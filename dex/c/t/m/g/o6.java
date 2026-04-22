package c.t.m.g;

import android.os.Bundle;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TML */
public class o6 {
    public static final o6 n = new o6();
    public String a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f78c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public final Bundle m = new Bundle();

    public o6() {
    }

    public static o6 a(o6 o6Var) {
        if (o6Var == null) {
            return null;
        }
        return new o6(o6Var);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SubnationData{");
        sb.append("name=").append(this.b).append(",");
        sb.append("address=").append(this.l).append(",");
        sb.append("code=").append(this.f78c).append(",");
        sb.append("phCode=").append(this.d).append(",");
        sb.append("nation=").append(this.a).append(",");
        sb.append("province=").append(this.e).append(",");
        sb.append("city=").append(this.f).append(",");
        sb.append("district=").append(this.g).append(",");
        sb.append("town=").append(this.h).append(",");
        sb.append("village=").append(this.i).append(",");
        sb.append("street=").append(this.j).append(",");
        sb.append("street_no=").append(this.k).append(",");
        sb.append("bundle").append(this.m).append(",");
        sb.append(com.alipay.sdk.m.q.h.d);
        return sb.toString();
    }

    public o6(o6 o6Var) {
        if (o6Var.m.size() > 0) {
            this.m.putAll(o6Var.m);
            return;
        }
        this.a = o6Var.a;
        this.b = o6Var.b;
        this.f78c = o6Var.f78c;
        this.d = o6Var.d;
        this.e = o6Var.e;
        this.f = o6Var.f;
        this.g = o6Var.g;
        this.h = o6Var.h;
        this.i = o6Var.i;
        this.j = o6Var.j;
        this.k = o6Var.k;
        this.l = o6Var.l;
    }

    public o6(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("admin_level_1")) {
            String optString = jSONObject.optString("nation");
            String optString2 = jSONObject.optString("admin_level_1");
            String optString3 = jSONObject.optString("admin_level_2");
            String optString4 = jSONObject.optString("admin_level_3");
            String optString5 = jSONObject.optString("locality");
            String optString6 = jSONObject.optString("sublocality");
            String optString7 = jSONObject.optString("route");
            this.m.putString("nation", optString);
            this.m.putString("admin_level_1", optString2);
            this.m.putString("admin_level_2", optString3);
            this.m.putString("admin_level_3", optString4);
            this.m.putString("locality", optString5);
            this.m.putString("sublocality", optString6);
            this.m.putString("route", optString7);
            return;
        }
        this.b = jSONObject.optString(com.alipay.sdk.m.h.c.e, null);
        this.f78c = jSONObject.optString("code", null);
        this.d = jSONObject.optString("pncode", null);
        this.a = jSONObject.optString("nation", null);
        this.e = jSONObject.optString("province", null);
        this.f = jSONObject.optString("city", null);
        this.g = jSONObject.optString("district", null);
        this.h = jSONObject.optString("town", null);
        this.i = jSONObject.optString("village", null);
        this.j = jSONObject.optString("street", null);
        this.k = jSONObject.optString("street_no", null);
        String optString8 = jSONObject.optString("mergedname", null);
        String optString9 = jSONObject.optString("mergedaddr", null);
        if (!TextUtils.isEmpty(optString8)) {
            this.b = optString8;
        }
        if (TextUtils.isEmpty(optString9)) {
            return;
        }
        this.l = optString9;
    }
}