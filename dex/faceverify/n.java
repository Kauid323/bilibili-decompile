package faceverify;

import android.text.TextUtils;
import com.dtf.face.log.RecordService;
import com.dtf.face.utils.DownloadUtil;
import com.tencent.open.SocialConstants;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class n implements Runnable {
    public final /* synthetic */ HashMap a;

    public n(HashMap hashMap) {
        this.a = hashMap;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (m.f1966f) {
            return;
        }
        boolean unused = m.f1966f = true;
        for (Map.Entry entry : this.a.entrySet()) {
            if (!TextUtils.equals((CharSequence) entry.getKey(), "suitableType") && !((String) entry.getKey()).startsWith("sigdtf")) {
                String str = (String) entry.getKey();
                if (!m.b.containsKey(entry.getKey()) && DownloadUtil.downloadFileSync((String) entry.getValue(), m.f1967g.getAbsolutePath() + File.separator, str + ".mp3", (String) null, 3) && !m.a(str)) {
                    RecordService.getInstance().recordEvent(2, "suitableError", new String[]{SocialConstants.PARAM_SEND_MSG, "md5 check fail", "fileName", str});
                }
            }
        }
    }
}