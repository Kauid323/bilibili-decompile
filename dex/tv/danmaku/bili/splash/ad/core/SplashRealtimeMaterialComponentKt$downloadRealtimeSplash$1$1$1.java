package tv.danmaku.bili.splash.ad.core;

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
import tv.danmaku.bili.splash.ad.model.SplashOrder;
import tv.danmaku.bili.splash.ad.utils.BusinessSplashResHelper;

/* compiled from: SplashRealtimeMaterialComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.splash.ad.core.SplashRealtimeMaterialComponentKt$downloadRealtimeSplash$1$1$1", f = "SplashRealtimeMaterialComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class SplashRealtimeMaterialComponentKt$downloadRealtimeSplash$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SplashOrder $splash;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashRealtimeMaterialComponentKt$downloadRealtimeSplash$1$1$1(SplashOrder splashOrder, Continuation<? super SplashRealtimeMaterialComponentKt$downloadRealtimeSplash$1$1$1> continuation) {
        super(2, continuation);
        this.$splash = splashOrder;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SplashRealtimeMaterialComponentKt$downloadRealtimeSplash$1$1$1(this.$splash, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                BusinessSplashResHelper.INSTANCE.downloadButtonRes(this.$splash.getSplashGuideButton(), this.$splash.getSplashType());
                BusinessSplashResHelper.INSTANCE.downloadMainLogo(this.$splash.getLogoUrl(), this.$splash.getLogoHash(), this.$splash.getSplashType());
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}