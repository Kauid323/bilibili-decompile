package io.ktor.serialization.kotlinx.json;

import io.ktor.serialization.kotlinx.SerializerLookupKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.jvm.javaio.BlockingKt;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.serialization.json.DecodeSequenceMode;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JvmStreamsKt;

/* compiled from: JsonExtensionsJvm.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/sequences/Sequence;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.serialization.kotlinx.json.JsonExtensionsJvmKt$deserializeSequence$2", f = "JsonExtensionsJvm.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class JsonExtensionsJvmKt$deserializeSequence$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Sequence<? extends Object>>, Object> {
    final /* synthetic */ ByteReadChannel $content;
    final /* synthetic */ Json $format;
    final /* synthetic */ TypeInfo $typeInfo;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonExtensionsJvmKt$deserializeSequence$2(ByteReadChannel byteReadChannel, TypeInfo typeInfo, Json json, Continuation<? super JsonExtensionsJvmKt$deserializeSequence$2> continuation) {
        super(2, continuation);
        this.$content = byteReadChannel;
        this.$typeInfo = typeInfo;
        this.$format = json;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new JsonExtensionsJvmKt$deserializeSequence$2(this.$content, this.$typeInfo, this.$format, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Sequence<? extends Object>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                InputStream inputStream = BlockingKt.toInputStream$default(this.$content, (Job) null, 1, (Object) null);
                TypeInfo elementTypeInfo = KotlinxSerializationJsonExtensionsKt.argumentTypeInfo(this.$typeInfo);
                return JvmStreamsKt.decodeToSequence$default(this.$format, inputStream, SerializerLookupKt.serializerForTypeInfo(this.$format.getSerializersModule(), elementTypeInfo), (DecodeSequenceMode) null, 4, (Object) null);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}