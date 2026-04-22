package io.ktor.util;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Deflater.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.DeflaterKt", f = "Deflater.kt", i = {0, 1}, l = {37, 38, 39}, m = "putGzipHeader", n = {"$this$putGzipHeader", "$this$putGzipHeader"}, s = {"L$0", "L$0"})
public final class DeflaterKt$putGzipHeader$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeflaterKt$putGzipHeader$1(Continuation<? super DeflaterKt$putGzipHeader$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object putGzipHeader;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        putGzipHeader = DeflaterKt.putGzipHeader(null, (Continuation) this);
        return putGzipHeader;
    }
}