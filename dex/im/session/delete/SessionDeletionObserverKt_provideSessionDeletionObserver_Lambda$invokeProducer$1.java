package im.session.delete;

import host.R;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SessionDeletionObserverKt_provideSessionDeletionObserver_Lambda.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.delete.SessionDeletionObserverKt_provideSessionDeletionObserver_Lambda", f = "SessionDeletionObserverKt_provideSessionDeletionObserver_Lambda.kt", i = {}, l = {R.styleable.CameraView_cameraVideoCodec}, m = "invokeProducer", n = {}, s = {}, v = 1)
public final class SessionDeletionObserverKt_provideSessionDeletionObserver_Lambda$invokeProducer$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SessionDeletionObserverKt_provideSessionDeletionObserver_Lambda this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionDeletionObserverKt_provideSessionDeletionObserver_Lambda$invokeProducer$1(SessionDeletionObserverKt_provideSessionDeletionObserver_Lambda sessionDeletionObserverKt_provideSessionDeletionObserver_Lambda, Continuation<? super SessionDeletionObserverKt_provideSessionDeletionObserver_Lambda$invokeProducer$1> continuation) {
        super(continuation);
        this.this$0 = sessionDeletionObserverKt_provideSessionDeletionObserver_Lambda;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invokeProducer((Continuation) this);
    }
}