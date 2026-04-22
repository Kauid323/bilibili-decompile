package tv.danmaku.bili.ui.webview.service;

import android.os.ParcelUuid;
import android.util.SparseArray;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class Utils {
    public static String bytesToHexString(byte[] bytes) {
        if (bytes == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer(bytes.length);
        for (byte b : bytes) {
            String sTmp = Integer.toHexString(b & 255);
            if (sTmp.length() < 2) {
                sb.append(0);
            }
            sb.append(sTmp.toUpperCase());
        }
        return sb.toString();
    }

    public static byte[] longToBytes(long value) {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.putLong(value);
        return buffer.array();
    }

    public static long bytesToLong(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.put(bytes);
        buffer.flip();
        return buffer.getLong();
    }

    public static ParcelUuid createUuidFromBytes(byte[] bytes) {
        if (bytes.length != 16) {
            return null;
        }
        long msb = 0;
        long lsb = 0;
        for (int i = 0; i < 8; i++) {
            msb = (msb << 8) | (bytes[i] & 255);
        }
        for (int i2 = 8; i2 < 16; i2++) {
            lsb = (lsb << 8) | (bytes[i2] & 255);
        }
        return new ParcelUuid(new UUID(msb, lsb));
    }

    public static ParcelUuid createBiliMidUuid(Long mid, byte[] prefix, String key) {
        if (!isBiliMidUuidPrefixValid(prefix) || !isEncKeyValid(key)) {
            return null;
        }
        long midValue = Long.valueOf(mid.longValue()).longValue();
        byte[] midBytes = longToBytes(midValue ^ Long.parseLong(key));
        byte[] uuidBytes = new byte[16];
        System.arraycopy(prefix, 0, uuidBytes, 0, prefix.length);
        System.arraycopy(midBytes, 0, uuidBytes, 8, midBytes.length);
        return createUuidFromBytes(uuidBytes);
    }

    public static Long parseBiliMidFromScanData(byte[] bytes, byte[] prefix, String key) {
        SparseArray<List<byte[]>> data = parseScanData(bytes);
        List<byte[]> list = data.get(7);
        if (list == null) {
            return null;
        }
        Iterator<byte[]> it = list.iterator();
        if (!it.hasNext()) {
            return null;
        }
        byte[] b = it.next();
        byte[] sorted = new byte[8];
        for (int i = 0; i < sorted.length; i++) {
            sorted[i] = b[7 - i];
        }
        long v = bytesToLong(sorted);
        return Long.valueOf(Long.parseLong(key) ^ v);
    }

    public static SparseArray<List<byte[]>> parseScanData(byte[] bytes) {
        int len;
        SparseArray<List<byte[]>> result = new SparseArray<>();
        if (bytes == null) {
            return result;
        }
        int offset = 0;
        while (offset < bytes.length && (len = bytes[offset]) > 0) {
            try {
                int type = bytes[offset + 1];
                byte[] value = new byte[len - 1];
                System.arraycopy(bytes, offset + 2, value, 0, value.length);
                List<byte[]> list = result.get(type);
                if (list == null) {
                    list = new ArrayList();
                    result.put(type, list);
                }
                list.add(value);
                offset = offset + len + 1;
            } catch (Exception e) {
                result.clear();
            }
        }
        return result;
    }

    public static boolean isEncKeyValid(String key) {
        if (key == null) {
            return false;
        }
        Long tmp = null;
        try {
            tmp = Long.valueOf(Long.parseLong(key));
        } catch (Exception e) {
        }
        return tmp != null;
    }

    public static boolean isBiliMidUuidPrefixValid(byte[] prefix) {
        return prefix != null && prefix.length == 8;
    }

    public static <T> String listToString(List<T> list, String separator) {
        if (list.isEmpty()) {
            return "";
        }
        String sep = separator != null ? separator : "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size() - 2; i++) {
            sb.append(list.get(i)).append(sep);
        }
        int i2 = list.size();
        sb.append(list.get(i2 - 1));
        return sb.toString();
    }
}