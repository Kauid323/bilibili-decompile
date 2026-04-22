package shark;

import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: HprofReader.kt */
@Deprecated(message = "Replaced by HprofStreamingReader.readerFor or HprofRandomAccessReader.openReaderFor")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\r\u001a\u00020\u000e2\u0014\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u00110\u00102\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lshark/HprofReader;", "", "hprof", "Lshark/Hprof;", "(Lshark/Hprof;)V", "identifierByteSize", "", "getIdentifierByteSize", "()I", "startPosition", "", "getStartPosition", "()J", "readHprofRecords", "", "recordTypes", "", "Lkotlin/reflect/KClass;", "Lshark/HprofRecord;", "listener", "Lshark/OnHprofRecordListener;", "shark-hprof"}, k = 1, mv = {1, 4, 1})
public final class HprofReader {
    private final Hprof hprof;

    public HprofReader(Hprof hprof) {
        Intrinsics.checkParameterIsNotNull(hprof, "hprof");
        this.hprof = hprof;
    }

    public final int getIdentifierByteSize() {
        return this.hprof.getHeader().getIdentifierByteSize();
    }

    public final long getStartPosition() {
        return this.hprof.getHeader().getRecordsPosition();
    }

    public final void readHprofRecords(Set<? extends KClass<? extends HprofRecord>> set, OnHprofRecordListener listener) {
        Intrinsics.checkParameterIsNotNull(set, "recordTypes");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        StreamingRecordReaderAdapter reader = StreamingRecordReaderAdapter.Companion.asStreamingRecordReader(StreamingHprofReader.Companion.readerFor(this.hprof.getFile(), this.hprof.getHeader()));
        reader.readRecords(set, listener);
    }
}