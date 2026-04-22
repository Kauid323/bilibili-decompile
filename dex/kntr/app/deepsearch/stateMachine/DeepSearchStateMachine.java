package kntr.app.deepsearch.stateMachine;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStateMachine;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.IdentityBuilderBlock;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import javax.inject.Inject;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.base.model.biz.DeepSearchBroadcastService;
import kntr.app.deepsearch.base.model.biz.DeepSearchDataProcessService;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.deepsearch.base.model.biz.DeepSearchTimeoutService;
import kntr.app.deepsearch.base.model.biz.PageStatus;
import kntr.app.deepsearch.base.model.biz.RequestStatus;
import kntr.app.deepsearch.di.DeepSearchScope;
import kntr.app.deepsearch.di.SessionId;
import kntr.app.deepsearch.di.SessionQuery;
import kntr.app.deepsearch.di.SessionTitle;
import kntr.app.deepsearch.handler.DeepSearchAppStateHandlerKt;
import kntr.app.deepsearch.handler.DeepSearchBubbleHandlerKt;
import kntr.app.deepsearch.handler.DeepSearchChatHandlerKt;
import kntr.app.deepsearch.handler.DeepSearchContainerWidthChangeHandlerKt;
import kntr.app.deepsearch.handler.DeepSearchCopyHandlerKt;
import kntr.app.deepsearch.handler.DeepSearchHistoryHandlerKt;
import kntr.app.deepsearch.handler.DeepSearchLikeHandlerKt;
import kntr.app.deepsearch.handler.DeepSearchSessionHandlerKt;
import kntr.app.deepsearch.handler.DeepSearchSumitTreadHandlerKt;
import kntr.app.deepsearch.handler.DeepSearchTextConfigHandlerKt;
import kntr.app.deepsearch.handler.DeepSearchThinkPopHandlerKt;
import kntr.app.deepsearch.handler.DeepSearchTrackerHandlerKt;
import kntr.app.deepsearch.handler.DeepSearchTreadPopHandlerKt;
import kntr.app.deepsearch.service.DeepSearchTextLinkNodeService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;

/* compiled from: DeepSearchStateMachine.kt */
@DeepSearchScope
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001BG\b\u0007\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u0013*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0014H\u0002J\u001e\u0010\u0015\u001a\u00020\u0013*\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0016H\u0002J\u001e\u0010\u0017\u001a\u00020\u0013*\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0016H\u0002J\u001e\u0010\u0018\u001a\u00020\u0013*\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0016H\u0002J\u001e\u0010\u0019\u001a\u00020\u0013*\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0016H\u0002J\u001e\u0010\u001a\u001a\u00020\u0013*\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0016H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lkntr/app/deepsearch/stateMachine/DeepSearchStateMachine;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", "sessionId", RoomRecommendViewModel.EMPTY_CURSOR, "sessionQuery", "sessionTitle", "dataProcessService", "Lkntr/app/deepsearch/base/model/biz/DeepSearchDataProcessService;", "broadcastService", "Lkntr/app/deepsearch/base/model/biz/DeepSearchBroadcastService;", "linkNodeService", "Lkntr/app/deepsearch/service/DeepSearchTextLinkNodeService;", "timeoutService", "Lkntr/app/deepsearch/base/model/biz/DeepSearchTimeoutService;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/deepsearch/base/model/biz/DeepSearchDataProcessService;Lkntr/app/deepsearch/base/model/biz/DeepSearchBroadcastService;Lkntr/app/deepsearch/service/DeepSearchTextLinkNodeService;Lkntr/app/deepsearch/base/model/biz/DeepSearchTimeoutService;)V", ReportBuildInParam.BUILD, RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/freeletics/flowredux/dsl/FlowReduxStoreBuilder;", "initialLoad", "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "bindBroadcastAction", "bindTimeoutAction", "bindLinkNodeAction", "bindChatHistoryResetAction", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchStateMachine extends FlowReduxStateMachine<DeepSearchPageData, DeepSearchAction> {
    public static final int $stable = 8;
    private final DeepSearchBroadcastService broadcastService;
    private final DeepSearchDataProcessService dataProcessService;
    private final DeepSearchTextLinkNodeService linkNodeService;
    private final DeepSearchTimeoutService timeoutService;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public DeepSearchStateMachine(@SessionId String sessionId, @SessionQuery String sessionQuery, @SessionTitle String sessionTitle, DeepSearchDataProcessService dataProcessService, DeepSearchBroadcastService broadcastService, DeepSearchTextLinkNodeService linkNodeService, DeepSearchTimeoutService timeoutService) {
        super(new DeepSearchPageData(sessionId, sessionQuery, sessionTitle, null, null, null, null, null, 0.0d, null, null, null, null, null, null, null, null, 131064, null));
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(sessionQuery, "sessionQuery");
        Intrinsics.checkNotNullParameter(sessionTitle, "sessionTitle");
        Intrinsics.checkNotNullParameter(dataProcessService, "dataProcessService");
        Intrinsics.checkNotNullParameter(broadcastService, "broadcastService");
        Intrinsics.checkNotNullParameter(linkNodeService, "linkNodeService");
        Intrinsics.checkNotNullParameter(timeoutService, "timeoutService");
        this.dataProcessService = dataProcessService;
        this.broadcastService = broadcastService;
        this.linkNodeService = linkNodeService;
        this.timeoutService = timeoutService;
        spec(new Function1() { // from class: kntr.app.deepsearch.stateMachine.DeepSearchStateMachine$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = DeepSearchStateMachine._init_$lambda$0(DeepSearchStateMachine.this, (FlowReduxStoreBuilder) obj);
                return _init_$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(DeepSearchStateMachine this$0, FlowReduxStoreBuilder $this$spec) {
        Intrinsics.checkNotNullParameter($this$spec, "$this$spec");
        DeepSearchTrackerHandlerKt.bindTrackerAction($this$spec);
        this$0.build($this$spec);
        return Unit.INSTANCE;
    }

    private final void build(FlowReduxStoreBuilder<DeepSearchPageData, DeepSearchAction> flowReduxStoreBuilder) {
        Function1 block$iv = new Function1() { // from class: kntr.app.deepsearch.stateMachine.DeepSearchStateMachine$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                Unit build$lambda$0;
                build$lambda$0 = DeepSearchStateMachine.build$lambda$0(DeepSearchStateMachine.this, (InStateBuilderBlock) obj);
                return build$lambda$0;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(DeepSearchPageData.class), block$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit build$lambda$0(DeepSearchStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        this$0.initialLoad($this$inState);
        this$0.bindBroadcastAction($this$inState);
        this$0.bindTimeoutAction($this$inState);
        DeepSearchTextConfigHandlerKt.bindTextConfigAction($this$inState, this$0.timeoutService);
        DeepSearchSessionHandlerKt.bindSessionAction($this$inState, this$0.timeoutService, this$0);
        DeepSearchChatHandlerKt.bindChatAction($this$inState, this$0.dataProcessService, this$0.timeoutService);
        DeepSearchHistoryHandlerKt.bindChatHistoryInitAction($this$inState, this$0);
        DeepSearchContainerWidthChangeHandlerKt.bindContainerWidthChangeChangeAction($this$inState, this$0.dataProcessService);
        DeepSearchBubbleHandlerKt.bindBubbleAction($this$inState, this$0.dataProcessService, this$0.linkNodeService);
        DeepSearchThinkPopHandlerKt.bindThinkPopAction($this$inState);
        this$0.bindLinkNodeAction($this$inState);
        this$0.bindChatHistoryResetAction($this$inState);
        DeepSearchAppStateHandlerKt.bindAppStateAction($this$inState, this$0.timeoutService);
        DeepSearchCopyHandlerKt.bindCopyAction($this$inState);
        DeepSearchLikeHandlerKt.bindLikeAction($this$inState);
        DeepSearchTreadPopHandlerKt.bindTreadPopAction($this$inState);
        DeepSearchSumitTreadHandlerKt.bindSubmitTreadAction($this$inState);
        return Unit.INSTANCE;
    }

    private final void initialLoad(InStateBuilderBlock<DeepSearchPageData, DeepSearchPageData, DeepSearchAction> inStateBuilderBlock) {
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.deepsearch.stateMachine.DeepSearchStateMachine$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                boolean initialLoad$lambda$0;
                initialLoad$lambda$0 = DeepSearchStateMachine.initialLoad$lambda$0((DeepSearchPageData) obj);
                return Boolean.valueOf(initialLoad$lambda$0);
            }
        }, new Function1() { // from class: kntr.app.deepsearch.stateMachine.DeepSearchStateMachine$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit initialLoad$lambda$1;
                initialLoad$lambda$1 = DeepSearchStateMachine.initialLoad$lambda$1((ConditionBuilderBlock) obj);
                return initialLoad$lambda$1;
            }
        });
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.deepsearch.stateMachine.DeepSearchStateMachine$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                boolean initialLoad$lambda$2;
                initialLoad$lambda$2 = DeepSearchStateMachine.initialLoad$lambda$2((DeepSearchPageData) obj);
                return Boolean.valueOf(initialLoad$lambda$2);
            }
        }, new Function1() { // from class: kntr.app.deepsearch.stateMachine.DeepSearchStateMachine$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Unit initialLoad$lambda$3;
                initialLoad$lambda$3 = DeepSearchStateMachine.initialLoad$lambda$3(DeepSearchStateMachine.this, (ConditionBuilderBlock) obj);
                return initialLoad$lambda$3;
            }
        });
        inStateBuilderBlock.untilIdentityChanges(new Function1() { // from class: kntr.app.deepsearch.stateMachine.DeepSearchStateMachine$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                Object initialLoad$lambda$4;
                initialLoad$lambda$4 = DeepSearchStateMachine.initialLoad$lambda$4((DeepSearchPageData) obj);
                return initialLoad$lambda$4;
            }
        }, new Function1() { // from class: kntr.app.deepsearch.stateMachine.DeepSearchStateMachine$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                Unit initialLoad$lambda$5;
                initialLoad$lambda$5 = DeepSearchStateMachine.initialLoad$lambda$5(DeepSearchStateMachine.this, (IdentityBuilderBlock) obj);
                return initialLoad$lambda$5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initialLoad$lambda$0(DeepSearchPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.getPageStatus(), PageStatus.Idle.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initialLoad$lambda$1(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new DeepSearchStateMachine$initialLoad$2$1(null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initialLoad$lambda$2(DeepSearchPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.getPageStatus(), PageStatus.InitSuccess.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initialLoad$lambda$3(DeepSearchStateMachine this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnterEffect(new DeepSearchStateMachine$initialLoad$4$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object initialLoad$lambda$4(DeepSearchPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Boolean.valueOf(it.getRequestModel().getTextConfigReqState().getStatus() instanceof RequestStatus.Success);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initialLoad$lambda$5(DeepSearchStateMachine this$0, IdentityBuilderBlock $this$untilIdentityChanges) {
        Intrinsics.checkNotNullParameter($this$untilIdentityChanges, "$this$untilIdentityChanges");
        $this$untilIdentityChanges.onEnter(new DeepSearchStateMachine$initialLoad$6$1(this$0, null));
        return Unit.INSTANCE;
    }

    private final void bindBroadcastAction(InStateBuilderBlock<DeepSearchPageData, DeepSearchPageData, DeepSearchAction> inStateBuilderBlock) {
        BaseBuilderBlock.collectWhileInState$default((BaseBuilderBlock) inStateBuilderBlock, this.broadcastService.deepSearchFlow(), (ExecutionPolicy) null, new DeepSearchStateMachine$bindBroadcastAction$1(this, null), 2, (Object) null);
    }

    private final void bindTimeoutAction(InStateBuilderBlock<DeepSearchPageData, DeepSearchPageData, DeepSearchAction> inStateBuilderBlock) {
        BaseBuilderBlock.collectWhileInState$default((BaseBuilderBlock) inStateBuilderBlock, this.timeoutService.timeoutFlow(), (ExecutionPolicy) null, new DeepSearchStateMachine$bindTimeoutAction$1(this, null), 2, (Object) null);
        BaseBuilderBlock.collectWhileInState$default((BaseBuilderBlock) inStateBuilderBlock, this.timeoutService.greetTimeoutFlow(), (ExecutionPolicy) null, new DeepSearchStateMachine$bindTimeoutAction$2(this, null), 2, (Object) null);
    }

    private final void bindLinkNodeAction(InStateBuilderBlock<DeepSearchPageData, DeepSearchPageData, DeepSearchAction> inStateBuilderBlock) {
        BaseBuilderBlock.collectWhileInState$default((BaseBuilderBlock) inStateBuilderBlock, new Function1() { // from class: kntr.app.deepsearch.stateMachine.DeepSearchStateMachine$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Flow bindLinkNodeAction$lambda$0;
                bindLinkNodeAction$lambda$0 = DeepSearchStateMachine.bindLinkNodeAction$lambda$0(DeepSearchStateMachine.this, (DeepSearchPageData) obj);
                return bindLinkNodeAction$lambda$0;
            }
        }, (ExecutionPolicy) null, new DeepSearchStateMachine$bindLinkNodeAction$2(this, null), 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow bindLinkNodeAction$lambda$0(DeepSearchStateMachine this$0, DeepSearchPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this$0.linkNodeService.getTapTextFlow$biz_debug();
    }

    private final void bindChatHistoryResetAction(InStateBuilderBlock<DeepSearchPageData, DeepSearchPageData, DeepSearchAction> inStateBuilderBlock) {
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.deepsearch.stateMachine.DeepSearchStateMachine$$ExternalSyntheticLambda10
            public final Object invoke(Object obj) {
                boolean bindChatHistoryResetAction$lambda$0;
                bindChatHistoryResetAction$lambda$0 = DeepSearchStateMachine.bindChatHistoryResetAction$lambda$0((DeepSearchPageData) obj);
                return Boolean.valueOf(bindChatHistoryResetAction$lambda$0);
            }
        }, new Function1() { // from class: kntr.app.deepsearch.stateMachine.DeepSearchStateMachine$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit bindChatHistoryResetAction$lambda$1;
                bindChatHistoryResetAction$lambda$1 = DeepSearchStateMachine.bindChatHistoryResetAction$lambda$1(DeepSearchStateMachine.this, (ConditionBuilderBlock) obj);
                return bindChatHistoryResetAction$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindChatHistoryResetAction$lambda$0(DeepSearchPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getPageStatus() instanceof PageStatus.InitSuccess;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindChatHistoryResetAction$lambda$1(DeepSearchStateMachine this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new DeepSearchStateMachine$bindChatHistoryResetAction$2$1(this$0, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(DeepSearchAction.RetryIfPossible.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }
}