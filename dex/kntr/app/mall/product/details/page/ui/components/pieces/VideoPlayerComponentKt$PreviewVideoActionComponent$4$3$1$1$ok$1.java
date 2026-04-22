package kntr.app.mall.product.details.page.ui.components.pieces;

import com.bilibili.framework.simpleplayer.SimplePlayer;
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
import kotlin.time.Duration;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* compiled from: VideoPlayerComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.ui.components.pieces.VideoPlayerComponentKt$PreviewVideoActionComponent$4$3$1$1$ok$1", f = "VideoPlayerComponent.kt", i = {0}, l = {370}, m = "invokeSuspend", n = {"cur"}, s = {"D$0"}, v = 1)
final class VideoPlayerComponentKt$PreviewVideoActionComponent$4$3$1$1$ok$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ long $targetMs;
    final /* synthetic */ SimplePlayer $videoPlayer;
    double D$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPlayerComponentKt$PreviewVideoActionComponent$4$3$1$1$ok$1(SimplePlayer simplePlayer, long j, Continuation<? super VideoPlayerComponentKt$PreviewVideoActionComponent$4$3$1$1$ok$1> continuation) {
        super(2, continuation);
        this.$videoPlayer = simplePlayer;
        this.$targetMs = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoPlayerComponentKt$PreviewVideoActionComponent$4$3$1$1$ok$1(this.$videoPlayer, this.$targetMs, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0051 -> B:19:0x0054). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        VideoPlayerComponentKt$PreviewVideoActionComponent$4$3$1$1$ok$1 videoPlayerComponentKt$PreviewVideoActionComponent$4$3$1$1$ok$1;
        double cur;
        VideoPlayerComponentKt$PreviewVideoActionComponent$4$3$1$1$ok$1 videoPlayerComponentKt$PreviewVideoActionComponent$4$3$1$1$ok$12;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                videoPlayerComponentKt$PreviewVideoActionComponent$4$3$1$1$ok$1 = this;
                break;
            case 1:
                double d = this.D$0;
                ResultKt.throwOnFailure($result);
                videoPlayerComponentKt$PreviewVideoActionComponent$4$3$1$1$ok$12 = this;
                videoPlayerComponentKt$PreviewVideoActionComponent$4$3$1$1$ok$1 = videoPlayerComponentKt$PreviewVideoActionComponent$4$3$1$1$ok$12;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        try {
        } catch (Exception e) {
            cur = 0.0d;
        }
        cur = Duration.toDouble-impl(videoPlayerComponentKt$PreviewVideoActionComponent$4$3$1$1$ok$1.$videoPlayer.getCurrentProgress-UwyO8pc(), DurationUnit.MILLISECONDS);
        if (Math.abs(cur - videoPlayerComponentKt$PreviewVideoActionComponent$4$3$1$1$ok$1.$targetMs) <= 30.0d) {
            videoPlayerComponentKt$PreviewVideoActionComponent$4$3$1$1$ok$1.D$0 = cur;
            videoPlayerComponentKt$PreviewVideoActionComponent$4$3$1$1$ok$1.label = 1;
            if (DelayKt.delay(16L, (Continuation) videoPlayerComponentKt$PreviewVideoActionComponent$4$3$1$1$ok$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            videoPlayerComponentKt$PreviewVideoActionComponent$4$3$1$1$ok$12 = videoPlayerComponentKt$PreviewVideoActionComponent$4$3$1$1$ok$1;
            videoPlayerComponentKt$PreviewVideoActionComponent$4$3$1$1$ok$1 = videoPlayerComponentKt$PreviewVideoActionComponent$4$3$1$1$ok$12;
            cur = Duration.toDouble-impl(videoPlayerComponentKt$PreviewVideoActionComponent$4$3$1$1$ok$1.$videoPlayer.getCurrentProgress-UwyO8pc(), DurationUnit.MILLISECONDS);
            if (Math.abs(cur - videoPlayerComponentKt$PreviewVideoActionComponent$4$3$1$1$ok$1.$targetMs) <= 30.0d) {
                return Boxing.boxBoolean(true);
            }
        }
    }
}