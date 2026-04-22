package shark;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import shark.HprofRecord;

/* compiled from: HprofPrimitiveArrayStripper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004J\u0016\u0010\u0003\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lshark/HprofPrimitiveArrayStripper;", "", "()V", "stripPrimitiveArrays", "Ljava/io/File;", "inputHprofFile", "outputHprofFile", "", "hprofSourceProvider", "Lshark/StreamingSourceProvider;", "hprofSink", "Lokio/BufferedSink;", "shark-hprof"}, k = 1, mv = {1, 4, 1})
public final class HprofPrimitiveArrayStripper {
    public static /* synthetic */ File stripPrimitiveArrays$default(HprofPrimitiveArrayStripper hprofPrimitiveArrayStripper, File file, File file2, int i, Object obj) {
        if ((i & 2) != 0) {
            String parent = file.getParent();
            String name = file.getName();
            Intrinsics.checkExpressionValueIsNotNull(name, "inputHprofFile.name");
            String it = StringsKt.replace$default(name, ".hprof", "-stripped.hprof", false, 4, (Object) null);
            if (Intrinsics.areEqual(it, file.getName())) {
                it = file.getName() + "-stripped";
            }
            file2 = new File(parent, it);
        }
        return hprofPrimitiveArrayStripper.stripPrimitiveArrays(file, file2);
    }

    public final File stripPrimitiveArrays(File inputHprofFile, File outputHprofFile) {
        Intrinsics.checkParameterIsNotNull(inputHprofFile, "inputHprofFile");
        Intrinsics.checkParameterIsNotNull(outputHprofFile, "outputHprofFile");
        BufferedSink buffer = Okio.buffer(Okio.sink(new FileOutputStream(outputHprofFile)));
        Intrinsics.checkExpressionValueIsNotNull(buffer, "Okio.buffer(Okio.sink(ou…profFile.outputStream()))");
        stripPrimitiveArrays(new FileSourceProvider(inputHprofFile), buffer);
        return outputHprofFile;
    }

    public final void stripPrimitiveArrays(StreamingSourceProvider hprofSourceProvider, BufferedSink hprofSink) {
        Intrinsics.checkParameterIsNotNull(hprofSourceProvider, "hprofSourceProvider");
        Intrinsics.checkParameterIsNotNull(hprofSink, "hprofSink");
        HprofWriter hprofWriter = (Closeable) hprofSourceProvider.openStreamingSource();
        try {
            BufferedSource it = hprofWriter;
            HprofHeader header = HprofHeader.Companion.parseHeaderOf(it);
            CloseableKt.closeFinally(hprofWriter, (Throwable) null);
            StreamingRecordReaderAdapter reader = StreamingRecordReaderAdapter.Companion.asStreamingRecordReader(StreamingHprofReader.Companion.readerFor(hprofSourceProvider, header));
            hprofWriter = HprofWriter.Companion.openWriterFor(hprofSink, header);
            try {
                final HprofWriter writer = hprofWriter;
                reader.readRecords(SetsKt.setOf(Reflection.getOrCreateKotlinClass(HprofRecord.class)), new OnHprofRecordListener() { // from class: shark.HprofPrimitiveArrayStripper$stripPrimitiveArrays$2$1
                    @Override // shark.OnHprofRecordListener
                    public final void onHprofRecord(long $noName_0, HprofRecord record) {
                        HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.LongArrayDump longArrayDump;
                        Intrinsics.checkParameterIsNotNull(record, "record");
                        if (record instanceof HprofRecord.HeapDumpEndRecord) {
                            return;
                        }
                        HprofWriter hprofWriter2 = HprofWriter.this;
                        if (record instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.BooleanArrayDump) {
                            longArrayDump = new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.BooleanArrayDump(((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.BooleanArrayDump) record).getId(), ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.BooleanArrayDump) record).getStackTraceSerialNumber(), new boolean[((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.BooleanArrayDump) record).getArray().length]);
                        } else {
                            int i = 0;
                            if (record instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump) {
                                long id = ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump) record).getId();
                                int stackTraceSerialNumber = ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump) record).getStackTraceSerialNumber();
                                int length = ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump) record).getArray().length;
                                char[] cArr = new char[length];
                                while (i < length) {
                                    cArr[i] = '?';
                                    i++;
                                }
                                longArrayDump = new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump(id, stackTraceSerialNumber, cArr);
                            } else if (record instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.FloatArrayDump) {
                                longArrayDump = new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.FloatArrayDump(((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.FloatArrayDump) record).getId(), ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.FloatArrayDump) record).getStackTraceSerialNumber(), new float[((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.FloatArrayDump) record).getArray().length]);
                            } else if (record instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.DoubleArrayDump) {
                                longArrayDump = new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.DoubleArrayDump(((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.DoubleArrayDump) record).getId(), ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.DoubleArrayDump) record).getStackTraceSerialNumber(), new double[((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.DoubleArrayDump) record).getArray().length]);
                            } else if (record instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ByteArrayDump) {
                                long id2 = ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ByteArrayDump) record).getId();
                                int stackTraceSerialNumber2 = ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ByteArrayDump) record).getStackTraceSerialNumber();
                                int length2 = ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ByteArrayDump) record).getArray().length;
                                byte[] bArr = new byte[length2];
                                while (i < length2) {
                                    bArr[i] = 63;
                                    i++;
                                }
                                longArrayDump = new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ByteArrayDump(id2, stackTraceSerialNumber2, bArr);
                            } else if (record instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ShortArrayDump) {
                                longArrayDump = new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ShortArrayDump(((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ShortArrayDump) record).getId(), ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ShortArrayDump) record).getStackTraceSerialNumber(), new short[((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ShortArrayDump) record).getArray().length]);
                            } else if (record instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.IntArrayDump) {
                                longArrayDump = new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.IntArrayDump(((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.IntArrayDump) record).getId(), ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.IntArrayDump) record).getStackTraceSerialNumber(), new int[((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.IntArrayDump) record).getArray().length]);
                            } else if (record instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.LongArrayDump) {
                                longArrayDump = new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.LongArrayDump(((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.LongArrayDump) record).getId(), ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.LongArrayDump) record).getStackTraceSerialNumber(), new long[((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.LongArrayDump) record).getArray().length]);
                            } else {
                                longArrayDump = record;
                            }
                        }
                        hprofWriter2.write(longArrayDump);
                    }
                });
                CloseableKt.closeFinally(hprofWriter, (Throwable) null);
            } finally {
            }
        } finally {
            try {
                throw th;
            } finally {
            }
        }
    }
}