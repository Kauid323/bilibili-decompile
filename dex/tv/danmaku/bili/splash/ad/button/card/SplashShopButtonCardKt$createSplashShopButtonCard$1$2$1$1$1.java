package tv.danmaku.bili.splash.ad.button.card;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.button.model.ButtonClickData;
import tv.danmaku.bili.splash.ad.button.model.SplashActionType;
import tv.danmaku.bili.splash.ad.button.model.SplashButtonClickListener;
import tv.danmaku.bili.splash.ad.model.SplashGuideButton;
import tv.danmaku.bili.splash.ad.model.SplashShopCard;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SplashShopButtonCard.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.splash.ad.button.card.SplashShopButtonCardKt$createSplashShopButtonCard$1$2$1$1$1", f = "SplashShopButtonCard.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SplashShopButtonCardKt$createSplashShopButtonCard$1$2$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SplashGuideButton $buttonData;
    final /* synthetic */ SplashShopCard $card;
    final /* synthetic */ int $index;
    final /* synthetic */ SplashButtonClickListener $listener;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashShopButtonCardKt$createSplashShopButtonCard$1$2$1$1$1(SplashButtonClickListener splashButtonClickListener, SplashGuideButton splashGuideButton, SplashShopCard splashShopCard, int i, Continuation<? super SplashShopButtonCardKt$createSplashShopButtonCard$1$2$1$1$1> continuation) {
        super(2, continuation);
        this.$listener = splashButtonClickListener;
        this.$buttonData = splashGuideButton;
        this.$card = splashShopCard;
        this.$index = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SplashShopButtonCardKt$createSplashShopButtonCard$1$2$1$1$1(this.$listener, this.$buttonData, this.$card, this.$index, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                SplashButtonClickListener splashButtonClickListener = this.$listener;
                SplashActionType splashActionType = SplashActionType.BUTTON;
                String schema = this.$buttonData.getSchema();
                splashButtonClickListener.onClickV2(new ButtonClickData(splashActionType, this.$buttonData, this.$buttonData.getJumpUrl(), schema, this.$card.getJumpUrl(), this.$card.getSchema(), Boxing.boxInt(this.$index), this.$card.getWxProgramInfo()));
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}