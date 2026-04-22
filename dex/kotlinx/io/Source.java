package kotlinx.io;

import kotlin.Metadata;

/* compiled from: Source.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\rH&J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J$\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u0014H&J\u0018\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u001dH&J\b\u0010\u001f\u001a\u00020\u0000H&R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\u0003 ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006!À\u0006\u0001"}, d2 = {"Lkotlinx/io/Source;", "Lkotlinx/io/RawSource;", "buffer", "Lkotlinx/io/Buffer;", "getBuffer$annotations", "()V", "getBuffer", "()Lkotlinx/io/Buffer;", "exhausted", "", "require", "", "byteCount", "", "request", "readByte", "", "readShort", "", "readInt", "", "readLong", "skip", "readAtMostTo", "sink", "", "startIndex", "endIndex", "readTo", "Lkotlinx/io/RawSink;", "transferTo", "peek", "Lkotlinx/io/RealSource;", "kotlinx-io-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface Source extends RawSource {
    boolean exhausted();

    Buffer getBuffer();

    Source peek();

    int readAtMostTo(byte[] bArr, int i, int i2);

    byte readByte();

    int readInt();

    long readLong();

    short readShort();

    void readTo(RawSink rawSink, long j);

    boolean request(long j);

    void require(long j);

    void skip(long j);

    long transferTo(RawSink rawSink);

    /* compiled from: Source.kt */
    /* renamed from: kotlinx.io.Source$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void getBuffer$annotations() {
        }

        public static /* synthetic */ int readAtMostTo$default(Source source, byte[] bArr, int i, int i2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    i = 0;
                }
                if ((i3 & 4) != 0) {
                    i2 = bArr.length;
                }
                return source.readAtMostTo(bArr, i, i2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readAtMostTo");
        }
    }
}