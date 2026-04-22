package kotlinx.serialization.json.io.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Sink;
import kotlinx.io.Utf8Kt;
import kotlinx.serialization.json.internal.InternalJsonWriter;
import kotlinx.serialization.json.internal.StringOpsKt;

/* compiled from: IoJsonStreams.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlinx/serialization/json/io/internal/JsonToIoStreamWriter;", "Lkotlinx/serialization/json/internal/InternalJsonWriter;", "sink", "Lkotlinx/io/Sink;", "<init>", "(Lkotlinx/io/Sink;)V", "writeLong", "", "value", "", "writeChar", "char", "", "write", "text", "", "writeQuoted", "release", "kotlinx-serialization-json-io"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class JsonToIoStreamWriter implements InternalJsonWriter {
    private final Sink sink;

    public JsonToIoStreamWriter(Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.sink = sink;
    }

    public void writeLong(long value) {
        write(String.valueOf(value));
    }

    public void writeChar(char c) {
        Utf8Kt.writeCodePointValue(this.sink, c);
    }

    public void write(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        Utf8Kt.writeString$default(this.sink, text, 0, 0, 6, (Object) null);
    }

    public void writeQuoted(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        Utf8Kt.writeCodePointValue(this.sink, 34);
        InternalJsonWriter.Companion companion = InternalJsonWriter.Companion;
        int lastPos$iv = 0;
        int length = text.length();
        for (int i$iv = 0; i$iv < length; i$iv++) {
            int c$iv = text.charAt(i$iv);
            if (c$iv < StringOpsKt.getESCAPE_STRINGS().length && StringOpsKt.getESCAPE_STRINGS()[c$iv] != null) {
                int end = i$iv;
                int start = lastPos$iv;
                Utf8Kt.writeString(this.sink, text, start, end);
                String escape$iv = StringOpsKt.getESCAPE_STRINGS()[c$iv];
                Intrinsics.checkNotNull(escape$iv);
                int end2 = escape$iv.length();
                Utf8Kt.writeString(this.sink, escape$iv, 0, end2);
                lastPos$iv = i$iv + 1;
            }
        }
        int end3 = text.length();
        int start2 = lastPos$iv;
        Utf8Kt.writeString(this.sink, text, start2, end3);
        Utf8Kt.writeCodePointValue(this.sink, 34);
    }

    public void release() {
    }
}