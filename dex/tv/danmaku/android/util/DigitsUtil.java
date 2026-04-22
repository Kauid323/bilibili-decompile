package tv.danmaku.android.util;

import android.text.TextUtils;

public class DigitsUtil {
    public static boolean isDigits(CharSequence str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        char firstChar = str.charAt(0);
        int firstDigitIndex = (firstChar == '-' || firstChar == '+') ? 1 : 0;
        if (firstDigitIndex == str.length()) {
            return false;
        }
        int len = str.length();
        for (int i = firstDigitIndex; i < len; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static int parseInt(CharSequence str, int def) {
        try {
            return Integer.parseInt(String.valueOf(str));
        } catch (Exception e) {
            return def;
        }
    }

    public static int parseInt(CharSequence str) {
        return parseInt(str, 0);
    }

    public static long parseLong(CharSequence str, long def) {
        try {
            return Long.parseLong(String.valueOf(str));
        } catch (Exception e) {
            return def;
        }
    }

    public static long parseLong(CharSequence str) {
        return parseLong(str, 0L);
    }

    public static double parseDouble(CharSequence numStr, double defaultValue) {
        try {
            return Double.parseDouble(String.valueOf(numStr));
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static double parseDouble(String numStr) {
        return parseDouble(numStr, 0.0d);
    }

    public static String getQueryParameter(String urlQueryStyleStr, String key) {
        if (TextUtils.isEmpty(urlQueryStyleStr) || TextUtils.isEmpty(key)) {
            return null;
        }
        int length = urlQueryStyleStr.length();
        int start = 0;
        while (true) {
            int nextAmpersand = urlQueryStyleStr.indexOf(38, start);
            int end = nextAmpersand != -1 ? nextAmpersand : length;
            int separator = urlQueryStyleStr.indexOf(61, start);
            if (separator > end || separator == -1) {
                separator = end;
            }
            if (separator - start == key.length() && urlQueryStyleStr.regionMatches(start, key, 0, key.length())) {
                if (separator == end) {
                    return "";
                }
                String encodedValue = urlQueryStyleStr.substring(separator + 1, end);
                return encodedValue;
            } else if (nextAmpersand == -1) {
                return null;
            } else {
                start = nextAmpersand + 1;
            }
        }
    }
}