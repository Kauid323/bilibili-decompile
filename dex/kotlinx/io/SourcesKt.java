package kotlinx.io;

import java.io.EOFException;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import org.msgpack.core.MessagePack;

/* compiled from: Sources.kt */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0010\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0002\u001a\n\u0010\t\u001a\u00020\u0006*\u00020\u0002\u001a\n\u0010\n\u001a\u00020\u0006*\u00020\u0002\u001a&\u0010\u000b\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u001a\n\u0010\u0010\u001a\u00020\u0011*\u00020\u0002\u001a\u0012\u0010\u0010\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0004\u001a\u0014\u0010\u0013\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0004H\u0002\u001a&\u0010\u0015\u001a\u00020\u0016*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u001a\u000f\u0010\u0018\u001a\u00020\u0019*\u00020\u0002¢\u0006\u0002\u0010\u001a\u001a\u000f\u0010\u001b\u001a\u00020\u001c*\u00020\u0002¢\u0006\u0002\u0010\u001d\u001a\u000f\u0010\u001e\u001a\u00020\u001f*\u00020\u0002¢\u0006\u0002\u0010 \u001a\u000f\u0010!\u001a\u00020\"*\u00020\u0002¢\u0006\u0002\u0010#\u001a\u000f\u0010$\u001a\u00020\u001c*\u00020\u0002¢\u0006\u0002\u0010\u001d\u001a\u000f\u0010%\u001a\u00020\u001f*\u00020\u0002¢\u0006\u0002\u0010 \u001a\u000f\u0010&\u001a\u00020\"*\u00020\u0002¢\u0006\u0002\u0010#\u001a\n\u0010'\u001a\u00020(*\u00020\u0002\u001a\n\u0010)\u001a\u00020**\u00020\u0002\u001a\n\u0010+\u001a\u00020(*\u00020\u0002\u001a\n\u0010,\u001a\u00020**\u00020\u0002\u001a\u0012\u0010-\u001a\u00020.*\u00020\u00022\u0006\u0010\f\u001a\u00020\r\"\u000e\u0010\u0007\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"readShortLe", "", "Lkotlinx/io/Source;", "readIntLe", "", "readLongLe", "", "OVERFLOW_ZONE", "OVERFLOW_DIGIT_START", "readDecimalLong", "readHexadecimalUnsignedLong", "indexOf", "byte", "", "startIndex", "endIndex", "readByteArray", "", "byteCount", "readByteArrayImpl", "size", "readTo", "", "sink", "readUByte", "Lkotlin/UByte;", "(Lkotlinx/io/Source;)B", "readUShort", "Lkotlin/UShort;", "(Lkotlinx/io/Source;)S", "readUInt", "Lkotlin/UInt;", "(Lkotlinx/io/Source;)I", "readULong", "Lkotlin/ULong;", "(Lkotlinx/io/Source;)J", "readUShortLe", "readUIntLe", "readULongLe", "readFloat", "", "readDouble", "", "readFloatLe", "readDoubleLe", "startsWith", "", "kotlinx-io-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SourcesKt {
    public static final long OVERFLOW_DIGIT_START = -7;
    public static final long OVERFLOW_ZONE = -922337203685477580L;

    public static final short readShortLe(Source $this$readShortLe) {
        Intrinsics.checkNotNullParameter($this$readShortLe, "<this>");
        return _UtilsJvmKt.reverseBytes($this$readShortLe.readShort());
    }

    public static final int readIntLe(Source $this$readIntLe) {
        Intrinsics.checkNotNullParameter($this$readIntLe, "<this>");
        return _UtilsJvmKt.reverseBytes($this$readIntLe.readInt());
    }

    public static final long readLongLe(Source $this$readLongLe) {
        Intrinsics.checkNotNullParameter($this$readLongLe, "<this>");
        return _UtilsJvmKt.reverseBytes($this$readLongLe.readLong());
    }

    /* JADX WARN: Code restructure failed: missing block: B:111:0x027b, code lost:
        r4 = new kotlinx.io.Buffer();
        kotlinx.io.SinksKt.writeDecimalLong(r4, r8);
        r4.writeByte(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x028a, code lost:
        if (r3 != false) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x028c, code lost:
        r4.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x02a9, code lost:
        throw new java.lang.NumberFormatException("Number too large: " + kotlinx.io.Utf8Kt.readString(r4));
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ed, code lost:
        r0 = new kotlinx.io.Buffer();
        kotlinx.io.SinksKt.writeDecimalLong(r0, r4);
        r0.writeByte(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00fc, code lost:
        if (r3 != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00fe, code lost:
        r0.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x011f, code lost:
        throw new java.lang.NumberFormatException(r28 + kotlinx.io.Utf8Kt.readString(r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0127, code lost:
        r31 = r6;
        r23 = r8;
        r8 = r4;
        r4 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01ba, code lost:
        r10 = new kotlinx.io.Buffer();
        kotlinx.io.SinksKt.writeDecimalLong(r10, r8);
        r10.writeByte(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01c9, code lost:
        if (r3 != false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01cb, code lost:
        r10.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01e8, code lost:
        throw new java.lang.NumberFormatException("Number too large: " + kotlinx.io.Utf8Kt.readString(r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01f8, code lost:
        r31 = r6;
        r4 = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02aa A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final long readDecimalLong(Source $this$readDecimalLong) {
        long bufferOffset;
        long bufferOffset2;
        long overflowDigit;
        long value;
        boolean finished;
        boolean z;
        long offset$iv;
        long offset$iv2;
        String str;
        Source source = $this$readDecimalLong;
        Intrinsics.checkNotNullParameter(source, "<this>");
        long j = 1;
        source.require(1L);
        boolean negative = false;
        long value2 = 0;
        long overflowDigit2 = -7;
        byte b = $this$readDecimalLong.getBuffer().get(0L);
        byte b2 = 58;
        byte b3 = 48;
        if (b == 45) {
            negative = true;
            overflowDigit2 = (-7) - 1;
            source.require(2L);
            byte b4 = $this$readDecimalLong.getBuffer().get(1L);
            if (!(48 <= b4 && b4 < 58)) {
                throw new NumberFormatException("Expected a digit but was 0x" + _UtilKt.toHexString($this$readDecimalLong.getBuffer().get(1L)));
            }
        } else {
            if (!(48 <= b && b < 58)) {
                throw new NumberFormatException("Expected a digit or '-' but was 0x" + _UtilKt.toHexString(b));
            }
            value2 = 48 - b;
        }
        long bufferOffset3 = 1;
        loop0: while (true) {
            if (!source.request(bufferOffset3 + j)) {
                break;
            }
            Buffer $this$seek$iv = $this$readDecimalLong.getBuffer();
            long fromIndex$iv = bufferOffset3;
            String str2 = "Number too large: ";
            if ($this$seek$iv.getHead() != null) {
                if ($this$seek$iv.getSize() - fromIndex$iv >= fromIndex$iv) {
                    long bufferOffset4 = value2;
                    Segment s$iv = $this$seek$iv.getHead();
                    long offset$iv3 = 0;
                    while (s$iv != null) {
                        long nextOffset$iv = (s$iv.getLimit() - s$iv.getPos()) + offset$iv3;
                        if (nextOffset$iv > fromIndex$iv) {
                            break;
                        }
                        s$iv = s$iv.getNext();
                        offset$iv3 = nextOffset$iv;
                    }
                    Segment seg = s$iv;
                    Intrinsics.checkNotNull(seg);
                    int currIdx = (int) (bufferOffset3 - offset$iv3);
                    int size = seg.getSize();
                    long j2 = bufferOffset3;
                    bufferOffset = bufferOffset4;
                    bufferOffset2 = j2;
                    while (true) {
                        if (currIdx >= size) {
                            overflowDigit = overflowDigit2;
                            value = 1;
                            finished = false;
                            break;
                        }
                        Segment s$iv2 = s$iv;
                        byte b5 = seg.getUnchecked$kotlinx_io_core(currIdx);
                        Segment seg2 = seg;
                        if (48 <= b5 && b5 < 58) {
                            z = true;
                            if (z) {
                                overflowDigit = overflowDigit2;
                                value = 1;
                                finished = true;
                                break;
                            }
                            int digit = 48 - b5;
                            if (bufferOffset < -922337203685477580L) {
                                break loop0;
                            }
                            if (bufferOffset == -922337203685477580L) {
                                offset$iv = offset$iv3;
                                long offset$iv4 = digit;
                                if (offset$iv4 < overflowDigit2) {
                                    break loop0;
                                }
                            } else {
                                offset$iv = offset$iv3;
                            }
                            long offset$iv5 = bufferOffset * 10;
                            long overflowDigit3 = overflowDigit2;
                            long overflowDigit4 = digit;
                            bufferOffset = offset$iv5 + overflowDigit4;
                            currIdx++;
                            bufferOffset2++;
                            s$iv = s$iv2;
                            seg = seg2;
                            offset$iv3 = offset$iv;
                            overflowDigit2 = overflowDigit3;
                        }
                        z = false;
                        if (z) {
                        }
                    }
                } else {
                    Segment s$iv3 = $this$seek$iv.getTail();
                    long offset$iv6 = $this$seek$iv.getSize();
                    while (s$iv3 != null && offset$iv6 > fromIndex$iv) {
                        offset$iv6 -= s$iv3.getLimit() - s$iv3.getPos();
                        if (offset$iv6 <= fromIndex$iv) {
                            break;
                        }
                        s$iv3 = s$iv3.getPrev();
                    }
                    Segment seg3 = s$iv3;
                    long offset = offset$iv6;
                    Intrinsics.checkNotNull(seg3);
                    long value3 = value2;
                    long value4 = bufferOffset3 - offset;
                    int currIdx2 = (int) value4;
                    int size2 = seg3.getSize();
                    long j3 = bufferOffset3;
                    bufferOffset = value3;
                    bufferOffset2 = j3;
                    while (true) {
                        if (currIdx2 >= size2) {
                            finished = false;
                            break;
                        }
                        Segment s$iv4 = s$iv3;
                        byte b6 = seg3.getUnchecked$kotlinx_io_core(currIdx2);
                        Segment seg4 = seg3;
                        if (!(48 <= b6 && b6 < 58)) {
                            finished = true;
                            break;
                        }
                        int digit2 = 48 - b6;
                        if (bufferOffset < -922337203685477580L) {
                            break loop0;
                        }
                        if (bufferOffset == -922337203685477580L) {
                            offset$iv2 = offset$iv6;
                            long offset$iv7 = digit2;
                            if (offset$iv7 < overflowDigit2) {
                                break loop0;
                            }
                        } else {
                            offset$iv2 = offset$iv6;
                        }
                        long offset$iv8 = bufferOffset * 10;
                        bufferOffset = offset$iv8 + digit2;
                        currIdx2++;
                        bufferOffset2++;
                        s$iv3 = s$iv4;
                        seg3 = seg4;
                        offset$iv6 = offset$iv2;
                        offset = offset;
                    }
                }
            } else {
                Segment seg5 = null;
                Intrinsics.checkNotNull(null);
                int currIdx3 = (int) (bufferOffset3 - (-1));
                int size3 = seg5.getSize();
                while (true) {
                    if (currIdx3 < size3) {
                        Segment seg6 = seg5;
                        byte b7 = seg6.getUnchecked$kotlinx_io_core(currIdx3);
                        if (!(b3 <= b7 && b7 < b2)) {
                            finished = true;
                            break;
                        }
                        int digit3 = 48 - b7;
                        if (value2 < -922337203685477580L) {
                            str = str2;
                            break loop0;
                        }
                        if (value2 == -922337203685477580L) {
                            str = str2;
                            if (digit3 < overflowDigit2) {
                                break loop0;
                            }
                        } else {
                            str = str2;
                        }
                        value2 = (value2 * 10) + digit3;
                        currIdx3++;
                        bufferOffset3++;
                        str2 = str;
                        seg5 = seg6;
                        b2 = 58;
                        b3 = 48;
                    } else {
                        finished = false;
                        break;
                    }
                }
            }
            if (finished) {
                value2 = bufferOffset;
                bufferOffset3 = bufferOffset2;
                break;
            }
            source = $this$readDecimalLong;
            j = value;
            value2 = bufferOffset;
            bufferOffset3 = bufferOffset2;
            overflowDigit2 = overflowDigit;
            b2 = 58;
            b3 = 48;
        }
        $this$readDecimalLong.skip(bufferOffset3);
        return negative ? value2 : -value2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01f1, code lost:
        r25 = r5;
        r4 = r3;
        r2 = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0288 A[LOOP:5: B:107:0x022e->B:137:0x0288, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02a0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x02d2 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final long readHexadecimalUnsignedLong(Source $this$readHexadecimalUnsignedLong) {
        int i;
        long result;
        long offset;
        long j;
        boolean stop;
        boolean z;
        boolean z2;
        boolean z3;
        int i2;
        int localOffset;
        boolean z4;
        int i3;
        byte b;
        boolean z5;
        int bDigit;
        Intrinsics.checkNotNullParameter($this$readHexadecimalUnsignedLong, "<this>");
        long j2 = 1;
        $this$readHexadecimalUnsignedLong.require(1L);
        byte b2 = $this$readHexadecimalUnsignedLong.getBuffer().get(0L);
        byte b3 = 58;
        byte b4 = 48;
        byte b5 = 65;
        byte b6 = 97;
        if (48 <= b2 && b2 < 58) {
            i = b2 + MessagePack.Code.INT8;
        } else {
            if (97 <= b2 && b2 < 103) {
                i = (b2 - 97) + 10;
            } else {
                if (!(65 <= b2 && b2 < 71)) {
                    throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + _UtilKt.toHexString(b2));
                }
                i = (b2 - 65) + 10;
            }
        }
        long result2 = i;
        long bytesRead = 1;
        while (true) {
            if (!$this$readHexadecimalUnsignedLong.request(bytesRead + j2)) {
                break;
            }
            Buffer $this$seek$iv = $this$readHexadecimalUnsignedLong.getBuffer();
            long fromIndex$iv = bytesRead;
            if ($this$seek$iv.getHead() != null) {
                if ($this$seek$iv.getSize() - fromIndex$iv >= fromIndex$iv) {
                    Segment s$iv = $this$seek$iv.getHead();
                    long offset$iv = 0;
                    while (s$iv != null) {
                        long nextOffset$iv = (s$iv.getLimit() - s$iv.getPos()) + offset$iv;
                        if (nextOffset$iv > fromIndex$iv) {
                            break;
                        }
                        s$iv = s$iv.getNext();
                        offset$iv = nextOffset$iv;
                    }
                    Segment seg = s$iv;
                    long offset2 = offset$iv;
                    Intrinsics.checkNotNull(seg);
                    long result3 = result2;
                    long result4 = bytesRead - offset2;
                    int startIndex = (int) result4;
                    int size = seg.getSize();
                    int localOffset2 = startIndex;
                    result = result3;
                    offset = bytesRead;
                    while (true) {
                        if (localOffset2 >= size) {
                            j = 1;
                            stop = false;
                            break;
                        }
                        byte b7 = seg.getUnchecked$kotlinx_io_core(localOffset2);
                        Segment s$iv2 = s$iv;
                        if (48 <= b7 && b7 < 58) {
                            z = true;
                            if (z) {
                                if (97 <= b7 && b7 < 103) {
                                    z2 = true;
                                    if (z2) {
                                        if (65 <= b7 && b7 < 71) {
                                            z3 = true;
                                            if (z3) {
                                                j = 1;
                                                stop = true;
                                                break;
                                            }
                                            i2 = (b7 - 65) + 10;
                                        }
                                        z3 = false;
                                        if (z3) {
                                        }
                                    } else {
                                        i2 = (b7 - 97) + 10;
                                    }
                                }
                                z2 = false;
                                if (z2) {
                                }
                            } else {
                                i2 = b7 + MessagePack.Code.INT8;
                            }
                            int bDigit2 = i2;
                            if ((result & (-1152921504606846976L)) == 0) {
                                Buffer $this$readHexadecimalUnsignedLong_u24lambda_u243_u24lambda_u242 = new Buffer();
                                SinksKt.writeHexadecimalUnsignedLong($this$readHexadecimalUnsignedLong_u24lambda_u243_u24lambda_u242, result);
                                $this$readHexadecimalUnsignedLong_u24lambda_u243_u24lambda_u242.writeByte(b7);
                                throw new NumberFormatException("Number too large: " + Utf8Kt.readString($this$readHexadecimalUnsignedLong_u24lambda_u243_u24lambda_u242));
                            }
                            result = (result << 4) + bDigit2;
                            offset++;
                            localOffset2++;
                            s$iv = s$iv2;
                            seg = seg;
                            startIndex = startIndex;
                        }
                        z = false;
                        if (z) {
                        }
                        int bDigit22 = i2;
                        if ((result & (-1152921504606846976L)) == 0) {
                        }
                    }
                } else {
                    Segment s$iv3 = $this$seek$iv.getTail();
                    long offset$iv2 = $this$seek$iv.getSize();
                    while (s$iv3 != null && offset$iv2 > fromIndex$iv) {
                        offset$iv2 -= s$iv3.getLimit() - s$iv3.getPos();
                        if (offset$iv2 <= fromIndex$iv) {
                            break;
                        }
                        s$iv3 = s$iv3.getPrev();
                    }
                    Segment seg2 = s$iv3;
                    long offset3 = offset$iv2;
                    Intrinsics.checkNotNull(seg2);
                    int bDigit3 = (int) (bytesRead - offset3);
                    int size2 = seg2.getSize();
                    while (true) {
                        if (bDigit3 >= size2) {
                            stop = false;
                            break;
                        }
                        byte b8 = seg2.getUnchecked$kotlinx_io_core(bDigit3);
                        Segment s$iv4 = s$iv3;
                        if (!(48 <= b8 && b8 < 58)) {
                            if (97 > b8 || b8 >= 103) {
                                localOffset = bDigit3;
                                z4 = false;
                            } else {
                                localOffset = bDigit3;
                                z4 = true;
                            }
                            if (!z4) {
                                if (!(65 <= b8 && b8 < 71)) {
                                    stop = true;
                                    break;
                                }
                                i3 = (b8 - 65) + 10;
                            } else {
                                i3 = (b8 - 97) + 10;
                            }
                        } else {
                            i3 = b8 + MessagePack.Code.INT8;
                            localOffset = bDigit3;
                        }
                        int bDigit4 = i3;
                        if ((result2 & (-1152921504606846976L)) != 0) {
                            Buffer $this$readHexadecimalUnsignedLong_u24lambda_u243_u24lambda_u2422 = new Buffer();
                            SinksKt.writeHexadecimalUnsignedLong($this$readHexadecimalUnsignedLong_u24lambda_u243_u24lambda_u2422, result2);
                            $this$readHexadecimalUnsignedLong_u24lambda_u243_u24lambda_u2422.writeByte(b8);
                            throw new NumberFormatException("Number too large: " + Utf8Kt.readString($this$readHexadecimalUnsignedLong_u24lambda_u243_u24lambda_u2422));
                        }
                        long offset$iv3 = offset$iv2;
                        long offset$iv4 = bDigit4;
                        result2 = (result2 << 4) + offset$iv4;
                        bytesRead++;
                        bDigit3 = localOffset + 1;
                        s$iv3 = s$iv4;
                        offset$iv2 = offset$iv3;
                    }
                }
            } else {
                Segment seg3 = null;
                Intrinsics.checkNotNull(null);
                int size3 = seg3.getSize();
                int localOffset3 = (int) (bytesRead - (-1));
                while (true) {
                    if (localOffset3 >= size3) {
                        stop = false;
                        break;
                    }
                    byte b9 = seg3.getUnchecked$kotlinx_io_core(localOffset3);
                    if (!(b4 <= b9 && b9 < b3)) {
                        if (b6 > b9 || b9 >= 103) {
                            b = b9;
                            z5 = false;
                        } else {
                            b = b9;
                            z5 = true;
                        }
                        if (!z5) {
                            if (!(b5 <= b && b < 71)) {
                                stop = true;
                                break;
                            }
                            bDigit = (b - 65) + 10;
                        } else {
                            bDigit = (b - 97) + 10;
                        }
                    } else {
                        b = b9;
                        bDigit = b9 + MessagePack.Code.INT8;
                    }
                    if ((result2 & (-1152921504606846976L)) != 0) {
                        Buffer $this$readHexadecimalUnsignedLong_u24lambda_u243_u24lambda_u2423 = new Buffer();
                        SinksKt.writeHexadecimalUnsignedLong($this$readHexadecimalUnsignedLong_u24lambda_u243_u24lambda_u2423, result2);
                        $this$readHexadecimalUnsignedLong_u24lambda_u243_u24lambda_u2423.writeByte(b);
                        throw new NumberFormatException("Number too large: " + Utf8Kt.readString($this$readHexadecimalUnsignedLong_u24lambda_u243_u24lambda_u2423));
                    }
                    result2 = (result2 << 4) + bDigit;
                    bytesRead++;
                    localOffset3++;
                    b3 = 58;
                    b6 = 97;
                }
                offset = bytesRead;
                result = result2;
                j = 1;
            }
            if (stop) {
                result2 = result;
                bytesRead = offset;
                break;
            }
            j2 = j;
            result2 = result;
            bytesRead = offset;
            b3 = 58;
            b6 = 97;
            b4 = 48;
            b5 = 65;
        }
        $this$readHexadecimalUnsignedLong.skip(bytesRead);
        return result2;
    }

    public static /* synthetic */ long indexOf$default(Source source, byte b, long j, long j2, int i, Object obj) {
        long j3;
        long j4;
        if ((i & 2) == 0) {
            j3 = j;
        } else {
            j3 = 0;
        }
        if ((i & 4) == 0) {
            j4 = j2;
        } else {
            j4 = Long.MAX_VALUE;
        }
        return indexOf(source, b, j3, j4);
    }

    public static final long indexOf(Source $this$indexOf, byte b, long startIndex, long endIndex) {
        String str;
        Intrinsics.checkNotNullParameter($this$indexOf, "<this>");
        boolean z = false;
        if (0 <= startIndex && startIndex <= endIndex) {
            z = true;
        }
        if (!z) {
            if (endIndex < 0) {
                str = "startIndex (" + startIndex + ") and endIndex (" + endIndex + ") should be non negative";
            } else {
                str = "startIndex (" + startIndex + ") is not within the range [0..endIndex(" + endIndex + "))";
            }
            throw new IllegalArgumentException(str.toString());
        } else if (startIndex == endIndex) {
            return -1L;
        } else {
            long offset = startIndex;
            while (offset < endIndex && $this$indexOf.request(1 + offset)) {
                long idx = BuffersKt.indexOf($this$indexOf.getBuffer(), b, offset, Math.min(endIndex, $this$indexOf.getBuffer().getSize()));
                if (idx != -1) {
                    return idx;
                }
                offset = $this$indexOf.getBuffer().getSize();
            }
            return -1L;
        }
    }

    public static final byte[] readByteArray(Source $this$readByteArray) {
        Intrinsics.checkNotNullParameter($this$readByteArray, "<this>");
        return readByteArrayImpl($this$readByteArray, -1);
    }

    public static final byte[] readByteArray(Source $this$readByteArray, int byteCount) {
        Intrinsics.checkNotNullParameter($this$readByteArray, "<this>");
        long byteCount$iv = byteCount;
        if (byteCount$iv >= 0) {
            return readByteArrayImpl($this$readByteArray, byteCount);
        }
        throw new IllegalArgumentException(("byteCount (" + byteCount$iv + ") < 0").toString());
    }

    private static final byte[] readByteArrayImpl(Source $this$readByteArrayImpl, int size) {
        int arraySize = size;
        if (size == -1) {
            for (long fetchSize = 2147483647L; $this$readByteArrayImpl.getBuffer().getSize() < 2147483647L && $this$readByteArrayImpl.request(fetchSize); fetchSize *= 2) {
            }
            if (!($this$readByteArrayImpl.getBuffer().getSize() < 2147483647L)) {
                throw new IllegalStateException(("Can't create an array of size " + $this$readByteArrayImpl.getBuffer().getSize()).toString());
            }
            arraySize = (int) $this$readByteArrayImpl.getBuffer().getSize();
        } else {
            long fetchSize2 = size;
            $this$readByteArrayImpl.require(fetchSize2);
        }
        byte[] array = new byte[arraySize];
        readTo$default($this$readByteArrayImpl.getBuffer(), array, 0, 0, 6, null);
        return array;
    }

    public static /* synthetic */ void readTo$default(Source source, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        readTo(source, bArr, i, i2);
    }

    public static final void readTo(Source $this$readTo, byte[] sink, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$readTo, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        int size$iv = sink.length;
        _UtilKt.checkBounds(size$iv, startIndex, endIndex);
        int offset = startIndex;
        while (offset < endIndex) {
            int bytesRead = $this$readTo.readAtMostTo(sink, offset, endIndex);
            if (bytesRead == -1) {
                throw new EOFException("Source exhausted before reading " + (endIndex - startIndex) + " bytes. Only " + bytesRead + " bytes were read.");
            }
            offset += bytesRead;
        }
    }

    public static final byte readUByte(Source $this$readUByte) {
        Intrinsics.checkNotNullParameter($this$readUByte, "<this>");
        return UByte.constructor-impl($this$readUByte.readByte());
    }

    public static final short readUShort(Source $this$readUShort) {
        Intrinsics.checkNotNullParameter($this$readUShort, "<this>");
        return UShort.constructor-impl($this$readUShort.readShort());
    }

    public static final int readUInt(Source $this$readUInt) {
        Intrinsics.checkNotNullParameter($this$readUInt, "<this>");
        return UInt.constructor-impl($this$readUInt.readInt());
    }

    public static final long readULong(Source $this$readULong) {
        Intrinsics.checkNotNullParameter($this$readULong, "<this>");
        return ULong.constructor-impl($this$readULong.readLong());
    }

    public static final short readUShortLe(Source $this$readUShortLe) {
        Intrinsics.checkNotNullParameter($this$readUShortLe, "<this>");
        return UShort.constructor-impl(readShortLe($this$readUShortLe));
    }

    public static final int readUIntLe(Source $this$readUIntLe) {
        Intrinsics.checkNotNullParameter($this$readUIntLe, "<this>");
        return UInt.constructor-impl(readIntLe($this$readUIntLe));
    }

    public static final long readULongLe(Source $this$readULongLe) {
        Intrinsics.checkNotNullParameter($this$readULongLe, "<this>");
        return ULong.constructor-impl(readLongLe($this$readULongLe));
    }

    public static final float readFloat(Source $this$readFloat) {
        Intrinsics.checkNotNullParameter($this$readFloat, "<this>");
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat($this$readFloat.readInt());
    }

    public static final double readDouble(Source $this$readDouble) {
        Intrinsics.checkNotNullParameter($this$readDouble, "<this>");
        DoubleCompanionObject doubleCompanionObject = DoubleCompanionObject.INSTANCE;
        return Double.longBitsToDouble($this$readDouble.readLong());
    }

    public static final float readFloatLe(Source $this$readFloatLe) {
        Intrinsics.checkNotNullParameter($this$readFloatLe, "<this>");
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat(readIntLe($this$readFloatLe));
    }

    public static final double readDoubleLe(Source $this$readDoubleLe) {
        Intrinsics.checkNotNullParameter($this$readDoubleLe, "<this>");
        DoubleCompanionObject doubleCompanionObject = DoubleCompanionObject.INSTANCE;
        return Double.longBitsToDouble(readLongLe($this$readDoubleLe));
    }

    public static final boolean startsWith(Source $this$startsWith, byte b) {
        Intrinsics.checkNotNullParameter($this$startsWith, "<this>");
        return $this$startsWith.request(1L) && $this$startsWith.getBuffer().get(0L) == b;
    }
}