package b;

import java.util.HashMap;

public final class b {
    public HashMap a = new HashMap();

    /* loaded from: /data/np/file-convert/20260223061017a7df215e-cc71-4f91-a72e-32f005bc9f3f/20260223061017a7df215e-cc71-4f91-a72e-32f005bc9f3f.dex */
    public static class a {
        public static final b a = new b();
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            bVar = a.a;
        }
        return bVar;
    }
}