package c.t.m.g;

import android.os.Build;
import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: TML */
public class n4 {
    public int a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f71c;
    public String d;
    public String e;
    public String f;
    public String g;
    public long h;
    public String i = "";
    public volatile long j = 0;
    public volatile long k = 0;
    public volatile long l = 0;
    public volatile long m = 0;
    public String n;

    static {
        String str = Build.BRAND;
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(boolean z) {
    }

    public void b(int i) {
    }

    public void b(String str) {
        this.b = str;
    }

    public void b(boolean z) {
    }

    public String c() {
        return this.g;
    }

    public void c(String str) {
    }

    public void c(boolean z) {
    }

    public String d() {
        return "0123456789ABCDEF";
    }

    public void d(String str) {
        this.e = str;
    }

    public String e() {
        return this.b;
    }

    public String f() {
        HashMap hashMap = new HashMap();
        hashMap.put("imei", "");
        hashMap.put("imsi", "");
        hashMap.put("qq", n());
        hashMap.put("mac", "");
        hashMap.put("qimei", t4.a);
        hashMap.put("q16", t4.b);
        hashMap.put("q36", t4.f101c);
        hashMap.put("idfa", com.alipay.sdk.m.q.h.b + l());
        hashMap.put("idfv", TextUtils.isEmpty(l()) ? b() : "");
        hashMap.put("sid", o());
        hashMap.put("lid", i4.k());
        return new JSONObject(hashMap).toString();
    }

    public void f(String str) {
    }

    public void g(String str) {
        this.f71c = str;
    }

    public void h(String str) {
        this.d = str;
    }

    public String i() {
        return c7.a(this.e);
    }

    public void i(String str) {
    }

    public void j(String str) {
        this.f = str;
    }

    public long k() {
        return this.m;
    }

    public String l() {
        return t0.b();
    }

    public int m() {
        return this.a;
    }

    public String n() {
        return (TextUtils.isEmpty(this.f71c) || "0123456789ABCDEF".equals(this.f71c)) ? "" : this.f71c;
    }

    public String o() {
        return e7.a("LocationSDK", "location_device_id", "");
    }

    public String p() {
        return c7.a(this.d);
    }

    public long q() {
        return this.j;
    }

    public String r() {
        return this.f;
    }

    public long s() {
        return this.h;
    }

    public void a(String str) {
        this.g = str;
    }

    public String b() {
        return i4.a();
    }

    public void c(long j) {
        this.m = j;
    }

    public void d(long j) {
        this.j = j;
    }

    public void e(String str) {
        this.i = str;
    }

    public long g() {
        return this.l;
    }

    public long h() {
        return this.k;
    }

    public String j() {
        return this.i;
    }

    public void a(long j) {
        this.l = j;
    }

    public void b(long j) {
        this.k = j;
    }

    public void a(long j, boolean z) {
        this.h = Math.max(Long.parseLong(f7.a().get("min_wifi_scan_interval")), j);
        if (z) {
            a7.b("WifiInterval", "IndoorMode");
            this.h = 5000L;
            return;
        }
        a7.b("WifiInterval", "not IndoorMode");
    }

    public String a() {
        if (TextUtils.isEmpty(this.n)) {
            StringBuilder sb = new StringBuilder();
            if (TextUtils.isEmpty(t4.a)) {
                sb.append(t0.b());
            } else {
                sb.append(t4.a).append("_").append(t0.b());
            }
            this.n = h7.a(sb.toString());
        } else {
            a7.b("AppStatus", "getAccessToken token is null");
        }
        return this.n;
    }
}