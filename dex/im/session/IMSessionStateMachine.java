package im.session;

import com.bapis.bilibili.app.im.v1.KGetQuickLinkUnreadReply;
import com.bapis.bilibili.app.im.v1.KPaginationParams;
import com.bapis.bilibili.app.im.v1.KSessionId;
import com.bapis.bilibili.app.im.v1.KSessionListExtraInfo;
import com.bapis.bilibili.app.im.v1.KSessionPageType;
import com.bapis.bilibili.broadcast.message.im.KCommandMsg;
import com.bapis.bilibili.broadcast.message.im.KReqServerNotify;
import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStateMachine;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.IdentityBuilderBlock;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import com.freeletics.flowredux.dsl.State;
import com.tencent.smtt.sdk.TbsListener;
import im.base.IMLog;
import im.base.IMToast;
import im.base.IMToastKt;
import im.session.RequestStatus;
import im.session.log.LogTagKt;
import im.session.model.IMQuickLink;
import im.session.model.IMSessionCard;
import im.session.model.IMSessionFilterKt;
import im.session.model.IMSessionPageData;
import im.session.model.IMSessionPageDataKt;
import im.session.model.IMSessionPageDataLensKt;
import im.session.service.IMClearSessionService;
import im.session.service.IMClearUnreadService;
import im.session.service.IMGroupAssistantFetcherService;
import im.session.service.IMMessageSummaryServiceKt;
import im.session.service.IMSessionBroadcastService;
import im.session.service.IMSessionCardEventService;
import im.session.service.IMSessionDataSourceServiceLike;
import im.session.service.IMSessionInteractiveService;
import im.session.service.IMSessionListCacheService;
import im.session.service.IMSessionUpdateService;
import im.session.service.IMSummaryCacheService;
import im.session.service.PinResult;
import im.session.service.Summary;
import im.session.track.TechTrackerKt;
import im.session.track.TrackerKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kntr.app.im.base.IMEventHub;
import kntr.base.account.KAccountStore;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;
import kotlinx.datetime.Clock;

/* compiled from: IMSessionStateMachine.kt */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001Bo\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\"\u0010 \u001a\u00020!*\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\"j\u0002`#H\u0002J\"\u0010$\u001a\u00020!*\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\"j\u0002`#H\u0002J\"\u0010%\u001a\u00020!*\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\"j\u0002`#H\u0002J(\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020'*\b\u0012\u0004\u0012\u00020\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0082@¢\u0006\u0002\u0010+J\u001c\u0010&\u001a\u00020\u0002*\u00020\u00022\b\u0010)\u001a\u0004\u0018\u00010*H\u0082@¢\u0006\u0002\u0010,J\"\u0010-\u001a\u00020!*\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\"j\u0002`#H\u0002J\u001e\u0010.\u001a\u00020!*\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030/H\u0002J\u001e\u00100\u001a\u00020!*\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030/H\u0002J@\u00101\u001a\b\u0012\u0004\u0012\u00020\u00020'*\b\u0012\u0004\u0012\u00020\u00020(2\f\u00102\u001a\b\u0012\u0004\u0012\u000204032\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u000206H\u0082@¢\u0006\u0002\u00108J&\u00109\u001a\b\u0012\u0004\u0012\u00020\u00020'*\b\u0012\u0004\u0012\u00020\u00020(2\u0006\u0010)\u001a\u00020*H\u0082@¢\u0006\u0002\u0010+J\u001e\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00020'*\b\u0012\u0004\u0012\u00020\u00020(H\u0082@¢\u0006\u0002\u0010;J\u001e\u0010<\u001a\u00020!2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0002H\u0082@¢\u0006\u0002\u0010@J\u001e\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00020'*\b\u0012\u0004\u0012\u00020\u00020(H\u0082@¢\u0006\u0002\u0010;J*\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00020'*\b\u0012\u0004\u0012\u00020\u00020(2\u0006\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010FH\u0002J \u0010G\u001a\b\u0012\u0004\u0012\u00020\u00020'*\b\u0012\u0004\u0012\u00020\u00020(2\u0006\u0010C\u001a\u00020DH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lim/session/IMSessionStateMachine;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Lim/session/IMState;", "Lim/session/IMAction;", "pageType", "Lcom/bapis/bilibili/app/im/v1/KSessionPageType;", "broadcastService", "Lim/session/service/IMSessionBroadcastService;", "dataSourceService", "Lim/session/service/IMSessionDataSourceServiceLike;", "updateService", "Lim/session/service/IMSessionUpdateService;", "sessionEventService", "Lim/session/service/IMSessionCardEventService;", "clearUnreadService", "Lim/session/service/IMClearUnreadService;", "clearSessionService", "Lim/session/service/IMClearSessionService;", "interactiveService", "Lim/session/service/IMSessionInteractiveService;", "accountStore", "Lkntr/base/account/KAccountStore;", "summaryService", "Lim/session/service/IMSummaryCacheService;", "cacheService", "Lim/session/service/IMSessionListCacheService;", "groupAssistantFetcherService", "Lim/session/service/IMGroupAssistantFetcherService;", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KSessionPageType;Lim/session/service/IMSessionBroadcastService;Lim/session/service/IMSessionDataSourceServiceLike;Lim/session/service/IMSessionUpdateService;Lim/session/service/IMSessionCardEventService;Lim/session/service/IMClearUnreadService;Lim/session/service/IMClearSessionService;Lim/session/service/IMSessionInteractiveService;Lkntr/base/account/KAccountStore;Lim/session/service/IMSummaryCacheService;Lim/session/service/IMSessionListCacheService;Lim/session/service/IMGroupAssistantFetcherService;)V", "sessionLogTag", "", "sessionClickBlock", "", "Lcom/freeletics/flowredux/dsl/BaseBuilderBlock;", "Lim/session/BaseIMBlock;", "updateBlock", "clearSessionListBlock", "markSessionAsRead", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lcom/freeletics/flowredux/dsl/State;", "session", "Lim/session/model/IMSessionCard;", "(Lcom/freeletics/flowredux/dsl/State;Lim/session/model/IMSessionCard;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lim/session/IMState;Lim/session/model/IMSessionCard;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sessionDeleteBlock", "summaryBlock", "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "broadcastBlock", "receive", "result", "Lkotlin/Result;", "Lim/session/model/IMSessionPageData;", "byNext", "", "overrideQuickLink", "(Lcom/freeletics/flowredux/dsl/State;Ljava/lang/Object;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pinOrNot", "clearUnread", "(Lcom/freeletics/flowredux/dsl/State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "broadcastReceived", "notify", "Lcom/bapis/bilibili/broadcast/message/im/KReqServerNotify;", "state", "(Lcom/bapis/bilibili/broadcast/message/im/KReqServerNotify;Lim/session/IMState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateQuickLink", "updateSummaryFor", "sessionId", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "newSummary", "Lim/session/service/Summary;", "removeSession", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSessionStateMachine extends FlowReduxStateMachine<IMState, IMAction> {
    private final KAccountStore accountStore;
    private final IMSessionBroadcastService broadcastService;
    private final IMSessionListCacheService cacheService;
    private final IMClearSessionService clearSessionService;
    private final IMClearUnreadService clearUnreadService;
    private final IMSessionDataSourceServiceLike dataSourceService;
    private final IMGroupAssistantFetcherService groupAssistantFetcherService;
    private final IMSessionInteractiveService interactiveService;
    private final KSessionPageType pageType;
    private final IMSessionCardEventService sessionEventService;
    private final String sessionLogTag;
    private final IMSummaryCacheService summaryService;
    private final IMSessionUpdateService updateService;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public IMSessionStateMachine(KSessionPageType pageType, IMSessionBroadcastService broadcastService, IMSessionDataSourceServiceLike dataSourceService, IMSessionUpdateService updateService, IMSessionCardEventService sessionEventService, IMClearUnreadService clearUnreadService, IMClearSessionService clearSessionService, IMSessionInteractiveService interactiveService, KAccountStore accountStore, IMSummaryCacheService summaryService, IMSessionListCacheService cacheService, IMGroupAssistantFetcherService groupAssistantFetcherService) {
        super(new IMState(pageType, new IMSessionPageData(null, null, null, null, null, null, null, null, null, null, false, 2047, null), null, false, RequestStatus.Idle.INSTANCE, null, false, null, TbsListener.ErrorCode.TPATCH_INSTALL_SUCCESS, null));
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        Intrinsics.checkNotNullParameter(broadcastService, "broadcastService");
        Intrinsics.checkNotNullParameter(dataSourceService, "dataSourceService");
        Intrinsics.checkNotNullParameter(updateService, "updateService");
        Intrinsics.checkNotNullParameter(sessionEventService, "sessionEventService");
        Intrinsics.checkNotNullParameter(clearUnreadService, "clearUnreadService");
        Intrinsics.checkNotNullParameter(clearSessionService, "clearSessionService");
        Intrinsics.checkNotNullParameter(accountStore, "accountStore");
        Intrinsics.checkNotNullParameter(summaryService, "summaryService");
        this.pageType = pageType;
        this.broadcastService = broadcastService;
        this.dataSourceService = dataSourceService;
        this.updateService = updateService;
        this.sessionEventService = sessionEventService;
        this.clearUnreadService = clearUnreadService;
        this.clearSessionService = clearSessionService;
        this.interactiveService = interactiveService;
        this.accountStore = accountStore;
        this.summaryService = summaryService;
        this.cacheService = cacheService;
        this.groupAssistantFetcherService = groupAssistantFetcherService;
        this.sessionLogTag = LogTagKt.SessionLogTag(this.pageType.getName());
        IMLog.Companion.i(this.sessionLogTag, "会话列表:" + this.pageType + " 状态机初始化(init)");
        spec(new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda50
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = IMSessionStateMachine._init_$lambda$0(IMSessionStateMachine.this, (FlowReduxStoreBuilder) obj);
                return _init_$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(final IMSessionStateMachine this$0, FlowReduxStoreBuilder $this$spec) {
        Intrinsics.checkNotNullParameter($this$spec, "$this$spec");
        TrackerKt.bindTracker($this$spec);
        TechTrackerKt.bindTechTracker($this$spec);
        Function1 block$iv = new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return IMSessionStateMachine.lambda$0$0(IMSessionStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(IMState.class), block$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0(final IMSessionStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnterEffect(new IMSessionStateMachine$1$1$1(this$0, null));
        $this$inState.condition(new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda14
            public final Object invoke(Object obj) {
                return Boolean.valueOf(IMSessionStateMachine.lambda$0$0$0((IMState) obj));
            }
        }, new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda26
            public final Object invoke(Object obj) {
                return IMSessionStateMachine.lambda$0$0$1(IMSessionStateMachine.this, (ConditionBuilderBlock) obj);
            }
        });
        $this$inState.condition(new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda36
            public final Object invoke(Object obj) {
                return Boolean.valueOf(IMSessionStateMachine.lambda$0$0$2((IMState) obj));
            }
        }, new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda37
            public final Object invoke(Object obj) {
                return IMSessionStateMachine.lambda$0$0$3(IMSessionStateMachine.this, (ConditionBuilderBlock) obj);
            }
        });
        $this$inState.condition(new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda38
            public final Object invoke(Object obj) {
                return Boolean.valueOf(IMSessionStateMachine.lambda$0$0$4((IMState) obj));
            }
        }, new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda39
            public final Object invoke(Object obj) {
                return IMSessionStateMachine.lambda$0$0$5(IMSessionStateMachine.this, (ConditionBuilderBlock) obj);
            }
        });
        $this$inState.untilIdentityChanges(new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda40
            public final Object invoke(Object obj) {
                return IMSessionStateMachine.lambda$0$0$6((IMState) obj);
            }
        }, new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda41
            public final Object invoke(Object obj) {
                return IMSessionStateMachine.lambda$0$0$7(IMSessionStateMachine.this, (IdentityBuilderBlock) obj);
            }
        });
        this$0.summaryBlock($this$inState);
        this$0.broadcastBlock($this$inState);
        $this$inState.condition(new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda42
            public final Object invoke(Object obj) {
                return Boolean.valueOf(IMSessionStateMachine.lambda$0$0$8((IMState) obj));
            }
        }, new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda43
            public final Object invoke(Object obj) {
                return IMSessionStateMachine.lambda$0$0$9((ConditionBuilderBlock) obj);
            }
        });
        $this$inState.condition(new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda15
            public final Object invoke(Object obj) {
                return Boolean.valueOf(IMSessionStateMachine.lambda$0$0$10((IMState) obj));
            }
        }, new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda16
            public final Object invoke(Object obj) {
                return IMSessionStateMachine.lambda$0$0$11((ConditionBuilderBlock) obj);
            }
        });
        $this$inState.condition(new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda17
            public final Object invoke(Object obj) {
                return Boolean.valueOf(IMSessionStateMachine.lambda$0$0$12((IMState) obj));
            }
        }, new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda18
            public final Object invoke(Object obj) {
                return IMSessionStateMachine.lambda$0$0$13(IMSessionStateMachine.this, (ConditionBuilderBlock) obj);
            }
        });
        BaseBuilderBlock.collectWhileInStateEffect$default((BaseBuilderBlock) $this$inState, this$0.accountStore.getState(), (ExecutionPolicy) null, new IMSessionStateMachine$1$1$16(this$0, null), 2, (Object) null);
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new IMSessionStateMachine$1$1$17(this$0, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(IMActionLogout.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv2 = new IMSessionStateMachine$1$1$18(this$0, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(IMActionLogin.class), executionPolicy$iv2, handler$iv2);
        $this$inState.condition(new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda19
            public final Object invoke(Object obj) {
                return Boolean.valueOf(IMSessionStateMachine.lambda$0$0$14(IMSessionStateMachine.this, (IMState) obj));
            }
        }, new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda20
            public final Object invoke(Object obj) {
                return IMSessionStateMachine.lambda$0$0$15(IMSessionStateMachine.this, (ConditionBuilderBlock) obj);
            }
        });
        $this$inState.condition(new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda21
            public final Object invoke(Object obj) {
                return Boolean.valueOf(IMSessionStateMachine.lambda$0$0$16((IMState) obj));
            }
        }, new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda23
            public final Object invoke(Object obj) {
                return IMSessionStateMachine.lambda$0$0$17((ConditionBuilderBlock) obj);
            }
        });
        $this$inState.condition(new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda24
            public final Object invoke(Object obj) {
                return Boolean.valueOf(IMSessionStateMachine.lambda$0$0$18((IMState) obj));
            }
        }, new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda25
            public final Object invoke(Object obj) {
                return IMSessionStateMachine.lambda$0$0$19(IMSessionStateMachine.this, (ConditionBuilderBlock) obj);
            }
        });
        $this$inState.condition(new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda27
            public final Object invoke(Object obj) {
                return Boolean.valueOf(IMSessionStateMachine.lambda$0$0$20((IMState) obj));
            }
        }, new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda28
            public final Object invoke(Object obj) {
                return IMSessionStateMachine.lambda$0$0$21((ConditionBuilderBlock) obj);
            }
        });
        $this$inState.untilIdentityChanges(new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda29
            public final Object invoke(Object obj) {
                return IMSessionStateMachine.lambda$0$0$22((IMState) obj);
            }
        }, new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda30
            public final Object invoke(Object obj) {
                return IMSessionStateMachine.lambda$0$0$23(IMSessionStateMachine.this, (IdentityBuilderBlock) obj);
            }
        });
        $this$inState.condition(new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda31
            public final Object invoke(Object obj) {
                return Boolean.valueOf(IMSessionStateMachine.lambda$0$0$24((IMState) obj));
            }
        }, new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda32
            public final Object invoke(Object obj) {
                return IMSessionStateMachine.lambda$0$0$25(IMSessionStateMachine.this, (ConditionBuilderBlock) obj);
            }
        });
        $this$inState.condition(new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda34
            public final Object invoke(Object obj) {
                return Boolean.valueOf(IMSessionStateMachine.lambda$0$0$26(IMSessionStateMachine.this, (IMState) obj));
            }
        }, new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda35
            public final Object invoke(Object obj) {
                return IMSessionStateMachine.lambda$0$0$27(IMSessionStateMachine.this, (ConditionBuilderBlock) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean lambda$0$0$0(IMState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !(it.getType$session_debug() instanceof RequestStatus.Loading);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0$1(IMSessionStateMachine this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new IMSessionStateMachine$1$1$3$1(this$0, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(IMActionRequestInitial.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean lambda$0$0$2(IMState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (it.getType$session_debug() instanceof RequestStatus.Loading) && ((RequestStatus.Loading) it.getType$session_debug()).getRefreshList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0$3(final IMSessionStateMachine this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.untilIdentityChanges(new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                return IMSessionStateMachine.lambda$0$0$3$0((IMState) obj);
            }
        }, new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                return IMSessionStateMachine.lambda$0$0$3$1(IMSessionStateMachine.this, (IdentityBuilderBlock) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Object lambda$0$0$3$0(IMState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return IMSessionFilterKt.currentFilterType(it.getData().getFilters());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0$3$1(final IMSessionStateMachine this$0, IdentityBuilderBlock $this$untilIdentityChanges) {
        Intrinsics.checkNotNullParameter($this$untilIdentityChanges, "$this$untilIdentityChanges");
        BaseBuilderBlock.collectWhileInState$default((BaseBuilderBlock) $this$untilIdentityChanges, new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda51
            public final Object invoke(Object obj) {
                return IMSessionStateMachine.lambda$0$0$3$1$0(IMSessionStateMachine.this, (IMState) obj);
            }
        }, (ExecutionPolicy) null, new IMSessionStateMachine$1$1$5$2$2(this$0, null), 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Flow lambda$0$0$3$1$0(IMSessionStateMachine this$0, IMState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this$0.dataSourceService.load(this$0.pageType, it, it.getFirstLoad$session_debug());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean lambda$0$0$4(IMState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (it.getType$session_debug() instanceof RequestStatus.Loading) && !((RequestStatus.Loading) it.getType$session_debug()).getRefreshList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0$5(IMSessionStateMachine this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new IMSessionStateMachine$1$1$7$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Object lambda$0$0$6(IMState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getData();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0$7(IMSessionStateMachine this$0, IdentityBuilderBlock $this$untilIdentityChanges) {
        Intrinsics.checkNotNullParameter($this$untilIdentityChanges, "$this$untilIdentityChanges");
        $this$untilIdentityChanges.onEnterEffect(new IMSessionStateMachine$1$1$9$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean lambda$0$0$8(IMState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getType$session_debug() instanceof RequestStatus.Idle) {
            KPaginationParams paginationParams$session_debug = it.getData().getPaginationParams$session_debug();
            return paginationParams$session_debug != null && paginationParams$session_debug.getHasMore();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0$9(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new IMSessionStateMachine$1$1$11$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(IMActionRequestNext.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean lambda$0$0$10(IMState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getType$session_debug() instanceof RequestStatus.Error) {
            KPaginationParams paginationParams$session_debug = it.getData().getPaginationParams$session_debug();
            return paginationParams$session_debug != null && paginationParams$session_debug.getHasMore();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0$11(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new IMSessionStateMachine$1$1$13$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(IMActionRetryRequestNext.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean lambda$0$0$12(IMState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.isLoggedIn();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0$13(IMSessionStateMachine this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        this$0.sessionDeleteBlock((BaseBuilderBlock) $this$condition);
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new IMSessionStateMachine$1$1$15$1(this$0, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(IMActionSessionPin.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock.collectWhileInState$default((BaseBuilderBlock) $this$condition, new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda48
            public final Object invoke(Object obj) {
                return IMSessionStateMachine.lambda$0$0$13$0((IMState) obj);
            }
        }, (ExecutionPolicy) null, new IMSessionStateMachine$1$1$15$3(null), 2, (Object) null);
        this$0.updateBlock((BaseBuilderBlock) $this$condition);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv2 = new IMSessionStateMachine$1$1$15$4(this$0, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(IMActionClearUnread.class), executionPolicy$iv2, handler$iv2);
        this$0.sessionClickBlock((BaseBuilderBlock) $this$condition);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv3 = new IMSessionStateMachine$1$1$15$5(this$0, null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(IMActionClickThreeDotItem.class), executionPolicy$iv3, handler$iv3);
        BaseBuilderBlock $this$iv4 = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv4 = new IMSessionStateMachine$1$1$15$6(this$0, null);
        ExecutionPolicy executionPolicy$iv4 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv4.on(Reflection.getOrCreateKotlinClass(IMActionClickQuickLinkItem.class), executionPolicy$iv4, handler$iv4);
        BaseBuilderBlock $this$iv5 = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv5 = new IMSessionStateMachine$1$1$15$7(null);
        ExecutionPolicy executionPolicy$iv5 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv5.on(Reflection.getOrCreateKotlinClass(IMActionChangeFilter.class), executionPolicy$iv5, handler$iv5);
        this$0.clearSessionListBlock((BaseBuilderBlock) $this$condition);
        BaseBuilderBlock $this$iv6 = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv6 = new IMSessionStateMachine$1$1$15$8(this$0, null);
        ExecutionPolicy executionPolicy$iv6 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv6.on(Reflection.getOrCreateKotlinClass(IMActionUnBlockSession.class), executionPolicy$iv6, handler$iv6);
        BaseBuilderBlock.collectWhileInStateEffect$default((BaseBuilderBlock) $this$condition, new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda49
            public final Object invoke(Object obj) {
                return IMSessionStateMachine.lambda$0$0$13$1((IMState) obj);
            }
        }, (ExecutionPolicy) null, new IMSessionStateMachine$1$1$15$10(this$0, null), 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Flow lambda$0$0$13$0(IMState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return IMEventHub.INSTANCE.getSessionPinEventFlow();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Flow lambda$0$0$13$1(IMState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return IMEventHub.INSTANCE.getRefreshSessionsFlow();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean lambda$0$0$14(IMSessionStateMachine this$0, IMState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(this$0.pageType, KSessionPageType.SESSION_PAGE_TYPE_HOME.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0$15(IMSessionStateMachine this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new IMSessionStateMachine$1$1$20$1(this$0, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.onActionEffect(Reflection.getOrCreateKotlinClass(IMActionLogin.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean lambda$0$0$16(IMState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        KSessionListExtraInfo extraInfo = it.getData().getExtraInfo();
        return (extraInfo != null ? extraInfo.getAutoReplyToast() : null) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0$17(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new IMSessionStateMachine$1$1$22$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(IMActionDismissAutoReply.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean lambda$0$0$18(IMState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        KSessionListExtraInfo extraInfo = it.getData().getExtraInfo();
        return (extraInfo != null ? extraInfo.getBehaviorAlertToast() : null) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0$19(IMSessionStateMachine this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new IMSessionStateMachine$1$1$24$1(this$0, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.onActionEffect(Reflection.getOrCreateKotlinClass(IMActionDismissBehaviorAlert.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean lambda$0$0$20(IMState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        KSessionListExtraInfo extraInfo = it.getData().getExtraInfo();
        if ((extraInfo != null ? extraInfo.getBehaviorAlertToast() : null) == null) {
            KSessionListExtraInfo extraInfo2 = it.getData().getExtraInfo();
            return extraInfo2 != null && extraInfo2.getShowAntiHarassmentPopup();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0$21(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new IMSessionStateMachine$1$1$26$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(IMActionDismissBehaviorAlert.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Object lambda$0$0$22(IMState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getData().getAlert$session_debug();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0$23(IMSessionStateMachine this$0, IdentityBuilderBlock $this$untilIdentityChanges) {
        Intrinsics.checkNotNullParameter($this$untilIdentityChanges, "$this$untilIdentityChanges");
        $this$untilIdentityChanges.onEnterEffect(new IMSessionStateMachine$1$1$28$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean lambda$0$0$24(IMState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        IMQuickLink quickLinks = it.getData().getQuickLinks();
        return (quickLinks != null ? quickLinks.getBubble() : null) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0$25(IMSessionStateMachine this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new IMSessionStateMachine$1$1$30$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(IMActionDismissQuickLinkBubble.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv2 = new IMSessionStateMachine$1$1$30$2(this$0, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.onActionEffect(Reflection.getOrCreateKotlinClass(IMActionClickQuickLinkItem.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv3 = new IMSessionStateMachine$1$1$30$3(this$0, null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.onActionEffect(Reflection.getOrCreateKotlinClass(IMActionDismissQuickLinkBubble.class), executionPolicy$iv3, handler$iv3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean lambda$0$0$26(IMSessionStateMachine this$0, IMState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(this$0.pageType, KSessionPageType.SESSION_PAGE_TYPE_DUSTBIN.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0$27(IMSessionStateMachine this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new IMSessionStateMachine$1$1$32$1(this$0, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(IMActionClearSessionUnread.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    private final void sessionClickBlock(BaseBuilderBlock<IMState, IMState, IMAction> baseBuilderBlock) {
        Function3 handler$iv = new IMSessionStateMachine$sessionClickBlock$1(this, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        baseBuilderBlock.on(Reflection.getOrCreateKotlinClass(IMActionClickSessionCard.class), executionPolicy$iv, handler$iv);
        Function3 handler$iv2 = new IMSessionStateMachine$sessionClickBlock$2(this, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        baseBuilderBlock.on(Reflection.getOrCreateKotlinClass(IMActionPageRedisplay.class), executionPolicy$iv2, handler$iv2);
    }

    private final void updateBlock(BaseBuilderBlock<IMState, IMState, IMAction> baseBuilderBlock) {
        BaseBuilderBlock.collectWhileInStateEffect$default(baseBuilderBlock, new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Flow updateBlock$lambda$0;
                updateBlock$lambda$0 = IMSessionStateMachine.updateBlock$lambda$0((IMState) obj);
                return updateBlock$lambda$0;
            }
        }, (ExecutionPolicy) null, new IMSessionStateMachine$updateBlock$2(this, null), 2, (Object) null);
        Function3 handler$iv = new IMSessionStateMachine$updateBlock$3(this, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        baseBuilderBlock.on(Reflection.getOrCreateKotlinClass(IMActionRefreshSession.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock.collectWhileInState$default(baseBuilderBlock, new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Flow updateBlock$lambda$1;
                updateBlock$lambda$1 = IMSessionStateMachine.updateBlock$lambda$1(IMSessionStateMachine.this, (IMState) obj);
                return updateBlock$lambda$1;
            }
        }, (ExecutionPolicy) null, new IMSessionStateMachine$updateBlock$5(this, null), 2, (Object) null);
        Function3 handler$iv2 = new IMSessionStateMachine$updateBlock$6(this, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        baseBuilderBlock.on(Reflection.getOrCreateKotlinClass(IMActionUpdateList.class), executionPolicy$iv2, handler$iv2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow updateBlock$lambda$0(IMState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return IMEventHub.INSTANCE.getRefreshSessionFlow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow updateBlock$lambda$1(IMSessionStateMachine this$0, IMState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this$0.broadcastService.updateQuickLinkCommands();
    }

    private final void clearSessionListBlock(BaseBuilderBlock<IMState, IMState, IMAction> baseBuilderBlock) {
        Function3 handler$iv = new IMSessionStateMachine$clearSessionListBlock$1(this, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        baseBuilderBlock.on(Reflection.getOrCreateKotlinClass(IMActionClearAllSessions.class), executionPolicy$iv, handler$iv);
        Function3 handler$iv2 = new IMSessionStateMachine$clearSessionListBlock$2(null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        baseBuilderBlock.onActionEffect(Reflection.getOrCreateKotlinClass(IMActionClearAllSessionsSucceed.class), executionPolicy$iv2, handler$iv2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object markSessionAsRead(State<IMState> state, IMSessionCard session, Continuation<? super ChangedState<IMState>> continuation) {
        IMSessionStateMachine$markSessionAsRead$1 iMSessionStateMachine$markSessionAsRead$1;
        Object markSessionAsRead;
        if (continuation instanceof IMSessionStateMachine$markSessionAsRead$1) {
            iMSessionStateMachine$markSessionAsRead$1 = (IMSessionStateMachine$markSessionAsRead$1) continuation;
            if ((iMSessionStateMachine$markSessionAsRead$1.label & Integer.MIN_VALUE) != 0) {
                iMSessionStateMachine$markSessionAsRead$1.label -= Integer.MIN_VALUE;
                Object $result = iMSessionStateMachine$markSessionAsRead$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (iMSessionStateMachine$markSessionAsRead$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        iMSessionStateMachine$markSessionAsRead$1.L$0 = state;
                        iMSessionStateMachine$markSessionAsRead$1.L$1 = SpillingKt.nullOutSpilledVariable(session);
                        iMSessionStateMachine$markSessionAsRead$1.label = 1;
                        markSessionAsRead = markSessionAsRead((IMState) state.getSnapshot(), session, (Continuation<? super IMState>) iMSessionStateMachine$markSessionAsRead$1);
                        if (markSessionAsRead == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        IMSessionCard iMSessionCard = (IMSessionCard) iMSessionStateMachine$markSessionAsRead$1.L$1;
                        state = (State) iMSessionStateMachine$markSessionAsRead$1.L$0;
                        ResultKt.throwOnFailure($result);
                        markSessionAsRead = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                final IMState read = (IMState) markSessionAsRead;
                return state.mutate(new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda22
                    public final Object invoke(Object obj) {
                        IMState markSessionAsRead$lambda$0;
                        markSessionAsRead$lambda$0 = IMSessionStateMachine.markSessionAsRead$lambda$0(IMState.this, (IMState) obj);
                        return markSessionAsRead$lambda$0;
                    }
                });
            }
        }
        iMSessionStateMachine$markSessionAsRead$1 = new IMSessionStateMachine$markSessionAsRead$1(this, continuation);
        Object $result2 = iMSessionStateMachine$markSessionAsRead$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (iMSessionStateMachine$markSessionAsRead$1.label) {
        }
        final IMState read2 = (IMState) markSessionAsRead;
        return state.mutate(new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda22
            public final Object invoke(Object obj) {
                IMState markSessionAsRead$lambda$0;
                markSessionAsRead$lambda$0 = IMSessionStateMachine.markSessionAsRead$lambda$0(IMState.this, (IMState) obj);
                return markSessionAsRead$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMState markSessionAsRead$lambda$0(IMState $read, IMState $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        return $read;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0132  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00fc -> B:26:0x0108). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0119 -> B:28:0x0124). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object markSessionAsRead(IMState $this$markSessionAsRead, IMSessionCard session, Continuation<? super IMState> continuation) {
        IMSessionStateMachine$markSessionAsRead$3 iMSessionStateMachine$markSessionAsRead$3;
        IMSessionStateMachine iMSessionStateMachine;
        int $i$f$mapTo;
        Iterable $this$mapTo$iv$iv;
        IMSessionStateMachine iMSessionStateMachine2;
        Iterable $this$mapTo$iv$iv2;
        Iterator it;
        IMState $this$markSessionAsRead2;
        int $i$f$map;
        Collection destination$iv$iv;
        Object $result;
        Object obj;
        Continuation $completion;
        IMSessionStateMachine$markSessionAsRead$3 iMSessionStateMachine$markSessionAsRead$32;
        IMSessionCard session2;
        IMState $this$markSessionAsRead3;
        Iterable $this$map$iv;
        IMSessionCard iMSessionCard;
        Iterable $this$map$iv2;
        Collection destination$iv$iv2;
        IMSessionCard session3;
        int i2;
        Object $result2;
        IMState $this$markSessionAsRead4;
        Continuation $completion2;
        if (continuation instanceof IMSessionStateMachine$markSessionAsRead$3) {
            iMSessionStateMachine$markSessionAsRead$3 = (IMSessionStateMachine$markSessionAsRead$3) continuation;
            if ((iMSessionStateMachine$markSessionAsRead$3.label & Integer.MIN_VALUE) != 0) {
                iMSessionStateMachine$markSessionAsRead$3.label -= Integer.MIN_VALUE;
                iMSessionStateMachine = this;
                Object $result3 = iMSessionStateMachine$markSessionAsRead$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (iMSessionStateMachine$markSessionAsRead$3.label) {
                    case 0:
                        ResultKt.throwOnFailure($result3);
                        Iterable $this$map$iv3 = $this$markSessionAsRead.getData().getSessions();
                        Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                        $i$f$mapTo = 0;
                        $this$mapTo$iv$iv = $this$map$iv3;
                        iMSessionStateMachine2 = iMSessionStateMachine;
                        $this$mapTo$iv$iv2 = $this$map$iv3;
                        it = $this$map$iv3.iterator();
                        $this$markSessionAsRead2 = $this$markSessionAsRead;
                        $i$f$map = 0;
                        destination$iv$iv = destination$iv$iv3;
                        $result = $result3;
                        obj = coroutine_suspended;
                        $completion = continuation;
                        iMSessionStateMachine$markSessionAsRead$32 = iMSessionStateMachine$markSessionAsRead$3;
                        session2 = session;
                        break;
                    case 1:
                        i2 = iMSessionStateMachine$markSessionAsRead$3.I$2;
                        int $i$f$mapTo2 = iMSessionStateMachine$markSessionAsRead$3.I$1;
                        $i$f$map = iMSessionStateMachine$markSessionAsRead$3.I$0;
                        IMSessionCard iMSessionCard2 = (IMSessionCard) iMSessionStateMachine$markSessionAsRead$3.L$7;
                        Object obj2 = iMSessionStateMachine$markSessionAsRead$3.L$6;
                        it = (Iterator) iMSessionStateMachine$markSessionAsRead$3.L$5;
                        Collection destination$iv$iv4 = (Collection) iMSessionStateMachine$markSessionAsRead$3.L$4;
                        Iterable $this$mapTo$iv$iv3 = (Iterable) iMSessionStateMachine$markSessionAsRead$3.L$3;
                        IMSessionCard session4 = (IMSessionCard) iMSessionStateMachine$markSessionAsRead$3.L$1;
                        ResultKt.throwOnFailure($result3);
                        $this$map$iv = (Iterable) iMSessionStateMachine$markSessionAsRead$3.L$2;
                        session3 = session4;
                        $this$map$iv2 = $this$mapTo$iv$iv3;
                        destination$iv$iv = (Collection) iMSessionStateMachine$markSessionAsRead$3.L$8;
                        destination$iv$iv2 = destination$iv$iv4;
                        $i$f$mapTo = $i$f$mapTo2;
                        iMSessionStateMachine2 = iMSessionStateMachine;
                        $result2 = $result3;
                        obj = coroutine_suspended;
                        iMSessionStateMachine$markSessionAsRead$32 = iMSessionStateMachine$markSessionAsRead$3;
                        $this$markSessionAsRead4 = (IMState) iMSessionStateMachine$markSessionAsRead$3.L$0;
                        $completion2 = continuation;
                        IMSessionCard iMSessionCard3 = (IMSessionCard) $result3;
                        $this$markSessionAsRead3 = $this$markSessionAsRead4;
                        session2 = session3;
                        $completion = $completion2;
                        iMSessionCard = iMSessionCard3;
                        $result = $result2;
                        destination$iv$iv.add(iMSessionCard);
                        $this$markSessionAsRead2 = $this$markSessionAsRead3;
                        destination$iv$iv = destination$iv$iv2;
                        $this$mapTo$iv$iv2 = $this$map$iv2;
                        $this$mapTo$iv$iv = $this$map$iv;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (!it.hasNext()) {
                    Object item$iv$iv = it.next();
                    IMSessionCard s = (IMSessionCard) item$iv$iv;
                    Continuation $completion3 = $completion;
                    Object $result4 = $result;
                    if (Intrinsics.areEqual(s.getId(), session2 != null ? session2.getId() : null)) {
                        IMSummaryCacheService iMSummaryCacheService = iMSessionStateMachine2.summaryService;
                        iMSessionStateMachine$markSessionAsRead$32.L$0 = $this$markSessionAsRead2;
                        iMSessionStateMachine$markSessionAsRead$32.L$1 = session2;
                        iMSessionStateMachine$markSessionAsRead$32.L$2 = SpillingKt.nullOutSpilledVariable($this$mapTo$iv$iv);
                        iMSessionStateMachine$markSessionAsRead$32.L$3 = SpillingKt.nullOutSpilledVariable($this$mapTo$iv$iv2);
                        iMSessionStateMachine$markSessionAsRead$32.L$4 = destination$iv$iv;
                        iMSessionStateMachine$markSessionAsRead$32.L$5 = it;
                        iMSessionStateMachine$markSessionAsRead$32.L$6 = SpillingKt.nullOutSpilledVariable(item$iv$iv);
                        iMSessionStateMachine$markSessionAsRead$32.L$7 = SpillingKt.nullOutSpilledVariable(s);
                        iMSessionStateMachine$markSessionAsRead$32.L$8 = destination$iv$iv;
                        iMSessionStateMachine$markSessionAsRead$32.I$0 = $i$f$map;
                        iMSessionStateMachine$markSessionAsRead$32.I$1 = $i$f$mapTo;
                        iMSessionStateMachine$markSessionAsRead$32.I$2 = 0;
                        iMSessionStateMachine$markSessionAsRead$32.label = 1;
                        $result3 = iMSummaryCacheService.markAsRead(s, iMSessionStateMachine$markSessionAsRead$32);
                        if ($result3 == obj) {
                            return obj;
                        }
                        session3 = session2;
                        i2 = 0;
                        $this$map$iv = $this$mapTo$iv$iv;
                        $result2 = $result4;
                        $this$markSessionAsRead4 = $this$markSessionAsRead2;
                        $this$map$iv2 = $this$mapTo$iv$iv2;
                        $completion2 = $completion3;
                        destination$iv$iv2 = destination$iv$iv;
                        IMSessionCard iMSessionCard32 = (IMSessionCard) $result3;
                        $this$markSessionAsRead3 = $this$markSessionAsRead4;
                        session2 = session3;
                        $completion = $completion2;
                        iMSessionCard = iMSessionCard32;
                        $result = $result2;
                        destination$iv$iv.add(iMSessionCard);
                        $this$markSessionAsRead2 = $this$markSessionAsRead3;
                        destination$iv$iv = destination$iv$iv2;
                        $this$mapTo$iv$iv2 = $this$map$iv2;
                        $this$mapTo$iv$iv = $this$map$iv;
                        if (!it.hasNext()) {
                            final List sessions = IMSessionPageDataKt.uniqueAndSort((List) destination$iv$iv);
                            return CopyScopeKt.copy($this$markSessionAsRead2, new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda13
                                public final Object invoke(Object obj3) {
                                    Unit markSessionAsRead$lambda$2;
                                    markSessionAsRead$lambda$2 = IMSessionStateMachine.markSessionAsRead$lambda$2(sessions, (CopyScope) obj3);
                                    return markSessionAsRead$lambda$2;
                                }
                            });
                        }
                    } else {
                        $completion = $completion3;
                        $result = $result4;
                        $this$markSessionAsRead3 = $this$markSessionAsRead2;
                        $this$map$iv = $this$mapTo$iv$iv;
                        iMSessionCard = s;
                        $this$map$iv2 = $this$mapTo$iv$iv2;
                        destination$iv$iv2 = destination$iv$iv;
                        destination$iv$iv.add(iMSessionCard);
                        $this$markSessionAsRead2 = $this$markSessionAsRead3;
                        destination$iv$iv = destination$iv$iv2;
                        $this$mapTo$iv$iv2 = $this$map$iv2;
                        $this$mapTo$iv$iv = $this$map$iv;
                        if (!it.hasNext()) {
                        }
                    }
                }
            }
        }
        iMSessionStateMachine = this;
        iMSessionStateMachine$markSessionAsRead$3 = new IMSessionStateMachine$markSessionAsRead$3(iMSessionStateMachine, continuation);
        Object $result32 = iMSessionStateMachine$markSessionAsRead$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (iMSessionStateMachine$markSessionAsRead$3.label) {
        }
        if (!it.hasNext()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit markSessionAsRead$lambda$2(List $sessions, CopyScope $this$copy) {
        Intrinsics.checkNotNullParameter($this$copy, "$this$copy");
        $this$copy.set(IMSessionPageDataLensKt.getSessions(IMStateLensKt.getData(IMState.Companion)), $sessions);
        return Unit.INSTANCE;
    }

    private final void sessionDeleteBlock(BaseBuilderBlock<IMState, IMState, IMAction> baseBuilderBlock) {
        Function3 handler$iv = new IMSessionStateMachine$sessionDeleteBlock$1(this, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        baseBuilderBlock.on(Reflection.getOrCreateKotlinClass(IMActionSessionDelete.class), executionPolicy$iv, handler$iv);
        Function3 handler$iv2 = new IMSessionStateMachine$sessionDeleteBlock$2(null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        baseBuilderBlock.on(Reflection.getOrCreateKotlinClass(IMActionSessionDeleteConfirm.class), executionPolicy$iv2, handler$iv2);
        Function3 handler$iv3 = new IMSessionStateMachine$sessionDeleteBlock$3(this, null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        baseBuilderBlock.onActionEffect(Reflection.getOrCreateKotlinClass(IMActionSessionDeleteConfirm.class), executionPolicy$iv3, handler$iv3);
        Function3 handler$iv4 = new IMSessionStateMachine$sessionDeleteBlock$4(this, null);
        ExecutionPolicy executionPolicy$iv4 = ExecutionPolicy.CANCEL_PREVIOUS;
        baseBuilderBlock.on(Reflection.getOrCreateKotlinClass(IMActionSessionDeletePerform.class), executionPolicy$iv4, handler$iv4);
        BaseBuilderBlock.collectWhileInState$default(baseBuilderBlock, new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda47
            public final Object invoke(Object obj) {
                Flow sessionDeleteBlock$lambda$0;
                sessionDeleteBlock$lambda$0 = IMSessionStateMachine.sessionDeleteBlock$lambda$0((IMState) obj);
                return sessionDeleteBlock$lambda$0;
            }
        }, (ExecutionPolicy) null, new IMSessionStateMachine$sessionDeleteBlock$6(null), 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow sessionDeleteBlock$lambda$0(IMState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return IMEventHub.INSTANCE.getDeleteSessionFlow();
    }

    private final void summaryBlock(InStateBuilderBlock<IMState, IMState, IMAction> inStateBuilderBlock) {
        inStateBuilderBlock.condition(new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                boolean summaryBlock$lambda$0;
                summaryBlock$lambda$0 = IMSessionStateMachine.summaryBlock$lambda$0((IMState) obj);
                return Boolean.valueOf(summaryBlock$lambda$0);
            }
        }, new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit summaryBlock$lambda$1;
                summaryBlock$lambda$1 = IMSessionStateMachine.summaryBlock$lambda$1(IMSessionStateMachine.this, (ConditionBuilderBlock) obj);
                return summaryBlock$lambda$1;
            }
        });
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new IMSessionStateMachine$summaryBlock$3(this, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(IMUpdateSummary.class), executionPolicy$iv, handler$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean summaryBlock$lambda$0(IMState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !it.getData().isCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit summaryBlock$lambda$1(IMSessionStateMachine this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock.collectWhileInStateEffect$default((BaseBuilderBlock) $this$condition, this$0.summaryService.getAllDraftFlow$session_debug(), (ExecutionPolicy) null, new IMSessionStateMachine$summaryBlock$2$1(this$0, null), 2, (Object) null);
        return Unit.INSTANCE;
    }

    private final void broadcastBlock(InStateBuilderBlock<IMState, IMState, IMAction> inStateBuilderBlock) {
        BaseBuilderBlock.collectWhileInStateEffect$default((BaseBuilderBlock) inStateBuilderBlock, this.broadcastService.registerBroadcast(), (ExecutionPolicy) null, new IMSessionStateMachine$broadcastBlock$1(this, null), 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00f5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object receive(State<IMState> state, Object result, final boolean byNext, final boolean overrideQuickLink, Continuation<? super ChangedState<IMState>> continuation) {
        IMSessionStateMachine$receive$1 iMSessionStateMachine$receive$1;
        Object displayString$default;
        Throwable it;
        int i2;
        boolean overrideQuickLink2;
        boolean overrideQuickLink3;
        Object result2;
        Object create;
        final String errorString;
        State $this$receive = state;
        if (continuation instanceof IMSessionStateMachine$receive$1) {
            iMSessionStateMachine$receive$1 = (IMSessionStateMachine$receive$1) continuation;
            if ((iMSessionStateMachine$receive$1.label & Integer.MIN_VALUE) != 0) {
                iMSessionStateMachine$receive$1.label -= Integer.MIN_VALUE;
                Object $result = iMSessionStateMachine$receive$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (iMSessionStateMachine$receive$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Throwable it2 = Result.exceptionOrNull-impl(result);
                        if (it2 == null) {
                            final IMSessionPageData it3 = (IMSessionPageData) result;
                            return $this$receive.override(new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda6
                                public final Object invoke(Object obj) {
                                    IMState receive$lambda$0$0;
                                    receive$lambda$0$0 = IMSessionStateMachine.receive$lambda$0$0(IMSessionPageData.this, byNext, overrideQuickLink, (IMState) obj);
                                    return receive$lambda$0$0;
                                }
                            });
                        }
                        iMSessionStateMachine$receive$1.L$0 = $this$receive;
                        iMSessionStateMachine$receive$1.L$1 = SpillingKt.nullOutSpilledVariable(result);
                        iMSessionStateMachine$receive$1.L$2 = it2;
                        iMSessionStateMachine$receive$1.Z$0 = byNext;
                        iMSessionStateMachine$receive$1.Z$1 = overrideQuickLink;
                        iMSessionStateMachine$receive$1.I$0 = 0;
                        iMSessionStateMachine$receive$1.label = 1;
                        displayString$default = IMToastKt.toDisplayString$default(it2, null, null, iMSessionStateMachine$receive$1, 3, null);
                        if (displayString$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        it = it2;
                        i2 = 0;
                        overrideQuickLink2 = overrideQuickLink;
                        overrideQuickLink3 = byNext;
                        result2 = result;
                        String errorString2 = (String) displayString$default;
                        IMToast.Companion companion = IMToast.Companion;
                        iMSessionStateMachine$receive$1.L$0 = $this$receive;
                        iMSessionStateMachine$receive$1.L$1 = SpillingKt.nullOutSpilledVariable(result2);
                        iMSessionStateMachine$receive$1.L$2 = SpillingKt.nullOutSpilledVariable(it);
                        iMSessionStateMachine$receive$1.L$3 = errorString2;
                        iMSessionStateMachine$receive$1.Z$0 = overrideQuickLink3;
                        iMSessionStateMachine$receive$1.Z$1 = overrideQuickLink2;
                        iMSessionStateMachine$receive$1.I$0 = i2;
                        iMSessionStateMachine$receive$1.label = 2;
                        create = companion.create(it, (r12 & 2) != 0 ? "" : null, (r12 & 4) != 0 ? Clock.System.INSTANCE.now() : null, (r12 & 8) != 0 ? null : null, iMSessionStateMachine$receive$1);
                        if (create != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        errorString = errorString2;
                        final IMToast imToast = (IMToast) create;
                        return $this$receive.override(new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda7
                            public final Object invoke(Object obj) {
                                IMState receive$lambda$1$0;
                                receive$lambda$1$0 = IMSessionStateMachine.receive$lambda$1$0(errorString, imToast, (IMState) obj);
                                return receive$lambda$1$0;
                            }
                        });
                    case 1:
                        int i3 = iMSessionStateMachine$receive$1.I$0;
                        boolean overrideQuickLink4 = iMSessionStateMachine$receive$1.Z$1;
                        boolean byNext2 = iMSessionStateMachine$receive$1.Z$0;
                        Object result3 = iMSessionStateMachine$receive$1.L$1;
                        $this$receive = (State) iMSessionStateMachine$receive$1.L$0;
                        ResultKt.throwOnFailure($result);
                        overrideQuickLink2 = overrideQuickLink4;
                        i2 = i3;
                        it = (Throwable) iMSessionStateMachine$receive$1.L$2;
                        displayString$default = $result;
                        overrideQuickLink3 = byNext2;
                        result2 = result3;
                        String errorString22 = (String) displayString$default;
                        IMToast.Companion companion2 = IMToast.Companion;
                        iMSessionStateMachine$receive$1.L$0 = $this$receive;
                        iMSessionStateMachine$receive$1.L$1 = SpillingKt.nullOutSpilledVariable(result2);
                        iMSessionStateMachine$receive$1.L$2 = SpillingKt.nullOutSpilledVariable(it);
                        iMSessionStateMachine$receive$1.L$3 = errorString22;
                        iMSessionStateMachine$receive$1.Z$0 = overrideQuickLink3;
                        iMSessionStateMachine$receive$1.Z$1 = overrideQuickLink2;
                        iMSessionStateMachine$receive$1.I$0 = i2;
                        iMSessionStateMachine$receive$1.label = 2;
                        create = companion2.create(it, (r12 & 2) != 0 ? "" : null, (r12 & 4) != 0 ? Clock.System.INSTANCE.now() : null, (r12 & 8) != 0 ? null : null, iMSessionStateMachine$receive$1);
                        if (create != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        int i4 = iMSessionStateMachine$receive$1.I$0;
                        boolean z = iMSessionStateMachine$receive$1.Z$1;
                        boolean z2 = iMSessionStateMachine$receive$1.Z$0;
                        errorString = (String) iMSessionStateMachine$receive$1.L$3;
                        Throwable th = (Throwable) iMSessionStateMachine$receive$1.L$2;
                        Object obj = iMSessionStateMachine$receive$1.L$1;
                        $this$receive = (State) iMSessionStateMachine$receive$1.L$0;
                        ResultKt.throwOnFailure($result);
                        create = $result;
                        final IMToast imToast2 = (IMToast) create;
                        return $this$receive.override(new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda7
                            public final Object invoke(Object obj2) {
                                IMState receive$lambda$1$0;
                                receive$lambda$1$0 = IMSessionStateMachine.receive$lambda$1$0(errorString, imToast2, (IMState) obj2);
                                return receive$lambda$1$0;
                            }
                        });
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        iMSessionStateMachine$receive$1 = new IMSessionStateMachine$receive$1(this, continuation);
        Object $result2 = iMSessionStateMachine$receive$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (iMSessionStateMachine$receive$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object receive$default(IMSessionStateMachine iMSessionStateMachine, State state, Object obj, boolean z, boolean z2, Continuation continuation, int i2, Object obj2) {
        boolean z3;
        boolean z4;
        if ((i2 & 2) == 0) {
            z3 = z;
        } else {
            z3 = false;
        }
        if ((i2 & 4) == 0) {
            z4 = z2;
        } else {
            z4 = z3;
        }
        return iMSessionStateMachine.receive(state, obj, z3, z4, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMState receive$lambda$0$0(IMSessionPageData $it, boolean $byNext, boolean $overrideQuickLink, IMState $this$override) {
        IMSessionPageData newData;
        IMState copy;
        IMState copy2;
        Intrinsics.checkNotNullParameter($this$override, "$this$override");
        if (!$it.isCache()) {
            if ($byNext) {
                newData = $this$override.getData().append$session_debug($it);
            } else {
                newData = IMSessionPageData.copy$default($it, null, null, $overrideQuickLink ? $it.getQuickLinks() : $this$override.getData().getQuickLinks(), null, null, null, null, null, null, null, false, 2043, null);
            }
            copy = $this$override.copy((r18 & 1) != 0 ? $this$override.pageType : null, (r18 & 2) != 0 ? $this$override.data : newData, (r18 & 4) != 0 ? $this$override.toast : null, (r18 & 8) != 0 ? $this$override.isLoggedIn : false, (r18 & 16) != 0 ? $this$override.type : RequestStatus.Idle.INSTANCE, (r18 & 32) != 0 ? $this$override.clickedSession : null, (r18 & 64) != 0 ? $this$override.firstLoad : false, (r18 & 128) != 0 ? $this$override.techTrack : null);
            return copy;
        }
        copy2 = $this$override.copy((r18 & 1) != 0 ? $this$override.pageType : null, (r18 & 2) != 0 ? $this$override.data : $it, (r18 & 4) != 0 ? $this$override.toast : null, (r18 & 8) != 0 ? $this$override.isLoggedIn : false, (r18 & 16) != 0 ? $this$override.type : $this$override.getType$session_debug(), (r18 & 32) != 0 ? $this$override.clickedSession : null, (r18 & 64) != 0 ? $this$override.firstLoad : false, (r18 & 128) != 0 ? $this$override.techTrack : null);
        return copy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMState receive$lambda$1$0(String $errorString, IMToast $imToast, IMState $this$override) {
        IMState copy;
        IMState copy2;
        Intrinsics.checkNotNullParameter($this$override, "$this$override");
        if ($this$override.getData().isCache()) {
            copy2 = $this$override.copy((r18 & 1) != 0 ? $this$override.pageType : null, (r18 & 2) != 0 ? $this$override.data : $this$override.getData(), (r18 & 4) != 0 ? $this$override.toast : $imToast, (r18 & 8) != 0 ? $this$override.isLoggedIn : false, (r18 & 16) != 0 ? $this$override.type : new RequestStatus.Error($errorString), (r18 & 32) != 0 ? $this$override.clickedSession : null, (r18 & 64) != 0 ? $this$override.firstLoad : false, (r18 & 128) != 0 ? $this$override.techTrack : null);
            return copy2;
        }
        copy = $this$override.copy((r18 & 1) != 0 ? $this$override.pageType : null, (r18 & 2) != 0 ? $this$override.data : $this$override.getData(), (r18 & 4) != 0 ? $this$override.toast : null, (r18 & 8) != 0 ? $this$override.isLoggedIn : false, (r18 & 16) != 0 ? $this$override.type : new RequestStatus.Error($errorString), (r18 & 32) != 0 ? $this$override.clickedSession : null, (r18 & 64) != 0 ? $this$override.firstLoad : false, (r18 & 128) != 0 ? $this$override.techTrack : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object pinOrNot(State<IMState> state, final IMSessionCard session, Continuation<? super ChangedState<IMState>> continuation) {
        Continuation<? super Result<PinResult>> iMSessionStateMachine$pinOrNot$1;
        Object m3353pinOrNotgIAlus;
        Throwable it;
        Object create;
        if (continuation instanceof IMSessionStateMachine$pinOrNot$1) {
            iMSessionStateMachine$pinOrNot$1 = (IMSessionStateMachine$pinOrNot$1) continuation;
            if ((iMSessionStateMachine$pinOrNot$1.label & Integer.MIN_VALUE) != 0) {
                iMSessionStateMachine$pinOrNot$1.label -= Integer.MIN_VALUE;
                Object $result = iMSessionStateMachine$pinOrNot$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (iMSessionStateMachine$pinOrNot$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        IMSessionCardEventService iMSessionCardEventService = this.sessionEventService;
                        iMSessionStateMachine$pinOrNot$1.L$0 = state;
                        iMSessionStateMachine$pinOrNot$1.L$1 = session;
                        iMSessionStateMachine$pinOrNot$1.label = 1;
                        m3353pinOrNotgIAlus = iMSessionCardEventService.m3353pinOrNotgIAlus(session, iMSessionStateMachine$pinOrNot$1);
                        if (m3353pinOrNotgIAlus == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        it = Result.exceptionOrNull-impl(m3353pinOrNotgIAlus);
                        if (it != null) {
                            final PinResult it2 = (PinResult) m3353pinOrNotgIAlus;
                            return state.mutate(new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda10
                                public final Object invoke(Object obj) {
                                    IMState pinOrNot$lambda$0$0;
                                    pinOrNot$lambda$0$0 = IMSessionStateMachine.pinOrNot$lambda$0$0(IMSessionCard.this, it2, (IMState) obj);
                                    return pinOrNot$lambda$0$0;
                                }
                            });
                        }
                        IMToast.Companion companion = IMToast.Companion;
                        iMSessionStateMachine$pinOrNot$1.L$0 = state;
                        iMSessionStateMachine$pinOrNot$1.L$1 = SpillingKt.nullOutSpilledVariable(session);
                        iMSessionStateMachine$pinOrNot$1.L$2 = SpillingKt.nullOutSpilledVariable(it);
                        iMSessionStateMachine$pinOrNot$1.I$0 = 0;
                        iMSessionStateMachine$pinOrNot$1.label = 2;
                        create = companion.create(it, (r12 & 2) != 0 ? "" : null, (r12 & 4) != 0 ? Clock.System.INSTANCE.now() : null, (r12 & 8) != 0 ? null : null, iMSessionStateMachine$pinOrNot$1);
                        if (create == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        final IMToast imToast = (IMToast) create;
                        return state.mutate(new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda12
                            public final Object invoke(Object obj) {
                                IMState pinOrNot$lambda$1$0;
                                pinOrNot$lambda$1$0 = IMSessionStateMachine.pinOrNot$lambda$1$0(IMToast.this, (IMState) obj);
                                return pinOrNot$lambda$1$0;
                            }
                        });
                    case 1:
                        session = (IMSessionCard) iMSessionStateMachine$pinOrNot$1.L$1;
                        state = (State) iMSessionStateMachine$pinOrNot$1.L$0;
                        ResultKt.throwOnFailure($result);
                        m3353pinOrNotgIAlus = ((Result) $result).unbox-impl();
                        it = Result.exceptionOrNull-impl(m3353pinOrNotgIAlus);
                        if (it != null) {
                        }
                        break;
                    case 2:
                        int i2 = iMSessionStateMachine$pinOrNot$1.I$0;
                        Throwable th = (Throwable) iMSessionStateMachine$pinOrNot$1.L$2;
                        IMSessionCard iMSessionCard = (IMSessionCard) iMSessionStateMachine$pinOrNot$1.L$1;
                        state = (State) iMSessionStateMachine$pinOrNot$1.L$0;
                        ResultKt.throwOnFailure($result);
                        create = $result;
                        final IMToast imToast2 = (IMToast) create;
                        return state.mutate(new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda12
                            public final Object invoke(Object obj) {
                                IMState pinOrNot$lambda$1$0;
                                pinOrNot$lambda$1$0 = IMSessionStateMachine.pinOrNot$lambda$1$0(IMToast.this, (IMState) obj);
                                return pinOrNot$lambda$1$0;
                            }
                        });
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        iMSessionStateMachine$pinOrNot$1 = new IMSessionStateMachine$pinOrNot$1(this, continuation);
        Object $result2 = iMSessionStateMachine$pinOrNot$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (iMSessionStateMachine$pinOrNot$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMState pinOrNot$lambda$0$0(IMSessionCard $session, PinResult $it, IMState $this$mutate) {
        IMState copy;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        copy = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.pageType : null, (r18 & 2) != 0 ? $this$mutate.data : $this$mutate.getData().pinOrNot$session_debug($session, $it), (r18 & 4) != 0 ? $this$mutate.toast : null, (r18 & 8) != 0 ? $this$mutate.isLoggedIn : false, (r18 & 16) != 0 ? $this$mutate.type : null, (r18 & 32) != 0 ? $this$mutate.clickedSession : null, (r18 & 64) != 0 ? $this$mutate.firstLoad : false, (r18 & 128) != 0 ? $this$mutate.techTrack : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMState pinOrNot$lambda$1$0(IMToast $imToast, IMState $this$mutate) {
        IMState copy;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        copy = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.pageType : null, (r18 & 2) != 0 ? $this$mutate.data : null, (r18 & 4) != 0 ? $this$mutate.toast : $imToast, (r18 & 8) != 0 ? $this$mutate.isLoggedIn : false, (r18 & 16) != 0 ? $this$mutate.type : null, (r18 & 32) != 0 ? $this$mutate.clickedSession : null, (r18 & 64) != 0 ? $this$mutate.firstLoad : false, (r18 & 128) != 0 ? $this$mutate.techTrack : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object clearUnread(State<IMState> state, Continuation<? super ChangedState<IMState>> continuation) {
        Continuation<? super IMSessionPageData> iMSessionStateMachine$clearUnread$1;
        Object m3343clearUnreadgIAlus;
        Throwable it;
        Object create;
        Object readActionToast;
        Unit it2;
        int i2;
        Object clearAllUnread$session_debug;
        final String toastString;
        if (continuation instanceof IMSessionStateMachine$clearUnread$1) {
            iMSessionStateMachine$clearUnread$1 = (IMSessionStateMachine$clearUnread$1) continuation;
            if ((iMSessionStateMachine$clearUnread$1.label & Integer.MIN_VALUE) != 0) {
                iMSessionStateMachine$clearUnread$1.label -= Integer.MIN_VALUE;
                Object $result = iMSessionStateMachine$clearUnread$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (iMSessionStateMachine$clearUnread$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        IMClearUnreadService iMClearUnreadService = this.clearUnreadService;
                        KSessionPageType kSessionPageType = this.pageType;
                        iMSessionStateMachine$clearUnread$1.L$0 = state;
                        iMSessionStateMachine$clearUnread$1.label = 1;
                        m3343clearUnreadgIAlus = iMClearUnreadService.m3343clearUnreadgIAlus(kSessionPageType, iMSessionStateMachine$clearUnread$1);
                        if (m3343clearUnreadgIAlus == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        it = Result.exceptionOrNull-impl(m3343clearUnreadgIAlus);
                        if (it == null) {
                            IMToast.Companion companion = IMToast.Companion;
                            iMSessionStateMachine$clearUnread$1.L$0 = state;
                            iMSessionStateMachine$clearUnread$1.L$1 = SpillingKt.nullOutSpilledVariable(it);
                            iMSessionStateMachine$clearUnread$1.I$0 = 0;
                            iMSessionStateMachine$clearUnread$1.label = 4;
                            create = companion.create(it, (r12 & 2) != 0 ? "" : null, (r12 & 4) != 0 ? Clock.System.INSTANCE.now() : null, (r12 & 8) != 0 ? null : null, iMSessionStateMachine$clearUnread$1);
                            if (create == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            final IMToast imToast = (IMToast) create;
                            return state.mutate(new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda46
                                public final Object invoke(Object obj) {
                                    IMState clearUnread$lambda$1$0;
                                    clearUnread$lambda$1$0 = IMSessionStateMachine.clearUnread$lambda$1$0(IMToast.this, (IMState) obj);
                                    return clearUnread$lambda$1$0;
                                }
                            });
                        }
                        Unit it3 = (Unit) m3343clearUnreadgIAlus;
                        iMSessionStateMachine$clearUnread$1.L$0 = state;
                        iMSessionStateMachine$clearUnread$1.L$1 = SpillingKt.nullOutSpilledVariable(it3);
                        iMSessionStateMachine$clearUnread$1.I$0 = 0;
                        iMSessionStateMachine$clearUnread$1.label = 2;
                        readActionToast = IMMessageSummaryServiceKt.getReadActionToast(iMSessionStateMachine$clearUnread$1);
                        if (readActionToast == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        it2 = it3;
                        i2 = 0;
                        String toastString2 = (String) readActionToast;
                        IMSessionPageData data = ((IMState) state.getSnapshot()).getData();
                        IMSummaryCacheService iMSummaryCacheService = this.summaryService;
                        iMSessionStateMachine$clearUnread$1.L$0 = state;
                        iMSessionStateMachine$clearUnread$1.L$1 = SpillingKt.nullOutSpilledVariable(it2);
                        iMSessionStateMachine$clearUnread$1.L$2 = toastString2;
                        iMSessionStateMachine$clearUnread$1.I$0 = i2;
                        iMSessionStateMachine$clearUnread$1.label = 3;
                        clearAllUnread$session_debug = data.clearAllUnread$session_debug(iMSummaryCacheService, iMSessionStateMachine$clearUnread$1);
                        if (clearAllUnread$session_debug != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        toastString = toastString2;
                        final IMSessionPageData data2 = (IMSessionPageData) clearAllUnread$session_debug;
                        return state.mutate(new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda45
                            public final Object invoke(Object obj) {
                                IMState clearUnread$lambda$0$0;
                                clearUnread$lambda$0$0 = IMSessionStateMachine.clearUnread$lambda$0$0(IMSessionPageData.this, toastString, (IMState) obj);
                                return clearUnread$lambda$0$0;
                            }
                        });
                    case 1:
                        state = (State) iMSessionStateMachine$clearUnread$1.L$0;
                        ResultKt.throwOnFailure($result);
                        m3343clearUnreadgIAlus = ((Result) $result).unbox-impl();
                        it = Result.exceptionOrNull-impl(m3343clearUnreadgIAlus);
                        if (it == null) {
                        }
                        break;
                    case 2:
                        i2 = iMSessionStateMachine$clearUnread$1.I$0;
                        it2 = (Unit) iMSessionStateMachine$clearUnread$1.L$1;
                        state = (State) iMSessionStateMachine$clearUnread$1.L$0;
                        ResultKt.throwOnFailure($result);
                        readActionToast = $result;
                        String toastString22 = (String) readActionToast;
                        IMSessionPageData data3 = ((IMState) state.getSnapshot()).getData();
                        IMSummaryCacheService iMSummaryCacheService2 = this.summaryService;
                        iMSessionStateMachine$clearUnread$1.L$0 = state;
                        iMSessionStateMachine$clearUnread$1.L$1 = SpillingKt.nullOutSpilledVariable(it2);
                        iMSessionStateMachine$clearUnread$1.L$2 = toastString22;
                        iMSessionStateMachine$clearUnread$1.I$0 = i2;
                        iMSessionStateMachine$clearUnread$1.label = 3;
                        clearAllUnread$session_debug = data3.clearAllUnread$session_debug(iMSummaryCacheService2, iMSessionStateMachine$clearUnread$1);
                        if (clearAllUnread$session_debug != coroutine_suspended) {
                        }
                        break;
                    case 3:
                        int i3 = iMSessionStateMachine$clearUnread$1.I$0;
                        toastString = (String) iMSessionStateMachine$clearUnread$1.L$2;
                        Unit unit = (Unit) iMSessionStateMachine$clearUnread$1.L$1;
                        state = (State) iMSessionStateMachine$clearUnread$1.L$0;
                        ResultKt.throwOnFailure($result);
                        clearAllUnread$session_debug = $result;
                        final IMSessionPageData data22 = (IMSessionPageData) clearAllUnread$session_debug;
                        return state.mutate(new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda45
                            public final Object invoke(Object obj) {
                                IMState clearUnread$lambda$0$0;
                                clearUnread$lambda$0$0 = IMSessionStateMachine.clearUnread$lambda$0$0(IMSessionPageData.this, toastString, (IMState) obj);
                                return clearUnread$lambda$0$0;
                            }
                        });
                    case 4:
                        int i4 = iMSessionStateMachine$clearUnread$1.I$0;
                        Throwable th = (Throwable) iMSessionStateMachine$clearUnread$1.L$1;
                        state = (State) iMSessionStateMachine$clearUnread$1.L$0;
                        ResultKt.throwOnFailure($result);
                        create = $result;
                        final IMToast imToast2 = (IMToast) create;
                        return state.mutate(new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda46
                            public final Object invoke(Object obj) {
                                IMState clearUnread$lambda$1$0;
                                clearUnread$lambda$1$0 = IMSessionStateMachine.clearUnread$lambda$1$0(IMToast.this, (IMState) obj);
                                return clearUnread$lambda$1$0;
                            }
                        });
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        iMSessionStateMachine$clearUnread$1 = new IMSessionStateMachine$clearUnread$1(this, continuation);
        Object $result2 = iMSessionStateMachine$clearUnread$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (iMSessionStateMachine$clearUnread$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMState clearUnread$lambda$0$0(IMSessionPageData $data, String $toastString, IMState $this$mutate) {
        IMState copy;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        copy = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.pageType : null, (r18 & 2) != 0 ? $this$mutate.data : $data, (r18 & 4) != 0 ? $this$mutate.toast : IMToast.Companion.create$default(IMToast.Companion, $toastString, null, 2, null), (r18 & 8) != 0 ? $this$mutate.isLoggedIn : false, (r18 & 16) != 0 ? $this$mutate.type : null, (r18 & 32) != 0 ? $this$mutate.clickedSession : null, (r18 & 64) != 0 ? $this$mutate.firstLoad : false, (r18 & 128) != 0 ? $this$mutate.techTrack : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMState clearUnread$lambda$1$0(IMToast $imToast, IMState $this$mutate) {
        IMState copy;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        copy = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.pageType : null, (r18 & 2) != 0 ? $this$mutate.data : null, (r18 & 4) != 0 ? $this$mutate.toast : $imToast, (r18 & 8) != 0 ? $this$mutate.isLoggedIn : false, (r18 & 16) != 0 ? $this$mutate.type : null, (r18 & 32) != 0 ? $this$mutate.clickedSession : null, (r18 & 64) != 0 ? $this$mutate.firstLoad : false, (r18 & 128) != 0 ? $this$mutate.techTrack : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0252  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x012c -> B:44:0x024d). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x018c -> B:44:0x024d). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x021b -> B:40:0x022b). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x0244 -> B:44:0x024d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object broadcastReceived(KReqServerNotify notify, IMState state, Continuation<? super Unit> continuation) {
        IMSessionStateMachine$broadcastReceived$1 iMSessionStateMachine$broadcastReceived$1;
        IMSessionStateMachine iMSessionStateMachine;
        IMSessionStateMachine iMSessionStateMachine2;
        Iterable $this$forEach$iv;
        Iterator it;
        Object $result;
        int $i$f$forEach;
        Continuation $completion;
        Object obj;
        KReqServerNotify notify2;
        IMSessionStateMachine$broadcastReceived$1 iMSessionStateMachine$broadcastReceived$12;
        IMState state2;
        int i2;
        int $i$f$forEach2;
        Object element$iv;
        Iterable element$iv2;
        KReqServerNotify notify3;
        IMState state3;
        int i3;
        int $i$f$forEach3;
        Object element$iv3;
        Iterable element$iv4;
        KReqServerNotify notify4;
        IMState state4;
        Object $result2;
        Object obj2;
        IMSessionStateMachine iMSessionStateMachine3;
        KReqServerNotify notify5;
        IMState state5;
        int i4;
        Continuation $completion2 = continuation;
        if ($completion2 instanceof IMSessionStateMachine$broadcastReceived$1) {
            iMSessionStateMachine$broadcastReceived$1 = (IMSessionStateMachine$broadcastReceived$1) $completion2;
            if ((iMSessionStateMachine$broadcastReceived$1.label & Integer.MIN_VALUE) != 0) {
                iMSessionStateMachine$broadcastReceived$1.label -= Integer.MIN_VALUE;
                iMSessionStateMachine = this;
                Object $result3 = iMSessionStateMachine$broadcastReceived$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (iMSessionStateMachine$broadcastReceived$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result3);
                        Iterable $this$forEach$iv2 = notify.getCommandMsgs();
                        iMSessionStateMachine2 = iMSessionStateMachine;
                        $this$forEach$iv = $this$forEach$iv2;
                        it = $this$forEach$iv2.iterator();
                        $result = $result3;
                        $i$f$forEach = 0;
                        $completion = $completion2;
                        obj = coroutine_suspended;
                        notify2 = notify;
                        iMSessionStateMachine$broadcastReceived$12 = iMSessionStateMachine$broadcastReceived$1;
                        state2 = state;
                        break;
                    case 1:
                        i2 = iMSessionStateMachine$broadcastReceived$1.I$1;
                        $i$f$forEach2 = iMSessionStateMachine$broadcastReceived$1.I$0;
                        KCommandMsg.ICommand iCommand = (KCommandMsg.ICommand) iMSessionStateMachine$broadcastReceived$1.L$6;
                        KCommandMsg kCommandMsg = (KCommandMsg) iMSessionStateMachine$broadcastReceived$1.L$5;
                        element$iv = iMSessionStateMachine$broadcastReceived$1.L$4;
                        element$iv2 = (Iterable) iMSessionStateMachine$broadcastReceived$1.L$2;
                        IMState state6 = (IMState) iMSessionStateMachine$broadcastReceived$1.L$1;
                        notify3 = (KReqServerNotify) iMSessionStateMachine$broadcastReceived$1.L$0;
                        ResultKt.throwOnFailure($result3);
                        iMSessionStateMachine2 = iMSessionStateMachine;
                        state3 = state6;
                        it = (Iterator) iMSessionStateMachine$broadcastReceived$1.L$3;
                        $i$f$forEach = $i$f$forEach2;
                        obj = coroutine_suspended;
                        iMSessionStateMachine$broadcastReceived$12 = iMSessionStateMachine$broadcastReceived$1;
                        state2 = state3;
                        Object obj3 = $result3;
                        $completion = $completion2;
                        notify2 = notify3;
                        $this$forEach$iv = element$iv2;
                        $result = obj3;
                        break;
                    case 2:
                        i3 = iMSessionStateMachine$broadcastReceived$1.I$1;
                        $i$f$forEach3 = iMSessionStateMachine$broadcastReceived$1.I$0;
                        KCommandMsg.ICommand iCommand2 = (KCommandMsg.ICommand) iMSessionStateMachine$broadcastReceived$1.L$6;
                        KCommandMsg kCommandMsg2 = (KCommandMsg) iMSessionStateMachine$broadcastReceived$1.L$5;
                        element$iv3 = iMSessionStateMachine$broadcastReceived$1.L$4;
                        element$iv4 = (Iterable) iMSessionStateMachine$broadcastReceived$1.L$2;
                        IMState state7 = (IMState) iMSessionStateMachine$broadcastReceived$1.L$1;
                        notify4 = (KReqServerNotify) iMSessionStateMachine$broadcastReceived$1.L$0;
                        ResultKt.throwOnFailure($result3);
                        iMSessionStateMachine2 = iMSessionStateMachine;
                        state4 = state7;
                        it = (Iterator) iMSessionStateMachine$broadcastReceived$1.L$3;
                        $i$f$forEach = $i$f$forEach3;
                        obj = coroutine_suspended;
                        iMSessionStateMachine$broadcastReceived$12 = iMSessionStateMachine$broadcastReceived$1;
                        state2 = state4;
                        Object obj4 = $result3;
                        $completion = $completion2;
                        notify2 = notify4;
                        $this$forEach$iv = element$iv4;
                        $result = obj4;
                        break;
                    case 3:
                        int i5 = iMSessionStateMachine$broadcastReceived$1.I$2;
                        i4 = iMSessionStateMachine$broadcastReceived$1.I$1;
                        $i$f$forEach = iMSessionStateMachine$broadcastReceived$1.I$0;
                        KSessionId kSessionId = (KSessionId) iMSessionStateMachine$broadcastReceived$1.L$7;
                        KCommandMsg.ICommand iCommand3 = (KCommandMsg.ICommand) iMSessionStateMachine$broadcastReceived$1.L$6;
                        KCommandMsg kCommandMsg3 = (KCommandMsg) iMSessionStateMachine$broadcastReceived$1.L$5;
                        Object obj5 = iMSessionStateMachine$broadcastReceived$1.L$4;
                        it = (Iterator) iMSessionStateMachine$broadcastReceived$1.L$3;
                        $this$forEach$iv = (Iterable) iMSessionStateMachine$broadcastReceived$1.L$2;
                        state5 = (IMState) iMSessionStateMachine$broadcastReceived$1.L$1;
                        notify5 = (KReqServerNotify) iMSessionStateMachine$broadcastReceived$1.L$0;
                        ResultKt.throwOnFailure($result3);
                        iMSessionStateMachine2 = iMSessionStateMachine;
                        $result = $result3;
                        $completion = $completion2;
                        obj = coroutine_suspended;
                        notify2 = notify5;
                        iMSessionStateMachine$broadcastReceived$12 = iMSessionStateMachine$broadcastReceived$1;
                        state2 = state5;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (!it.hasNext()) {
                    Object element$iv5 = it.next();
                    KCommandMsg it2 = (KCommandMsg) element$iv5;
                    KCommandMsg.KUpdateSessionOneCommand command = it2.getCommand();
                    if (command instanceof KCommandMsg.KUpdateQuickLinkCommand) {
                        Continuation $completion3 = $completion;
                        IMLog.Companion.i(iMSessionStateMachine2.sessionLogTag, "收到更新金刚位的长链消息");
                        IMActionUpdateQuickLink iMActionUpdateQuickLink = IMActionUpdateQuickLink.INSTANCE;
                        iMSessionStateMachine$broadcastReceived$12.L$0 = SpillingKt.nullOutSpilledVariable(notify2);
                        iMSessionStateMachine$broadcastReceived$12.L$1 = state2;
                        iMSessionStateMachine$broadcastReceived$12.L$2 = SpillingKt.nullOutSpilledVariable($this$forEach$iv);
                        iMSessionStateMachine$broadcastReceived$12.L$3 = it;
                        iMSessionStateMachine$broadcastReceived$12.L$4 = SpillingKt.nullOutSpilledVariable(element$iv5);
                        iMSessionStateMachine$broadcastReceived$12.L$5 = SpillingKt.nullOutSpilledVariable(it2);
                        iMSessionStateMachine$broadcastReceived$12.L$6 = SpillingKt.nullOutSpilledVariable(command);
                        iMSessionStateMachine$broadcastReceived$12.L$7 = null;
                        iMSessionStateMachine$broadcastReceived$12.I$0 = $i$f$forEach;
                        iMSessionStateMachine$broadcastReceived$12.I$1 = 0;
                        iMSessionStateMachine$broadcastReceived$12.label = 1;
                        if (iMSessionStateMachine2.dispatch(iMActionUpdateQuickLink, iMSessionStateMachine$broadcastReceived$12) == obj) {
                            return obj;
                        }
                        state3 = state2;
                        iMSessionStateMachine$broadcastReceived$1 = iMSessionStateMachine$broadcastReceived$12;
                        $result3 = $result;
                        coroutine_suspended = obj;
                        $i$f$forEach2 = $i$f$forEach;
                        i2 = 0;
                        element$iv = element$iv5;
                        element$iv2 = $this$forEach$iv;
                        notify3 = notify2;
                        $completion2 = $completion3;
                        $i$f$forEach = $i$f$forEach2;
                        obj = coroutine_suspended;
                        iMSessionStateMachine$broadcastReceived$12 = iMSessionStateMachine$broadcastReceived$1;
                        state2 = state3;
                        Object obj32 = $result3;
                        $completion = $completion2;
                        notify2 = notify3;
                        $this$forEach$iv = element$iv2;
                        $result = obj32;
                        if (!it.hasNext()) {
                            return Unit.INSTANCE;
                        }
                    } else {
                        Continuation $completion4 = $completion;
                        if (command instanceof KCommandMsg.KUpdateSessionListCommand) {
                            IMLog.Companion.i(iMSessionStateMachine2.sessionLogTag, "收到更新会话列表的长链消息");
                            IMActionUpdateList iMActionUpdateList = IMActionUpdateList.INSTANCE;
                            iMSessionStateMachine$broadcastReceived$12.L$0 = SpillingKt.nullOutSpilledVariable(notify2);
                            iMSessionStateMachine$broadcastReceived$12.L$1 = state2;
                            iMSessionStateMachine$broadcastReceived$12.L$2 = SpillingKt.nullOutSpilledVariable($this$forEach$iv);
                            iMSessionStateMachine$broadcastReceived$12.L$3 = it;
                            iMSessionStateMachine$broadcastReceived$12.L$4 = SpillingKt.nullOutSpilledVariable(element$iv5);
                            iMSessionStateMachine$broadcastReceived$12.L$5 = SpillingKt.nullOutSpilledVariable(it2);
                            iMSessionStateMachine$broadcastReceived$12.L$6 = SpillingKt.nullOutSpilledVariable(command);
                            iMSessionStateMachine$broadcastReceived$12.L$7 = null;
                            iMSessionStateMachine$broadcastReceived$12.I$0 = $i$f$forEach;
                            iMSessionStateMachine$broadcastReceived$12.I$1 = 0;
                            iMSessionStateMachine$broadcastReceived$12.label = 2;
                            if (iMSessionStateMachine2.dispatch(iMActionUpdateList, iMSessionStateMachine$broadcastReceived$12) == obj) {
                                return obj;
                            }
                            state4 = state2;
                            iMSessionStateMachine$broadcastReceived$1 = iMSessionStateMachine$broadcastReceived$12;
                            $result3 = $result;
                            coroutine_suspended = obj;
                            $i$f$forEach3 = $i$f$forEach;
                            i3 = 0;
                            element$iv3 = element$iv5;
                            element$iv4 = $this$forEach$iv;
                            notify4 = notify2;
                            $completion2 = $completion4;
                            $i$f$forEach = $i$f$forEach3;
                            obj = coroutine_suspended;
                            iMSessionStateMachine$broadcastReceived$12 = iMSessionStateMachine$broadcastReceived$1;
                            state2 = state4;
                            Object obj42 = $result3;
                            $completion = $completion2;
                            notify2 = notify4;
                            $this$forEach$iv = element$iv4;
                            $result = obj42;
                            if (!it.hasNext()) {
                            }
                        } else {
                            if (command instanceof KCommandMsg.KUpdateSessionOneCommand) {
                                KSessionId sessionId = command.getValue().getSessionId();
                                if (sessionId != null) {
                                    Object $result4 = $result;
                                    Object obj6 = obj;
                                    IMSessionStateMachine iMSessionStateMachine4 = iMSessionStateMachine2;
                                    IMLog.Companion.i(iMSessionStateMachine2.sessionLogTag, "收到单个会话更新的长链消息 " + sessionId);
                                    IMActionRefreshSession iMActionRefreshSession = new IMActionRefreshSession(sessionId, IMSessionFilterKt.currentFilterType(state2.getData().getFilters()));
                                    iMSessionStateMachine$broadcastReceived$12.L$0 = SpillingKt.nullOutSpilledVariable(notify2);
                                    iMSessionStateMachine$broadcastReceived$12.L$1 = state2;
                                    iMSessionStateMachine$broadcastReceived$12.L$2 = SpillingKt.nullOutSpilledVariable($this$forEach$iv);
                                    iMSessionStateMachine$broadcastReceived$12.L$3 = it;
                                    iMSessionStateMachine$broadcastReceived$12.L$4 = SpillingKt.nullOutSpilledVariable(element$iv5);
                                    iMSessionStateMachine$broadcastReceived$12.L$5 = SpillingKt.nullOutSpilledVariable(it2);
                                    iMSessionStateMachine$broadcastReceived$12.L$6 = SpillingKt.nullOutSpilledVariable(command);
                                    iMSessionStateMachine$broadcastReceived$12.L$7 = SpillingKt.nullOutSpilledVariable(sessionId);
                                    iMSessionStateMachine$broadcastReceived$12.I$0 = $i$f$forEach;
                                    iMSessionStateMachine$broadcastReceived$12.I$1 = 0;
                                    iMSessionStateMachine$broadcastReceived$12.I$2 = 0;
                                    iMSessionStateMachine$broadcastReceived$12.label = 3;
                                    if (iMSessionStateMachine4.dispatch(iMActionRefreshSession, iMSessionStateMachine$broadcastReceived$12) == obj6) {
                                        return obj6;
                                    }
                                    notify5 = notify2;
                                    $result3 = $result4;
                                    $completion2 = $completion4;
                                    state5 = state2;
                                    iMSessionStateMachine$broadcastReceived$1 = iMSessionStateMachine$broadcastReceived$12;
                                    coroutine_suspended = obj6;
                                    iMSessionStateMachine = iMSessionStateMachine4;
                                    i4 = 0;
                                    iMSessionStateMachine2 = iMSessionStateMachine;
                                    $result = $result3;
                                    $completion = $completion2;
                                    obj = coroutine_suspended;
                                    notify2 = notify5;
                                    iMSessionStateMachine$broadcastReceived$12 = iMSessionStateMachine$broadcastReceived$1;
                                    state2 = state5;
                                    if (!it.hasNext()) {
                                    }
                                } else {
                                    $result2 = $result;
                                    IMSessionStateMachine iMSessionStateMachine5 = iMSessionStateMachine2;
                                    obj2 = obj;
                                    iMSessionStateMachine3 = iMSessionStateMachine5;
                                }
                            } else {
                                $result2 = $result;
                                IMSessionStateMachine iMSessionStateMachine6 = iMSessionStateMachine2;
                                obj2 = obj;
                                iMSessionStateMachine3 = iMSessionStateMachine6;
                            }
                            $result = $result2;
                            $completion = $completion4;
                            Object obj7 = obj2;
                            iMSessionStateMachine2 = iMSessionStateMachine3;
                            obj = obj7;
                            if (!it.hasNext()) {
                            }
                        }
                    }
                }
            }
        }
        iMSessionStateMachine = this;
        iMSessionStateMachine$broadcastReceived$1 = new IMSessionStateMachine$broadcastReceived$1(iMSessionStateMachine, $completion2);
        Object $result32 = iMSessionStateMachine$broadcastReceived$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (iMSessionStateMachine$broadcastReceived$1.label) {
        }
        if (!it.hasNext()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object updateQuickLink(State<IMState> state, Continuation<? super ChangedState<IMState>> continuation) {
        Continuation<? super Result<KGetQuickLinkUnreadReply>> iMSessionStateMachine$updateQuickLink$1;
        Object m3360updateInteractiveUnreadIoAF18A;
        Throwable it;
        Object create;
        ChangedState mutate;
        if (continuation instanceof IMSessionStateMachine$updateQuickLink$1) {
            iMSessionStateMachine$updateQuickLink$1 = (IMSessionStateMachine$updateQuickLink$1) continuation;
            if ((iMSessionStateMachine$updateQuickLink$1.label & Integer.MIN_VALUE) != 0) {
                iMSessionStateMachine$updateQuickLink$1.label -= Integer.MIN_VALUE;
                Object $result = iMSessionStateMachine$updateQuickLink$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (iMSessionStateMachine$updateQuickLink$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        IMSessionInteractiveService iMSessionInteractiveService = this.interactiveService;
                        if (iMSessionInteractiveService != null) {
                            iMSessionStateMachine$updateQuickLink$1.L$0 = state;
                            iMSessionStateMachine$updateQuickLink$1.label = 1;
                            m3360updateInteractiveUnreadIoAF18A = iMSessionInteractiveService.m3360updateInteractiveUnreadIoAF18A(iMSessionStateMachine$updateQuickLink$1);
                            if (m3360updateInteractiveUnreadIoAF18A == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            it = Result.exceptionOrNull-impl(m3360updateInteractiveUnreadIoAF18A);
                            if (it != null) {
                                final KGetQuickLinkUnreadReply it2 = (KGetQuickLinkUnreadReply) m3360updateInteractiveUnreadIoAF18A;
                                mutate = state.mutate(new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda0
                                    public final Object invoke(Object obj) {
                                        IMState updateQuickLink$lambda$0$0;
                                        updateQuickLink$lambda$0$0 = IMSessionStateMachine.updateQuickLink$lambda$0$0(it2, (IMState) obj);
                                        return updateQuickLink$lambda$0$0;
                                    }
                                });
                                if (mutate != null) {
                                    return mutate;
                                }
                            } else {
                                IMToast.Companion companion = IMToast.Companion;
                                iMSessionStateMachine$updateQuickLink$1.L$0 = state;
                                iMSessionStateMachine$updateQuickLink$1.L$1 = SpillingKt.nullOutSpilledVariable(it);
                                iMSessionStateMachine$updateQuickLink$1.I$0 = 0;
                                iMSessionStateMachine$updateQuickLink$1.label = 2;
                                create = companion.create(it, (r12 & 2) != 0 ? "" : null, (r12 & 4) != 0 ? Clock.System.INSTANCE.now() : null, (r12 & 8) != 0 ? null : null, iMSessionStateMachine$updateQuickLink$1);
                                if (create == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                final IMToast imToast = (IMToast) create;
                                mutate = state.mutate(new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda11
                                    public final Object invoke(Object obj) {
                                        IMState updateQuickLink$lambda$1$0;
                                        updateQuickLink$lambda$1$0 = IMSessionStateMachine.updateQuickLink$lambda$1$0(IMToast.this, (IMState) obj);
                                        return updateQuickLink$lambda$1$0;
                                    }
                                });
                                if (mutate != null) {
                                }
                            }
                        }
                        return state.noChange();
                    case 1:
                        state = (State) iMSessionStateMachine$updateQuickLink$1.L$0;
                        ResultKt.throwOnFailure($result);
                        m3360updateInteractiveUnreadIoAF18A = ((Result) $result).unbox-impl();
                        it = Result.exceptionOrNull-impl(m3360updateInteractiveUnreadIoAF18A);
                        if (it != null) {
                        }
                        break;
                    case 2:
                        int i2 = iMSessionStateMachine$updateQuickLink$1.I$0;
                        Throwable th = (Throwable) iMSessionStateMachine$updateQuickLink$1.L$1;
                        state = (State) iMSessionStateMachine$updateQuickLink$1.L$0;
                        ResultKt.throwOnFailure($result);
                        create = $result;
                        final IMToast imToast2 = (IMToast) create;
                        mutate = state.mutate(new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda11
                            public final Object invoke(Object obj) {
                                IMState updateQuickLink$lambda$1$0;
                                updateQuickLink$lambda$1$0 = IMSessionStateMachine.updateQuickLink$lambda$1$0(IMToast.this, (IMState) obj);
                                return updateQuickLink$lambda$1$0;
                            }
                        });
                        if (mutate != null) {
                        }
                        return state.noChange();
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        iMSessionStateMachine$updateQuickLink$1 = new IMSessionStateMachine$updateQuickLink$1(this, continuation);
        Object $result2 = iMSessionStateMachine$updateQuickLink$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (iMSessionStateMachine$updateQuickLink$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMState updateQuickLink$lambda$0$0(KGetQuickLinkUnreadReply $it, IMState $this$mutate) {
        IMState copy;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        copy = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.pageType : null, (r18 & 2) != 0 ? $this$mutate.data : $this$mutate.getData().updateQuickLinkUnread$session_debug($it), (r18 & 4) != 0 ? $this$mutate.toast : null, (r18 & 8) != 0 ? $this$mutate.isLoggedIn : false, (r18 & 16) != 0 ? $this$mutate.type : null, (r18 & 32) != 0 ? $this$mutate.clickedSession : null, (r18 & 64) != 0 ? $this$mutate.firstLoad : false, (r18 & 128) != 0 ? $this$mutate.techTrack : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMState updateQuickLink$lambda$1$0(IMToast $imToast, IMState $this$mutate) {
        IMState copy;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        copy = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.pageType : null, (r18 & 2) != 0 ? $this$mutate.data : null, (r18 & 4) != 0 ? $this$mutate.toast : $imToast, (r18 & 8) != 0 ? $this$mutate.isLoggedIn : false, (r18 & 16) != 0 ? $this$mutate.type : null, (r18 & 32) != 0 ? $this$mutate.clickedSession : null, (r18 & 64) != 0 ? $this$mutate.firstLoad : false, (r18 & 128) != 0 ? $this$mutate.techTrack : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChangedState<IMState> updateSummaryFor(State<IMState> state, final KSessionId sessionId, final Summary newSummary) {
        return state.override(new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda33
            public final Object invoke(Object obj) {
                IMState updateSummaryFor$lambda$0;
                updateSummaryFor$lambda$0 = IMSessionStateMachine.updateSummaryFor$lambda$0(sessionId, newSummary, (IMState) obj);
                return updateSummaryFor$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMState updateSummaryFor$lambda$0(KSessionId $sessionId, Summary $newSummary, IMState $this$override) {
        IMState copy;
        Intrinsics.checkNotNullParameter($this$override, "$this$override");
        copy = $this$override.copy((r18 & 1) != 0 ? $this$override.pageType : null, (r18 & 2) != 0 ? $this$override.data : $this$override.getData().updateSummary$session_debug($sessionId, $newSummary), (r18 & 4) != 0 ? $this$override.toast : null, (r18 & 8) != 0 ? $this$override.isLoggedIn : false, (r18 & 16) != 0 ? $this$override.type : null, (r18 & 32) != 0 ? $this$override.clickedSession : null, (r18 & 64) != 0 ? $this$override.firstLoad : false, (r18 & 128) != 0 ? $this$override.techTrack : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChangedState<IMState> removeSession(State<IMState> state, final KSessionId sessionId) {
        return state.mutate(new Function1() { // from class: im.session.IMSessionStateMachine$$ExternalSyntheticLambda44
            public final Object invoke(Object obj) {
                IMState removeSession$lambda$0;
                removeSession$lambda$0 = IMSessionStateMachine.removeSession$lambda$0(sessionId, (IMState) obj);
                return removeSession$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMState removeSession$lambda$0(KSessionId $sessionId, IMState $this$mutate) {
        IMState copy;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        IMSessionPageData data = $this$mutate.getData();
        Iterable $this$filter$iv = $this$mutate.getData().getSessions();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            IMSessionCard it = (IMSessionCard) element$iv$iv;
            if (!Intrinsics.areEqual(it.getId(), $sessionId)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        copy = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.pageType : null, (r18 & 2) != 0 ? $this$mutate.data : IMSessionPageData.copy$default(data, null, null, null, null, (List) destination$iv$iv, null, null, null, null, null, false, 2031, null), (r18 & 4) != 0 ? $this$mutate.toast : null, (r18 & 8) != 0 ? $this$mutate.isLoggedIn : false, (r18 & 16) != 0 ? $this$mutate.type : null, (r18 & 32) != 0 ? $this$mutate.clickedSession : null, (r18 & 64) != 0 ? $this$mutate.firstLoad : false, (r18 & 128) != 0 ? $this$mutate.techTrack : null);
        return copy;
    }
}