package c.t.m.g;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

/* compiled from: TML */
public class z0 {
    public Context a;

    public z0(Context context) {
        this.a = context;
    }

    public String a() {
        try {
            ContentProviderClient acquireContentProviderClient = this.a.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            Bundle call = acquireContentProviderClient.call("getOAID", null, null);
            if (acquireContentProviderClient != null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    acquireContentProviderClient.release();
                } else {
                    acquireContentProviderClient.release();
                }
            }
            if (call.getInt("code", -1) == 0) {
                return call.getString("id");
            }
            call.getString("message");
            return null;
        } catch (Exception e) {
            w3.a("NubiaDeviceIDHelper", "getID", e);
            return null;
        }
    }
}