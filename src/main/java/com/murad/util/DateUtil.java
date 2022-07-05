package com.murad.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateUtil {


    private static final Map<String, String> DATE_FORMAT_REGEXPS = new HashMap<String, String>() {{
        put("^\\d{8}$", "yyyyMMdd");
        put("^\\d{1,2}-\\d{1,2}-\\d{4}$", "dd-MM-yyyy");
        put("^\\d{4}-\\d{1,2}-\\d{1,2}$", "yyyy-MM-dd");
        put("^\\d{1,2}/\\d{1,2}/\\d{4}$", "MM/dd/yyyy");
        put("^\\d{4}/\\d{1,2}/\\d{1,2}$", "yyyy/MM/dd");
        put("^\\d{1,2}\\s[a-z]{3}\\s\\d{4}$", "dd MMM yyyy");
        put("^\\d{1,2}\\s[a-z]{4,}\\s\\d{4}$", "dd MMMM yyyy");
    }};

    public static String determineDateFormat(String dateString) {
        for (String regexp : DATE_FORMAT_REGEXPS.keySet()) {
            if (dateString.toLowerCase().matches(regexp)) {
                return DATE_FORMAT_REGEXPS.get(regexp);
            }
        }
        return null;
    }

    public static boolean isDateString(String dateString) {
        if (null == dateString) return false;
        String regex = ".*[0-9].*";
        if (!dateString.matches(regex)) return false;
        for (String regexp : DATE_FORMAT_REGEXPS.keySet()) {
            if (dateString.toLowerCase().matches(regexp)) {
                return true;
            }
        }
        return false; // not a date.
    }

    public static String convertDateToString(Date date, String pattern) {
        if (null != date && null != pattern) {
            DateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }
}
