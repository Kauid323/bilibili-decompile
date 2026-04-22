package shark;

import java.io.Closeable;
import java.io.File;
import java.util.Arrays;
import java.util.Set;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;

/* compiled from: StreamingHprofReader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lshark/StreamingHprofReader;", "", "sourceProvider", "Lshark/StreamingSourceProvider;", "header", "Lshark/HprofHeader;", "(Lshark/StreamingSourceProvider;Lshark/HprofHeader;)V", "readRecords", "", "recordTags", "", "Lshark/HprofRecordTag;", "listener", "Lshark/OnHprofRecordTagListener;", "Companion", "shark-hprof"}, k = 1, mv = {1, 4, 1})
public final class StreamingHprofReader {
    public static final Companion Companion = new Companion(null);
    private final HprofHeader header;
    private final StreamingSourceProvider sourceProvider;

    private StreamingHprofReader(StreamingSourceProvider sourceProvider, HprofHeader header) {
        this.sourceProvider = sourceProvider;
        this.header = header;
    }

    public /* synthetic */ StreamingHprofReader(StreamingSourceProvider sourceProvider, HprofHeader header, DefaultConstructorMarker $constructor_marker) {
        this(sourceProvider, header);
    }

    public final long readRecords(Set<? extends HprofRecordTag> set, OnHprofRecordTagListener listener) {
        BufferedSource source;
        boolean z;
        int intByteSize;
        int identifierByteSize;
        Intrinsics.checkParameterIsNotNull(set, "recordTags");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        BufferedSource bufferedSource = (Closeable) this.sourceProvider.openStreamingSource();
        try {
            BufferedSource source2 = bufferedSource;
            boolean z2 = false;
            HprofRecordReader reader = new HprofRecordReader(this.header, source2);
            reader.skip(this.header.getRecordsPosition());
            int intByteSize2 = PrimitiveType.INT.getByteSize();
            int identifierByteSize2 = reader.sizeOf(2);
            while (!source2.exhausted()) {
                int tag = reader.readUnsignedByte();
                reader.skip(intByteSize2);
                long length = reader.readUnsignedInt();
                if (tag == HprofRecordTag.STRING_IN_UTF8.getTag()) {
                    if (set.contains(HprofRecordTag.STRING_IN_UTF8)) {
                        listener.onHprofRecord(HprofRecordTag.STRING_IN_UTF8, length, reader);
                        source = source2;
                        z = z2;
                        intByteSize = intByteSize2;
                        identifierByteSize = identifierByteSize2;
                    } else {
                        reader.skip(length);
                        source = source2;
                        z = z2;
                        intByteSize = intByteSize2;
                        identifierByteSize = identifierByteSize2;
                    }
                } else if (tag == HprofRecordTag.LOAD_CLASS.getTag()) {
                    if (set.contains(HprofRecordTag.LOAD_CLASS)) {
                        listener.onHprofRecord(HprofRecordTag.LOAD_CLASS, length, reader);
                        source = source2;
                        z = z2;
                        intByteSize = intByteSize2;
                        identifierByteSize = identifierByteSize2;
                    } else {
                        reader.skip(length);
                        source = source2;
                        z = z2;
                        intByteSize = intByteSize2;
                        identifierByteSize = identifierByteSize2;
                    }
                } else if (tag == HprofRecordTag.STACK_FRAME.getTag()) {
                    if (set.contains(HprofRecordTag.STACK_FRAME)) {
                        listener.onHprofRecord(HprofRecordTag.STACK_FRAME, length, reader);
                        source = source2;
                        z = z2;
                        intByteSize = intByteSize2;
                        identifierByteSize = identifierByteSize2;
                    } else {
                        reader.skip(length);
                        source = source2;
                        z = z2;
                        intByteSize = intByteSize2;
                        identifierByteSize = identifierByteSize2;
                    }
                } else if (tag == HprofRecordTag.STACK_TRACE.getTag()) {
                    if (set.contains(HprofRecordTag.STACK_TRACE)) {
                        listener.onHprofRecord(HprofRecordTag.STACK_TRACE, length, reader);
                        source = source2;
                        z = z2;
                        intByteSize = intByteSize2;
                        identifierByteSize = identifierByteSize2;
                    } else {
                        reader.skip(length);
                        source = source2;
                        z = z2;
                        intByteSize = intByteSize2;
                        identifierByteSize = identifierByteSize2;
                    }
                } else {
                    if (tag != HprofRecordTag.HEAP_DUMP.getTag() && tag != HprofRecordTag.HEAP_DUMP_SEGMENT.getTag()) {
                        source = source2;
                        z = z2;
                        intByteSize = intByteSize2;
                        identifierByteSize = identifierByteSize2;
                        if (tag == HprofRecordTag.HEAP_DUMP_END.getTag()) {
                            if (set.contains(HprofRecordTag.HEAP_DUMP_END)) {
                                listener.onHprofRecord(HprofRecordTag.HEAP_DUMP_END, length, reader);
                            }
                        } else {
                            reader.skip(length);
                        }
                    }
                    long heapDumpStart = reader.getBytesRead();
                    int previousTag = 0;
                    source = source2;
                    z = z2;
                    long previousTagPosition = 0;
                    while (reader.getBytesRead() - heapDumpStart < length) {
                        long heapDumpTagPosition = reader.getBytesRead();
                        int heapDumpTag = reader.readUnsignedByte();
                        long length2 = length;
                        if (heapDumpTag == HprofRecordTag.ROOT_UNKNOWN.getTag()) {
                            if (set.contains(HprofRecordTag.ROOT_UNKNOWN)) {
                                listener.onHprofRecord(HprofRecordTag.ROOT_UNKNOWN, -1L, reader);
                            } else {
                                reader.skip(identifierByteSize2);
                            }
                        } else {
                            long previousTagPosition2 = previousTagPosition;
                            if (heapDumpTag == HprofRecordTag.ROOT_JNI_GLOBAL.getTag()) {
                                if (set.contains(HprofRecordTag.ROOT_JNI_GLOBAL)) {
                                    listener.onHprofRecord(HprofRecordTag.ROOT_JNI_GLOBAL, -1L, reader);
                                } else {
                                    reader.skip(identifierByteSize2 + identifierByteSize2);
                                }
                            } else if (heapDumpTag == HprofRecordTag.ROOT_JNI_LOCAL.getTag()) {
                                if (set.contains(HprofRecordTag.ROOT_JNI_LOCAL)) {
                                    listener.onHprofRecord(HprofRecordTag.ROOT_JNI_LOCAL, -1L, reader);
                                } else {
                                    reader.skip(identifierByteSize2 + intByteSize2 + intByteSize2);
                                }
                            } else if (heapDumpTag == HprofRecordTag.ROOT_JAVA_FRAME.getTag()) {
                                if (set.contains(HprofRecordTag.ROOT_JAVA_FRAME)) {
                                    listener.onHprofRecord(HprofRecordTag.ROOT_JAVA_FRAME, -1L, reader);
                                } else {
                                    reader.skip(identifierByteSize2 + intByteSize2 + intByteSize2);
                                }
                            } else if (heapDumpTag == HprofRecordTag.ROOT_NATIVE_STACK.getTag()) {
                                if (set.contains(HprofRecordTag.ROOT_NATIVE_STACK)) {
                                    listener.onHprofRecord(HprofRecordTag.ROOT_NATIVE_STACK, -1L, reader);
                                } else {
                                    reader.skip(identifierByteSize2 + intByteSize2);
                                }
                            } else if (heapDumpTag == HprofRecordTag.ROOT_STICKY_CLASS.getTag()) {
                                if (set.contains(HprofRecordTag.ROOT_STICKY_CLASS)) {
                                    listener.onHprofRecord(HprofRecordTag.ROOT_STICKY_CLASS, -1L, reader);
                                } else {
                                    reader.skip(identifierByteSize2);
                                }
                            } else if (heapDumpTag == HprofRecordTag.ROOT_THREAD_BLOCK.getTag()) {
                                if (set.contains(HprofRecordTag.ROOT_THREAD_BLOCK)) {
                                    listener.onHprofRecord(HprofRecordTag.ROOT_THREAD_BLOCK, -1L, reader);
                                } else {
                                    reader.skip(identifierByteSize2 + intByteSize2);
                                }
                            } else if (heapDumpTag == HprofRecordTag.ROOT_MONITOR_USED.getTag()) {
                                if (set.contains(HprofRecordTag.ROOT_MONITOR_USED)) {
                                    listener.onHprofRecord(HprofRecordTag.ROOT_MONITOR_USED, -1L, reader);
                                } else {
                                    reader.skip(identifierByteSize2);
                                }
                            } else if (heapDumpTag == HprofRecordTag.ROOT_THREAD_OBJECT.getTag()) {
                                if (set.contains(HprofRecordTag.ROOT_THREAD_OBJECT)) {
                                    listener.onHprofRecord(HprofRecordTag.ROOT_THREAD_OBJECT, -1L, reader);
                                } else {
                                    reader.skip(identifierByteSize2 + intByteSize2 + intByteSize2);
                                }
                            } else if (heapDumpTag == HprofRecordTag.ROOT_INTERNED_STRING.getTag()) {
                                if (set.contains(HprofRecordTag.ROOT_INTERNED_STRING)) {
                                    listener.onHprofRecord(HprofRecordTag.ROOT_INTERNED_STRING, -1L, reader);
                                } else {
                                    reader.skip(identifierByteSize2);
                                }
                            } else if (heapDumpTag == HprofRecordTag.ROOT_FINALIZING.getTag()) {
                                if (set.contains(HprofRecordTag.ROOT_FINALIZING)) {
                                    listener.onHprofRecord(HprofRecordTag.ROOT_FINALIZING, -1L, reader);
                                } else {
                                    reader.skip(identifierByteSize2);
                                }
                            } else if (heapDumpTag == HprofRecordTag.ROOT_DEBUGGER.getTag()) {
                                if (set.contains(HprofRecordTag.ROOT_DEBUGGER)) {
                                    listener.onHprofRecord(HprofRecordTag.ROOT_DEBUGGER, -1L, reader);
                                } else {
                                    reader.skip(identifierByteSize2);
                                }
                            } else if (heapDumpTag == HprofRecordTag.ROOT_REFERENCE_CLEANUP.getTag()) {
                                if (set.contains(HprofRecordTag.ROOT_REFERENCE_CLEANUP)) {
                                    listener.onHprofRecord(HprofRecordTag.ROOT_REFERENCE_CLEANUP, -1L, reader);
                                } else {
                                    reader.skip(identifierByteSize2);
                                }
                            } else if (heapDumpTag == HprofRecordTag.ROOT_VM_INTERNAL.getTag()) {
                                if (set.contains(HprofRecordTag.ROOT_VM_INTERNAL)) {
                                    listener.onHprofRecord(HprofRecordTag.ROOT_VM_INTERNAL, -1L, reader);
                                } else {
                                    reader.skip(identifierByteSize2);
                                }
                            } else if (heapDumpTag == HprofRecordTag.ROOT_JNI_MONITOR.getTag()) {
                                if (set.contains(HprofRecordTag.ROOT_JNI_MONITOR)) {
                                    listener.onHprofRecord(HprofRecordTag.ROOT_JNI_MONITOR, -1L, reader);
                                } else {
                                    reader.skip(identifierByteSize2 + intByteSize2 + intByteSize2);
                                }
                            } else if (heapDumpTag == HprofRecordTag.ROOT_UNREACHABLE.getTag()) {
                                if (set.contains(HprofRecordTag.ROOT_UNREACHABLE)) {
                                    listener.onHprofRecord(HprofRecordTag.ROOT_UNREACHABLE, -1L, reader);
                                } else {
                                    reader.skip(identifierByteSize2);
                                }
                            } else if (heapDumpTag == HprofRecordTag.CLASS_DUMP.getTag()) {
                                if (set.contains(HprofRecordTag.CLASS_DUMP)) {
                                    listener.onHprofRecord(HprofRecordTag.CLASS_DUMP, -1L, reader);
                                } else {
                                    reader.skipClassDumpRecord();
                                }
                            } else if (heapDumpTag == HprofRecordTag.INSTANCE_DUMP.getTag()) {
                                if (set.contains(HprofRecordTag.INSTANCE_DUMP)) {
                                    listener.onHprofRecord(HprofRecordTag.INSTANCE_DUMP, -1L, reader);
                                } else {
                                    reader.skipInstanceDumpRecord();
                                }
                            } else if (heapDumpTag == HprofRecordTag.OBJECT_ARRAY_DUMP.getTag()) {
                                if (set.contains(HprofRecordTag.OBJECT_ARRAY_DUMP)) {
                                    listener.onHprofRecord(HprofRecordTag.OBJECT_ARRAY_DUMP, -1L, reader);
                                } else {
                                    reader.skipObjectArrayDumpRecord();
                                }
                            } else if (heapDumpTag == HprofRecordTag.PRIMITIVE_ARRAY_DUMP.getTag()) {
                                if (set.contains(HprofRecordTag.PRIMITIVE_ARRAY_DUMP)) {
                                    listener.onHprofRecord(HprofRecordTag.PRIMITIVE_ARRAY_DUMP, -1L, reader);
                                } else {
                                    reader.skipPrimitiveArrayDumpRecord();
                                }
                            } else if (heapDumpTag == HprofRecordTag.PRIMITIVE_ARRAY_NODATA.getTag()) {
                                throw new UnsupportedOperationException(HprofRecordTag.PRIMITIVE_ARRAY_NODATA + " cannot be parsed");
                            } else {
                                if (heapDumpTag == HprofRecordTag.HEAP_DUMP_INFO.getTag()) {
                                    if (set.contains(HprofRecordTag.HEAP_DUMP_INFO)) {
                                        listener.onHprofRecord(HprofRecordTag.HEAP_DUMP_INFO, -1L, reader);
                                    } else {
                                        reader.skipHeapDumpInfoRecord();
                                    }
                                } else {
                                    StringBuilder append = new StringBuilder().append("Unknown tag ");
                                    String format = String.format("0x%02x", Arrays.copyOf(new Object[]{Integer.valueOf(heapDumpTag)}, 1));
                                    Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(this, *args)");
                                    StringBuilder append2 = append.append(format).append(" at ").append(heapDumpTagPosition).append(" after ");
                                    String format2 = String.format("0x%02x", Arrays.copyOf(new Object[]{Integer.valueOf(previousTag)}, 1));
                                    Intrinsics.checkExpressionValueIsNotNull(format2, "java.lang.String.format(this, *args)");
                                    throw new IllegalStateException(append2.append(format2).append(" at ").append(previousTagPosition2).toString());
                                }
                            }
                        }
                        previousTag = heapDumpTag;
                        previousTagPosition = heapDumpTagPosition;
                        length = length2;
                    }
                    intByteSize = intByteSize2;
                    identifierByteSize = identifierByteSize2;
                }
                source2 = source;
                z2 = z;
                identifierByteSize2 = identifierByteSize;
                intByteSize2 = intByteSize;
            }
            long bytesRead = reader.getBytesRead();
            CloseableKt.closeFinally(bufferedSource, (Throwable) null);
            return bytesRead;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(bufferedSource, th);
                throw th2;
            }
        }
    }

    /* compiled from: StreamingHprofReader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bJ\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\u000b"}, d2 = {"Lshark/StreamingHprofReader$Companion;", "", "()V", "readerFor", "Lshark/StreamingHprofReader;", "hprofFile", "Ljava/io/File;", "hprofHeader", "Lshark/HprofHeader;", "hprofSourceProvider", "Lshark/StreamingSourceProvider;", "shark-hprof"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public static /* synthetic */ StreamingHprofReader readerFor$default(Companion companion, File file, HprofHeader hprofHeader, int i, Object obj) {
            if ((i & 2) != 0) {
                hprofHeader = HprofHeader.Companion.parseHeaderOf(file);
            }
            return companion.readerFor(file, hprofHeader);
        }

        public final StreamingHprofReader readerFor(File hprofFile, HprofHeader hprofHeader) {
            Intrinsics.checkParameterIsNotNull(hprofFile, "hprofFile");
            Intrinsics.checkParameterIsNotNull(hprofHeader, "hprofHeader");
            FileSourceProvider sourceProvider = new FileSourceProvider(hprofFile);
            return readerFor(sourceProvider, hprofHeader);
        }

        public static /* synthetic */ StreamingHprofReader readerFor$default(Companion companion, StreamingSourceProvider streamingSourceProvider, HprofHeader hprofHeader, int i, Object obj) {
            if ((i & 2) != 0) {
                BufferedSource bufferedSource = (Closeable) streamingSourceProvider.openStreamingSource();
                try {
                    BufferedSource it = bufferedSource;
                    HprofHeader parseHeaderOf = HprofHeader.Companion.parseHeaderOf(it);
                    CloseableKt.closeFinally(bufferedSource, (Throwable) null);
                    hprofHeader = parseHeaderOf;
                } finally {
                }
            }
            return companion.readerFor(streamingSourceProvider, hprofHeader);
        }

        public final StreamingHprofReader readerFor(StreamingSourceProvider hprofSourceProvider, HprofHeader hprofHeader) {
            Intrinsics.checkParameterIsNotNull(hprofSourceProvider, "hprofSourceProvider");
            Intrinsics.checkParameterIsNotNull(hprofHeader, "hprofHeader");
            return new StreamingHprofReader(hprofSourceProvider, hprofHeader, null);
        }
    }
}