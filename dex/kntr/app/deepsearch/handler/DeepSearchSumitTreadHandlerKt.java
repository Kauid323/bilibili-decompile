package kntr.app.deepsearch.handler;

import com.bapis.bilibili.app.search.deepsearch.v1.KDeepSearchMoss;
import com.bapis.bilibili.app.search.deepsearch.v1.KTreadSubmitReq;
import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.deepsearch.base.model.biz.RequestParam;
import kntr.app.deepsearch.base.model.biz.RequestStatus;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: DeepSearchSumitTreadHandler.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u0006\u001a\u001e\u0010\u0007\u001a\u00020\u0001*\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0000¨\u0006\u000b"}, d2 = {"requestSubmitTread", RoomRecommendViewModel.EMPTY_CURSOR, "sessionId", RoomRecommendViewModel.EMPTY_CURSOR, "submitTreadParam", "Lkntr/app/deepsearch/base/model/biz/RequestParam$SubmitTreadParam;", "(Ljava/lang/String;Lkntr/app/deepsearch/base/model/biz/RequestParam$SubmitTreadParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bindSubmitTreadAction", "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", "biz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchSumitTreadHandlerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Object requestSubmitTread(String sessionId, RequestParam.SubmitTreadParam submitTreadParam, Continuation<? super Unit> continuation) {
        KTreadSubmitReq req = new KTreadSubmitReq(sessionId, submitTreadParam.getQueryId(), submitTreadParam.getSelectedContent(), submitTreadParam.getInputContent());
        Object treadSubmit = new KDeepSearchMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null).treadSubmit(req, continuation);
        return treadSubmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? treadSubmit : Unit.INSTANCE;
    }

    public static final void bindSubmitTreadAction(InStateBuilderBlock<DeepSearchPageData, DeepSearchPageData, DeepSearchAction> inStateBuilderBlock) {
        Intrinsics.checkNotNullParameter(inStateBuilderBlock, "<this>");
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchSumitTreadHandlerKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean bindSubmitTreadAction$lambda$0;
                bindSubmitTreadAction$lambda$0 = DeepSearchSumitTreadHandlerKt.bindSubmitTreadAction$lambda$0((DeepSearchPageData) obj);
                return Boolean.valueOf(bindSubmitTreadAction$lambda$0);
            }
        }, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchSumitTreadHandlerKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit bindSubmitTreadAction$lambda$1;
                bindSubmitTreadAction$lambda$1 = DeepSearchSumitTreadHandlerKt.bindSubmitTreadAction$lambda$1((ConditionBuilderBlock) obj);
                return bindSubmitTreadAction$lambda$1;
            }
        });
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchSumitTreadHandlerKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                boolean bindSubmitTreadAction$lambda$2;
                bindSubmitTreadAction$lambda$2 = DeepSearchSumitTreadHandlerKt.bindSubmitTreadAction$lambda$2((DeepSearchPageData) obj);
                return Boolean.valueOf(bindSubmitTreadAction$lambda$2);
            }
        }, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchSumitTreadHandlerKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit bindSubmitTreadAction$lambda$3;
                bindSubmitTreadAction$lambda$3 = DeepSearchSumitTreadHandlerKt.bindSubmitTreadAction$lambda$3((ConditionBuilderBlock) obj);
                return bindSubmitTreadAction$lambda$3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindSubmitTreadAction$lambda$0(DeepSearchPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !(it.getRequestModel().getSubmitTreadState().getStatus() instanceof RequestStatus.Loading);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindSubmitTreadAction$lambda$1(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new DeepSearchSumitTreadHandlerKt$bindSubmitTreadAction$2$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(DeepSearchAction.SubmitTreadAction.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindSubmitTreadAction$lambda$2(DeepSearchPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getRequestModel().getSubmitTreadState().getStatus() instanceof RequestStatus.Loading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindSubmitTreadAction$lambda$3(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new DeepSearchSumitTreadHandlerKt$bindSubmitTreadAction$4$1(null));
        return Unit.INSTANCE;
    }
}