package io.ktor.client.statement;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Readers.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.statement.ReadersKt", f = "Readers.kt", i = {}, l = {15}, m = "readBytes", n = {}, s = {})
public final class ReadersKt$readBytes$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReadersKt$readBytes$1(Continuation<? super ReadersKt$readBytes$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ReadersKt.readBytes(null, 0, (Continuation) this);
    }
}