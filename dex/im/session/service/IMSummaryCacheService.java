package im.session.service;

import com.bapis.bilibili.app.im.v1.KMsgSummary;
import com.bapis.bilibili.app.im.v1.KMsgSummaryPrefixType;
import com.bapis.bilibili.app.im.v1.KSessionId;
import com.bapis.bilibili.app.im.v1.KUnread;
import com.tencent.smtt.sdk.TbsListener;
import im.base.IMLog;
import im.session.base.ConversationDraftHolder;
import im.session.base.IMConversationDraftService;
import im.session.base.IMSessionDraftService;
import im.session.di.IMSessionScope;
import im.session.log.LogTagKt;
import im.session.model.IMSessionCard;
import im.session.model.IMSessionPageDataKt;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: IMMessageSummaryService.kt */
@IMSessionScope
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0015\u001a\u00020\u0016H\u0080@¢\u0006\u0004\b\u0017\u0010\u0018J \u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u0006\u0010\u001a\u001a\u00020\u001bH\u0080@¢\u0006\u0004\b\u001c\u0010\u001dJ\u0013\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00140\u001fH\u0000¢\u0006\u0002\b J\u0016\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u001bH\u0087@¢\u0006\u0002\u0010\u001dJ\"\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\u000f2\b\u0010&\u001a\u0004\u0018\u00010$H\u0082@¢\u0006\u0002\u0010'J\u0018\u0010(\u001a\u0004\u0018\u00010$2\u0006\u0010\"\u001a\u00020\u001bH\u0082@¢\u0006\u0002\u0010\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lim/session/service/IMSummaryCacheService;", "", "service", "Lim/session/base/IMConversationDraftService;", "<init>", "(Lim/session/base/IMConversationDraftService;)V", "scopeInject", "Lkotlinx/coroutines/CoroutineScope;", "scope", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "mapLock", "Lkotlinx/coroutines/sync/Mutex;", "map", "", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "Lkotlinx/coroutines/flow/StateFlow;", "Lim/session/service/Summary;", "draftNotifyFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lim/session/service/ConversationSummaryHolder;", "initScope", "", "initScope$session_debug", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observe", "session", "Lim/session/model/IMSessionCard;", "observe$session_debug", "(Lim/session/model/IMSessionCard;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllDraftFlow", "Lkotlinx/coroutines/flow/Flow;", "getAllDraftFlow$session_debug", "markAsRead", "card", "getEmptySummary", "Lcom/bapis/bilibili/app/im/v1/KMsgSummary;", "id", "currentSummary", "(Lcom/bapis/bilibili/app/im/v1/KSessionId;Lcom/bapis/bilibili/app/im/v1/KMsgSummary;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "summaryAfterRead", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSummaryCacheService {
    private final MutableSharedFlow<ConversationSummaryHolder> draftNotifyFlow;
    private final Map<KSessionId, StateFlow<Summary>> map;
    private final Mutex mapLock;
    private CoroutineScope scopeInject;
    private final IMConversationDraftService service;

    @Inject
    public IMSummaryCacheService(@IMSessionDraftService IMConversationDraftService service) {
        Intrinsics.checkNotNullParameter(service, "service");
        this.service = service;
        this.mapLock = MutexKt.Mutex$default(false, 1, (Object) null);
        this.map = new LinkedHashMap();
        this.draftNotifyFlow = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
    }

    private final CoroutineScope getScope() {
        CoroutineScope coroutineScope = this.scopeInject;
        if (coroutineScope == null) {
            throw new IllegalArgumentException("Call initScope() before using this service".toString());
        }
        return coroutineScope;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object initScope$session_debug(Continuation<?> continuation) {
        Continuation $continuation;
        if (continuation instanceof IMSummaryCacheService$initScope$1) {
            $continuation = (IMSummaryCacheService$initScope$1) continuation;
            if (($continuation.label & Integer.MIN_VALUE) != 0) {
                $continuation.label -= Integer.MIN_VALUE;
                Object $result = $continuation.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch ($continuation.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $continuation.I$0 = 0;
                        $continuation.label = 1;
                        Continuation uCont$iv = $continuation;
                        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
                        cancellableContinuationImpl.initCancellability();
                        CancellableContinuation it = cancellableContinuationImpl;
                        this.scopeInject = CoroutineScopeKt.CoroutineScope(it.getContext());
                        IMLog.Companion.d(LogTagKt.getSummaryLogTag(), "IMSummaryCacheService initScope");
                        it.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: im.session.service.IMSummaryCacheService$initScope$2$1
                            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                                invoke((Throwable) p1);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Throwable t) {
                                CoroutineScope coroutineScope;
                                Map map;
                                coroutineScope = IMSummaryCacheService.this.scopeInject;
                                if (coroutineScope != null) {
                                    CoroutineScopeKt.cancel(coroutineScope, "Parent scope cancelled", t);
                                }
                                IMSummaryCacheService.this.scopeInject = null;
                                map = IMSummaryCacheService.this.map;
                                map.clear();
                                IMLog.Companion.d(LogTagKt.getSummaryLogTag(), "IMSummaryCacheService cancelled");
                            }
                        });
                        Object result = cancellableContinuationImpl.getResult();
                        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            DebugProbesKt.probeCoroutineSuspended($continuation);
                        }
                        if (result != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i2 = $continuation.I$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                throw new KotlinNothingValueException();
            }
        }
        $continuation = new IMSummaryCacheService$initScope$1(this, continuation);
        Object $result2 = $continuation.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
        }
        throw new KotlinNothingValueException();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009b A[Catch: all -> 0x0122, TRY_LEAVE, TryCatch #1 {all -> 0x0122, blocks: (B:23:0x008c, B:25:0x009b), top: B:46:0x008c }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object observe$session_debug(IMSessionCard session, Continuation<? super StateFlow<Summary>> continuation) {
        IMSummaryCacheService$observe$1 iMSummaryCacheService$observe$1;
        IMSummaryCacheService$observe$1 iMSummaryCacheService$observe$12;
        int $i$f$withLock;
        IMSessionCard session2;
        Mutex $this$withLock_u24default$iv;
        Object owner$iv;
        KSessionId id;
        Map $this$getOrPut$iv;
        StateFlow<Summary> stateFlow;
        StateFlow stateFlow2;
        IMSessionCard session3;
        if (continuation instanceof IMSummaryCacheService$observe$1) {
            iMSummaryCacheService$observe$1 = (IMSummaryCacheService$observe$1) continuation;
            if ((iMSummaryCacheService$observe$1.label & Integer.MIN_VALUE) != 0) {
                iMSummaryCacheService$observe$1.label -= Integer.MIN_VALUE;
                iMSummaryCacheService$observe$12 = iMSummaryCacheService$observe$1;
                Object $result = iMSummaryCacheService$observe$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (iMSummaryCacheService$observe$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Mutex $this$withLock_u24default$iv2 = this.mapLock;
                        $i$f$withLock = 0;
                        session2 = session;
                        iMSummaryCacheService$observe$12.L$0 = session2;
                        iMSummaryCacheService$observe$12.L$1 = $this$withLock_u24default$iv2;
                        iMSummaryCacheService$observe$12.I$0 = 0;
                        iMSummaryCacheService$observe$12.label = 1;
                        if ($this$withLock_u24default$iv2.lock((Object) null, iMSummaryCacheService$observe$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $this$withLock_u24default$iv = $this$withLock_u24default$iv2;
                        owner$iv = null;
                        try {
                            Map map = this.map;
                            id = session2.getId();
                            $this$getOrPut$iv = map;
                            stateFlow = $this$getOrPut$iv.get(id);
                            if (stateFlow == null) {
                                stateFlow2 = stateFlow;
                                StateFlow stateFlow3 = stateFlow2;
                                $this$withLock_u24default$iv.unlock(owner$iv);
                                return stateFlow3;
                            }
                            final Flow $this$map$iv = this.service.observe(session2.getId());
                            try {
                                Flow rawFlow = new Flow<Summary>() { // from class: im.session.service.IMSummaryCacheService$observe$lambda$0$0$$inlined$map$1
                                    public Object collect(FlowCollector collector, Continuation $completion) {
                                        Object collect = $this$map$iv.collect(new AnonymousClass2(collector), $completion);
                                        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                                    }

                                    /* compiled from: Emitters.kt */
                                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                                    /* renamed from: im.session.service.IMSummaryCacheService$observe$lambda$0$0$$inlined$map$1$2  reason: invalid class name */
                                    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
                                    public static final class AnonymousClass2<T> implements FlowCollector {
                                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                                        /* compiled from: Emitters.kt */
                                        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                                        @DebugMetadata(c = "im.session.service.IMSummaryCacheService$observe$lambda$0$0$$inlined$map$1$2", f = "IMMessageSummaryService.kt", i = {0, 0, 0, 0, 0}, l = {TbsListener.ErrorCode.RENAME_EXCEPTION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                                        /* renamed from: im.session.service.IMSummaryCacheService$observe$lambda$0$0$$inlined$map$1$2$1  reason: invalid class name */
                                        /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
                                        public static final class AnonymousClass1 extends ContinuationImpl {
                                            int I$0;
                                            Object L$0;
                                            Object L$1;
                                            Object L$2;
                                            Object L$3;
                                            int label;
                                            /* synthetic */ Object result;

                                            public AnonymousClass1(Continuation continuation) {
                                                super(continuation);
                                            }

                                            public final Object invokeSuspend(Object obj) {
                                                this.result = obj;
                                                this.label |= Integer.MIN_VALUE;
                                                return AnonymousClass2.this.emit(null, (Continuation) this);
                                            }
                                        }

                                        public AnonymousClass2(FlowCollector flowCollector) {
                                            this.$this_unsafeFlow = flowCollector;
                                        }

                                        /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
                                        /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
                                        /* JADX WARN: Removed duplicated region for block: B:13:0x0043  */
                                        /*
                                            Code decompiled incorrectly, please refer to instructions dump.
                                        */
                                        public final Object emit(Object value, Continuation $completion) {
                                            Continuation $continuation;
                                            if ($completion instanceof AnonymousClass1) {
                                                $continuation = (AnonymousClass1) $completion;
                                                if (($continuation.label & Integer.MIN_VALUE) != 0) {
                                                    $continuation.label -= Integer.MIN_VALUE;
                                                    Object $result = $continuation.result;
                                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                    switch ($continuation.label) {
                                                        case 0:
                                                            ResultKt.throwOnFailure($result);
                                                            FlowCollector $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                                            AnonymousClass1 anonymousClass1 = $continuation;
                                                            ConversationDraftHolder it = (ConversationDraftHolder) value;
                                                            Summary summary = null;
                                                            if (it != null) {
                                                                boolean z = false;
                                                                if (!StringsKt.isBlank(it.getPrefix())) {
                                                                    if (it.getContent().length() > 0) {
                                                                        z = true;
                                                                    }
                                                                }
                                                                ConversationDraftHolder conversationDraftHolder = z ? it : null;
                                                                if (conversationDraftHolder != null) {
                                                                    ConversationDraftHolder it2 = conversationDraftHolder;
                                                                    summary = new Summary(new SummaryPrefix(it2.getPrefix(), SummaryPrefixType.Draft), it2.getContent());
                                                                }
                                                            }
                                                            $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                                            $continuation.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                                            $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                                            $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
                                                            $continuation.I$0 = 0;
                                                            $continuation.label = 1;
                                                            if ($this$map_u24lambda_u245.emit(summary, $continuation) != coroutine_suspended) {
                                                                break;
                                                            } else {
                                                                return coroutine_suspended;
                                                            }
                                                        case 1:
                                                            int i2 = $continuation.I$0;
                                                            FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                                            Object obj = $continuation.L$2;
                                                            AnonymousClass1 anonymousClass12 = (AnonymousClass1) $continuation.L$1;
                                                            Object obj2 = $continuation.L$0;
                                                            ResultKt.throwOnFailure($result);
                                                            break;
                                                        default:
                                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }
                                            $continuation = new AnonymousClass1($completion);
                                            Object $result2 = $continuation.result;
                                            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            switch ($continuation.label) {
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }
                                };
                                CoroutineScope scope = getScope();
                                iMSummaryCacheService$observe$12.L$0 = session2;
                                iMSummaryCacheService$observe$12.L$1 = $this$withLock_u24default$iv;
                                iMSummaryCacheService$observe$12.L$2 = $this$getOrPut$iv;
                                iMSummaryCacheService$observe$12.L$3 = id;
                                iMSummaryCacheService$observe$12.L$4 = SpillingKt.nullOutSpilledVariable(stateFlow);
                                iMSummaryCacheService$observe$12.L$5 = SpillingKt.nullOutSpilledVariable(rawFlow);
                                iMSummaryCacheService$observe$12.I$0 = $i$f$withLock;
                                iMSummaryCacheService$observe$12.I$1 = 0;
                                iMSummaryCacheService$observe$12.I$2 = 0;
                                iMSummaryCacheService$observe$12.I$3 = 0;
                                iMSummaryCacheService$observe$12.label = 2;
                                $result = FlowKt.stateIn(rawFlow, scope, iMSummaryCacheService$observe$12);
                                if ($result == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                session3 = session2;
                                try {
                                    StateFlow stateFlow4 = (StateFlow) $result;
                                    BuildersKt.launch$default(getScope(), (CoroutineContext) null, (CoroutineStart) null, new IMSummaryCacheService$observe$2$1$1(stateFlow4, session3, this, null), 3, (Object) null);
                                    stateFlow2 = stateFlow4;
                                    $this$getOrPut$iv.put(id, stateFlow2);
                                    StateFlow stateFlow32 = stateFlow2;
                                    $this$withLock_u24default$iv.unlock(owner$iv);
                                    return stateFlow32;
                                } catch (Throwable th) {
                                    th = th;
                                    $this$withLock_u24default$iv.unlock(owner$iv);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                $this$withLock_u24default$iv.unlock(owner$iv);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    case 1:
                        int $i$f$withLock2 = iMSummaryCacheService$observe$12.I$0;
                        session2 = (IMSessionCard) iMSummaryCacheService$observe$12.L$0;
                        ResultKt.throwOnFailure($result);
                        owner$iv = null;
                        $this$withLock_u24default$iv = (Mutex) iMSummaryCacheService$observe$12.L$1;
                        $i$f$withLock = $i$f$withLock2;
                        Map map2 = this.map;
                        id = session2.getId();
                        $this$getOrPut$iv = map2;
                        stateFlow = $this$getOrPut$iv.get(id);
                        if (stateFlow == null) {
                        }
                        break;
                    case 2:
                        int i2 = iMSummaryCacheService$observe$12.I$3;
                        int i3 = iMSummaryCacheService$observe$12.I$2;
                        int i4 = iMSummaryCacheService$observe$12.I$1;
                        int i5 = iMSummaryCacheService$observe$12.I$0;
                        Flow flow = (Flow) iMSummaryCacheService$observe$12.L$5;
                        Object obj = iMSummaryCacheService$observe$12.L$4;
                        id = (KSessionId) iMSummaryCacheService$observe$12.L$3;
                        $this$getOrPut$iv = (Map) iMSummaryCacheService$observe$12.L$2;
                        owner$iv = null;
                        $this$withLock_u24default$iv = (Mutex) iMSummaryCacheService$observe$12.L$1;
                        session3 = (IMSessionCard) iMSummaryCacheService$observe$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            StateFlow stateFlow42 = (StateFlow) $result;
                            BuildersKt.launch$default(getScope(), (CoroutineContext) null, (CoroutineStart) null, new IMSummaryCacheService$observe$2$1$1(stateFlow42, session3, this, null), 3, (Object) null);
                            stateFlow2 = stateFlow42;
                            $this$getOrPut$iv.put(id, stateFlow2);
                            StateFlow stateFlow322 = stateFlow2;
                            $this$withLock_u24default$iv.unlock(owner$iv);
                            return stateFlow322;
                        } catch (Throwable th4) {
                            th = th4;
                            $this$withLock_u24default$iv.unlock(owner$iv);
                            throw th;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        iMSummaryCacheService$observe$1 = new IMSummaryCacheService$observe$1(this, continuation);
        iMSummaryCacheService$observe$12 = iMSummaryCacheService$observe$1;
        Object $result2 = iMSummaryCacheService$observe$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (iMSummaryCacheService$observe$12.label) {
        }
    }

    public final Flow<ConversationSummaryHolder> getAllDraftFlow$session_debug() {
        return this.draftNotifyFlow;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object markAsRead(IMSessionCard card, Continuation<? super IMSessionCard> continuation) {
        IMSummaryCacheService$markAsRead$1 iMSummaryCacheService$markAsRead$1;
        Object summaryAfterRead;
        IMSessionCard iMSessionCard;
        KUnread kUnread;
        if (continuation instanceof IMSummaryCacheService$markAsRead$1) {
            iMSummaryCacheService$markAsRead$1 = (IMSummaryCacheService$markAsRead$1) continuation;
            if ((iMSummaryCacheService$markAsRead$1.label & Integer.MIN_VALUE) != 0) {
                iMSummaryCacheService$markAsRead$1.label -= Integer.MIN_VALUE;
                Object $result = iMSummaryCacheService$markAsRead$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (iMSummaryCacheService$markAsRead$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        KUnread none = IMSessionPageDataKt.none(KUnread.Companion);
                        iMSummaryCacheService$markAsRead$1.L$0 = SpillingKt.nullOutSpilledVariable(card);
                        iMSummaryCacheService$markAsRead$1.L$1 = card;
                        iMSummaryCacheService$markAsRead$1.L$2 = none;
                        iMSummaryCacheService$markAsRead$1.label = 1;
                        summaryAfterRead = summaryAfterRead(card, iMSummaryCacheService$markAsRead$1);
                        if (summaryAfterRead == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        iMSessionCard = card;
                        kUnread = none;
                        break;
                    case 1:
                        IMSessionCard iMSessionCard2 = (IMSessionCard) iMSummaryCacheService$markAsRead$1.L$0;
                        ResultKt.throwOnFailure($result);
                        summaryAfterRead = $result;
                        kUnread = (KUnread) iMSummaryCacheService$markAsRead$1.L$2;
                        iMSessionCard = (IMSessionCard) iMSummaryCacheService$markAsRead$1.L$1;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return IMSessionCard.copy$default(iMSessionCard, null, null, kUnread, (KMsgSummary) summaryAfterRead, null, false, 0L, false, null, null, null, null, 4083, null);
            }
        }
        iMSummaryCacheService$markAsRead$1 = new IMSummaryCacheService$markAsRead$1(this, continuation);
        Object $result2 = iMSummaryCacheService$markAsRead$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (iMSummaryCacheService$markAsRead$1.label) {
        }
        return IMSessionCard.copy$default(iMSessionCard, null, null, kUnread, (KMsgSummary) summaryAfterRead, null, false, 0L, false, null, null, null, null, 4083, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getEmptySummary(KSessionId id, KMsgSummary currentSummary, Continuation<? super KMsgSummary> continuation) {
        IMSummaryCacheService$getEmptySummary$1 iMSummaryCacheService$getEmptySummary$1;
        String str;
        Object defaultSummaryOfFold;
        String rawMsg;
        KMsgSummaryPrefixType prefixType;
        if (continuation instanceof IMSummaryCacheService$getEmptySummary$1) {
            iMSummaryCacheService$getEmptySummary$1 = (IMSummaryCacheService$getEmptySummary$1) continuation;
            if ((iMSummaryCacheService$getEmptySummary$1.label & Integer.MIN_VALUE) != 0) {
                iMSummaryCacheService$getEmptySummary$1.label -= Integer.MIN_VALUE;
                Object $result = iMSummaryCacheService$getEmptySummary$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (iMSummaryCacheService$getEmptySummary$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        str = null;
                        if (currentSummary == null) {
                            return null;
                        }
                        KSessionId.KFoldId id2 = id.getId();
                        if (id2 instanceof KSessionId.KFoldId) {
                            iMSummaryCacheService$getEmptySummary$1.L$0 = SpillingKt.nullOutSpilledVariable(id);
                            iMSummaryCacheService$getEmptySummary$1.L$1 = currentSummary;
                            iMSummaryCacheService$getEmptySummary$1.L$2 = SpillingKt.nullOutSpilledVariable(id2);
                            iMSummaryCacheService$getEmptySummary$1.label = 1;
                            defaultSummaryOfFold = IMMessageSummaryServiceKt.getDefaultSummaryOfFold(id2, iMSummaryCacheService$getEmptySummary$1);
                            if (defaultSummaryOfFold != coroutine_suspended) {
                                str = (String) defaultSummaryOfFold;
                                break;
                            } else {
                                return coroutine_suspended;
                            }
                        }
                        break;
                    case 1:
                        KSessionId.IId iId = (KSessionId.IId) iMSummaryCacheService$getEmptySummary$1.L$2;
                        currentSummary = (KMsgSummary) iMSummaryCacheService$getEmptySummary$1.L$1;
                        KSessionId kSessionId = (KSessionId) iMSummaryCacheService$getEmptySummary$1.L$0;
                        ResultKt.throwOnFailure($result);
                        defaultSummaryOfFold = $result;
                        str = (String) defaultSummaryOfFold;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (str == null) {
                    rawMsg = str;
                } else {
                    rawMsg = currentSummary.getRawMsg();
                }
                prefixType = IMMessageSummaryServiceKt.removeUnread(currentSummary.getPrefixType());
                String prefixText = !Intrinsics.areEqual(prefixType, KMsgSummaryPrefixType.MSG_SUMMARY_PREFIX_TYPE_NONE.INSTANCE) ? "" : currentSummary.getPrefixText();
                return new KMsgSummary(rawMsg, prefixType, prefixText, false, 8, (DefaultConstructorMarker) null);
            }
        }
        iMSummaryCacheService$getEmptySummary$1 = new IMSummaryCacheService$getEmptySummary$1(this, continuation);
        Object $result2 = iMSummaryCacheService$getEmptySummary$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (iMSummaryCacheService$getEmptySummary$1.label) {
        }
        if (str == null) {
        }
        prefixType = IMMessageSummaryServiceKt.removeUnread(currentSummary.getPrefixType());
        String prefixText2 = !Intrinsics.areEqual(prefixType, KMsgSummaryPrefixType.MSG_SUMMARY_PREFIX_TYPE_NONE.INSTANCE) ? "" : currentSummary.getPrefixText();
        return new KMsgSummary(rawMsg, prefixType, prefixText2, false, 8, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object summaryAfterRead(IMSessionCard card, Continuation<? super KMsgSummary> continuation) {
        IMSummaryCacheService$summaryAfterRead$1 iMSummaryCacheService$summaryAfterRead$1;
        Object emptySummary;
        if (continuation instanceof IMSummaryCacheService$summaryAfterRead$1) {
            iMSummaryCacheService$summaryAfterRead$1 = (IMSummaryCacheService$summaryAfterRead$1) continuation;
            if ((iMSummaryCacheService$summaryAfterRead$1.label & Integer.MIN_VALUE) != 0) {
                iMSummaryCacheService$summaryAfterRead$1.label -= Integer.MIN_VALUE;
                Object $result = iMSummaryCacheService$summaryAfterRead$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (iMSummaryCacheService$summaryAfterRead$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        KSessionId id = card.getId();
                        KMsgSummary msgSummary$session_debug = card.getMsgSummary$session_debug();
                        iMSummaryCacheService$summaryAfterRead$1.L$0 = SpillingKt.nullOutSpilledVariable(card);
                        iMSummaryCacheService$summaryAfterRead$1.label = 1;
                        emptySummary = getEmptySummary(id, msgSummary$session_debug, iMSummaryCacheService$summaryAfterRead$1);
                        if (emptySummary == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        IMSessionCard iMSessionCard = (IMSessionCard) iMSummaryCacheService$summaryAfterRead$1.L$0;
                        ResultKt.throwOnFailure($result);
                        emptySummary = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                KMsgSummary newSummaryContent = (KMsgSummary) emptySummary;
                return newSummaryContent;
            }
        }
        iMSummaryCacheService$summaryAfterRead$1 = new IMSummaryCacheService$summaryAfterRead$1(this, continuation);
        Object $result2 = iMSummaryCacheService$summaryAfterRead$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (iMSummaryCacheService$summaryAfterRead$1.label) {
        }
        KMsgSummary newSummaryContent2 = (KMsgSummary) emptySummary;
        return newSummaryContent2;
    }
}