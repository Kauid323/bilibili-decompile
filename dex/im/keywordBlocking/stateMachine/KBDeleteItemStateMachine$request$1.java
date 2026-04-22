package im.keywordBlocking.stateMachine;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KBDeleteItemStateMachine.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.keywordBlocking.stateMachine.KBDeleteItemStateMachine", f = "KBDeleteItemStateMachine.kt", i = {0}, l = {64}, m = SocialConstants.TYPE_REQUEST, n = {"$this$request"}, s = {"L$0"}, v = 1)
public final class KBDeleteItemStateMachine$request$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KBDeleteItemStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KBDeleteItemStateMachine$request$1(KBDeleteItemStateMachine kBDeleteItemStateMachine, Continuation<? super KBDeleteItemStateMachine$request$1> continuation) {
        super(continuation);
        this.this$0 = kBDeleteItemStateMachine;
    }

    public final Object invokeSuspend(Object obj) {
        Object request;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        request = this.this$0.request(null, (Continuation) this);
        return request;
    }
}