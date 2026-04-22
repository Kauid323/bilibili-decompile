package facadeverify;

import android.content.Context;
import android.text.TextUtils;
import com.dtf.face.log.RecordService;
import com.dtf.face.network.mpass.biz.rpc.FaceVerifyRpcService;
import com.dtf.face.utils.ClientConfigUtil;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

public class h {
    public String b;
    public List<String> c = new ArrayList();
    public y a = new g(new a());

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public class a implements n {

        /* renamed from: facadeverify.h$a$a  reason: collision with other inner class name */
        /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
        public class C0020a extends b0 {
            public C0020a(a aVar) {
            }

            @Override // facadeverify.b0
            public List<Header> a() {
                String str;
                ArrayList arrayList = new ArrayList();
                arrayList.add(new BasicHeader("AppId", "C321516081430"));
                if (TextUtils.isEmpty(FaceVerifyRpcService.getRpcService().getEnvName())) {
                    str = "prod";
                } else {
                    str = FaceVerifyRpcService.getRpcService().getEnvName();
                }
                arrayList.add(new BasicHeader("WorkspaceId", str));
                return arrayList;
            }
        }

        public a() {
        }

        public b0 a() {
            return new C0020a(this);
        }

        public c0 b() {
            Context context = FaceVerifyRpcService.getRpcService().getContext();
            s sVar = s.f1918h;
            return sVar != null ? sVar : s.a(context);
        }

        public String c() {
            if (!ClientConfigUtil.getNeedBackupUrl()) {
                return h.this.c.size() > 0 ? h.this.c.get(0) : "";
            }
            if (h.this.c.size() > 0) {
                h hVar = h.this;
                if (!hVar.b.equals(hVar.c.get(0))) {
                    RecordService.getInstance().recordEvent(2, "networkRequest", new String[]{"backupGWUrl", h.this.b});
                }
            }
            return h.this.b;
        }

        public boolean d() {
            return true;
        }
    }
}