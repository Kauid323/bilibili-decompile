package tv.danmaku.bili.rating;

import com.bilibili.app.comm.IJsBridgeContextV2;
import com.bilibili.common.webview.js.JsbDynamicService;
import com.bilibili.common.webview.js.JsbDynamicServiceProvider;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: RatingJSB.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0001H\u0007J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/rating/RatingJsbServiceProvider;", "Lcom/bilibili/common/webview/js/JsbDynamicServiceProvider;", "<init>", "()V", "asProvider", "create", "Lcom/bilibili/common/webview/js/JsbDynamicService;", "jsbContext", "Lcom/bilibili/app/comm/IJsBridgeContextV2;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class RatingJsbServiceProvider implements JsbDynamicServiceProvider {
    public static final int $stable = 0;

    public /* synthetic */ boolean enableBuildIn() {
        return JsbDynamicServiceProvider.-CC.$default$enableBuildIn(this);
    }

    @Named("main.showAppStoreRatingPopup")
    public final JsbDynamicServiceProvider asProvider() {
        return this;
    }

    public JsbDynamicService create(IJsBridgeContextV2 jsbContext) {
        Intrinsics.checkNotNullParameter(jsbContext, "jsbContext");
        return new RatingJSBService(jsbContext);
    }
}