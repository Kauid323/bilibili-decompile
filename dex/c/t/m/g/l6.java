package c.t.m.g;

import org.json.JSONObject;

/* compiled from: TML */
public class l6 {
    public String a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public int f60c;

    public l6(JSONObject jSONObject) {
        this.a = jSONObject.optString("bid", null);
        this.b = jSONObject.optString("floor", "1000");
        this.f60c = jSONObject.optInt(com.alipay.sdk.m.l.e.r, -1);
    }
}