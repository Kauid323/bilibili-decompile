package kotlinx.io;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Segment.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b(\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b*\u0018\u0000 k2\u00020\u0001:\u0001kB\t\b\u0012¢\u0006\u0004\b\u0002\u0010\u0003B3\b\u0012\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0002\u0010\rJ\r\u0010(\u001a\u00020\u0000H\u0000¢\u0006\u0002\b)J\u000f\u0010*\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0002\b+J\u0015\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u0000H\u0000¢\u0006\u0002\b.J\u0015\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u0007H\u0000¢\u0006\u0002\b1J\r\u00102\u001a\u00020\u0000H\u0000¢\u0006\u0002\b3J\u0015\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0000¢\u0006\u0002\b8J\u0015\u00109\u001a\u0002052\u0006\u0010:\u001a\u00020;H\u0000¢\u0006\u0002\b<J\u0015\u0010=\u001a\u0002052\u0006\u0010>\u001a\u00020\u0007H\u0000¢\u0006\u0002\b?J\u0015\u0010@\u001a\u0002052\u0006\u0010A\u001a\u00020BH\u0000¢\u0006\u0002\bCJ\r\u0010D\u001a\u000207H\u0000¢\u0006\u0002\bEJ\r\u0010F\u001a\u00020;H\u0000¢\u0006\u0002\bGJ\r\u0010H\u001a\u00020\u0007H\u0000¢\u0006\u0002\bIJ\r\u0010J\u001a\u00020BH\u0000¢\u0006\u0002\bKJ\u001d\u0010L\u001a\u0002052\u0006\u0010M\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u0007H\u0000¢\u0006\u0002\bNJ%\u0010O\u001a\u0002052\u0006\u0010P\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u00072\u0006\u0010R\u001a\u00020\u0007H\u0000¢\u0006\u0002\bSJ%\u0010T\u001a\u0002052\u0006\u0010U\u001a\u00020\u00052\u0006\u0010V\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\u0007H\u0000¢\u0006\u0002\bXJ\u0010\u0010]\u001a\u00020\u00052\u0006\u0010^\u001a\u00020\fH\u0001J\u0018\u0010_\u001a\u0002052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010`\u001a\u00020\u0007H\u0001J\u0015\u0010a\u001a\u0002072\u0006\u0010b\u001a\u00020\u0007H\u0000¢\u0006\u0002\bcJ\u001d\u0010d\u001a\u0002052\u0006\u0010b\u001a\u00020\u00072\u0006\u0010e\u001a\u000207H\u0000¢\u0006\u0002\bfJ%\u0010d\u001a\u0002052\u0006\u0010b\u001a\u00020\u00072\u0006\u0010g\u001a\u0002072\u0006\u0010h\u001a\u000207H\u0000¢\u0006\u0002\bfJ-\u0010d\u001a\u0002052\u0006\u0010b\u001a\u00020\u00072\u0006\u0010g\u001a\u0002072\u0006\u0010h\u001a\u0002072\u0006\u0010i\u001a\u000207H\u0000¢\u0006\u0002\bfJ5\u0010d\u001a\u0002052\u0006\u0010b\u001a\u00020\u00072\u0006\u0010g\u001a\u0002072\u0006\u0010h\u001a\u0002072\u0006\u0010i\u001a\u0002072\u0006\u0010j\u001a\u000207H\u0000¢\u0006\u0002\bfR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0006\u001a\u00020\u00078\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\b\u001a\u00020\u00078\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0012\u0010\u000b\u001a\u00020\f8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R&\u0010\u001e\u001a\u0004\u0018\u00010\u00008\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001f\u0010\u0003\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R&\u0010$\u001a\u0004\u0018\u00010\u00008\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b%\u0010\u0003\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#R\u0011\u0010Y\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bZ\u0010\u0010R\u0011\u0010[\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\\\u0010\u0010¨\u0006l"}, d2 = {"Lkotlinx/io/Segment;", "", "<init>", "()V", "data", "", "pos", "", "limit", "shareToken", "Lkotlinx/io/SegmentCopyTracker;", "owner", "", "([BIILkotlinx/io/SegmentCopyTracker;Z)V", "getPos$annotations", "getPos", "()I", "setPos", "(I)V", "getLimit$annotations", "getLimit", "setLimit", "shared", "getShared$kotlinx_io_core", "()Z", "copyTracker", "getCopyTracker$kotlinx_io_core", "()Lkotlinx/io/SegmentCopyTracker;", "setCopyTracker$kotlinx_io_core", "(Lkotlinx/io/SegmentCopyTracker;)V", "next", "getNext$annotations", "getNext", "()Lkotlinx/io/Segment;", "setNext", "(Lkotlinx/io/Segment;)V", "prev", "getPrev$annotations", "getPrev", "setPrev", "sharedCopy", "sharedCopy$kotlinx_io_core", "pop", "pop$kotlinx_io_core", "push", "segment", "push$kotlinx_io_core", "split", "byteCount", "split$kotlinx_io_core", "compact", "compact$kotlinx_io_core", "writeByte", "", "byte", "", "writeByte$kotlinx_io_core", "writeShort", "short", "", "writeShort$kotlinx_io_core", "writeInt", "int", "writeInt$kotlinx_io_core", "writeLong", "long", "", "writeLong$kotlinx_io_core", "readByte", "readByte$kotlinx_io_core", "readShort", "readShort$kotlinx_io_core", "readInt", "readInt$kotlinx_io_core", "readLong", "readLong$kotlinx_io_core", "writeTo", "sink", "writeTo$kotlinx_io_core", "readTo", "dst", "dstStartOffset", "dstEndOffset", "readTo$kotlinx_io_core", "write", "src", "srcStartOffset", "srcEndOffset", "write$kotlinx_io_core", "size", "getSize", "remainingCapacity", "getRemainingCapacity", "dataAsByteArray", "readOnly", "writeBackData", "bytesToCommit", "getUnchecked", "index", "getUnchecked$kotlinx_io_core", "setUnchecked", "value", "setUnchecked$kotlinx_io_core", "b0", "b1", "b2", "b3", "Companion", "kotlinx-io-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Segment {
    public static final Companion Companion = new Companion(null);
    public static final int SHARE_MINIMUM = 1024;
    public static final int SIZE = 8192;
    private SegmentCopyTracker copyTracker;
    private final byte[] data;
    private int limit;
    private Segment next;
    public boolean owner;
    private int pos;
    private Segment prev;

    public /* synthetic */ Segment(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public /* synthetic */ Segment(byte[] bArr, int i, int i2, SegmentCopyTracker segmentCopyTracker, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr, i, i2, segmentCopyTracker, z);
    }

    public static /* synthetic */ void getLimit$annotations() {
    }

    public static /* synthetic */ void getNext$annotations() {
    }

    public static /* synthetic */ void getPos$annotations() {
    }

    public static /* synthetic */ void getPrev$annotations() {
    }

    public final /* synthetic */ int getPos() {
        return this.pos;
    }

    public final /* synthetic */ void setPos(int i) {
        this.pos = i;
    }

    public final /* synthetic */ int getLimit() {
        return this.limit;
    }

    public final /* synthetic */ void setLimit(int i) {
        this.limit = i;
    }

    public final boolean getShared$kotlinx_io_core() {
        SegmentCopyTracker segmentCopyTracker = this.copyTracker;
        if (segmentCopyTracker != null) {
            return segmentCopyTracker.getShared();
        }
        return false;
    }

    public final SegmentCopyTracker getCopyTracker$kotlinx_io_core() {
        return this.copyTracker;
    }

    public final void setCopyTracker$kotlinx_io_core(SegmentCopyTracker segmentCopyTracker) {
        this.copyTracker = segmentCopyTracker;
    }

    public final /* synthetic */ Segment getNext() {
        return this.next;
    }

    public final /* synthetic */ void setNext(Segment segment) {
        this.next = segment;
    }

    public final /* synthetic */ Segment getPrev() {
        return this.prev;
    }

    public final /* synthetic */ void setPrev(Segment segment) {
        this.prev = segment;
    }

    private Segment() {
        this.data = new byte[8192];
        this.owner = true;
        this.copyTracker = null;
    }

    private Segment(byte[] data, int pos, int limit, SegmentCopyTracker shareToken, boolean owner) {
        this.data = data;
        this.pos = pos;
        this.limit = limit;
        this.copyTracker = shareToken;
        this.owner = owner;
    }

    public final Segment sharedCopy$kotlinx_io_core() {
        SegmentCopyTracker it = this.copyTracker;
        if (it == null) {
            it = SegmentPool.tracker();
            this.copyTracker = it;
        }
        SegmentCopyTracker t = it;
        byte[] bArr = this.data;
        int i = this.pos;
        int i2 = this.limit;
        t.addCopy();
        Unit unit = Unit.INSTANCE;
        return new Segment(bArr, i, i2, t, false);
    }

    public final Segment pop$kotlinx_io_core() {
        Segment result = this.next;
        if (this.prev != null) {
            Segment segment = this.prev;
            Intrinsics.checkNotNull(segment);
            segment.next = this.next;
        }
        if (this.next != null) {
            Segment segment2 = this.next;
            Intrinsics.checkNotNull(segment2);
            segment2.prev = this.prev;
        }
        this.next = null;
        this.prev = null;
        return result;
    }

    public final Segment push$kotlinx_io_core(Segment segment) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        segment.prev = this;
        segment.next = this.next;
        if (this.next != null) {
            Segment segment2 = this.next;
            Intrinsics.checkNotNull(segment2);
            segment2.prev = segment;
        }
        this.next = segment;
        return segment;
    }

    public final Segment split$kotlinx_io_core(int byteCount) {
        Segment prefix;
        if (byteCount > 0 && byteCount <= this.limit - this.pos) {
            if (byteCount >= 1024) {
                prefix = sharedCopy$kotlinx_io_core();
            } else {
                prefix = SegmentPool.take();
                ArraysKt.copyInto$default(this.data, prefix.data, 0, this.pos, this.pos + byteCount, 2, (Object) null);
            }
            prefix.limit = prefix.pos + byteCount;
            this.pos += byteCount;
            if (this.prev != null) {
                Segment segment = this.prev;
                Intrinsics.checkNotNull(segment);
                segment.push$kotlinx_io_core(prefix);
            } else {
                prefix.next = this;
                this.prev = prefix;
            }
            return prefix;
        }
        throw new IllegalArgumentException("byteCount out of range".toString());
    }

    public final Segment compact$kotlinx_io_core() {
        int i;
        if (this.prev != null) {
            Segment segment = this.prev;
            Intrinsics.checkNotNull(segment);
            if (segment.owner) {
                int byteCount = this.limit - this.pos;
                Segment segment2 = this.prev;
                Intrinsics.checkNotNull(segment2);
                int i2 = 8192 - segment2.limit;
                Segment segment3 = this.prev;
                Intrinsics.checkNotNull(segment3);
                if (segment3.getShared$kotlinx_io_core()) {
                    i = 0;
                } else {
                    Segment segment4 = this.prev;
                    Intrinsics.checkNotNull(segment4);
                    i = segment4.pos;
                }
                int availableByteCount = i2 + i;
                if (byteCount > availableByteCount) {
                    return this;
                }
                Segment predecessor = this.prev;
                Intrinsics.checkNotNull(predecessor);
                writeTo$kotlinx_io_core(predecessor, byteCount);
                Segment successor = pop$kotlinx_io_core();
                if (!(successor == null)) {
                    throw new IllegalStateException("Check failed.");
                }
                SegmentPool.recycle(this);
                return predecessor;
            }
            return this;
        }
        throw new IllegalStateException("cannot compact".toString());
    }

    public final void writeByte$kotlinx_io_core(byte b) {
        byte[] bArr = this.data;
        int i = this.limit;
        this.limit = i + 1;
        bArr[i] = b;
    }

    public final void writeShort$kotlinx_io_core(short s) {
        byte[] data = this.data;
        int limit = this.limit;
        int limit2 = limit + 1;
        data[limit] = (byte) ((s >>> 8) & 255);
        data[limit2] = (byte) (s & 255);
        this.limit = limit2 + 1;
    }

    public final void writeInt$kotlinx_io_core(int i) {
        byte[] data = this.data;
        int limit = this.limit;
        int limit2 = limit + 1;
        data[limit] = (byte) ((i >>> 24) & 255);
        int limit3 = limit2 + 1;
        data[limit2] = (byte) ((i >>> 16) & 255);
        int limit4 = limit3 + 1;
        data[limit3] = (byte) ((i >>> 8) & 255);
        data[limit4] = (byte) (i & 255);
        this.limit = limit4 + 1;
    }

    public final void writeLong$kotlinx_io_core(long j) {
        byte[] data = this.data;
        int limit = this.limit;
        int limit2 = limit + 1;
        data[limit] = (byte) ((j >>> 56) & 255);
        int limit3 = limit2 + 1;
        data[limit2] = (byte) ((j >>> 48) & 255);
        int limit4 = limit3 + 1;
        data[limit3] = (byte) ((j >>> 40) & 255);
        int limit5 = limit4 + 1;
        data[limit4] = (byte) ((j >>> 32) & 255);
        int limit6 = limit5 + 1;
        data[limit5] = (byte) ((j >>> 24) & 255);
        int limit7 = limit6 + 1;
        data[limit6] = (byte) ((j >>> 16) & 255);
        int limit8 = limit7 + 1;
        data[limit7] = (byte) ((j >>> 8) & 255);
        data[limit8] = (byte) (j & 255);
        this.limit = limit8 + 1;
    }

    public final byte readByte$kotlinx_io_core() {
        byte[] bArr = this.data;
        int i = this.pos;
        this.pos = i + 1;
        return bArr[i];
    }

    public final short readShort$kotlinx_io_core() {
        byte[] data = this.data;
        int pos = this.pos;
        int pos2 = pos + 1;
        byte $this$and$iv = data[pos];
        int pos3 = pos2 + 1;
        byte $this$and$iv2 = data[pos2];
        short s = (short) ((($this$and$iv & 255) << 8) | ($this$and$iv2 & 255));
        this.pos = pos3;
        return s;
    }

    public final int readInt$kotlinx_io_core() {
        byte[] data = this.data;
        int pos = this.pos;
        int pos2 = pos + 1;
        byte $this$and$iv = data[pos];
        int pos3 = pos2 + 1;
        byte $this$and$iv2 = data[pos2];
        int i = (($this$and$iv & 255) << 24) | (($this$and$iv2 & 255) << 16);
        int pos4 = pos3 + 1;
        byte $this$and$iv3 = data[pos3];
        int i2 = i | (($this$and$iv3 & 255) << 8);
        int pos5 = pos4 + 1;
        byte $this$and$iv4 = data[pos4];
        int i3 = i2 | ($this$and$iv4 & 255);
        this.pos = pos5;
        return i3;
    }

    public final long readLong$kotlinx_io_core() {
        byte[] data = this.data;
        int pos = this.pos;
        int pos2 = pos + 1;
        byte $this$and$iv = data[pos];
        long other$iv = 255 & $this$and$iv;
        int pos3 = pos2 + 1;
        byte $this$and$iv2 = data[pos2];
        long other$iv2 = 255 & $this$and$iv2;
        long j = (other$iv << 56) | (other$iv2 << 48);
        int pos4 = pos3 + 1;
        byte $this$and$iv3 = data[pos3];
        long other$iv3 = 255 & $this$and$iv3;
        int pos5 = pos4 + 1;
        byte $this$and$iv4 = data[pos4];
        long j2 = j | (other$iv3 << 40) | (($this$and$iv4 & 255) << 32);
        int pos6 = pos5 + 1;
        byte $this$and$iv5 = data[pos5];
        long other$iv4 = 255 & $this$and$iv5;
        int pos7 = pos6 + 1;
        byte $this$and$iv6 = data[pos6];
        long j3 = j2 | (other$iv4 << 24) | (($this$and$iv6 & 255) << 16);
        int pos8 = pos7 + 1;
        byte $this$and$iv7 = data[pos7];
        long other$iv5 = 255 & $this$and$iv7;
        int pos9 = pos8 + 1;
        byte $this$and$iv8 = data[pos8];
        long v = j3 | (other$iv5 << 8) | ($this$and$iv8 & 255);
        this.pos = pos9;
        return v;
    }

    public final void writeTo$kotlinx_io_core(Segment sink, int byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (!sink.owner) {
            throw new IllegalStateException("only owner can write".toString());
        }
        if (sink.limit + byteCount > 8192) {
            if (sink.getShared$kotlinx_io_core()) {
                throw new IllegalArgumentException();
            }
            if ((sink.limit + byteCount) - sink.pos > 8192) {
                throw new IllegalArgumentException();
            }
            ArraysKt.copyInto$default(sink.data, sink.data, 0, sink.pos, sink.limit, 2, (Object) null);
            sink.limit -= sink.pos;
            sink.pos = 0;
        }
        ArraysKt.copyInto(this.data, sink.data, sink.limit, this.pos, this.pos + byteCount);
        sink.limit += byteCount;
        this.pos += byteCount;
    }

    public final void readTo$kotlinx_io_core(byte[] dst, int dstStartOffset, int dstEndOffset) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        int len = dstEndOffset - dstStartOffset;
        ArraysKt.copyInto(this.data, dst, dstStartOffset, this.pos, this.pos + len);
        this.pos += len;
    }

    public final void write$kotlinx_io_core(byte[] src, int srcStartOffset, int srcEndOffset) {
        Intrinsics.checkNotNullParameter(src, "src");
        ArraysKt.copyInto(src, this.data, this.limit, srcStartOffset, srcEndOffset);
        this.limit += srcEndOffset - srcStartOffset;
    }

    public final int getSize() {
        return this.limit - this.pos;
    }

    public final int getRemainingCapacity() {
        return this.data.length - this.limit;
    }

    public final /* synthetic */ byte[] dataAsByteArray(boolean readOnly) {
        return this.data;
    }

    public final /* synthetic */ void writeBackData(byte[] data, int bytesToCommit) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    public final byte getUnchecked$kotlinx_io_core(int index) {
        return this.data[this.pos + index];
    }

    public final void setUnchecked$kotlinx_io_core(int index, byte value) {
        this.data[this.limit + index] = value;
    }

    public final void setUnchecked$kotlinx_io_core(int index, byte b0, byte b1) {
        byte[] d = this.data;
        int l = this.limit;
        d[l + index] = b0;
        d[l + index + 1] = b1;
    }

    public final void setUnchecked$kotlinx_io_core(int index, byte b0, byte b1, byte b2) {
        byte[] d = this.data;
        int l = this.limit;
        d[l + index] = b0;
        d[l + index + 1] = b1;
        d[l + index + 2] = b2;
    }

    public final void setUnchecked$kotlinx_io_core(int index, byte b0, byte b1, byte b2, byte b3) {
        byte[] d = this.data;
        int l = this.limit;
        d[l + index] = b0;
        d[l + index + 1] = b1;
        d[l + index + 2] = b2;
        d[l + index + 3] = b3;
    }

    /* compiled from: Segment.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\tJ7\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlinx/io/Segment$Companion;", "", "<init>", "()V", "SIZE", "", "SHARE_MINIMUM", "new", "Lkotlinx/io/Segment;", "new$kotlinx_io_core", "data", "", "pos", "limit", "copyTracker", "Lkotlinx/io/SegmentCopyTracker;", "owner", "", "kotlinx-io-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final /* synthetic */ Segment new$kotlinx_io_core() {
            return new Segment(null);
        }

        public final /* synthetic */ Segment new$kotlinx_io_core(byte[] data, int pos, int limit, SegmentCopyTracker copyTracker, boolean owner) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new Segment(data, pos, limit, copyTracker, owner, null);
        }
    }
}