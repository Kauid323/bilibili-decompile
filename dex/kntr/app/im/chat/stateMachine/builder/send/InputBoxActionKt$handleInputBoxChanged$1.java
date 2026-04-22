package kntr.app.im.chat.stateMachine.builder.send;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InputBoxAction.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.stateMachine.builder.send.InputBoxActionKt", f = "InputBoxAction.kt", i = {0, 0, 0, 0}, l = {147}, m = "handleInputBoxChanged", n = {"$this$handleInputBoxChanged", "draftService", "newValue", "active"}, s = {"L$0", "L$1", "L$2", "Z$0"}, v = 1)
public final class InputBoxActionKt$handleInputBoxChanged$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InputBoxActionKt$handleInputBoxChanged$1(Continuation<? super InputBoxActionKt$handleInputBoxChanged$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object handleInputBoxChanged;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        handleInputBoxChanged = InputBoxActionKt.handleInputBoxChanged(null, null, null, false, (Continuation) this);
        return handleInputBoxChanged;
    }
}