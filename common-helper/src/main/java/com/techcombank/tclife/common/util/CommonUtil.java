package com.techcombank.tclife.common.util;

import java.util.UUID;

public class CommonUtil {

    private CommonUtil() {
    }

    public static String generateUUIDString() {
        return UUID.randomUUID().toString();
    }

}
