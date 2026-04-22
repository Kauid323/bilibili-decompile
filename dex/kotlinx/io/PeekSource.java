package kotlinx.io;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PeekSource.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lkotlinx/io/PeekSource;", "Lkotlinx/io/RawSource;", "upstream", "Lkotlinx/io/Source;", "<init>", "(Lkotlinx/io/Source;)V", "buffer", "Lkotlinx/io/Buffer;", "getBuffer$annotations", "()V", "expectedSegment", "Lkotlinx/io/Segment;", "expectedPos", "", "closed", "", "pos", "", "readAtMostTo", "sink", "byteCount", "close", "", "kotlinx-io-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PeekSource implements RawSource {
    private final Buffer buffer;
    private boolean closed;
    private int expectedPos;
    private Segment expectedSegment;
    private long pos;
    private final Source upstream;

    private static /* synthetic */ void getBuffer$annotations() {
    }

    public PeekSource(Source upstream) {
        Intrinsics.checkNotNullParameter(upstream, "upstream");
        this.upstream = upstream;
        this.buffer = this.upstream.getBuffer();
        this.expectedSegment = this.buffer.getHead();
        Segment head = this.buffer.getHead();
        this.expectedPos = head != null ? head.getPos() : -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0036, code lost:
        if (r0 == r3.getPos()) goto L14;
     */
    @Override // kotlinx.io.RawSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long readAtMostTo(Buffer sink, long byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (this.closed) {
            throw new IllegalStateException("Source is closed.".toString());
        }
        boolean z = true;
        if (byteCount >= 0) {
            if (this.expectedSegment != null) {
                if (this.expectedSegment == this.buffer.getHead()) {
                    int i = this.expectedPos;
                    Segment head = this.buffer.getHead();
                    Intrinsics.checkNotNull(head);
                }
                z = false;
            }
            if (!z) {
                throw new IllegalStateException("Peek source is invalid because upstream source was used".toString());
            }
            if (byteCount != 0) {
                if (this.upstream.request(this.pos + 1)) {
                    if (this.expectedSegment == null && this.buffer.getHead() != null) {
                        this.expectedSegment = this.buffer.getHead();
                        Segment head2 = this.buffer.getHead();
                        Intrinsics.checkNotNull(head2);
                        this.expectedPos = head2.getPos();
                    }
                    long toCopy = Math.min(byteCount, this.buffer.getSize() - this.pos);
                    this.buffer.copyTo(sink, this.pos, this.pos + toCopy);
                    this.pos += toCopy;
                    return toCopy;
                }
                return -1L;
            }
            return 0L;
        }
        throw new IllegalArgumentException(("byteCount (" + byteCount + ") < 0").toString());
    }

    @Override // kotlinx.io.RawSource, java.lang.AutoCloseable, kotlinx.io.RawSink
    public void close() {
        this.closed = true;
    }
}