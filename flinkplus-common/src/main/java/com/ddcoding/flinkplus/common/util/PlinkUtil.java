package com.ddcoding.flinkplus.common.util;

/**
 * @author: ddcoding
 * @date: 2020/9/29
 */
public class PlinkUtil {

    public static String getPlinkHome() {
        String plink_home = System.getenv("FLINKPLUS_HOME");
        if (plink_home == null) {
            plink_home = System.getProperty("user.dir");
        }
        return plink_home;
    }

}
