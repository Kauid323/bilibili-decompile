package video.biz.offline.list.logic.model;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.interfacee.bridge.history.KMediaHistoryKt;

/* compiled from: OfflineCacheCardModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkotlin/time/Duration;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.model.OfflineCacheCardModelKt$getHistoryProgress$2", f = "OfflineCacheCardModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class OfflineCacheCardModelKt$getHistoryProgress$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Duration>, Object> {
    final /* synthetic */ OfflineVideoEntity $this_getHistoryProgress;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineCacheCardModelKt$getHistoryProgress$2(OfflineVideoEntity offlineVideoEntity, Continuation<? super OfflineCacheCardModelKt$getHistoryProgress$2> continuation) {
        super(2, continuation);
        this.$this_getHistoryProgress = offlineVideoEntity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OfflineCacheCardModelKt$getHistoryProgress$2(this.$this_getHistoryProgress, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Duration> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Duration.Companion companion = Duration.Companion;
                return Duration.box-impl(DurationKt.toDuration(KMediaHistoryKt.getKMediaHistory().read(this.$this_getHistoryProgress.getCid()), DurationUnit.MILLISECONDS));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}