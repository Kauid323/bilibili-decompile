package kntr.app.im.chat.service;

import im.base.IMLog;
import kntr.app.im.chat.core.service.MessageSendProgress;
import kntr.app.im.chat.core.service.MessageTask;
import kntr.app.im.chat.service.MessageSendServiceImpl$start$3$1$1$1;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: MessageSendServiceImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.MessageSendServiceImpl$start$3$1$1$1", f = "MessageSendServiceImpl.kt", i = {}, l = {94}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class MessageSendServiceImpl$start$3$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MessageTask $uploadTask;
    int label;
    final /* synthetic */ MessageSendServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageSendServiceImpl$start$3$1$1$1(MessageTask messageTask, MessageSendServiceImpl messageSendServiceImpl, Continuation<? super MessageSendServiceImpl$start$3$1$1$1> continuation) {
        super(2, continuation);
        this.$uploadTask = messageTask;
        this.this$0 = messageSendServiceImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MessageSendServiceImpl$start$3$1$1$1(this.$uploadTask, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Flow onEach = FlowKt.onEach(this.$uploadTask.startUpload(), new AnonymousClass1(this.$uploadTask, null));
                final MessageSendServiceImpl messageSendServiceImpl = this.this$0;
                final MessageTask messageTask = this.$uploadTask;
                this.label = 1;
                if (onEach.collect(new FlowCollector() { // from class: kntr.app.im.chat.service.MessageSendServiceImpl$start$3$1$1$1.2
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((MessageSendProgress) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(MessageSendProgress it, Continuation<? super Unit> continuation) {
                        Object updateMap;
                        updateMap = MessageSendServiceImpl.this.updateMap(new MessageTask[]{messageTask}, continuation);
                        return updateMap == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? updateMap : Unit.INSTANCE;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MessageSendServiceImpl.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "it", "Lkntr/app/im/chat/core/service/MessageSendProgress;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kntr.app.im.chat.service.MessageSendServiceImpl$start$3$1$1$1$1", f = "MessageSendServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.app.im.chat.service.MessageSendServiceImpl$start$3$1$1$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<MessageSendProgress, Continuation<? super Unit>, Object> {
        final /* synthetic */ MessageTask $uploadTask;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MessageTask messageTask, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$uploadTask = messageTask;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$uploadTask, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(MessageSendProgress messageSendProgress, Continuation<? super Unit> continuation) {
            return create(messageSendProgress, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            final MessageSendProgress it = (MessageSendProgress) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    IMLog.Companion companion = IMLog.Companion;
                    final MessageTask messageTask = this.$uploadTask;
                    companion.d("MessageSendService", new Function0() { // from class: kntr.app.im.chat.service.MessageSendServiceImpl$start$3$1$1$1$1$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            String invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = MessageSendServiceImpl$start$3$1$1$1.AnonymousClass1.invokeSuspend$lambda$0(MessageTask.this, it);
                            return invokeSuspend$lambda$0;
                        }
                    });
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$0(MessageTask $uploadTask, MessageSendProgress $it) {
            return "上传任务 " + $uploadTask.getToken() + " 状态更新为 " + $it;
        }
    }
}