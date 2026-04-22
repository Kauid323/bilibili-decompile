package io.ktor.utils.io.bits;

import com.lynx.tasm.behavior.PropertyIDConstants;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;

/* compiled from: ByteOrder.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\u001a\u0011\u0010\u0003\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0011\u0010\u0003\u001a\u00020\u0004*\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0011\u0010\u0003\u001a\u00020\u0007*\u00020\u0007¢\u0006\u0004\b\b\u0010\t\"\u0016\u0010\u000e\u001a\u00020\u000b*\u00020\n8Æ\u0002¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u0016\u0010\u0010\u001a\u00020\u000b*\u00020\n8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r\"\u0016\u0010\u0014\u001a\u00020\n*\u00020\u00118Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u0016\u0010\u0016\u001a\u00020\n*\u00020\u00118Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013\"\u0016\u0010\u001a\u001a\u00020\u0011*\u00020\u00178Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\"\u0016\u0010\u001c\u001a\u00020\u0011*\u00020\u00178Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019¨\u0006\u001d"}, d2 = {"Lkotlin/UShort;", "reverseByteOrder-xj2QHRw", "(S)S", "reverseByteOrder", "Lkotlin/UInt;", "reverseByteOrder-WZ4Q5Ns", "(I)I", "Lkotlin/ULong;", "reverseByteOrder-VKZWuLQ", "(J)J", "", "", "getHighByte", "(S)B", "highByte", "getLowByte", "lowByte", "", "getHighShort", "(I)S", "highShort", "getLowShort", "lowShort", "", "getHighInt", "(J)I", "highInt", "getLowInt", "lowInt", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class ByteOrderKt {
    /* renamed from: reverseByteOrder-xj2QHRw  reason: not valid java name */
    public static final short m1392reverseByteOrderxj2QHRw(short $this$reverseByteOrder_u2dxj2QHRw) {
        short $this$reverseByteOrder$iv = Short.reverseBytes($this$reverseByteOrder_u2dxj2QHRw);
        return UShort.constructor-impl($this$reverseByteOrder$iv);
    }

    /* renamed from: reverseByteOrder-WZ4Q5Ns  reason: not valid java name */
    public static final int m1391reverseByteOrderWZ4Q5Ns(int $this$reverseByteOrder_u2dWZ4Q5Ns) {
        int $this$reverseByteOrder$iv = Integer.reverseBytes($this$reverseByteOrder_u2dWZ4Q5Ns);
        return UInt.constructor-impl($this$reverseByteOrder$iv);
    }

    /* renamed from: reverseByteOrder-VKZWuLQ  reason: not valid java name */
    public static final long m1390reverseByteOrderVKZWuLQ(long $this$reverseByteOrder_u2dVKZWuLQ) {
        long $this$reverseByteOrder$iv = Long.reverseBytes($this$reverseByteOrder_u2dVKZWuLQ);
        return ULong.constructor-impl($this$reverseByteOrder$iv);
    }

    public static final byte getHighByte(short $this$highByte) {
        return (byte) ($this$highByte >>> 8);
    }

    public static final byte getLowByte(short $this$lowByte) {
        return (byte) ($this$lowByte & 255);
    }

    public static final short getHighShort(int $this$highShort) {
        return (short) ($this$highShort >>> 16);
    }

    public static final short getLowShort(int $this$lowShort) {
        return (short) (65535 & $this$lowShort);
    }

    public static final int getHighInt(long $this$highInt) {
        return (int) ($this$highInt >>> 32);
    }

    public static final int getLowInt(long $this$lowInt) {
        return (int) (4294967295L & $this$lowInt);
    }
}