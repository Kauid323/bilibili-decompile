package io.ktor.client.statement;

import host.R;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpStatement.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", i = {0, 0, 1, 1}, l = {49, R.styleable.CameraView_cameraVideoSizeMinArea, R.styleable.CameraView_cameraVideoSizeMinWidth, R.styleable.CameraView_cameraVideoSizeMinWidth}, m = "execute", n = {"this", "block", "this", "response"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class HttpStatement$execute$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HttpStatement this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpStatement$execute$1(HttpStatement httpStatement, Continuation<? super HttpStatement$execute$1> continuation) {
        super(continuation);
        this.this$0 = httpStatement;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.execute(null, (Continuation) this);
    }
}