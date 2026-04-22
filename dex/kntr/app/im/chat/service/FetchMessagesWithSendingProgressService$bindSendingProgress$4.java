package kntr.app.im.chat.service;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.base.IMLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.FetchMessagesData;
import kntr.app.im.chat.core.model.Messages;
import kntr.app.im.chat.core.service.MessageSendProgress;
import kntr.app.im.chat.core.service.MessageTask;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.account.AccountState;
import kntr.base.account.KAccountStore;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;
import kotlinx.datetime.Instant;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FetchMessagesWithSendingProgressService.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u001d\u0010\u0003\u001a\u0019\u0012\u0015\u0012\u0013\u0012\t\u0012\u00070\u0006¢\u0006\u0002\b\u0007\u0012\u0004\u0012\u00020\b0\u00050\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/im/chat/core/model/FetchMessagesData;", "tasks", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/Pair;", "Lkntr/app/im/chat/core/service/MessageTask;", "Lkotlin/jvm/internal/EnhancedNullability;", "Lkntr/app/im/chat/core/service/MessageSendProgress;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.FetchMessagesWithSendingProgressService$bindSendingProgress$4", f = "FetchMessagesWithSendingProgressService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class FetchMessagesWithSendingProgressService$bindSendingProgress$4 extends SuspendLambda implements Function3<List<? extends Pair<? extends MessageTask, ? extends MessageSendProgress>>, State<FetchMessagesData>, Continuation<? super ChangedState<? extends FetchMessagesData>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ FetchMessagesWithSendingProgressService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FetchMessagesWithSendingProgressService$bindSendingProgress$4(FetchMessagesWithSendingProgressService fetchMessagesWithSendingProgressService, Continuation<? super FetchMessagesWithSendingProgressService$bindSendingProgress$4> continuation) {
        super(3, continuation);
        this.this$0 = fetchMessagesWithSendingProgressService;
    }

    public final Object invoke(List<? extends Pair<? extends MessageTask, ? extends MessageSendProgress>> list, State<FetchMessagesData> state, Continuation<? super ChangedState<FetchMessagesData>> continuation) {
        FetchMessagesWithSendingProgressService$bindSendingProgress$4 fetchMessagesWithSendingProgressService$bindSendingProgress$4 = new FetchMessagesWithSendingProgressService$bindSendingProgress$4(this.this$0, continuation);
        fetchMessagesWithSendingProgressService$bindSendingProgress$4.L$0 = list;
        fetchMessagesWithSendingProgressService$bindSendingProgress$4.L$1 = state;
        return fetchMessagesWithSendingProgressService$bindSendingProgress$4.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Exception exc;
        MessageSendProgress.SendFailed sendFailed;
        KAccountStore kAccountStore;
        EntityMessage buildMessage;
        Iterable tasks = (List) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Iterable $this$mapNotNull$iv = tasks;
                FetchMessagesWithSendingProgressService fetchMessagesWithSendingProgressService = this.this$0;
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                    Object component1 = ((Pair) element$iv$iv$iv).component1();
                    Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                    Intrinsics.checkNotNullExpressionValue(component1, "component1(...)");
                    MessageTask task = (MessageTask) component1;
                    buildMessage = fetchMessagesWithSendingProgressService.buildMessage(task, ((FetchMessagesData) state.getSnapshot()).getMessages().getLastSequence());
                    if (buildMessage != null) {
                        destination$iv$iv.add(buildMessage);
                    }
                    $this$mapNotNull$iv = $this$mapNotNull$iv2;
                }
                final List messages = (List) destination$iv$iv;
                Iterator it = tasks.iterator();
                while (true) {
                    exc = null;
                    if (it.hasNext()) {
                        Pair it2 = (Pair) it.next();
                        Object second = it2.getSecond();
                        if (second instanceof MessageSendProgress.SendFailed) {
                            sendFailed = (MessageSendProgress.SendFailed) second;
                            continue;
                        } else {
                            sendFailed = null;
                            continue;
                        }
                        if (sendFailed != null) {
                        }
                    } else {
                        sendFailed = null;
                    }
                }
                MessageSendProgress.SendFailed firstError = sendFailed;
                if (firstError != null) {
                    FetchMessagesWithSendingProgressService fetchMessagesWithSendingProgressService2 = this.this$0;
                    Exception error = firstError.getError();
                    kAccountStore = this.this$0.account;
                    exc = fetchMessagesWithSendingProgressService2.mapException(error, (AccountState) kAccountStore.getState().getValue());
                }
                final Exception exception = exc;
                IMLog.Companion.e$default(IMLog.Companion, "ChatFetchService", "Updating sending progress to State: " + messages.size() + " messages, exception=" + exception, (Throwable) null, 4, (Object) null);
                return state.mutate(new Function1() { // from class: kntr.app.im.chat.service.FetchMessagesWithSendingProgressService$bindSendingProgress$4$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        FetchMessagesData invokeSuspend$lambda$2;
                        invokeSuspend$lambda$2 = FetchMessagesWithSendingProgressService$bindSendingProgress$4.invokeSuspend$lambda$2(messages, exception, (FetchMessagesData) obj);
                        return invokeSuspend$lambda$2;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FetchMessagesData invokeSuspend$lambda$2(List $messages, Exception $exception, FetchMessagesData $this$mutate) {
        Instant errorTime;
        FetchMessagesData copy;
        Messages copy$default = Messages.copy$default($this$mutate.getMessages(), null, null, $messages, 3, null);
        Throwable error = $exception != null ? $exception : $this$mutate.getError();
        if ($exception == null || (errorTime = Clock.System.INSTANCE.now()) == null) {
            errorTime = $this$mutate.getErrorTime();
        }
        copy = $this$mutate.copy((r30 & 1) != 0 ? $this$mutate.databaseReady : false, (r30 & 2) != 0 ? $this$mutate.loadingLater : false, (r30 & 4) != 0 ? $this$mutate.pendingLoadLater : false, (r30 & 8) != 0 ? $this$mutate.loadingEarlier : false, (r30 & 16) != 0 ? $this$mutate.pendingLoadEarlier : false, (r30 & 32) != 0 ? $this$mutate.currentRange : null, (r30 & 64) != 0 ? $this$mutate.messages : copy$default, (r30 & 128) != 0 ? $this$mutate.baselineTime : null, (r30 & 256) != 0 ? $this$mutate.tempMessages : null, (r30 & 512) != 0 ? $this$mutate.updateMsgIds : null, (r30 & 1024) != 0 ? $this$mutate.markFailedMessage : null, (r30 & 2048) != 0 ? $this$mutate.performAck : false, (r30 & 4096) != 0 ? $this$mutate.error : error, (r30 & 8192) != 0 ? $this$mutate.errorTime : errorTime);
        return copy;
    }
}