package tv.danmaku.bili.splash.ad.business.livereserve;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SplashLiveReserveHelper.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.splash.ad.business.livereserve.SplashLiveReserveHelper", f = "SplashLiveReserveHelper.kt", i = {0, 0}, l = {BR.avatarPendantUrl}, m = "reserveLive", n = {UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH, "needToast"}, s = {"L$0", "Z$0"}, v = 1)
public final class SplashLiveReserveHelper$reserveLive$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SplashLiveReserveHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashLiveReserveHelper$reserveLive$1(SplashLiveReserveHelper splashLiveReserveHelper, Continuation<? super SplashLiveReserveHelper$reserveLive$1> continuation) {
        super(continuation);
        this.this$0 = splashLiveReserveHelper;
    }

    public final Object invokeSuspend(Object obj) {
        Object reserveLive;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        reserveLive = this.this$0.reserveLive(null, false, (Continuation) this);
        return reserveLive;
    }
}