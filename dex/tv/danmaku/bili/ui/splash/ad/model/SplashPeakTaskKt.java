package tv.danmaku.bili.ui.splash.ad.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.ui.splash.ad.util.BusinessSplashResHelper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashPeakTask.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"isResourceExists", "", "Ltv/danmaku/bili/ui/splash/ad/model/SplashPeakTask;", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashPeakTaskKt {
    public static final boolean isResourceExists(SplashPeakTask $this$isResourceExists) {
        Intrinsics.checkNotNullParameter($this$isResourceExists, "<this>");
        String hash = $this$isResourceExists.getHash();
        if (hash == null || StringsKt.isBlank(hash)) {
            return false;
        }
        return BusinessSplashResHelper.isResourceExistByHash($this$isResourceExists.getHash()) || BusinessSplashResHelper.isResourceExistByHash($this$isResourceExists.getHash());
    }
}