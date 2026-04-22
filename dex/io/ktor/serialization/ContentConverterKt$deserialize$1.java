package io.ktor.serialization;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ContentConverter.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.serialization.ContentConverterKt", f = "ContentConverter.kt", i = {0, 0}, l = {97}, m = "deserialize", n = {"body", "typeInfo"}, s = {"L$0", "L$1"})
public final class ContentConverterKt$deserialize$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ContentConverterKt$deserialize$1(Continuation<? super ContentConverterKt$deserialize$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ContentConverterKt.deserialize(null, null, null, null, (Continuation) this);
    }
}