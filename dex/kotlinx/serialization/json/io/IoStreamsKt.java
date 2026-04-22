package kotlinx.serialization.json.io;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.reflect.KType;
import kotlin.sequences.Sequence;
import kotlinx.io.Sink;
import kotlinx.io.Source;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.DecodeSequenceMode;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.internal.JsonStreamsKt;
import kotlinx.serialization.json.io.internal.IoSerialReader;
import kotlinx.serialization.json.io.internal.JsonToIoStreamWriter;
import kotlinx.serialization.modules.SerializersModule;

/* compiled from: IoStreams.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a5\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\t\u001a*\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0006\u001a\u0002H\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0087\b¢\u0006\u0002\u0010\n\u001a-\u0010\u000b\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001a\"\u0010\u000b\u001a\u0002H\u0002\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0087\b¢\u0006\u0002\u0010\u0011\u001a8\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0013\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007\u001a-\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0013\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0087\b¨\u0006\u0016"}, d2 = {"encodeToSink", "", "T", "Lkotlinx/serialization/json/Json;", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "value", "sink", "Lkotlinx/io/Sink;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;Lkotlinx/io/Sink;)V", "(Lkotlinx/serialization/json/Json;Ljava/lang/Object;Lkotlinx/io/Sink;)V", "decodeFromSource", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "source", "Lkotlinx/io/Source;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/DeserializationStrategy;Lkotlinx/io/Source;)Ljava/lang/Object;", "(Lkotlinx/serialization/json/Json;Lkotlinx/io/Source;)Ljava/lang/Object;", "decodeSourceToSequence", "Lkotlin/sequences/Sequence;", "format", "Lkotlinx/serialization/json/DecodeSequenceMode;", "kotlinx-serialization-json-io"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class IoStreamsKt {
    @ExperimentalSerializationApi
    public static final <T> void encodeToSink(Json $this$encodeToSink, SerializationStrategy<? super T> serializer, T t, Sink sink) {
        Intrinsics.checkNotNullParameter($this$encodeToSink, "<this>");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(sink, "sink");
        JsonToIoStreamWriter writer = new JsonToIoStreamWriter(sink);
        try {
            JsonStreamsKt.encodeByWriter($this$encodeToSink, writer, serializer, t);
        } finally {
            writer.release();
        }
    }

    @ExperimentalSerializationApi
    public static final /* synthetic */ <T> void encodeToSink(Json $this$encodeToSink, T t, Sink sink) {
        Intrinsics.checkNotNullParameter($this$encodeToSink, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        SerializersModule serializersModule = $this$encodeToSink.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        encodeToSink($this$encodeToSink, SerializersKt.serializer(serializersModule, (KType) null), t, sink);
    }

    @ExperimentalSerializationApi
    public static final <T> T decodeFromSource(Json $this$decodeFromSource, DeserializationStrategy<? extends T> deserializer, Source source) {
        Intrinsics.checkNotNullParameter($this$decodeFromSource, "<this>");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        Intrinsics.checkNotNullParameter(source, "source");
        return (T) JsonStreamsKt.decodeByReader($this$decodeFromSource, deserializer, new IoSerialReader(source));
    }

    @ExperimentalSerializationApi
    public static final /* synthetic */ <T> T decodeFromSource(Json $this$decodeFromSource, Source source) {
        Intrinsics.checkNotNullParameter($this$decodeFromSource, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        SerializersModule serializersModule = $this$decodeFromSource.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return (T) decodeFromSource($this$decodeFromSource, SerializersKt.serializer(serializersModule, (KType) null), source);
    }

    public static /* synthetic */ Sequence decodeSourceToSequence$default(Json json, Source source, DeserializationStrategy deserializationStrategy, DecodeSequenceMode decodeSequenceMode, int i, Object obj) {
        if ((i & 4) != 0) {
            decodeSequenceMode = DecodeSequenceMode.AUTO_DETECT;
        }
        return decodeSourceToSequence(json, source, deserializationStrategy, decodeSequenceMode);
    }

    @ExperimentalSerializationApi
    public static final <T> Sequence<T> decodeSourceToSequence(Json $this$decodeSourceToSequence, Source source, DeserializationStrategy<? extends T> deserializer, DecodeSequenceMode format) {
        Intrinsics.checkNotNullParameter($this$decodeSourceToSequence, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        Intrinsics.checkNotNullParameter(format, "format");
        return JsonStreamsKt.decodeToSequenceByReader($this$decodeSourceToSequence, new IoSerialReader(source), deserializer, format);
    }

    public static /* synthetic */ Sequence decodeSourceToSequence$default(Json $this$decodeSourceToSequence_u24default, Source source, DecodeSequenceMode format, int i, Object obj) {
        if ((i & 2) != 0) {
            format = DecodeSequenceMode.AUTO_DETECT;
        }
        Intrinsics.checkNotNullParameter($this$decodeSourceToSequence_u24default, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(format, "format");
        SerializersModule serializersModule = $this$decodeSourceToSequence_u24default.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return decodeSourceToSequence($this$decodeSourceToSequence_u24default, source, SerializersKt.serializer(serializersModule, (KType) null), format);
    }

    @ExperimentalSerializationApi
    public static final /* synthetic */ <T> Sequence<T> decodeSourceToSequence(Json $this$decodeSourceToSequence, Source source, DecodeSequenceMode format) {
        Intrinsics.checkNotNullParameter($this$decodeSourceToSequence, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(format, "format");
        SerializersModule serializersModule = $this$decodeSourceToSequence.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return decodeSourceToSequence($this$decodeSourceToSequence, source, SerializersKt.serializer(serializersModule, (KType) null), format);
    }
}