package io.ktor.serialization.kotlinx.json;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KotlinxSerializationJsonExtensions.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions", f = "KotlinxSerializationJsonExtensions.kt", i = {}, l = {64}, m = "deserialize", n = {}, s = {})
public final class KotlinxSerializationJsonExtensions$deserialize$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KotlinxSerializationJsonExtensions this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinxSerializationJsonExtensions$deserialize$1(KotlinxSerializationJsonExtensions kotlinxSerializationJsonExtensions, Continuation<? super KotlinxSerializationJsonExtensions$deserialize$1> continuation) {
        super(continuation);
        this.this$0 = kotlinxSerializationJsonExtensions;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deserialize(null, null, null, (Continuation) this);
    }
}