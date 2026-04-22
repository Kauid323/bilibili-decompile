package c.t.m.g;

import android.os.Parcelable;
import com.tencent.map.geolocation.TencentPoi;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TML */
public class k6 {
    public int a;
    public final ArrayList<TencentPoi> b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public o6 f55c;

    public k6() {
    }

    public static k6 a(k6 k6Var) {
        if (k6Var == null) {
            return null;
        }
        k6 k6Var2 = new k6();
        k6Var2.a = k6Var.a;
        k6Var2.f55c = o6.a(k6Var.f55c);
        Iterator<TencentPoi> it = k6Var.b.iterator();
        while (it.hasNext()) {
            k6Var2.b.add(new n6(it.next()));
        }
        return k6Var2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DetailsData{");
        sb.append("subnation=").append(this.f55c).append(",");
        sb.append("poilist=[");
        Iterator<TencentPoi> it = this.b.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append(",");
        }
        sb.append("]");
        sb.append(com.alipay.sdk.m.q.h.d);
        return sb.toString();
    }

    public k6(JSONObject jSONObject) throws JSONException {
        this.a = jSONObject.optInt("stat");
        if (jSONObject.has("subnation")) {
            this.f55c = new o6(jSONObject.optJSONObject("subnation"));
        } else if (jSONObject.has("results")) {
            this.f55c = a(jSONObject.optJSONArray("results"));
        } else {
            this.f55c = o6.n;
            a7.b("DetailsData", "DetailsData: unknown json " + jSONObject.toString());
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("poilist");
        if (optJSONArray != null) {
            try {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    this.b.add(new n6(optJSONArray.getJSONObject(i)));
                }
            } catch (JSONException e) {
                a7.a("DetailsData", "json error", e);
            }
        }
    }

    public final o6 a(JSONArray jSONArray) {
        o6 a;
        JSONObject optJSONObject;
        if (jSONArray == null || (a = o6.a(o6.n)) == null) {
            return null;
        }
        int length = jSONArray.length();
        if (length > 0 && (optJSONObject = jSONArray.optJSONObject(0)) != null) {
            a.a = optJSONObject.optString("n", null);
            a.e = optJSONObject.optString("p", null);
            a.f = optJSONObject.optString("c", null);
            a.g = optJSONObject.optString("d", null);
            a.f78c = optJSONObject.optString("adcode", null);
        }
        if (length > 1) {
            JSONObject optJSONObject2 = jSONArray.optJSONObject(1);
            a.m.putString("addrdesp.name", optJSONObject2.optString("address_name"));
            JSONObject optJSONObject3 = optJSONObject2.optJSONObject("landmark");
            JSONObject optJSONObject4 = optJSONObject2.optJSONObject("second_landmark");
            if (optJSONObject3 != null) {
                a.m.putParcelable("addrdesp.landmark", new j6(optJSONObject3));
            }
            if (optJSONObject4 != null) {
                a.m.putParcelable("addrdesp.second_landmark", new j6(optJSONObject4));
            }
        }
        if (length > 2) {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            for (int i = 2; i < length; i++) {
                j6 j6Var = new j6(jSONArray.optJSONObject(i));
                arrayList.add(j6Var);
                if ("ST".equals(j6Var.b)) {
                    a.j = j6Var.a;
                } else if ("ST_NO".equals(j6Var.b)) {
                    a.k = j6Var.a;
                }
            }
            a.m.putParcelableArrayList("addrdesp.results", arrayList);
        }
        return a;
    }
}