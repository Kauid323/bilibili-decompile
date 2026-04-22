package io.ktor.serialization.kotlinx.json;

import faceverify.q;
import io.ktor.http.ContentType;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.http.content.ChannelWriterContent;
import io.ktor.http.content.OutgoingContent;
import io.ktor.serialization.ContentConverter;
import io.ktor.serialization.JsonConvertException;
import io.ktor.serialization.kotlinx.SerializerLookupKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.core.ByteReadPacketKt;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Buffer;
import kotlinx.io.Sink;
import kotlinx.io.Source;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.io.IoStreamsKt;

/* compiled from: ExperimentalJsonConverter.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J6\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096@¢\u0006\u0004\b\u0010\u0010\u0011J.\u0010\u0014\u001a\u0004\u0018\u00010\r2\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0096@¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016¨\u0006\u0017"}, d2 = {"Lio/ktor/serialization/kotlinx/json/ExperimentalJsonConverter;", "Lio/ktor/serialization/ContentConverter;", "Lkotlinx/serialization/json/Json;", "format", "<init>", "(Lkotlinx/serialization/json/Json;)V", "Lio/ktor/http/ContentType;", "contentType", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", HttpAuthHeader.Parameters.Charset, "Lio/ktor/util/reflect/TypeInfo;", "typeInfo", "", "value", "Lio/ktor/http/content/OutgoingContent;", "serialize", "(Lio/ktor/http/ContentType;Ljava/nio/charset/Charset;Lio/ktor/util/reflect/TypeInfo;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteReadChannel;", q.KEY_RES_9_CONTENT, "deserialize", "(Ljava/nio/charset/Charset;Lio/ktor/util/reflect/TypeInfo;Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/serialization/json/Json;", "ktor-serialization-kotlinx-json"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExperimentalJsonConverter implements ContentConverter {
    private final Json format;

    public ExperimentalJsonConverter(Json format) {
        Intrinsics.checkNotNullParameter(format, "format");
        this.format = format;
    }

    @Override // io.ktor.serialization.ContentConverter
    public Object serialize(ContentType contentType, Charset charset, TypeInfo typeInfo, Object value, Continuation<? super OutgoingContent> continuation) {
        SerializationStrategy guessSerializer;
        try {
            guessSerializer = SerializerLookupKt.serializerForTypeInfo(this.format.getSerializersModule(), typeInfo);
        } catch (SerializationException e2) {
            guessSerializer = SerializerLookupKt.guessSerializer(value, this.format.getSerializersModule());
        }
        Source buffer = new Buffer();
        Json json = this.format;
        Intrinsics.checkNotNull(guessSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any?>");
        IoStreamsKt.encodeToSink(json, guessSerializer, value, (Sink) buffer);
        return new ChannelWriterContent(new ExperimentalJsonConverter$serialize$2(buffer, null), contentType, null, Boxing.boxLong(ByteReadPacketKt.getRemaining(buffer)), 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    @Override // io.ktor.serialization.ContentConverter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object deserialize(Charset charset, TypeInfo typeInfo, ByteReadChannel content, Continuation<Object> continuation) {
        ExperimentalJsonConverter$deserialize$1 experimentalJsonConverter$deserialize$1;
        ExperimentalJsonConverter experimentalJsonConverter;
        DeserializationStrategy serializerForTypeInfo;
        Object readRemaining;
        try {
            if (continuation instanceof ExperimentalJsonConverter$deserialize$1) {
                experimentalJsonConverter$deserialize$1 = (ExperimentalJsonConverter$deserialize$1) continuation;
                if ((experimentalJsonConverter$deserialize$1.label & Integer.MIN_VALUE) != 0) {
                    experimentalJsonConverter$deserialize$1.label -= Integer.MIN_VALUE;
                    Object $result = experimentalJsonConverter$deserialize$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (experimentalJsonConverter$deserialize$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            experimentalJsonConverter = this;
                            serializerForTypeInfo = SerializerLookupKt.serializerForTypeInfo(experimentalJsonConverter.format.getSerializersModule(), typeInfo);
                            experimentalJsonConverter$deserialize$1.L$0 = experimentalJsonConverter;
                            experimentalJsonConverter$deserialize$1.L$1 = serializerForTypeInfo;
                            experimentalJsonConverter$deserialize$1.label = 1;
                            readRemaining = ByteReadChannelOperationsKt.readRemaining(content, experimentalJsonConverter$deserialize$1);
                            if (readRemaining == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            break;
                        case 1:
                            serializerForTypeInfo = (KSerializer) experimentalJsonConverter$deserialize$1.L$1;
                            ResultKt.throwOnFailure($result);
                            experimentalJsonConverter = (ExperimentalJsonConverter) experimentalJsonConverter$deserialize$1.L$0;
                            readRemaining = $result;
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Source contentPacket = (Source) readRemaining;
                    return IoStreamsKt.decodeFromSource(experimentalJsonConverter.format, serializerForTypeInfo, contentPacket);
                }
            }
            return IoStreamsKt.decodeFromSource(experimentalJsonConverter.format, serializerForTypeInfo, contentPacket);
        } catch (Throwable cause) {
            throw new JsonConvertException("Illegal input: " + cause.getMessage(), cause);
        }
        experimentalJsonConverter$deserialize$1 = new ExperimentalJsonConverter$deserialize$1(this, continuation);
        Object $result2 = experimentalJsonConverter$deserialize$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (experimentalJsonConverter$deserialize$1.label) {
        }
        Source contentPacket2 = (Source) readRemaining;
    }
}