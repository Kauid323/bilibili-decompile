package im.session.common;

import host.R;
import im.session.IMActionClickSessionCard;
import im.session.model.IMSessionCard;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMConversationSwipe.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.common.IMConversationSwipeKt$IMConversationSwipe$1$1$1$1", f = "IMConversationSwipe.kt", i = {}, l = {R.styleable.CameraView_cameraVideoSizeMinHeight}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class IMConversationSwipeKt$IMConversationSwipe$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IMSessionCard $conversation;
    final /* synthetic */ IMSessionEventHandler $eventHandler;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMConversationSwipeKt$IMConversationSwipe$1$1$1$1(IMSessionEventHandler iMSessionEventHandler, IMSessionCard iMSessionCard, Continuation<? super IMConversationSwipeKt$IMConversationSwipe$1$1$1$1> continuation) {
        super(2, continuation);
        this.$eventHandler = iMSessionEventHandler;
        this.$conversation = iMSessionCard;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IMConversationSwipeKt$IMConversationSwipe$1$1$1$1(this.$eventHandler, this.$conversation, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.$eventHandler.getActionHandler().invoke(new IMActionClickSessionCard(this.$conversation));
                this.label = 1;
                if (this.$eventHandler.getRouteHandler().invoke(this.$conversation.getUrlWithParam(), (Continuation) this) == coroutine_suspended) {
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