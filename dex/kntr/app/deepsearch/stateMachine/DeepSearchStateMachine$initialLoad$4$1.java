package kntr.app.deepsearch.stateMachine;

import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.deepsearch.base.model.biz.PageStyle;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeepSearchStateMachine.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "it", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.stateMachine.DeepSearchStateMachine$initialLoad$4$1", f = "DeepSearchStateMachine.kt", i = {0, 1}, l = {125, 127}, m = "invokeSuspend", n = {"it", "it"}, s = {"L$0", "L$0"}, v = 1)
public final class DeepSearchStateMachine$initialLoad$4$1 extends SuspendLambda implements Function2<DeepSearchPageData, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DeepSearchStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeepSearchStateMachine$initialLoad$4$1(DeepSearchStateMachine deepSearchStateMachine, Continuation<? super DeepSearchStateMachine$initialLoad$4$1> continuation) {
        super(2, continuation);
        this.this$0 = deepSearchStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> deepSearchStateMachine$initialLoad$4$1 = new DeepSearchStateMachine$initialLoad$4$1(this.this$0, continuation);
        deepSearchStateMachine$initialLoad$4$1.L$0 = obj;
        return deepSearchStateMachine$initialLoad$4$1;
    }

    public final Object invoke(DeepSearchPageData deepSearchPageData, Continuation<? super Unit> continuation) {
        return create(deepSearchPageData, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        DeepSearchPageData it = (DeepSearchPageData) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = it;
                this.label = 1;
                if (this.this$0.dispatch(DeepSearchAction.TextConfig.INSTANCE, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                if (Intrinsics.areEqual(it.getPageStyle(), PageStyle.Init.INSTANCE)) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                    this.label = 2;
                    if (this.this$0.dispatch(DeepSearchAction.CreateSession.INSTANCE, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                if (Intrinsics.areEqual(it.getPageStyle(), PageStyle.Init.INSTANCE)) {
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}