@echo off
cd /d %~dp0

if "%1"=="start" (
    echo "Starting flinkplus ..."
    cd ..
    java -jar lib\flinkplus-web-0.1-SNAPSHOT.jar --spring.config.location=config/ %--spring.profiles.active=local%
) ^
else if "%1"=="stop" (
    for /f %%i in ('jps -l ^| findstr flinkplus-web') do (
        taskkill /f /pid %%i
    )
    echo "Stopped flinkplus !"
) ^
else (
    echo "Error! The expected parameters is start | stop ."
)

pause