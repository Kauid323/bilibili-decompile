package kotlinx.coroutines.rx3;

import io.reactivex.rxjava3.core.MaybeSource;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.IntCompanionObject;
import org.webrtc.H265Utils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RxAwait.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.rx3.RxAwaitKt", f = "RxAwait.kt", i = {}, l = {H265Utils.kLevel2_1}, m = "awaitSingle", n = {}, s = {})
public final class RxAwaitKt$awaitSingle$1<T> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RxAwaitKt$awaitSingle$1(Continuation<? super RxAwaitKt$awaitSingle$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= IntCompanionObject.MIN_VALUE;
        return RxAwaitKt.awaitSingle((MaybeSource) null, this);
    }
}