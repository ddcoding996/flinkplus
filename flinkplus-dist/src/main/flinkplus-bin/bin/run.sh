#!/bin/sh

# shellcheck disable=SC2164
# shellcheck disable=SC2034
SERVER_ROOT_PATH=$(cd "$(dirname "$0")"; cd ..; pwd)

cd "$SERVER_ROOT_PATH"

if [ $FLINKPLUS_HOME ]; then
  echo  "FLINKPLUS_HOME is $FLINKPLUS_HOME"
else
  export FLINKPLUS_HOME=$SERVER_ROOT_PATH
  echo  "FLINKPLUS_HOME is auto set $FLINKPLUS_HOME"
fi

APP_LOG_DIR="${SERVER_ROOT_PATH}/log"
LOG_FILE="$APP_LOG_DIR/console.log"

profile=""
if [ ! -z $2 ]; then
    profile="--spring.profiles.active=$2"
else
    profile="--spring.profiles.active=prod"
fi

JARFILE=$(find . -name "$SERVER_ROOT_PATH/lib/flinkplus-web-*.jar" -print)

case "$1" in

    start)
        if [ ! -d "${APP_LOG_DIR}" ]; then
            mkdir -p "${APP_LOG_DIR}"
        fi
        touch "$LOG_FILE"
        exec java -jar "$JARFILE" "$profile" --spring.config.location=$SERVER_ROOT_PATH/config/ >> "${LOG_FILE}" 2>&1 &
        echo "server starting log to " "${LOG_FILE}"
        tail -f -n 0 "${LOG_FILE}"
    ;;

    *)
        echo "Usage: sh run.sh {start} {local|test|prod(default)}"
    ;;

esac

exit 0