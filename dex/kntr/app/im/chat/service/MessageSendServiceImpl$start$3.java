package kntr.app.im.chat.service;

import java.util.LinkedHashMap;
import java.util.Map;
import kntr.app.im.chat.core.service.MessageSendProgress;
import kntr.app.im.chat.core.service.MessageTask;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: MessageSendServiceImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.MessageSendServiceImpl$start$3", f = "MessageSendServiceImpl.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class MessageSendServiceImpl$start$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineScope $localScope;
    int label;
    final /* synthetic */ MessageSendServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageSendServiceImpl$start$3(MessageSendServiceImpl messageSendServiceImpl, CoroutineScope coroutineScope, Continuation<? super MessageSendServiceImpl$start$3> continuation) {
        super(2, continuation);
        this.this$0 = messageSendServiceImpl;
        this.$localScope = coroutineScope;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MessageSendServiceImpl$start$3(this.this$0, this.$localScope, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Flow stateFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                stateFlow = this.this$0.getStateFlow();
                final CoroutineScope coroutineScope = this.$localScope;
                final MessageSendServiceImpl messageSendServiceImpl = this.this$0;
                this.label = 1;
                if (stateFlow.collect(new FlowCollector() { // from class: kntr.app.im.chat.service.MessageSendServiceImpl$start$3.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((LinkedHashMap) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(LinkedHashMap<String, MessageTask> linkedHashMap, Continuation<? super Unit> continuation) {
                        LinkedHashMap<String, MessageTask> $this$filterValues$iv = linkedHashMap;
                        LinkedHashMap result$iv = new LinkedHashMap();
                        for (Map.Entry entry$iv : $this$filterValues$iv.entrySet()) {
                            MessageTask it = entry$iv.getValue();
                            if (Intrinsics.areEqual(it.getProgress().getValue(), MessageSendProgress.Pending.INSTANCE)) {
                                result$iv.put(entry$iv.getKey(), entry$iv.getValue());
                            }
                        }
                        LinkedHashMap $this$filterValues$iv2 = result$iv;
                        Iterable upload = $this$filterValues$iv2.values();
                        Iterable $this$forEach$iv = upload;
                        CoroutineScope coroutineScope2 = coroutineScope;
                        MessageSendServiceImpl messageSendServiceImpl2 = messageSendServiceImpl;
                        for (Object element$iv : $this$forEach$iv) {
                            MessageTask uploadTask = (MessageTask) element$iv;
                            BuildersKt.launch$default(coroutineScope2, (CoroutineContext) null, (CoroutineStart) null, new MessageSendServiceImpl$start$3$1$1$1(uploadTask, messageSendServiceImpl2, null), 3, (Object) null);
                        }
                        return Unit.INSTANCE;
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