package baseverify;

import com.dtf.face.network.APICallback;
import java.util.Map;

public final class h implements APICallback<Map<String, Object>> {
    public final /* synthetic */ Map a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f13b;

    public h(Map map, String str) {
        this.a = map;
        this.f13b = str;
    }

    public void onError(String str, String str2, String str3) {
        APICallback aPICallback = (APICallback) this.a.get("logCallback");
        if (aPICallback != null) {
            aPICallback.onError(str, this.f13b, str3);
        }
    }

    public void onSuccess(Object obj) {
        Map map = (Map) obj;
        APICallback aPICallback = (APICallback) this.a.get("logCallback");
        if (aPICallback != null) {
            aPICallback.onSuccess(this.f13b);
        }
    }
}