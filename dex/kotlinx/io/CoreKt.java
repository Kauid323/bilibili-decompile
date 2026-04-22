package kotlinx.io;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Core.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0000\u001a\u00020\u0003*\u00020\u0004\u001a\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"buffered", "Lkotlinx/io/Source;", "Lkotlinx/io/RawSource;", "Lkotlinx/io/Sink;", "Lkotlinx/io/RawSink;", "discardingSink", "kotlinx-io-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CoreKt {
    public static final Source buffered(RawSource $this$buffered) {
        Intrinsics.checkNotNullParameter($this$buffered, "<this>");
        return new RealSource($this$buffered);
    }

    public static final Sink buffered(RawSink $this$buffered) {
        Intrinsics.checkNotNullParameter($this$buffered, "<this>");
        return new RealSink($this$buffered);
    }

    public static final RawSink discardingSink() {
        return new DiscardingSink();
    }
}