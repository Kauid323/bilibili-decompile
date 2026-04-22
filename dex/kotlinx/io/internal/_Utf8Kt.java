package kotlinx.io.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.msgpack.core.MessagePack;

/* compiled from: -Utf8.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0000\u001a\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0080\b\u001a\u0011\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0007H\u0080\b\u001a4\u0010\u0010\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u0013H\u0080\bø\u0001\u0000\u001a4\u0010\u0016\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00110\u0013H\u0080\bø\u0001\u0000\u001a4\u0010\u0018\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u0013H\u0080\bø\u0001\u0000\u001a4\u0010\u001a\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u0013H\u0080\bø\u0001\u0000\u001a4\u0010\u001c\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u0013H\u0080\bø\u0001\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001d"}, d2 = {"commonToUtf8String", "", "", "beginIndex", "", "endIndex", "REPLACEMENT_BYTE", "", "REPLACEMENT_CHARACTER", "", "REPLACEMENT_CODE_POINT", "isIsoControl", "", "codePoint", "isUtf8Continuation", "byte", "processUtf8CodePoints", "", "yield", "Lkotlin/Function1;", "HIGH_SURROGATE_HEADER", "LOG_SURROGATE_HEADER", "processUtf16Chars", "MASK_2BYTES", "process2Utf8Bytes", "MASK_3BYTES", "process3Utf8Bytes", "MASK_4BYTES", "process4Utf8Bytes", "kotlinx-io-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class _Utf8Kt {
    public static final int HIGH_SURROGATE_HEADER = 55232;
    public static final int LOG_SURROGATE_HEADER = 56320;
    public static final int MASK_2BYTES = 3968;
    public static final int MASK_3BYTES = -123008;
    public static final int MASK_4BYTES = 3678080;
    public static final byte REPLACEMENT_BYTE = 63;
    public static final char REPLACEMENT_CHARACTER = 65533;
    public static final int REPLACEMENT_CODE_POINT = 65533;

    public static /* synthetic */ String commonToUtf8String$default(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        return commonToUtf8String(bArr, i, i2);
    }

    public static final String commonToUtf8String(byte[] $this$commonToUtf8String, int beginIndex, int endIndex) {
        int $i$f$processUtf16Chars;
        int length;
        byte b2$iv$iv;
        int length2;
        int length3;
        int length4;
        int length5;
        int length6;
        int i;
        int length7;
        int length8;
        byte b1$iv$iv;
        Intrinsics.checkNotNullParameter($this$commonToUtf8String, "<this>");
        if (beginIndex < 0 || endIndex > $this$commonToUtf8String.length || beginIndex > endIndex) {
            throw new IndexOutOfBoundsException("size=" + $this$commonToUtf8String.length + " beginIndex=" + beginIndex + " endIndex=" + endIndex);
        }
        char[] chars = new char[endIndex - beginIndex];
        int index$iv = 0;
        int $i$f$processUtf16Chars2 = 0;
        int index$iv2 = beginIndex;
        while (index$iv2 < endIndex) {
            byte b0$iv = $this$commonToUtf8String[index$iv2];
            if (b0$iv >= 0) {
                char c = (char) b0$iv;
                int length9 = index$iv + 1;
                chars[index$iv] = c;
                index$iv2++;
                while (index$iv2 < endIndex && $this$commonToUtf8String[index$iv2] >= 0) {
                    int index$iv3 = index$iv2 + 1;
                    char c2 = (char) $this$commonToUtf8String[index$iv2];
                    chars[length9] = c2;
                    index$iv2 = index$iv3;
                    length9++;
                }
                Unit unit = Unit.INSTANCE;
                $i$f$processUtf16Chars = $i$f$processUtf16Chars2;
                index$iv = length9;
            } else {
                int other$iv$iv = b0$iv >> 5;
                if (other$iv$iv == -2) {
                    if (endIndex <= index$iv2 + 1) {
                        char c3 = (char) 65533;
                        int length10 = index$iv + 1;
                        chars[index$iv] = c3;
                        Unit unit2 = Unit.INSTANCE;
                        length8 = length10;
                        b1$iv$iv = 1;
                        $i$f$processUtf16Chars = $i$f$processUtf16Chars2;
                    } else {
                        byte b0$iv$iv = $this$commonToUtf8String[index$iv2];
                        byte b1$iv$iv2 = $this$commonToUtf8String[index$iv2 + 1];
                        if ((b1$iv$iv2 & MessagePack.Code.NIL) == 128) {
                            int codePoint$iv$iv = (b1$iv$iv2 ^ 3968) ^ (b0$iv$iv << 6);
                            if (codePoint$iv$iv < 128) {
                                $i$f$processUtf16Chars = $i$f$processUtf16Chars2;
                                char c4 = (char) 65533;
                                length7 = index$iv + 1;
                                chars[index$iv] = c4;
                                Unit unit3 = Unit.INSTANCE;
                            } else {
                                $i$f$processUtf16Chars = $i$f$processUtf16Chars2;
                                char c5 = (char) codePoint$iv$iv;
                                length7 = index$iv + 1;
                                chars[index$iv] = c5;
                                Unit unit4 = Unit.INSTANCE;
                            }
                            length8 = length7;
                            b1$iv$iv = 2;
                        } else {
                            char c6 = (char) 65533;
                            length8 = index$iv + 1;
                            chars[index$iv] = c6;
                            Unit unit5 = Unit.INSTANCE;
                            $i$f$processUtf16Chars = $i$f$processUtf16Chars2;
                            b1$iv$iv = 1;
                        }
                    }
                    index$iv2 += b1$iv$iv;
                    Unit unit6 = Unit.INSTANCE;
                    index$iv = length8;
                } else {
                    $i$f$processUtf16Chars = $i$f$processUtf16Chars2;
                    int other$iv$iv2 = b0$iv >> 4;
                    if (other$iv$iv2 == -2) {
                        if (endIndex <= index$iv2 + 2) {
                            char c7 = (char) 65533;
                            length6 = index$iv + 1;
                            chars[index$iv] = c7;
                            Unit unit7 = Unit.INSTANCE;
                            if (endIndex > index$iv2 + 1) {
                                byte byte$iv$iv$iv = $this$commonToUtf8String[index$iv2 + 1];
                                int other$iv$iv$iv$iv = 192 & byte$iv$iv$iv;
                                if (other$iv$iv$iv$iv == 128) {
                                    i = 2;
                                }
                            }
                            i = 1;
                        } else {
                            byte b0$iv$iv2 = $this$commonToUtf8String[index$iv2];
                            byte b1$iv$iv3 = $this$commonToUtf8String[index$iv2 + 1];
                            if ((b1$iv$iv3 & MessagePack.Code.NIL) == 128) {
                                int length11 = index$iv2 + 2;
                                byte b2$iv$iv2 = $this$commonToUtf8String[length11];
                                if ((b2$iv$iv2 & MessagePack.Code.NIL) == 128) {
                                    int codePoint$iv$iv2 = (((-123008) ^ b2$iv$iv2) ^ (b1$iv$iv3 << 6)) ^ (b0$iv$iv2 << 12);
                                    if (codePoint$iv$iv2 < 2048) {
                                        char c8 = (char) 65533;
                                        length5 = index$iv + 1;
                                        chars[index$iv] = c8;
                                        Unit unit8 = Unit.INSTANCE;
                                    } else {
                                        if (55296 <= codePoint$iv$iv2 && codePoint$iv$iv2 < 57344) {
                                            char c9 = (char) 65533;
                                            length5 = index$iv + 1;
                                            chars[index$iv] = c9;
                                            Unit unit9 = Unit.INSTANCE;
                                        } else {
                                            char c10 = (char) codePoint$iv$iv2;
                                            length5 = index$iv + 1;
                                            chars[index$iv] = c10;
                                            Unit unit10 = Unit.INSTANCE;
                                        }
                                    }
                                    length6 = length5;
                                    i = 3;
                                } else {
                                    char c11 = (char) 65533;
                                    int length12 = index$iv + 1;
                                    chars[index$iv] = c11;
                                    Unit unit11 = Unit.INSTANCE;
                                    length6 = length12;
                                    i = 2;
                                }
                            } else {
                                char c12 = (char) 65533;
                                int length13 = index$iv + 1;
                                chars[index$iv] = c12;
                                Unit unit12 = Unit.INSTANCE;
                                length6 = length13;
                                i = 1;
                            }
                        }
                        index$iv2 += i;
                        Unit unit13 = Unit.INSTANCE;
                        index$iv = length6;
                    } else {
                        int other$iv$iv3 = b0$iv >> 3;
                        if (other$iv$iv3 == -2) {
                            if (endIndex <= index$iv2 + 3) {
                                if (65533 != 65533) {
                                    char c13 = (char) ((65533 >>> 10) + 55232);
                                    int length14 = index$iv + 1;
                                    chars[index$iv] = c13;
                                    char c14 = (char) ((65533 & 1023) + 56320);
                                    length2 = length14 + 1;
                                    chars[length14] = c14;
                                } else {
                                    int length15 = index$iv + 1;
                                    chars[index$iv] = 65533;
                                    length2 = length15;
                                }
                                Unit unit14 = Unit.INSTANCE;
                                if (endIndex > index$iv2 + 1) {
                                    byte byte$iv$iv$iv2 = $this$commonToUtf8String[index$iv2 + 1];
                                    int other$iv$iv$iv$iv2 = 192 & byte$iv$iv$iv2;
                                    byte byte$iv$iv$iv3 = other$iv$iv$iv$iv2 == 128 ? (byte) 1 : (byte) 0;
                                    if (byte$iv$iv$iv3 != 0) {
                                        if (endIndex > index$iv2 + 2) {
                                            byte byte$iv$iv$iv4 = $this$commonToUtf8String[index$iv2 + 2];
                                            int other$iv$iv$iv$iv3 = 192 & byte$iv$iv$iv4;
                                            if (other$iv$iv$iv$iv3 == 128) {
                                                b2$iv$iv = 3;
                                            }
                                        }
                                        b2$iv$iv = 2;
                                    }
                                }
                                b2$iv$iv = 1;
                            } else {
                                byte b0$iv$iv3 = $this$commonToUtf8String[index$iv2];
                                byte b1$iv$iv4 = $this$commonToUtf8String[index$iv2 + 1];
                                if ((b1$iv$iv4 & MessagePack.Code.NIL) == 128) {
                                    byte b2$iv$iv3 = $this$commonToUtf8String[index$iv2 + 2];
                                    if ((b2$iv$iv3 & MessagePack.Code.NIL) == 128) {
                                        byte b3$iv$iv = $this$commonToUtf8String[index$iv2 + 3];
                                        if ((b3$iv$iv & MessagePack.Code.NIL) == 128) {
                                            int codePoint$iv$iv3 = (((3678080 ^ b3$iv$iv) ^ (b2$iv$iv3 << 6)) ^ (b1$iv$iv4 << 12)) ^ (b0$iv$iv3 << 18);
                                            if (codePoint$iv$iv3 > 1114111) {
                                                if (65533 != 65533) {
                                                    char c15 = (char) ((65533 >>> 10) + 55232);
                                                    int length16 = index$iv + 1;
                                                    chars[index$iv] = c15;
                                                    char c16 = (char) ((65533 & 1023) + 56320);
                                                    length = length16 + 1;
                                                    chars[length16] = c16;
                                                } else {
                                                    int length17 = index$iv + 1;
                                                    chars[index$iv] = 65533;
                                                    length = length17;
                                                }
                                                Unit unit15 = Unit.INSTANCE;
                                            } else {
                                                if (55296 <= codePoint$iv$iv3 && codePoint$iv$iv3 < 57344) {
                                                    if (65533 != 65533) {
                                                        char c17 = (char) ((65533 >>> 10) + 55232);
                                                        int length18 = index$iv + 1;
                                                        chars[index$iv] = c17;
                                                        char c18 = (char) ((65533 & 1023) + 56320);
                                                        length = length18 + 1;
                                                        chars[length18] = c18;
                                                    } else {
                                                        int length19 = index$iv + 1;
                                                        chars[index$iv] = 65533;
                                                        length = length19;
                                                    }
                                                    Unit unit16 = Unit.INSTANCE;
                                                } else if (codePoint$iv$iv3 < 65536) {
                                                    if (65533 != 65533) {
                                                        char c19 = (char) ((65533 >>> 10) + 55232);
                                                        int length20 = index$iv + 1;
                                                        chars[index$iv] = c19;
                                                        char c20 = (char) ((65533 & 1023) + 56320);
                                                        length = length20 + 1;
                                                        chars[length20] = c20;
                                                    } else {
                                                        int length21 = index$iv + 1;
                                                        chars[index$iv] = 65533;
                                                        length = length21;
                                                    }
                                                    Unit unit17 = Unit.INSTANCE;
                                                } else {
                                                    if (codePoint$iv$iv3 != 65533) {
                                                        char c21 = (char) ((codePoint$iv$iv3 >>> 10) + 55232);
                                                        int length22 = index$iv + 1;
                                                        chars[index$iv] = c21;
                                                        char c22 = (char) ((codePoint$iv$iv3 & 1023) + 56320);
                                                        length = length22 + 1;
                                                        chars[length22] = c22;
                                                    } else {
                                                        int length23 = index$iv + 1;
                                                        chars[index$iv] = 65533;
                                                        length = length23;
                                                    }
                                                    Unit unit18 = Unit.INSTANCE;
                                                }
                                            }
                                            b2$iv$iv = 4;
                                            length2 = length;
                                        } else {
                                            if (65533 != 65533) {
                                                char c23 = (char) ((65533 >>> 10) + 55232);
                                                int length24 = index$iv + 1;
                                                chars[index$iv] = c23;
                                                char c24 = (char) ((65533 & 1023) + 56320);
                                                length3 = length24 + 1;
                                                chars[length24] = c24;
                                            } else {
                                                int length25 = index$iv + 1;
                                                chars[index$iv] = 65533;
                                                length3 = length25;
                                            }
                                            Unit unit19 = Unit.INSTANCE;
                                            length2 = length3;
                                            b2$iv$iv = 3;
                                        }
                                    } else {
                                        if (65533 != 65533) {
                                            char c25 = (char) ((65533 >>> 10) + 55232);
                                            int length26 = index$iv + 1;
                                            chars[index$iv] = c25;
                                            char c26 = (char) ((65533 & 1023) + 56320);
                                            length4 = length26 + 1;
                                            chars[length26] = c26;
                                        } else {
                                            int length27 = index$iv + 1;
                                            chars[index$iv] = 65533;
                                            length4 = length27;
                                        }
                                        Unit unit20 = Unit.INSTANCE;
                                        length2 = length4;
                                        b2$iv$iv = 2;
                                    }
                                } else {
                                    if (65533 != 65533) {
                                        char c27 = (char) ((65533 >>> 10) + 55232);
                                        int length28 = index$iv + 1;
                                        chars[index$iv] = c27;
                                        char c28 = (char) ((65533 & 1023) + 56320);
                                        length2 = length28 + 1;
                                        chars[length28] = c28;
                                    } else {
                                        int length29 = index$iv + 1;
                                        chars[index$iv] = 65533;
                                        length2 = length29;
                                    }
                                    Unit unit21 = Unit.INSTANCE;
                                    b2$iv$iv = 1;
                                }
                            }
                            index$iv2 += b2$iv$iv;
                            Unit unit22 = Unit.INSTANCE;
                            index$iv = length2;
                        } else {
                            int length30 = index$iv + 1;
                            chars[index$iv] = 65533;
                            Integer.valueOf(index$iv2);
                            index$iv2++;
                            index$iv = length30;
                        }
                    }
                }
            }
            $i$f$processUtf16Chars2 = $i$f$processUtf16Chars;
        }
        return StringsKt.concatToString(chars, 0, index$iv);
    }

    public static final boolean isIsoControl(int codePoint) {
        if (codePoint >= 0 && codePoint < 32) {
            return true;
        }
        return 127 <= codePoint && codePoint < 160;
    }

    public static final boolean isUtf8Continuation(byte b) {
        int other$iv = 192 & b;
        return other$iv == 128;
    }

    public static final void processUtf8CodePoints(byte[] $this$processUtf8CodePoints, int beginIndex, int endIndex, Function1<? super Integer, Unit> yield) {
        int i;
        byte b2$iv;
        byte b0$iv;
        Intrinsics.checkNotNullParameter($this$processUtf8CodePoints, "<this>");
        Intrinsics.checkNotNullParameter(yield, "yield");
        int index = beginIndex;
        while (index < endIndex) {
            byte b0 = $this$processUtf8CodePoints[index];
            if (b0 >= 0) {
                yield.invoke(Integer.valueOf(b0));
                index++;
                while (index < endIndex && $this$processUtf8CodePoints[index] >= 0) {
                    yield.invoke(Integer.valueOf($this$processUtf8CodePoints[index]));
                    index++;
                }
            } else {
                int other$iv = b0 >> 5;
                if (other$iv == -2) {
                    if (endIndex <= index + 1) {
                        yield.invoke(65533);
                        Unit unit = Unit.INSTANCE;
                        i = 1;
                    } else {
                        byte b0$iv2 = $this$processUtf8CodePoints[index];
                        byte b1$iv = $this$processUtf8CodePoints[index + 1];
                        int other$iv$iv$iv = b1$iv & MessagePack.Code.NIL;
                        if (other$iv$iv$iv == 128) {
                            int codePoint$iv = (b1$iv ^ 3968) ^ (b0$iv2 << 6);
                            if (codePoint$iv < 128) {
                                yield.invoke(65533);
                                Unit unit2 = Unit.INSTANCE;
                            } else {
                                yield.invoke(Integer.valueOf(codePoint$iv));
                                Unit unit3 = Unit.INSTANCE;
                            }
                            i = 2;
                        } else {
                            yield.invoke(65533);
                            Unit unit4 = Unit.INSTANCE;
                            i = 1;
                        }
                    }
                    index += i;
                } else {
                    int other$iv2 = b0 >> 4;
                    if (other$iv2 == -2) {
                        if (endIndex <= index + 2) {
                            yield.invoke(65533);
                            Unit unit5 = Unit.INSTANCE;
                            if (endIndex > index + 1) {
                                byte byte$iv$iv = $this$processUtf8CodePoints[index + 1];
                                int other$iv$iv$iv2 = 192 & byte$iv$iv;
                                if (other$iv$iv$iv2 == 128) {
                                    b2$iv = 2;
                                }
                            }
                            b2$iv = 1;
                        } else {
                            byte b0$iv3 = $this$processUtf8CodePoints[index];
                            byte b1$iv2 = $this$processUtf8CodePoints[index + 1];
                            if ((b1$iv2 & MessagePack.Code.NIL) == 128) {
                                byte b2$iv2 = $this$processUtf8CodePoints[index + 2];
                                if ((b2$iv2 & MessagePack.Code.NIL) == 128) {
                                    int codePoint$iv2 = (((-123008) ^ b2$iv2) ^ (b1$iv2 << 6)) ^ (b0$iv3 << 12);
                                    if (codePoint$iv2 < 2048) {
                                        yield.invoke(65533);
                                        Unit unit6 = Unit.INSTANCE;
                                    } else {
                                        if (55296 <= codePoint$iv2 && codePoint$iv2 < 57344) {
                                            yield.invoke(65533);
                                            Unit unit7 = Unit.INSTANCE;
                                        } else {
                                            yield.invoke(Integer.valueOf(codePoint$iv2));
                                            Unit unit8 = Unit.INSTANCE;
                                        }
                                    }
                                    b2$iv = 3;
                                } else {
                                    yield.invoke(65533);
                                    Unit unit9 = Unit.INSTANCE;
                                    b2$iv = 2;
                                }
                            } else {
                                yield.invoke(65533);
                                Unit unit10 = Unit.INSTANCE;
                                b2$iv = 1;
                            }
                        }
                        index += b2$iv;
                    } else {
                        int other$iv3 = b0 >> 3;
                        if (other$iv3 == -2) {
                            if (endIndex <= index + 3) {
                                yield.invoke(65533);
                                Unit unit11 = Unit.INSTANCE;
                                if (endIndex > index + 1) {
                                    byte byte$iv$iv2 = $this$processUtf8CodePoints[index + 1];
                                    int other$iv$iv$iv3 = 192 & byte$iv$iv2;
                                    byte byte$iv$iv3 = other$iv$iv$iv3 == 128 ? (byte) 1 : (byte) 0;
                                    if (byte$iv$iv3 != 0) {
                                        if (endIndex > index + 2) {
                                            byte byte$iv$iv4 = $this$processUtf8CodePoints[index + 2];
                                            int other$iv$iv$iv4 = 192 & byte$iv$iv4;
                                            int $i$f$isUtf8Continuation = other$iv$iv$iv4 == 128 ? 1 : 0;
                                            if ($i$f$isUtf8Continuation != 0) {
                                                b0$iv = 3;
                                            }
                                        }
                                        b0$iv = 2;
                                    }
                                }
                                b0$iv = 1;
                            } else {
                                byte b0$iv4 = $this$processUtf8CodePoints[index];
                                byte b1$iv3 = $this$processUtf8CodePoints[index + 1];
                                if ((b1$iv3 & MessagePack.Code.NIL) == 128) {
                                    byte b2$iv3 = $this$processUtf8CodePoints[index + 2];
                                    if ((b2$iv3 & MessagePack.Code.NIL) == 128) {
                                        byte b3$iv = $this$processUtf8CodePoints[index + 3];
                                        if ((b3$iv & MessagePack.Code.NIL) == 128) {
                                            int codePoint$iv3 = (((3678080 ^ b3$iv) ^ (b2$iv3 << 6)) ^ (b1$iv3 << 12)) ^ (b0$iv4 << 18);
                                            if (codePoint$iv3 > 1114111) {
                                                yield.invoke(65533);
                                                Unit unit12 = Unit.INSTANCE;
                                            } else {
                                                if (55296 <= codePoint$iv3 && codePoint$iv3 < 57344) {
                                                    yield.invoke(65533);
                                                    Unit unit13 = Unit.INSTANCE;
                                                } else if (codePoint$iv3 < 65536) {
                                                    yield.invoke(65533);
                                                    Unit unit14 = Unit.INSTANCE;
                                                } else {
                                                    yield.invoke(Integer.valueOf(codePoint$iv3));
                                                    Unit unit15 = Unit.INSTANCE;
                                                }
                                            }
                                            b0$iv = 4;
                                        } else {
                                            yield.invoke(65533);
                                            Unit unit16 = Unit.INSTANCE;
                                            b0$iv = 3;
                                        }
                                    } else {
                                        yield.invoke(65533);
                                        Unit unit17 = Unit.INSTANCE;
                                        b0$iv = 2;
                                    }
                                } else {
                                    yield.invoke(65533);
                                    Unit unit18 = Unit.INSTANCE;
                                    b0$iv = 1;
                                }
                            }
                            index += b0$iv;
                        } else {
                            yield.invoke(65533);
                            index++;
                        }
                    }
                }
            }
        }
    }

    public static final void processUtf16Chars(byte[] $this$processUtf16Chars, int beginIndex, int endIndex, Function1<? super Character, Unit> yield) {
        int i;
        byte b2$iv;
        int i2;
        Intrinsics.checkNotNullParameter($this$processUtf16Chars, "<this>");
        Intrinsics.checkNotNullParameter(yield, "yield");
        int index = beginIndex;
        while (index < endIndex) {
            byte b0 = $this$processUtf16Chars[index];
            if (b0 >= 0) {
                yield.invoke(Character.valueOf((char) b0));
                index++;
                while (index < endIndex && $this$processUtf16Chars[index] >= 0) {
                    yield.invoke(Character.valueOf((char) $this$processUtf16Chars[index]));
                    index++;
                }
            } else {
                int other$iv = b0 >> 5;
                if (other$iv == -2) {
                    if (endIndex <= index + 1) {
                        yield.invoke(Character.valueOf((char) 65533));
                        Unit unit = Unit.INSTANCE;
                        i = 1;
                    } else {
                        byte b0$iv = $this$processUtf16Chars[index];
                        byte b1$iv = $this$processUtf16Chars[index + 1];
                        int other$iv$iv$iv = b1$iv & MessagePack.Code.NIL;
                        if (other$iv$iv$iv == 128) {
                            int codePoint$iv = (b1$iv ^ 3968) ^ (b0$iv << 6);
                            if (codePoint$iv < 128) {
                                yield.invoke(Character.valueOf((char) 65533));
                                Unit unit2 = Unit.INSTANCE;
                            } else {
                                yield.invoke(Character.valueOf((char) codePoint$iv));
                                Unit unit3 = Unit.INSTANCE;
                            }
                            i = 2;
                        } else {
                            yield.invoke(Character.valueOf((char) 65533));
                            Unit unit4 = Unit.INSTANCE;
                            i = 1;
                        }
                    }
                    index += i;
                } else {
                    int other$iv2 = b0 >> 4;
                    if (other$iv2 == -2) {
                        if (endIndex <= index + 2) {
                            yield.invoke(Character.valueOf((char) 65533));
                            Unit unit5 = Unit.INSTANCE;
                            if (endIndex > index + 1) {
                                byte byte$iv$iv = $this$processUtf16Chars[index + 1];
                                int other$iv$iv$iv2 = 192 & byte$iv$iv;
                                if (other$iv$iv$iv2 == 128) {
                                    b2$iv = 2;
                                }
                            }
                            b2$iv = 1;
                        } else {
                            byte b0$iv2 = $this$processUtf16Chars[index];
                            byte b1$iv2 = $this$processUtf16Chars[index + 1];
                            if ((b1$iv2 & MessagePack.Code.NIL) == 128) {
                                byte b2$iv2 = $this$processUtf16Chars[index + 2];
                                if ((b2$iv2 & MessagePack.Code.NIL) == 128) {
                                    int codePoint$iv2 = (((-123008) ^ b2$iv2) ^ (b1$iv2 << 6)) ^ (b0$iv2 << 12);
                                    if (codePoint$iv2 < 2048) {
                                        yield.invoke(Character.valueOf((char) 65533));
                                        Unit unit6 = Unit.INSTANCE;
                                    } else {
                                        if (55296 <= codePoint$iv2 && codePoint$iv2 < 57344) {
                                            yield.invoke(Character.valueOf((char) 65533));
                                            Unit unit7 = Unit.INSTANCE;
                                        } else {
                                            yield.invoke(Character.valueOf((char) codePoint$iv2));
                                            Unit unit8 = Unit.INSTANCE;
                                        }
                                    }
                                    b2$iv = 3;
                                } else {
                                    yield.invoke(Character.valueOf((char) 65533));
                                    Unit unit9 = Unit.INSTANCE;
                                    b2$iv = 2;
                                }
                            } else {
                                yield.invoke(Character.valueOf((char) 65533));
                                Unit unit10 = Unit.INSTANCE;
                                b2$iv = 1;
                            }
                        }
                        index += b2$iv;
                    } else {
                        int other$iv3 = b0 >> 3;
                        if (other$iv3 == -2) {
                            if (endIndex <= index + 3) {
                                if (65533 != 65533) {
                                    yield.invoke(Character.valueOf((char) ((65533 >>> 10) + 55232)));
                                    yield.invoke(Character.valueOf((char) ((65533 & 1023) + 56320)));
                                } else {
                                    yield.invoke((char) 65533);
                                }
                                Unit unit11 = Unit.INSTANCE;
                                if (endIndex > index + 1) {
                                    byte byte$iv$iv2 = $this$processUtf16Chars[index + 1];
                                    int other$iv$iv$iv3 = 192 & byte$iv$iv2;
                                    byte byte$iv$iv3 = other$iv$iv$iv3 == 128 ? (byte) 1 : (byte) 0;
                                    if (byte$iv$iv3 != 0) {
                                        if (endIndex > index + 2) {
                                            byte byte$iv$iv4 = $this$processUtf16Chars[index + 2];
                                            int other$iv$iv$iv4 = 192 & byte$iv$iv4;
                                            int $i$f$isUtf8Continuation = other$iv$iv$iv4 == 128 ? 1 : 0;
                                            if ($i$f$isUtf8Continuation != 0) {
                                                i2 = 3;
                                            }
                                        }
                                        i2 = 2;
                                    }
                                }
                                i2 = 1;
                            } else {
                                byte b0$iv3 = $this$processUtf16Chars[index];
                                byte b1$iv3 = $this$processUtf16Chars[index + 1];
                                if ((b1$iv3 & MessagePack.Code.NIL) == 128) {
                                    byte b2$iv3 = $this$processUtf16Chars[index + 2];
                                    if ((b2$iv3 & MessagePack.Code.NIL) == 128) {
                                        byte b3$iv = $this$processUtf16Chars[index + 3];
                                        if ((b3$iv & MessagePack.Code.NIL) == 128) {
                                            int codePoint$iv3 = (((3678080 ^ b3$iv) ^ (b2$iv3 << 6)) ^ (b1$iv3 << 12)) ^ (b0$iv3 << 18);
                                            if (codePoint$iv3 > 1114111) {
                                                if (65533 != 65533) {
                                                    yield.invoke(Character.valueOf((char) ((65533 >>> 10) + 55232)));
                                                    yield.invoke(Character.valueOf((char) ((65533 & 1023) + 56320)));
                                                } else {
                                                    yield.invoke((char) 65533);
                                                }
                                                Unit unit12 = Unit.INSTANCE;
                                            } else {
                                                if (55296 <= codePoint$iv3 && codePoint$iv3 < 57344) {
                                                    if (65533 != 65533) {
                                                        yield.invoke(Character.valueOf((char) ((65533 >>> 10) + 55232)));
                                                        yield.invoke(Character.valueOf((char) ((65533 & 1023) + 56320)));
                                                    } else {
                                                        yield.invoke((char) 65533);
                                                    }
                                                    Unit unit13 = Unit.INSTANCE;
                                                } else if (codePoint$iv3 < 65536) {
                                                    if (65533 != 65533) {
                                                        yield.invoke(Character.valueOf((char) ((65533 >>> 10) + 55232)));
                                                        yield.invoke(Character.valueOf((char) ((65533 & 1023) + 56320)));
                                                    } else {
                                                        yield.invoke((char) 65533);
                                                    }
                                                    Unit unit14 = Unit.INSTANCE;
                                                } else {
                                                    if (codePoint$iv3 != 65533) {
                                                        yield.invoke(Character.valueOf((char) ((codePoint$iv3 >>> 10) + 55232)));
                                                        yield.invoke(Character.valueOf((char) ((codePoint$iv3 & 1023) + 56320)));
                                                    } else {
                                                        yield.invoke((char) 65533);
                                                    }
                                                    Unit unit15 = Unit.INSTANCE;
                                                }
                                            }
                                            i2 = 4;
                                        } else {
                                            if (65533 != 65533) {
                                                yield.invoke(Character.valueOf((char) ((65533 >>> 10) + 55232)));
                                                yield.invoke(Character.valueOf((char) ((65533 & 1023) + 56320)));
                                            } else {
                                                yield.invoke((char) 65533);
                                            }
                                            Unit unit16 = Unit.INSTANCE;
                                            i2 = 3;
                                        }
                                    } else {
                                        if (65533 != 65533) {
                                            yield.invoke(Character.valueOf((char) ((65533 >>> 10) + 55232)));
                                            yield.invoke(Character.valueOf((char) ((65533 & 1023) + 56320)));
                                        } else {
                                            yield.invoke((char) 65533);
                                        }
                                        Unit unit17 = Unit.INSTANCE;
                                        i2 = 2;
                                    }
                                } else {
                                    if (65533 != 65533) {
                                        yield.invoke(Character.valueOf((char) ((65533 >>> 10) + 55232)));
                                        yield.invoke(Character.valueOf((char) ((65533 & 1023) + 56320)));
                                    } else {
                                        yield.invoke((char) 65533);
                                    }
                                    Unit unit18 = Unit.INSTANCE;
                                    i2 = 1;
                                }
                            }
                            index += i2;
                        } else {
                            yield.invoke((char) 65533);
                            index++;
                        }
                    }
                }
            }
        }
    }

    public static final int process2Utf8Bytes(byte[] $this$process2Utf8Bytes, int beginIndex, int endIndex, Function1<? super Integer, Unit> yield) {
        Intrinsics.checkNotNullParameter($this$process2Utf8Bytes, "<this>");
        Intrinsics.checkNotNullParameter(yield, "yield");
        if (endIndex <= beginIndex + 1) {
            yield.invoke(65533);
            return 1;
        }
        byte b0 = $this$process2Utf8Bytes[beginIndex];
        byte b1 = $this$process2Utf8Bytes[beginIndex + 1];
        int other$iv$iv = 192 & b1;
        if (!(other$iv$iv == 128)) {
            yield.invoke(65533);
            return 1;
        }
        int codePoint = (b1 ^ 3968) ^ (b0 << 6);
        if (codePoint < 128) {
            yield.invoke(65533);
            return 2;
        }
        yield.invoke(Integer.valueOf(codePoint));
        return 2;
    }

    public static final int process3Utf8Bytes(byte[] $this$process3Utf8Bytes, int beginIndex, int endIndex, Function1<? super Integer, Unit> yield) {
        Intrinsics.checkNotNullParameter($this$process3Utf8Bytes, "<this>");
        Intrinsics.checkNotNullParameter(yield, "yield");
        if (endIndex <= beginIndex + 2) {
            yield.invoke(65533);
            if (endIndex > beginIndex + 1) {
                byte byte$iv = $this$process3Utf8Bytes[beginIndex + 1];
                int other$iv$iv = 192 & byte$iv;
                if (other$iv$iv == 128) {
                    return 2;
                }
            }
            return 1;
        }
        byte b0 = $this$process3Utf8Bytes[beginIndex];
        byte b1 = $this$process3Utf8Bytes[beginIndex + 1];
        int other$iv$iv2 = 192 & b1;
        int $i$f$isUtf8Continuation = other$iv$iv2 == 128 ? 1 : 0;
        if ($i$f$isUtf8Continuation == 0) {
            yield.invoke(65533);
            return 1;
        }
        byte b2 = $this$process3Utf8Bytes[beginIndex + 2];
        int other$iv$iv3 = 192 & b2;
        if (!(other$iv$iv3 == 128)) {
            yield.invoke(65533);
            return 2;
        }
        int codePoint = (((-123008) ^ b2) ^ (b1 << 6)) ^ (b0 << 12);
        if (codePoint < 2048) {
            yield.invoke(65533);
            return 3;
        }
        if (55296 <= codePoint && codePoint < 57344) {
            r6 = true;
        }
        if (r6) {
            yield.invoke(65533);
            return 3;
        }
        yield.invoke(Integer.valueOf(codePoint));
        return 3;
    }

    public static final int process4Utf8Bytes(byte[] $this$process4Utf8Bytes, int beginIndex, int endIndex, Function1<? super Integer, Unit> yield) {
        Intrinsics.checkNotNullParameter($this$process4Utf8Bytes, "<this>");
        Intrinsics.checkNotNullParameter(yield, "yield");
        if (endIndex <= beginIndex + 3) {
            yield.invoke(65533);
            if (endIndex > beginIndex + 1) {
                byte byte$iv = $this$process4Utf8Bytes[beginIndex + 1];
                int other$iv$iv = 192 & byte$iv;
                byte byte$iv2 = other$iv$iv == 128 ? (byte) 1 : (byte) 0;
                if (byte$iv2 != 0) {
                    if (endIndex > beginIndex + 2) {
                        byte byte$iv3 = $this$process4Utf8Bytes[beginIndex + 2];
                        int other$iv$iv2 = 192 & byte$iv3;
                        if (other$iv$iv2 == 128) {
                            return 3;
                        }
                    }
                    return 2;
                }
            }
            return 1;
        }
        byte b0 = $this$process4Utf8Bytes[beginIndex];
        byte b1 = $this$process4Utf8Bytes[beginIndex + 1];
        int other$iv$iv3 = 192 & b1;
        int $i$f$isUtf8Continuation = other$iv$iv3 == 128 ? 1 : 0;
        if ($i$f$isUtf8Continuation == 0) {
            yield.invoke(65533);
            return 1;
        }
        byte b2 = $this$process4Utf8Bytes[beginIndex + 2];
        int other$iv$iv4 = 192 & b2;
        int $i$f$isUtf8Continuation2 = other$iv$iv4 == 128 ? 1 : 0;
        if ($i$f$isUtf8Continuation2 == 0) {
            yield.invoke(65533);
            return 2;
        }
        byte b3 = $this$process4Utf8Bytes[beginIndex + 3];
        int other$iv$iv5 = 192 & b3;
        if (!(other$iv$iv5 == 128)) {
            yield.invoke(65533);
            return 3;
        }
        int codePoint = (((3678080 ^ b3) ^ (b2 << 6)) ^ (b1 << 12)) ^ (b0 << 18);
        if (codePoint > 1114111) {
            yield.invoke(65533);
            return 4;
        }
        if (55296 <= codePoint && codePoint < 57344) {
            r7 = true;
        }
        if (r7) {
            yield.invoke(65533);
            return 4;
        } else if (codePoint < 65536) {
            yield.invoke(65533);
            return 4;
        } else {
            yield.invoke(Integer.valueOf(codePoint));
            return 4;
        }
    }
}