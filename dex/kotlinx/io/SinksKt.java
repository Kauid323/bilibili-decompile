package kotlinx.io;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.unsafe.SegmentWriteContext;
import kotlinx.io.unsafe.UnsafeBufferOperations;
import kotlinx.io.unsafe.UnsafeBufferOperationsKt;

/* compiled from: Sinks.kt */
@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0012\u0010\u0007\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\b\u001a\u00020\t\u001a\u0012\u0010\n\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f\u001a\u0012\u0010\r\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f\u001a\u0012\u0010\u000e\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f\u001a\u0019\u0010\u000f\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0019\u0010\u0014\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0019\u0010\u0018\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\b\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0019\u0010\u001c\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0019\u0010 \u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0015¢\u0006\u0004\b!\u0010\u0017\u001a\u0019\u0010\"\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\b\u001a\u00020\u0019¢\u0006\u0004\b#\u0010\u001b\u001a\u0019\u0010$\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u001d¢\u0006\u0004\b%\u0010\u001f\u001a\u0012\u0010&\u001a\u00020\u0003*\u00020\u00042\u0006\u0010'\u001a\u00020(\u001a\u0012\u0010)\u001a\u00020\u0003*\u00020\u00042\u0006\u0010*\u001a\u00020+\u001a\u0012\u0010,\u001a\u00020\u0003*\u00020\u00042\u0006\u0010'\u001a\u00020(\u001a\u0012\u0010-\u001a\u00020\u0003*\u00020\u00042\u0006\u0010*\u001a\u00020+\u001a1\u0010.\u001a\u00020\u0003*\u00020\u00042\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u000300H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00062"}, d2 = {"HEX_DIGIT_BYTES", "", "writeShortLe", "", "Lkotlinx/io/Sink;", "short", "", "writeIntLe", "int", "", "writeLongLe", "long", "", "writeDecimalLong", "writeHexadecimalUnsignedLong", "writeUByte", "byte", "Lkotlin/UByte;", "writeUByte-EK-6454", "(Lkotlinx/io/Sink;B)V", "writeUShort", "Lkotlin/UShort;", "writeUShort-i8woANY", "(Lkotlinx/io/Sink;S)V", "writeUInt", "Lkotlin/UInt;", "writeUInt-Qn1smSk", "(Lkotlinx/io/Sink;I)V", "writeULong", "Lkotlin/ULong;", "writeULong-2TYgG_w", "(Lkotlinx/io/Sink;J)V", "writeUShortLe", "writeUShortLe-i8woANY", "writeUIntLe", "writeUIntLe-Qn1smSk", "writeULongLe", "writeULongLe-2TYgG_w", "writeFloat", "float", "", "writeDouble", "double", "", "writeFloatLe", "writeDoubleLe", "writeToInternalBuffer", "lambda", "Lkotlin/Function1;", "Lkotlinx/io/Buffer;", "kotlinx-io-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SinksKt {
    private static final byte[] HEX_DIGIT_BYTES;

    static {
        byte[] bArr = new byte[16];
        int i = 0;
        while (i < 16) {
            bArr[i] = (byte) ((i < 10 ? 48 : 87) + i);
            i++;
        }
        HEX_DIGIT_BYTES = bArr;
    }

    public static final void writeShortLe(Sink $this$writeShortLe, short s) {
        Intrinsics.checkNotNullParameter($this$writeShortLe, "<this>");
        $this$writeShortLe.writeShort(_UtilsJvmKt.reverseBytes(s));
    }

    public static final void writeIntLe(Sink $this$writeIntLe, int i) {
        Intrinsics.checkNotNullParameter($this$writeIntLe, "<this>");
        $this$writeIntLe.writeInt(_UtilsJvmKt.reverseBytes(i));
    }

    public static final void writeLongLe(Sink $this$writeLongLe, long j) {
        Intrinsics.checkNotNullParameter($this$writeLongLe, "<this>");
        $this$writeLongLe.writeLong(_UtilsJvmKt.reverseBytes(j));
    }

    public static final void writeDecimalLong(Sink $this$writeDecimalLong, long j) {
        int i;
        SegmentWriteContext ctx;
        Segment segment;
        Intrinsics.checkNotNullParameter($this$writeDecimalLong, "<this>");
        long v = j;
        if (v == 0) {
            $this$writeDecimalLong.writeByte((byte) 48);
            return;
        }
        int i2 = 0;
        if (v < 0) {
            long v2 = -v;
            if (v2 < 0) {
                Utf8Kt.writeString$default($this$writeDecimalLong, "-9223372036854775808", 0, 0, 6, (Object) null);
                return;
            } else {
                i2 = 1;
                v = v2;
            }
        }
        int i3 = 10;
        if (v < 100000000) {
            if (v < 10000) {
                if (v < 100) {
                    i = v < 10 ? 1 : 2;
                } else {
                    i = v < 1000 ? 3 : 4;
                }
            } else if (v < 1000000) {
                i = v < 100000 ? 5 : 6;
            } else {
                i = v < 10000000 ? 7 : 8;
            }
        } else if (v < 1000000000000L) {
            if (v < 10000000000L) {
                i = v < 1000000000 ? 9 : 10;
            } else {
                i = v < 100000000000L ? 11 : 12;
            }
        } else if (v < 1000000000000000L) {
            if (v < 10000000000000L) {
                i = 13;
            } else {
                i = v < 100000000000000L ? 14 : 15;
            }
        } else if (v < 100000000000000000L) {
            i = v < 10000000000000000L ? 16 : 17;
        } else {
            i = v < 1000000000000000000L ? 18 : 19;
        }
        int width = i;
        if (i2 != 0) {
            width++;
        }
        Buffer buffer = $this$writeDecimalLong.getBuffer();
        int i4 = 0;
        UnsafeBufferOperations this_$iv = UnsafeBufferOperations.INSTANCE;
        int minimumCapacity$iv = width;
        Segment tail$iv = buffer.writableSegment(minimumCapacity$iv);
        ctx = UnsafeBufferOperationsKt.SegmentWriteContextImpl;
        Segment segment2 = tail$iv;
        int pos = width - 1;
        if (i2 <= pos) {
            while (true) {
                int i5 = i4;
                UnsafeBufferOperations this_$iv2 = this_$iv;
                long j2 = i3;
                int pos2 = pos;
                byte digit = (byte) (v % j2);
                byte b = HEX_DIGIT_BYTES[digit];
                segment = segment2;
                ctx.setUnchecked(segment, pos2, b);
                v /= j2;
                if (pos2 == i2) {
                    break;
                }
                pos = pos2 - 1;
                segment2 = segment;
                i4 = i5;
                this_$iv = this_$iv2;
                i3 = 10;
            }
        } else {
            segment = segment2;
        }
        int pos3 = 0;
        if (i2 != 0) {
            ctx.setUnchecked(segment, 0, (byte) 45);
        }
        int bytesWritten$iv = width;
        if (bytesWritten$iv == minimumCapacity$iv) {
            tail$iv.setLimit(tail$iv.getLimit() + bytesWritten$iv);
            buffer.setSizeMut(buffer.getSizeMut() + bytesWritten$iv);
        } else {
            if (bytesWritten$iv >= 0 && bytesWritten$iv <= tail$iv.getRemainingCapacity()) {
                pos3 = 1;
            }
            if (pos3 == 0) {
                throw new IllegalStateException(("Invalid number of bytes written: " + bytesWritten$iv + ". Should be in 0.." + tail$iv.getRemainingCapacity()).toString());
            }
            if (bytesWritten$iv != 0) {
                tail$iv.setLimit(tail$iv.getLimit() + bytesWritten$iv);
                buffer.setSizeMut(buffer.getSizeMut() + bytesWritten$iv);
            } else if (SegmentKt.isEmpty(tail$iv)) {
                buffer.recycleTail();
            }
        }
        $this$writeDecimalLong.hintEmit();
    }

    public static final void writeHexadecimalUnsignedLong(Sink $this$writeHexadecimalUnsignedLong, long j) {
        SegmentWriteContext ctx;
        Intrinsics.checkNotNullParameter($this$writeHexadecimalUnsignedLong, "<this>");
        long v = j;
        if (v == 0) {
            $this$writeHexadecimalUnsignedLong.writeByte((byte) 48);
            return;
        }
        int exactWidth$iv = v == 0 ? 1 : ((64 - Long.numberOfLeadingZeros(v)) + 3) / 4;
        Buffer buffer = $this$writeHexadecimalUnsignedLong.getBuffer();
        UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
        Segment tail$iv = buffer.writableSegment(exactWidth$iv);
        ctx = UnsafeBufferOperationsKt.SegmentWriteContextImpl;
        for (int pos = exactWidth$iv - 1; -1 < pos; pos--) {
            ctx.setUnchecked(tail$iv, pos, HEX_DIGIT_BYTES[((int) v) & 15]);
            v >>>= 4;
        }
        if (exactWidth$iv == exactWidth$iv) {
            tail$iv.setLimit(tail$iv.getLimit() + exactWidth$iv);
            buffer.setSizeMut(buffer.getSizeMut() + exactWidth$iv);
        } else {
            if (!(exactWidth$iv >= 0 && exactWidth$iv <= tail$iv.getRemainingCapacity())) {
                throw new IllegalStateException(("Invalid number of bytes written: " + exactWidth$iv + ". Should be in 0.." + tail$iv.getRemainingCapacity()).toString());
            }
            if (exactWidth$iv != 0) {
                tail$iv.setLimit(tail$iv.getLimit() + exactWidth$iv);
                buffer.setSizeMut(buffer.getSizeMut() + exactWidth$iv);
            } else if (SegmentKt.isEmpty(tail$iv)) {
                buffer.recycleTail();
            }
        }
        $this$writeHexadecimalUnsignedLong.hintEmit();
    }

    /* renamed from: writeUByte-EK-6454  reason: not valid java name */
    public static final void m1516writeUByteEK6454(Sink writeUByte, byte b) {
        Intrinsics.checkNotNullParameter(writeUByte, "$this$writeUByte");
        writeUByte.writeByte(b);
    }

    /* renamed from: writeUShort-i8woANY  reason: not valid java name */
    public static final void m1521writeUShorti8woANY(Sink writeUShort, short s) {
        Intrinsics.checkNotNullParameter(writeUShort, "$this$writeUShort");
        writeUShort.writeShort(s);
    }

    /* renamed from: writeUInt-Qn1smSk  reason: not valid java name */
    public static final void m1517writeUIntQn1smSk(Sink writeUInt, int i) {
        Intrinsics.checkNotNullParameter(writeUInt, "$this$writeUInt");
        writeUInt.writeInt(i);
    }

    /* renamed from: writeULong-2TYgG_w  reason: not valid java name */
    public static final void m1519writeULong2TYgG_w(Sink writeULong, long j) {
        Intrinsics.checkNotNullParameter(writeULong, "$this$writeULong");
        writeULong.writeLong(j);
    }

    /* renamed from: writeUShortLe-i8woANY  reason: not valid java name */
    public static final void m1522writeUShortLei8woANY(Sink writeUShortLe, short s) {
        Intrinsics.checkNotNullParameter(writeUShortLe, "$this$writeUShortLe");
        writeShortLe(writeUShortLe, s);
    }

    /* renamed from: writeUIntLe-Qn1smSk  reason: not valid java name */
    public static final void m1518writeUIntLeQn1smSk(Sink writeUIntLe, int i) {
        Intrinsics.checkNotNullParameter(writeUIntLe, "$this$writeUIntLe");
        writeIntLe(writeUIntLe, i);
    }

    /* renamed from: writeULongLe-2TYgG_w  reason: not valid java name */
    public static final void m1520writeULongLe2TYgG_w(Sink writeULongLe, long j) {
        Intrinsics.checkNotNullParameter(writeULongLe, "$this$writeULongLe");
        writeLongLe(writeULongLe, j);
    }

    public static final void writeFloat(Sink $this$writeFloat, float f) {
        Intrinsics.checkNotNullParameter($this$writeFloat, "<this>");
        $this$writeFloat.writeInt(Float.floatToIntBits(f));
    }

    public static final void writeDouble(Sink $this$writeDouble, double d) {
        Intrinsics.checkNotNullParameter($this$writeDouble, "<this>");
        $this$writeDouble.writeLong(Double.doubleToLongBits(d));
    }

    public static final void writeFloatLe(Sink $this$writeFloatLe, float f) {
        Intrinsics.checkNotNullParameter($this$writeFloatLe, "<this>");
        writeIntLe($this$writeFloatLe, Float.floatToIntBits(f));
    }

    public static final void writeDoubleLe(Sink $this$writeDoubleLe, double d) {
        Intrinsics.checkNotNullParameter($this$writeDoubleLe, "<this>");
        writeLongLe($this$writeDoubleLe, Double.doubleToLongBits(d));
    }

    public static final void writeToInternalBuffer(Sink $this$writeToInternalBuffer, Function1<? super Buffer, Unit> lambda) {
        Intrinsics.checkNotNullParameter($this$writeToInternalBuffer, "<this>");
        Intrinsics.checkNotNullParameter(lambda, "lambda");
        lambda.invoke($this$writeToInternalBuffer.getBuffer());
        $this$writeToInternalBuffer.hintEmit();
    }
}