package kntr.app.mall.product.details.page.ui.components.pieces;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import com.bilibili.framework.simpleplayer.SimplePlayer;
import com.bilibili.framework.simpleplayer.SimplePlayerState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoPlayerComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.ui.components.pieces.VideoPlayerComponentKt$PreviewVideoActionComponent$4$3$1$1", f = "VideoPlayerComponent.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {356, 361}, m = "invokeSuspend", n = {"d", "p", "dMs", "targetMs", "d", "p", "dMs", "targetMs"}, s = {"J$0", "D$0", "D$1", "J$1", "J$0", "D$0", "D$1", "J$1"}, v = 1)
public final class VideoPlayerComponentKt$PreviewVideoActionComponent$4$3$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $isChangingSlider;
    final /* synthetic */ MutableFloatState $progress$delegate;
    final /* synthetic */ SimplePlayer $videoPlayer;
    double D$0;
    double D$1;
    long J$0;
    long J$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPlayerComponentKt$PreviewVideoActionComponent$4$3$1$1(SimplePlayer simplePlayer, MutableState<Boolean> mutableState, MutableFloatState mutableFloatState, Continuation<? super VideoPlayerComponentKt$PreviewVideoActionComponent$4$3$1$1> continuation) {
        super(2, continuation);
        this.$videoPlayer = simplePlayer;
        this.$isChangingSlider = mutableState;
        this.$progress$delegate = mutableFloatState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoPlayerComponentKt$PreviewVideoActionComponent$4$3$1$1(this.$videoPlayer, this.$isChangingSlider, this.$progress$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00ca A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        float PreviewVideoActionComponent$lambda$3;
        long targetMs;
        long d;
        double p;
        double dMs;
        Object withTimeoutOrNull;
        Object obj;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$videoPlayer.getState() != SimplePlayerState.READY) {
                    this.$isChangingSlider.setValue(Boxing.boxBoolean(false));
                    return Unit.INSTANCE;
                }
                long d2 = this.$videoPlayer.getDuration-UwyO8pc();
                if (Duration.isPositive-impl(d2) && Duration.isFinite-impl(d2)) {
                    PreviewVideoActionComponent$lambda$3 = VideoPlayerComponentKt.PreviewVideoActionComponent$lambda$3(this.$progress$delegate);
                    double p2 = RangesKt.coerceIn(PreviewVideoActionComponent$lambda$3, 0.0f, 1.0f);
                    double dMs2 = Duration.toDouble-impl(d2, DurationUnit.MILLISECONDS);
                    long targetMs2 = RangesKt.coerceIn(MathKt.roundToLong(p2 * dMs2), 0L, Duration.getInWholeMilliseconds-impl(d2));
                    this.J$0 = d2;
                    this.D$0 = p2;
                    this.D$1 = dMs2;
                    this.J$1 = targetMs2;
                    this.label = 1;
                    if (this.$videoPlayer.seekTo-VtjQ1oo(DurationKt.toDuration(targetMs2, DurationUnit.MILLISECONDS), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    targetMs = targetMs2;
                    d = d2;
                    p = dMs2;
                    dMs = p2;
                    this.J$0 = d;
                    this.D$0 = dMs;
                    this.D$1 = p;
                    this.J$1 = targetMs;
                    this.label = 2;
                    withTimeoutOrNull = TimeoutKt.withTimeoutOrNull(800L, new VideoPlayerComponentKt$PreviewVideoActionComponent$4$3$1$1$ok$1(this.$videoPlayer, targetMs, null), (Continuation) this);
                    if (withTimeoutOrNull != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = withTimeoutOrNull;
                    Boolean bool = (Boolean) obj;
                }
                this.$isChangingSlider.setValue(Boxing.boxBoolean(false));
                return Unit.INSTANCE;
            case 1:
                targetMs = this.J$1;
                p = this.D$1;
                dMs = this.D$0;
                d = this.J$0;
                ResultKt.throwOnFailure($result);
                this.J$0 = d;
                this.D$0 = dMs;
                this.D$1 = p;
                this.J$1 = targetMs;
                this.label = 2;
                withTimeoutOrNull = TimeoutKt.withTimeoutOrNull(800L, new VideoPlayerComponentKt$PreviewVideoActionComponent$4$3$1$1$ok$1(this.$videoPlayer, targetMs, null), (Continuation) this);
                if (withTimeoutOrNull != coroutine_suspended) {
                }
                break;
            case 2:
                long j = this.J$1;
                double d3 = this.D$1;
                double d4 = this.D$0;
                long d5 = this.J$0;
                ResultKt.throwOnFailure($result);
                d = d5;
                obj = $result;
                Boolean bool2 = (Boolean) obj;
                this.$isChangingSlider.setValue(Boxing.boxBoolean(false));
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}