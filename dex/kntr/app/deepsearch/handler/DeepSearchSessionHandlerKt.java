package kntr.app.deepsearch.handler;

import com.bapis.bilibili.app.search.deepsearch.v1.KChatHistoryItem;
import com.bapis.bilibili.app.search.deepsearch.v1.KDeepSearchMoss;
import com.bapis.bilibili.app.search.deepsearch.v1.KSessionReply;
import com.bapis.bilibili.app.search.deepsearch.v1.KSessionReq;
import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.IdentityBuilderBlock;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import java.util.Iterator;
import java.util.List;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.deepsearch.base.model.biz.DeepSearchTimeoutService;
import kntr.app.deepsearch.base.model.biz.RequestStatus;
import kntr.app.deepsearch.service.DeepSearchTransformListServiceImpKt;
import kntr.app.deepsearch.stateMachine.DeepSearchStateMachine;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: DeepSearchSessionHandler.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0082@¢\u0006\u0002\u0010\u0005\u001a.\u0010\u0006\u001a\u00020\u0007*\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001a\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\tH\u0002¨\u0006\u0013"}, d2 = {"createSession", "Lcom/bapis/bilibili/app/search/deepsearch/v1/KSessionReply;", "query", RoomRecommendViewModel.EMPTY_CURSOR, "title", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bindSessionAction", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", "timeoutService", "Lkntr/app/deepsearch/base/model/biz/DeepSearchTimeoutService;", ReportBuildInParam.MACHINE, "Lkntr/app/deepsearch/stateMachine/DeepSearchStateMachine;", "insertDefaultGreet", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/bapis/bilibili/app/search/deepsearch/v1/KChatHistoryItem;", "pageData", "biz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchSessionHandlerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Object createSession(String query, String title, Continuation<? super KSessionReply> continuation) {
        KSessionReq request = new KSessionReq(query, title);
        return new KDeepSearchMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null).session(request, continuation);
    }

    public static final void bindSessionAction(InStateBuilderBlock<DeepSearchPageData, DeepSearchPageData, DeepSearchAction> inStateBuilderBlock, final DeepSearchTimeoutService timeoutService, final DeepSearchStateMachine machine) {
        Intrinsics.checkNotNullParameter(inStateBuilderBlock, "<this>");
        Intrinsics.checkNotNullParameter(timeoutService, "timeoutService");
        Intrinsics.checkNotNullParameter(machine, ReportBuildInParam.MACHINE);
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchSessionHandlerKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean bindSessionAction$lambda$0;
                bindSessionAction$lambda$0 = DeepSearchSessionHandlerKt.bindSessionAction$lambda$0((DeepSearchPageData) obj);
                return Boolean.valueOf(bindSessionAction$lambda$0);
            }
        }, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchSessionHandlerKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit bindSessionAction$lambda$1;
                bindSessionAction$lambda$1 = DeepSearchSessionHandlerKt.bindSessionAction$lambda$1((ConditionBuilderBlock) obj);
                return bindSessionAction$lambda$1;
            }
        });
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchSessionHandlerKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                boolean bindSessionAction$lambda$2;
                bindSessionAction$lambda$2 = DeepSearchSessionHandlerKt.bindSessionAction$lambda$2((DeepSearchPageData) obj);
                return Boolean.valueOf(bindSessionAction$lambda$2);
            }
        }, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchSessionHandlerKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit bindSessionAction$lambda$3;
                bindSessionAction$lambda$3 = DeepSearchSessionHandlerKt.bindSessionAction$lambda$3(DeepSearchTimeoutService.this, (ConditionBuilderBlock) obj);
                return bindSessionAction$lambda$3;
            }
        });
        inStateBuilderBlock.untilIdentityChanges(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchSessionHandlerKt$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Object bindSessionAction$lambda$4;
                bindSessionAction$lambda$4 = DeepSearchSessionHandlerKt.bindSessionAction$lambda$4((DeepSearchPageData) obj);
                return bindSessionAction$lambda$4;
            }
        }, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchSessionHandlerKt$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit bindSessionAction$lambda$5;
                bindSessionAction$lambda$5 = DeepSearchSessionHandlerKt.bindSessionAction$lambda$5(DeepSearchStateMachine.this, (IdentityBuilderBlock) obj);
                return bindSessionAction$lambda$5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindSessionAction$lambda$0(DeepSearchPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !(it.getRequestModel().getSessionReqState().getStatus() instanceof RequestStatus.Loading);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindSessionAction$lambda$1(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new DeepSearchSessionHandlerKt$bindSessionAction$2$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(DeepSearchAction.CreateSession.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindSessionAction$lambda$2(DeepSearchPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getRequestModel().getSessionReqState().getStatus() instanceof RequestStatus.Loading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindSessionAction$lambda$3(DeepSearchTimeoutService $timeoutService, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new DeepSearchSessionHandlerKt$bindSessionAction$4$1($timeoutService, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object bindSessionAction$lambda$4(DeepSearchPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Boolean.valueOf(it.getRequestModel().getSessionReqState().getStatus() instanceof RequestStatus.Success);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindSessionAction$lambda$5(DeepSearchStateMachine $machine, IdentityBuilderBlock $this$untilIdentityChanges) {
        Intrinsics.checkNotNullParameter($this$untilIdentityChanges, "$this$untilIdentityChanges");
        $this$untilIdentityChanges.onEnter(new DeepSearchSessionHandlerKt$bindSessionAction$6$1(null));
        $this$untilIdentityChanges.onEnterEffect(new DeepSearchSessionHandlerKt$bindSessionAction$6$2($machine, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<KChatHistoryItem> insertDefaultGreet(DeepSearchPageData pageData) {
        List tempList = CollectionsKt.toMutableList(pageData.getList().getList());
        boolean isExistGreet = false;
        Iterator<KChatHistoryItem> it = pageData.getList().getList().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            KChatHistoryItem item = it.next();
            if (DeepSearchTransformListServiceImpKt.isContentGreet(item.getContent())) {
                isExistGreet = true;
                break;
            }
        }
        if (!isExistGreet) {
            tempList.add(0, DeepSearchChatErrorHandlerKt.createGreetError());
        }
        return tempList;
    }
}