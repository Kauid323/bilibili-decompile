package shark.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import shark.HprofRecord;
import shark.PrimitiveType;
import shark.ValueHolder;
import shark.internal.ClassFieldsReader;
import shark.internal.IndexedObject;

/* compiled from: ClassFieldsReader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\b2\u0006\u0010\n\u001a\u00020\u000bJ8\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u001b\u0010\u0013\u001a\u0017\u0012\b\u0012\u00060\u0015R\u00020\u0000\u0012\u0004\u0012\u0002H\u00110\u0014¢\u0006\u0002\b\u0016H\u0002¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lshark/internal/ClassFieldsReader;", "", "identifierByteSize", "", "classFieldBytes", "", "(I[B)V", "classDumpFields", "", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$FieldRecord;", "indexedClass", "Lshark/internal/IndexedObject$IndexedClass;", "classDumpHasReferenceFields", "", "classDumpStaticFields", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$StaticFieldRecord;", "read", "R", "initialPosition", "block", "Lkotlin/Function1;", "Lshark/internal/ClassFieldsReader$ReadInFlight;", "Lkotlin/ExtensionFunctionType;", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Companion", "ReadInFlight", "shark-graph"}, k = 1, mv = {1, 4, 1})
public final class ClassFieldsReader {
    private final byte[] classFieldBytes;
    private final int identifierByteSize;
    public static final Companion Companion = new Companion(null);
    private static final int BOOLEAN_TYPE = PrimitiveType.BOOLEAN.getHprofType();
    private static final int CHAR_TYPE = PrimitiveType.CHAR.getHprofType();
    private static final int FLOAT_TYPE = PrimitiveType.FLOAT.getHprofType();
    private static final int DOUBLE_TYPE = PrimitiveType.DOUBLE.getHprofType();
    private static final int BYTE_TYPE = PrimitiveType.BYTE.getHprofType();
    private static final int SHORT_TYPE = PrimitiveType.SHORT.getHprofType();
    private static final int INT_TYPE = PrimitiveType.INT.getHprofType();
    private static final int LONG_TYPE = PrimitiveType.LONG.getHprofType();

    public ClassFieldsReader(int identifierByteSize, byte[] classFieldBytes) {
        Intrinsics.checkParameterIsNotNull(classFieldBytes, "classFieldBytes");
        this.identifierByteSize = identifierByteSize;
        this.classFieldBytes = classFieldBytes;
    }

    public final List<HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord> classDumpStaticFields(IndexedObject.IndexedClass indexedClass) {
        Intrinsics.checkParameterIsNotNull(indexedClass, "indexedClass");
        return (List) read(indexedClass.getFieldsIndex(), new Function1<ReadInFlight, ArrayList<HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord>>() { // from class: shark.internal.ClassFieldsReader$classDumpStaticFields$1
            public final ArrayList<HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord> invoke(ClassFieldsReader.ReadInFlight $this$read) {
                Intrinsics.checkParameterIsNotNull($this$read, "$receiver");
                int staticFieldCount = $this$read.readUnsignedShort();
                ArrayList staticFields = new ArrayList(staticFieldCount);
                for (int i = 0; i < staticFieldCount; i++) {
                    long nameStringId = $this$read.readId();
                    int type = $this$read.readUnsignedByte();
                    ValueHolder value = $this$read.readValue(type);
                    staticFields.add(new HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord(nameStringId, type, value));
                }
                return staticFields;
            }
        });
    }

    public final List<HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord> classDumpFields(IndexedObject.IndexedClass indexedClass) {
        Intrinsics.checkParameterIsNotNull(indexedClass, "indexedClass");
        return (List) read(indexedClass.getFieldsIndex(), new Function1<ReadInFlight, ArrayList<HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord>>() { // from class: shark.internal.ClassFieldsReader$classDumpFields$1
            public final ArrayList<HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord> invoke(ClassFieldsReader.ReadInFlight $this$read) {
                Intrinsics.checkParameterIsNotNull($this$read, "$receiver");
                $this$read.skipStaticFields();
                int fieldCount = $this$read.readUnsignedShort();
                ArrayList fields = new ArrayList(fieldCount);
                for (int i = 0; i < fieldCount; i++) {
                    fields.add(new HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord($this$read.readId(), $this$read.readUnsignedByte()));
                }
                return fields;
            }
        });
    }

    public final boolean classDumpHasReferenceFields(IndexedObject.IndexedClass indexedClass) {
        Intrinsics.checkParameterIsNotNull(indexedClass, "indexedClass");
        return ((Boolean) read(indexedClass.getFieldsIndex(), new Function1<ReadInFlight, Boolean>() { // from class: shark.internal.ClassFieldsReader$classDumpHasReferenceFields$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return Boolean.valueOf(invoke((ClassFieldsReader.ReadInFlight) obj));
            }

            public final boolean invoke(ClassFieldsReader.ReadInFlight $this$read) {
                Intrinsics.checkParameterIsNotNull($this$read, "$receiver");
                $this$read.skipStaticFields();
                int fieldCount = $this$read.readUnsignedShort();
                for (int i = 0; i < fieldCount; i++) {
                    $this$read.setPosition($this$read.getPosition() + ClassFieldsReader.this.identifierByteSize);
                    int type = $this$read.readUnsignedByte();
                    if (type == 2) {
                        return true;
                    }
                }
                return false;
            }
        })).booleanValue();
    }

    private final <R> R read(int initialPosition, Function1<? super ReadInFlight, ? extends R> function1) {
        ReadInFlight readInFlight = new ReadInFlight();
        readInFlight.setPosition(initialPosition);
        return (R) function1.invoke(readInFlight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ClassFieldsReader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\u0004J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004J\u0006\u0010\u001e\u001a\u00020\u001fR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006 "}, d2 = {"Lshark/internal/ClassFieldsReader$ReadInFlight;", "", "(Lshark/internal/ClassFieldsReader;)V", "position", "", "getPosition", "()I", "setPosition", "(I)V", "readBoolean", "", "readByte", "", "readChar", "", "readDouble", "", "readFloat", "", "readId", "", "readInt", "readLong", "readShort", "", "readUnsignedByte", "readUnsignedShort", "readValue", "Lshark/ValueHolder;", "type", "skipStaticFields", "", "shark-graph"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final class ReadInFlight {
        private int position;

        public ReadInFlight() {
        }

        public final int getPosition() {
            return this.position;
        }

        public final void setPosition(int i) {
            this.position = i;
        }

        public final void skipStaticFields() {
            int intValue;
            int staticFieldCount = readUnsignedShort();
            for (int i = 0; i < staticFieldCount; i++) {
                this.position += ClassFieldsReader.this.identifierByteSize;
                int type = readUnsignedByte();
                int i2 = this.position;
                if (type == 2) {
                    intValue = ClassFieldsReader.this.identifierByteSize;
                } else {
                    intValue = ((Number) MapsKt.getValue(PrimitiveType.Companion.getByteSizeByHprofType(), Integer.valueOf(type))).intValue();
                }
                this.position = i2 + intValue;
            }
        }

        public final ValueHolder readValue(int type) {
            if (type == 2) {
                return new ValueHolder.ReferenceHolder(readId());
            }
            if (type == ClassFieldsReader.BOOLEAN_TYPE) {
                return new ValueHolder.BooleanHolder(readBoolean());
            }
            if (type == ClassFieldsReader.CHAR_TYPE) {
                return new ValueHolder.CharHolder(readChar());
            }
            if (type == ClassFieldsReader.FLOAT_TYPE) {
                return new ValueHolder.FloatHolder(readFloat());
            }
            if (type == ClassFieldsReader.DOUBLE_TYPE) {
                return new ValueHolder.DoubleHolder(readDouble());
            }
            if (type == ClassFieldsReader.BYTE_TYPE) {
                return new ValueHolder.ByteHolder(readByte());
            }
            if (type == ClassFieldsReader.SHORT_TYPE) {
                return new ValueHolder.ShortHolder(readShort());
            }
            if (type == ClassFieldsReader.INT_TYPE) {
                return new ValueHolder.IntHolder(readInt());
            }
            if (type == ClassFieldsReader.LONG_TYPE) {
                return new ValueHolder.LongHolder(readLong());
            }
            throw new IllegalStateException("Unknown type " + type);
        }

        public final byte readByte() {
            byte[] bArr = ClassFieldsReader.this.classFieldBytes;
            int i = this.position;
            this.position = i + 1;
            return bArr[i];
        }

        public final int readInt() {
            byte[] bArr = ClassFieldsReader.this.classFieldBytes;
            int i = this.position;
            this.position = i + 1;
            byte[] bArr2 = ClassFieldsReader.this.classFieldBytes;
            int i2 = this.position;
            this.position = i2 + 1;
            int i3 = ((bArr[i] & 255) << 24) | ((bArr2[i2] & 255) << 16);
            byte[] bArr3 = ClassFieldsReader.this.classFieldBytes;
            int i4 = this.position;
            this.position = i4 + 1;
            int i5 = i3 | ((bArr3[i4] & 255) << 8);
            byte[] bArr4 = ClassFieldsReader.this.classFieldBytes;
            int i6 = this.position;
            this.position = i6 + 1;
            return i5 | (bArr4[i6] & 255);
        }

        public final long readLong() {
            byte[] bArr = ClassFieldsReader.this.classFieldBytes;
            int i = this.position;
            this.position = i + 1;
            byte[] bArr2 = ClassFieldsReader.this.classFieldBytes;
            int i2 = this.position;
            this.position = i2 + 1;
            long j = ((bArr[i] & 255) << 56) | ((bArr2[i2] & 255) << 48);
            byte[] bArr3 = ClassFieldsReader.this.classFieldBytes;
            int i3 = this.position;
            this.position = i3 + 1;
            long j2 = j | ((bArr3[i3] & 255) << 40);
            byte[] bArr4 = ClassFieldsReader.this.classFieldBytes;
            int i4 = this.position;
            this.position = i4 + 1;
            long j3 = j2 | ((bArr4[i4] & 255) << 32);
            byte[] bArr5 = ClassFieldsReader.this.classFieldBytes;
            int i5 = this.position;
            this.position = i5 + 1;
            long j4 = j3 | ((bArr5[i5] & 255) << 24);
            byte[] bArr6 = ClassFieldsReader.this.classFieldBytes;
            int i6 = this.position;
            this.position = i6 + 1;
            long j5 = j4 | ((bArr6[i6] & 255) << 16);
            byte[] bArr7 = ClassFieldsReader.this.classFieldBytes;
            int i7 = this.position;
            this.position = i7 + 1;
            long j6 = j5 | ((bArr7[i7] & 255) << 8);
            byte[] bArr8 = ClassFieldsReader.this.classFieldBytes;
            int i8 = this.position;
            this.position = i8 + 1;
            return j6 | (255 & bArr8[i8]);
        }

        public final short readShort() {
            byte[] bArr = ClassFieldsReader.this.classFieldBytes;
            int i = this.position;
            this.position = i + 1;
            byte[] bArr2 = ClassFieldsReader.this.classFieldBytes;
            int i2 = this.position;
            this.position = i2 + 1;
            return (short) (((bArr[i] & 255) << 8) | (bArr2[i2] & 255));
        }

        public final int readUnsignedShort() {
            return readShort() & 65535;
        }

        public final int readUnsignedByte() {
            return readByte() & 255;
        }

        public final long readId() {
            switch (ClassFieldsReader.this.identifierByteSize) {
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

        public final boolean readBoolean() {
            return readByte() != 0;
        }

        public final char readChar() {
            return (char) readShort();
        }

        public final float readFloat() {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            return Float.intBitsToFloat(readInt());
        }

        public final double readDouble() {
            DoubleCompanionObject doubleCompanionObject = DoubleCompanionObject.INSTANCE;
            return Double.longBitsToDouble(readLong());
        }
    }

    /* compiled from: ClassFieldsReader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lshark/internal/ClassFieldsReader$Companion;", "", "()V", "BOOLEAN_TYPE", "", "BYTE_TYPE", "CHAR_TYPE", "DOUBLE_TYPE", "FLOAT_TYPE", "INT_TYPE", "LONG_TYPE", "SHORT_TYPE", "shark-graph"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}