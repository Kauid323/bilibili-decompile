package kntr.app.digital.preview.card.video;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoUIService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.digital.preview.card.video.VideoUIService$VideoCardContent$1$1$1$1", f = "VideoUIService.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class VideoUIService$VideoCardContent$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $progress;
    int label;
    final /* synthetic */ VideoUIService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoUIService$VideoCardContent$1$1$1$1(VideoUIService videoUIService, long j2, Continuation<? super VideoUIService$VideoCardContent$1$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = videoUIService;
        this.$progress = j2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoUIService$VideoCardContent$1$1$1$1(this.this$0, this.$progress, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        DigitalVideoPlayService digitalVideoPlayService;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                digitalVideoPlayService = this.this$0.videoPlayService;
                this.label = 1;
                if (digitalVideoPlayService.getSimplePlayer().seekTo-VtjQ1oo(DurationKt.toDuration(this.$progress, DurationUnit.MILLISECONDS), (Continuation) this) == coroutine_suspended) {
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