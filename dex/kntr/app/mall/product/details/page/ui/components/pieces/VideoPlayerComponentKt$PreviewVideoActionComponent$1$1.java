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
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoPlayerComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.ui.components.pieces.VideoPlayerComponentKt$PreviewVideoActionComponent$1$1", f = "VideoPlayerComponent.kt", i = {}, l = {259}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class VideoPlayerComponentKt$PreviewVideoActionComponent$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $isChangingSlider;
    final /* synthetic */ MutableFloatState $progress$delegate;
    final /* synthetic */ SimplePlayer $videoPlayer;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPlayerComponentKt$PreviewVideoActionComponent$1$1(SimplePlayer simplePlayer, MutableState<Boolean> mutableState, MutableFloatState mutableFloatState, Continuation<? super VideoPlayerComponentKt$PreviewVideoActionComponent$1$1> continuation) {
        super(2, continuation);
        this.$videoPlayer = simplePlayer;
        this.$isChangingSlider = mutableState;
        this.$progress$delegate = mutableFloatState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoPlayerComponentKt$PreviewVideoActionComponent$1$1(this.$videoPlayer, this.$isChangingSlider, this.$progress$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:6|(1:7)|8|10|11|12|(1:25)(3:16|(1:18)|19)|20) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
        r7 = kotlin.time.Duration.Companion.getZERO-UwyO8pc();
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003f -> B:38:0x0043). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object obj;
        VideoPlayerComponentKt$PreviewVideoActionComponent$1$1 videoPlayerComponentKt$PreviewVideoActionComponent$1$1;
        Object $result2;
        VideoPlayerComponentKt$PreviewVideoActionComponent$1$1 videoPlayerComponentKt$PreviewVideoActionComponent$1$12;
        Object obj2;
        Object $result3;
        long currentProgress;
        long duration;
        Object $result4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$videoPlayer.getState() == SimplePlayerState.READY) {
                    obj = coroutine_suspended;
                    videoPlayerComponentKt$PreviewVideoActionComponent$1$1 = this;
                    $result2 = $result;
                    break;
                } else {
                    return Unit.INSTANCE;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                $result3 = $result;
                obj2 = coroutine_suspended;
                videoPlayerComponentKt$PreviewVideoActionComponent$1$12 = this;
                try {
                } catch (Exception e) {
                    currentProgress = Duration.Companion.getZERO-UwyO8pc();
                }
                currentProgress = videoPlayerComponentKt$PreviewVideoActionComponent$1$12.$videoPlayer.getCurrentProgress-UwyO8pc();
                duration = videoPlayerComponentKt$PreviewVideoActionComponent$1$12.$videoPlayer.getDuration-UwyO8pc();
                if (Duration.isPositive-impl(duration) || ((Boolean) videoPlayerComponentKt$PreviewVideoActionComponent$1$12.$isChangingSlider.getValue()).booleanValue()) {
                    $result4 = $result3;
                } else {
                    double denomMs = Duration.toDouble-impl(duration, DurationUnit.MILLISECONDS);
                    double numerMs = Duration.toDouble-impl(currentProgress, DurationUnit.MILLISECONDS);
                    double ratio = denomMs > 0.0d ? numerMs / denomMs : 0.0d;
                    $result4 = $result3;
                    videoPlayerComponentKt$PreviewVideoActionComponent$1$12.$progress$delegate.setFloatValue(RangesKt.coerceIn((float) ratio, 0.0f, 1.0f));
                }
                $result2 = $result4;
                obj = obj2;
                videoPlayerComponentKt$PreviewVideoActionComponent$1$1 = videoPlayerComponentKt$PreviewVideoActionComponent$1$12;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        videoPlayerComponentKt$PreviewVideoActionComponent$1$1.label = 1;
        if (DelayKt.delay(33L, (Continuation) videoPlayerComponentKt$PreviewVideoActionComponent$1$1) != obj) {
            return obj;
        }
        videoPlayerComponentKt$PreviewVideoActionComponent$1$12 = videoPlayerComponentKt$PreviewVideoActionComponent$1$1;
        obj2 = obj;
        $result3 = $result2;
        currentProgress = videoPlayerComponentKt$PreviewVideoActionComponent$1$12.$videoPlayer.getCurrentProgress-UwyO8pc();
        duration = videoPlayerComponentKt$PreviewVideoActionComponent$1$12.$videoPlayer.getDuration-UwyO8pc();
        if (Duration.isPositive-impl(duration)) {
        }
        $result4 = $result3;
        $result2 = $result4;
        obj = obj2;
        videoPlayerComponentKt$PreviewVideoActionComponent$1$1 = videoPlayerComponentKt$PreviewVideoActionComponent$1$12;
        videoPlayerComponentKt$PreviewVideoActionComponent$1$1.label = 1;
        if (DelayKt.delay(33L, (Continuation) videoPlayerComponentKt$PreviewVideoActionComponent$1$1) != obj) {
        }
    }
}