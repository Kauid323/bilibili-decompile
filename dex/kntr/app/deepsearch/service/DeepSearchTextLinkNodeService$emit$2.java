package kntr.app.deepsearch.service;

import kntr.app.deepsearch.base.model.biz.LinkNodeData;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeepSearchTextLinkNodeService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.service.DeepSearchTextLinkNodeService$emit$2", f = "DeepSearchTextLinkNodeService.kt", i = {}, l = {31}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DeepSearchTextLinkNodeService$emit$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LinkNodeData $data;
    int label;
    final /* synthetic */ DeepSearchTextLinkNodeService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeepSearchTextLinkNodeService$emit$2(DeepSearchTextLinkNodeService deepSearchTextLinkNodeService, LinkNodeData linkNodeData, Continuation<? super DeepSearchTextLinkNodeService$emit$2> continuation) {
        super(2, continuation);
        this.this$0 = deepSearchTextLinkNodeService;
        this.$data = linkNodeData;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeepSearchTextLinkNodeService$emit$2(this.this$0, this.$data, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (this.this$0.getTapTextFlow$biz_debug().emit(this.$data, (Continuation) this) == coroutine_suspended) {
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