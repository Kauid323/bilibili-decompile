package im.keywordBlocking.stateMachine;

import com.bapis.bilibili.app.im.v1.KKeywordBlockingListReply;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.base.IMLog;
import im.keywordBlocking.KBPageData;
import im.keywordBlocking.log.LogTagKt;
import im.keywordBlocking.service.KBPageLoadService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KBStateMachine.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/keywordBlocking/KBPageData;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.keywordBlocking.stateMachine.KBStateMachine$initialLoad$4$1", f = "KBStateMachine.kt", i = {0, 1, 1}, l = {81, 95}, m = "invokeSuspend", n = {"state", "state", "result"}, s = {"L$0", "L$0", "L$1"}, v = 1)
public final class KBStateMachine$initialLoad$4$1 extends SuspendLambda implements Function2<State<KBPageData>, Continuation<? super ChangedState<? extends KBPageData>>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ KBStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KBStateMachine$initialLoad$4$1(KBStateMachine kBStateMachine, Continuation<? super KBStateMachine$initialLoad$4$1> continuation) {
        super(2, continuation);
        this.this$0 = kBStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> kBStateMachine$initialLoad$4$1 = new KBStateMachine$initialLoad$4$1(this.this$0, continuation);
        kBStateMachine$initialLoad$4$1.L$0 = obj;
        return kBStateMachine$initialLoad$4$1;
    }

    public final Object invoke(State<KBPageData> state, Continuation<? super ChangedState<KBPageData>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00c7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        KBPageLoadService kBPageLoadService;
        Object result;
        Object result2;
        Throwable throwable;
        Object result3;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                IMLog.Companion.i(LogTagKt.KB_LOG_TAG, "准备请求列表");
                kBPageLoadService = this.this$0.loadService;
                this.L$0 = state;
                this.label = 1;
                result = kBPageLoadService.m3191loadIoAF18A$keyword_blocking_debug((Continuation) this);
                if (result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                result2 = result;
                if (Result.isSuccess-impl(result2)) {
                    KKeywordBlockingListReply reply = (KKeywordBlockingListReply) result2;
                    IMLog.Companion companion = IMLog.Companion;
                    int size = reply.getItems().size();
                    int listLimit = reply.getListLimit();
                    companion.i(LogTagKt.KB_LOG_TAG, "请求列表成功，列表长度 " + size + ", 列表数量上限 " + listLimit + ", 关键词字符上限 " + reply.getCharLimit());
                }
                throwable = Result.exceptionOrNull-impl(result2);
                if (throwable != null) {
                    IMLog.Companion.e(LogTagKt.KB_LOG_TAG, "列表请求失败", throwable);
                }
                this.L$0 = state;
                this.L$1 = SpillingKt.nullOutSpilledVariable(result);
                this.label = 2;
                result3 = ((KBPageData) state.getSnapshot()).receive$keyword_blocking_debug(result, (Continuation) this);
                if (result3 != coroutine_suspended) {
                    return coroutine_suspended;
                }
                final KBPageData newState = (KBPageData) result3;
                return state.mutate(new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$initialLoad$4$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        KBPageData invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = KBStateMachine$initialLoad$4$1.invokeSuspend$lambda$1(KBPageData.this, (KBPageData) obj);
                        return invokeSuspend$lambda$1;
                    }
                });
            case 1:
                ResultKt.throwOnFailure($result);
                result = ((Result) $result).unbox-impl();
                result2 = result;
                if (Result.isSuccess-impl(result2)) {
                }
                throwable = Result.exceptionOrNull-impl(result2);
                if (throwable != null) {
                }
                this.L$0 = state;
                this.L$1 = SpillingKt.nullOutSpilledVariable(result);
                this.label = 2;
                result3 = ((KBPageData) state.getSnapshot()).receive$keyword_blocking_debug(result, (Continuation) this);
                if (result3 != coroutine_suspended) {
                }
                break;
            case 2:
                Object obj = this.L$1;
                ResultKt.throwOnFailure($result);
                result3 = $result;
                final KBPageData newState2 = (KBPageData) result3;
                return state.mutate(new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$initialLoad$4$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        KBPageData invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = KBStateMachine$initialLoad$4$1.invokeSuspend$lambda$1(KBPageData.this, (KBPageData) obj2);
                        return invokeSuspend$lambda$1;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KBPageData invokeSuspend$lambda$1(KBPageData $newState, KBPageData $this$mutate) {
        return $newState;
    }
}