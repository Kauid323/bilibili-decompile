package tv.danmaku.bili.splash.ad.button;

import android.content.Context;
import android.view.ViewGroup;
import com.bilibili.common.chronoscommon.EnhancedChronosView;
import com.bilibili.common.chronoscommon.EnhancedChronosViewKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.chronos.SplashChronosViewKt;
import tv.danmaku.bili.splash.ad.model.SplashOrder;

/* compiled from: SplashButtonHelper.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.splash.ad.button.SplashButtonHelper$injectSplashButton$1$onGlobalLayout$3", f = "SplashButtonHelper.kt", i = {}, l = {BR.errorViewVisible}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class SplashButtonHelper$injectSplashButton$1$onGlobalLayout$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ViewGroup $container;
    final /* synthetic */ Context $context;
    final /* synthetic */ SplashOrder $splash;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashButtonHelper$injectSplashButton$1$onGlobalLayout$3(Context context, SplashOrder splashOrder, ViewGroup viewGroup, Continuation<? super SplashButtonHelper$injectSplashButton$1$onGlobalLayout$3> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$splash = splashOrder;
        this.$container = viewGroup;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SplashButtonHelper$injectSplashButton$1$onGlobalLayout$3(this.$context, this.$splash, this.$container, continuation);
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
                Object tryCreateSplashChronosView = SplashChronosViewKt.tryCreateSplashChronosView(this.$context, !this.$splash.getRuntimeExtra().isHotSplash(), (Continuation) this);
                if (tryCreateSplashChronosView != coroutine_suspended) {
                    $result = tryCreateSplashChronosView;
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
        EnhancedChronosView it = (EnhancedChronosView) $result;
        if (it != null) {
            EnhancedChronosViewKt.addView(this.$container, it, 0, new ViewGroup.LayoutParams(-1, -1));
        }
        return Unit.INSTANCE;
    }
}