package tv.danmaku.bili.ui.deeplinkbutton.api;

import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.call.BiliCall;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import retrofit2.Callback;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;

/* compiled from: DeepLinkButtonApiManager.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tH\u0007¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/ui/deeplinkbutton/api/DeepLinkButtonApiManager;", "", "<init>", "()V", "getDeepLinkButtonInfo", "", "schema", "", AuthResultCbHelper.ARGS_CALLBACK, "Lcom/bilibili/okretro/BiliApiDataCallback;", "Ltv/danmaku/bili/ui/deeplinkbutton/api/DeepLinkButtonInfo;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DeepLinkButtonApiManager {
    public static final int $stable = 0;
    public static final DeepLinkButtonApiManager INSTANCE = new DeepLinkButtonApiManager();

    private DeepLinkButtonApiManager() {
    }

    @JvmStatic
    public static final void getDeepLinkButtonInfo(String schema, BiliApiDataCallback<DeepLinkButtonInfo> biliApiDataCallback) {
        BiliCall<GeneralResponse<DeepLinkButtonInfo>> deepLinkButtonInfo = ((DeepLinkButtonService) ServiceGenerator.createService(DeepLinkButtonService.class)).getDeepLinkButtonInfo(schema);
        if (deepLinkButtonInfo != null) {
            deepLinkButtonInfo.enqueue((Callback) biliApiDataCallback);
        }
    }
}