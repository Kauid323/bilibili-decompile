package tv.danmaku.bili.push.innerpush;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UploadStreamRpc.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.push.innerpush.UploadStreamRpc", f = "UploadStreamRpc.kt", i = {0, 0}, l = {BR.buttonVisible}, m = "send", n = {"value", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"}, v = 1)
public final class UploadStreamRpc$send$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UploadStreamRpc<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadStreamRpc$send$1(UploadStreamRpc<T> uploadStreamRpc, Continuation<? super UploadStreamRpc$send$1> continuation) {
        super(continuation);
        this.this$0 = uploadStreamRpc;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.send(null, (Continuation) this);
    }
}