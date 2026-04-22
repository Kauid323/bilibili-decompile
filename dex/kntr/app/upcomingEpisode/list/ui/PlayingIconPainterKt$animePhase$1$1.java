package kntr.app.upcomingEpisode.list.ui;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.RepeatMode;
import kntr.app.upcomingEpisode.ConstantsKt;
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
/* compiled from: PlayingIconPainter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.upcomingEpisode.list.ui.PlayingIconPainterKt$animePhase$1$1", f = "PlayingIconPainter.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PlayingIconPainterKt$animePhase$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $animatable;
    final /* synthetic */ int $count;
    final /* synthetic */ int $start;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayingIconPainterKt$animePhase$1$1(Animatable<Float, AnimationVector1D> animatable, int i, int i2, Continuation<? super PlayingIconPainterKt$animePhase$1$1> continuation) {
        super(2, continuation);
        this.$animatable = animatable;
        this.$start = i;
        this.$count = i2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlayingIconPainterKt$animePhase$1$1(this.$animatable, this.$start, this.$count, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Animatable<Float, AnimationVector1D> animatable = this.$animatable;
                Float boxFloat = Boxing.boxFloat(1.0f);
                Easing linearEasing = EasingKt.getLinearEasing();
                this.label = 1;
                if (Animatable.animateTo$default(animatable, boxFloat, AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.tween((int) ConstantsKt.PLAYING_ICON_DURATION, (int) ((this.$start / this.$count) * ((float) ConstantsKt.PLAYING_ICON_DURATION)), linearEasing), RepeatMode.Restart, 0L, 4, (Object) null), (Object) null, (Function1) null, (Continuation) this, 12, (Object) null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}