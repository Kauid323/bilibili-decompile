package io.ktor.serialization.kotlinx.json;

import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.utils.io.ByteWriteChannel;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.Flow;
import kotlinx.serialization.KSerializer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KotlinxSerializationJsonExtensions.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions", f = "KotlinxSerializationJsonExtensions.kt", i = {0, 0, 0, 0, 0, 0, 1, 1}, l = {78, 118, 87}, m = "serialize", n = {"this", "$this$serialize", "serializer", HttpAuthHeader.Parameters.Charset, "channel", "jsonArraySymbols", "channel", "jsonArraySymbols"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1"})
public final class KotlinxSerializationJsonExtensions$serialize$3<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KotlinxSerializationJsonExtensions this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinxSerializationJsonExtensions$serialize$3(KotlinxSerializationJsonExtensions kotlinxSerializationJsonExtensions, Continuation<? super KotlinxSerializationJsonExtensions$serialize$3> continuation) {
        super(continuation);
        this.this$0 = kotlinxSerializationJsonExtensions;
    }

    public final Object invokeSuspend(Object obj) {
        Object serialize;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        serialize = this.this$0.serialize((Flow) null, (KSerializer) null, (Charset) null, (ByteWriteChannel) null, (Continuation) this);
        return serialize;
    }
}