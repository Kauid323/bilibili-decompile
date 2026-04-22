package shark;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okio.BufferedSource;
import shark.GcRoot;
import shark.HprofRecord;
import shark.ValueHolder;

/* compiled from: HprofRecordReader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¼\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u0000 |2\u00020\u0001:\u0001|B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rJ\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\rJ\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\rJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020\rJ\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020)J\u000e\u0010*\u001a\u00020+2\u0006\u0010\u0014\u001a\u00020\rJ\u0006\u0010,\u001a\u00020-J\u0006\u0010.\u001a\u00020\bJ\u000e\u0010/\u001a\u0002002\u0006\u0010\u0014\u001a\u00020\rJ\u0006\u00101\u001a\u000202J\u0006\u00103\u001a\u00020\rJ\u000e\u00104\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\rJ\u0006\u00105\u001a\u000206J\u0006\u00107\u001a\u000208J\u0006\u00109\u001a\u00020:J\u0006\u0010;\u001a\u00020<J\u0006\u0010=\u001a\u00020>J\u0006\u0010?\u001a\u00020@J\u0006\u0010A\u001a\u00020\bJ\u000e\u0010B\u001a\u0002002\u0006\u0010\u0014\u001a\u00020\rJ\u0006\u0010C\u001a\u00020DJ\u0006\u0010E\u001a\u00020FJ\u0006\u0010G\u001a\u00020HJ\u0006\u0010I\u001a\u00020JJ\u0006\u0010K\u001a\u00020LJ\u0006\u0010M\u001a\u00020NJ\u000e\u0010O\u001a\u00020P2\u0006\u0010\u0014\u001a\u00020\rJ\u0006\u0010Q\u001a\u00020RJ\u0006\u0010S\u001a\u00020TJ\u0006\u0010U\u001a\u00020VJ\u0016\u0010W\u001a\u00020X2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010Y\u001a\u00020ZJ\u000e\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020\bJ\u0006\u0010^\u001a\u00020_J\u0006\u0010`\u001a\u00020aJ\u0006\u0010b\u001a\u00020cJ\u0006\u0010d\u001a\u00020eJ\u0006\u0010f\u001a\u00020\rJ\u0006\u0010g\u001a\u00020\bJ\u0006\u0010h\u001a\u00020\rJ\u000e\u0010i\u001a\u00020X2\u0006\u0010\u0019\u001a\u00020\bJ\u000e\u0010j\u001a\u00020k2\u0006\u0010l\u001a\u00020\rJ\u0006\u0010m\u001a\u00020nJ\u000e\u0010o\u001a\u00020\r2\u0006\u0010l\u001a\u00020\rJ\u000e\u0010p\u001a\u00020q2\u0006\u0010\u0019\u001a\u00020\rJ\u000e\u0010p\u001a\u00020q2\u0006\u0010\u0019\u001a\u00020\bJ\u0006\u0010r\u001a\u00020qJ\u0006\u0010s\u001a\u00020qJ\u0006\u0010t\u001a\u00020qJ\u0006\u0010u\u001a\u00020qJ\u0006\u0010v\u001a\u00020qJ\u0006\u0010w\u001a\u00020qJ\u0006\u0010x\u001a\u00020qJ\u0006\u0010y\u001a\u00020qJ\u0006\u0010z\u001a\u00020qJ\u0006\u0010{\u001a\u00020qR\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006}"}, d2 = {"Lshark/HprofRecordReader;", "", "header", "Lshark/HprofHeader;", "source", "Lokio/BufferedSource;", "(Lshark/HprofHeader;Lokio/BufferedSource;)V", "<set-?>", "", "bytesRead", "getBytesRead", "()J", "identifierByteSize", "", "typeSizes", "", "readBoolean", "", "readBooleanArray", "", "arrayLength", "readByte", "", "readByteArray", "", "byteCount", "readChar", "", "readCharArray", "", "readClassDumpRecord", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord;", "readDebuggerGcRootRecord", "Lshark/GcRoot$Debugger;", "readDouble", "", "readDoubleArray", "", "readFinalizingGcRootRecord", "Lshark/GcRoot$Finalizing;", "readFloat", "", "readFloatArray", "", "readHeapDumpInfoRecord", "Lshark/HprofRecord$HeapDumpRecord$HeapDumpInfoRecord;", "readId", "readIdArray", "", "readInstanceDumpRecord", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;", "readInt", "readIntArray", "readInternedStringGcRootRecord", "Lshark/GcRoot$InternedString;", "readJavaFrameGcRootRecord", "Lshark/GcRoot$JavaFrame;", "readJniGlobalGcRootRecord", "Lshark/GcRoot$JniGlobal;", "readJniLocalGcRootRecord", "Lshark/GcRoot$JniLocal;", "readJniMonitorGcRootRecord", "Lshark/GcRoot$JniMonitor;", "readLoadClassRecord", "Lshark/HprofRecord$LoadClassRecord;", "readLong", "readLongArray", "readMonitorUsedGcRootRecord", "Lshark/GcRoot$MonitorUsed;", "readNativeStackGcRootRecord", "Lshark/GcRoot$NativeStack;", "readObjectArrayDumpRecord", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ObjectArrayDumpRecord;", "readPrimitiveArrayDumpRecord", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "readReferenceCleanupGcRootRecord", "Lshark/GcRoot$ReferenceCleanup;", "readShort", "", "readShortArray", "", "readStackFrameRecord", "Lshark/HprofRecord$StackFrameRecord;", "readStackTraceRecord", "Lshark/HprofRecord$StackTraceRecord;", "readStickyClassGcRootRecord", "Lshark/GcRoot$StickyClass;", "readString", "", "charset", "Ljava/nio/charset/Charset;", "readStringRecord", "Lshark/HprofRecord$StringRecord;", "length", "readThreadBlockGcRootRecord", "Lshark/GcRoot$ThreadBlock;", "readThreadObjectGcRootRecord", "Lshark/GcRoot$ThreadObject;", "readUnknownGcRootRecord", "Lshark/GcRoot$Unknown;", "readUnreachableGcRootRecord", "Lshark/GcRoot$Unreachable;", "readUnsignedByte", "readUnsignedInt", "readUnsignedShort", "readUtf8", "readValue", "Lshark/ValueHolder;", "type", "readVmInternalGcRootRecord", "Lshark/GcRoot$VmInternal;", "sizeOf", "skip", "", "skipClassDumpConstantPool", "skipClassDumpFields", "skipClassDumpHeader", "skipClassDumpRecord", "skipClassDumpStaticFields", "skipHeapDumpInfoRecord", "skipId", "skipInstanceDumpRecord", "skipObjectArrayDumpRecord", "skipPrimitiveArrayDumpRecord", "Companion", "shark-hprof"}, k = 1, mv = {1, 4, 1})
public final class HprofRecordReader {
    private static final int BYTE_MASK = 255;
    private static final long INT_MASK = 4294967295L;
    private long bytesRead;
    private final int identifierByteSize;
    private final BufferedSource source;
    private final int[] typeSizes;
    public static final Companion Companion = new Companion(null);
    private static final int BOOLEAN_SIZE = PrimitiveType.BOOLEAN.getByteSize();
    private static final int CHAR_SIZE = PrimitiveType.CHAR.getByteSize();
    private static final int BYTE_SIZE = PrimitiveType.BYTE.getByteSize();
    private static final int SHORT_SIZE = PrimitiveType.SHORT.getByteSize();
    private static final int INT_SIZE = PrimitiveType.INT.getByteSize();
    private static final int LONG_SIZE = PrimitiveType.LONG.getByteSize();
    private static final int BOOLEAN_TYPE = PrimitiveType.BOOLEAN.getHprofType();
    private static final int CHAR_TYPE = PrimitiveType.CHAR.getHprofType();
    private static final int FLOAT_TYPE = PrimitiveType.FLOAT.getHprofType();
    private static final int DOUBLE_TYPE = PrimitiveType.DOUBLE.getHprofType();
    private static final int BYTE_TYPE = PrimitiveType.BYTE.getHprofType();
    private static final int SHORT_TYPE = PrimitiveType.SHORT.getHprofType();
    private static final int INT_TYPE = PrimitiveType.INT.getHprofType();
    private static final int LONG_TYPE = PrimitiveType.LONG.getHprofType();

    public HprofRecordReader(HprofHeader header, BufferedSource source) {
        Intrinsics.checkParameterIsNotNull(header, "header");
        Intrinsics.checkParameterIsNotNull(source, "source");
        this.source = source;
        this.identifierByteSize = header.getIdentifierByteSize();
        Map typeSizesMap = MapsKt.plus(PrimitiveType.Companion.getByteSizeByHprofType(), TuplesKt.to(2, Integer.valueOf(this.identifierByteSize)));
        Comparable max = CollectionsKt.max(typeSizesMap.keySet());
        if (max == null) {
            Intrinsics.throwNpe();
        }
        int maxKey = ((Number) max).intValue();
        int i = maxKey + 1;
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            int key = i2;
            Integer num = (Integer) typeSizesMap.get(Integer.valueOf(key));
            iArr[i2] = num != null ? num.intValue() : 0;
        }
        this.typeSizes = iArr;
    }

    public final long getBytesRead() {
        return this.bytesRead;
    }

    public final int sizeOf(int type) {
        return this.typeSizes[type];
    }

    public final HprofRecord.StringRecord readStringRecord(long length) {
        return new HprofRecord.StringRecord(readId(), readUtf8(length - this.identifierByteSize));
    }

    public final HprofRecord.LoadClassRecord readLoadClassRecord() {
        return new HprofRecord.LoadClassRecord(readInt(), readId(), readInt(), readId());
    }

    public final HprofRecord.StackFrameRecord readStackFrameRecord() {
        return new HprofRecord.StackFrameRecord(readId(), readId(), readId(), readId(), readInt(), readInt());
    }

    public final HprofRecord.StackTraceRecord readStackTraceRecord() {
        return new HprofRecord.StackTraceRecord(readInt(), readInt(), readIdArray(readInt()));
    }

    public final GcRoot.Unknown readUnknownGcRootRecord() {
        return new GcRoot.Unknown(readId());
    }

    public final GcRoot.JniGlobal readJniGlobalGcRootRecord() {
        return new GcRoot.JniGlobal(readId(), readId());
    }

    public final GcRoot.JniLocal readJniLocalGcRootRecord() {
        return new GcRoot.JniLocal(readId(), readInt(), readInt());
    }

    public final GcRoot.JavaFrame readJavaFrameGcRootRecord() {
        return new GcRoot.JavaFrame(readId(), readInt(), readInt());
    }

    public final GcRoot.NativeStack readNativeStackGcRootRecord() {
        return new GcRoot.NativeStack(readId(), readInt());
    }

    public final GcRoot.StickyClass readStickyClassGcRootRecord() {
        return new GcRoot.StickyClass(readId());
    }

    public final GcRoot.ThreadBlock readThreadBlockGcRootRecord() {
        return new GcRoot.ThreadBlock(readId(), readInt());
    }

    public final GcRoot.MonitorUsed readMonitorUsedGcRootRecord() {
        return new GcRoot.MonitorUsed(readId());
    }

    public final GcRoot.ThreadObject readThreadObjectGcRootRecord() {
        return new GcRoot.ThreadObject(readId(), readInt(), readInt());
    }

    public final GcRoot.InternedString readInternedStringGcRootRecord() {
        return new GcRoot.InternedString(readId());
    }

    public final GcRoot.Finalizing readFinalizingGcRootRecord() {
        return new GcRoot.Finalizing(readId());
    }

    public final GcRoot.Debugger readDebuggerGcRootRecord() {
        return new GcRoot.Debugger(readId());
    }

    public final GcRoot.ReferenceCleanup readReferenceCleanupGcRootRecord() {
        return new GcRoot.ReferenceCleanup(readId());
    }

    public final GcRoot.VmInternal readVmInternalGcRootRecord() {
        return new GcRoot.VmInternal(readId());
    }

    public final GcRoot.JniMonitor readJniMonitorGcRootRecord() {
        return new GcRoot.JniMonitor(readId(), readInt(), readInt());
    }

    public final GcRoot.Unreachable readUnreachableGcRootRecord() {
        return new GcRoot.Unreachable(readId());
    }

    public final HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord readInstanceDumpRecord() {
        long id = readId();
        int stackTraceSerialNumber = readInt();
        long classId = readId();
        int remainingBytesInInstance = readInt();
        byte[] fieldValues = readByteArray(remainingBytesInInstance);
        return new HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord(id, stackTraceSerialNumber, classId, fieldValues);
    }

    public final HprofRecord.HeapDumpRecord.HeapDumpInfoRecord readHeapDumpInfoRecord() {
        int heapId = readInt();
        return new HprofRecord.HeapDumpRecord.HeapDumpInfoRecord(heapId, readId());
    }

    public final HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord readClassDumpRecord() {
        long id = readId();
        int stackTraceSerialNumber = readInt();
        long superclassId = readId();
        long classLoaderId = readId();
        long signersId = readId();
        long protectionDomainId = readId();
        readId();
        readId();
        int instanceSize = readInt();
        int constantPoolCount = readUnsignedShort();
        for (int i = 0; i < constantPoolCount; i++) {
            skip(SHORT_SIZE);
            skip(this.typeSizes[readUnsignedByte()]);
        }
        int staticFieldCount = readUnsignedShort();
        ArrayList staticFields = new ArrayList(staticFieldCount);
        for (int i2 = 0; i2 < staticFieldCount; i2++) {
            long nameStringId = readId();
            int type = readUnsignedByte();
            ValueHolder value = readValue(type);
            staticFields.add(new HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord(nameStringId, type, value));
        }
        int fieldCount = readUnsignedShort();
        ArrayList fields = new ArrayList(fieldCount);
        for (int i3 = 0; i3 < fieldCount; i3++) {
            fields.add(new HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord(readId(), readUnsignedByte()));
        }
        return new HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord(id, stackTraceSerialNumber, superclassId, classLoaderId, signersId, protectionDomainId, instanceSize, staticFields, fields);
    }

    public final HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord readPrimitiveArrayDumpRecord() {
        long id = readId();
        int stackTraceSerialNumber = readInt();
        int arrayLength = readInt();
        int type = readUnsignedByte();
        if (type == BOOLEAN_TYPE) {
            return new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.BooleanArrayDump(id, stackTraceSerialNumber, readBooleanArray(arrayLength));
        }
        if (type == CHAR_TYPE) {
            return new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump(id, stackTraceSerialNumber, readCharArray(arrayLength));
        }
        if (type == FLOAT_TYPE) {
            return new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.FloatArrayDump(id, stackTraceSerialNumber, readFloatArray(arrayLength));
        }
        if (type == DOUBLE_TYPE) {
            return new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.DoubleArrayDump(id, stackTraceSerialNumber, readDoubleArray(arrayLength));
        }
        if (type == BYTE_TYPE) {
            return new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ByteArrayDump(id, stackTraceSerialNumber, readByteArray(arrayLength));
        }
        if (type == SHORT_TYPE) {
            return new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ShortArrayDump(id, stackTraceSerialNumber, readShortArray(arrayLength));
        }
        if (type == INT_TYPE) {
            return new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.IntArrayDump(id, stackTraceSerialNumber, readIntArray(arrayLength));
        }
        if (type == LONG_TYPE) {
            return new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.LongArrayDump(id, stackTraceSerialNumber, readLongArray(arrayLength));
        }
        throw new IllegalStateException("Unexpected type " + type);
    }

    public final HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord readObjectArrayDumpRecord() {
        long id = readId();
        int stackTraceSerialNumber = readInt();
        int arrayLength = readInt();
        long arrayClassId = readId();
        long[] elementIds = readIdArray(arrayLength);
        return new HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord(id, stackTraceSerialNumber, arrayClassId, elementIds);
    }

    public final void skipClassDumpHeader() {
        skip((INT_SIZE * 2) + (this.identifierByteSize * 7));
        skipClassDumpConstantPool();
    }

    public final void skipClassDumpConstantPool() {
        int constantPoolCount = readUnsignedShort();
        for (int i = 0; i < constantPoolCount; i++) {
            skip(PrimitiveType.SHORT.getByteSize());
            skip(sizeOf(readUnsignedByte()));
        }
    }

    public final void skipClassDumpStaticFields() {
        int intValue;
        int staticFieldCount = readUnsignedShort();
        for (int i = 0; i < staticFieldCount; i++) {
            skip(this.identifierByteSize);
            int type = readUnsignedByte();
            if (type == 2) {
                intValue = this.identifierByteSize;
            } else {
                intValue = ((Number) MapsKt.getValue(PrimitiveType.Companion.getByteSizeByHprofType(), Integer.valueOf(type))).intValue();
            }
            skip(intValue);
        }
    }

    public final void skipClassDumpFields() {
        int fieldCount = readUnsignedShort();
        skip((this.identifierByteSize + 1) * fieldCount);
    }

    public final void skipInstanceDumpRecord() {
        skip(this.identifierByteSize + INT_SIZE + this.identifierByteSize);
        int remainingBytesInInstance = readInt();
        skip(remainingBytesInInstance);
    }

    public final void skipClassDumpRecord() {
        skip(this.identifierByteSize + INT_SIZE + this.identifierByteSize + this.identifierByteSize + this.identifierByteSize + this.identifierByteSize + this.identifierByteSize + this.identifierByteSize + INT_SIZE);
        int constantPoolCount = readUnsignedShort();
        for (int i = 0; i < constantPoolCount; i++) {
            skip(SHORT_SIZE);
            skip(this.typeSizes[readUnsignedByte()]);
        }
        int staticFieldCount = readUnsignedShort();
        for (int i2 = 0; i2 < staticFieldCount; i2++) {
            skip(this.identifierByteSize);
            int type = readUnsignedByte();
            skip(this.typeSizes[type]);
        }
        int fieldCount = readUnsignedShort();
        skip((this.identifierByteSize + BYTE_SIZE) * fieldCount);
    }

    public final void skipObjectArrayDumpRecord() {
        skip(this.identifierByteSize + INT_SIZE);
        int arrayLength = readInt();
        skip(this.identifierByteSize + (this.identifierByteSize * arrayLength));
    }

    public final void skipPrimitiveArrayDumpRecord() {
        skip(this.identifierByteSize + INT_SIZE);
        int arrayLength = readInt();
        int type = readUnsignedByte();
        skip(this.typeSizes[type] * arrayLength);
    }

    public final void skipHeapDumpInfoRecord() {
        skip(this.identifierByteSize + this.identifierByteSize);
    }

    public final void skip(int byteCount) {
        this.bytesRead += byteCount;
        this.source.skip(byteCount);
    }

    public final void skipId() {
        skip(this.identifierByteSize);
    }

    public final void skip(long byteCount) {
        this.bytesRead += byteCount;
        this.source.skip(byteCount);
    }

    public final long readUnsignedInt() {
        return readInt() & INT_MASK;
    }

    public final int readUnsignedByte() {
        return readByte() & 255;
    }

    public final ValueHolder readValue(int type) {
        if (type == 2) {
            return new ValueHolder.ReferenceHolder(readId());
        }
        if (type == BOOLEAN_TYPE) {
            return new ValueHolder.BooleanHolder(readBoolean());
        }
        if (type == CHAR_TYPE) {
            return new ValueHolder.CharHolder(readChar());
        }
        if (type == FLOAT_TYPE) {
            return new ValueHolder.FloatHolder(readFloat());
        }
        if (type == DOUBLE_TYPE) {
            return new ValueHolder.DoubleHolder(readDouble());
        }
        if (type == BYTE_TYPE) {
            return new ValueHolder.ByteHolder(readByte());
        }
        if (type == SHORT_TYPE) {
            return new ValueHolder.ShortHolder(readShort());
        }
        if (type == INT_TYPE) {
            return new ValueHolder.IntHolder(readInt());
        }
        if (type == LONG_TYPE) {
            return new ValueHolder.LongHolder(readLong());
        }
        throw new IllegalStateException("Unknown type " + type);
    }

    public final short readShort() {
        this.bytesRead += SHORT_SIZE;
        return this.source.readShort();
    }

    public final int readInt() {
        this.bytesRead += INT_SIZE;
        return this.source.readInt();
    }

    public final long[] readIdArray(int arrayLength) {
        long[] jArr = new long[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            jArr[i] = readId();
        }
        return jArr;
    }

    public final boolean[] readBooleanArray(int arrayLength) {
        boolean[] zArr = new boolean[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            zArr[i] = readByte() != 0;
        }
        return zArr;
    }

    public final char[] readCharArray(int arrayLength) {
        char[] cArr = new char[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            cArr[i] = readChar();
        }
        return cArr;
    }

    public final String readString(int byteCount, Charset charset) {
        Intrinsics.checkParameterIsNotNull(charset, "charset");
        this.bytesRead += byteCount;
        String readString = this.source.readString(byteCount, charset);
        Intrinsics.checkExpressionValueIsNotNull(readString, "source.readString(byteCount.toLong(), charset)");
        return readString;
    }

    public final float[] readFloatArray(int arrayLength) {
        float[] fArr = new float[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            fArr[i] = readFloat();
        }
        return fArr;
    }

    public final double[] readDoubleArray(int arrayLength) {
        double[] dArr = new double[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            dArr[i] = readDouble();
        }
        return dArr;
    }

    public final short[] readShortArray(int arrayLength) {
        short[] sArr = new short[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            sArr[i] = readShort();
        }
        return sArr;
    }

    public final int[] readIntArray(int arrayLength) {
        int[] iArr = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            int it = readInt();
            iArr[i] = it;
        }
        return iArr;
    }

    public final long[] readLongArray(int arrayLength) {
        long[] jArr = new long[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            jArr[i] = readLong();
        }
        return jArr;
    }

    public final long readLong() {
        this.bytesRead += LONG_SIZE;
        return this.source.readLong();
    }

    public final byte readByte() {
        this.bytesRead += BYTE_SIZE;
        return this.source.readByte();
    }

    public final boolean readBoolean() {
        this.bytesRead += BOOLEAN_SIZE;
        return this.source.readByte() != 0;
    }

    public final byte[] readByteArray(int byteCount) {
        this.bytesRead += byteCount;
        byte[] readByteArray = this.source.readByteArray(byteCount);
        Intrinsics.checkExpressionValueIsNotNull(readByteArray, "source.readByteArray(byteCount.toLong())");
        return readByteArray;
    }

    public final char readChar() {
        return readString(CHAR_SIZE, Charsets.UTF_16BE).charAt(0);
    }

    public final float readFloat() {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat(readInt());
    }

    public final double readDouble() {
        DoubleCompanionObject doubleCompanionObject = DoubleCompanionObject.INSTANCE;
        return Double.longBitsToDouble(readLong());
    }

    public final long readId() {
        switch (this.identifierByteSize) {
            case 1:
                return readByte();
            case 2:
                return readShort();
            case 4:
                return readInt();
            case 8:
                return readLong();
            default:
                throw new IllegalArgumentException("ID Length must be 1, 2, 4, or 8");
        }
    }

    public final String readUtf8(long byteCount) {
        this.bytesRead += byteCount;
        String readUtf8 = this.source.readUtf8(byteCount);
        Intrinsics.checkExpressionValueIsNotNull(readUtf8, "source.readUtf8(byteCount)");
        return readUtf8;
    }

    public final int readUnsignedShort() {
        return readShort() & 65535;
    }

    /* compiled from: HprofRecordReader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lshark/HprofRecordReader$Companion;", "", "()V", "BOOLEAN_SIZE", "", "BOOLEAN_TYPE", "BYTE_MASK", "BYTE_SIZE", "BYTE_TYPE", "CHAR_SIZE", "CHAR_TYPE", "DOUBLE_TYPE", "FLOAT_TYPE", "INT_MASK", "", "INT_SIZE", "INT_TYPE", "LONG_SIZE", "LONG_TYPE", "SHORT_SIZE", "SHORT_TYPE", "shark-hprof"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}