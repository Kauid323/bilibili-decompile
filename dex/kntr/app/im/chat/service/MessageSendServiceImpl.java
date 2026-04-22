package kntr.app.im.chat.service;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import com.bapis.bilibili.app.im.v1.KEntityMsgType;
import com.bapis.bilibili.app.im.v1.KUserPlaceholder;
import im.base.IMLog;
import im.base.config.IMConfigSetting;
import im.base.model.SessionId;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.InputContent;
import kntr.app.im.chat.core.service.MessageSendProgress;
import kntr.app.im.chat.core.service.MessageSendService;
import kntr.app.im.chat.core.service.MessageTask;
import kntr.app.im.chat.network.ChatSendEvent;
import kntr.app.im.chat.service.sender.TextMessageSender;
import kntr.app.im.chat.service.sender.image.ImageMessageSender;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicLong;
import kotlinx.atomicfu.AtomicRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: MessageSendServiceImpl.kt */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010!\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010#J.\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0096@¢\u0006\u0002\u0010-J\u001e\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u0002002\u0006\u0010+\u001a\u00020,H\u0096@¢\u0006\u0002\u00101J\u001c\u00102\u001a\u00020\"2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001104H\u0096@¢\u0006\u0002\u00105J\u001c\u00106\u001a\u00020\"2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u001208H\u0082@¢\u0006\u0002\u00109J\"\u00106\u001a\u00020\"2\u0012\u0010:\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120;\"\u00020\u0012H\u0082@¢\u0006\u0002\u0010<R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010\u000e\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012`\u00130\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\u0014\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012`\u00130\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\u001d\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012`\u00130\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006="}, d2 = {"Lkntr/app/im/chat/service/MessageSendServiceImpl;", "Lkntr/app/im/chat/core/service/MessageSendService;", "imageMessageSender", "Lkntr/app/im/chat/service/sender/image/ImageMessageSender;", "textMessageSender", "Lkntr/app/im/chat/service/sender/TextMessageSender;", "sendEvent", "Lkntr/app/im/chat/network/ChatSendEvent;", "imConfigSetting", "Lim/base/config/IMConfigSetting;", "<init>", "(Lkntr/app/im/chat/service/sender/image/ImageMessageSender;Lkntr/app/im/chat/service/sender/TextMessageSender;Lkntr/app/im/chat/network/ChatSendEvent;Lim/base/config/IMConfigSetting;)V", "currentTaskOffset", "Lkotlinx/atomicfu/AtomicLong;", "state", "Landroidx/compose/runtime/MutableState;", "Ljava/util/LinkedHashMap;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/core/service/MessageTask;", "Lkotlin/collections/LinkedHashMap;", "tasks", "Landroidx/compose/runtime/State;", "getTasks", "()Landroidx/compose/runtime/State;", "scope", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/CoroutineScope;", "mapLock", "Lkotlinx/coroutines/sync/Mutex;", "stateFlow", "Lkotlinx/coroutines/flow/Flow;", "getStateFlow", "()Lkotlinx/coroutines/flow/Flow;", "start", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "send", "sessionId", "Lim/base/model/SessionId;", "content", "Lkntr/app/im/chat/core/model/InputContent;", "imageType", "Lcom/bapis/bilibili/app/im/v1/KEntityMsgType;", "userPlaceholder", "Lcom/bapis/bilibili/app/im/v1/KUserPlaceholder;", "(Lim/base/model/SessionId;Lkntr/app/im/chat/core/model/InputContent;Lcom/bapis/bilibili/app/im/v1/KEntityMsgType;Lcom/bapis/bilibili/app/im/v1/KUserPlaceholder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resend", "message", "Lkntr/app/im/chat/core/model/EntityMessage;", "(Lkntr/app/im/chat/core/model/EntityMessage;Lcom/bapis/bilibili/app/im/v1/KUserPlaceholder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumeResult", "successToken", RoomRecommendViewModel.EMPTY_CURSOR, "(Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateMap", "taskList", RoomRecommendViewModel.EMPTY_CURSOR, "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "task", RoomRecommendViewModel.EMPTY_CURSOR, "([Lkntr/app/im/chat/core/service/MessageTask;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MessageSendServiceImpl implements MessageSendService {
    public static final int $stable = 8;
    private final AtomicLong currentTaskOffset;
    private final IMConfigSetting imConfigSetting;
    private final ImageMessageSender imageMessageSender;
    private final Mutex mapLock;
    private final AtomicRef<CoroutineScope> scope;
    private final ChatSendEvent sendEvent;
    private final MutableState<LinkedHashMap<String, MessageTask>> state;
    private final TextMessageSender textMessageSender;

    @Inject
    public MessageSendServiceImpl(ImageMessageSender imageMessageSender, TextMessageSender textMessageSender, ChatSendEvent sendEvent, IMConfigSetting imConfigSetting) {
        Intrinsics.checkNotNullParameter(imageMessageSender, "imageMessageSender");
        Intrinsics.checkNotNullParameter(textMessageSender, "textMessageSender");
        Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
        Intrinsics.checkNotNullParameter(imConfigSetting, "imConfigSetting");
        this.imageMessageSender = imageMessageSender;
        this.textMessageSender = textMessageSender;
        this.sendEvent = sendEvent;
        this.imConfigSetting = imConfigSetting;
        this.currentTaskOffset = AtomicFU.atomic(1L);
        this.state = SnapshotStateKt.mutableStateOf$default(new LinkedHashMap(), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.scope = AtomicFU.atomic((Object) null);
        this.mapLock = MutexKt.Mutex$default(false, 1, (Object) null);
    }

    @Override // kntr.app.im.chat.core.service.MessageSendService
    public State<LinkedHashMap<String, MessageTask>> getTasks() {
        return this.state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair _get_stateFlow_$lambda$0(MessageSendServiceImpl this$0) {
        Object value = this$0.state.getValue();
        Map $this$mapValues$iv = (Map) this$0.state.getValue();
        Map destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity($this$mapValues$iv.size()));
        Iterable $this$associateByTo$iv$iv$iv = $this$mapValues$iv.entrySet();
        for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            Map.Entry it$iv$iv = (Map.Entry) element$iv$iv$iv;
            Map.Entry it = (Map.Entry) element$iv$iv$iv;
            destination$iv$iv.put(it$iv$iv.getKey(), (MessageSendProgress) ((MessageTask) it.getValue()).getProgress().getValue());
        }
        return TuplesKt.to(value, destination$iv$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Flow<LinkedHashMap<String, MessageTask>> getStateFlow() {
        final Flow $this$map$iv = SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.im.chat.service.MessageSendServiceImpl$$ExternalSyntheticLambda0
            public final Object invoke() {
                Pair _get_stateFlow_$lambda$0;
                _get_stateFlow_$lambda$0 = MessageSendServiceImpl._get_stateFlow_$lambda$0(MessageSendServiceImpl.this);
                return _get_stateFlow_$lambda$0;
            }
        });
        return new Flow<LinkedHashMap<String, MessageTask>>() { // from class: kntr.app.im.chat.service.MessageSendServiceImpl$special$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: kntr.app.im.chat.service.MessageSendServiceImpl$special$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "kntr.app.im.chat.service.MessageSendServiceImpl$special$$inlined$map$1$2", f = "MessageSendServiceImpl.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                /* renamed from: kntr.app.im.chat.service.MessageSendServiceImpl$special$$inlined$map$1$2$1  reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
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
                                    Pair it = (Pair) value;
                                    Object first = it.getFirst();
                                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable($continuation);
                                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
                                    $continuation.I$0 = 0;
                                    $continuation.label = 1;
                                    if ($this$map_u24lambda_u245.emit(first, $continuation) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                case 1:
                                    int i = $continuation.I$0;
                                    FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                    Object obj = $continuation.L$2;
                                    AnonymousClass1 anonymousClass1 = (AnonymousClass1) $continuation.L$1;
                                    Object value2 = $continuation.L$0;
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

            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv.collect(new AnonymousClass2(collector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
    }

    @Override // kntr.app.im.chat.core.service.MessageSendService
    public Object start(Continuation<? super Unit> continuation) {
        CoroutineScope localScope;
        if (this.scope.compareAndSet((Object) null, CoroutineScopeKt.CoroutineScope(continuation.getContext())) && (localScope = (CoroutineScope) this.scope.getValue()) != null) {
            BuildersKt.launch$default(localScope, (CoroutineContext) null, (CoroutineStart) null, new MessageSendServiceImpl$start$2(this, null), 3, (Object) null);
            BuildersKt.launch$default(localScope, (CoroutineContext) null, (CoroutineStart) null, new MessageSendServiceImpl$start$3(this, localScope, null), 3, (Object) null);
            BuildersKt.launch$default(localScope, (CoroutineContext) null, (CoroutineStart) null, new MessageSendServiceImpl$start$4(this, null), 3, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00f8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0130 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0131  */
    @Override // kntr.app.im.chat.core.service.MessageSendService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object send(SessionId sessionId, InputContent content, KEntityMsgType imageType, KUserPlaceholder userPlaceholder, Continuation<? super Unit> continuation) {
        Continuation<? super List<? extends MessageTask>> messageSendServiceImpl$send$1;
        SessionId sessionId2;
        InputContent content2;
        KEntityMsgType imageType2;
        KUserPlaceholder userPlaceholder2;
        Object send;
        Object send2;
        Object obj;
        SessionId sessionId3;
        InputContent content3;
        KEntityMsgType imageType3;
        Collection collection;
        if (continuation instanceof MessageSendServiceImpl$send$1) {
            messageSendServiceImpl$send$1 = (MessageSendServiceImpl$send$1) continuation;
            if ((messageSendServiceImpl$send$1.label & Integer.MIN_VALUE) != 0) {
                messageSendServiceImpl$send$1.label -= Integer.MIN_VALUE;
                Object $result = messageSendServiceImpl$send$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (messageSendServiceImpl$send$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        sessionId2 = sessionId;
                        messageSendServiceImpl$send$1.L$0 = sessionId2;
                        content2 = content;
                        messageSendServiceImpl$send$1.L$1 = content2;
                        imageType2 = imageType;
                        messageSendServiceImpl$send$1.L$2 = imageType2;
                        userPlaceholder2 = userPlaceholder;
                        messageSendServiceImpl$send$1.L$3 = userPlaceholder2;
                        messageSendServiceImpl$send$1.label = 1;
                        send = this.imageMessageSender.send(sessionId, content, imageType, userPlaceholder, new MessageSendServiceImpl$send$taskList$1(this.currentTaskOffset), messageSendServiceImpl$send$1);
                        if (send == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Collection collection2 = (Collection) send;
                        TextMessageSender textMessageSender = this.textMessageSender;
                        MessageSendServiceImpl$send$taskList$2 messageSendServiceImpl$send$taskList$2 = new MessageSendServiceImpl$send$taskList$2(this.currentTaskOffset);
                        messageSendServiceImpl$send$1.L$0 = SpillingKt.nullOutSpilledVariable(sessionId2);
                        messageSendServiceImpl$send$1.L$1 = SpillingKt.nullOutSpilledVariable(content2);
                        messageSendServiceImpl$send$1.L$2 = SpillingKt.nullOutSpilledVariable(imageType2);
                        messageSendServiceImpl$send$1.L$3 = SpillingKt.nullOutSpilledVariable(userPlaceholder2);
                        messageSendServiceImpl$send$1.L$4 = collection2;
                        messageSendServiceImpl$send$1.label = 2;
                        send2 = textMessageSender.send(sessionId2, content2, imageType2, userPlaceholder2, messageSendServiceImpl$send$taskList$2, messageSendServiceImpl$send$1);
                        if (send2 != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = send2;
                        sessionId3 = sessionId2;
                        content3 = content2;
                        imageType3 = imageType2;
                        collection = collection2;
                        List taskList = CollectionsKt.plus(collection, (Iterable) obj);
                        messageSendServiceImpl$send$1.L$0 = SpillingKt.nullOutSpilledVariable(sessionId3);
                        messageSendServiceImpl$send$1.L$1 = SpillingKt.nullOutSpilledVariable(content3);
                        messageSendServiceImpl$send$1.L$2 = SpillingKt.nullOutSpilledVariable(imageType3);
                        messageSendServiceImpl$send$1.L$3 = SpillingKt.nullOutSpilledVariable(userPlaceholder2);
                        messageSendServiceImpl$send$1.L$4 = SpillingKt.nullOutSpilledVariable(taskList);
                        messageSendServiceImpl$send$1.label = 3;
                        return updateMap((Collection<? extends MessageTask>) taskList, (Continuation<? super Unit>) messageSendServiceImpl$send$1) != coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        userPlaceholder2 = (KUserPlaceholder) messageSendServiceImpl$send$1.L$3;
                        imageType2 = (KEntityMsgType) messageSendServiceImpl$send$1.L$2;
                        content2 = (InputContent) messageSendServiceImpl$send$1.L$1;
                        sessionId2 = (SessionId) messageSendServiceImpl$send$1.L$0;
                        send = $result;
                        Collection collection22 = (Collection) send;
                        TextMessageSender textMessageSender2 = this.textMessageSender;
                        MessageSendServiceImpl$send$taskList$2 messageSendServiceImpl$send$taskList$22 = new MessageSendServiceImpl$send$taskList$2(this.currentTaskOffset);
                        messageSendServiceImpl$send$1.L$0 = SpillingKt.nullOutSpilledVariable(sessionId2);
                        messageSendServiceImpl$send$1.L$1 = SpillingKt.nullOutSpilledVariable(content2);
                        messageSendServiceImpl$send$1.L$2 = SpillingKt.nullOutSpilledVariable(imageType2);
                        messageSendServiceImpl$send$1.L$3 = SpillingKt.nullOutSpilledVariable(userPlaceholder2);
                        messageSendServiceImpl$send$1.L$4 = collection22;
                        messageSendServiceImpl$send$1.label = 2;
                        send2 = textMessageSender2.send(sessionId2, content2, imageType2, userPlaceholder2, messageSendServiceImpl$send$taskList$22, messageSendServiceImpl$send$1);
                        if (send2 != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        collection = (Collection) messageSendServiceImpl$send$1.L$4;
                        imageType3 = (KEntityMsgType) messageSendServiceImpl$send$1.L$2;
                        content3 = (InputContent) messageSendServiceImpl$send$1.L$1;
                        sessionId3 = (SessionId) messageSendServiceImpl$send$1.L$0;
                        ResultKt.throwOnFailure($result);
                        userPlaceholder2 = (KUserPlaceholder) messageSendServiceImpl$send$1.L$3;
                        obj = $result;
                        List taskList2 = CollectionsKt.plus(collection, (Iterable) obj);
                        messageSendServiceImpl$send$1.L$0 = SpillingKt.nullOutSpilledVariable(sessionId3);
                        messageSendServiceImpl$send$1.L$1 = SpillingKt.nullOutSpilledVariable(content3);
                        messageSendServiceImpl$send$1.L$2 = SpillingKt.nullOutSpilledVariable(imageType3);
                        messageSendServiceImpl$send$1.L$3 = SpillingKt.nullOutSpilledVariable(userPlaceholder2);
                        messageSendServiceImpl$send$1.L$4 = SpillingKt.nullOutSpilledVariable(taskList2);
                        messageSendServiceImpl$send$1.label = 3;
                        if (updateMap((Collection<? extends MessageTask>) taskList2, (Continuation<? super Unit>) messageSendServiceImpl$send$1) != coroutine_suspended) {
                        }
                        break;
                    case 3:
                        List list = (List) messageSendServiceImpl$send$1.L$4;
                        KUserPlaceholder kUserPlaceholder = (KUserPlaceholder) messageSendServiceImpl$send$1.L$3;
                        KEntityMsgType kEntityMsgType = (KEntityMsgType) messageSendServiceImpl$send$1.L$2;
                        InputContent inputContent = (InputContent) messageSendServiceImpl$send$1.L$1;
                        SessionId sessionId4 = (SessionId) messageSendServiceImpl$send$1.L$0;
                        ResultKt.throwOnFailure($result);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        messageSendServiceImpl$send$1 = new MessageSendServiceImpl$send$1(this, continuation);
        Object $result2 = messageSendServiceImpl$send$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (messageSendServiceImpl$send$1.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0114  */
    @Override // kntr.app.im.chat.core.service.MessageSendService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object resend(EntityMessage message, KUserPlaceholder userPlaceholder, Continuation<? super Unit> continuation) {
        MessageSendServiceImpl$resend$1 messageSendServiceImpl$resend$1;
        Object resend;
        MessageTask resendTask;
        Object resend2;
        if (continuation instanceof MessageSendServiceImpl$resend$1) {
            messageSendServiceImpl$resend$1 = (MessageSendServiceImpl$resend$1) continuation;
            if ((messageSendServiceImpl$resend$1.label & Integer.MIN_VALUE) != 0) {
                messageSendServiceImpl$resend$1.label -= Integer.MIN_VALUE;
                Object $result = messageSendServiceImpl$resend$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (messageSendServiceImpl$resend$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        KEntityMsgType msgType = message.getMsgType();
                        if (Intrinsics.areEqual(msgType, KEntityMsgType.ENTITY_MSG_TYPE_PICTURE.INSTANCE) || Intrinsics.areEqual(msgType, KEntityMsgType.ENTITY_MSG_TYPE_CUSTOM_STICKER.INSTANCE)) {
                            messageSendServiceImpl$resend$1.L$0 = SpillingKt.nullOutSpilledVariable(message);
                            messageSendServiceImpl$resend$1.L$1 = SpillingKt.nullOutSpilledVariable(userPlaceholder);
                            messageSendServiceImpl$resend$1.label = 1;
                            resend = this.imageMessageSender.resend(message, userPlaceholder, new MessageSendServiceImpl$resend$resendTask$1(this.currentTaskOffset), messageSendServiceImpl$resend$1);
                            if (resend == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            resendTask = (MessageTask) resend;
                            if (resendTask != null) {
                                MessageTask[] messageTaskArr = {resendTask};
                                messageSendServiceImpl$resend$1.L$0 = SpillingKt.nullOutSpilledVariable(message);
                                messageSendServiceImpl$resend$1.L$1 = SpillingKt.nullOutSpilledVariable(userPlaceholder);
                                messageSendServiceImpl$resend$1.L$2 = SpillingKt.nullOutSpilledVariable(resendTask);
                                messageSendServiceImpl$resend$1.label = 3;
                                return updateMap(messageTaskArr, (Continuation<? super Unit>) messageSendServiceImpl$resend$1) == coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                            }
                            return Unit.INSTANCE;
                        } else if (Intrinsics.areEqual(msgType, KEntityMsgType.ENTITY_MSG_TYPE_TEXT.INSTANCE)) {
                            messageSendServiceImpl$resend$1.L$0 = SpillingKt.nullOutSpilledVariable(message);
                            messageSendServiceImpl$resend$1.L$1 = SpillingKt.nullOutSpilledVariable(userPlaceholder);
                            messageSendServiceImpl$resend$1.label = 2;
                            resend2 = this.textMessageSender.resend(message, userPlaceholder, new MessageSendServiceImpl$resend$resendTask$2(this.currentTaskOffset), messageSendServiceImpl$resend$1);
                            if (resend2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            resendTask = (MessageTask) resend2;
                            if (resendTask != null) {
                            }
                        } else {
                            IMLog.Companion.w("MessageSendService", "不支持重发消息类型: " + message.getMsgType());
                            resendTask = null;
                            if (resendTask != null) {
                            }
                        }
                        break;
                    case 1:
                        userPlaceholder = (KUserPlaceholder) messageSendServiceImpl$resend$1.L$1;
                        message = (EntityMessage) messageSendServiceImpl$resend$1.L$0;
                        ResultKt.throwOnFailure($result);
                        resend = $result;
                        resendTask = (MessageTask) resend;
                        if (resendTask != null) {
                        }
                        break;
                    case 2:
                        userPlaceholder = (KUserPlaceholder) messageSendServiceImpl$resend$1.L$1;
                        message = (EntityMessage) messageSendServiceImpl$resend$1.L$0;
                        ResultKt.throwOnFailure($result);
                        resend2 = $result;
                        resendTask = (MessageTask) resend2;
                        if (resendTask != null) {
                        }
                        break;
                    case 3:
                        MessageTask messageTask = (MessageTask) messageSendServiceImpl$resend$1.L$2;
                        KUserPlaceholder kUserPlaceholder = (KUserPlaceholder) messageSendServiceImpl$resend$1.L$1;
                        EntityMessage entityMessage = (EntityMessage) messageSendServiceImpl$resend$1.L$0;
                        ResultKt.throwOnFailure($result);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        messageSendServiceImpl$resend$1 = new MessageSendServiceImpl$resend$1(this, continuation);
        Object $result2 = messageSendServiceImpl$resend$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (messageSendServiceImpl$resend$1.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0099 A[Catch: all -> 0x0105, TryCatch #0 {all -> 0x0105, blocks: (B:18:0x0079, B:20:0x0099, B:22:0x00a7, B:24:0x00ab, B:30:0x00f9, B:28:0x00b9), top: B:36:0x0079 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f7  */
    @Override // kntr.app.im.chat.core.service.MessageSendService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object consumeResult(Set<String> set, Continuation<? super Unit> continuation) {
        MessageSendServiceImpl$consumeResult$1 messageSendServiceImpl$consumeResult$1;
        Mutex $this$withLock_u24default$iv;
        Object owner$iv;
        Set successToken;
        MessageTask first;
        try {
            if (continuation instanceof MessageSendServiceImpl$consumeResult$1) {
                messageSendServiceImpl$consumeResult$1 = (MessageSendServiceImpl$consumeResult$1) continuation;
                if ((messageSendServiceImpl$consumeResult$1.label & Integer.MIN_VALUE) != 0) {
                    messageSendServiceImpl$consumeResult$1.label -= Integer.MIN_VALUE;
                    Object $result = messageSendServiceImpl$consumeResult$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (messageSendServiceImpl$consumeResult$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            IMLog.Companion.i("MessageSendService", "consumeResult: " + set);
                            $this$withLock_u24default$iv = this.mapLock;
                            owner$iv = null;
                            messageSendServiceImpl$consumeResult$1.L$0 = set;
                            messageSendServiceImpl$consumeResult$1.L$1 = $this$withLock_u24default$iv;
                            messageSendServiceImpl$consumeResult$1.I$0 = 0;
                            messageSendServiceImpl$consumeResult$1.label = 1;
                            if ($this$withLock_u24default$iv.lock((Object) null, messageSendServiceImpl$consumeResult$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            successToken = set;
                            break;
                        case 1:
                            int i = messageSendServiceImpl$consumeResult$1.I$0;
                            owner$iv = null;
                            $this$withLock_u24default$iv = (Mutex) messageSendServiceImpl$consumeResult$1.L$1;
                            Set successToken2 = (Set) messageSendServiceImpl$consumeResult$1.L$0;
                            ResultKt.throwOnFailure($result);
                            successToken = successToken2;
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    LinkedHashMap map = new LinkedHashMap((Map) this.state.getValue());
                    Collection values = map.values();
                    Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
                    first = (MessageTask) CollectionsKt.firstOrNull(values);
                    if (first == null) {
                        MessageSendProgress progress = (MessageSendProgress) first.getProgress().getValue();
                        if (!(progress instanceof MessageSendProgress.SendFailed) && (!(progress instanceof MessageSendProgress.SendSuccess) || !successToken.contains(first.getToken()))) {
                        }
                        IMLog.Companion.d("MessageSendService", "清理已完成任务: " + first.getToken() + ", 状态: " + Reflection.getOrCreateKotlinClass(progress.getClass()));
                        map.remove(first.getToken());
                        this.state.setValue(map);
                    }
                    Unit unit = Unit.INSTANCE;
                    $this$withLock_u24default$iv.unlock(owner$iv);
                    return Unit.INSTANCE;
                }
            }
            LinkedHashMap map2 = new LinkedHashMap((Map) this.state.getValue());
            Collection values2 = map2.values();
            Intrinsics.checkNotNullExpressionValue(values2, "<get-values>(...)");
            first = (MessageTask) CollectionsKt.firstOrNull(values2);
            if (first == null) {
            }
            Unit unit2 = Unit.INSTANCE;
            $this$withLock_u24default$iv.unlock(owner$iv);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            $this$withLock_u24default$iv.unlock(owner$iv);
            throw th;
        }
        messageSendServiceImpl$consumeResult$1 = new MessageSendServiceImpl$consumeResult$1(this, continuation);
        Object $result2 = messageSendServiceImpl$consumeResult$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (messageSendServiceImpl$consumeResult$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0083 A[Catch: all -> 0x00b0, LOOP:0: B:19:0x007d->B:21:0x0083, LOOP_END, TryCatch #0 {all -> 0x00b0, blocks: (B:18:0x0068, B:19:0x007d, B:21:0x0083, B:22:0x009d), top: B:28:0x0068 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object updateMap(Collection<? extends MessageTask> collection, Continuation<? super Unit> continuation) {
        MessageSendServiceImpl$updateMap$1 messageSendServiceImpl$updateMap$1;
        MessageSendServiceImpl$updateMap$1 messageSendServiceImpl$updateMap$12;
        Mutex $this$withLock_u24default$iv;
        Iterable iterable;
        Mutex $this$withLock_u24default$iv2;
        try {
            if (continuation instanceof MessageSendServiceImpl$updateMap$1) {
                messageSendServiceImpl$updateMap$1 = (MessageSendServiceImpl$updateMap$1) continuation;
                if ((messageSendServiceImpl$updateMap$1.label & Integer.MIN_VALUE) != 0) {
                    messageSendServiceImpl$updateMap$1.label -= Integer.MIN_VALUE;
                    messageSendServiceImpl$updateMap$12 = messageSendServiceImpl$updateMap$1;
                    Object $result = messageSendServiceImpl$updateMap$12.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (messageSendServiceImpl$updateMap$12.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            Mutex $this$withLock_u24default$iv3 = this.mapLock;
                            messageSendServiceImpl$updateMap$12.L$0 = collection;
                            messageSendServiceImpl$updateMap$12.L$1 = $this$withLock_u24default$iv3;
                            messageSendServiceImpl$updateMap$12.I$0 = 0;
                            messageSendServiceImpl$updateMap$12.label = 1;
                            if ($this$withLock_u24default$iv3.lock((Object) null, messageSendServiceImpl$updateMap$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $this$withLock_u24default$iv = null;
                            iterable = collection;
                            $this$withLock_u24default$iv2 = $this$withLock_u24default$iv3;
                            break;
                        case 1:
                            int i = messageSendServiceImpl$updateMap$12.I$0;
                            iterable = (Collection) messageSendServiceImpl$updateMap$12.L$0;
                            ResultKt.throwOnFailure($result);
                            $this$withLock_u24default$iv2 = (Mutex) messageSendServiceImpl$updateMap$12.L$1;
                            $this$withLock_u24default$iv = null;
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    boolean z = false;
                    LinkedHashMap currentTaskMap = new LinkedHashMap((Map) this.state.getValue());
                    Iterable $this$forEach$iv = iterable;
                    for (Object element$iv : $this$forEach$iv) {
                        MessageTask it = (MessageTask) element$iv;
                        currentTaskMap.put(it.getToken(), it);
                        z = z;
                    }
                    this.state.setValue(currentTaskMap);
                    Unit unit = Unit.INSTANCE;
                    $this$withLock_u24default$iv2.unlock($this$withLock_u24default$iv);
                    return Unit.INSTANCE;
                }
            }
            LinkedHashMap currentTaskMap2 = new LinkedHashMap((Map) this.state.getValue());
            Iterable $this$forEach$iv2 = iterable;
            while (r12.hasNext()) {
            }
            this.state.setValue(currentTaskMap2);
            Unit unit2 = Unit.INSTANCE;
            $this$withLock_u24default$iv2.unlock($this$withLock_u24default$iv);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            $this$withLock_u24default$iv2.unlock($this$withLock_u24default$iv);
            throw th;
        }
        messageSendServiceImpl$updateMap$1 = new MessageSendServiceImpl$updateMap$1(this, continuation);
        messageSendServiceImpl$updateMap$12 = messageSendServiceImpl$updateMap$1;
        Object $result2 = messageSendServiceImpl$updateMap$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (messageSendServiceImpl$updateMap$12.label) {
        }
        boolean z2 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateMap(MessageTask[] task, Continuation<? super Unit> continuation) {
        Object updateMap = updateMap(ArraysKt.toList(task), continuation);
        return updateMap == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? updateMap : Unit.INSTANCE;
    }
}