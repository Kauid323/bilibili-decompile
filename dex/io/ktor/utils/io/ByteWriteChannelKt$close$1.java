package io.ktor.utils.io;

import com.lynx.tasm.behavior.PropertyIDConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: ByteWriteChannel.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
/* synthetic */ class ByteWriteChannelKt$close$1 extends FunctionReferenceImpl implements Function1<Continuation<? super Unit>, Object>, SuspendFunction {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteWriteChannelKt$close$1(Object obj) {
        super(1, obj, ByteWriteChannel.class, "flushAndClose", "flushAndClose(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((ByteWriteChannel) this.receiver).flushAndClose(continuation);
    }
}