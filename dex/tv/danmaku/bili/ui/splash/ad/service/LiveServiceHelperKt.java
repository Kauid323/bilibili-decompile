package tv.danmaku.bili.ui.splash.ad.service;

import com.alibaba.fastjson.JSONObject;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.call.BiliCall;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Callback;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: LiveServiceHelper.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"service", "Ltv/danmaku/bili/ui/splash/ad/service/LiveService;", "requestReserve", "", "sid", "", "csrf", "", "callback", "Lcom/bilibili/okretro/BiliApiDataCallback;", "Lcom/alibaba/fastjson/JSONObject;", "TAG", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class LiveServiceHelperKt {
    private static final String TAG = "[Splash]LiveServiceHelper";
    private static LiveService service;

    static {
        Object createService = ServiceGenerator.createService(LiveService.class);
        Intrinsics.checkNotNullExpressionValue(createService, "createService(...)");
        service = (LiveService) createService;
    }

    public static final void requestReserve(long sid, String csrf, BiliApiDataCallback<JSONObject> biliApiDataCallback) {
        Intrinsics.checkNotNullParameter(csrf, "csrf");
        String accessKey = BiliAccounts.get(BiliContext.application()).getAccessKey();
        BiliCall biliCall = service.reserve(accessKey, sid, csrf);
        biliCall.enqueue((Callback) biliApiDataCallback);
    }
}