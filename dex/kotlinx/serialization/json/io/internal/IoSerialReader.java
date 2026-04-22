package kotlinx.serialization.json.io.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Source;
import kotlinx.io.Utf8Kt;
import kotlinx.serialization.json.internal.InternalJsonReaderCodePointImpl;

/* compiled from: IoJsonStreams.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkotlinx/serialization/json/io/internal/IoSerialReader;", "Lkotlinx/serialization/json/internal/InternalJsonReaderCodePointImpl;", "source", "Lkotlinx/io/Source;", "<init>", "(Lkotlinx/io/Source;)V", "exhausted", "", "nextCodePoint", "", "kotlinx-serialization-json-io"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IoSerialReader extends InternalJsonReaderCodePointImpl {
    private final Source source;

    public IoSerialReader(Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
    }

    public boolean exhausted() {
        return this.source.exhausted();
    }

    public int nextCodePoint() {
        return Utf8Kt.readCodePointValue(this.source);
    }
}