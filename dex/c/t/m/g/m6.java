package c.t.m.g;

import org.json.JSONObject;

/* compiled from: TML */
public class m6 {
    public double a;
    public double b;

    /* renamed from: c  reason: collision with root package name */
    public double f67c;
    public float d;
    public int e;
    public String f;
    public String g;

    public m6() {
    }

    public static m6 a(m6 m6Var) {
        m6 m6Var2 = new m6();
        if (m6Var != null) {
            m6Var2.a = m6Var.a;
            m6Var2.b = m6Var.b;
            m6Var2.f67c = m6Var.f67c;
            m6Var2.d = m6Var.d;
            m6Var2.f = m6Var.f;
            m6Var2.g = m6Var.g;
        }
        return m6Var2;
    }

    public m6(JSONObject jSONObject) {
        this.a = jSONObject.optDouble("latitude", 0.0d);
        this.b = jSONObject.optDouble("longitude", 0.0d);
        this.f67c = jSONObject.optDouble("altitude", 0.0d);
        this.d = (float) jSONObject.optDouble("accuracy", 0.0d);
        int optInt = jSONObject.optInt(com.alipay.sdk.m.l.e.r, -3);
        this.e = optInt;
        if (optInt == 2) {
            g7.b = System.currentTimeMillis();
        }
        this.f = jSONObject.optString(com.alipay.sdk.m.h.c.e, null);
        this.g = jSONObject.optString("addr", null);
    }
}