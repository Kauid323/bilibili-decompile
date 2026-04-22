package im.session.home;

import com.bapis.bilibili.app.im.v1.KAutoReplyToast;
import im.session.common.IMSessionEventHandler;
import im.session.common.IMSessionPageStateKt;
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
/* compiled from: AutoReplyBubble.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.home.AutoReplyBubbleKt$AutoReplyBubble$1$1$1$1", f = "AutoReplyBubble.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class AutoReplyBubbleKt$AutoReplyBubble$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ KAutoReplyToast $bubbleContent;
    final /* synthetic */ IMSessionEventHandler $eventHandler;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoReplyBubbleKt$AutoReplyBubble$1$1$1$1(IMSessionEventHandler iMSessionEventHandler, KAutoReplyToast kAutoReplyToast, Continuation<? super AutoReplyBubbleKt$AutoReplyBubble$1$1$1$1> continuation) {
        super(2, continuation);
        this.$eventHandler = iMSessionEventHandler;
        this.$bubbleContent = kAutoReplyToast;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AutoReplyBubbleKt$AutoReplyBubble$1$1$1$1(this.$eventHandler, this.$bubbleContent, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (IMSessionPageStateKt.invoke(this.$eventHandler.getRouteHandler(), this.$bubbleContent.getUrl(), (Continuation) this) == coroutine_suspended) {
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