package kotlinx.serialization.json.internal;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.reflect.KType;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.DecodeSequenceMode;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonEncoder;
import kotlinx.serialization.modules.SerializersModule;

/* compiled from: JsonStreams.kt */
@Metadata(d1 = {"\u00008\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a-\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001a8\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00010\t\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0001\u001a-\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00010\t\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0081\b\u001a5\u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00112\u0006\u0010\u0012\u001a\u0002H\u0001H\u0001¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"decodeByReader", "T", "Lkotlinx/serialization/json/Json;", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "reader", "Lkotlinx/serialization/json/internal/SerialReader;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/DeserializationStrategy;Lkotlinx/serialization/json/internal/SerialReader;)Ljava/lang/Object;", "decodeToSequenceByReader", "Lkotlin/sequences/Sequence;", "format", "Lkotlinx/serialization/json/DecodeSequenceMode;", "encodeByWriter", "", "writer", "Lkotlinx/serialization/json/internal/JsonWriter;", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "value", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/JsonWriter;Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "kotlinx-serialization-json"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class JsonStreamsKt {
    public static final <T> void encodeByWriter(Json $this$encodeByWriter, JsonWriter writer, SerializationStrategy<? super T> serializer, T t) {
        Intrinsics.checkNotNullParameter($this$encodeByWriter, "<this>");
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        StreamingJsonEncoder encoder = new StreamingJsonEncoder(writer, $this$encodeByWriter, WriteMode.OBJ, new JsonEncoder[WriteMode.values().length]);
        encoder.encodeSerializableValue(serializer, t);
    }

    public static final <T> T decodeByReader(Json $this$decodeByReader, DeserializationStrategy<? extends T> deserializer, SerialReader reader) {
        Intrinsics.checkNotNullParameter($this$decodeByReader, "<this>");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        Intrinsics.checkNotNullParameter(reader, "reader");
        ReaderJsonLexer lexer = new ReaderJsonLexer(reader, null, 2, null);
        try {
            StreamingJsonDecoder input = new StreamingJsonDecoder($this$decodeByReader, WriteMode.OBJ, lexer, deserializer.getDescriptor(), null);
            T t = (T) input.decodeSerializableValue(deserializer);
            lexer.expectEof();
            return t;
        } finally {
            lexer.release();
        }
    }

    public static /* synthetic */ Sequence decodeToSequenceByReader$default(Json json, SerialReader serialReader, DeserializationStrategy deserializationStrategy, DecodeSequenceMode decodeSequenceMode, int i, Object obj) {
        if ((i & 4) != 0) {
            decodeSequenceMode = DecodeSequenceMode.AUTO_DETECT;
        }
        return decodeToSequenceByReader(json, serialReader, deserializationStrategy, decodeSequenceMode);
    }

    @ExperimentalSerializationApi
    public static final <T> Sequence<T> decodeToSequenceByReader(Json $this$decodeToSequenceByReader, SerialReader reader, DeserializationStrategy<? extends T> deserializer, DecodeSequenceMode format) {
        Intrinsics.checkNotNullParameter($this$decodeToSequenceByReader, "<this>");
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        Intrinsics.checkNotNullParameter(format, "format");
        ReaderJsonLexer lexer = new ReaderJsonLexer(reader, new char[16384]);
        final Iterator iter = JsonIteratorKt.JsonIterator(format, $this$decodeToSequenceByReader, lexer, deserializer);
        return SequencesKt.constrainOnce(new Sequence<T>() { // from class: kotlinx.serialization.json.internal.JsonStreamsKt$decodeToSequenceByReader$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public Iterator<T> iterator() {
                return iter;
            }
        });
    }

    public static /* synthetic */ Sequence decodeToSequenceByReader$default(Json $this$decodeToSequenceByReader_u24default, SerialReader reader, DecodeSequenceMode format, int i, Object obj) {
        if ((i & 2) != 0) {
            format = DecodeSequenceMode.AUTO_DETECT;
        }
        Intrinsics.checkNotNullParameter($this$decodeToSequenceByReader_u24default, "<this>");
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(format, "format");
        SerializersModule serializersModule = $this$decodeToSequenceByReader_u24default.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return decodeToSequenceByReader($this$decodeToSequenceByReader_u24default, reader, SerializersKt.serializer(serializersModule, (KType) null), format);
    }

    @ExperimentalSerializationApi
    public static final /* synthetic */ <T> Sequence<T> decodeToSequenceByReader(Json $this$decodeToSequenceByReader, SerialReader reader, DecodeSequenceMode format) {
        Intrinsics.checkNotNullParameter($this$decodeToSequenceByReader, "<this>");
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(format, "format");
        SerializersModule serializersModule = $this$decodeToSequenceByReader.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return decodeToSequenceByReader($this$decodeToSequenceByReader, reader, SerializersKt.serializer(serializersModule, (KType) null), format);
    }
}