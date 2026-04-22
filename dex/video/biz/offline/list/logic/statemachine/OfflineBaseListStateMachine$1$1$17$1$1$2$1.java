package video.biz.offline.list.logic.statemachine;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.biz.offline.list.logic.model.OfflineCacheCardModelKt;
import video.biz.offline.list.logic.model.OfflineCachedCardModel;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineBaseListStateMachine.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lkotlin/time/Duration;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine$1$1$17$1$1$2$1", f = "OfflineBaseListStateMachine.kt", i = {0}, l = {182}, m = "invokeSuspend", n = {"video"}, s = {"L$0"}, v = 1)
public final class OfflineBaseListStateMachine$1$1$17$1$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends Long, ? extends Duration>>, Object> {
    final /* synthetic */ OfflineCachedCardModel $it;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineBaseListStateMachine$1$1$17$1$1$2$1(OfflineCachedCardModel offlineCachedCardModel, Continuation<? super OfflineBaseListStateMachine$1$1$17$1$1$2$1> continuation) {
        super(2, continuation);
        this.$it = offlineCachedCardModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OfflineBaseListStateMachine$1$1$17$1$1$2$1(this.$it, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<Long, Duration>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object historyProgress;
        OfflineVideoEntity video2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                OfflineVideoEntity video3 = this.$it.getEntity();
                if (video3 != null) {
                    this.L$0 = video3;
                    this.label = 1;
                    historyProgress = OfflineCacheCardModelKt.getHistoryProgress(video3, (Continuation) this);
                    if (historyProgress == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    video2 = video3;
                    break;
                } else {
                    return null;
                }
            case 1:
                video2 = (OfflineVideoEntity) this.L$0;
                ResultKt.throwOnFailure($result);
                historyProgress = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        long progress = ((Duration) historyProgress).unbox-impl();
        return new Pair(Boxing.boxLong(video2.getCid()), Duration.box-impl(progress));
    }
}