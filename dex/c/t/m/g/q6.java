package c.t.m.g;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import java.io.UnsupportedEncodingException;

/* compiled from: TML */
public class q6 {
    public static void a(Context context) {
        try {
            String str = Build.MANUFACTURER;
            boolean parseBoolean = Boolean.parseBoolean(f7.a().get("enable_invoke_map"));
            a7.c("ManHattanStrategy", "invokeMap start, manufacturer = " + str + ", control = " + parseBoolean);
            if (parseBoolean) {
                if (str.equals("Meizu") || str.equals("samsung") || str.equals("OnePlus")) {
                    long a = e7.a("LocationSDK", "location_invoke_map_time", 0L);
                    int a2 = e7.a("LocationSDK", "location_invoke_map_count", 0);
                    int i = ((System.currentTimeMillis() - a) > 86400000L ? 1 : ((System.currentTimeMillis() - a) == 86400000L ? 0 : -1));
                    a7.c("ManHattanStrategy", "invokeMap middle, result = " + (i > 0 && a2 <= 5));
                    if (i <= 0 || a2 > 5) {
                        return;
                    }
                    e7.b("LocationSDK", "location_invoke_map_time", System.currentTimeMillis());
                    e7.b("LocationSDK", "location_invoke_map_count", a2 + 1);
                    Intent intent = new Intent();
                    intent.setPackage(a(0));
                    intent.setAction(a(1));
                    intent.putExtra("source", "location_official");
                    context.startService(intent);
                    a7.c("ManHattanStrategy", "invokeMap end, " + a(0) + ", " + a(1));
                }
            }
        } catch (Throwable th) {
            a7.a("ManHattanStrategy", "invokeMap exception", th);
        }
    }

    public static String a(int i) {
        byte[] bArr = {-100, -112, -110, -47, -117, -102, -111, -100, -102, -111, -117, -47, -110, -98, -113, -47, -120, -98, -108, -102, -118, -113};
        int i2 = (i * 7) + 15 > 15 ? 21 : 15;
        byte[] bArr2 = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            if (i2 > 15 && i3 > 9) {
                bArr2[i3] = (byte) (~bArr[i3 + 1]);
            } else {
                bArr2[i3] = (byte) (~bArr[i3]);
            }
        }
        try {
            return new String(bArr2, com.alipay.sdk.m.o.a.z);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }
}