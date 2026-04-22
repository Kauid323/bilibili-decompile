package io.ktor.util;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Deflater.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.DeflaterKt", f = "Deflater.kt", i = {0, 0}, l = {43, 44}, m = "putGzipTrailer", n = {"$this$putGzipTrailer", "deflater"}, s = {"L$0", "L$1"})
public final class DeflaterKt$putGzipTrailer$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeflaterKt$putGzipTrailer$1(Continuation<? super DeflaterKt$putGzipTrailer$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object putGzipTrailer;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        putGzipTrailer = DeflaterKt.putGzipTrailer(null, null, null, (Continuation) this);
        return putGzipTrailer;
    }
}