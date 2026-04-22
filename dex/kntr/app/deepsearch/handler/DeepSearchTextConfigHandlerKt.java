package kntr.app.deepsearch.handler;

import com.bapis.bilibili.app.search.deepsearch.v1.KConfigReply;
import com.bapis.bilibili.app.search.deepsearch.v1.KConfigReq;
import com.bapis.bilibili.app.search.deepsearch.v1.KDeepSearchMoss;
import com.bapis.bilibili.app.search.deepsearch.v1.KTreadPop;
import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.deepsearch.base.model.biz.DeepSearchTimeoutService;
import kntr.app.deepsearch.base.model.biz.DeepSearchTreadPopModel;
import kntr.app.deepsearch.base.model.biz.RequestStatus;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: DeepSearchTextConfigHandler.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u0001H\u0082@¢\u0006\u0002\u0010\u0002\u001a&\u0010\u0003\u001a\u00020\u0004*\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002¨\u0006\u000e"}, d2 = {"loadTextConfig", "Lcom/bapis/bilibili/app/search/deepsearch/v1/KConfigReply;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bindTextConfigAction", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", "timeoutService", "Lkntr/app/deepsearch/base/model/biz/DeepSearchTimeoutService;", "createTreadModel", "Lkntr/app/deepsearch/base/model/biz/DeepSearchTreadPopModel;", "treadData", "Lcom/bapis/bilibili/app/search/deepsearch/v1/KTreadPop;", "biz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchTextConfigHandlerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Object loadTextConfig(Continuation<? super KConfigReply> continuation) {
        KConfigReq req = new KConfigReq();
        return new KDeepSearchMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null).config(req, continuation);
    }

    public static final void bindTextConfigAction(InStateBuilderBlock<DeepSearchPageData, DeepSearchPageData, DeepSearchAction> inStateBuilderBlock, final DeepSearchTimeoutService timeoutService) {
        Intrinsics.checkNotNullParameter(inStateBuilderBlock, "<this>");
        Intrinsics.checkNotNullParameter(timeoutService, "timeoutService");
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchTextConfigHandlerKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean bindTextConfigAction$lambda$0;
                bindTextConfigAction$lambda$0 = DeepSearchTextConfigHandlerKt.bindTextConfigAction$lambda$0((DeepSearchPageData) obj);
                return Boolean.valueOf(bindTextConfigAction$lambda$0);
            }
        }, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchTextConfigHandlerKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit bindTextConfigAction$lambda$1;
                bindTextConfigAction$lambda$1 = DeepSearchTextConfigHandlerKt.bindTextConfigAction$lambda$1((ConditionBuilderBlock) obj);
                return bindTextConfigAction$lambda$1;
            }
        });
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchTextConfigHandlerKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                boolean bindTextConfigAction$lambda$2;
                bindTextConfigAction$lambda$2 = DeepSearchTextConfigHandlerKt.bindTextConfigAction$lambda$2((DeepSearchPageData) obj);
                return Boolean.valueOf(bindTextConfigAction$lambda$2);
            }
        }, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchTextConfigHandlerKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit bindTextConfigAction$lambda$3;
                bindTextConfigAction$lambda$3 = DeepSearchTextConfigHandlerKt.bindTextConfigAction$lambda$3(DeepSearchTimeoutService.this, (ConditionBuilderBlock) obj);
                return bindTextConfigAction$lambda$3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindTextConfigAction$lambda$0(DeepSearchPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !(it.getRequestModel().getTextConfigReqState().getStatus() instanceof RequestStatus.Loading);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindTextConfigAction$lambda$1(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new DeepSearchTextConfigHandlerKt$bindTextConfigAction$2$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(DeepSearchAction.TextConfig.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindTextConfigAction$lambda$2(DeepSearchPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getRequestModel().getTextConfigReqState().getStatus() instanceof RequestStatus.Loading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindTextConfigAction$lambda$3(DeepSearchTimeoutService $timeoutService, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new DeepSearchTextConfigHandlerKt$bindTextConfigAction$4$1($timeoutService, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeepSearchTreadPopModel createTreadModel(KTreadPop treadData) {
        if (treadData != null) {
            return new DeepSearchTreadPopModel(treadData.getTitle(), treadData.getReasons(), treadData.getMaxCountWords(), treadData.getInputPlaceholder());
        }
        return new DeepSearchTreadPopModel(null, null, 0, null, 15, null);
    }
}