package tv.danmaku.bili.splash.ad.page.component;

import com.bilibili.app.comm.list.common.widget.PromoToast;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.model.ExtSplashOrderKt;
import tv.danmaku.bili.splash.ad.page.BaseSplash;
import tv.danmaku.bili.splash.ad.utils.SplashConfigKt;
import tv.danmaku.bili.splash.ad.utils.SplashUtilsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PrepareComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.splash.ad.page.component.PrepareComponentKt$prepareSplash$1", f = "PrepareComponent.kt", i = {0}, l = {BR.avatarUrl}, m = "invokeSuspend", n = {"maxPrepareTime"}, s = {"J$0"}, v = 1)
public final class PrepareComponentKt$prepareSplash$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BaseSplash $this_prepareSplash;
    long J$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrepareComponentKt$prepareSplash$1(BaseSplash baseSplash, Continuation<? super PrepareComponentKt$prepareSplash$1> continuation) {
        super(2, continuation);
        this.$this_prepareSplash = baseSplash;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PrepareComponentKt$prepareSplash$1(this.$this_prepareSplash, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        long maxPrepareTime;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                long maxPrepareTime2 = ExtSplashOrderKt.isBannerSplash(this.$this_prepareSplash.getSplash$adsplash_debug()) ? SplashConfigKt.getBannerSplashMaxPrepareTimeMs() : SplashConfigKt.getSplashMaxPrepareTime();
                this.J$0 = maxPrepareTime2;
                this.label = 1;
                if (DelayKt.delay(maxPrepareTime2, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                maxPrepareTime = maxPrepareTime2;
                break;
            case 1:
                maxPrepareTime = this.J$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (this.$this_prepareSplash.getComponentHolder$adsplash_debug().isReady()) {
            return Unit.INSTANCE;
        }
        BLog.i("[Splash]PrepareComponent", "prepare reach timeout");
        this.$this_prepareSplash.onSplashReady(false);
        if (SplashUtilsKt.isDebug()) {
            PromoToast.showMidToast(this.$this_prepareSplash.getContext(), "闪屏视频准备超时，MaxTime" + maxPrepareTime + "ms");
        }
        return Unit.INSTANCE;
    }
}