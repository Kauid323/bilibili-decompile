package io.ktor.util;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Deflater.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.DeflaterKt", f = "Deflater.kt", i = {0, 0, 0, 0}, l = {52}, m = "deflateWhile", n = {"$this$deflateWhile", "deflater", "buffer", "predicate"}, s = {"L$0", "L$1", "L$2", "L$3"})
public final class DeflaterKt$deflateWhile$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeflaterKt$deflateWhile$1(Continuation<? super DeflaterKt$deflateWhile$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object deflateWhile;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        deflateWhile = DeflaterKt.deflateWhile(null, null, null, null, (Continuation) this);
        return deflateWhile;
    }
}