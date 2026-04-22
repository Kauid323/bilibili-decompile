package shark.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteSubArray.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\n\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0082\f\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0082\f\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\b\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\t\u001a\u00020\n*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001H\u0000¨\u0006\u000b"}, d2 = {"and", "", "", "other", "", "readInt", "", "index", "readLong", "readShort", "", "shark-graph"}, k = 2, mv = {1, 4, 1})
public final class ByteSubArrayKt {
    public static final short readShort(byte[] $this$readShort, int index) {
        Intrinsics.checkParameterIsNotNull($this$readShort, "$this$readShort");
        int pos = index + 1;
        byte $this$and$iv = $this$readShort[index];
        byte $this$and$iv2 = $this$readShort[pos];
        int valueAsInt = (($this$and$iv & 255) << 8) | ($this$and$iv2 & 255);
        return (short) valueAsInt;
    }

    public static final int readInt(byte[] $this$readInt, int index) {
        Intrinsics.checkParameterIsNotNull($this$readInt, "$this$readInt");
        int pos = index + 1;
        byte $this$and$iv = $this$readInt[index];
        int pos2 = pos + 1;
        byte $this$and$iv2 = $this$readInt[pos];
        int i = (($this$and$iv & 255) << 24) | (($this$and$iv2 & 255) << 16);
        int pos3 = pos2 + 1;
        byte $this$and$iv3 = $this$readInt[pos2];
        int i2 = i | (($this$and$iv3 & 255) << 8);
        byte $this$and$iv4 = $this$readInt[pos3];
        return i2 | ($this$and$iv4 & 255);
    }

    public static final long readLong(byte[] $this$readLong, int index) {
        Intrinsics.checkParameterIsNotNull($this$readLong, "$this$readLong");
        int pos = index + 1;
        byte $this$and$iv = $this$readLong[index];
        long other$iv = 255 & $this$and$iv;
        int pos2 = pos + 1;
        byte $this$and$iv2 = $this$readLong[pos];
        long other$iv2 = 255 & $this$and$iv2;
        long j = (other$iv << 56) | (other$iv2 << 48);
        int pos3 = pos2 + 1;
        byte $this$and$iv3 = $this$readLong[pos2];
        long other$iv3 = 255 & $this$and$iv3;
        int pos4 = pos3 + 1;
        byte $this$and$iv4 = $this$readLong[pos3];
        long j2 = j | (other$iv3 << 40) | (($this$and$iv4 & 255) << 32);
        int pos5 = pos4 + 1;
        byte $this$and$iv5 = $this$readLong[pos4];
        long other$iv4 = 255 & $this$and$iv5;
        int pos6 = pos5 + 1;
        byte $this$and$iv6 = $this$readLong[pos5];
        long j3 = j2 | (other$iv4 << 24) | (($this$and$iv6 & 255) << 16);
        int pos7 = pos6 + 1;
        byte $this$and$iv7 = $this$readLong[pos6];
        long other$iv5 = 255 & $this$and$iv7;
        long j4 = j3 | (other$iv5 << 8);
        byte $this$and$iv8 = $this$readLong[pos7];
        long other$iv6 = 255 & $this$and$iv8;
        return j4 | other$iv6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long and(byte $this$and, long other) {
        return $this$and & other;
    }

    private static final int and(byte $this$and, int other) {
        return $this$and & other;
    }
}