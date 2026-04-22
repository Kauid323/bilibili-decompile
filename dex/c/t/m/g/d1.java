package c.t.m.g;

import android.content.Context;
import java.lang.reflect.Method;

/* compiled from: TML */
public class d1 {
    public Context a;
    public Class b;

    /* renamed from: c  reason: collision with root package name */
    public Object f20c;
    public Method d;

    public d1(Context context) {
        this.a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.b = cls;
            this.f20c = cls.newInstance();
        } catch (Exception e) {
            w3.a("XiaomiDeviceIDHelper", "constructor", e);
        }
        try {
            this.d = this.b.getMethod("getOAID", Context.class);
        } catch (Exception e2) {
            w3.a("XiaomiDeviceIDHelper", "constructor", e2);
        }
    }

    public final String a(Context context, Method method) {
        Object obj = this.f20c;
        if (obj != null && method != null) {
            try {
                return (String) method.invoke(obj, context);
            } catch (Exception e) {
                w3.a("XiaomiDeviceIDHelper", "invoke", e);
            }
        }
        return null;
    }

    public String a() {
        return a(this.a, this.d);
    }
}