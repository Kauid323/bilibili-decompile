package io.ktor.util.cio;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Readers.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.cio.ReadersKt", f = "Readers.kt", i = {}, l = {17}, m = "toByteArray", n = {}, s = {})
public final class ReadersKt$toByteArray$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReadersKt$toByteArray$1(Continuation<? super ReadersKt$toByteArray$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ReadersKt.toByteArray(null, 0, (Continuation) this);
    }
}