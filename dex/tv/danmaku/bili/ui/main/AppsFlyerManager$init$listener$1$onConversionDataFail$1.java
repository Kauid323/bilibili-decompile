package tv.danmaku.bili.ui.main;

import android.net.Uri;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.utils.DelayInitHelper;

/* compiled from: AppsFlyerManager.kt */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"tv/danmaku/bili/ui/main/AppsFlyerManager$init$listener$1$onConversionDataFail$1", "Ltv/danmaku/bili/utils/DelayInitHelper$DelayInitTask;", "onExecute", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AppsFlyerManager$init$listener$1$onConversionDataFail$1 implements DelayInitHelper.DelayInitTask {
    public void onExecute() {
        Uri parse = Uri.parse("bilibili://root");
        Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
        RouteRequest request = new RouteRequest.Builder(parse).extras(new Function1() { // from class: tv.danmaku.bili.ui.main.AppsFlyerManager$init$listener$1$onConversionDataFail$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit onExecute$lambda$0;
                onExecute$lambda$0 = AppsFlyerManager$init$listener$1$onConversionDataFail$1.onExecute$lambda$0((MutableBundleLike) obj);
                return onExecute$lambda$0;
            }
        }).build();
        BLRouter.routeTo(request, BiliContext.topActivitiy());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onExecute$lambda$0(MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        $this$extras.put("fromSplash", "true");
        return Unit.INSTANCE;
    }
}