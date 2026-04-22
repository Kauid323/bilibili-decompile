package shark;

import java.util.EnumSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import shark.GcRoot;
import shark.HprofRecord;
import shark.StreamingRecordReaderAdapter;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;

/* compiled from: StreamingRecordReaderAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lshark/StreamingRecordReaderAdapter;", "", "streamingHprofReader", "Lshark/StreamingHprofReader;", "(Lshark/StreamingHprofReader;)V", "readRecords", "", "recordTypes", "", "Lkotlin/reflect/KClass;", "Lshark/HprofRecord;", "listener", "Lshark/OnHprofRecordListener;", "Companion", "shark-hprof"}, k = 1, mv = {1, 4, 1})
public final class StreamingRecordReaderAdapter {
    public static final Companion Companion = new Companion(null);
    private final StreamingHprofReader streamingHprofReader;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[HprofRecordTag.values().length];

        static {
            $EnumSwitchMapping$0[HprofRecordTag.STRING_IN_UTF8.ordinal()] = 1;
            $EnumSwitchMapping$0[HprofRecordTag.LOAD_CLASS.ordinal()] = 2;
            $EnumSwitchMapping$0[HprofRecordTag.STACK_FRAME.ordinal()] = 3;
            $EnumSwitchMapping$0[HprofRecordTag.STACK_TRACE.ordinal()] = 4;
            $EnumSwitchMapping$0[HprofRecordTag.ROOT_UNKNOWN.ordinal()] = 5;
            $EnumSwitchMapping$0[HprofRecordTag.ROOT_JNI_GLOBAL.ordinal()] = 6;
            $EnumSwitchMapping$0[HprofRecordTag.ROOT_JNI_LOCAL.ordinal()] = 7;
            $EnumSwitchMapping$0[HprofRecordTag.ROOT_JAVA_FRAME.ordinal()] = 8;
            $EnumSwitchMapping$0[HprofRecordTag.ROOT_NATIVE_STACK.ordinal()] = 9;
            $EnumSwitchMapping$0[HprofRecordTag.ROOT_STICKY_CLASS.ordinal()] = 10;
            $EnumSwitchMapping$0[HprofRecordTag.ROOT_THREAD_BLOCK.ordinal()] = 11;
            $EnumSwitchMapping$0[HprofRecordTag.ROOT_MONITOR_USED.ordinal()] = 12;
            $EnumSwitchMapping$0[HprofRecordTag.ROOT_THREAD_OBJECT.ordinal()] = 13;
            $EnumSwitchMapping$0[HprofRecordTag.ROOT_INTERNED_STRING.ordinal()] = 14;
            $EnumSwitchMapping$0[HprofRecordTag.ROOT_FINALIZING.ordinal()] = 15;
            $EnumSwitchMapping$0[HprofRecordTag.ROOT_DEBUGGER.ordinal()] = 16;
            $EnumSwitchMapping$0[HprofRecordTag.ROOT_REFERENCE_CLEANUP.ordinal()] = 17;
            $EnumSwitchMapping$0[HprofRecordTag.ROOT_VM_INTERNAL.ordinal()] = 18;
            $EnumSwitchMapping$0[HprofRecordTag.ROOT_JNI_MONITOR.ordinal()] = 19;
            $EnumSwitchMapping$0[HprofRecordTag.ROOT_UNREACHABLE.ordinal()] = 20;
            $EnumSwitchMapping$0[HprofRecordTag.CLASS_DUMP.ordinal()] = 21;
            $EnumSwitchMapping$0[HprofRecordTag.INSTANCE_DUMP.ordinal()] = 22;
            $EnumSwitchMapping$0[HprofRecordTag.OBJECT_ARRAY_DUMP.ordinal()] = 23;
            $EnumSwitchMapping$0[HprofRecordTag.PRIMITIVE_ARRAY_DUMP.ordinal()] = 24;
            $EnumSwitchMapping$0[HprofRecordTag.HEAP_DUMP_INFO.ordinal()] = 25;
            $EnumSwitchMapping$0[HprofRecordTag.HEAP_DUMP_END.ordinal()] = 26;
        }
    }

    public StreamingRecordReaderAdapter(StreamingHprofReader streamingHprofReader) {
        Intrinsics.checkParameterIsNotNull(streamingHprofReader, "streamingHprofReader");
        this.streamingHprofReader = streamingHprofReader;
    }

    public final long readRecords(Set<? extends KClass<? extends HprofRecord>> set, final OnHprofRecordListener listener) {
        Intrinsics.checkParameterIsNotNull(set, "recordTypes");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        EnumSet recordTags = Companion.asHprofTags(set);
        return this.streamingHprofReader.readRecords(recordTags, new OnHprofRecordTagListener() { // from class: shark.StreamingRecordReaderAdapter$readRecords$1
            @Override // shark.OnHprofRecordTagListener
            public final void onHprofRecord(HprofRecordTag tag, long length, HprofRecordReader reader) {
                Intrinsics.checkParameterIsNotNull(tag, AppConfig.HOST_TAG);
                Intrinsics.checkParameterIsNotNull(reader, "reader");
                switch (StreamingRecordReaderAdapter.WhenMappings.$EnumSwitchMapping$0[tag.ordinal()]) {
                    case 1:
                        long recordPosition = reader.getBytesRead();
                        HprofRecord.StringRecord record = reader.readStringRecord(length);
                        OnHprofRecordListener.this.onHprofRecord(recordPosition, record);
                        return;
                    case 2:
                        long recordPosition2 = reader.getBytesRead();
                        HprofRecord.LoadClassRecord record2 = reader.readLoadClassRecord();
                        OnHprofRecordListener.this.onHprofRecord(recordPosition2, record2);
                        return;
                    case 3:
                        long recordPosition3 = reader.getBytesRead();
                        HprofRecord.StackFrameRecord record3 = reader.readStackFrameRecord();
                        OnHprofRecordListener.this.onHprofRecord(recordPosition3, record3);
                        return;
                    case 4:
                        long recordPosition4 = reader.getBytesRead();
                        HprofRecord.StackTraceRecord record4 = reader.readStackTraceRecord();
                        OnHprofRecordListener.this.onHprofRecord(recordPosition4, record4);
                        return;
                    case 5:
                        long recordPosition5 = reader.getBytesRead();
                        GcRoot.Unknown record5 = reader.readUnknownGcRootRecord();
                        OnHprofRecordListener.this.onHprofRecord(recordPosition5, new HprofRecord.HeapDumpRecord.GcRootRecord(record5));
                        return;
                    case 6:
                        long recordPosition6 = reader.getBytesRead();
                        GcRoot.JniGlobal gcRootRecord = reader.readJniGlobalGcRootRecord();
                        OnHprofRecordListener.this.onHprofRecord(recordPosition6, new HprofRecord.HeapDumpRecord.GcRootRecord(gcRootRecord));
                        return;
                    case 7:
                        long recordPosition7 = reader.getBytesRead();
                        GcRoot.JniLocal gcRootRecord2 = reader.readJniLocalGcRootRecord();
                        OnHprofRecordListener.this.onHprofRecord(recordPosition7, new HprofRecord.HeapDumpRecord.GcRootRecord(gcRootRecord2));
                        return;
                    case 8:
                        long recordPosition8 = reader.getBytesRead();
                        GcRoot.JavaFrame gcRootRecord3 = reader.readJavaFrameGcRootRecord();
                        OnHprofRecordListener.this.onHprofRecord(recordPosition8, new HprofRecord.HeapDumpRecord.GcRootRecord(gcRootRecord3));
                        return;
                    case 9:
                        long recordPosition9 = reader.getBytesRead();
                        GcRoot.NativeStack gcRootRecord4 = reader.readNativeStackGcRootRecord();
                        OnHprofRecordListener.this.onHprofRecord(recordPosition9, new HprofRecord.HeapDumpRecord.GcRootRecord(gcRootRecord4));
                        return;
                    case 10:
                        long recordPosition10 = reader.getBytesRead();
                        GcRoot.StickyClass gcRootRecord5 = reader.readStickyClassGcRootRecord();
                        OnHprofRecordListener.this.onHprofRecord(recordPosition10, new HprofRecord.HeapDumpRecord.GcRootRecord(gcRootRecord5));
                        return;
                    case 11:
                        long recordPosition11 = reader.getBytesRead();
                        GcRoot.ThreadBlock gcRootRecord6 = reader.readThreadBlockGcRootRecord();
                        OnHprofRecordListener.this.onHprofRecord(recordPosition11, new HprofRecord.HeapDumpRecord.GcRootRecord(gcRootRecord6));
                        return;
                    case 12:
                        long recordPosition12 = reader.getBytesRead();
                        GcRoot.MonitorUsed gcRootRecord7 = reader.readMonitorUsedGcRootRecord();
                        OnHprofRecordListener.this.onHprofRecord(recordPosition12, new HprofRecord.HeapDumpRecord.GcRootRecord(gcRootRecord7));
                        return;
                    case 13:
                        long recordPosition13 = reader.getBytesRead();
                        GcRoot.ThreadObject gcRootRecord8 = reader.readThreadObjectGcRootRecord();
                        OnHprofRecordListener.this.onHprofRecord(recordPosition13, new HprofRecord.HeapDumpRecord.GcRootRecord(gcRootRecord8));
                        return;
                    case 14:
                        long recordPosition14 = reader.getBytesRead();
                        GcRoot.InternedString gcRootRecord9 = reader.readInternedStringGcRootRecord();
                        OnHprofRecordListener.this.onHprofRecord(recordPosition14, new HprofRecord.HeapDumpRecord.GcRootRecord(gcRootRecord9));
                        return;
                    case 15:
                        long recordPosition15 = reader.getBytesRead();
                        GcRoot.Finalizing gcRootRecord10 = reader.readFinalizingGcRootRecord();
                        OnHprofRecordListener.this.onHprofRecord(recordPosition15, new HprofRecord.HeapDumpRecord.GcRootRecord(gcRootRecord10));
                        return;
                    case 16:
                        long recordPosition16 = reader.getBytesRead();
                        GcRoot.Debugger gcRootRecord11 = reader.readDebuggerGcRootRecord();
                        OnHprofRecordListener.this.onHprofRecord(recordPosition16, new HprofRecord.HeapDumpRecord.GcRootRecord(gcRootRecord11));
                        return;
                    case 17:
                        long recordPosition17 = reader.getBytesRead();
                        GcRoot.ReferenceCleanup gcRootRecord12 = reader.readReferenceCleanupGcRootRecord();
                        OnHprofRecordListener.this.onHprofRecord(recordPosition17, new HprofRecord.HeapDumpRecord.GcRootRecord(gcRootRecord12));
                        return;
                    case 18:
                        long recordPosition18 = reader.getBytesRead();
                        GcRoot.VmInternal gcRootRecord13 = reader.readVmInternalGcRootRecord();
                        OnHprofRecordListener.this.onHprofRecord(recordPosition18, new HprofRecord.HeapDumpRecord.GcRootRecord(gcRootRecord13));
                        return;
                    case 19:
                        long recordPosition19 = reader.getBytesRead();
                        GcRoot.JniMonitor gcRootRecord14 = reader.readJniMonitorGcRootRecord();
                        OnHprofRecordListener.this.onHprofRecord(recordPosition19, new HprofRecord.HeapDumpRecord.GcRootRecord(gcRootRecord14));
                        return;
                    case 20:
                        long recordPosition20 = reader.getBytesRead();
                        GcRoot.Unreachable gcRootRecord15 = reader.readUnreachableGcRootRecord();
                        OnHprofRecordListener.this.onHprofRecord(recordPosition20, new HprofRecord.HeapDumpRecord.GcRootRecord(gcRootRecord15));
                        return;
                    case 21:
                        long recordPosition21 = reader.getBytesRead();
                        HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord record6 = reader.readClassDumpRecord();
                        OnHprofRecordListener.this.onHprofRecord(recordPosition21, record6);
                        return;
                    case 22:
                        long recordPosition22 = reader.getBytesRead();
                        HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord record7 = reader.readInstanceDumpRecord();
                        OnHprofRecordListener.this.onHprofRecord(recordPosition22, record7);
                        return;
                    case 23:
                        long recordPosition23 = reader.getBytesRead();
                        HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord arrayRecord = reader.readObjectArrayDumpRecord();
                        OnHprofRecordListener.this.onHprofRecord(recordPosition23, arrayRecord);
                        return;
                    case 24:
                        long recordPosition24 = reader.getBytesRead();
                        HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord record8 = reader.readPrimitiveArrayDumpRecord();
                        OnHprofRecordListener.this.onHprofRecord(recordPosition24, record8);
                        return;
                    case BR.avatarList /* 25 */:
                        long recordPosition25 = reader.getBytesRead();
                        HprofRecord.HeapDumpRecord.HeapDumpInfoRecord record9 = reader.readHeapDumpInfoRecord();
                        OnHprofRecordListener.this.onHprofRecord(recordPosition25, record9);
                        return;
                    case BR.avatarListVisible /* 26 */:
                        long recordPosition26 = reader.getBytesRead();
                        HprofRecord.HeapDumpEndRecord record10 = HprofRecord.HeapDumpEndRecord.INSTANCE;
                        OnHprofRecordListener.this.onHprofRecord(recordPosition26, record10);
                        return;
                    default:
                        throw new IllegalStateException(("Unexpected heap dump tag " + tag + " at position " + reader.getBytesRead()).toString());
                }
            }
        });
    }

    /* compiled from: StreamingRecordReaderAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00070\u0006J\n\u0010\t\u001a\u00020\n*\u00020\u000b¨\u0006\f"}, d2 = {"Lshark/StreamingRecordReaderAdapter$Companion;", "", "()V", "asHprofTags", "Ljava/util/EnumSet;", "Lshark/HprofRecordTag;", "", "Lkotlin/reflect/KClass;", "Lshark/HprofRecord;", "asStreamingRecordReader", "Lshark/StreamingRecordReaderAdapter;", "Lshark/StreamingHprofReader;", "shark-hprof"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final StreamingRecordReaderAdapter asStreamingRecordReader(StreamingHprofReader $this$asStreamingRecordReader) {
            Intrinsics.checkParameterIsNotNull($this$asStreamingRecordReader, "$this$asStreamingRecordReader");
            return new StreamingRecordReaderAdapter($this$asStreamingRecordReader);
        }

        public final EnumSet<HprofRecordTag> asHprofTags(Set<? extends KClass<? extends HprofRecord>> set) {
            Intrinsics.checkParameterIsNotNull(set, "$this$asHprofTags");
            if (set.contains(Reflection.getOrCreateKotlinClass(HprofRecord.class))) {
                EnumSet<HprofRecordTag> allOf = EnumSet.allOf(HprofRecordTag.class);
                Intrinsics.checkExpressionValueIsNotNull(allOf, "EnumSet.allOf(HprofRecordTag::class.java)");
                return allOf;
            }
            EnumSet $this$apply = EnumSet.noneOf(HprofRecordTag.class);
            if (set.contains(Reflection.getOrCreateKotlinClass(HprofRecord.StringRecord.class))) {
                $this$apply.add(HprofRecordTag.STRING_IN_UTF8);
            }
            if (set.contains(Reflection.getOrCreateKotlinClass(HprofRecord.LoadClassRecord.class))) {
                $this$apply.add(HprofRecordTag.LOAD_CLASS);
            }
            if (set.contains(Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpEndRecord.class))) {
                $this$apply.add(HprofRecordTag.HEAP_DUMP_END);
            }
            if (set.contains(Reflection.getOrCreateKotlinClass(HprofRecord.StackFrameRecord.class))) {
                $this$apply.add(HprofRecordTag.STACK_FRAME);
            }
            if (set.contains(Reflection.getOrCreateKotlinClass(HprofRecord.StackTraceRecord.class))) {
                $this$apply.add(HprofRecordTag.STACK_TRACE);
            }
            if (set.contains(Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.HeapDumpInfoRecord.class))) {
                $this$apply.add(HprofRecordTag.HEAP_DUMP_INFO);
            }
            boolean readAllHeapDumpRecords = set.contains(Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.class));
            if (readAllHeapDumpRecords || set.contains(Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.GcRootRecord.class))) {
                $this$apply.addAll(HprofRecordTag.Companion.getRootTags());
            }
            boolean readAllObjectRecords = readAllHeapDumpRecords || set.contains(Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.ObjectRecord.class));
            if (readAllObjectRecords || set.contains(Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.class))) {
                $this$apply.add(HprofRecordTag.CLASS_DUMP);
            }
            if (readAllObjectRecords || set.contains(Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord.class))) {
                $this$apply.add(HprofRecordTag.INSTANCE_DUMP);
            }
            if (readAllObjectRecords || set.contains(Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord.class))) {
                $this$apply.add(HprofRecordTag.OBJECT_ARRAY_DUMP);
            }
            if (readAllObjectRecords || set.contains(Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.class))) {
                $this$apply.add(HprofRecordTag.PRIMITIVE_ARRAY_DUMP);
            }
            Intrinsics.checkExpressionValueIsNotNull($this$apply, "EnumSet.noneOf(HprofReco…MP)\n          }\n        }");
            return $this$apply;
        }
    }
}