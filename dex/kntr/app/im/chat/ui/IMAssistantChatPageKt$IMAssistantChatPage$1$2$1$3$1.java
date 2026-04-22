package kntr.app.im.chat.ui;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import com.bapis.bilibili.app.im.v1.KChatInfoReply;
import java.util.Map;
import kntr.app.im.chat.core.model.ChatInfo;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.ui.neuron.ChatReporter;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMAssistantChatPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.IMAssistantChatPageKt$IMAssistantChatPage$1$2$1$3$1", f = "IMAssistantChatPage.kt", i = {}, l = {128}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class IMAssistantChatPageKt$IMAssistantChatPage$1$2$1$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<ChatPageData> $pageState;
    final /* synthetic */ ChatReporter $reporter;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMAssistantChatPageKt$IMAssistantChatPage$1$2$1$3$1(State<ChatPageData> state, ChatReporter chatReporter, Continuation<? super IMAssistantChatPageKt$IMAssistantChatPage$1$2$1$3$1> continuation) {
        super(2, continuation);
        this.$pageState = state;
        this.$reporter = chatReporter;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IMAssistantChatPageKt$IMAssistantChatPage$1$2$1$3$1(this.$pageState, this.$reporter, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final State<ChatPageData> state = this.$pageState;
                final Flow $this$mapNotNull$iv = SnapshotStateKt.snapshotFlow(new Function0<ChatPageData>() { // from class: kntr.app.im.chat.ui.IMAssistantChatPageKt$IMAssistantChatPage$1$2$1$3$1.1
                    public final ChatPageData invoke() {
                        return (ChatPageData) state.getValue();
                    }
                });
                Flow $this$mapNotNull$iv2 = FlowKt.distinctUntilChanged(new Flow<Map<String, ? extends String>>() { // from class: kntr.app.im.chat.ui.IMAssistantChatPageKt$IMAssistantChatPage$1$2$1$3$1$invokeSuspend$$inlined$mapNotNull$1
                    public Object collect(FlowCollector collector, Continuation $completion) {
                        Object collect = $this$mapNotNull$iv.collect(new AnonymousClass2(collector), $completion);
                        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                    }

                    /* compiled from: Emitters.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                    /* renamed from: kntr.app.im.chat.ui.IMAssistantChatPageKt$IMAssistantChatPage$1$2$1$3$1$invokeSuspend$$inlined$mapNotNull$1$2  reason: invalid class name */
                    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* compiled from: Emitters.kt */
                        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "kntr.app.im.chat.ui.IMAssistantChatPageKt$IMAssistantChatPage$1$2$1$3$1$invokeSuspend$$inlined$mapNotNull$1$2", f = "IMAssistantChatPage.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                        /* renamed from: kntr.app.im.chat.ui.IMAssistantChatPageKt$IMAssistantChatPage$1$2$1$3$1$invokeSuspend$$inlined$mapNotNull$1$2$1  reason: invalid class name */
                        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            int I$0;
                            Object L$0;
                            Object L$1;
                            Object L$2;
                            Object L$3;
                            Object L$4;
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
                        /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Object emit(Object value, Continuation $completion) {
                            Continuation $continuation;
                            KChatInfoReply reply;
                            if ($completion instanceof AnonymousClass1) {
                                $continuation = (AnonymousClass1) $completion;
                                if (($continuation.label & Integer.MIN_VALUE) != 0) {
                                    $continuation.label -= Integer.MIN_VALUE;
                                    Object $result = $continuation.result;
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch ($continuation.label) {
                                        case 0:
                                            ResultKt.throwOnFailure($result);
                                            FlowCollector $this$mapNotNull_u24lambda_u246 = this.$this_unsafeFlow;
                                            AnonymousClass1 anonymousClass1 = $continuation;
                                            ChatPageData it = (ChatPageData) value;
                                            ChatInfo chatInfo = it.getChatInfo();
                                            Object traceParams = (chatInfo == null || (reply = chatInfo.getReply()) == null) ? null : reply.getTraceParams();
                                            if (traceParams != null) {
                                                Object transformed = traceParams;
                                                $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                                $continuation.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                                $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                                $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$mapNotNull_u24lambda_u246);
                                                $continuation.L$4 = SpillingKt.nullOutSpilledVariable(transformed);
                                                $continuation.I$0 = 0;
                                                $continuation.label = 1;
                                                if ($this$mapNotNull_u24lambda_u246.emit(transformed, $continuation) != coroutine_suspended) {
                                                    break;
                                                } else {
                                                    return coroutine_suspended;
                                                }
                                            }
                                            break;
                                        case 1:
                                            int i = $continuation.I$0;
                                            Map map = (Map) $continuation.L$4;
                                            FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                            Object obj = $continuation.L$2;
                                            AnonymousClass1 anonymousClass12 = (AnonymousClass1) $continuation.L$1;
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
                });
                final ChatReporter chatReporter = this.$reporter;
                this.label = 1;
                if ($this$mapNotNull$iv2.collect(new FlowCollector() { // from class: kntr.app.im.chat.ui.IMAssistantChatPageKt$IMAssistantChatPage$1$2$1$3$1.3
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((Map) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(Map<String, String> map, Continuation<? super Unit> continuation) {
                        ChatReporter.this.appendParam(map);
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