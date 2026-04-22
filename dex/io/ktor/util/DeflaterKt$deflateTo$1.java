package io.ktor.util;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Deflater.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.DeflaterKt", f = "Deflater.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4}, l = {72, 77, 82, 88, 91}, m = "deflateTo", n = {"$this$deflateTo", "destination", "pool", "crc", "deflater", "input", "compressed", "gzip", "$this$deflateTo", "destination", "pool", "crc", "deflater", "input", "compressed", "gzip", "$this$deflateTo", "destination", "pool", "crc", "deflater", "input", "compressed", "gzip", "destination", "pool", "crc", "deflater", "input", "compressed", "gzip", "pool", "deflater", "input", "compressed"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "L$0", "L$1", "L$2", "L$3"})
public final class DeflaterKt$deflateTo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeflaterKt$deflateTo$1(Continuation<? super DeflaterKt$deflateTo$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object deflateTo;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        deflateTo = DeflaterKt.deflateTo(null, null, false, null, (Continuation) this);
        return deflateTo;
    }
}