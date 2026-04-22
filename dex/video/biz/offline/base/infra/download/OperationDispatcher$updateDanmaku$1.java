package video.biz.offline.base.infra.download;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OperationDispatcher.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.infra.download.OperationDispatcher$updateDanmaku$1", f = "OperationDispatcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OperationDispatcher$updateDanmaku$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<OfflineVideoEntity> $videos;
    int label;
    final /* synthetic */ OperationDispatcher this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperationDispatcher$updateDanmaku$1(OperationDispatcher operationDispatcher, List<OfflineVideoEntity> list, Continuation<? super OperationDispatcher$updateDanmaku$1> continuation) {
        super(2, continuation);
        this.this$0 = operationDispatcher;
        this.$videos = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OperationDispatcher$updateDanmaku$1(this.this$0, this.$videos, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        OperationPool operationPool;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                operationPool = this.this$0.operationPool;
                operationPool.updateDanmaku(this.$videos);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}