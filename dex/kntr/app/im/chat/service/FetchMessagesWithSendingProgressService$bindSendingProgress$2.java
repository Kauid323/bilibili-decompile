package kntr.app.im.chat.service;

import java.util.LinkedHashMap;
import kntr.app.im.chat.core.model.FetchMessagesData;
import kntr.app.im.chat.core.service.MessageTask;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FetchMessagesWithSendingProgressService.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "tasks", "Ljava/util/LinkedHashMap;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/core/service/MessageTask;", "state", "Lkntr/app/im/chat/core/model/FetchMessagesData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.FetchMessagesWithSendingProgressService$bindSendingProgress$2", f = "FetchMessagesWithSendingProgressService.kt", i = {0, 0}, l = {384}, m = "invokeSuspend", n = {"tasks", "state"}, s = {"L$0", "L$1"}, v = 1)
public final class FetchMessagesWithSendingProgressService$bindSendingProgress$2 extends SuspendLambda implements Function3<LinkedHashMap<String, MessageTask>, FetchMessagesData, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ FetchMessagesWithSendingProgressService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FetchMessagesWithSendingProgressService$bindSendingProgress$2(FetchMessagesWithSendingProgressService fetchMessagesWithSendingProgressService, Continuation<? super FetchMessagesWithSendingProgressService$bindSendingProgress$2> continuation) {
        super(3, continuation);
        this.this$0 = fetchMessagesWithSendingProgressService;
    }

    public final Object invoke(LinkedHashMap<String, MessageTask> linkedHashMap, FetchMessagesData fetchMessagesData, Continuation<? super Unit> continuation) {
        FetchMessagesWithSendingProgressService$bindSendingProgress$2 fetchMessagesWithSendingProgressService$bindSendingProgress$2 = new FetchMessagesWithSendingProgressService$bindSendingProgress$2(this.this$0, continuation);
        fetchMessagesWithSendingProgressService$bindSendingProgress$2.L$0 = linkedHashMap;
        fetchMessagesWithSendingProgressService$bindSendingProgress$2.L$1 = fetchMessagesData;
        return fetchMessagesWithSendingProgressService$bindSendingProgress$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FetchMessagesWithSendingProgressService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kntr.app.im.chat.service.FetchMessagesWithSendingProgressService$bindSendingProgress$2$1", f = "FetchMessagesWithSendingProgressService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.app.im.chat.service.FetchMessagesWithSendingProgressService$bindSendingProgress$2$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FetchMessagesData $state;
        final /* synthetic */ LinkedHashMap<String, MessageTask> $tasks;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ FetchMessagesWithSendingProgressService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LinkedHashMap<String, MessageTask> linkedHashMap, FetchMessagesWithSendingProgressService fetchMessagesWithSendingProgressService, FetchMessagesData fetchMessagesData, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$tasks = linkedHashMap;
            this.this$0 = fetchMessagesWithSendingProgressService;
            this.$state = fetchMessagesData;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$tasks, this.this$0, this.$state, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Iterable values = this.$tasks.values();
                    Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
                    Iterable $this$forEach$iv = values;
                    FetchMessagesWithSendingProgressService fetchMessagesWithSendingProgressService = this.this$0;
                    FetchMessagesData fetchMessagesData = this.$state;
                    for (Object element$iv : $this$forEach$iv) {
                        MessageTask task = (MessageTask) element$iv;
                        BuildersKt.async$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new FetchMessagesWithSendingProgressService$bindSendingProgress$2$1$1$1(task, fetchMessagesWithSendingProgressService, fetchMessagesData, null), 3, (Object) null);
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Object invokeSuspend(Object $result) {
        LinkedHashMap tasks = (LinkedHashMap) this.L$0;
        FetchMessagesData state = (FetchMessagesData) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable(tasks);
                this.L$1 = SpillingKt.nullOutSpilledVariable(state);
                this.label = 1;
                if (CoroutineScopeKt.coroutineScope(new AnonymousClass1(tasks, this.this$0, state, null), (Continuation) this) == coroutine_suspended) {
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