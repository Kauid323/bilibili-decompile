package shark.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import shark.HprofRecord;

/* compiled from: FieldIdReader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0006\u0010\r\u001a\u00020\tJ\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005J\u0015\u0010\u0014\u001a\u00020\u0005*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0005H\u0082\fJ\u0015\u0010\u0014\u001a\u00020\t*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\tH\u0082\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lshark/internal/FieldIdReader;", "", "record", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;", "identifierByteSize", "", "(Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;I)V", "position", "readByteId", "", "index", "array", "", "readId", "readIntId", "readLongId", "readShortId", "skipBytes", "", "count", "and", "", "other", "shark"}, k = 1, mv = {1, 4, 1})
public final class FieldIdReader {
    private final int identifierByteSize;
    private int position;
    private final HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord record;

    public FieldIdReader(HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord record, int identifierByteSize) {
        Intrinsics.checkParameterIsNotNull(record, "record");
        this.record = record;
        this.identifierByteSize = identifierByteSize;
    }

    public final long readId() {
        long value;
        switch (this.identifierByteSize) {
            case 1:
                value = readByteId(this.position, this.record.getFieldValues());
                break;
            case 2:
                value = readShortId(this.position, this.record.getFieldValues());
                break;
            case 4:
                value = readIntId(this.position, this.record.getFieldValues());
                break;
            case 8:
                value = readLongId(this.position, this.record.getFieldValues());
                break;
            default:
                throw new IllegalStateException("ID Length must be 1, 2, 4, or 8".toString());
        }
        this.position += this.identifierByteSize;
        return value;
    }

    public final void skipBytes(int count) {
        this.position += count;
    }

    private final long readByteId(int index, byte[] array) {
        return array[index];
    }

    private final long readShortId(int index, byte[] array) {
        int pos = index + 1;
        byte $this$and$iv = array[index];
        byte $this$and$iv2 = array[pos];
        return (($this$and$iv & 255) << 8) | ($this$and$iv2 & 255);
    }

    private final long readIntId(int index, byte[] array) {
        int pos = index + 1;
        byte $this$and$iv = array[index];
        int pos2 = pos + 1;
        byte $this$and$iv2 = array[pos];
        int i = (($this$and$iv & 255) << 24) | (($this$and$iv2 & 255) << 16);
        int pos3 = pos2 + 1;
        byte $this$and$iv3 = array[pos2];
        int i2 = i | (($this$and$iv3 & 255) << 8);
        byte $this$and$iv4 = array[pos3];
        return i2 | ($this$and$iv4 & 255);
    }

    private final long readLongId(int index, byte[] array) {
        int pos = index + 1;
        byte $this$and$iv = array[index];
        long other$iv = 255 & $this$and$iv;
        int pos2 = pos + 1;
        byte $this$and$iv2 = array[pos];
        long other$iv2 = 255 & $this$and$iv2;
        long j = (other$iv << 56) | (other$iv2 << 48);
        int pos3 = pos2 + 1;
        byte $this$and$iv3 = array[pos2];
        long other$iv3 = 255 & $this$and$iv3;
        int pos4 = pos3 + 1;
        byte $this$and$iv4 = array[pos3];
        long j2 = j | (other$iv3 << 40) | (($this$and$iv4 & 255) << 32);
        int pos5 = pos4 + 1;
        byte $this$and$iv5 = array[pos4];
        long other$iv4 = 255 & $this$and$iv5;
        int pos6 = pos5 + 1;
        byte $this$and$iv6 = array[pos5];
        long j3 = j2 | (other$iv4 << 24) | (($this$and$iv6 & 255) << 16);
        int pos7 = pos6 + 1;
        byte $this$and$iv7 = array[pos6];
        long other$iv5 = 255 & $this$and$iv7;
        long j4 = j3 | (other$iv5 << 8);
        byte $this$and$iv8 = array[pos7];
        long other$iv6 = 255 & $this$and$iv8;
        return j4 | other$iv6;
    }

    private final long and(byte $this$and, long other) {
        return $this$and & other;
    }

    private final int and(byte $this$and, int other) {
        return $this$and & other;
    }
}