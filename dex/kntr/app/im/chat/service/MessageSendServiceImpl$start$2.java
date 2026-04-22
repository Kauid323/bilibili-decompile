package kntr.app.im.chat.service;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kntr.app.im.chat.core.service.MessageSendProgress;
import kntr.app.im.chat.core.service.MessageTask;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: MessageSendServiceImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.MessageSendServiceImpl$start$2", f = "MessageSendServiceImpl.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class MessageSendServiceImpl$start$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MessageSendServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageSendServiceImpl$start$2(MessageSendServiceImpl messageSendServiceImpl, Continuation<? super MessageSendServiceImpl$start$2> continuation) {
        super(2, continuation);
        this.this$0 = messageSendServiceImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MessageSendServiceImpl$start$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MessageSendServiceImpl.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: kntr.app.im.chat.service.MessageSendServiceImpl$start$2$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ MessageSendServiceImpl this$0;

        AnonymousClass1(MessageSendServiceImpl messageSendServiceImpl) {
            this.this$0 = messageSendServiceImpl;
        }

        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
            return emit((LinkedHashMap) value, (Continuation<? super Unit>) $completion);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00c5  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0106  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00f7 -> B:27:0x00ff). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(LinkedHashMap<String, MessageTask> linkedHashMap, Continuation<? super Unit> continuation) {
            MessageSendServiceImpl$start$2$1$emit$1 messageSendServiceImpl$start$2$1$emit$1;
            Iterable $this$forEach$iv;
            int $i$f$forEach;
            Iterator<T> it;
            AnonymousClass1 anonymousClass1;
            Object obj;
            Collection started;
            Object updateMap;
            Object obj2;
            Iterable $this$forEach$iv2;
            Iterator<T> it2;
            AnonymousClass1 anonymousClass12;
            int $i$f$forEach2;
            if (continuation instanceof MessageSendServiceImpl$start$2$1$emit$1) {
                messageSendServiceImpl$start$2$1$emit$1 = (MessageSendServiceImpl$start$2$1$emit$1) continuation;
                if ((messageSendServiceImpl$start$2$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                    messageSendServiceImpl$start$2$1$emit$1.label -= Integer.MIN_VALUE;
                    Object $result = messageSendServiceImpl$start$2$1$emit$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (messageSendServiceImpl$start$2$1$emit$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            LinkedHashMap<String, MessageTask> $this$filterValues$iv = linkedHashMap;
                            LinkedHashMap result$iv = new LinkedHashMap();
                            for (Map.Entry entry$iv : $this$filterValues$iv.entrySet()) {
                                if (Intrinsics.areEqual(entry$iv.getValue().getProgress().getValue(), MessageSendProgress.Init.INSTANCE)) {
                                    result$iv.put(entry$iv.getKey(), entry$iv.getValue());
                                }
                            }
                            LinkedHashMap $this$filterValues$iv2 = result$iv;
                            Iterable started2 = $this$filterValues$iv2.values();
                            Iterable $this$forEach$iv3 = started2;
                            Iterator<T> it3 = $this$forEach$iv3.iterator();
                            $this$forEach$iv = $this$forEach$iv3;
                            $i$f$forEach = 0;
                            it = it3;
                            anonymousClass1 = this;
                            obj = coroutine_suspended;
                            started = started2;
                            if (it.hasNext()) {
                                Object element$iv = it.next();
                                MessageTask it4 = (MessageTask) element$iv;
                                messageSendServiceImpl$start$2$1$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(linkedHashMap);
                                messageSendServiceImpl$start$2$1$emit$1.L$1 = started;
                                messageSendServiceImpl$start$2$1$emit$1.L$2 = SpillingKt.nullOutSpilledVariable($this$forEach$iv);
                                messageSendServiceImpl$start$2$1$emit$1.L$3 = it;
                                messageSendServiceImpl$start$2$1$emit$1.L$4 = SpillingKt.nullOutSpilledVariable(element$iv);
                                messageSendServiceImpl$start$2$1$emit$1.L$5 = SpillingKt.nullOutSpilledVariable(it4);
                                messageSendServiceImpl$start$2$1$emit$1.I$0 = $i$f$forEach;
                                messageSendServiceImpl$start$2$1$emit$1.I$1 = 0;
                                messageSendServiceImpl$start$2$1$emit$1.label = 1;
                                if (it4.init(messageSendServiceImpl$start$2$1$emit$1) == obj) {
                                    return obj;
                                }
                                int i = $i$f$forEach;
                                obj2 = obj;
                                $this$forEach$iv2 = $this$forEach$iv;
                                it2 = it;
                                anonymousClass12 = anonymousClass1;
                                $i$f$forEach2 = i;
                                obj = obj2;
                                $i$f$forEach = $i$f$forEach2;
                                anonymousClass1 = anonymousClass12;
                                it = it2;
                                $this$forEach$iv = $this$forEach$iv2;
                                if (it.hasNext()) {
                                    MessageSendServiceImpl messageSendServiceImpl = anonymousClass1.this$0;
                                    messageSendServiceImpl$start$2$1$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(linkedHashMap);
                                    messageSendServiceImpl$start$2$1$emit$1.L$1 = SpillingKt.nullOutSpilledVariable(started);
                                    messageSendServiceImpl$start$2$1$emit$1.L$2 = null;
                                    messageSendServiceImpl$start$2$1$emit$1.L$3 = null;
                                    messageSendServiceImpl$start$2$1$emit$1.L$4 = null;
                                    messageSendServiceImpl$start$2$1$emit$1.L$5 = null;
                                    messageSendServiceImpl$start$2$1$emit$1.label = 2;
                                    updateMap = messageSendServiceImpl.updateMap((Collection<? extends MessageTask>) started, (Continuation<? super Unit>) messageSendServiceImpl$start$2$1$emit$1);
                                    if (updateMap == obj) {
                                        return obj;
                                    }
                                    return Unit.INSTANCE;
                                }
                            }
                        case 1:
                            int i2 = messageSendServiceImpl$start$2$1$emit$1.I$1;
                            int $i$f$forEach3 = messageSendServiceImpl$start$2$1$emit$1.I$0;
                            MessageTask messageTask = (MessageTask) messageSendServiceImpl$start$2$1$emit$1.L$5;
                            Object obj3 = messageSendServiceImpl$start$2$1$emit$1.L$4;
                            linkedHashMap = (LinkedHashMap) messageSendServiceImpl$start$2$1$emit$1.L$0;
                            ResultKt.throwOnFailure($result);
                            $this$forEach$iv2 = (Iterable) messageSendServiceImpl$start$2$1$emit$1.L$2;
                            it2 = (Iterator) messageSendServiceImpl$start$2$1$emit$1.L$3;
                            anonymousClass12 = this;
                            obj2 = coroutine_suspended;
                            started = (Collection) messageSendServiceImpl$start$2$1$emit$1.L$1;
                            $i$f$forEach2 = $i$f$forEach3;
                            obj = obj2;
                            $i$f$forEach = $i$f$forEach2;
                            anonymousClass1 = anonymousClass12;
                            it = it2;
                            $this$forEach$iv = $this$forEach$iv2;
                            if (it.hasNext()) {
                            }
                            break;
                        case 2:
                            Collection collection = (Collection) messageSendServiceImpl$start$2$1$emit$1.L$1;
                            LinkedHashMap linkedHashMap2 = (LinkedHashMap) messageSendServiceImpl$start$2$1$emit$1.L$0;
                            ResultKt.throwOnFailure($result);
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            messageSendServiceImpl$start$2$1$emit$1 = new MessageSendServiceImpl$start$2$1$emit$1(this, continuation);
            Object $result2 = messageSendServiceImpl$start$2$1$emit$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (messageSendServiceImpl$start$2$1$emit$1.label) {
            }
        }
    }

    public final Object invokeSuspend(Object $result) {
        Flow stateFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                stateFlow = this.this$0.getStateFlow();
                this.label = 1;
                if (stateFlow.collect(new AnonymousClass1(this.this$0), (Continuation) this) == coroutine_suspended) {
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