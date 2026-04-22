package io.grpc.internal;

import com.google.common.math.LongMath;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public class JsonUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long DURATION_SECONDS_MAX = 315576000000L;
    private static final long DURATION_SECONDS_MIN = -315576000000L;
    private static final long NANOS_PER_SECOND = TimeUnit.SECONDS.toNanos(1);

    @Nullable
    public static List<?> getList(Map<String, ?> obj, String key) {
        if (key == null) {
            throw new AssertionError();
        }
        if (!obj.containsKey(key)) {
            return null;
        }
        Object value = obj.get(key);
        if (!(value instanceof List)) {
            throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not List", value, key, obj));
        }
        return (List) value;
    }

    @Nullable
    public static List<Map<String, ?>> getListOfObjects(Map<String, ?> obj, String key) {
        List<?> list = getList(obj, key);
        if (list == null) {
            return null;
        }
        return checkObjectList(list);
    }

    @Nullable
    public static List<String> getListOfStrings(Map<String, ?> obj, String key) {
        List<?> list = getList(obj, key);
        if (list == null) {
            return null;
        }
        return checkStringList(list);
    }

    @Nullable
    public static Map<String, ?> getObject(Map<String, ?> obj, String key) {
        if (key == null) {
            throw new AssertionError();
        }
        if (!obj.containsKey(key)) {
            return null;
        }
        Object value = obj.get(key);
        if (!(value instanceof Map)) {
            throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not object", value, key, obj));
        }
        return (Map) value;
    }

    @Nullable
    public static Double getNumber(Map<String, ?> obj, String key) {
        if (key == null) {
            throw new AssertionError();
        }
        if (!obj.containsKey(key)) {
            return null;
        }
        Object value = obj.get(key);
        if (!(value instanceof Double)) {
            throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not Double", value, key, obj));
        }
        return (Double) value;
    }

    public static Integer getNumberAsInteger(Map<String, ?> obj, String key) {
        Double d2 = getNumber(obj, key);
        if (d2 == null) {
            return null;
        }
        int i2 = d2.intValue();
        if (i2 != d2.doubleValue()) {
            throw new ClassCastException("Number expected to be integer: " + d2);
        }
        return Integer.valueOf(i2);
    }

    public static Long getNumberAsLong(Map<String, ?> obj, String key) {
        Double d2 = getNumber(obj, key);
        if (d2 == null) {
            return null;
        }
        long l = d2.longValue();
        if (l != d2.doubleValue()) {
            throw new ClassCastException("Number expected to be long: " + d2);
        }
        return Long.valueOf(l);
    }

    @Nullable
    public static String getString(Map<String, ?> obj, String key) {
        if (key == null) {
            throw new AssertionError();
        }
        if (!obj.containsKey(key)) {
            return null;
        }
        Object value = obj.get(key);
        if (!(value instanceof String)) {
            throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not String", value, key, obj));
        }
        return (String) value;
    }

    public static Long getStringAsDuration(Map<String, ?> obj, String key) {
        String value = getString(obj, key);
        if (value == null) {
            return null;
        }
        try {
            return Long.valueOf(parseDuration(value));
        } catch (ParseException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Nullable
    public static Boolean getBoolean(Map<String, ?> obj, String key) {
        if (key == null) {
            throw new AssertionError();
        }
        if (!obj.containsKey(key)) {
            return null;
        }
        Object value = obj.get(key);
        if (!(value instanceof Boolean)) {
            throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not Boolean", value, key, obj));
        }
        return (Boolean) value;
    }

    public static List<Map<String, ?>> checkObjectList(List<?> rawList) {
        for (int i2 = 0; i2 < rawList.size(); i2++) {
            if (!(rawList.get(i2) instanceof Map)) {
                throw new ClassCastException(String.format("value %s for idx %d in %s is not object", rawList.get(i2), Integer.valueOf(i2), rawList));
            }
        }
        return rawList;
    }

    public static List<String> checkStringList(List<?> rawList) {
        for (int i2 = 0; i2 < rawList.size(); i2++) {
            if (!(rawList.get(i2) instanceof String)) {
                throw new ClassCastException(String.format("value '%s' for idx %d in '%s' is not string", rawList.get(i2), Integer.valueOf(i2), rawList));
            }
        }
        return rawList;
    }

    private static long parseDuration(String value) throws ParseException {
        if (value.isEmpty() || value.charAt(value.length() - 1) != 's') {
            throw new ParseException("Invalid duration string: " + value, 0);
        }
        boolean negative = false;
        if (value.charAt(0) == '-') {
            negative = true;
            value = value.substring(1);
        }
        String secondValue = value.substring(0, value.length() - 1);
        String nanoValue = "";
        int pointPosition = secondValue.indexOf(46);
        if (pointPosition != -1) {
            nanoValue = secondValue.substring(pointPosition + 1);
            secondValue = secondValue.substring(0, pointPosition);
        }
        long seconds = Long.parseLong(secondValue);
        int nanos = nanoValue.isEmpty() ? 0 : parseNanos(nanoValue);
        if (seconds < 0) {
            throw new ParseException("Invalid duration string: " + value, 0);
        }
        if (negative) {
            seconds = -seconds;
            nanos = -nanos;
        }
        try {
            return normalizedDuration(seconds, nanos);
        } catch (IllegalArgumentException e2) {
            throw new ParseException("Duration value is out of range.", 0);
        }
    }

    private static int parseNanos(String value) throws ParseException {
        int result = 0;
        for (int i2 = 0; i2 < 9; i2++) {
            result *= 10;
            if (i2 < value.length()) {
                if (value.charAt(i2) < '0' || value.charAt(i2) > '9') {
                    throw new ParseException("Invalid nanoseconds.", 0);
                }
                result += value.charAt(i2) - '0';
            }
        }
        return result;
    }

    private static long normalizedDuration(long seconds, int nanos) {
        if (nanos <= (-NANOS_PER_SECOND) || nanos >= NANOS_PER_SECOND) {
            seconds = LongMath.checkedAdd(seconds, nanos / NANOS_PER_SECOND);
            nanos = (int) (nanos % NANOS_PER_SECOND);
        }
        if (seconds > 0 && nanos < 0) {
            nanos = (int) (nanos + NANOS_PER_SECOND);
            seconds--;
        }
        if (seconds < 0 && nanos > 0) {
            nanos = (int) (nanos - NANOS_PER_SECOND);
            seconds++;
        }
        if (!durationIsValid(seconds, nanos)) {
            throw new IllegalArgumentException(String.format("Duration is not valid. See proto definition for valid values. Seconds (%s) must be in range [-315,576,000,000, +315,576,000,000]. Nanos (%s) must be in range [-999,999,999, +999,999,999]. Nanos must have the same sign as seconds", Long.valueOf(seconds), Integer.valueOf(nanos)));
        }
        return saturatedAdd(TimeUnit.SECONDS.toNanos(seconds), nanos);
    }

    private static boolean durationIsValid(long seconds, int nanos) {
        if (seconds < DURATION_SECONDS_MIN || seconds > DURATION_SECONDS_MAX || nanos < -999999999 || nanos >= NANOS_PER_SECOND) {
            return false;
        }
        if (seconds < 0 || nanos < 0) {
            return seconds <= 0 && nanos <= 0;
        }
        return true;
    }

    private static long saturatedAdd(long a, long b) {
        long naiveSum = a + b;
        if (((a ^ b) < 0) | ((a ^ naiveSum) >= 0)) {
            return naiveSum;
        }
        return ((naiveSum >>> 63) ^ 1) + Long.MAX_VALUE;
    }
}