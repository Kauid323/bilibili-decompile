package kntr.app.im.chat.network;

import com.bapis.bilibili.app.im.v1.KSessionId;
import com.bapis.bilibili.broadcast.message.im.KCmdId;
import com.bapis.bilibili.broadcast.message.im.KCommandMsg;
import com.bapis.bilibili.broadcast.message.im.KFetchMessageCommand;
import com.bapis.bilibili.broadcast.message.im.KReqServerNotify;
import im.base.IMBroadcastManager;
import im.base.SessionIdConverters;
import im.base.model.SessionId;
import java.util.Collection;
import java.util.Iterator;
import javax.inject.Inject;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: ChatFetchEventServiceImpl.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lkntr/app/im/chat/network/ChatBroadcastFetchEvent;", RoomRecommendViewModel.EMPTY_CURSOR, "manager", "Lim/base/IMBroadcastManager;", "sessionId", "Lim/base/model/SessionId;", "sessionIdConverters", "Lim/base/SessionIdConverters;", "<init>", "(Lim/base/IMBroadcastManager;Lim/base/model/SessionId;Lim/base/SessionIdConverters;)V", "event", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bapis/bilibili/broadcast/message/im/KReqServerNotify;", "getEvent", "()Lkotlinx/coroutines/flow/Flow;", "network_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatBroadcastFetchEvent {
    private final Flow<KReqServerNotify> event;
    private final SessionId sessionId;
    private final SessionIdConverters sessionIdConverters;

    @Inject
    public ChatBroadcastFetchEvent(IMBroadcastManager manager, SessionId sessionId, SessionIdConverters sessionIdConverters) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(sessionIdConverters, "sessionIdConverters");
        this.sessionId = sessionId;
        this.sessionIdConverters = sessionIdConverters;
        final Flow $this$filter$iv = FlowKt.onEach(manager.ofCommandType(KCmdId.EN_CMD_ID_MSG_NOTIFY.INSTANCE, KReqServerNotify.Companion.serializer()), new ChatBroadcastFetchEvent$event$1(null));
        this.event = new Flow<KReqServerNotify>() { // from class: kntr.app.im.chat.network.ChatBroadcastFetchEvent$special$$inlined$filter$1
            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$filter$iv.collect(new AnonymousClass2(collector, this), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: kntr.app.im.chat.network.ChatBroadcastFetchEvent$special$$inlined$filter$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ ChatBroadcastFetchEvent this$0;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "kntr.app.im.chat.network.ChatBroadcastFetchEvent$special$$inlined$filter$1$2", f = "ChatFetchEventServiceImpl.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "emit", n = {"value", "$completion", "value", "$this$filter_u24lambda_u240", "$i$a$-unsafeTransform-FlowKt__TransformKt$filter$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                /* renamed from: kntr.app.im.chat.network.ChatBroadcastFetchEvent$special$$inlined$filter$1$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
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

                public AnonymousClass2(FlowCollector flowCollector, ChatBroadcastFetchEvent chatBroadcastFetchEvent) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = chatBroadcastFetchEvent;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0045  */
                /* JADX WARN: Removed duplicated region for block: B:43:0x00d7 A[LOOP:0: B:19:0x0073->B:43:0x00d7, LOOP_END] */
                /* JADX WARN: Removed duplicated region for block: B:55:0x00d4 A[SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    Object $result;
                    boolean z;
                    SessionIdConverters sessionIdConverters;
                    SessionId sessionId;
                    if ($completion instanceof AnonymousClass1) {
                        $continuation = (AnonymousClass1) $completion;
                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                            $continuation.label -= Integer.MIN_VALUE;
                            Object $result2 = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result2);
                                    FlowCollector $this$filter_u24lambda_u240 = this.$this_unsafeFlow;
                                    AnonymousClass1 anonymousClass1 = $continuation;
                                    KReqServerNotify it = (KReqServerNotify) value;
                                    Iterable $this$any$iv = it.getCommandMsgs();
                                    boolean z2 = false;
                                    if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                                        Iterator<T> it2 = $this$any$iv.iterator();
                                        while (true) {
                                            if (it2.hasNext()) {
                                                Object element$iv = it2.next();
                                                KCommandMsg message = (KCommandMsg) element$iv;
                                                KCommandMsg.KFetchMessageCommand command = message.getCommand();
                                                KCommandMsg.KFetchMessageCommand kFetchMessageCommand = command instanceof KCommandMsg.KFetchMessageCommand ? command : null;
                                                if (kFetchMessageCommand != null) {
                                                    KFetchMessageCommand value2 = kFetchMessageCommand.getValue();
                                                    if (value2 != null) {
                                                        KSessionId id = value2.getSessionId();
                                                        if (id == null) {
                                                            $result = $result2;
                                                        } else {
                                                            $result = $result2;
                                                            sessionIdConverters = this.this$0.sessionIdConverters;
                                                            SessionId convertToSessionId = sessionIdConverters.convertToSessionId(id);
                                                            if (convertToSessionId != null) {
                                                                sessionId = this.this$0.sessionId;
                                                                if (convertToSessionId.checkSameId(sessionId)) {
                                                                    z = true;
                                                                    if (z) {
                                                                        $result2 = $result;
                                                                    } else {
                                                                        z2 = true;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        $result = $result2;
                                                    }
                                                } else {
                                                    $result = $result2;
                                                }
                                                z = false;
                                                if (z) {
                                                }
                                            }
                                        }
                                    }
                                    if (!z2) {
                                        break;
                                    } else {
                                        $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                        $continuation.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                        $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                        $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$filter_u24lambda_u240);
                                        $continuation.I$0 = 0;
                                        $continuation.label = 1;
                                        if ($this$filter_u24lambda_u240.emit(value, $continuation) != coroutine_suspended) {
                                            break;
                                        } else {
                                            return coroutine_suspended;
                                        }
                                    }
                                case 1:
                                    int i = $continuation.I$0;
                                    FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                    Object obj = $continuation.L$2;
                                    AnonymousClass1 anonymousClass12 = (AnonymousClass1) $continuation.L$1;
                                    Object obj2 = $continuation.L$0;
                                    ResultKt.throwOnFailure($result2);
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    $continuation = new AnonymousClass1($completion);
                    Object $result22 = $continuation.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch ($continuation.label) {
                    }
                    return Unit.INSTANCE;
                }
            }
        };
    }

    public final Flow<KReqServerNotify> getEvent() {
        return this.event;
    }
}