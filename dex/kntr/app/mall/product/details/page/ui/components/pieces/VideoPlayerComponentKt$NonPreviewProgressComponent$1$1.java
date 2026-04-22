package kntr.app.mall.product.details.page.ui.components.pieces;

import androidx.compose.runtime.MutableFloatState;
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
@DebugMetadata(c = "kntr.app.mall.product.details.page.ui.components.pieces.VideoPlayerComponentKt$NonPreviewProgressComponent$1$1", f = "VideoPlayerComponent.kt", i = {}, l = {214}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class VideoPlayerComponentKt$NonPreviewProgressComponent$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableFloatState $progress$delegate;
    final /* synthetic */ SimplePlayer $videoPlayer;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPlayerComponentKt$NonPreviewProgressComponent$1$1(SimplePlayer simplePlayer, MutableFloatState mutableFloatState, Continuation<? super VideoPlayerComponentKt$NonPreviewProgressComponent$1$1> continuation) {
        super(2, continuation);
        this.$videoPlayer = simplePlayer;
        this.$progress$delegate = mutableFloatState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoPlayerComponentKt$NonPreviewProgressComponent$1$1(this.$videoPlayer, this.$progress$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:6|(1:7)|8|10|11|12|(1:14)|15) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
        r7 = kotlin.time.Duration.Companion.getZERO-UwyO8pc();
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0076  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003f -> B:32:0x0043). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object obj;
        VideoPlayerComponentKt$NonPreviewProgressComponent$1$1 videoPlayerComponentKt$NonPreviewProgressComponent$1$1;
        Object $result2;
        VideoPlayerComponentKt$NonPreviewProgressComponent$1$1 videoPlayerComponentKt$NonPreviewProgressComponent$1$12;
        Object obj2;
        Object $result3;
        long currentProgress;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$videoPlayer.getState() == SimplePlayerState.READY) {
                    obj = coroutine_suspended;
                    videoPlayerComponentKt$NonPreviewProgressComponent$1$1 = this;
                    $result2 = $result;
                    break;
                } else {
                    return Unit.INSTANCE;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                $result3 = $result;
                obj2 = coroutine_suspended;
                videoPlayerComponentKt$NonPreviewProgressComponent$1$12 = this;
                try {
                } catch (Exception e) {
                    currentProgress = Duration.Companion.getZERO-UwyO8pc();
                }
                currentProgress = videoPlayerComponentKt$NonPreviewProgressComponent$1$12.$videoPlayer.getCurrentProgress-UwyO8pc();
                long duration = videoPlayerComponentKt$NonPreviewProgressComponent$1$12.$videoPlayer.getDuration-UwyO8pc();
                double denomMs = Duration.toDouble-impl(duration, DurationUnit.MILLISECONDS);
                double numerMs = Duration.toDouble-impl(currentProgress, DurationUnit.MILLISECONDS);
                double ratio = denomMs > 0.0d ? numerMs / denomMs : 0.0d;
                videoPlayerComponentKt$NonPreviewProgressComponent$1$12.$progress$delegate.setFloatValue(RangesKt.coerceIn((float) ratio, 0.0f, 1.0f));
                $result2 = $result3;
                obj = obj2;
                videoPlayerComponentKt$NonPreviewProgressComponent$1$1 = videoPlayerComponentKt$NonPreviewProgressComponent$1$12;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        videoPlayerComponentKt$NonPreviewProgressComponent$1$1.label = 1;
        if (DelayKt.delay(33L, (Continuation) videoPlayerComponentKt$NonPreviewProgressComponent$1$1) != obj) {
            return obj;
        }
        videoPlayerComponentKt$NonPreviewProgressComponent$1$12 = videoPlayerComponentKt$NonPreviewProgressComponent$1$1;
        obj2 = obj;
        $result3 = $result2;
        currentProgress = videoPlayerComponentKt$NonPreviewProgressComponent$1$12.$videoPlayer.getCurrentProgress-UwyO8pc();
        long duration2 = videoPlayerComponentKt$NonPreviewProgressComponent$1$12.$videoPlayer.getDuration-UwyO8pc();
        double denomMs2 = Duration.toDouble-impl(duration2, DurationUnit.MILLISECONDS);
        double numerMs2 = Duration.toDouble-impl(currentProgress, DurationUnit.MILLISECONDS);
        if (denomMs2 > 0.0d) {
        }
        videoPlayerComponentKt$NonPreviewProgressComponent$1$12.$progress$delegate.setFloatValue(RangesKt.coerceIn((float) ratio, 0.0f, 1.0f));
        $result2 = $result3;
        obj = obj2;
        videoPlayerComponentKt$NonPreviewProgressComponent$1$1 = videoPlayerComponentKt$NonPreviewProgressComponent$1$12;
        videoPlayerComponentKt$NonPreviewProgressComponent$1$1.label = 1;
        if (DelayKt.delay(33L, (Continuation) videoPlayerComponentKt$NonPreviewProgressComponent$1$1) != obj) {
        }
    }
}