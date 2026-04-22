package video.biz.offline.base.model.dao;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.model.dao.OfflineVideoDao;
import video.biz.offline.base.model.entity.OfflineAuthUpdate;

/* compiled from: OfflineVideoDao_Impl.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.model.dao.OfflineVideoDao_Impl$updateVerificationCodeBatch$2", f = "OfflineVideoDao_Impl.kt", i = {}, l = {193}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class OfflineVideoDao_Impl$updateVerificationCodeBatch$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ List<OfflineAuthUpdate> $updates;
    int label;
    final /* synthetic */ OfflineVideoDao_Impl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineVideoDao_Impl$updateVerificationCodeBatch$2(OfflineVideoDao_Impl offlineVideoDao_Impl, List<OfflineAuthUpdate> list, Continuation<? super OfflineVideoDao_Impl$updateVerificationCodeBatch$2> continuation) {
        super(1, continuation);
        this.this$0 = offlineVideoDao_Impl;
        this.$updates = list;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new OfflineVideoDao_Impl$updateVerificationCodeBatch$2(this.this$0, this.$updates, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object updateVerificationCodeBatch$suspendImpl;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                updateVerificationCodeBatch$suspendImpl = OfflineVideoDao.CC.updateVerificationCodeBatch$suspendImpl(this.this$0, this.$updates, (Continuation) this);
                if (updateVerificationCodeBatch$suspendImpl == coroutine_suspended) {
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