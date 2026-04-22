package kntr.app.ad.domain.click.internal.interop;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Scheme.android.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.ad.domain.click.internal.interop.Scheme_androidKt", f = "Scheme.android.kt", i = {0, 0, 0}, l = {34}, m = "openScheme", n = {"context", "url", "intent"}, s = {"L$0", "L$1", "L$2"}, v = 1)
public final class Scheme_androidKt$openScheme$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Scheme_androidKt$openScheme$1(Continuation<? super Scheme_androidKt$openScheme$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return Scheme_androidKt.openScheme(null, null, (Continuation) this);
    }
}