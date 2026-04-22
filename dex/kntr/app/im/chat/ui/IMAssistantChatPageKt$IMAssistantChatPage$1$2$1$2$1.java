package kntr.app.im.chat.ui;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import java.util.Map;
import kntr.app.im.chat.ui.neuron.ChatReporter;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.pv.PvEventTrigger;
import kntr.common.pv.PvEventTriggerKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMAssistantChatPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.IMAssistantChatPageKt$IMAssistantChatPage$1$2$1$2$1", f = "IMAssistantChatPage.kt", i = {}, l = {115}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class IMAssistantChatPageKt$IMAssistantChatPage$1$2$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PvEventTrigger $pvTrigger;
    final /* synthetic */ ChatReporter $reporter;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMAssistantChatPageKt$IMAssistantChatPage$1$2$1$2$1(ChatReporter chatReporter, PvEventTrigger pvEventTrigger, Continuation<? super IMAssistantChatPageKt$IMAssistantChatPage$1$2$1$2$1> continuation) {
        super(2, continuation);
        this.$reporter = chatReporter;
        this.$pvTrigger = pvEventTrigger;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IMAssistantChatPageKt$IMAssistantChatPage$1$2$1$2$1(this.$reporter, this.$pvTrigger, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final ChatReporter chatReporter = this.$reporter;
                Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0<SnapshotStateMap<String, String>>() { // from class: kntr.app.im.chat.ui.IMAssistantChatPageKt$IMAssistantChatPage$1$2$1$2$1.1
                    /* renamed from: invoke */
                    public final SnapshotStateMap<String, String> m1719invoke() {
                        return ChatReporter.this.getPageEventParamMap();
                    }
                });
                final PvEventTrigger pvEventTrigger = this.$pvTrigger;
                this.label = 1;
                if (snapshotFlow.collect(new FlowCollector() { // from class: kntr.app.im.chat.ui.IMAssistantChatPageKt$IMAssistantChatPage$1$2$1$2$1.2
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((SnapshotStateMap) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(SnapshotStateMap<String, String> snapshotStateMap, Continuation<? super Unit> continuation) {
                        PvEventTriggerKt.updateExtra(pvEventTrigger, (Map) snapshotStateMap);
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