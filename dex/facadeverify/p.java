package facadeverify;

import com.xiaomi.mipush.sdk.Constants;
import host.R;
import java.util.regex.Pattern;

public final class p {
    public static final Pattern a = Pattern.compile("([0-9]{1,2})[- ]([A-Za-z]{3,9})[- ]([0-9]{2,4})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])");
    public static final Pattern b = Pattern.compile("[ ]([A-Za-z]{3,9})[ ]+([0-9]{1,2})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])[ ]([0-9]{2,4})");

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static class a {
        public int a;
        public int b;
        public int c;

        public a(int i2, int i3, int i4) {
            this.a = i2;
            this.b = i3;
            this.c = i4;
        }
    }

    public static int a(String str) {
        if (str.length() == 2) {
            return (str.charAt(1) - '0') + ((str.charAt(0) - '0') * 10);
        }
        return str.charAt(0) - '0';
    }

    public static int b(String str) {
        char lowerCase = Character.toLowerCase(str.charAt(0));
        switch ((Character.toLowerCase(str.charAt(2)) + (Character.toLowerCase(str.charAt(1)) + lowerCase)) - 291) {
            case 9:
                return 11;
            case 10:
                return 1;
            case 22:
                return 0;
            case 26:
                return 7;
            case 29:
                return 2;
            case 32:
                return 3;
            case 35:
                return 9;
            case 36:
                return 4;
            case 37:
                return 8;
            case R.styleable.CameraView_cameraSnapshotMaxHeight /* 40 */:
                return 6;
            case R.styleable.CameraView_cameraUseDeviceOrientation /* 42 */:
                return 5;
            case 48:
                return 10;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static a c(String str) {
        int i2;
        int i3;
        int i4;
        int charAt = str.charAt(0) - '0';
        if (str.charAt(1) == ':') {
            i2 = 1;
        } else {
            charAt = (charAt * 10) + (str.charAt(1) - '0');
            i2 = 2;
        }
        int i5 = i2 + 1 + 1 + 1 + 1;
        return new a(charAt, (str.charAt(i4) - '0') + ((str.charAt(i3) - '0') * 10), (str.charAt(i5 + 1) - '0') + ((str.charAt(i5) - '0') * 10));
    }

    public static int d(String str) {
        if (str.length() == 2) {
            int charAt = (str.charAt(1) - '0') + ((str.charAt(0) - '0') * 10);
            return charAt >= 70 ? charAt + 1900 : charAt + Constants.ASSEMBLE_PUSH_RETRY_INTERVAL;
        } else if (str.length() == 3) {
            return (str.charAt(2) - '0') + ((str.charAt(1) - '0') * 10) + ((str.charAt(0) - '0') * 100) + 1900;
        } else if (str.length() == 4) {
            return (str.charAt(3) - '0') + ((str.charAt(2) - '0') * 10) + ((str.charAt(1) - '0') * 100) + ((str.charAt(0) - '0') * 1000);
        } else {
            return 1970;
        }
    }
}