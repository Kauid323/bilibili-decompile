package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlinx.coroutines.scheduling.WorkQueueKt;

public class BitEncoding {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean FORCE_8TO7_ENCODING;

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        switch (i) {
            case 1:
            case 3:
            case 6:
            case 8:
            case 10:
            case additional_type_content_opus_VALUE:
            case additional_type_content_comment_VALUE:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 1:
            case 3:
            case 6:
            case 8:
            case 10:
            case additional_type_content_opus_VALUE:
            case additional_type_content_comment_VALUE:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 3:
            case 6:
            case 8:
            case 10:
            case additional_type_content_opus_VALUE:
            case additional_type_content_comment_VALUE:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/BitEncoding";
                break;
            default:
                objArr[0] = "data";
                break;
        }
        switch (i) {
            case 1:
                objArr[1] = "encodeBytes";
                break;
            case 3:
                objArr[1] = "encode8to7";
                break;
            case 6:
                objArr[1] = "splitBytesToStringArray";
                break;
            case 8:
                objArr[1] = "decodeBytes";
                break;
            case 10:
                objArr[1] = "dropMarker";
                break;
            case additional_type_content_opus_VALUE:
                objArr[1] = "combineStringArrayIntoBytes";
                break;
            case additional_type_content_comment_VALUE:
                objArr[1] = "decode7to8";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/BitEncoding";
                break;
        }
        switch (i) {
            case 1:
            case 3:
            case 6:
            case 8:
            case 10:
            case additional_type_content_opus_VALUE:
            case additional_type_content_comment_VALUE:
                break;
            case 2:
                objArr[2] = "encode8to7";
                break;
            case 4:
                objArr[2] = "addModuloByte";
                break;
            case 5:
                objArr[2] = "splitBytesToStringArray";
                break;
            case 7:
                objArr[2] = "decodeBytes";
                break;
            case 9:
                objArr[2] = "dropMarker";
                break;
            case 11:
                objArr[2] = "combineStringArrayIntoBytes";
                break;
            case additional_type_content_video_VALUE:
                objArr[2] = "decode7to8";
                break;
            default:
                objArr[2] = "encodeBytes";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 1:
            case 3:
            case 6:
            case 8:
            case 10:
            case additional_type_content_opus_VALUE:
            case additional_type_content_comment_VALUE:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    static {
        String use8to7;
        try {
            use8to7 = System.getProperty("kotlin.jvm.serialization.use8to7");
        } catch (SecurityException e) {
            use8to7 = null;
        }
        FORCE_8TO7_ENCODING = "true".equals(use8to7);
    }

    private BitEncoding() {
    }

    private static void addModuloByte(byte[] data, int increment) {
        if (data == null) {
            $$$reportNull$$$0(4);
        }
        int n = data.length;
        for (int i = 0; i < n; i++) {
            data[i] = (byte) ((data[i] + increment) & WorkQueueKt.MASK);
        }
    }

    public static byte[] decodeBytes(String[] data) {
        if (data == null) {
            $$$reportNull$$$0(7);
        }
        if (data.length > 0 && !data[0].isEmpty()) {
            char possibleMarker = data[0].charAt(0);
            if (possibleMarker == 0) {
                byte[] stringsToBytes = UtfEncodingKt.stringsToBytes(dropMarker(data));
                if (stringsToBytes == null) {
                    $$$reportNull$$$0(8);
                }
                return stringsToBytes;
            } else if (possibleMarker == 65535) {
                data = dropMarker(data);
            }
        }
        byte[] bytes = combineStringArrayIntoBytes(data);
        addModuloByte(bytes, WorkQueueKt.MASK);
        return decode7to8(bytes);
    }

    private static String[] dropMarker(String[] data) {
        if (data == null) {
            $$$reportNull$$$0(9);
        }
        String[] result = (String[]) data.clone();
        result[0] = result[0].substring(1);
        if (result == null) {
            $$$reportNull$$$0(10);
        }
        return result;
    }

    private static byte[] combineStringArrayIntoBytes(String[] data) {
        if (data == null) {
            $$$reportNull$$$0(11);
        }
        int resultLength = 0;
        for (String s : data) {
            if (s.length() > 65535) {
                throw new AssertionError("String is too long: " + s.length());
            }
            resultLength += s.length();
        }
        byte[] result = new byte[resultLength];
        int p = 0;
        for (String s2 : data) {
            int i = 0;
            int n = s2.length();
            while (i < n) {
                result[p] = (byte) s2.charAt(i);
                i++;
                p++;
            }
        }
        return result;
    }

    private static byte[] decode7to8(byte[] data) {
        if (data == null) {
            $$$reportNull$$$0(13);
        }
        int resultLength = (data.length * 7) / 8;
        byte[] result = new byte[resultLength];
        int byteIndex = 0;
        int bit = 0;
        for (int i = 0; i < resultLength; i++) {
            int firstPart = (data[byteIndex] & 255) >>> bit;
            byteIndex++;
            int secondPart = (data[byteIndex] & ((1 << (bit + 1)) - 1)) << (7 - bit);
            result[i] = (byte) (firstPart + secondPart);
            if (bit == 6) {
                byteIndex++;
                bit = 0;
            } else {
                bit++;
            }
        }
        return result;
    }
}