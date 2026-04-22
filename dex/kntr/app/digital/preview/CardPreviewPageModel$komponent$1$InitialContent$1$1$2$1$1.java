package kntr.app.digital.preview;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.runtime.MutableState;
import kntr.app.digital.preview.PageState;
import kntr.app.digital.preview.api.CardPreviewModel;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CardPreviewPageModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.digital.preview.CardPreviewPageModel$komponent$1$InitialContent$1$1$2$1$1", f = "CardPreviewPageModel.kt", i = {}, l = {153}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class CardPreviewPageModel$komponent$1$InitialContent$1$1$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $animationFinished$delegate;
    final /* synthetic */ MutableState<CardPreviewModel> $pendingPageData$delegate;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $scale;
    final /* synthetic */ MutableState<PageState> $state$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardPreviewPageModel$komponent$1$InitialContent$1$1$2$1$1(Animatable<Float, AnimationVector1D> animatable, MutableState<Boolean> mutableState, MutableState<CardPreviewModel> mutableState2, MutableState<PageState> mutableState3, Continuation<? super CardPreviewPageModel$komponent$1$InitialContent$1$1$2$1$1> continuation) {
        super(2, continuation);
        this.$scale = animatable;
        this.$animationFinished$delegate = mutableState;
        this.$pendingPageData$delegate = mutableState2;
        this.$state$delegate = mutableState3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CardPreviewPageModel$komponent$1$InitialContent$1$1$2$1$1(this.$scale, this.$animationFinished$delegate, this.$pendingPageData$delegate, this.$state$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        CardPreviewModel it;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (Animatable.animateTo$default(this.$scale, Boxing.boxFloat(1.0f), AnimationSpecKt.tween$default(250, 0, EasingKt.getFastOutSlowInEasing(), 2, (Object) null), (Object) null, (Function1) null, (Continuation) this, 12, (Object) null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        CardPreviewPageModel.komponent$lambda$0$3(this.$animationFinished$delegate, true);
        it = CardPreviewPageModel.komponent$lambda$0$4(this.$pendingPageData$delegate);
        if (it != null) {
            this.$state$delegate.setValue(new PageState.Ready(it));
        }
        return Unit.INSTANCE;
    }
}