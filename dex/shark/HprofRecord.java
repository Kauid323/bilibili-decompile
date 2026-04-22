package shark;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HprofRecord.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0082\u0001\u0006\t\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lshark/HprofRecord;", "", "()V", "HeapDumpEndRecord", "HeapDumpRecord", "LoadClassRecord", "StackFrameRecord", "StackTraceRecord", "StringRecord", "Lshark/HprofRecord$StringRecord;", "Lshark/HprofRecord$LoadClassRecord;", "Lshark/HprofRecord$HeapDumpEndRecord;", "Lshark/HprofRecord$StackFrameRecord;", "Lshark/HprofRecord$StackTraceRecord;", "Lshark/HprofRecord$HeapDumpRecord;", "shark-hprof"}, k = 1, mv = {1, 4, 1})
public abstract class HprofRecord {

    /* compiled from: HprofRecord.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lshark/HprofRecord$StringRecord;", "Lshark/HprofRecord;", "id", "", "string", "", "(JLjava/lang/String;)V", "getId", "()J", "getString", "()Ljava/lang/String;", "shark-hprof"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class StringRecord extends HprofRecord {
        private final long id;
        private final String string;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StringRecord(long id, String string) {
            super(null);
            Intrinsics.checkParameterIsNotNull(string, "string");
            this.id = id;
            this.string = string;
        }

        public final long getId() {
            return this.id;
        }

        public final String getString() {
            return this.string;
        }
    }

    private HprofRecord() {
    }

    public /* synthetic */ HprofRecord(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    /* compiled from: HprofRecord.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lshark/HprofRecord$LoadClassRecord;", "Lshark/HprofRecord;", "classSerialNumber", "", "id", "", "stackTraceSerialNumber", "classNameStringId", "(IJIJ)V", "getClassNameStringId", "()J", "getClassSerialNumber", "()I", "getId", "getStackTraceSerialNumber", "shark-hprof"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class LoadClassRecord extends HprofRecord {
        private final long classNameStringId;
        private final int classSerialNumber;
        private final long id;
        private final int stackTraceSerialNumber;

        public LoadClassRecord(int classSerialNumber, long id, int stackTraceSerialNumber, long classNameStringId) {
            super(null);
            this.classSerialNumber = classSerialNumber;
            this.id = id;
            this.stackTraceSerialNumber = stackTraceSerialNumber;
            this.classNameStringId = classNameStringId;
        }

        public final int getClassSerialNumber() {
            return this.classSerialNumber;
        }

        public final long getId() {
            return this.id;
        }

        public final int getStackTraceSerialNumber() {
            return this.stackTraceSerialNumber;
        }

        public final long getClassNameStringId() {
            return this.classNameStringId;
        }
    }

    /* compiled from: HprofRecord.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lshark/HprofRecord$HeapDumpEndRecord;", "Lshark/HprofRecord;", "()V", "shark-hprof"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class HeapDumpEndRecord extends HprofRecord {
        public static final HeapDumpEndRecord INSTANCE = new HeapDumpEndRecord();

        private HeapDumpEndRecord() {
            super(null);
        }
    }

    /* compiled from: HprofRecord.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u0013"}, d2 = {"Lshark/HprofRecord$StackFrameRecord;", "Lshark/HprofRecord;", "id", "", "methodNameStringId", "methodSignatureStringId", "sourceFileNameStringId", "classSerialNumber", "", "lineNumber", "(JJJJII)V", "getClassSerialNumber", "()I", "getId", "()J", "getLineNumber", "getMethodNameStringId", "getMethodSignatureStringId", "getSourceFileNameStringId", "shark-hprof"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class StackFrameRecord extends HprofRecord {
        private final int classSerialNumber;
        private final long id;
        private final int lineNumber;
        private final long methodNameStringId;
        private final long methodSignatureStringId;
        private final long sourceFileNameStringId;

        public StackFrameRecord(long id, long methodNameStringId, long methodSignatureStringId, long sourceFileNameStringId, int classSerialNumber, int lineNumber) {
            super(null);
            this.id = id;
            this.methodNameStringId = methodNameStringId;
            this.methodSignatureStringId = methodSignatureStringId;
            this.sourceFileNameStringId = sourceFileNameStringId;
            this.classSerialNumber = classSerialNumber;
            this.lineNumber = lineNumber;
        }

        public final long getId() {
            return this.id;
        }

        public final long getMethodNameStringId() {
            return this.methodNameStringId;
        }

        public final long getMethodSignatureStringId() {
            return this.methodSignatureStringId;
        }

        public final long getSourceFileNameStringId() {
            return this.sourceFileNameStringId;
        }

        public final int getClassSerialNumber() {
            return this.classSerialNumber;
        }

        public final int getLineNumber() {
            return this.lineNumber;
        }
    }

    /* compiled from: HprofRecord.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"Lshark/HprofRecord$StackTraceRecord;", "Lshark/HprofRecord;", "stackTraceSerialNumber", "", "threadSerialNumber", "stackFrameIds", "", "(II[J)V", "getStackFrameIds", "()[J", "getStackTraceSerialNumber", "()I", "getThreadSerialNumber", "shark-hprof"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class StackTraceRecord extends HprofRecord {
        private final long[] stackFrameIds;
        private final int stackTraceSerialNumber;
        private final int threadSerialNumber;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StackTraceRecord(int stackTraceSerialNumber, int threadSerialNumber, long[] stackFrameIds) {
            super(null);
            Intrinsics.checkParameterIsNotNull(stackFrameIds, "stackFrameIds");
            this.stackTraceSerialNumber = stackTraceSerialNumber;
            this.threadSerialNumber = threadSerialNumber;
            this.stackFrameIds = stackFrameIds;
        }

        public final int getStackTraceSerialNumber() {
            return this.stackTraceSerialNumber;
        }

        public final int getThreadSerialNumber() {
            return this.threadSerialNumber;
        }

        public final long[] getStackFrameIds() {
            return this.stackFrameIds;
        }
    }

    /* compiled from: HprofRecord.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lshark/HprofRecord$HeapDumpRecord;", "Lshark/HprofRecord;", "()V", "GcRootRecord", "HeapDumpInfoRecord", "ObjectRecord", "Lshark/HprofRecord$HeapDumpRecord$GcRootRecord;", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord;", "Lshark/HprofRecord$HeapDumpRecord$HeapDumpInfoRecord;", "shark-hprof"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static abstract class HeapDumpRecord extends HprofRecord {

        /* compiled from: HprofRecord.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lshark/HprofRecord$HeapDumpRecord$GcRootRecord;", "Lshark/HprofRecord$HeapDumpRecord;", "gcRoot", "Lshark/GcRoot;", "(Lshark/GcRoot;)V", "getGcRoot", "()Lshark/GcRoot;", "shark-hprof"}, k = 1, mv = {1, 4, 1})
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class GcRootRecord extends HeapDumpRecord {
            private final GcRoot gcRoot;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public GcRootRecord(GcRoot gcRoot) {
                super(null);
                Intrinsics.checkParameterIsNotNull(gcRoot, "gcRoot");
                this.gcRoot = gcRoot;
            }

            public final GcRoot getGcRoot() {
                return this.gcRoot;
            }
        }

        private HeapDumpRecord() {
            super(null);
        }

        public /* synthetic */ HeapDumpRecord(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        /* compiled from: HprofRecord.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lshark/HprofRecord$HeapDumpRecord$ObjectRecord;", "Lshark/HprofRecord$HeapDumpRecord;", "()V", "ClassDumpRecord", "InstanceDumpRecord", "ObjectArrayDumpRecord", "PrimitiveArrayDumpRecord", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord;", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ObjectArrayDumpRecord;", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "shark-hprof"}, k = 1, mv = {1, 4, 1})
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static abstract class ObjectRecord extends HeapDumpRecord {

            /* compiled from: HprofRecord.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0002\u001d\u001eBY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012¨\u0006\u001f"}, d2 = {"Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord;", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord;", "id", "", "stackTraceSerialNumber", "", "superclassId", "classLoaderId", "signersId", "protectionDomainId", "instanceSize", "staticFields", "", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$StaticFieldRecord;", "fields", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$FieldRecord;", "(JIJJJJILjava/util/List;Ljava/util/List;)V", "getClassLoaderId", "()J", "getFields", "()Ljava/util/List;", "getId", "getInstanceSize", "()I", "getProtectionDomainId", "getSignersId", "getStackTraceSerialNumber", "getStaticFields", "getSuperclassId", "FieldRecord", "StaticFieldRecord", "shark-hprof"}, k = 1, mv = {1, 4, 1})
            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
            public static final class ClassDumpRecord extends ObjectRecord {
                private final long classLoaderId;
                private final List<FieldRecord> fields;
                private final long id;
                private final int instanceSize;
                private final long protectionDomainId;
                private final long signersId;
                private final int stackTraceSerialNumber;
                private final List<StaticFieldRecord> staticFields;
                private final long superclassId;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public ClassDumpRecord(long id, int stackTraceSerialNumber, long superclassId, long classLoaderId, long signersId, long protectionDomainId, int instanceSize, List<StaticFieldRecord> list, List<FieldRecord> list2) {
                    super(null);
                    Intrinsics.checkParameterIsNotNull(list, "staticFields");
                    Intrinsics.checkParameterIsNotNull(list2, "fields");
                    this.id = id;
                    this.stackTraceSerialNumber = stackTraceSerialNumber;
                    this.superclassId = superclassId;
                    this.classLoaderId = classLoaderId;
                    this.signersId = signersId;
                    this.protectionDomainId = protectionDomainId;
                    this.instanceSize = instanceSize;
                    this.staticFields = list;
                    this.fields = list2;
                }

                public final long getId() {
                    return this.id;
                }

                public final int getStackTraceSerialNumber() {
                    return this.stackTraceSerialNumber;
                }

                public final long getSuperclassId() {
                    return this.superclassId;
                }

                public final long getClassLoaderId() {
                    return this.classLoaderId;
                }

                public final long getSignersId() {
                    return this.signersId;
                }

                public final long getProtectionDomainId() {
                    return this.protectionDomainId;
                }

                public final int getInstanceSize() {
                    return this.instanceSize;
                }

                public final List<StaticFieldRecord> getStaticFields() {
                    return this.staticFields;
                }

                public final List<FieldRecord> getFields() {
                    return this.fields;
                }

                /* compiled from: HprofRecord.kt */
                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$StaticFieldRecord;", "", "nameStringId", "", "type", "", "value", "Lshark/ValueHolder;", "(JILshark/ValueHolder;)V", "getNameStringId", "()J", "getType", "()I", "getValue", "()Lshark/ValueHolder;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "shark-hprof"}, k = 1, mv = {1, 4, 1})
                /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                public static final class StaticFieldRecord {
                    private final long nameStringId;
                    private final int type;
                    private final ValueHolder value;

                    public static /* synthetic */ StaticFieldRecord copy$default(StaticFieldRecord staticFieldRecord, long j, int i, ValueHolder valueHolder, int i2, Object obj) {
                        if ((i2 & 1) != 0) {
                            j = staticFieldRecord.nameStringId;
                        }
                        if ((i2 & 2) != 0) {
                            i = staticFieldRecord.type;
                        }
                        if ((i2 & 4) != 0) {
                            valueHolder = staticFieldRecord.value;
                        }
                        return staticFieldRecord.copy(j, i, valueHolder);
                    }

                    public final long component1() {
                        return this.nameStringId;
                    }

                    public final int component2() {
                        return this.type;
                    }

                    public final ValueHolder component3() {
                        return this.value;
                    }

                    public final StaticFieldRecord copy(long j, int i, ValueHolder valueHolder) {
                        Intrinsics.checkParameterIsNotNull(valueHolder, "value");
                        return new StaticFieldRecord(j, i, valueHolder);
                    }

                    public boolean equals(Object obj) {
                        if (this != obj) {
                            if (obj instanceof StaticFieldRecord) {
                                StaticFieldRecord staticFieldRecord = (StaticFieldRecord) obj;
                                return this.nameStringId == staticFieldRecord.nameStringId && this.type == staticFieldRecord.type && Intrinsics.areEqual(this.value, staticFieldRecord.value);
                            }
                            return false;
                        }
                        return true;
                    }

                    public int hashCode() {
                        long j = this.nameStringId;
                        int i = ((((int) (j ^ (j >>> 32))) * 31) + this.type) * 31;
                        ValueHolder valueHolder = this.value;
                        return i + (valueHolder != null ? valueHolder.hashCode() : 0);
                    }

                    public String toString() {
                        return "StaticFieldRecord(nameStringId=" + this.nameStringId + ", type=" + this.type + ", value=" + this.value + ")";
                    }

                    public StaticFieldRecord(long nameStringId, int type, ValueHolder value) {
                        Intrinsics.checkParameterIsNotNull(value, "value");
                        this.nameStringId = nameStringId;
                        this.type = type;
                        this.value = value;
                    }

                    public final long getNameStringId() {
                        return this.nameStringId;
                    }

                    public final int getType() {
                        return this.type;
                    }

                    public final ValueHolder getValue() {
                        return this.value;
                    }
                }

                /* compiled from: HprofRecord.kt */
                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$FieldRecord;", "", "nameStringId", "", "type", "", "(JI)V", "getNameStringId", "()J", "getType", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "shark-hprof"}, k = 1, mv = {1, 4, 1})
                /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                public static final class FieldRecord {
                    private final long nameStringId;
                    private final int type;

                    public static /* synthetic */ FieldRecord copy$default(FieldRecord fieldRecord, long j, int i, int i2, Object obj) {
                        if ((i2 & 1) != 0) {
                            j = fieldRecord.nameStringId;
                        }
                        if ((i2 & 2) != 0) {
                            i = fieldRecord.type;
                        }
                        return fieldRecord.copy(j, i);
                    }

                    public final long component1() {
                        return this.nameStringId;
                    }

                    public final int component2() {
                        return this.type;
                    }

                    public final FieldRecord copy(long j, int i) {
                        return new FieldRecord(j, i);
                    }

                    public boolean equals(Object obj) {
                        if (this != obj) {
                            if (obj instanceof FieldRecord) {
                                FieldRecord fieldRecord = (FieldRecord) obj;
                                return this.nameStringId == fieldRecord.nameStringId && this.type == fieldRecord.type;
                            }
                            return false;
                        }
                        return true;
                    }

                    public int hashCode() {
                        long j = this.nameStringId;
                        return (((int) (j ^ (j >>> 32))) * 31) + this.type;
                    }

                    public String toString() {
                        return "FieldRecord(nameStringId=" + this.nameStringId + ", type=" + this.type + ")";
                    }

                    public FieldRecord(long nameStringId, int type) {
                        this.nameStringId = nameStringId;
                        this.type = type;
                    }

                    public final long getNameStringId() {
                        return this.nameStringId;
                    }

                    public final int getType() {
                        return this.type;
                    }
                }
            }

            private ObjectRecord() {
                super(null);
            }

            public /* synthetic */ ObjectRecord(DefaultConstructorMarker $constructor_marker) {
                this();
            }

            /* compiled from: HprofRecord.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord;", "id", "", "stackTraceSerialNumber", "", "classId", "fieldValues", "", "(JIJ[B)V", "getClassId", "()J", "getFieldValues", "()[B", "getId", "getStackTraceSerialNumber", "()I", "shark-hprof"}, k = 1, mv = {1, 4, 1})
            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
            public static final class InstanceDumpRecord extends ObjectRecord {
                private final long classId;
                private final byte[] fieldValues;
                private final long id;
                private final int stackTraceSerialNumber;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public InstanceDumpRecord(long id, int stackTraceSerialNumber, long classId, byte[] fieldValues) {
                    super(null);
                    Intrinsics.checkParameterIsNotNull(fieldValues, "fieldValues");
                    this.id = id;
                    this.stackTraceSerialNumber = stackTraceSerialNumber;
                    this.classId = classId;
                    this.fieldValues = fieldValues;
                }

                public final long getId() {
                    return this.id;
                }

                public final int getStackTraceSerialNumber() {
                    return this.stackTraceSerialNumber;
                }

                public final long getClassId() {
                    return this.classId;
                }

                public final byte[] getFieldValues() {
                    return this.fieldValues;
                }
            }

            /* compiled from: HprofRecord.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ObjectArrayDumpRecord;", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord;", "id", "", "stackTraceSerialNumber", "", "arrayClassId", "elementIds", "", "(JIJ[J)V", "getArrayClassId", "()J", "getElementIds", "()[J", "getId", "getStackTraceSerialNumber", "()I", "shark-hprof"}, k = 1, mv = {1, 4, 1})
            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
            public static final class ObjectArrayDumpRecord extends ObjectRecord {
                private final long arrayClassId;
                private final long[] elementIds;
                private final long id;
                private final int stackTraceSerialNumber;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public ObjectArrayDumpRecord(long id, int stackTraceSerialNumber, long arrayClassId, long[] elementIds) {
                    super(null);
                    Intrinsics.checkParameterIsNotNull(elementIds, "elementIds");
                    this.id = id;
                    this.stackTraceSerialNumber = stackTraceSerialNumber;
                    this.arrayClassId = arrayClassId;
                    this.elementIds = elementIds;
                }

                public final long getId() {
                    return this.id;
                }

                public final int getStackTraceSerialNumber() {
                    return this.stackTraceSerialNumber;
                }

                public final long getArrayClassId() {
                    return this.arrayClassId;
                }

                public final long[] getElementIds() {
                    return this.elementIds;
                }
            }

            /* compiled from: HprofRecord.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\n\u0082\u0001\b\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c¨\u0006\u001d"}, d2 = {"Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord;", "()V", "id", "", "getId", "()J", "size", "", "getSize", "()I", "stackTraceSerialNumber", "getStackTraceSerialNumber", "BooleanArrayDump", "ByteArrayDump", "CharArrayDump", "DoubleArrayDump", "FloatArrayDump", "IntArrayDump", "LongArrayDump", "ShortArrayDump", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$BooleanArrayDump;", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$CharArrayDump;", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$FloatArrayDump;", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$DoubleArrayDump;", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$ByteArrayDump;", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$ShortArrayDump;", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$IntArrayDump;", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$LongArrayDump;", "shark-hprof"}, k = 1, mv = {1, 4, 1})
            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
            public static abstract class PrimitiveArrayDumpRecord extends ObjectRecord {
                public abstract long getId();

                public abstract int getSize();

                public abstract int getStackTraceSerialNumber();

                private PrimitiveArrayDumpRecord() {
                    super(null);
                }

                public /* synthetic */ PrimitiveArrayDumpRecord(DefaultConstructorMarker $constructor_marker) {
                    this();
                }

                /* compiled from: HprofRecord.kt */
                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0018\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$BooleanArrayDump;", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "id", "", "stackTraceSerialNumber", "", "array", "", "(JI[Z)V", "getArray", "()[Z", "getId", "()J", "size", "getSize", "()I", "getStackTraceSerialNumber", "shark-hprof"}, k = 1, mv = {1, 4, 1})
                /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                public static final class BooleanArrayDump extends PrimitiveArrayDumpRecord {
                    private final boolean[] array;
                    private final long id;
                    private final int stackTraceSerialNumber;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public BooleanArrayDump(long id, int stackTraceSerialNumber, boolean[] array) {
                        super(null);
                        Intrinsics.checkParameterIsNotNull(array, "array");
                        this.id = id;
                        this.stackTraceSerialNumber = stackTraceSerialNumber;
                        this.array = array;
                    }

                    @Override // shark.HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord
                    public long getId() {
                        return this.id;
                    }

                    @Override // shark.HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord
                    public int getStackTraceSerialNumber() {
                        return this.stackTraceSerialNumber;
                    }

                    public final boolean[] getArray() {
                        return this.array;
                    }

                    @Override // shark.HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord
                    public int getSize() {
                        return this.array.length;
                    }
                }

                /* compiled from: HprofRecord.kt */
                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0019\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$CharArrayDump;", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "id", "", "stackTraceSerialNumber", "", "array", "", "(JI[C)V", "getArray", "()[C", "getId", "()J", "size", "getSize", "()I", "getStackTraceSerialNumber", "shark-hprof"}, k = 1, mv = {1, 4, 1})
                /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                public static final class CharArrayDump extends PrimitiveArrayDumpRecord {
                    private final char[] array;
                    private final long id;
                    private final int stackTraceSerialNumber;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public CharArrayDump(long id, int stackTraceSerialNumber, char[] array) {
                        super(null);
                        Intrinsics.checkParameterIsNotNull(array, "array");
                        this.id = id;
                        this.stackTraceSerialNumber = stackTraceSerialNumber;
                        this.array = array;
                    }

                    @Override // shark.HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord
                    public long getId() {
                        return this.id;
                    }

                    @Override // shark.HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord
                    public int getStackTraceSerialNumber() {
                        return this.stackTraceSerialNumber;
                    }

                    public final char[] getArray() {
                        return this.array;
                    }

                    @Override // shark.HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord
                    public int getSize() {
                        return this.array.length;
                    }
                }

                /* compiled from: HprofRecord.kt */
                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$FloatArrayDump;", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "id", "", "stackTraceSerialNumber", "", "array", "", "(JI[F)V", "getArray", "()[F", "getId", "()J", "size", "getSize", "()I", "getStackTraceSerialNumber", "shark-hprof"}, k = 1, mv = {1, 4, 1})
                /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                public static final class FloatArrayDump extends PrimitiveArrayDumpRecord {
                    private final float[] array;
                    private final long id;
                    private final int stackTraceSerialNumber;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public FloatArrayDump(long id, int stackTraceSerialNumber, float[] array) {
                        super(null);
                        Intrinsics.checkParameterIsNotNull(array, "array");
                        this.id = id;
                        this.stackTraceSerialNumber = stackTraceSerialNumber;
                        this.array = array;
                    }

                    @Override // shark.HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord
                    public long getId() {
                        return this.id;
                    }

                    @Override // shark.HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord
                    public int getStackTraceSerialNumber() {
                        return this.stackTraceSerialNumber;
                    }

                    public final float[] getArray() {
                        return this.array;
                    }

                    @Override // shark.HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord
                    public int getSize() {
                        return this.array.length;
                    }
                }

                /* compiled from: HprofRecord.kt */
                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0013\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$DoubleArrayDump;", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "id", "", "stackTraceSerialNumber", "", "array", "", "(JI[D)V", "getArray", "()[D", "getId", "()J", "size", "getSize", "()I", "getStackTraceSerialNumber", "shark-hprof"}, k = 1, mv = {1, 4, 1})
                /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                public static final class DoubleArrayDump extends PrimitiveArrayDumpRecord {
                    private final double[] array;
                    private final long id;
                    private final int stackTraceSerialNumber;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public DoubleArrayDump(long id, int stackTraceSerialNumber, double[] array) {
                        super(null);
                        Intrinsics.checkParameterIsNotNull(array, "array");
                        this.id = id;
                        this.stackTraceSerialNumber = stackTraceSerialNumber;
                        this.array = array;
                    }

                    @Override // shark.HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord
                    public long getId() {
                        return this.id;
                    }

                    @Override // shark.HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord
                    public int getStackTraceSerialNumber() {
                        return this.stackTraceSerialNumber;
                    }

                    public final double[] getArray() {
                        return this.array;
                    }

                    @Override // shark.HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord
                    public int getSize() {
                        return this.array.length;
                    }
                }

                /* compiled from: HprofRecord.kt */
                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$ByteArrayDump;", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "id", "", "stackTraceSerialNumber", "", "array", "", "(JI[B)V", "getArray", "()[B", "getId", "()J", "size", "getSize", "()I", "getStackTraceSerialNumber", "shark-hprof"}, k = 1, mv = {1, 4, 1})
                /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                public static final class ByteArrayDump extends PrimitiveArrayDumpRecord {
                    private final byte[] array;
                    private final long id;
                    private final int stackTraceSerialNumber;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public ByteArrayDump(long id, int stackTraceSerialNumber, byte[] array) {
                        super(null);
                        Intrinsics.checkParameterIsNotNull(array, "array");
                        this.id = id;
                        this.stackTraceSerialNumber = stackTraceSerialNumber;
                        this.array = array;
                    }

                    @Override // shark.HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord
                    public long getId() {
                        return this.id;
                    }

                    @Override // shark.HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord
                    public int getStackTraceSerialNumber() {
                        return this.stackTraceSerialNumber;
                    }

                    public final byte[] getArray() {
                        return this.array;
                    }

                    @Override // shark.HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord
                    public int getSize() {
                        return this.array.length;
                    }
                }

                /* compiled from: HprofRecord.kt */
                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0017\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$ShortArrayDump;", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "id", "", "stackTraceSerialNumber", "", "array", "", "(JI[S)V", "getArray", "()[S", "getId", "()J", "size", "getSize", "()I", "getStackTraceSerialNumber", "shark-hprof"}, k = 1, mv = {1, 4, 1})
                /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                public static final class ShortArrayDump extends PrimitiveArrayDumpRecord {
                    private final short[] array;
                    private final long id;
                    private final int stackTraceSerialNumber;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public ShortArrayDump(long id, int stackTraceSerialNumber, short[] array) {
                        super(null);
                        Intrinsics.checkParameterIsNotNull(array, "array");
                        this.id = id;
                        this.stackTraceSerialNumber = stackTraceSerialNumber;
                        this.array = array;
                    }

                    @Override // shark.HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord
                    public long getId() {
                        return this.id;
                    }

                    @Override // shark.HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord
                    public int getStackTraceSerialNumber() {
                        return this.stackTraceSerialNumber;
                    }

                    public final short[] getArray() {
                        return this.array;
                    }

                    @Override // shark.HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord
                    public int getSize() {
                        return this.array.length;
                    }
                }

                /* compiled from: HprofRecord.kt */
                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$IntArrayDump;", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "id", "", "stackTraceSerialNumber", "", "array", "", "(JI[I)V", "getArray", "()[I", "getId", "()J", "size", "getSize", "()I", "getStackTraceSerialNumber", "shark-hprof"}, k = 1, mv = {1, 4, 1})
                /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                public static final class IntArrayDump extends PrimitiveArrayDumpRecord {
                    private final int[] array;
                    private final long id;
                    private final int stackTraceSerialNumber;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public IntArrayDump(long id, int stackTraceSerialNumber, int[] array) {
                        super(null);
                        Intrinsics.checkParameterIsNotNull(array, "array");
                        this.id = id;
                        this.stackTraceSerialNumber = stackTraceSerialNumber;
                        this.array = array;
                    }

                    @Override // shark.HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord
                    public long getId() {
                        return this.id;
                    }

                    @Override // shark.HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord
                    public int getStackTraceSerialNumber() {
                        return this.stackTraceSerialNumber;
                    }

                    public final int[] getArray() {
                        return this.array;
                    }

                    @Override // shark.HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord
                    public int getSize() {
                        return this.array.length;
                    }
                }

                /* compiled from: HprofRecord.kt */
                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$LongArrayDump;", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "id", "", "stackTraceSerialNumber", "", "array", "", "(JI[J)V", "getArray", "()[J", "getId", "()J", "size", "getSize", "()I", "getStackTraceSerialNumber", "shark-hprof"}, k = 1, mv = {1, 4, 1})
                /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                public static final class LongArrayDump extends PrimitiveArrayDumpRecord {
                    private final long[] array;
                    private final long id;
                    private final int stackTraceSerialNumber;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public LongArrayDump(long id, int stackTraceSerialNumber, long[] array) {
                        super(null);
                        Intrinsics.checkParameterIsNotNull(array, "array");
                        this.id = id;
                        this.stackTraceSerialNumber = stackTraceSerialNumber;
                        this.array = array;
                    }

                    @Override // shark.HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord
                    public long getId() {
                        return this.id;
                    }

                    @Override // shark.HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord
                    public int getStackTraceSerialNumber() {
                        return this.stackTraceSerialNumber;
                    }

                    public final long[] getArray() {
                        return this.array;
                    }

                    @Override // shark.HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord
                    public int getSize() {
                        return this.array.length;
                    }
                }
            }
        }

        /* compiled from: HprofRecord.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lshark/HprofRecord$HeapDumpRecord$HeapDumpInfoRecord;", "Lshark/HprofRecord$HeapDumpRecord;", "heapId", "", "heapNameStringId", "", "(IJ)V", "getHeapId", "()I", "getHeapNameStringId", "()J", "shark-hprof"}, k = 1, mv = {1, 4, 1})
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class HeapDumpInfoRecord extends HeapDumpRecord {
            private final int heapId;
            private final long heapNameStringId;

            public HeapDumpInfoRecord(int heapId, long heapNameStringId) {
                super(null);
                this.heapId = heapId;
                this.heapNameStringId = heapNameStringId;
            }

            public final int getHeapId() {
                return this.heapId;
            }

            public final long getHeapNameStringId() {
                return this.heapNameStringId;
            }
        }
    }
}