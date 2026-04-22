package c.t.m.g;

import com.tencent.map.geolocation.TencentLocationManagerOptions;

/* compiled from: TML */
public class v4 {
    public static boolean a = false;
    public static int b;

    public static boolean a(x5 x5Var) {
        boolean z;
        if (a || a5.a(x5Var.a)) {
            return false;
        }
        if (g5.b().b(x5Var) != -2) {
            z = false;
        } else {
            a7.c("AntiMockProvider", "gps fake, not ValidMoveSpeed");
            z = true;
        }
        a(4, z);
        return b() != 0;
    }

    public static boolean b(int i) {
        return (i & b) != 0;
    }

    public static void c() {
        b = 0;
    }

    public static boolean c(int i) {
        return i == 1 || i == 2 || i == 4 || i == 8 || i == 16 || i == 32 || i == 64;
    }

    public static int b() {
        if (a) {
            return 0;
        }
        return b;
    }

    public static boolean a(p6 p6Var) {
        if (a) {
            return false;
        }
        a(1, p6Var.isMockGps() >= 1);
        return b() != 0;
    }

    public static void a(int i, boolean z) {
        if (c(i)) {
            if (a) {
                return;
            }
            if (Boolean.parseBoolean(TencentLocationManagerOptions.getExtraDataForKey("isBaGun")) && (i == 64 || i == 32)) {
                return;
            }
            if (!z) {
                int i2 = b;
                if ((i2 & i) != 0) {
                    b = i2 - i;
                    a7.c("AntiMockProvider", "delete fakeReason " + i);
                }
            }
            if (z) {
                int i3 = b;
                if ((i3 & i) == 0) {
                    b = i3 + i;
                    a7.c("AntiMockProvider", "add fakeReason " + i);
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("fake reason not exists");
    }

    public static void a(boolean z) {
        a = z;
    }

    public static boolean a() {
        return a;
    }

    public static float a(int i) {
        float max = (i & 1) != 0 ? Math.max(0.0f, 0.99f) : 0.0f;
        if ((i & 2) != 0) {
            max = Math.max(max, 0.8f);
        }
        if ((i & 4) != 0) {
            max = Math.max(max, 0.8f);
        }
        if ((i & 8) != 0) {
            max = Math.max(max, 0.95f);
        }
        if ((i & 16) != 0) {
            max = Math.max(max, 0.9f);
        }
        if (Boolean.parseBoolean(TencentLocationManagerOptions.getExtraDataForKey("isBaGun"))) {
            return max;
        }
        if ((i & 32) != 0) {
            max = Math.max(max, 0.8f);
        }
        return (i & 64) != 0 ? Math.max(max, 0.9f) : max;
    }
}