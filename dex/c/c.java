package c;

import android.os.Bundle;
import java.util.HashMap;

public final class c {
    public String a;
    public Bundle b = new Bundle();

    /* renamed from: c  reason: collision with root package name */
    public Bundle f0c = new Bundle();
    public HashMap d = new HashMap();
    public HashMap e = new HashMap();
    public int f;
    public int g;

    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public static final class a {
        public String a;
        public Bundle b = new Bundle();

        /* renamed from: c  reason: collision with root package name */
        public Bundle f1c = new Bundle();
        public HashMap d = new HashMap();
        public HashMap e = new HashMap();
        public int f = 30000;
        public int g = 60000;
    }

    public c(a aVar) {
        this.a = aVar.a;
        this.b.putAll(aVar.b);
        this.f0c.putAll(aVar.f1c);
        this.d.putAll(aVar.d);
        this.e.putAll(aVar.e);
        this.f = aVar.f;
        this.g = aVar.g;
    }
}