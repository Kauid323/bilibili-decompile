package tv.danmaku.bili.splash.ad.player;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SplashBannerPlayer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.splash.ad.player.SplashBannerPlayer$takeSnapshot$1", f = "SplashBannerPlayer.kt", i = {}, l = {119}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SplashBannerPlayer$takeSnapshot$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Bitmap, Unit> $onCaptured;
    int label;
    final /* synthetic */ SplashBannerPlayer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SplashBannerPlayer$takeSnapshot$1(Function1<? super Bitmap, Unit> function1, SplashBannerPlayer splashBannerPlayer, Continuation<? super SplashBannerPlayer$takeSnapshot$1> continuation) {
        super(2, continuation);
        this.$onCaptured = function1;
        this.this$0 = splashBannerPlayer;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SplashBannerPlayer$takeSnapshot$1(this.$onCaptured, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                Object withTimeoutOrNull = TimeoutKt.withTimeoutOrNull(100L, new SplashBannerPlayer$takeSnapshot$1$bm$1(this.this$0, null), (Continuation) this);
                if (withTimeoutOrNull != coroutine_suspended) {
                    $result = withTimeoutOrNull;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Bitmap bm = (Bitmap) $result;
        this.$onCaptured.invoke(bm);
        return Unit.INSTANCE;
    }
}