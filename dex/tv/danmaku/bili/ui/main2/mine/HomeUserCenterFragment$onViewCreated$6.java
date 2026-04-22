package tv.danmaku.bili.ui.main2.mine;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import tv.danmaku.bili.BR;

/* compiled from: HomeUserCenterFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$onViewCreated$6", f = "HomeUserCenterFragment.kt", i = {}, l = {862}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class HomeUserCenterFragment$onViewCreated$6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HomeUserCenterFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeUserCenterFragment$onViewCreated$6(HomeUserCenterFragment homeUserCenterFragment, Continuation<? super HomeUserCenterFragment$onViewCreated$6> continuation) {
        super(2, continuation);
        this.this$0 = homeUserCenterFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeUserCenterFragment$onViewCreated$6(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
        r1 = r5.this$0.adapterDataChangedFlow(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        HomeUserCenterAdapter homeUserCenterAdapter;
        Flow adapterDataChangedFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                homeUserCenterAdapter = this.this$0.mAdapter;
                if (homeUserCenterAdapter != null && adapterDataChangedFlow != null) {
                    final HomeUserCenterFragment homeUserCenterFragment = this.this$0;
                    this.label = 1;
                    if (adapterDataChangedFlow.collect(new FlowCollector() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$onViewCreated$6.1
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((Unit) value, (Continuation<? super Unit>) $completion);
                        }

                        public final Object emit(Unit it, Continuation<? super Unit> continuation) {
                            MinePagePendingTaskUtil it2;
                            Object executes;
                            it2 = HomeUserCenterFragment.this.getPendingTaskUtil();
                            if (!it2.hasWaitingTasks()) {
                                it2 = null;
                            }
                            return (it2 == null || (executes = it2.executes(continuation)) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? Unit.INSTANCE : executes;
                        }
                    }, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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