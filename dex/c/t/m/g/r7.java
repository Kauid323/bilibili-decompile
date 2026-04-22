package c.t.m.g;

import android.content.Context;
import java.io.File;

/* compiled from: TML */
public class r7 {

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a implements c2 {
        public a(r7 r7Var) {
        }

        @Override // c.t.m.g.c2
        public void a(int i, String str, String str2) {
            x3.a(str, str2);
        }
    }

    public void a() {
    }

    public void a(Context context) {
        File externalFilesDir = context.getExternalFilesDir(com.alipay.sdk.m.l.e.m);
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        new File(externalFilesDir, "DrDebugLog");
        b2.a(new a(this));
    }
}