package kntr.app.im.chat.network;

import com.bapis.bilibili.broadcast.message.im.KReqServerNotify;
import im.base.IMLog;
import kntr.app.im.chat.core.service.FetchEventType;
import kntr.app.im.chat.network.ChatFetchEventServiceImpl$fetchMessageFlow$1;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicInt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: ChatFetchEventServiceImpl.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/channels/ProducerScope;", "Lkntr/app/im/chat/core/service/FetchEventType;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.network.ChatFetchEventServiceImpl$fetchMessageFlow$1", f = "ChatFetchEventServiceImpl.kt", i = {0, 0, 0}, l = {60}, m = "invokeSuspend", n = {"$this$channelFlow", "lock", "buffer"}, s = {"L$0", "L$1", "L$2"}, v = 1)
final class ChatFetchEventServiceImpl$fetchMessageFlow$1 extends SuspendLambda implements Function2<ProducerScope<? super FetchEventType>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ChatFetchEventServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatFetchEventServiceImpl$fetchMessageFlow$1(ChatFetchEventServiceImpl chatFetchEventServiceImpl, Continuation<? super ChatFetchEventServiceImpl$fetchMessageFlow$1> continuation) {
        super(2, continuation);
        this.this$0 = chatFetchEventServiceImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> chatFetchEventServiceImpl$fetchMessageFlow$1 = new ChatFetchEventServiceImpl$fetchMessageFlow$1(this.this$0, continuation);
        chatFetchEventServiceImpl$fetchMessageFlow$1.L$0 = obj;
        return chatFetchEventServiceImpl$fetchMessageFlow$1;
    }

    public final Object invoke(ProducerScope<? super FetchEventType> producerScope, Continuation<? super Unit> continuation) {
        return create(producerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        ProducerScope $this$channelFlow = (ProducerScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AtomicInt lock = AtomicFU.atomic(0);
                MutableSharedFlow buffer = SharedFlowKt.MutableSharedFlow$default(0, 20, (BufferOverflow) null, 5, (Object) null);
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$channelFlow);
                this.L$1 = SpillingKt.nullOutSpilledVariable(lock);
                this.L$2 = SpillingKt.nullOutSpilledVariable(buffer);
                this.label = 1;
                if (CoroutineScopeKt.coroutineScope(new AnonymousClass1(this.this$0, lock, buffer, $this$channelFlow, null), (Continuation) this) != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                MutableSharedFlow mutableSharedFlow = (MutableSharedFlow) this.L$2;
                AtomicInt atomicInt = (AtomicInt) this.L$1;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChatFetchEventServiceImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kntr.app.im.chat.network.ChatFetchEventServiceImpl$fetchMessageFlow$1$1", f = "ChatFetchEventServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.app.im.chat.network.ChatFetchEventServiceImpl$fetchMessageFlow$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ProducerScope<FetchEventType> $$this$channelFlow;
        final /* synthetic */ MutableSharedFlow<FetchEventType> $buffer;
        final /* synthetic */ AtomicInt $lock;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ChatFetchEventServiceImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(ChatFetchEventServiceImpl chatFetchEventServiceImpl, AtomicInt atomicInt, MutableSharedFlow<FetchEventType> mutableSharedFlow, ProducerScope<? super FetchEventType> producerScope, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = chatFetchEventServiceImpl;
            this.$lock = atomicInt;
            this.$buffer = mutableSharedFlow;
            this.$$this$channelFlow = producerScope;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.this$0, this.$lock, this.$buffer, this.$$this$channelFlow, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ChatFetchEventServiceImpl.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "kntr.app.im.chat.network.ChatFetchEventServiceImpl$fetchMessageFlow$1$1$1", f = "ChatFetchEventServiceImpl.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        /* renamed from: kntr.app.im.chat.network.ChatFetchEventServiceImpl$fetchMessageFlow$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class C00151 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ MutableSharedFlow<FetchEventType> $buffer;
            final /* synthetic */ AtomicInt $lock;
            int label;
            final /* synthetic */ ChatFetchEventServiceImpl this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00151(ChatFetchEventServiceImpl chatFetchEventServiceImpl, AtomicInt atomicInt, MutableSharedFlow<FetchEventType> mutableSharedFlow, Continuation<? super C00151> continuation) {
                super(2, continuation);
                this.this$0 = chatFetchEventServiceImpl;
                this.$lock = atomicInt;
                this.$buffer = mutableSharedFlow;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00151(this.this$0, this.$lock, this.$buffer, continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                ChatBroadcastFetchEvent chatBroadcastFetchEvent;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        chatBroadcastFetchEvent = this.this$0.broadcastFlow;
                        Flow<KReqServerNotify> event = chatBroadcastFetchEvent.getEvent();
                        final AtomicInt atomicInt = this.$lock;
                        final MutableSharedFlow<FetchEventType> mutableSharedFlow = this.$buffer;
                        this.label = 1;
                        if (event.collect(new FlowCollector() { // from class: kntr.app.im.chat.network.ChatFetchEventServiceImpl.fetchMessageFlow.1.1.1.1
                            public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                                return emit((KReqServerNotify) value, (Continuation<? super Unit>) $completion);
                            }

                            public final Object emit(KReqServerNotify it, Continuation<? super Unit> continuation) {
                                IMLog.Companion.i("ChatFetchEventService", "Event from broadcast");
                                atomicInt.incrementAndGet();
                                Object emit = mutableSharedFlow.emit(FetchEventType.Fetch, continuation);
                                return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
                            }
                        }, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object $result) {
            CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C00151(this.this$0, this.$lock, this.$buffer, null), 3, (Object) null);
                    BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2(this.this$0, this.$lock, this.$buffer, null), 3, (Object) null);
                    BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass3(this.this$0, this.$lock, this.$buffer, null), 3, (Object) null);
                    BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass4(this.$buffer, this.$lock, this.$$this$channelFlow, null), 3, (Object) null);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ChatFetchEventServiceImpl.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "kntr.app.im.chat.network.ChatFetchEventServiceImpl$fetchMessageFlow$1$1$2", f = "ChatFetchEventServiceImpl.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        /* renamed from: kntr.app.im.chat.network.ChatFetchEventServiceImpl$fetchMessageFlow$1$1$2  reason: invalid class name */
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ MutableSharedFlow<FetchEventType> $buffer;
            final /* synthetic */ AtomicInt $lock;
            int label;
            final /* synthetic */ ChatFetchEventServiceImpl this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(ChatFetchEventServiceImpl chatFetchEventServiceImpl, AtomicInt atomicInt, MutableSharedFlow<FetchEventType> mutableSharedFlow, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = chatFetchEventServiceImpl;
                this.$lock = atomicInt;
                this.$buffer = mutableSharedFlow;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, this.$lock, this.$buffer, continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: ChatFetchEventServiceImpl.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: kntr.app.im.chat.network.ChatFetchEventServiceImpl$fetchMessageFlow$1$1$2$1  reason: invalid class name and collision with other inner class name */
            /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
            public static final class C00171<T> implements FlowCollector {
                final /* synthetic */ MutableSharedFlow<FetchEventType> $buffer;
                final /* synthetic */ AtomicInt $lock;

                C00171(AtomicInt atomicInt, MutableSharedFlow<FetchEventType> mutableSharedFlow) {
                    this.$lock = atomicInt;
                    this.$buffer = mutableSharedFlow;
                }

                public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                    return emit((MessageEvent) value, (Continuation<? super Unit>) $completion);
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
                /* JADX WARN: Removed duplicated region for block: B:19:0x008f  */
                /* JADX WARN: Removed duplicated region for block: B:29:0x00d9  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(MessageEvent it, Continuation<? super Unit> continuation) {
                    ChatFetchEventServiceImpl$fetchMessageFlow$1$1$2$1$emit$1 chatFetchEventServiceImpl$fetchMessageFlow$1$1$2$1$emit$1;
                    int lockBefore;
                    FetchEventType fetchEventType;
                    if (continuation instanceof ChatFetchEventServiceImpl$fetchMessageFlow$1$1$2$1$emit$1) {
                        chatFetchEventServiceImpl$fetchMessageFlow$1$1$2$1$emit$1 = (ChatFetchEventServiceImpl$fetchMessageFlow$1$1$2$1$emit$1) continuation;
                        if ((chatFetchEventServiceImpl$fetchMessageFlow$1$1$2$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                            chatFetchEventServiceImpl$fetchMessageFlow$1$1$2$1$emit$1.label -= Integer.MIN_VALUE;
                            Object $result = chatFetchEventServiceImpl$fetchMessageFlow$1$1$2$1$emit$1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (chatFetchEventServiceImpl$fetchMessageFlow$1$1$2$1$emit$1.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    IMLog.Companion.i("ChatFetchEventService", "Event from " + it.getType() + ", delay 3s");
                                    lockBefore = this.$lock.getValue();
                                    Duration.Companion companion = Duration.Companion;
                                    long duration = DurationKt.toDuration(3, DurationUnit.SECONDS);
                                    chatFetchEventServiceImpl$fetchMessageFlow$1$1$2$1$emit$1.L$0 = it;
                                    chatFetchEventServiceImpl$fetchMessageFlow$1$1$2$1$emit$1.I$0 = lockBefore;
                                    chatFetchEventServiceImpl$fetchMessageFlow$1$1$2$1$emit$1.label = 1;
                                    if (DelayKt.delay-VtjQ1oo(duration, chatFetchEventServiceImpl$fetchMessageFlow$1$1$2$1$emit$1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    if (this.$lock.getValue() != lockBefore) {
                                        IMLog.Companion.i("ChatFetchEventService", "Event from " + it.getType() + ", emit");
                                        this.$lock.incrementAndGet();
                                        MutableSharedFlow<FetchEventType> mutableSharedFlow = this.$buffer;
                                        if (it.getType() == MessageEventType.Send) {
                                            fetchEventType = FetchEventType.Update;
                                        } else {
                                            fetchEventType = FetchEventType.Fetch;
                                        }
                                        chatFetchEventServiceImpl$fetchMessageFlow$1$1$2$1$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(it);
                                        chatFetchEventServiceImpl$fetchMessageFlow$1$1$2$1$emit$1.I$0 = lockBefore;
                                        chatFetchEventServiceImpl$fetchMessageFlow$1$1$2$1$emit$1.label = 2;
                                        if (mutableSharedFlow.emit(fetchEventType, chatFetchEventServiceImpl$fetchMessageFlow$1$1$2$1$emit$1) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        return Unit.INSTANCE;
                                    }
                                    IMLog.Companion.i("ChatFetchEventService", "Event from " + it.getType() + ", cancelled (lock changed)");
                                    return Unit.INSTANCE;
                                case 1:
                                    lockBefore = chatFetchEventServiceImpl$fetchMessageFlow$1$1$2$1$emit$1.I$0;
                                    it = (MessageEvent) chatFetchEventServiceImpl$fetchMessageFlow$1$1$2$1$emit$1.L$0;
                                    ResultKt.throwOnFailure($result);
                                    if (this.$lock.getValue() != lockBefore) {
                                    }
                                    break;
                                case 2:
                                    int i = chatFetchEventServiceImpl$fetchMessageFlow$1$1$2$1$emit$1.I$0;
                                    MessageEvent messageEvent = (MessageEvent) chatFetchEventServiceImpl$fetchMessageFlow$1$1$2$1$emit$1.L$0;
                                    ResultKt.throwOnFailure($result);
                                    return Unit.INSTANCE;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }
                    }
                    chatFetchEventServiceImpl$fetchMessageFlow$1$1$2$1$emit$1 = new ChatFetchEventServiceImpl$fetchMessageFlow$1$1$2$1$emit$1(this, continuation);
                    Object $result2 = chatFetchEventServiceImpl$fetchMessageFlow$1$1$2$1$emit$1.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (chatFetchEventServiceImpl$fetchMessageFlow$1$1$2$1$emit$1.label) {
                    }
                }
            }

            public final Object invokeSuspend(Object $result) {
                ChatSendEvent chatSendEvent;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        chatSendEvent = this.this$0.sendEvent;
                        this.label = 1;
                        if (chatSendEvent.getEvent().collect(new C00171(this.$lock, this.$buffer), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ChatFetchEventServiceImpl.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "kntr.app.im.chat.network.ChatFetchEventServiceImpl$fetchMessageFlow$1$1$3", f = "ChatFetchEventServiceImpl.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        /* renamed from: kntr.app.im.chat.network.ChatFetchEventServiceImpl$fetchMessageFlow$1$1$3  reason: invalid class name */
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ MutableSharedFlow<FetchEventType> $buffer;
            final /* synthetic */ AtomicInt $lock;
            int label;
            final /* synthetic */ ChatFetchEventServiceImpl this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(ChatFetchEventServiceImpl chatFetchEventServiceImpl, AtomicInt atomicInt, MutableSharedFlow<FetchEventType> mutableSharedFlow, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.this$0 = chatFetchEventServiceImpl;
                this.$lock = atomicInt;
                this.$buffer = mutableSharedFlow;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass3(this.this$0, this.$lock, this.$buffer, continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                ChatLoopFetchService chatLoopFetchService;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        chatLoopFetchService = this.this$0.loopFlow;
                        Flow<Unit> flow = chatLoopFetchService.getFlow();
                        final AtomicInt atomicInt = this.$lock;
                        final MutableSharedFlow<FetchEventType> mutableSharedFlow = this.$buffer;
                        this.label = 1;
                        if (flow.collect(new FlowCollector() { // from class: kntr.app.im.chat.network.ChatFetchEventServiceImpl.fetchMessageFlow.1.1.3.1
                            public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                                return emit((Unit) value, (Continuation<? super Unit>) $completion);
                            }

                            public final Object emit(Unit it, Continuation<? super Unit> continuation) {
                                IMLog.Companion.i("ChatFetchEventService", "Event from debug loop");
                                atomicInt.incrementAndGet();
                                Object emit = mutableSharedFlow.emit(FetchEventType.Fetch, continuation);
                                return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
                            }
                        }, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ChatFetchEventServiceImpl.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "kntr.app.im.chat.network.ChatFetchEventServiceImpl$fetchMessageFlow$1$1$4", f = "ChatFetchEventServiceImpl.kt", i = {}, l = {111}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        /* renamed from: kntr.app.im.chat.network.ChatFetchEventServiceImpl$fetchMessageFlow$1$1$4  reason: invalid class name */
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ProducerScope<FetchEventType> $$this$channelFlow;
            final /* synthetic */ MutableSharedFlow<FetchEventType> $buffer;
            final /* synthetic */ AtomicInt $lock;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass4(MutableSharedFlow<FetchEventType> mutableSharedFlow, AtomicInt atomicInt, ProducerScope<? super FetchEventType> producerScope, Continuation<? super AnonymousClass4> continuation) {
                super(2, continuation);
                this.$buffer = mutableSharedFlow;
                this.$lock = atomicInt;
                this.$$this$channelFlow = producerScope;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass4(this.$buffer, this.$lock, this.$$this$channelFlow, continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        final AtomicInt atomicInt = this.$lock;
                        Flow onEach = FlowKt.onEach(FlowKt.debounceDuration(this.$buffer, new Function1() { // from class: kntr.app.im.chat.network.ChatFetchEventServiceImpl$fetchMessageFlow$1$1$4$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                Duration invokeSuspend$lambda$0;
                                invokeSuspend$lambda$0 = ChatFetchEventServiceImpl$fetchMessageFlow$1.AnonymousClass1.AnonymousClass4.invokeSuspend$lambda$0(atomicInt, (FetchEventType) obj);
                                return invokeSuspend$lambda$0;
                            }
                        }), new AnonymousClass2(this.$lock, null));
                        final ProducerScope<FetchEventType> producerScope = this.$$this$channelFlow;
                        this.label = 1;
                        if (onEach.collect(new FlowCollector() { // from class: kntr.app.im.chat.network.ChatFetchEventServiceImpl.fetchMessageFlow.1.1.4.3
                            public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                                return emit((FetchEventType) value, (Continuation<? super Unit>) $completion);
                            }

                            public final Object emit(FetchEventType it, Continuation<? super Unit> continuation) {
                                Object send = producerScope.send(it, continuation);
                                return send == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? send : Unit.INSTANCE;
                            }
                        }, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Duration invokeSuspend$lambda$0(AtomicInt $lock, FetchEventType it) {
                long duration;
                if ($lock.getValue() <= 1) {
                    Duration.Companion companion = Duration.Companion;
                    duration = DurationKt.toDuration(0, DurationUnit.SECONDS);
                } else {
                    Duration.Companion companion2 = Duration.Companion;
                    duration = DurationKt.toDuration(3, DurationUnit.SECONDS);
                }
                Duration duration2 = Duration.box-impl(duration);
                duration2.unbox-impl();
                $lock.decrementAndGet();
                return duration2;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: ChatFetchEventServiceImpl.kt */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "it", "Lkntr/app/im/chat/core/service/FetchEventType;"}, k = 3, mv = {2, 2, 0}, xi = 48)
            @DebugMetadata(c = "kntr.app.im.chat.network.ChatFetchEventServiceImpl$fetchMessageFlow$1$1$4$2", f = "ChatFetchEventServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            /* renamed from: kntr.app.im.chat.network.ChatFetchEventServiceImpl$fetchMessageFlow$1$1$4$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
            public static final class AnonymousClass2 extends SuspendLambda implements Function2<FetchEventType, Continuation<? super Unit>, Object> {
                final /* synthetic */ AtomicInt $lock;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(AtomicInt atomicInt, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.$lock = atomicInt;
                }

                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass2(this.$lock, continuation);
                }

                public final Object invoke(FetchEventType fetchEventType, Continuation<? super Unit> continuation) {
                    return create(fetchEventType, continuation).invokeSuspend(Unit.INSTANCE);
                }

                public final Object invokeSuspend(Object $result) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            IMLog.Companion.i("ChatFetchEventService", "Emit fetch event, lock=" + this.$lock.getValue());
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
        }
    }
}