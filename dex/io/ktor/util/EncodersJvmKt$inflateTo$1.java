package io.ktor.util;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EncodersJvm.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.EncodersJvmKt", f = "EncodersJvm.kt", i = {0}, l = {167}, m = "inflateTo", n = {"inflated"}, s = {"I$0"})
public final class EncodersJvmKt$inflateTo$1 extends ContinuationImpl {
    int I$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EncodersJvmKt$inflateTo$1(Continuation<? super EncodersJvmKt$inflateTo$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object inflateTo;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        inflateTo = EncodersJvmKt.inflateTo(null, null, null, null, (Continuation) this);
        return inflateTo;
    }
}