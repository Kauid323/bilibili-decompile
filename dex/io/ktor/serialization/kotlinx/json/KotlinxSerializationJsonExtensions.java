package io.ktor.serialization.kotlinx.json;

import faceverify.q;
import io.ktor.http.ContentType;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.http.content.ChannelWriterContent;
import io.ktor.http.content.OutgoingContent;
import io.ktor.serialization.JsonConvertException;
import io.ktor.serialization.kotlinx.KotlinxSerializationExtension;
import io.ktor.serialization.kotlinx.SerializerLookupKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.Sequence;
import kotlin.text.Charsets;
import kotlinx.coroutines.flow.Flow;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.json.Json;

/* compiled from: KotlinxSerializationJsonExtensions.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J8\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096@¢\u0006\u0004\b\u0010\u0010\u0011J.\u0010\u0014\u001a\u0004\u0018\u00010\r2\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0096@¢\u0006\u0004\b\u0014\u0010\u0015JB\u0010\u0010\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0016*\b\u0012\u0004\u0012\u00028\u00000\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00182\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010\u001b\u001a\u00020\u001aH\u0082@¢\u0006\u0004\b\u0010\u0010\u001dR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001eR$\u0010!\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020 0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lio/ktor/serialization/kotlinx/json/KotlinxSerializationJsonExtensions;", "Lio/ktor/serialization/kotlinx/KotlinxSerializationExtension;", "Lkotlinx/serialization/json/Json;", "format", "<init>", "(Lkotlinx/serialization/json/Json;)V", "Lio/ktor/http/ContentType;", "contentType", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", HttpAuthHeader.Parameters.Charset, "Lio/ktor/util/reflect/TypeInfo;", "typeInfo", "", "value", "Lio/ktor/http/content/OutgoingContent;", "serialize", "(Lio/ktor/http/ContentType;Ljava/nio/charset/Charset;Lio/ktor/util/reflect/TypeInfo;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteReadChannel;", q.KEY_RES_9_CONTENT, "deserialize", "(Ljava/nio/charset/Charset;Lio/ktor/util/reflect/TypeInfo;Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "T", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/serialization/KSerializer;", "serializer", "Lio/ktor/utils/io/ByteWriteChannel;", "channel", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/serialization/KSerializer;Ljava/nio/charset/Charset;Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/serialization/json/Json;", "", "Lio/ktor/serialization/kotlinx/json/JsonArraySymbols;", "jsonArraySymbolsMap", "Ljava/util/Map;", "ktor-serialization-kotlinx-json"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class KotlinxSerializationJsonExtensions implements KotlinxSerializationExtension {
    private final Json format;
    private final Map<Charset, JsonArraySymbols> jsonArraySymbolsMap;

    public KotlinxSerializationJsonExtensions(Json format) {
        Intrinsics.checkNotNullParameter(format, "format");
        this.format = format;
        this.jsonArraySymbolsMap = new LinkedHashMap();
    }

    @Override // io.ktor.serialization.kotlinx.KotlinxSerializationExtension
    public Object serialize(ContentType contentType, Charset charset, TypeInfo typeInfo, Object value, Continuation<? super OutgoingContent> continuation) {
        if (!Intrinsics.areEqual(charset, Charsets.UTF_8) || !Intrinsics.areEqual(typeInfo.getType(), Reflection.getOrCreateKotlinClass(Flow.class))) {
            return null;
        }
        TypeInfo elementTypeInfo = KotlinxSerializationJsonExtensionsKt.argumentTypeInfo(typeInfo);
        KSerializer serializer = SerializerLookupKt.serializerForTypeInfo(this.format.getSerializersModule(), elementTypeInfo);
        return new ChannelWriterContent(new KotlinxSerializationJsonExtensions$serialize$2(this, value, serializer, charset, null), ContentTypesKt.withCharsetIfNeeded(contentType, charset), null, null, 12, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c A[Catch: all -> 0x0031, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0031, blocks: (B:12:0x002c, B:22:0x0051), top: B:30:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
    @Override // io.ktor.serialization.kotlinx.KotlinxSerializationExtension
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object deserialize(Charset charset, TypeInfo typeInfo, ByteReadChannel content, Continuation<Object> continuation) {
        KotlinxSerializationJsonExtensions$deserialize$1 kotlinxSerializationJsonExtensions$deserialize$1;
        try {
            if (continuation instanceof KotlinxSerializationJsonExtensions$deserialize$1) {
                kotlinxSerializationJsonExtensions$deserialize$1 = (KotlinxSerializationJsonExtensions$deserialize$1) continuation;
                if ((kotlinxSerializationJsonExtensions$deserialize$1.label & Integer.MIN_VALUE) != 0) {
                    kotlinxSerializationJsonExtensions$deserialize$1.label -= Integer.MIN_VALUE;
                    Object $result = kotlinxSerializationJsonExtensions$deserialize$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (kotlinxSerializationJsonExtensions$deserialize$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            if (!Intrinsics.areEqual(charset, Charsets.UTF_8) || !Intrinsics.areEqual(typeInfo.getType(), Reflection.getOrCreateKotlinClass(Sequence.class))) {
                                return null;
                            }
                            Json json = this.format;
                            kotlinxSerializationJsonExtensions$deserialize$1.label = 1;
                            Object deserializeSequence = JsonExtensionsJvmKt.deserializeSequence(json, content, typeInfo, kotlinxSerializationJsonExtensions$deserialize$1);
                            if (deserializeSequence == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return deserializeSequence;
                        case 1:
                            ResultKt.throwOnFailure($result);
                            return $result;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            switch (kotlinxSerializationJsonExtensions$deserialize$1.label) {
            }
        } catch (Throwable cause) {
            throw new JsonConvertException("Illegal input: " + cause.getMessage(), cause);
        }
        kotlinxSerializationJsonExtensions$deserialize$1 = new KotlinxSerializationJsonExtensions$deserialize$1(this, continuation);
        Object $result2 = kotlinxSerializationJsonExtensions$deserialize$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ed A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0109 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T> Object serialize(Flow<? extends T> flow, KSerializer<T> kSerializer, Charset charset, ByteWriteChannel byteWriteChannel, Continuation<? super Unit> continuation) {
        KotlinxSerializationJsonExtensions$serialize$3 kotlinxSerializationJsonExtensions$serialize$3;
        KotlinxSerializationJsonExtensions kotlinxSerializationJsonExtensions;
        KSerializer serializer;
        ByteWriteChannel channel;
        Charset charset2;
        Flow $this$serialize;
        JsonArraySymbols jsonArraySymbols;
        Flow $this$collectIndexed$iv;
        JsonArraySymbols jsonArraySymbols2;
        byte[] endArray;
        if (continuation instanceof KotlinxSerializationJsonExtensions$serialize$3) {
            kotlinxSerializationJsonExtensions$serialize$3 = (KotlinxSerializationJsonExtensions$serialize$3) continuation;
            if ((kotlinxSerializationJsonExtensions$serialize$3.label & Integer.MIN_VALUE) != 0) {
                kotlinxSerializationJsonExtensions$serialize$3.label -= Integer.MIN_VALUE;
                Object $result = kotlinxSerializationJsonExtensions$serialize$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (kotlinxSerializationJsonExtensions$serialize$3.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        kotlinxSerializationJsonExtensions = this;
                        serializer = kSerializer;
                        channel = byteWriteChannel;
                        Map $this$getOrPut$iv = kotlinxSerializationJsonExtensions.jsonArraySymbolsMap;
                        JsonArraySymbols jsonArraySymbols3 = $this$getOrPut$iv.get(charset);
                        if (jsonArraySymbols3 == null) {
                            jsonArraySymbols3 = new JsonArraySymbols(charset);
                            $this$getOrPut$iv.put(charset, jsonArraySymbols3);
                        }
                        JsonArraySymbols jsonArraySymbols4 = jsonArraySymbols3;
                        byte[] beginArray = jsonArraySymbols4.getBeginArray();
                        kotlinxSerializationJsonExtensions$serialize$3.L$0 = kotlinxSerializationJsonExtensions;
                        kotlinxSerializationJsonExtensions$serialize$3.L$1 = flow;
                        kotlinxSerializationJsonExtensions$serialize$3.L$2 = serializer;
                        kotlinxSerializationJsonExtensions$serialize$3.L$3 = charset;
                        kotlinxSerializationJsonExtensions$serialize$3.L$4 = channel;
                        kotlinxSerializationJsonExtensions$serialize$3.L$5 = jsonArraySymbols4;
                        kotlinxSerializationJsonExtensions$serialize$3.label = 1;
                        charset2 = charset;
                        if (ByteWriteChannelOperationsKt.writeFully$default(channel, beginArray, 0, 0, kotlinxSerializationJsonExtensions$serialize$3, 6, (Object) null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $this$serialize = flow;
                        jsonArraySymbols = jsonArraySymbols4;
                        $this$collectIndexed$iv = $this$serialize;
                        kotlinxSerializationJsonExtensions$serialize$3.L$0 = channel;
                        kotlinxSerializationJsonExtensions$serialize$3.L$1 = jsonArraySymbols;
                        kotlinxSerializationJsonExtensions$serialize$3.L$2 = null;
                        kotlinxSerializationJsonExtensions$serialize$3.L$3 = null;
                        kotlinxSerializationJsonExtensions$serialize$3.L$4 = null;
                        kotlinxSerializationJsonExtensions$serialize$3.L$5 = null;
                        kotlinxSerializationJsonExtensions$serialize$3.label = 2;
                        if ($this$collectIndexed$iv.collect(new KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1(channel, jsonArraySymbols, kotlinxSerializationJsonExtensions, serializer, charset2), kotlinxSerializationJsonExtensions$serialize$3) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        jsonArraySymbols2 = jsonArraySymbols;
                        endArray = jsonArraySymbols2.getEndArray();
                        kotlinxSerializationJsonExtensions$serialize$3.L$0 = null;
                        kotlinxSerializationJsonExtensions$serialize$3.L$1 = null;
                        kotlinxSerializationJsonExtensions$serialize$3.label = 3;
                        if (ByteWriteChannelOperationsKt.writeFully$default(channel, endArray, 0, 0, kotlinxSerializationJsonExtensions$serialize$3, 6, (Object) null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        jsonArraySymbols = (JsonArraySymbols) kotlinxSerializationJsonExtensions$serialize$3.L$5;
                        $this$serialize = (Flow) kotlinxSerializationJsonExtensions$serialize$3.L$1;
                        ResultKt.throwOnFailure($result);
                        channel = (ByteWriteChannel) kotlinxSerializationJsonExtensions$serialize$3.L$4;
                        charset2 = (Charset) kotlinxSerializationJsonExtensions$serialize$3.L$3;
                        serializer = (KSerializer) kotlinxSerializationJsonExtensions$serialize$3.L$2;
                        kotlinxSerializationJsonExtensions = (KotlinxSerializationJsonExtensions) kotlinxSerializationJsonExtensions$serialize$3.L$0;
                        $this$collectIndexed$iv = $this$serialize;
                        kotlinxSerializationJsonExtensions$serialize$3.L$0 = channel;
                        kotlinxSerializationJsonExtensions$serialize$3.L$1 = jsonArraySymbols;
                        kotlinxSerializationJsonExtensions$serialize$3.L$2 = null;
                        kotlinxSerializationJsonExtensions$serialize$3.L$3 = null;
                        kotlinxSerializationJsonExtensions$serialize$3.L$4 = null;
                        kotlinxSerializationJsonExtensions$serialize$3.L$5 = null;
                        kotlinxSerializationJsonExtensions$serialize$3.label = 2;
                        if ($this$collectIndexed$iv.collect(new KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1(channel, jsonArraySymbols, kotlinxSerializationJsonExtensions, serializer, charset2), kotlinxSerializationJsonExtensions$serialize$3) != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        jsonArraySymbols2 = (JsonArraySymbols) kotlinxSerializationJsonExtensions$serialize$3.L$1;
                        channel = (ByteWriteChannel) kotlinxSerializationJsonExtensions$serialize$3.L$0;
                        endArray = jsonArraySymbols2.getEndArray();
                        kotlinxSerializationJsonExtensions$serialize$3.L$0 = null;
                        kotlinxSerializationJsonExtensions$serialize$3.L$1 = null;
                        kotlinxSerializationJsonExtensions$serialize$3.label = 3;
                        if (ByteWriteChannelOperationsKt.writeFully$default(channel, endArray, 0, 0, kotlinxSerializationJsonExtensions$serialize$3, 6, (Object) null) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    case 3:
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        kotlinxSerializationJsonExtensions$serialize$3 = new KotlinxSerializationJsonExtensions$serialize$3(this, continuation);
        Object $result2 = kotlinxSerializationJsonExtensions$serialize$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (kotlinxSerializationJsonExtensions$serialize$3.label) {
        }
    }
}