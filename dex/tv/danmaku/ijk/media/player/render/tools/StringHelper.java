package tv.danmaku.ijk.media.player.render.tools;

import android.util.Base64;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;

public class StringHelper {
    public static final String EMPTY = "";

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static String trim(String str) {
        if (str == null) {
            return null;
        }
        return str.trim();
    }

    public static String trimToNull(String str) {
        String ts = trim(str);
        if (isEmpty(ts)) {
            return null;
        }
        return ts;
    }

    public static String trimToEmpty(String str) {
        return str == null ? "" : str.trim();
    }

    public static String md5(String s) {
        return md5(s.getBytes());
    }

    public static String md5(byte[] bytes) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(bytes);
            BigInteger number = new BigInteger(1, m.digest());
            String hash = String.format("%032x", number);
            return hash;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String encryptMd5(String str) {
        char[] a = str.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 'l');
        }
        String s = new String(a);
        return s;
    }

    public static String Base64Encode(String str) {
        return str == null ? "" : Base64.encodeToString(ByteUtils.getBytes(str), 2);
    }

    public static String uuid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().toLowerCase();
    }

    public static HashMap<String, String> urlQuery(String query) {
        String[] queries;
        if (query == null || (queries = query.split("&")) == null || queries.length == 0) {
            return null;
        }
        HashMap<String, String> map = new HashMap<>(queries.length);
        for (String string : queries) {
            String[] keyValue = string.split("=");
            if (keyValue != null && keyValue.length == 2) {
                map.put(keyValue[0], keyValue[1]);
            }
        }
        return map;
    }

    public static String timeStampString() {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date());
        return timeStamp;
    }

    public static String formatByte(long size) {
        if (size < 1024) {
            return String.format("%sB", Long.valueOf(size));
        }
        long kVal = size / 1024;
        if (kVal < 1024) {
            return String.format("%sK", Long.valueOf(kVal));
        }
        float mVal = ((float) size) / 1048576.0f;
        return mVal < 1024.0f ? String.format(Locale.getDefault(), "%.1fM", Float.valueOf(mVal)) : String.format(Locale.getDefault(), "%.1fG", Float.valueOf(mVal / 1024.0f));
    }

    public static boolean isLetter(String txt, int preLength) {
        if (isEmpty(txt) || preLength > txt.length()) {
            return false;
        }
        if (preLength > 0) {
            txt = txt.substring(0, preLength);
        }
        return txt.matches("[a-zA-z]");
    }

    public static int parserInt(String txt) {
        if (txt == null) {
            return 0;
        }
        try {
            int opt = Integer.parseInt(txt);
            return opt;
        } catch (Exception e) {
            return 0;
        }
    }

    public static int parserInt(String txt, int radix) {
        if (txt == null) {
            return 0;
        }
        try {
            int opt = Integer.parseInt(txt, radix);
            return opt;
        } catch (Exception e) {
            return 0;
        }
    }

    public static float parseFloat(String txt) {
        if (txt == null) {
            return DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        }
        try {
            float opt = Float.parseFloat(txt);
            return opt;
        } catch (Exception e) {
            return DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        }
    }

    public static long parserLong(String txt) {
        if (txt == null) {
            return 0L;
        }
        try {
            long opt = Long.parseLong(txt);
            return opt;
        } catch (Exception e) {
            return 0L;
        }
    }

    public static String bytesToHexString(byte[] src) {
        StringBuilder sb = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        char[] buffer = new char[2];
        for (int i = 0; i < src.length; i++) {
            buffer[0] = Character.forDigit((src[i] >>> 4) & 15, 16);
            buffer[1] = Character.forDigit(src[i] & 15, 16);
            sb.append(buffer);
        }
        return sb.toString().toUpperCase();
    }

    public static int matchInt(String input, String regex) {
        String str = matchString(input, regex);
        return parserInt(str);
    }

    public static String matchString(String input, String regex) {
        if (input == null || regex == null) {
            return null;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.find()) {
            return null;
        }
        return matcher.group(1);
    }

    public static ArrayList<String> matchStrings(String input, String regex) {
        if (input == null || regex == null) {
            return null;
        }
        ArrayList<String> matches = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            int j = matcher.groupCount();
            for (int i = 0; i <= j; i++) {
                matches.add(matcher.group(i));
            }
        }
        return matches;
    }

    public static String removeSuffix(String fileName) {
        if (fileName == null) {
            return null;
        }
        int index = fileName.lastIndexOf(".");
        if (index > -1) {
            return fileName.substring(0, index);
        }
        return fileName;
    }
}