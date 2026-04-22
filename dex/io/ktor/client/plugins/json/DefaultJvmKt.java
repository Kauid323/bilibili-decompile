package io.ktor.client.plugins.json;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* compiled from: DefaultJvm.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\" \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00000\u00038\u0002X\u0082\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u0012\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/client/plugins/json/JsonSerializer;", "defaultSerializer", "()Lio/ktor/client/plugins/json/JsonSerializer;", "", "serializers", "Ljava/util/List;", "getSerializers$annotations", "()V", "ktor-client-json"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DefaultJvmKt {
    private static final List<JsonSerializer> serializers;

    private static /* synthetic */ void getSerializers$annotations() {
    }

    public static final JsonSerializer defaultSerializer() {
        Object maxElem$iv;
        Iterable $this$maxByOrNull$iv = serializers;
        Iterator iterator$iv = $this$maxByOrNull$iv.iterator();
        if (iterator$iv.hasNext()) {
            maxElem$iv = iterator$iv.next();
            if (iterator$iv.hasNext()) {
                JsonSerializer jsonSerializer = (JsonSerializer) maxElem$iv;
                do {
                    Object e$iv = iterator$iv.next();
                    JsonSerializer jsonSerializer2 = (JsonSerializer) e$iv;
                    if (maxValue$iv.compareTo(r7) < 0) {
                        maxElem$iv = e$iv;
                        maxValue$iv = r7;
                    }
                } while (iterator$iv.hasNext());
            }
        } else {
            maxElem$iv = null;
        }
        JsonSerializer jsonSerializer3 = (JsonSerializer) maxElem$iv;
        if (jsonSerializer3 == null) {
            throw new IllegalStateException("Failed to find serializer. Consider adding one of the following dependencies: \n - ktor-client-gson\n - ktor-client-json\n - ktor-client-serialization".toString());
        }
        return jsonSerializer3;
    }

    static {
        Iterator it = ServiceLoader.load(JsonSerializer.class, JsonSerializer.class.getClassLoader()).iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        serializers = SequencesKt.toList(SequencesKt.asSequence(it));
    }
}