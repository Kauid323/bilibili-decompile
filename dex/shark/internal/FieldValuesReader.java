package shark.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import shark.HprofRecord;
import shark.PrimitiveType;
import shark.ValueHolder;

/* compiled from: FieldValuesReader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lshark/internal/FieldValuesReader;", "", "record", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;", "identifierByteSize", "", "(Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;I)V", "position", "readBoolean", "", "readByte", "", "readChar", "", "readDouble", "", "readFloat", "", "readId", "", "readInt", "readLong", "readShort", "", "readValue", "Lshark/ValueHolder;", "field", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$FieldRecord;", "Companion", "shark-graph"}, k = 1, mv = {1, 4, 1})
public final class FieldValuesReader {
    private final int identifierByteSize;
    private int position;
    private final HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord record;
    public static final Companion Companion = new Companion(null);
    private static final int BOOLEAN_TYPE = PrimitiveType.BOOLEAN.getHprofType();
    private static final int CHAR_TYPE = PrimitiveType.CHAR.getHprofType();
    private static final int FLOAT_TYPE = PrimitiveType.FLOAT.getHprofType();
    private static final int DOUBLE_TYPE = PrimitiveType.DOUBLE.getHprofType();
    private static final int BYTE_TYPE = PrimitiveType.BYTE.getHprofType();
    private static final int SHORT_TYPE = PrimitiveType.SHORT.getHprofType();
    private static final int INT_TYPE = PrimitiveType.INT.getHprofType();
    private static final int LONG_TYPE = PrimitiveType.LONG.getHprofType();

    public FieldValuesReader(HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord record, int identifierByteSize) {
        Intrinsics.checkParameterIsNotNull(record, "record");
        this.record = record;
        this.identifierByteSize = identifierByteSize;
    }

    public final ValueHolder readValue(HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord field) {
        Intrinsics.checkParameterIsNotNull(field, "field");
        int type = field.getType();
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
        throw new IllegalStateException("Unknown type " + field.getType());
    }

    private final long readId() {
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

    private final boolean readBoolean() {
        byte value = this.record.getFieldValues()[this.position];
        this.position++;
        return value != ((byte) 0);
    }

    private final byte readByte() {
        byte value = this.record.getFieldValues()[this.position];
        this.position++;
        return value;
    }

    private final int readInt() {
        int value = ByteSubArrayKt.readInt(this.record.getFieldValues(), this.position);
        this.position += 4;
        return value;
    }

    private final short readShort() {
        short value = ByteSubArrayKt.readShort(this.record.getFieldValues(), this.position);
        this.position += 2;
        return value;
    }

    private final long readLong() {
        long value = ByteSubArrayKt.readLong(this.record.getFieldValues(), this.position);
        this.position += 8;
        return value;
    }

    private final float readFloat() {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat(readInt());
    }

    private final double readDouble() {
        DoubleCompanionObject doubleCompanionObject = DoubleCompanionObject.INSTANCE;
        return Double.longBitsToDouble(readLong());
    }

    private final char readChar() {
        String string = new String(this.record.getFieldValues(), this.position, 2, Charsets.UTF_16BE);
        this.position += 2;
        return string.charAt(0);
    }

    /* compiled from: FieldValuesReader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lshark/internal/FieldValuesReader$Companion;", "", "()V", "BOOLEAN_TYPE", "", "BYTE_TYPE", "CHAR_TYPE", "DOUBLE_TYPE", "FLOAT_TYPE", "INT_TYPE", "LONG_TYPE", "SHORT_TYPE", "shark-graph"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}