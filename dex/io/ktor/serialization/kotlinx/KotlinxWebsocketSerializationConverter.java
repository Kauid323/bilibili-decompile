package io.ktor.serialization.kotlinx;

import faceverify.q;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.serialization.WebsocketContentConverter;
import io.ktor.serialization.WebsocketConverterNotFoundException;
import io.ktor.serialization.WebsocketDeserializeException;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.websocket.Frame;
import io.ktor.websocket.FrameCommonKt;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.BinaryFormat;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialFormat;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.StringFormat;

/* compiled from: KotlinxWebsocketSerializationConverter.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J.\u0010\u000e\u001a\u00020\r2\n\u0010\b\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0096@¢\u0006\u0004\b\u000e\u0010\u000fJ.\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\n\u0010\b\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\rH\u0096@¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J-\u0010\u0019\u001a\u00020\r2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00172\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001b¨\u0006\u001c"}, d2 = {"Lio/ktor/serialization/kotlinx/KotlinxWebsocketSerializationConverter;", "Lio/ktor/serialization/WebsocketContentConverter;", "Lkotlinx/serialization/SerialFormat;", "format", "<init>", "(Lkotlinx/serialization/SerialFormat;)V", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", HttpAuthHeader.Parameters.Charset, "Lio/ktor/util/reflect/TypeInfo;", "typeInfo", "", "value", "Lio/ktor/websocket/Frame;", "serialize", "(Ljava/nio/charset/Charset;Lio/ktor/util/reflect/TypeInfo;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", q.KEY_RES_9_CONTENT, "deserialize", "(Ljava/nio/charset/Charset;Lio/ktor/util/reflect/TypeInfo;Lio/ktor/websocket/Frame;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "frame", "", "isApplicable", "(Lio/ktor/websocket/Frame;)Z", "Lkotlinx/serialization/KSerializer;", "serializer", "serializeContent", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/SerialFormat;Ljava/lang/Object;)Lio/ktor/websocket/Frame;", "Lkotlinx/serialization/SerialFormat;", "ktor-serialization-kotlinx"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class KotlinxWebsocketSerializationConverter implements WebsocketContentConverter {
    private final SerialFormat format;

    public KotlinxWebsocketSerializationConverter(SerialFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        this.format = format;
        if ((this.format instanceof BinaryFormat) || (this.format instanceof StringFormat)) {
            return;
        }
        throw new IllegalArgumentException(("Only binary and string formats are supported, " + this.format + " is not supported.").toString());
    }

    @Override // io.ktor.serialization.WebsocketContentConverter
    public Object serialize(Charset charset, TypeInfo typeInfo, Object value, Continuation<? super Frame> continuation) {
        KSerializer serializer;
        try {
            serializer = SerializerLookupKt.serializerForTypeInfo(this.format.getSerializersModule(), typeInfo);
        } catch (SerializationException e2) {
            serializer = SerializerLookupKt.guessSerializer(value, this.format.getSerializersModule());
        }
        return serializeContent(serializer, this.format, value);
    }

    @Override // io.ktor.serialization.WebsocketContentConverter
    public Object deserialize(Charset charset, TypeInfo typeInfo, Frame content, Continuation<Object> continuation) {
        if (!isApplicable(content)) {
            throw new WebsocketConverterNotFoundException("Unsupported frame " + content.getFrameType().name(), null, 2, null);
        }
        DeserializationStrategy serializerForTypeInfo = SerializerLookupKt.serializerForTypeInfo(this.format.getSerializersModule(), typeInfo);
        SerialFormat serialFormat = this.format;
        if (serialFormat instanceof StringFormat) {
            if (content instanceof Frame.Text) {
                return this.format.decodeFromString(serializerForTypeInfo, FrameCommonKt.readText((Frame.Text) content));
            }
            throw new WebsocketDeserializeException("Unsupported format " + this.format + " for " + content.getFrameType().name(), null, content, 2, null);
        } else if (serialFormat instanceof BinaryFormat) {
            if (content instanceof Frame.Binary) {
                return this.format.decodeFromByteArray(serializerForTypeInfo, FrameCommonKt.readBytes(content));
            }
            throw new WebsocketDeserializeException("Unsupported format " + this.format + " for " + content.getFrameType().name(), null, content, 2, null);
        } else {
            throw new IllegalStateException(("Unsupported format " + this.format).toString());
        }
    }

    @Override // io.ktor.serialization.WebsocketContentConverter
    public boolean isApplicable(Frame frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        return (frame instanceof Frame.Text) || (frame instanceof Frame.Binary);
    }

    private final Frame serializeContent(KSerializer<?> kSerializer, SerialFormat format, Object value) {
        if (format instanceof StringFormat) {
            Intrinsics.checkNotNull(kSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any?>");
            String content = ((StringFormat) format).encodeToString((SerializationStrategy) kSerializer, value);
            return new Frame.Text(content);
        } else if (format instanceof BinaryFormat) {
            Intrinsics.checkNotNull(kSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any?>");
            byte[] content2 = ((BinaryFormat) format).encodeToByteArray((SerializationStrategy) kSerializer, value);
            return new Frame.Binary(true, content2);
        } else {
            throw new IllegalStateException(("Unsupported format " + format).toString());
        }
    }
}