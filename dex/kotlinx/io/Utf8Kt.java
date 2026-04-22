package kotlinx.io;

import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.Ref;
import kotlinx.io.internal._Utf8Kt;
import kotlinx.io.unsafe.SegmentReadContext;
import kotlinx.io.unsafe.SegmentWriteContext;
import kotlinx.io.unsafe.UnsafeBufferOperations;
import kotlinx.io.unsafe.UnsafeBufferOperationsKt;

/* compiled from: Utf8.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0003\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0000\u001a\u0012\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u0004\u001a&\u0010\n\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u001a&\u0010\n\u001a\u00020\u0007*\u00020\b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u001a\n\u0010\u000e\u001a\u00020\u0002*\u00020\u000f\u001a\n\u0010\u000e\u001a\u00020\u0002*\u00020\u0010\u001a\u0012\u0010\u000e\u001a\u00020\u0002*\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0001\u001a\n\u0010\u0012\u001a\u00020\u0004*\u00020\u000f\u001a\f\u0010\u0013\u001a\u0004\u0018\u00010\u0002*\u00020\u000f\u001a\u0014\u0010\u0014\u001a\u00020\u0002*\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u0001\u001a\f\u0010\u0016\u001a\u00020\u0004*\u00020\u0010H\u0002\u001a1\u0010\u0017\u001a\u00020\u0007*\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001b0\u001aH\u0082\b\u001a\u0014\u0010\u001c\u001a\u00020\u0007*\u00020\u00102\u0006\u0010\t\u001a\u00020\u0004H\u0002\u001a\u0014\u0010\u001d\u001a\u00020\u0002*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0001H\u0002¨\u0006\u001e"}, d2 = {"utf8Size", "", "", "startIndex", "", "endIndex", "writeCodePointValue", "", "Lkotlinx/io/Sink;", "codePoint", "writeString", "string", "chars", "", "readString", "Lkotlinx/io/Source;", "Lkotlinx/io/Buffer;", "byteCount", "readCodePointValue", "readLine", "readLineStrict", "limit", "commonReadUtf8CodePoint", "commonWriteUtf8", "beginIndex", "charAt", "Lkotlin/Function1;", "", "commonWriteUtf8CodePoint", "commonReadUtf8", "kotlinx-io-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class Utf8Kt {
    public static /* synthetic */ long utf8Size$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return utf8Size(str, i, i2);
    }

    public static final long utf8Size(String $this$utf8Size, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$utf8Size, "<this>");
        int size$iv = $this$utf8Size.length();
        _UtilKt.checkBounds(size$iv, startIndex, endIndex);
        long result = 0;
        int i = startIndex;
        while (i < endIndex) {
            int c = $this$utf8Size.charAt(i);
            if (c < 128) {
                result++;
                i++;
            } else if (c < 2048) {
                result += 2;
                i++;
            } else if (c < 55296 || c > 57343) {
                result += 3;
                i++;
            } else {
                int low = i + 1 < endIndex ? $this$utf8Size.charAt(i + 1) : 0;
                if (c > 56319 || low < 56320 || low > 57343) {
                    result++;
                    i++;
                } else {
                    result += 4;
                    i += 2;
                }
            }
        }
        return result;
    }

    public static final void writeCodePointValue(Sink $this$writeCodePointValue, int codePoint) {
        Intrinsics.checkNotNullParameter($this$writeCodePointValue, "<this>");
        Buffer it = $this$writeCodePointValue.getBuffer();
        commonWriteUtf8CodePoint(it, codePoint);
        $this$writeCodePointValue.hintEmit();
    }

    public static /* synthetic */ void writeString$default(Sink sink, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = str.length();
        }
        writeString(sink, str, i, i2);
    }

    public static final void writeString(Sink $this$writeString, String string, int startIndex, int endIndex) {
        SegmentWriteContext ctx$iv;
        SegmentWriteContext ctx$iv2;
        SegmentWriteContext ctx$iv3;
        int i;
        SegmentWriteContext ctx$iv4;
        String string2 = string;
        int i2 = endIndex;
        Intrinsics.checkNotNullParameter($this$writeString, "<this>");
        Intrinsics.checkNotNullParameter(string2, "string");
        int size$iv = string.length();
        _UtilKt.checkBounds(size$iv, startIndex, i2);
        int codePoint$iv = 0;
        Buffer it = $this$writeString.getBuffer();
        int i3 = 0;
        int $i$f$commonWriteUtf8 = 0;
        int i$iv = startIndex;
        while (i$iv < i2) {
            Ref.IntRef c$iv = new Ref.IntRef();
            int p0 = i$iv;
            c$iv.element = Character.valueOf(string2.charAt(p0)).charValue();
            if (c$iv.element < 128) {
                UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
                Segment tail$iv$iv = it.writableSegment(1);
                ctx$iv = UnsafeBufferOperationsKt.SegmentWriteContextImpl;
                int $i$f$writeToInternalBuffer = codePoint$iv;
                int $i$f$writeToInternalBuffer2 = -i$iv;
                Buffer it2 = it;
                int i$iv2 = Math.min(i2, i$iv + tail$iv$iv.getRemainingCapacity());
                int i4 = i3;
                int $i$f$commonWriteUtf82 = $i$f$commonWriteUtf8;
                ctx$iv.setUnchecked(tail$iv$iv, i$iv + $i$f$writeToInternalBuffer2, (byte) c$iv.element);
                i$iv++;
                while (i$iv < i$iv2) {
                    int p02 = i$iv;
                    c$iv.element = Character.valueOf(string2.charAt(p02)).charValue();
                    int runLimit$iv = i$iv2;
                    if (c$iv.element >= 128) {
                        break;
                    }
                    ctx$iv.setUnchecked(tail$iv$iv, i$iv + $i$f$writeToInternalBuffer2, (byte) c$iv.element);
                    i$iv++;
                    i$iv2 = runLimit$iv;
                }
                int bytesWritten$iv$iv = $i$f$writeToInternalBuffer2 + i$iv;
                if (bytesWritten$iv$iv == 1) {
                    tail$iv$iv.setLimit(tail$iv$iv.getLimit() + bytesWritten$iv$iv);
                    it.setSizeMut(it.getSizeMut() + bytesWritten$iv$iv);
                } else {
                    if (!(bytesWritten$iv$iv >= 0 && bytesWritten$iv$iv <= tail$iv$iv.getRemainingCapacity())) {
                        throw new IllegalStateException(("Invalid number of bytes written: " + bytesWritten$iv$iv + ". Should be in 0.." + tail$iv$iv.getRemainingCapacity()).toString());
                    }
                    if (bytesWritten$iv$iv != 0) {
                        tail$iv$iv.setLimit(tail$iv$iv.getLimit() + bytesWritten$iv$iv);
                        it.setSizeMut(it.getSizeMut() + bytesWritten$iv$iv);
                    } else if (SegmentKt.isEmpty(tail$iv$iv)) {
                        it.recycleTail();
                    }
                }
                codePoint$iv = $i$f$writeToInternalBuffer;
                it = it2;
                i3 = i4;
                $i$f$commonWriteUtf8 = $i$f$commonWriteUtf82;
            } else {
                int $i$f$writeToInternalBuffer3 = codePoint$iv;
                Buffer it3 = it;
                int i5 = i3;
                int $i$f$commonWriteUtf83 = $i$f$commonWriteUtf8;
                if (c$iv.element < 2048) {
                    UnsafeBufferOperations unsafeBufferOperations2 = UnsafeBufferOperations.INSTANCE;
                    Segment tail$iv$iv2 = it.writableSegment(2);
                    ctx$iv2 = UnsafeBufferOperationsKt.SegmentWriteContextImpl;
                    boolean z = false;
                    ctx$iv2.setUnchecked(tail$iv$iv2, 0, (byte) ((c$iv.element >> 6) | 192), (byte) ((c$iv.element & 63) | 128));
                    if (2 == 2) {
                        tail$iv$iv2.setLimit(tail$iv$iv2.getLimit() + 2);
                        it.setSizeMut(it.getSizeMut() + 2);
                    } else {
                        if (2 >= 0 && 2 <= tail$iv$iv2.getRemainingCapacity()) {
                            z = true;
                        }
                        if (!z) {
                            throw new IllegalStateException(("Invalid number of bytes written: 2. Should be in 0.." + tail$iv$iv2.getRemainingCapacity()).toString());
                        }
                        if (2 != 0) {
                            tail$iv$iv2.setLimit(tail$iv$iv2.getLimit() + 2);
                            it.setSizeMut(it.getSizeMut() + 2);
                        } else if (SegmentKt.isEmpty(tail$iv$iv2)) {
                            it.recycleTail();
                        }
                    }
                    i$iv++;
                    codePoint$iv = $i$f$writeToInternalBuffer3;
                    it = it3;
                    i3 = i5;
                    $i$f$commonWriteUtf8 = $i$f$commonWriteUtf83;
                } else if (c$iv.element < 55296 || c$iv.element > 57343) {
                    UnsafeBufferOperations unsafeBufferOperations3 = UnsafeBufferOperations.INSTANCE;
                    Segment tail$iv$iv3 = it.writableSegment(3);
                    ctx$iv3 = UnsafeBufferOperationsKt.SegmentWriteContextImpl;
                    ctx$iv3.setUnchecked(tail$iv$iv3, 0, (byte) ((c$iv.element >> 12) | 224), (byte) (((c$iv.element >> 6) & 63) | 128), (byte) ((63 & c$iv.element) | 128));
                    if (3 == 3) {
                        tail$iv$iv3.setLimit(tail$iv$iv3.getLimit() + 3);
                        it.setSizeMut(it.getSizeMut() + 3);
                    } else {
                        if (!(3 >= 0 && 3 <= tail$iv$iv3.getRemainingCapacity())) {
                            throw new IllegalStateException(("Invalid number of bytes written: 3. Should be in 0.." + tail$iv$iv3.getRemainingCapacity()).toString());
                        }
                        if (3 != 0) {
                            tail$iv$iv3.setLimit(tail$iv$iv3.getLimit() + 3);
                            it.setSizeMut(it.getSizeMut() + 3);
                        } else if (SegmentKt.isEmpty(tail$iv$iv3)) {
                            it.recycleTail();
                        }
                    }
                    i$iv++;
                    string2 = string;
                    i2 = endIndex;
                    codePoint$iv = $i$f$writeToInternalBuffer3;
                    it = it3;
                    i3 = i5;
                    $i$f$commonWriteUtf8 = $i$f$commonWriteUtf83;
                } else {
                    if (i$iv + 1 < i2) {
                        int p03 = i$iv + 1;
                        i = string2.charAt(p03);
                    } else {
                        i = 0;
                    }
                    if (c$iv.element <= 56319) {
                        if (56320 <= i && i < 57344) {
                            int codePoint$iv2 = (((c$iv.element & 1023) << 10) | (i & 1023)) + 65536;
                            UnsafeBufferOperations unsafeBufferOperations4 = UnsafeBufferOperations.INSTANCE;
                            Segment tail$iv$iv4 = it.writableSegment(4);
                            ctx$iv4 = UnsafeBufferOperationsKt.SegmentWriteContextImpl;
                            int low$iv = (codePoint$iv2 >> 6) & 63;
                            ctx$iv4.setUnchecked(tail$iv$iv4, 0, (byte) ((codePoint$iv2 >> 18) | 240), (byte) (((codePoint$iv2 >> 12) & 63) | 128), (byte) (low$iv | 128), (byte) (128 | (codePoint$iv2 & 63)));
                            if (4 == 4) {
                                tail$iv$iv4.setLimit(tail$iv$iv4.getLimit() + 4);
                                it.setSizeMut(it.getSizeMut() + 4);
                            } else {
                                if (!(4 >= 0 && 4 <= tail$iv$iv4.getRemainingCapacity())) {
                                    throw new IllegalStateException(("Invalid number of bytes written: 4. Should be in 0.." + tail$iv$iv4.getRemainingCapacity()).toString());
                                }
                                if (4 != 0) {
                                    tail$iv$iv4.setLimit(tail$iv$iv4.getLimit() + 4);
                                    it.setSizeMut(it.getSizeMut() + 4);
                                } else if (SegmentKt.isEmpty(tail$iv$iv4)) {
                                    it.recycleTail();
                                }
                            }
                            i$iv += 2;
                            string2 = string;
                            i2 = endIndex;
                            codePoint$iv = $i$f$writeToInternalBuffer3;
                            it = it3;
                            i3 = i5;
                            $i$f$commonWriteUtf8 = $i$f$commonWriteUtf83;
                        }
                    }
                    it.writeByte((byte) 63);
                    i$iv++;
                    string2 = string;
                    i2 = endIndex;
                    codePoint$iv = $i$f$writeToInternalBuffer3;
                    it = it3;
                    i3 = i5;
                    $i$f$commonWriteUtf8 = $i$f$commonWriteUtf83;
                }
            }
        }
        $this$writeString.hintEmit();
    }

    public static /* synthetic */ void writeString$default(Sink sink, CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        writeString(sink, charSequence, i, i2);
    }

    public static final void writeString(Sink $this$writeString, CharSequence chars, int startIndex, int endIndex) {
        SegmentWriteContext ctx$iv;
        SegmentWriteContext ctx$iv2;
        SegmentWriteContext ctx$iv3;
        int i;
        SegmentWriteContext ctx$iv4;
        CharSequence chars2 = chars;
        int i2 = endIndex;
        Intrinsics.checkNotNullParameter($this$writeString, "<this>");
        Intrinsics.checkNotNullParameter(chars2, "chars");
        int size$iv = chars.length();
        _UtilKt.checkBounds(size$iv, startIndex, i2);
        int codePoint$iv = 0;
        Buffer it = $this$writeString.getBuffer();
        int i3 = 0;
        int $i$f$commonWriteUtf8 = 0;
        int i$iv = startIndex;
        while (i$iv < i2) {
            Ref.IntRef c$iv = new Ref.IntRef();
            int p0 = i$iv;
            c$iv.element = Character.valueOf(chars2.charAt(p0)).charValue();
            if (c$iv.element < 128) {
                UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
                Segment tail$iv$iv = it.writableSegment(1);
                ctx$iv = UnsafeBufferOperationsKt.SegmentWriteContextImpl;
                int $i$f$writeToInternalBuffer = codePoint$iv;
                int $i$f$writeToInternalBuffer2 = -i$iv;
                Buffer it2 = it;
                int i$iv2 = Math.min(i2, i$iv + tail$iv$iv.getRemainingCapacity());
                int i4 = i3;
                int $i$f$commonWriteUtf82 = $i$f$commonWriteUtf8;
                ctx$iv.setUnchecked(tail$iv$iv, i$iv + $i$f$writeToInternalBuffer2, (byte) c$iv.element);
                i$iv++;
                while (i$iv < i$iv2) {
                    int p02 = i$iv;
                    c$iv.element = Character.valueOf(chars2.charAt(p02)).charValue();
                    int runLimit$iv = i$iv2;
                    if (c$iv.element >= 128) {
                        break;
                    }
                    ctx$iv.setUnchecked(tail$iv$iv, i$iv + $i$f$writeToInternalBuffer2, (byte) c$iv.element);
                    i$iv++;
                    i$iv2 = runLimit$iv;
                }
                int bytesWritten$iv$iv = $i$f$writeToInternalBuffer2 + i$iv;
                if (bytesWritten$iv$iv == 1) {
                    tail$iv$iv.setLimit(tail$iv$iv.getLimit() + bytesWritten$iv$iv);
                    it.setSizeMut(it.getSizeMut() + bytesWritten$iv$iv);
                } else {
                    if (!(bytesWritten$iv$iv >= 0 && bytesWritten$iv$iv <= tail$iv$iv.getRemainingCapacity())) {
                        throw new IllegalStateException(("Invalid number of bytes written: " + bytesWritten$iv$iv + ". Should be in 0.." + tail$iv$iv.getRemainingCapacity()).toString());
                    }
                    if (bytesWritten$iv$iv != 0) {
                        tail$iv$iv.setLimit(tail$iv$iv.getLimit() + bytesWritten$iv$iv);
                        it.setSizeMut(it.getSizeMut() + bytesWritten$iv$iv);
                    } else if (SegmentKt.isEmpty(tail$iv$iv)) {
                        it.recycleTail();
                    }
                }
                codePoint$iv = $i$f$writeToInternalBuffer;
                it = it2;
                i3 = i4;
                $i$f$commonWriteUtf8 = $i$f$commonWriteUtf82;
            } else {
                int $i$f$writeToInternalBuffer3 = codePoint$iv;
                Buffer it3 = it;
                int i5 = i3;
                int $i$f$commonWriteUtf83 = $i$f$commonWriteUtf8;
                if (c$iv.element < 2048) {
                    UnsafeBufferOperations unsafeBufferOperations2 = UnsafeBufferOperations.INSTANCE;
                    Segment tail$iv$iv2 = it.writableSegment(2);
                    ctx$iv2 = UnsafeBufferOperationsKt.SegmentWriteContextImpl;
                    boolean z = false;
                    ctx$iv2.setUnchecked(tail$iv$iv2, 0, (byte) ((c$iv.element >> 6) | 192), (byte) ((c$iv.element & 63) | 128));
                    if (2 == 2) {
                        tail$iv$iv2.setLimit(tail$iv$iv2.getLimit() + 2);
                        it.setSizeMut(it.getSizeMut() + 2);
                    } else {
                        if (2 >= 0 && 2 <= tail$iv$iv2.getRemainingCapacity()) {
                            z = true;
                        }
                        if (!z) {
                            throw new IllegalStateException(("Invalid number of bytes written: 2. Should be in 0.." + tail$iv$iv2.getRemainingCapacity()).toString());
                        }
                        if (2 != 0) {
                            tail$iv$iv2.setLimit(tail$iv$iv2.getLimit() + 2);
                            it.setSizeMut(it.getSizeMut() + 2);
                        } else if (SegmentKt.isEmpty(tail$iv$iv2)) {
                            it.recycleTail();
                        }
                    }
                    i$iv++;
                    codePoint$iv = $i$f$writeToInternalBuffer3;
                    it = it3;
                    i3 = i5;
                    $i$f$commonWriteUtf8 = $i$f$commonWriteUtf83;
                } else if (c$iv.element < 55296 || c$iv.element > 57343) {
                    UnsafeBufferOperations unsafeBufferOperations3 = UnsafeBufferOperations.INSTANCE;
                    Segment tail$iv$iv3 = it.writableSegment(3);
                    ctx$iv3 = UnsafeBufferOperationsKt.SegmentWriteContextImpl;
                    ctx$iv3.setUnchecked(tail$iv$iv3, 0, (byte) ((c$iv.element >> 12) | 224), (byte) (((c$iv.element >> 6) & 63) | 128), (byte) ((63 & c$iv.element) | 128));
                    if (3 == 3) {
                        tail$iv$iv3.setLimit(tail$iv$iv3.getLimit() + 3);
                        it.setSizeMut(it.getSizeMut() + 3);
                    } else {
                        if (!(3 >= 0 && 3 <= tail$iv$iv3.getRemainingCapacity())) {
                            throw new IllegalStateException(("Invalid number of bytes written: 3. Should be in 0.." + tail$iv$iv3.getRemainingCapacity()).toString());
                        }
                        if (3 != 0) {
                            tail$iv$iv3.setLimit(tail$iv$iv3.getLimit() + 3);
                            it.setSizeMut(it.getSizeMut() + 3);
                        } else if (SegmentKt.isEmpty(tail$iv$iv3)) {
                            it.recycleTail();
                        }
                    }
                    i$iv++;
                    chars2 = chars;
                    i2 = endIndex;
                    codePoint$iv = $i$f$writeToInternalBuffer3;
                    it = it3;
                    i3 = i5;
                    $i$f$commonWriteUtf8 = $i$f$commonWriteUtf83;
                } else {
                    if (i$iv + 1 < i2) {
                        int p03 = i$iv + 1;
                        i = chars2.charAt(p03);
                    } else {
                        i = 0;
                    }
                    if (c$iv.element <= 56319) {
                        if (56320 <= i && i < 57344) {
                            int codePoint$iv2 = (((c$iv.element & 1023) << 10) | (i & 1023)) + 65536;
                            UnsafeBufferOperations unsafeBufferOperations4 = UnsafeBufferOperations.INSTANCE;
                            Segment tail$iv$iv4 = it.writableSegment(4);
                            ctx$iv4 = UnsafeBufferOperationsKt.SegmentWriteContextImpl;
                            int low$iv = (codePoint$iv2 >> 6) & 63;
                            ctx$iv4.setUnchecked(tail$iv$iv4, 0, (byte) ((codePoint$iv2 >> 18) | 240), (byte) (((codePoint$iv2 >> 12) & 63) | 128), (byte) (low$iv | 128), (byte) (128 | (codePoint$iv2 & 63)));
                            if (4 == 4) {
                                tail$iv$iv4.setLimit(tail$iv$iv4.getLimit() + 4);
                                it.setSizeMut(it.getSizeMut() + 4);
                            } else {
                                if (!(4 >= 0 && 4 <= tail$iv$iv4.getRemainingCapacity())) {
                                    throw new IllegalStateException(("Invalid number of bytes written: 4. Should be in 0.." + tail$iv$iv4.getRemainingCapacity()).toString());
                                }
                                if (4 != 0) {
                                    tail$iv$iv4.setLimit(tail$iv$iv4.getLimit() + 4);
                                    it.setSizeMut(it.getSizeMut() + 4);
                                } else if (SegmentKt.isEmpty(tail$iv$iv4)) {
                                    it.recycleTail();
                                }
                            }
                            i$iv += 2;
                            chars2 = chars;
                            i2 = endIndex;
                            codePoint$iv = $i$f$writeToInternalBuffer3;
                            it = it3;
                            i3 = i5;
                            $i$f$commonWriteUtf8 = $i$f$commonWriteUtf83;
                        }
                    }
                    it.writeByte((byte) 63);
                    i$iv++;
                    chars2 = chars;
                    i2 = endIndex;
                    codePoint$iv = $i$f$writeToInternalBuffer3;
                    it = it3;
                    i3 = i5;
                    $i$f$commonWriteUtf8 = $i$f$commonWriteUtf83;
                }
            }
        }
        $this$writeString.hintEmit();
    }

    public static final String readString(Source $this$readString) {
        Intrinsics.checkNotNullParameter($this$readString, "<this>");
        $this$readString.request(LongCompanionObject.MAX_VALUE);
        return commonReadUtf8($this$readString.getBuffer(), $this$readString.getBuffer().getSize());
    }

    public static final String readString(Buffer $this$readString) {
        Intrinsics.checkNotNullParameter($this$readString, "<this>");
        return commonReadUtf8($this$readString, $this$readString.getSize());
    }

    public static final String readString(Source $this$readString, long byteCount) {
        Intrinsics.checkNotNullParameter($this$readString, "<this>");
        $this$readString.require(byteCount);
        return commonReadUtf8($this$readString.getBuffer(), byteCount);
    }

    public static final int readCodePointValue(Source $this$readCodePointValue) {
        Intrinsics.checkNotNullParameter($this$readCodePointValue, "<this>");
        if ($this$readCodePointValue instanceof Buffer) {
            return commonReadUtf8CodePoint((Buffer) $this$readCodePointValue);
        }
        $this$readCodePointValue.require(1L);
        int b0 = $this$readCodePointValue.getBuffer().get(0L);
        if ((b0 & 224) == 192) {
            $this$readCodePointValue.require(2L);
        } else if ((b0 & 240) == 224) {
            $this$readCodePointValue.require(3L);
        } else if ((b0 & 248) == 240) {
            $this$readCodePointValue.require(4L);
        }
        return commonReadUtf8CodePoint($this$readCodePointValue.getBuffer());
    }

    public static final String readLine(Source $this$readLine) {
        Intrinsics.checkNotNullParameter($this$readLine, "<this>");
        if ($this$readLine.request(1L)) {
            long lfIndex = SourcesKt.indexOf$default($this$readLine, (byte) 10, 0L, 0L, 6, null);
            if (lfIndex == -1) {
                String string = readString($this$readLine);
                return string;
            } else if (lfIndex == 0) {
                $this$readLine.skip(1L);
                return "";
            } else {
                int skipBytes = 1;
                if ($this$readLine.getBuffer().get(lfIndex - 1) == 13) {
                    lfIndex--;
                    skipBytes = 1 + 1;
                }
                String string2 = readString($this$readLine, lfIndex);
                $this$readLine.skip(skipBytes);
                return string2;
            }
        }
        return null;
    }

    public static /* synthetic */ String readLineStrict$default(Source source, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = LongCompanionObject.MAX_VALUE;
        }
        return readLineStrict(source, j);
    }

    public static final String readLineStrict(Source $this$readLineStrict, long limit) {
        Intrinsics.checkNotNullParameter($this$readLineStrict, "<this>");
        if (!(limit >= 0)) {
            throw new IllegalArgumentException(("limit (" + limit + ") < 0").toString());
        }
        $this$readLineStrict.require(1L);
        long lfIndex = SourcesKt.indexOf($this$readLineStrict, (byte) 10, 0L, limit);
        if (lfIndex == 0) {
            $this$readLineStrict.skip(1L);
            return "";
        } else if (lfIndex > 0) {
            long skipBytes = 1;
            if ($this$readLineStrict.getBuffer().get(lfIndex - 1) == 13) {
                lfIndex--;
                skipBytes = 1 + 1;
            }
            String str = readString($this$readLineStrict, lfIndex);
            $this$readLineStrict.skip(skipBytes);
            return str;
        } else if ($this$readLineStrict.getBuffer().getSize() < limit) {
            throw new EOFException();
        } else {
            if (limit == LongCompanionObject.MAX_VALUE) {
                throw new EOFException();
            }
            if (!$this$readLineStrict.request(limit + 1)) {
                throw new EOFException();
            }
            byte b = $this$readLineStrict.getBuffer().get(limit);
            if (b == 10) {
                String str2 = readString($this$readLineStrict, limit);
                $this$readLineStrict.skip(1L);
                return str2;
            } else if (b == 13 && $this$readLineStrict.request(2 + limit)) {
                if ($this$readLineStrict.getBuffer().get(1 + limit) != 10) {
                    throw new EOFException();
                }
                String res = readString($this$readLineStrict, limit);
                $this$readLineStrict.skip(2L);
                return res;
            } else {
                throw new EOFException();
            }
        }
    }

    private static final int commonReadUtf8CodePoint(Buffer $this$commonReadUtf8CodePoint) {
        int other$iv;
        int byteCount;
        int min;
        $this$commonReadUtf8CodePoint.require(1L);
        byte b0 = $this$commonReadUtf8CodePoint.get(0L);
        int other$iv2 = 128 & b0;
        if (other$iv2 == 0) {
            other$iv = Byte.MAX_VALUE & b0;
            byteCount = 1;
            min = 0;
        } else {
            int other$iv3 = 224 & b0;
            if (other$iv3 == 192) {
                other$iv = 31 & b0;
                byteCount = 2;
                min = 128;
            } else {
                int other$iv4 = 240 & b0;
                if (other$iv4 == 224) {
                    other$iv = 15 & b0;
                    byteCount = 3;
                    min = 2048;
                } else {
                    int other$iv5 = 248 & b0;
                    if (other$iv5 != 240) {
                        $this$commonReadUtf8CodePoint.skip(1L);
                        return 65533;
                    }
                    other$iv = 7 & b0;
                    byteCount = 4;
                    min = 65536;
                }
            }
        }
        if ($this$commonReadUtf8CodePoint.getSize() < byteCount) {
            throw new EOFException("size < " + byteCount + ": " + $this$commonReadUtf8CodePoint.getSize() + " (to read code point prefixed 0x" + _UtilKt.toHexString(b0) + ')');
        }
        for (int i = 1; i < byteCount; i++) {
            byte b = $this$commonReadUtf8CodePoint.get(i);
            int other$iv6 = 192 & b;
            if (other$iv6 == 128) {
                int codePoint = other$iv << 6;
                int other$iv7 = 63 & b;
                other$iv = codePoint | other$iv7;
            } else {
                $this$commonReadUtf8CodePoint.skip(i);
                return 65533;
            }
        }
        $this$commonReadUtf8CodePoint.skip(byteCount);
        if (other$iv > 1114111) {
            return 65533;
        }
        boolean z = false;
        if (55296 <= other$iv && other$iv < 57344) {
            z = true;
        }
        if (z || other$iv < min) {
            return 65533;
        }
        return other$iv;
    }

    private static final void commonWriteUtf8(Buffer $this$commonWriteUtf8, int beginIndex, int endIndex, Function1<? super Integer, Character> function1) {
        SegmentWriteContext ctx;
        SegmentWriteContext ctx2;
        SegmentWriteContext ctx3;
        SegmentWriteContext ctx4;
        int i = endIndex;
        Function1<? super Integer, Character> function12 = function1;
        int $i$f$commonWriteUtf8 = 0;
        int i2 = beginIndex;
        while (i2 < i) {
            int c = function12.invoke(Integer.valueOf(i2)).charValue();
            if (c < 128) {
                UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
                Segment tail$iv = $this$commonWriteUtf8.writableSegment(1);
                ctx = UnsafeBufferOperationsKt.SegmentWriteContextImpl;
                int segmentOffset = -i2;
                int runLimit = Math.min(i, i2 + tail$iv.getRemainingCapacity());
                int $i$f$commonWriteUtf82 = $i$f$commonWriteUtf8;
                ctx.setUnchecked(tail$iv, i2 + segmentOffset, (byte) c);
                i2++;
                while (i2 < runLimit) {
                    int c2 = function12.invoke(Integer.valueOf(i2)).charValue();
                    if (c2 >= 128) {
                        break;
                    }
                    ctx.setUnchecked(tail$iv, i2 + segmentOffset, (byte) c2);
                    i2++;
                }
                int segmentOffset2 = segmentOffset + i2;
                if (segmentOffset2 == 1) {
                    tail$iv.setLimit(tail$iv.getLimit() + segmentOffset2);
                    $this$commonWriteUtf8.setSizeMut($this$commonWriteUtf8.getSizeMut() + segmentOffset2);
                } else {
                    if (!(segmentOffset2 >= 0 && segmentOffset2 <= tail$iv.getRemainingCapacity())) {
                        throw new IllegalStateException(("Invalid number of bytes written: " + segmentOffset2 + ". Should be in 0.." + tail$iv.getRemainingCapacity()).toString());
                    }
                    if (segmentOffset2 != 0) {
                        tail$iv.setLimit(tail$iv.getLimit() + segmentOffset2);
                        $this$commonWriteUtf8.setSizeMut($this$commonWriteUtf8.getSizeMut() + segmentOffset2);
                    } else if (SegmentKt.isEmpty(tail$iv)) {
                        $this$commonWriteUtf8.recycleTail();
                    }
                }
                $i$f$commonWriteUtf8 = $i$f$commonWriteUtf82;
            } else {
                int $i$f$commonWriteUtf83 = $i$f$commonWriteUtf8;
                if (c < 2048) {
                    UnsafeBufferOperations unsafeBufferOperations2 = UnsafeBufferOperations.INSTANCE;
                    Segment tail$iv2 = $this$commonWriteUtf8.writableSegment(2);
                    ctx2 = UnsafeBufferOperationsKt.SegmentWriteContextImpl;
                    boolean z = false;
                    ctx2.setUnchecked(tail$iv2, 0, (byte) ((c >> 6) | 192), (byte) (128 | (c & 63)));
                    if (2 == 2) {
                        tail$iv2.setLimit(tail$iv2.getLimit() + 2);
                        $this$commonWriteUtf8.setSizeMut($this$commonWriteUtf8.getSizeMut() + 2);
                    } else {
                        if (2 >= 0 && 2 <= tail$iv2.getRemainingCapacity()) {
                            z = true;
                        }
                        if (!z) {
                            throw new IllegalStateException(("Invalid number of bytes written: 2. Should be in 0.." + tail$iv2.getRemainingCapacity()).toString());
                        }
                        if (2 != 0) {
                            tail$iv2.setLimit(tail$iv2.getLimit() + 2);
                            $this$commonWriteUtf8.setSizeMut($this$commonWriteUtf8.getSizeMut() + 2);
                        } else if (SegmentKt.isEmpty(tail$iv2)) {
                            $this$commonWriteUtf8.recycleTail();
                        }
                    }
                    i2++;
                    $i$f$commonWriteUtf8 = $i$f$commonWriteUtf83;
                } else if (c < 55296 || c > 57343) {
                    UnsafeBufferOperations unsafeBufferOperations3 = UnsafeBufferOperations.INSTANCE;
                    Segment tail$iv3 = $this$commonWriteUtf8.writableSegment(3);
                    ctx3 = UnsafeBufferOperationsKt.SegmentWriteContextImpl;
                    ctx3.setUnchecked(tail$iv3, 0, (byte) ((c >> 12) | 224), (byte) (((c >> 6) & 63) | 128), (byte) ((c & 63) | 128));
                    if (3 == 3) {
                        tail$iv3.setLimit(tail$iv3.getLimit() + 3);
                        $this$commonWriteUtf8.setSizeMut($this$commonWriteUtf8.getSizeMut() + 3);
                    } else {
                        if (!(3 >= 0 && 3 <= tail$iv3.getRemainingCapacity())) {
                            throw new IllegalStateException(("Invalid number of bytes written: 3. Should be in 0.." + tail$iv3.getRemainingCapacity()).toString());
                        }
                        if (3 != 0) {
                            tail$iv3.setLimit(tail$iv3.getLimit() + 3);
                            $this$commonWriteUtf8.setSizeMut($this$commonWriteUtf8.getSizeMut() + 3);
                        } else if (SegmentKt.isEmpty(tail$iv3)) {
                            $this$commonWriteUtf8.recycleTail();
                        }
                    }
                    i2++;
                    i = endIndex;
                    function12 = function1;
                    $i$f$commonWriteUtf8 = $i$f$commonWriteUtf83;
                } else {
                    int charValue = i2 + 1 < i ? function12.invoke(Integer.valueOf(i2 + 1)).charValue() : (char) 0;
                    if (c <= 56319) {
                        if (56320 <= charValue && charValue < 57344) {
                            int codePoint = (((c & 1023) << 10) | (charValue & 1023)) + 65536;
                            UnsafeBufferOperations unsafeBufferOperations4 = UnsafeBufferOperations.INSTANCE;
                            Segment tail$iv4 = $this$commonWriteUtf8.writableSegment(4);
                            ctx4 = UnsafeBufferOperationsKt.SegmentWriteContextImpl;
                            int low = codePoint & 63;
                            ctx4.setUnchecked(tail$iv4, 0, (byte) ((codePoint >> 18) | 240), (byte) (((codePoint >> 12) & 63) | 128), (byte) (((codePoint >> 6) & 63) | 128), (byte) (low | 128));
                            if (4 == 4) {
                                tail$iv4.setLimit(tail$iv4.getLimit() + 4);
                                $this$commonWriteUtf8.setSizeMut($this$commonWriteUtf8.getSizeMut() + 4);
                            } else {
                                if (!(4 >= 0 && 4 <= tail$iv4.getRemainingCapacity())) {
                                    throw new IllegalStateException(("Invalid number of bytes written: 4. Should be in 0.." + tail$iv4.getRemainingCapacity()).toString());
                                }
                                if (4 != 0) {
                                    tail$iv4.setLimit(tail$iv4.getLimit() + 4);
                                    $this$commonWriteUtf8.setSizeMut($this$commonWriteUtf8.getSizeMut() + 4);
                                } else if (SegmentKt.isEmpty(tail$iv4)) {
                                    $this$commonWriteUtf8.recycleTail();
                                }
                            }
                            i2 += 2;
                            i = endIndex;
                            function12 = function1;
                            $i$f$commonWriteUtf8 = $i$f$commonWriteUtf83;
                        }
                    }
                    $this$commonWriteUtf8.writeByte((byte) 63);
                    i2++;
                    i = endIndex;
                    function12 = function1;
                    $i$f$commonWriteUtf8 = $i$f$commonWriteUtf83;
                }
            }
        }
    }

    private static final void commonWriteUtf8CodePoint(Buffer $this$commonWriteUtf8CodePoint, int codePoint) {
        SegmentWriteContext ctx;
        SegmentWriteContext ctx2;
        SegmentWriteContext ctx3;
        if (codePoint < 0 || codePoint > 1114111) {
            throw new IllegalArgumentException("Code point value is out of Unicode codespace 0..0x10ffff: 0x" + _UtilKt.toHexString(codePoint) + " (" + codePoint + ')');
        }
        if (codePoint < 128) {
            $this$commonWriteUtf8CodePoint.writeByte((byte) codePoint);
            return;
        }
        boolean z = true;
        if (codePoint < 2048) {
            UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
            Segment tail$iv = $this$commonWriteUtf8CodePoint.writableSegment(2);
            ctx3 = UnsafeBufferOperationsKt.SegmentWriteContextImpl;
            ctx3.setUnchecked(tail$iv, 0, (byte) ((codePoint >> 6) | 192));
            ctx3.setUnchecked(tail$iv, 1, (byte) (128 | (codePoint & 63)));
            if (2 == 2) {
                tail$iv.setLimit(tail$iv.getLimit() + 2);
                $this$commonWriteUtf8CodePoint.setSizeMut($this$commonWriteUtf8CodePoint.getSizeMut() + 2);
                return;
            }
            if (2 < 0 || 2 > tail$iv.getRemainingCapacity()) {
                z = false;
            }
            if (!z) {
                throw new IllegalStateException(("Invalid number of bytes written: 2. Should be in 0.." + tail$iv.getRemainingCapacity()).toString());
            }
            if (2 != 0) {
                tail$iv.setLimit(tail$iv.getLimit() + 2);
                $this$commonWriteUtf8CodePoint.setSizeMut($this$commonWriteUtf8CodePoint.getSizeMut() + 2);
                return;
            } else if (!SegmentKt.isEmpty(tail$iv)) {
                return;
            } else {
                $this$commonWriteUtf8CodePoint.recycleTail();
                return;
            }
        }
        if (55296 <= codePoint && codePoint < 57344) {
            $this$commonWriteUtf8CodePoint.writeByte((byte) 63);
        } else if (codePoint < 65536) {
            UnsafeBufferOperations unsafeBufferOperations2 = UnsafeBufferOperations.INSTANCE;
            Segment tail$iv2 = $this$commonWriteUtf8CodePoint.writableSegment(3);
            ctx2 = UnsafeBufferOperationsKt.SegmentWriteContextImpl;
            ctx2.setUnchecked(tail$iv2, 0, (byte) ((codePoint >> 12) | 224));
            ctx2.setUnchecked(tail$iv2, 1, (byte) ((63 & (codePoint >> 6)) | 128));
            ctx2.setUnchecked(tail$iv2, 2, (byte) (128 | (codePoint & 63)));
            if (3 == 3) {
                tail$iv2.setLimit(tail$iv2.getLimit() + 3);
                $this$commonWriteUtf8CodePoint.setSizeMut($this$commonWriteUtf8CodePoint.getSizeMut() + 3);
                return;
            }
            if (3 < 0 || 3 > tail$iv2.getRemainingCapacity()) {
                z = false;
            }
            if (!z) {
                throw new IllegalStateException(("Invalid number of bytes written: 3. Should be in 0.." + tail$iv2.getRemainingCapacity()).toString());
            }
            if (3 != 0) {
                tail$iv2.setLimit(tail$iv2.getLimit() + 3);
                $this$commonWriteUtf8CodePoint.setSizeMut($this$commonWriteUtf8CodePoint.getSizeMut() + 3);
            } else if (!SegmentKt.isEmpty(tail$iv2)) {
            } else {
                $this$commonWriteUtf8CodePoint.recycleTail();
            }
        } else {
            UnsafeBufferOperations this_$iv = UnsafeBufferOperations.INSTANCE;
            Segment tail$iv3 = $this$commonWriteUtf8CodePoint.writableSegment(4);
            ctx = UnsafeBufferOperationsKt.SegmentWriteContextImpl;
            ctx.setUnchecked(tail$iv3, 0, (byte) ((codePoint >> 18) | 240));
            ctx.setUnchecked(tail$iv3, 1, (byte) (((codePoint >> 12) & 63) | 128));
            ctx.setUnchecked(tail$iv3, 2, (byte) (((codePoint >> 6) & 63) | 128));
            ctx.setUnchecked(tail$iv3, 3, (byte) (128 | (codePoint & 63)));
            if (4 == 4) {
                tail$iv3.setLimit(tail$iv3.getLimit() + 4);
                $this$commonWriteUtf8CodePoint.setSizeMut($this$commonWriteUtf8CodePoint.getSizeMut() + 4);
                return;
            }
            if (4 < 0 || 4 > tail$iv3.getRemainingCapacity()) {
                z = false;
            }
            if (!z) {
                throw new IllegalStateException(("Invalid number of bytes written: 4. Should be in 0.." + tail$iv3.getRemainingCapacity()).toString());
            }
            if (4 != 0) {
                tail$iv3.setLimit(tail$iv3.getLimit() + 4);
                $this$commonWriteUtf8CodePoint.setSizeMut($this$commonWriteUtf8CodePoint.getSizeMut() + 4);
            } else if (!SegmentKt.isEmpty(tail$iv3)) {
            } else {
                $this$commonWriteUtf8CodePoint.recycleTail();
            }
        }
    }

    private static final String commonReadUtf8(Buffer $this$commonReadUtf8, long byteCount) {
        SegmentReadContext segmentReadContext;
        if (byteCount == 0) {
            return "";
        }
        UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
        Segment curr$iv = $this$commonReadUtf8.getHead();
        if (curr$iv != null) {
            segmentReadContext = UnsafeBufferOperationsKt.SegmentReadContextImpl;
            if (curr$iv.getSize() < byteCount) {
                return _Utf8Kt.commonToUtf8String$default(SourcesKt.readByteArray($this$commonReadUtf8, (int) byteCount), 0, 0, 3, null);
            }
            byte[] data = curr$iv.dataAsByteArray(true);
            int pos = curr$iv.getPos();
            int limit = curr$iv.getLimit();
            String commonToUtf8String = _Utf8Kt.commonToUtf8String(data, pos, Math.min(limit, ((int) byteCount) + pos));
            $this$commonReadUtf8.skip(byteCount);
            return commonToUtf8String;
        }
        throw new IllegalStateException("Unreacheable".toString());
    }
}