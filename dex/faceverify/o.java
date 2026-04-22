package faceverify;

import com.dtf.face.utils.DownloadUtil;
import java.io.File;

public final class o implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    public o(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        String valueOf = String.valueOf(this.a.hashCode());
        if (m.b.get(valueOf) != null) {
            return;
        }
        m.b.put(valueOf, 1);
        if (DownloadUtil.downloadFileSync(this.b, m.f1967g.getAbsolutePath() + File.separator, this.a + ".mp3", (String) null, 0) && m.a(this.a)) {
            m.a(m.f1967g.getAbsolutePath(), this.a, true);
        }
    }
}