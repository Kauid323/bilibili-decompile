package kntr.app.im.chat.service;

import com.bapis.bilibili.app.im.v1.KAckSessionReply;
import com.bapis.bilibili.app.im.v1.KAckSessionReq;
import com.bapis.bilibili.app.im.v1.KChatMoss;
import com.bapis.bilibili.app.im.v1.KSessionId;
import com.bilibili.blens.BSetter;
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
import im.base.IMLog;
import im.base.model.SessionId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kntr.app.im.chat.core.FetchMessageDirection;
import kntr.app.im.chat.core.RequestMessagesPolicy;
import kntr.app.im.chat.core.di.ChatScope;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.FetchMessagesData;
import kntr.app.im.chat.core.model.FetchMessagesDataLensKt;
import kntr.app.im.chat.core.model.FetchMessagesResult;
import kntr.app.im.chat.core.model.GhostMessage;
import kntr.app.im.chat.core.model.Message;
import kntr.app.im.chat.core.model.MessageId;
import kntr.app.im.chat.core.service.FusionFetchMessageService;
import kntr.app.im.chat.core.service.MessageDatabaseService;
import kntr.app.im.chat.core.service.NetworkFetchMessageService;
import kntr.app.im.chat.core.service.RangeDatabaseService;
import kntr.app.im.chat.service.FetchMessagesAction;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.LongRange;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.datetime.Clock;
import kotlinx.datetime.Instant;

/* compiled from: FusionFetchMessagesServiceImpl.kt */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 G2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001GB1\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u001bJ\u001c\u0010\u001c\u001a\u00020\u00182\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0096@¢\u0006\u0002\u0010 J\u001e\u0010!\u001a\u00020\u0018*\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\"H\u0002J\u001e\u0010#\u001a\u00020\u0018*\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\"H\u0002J\u001e\u0010$\u001a\u00020\u0018*\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\"H\u0002J\u001e\u0010%\u001a\u00020\u0018*\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\"H\u0002J\"\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020)H\u0082@¢\u0006\u0002\u0010*J\u001e\u0010+\u001a\u00020\u0018*\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\"H\u0002J\"\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00020'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020)H\u0082@¢\u0006\u0002\u0010*JS\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00020'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020)2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u001f\b\u0002\u00102\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000204\u0012\u0004\u0012\u00020\u001803¢\u0006\u0002\b5H\u0082@¢\u0006\u0002\u00106J\u000e\u00107\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u00108J0\u00109\u001a\b\u0012\u0004\u0012\u00020\u001f0:2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020<0\u001e2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020>0\u001eH\u0082@¢\u0006\u0002\u0010?J.\u0010@\u001a\u00020\u00182\f\u0010;\u001a\b\u0012\u0004\u0012\u00020<0\u001e2\u0006\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010BH\u0082@¢\u0006\u0002\u0010DJ \u0010E\u001a\u00020\u0018*\b\u0012\u0004\u0012\u00020\u0002042\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u001f0:H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006H"}, d2 = {"Lkntr/app/im/chat/service/FusionFetchMessagesServiceImpl;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Lkntr/app/im/chat/core/model/FetchMessagesData;", "Lkntr/app/im/chat/service/FetchMessagesAction;", "Lkntr/app/im/chat/core/service/FusionFetchMessageService;", "sessionId", "Lim/base/model/SessionId;", "kSessionId", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "networkService", "Lkntr/app/im/chat/core/service/NetworkFetchMessageService;", "messageDatabaseService", "Lkntr/app/im/chat/core/service/MessageDatabaseService;", "rangeDatabaseService", "Lkntr/app/im/chat/core/service/RangeDatabaseService;", "<init>", "(Lim/base/model/SessionId;Lcom/bapis/bilibili/app/im/v1/KSessionId;Lkntr/app/im/chat/core/service/NetworkFetchMessageService;Lkntr/app/im/chat/core/service/MessageDatabaseService;Lkntr/app/im/chat/core/service/RangeDatabaseService;)V", "updateBaseTime", "Lkotlinx/datetime/Instant;", "dataFlow", "Lkotlinx/coroutines/flow/Flow;", "getDataFlow", "()Lkotlinx/coroutines/flow/Flow;", "load", RoomRecommendViewModel.EMPTY_CURSOR, "direction", "Lkntr/app/im/chat/core/FetchMessageDirection;", "(Lkntr/app/im/chat/core/FetchMessageDirection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateMessages", "messages", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/core/model/MessageId;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bindInitialize", "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "bindPagination", "bindDatabase", "bindUpdate", "loadPrev", "Lcom/freeletics/flowredux/dsl/ChangedState;", "state", "Lcom/freeletics/flowredux/dsl/State;", "(Lcom/freeletics/flowredux/dsl/State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bindAck", "loadNext", "handleFetchMessagesResult", "result", "Lkntr/app/im/chat/core/model/FetchMessagesResult;", "needAck", RoomRecommendViewModel.EMPTY_CURSOR, "stateScope", "Lkotlin/Function1;", "Lcom/bilibili/blens/dsl/CopyScope;", "Lkotlin/ExtensionFunctionType;", "(Lcom/freeletics/flowredux/dsl/State;Lkntr/app/im/chat/core/model/FetchMessagesResult;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performAckSession", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkGhostMessage", RoomRecommendViewModel.EMPTY_CURSOR, "entityMessages", "Lkntr/app/im/chat/core/model/EntityMessage;", "ghostMessages", "Lkntr/app/im/chat/core/model/GhostMessage;", "(Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateEntityMessages", "resultRange", "Lkotlin/ranges/LongRange;", "currentRange", "(Ljava/util/List;Lkotlin/ranges/LongRange;Lkotlin/ranges/LongRange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setUpdateIds", "ids", "Companion", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@ChatScope
public final class FusionFetchMessagesServiceImpl extends FlowReduxStateMachine<FetchMessagesData, FetchMessagesAction> implements FusionFetchMessageService {
    public static final int PAGE_SIZE = 30;
    private final KSessionId kSessionId;
    private final MessageDatabaseService messageDatabaseService;
    private final NetworkFetchMessageService networkService;
    private final RangeDatabaseService rangeDatabaseService;
    private final SessionId sessionId;
    private final Instant updateBaseTime;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: FusionFetchMessagesServiceImpl.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FetchMessageDirection.values().length];
            try {
                iArr[FetchMessageDirection.UP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[FetchMessageDirection.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public FusionFetchMessagesServiceImpl(SessionId sessionId, KSessionId kSessionId, NetworkFetchMessageService networkService, MessageDatabaseService messageDatabaseService, RangeDatabaseService rangeDatabaseService) {
        super(new FetchMessagesData(false, false, false, false, false, null, null, null, null, null, null, false, null, null, 16383, null));
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(kSessionId, "kSessionId");
        Intrinsics.checkNotNullParameter(networkService, "networkService");
        Intrinsics.checkNotNullParameter(messageDatabaseService, "messageDatabaseService");
        Intrinsics.checkNotNullParameter(rangeDatabaseService, "rangeDatabaseService");
        this.sessionId = sessionId;
        this.kSessionId = kSessionId;
        this.networkService = networkService;
        this.messageDatabaseService = messageDatabaseService;
        this.rangeDatabaseService = rangeDatabaseService;
        this.updateBaseTime = Clock.System.INSTANCE.now();
        spec(new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda27
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = FusionFetchMessagesServiceImpl._init_$lambda$0(FusionFetchMessagesServiceImpl.this, (FlowReduxStoreBuilder) obj);
                return _init_$lambda$0;
            }
        });
    }

    /* compiled from: FusionFetchMessagesServiceImpl.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkntr/app/im/chat/service/FusionFetchMessagesServiceImpl$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "PAGE_SIZE", RoomRecommendViewModel.EMPTY_CURSOR, "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // kntr.app.im.chat.core.service.FusionFetchMessageService
    public Flow<FetchMessagesData> getDataFlow() {
        return FlowKt.distinctUntilChanged(getState());
    }

    @Override // kntr.app.im.chat.core.service.FusionFetchMessageService
    public Object load(FetchMessageDirection direction, Continuation<? super Unit> continuation) {
        FetchMessagesAction.LoadEarlier loadEarlier;
        switch (WhenMappings.$EnumSwitchMapping$0[direction.ordinal()]) {
            case 1:
                loadEarlier = FetchMessagesAction.LoadEarlier.INSTANCE;
                break;
            case 2:
                loadEarlier = FetchMessagesAction.LoadLater.INSTANCE;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        Object dispatch = dispatch(loadEarlier, continuation);
        return dispatch == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? dispatch : Unit.INSTANCE;
    }

    @Override // kntr.app.im.chat.core.service.FusionFetchMessageService
    public Object updateMessages(List<MessageId> list, Continuation<? super Unit> continuation) {
        Object dispatch = dispatch(new FetchMessagesAction.UpdateMessages(list), continuation);
        return dispatch == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? dispatch : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(final FusionFetchMessagesServiceImpl this$0, FlowReduxStoreBuilder $this$spec) {
        Intrinsics.checkNotNullParameter($this$spec, "$this$spec");
        Function1 block$iv = new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda13
            public final Object invoke(Object obj) {
                return FusionFetchMessagesServiceImpl.lambda$0$0(FusionFetchMessagesServiceImpl.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(FetchMessagesData.class), block$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0(FusionFetchMessagesServiceImpl this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        this$0.bindInitialize($this$inState);
        this$0.bindPagination($this$inState);
        this$0.bindDatabase($this$inState);
        this$0.bindUpdate($this$inState);
        this$0.bindAck($this$inState);
        return Unit.INSTANCE;
    }

    private final void bindInitialize(InStateBuilderBlock<FetchMessagesData, FetchMessagesData, FetchMessagesAction> inStateBuilderBlock) {
        inStateBuilderBlock.onEnter(new FusionFetchMessagesServiceImpl$bindInitialize$1(this, null));
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda34
            public final Object invoke(Object obj) {
                boolean bindInitialize$lambda$0;
                bindInitialize$lambda$0 = FusionFetchMessagesServiceImpl.bindInitialize$lambda$0((FetchMessagesData) obj);
                return Boolean.valueOf(bindInitialize$lambda$0);
            }
        }, new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit bindInitialize$lambda$1;
                bindInitialize$lambda$1 = FusionFetchMessagesServiceImpl.bindInitialize$lambda$1(FusionFetchMessagesServiceImpl.this, (ConditionBuilderBlock) obj);
                return bindInitialize$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindInitialize$lambda$0(FetchMessagesData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getDatabaseReady();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindInitialize$lambda$1(FusionFetchMessagesServiceImpl this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new FusionFetchMessagesServiceImpl$bindInitialize$3$1(this$0, null));
        return Unit.INSTANCE;
    }

    private final void bindPagination(InStateBuilderBlock<FetchMessagesData, FetchMessagesData, FetchMessagesAction> inStateBuilderBlock) {
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new FusionFetchMessagesServiceImpl$bindPagination$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(FetchMessagesAction.LoadLater.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv2 = new FusionFetchMessagesServiceImpl$bindPagination$2(null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(FetchMessagesAction.LoadEarlier.class), executionPolicy$iv2, handler$iv2);
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda11
            public final Object invoke(Object obj) {
                boolean bindPagination$lambda$0;
                bindPagination$lambda$0 = FusionFetchMessagesServiceImpl.bindPagination$lambda$0((FetchMessagesData) obj);
                return Boolean.valueOf(bindPagination$lambda$0);
            }
        }, new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda22
            public final Object invoke(Object obj) {
                Unit bindPagination$lambda$1;
                bindPagination$lambda$1 = FusionFetchMessagesServiceImpl.bindPagination$lambda$1(FusionFetchMessagesServiceImpl.this, (ConditionBuilderBlock) obj);
                return bindPagination$lambda$1;
            }
        });
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda28
            public final Object invoke(Object obj) {
                boolean bindPagination$lambda$2;
                bindPagination$lambda$2 = FusionFetchMessagesServiceImpl.bindPagination$lambda$2((FetchMessagesData) obj);
                return Boolean.valueOf(bindPagination$lambda$2);
            }
        }, new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda29
            public final Object invoke(Object obj) {
                Unit bindPagination$lambda$3;
                bindPagination$lambda$3 = FusionFetchMessagesServiceImpl.bindPagination$lambda$3((ConditionBuilderBlock) obj);
                return bindPagination$lambda$3;
            }
        });
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda30
            public final Object invoke(Object obj) {
                boolean bindPagination$lambda$4;
                bindPagination$lambda$4 = FusionFetchMessagesServiceImpl.bindPagination$lambda$4((FetchMessagesData) obj);
                return Boolean.valueOf(bindPagination$lambda$4);
            }
        }, new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda31
            public final Object invoke(Object obj) {
                Unit bindPagination$lambda$5;
                bindPagination$lambda$5 = FusionFetchMessagesServiceImpl.bindPagination$lambda$5(FusionFetchMessagesServiceImpl.this, (ConditionBuilderBlock) obj);
                return bindPagination$lambda$5;
            }
        });
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda32
            public final Object invoke(Object obj) {
                boolean bindPagination$lambda$6;
                bindPagination$lambda$6 = FusionFetchMessagesServiceImpl.bindPagination$lambda$6((FetchMessagesData) obj);
                return Boolean.valueOf(bindPagination$lambda$6);
            }
        }, new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda33
            public final Object invoke(Object obj) {
                Unit bindPagination$lambda$7;
                bindPagination$lambda$7 = FusionFetchMessagesServiceImpl.bindPagination$lambda$7((ConditionBuilderBlock) obj);
                return bindPagination$lambda$7;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindPagination$lambda$0(FetchMessagesData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getLoadingEarlier()) {
            LongRange currentRange = it.getCurrentRange();
            return !(currentRange != null && (currentRange.getFirst() > 0L ? 1 : (currentRange.getFirst() == 0L ? 0 : -1)) == 0);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindPagination$lambda$1(FusionFetchMessagesServiceImpl this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new FusionFetchMessagesServiceImpl$bindPagination$4$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindPagination$lambda$2(FetchMessagesData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !it.getLoadingEarlier() && it.getPendingLoadEarlier();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindPagination$lambda$3(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new FusionFetchMessagesServiceImpl$bindPagination$6$1(null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindPagination$lambda$4(FetchMessagesData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getLoadingLater();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindPagination$lambda$5(FusionFetchMessagesServiceImpl this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new FusionFetchMessagesServiceImpl$bindPagination$8$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindPagination$lambda$6(FetchMessagesData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !it.getLoadingLater() && it.getPendingLoadLater();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindPagination$lambda$7(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new FusionFetchMessagesServiceImpl$bindPagination$10$1(null));
        return Unit.INSTANCE;
    }

    private final void bindDatabase(InStateBuilderBlock<FetchMessagesData, FetchMessagesData, FetchMessagesAction> inStateBuilderBlock) {
        inStateBuilderBlock.untilIdentityChanges(new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Object bindDatabase$lambda$0;
                bindDatabase$lambda$0 = FusionFetchMessagesServiceImpl.bindDatabase$lambda$0((FetchMessagesData) obj);
                return bindDatabase$lambda$0;
            }
        }, new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit bindDatabase$lambda$1;
                bindDatabase$lambda$1 = FusionFetchMessagesServiceImpl.bindDatabase$lambda$1(FusionFetchMessagesServiceImpl.this, (IdentityBuilderBlock) obj);
                return bindDatabase$lambda$1;
            }
        });
        inStateBuilderBlock.untilIdentityChanges(new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Object bindDatabase$lambda$2;
                bindDatabase$lambda$2 = FusionFetchMessagesServiceImpl.bindDatabase$lambda$2((FetchMessagesData) obj);
                return bindDatabase$lambda$2;
            }
        }, new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit bindDatabase$lambda$3;
                bindDatabase$lambda$3 = FusionFetchMessagesServiceImpl.bindDatabase$lambda$3(FusionFetchMessagesServiceImpl.this, (IdentityBuilderBlock) obj);
                return bindDatabase$lambda$3;
            }
        });
        inStateBuilderBlock.untilIdentityChanges(new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Object bindDatabase$lambda$4;
                bindDatabase$lambda$4 = FusionFetchMessagesServiceImpl.bindDatabase$lambda$4((FetchMessagesData) obj);
                return bindDatabase$lambda$4;
            }
        }, new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                Unit bindDatabase$lambda$5;
                bindDatabase$lambda$5 = FusionFetchMessagesServiceImpl.bindDatabase$lambda$5(FusionFetchMessagesServiceImpl.this, (IdentityBuilderBlock) obj);
                return bindDatabase$lambda$5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object bindDatabase$lambda$0(FetchMessagesData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getCurrentRange();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindDatabase$lambda$1(FusionFetchMessagesServiceImpl this$0, IdentityBuilderBlock $this$untilIdentityChanges) {
        Intrinsics.checkNotNullParameter($this$untilIdentityChanges, "$this$untilIdentityChanges");
        $this$untilIdentityChanges.onEnter(new FusionFetchMessagesServiceImpl$bindDatabase$2$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object bindDatabase$lambda$2(FetchMessagesData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return TuplesKt.to(it.getCurrentRange(), it.getBaselineTime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindDatabase$lambda$3(final FusionFetchMessagesServiceImpl this$0, IdentityBuilderBlock $this$untilIdentityChanges) {
        Intrinsics.checkNotNullParameter($this$untilIdentityChanges, "$this$untilIdentityChanges");
        BaseBuilderBlock.collectWhileInState$default((BaseBuilderBlock) $this$untilIdentityChanges, new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda10
            public final Object invoke(Object obj) {
                Flow bindDatabase$lambda$3$0;
                bindDatabase$lambda$3$0 = FusionFetchMessagesServiceImpl.bindDatabase$lambda$3$0(FusionFetchMessagesServiceImpl.this, (FetchMessagesData) obj);
                return bindDatabase$lambda$3$0;
            }
        }, (ExecutionPolicy) null, new FusionFetchMessagesServiceImpl$bindDatabase$4$2(this$0, null), 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow bindDatabase$lambda$3$0(FusionFetchMessagesServiceImpl this$0, final FetchMessagesData state) {
        Flow<List<EntityMessage>> queryInRangeAsFlow;
        Intrinsics.checkNotNullParameter(state, "state");
        IMLog.Companion.d("ChatFetchService", new Function0() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda14
            public final Object invoke() {
                String bindDatabase$lambda$3$0$0;
                bindDatabase$lambda$3$0$0 = FusionFetchMessagesServiceImpl.bindDatabase$lambda$3$0$0(FetchMessagesData.this);
                return bindDatabase$lambda$3$0$0;
            }
        });
        LongRange it = state.getCurrentRange();
        return (it == null || (queryInRangeAsFlow = this$0.messageDatabaseService.queryInRangeAsFlow(it, state.getBaselineTime())) == null) ? FlowKt.emptyFlow() : queryInRangeAsFlow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String bindDatabase$lambda$3$0$0(FetchMessagesData $state) {
        LongRange currentRange = $state.getCurrentRange();
        Long valueOf = currentRange != null ? Long.valueOf(currentRange.getFirst()) : null;
        LongRange currentRange2 = $state.getCurrentRange();
        return "开始监听范围[" + valueOf + ", " + (currentRange2 != null ? Long.valueOf(currentRange2.getLast()) : null) + "]的消息变化";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object bindDatabase$lambda$4(FetchMessagesData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getMarkFailedMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindDatabase$lambda$5(FusionFetchMessagesServiceImpl this$0, IdentityBuilderBlock $this$untilIdentityChanges) {
        Intrinsics.checkNotNullParameter($this$untilIdentityChanges, "$this$untilIdentityChanges");
        $this$untilIdentityChanges.onEnter(new FusionFetchMessagesServiceImpl$bindDatabase$6$1(this$0, null));
        return Unit.INSTANCE;
    }

    private final void bindUpdate(InStateBuilderBlock<FetchMessagesData, FetchMessagesData, FetchMessagesAction> inStateBuilderBlock) {
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new FusionFetchMessagesServiceImpl$bindUpdate$1(this, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(FetchMessagesAction.UpdateMessages.class), executionPolicy$iv, handler$iv);
        inStateBuilderBlock.untilIdentityChanges(new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda16
            public final Object invoke(Object obj) {
                Object bindUpdate$lambda$0;
                bindUpdate$lambda$0 = FusionFetchMessagesServiceImpl.bindUpdate$lambda$0((FetchMessagesData) obj);
                return bindUpdate$lambda$0;
            }
        }, new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda17
            public final Object invoke(Object obj) {
                Unit bindUpdate$lambda$1;
                bindUpdate$lambda$1 = FusionFetchMessagesServiceImpl.bindUpdate$lambda$1(FusionFetchMessagesServiceImpl.this, (IdentityBuilderBlock) obj);
                return bindUpdate$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object bindUpdate$lambda$0(FetchMessagesData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getUpdateMsgIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindUpdate$lambda$1(FusionFetchMessagesServiceImpl this$0, IdentityBuilderBlock $this$untilIdentityChanges) {
        Intrinsics.checkNotNullParameter($this$untilIdentityChanges, "$this$untilIdentityChanges");
        $this$untilIdentityChanges.onEnter(new FusionFetchMessagesServiceImpl$bindUpdate$3$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0158 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadPrev(State<FetchMessagesData> state, Continuation<? super ChangedState<FetchMessagesData>> continuation) {
        FusionFetchMessagesServiceImpl$loadPrev$1 fusionFetchMessagesServiceImpl$loadPrev$1;
        FusionFetchMessagesServiceImpl$loadPrev$1 fusionFetchMessagesServiceImpl$loadPrev$12;
        LongRange currentRange;
        Object obj;
        State<FetchMessagesData> state2;
        LongRange prevRange;
        Object mo1360load0E7RQCE;
        LongRange currentRange2;
        State<FetchMessagesData> state3;
        final Throwable it;
        Object handleFetchMessagesResult;
        LongRange currentRange3;
        State<FetchMessagesData> state4;
        LongRange prevRange2;
        if (continuation instanceof FusionFetchMessagesServiceImpl$loadPrev$1) {
            fusionFetchMessagesServiceImpl$loadPrev$1 = (FusionFetchMessagesServiceImpl$loadPrev$1) continuation;
            if ((fusionFetchMessagesServiceImpl$loadPrev$1.label & Integer.MIN_VALUE) != 0) {
                fusionFetchMessagesServiceImpl$loadPrev$1.label -= Integer.MIN_VALUE;
                fusionFetchMessagesServiceImpl$loadPrev$12 = fusionFetchMessagesServiceImpl$loadPrev$1;
                Object $result = fusionFetchMessagesServiceImpl$loadPrev$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (fusionFetchMessagesServiceImpl$loadPrev$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        currentRange = ((FetchMessagesData) state.getSnapshot()).getCurrentRange();
                        RangeDatabaseService rangeDatabaseService = this.rangeDatabaseService;
                        Long boxLong = currentRange != null ? Boxing.boxLong(currentRange.getFirst()) : null;
                        fusionFetchMessagesServiceImpl$loadPrev$12.L$0 = state;
                        fusionFetchMessagesServiceImpl$loadPrev$12.L$1 = currentRange;
                        fusionFetchMessagesServiceImpl$loadPrev$12.label = 1;
                        Object queryPrevious = rangeDatabaseService.queryPrevious(boxLong, fusionFetchMessagesServiceImpl$loadPrev$12);
                        if (queryPrevious == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = queryPrevious;
                        state2 = state;
                        prevRange = (LongRange) obj;
                        IMLog.Companion.i("ChatFetchService", "加载上一页，当前range [" + (currentRange == null ? Boxing.boxLong(currentRange.getFirst()) : null) + ", " + (currentRange == null ? Boxing.boxLong(currentRange.getLast()) : null) + "], 上一页range [" + (prevRange == null ? Boxing.boxLong(prevRange.getFirst()) : null) + ", " + (prevRange != null ? Boxing.boxLong(prevRange.getLast()) : null) + "]");
                        if (prevRange == null && currentRange != null && FusionFetchMessagesServiceImplKt.isAdjacent(prevRange, currentRange)) {
                            final LongRange newRange = FusionFetchMessagesServiceImplKt.merge(currentRange, prevRange);
                            return state2.mutate(new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda19
                                public final Object invoke(Object obj2) {
                                    FetchMessagesData loadPrev$lambda$0;
                                    loadPrev$lambda$0 = FusionFetchMessagesServiceImpl.loadPrev$lambda$0(newRange, (FetchMessagesData) obj2);
                                    return loadPrev$lambda$0;
                                }
                            });
                        }
                        NetworkFetchMessageService networkFetchMessageService = this.networkService;
                        long longValue = currentRange == null ? currentRange.getStart().longValue() : Long.MAX_VALUE;
                        RequestMessagesPolicy requestMessagesPolicy = RequestMessagesPolicy.SEQUENCE_NUMBER_BEFORE;
                        fusionFetchMessagesServiceImpl$loadPrev$12.L$0 = state2;
                        fusionFetchMessagesServiceImpl$loadPrev$12.L$1 = SpillingKt.nullOutSpilledVariable(currentRange);
                        fusionFetchMessagesServiceImpl$loadPrev$12.L$2 = SpillingKt.nullOutSpilledVariable(prevRange);
                        fusionFetchMessagesServiceImpl$loadPrev$12.label = 2;
                        mo1360load0E7RQCE = networkFetchMessageService.mo1360load0E7RQCE(longValue, requestMessagesPolicy, fusionFetchMessagesServiceImpl$loadPrev$12);
                        if (mo1360load0E7RQCE != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        currentRange2 = currentRange;
                        state3 = state2;
                        it = Result.exceptionOrNull-impl(mo1360load0E7RQCE);
                        if (it == null) {
                            IMLog.Companion.e("ChatFetchService", "请求上一页消息失败", it);
                            return state3.mutate(new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda21
                                public final Object invoke(Object obj2) {
                                    FetchMessagesData loadPrev$lambda$2$0;
                                    loadPrev$lambda$2$0 = FusionFetchMessagesServiceImpl.loadPrev$lambda$2$0(it, (FetchMessagesData) obj2);
                                    return loadPrev$lambda$2$0;
                                }
                            });
                        }
                        final FetchMessagesResult it2 = (FetchMessagesResult) mo1360load0E7RQCE;
                        IMLog.Companion.i("ChatFetchService", "请求上一页消息成功，返回 " + it2.getMessages().size() + " 条消息，范围 [" + it2.getRange().getFirst() + ", " + it2.getRange().getLast() + "]");
                        Function1<? super CopyScope<FetchMessagesData>, Unit> function1 = new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda20
                            public final Object invoke(Object obj2) {
                                Unit loadPrev$lambda$1$0;
                                loadPrev$lambda$1$0 = FusionFetchMessagesServiceImpl.loadPrev$lambda$1$0(FetchMessagesResult.this, (CopyScope) obj2);
                                return loadPrev$lambda$1$0;
                            }
                        };
                        fusionFetchMessagesServiceImpl$loadPrev$12.L$0 = SpillingKt.nullOutSpilledVariable(state3);
                        fusionFetchMessagesServiceImpl$loadPrev$12.L$1 = SpillingKt.nullOutSpilledVariable(currentRange2);
                        fusionFetchMessagesServiceImpl$loadPrev$12.L$2 = SpillingKt.nullOutSpilledVariable(prevRange);
                        fusionFetchMessagesServiceImpl$loadPrev$12.L$3 = SpillingKt.nullOutSpilledVariable(it2);
                        fusionFetchMessagesServiceImpl$loadPrev$12.I$0 = 0;
                        fusionFetchMessagesServiceImpl$loadPrev$12.label = 3;
                        handleFetchMessagesResult = handleFetchMessagesResult(state3, it2, false, function1, fusionFetchMessagesServiceImpl$loadPrev$12);
                        if (handleFetchMessagesResult == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        currentRange3 = currentRange2;
                        state4 = state3;
                        prevRange2 = prevRange;
                        return (ChangedState) handleFetchMessagesResult;
                    case 1:
                        currentRange = (LongRange) fusionFetchMessagesServiceImpl$loadPrev$12.L$1;
                        state2 = (State) fusionFetchMessagesServiceImpl$loadPrev$12.L$0;
                        ResultKt.throwOnFailure($result);
                        obj = $result;
                        prevRange = (LongRange) obj;
                        if (currentRange == null) {
                        }
                        if (currentRange == null) {
                        }
                        IMLog.Companion.i("ChatFetchService", "加载上一页，当前range [" + (currentRange == null ? Boxing.boxLong(currentRange.getFirst()) : null) + ", " + (currentRange == null ? Boxing.boxLong(currentRange.getLast()) : null) + "], 上一页range [" + (prevRange == null ? Boxing.boxLong(prevRange.getFirst()) : null) + ", " + (prevRange != null ? Boxing.boxLong(prevRange.getLast()) : null) + "]");
                        if (prevRange == null) {
                        }
                        NetworkFetchMessageService networkFetchMessageService2 = this.networkService;
                        if (currentRange == null) {
                        }
                        RequestMessagesPolicy requestMessagesPolicy2 = RequestMessagesPolicy.SEQUENCE_NUMBER_BEFORE;
                        fusionFetchMessagesServiceImpl$loadPrev$12.L$0 = state2;
                        fusionFetchMessagesServiceImpl$loadPrev$12.L$1 = SpillingKt.nullOutSpilledVariable(currentRange);
                        fusionFetchMessagesServiceImpl$loadPrev$12.L$2 = SpillingKt.nullOutSpilledVariable(prevRange);
                        fusionFetchMessagesServiceImpl$loadPrev$12.label = 2;
                        mo1360load0E7RQCE = networkFetchMessageService2.mo1360load0E7RQCE(longValue, requestMessagesPolicy2, fusionFetchMessagesServiceImpl$loadPrev$12);
                        if (mo1360load0E7RQCE != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        currentRange2 = (LongRange) fusionFetchMessagesServiceImpl$loadPrev$12.L$1;
                        mo1360load0E7RQCE = ((Result) $result).unbox-impl();
                        prevRange = (LongRange) fusionFetchMessagesServiceImpl$loadPrev$12.L$2;
                        state3 = (State) fusionFetchMessagesServiceImpl$loadPrev$12.L$0;
                        it = Result.exceptionOrNull-impl(mo1360load0E7RQCE);
                        if (it == null) {
                        }
                        break;
                    case 3:
                        int i = fusionFetchMessagesServiceImpl$loadPrev$12.I$0;
                        FetchMessagesResult fetchMessagesResult = (FetchMessagesResult) fusionFetchMessagesServiceImpl$loadPrev$12.L$3;
                        prevRange2 = (LongRange) fusionFetchMessagesServiceImpl$loadPrev$12.L$2;
                        currentRange3 = (LongRange) fusionFetchMessagesServiceImpl$loadPrev$12.L$1;
                        state4 = (State) fusionFetchMessagesServiceImpl$loadPrev$12.L$0;
                        ResultKt.throwOnFailure($result);
                        handleFetchMessagesResult = $result;
                        return (ChangedState) handleFetchMessagesResult;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        fusionFetchMessagesServiceImpl$loadPrev$1 = new FusionFetchMessagesServiceImpl$loadPrev$1(this, continuation);
        fusionFetchMessagesServiceImpl$loadPrev$12 = fusionFetchMessagesServiceImpl$loadPrev$1;
        Object $result2 = fusionFetchMessagesServiceImpl$loadPrev$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (fusionFetchMessagesServiceImpl$loadPrev$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FetchMessagesData loadPrev$lambda$0(final LongRange $newRange, FetchMessagesData $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        return (FetchMessagesData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit loadPrev$lambda$0$0;
                loadPrev$lambda$0$0 = FusionFetchMessagesServiceImpl.loadPrev$lambda$0$0($newRange, (CopyScope) obj);
                return loadPrev$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit loadPrev$lambda$0$0(LongRange $newRange, CopyScope $this$copy) {
        Intrinsics.checkNotNullParameter($this$copy, "$this$copy");
        $this$copy.set(FetchMessagesDataLensKt.getCurrentRange(FetchMessagesData.Companion), $newRange);
        $this$copy.set(FetchMessagesDataLensKt.getLoadingEarlier(FetchMessagesData.Companion), false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit loadPrev$lambda$1$0(FetchMessagesResult $it, CopyScope $this$handleFetchMessagesResult) {
        Intrinsics.checkNotNullParameter($this$handleFetchMessagesResult, "$this$handleFetchMessagesResult");
        boolean z = false;
        $this$handleFetchMessagesResult.set(FetchMessagesDataLensKt.getLoadingEarlier(FetchMessagesData.Companion), false);
        BSetter pendingLoadEarlier = FetchMessagesDataLensKt.getPendingLoadEarlier(FetchMessagesData.Companion);
        if (((Boolean) $this$handleFetchMessagesResult.get(FetchMessagesDataLensKt.getPendingLoadEarlier(FetchMessagesData.Companion))).booleanValue() && $it.getRange().getFirst() != 0) {
            z = true;
        }
        $this$handleFetchMessagesResult.set(pendingLoadEarlier, Boolean.valueOf(z));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FetchMessagesData loadPrev$lambda$2$0(final Throwable $it, FetchMessagesData $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        return (FetchMessagesData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda12
            public final Object invoke(Object obj) {
                Unit loadPrev$lambda$2$0$0;
                loadPrev$lambda$2$0$0 = FusionFetchMessagesServiceImpl.loadPrev$lambda$2$0$0($it, (CopyScope) obj);
                return loadPrev$lambda$2$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit loadPrev$lambda$2$0$0(Throwable $it, CopyScope $this$copy) {
        Intrinsics.checkNotNullParameter($this$copy, "$this$copy");
        $this$copy.set(FetchMessagesDataLensKt.getLoadingEarlier(FetchMessagesData.Companion), false);
        $this$copy.set(FetchMessagesDataLensKt.getError(FetchMessagesData.Companion), $it);
        return Unit.INSTANCE;
    }

    private final void bindAck(InStateBuilderBlock<FetchMessagesData, FetchMessagesData, FetchMessagesAction> inStateBuilderBlock) {
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda25
            public final Object invoke(Object obj) {
                boolean bindAck$lambda$0;
                bindAck$lambda$0 = FusionFetchMessagesServiceImpl.bindAck$lambda$0((FetchMessagesData) obj);
                return Boolean.valueOf(bindAck$lambda$0);
            }
        }, new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda26
            public final Object invoke(Object obj) {
                Unit bindAck$lambda$1;
                bindAck$lambda$1 = FusionFetchMessagesServiceImpl.bindAck$lambda$1(FusionFetchMessagesServiceImpl.this, (ConditionBuilderBlock) obj);
                return bindAck$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindAck$lambda$0(FetchMessagesData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getPerformAck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindAck$lambda$1(FusionFetchMessagesServiceImpl this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new FusionFetchMessagesServiceImpl$bindAck$2$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0198  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadNext(State<FetchMessagesData> state, Continuation<? super ChangedState<FetchMessagesData>> continuation) {
        FusionFetchMessagesServiceImpl$loadNext$1 fusionFetchMessagesServiceImpl$loadNext$1;
        FusionFetchMessagesServiceImpl$loadNext$1 fusionFetchMessagesServiceImpl$loadNext$12;
        long beginSequenceNumber;
        RequestMessagesPolicy policy;
        State<FetchMessagesData> state2;
        RequestMessagesPolicy policy2;
        LongRange currentRange;
        Object obj;
        long beginSequenceNumber2;
        final Throwable it;
        Object handleFetchMessagesResult;
        long beginSequenceNumber3;
        State<FetchMessagesData> state3;
        LongRange currentRange2;
        RequestMessagesPolicy policy3;
        if (continuation instanceof FusionFetchMessagesServiceImpl$loadNext$1) {
            fusionFetchMessagesServiceImpl$loadNext$1 = (FusionFetchMessagesServiceImpl$loadNext$1) continuation;
            if ((fusionFetchMessagesServiceImpl$loadNext$1.label & Integer.MIN_VALUE) != 0) {
                fusionFetchMessagesServiceImpl$loadNext$1.label -= Integer.MIN_VALUE;
                fusionFetchMessagesServiceImpl$loadNext$12 = fusionFetchMessagesServiceImpl$loadNext$1;
                Object $result = fusionFetchMessagesServiceImpl$loadNext$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (fusionFetchMessagesServiceImpl$loadNext$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        LongRange currentRange3 = ((FetchMessagesData) state.getSnapshot()).getCurrentRange();
                        IMLog.Companion.i("ChatFetchService", "开始加载下一页，当前范围 [" + (currentRange3 != null ? Boxing.boxLong(currentRange3.getFirst()) : null) + ", " + (currentRange3 != null ? Boxing.boxLong(currentRange3.getLast()) : null) + "]");
                        if (currentRange3 == null) {
                            beginSequenceNumber = Long.MAX_VALUE;
                            policy = RequestMessagesPolicy.SEQUENCE_NUMBER_BEFORE;
                        } else {
                            beginSequenceNumber = currentRange3.getLast();
                            policy = RequestMessagesPolicy.SEQUENCE_NUMBER_AFTER;
                        }
                        NetworkFetchMessageService networkFetchMessageService = this.networkService;
                        state2 = state;
                        fusionFetchMessagesServiceImpl$loadNext$12.L$0 = state2;
                        fusionFetchMessagesServiceImpl$loadNext$12.L$1 = SpillingKt.nullOutSpilledVariable(policy);
                        fusionFetchMessagesServiceImpl$loadNext$12.L$2 = SpillingKt.nullOutSpilledVariable(currentRange3);
                        fusionFetchMessagesServiceImpl$loadNext$12.J$0 = beginSequenceNumber;
                        fusionFetchMessagesServiceImpl$loadNext$12.label = 1;
                        Object mo1360load0E7RQCE = networkFetchMessageService.mo1360load0E7RQCE(beginSequenceNumber, policy, fusionFetchMessagesServiceImpl$loadNext$12);
                        if (mo1360load0E7RQCE == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        policy2 = policy;
                        currentRange = currentRange3;
                        obj = mo1360load0E7RQCE;
                        beginSequenceNumber2 = beginSequenceNumber;
                        it = Result.exceptionOrNull-impl(obj);
                        if (it == null) {
                            IMLog.Companion.e("ChatFetchService", "请求下一页消息失败", it);
                            return state2.mutate(new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda9
                                public final Object invoke(Object obj2) {
                                    FetchMessagesData loadNext$lambda$1$0;
                                    loadNext$lambda$1$0 = FusionFetchMessagesServiceImpl.loadNext$lambda$1$0(it, (FetchMessagesData) obj2);
                                    return loadNext$lambda$1$0;
                                }
                            });
                        }
                        FetchMessagesResult it2 = (FetchMessagesResult) obj;
                        long beginSequenceNumber4 = beginSequenceNumber2;
                        IMLog.Companion.i("ChatFetchService", "请求下一页消息成功，返回 " + it2.getMessages().size() + " 条消息，范围 [" + it2.getRange().getFirst() + ", " + it2.getRange().getLast() + "]");
                        Function1<? super CopyScope<FetchMessagesData>, Unit> function1 = new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda8
                            public final Object invoke(Object obj2) {
                                Unit loadNext$lambda$0$0;
                                loadNext$lambda$0$0 = FusionFetchMessagesServiceImpl.loadNext$lambda$0$0((CopyScope) obj2);
                                return loadNext$lambda$0$0;
                            }
                        };
                        fusionFetchMessagesServiceImpl$loadNext$12.L$0 = SpillingKt.nullOutSpilledVariable(state2);
                        fusionFetchMessagesServiceImpl$loadNext$12.L$1 = SpillingKt.nullOutSpilledVariable(policy2);
                        fusionFetchMessagesServiceImpl$loadNext$12.L$2 = SpillingKt.nullOutSpilledVariable(currentRange);
                        fusionFetchMessagesServiceImpl$loadNext$12.L$3 = SpillingKt.nullOutSpilledVariable(it2);
                        fusionFetchMessagesServiceImpl$loadNext$12.J$0 = beginSequenceNumber4;
                        fusionFetchMessagesServiceImpl$loadNext$12.I$0 = 0;
                        fusionFetchMessagesServiceImpl$loadNext$12.label = 2;
                        handleFetchMessagesResult = handleFetchMessagesResult(state2, it2, true, function1, fusionFetchMessagesServiceImpl$loadNext$12);
                        if (handleFetchMessagesResult == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        beginSequenceNumber3 = beginSequenceNumber4;
                        state3 = state2;
                        currentRange2 = currentRange;
                        policy3 = policy2;
                        return (ChangedState) handleFetchMessagesResult;
                    case 1:
                        long beginSequenceNumber5 = fusionFetchMessagesServiceImpl$loadNext$12.J$0;
                        RequestMessagesPolicy policy4 = (RequestMessagesPolicy) fusionFetchMessagesServiceImpl$loadNext$12.L$1;
                        ResultKt.throwOnFailure($result);
                        currentRange = (LongRange) fusionFetchMessagesServiceImpl$loadNext$12.L$2;
                        policy2 = policy4;
                        obj = ((Result) $result).unbox-impl();
                        state2 = (State) fusionFetchMessagesServiceImpl$loadNext$12.L$0;
                        beginSequenceNumber2 = beginSequenceNumber5;
                        it = Result.exceptionOrNull-impl(obj);
                        if (it == null) {
                        }
                        break;
                    case 2:
                        int i = fusionFetchMessagesServiceImpl$loadNext$12.I$0;
                        beginSequenceNumber3 = fusionFetchMessagesServiceImpl$loadNext$12.J$0;
                        FetchMessagesResult fetchMessagesResult = (FetchMessagesResult) fusionFetchMessagesServiceImpl$loadNext$12.L$3;
                        currentRange2 = (LongRange) fusionFetchMessagesServiceImpl$loadNext$12.L$2;
                        policy3 = (RequestMessagesPolicy) fusionFetchMessagesServiceImpl$loadNext$12.L$1;
                        state3 = (State) fusionFetchMessagesServiceImpl$loadNext$12.L$0;
                        ResultKt.throwOnFailure($result);
                        handleFetchMessagesResult = $result;
                        return (ChangedState) handleFetchMessagesResult;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        fusionFetchMessagesServiceImpl$loadNext$1 = new FusionFetchMessagesServiceImpl$loadNext$1(this, continuation);
        fusionFetchMessagesServiceImpl$loadNext$12 = fusionFetchMessagesServiceImpl$loadNext$1;
        Object $result2 = fusionFetchMessagesServiceImpl$loadNext$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (fusionFetchMessagesServiceImpl$loadNext$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit loadNext$lambda$0$0(CopyScope $this$handleFetchMessagesResult) {
        Intrinsics.checkNotNullParameter($this$handleFetchMessagesResult, "$this$handleFetchMessagesResult");
        $this$handleFetchMessagesResult.set(FetchMessagesDataLensKt.getLoadingLater(FetchMessagesData.Companion), false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FetchMessagesData loadNext$lambda$1$0(final Throwable $it, FetchMessagesData $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        return (FetchMessagesData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda23
            public final Object invoke(Object obj) {
                Unit loadNext$lambda$1$0$0;
                loadNext$lambda$1$0$0 = FusionFetchMessagesServiceImpl.loadNext$lambda$1$0$0($it, (CopyScope) obj);
                return loadNext$lambda$1$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit loadNext$lambda$1$0$0(Throwable $it, CopyScope $this$copy) {
        Intrinsics.checkNotNullParameter($this$copy, "$this$copy");
        $this$copy.set(FetchMessagesDataLensKt.getLoadingLater(FetchMessagesData.Companion), false);
        $this$copy.set(FetchMessagesDataLensKt.getError(FetchMessagesData.Companion), $it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(12:1|(2:3|(9:5|6|7|44|45|46|47|48|(1:50)(11:51|15|16|17|18|(0)(0)|(1:22)|30|(0)(0)|27|28)))|124|6|7|44|45|46|47|48|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0277, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0278, code lost:
        r6 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x027a, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x027b, code lost:
        r19 = r1;
        r6 = r9;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0254 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02e0  */
    /* JADX WARN: Type inference failed for: r23v0, types: [kntr.app.im.chat.service.FusionFetchMessagesServiceImpl] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handleFetchMessagesResult(State<FetchMessagesData> state, FetchMessagesResult result, boolean needAck, Function1<? super CopyScope<FetchMessagesData>, Unit> function1, Continuation<? super ChangedState<FetchMessagesData>> continuation) {
        FusionFetchMessagesServiceImpl$handleFetchMessagesResult$1 fusionFetchMessagesServiceImpl$handleFetchMessagesResult$1;
        FusionFetchMessagesServiceImpl$handleFetchMessagesResult$1 fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12;
        Object coroutine_suspended;
        LongRange currentRange;
        LongRange resultRange;
        ArrayList entityMessages;
        ArrayList ghostMessages;
        boolean performAck;
        boolean needAck2;
        State state2;
        Function1 stateScope;
        LongRange currentRange2;
        LongRange currentRange3;
        List entityMessages2;
        List entityMessages3;
        List ghostMessages2;
        FetchMessagesResult result2;
        int $i$f$runSuspendCatching;
        State state3;
        boolean performAck2;
        int $i$f$runSuspendCatching2;
        int $i$f$runSuspendCatching3;
        Function1 function12;
        boolean needAck3;
        List tempMsgs;
        boolean performAck3;
        int $i$f$runSuspendCatching4;
        Object checkGhostMessage;
        boolean needAck4;
        Function1 stateScope2;
        LongRange currentRange4;
        final Object updateIds;
        boolean needAck5;
        State state4;
        List entityMessages4;
        LongRange currentRange5;
        Function1 stateScope3;
        LongRange currentRange6;
        boolean performAck4;
        Throwable it;
        if (continuation instanceof FusionFetchMessagesServiceImpl$handleFetchMessagesResult$1) {
            fusionFetchMessagesServiceImpl$handleFetchMessagesResult$1 = (FusionFetchMessagesServiceImpl$handleFetchMessagesResult$1) continuation;
            if ((fusionFetchMessagesServiceImpl$handleFetchMessagesResult$1.label & Integer.MIN_VALUE) != 0) {
                fusionFetchMessagesServiceImpl$handleFetchMessagesResult$1.label -= Integer.MIN_VALUE;
                fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12 = fusionFetchMessagesServiceImpl$handleFetchMessagesResult$1;
                Object $result = fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        currentRange = ((FetchMessagesData) state.getSnapshot()).getCurrentRange();
                        resultRange = result.getRange();
                        entityMessages = new ArrayList();
                        ghostMessages = new ArrayList();
                        for (Message message : result.getMessages()) {
                            if (message instanceof EntityMessage) {
                                entityMessages.add(message);
                            } else if (!(message instanceof GhostMessage)) {
                                throw new NoWhenBranchMatchedException();
                            } else {
                                ghostMessages.add(message);
                            }
                        }
                        ArrayList $this$filter$iv = entityMessages;
                        Collection destination$iv$iv = new ArrayList();
                        for (Object element$iv$iv : $this$filter$iv) {
                            Iterable $this$filter$iv2 = $this$filter$iv;
                            if (((EntityMessage) element$iv$iv).isTemporaryMsg()) {
                                destination$iv$iv.add(element$iv$iv);
                            }
                            $this$filter$iv = $this$filter$iv2;
                        }
                        List tempMsgs2 = (List) destination$iv$iv;
                        boolean z = needAck && result.getHasNewMessage();
                        if (needAck && result.getHasNewMessage()) {
                            IMLog.Companion.i("ChatFetchService", "有新消息，执行ack操作");
                        } else {
                            IMLog.Companion.i("ChatFetchService", "要求ack " + needAck + ", 有新消息 " + result.getHasNewMessage() + "，无需ack");
                        }
                        performAck = z;
                        try {
                            Result.Companion companion = Result.Companion;
                            $i$f$runSuspendCatching = 0;
                            if (entityMessages.isEmpty()) {
                                state3 = state;
                                stateScope = function1;
                                currentRange2 = currentRange;
                                performAck2 = performAck;
                                currentRange3 = resultRange;
                                $i$f$runSuspendCatching2 = 0;
                                entityMessages2 = entityMessages;
                                needAck2 = needAck;
                                entityMessages3 = ghostMessages;
                                ghostMessages2 = tempMsgs2;
                                $i$f$runSuspendCatching3 = 0;
                                result2 = result;
                                break;
                            } else {
                                try {
                                    fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$0 = state;
                                    fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$1 = SpillingKt.nullOutSpilledVariable(result);
                                    function12 = function1;
                                    try {
                                        fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$2 = function12;
                                        fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$3 = currentRange;
                                        fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$4 = resultRange;
                                        fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$5 = entityMessages;
                                        fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$6 = ghostMessages;
                                        fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$7 = tempMsgs2;
                                        fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.Z$0 = needAck;
                                        fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.Z$1 = performAck;
                                        fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.I$0 = 0;
                                        fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.I$1 = 0;
                                        fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.label = 1;
                                        if (updateEntityMessages(entityMessages, resultRange, currentRange, fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12) != coroutine_suspended) {
                                            needAck3 = needAck;
                                            state3 = state;
                                            stateScope = function12;
                                            tempMsgs = tempMsgs2;
                                            performAck3 = performAck;
                                            $i$f$runSuspendCatching4 = 0;
                                            result2 = result;
                                            int i = $i$f$runSuspendCatching4;
                                            $i$f$runSuspendCatching2 = $i$f$runSuspendCatching;
                                            needAck2 = needAck3;
                                            currentRange2 = currentRange;
                                            currentRange3 = resultRange;
                                            entityMessages2 = entityMessages;
                                            entityMessages3 = ghostMessages;
                                            ghostMessages2 = tempMsgs;
                                            performAck2 = performAck3;
                                            $i$f$runSuspendCatching3 = i;
                                            break;
                                        } else {
                                            return coroutine_suspended;
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        needAck2 = needAck;
                                        state2 = state;
                                        stateScope = function12;
                                        currentRange2 = currentRange;
                                        currentRange3 = resultRange;
                                        entityMessages2 = entityMessages;
                                        entityMessages3 = ghostMessages;
                                        ghostMessages2 = tempMsgs2;
                                        result2 = result;
                                        Result.Companion companion2 = Result.Companion;
                                        boolean z2 = performAck;
                                        updateIds = Result.constructor-impl(ResultKt.createFailure(th));
                                        needAck5 = needAck2;
                                        state4 = state2;
                                        entityMessages4 = ghostMessages2;
                                        currentRange5 = currentRange2;
                                        stateScope3 = stateScope;
                                        currentRange6 = currentRange3;
                                        performAck4 = z2;
                                        JobKt.ensureActive(fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.getContext());
                                        it = Result.exceptionOrNull-impl(updateIds);
                                        if (it != null) {
                                        }
                                        if (currentRange5 == null) {
                                        }
                                        State state5 = state4;
                                        final List list = entityMessages4;
                                        final boolean z3 = performAck4;
                                        final Function1 function13 = stateScope3;
                                        return state5.mutate(new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda15
                                            public final Object invoke(Object obj) {
                                                FetchMessagesData handleFetchMessagesResult$lambda$5;
                                                handleFetchMessagesResult$lambda$5 = FusionFetchMessagesServiceImpl.handleFetchMessagesResult$lambda$5(newRange, list, z3, this, updateIds, function13, (FetchMessagesData) obj);
                                                return handleFetchMessagesResult$lambda$5;
                                            }
                                        });
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    function12 = function1;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            needAck2 = needAck;
                            state2 = state;
                            stateScope = function1;
                            currentRange2 = currentRange;
                            currentRange3 = resultRange;
                            entityMessages2 = entityMessages;
                            entityMessages3 = ghostMessages;
                            ghostMessages2 = tempMsgs2;
                            result2 = result;
                        }
                        break;
                    case 1:
                        int $i$f$runSuspendCatching5 = fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.I$1;
                        int $i$f$runSuspendCatching6 = fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.I$0;
                        performAck = fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.Z$1;
                        boolean needAck6 = fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.Z$0;
                        List tempMsgs3 = (List) fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$7;
                        ghostMessages = (List) fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$6;
                        entityMessages = (List) fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$5;
                        resultRange = (LongRange) fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$4;
                        currentRange = (LongRange) fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$3;
                        stateScope = (Function1) fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$2;
                        needAck3 = needAck6;
                        FetchMessagesResult result3 = (FetchMessagesResult) fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$1;
                        state3 = (State) fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            tempMsgs = tempMsgs3;
                            performAck3 = performAck;
                            $i$f$runSuspendCatching4 = $i$f$runSuspendCatching6;
                            $i$f$runSuspendCatching = $i$f$runSuspendCatching5;
                            result2 = result3;
                            int i2 = $i$f$runSuspendCatching4;
                            $i$f$runSuspendCatching2 = $i$f$runSuspendCatching;
                            needAck2 = needAck3;
                            currentRange2 = currentRange;
                            currentRange3 = resultRange;
                            entityMessages2 = entityMessages;
                            entityMessages3 = ghostMessages;
                            ghostMessages2 = tempMsgs;
                            performAck2 = performAck3;
                            $i$f$runSuspendCatching3 = i2;
                            break;
                        } catch (Throwable th4) {
                            th = th4;
                            result2 = result3;
                            state2 = state3;
                            needAck2 = needAck3;
                            currentRange2 = currentRange;
                            currentRange3 = resultRange;
                            entityMessages2 = entityMessages;
                            entityMessages3 = ghostMessages;
                            ghostMessages2 = tempMsgs3;
                            Result.Companion companion22 = Result.Companion;
                            boolean z22 = performAck;
                            updateIds = Result.constructor-impl(ResultKt.createFailure(th));
                            needAck5 = needAck2;
                            state4 = state2;
                            entityMessages4 = ghostMessages2;
                            currentRange5 = currentRange2;
                            stateScope3 = stateScope;
                            currentRange6 = currentRange3;
                            performAck4 = z22;
                            JobKt.ensureActive(fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.getContext());
                            it = Result.exceptionOrNull-impl(updateIds);
                            if (it != null) {
                            }
                            if (currentRange5 == null) {
                            }
                            State state52 = state4;
                            final List list2 = entityMessages4;
                            final boolean z32 = performAck4;
                            final Function1 function132 = stateScope3;
                            return state52.mutate(new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda15
                                public final Object invoke(Object obj) {
                                    FetchMessagesData handleFetchMessagesResult$lambda$5;
                                    handleFetchMessagesResult$lambda$5 = FusionFetchMessagesServiceImpl.handleFetchMessagesResult$lambda$5(newRange, list2, z32, this, updateIds, function132, (FetchMessagesData) obj);
                                    return handleFetchMessagesResult$lambda$5;
                                }
                            });
                        }
                    case 2:
                        int i3 = fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.I$1;
                        int i4 = fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.I$0;
                        performAck = fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.Z$1;
                        needAck4 = fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.Z$0;
                        List tempMsgs4 = (List) fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$7;
                        List ghostMessages3 = (List) fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$6;
                        List entityMessages5 = (List) fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$5;
                        LongRange resultRange2 = (LongRange) fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$4;
                        LongRange currentRange7 = (LongRange) fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$3;
                        stateScope2 = (Function1) fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$2;
                        FetchMessagesResult result4 = (FetchMessagesResult) fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$1;
                        state2 = (State) fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            result2 = result4;
                            currentRange4 = currentRange7;
                            currentRange3 = resultRange2;
                            entityMessages2 = entityMessages5;
                            entityMessages3 = ghostMessages3;
                            ghostMessages2 = tempMsgs4;
                            try {
                                Object obj = Result.constructor-impl((Collection) $result);
                                stateScope3 = stateScope2;
                                state4 = state2;
                                entityMessages4 = ghostMessages2;
                                currentRange5 = currentRange4;
                                currentRange6 = currentRange3;
                                performAck4 = performAck;
                                updateIds = obj;
                                needAck5 = needAck4;
                            } catch (Throwable th5) {
                                th = th5;
                                currentRange2 = currentRange4;
                                stateScope = stateScope2;
                                needAck2 = needAck4;
                                Result.Companion companion222 = Result.Companion;
                                boolean z222 = performAck;
                                updateIds = Result.constructor-impl(ResultKt.createFailure(th));
                                needAck5 = needAck2;
                                state4 = state2;
                                entityMessages4 = ghostMessages2;
                                currentRange5 = currentRange2;
                                stateScope3 = stateScope;
                                currentRange6 = currentRange3;
                                performAck4 = z222;
                                JobKt.ensureActive(fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.getContext());
                                it = Result.exceptionOrNull-impl(updateIds);
                                if (it != null) {
                                }
                                if (currentRange5 == null) {
                                }
                                State state522 = state4;
                                final List list22 = entityMessages4;
                                final boolean z322 = performAck4;
                                final Function1 function1322 = stateScope3;
                                return state522.mutate(new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda15
                                    public final Object invoke(Object obj2) {
                                        FetchMessagesData handleFetchMessagesResult$lambda$5;
                                        handleFetchMessagesResult$lambda$5 = FusionFetchMessagesServiceImpl.handleFetchMessagesResult$lambda$5(newRange, list22, z322, this, updateIds, function1322, (FetchMessagesData) obj2);
                                        return handleFetchMessagesResult$lambda$5;
                                    }
                                });
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            currentRange2 = currentRange7;
                            currentRange3 = resultRange2;
                            entityMessages2 = entityMessages5;
                            entityMessages3 = ghostMessages3;
                            ghostMessages2 = tempMsgs4;
                            result2 = result4;
                            stateScope = stateScope2;
                            needAck2 = needAck4;
                            Result.Companion companion2222 = Result.Companion;
                            boolean z2222 = performAck;
                            updateIds = Result.constructor-impl(ResultKt.createFailure(th));
                            needAck5 = needAck2;
                            state4 = state2;
                            entityMessages4 = ghostMessages2;
                            currentRange5 = currentRange2;
                            stateScope3 = stateScope;
                            currentRange6 = currentRange3;
                            performAck4 = z2222;
                            JobKt.ensureActive(fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.getContext());
                            it = Result.exceptionOrNull-impl(updateIds);
                            if (it != null) {
                            }
                            if (currentRange5 == null) {
                            }
                            State state5222 = state4;
                            final List list222 = entityMessages4;
                            final boolean z3222 = performAck4;
                            final Function1 function13222 = stateScope3;
                            return state5222.mutate(new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda15
                                public final Object invoke(Object obj2) {
                                    FetchMessagesData handleFetchMessagesResult$lambda$5;
                                    handleFetchMessagesResult$lambda$5 = FusionFetchMessagesServiceImpl.handleFetchMessagesResult$lambda$5(newRange, list222, z3222, this, updateIds, function13222, (FetchMessagesData) obj2);
                                    return handleFetchMessagesResult$lambda$5;
                                }
                            });
                        }
                        JobKt.ensureActive(fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.getContext());
                        it = Result.exceptionOrNull-impl(updateIds);
                        if (it != null) {
                            IMLog.Companion.e("ChatFetchService", "插入新消息或更新失败", it);
                        }
                        final LongRange newRange = (currentRange5 == null && FusionFetchMessagesServiceImplKt.isAdjacent(currentRange5, currentRange6)) ? FusionFetchMessagesServiceImplKt.merge(currentRange6, currentRange5) : currentRange6;
                        State state52222 = state4;
                        final List list2222 = entityMessages4;
                        final boolean z32222 = performAck4;
                        final Function1 function132222 = stateScope3;
                        return state52222.mutate(new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda15
                            public final Object invoke(Object obj2) {
                                FetchMessagesData handleFetchMessagesResult$lambda$5;
                                handleFetchMessagesResult$lambda$5 = FusionFetchMessagesServiceImpl.handleFetchMessagesResult$lambda$5(newRange, list2222, z32222, this, updateIds, function132222, (FetchMessagesData) obj2);
                                return handleFetchMessagesResult$lambda$5;
                            }
                        });
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$0 = state3;
                state2 = state3;
                fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$1 = SpillingKt.nullOutSpilledVariable(result2);
                fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$2 = stateScope;
                fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$3 = currentRange2;
                fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$4 = currentRange3;
                fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$5 = SpillingKt.nullOutSpilledVariable(entityMessages2);
                fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$6 = SpillingKt.nullOutSpilledVariable(entityMessages3);
                fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$7 = ghostMessages2;
                fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.Z$0 = needAck2;
                fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.Z$1 = performAck2;
                fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.I$0 = $i$f$runSuspendCatching3;
                fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.I$1 = $i$f$runSuspendCatching2;
                fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.label = 2;
                checkGhostMessage = checkGhostMessage(entityMessages2, entityMessages3, fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12);
                if (checkGhostMessage != coroutine_suspended) {
                    return coroutine_suspended;
                }
                performAck = performAck2;
                LongRange longRange = currentRange2;
                $result = checkGhostMessage;
                needAck4 = needAck2;
                stateScope2 = stateScope;
                currentRange4 = longRange;
                Object obj2 = Result.constructor-impl((Collection) $result);
                stateScope3 = stateScope2;
                state4 = state2;
                entityMessages4 = ghostMessages2;
                currentRange5 = currentRange4;
                currentRange6 = currentRange3;
                performAck4 = performAck;
                updateIds = obj2;
                needAck5 = needAck4;
                JobKt.ensureActive(fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.getContext());
                it = Result.exceptionOrNull-impl(updateIds);
                if (it != null) {
                }
                if (currentRange5 == null) {
                }
                State state522222 = state4;
                final List list22222 = entityMessages4;
                final boolean z322222 = performAck4;
                final Function1 function1322222 = stateScope3;
                return state522222.mutate(new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda15
                    public final Object invoke(Object obj22) {
                        FetchMessagesData handleFetchMessagesResult$lambda$5;
                        handleFetchMessagesResult$lambda$5 = FusionFetchMessagesServiceImpl.handleFetchMessagesResult$lambda$5(newRange, list22222, z322222, this, updateIds, function1322222, (FetchMessagesData) obj22);
                        return handleFetchMessagesResult$lambda$5;
                    }
                });
            }
        }
        fusionFetchMessagesServiceImpl$handleFetchMessagesResult$1 = new FusionFetchMessagesServiceImpl$handleFetchMessagesResult$1(this, continuation);
        fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12 = fusionFetchMessagesServiceImpl$handleFetchMessagesResult$1;
        Object $result2 = fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.label) {
        }
        fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$0 = state3;
        state2 = state3;
        fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$1 = SpillingKt.nullOutSpilledVariable(result2);
        fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$2 = stateScope;
        fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$3 = currentRange2;
        fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$4 = currentRange3;
        fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$5 = SpillingKt.nullOutSpilledVariable(entityMessages2);
        fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$6 = SpillingKt.nullOutSpilledVariable(entityMessages3);
        fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.L$7 = ghostMessages2;
        fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.Z$0 = needAck2;
        fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.Z$1 = performAck2;
        fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.I$0 = $i$f$runSuspendCatching3;
        fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.I$1 = $i$f$runSuspendCatching2;
        fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12.label = 2;
        checkGhostMessage = checkGhostMessage(entityMessages2, entityMessages3, fusionFetchMessagesServiceImpl$handleFetchMessagesResult$12);
        if (checkGhostMessage != coroutine_suspended) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object handleFetchMessagesResult$default(FusionFetchMessagesServiceImpl fusionFetchMessagesServiceImpl, State state, FetchMessagesResult fetchMessagesResult, boolean z, Function1 function1, Continuation continuation, int i, Object obj) {
        Function1 function12;
        if ((i & 8) == 0) {
            function12 = function1;
        } else {
            function12 = new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda24
                public final Object invoke(Object obj2) {
                    Unit handleFetchMessagesResult$lambda$0;
                    handleFetchMessagesResult$lambda$0 = FusionFetchMessagesServiceImpl.handleFetchMessagesResult$lambda$0((CopyScope) obj2);
                    return handleFetchMessagesResult$lambda$0;
                }
            };
        }
        return fusionFetchMessagesServiceImpl.handleFetchMessagesResult(state, fetchMessagesResult, z, function12, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleFetchMessagesResult$lambda$0(CopyScope copyScope) {
        Intrinsics.checkNotNullParameter(copyScope, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FetchMessagesData handleFetchMessagesResult$lambda$5(final LongRange $newRange, final List $tempMsgs, final boolean $performAck, final FusionFetchMessagesServiceImpl this$0, final Object $updateIds, final Function1 $stateScope, FetchMessagesData $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        return (FetchMessagesData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$$ExternalSyntheticLambda18
            public final Object invoke(Object obj) {
                Unit handleFetchMessagesResult$lambda$5$0;
                handleFetchMessagesResult$lambda$5$0 = FusionFetchMessagesServiceImpl.handleFetchMessagesResult$lambda$5$0($newRange, $tempMsgs, $performAck, this$0, $updateIds, $stateScope, (CopyScope) obj);
                return handleFetchMessagesResult$lambda$5$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleFetchMessagesResult$lambda$5$0(LongRange $newRange, List $tempMsgs, boolean $performAck, FusionFetchMessagesServiceImpl this$0, Object $updateIds, Function1 $stateScope, CopyScope $this$copy) {
        Intrinsics.checkNotNullParameter($this$copy, "$this$copy");
        $this$copy.set(FetchMessagesDataLensKt.getCurrentRange(FetchMessagesData.Companion), $newRange);
        BSetter tempMessages = FetchMessagesDataLensKt.getTempMessages(FetchMessagesData.Companion);
        Iterable $this$distinctBy$iv = CollectionsKt.plus((Collection) $this$copy.get(FetchMessagesDataLensKt.getTempMessages(FetchMessagesData.Companion)), $tempMsgs);
        HashSet set$iv = new HashSet();
        ArrayList list$iv = new ArrayList();
        for (Object e$iv : $this$distinctBy$iv) {
            EntityMessage it = (EntityMessage) e$iv;
            if (set$iv.add(Long.valueOf(it.getEntityKey()))) {
                list$iv.add(e$iv);
            }
        }
        ArrayList $this$distinctBy$iv2 = list$iv;
        $this$copy.set(tempMessages, $this$distinctBy$iv2);
        $this$copy.set(FetchMessagesDataLensKt.getPerformAck(FetchMessagesData.Companion), Boolean.valueOf(((Boolean) $this$copy.get(FetchMessagesDataLensKt.getPerformAck(FetchMessagesData.Companion))).booleanValue() || $performAck));
        List list = (Collection) (Result.isFailure-impl($updateIds) ? null : $updateIds);
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        this$0.setUpdateIds($this$copy, list);
        $stateScope.invoke($this$copy);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(9:5|6|7|8|15|16|(1:18)(1:21)|19|20))|30|6|7|8|15|16|(0)(0)|19|20) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005f, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0060, code lost:
        r4 = kotlin.Result.Companion;
        r2 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r2));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object performAckSession(Continuation<? super Unit> continuation) {
        FusionFetchMessagesServiceImpl$performAckSession$1 fusionFetchMessagesServiceImpl$performAckSession$1;
        Throwable e;
        Object ackSession;
        if (continuation instanceof FusionFetchMessagesServiceImpl$performAckSession$1) {
            fusionFetchMessagesServiceImpl$performAckSession$1 = (FusionFetchMessagesServiceImpl$performAckSession$1) continuation;
            if ((fusionFetchMessagesServiceImpl$performAckSession$1.label & Integer.MIN_VALUE) != 0) {
                fusionFetchMessagesServiceImpl$performAckSession$1.label -= Integer.MIN_VALUE;
                Object $result = fusionFetchMessagesServiceImpl$performAckSession$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (fusionFetchMessagesServiceImpl$performAckSession$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Result.Companion companion = Result.Companion;
                        KChatMoss kChatMoss = new KChatMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                        KAckSessionReq kAckSessionReq = new KAckSessionReq(this.kSessionId);
                        fusionFetchMessagesServiceImpl$performAckSession$1.I$0 = 0;
                        fusionFetchMessagesServiceImpl$performAckSession$1.I$1 = 0;
                        fusionFetchMessagesServiceImpl$performAckSession$1.label = 1;
                        ackSession = kChatMoss.ackSession(kAckSessionReq, fusionFetchMessagesServiceImpl$performAckSession$1);
                        if (ackSession != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i = fusionFetchMessagesServiceImpl$performAckSession$1.I$1;
                        int i2 = fusionFetchMessagesServiceImpl$performAckSession$1.I$0;
                        ResultKt.throwOnFailure($result);
                        ackSession = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Object obj = Result.constructor-impl((KAckSessionReply) ackSession);
                JobKt.ensureActive(fusionFetchMessagesServiceImpl$performAckSession$1.getContext());
                e = Result.exceptionOrNull-impl(obj);
                if (e != null) {
                    KAckSessionReply kAckSessionReply = (KAckSessionReply) obj;
                    IMLog.Companion.i("ChatFetchService", "ack消息成功 session = " + this.sessionId);
                } else {
                    IMLog.Companion.e("ChatFetchService", "ack消息失败 session = " + this.sessionId, e);
                }
                return Unit.INSTANCE;
            }
        }
        fusionFetchMessagesServiceImpl$performAckSession$1 = new FusionFetchMessagesServiceImpl$performAckSession$1(this, continuation);
        Object $result2 = fusionFetchMessagesServiceImpl$performAckSession$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (fusionFetchMessagesServiceImpl$performAckSession$1.label) {
        }
        Object obj2 = Result.constructor-impl((KAckSessionReply) ackSession);
        JobKt.ensureActive(fusionFetchMessagesServiceImpl$performAckSession$1.getContext());
        e = Result.exceptionOrNull-impl(obj2);
        if (e != null) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object checkGhostMessage(List<EntityMessage> list, List<GhostMessage> list2, Continuation<? super Collection<MessageId>> continuation) {
        FusionFetchMessagesServiceImpl$checkGhostMessage$1 fusionFetchMessagesServiceImpl$checkGhostMessage$1;
        List ghostMessages;
        Object obj;
        List entityMessages;
        boolean z;
        boolean z2;
        boolean z3;
        if (continuation instanceof FusionFetchMessagesServiceImpl$checkGhostMessage$1) {
            fusionFetchMessagesServiceImpl$checkGhostMessage$1 = (FusionFetchMessagesServiceImpl$checkGhostMessage$1) continuation;
            if ((fusionFetchMessagesServiceImpl$checkGhostMessage$1.label & Integer.MIN_VALUE) != 0) {
                fusionFetchMessagesServiceImpl$checkGhostMessage$1.label -= Integer.MIN_VALUE;
                Object $result = fusionFetchMessagesServiceImpl$checkGhostMessage$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (fusionFetchMessagesServiceImpl$checkGhostMessage$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        RangeDatabaseService rangeDatabaseService = this.rangeDatabaseService;
                        fusionFetchMessagesServiceImpl$checkGhostMessage$1.L$0 = list;
                        fusionFetchMessagesServiceImpl$checkGhostMessage$1.L$1 = list2;
                        fusionFetchMessagesServiceImpl$checkGhostMessage$1.label = 1;
                        Object queryAll = rangeDatabaseService.queryAll(fusionFetchMessagesServiceImpl$checkGhostMessage$1);
                        if (queryAll != coroutine_suspended) {
                            ghostMessages = list2;
                            obj = queryAll;
                            entityMessages = list;
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        ghostMessages = (List) fusionFetchMessagesServiceImpl$checkGhostMessage$1.L$1;
                        entityMessages = (List) fusionFetchMessagesServiceImpl$checkGhostMessage$1.L$0;
                        ResultKt.throwOnFailure($result);
                        obj = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Iterable ranges = (List) obj;
                List $this$mapNotNull$iv = ghostMessages;
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                    GhostMessage it = (GhostMessage) element$iv$iv$iv;
                    MessageId associatedMsgId = it.getAssociatedMsgId();
                    if (associatedMsgId != null) {
                        destination$iv$iv.add(associatedMsgId);
                    }
                }
                Collection destination$iv$iv2 = new ArrayList();
                for (Object element$iv$iv : (List) destination$iv$iv) {
                    MessageId id = (MessageId) element$iv$iv;
                    Iterable $this$any$iv = ranges;
                    if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
                        z2 = false;
                    } else {
                        Iterator it2 = $this$any$iv.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                Object element$iv = it2.next();
                                LongRange range = (LongRange) element$iv;
                                long first = range.getFirst();
                                long last = range.getLast();
                                long sequenceNumber = id.getSequenceNumber();
                                if (first > sequenceNumber || sequenceNumber > last) {
                                    z3 = false;
                                    continue;
                                } else {
                                    z3 = true;
                                    continue;
                                }
                                if (z3) {
                                    z2 = true;
                                }
                            } else {
                                z2 = false;
                            }
                        }
                    }
                    if (z2) {
                        destination$iv$iv2.add(element$iv$iv);
                    }
                }
                Iterable $this$filter$iv = (List) destination$iv$iv2;
                Collection destination$iv$iv3 = new ArrayList();
                for (Object element$iv$iv2 : $this$filter$iv) {
                    MessageId id2 = (MessageId) element$iv$iv2;
                    List $this$any$iv2 = entityMessages;
                    Iterable $this$filter$iv2 = $this$filter$iv;
                    if (($this$any$iv2 instanceof Collection) && $this$any$iv2.isEmpty()) {
                        z = false;
                    } else {
                        Iterator it3 = $this$any$iv2.iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                Object element$iv2 = it3.next();
                                EntityMessage it4 = (EntityMessage) element$iv2;
                                Iterator it5 = it3;
                                if (Intrinsics.areEqual(it4.getMsgId(), id2)) {
                                    z = true;
                                } else {
                                    it3 = it5;
                                }
                            } else {
                                z = false;
                            }
                        }
                    }
                    if (!z) {
                        destination$iv$iv3.add(element$iv$iv2);
                    }
                    $this$filter$iv = $this$filter$iv2;
                }
                return (List) destination$iv$iv3;
            }
        }
        fusionFetchMessagesServiceImpl$checkGhostMessage$1 = new FusionFetchMessagesServiceImpl$checkGhostMessage$1(this, continuation);
        Object $result2 = fusionFetchMessagesServiceImpl$checkGhostMessage$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (fusionFetchMessagesServiceImpl$checkGhostMessage$1.label) {
        }
        Iterable ranges2 = (List) obj;
        List $this$mapNotNull$iv2 = ghostMessages;
        Collection destination$iv$iv4 = new ArrayList();
        while (r15.hasNext()) {
        }
        Collection destination$iv$iv22 = new ArrayList();
        while (r12.hasNext()) {
        }
        Iterable $this$filter$iv3 = (List) destination$iv$iv22;
        Collection destination$iv$iv32 = new ArrayList();
        while (r11.hasNext()) {
        }
        return (List) destination$iv$iv32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0129 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x012a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object updateEntityMessages(List<EntityMessage> list, LongRange resultRange, LongRange currentRange, Continuation<? super Unit> continuation) {
        FusionFetchMessagesServiceImpl$updateEntityMessages$1 fusionFetchMessagesServiceImpl$updateEntityMessages$1;
        LongRange currentRange2;
        LongRange resultRange2;
        RangeDatabaseService rangeDatabaseService;
        List entityMessages = list;
        if (continuation instanceof FusionFetchMessagesServiceImpl$updateEntityMessages$1) {
            fusionFetchMessagesServiceImpl$updateEntityMessages$1 = (FusionFetchMessagesServiceImpl$updateEntityMessages$1) continuation;
            if ((fusionFetchMessagesServiceImpl$updateEntityMessages$1.label & Integer.MIN_VALUE) != 0) {
                fusionFetchMessagesServiceImpl$updateEntityMessages$1.label -= Integer.MIN_VALUE;
                Object $result = fusionFetchMessagesServiceImpl$updateEntityMessages$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (fusionFetchMessagesServiceImpl$updateEntityMessages$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        IMLog.Companion.i("ChatFetchService", "数据库准备写入 " + entityMessages.size() + " 条消息, 范围[" + resultRange.getFirst() + ", " + resultRange.getLast() + "]");
                        MessageDatabaseService messageDatabaseService = this.messageDatabaseService;
                        fusionFetchMessagesServiceImpl$updateEntityMessages$1.L$0 = SpillingKt.nullOutSpilledVariable(list);
                        currentRange2 = resultRange;
                        fusionFetchMessagesServiceImpl$updateEntityMessages$1.L$1 = currentRange2;
                        resultRange2 = currentRange;
                        fusionFetchMessagesServiceImpl$updateEntityMessages$1.L$2 = resultRange2;
                        fusionFetchMessagesServiceImpl$updateEntityMessages$1.label = 1;
                        if (messageDatabaseService.add((List<EntityMessage>) entityMessages, (Continuation<? super Unit>) fusionFetchMessagesServiceImpl$updateEntityMessages$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (resultRange2 != null || currentRange2.getFirst() < resultRange2.getFirst() || currentRange2.getLast() > resultRange2.getLast()) {
                            IMLog.Companion.i("ChatFetchService", "数据库准备range, 范围[" + currentRange2.getFirst() + ", " + currentRange2.getLast() + "]");
                            rangeDatabaseService = this.rangeDatabaseService;
                            fusionFetchMessagesServiceImpl$updateEntityMessages$1.L$0 = SpillingKt.nullOutSpilledVariable(entityMessages);
                            fusionFetchMessagesServiceImpl$updateEntityMessages$1.L$1 = SpillingKt.nullOutSpilledVariable(currentRange2);
                            fusionFetchMessagesServiceImpl$updateEntityMessages$1.L$2 = SpillingKt.nullOutSpilledVariable(resultRange2);
                            fusionFetchMessagesServiceImpl$updateEntityMessages$1.label = 2;
                            if (rangeDatabaseService.add(currentRange2, fusionFetchMessagesServiceImpl$updateEntityMessages$1) != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        LongRange currentRange3 = (LongRange) fusionFetchMessagesServiceImpl$updateEntityMessages$1.L$2;
                        LongRange resultRange3 = (LongRange) fusionFetchMessagesServiceImpl$updateEntityMessages$1.L$1;
                        entityMessages = (List) fusionFetchMessagesServiceImpl$updateEntityMessages$1.L$0;
                        ResultKt.throwOnFailure($result);
                        resultRange2 = currentRange3;
                        currentRange2 = resultRange3;
                        if (resultRange2 != null) {
                            break;
                        }
                        IMLog.Companion.i("ChatFetchService", "数据库准备range, 范围[" + currentRange2.getFirst() + ", " + currentRange2.getLast() + "]");
                        rangeDatabaseService = this.rangeDatabaseService;
                        fusionFetchMessagesServiceImpl$updateEntityMessages$1.L$0 = SpillingKt.nullOutSpilledVariable(entityMessages);
                        fusionFetchMessagesServiceImpl$updateEntityMessages$1.L$1 = SpillingKt.nullOutSpilledVariable(currentRange2);
                        fusionFetchMessagesServiceImpl$updateEntityMessages$1.L$2 = SpillingKt.nullOutSpilledVariable(resultRange2);
                        fusionFetchMessagesServiceImpl$updateEntityMessages$1.label = 2;
                        if (rangeDatabaseService.add(currentRange2, fusionFetchMessagesServiceImpl$updateEntityMessages$1) != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        LongRange longRange = (LongRange) fusionFetchMessagesServiceImpl$updateEntityMessages$1.L$2;
                        LongRange longRange2 = (LongRange) fusionFetchMessagesServiceImpl$updateEntityMessages$1.L$1;
                        List list2 = (List) fusionFetchMessagesServiceImpl$updateEntityMessages$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        fusionFetchMessagesServiceImpl$updateEntityMessages$1 = new FusionFetchMessagesServiceImpl$updateEntityMessages$1(this, continuation);
        Object $result2 = fusionFetchMessagesServiceImpl$updateEntityMessages$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (fusionFetchMessagesServiceImpl$updateEntityMessages$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setUpdateIds(CopyScope<FetchMessagesData> copyScope, Collection<MessageId> collection) {
        Iterable $this$sortedBy$iv = CollectionsKt.distinct(CollectionsKt.plus((Collection) copyScope.get(FetchMessagesDataLensKt.getUpdateMsgIds(FetchMessagesData.Companion)), collection));
        copyScope.set(FetchMessagesDataLensKt.getUpdateMsgIds(FetchMessagesData.Companion), CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: kntr.app.im.chat.service.FusionFetchMessagesServiceImpl$setUpdateIds$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                MessageId it = (MessageId) t;
                MessageId it2 = (MessageId) t2;
                return ComparisonsKt.compareValues(it.getSequence(), it2.getSequence());
            }
        }));
    }
}