package shark;

import java.io.Closeable;
import java.io.File;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;

/* compiled from: RandomAccessHprofReader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J:\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\u000e0\u0013¢\u0006\u0002\b\u0014¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lshark/RandomAccessHprofReader;", "Ljava/io/Closeable;", "source", "Lshark/RandomAccessSource;", "hprofHeader", "Lshark/HprofHeader;", "(Lshark/RandomAccessSource;Lshark/HprofHeader;)V", "buffer", "Lokio/Buffer;", "reader", "Lshark/HprofRecordReader;", "close", "", "readRecord", "T", "recordPosition", "", "recordSize", "withRecordReader", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(JJLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Companion", "shark-hprof"}, k = 1, mv = {1, 4, 1})
public final class RandomAccessHprofReader implements Closeable {
    public static final Companion Companion = new Companion(null);
    private final Buffer buffer;
    private final HprofRecordReader reader;
    private final RandomAccessSource source;

    private RandomAccessHprofReader(RandomAccessSource source, HprofHeader hprofHeader) {
        this.source = source;
        this.buffer = new Buffer();
        this.reader = new HprofRecordReader(hprofHeader, this.buffer);
    }

    public /* synthetic */ RandomAccessHprofReader(RandomAccessSource source, HprofHeader hprofHeader, DefaultConstructorMarker $constructor_marker) {
        this(source, hprofHeader);
    }

    public final <T> T readRecord(long recordPosition, long recordSize, Function1<? super HprofRecordReader, ? extends T> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "withRecordReader");
        if (!(recordSize > 0)) {
            throw new IllegalArgumentException(("recordSize " + recordSize + " must be > 0").toString());
        }
        long mutablePos = recordPosition;
        long mutableByteCount = recordSize;
        while (mutableByteCount > 0) {
            long bytesRead = this.source.read(this.buffer, mutablePos, mutableByteCount);
            if (!(bytesRead > 0)) {
                throw new IllegalStateException(("Requested " + mutableByteCount + " bytes after reading " + (mutablePos - recordPosition) + ", got 0 bytes instead.").toString());
            }
            mutablePos += bytesRead;
            mutableByteCount -= bytesRead;
        }
        T t = (T) function1.invoke(this.reader);
        if (this.buffer.size() == 0) {
            return t;
        }
        throw new IllegalStateException(("Buffer not fully consumed: " + this.buffer.size() + " bytes left").toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.source.close();
    }

    /* compiled from: RandomAccessHprofReader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bJ\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\u000b"}, d2 = {"Lshark/RandomAccessHprofReader$Companion;", "", "()V", "openReaderFor", "Lshark/RandomAccessHprofReader;", "hprofFile", "Ljava/io/File;", "hprofHeader", "Lshark/HprofHeader;", "hprofSourceProvider", "Lshark/RandomAccessSourceProvider;", "shark-hprof"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public static /* synthetic */ RandomAccessHprofReader openReaderFor$default(Companion companion, File file, HprofHeader hprofHeader, int i, Object obj) {
            if ((i & 2) != 0) {
                hprofHeader = HprofHeader.Companion.parseHeaderOf(file);
            }
            return companion.openReaderFor(file, hprofHeader);
        }

        public final RandomAccessHprofReader openReaderFor(File hprofFile, HprofHeader hprofHeader) {
            Intrinsics.checkParameterIsNotNull(hprofFile, "hprofFile");
            Intrinsics.checkParameterIsNotNull(hprofHeader, "hprofHeader");
            FileSourceProvider sourceProvider = new FileSourceProvider(hprofFile);
            return openReaderFor(sourceProvider, hprofHeader);
        }

        public static /* synthetic */ RandomAccessHprofReader openReaderFor$default(Companion companion, RandomAccessSourceProvider randomAccessSourceProvider, HprofHeader hprofHeader, int i, Object obj) {
            if ((i & 2) != 0) {
                RandomAccessSource openRandomAccessSource = randomAccessSourceProvider.openRandomAccessSource();
                try {
                    RandomAccessSource it = openRandomAccessSource;
                    HprofHeader parseHeaderOf = HprofHeader.Companion.parseHeaderOf(it.asStreamingSource());
                    CloseableKt.closeFinally(openRandomAccessSource, (Throwable) null);
                    hprofHeader = parseHeaderOf;
                } finally {
                }
            }
            return companion.openReaderFor(randomAccessSourceProvider, hprofHeader);
        }

        public final RandomAccessHprofReader openReaderFor(RandomAccessSourceProvider hprofSourceProvider, HprofHeader hprofHeader) {
            Intrinsics.checkParameterIsNotNull(hprofSourceProvider, "hprofSourceProvider");
            Intrinsics.checkParameterIsNotNull(hprofHeader, "hprofHeader");
            return new RandomAccessHprofReader(hprofSourceProvider.openRandomAccessSource(), hprofHeader, null);
        }
    }
}