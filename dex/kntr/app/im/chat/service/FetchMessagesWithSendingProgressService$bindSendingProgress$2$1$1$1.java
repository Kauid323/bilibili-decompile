package kntr.app.im.chat.service;

import im.base.IMLog;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.FetchMessagesData;
import kntr.app.im.chat.core.service.MessageDatabaseService;
import kntr.app.im.chat.core.service.MessageSendProgress;
import kntr.app.im.chat.core.service.MessageSendServiceKt;
import kntr.app.im.chat.core.service.MessageTask;
import kntr.app.im.chat.service.FetchMessagesWithSendingProgressService$bindSendingProgress$2$1$1$1;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FetchMessagesWithSendingProgressService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.FetchMessagesWithSendingProgressService$bindSendingProgress$2$1$1$1", f = "FetchMessagesWithSendingProgressService.kt", i = {}, l = {387}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class FetchMessagesWithSendingProgressService$bindSendingProgress$2$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FetchMessagesData $state;
    final /* synthetic */ MessageTask $task;
    int label;
    final /* synthetic */ FetchMessagesWithSendingProgressService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FetchMessagesWithSendingProgressService$bindSendingProgress$2$1$1$1(MessageTask messageTask, FetchMessagesWithSendingProgressService fetchMessagesWithSendingProgressService, FetchMessagesData fetchMessagesData, Continuation<? super FetchMessagesWithSendingProgressService$bindSendingProgress$2$1$1$1> continuation) {
        super(2, continuation);
        this.$task = messageTask;
        this.this$0 = fetchMessagesWithSendingProgressService;
        this.$state = fetchMessagesData;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FetchMessagesWithSendingProgressService$bindSendingProgress$2$1$1$1(this.$task, this.this$0, this.$state, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FetchMessagesWithSendingProgressService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: kntr.app.im.chat.service.FetchMessagesWithSendingProgressService$bindSendingProgress$2$1$1$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ FetchMessagesData $state;
        final /* synthetic */ MessageTask $task;
        final /* synthetic */ FetchMessagesWithSendingProgressService this$0;

        AnonymousClass1(FetchMessagesWithSendingProgressService fetchMessagesWithSendingProgressService, MessageTask messageTask, FetchMessagesData fetchMessagesData) {
            this.this$0 = fetchMessagesWithSendingProgressService;
            this.$task = messageTask;
            this.$state = fetchMessagesData;
        }

        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
            return emit((MessageSendProgress) value, (Continuation<? super Unit>) $completion);
        }

        public final Object emit(final MessageSendProgress it, Continuation<? super Unit> continuation) {
            EntityMessage message;
            MessageDatabaseService messageDatabaseService;
            FetchMessagesWithSendingProgressService fetchMessagesWithSendingProgressService = this.this$0;
            MessageTask messageTask = this.$task;
            Intrinsics.checkNotNull(messageTask);
            message = fetchMessagesWithSendingProgressService.buildMessage(messageTask, this.$state.getMessages().getLastSequence());
            if (message != null) {
                IMLog.Companion companion = IMLog.Companion;
                final MessageTask messageTask2 = this.$task;
                companion.d("ChatFetchService", new Function0() { // from class: kntr.app.im.chat.service.FetchMessagesWithSendingProgressService$bindSendingProgress$2$1$1$1$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        String emit$lambda$0;
                        emit$lambda$0 = FetchMessagesWithSendingProgressService$bindSendingProgress$2$1$1$1.AnonymousClass1.emit$lambda$0(MessageTask.this, it);
                        return emit$lambda$0;
                    }
                });
                messageDatabaseService = this.this$0.messageDatabaseService;
                Object add = messageDatabaseService.add(message, continuation);
                return add == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? add : Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String emit$lambda$0(MessageTask $task, MessageSendProgress $it) {
            String token = $task.getToken();
            return "Writing sending progress to DB: task=" + token + ", progress=" + Reflection.getOrCreateKotlinClass($it.getClass());
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                MessageTask messageTask = this.$task;
                Intrinsics.checkNotNull(messageTask);
                this.label = 1;
                if (MessageSendServiceKt.progressFlow(messageTask).collect(new AnonymousClass1(this.this$0, this.$task, this.$state), (Continuation) this) == coroutine_suspended) {
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