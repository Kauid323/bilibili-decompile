package kntr.app.im.chat.di.module.assistant;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssistantNotifyModule.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.di.module.assistant.AssistantNotifyModule$provideNotifyMessageService$1", f = "AssistantNotifyModule.kt", i = {0, 0, 0}, l = {26}, m = "notifyMessageOp-gIAlu-s", n = {"it", "$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-AssistantNotifyModule$provideNotifyMessageService$1$1"}, s = {"L$0", "I$0", "I$1"}, v = 1)
/* renamed from: kntr.app.im.chat.di.module.assistant.AssistantNotifyModule$provideNotifyMessageService$1$notifyMessageOp-gIAlu-s$1  reason: invalid class name */
public final class AssistantNotifyModule$provideNotifyMessageService$1$notifyMessageOpgIAlus$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AssistantNotifyModule$provideNotifyMessageService$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AssistantNotifyModule$provideNotifyMessageService$1$notifyMessageOpgIAlus$1(AssistantNotifyModule$provideNotifyMessageService$1 assistantNotifyModule$provideNotifyMessageService$1, Continuation<? super AssistantNotifyModule$provideNotifyMessageService$1$notifyMessageOpgIAlus$1> continuation) {
        super(continuation);
        this.this$0 = assistantNotifyModule$provideNotifyMessageService$1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object mo1363notifyMessageOpgIAlus = this.this$0.mo1363notifyMessageOpgIAlus(null, (Continuation) this);
        return mo1363notifyMessageOpgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mo1363notifyMessageOpgIAlus : Result.box-impl(mo1363notifyMessageOpgIAlus);
    }
}