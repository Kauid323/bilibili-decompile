package io.ktor.utils.io.core;

import com.lynx.tasm.behavior.PropertyIDConstants;
import io.ktor.utils.io.pool.ObjectPool;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Buffer;
import kotlinx.io.RawSource;
import kotlinx.io.Sink;
import kotlinx.io.Source;
import kotlinx.io.SourcesKt;

/* compiled from: ByteReadPacket.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a)\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001b\u0010\u000b\u001a\u00020\n2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\bH\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u000f\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\r\u001a\u0019\u0010\u000f\u001a\u00020\u0002*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0011\u0010\u0011\u001a\u00020\u0005*\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0011\u0010\u0014\u001a\u00020\u0013*\u00020\u0005¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001b\u0010\u0018\u001a\u00020\u0016*\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019\u001a%\u0010\u001e\u001a\u00020\u001d*\u00020\u00052\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\u0004\b\u001e\u0010\u001f\u001a-\u0010 \u001a\u00020\u001d*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b \u0010!\u001a+\u0010$\u001a\u00028\u0000\"\u0004\b\u0000\u0010\"*\u00020\u00052\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u001a¢\u0006\u0004\b$\u0010%\u001a+\u0010$\u001a\u00028\u0000\"\u0004\b\u0000\u0010\"*\u00020&2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u001a¢\u0006\u0004\b$\u0010'\u001a\u0013\u0010(\u001a\u00020\u001d*\u00020\u0005H\u0007¢\u0006\u0004\b(\u0010)\"\u0017\u0010*\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u001b\u00101\u001a\u00020\u0016*\u00020\u00058F¢\u0006\f\u0012\u0004\b0\u0010)\u001a\u0004\b.\u0010/*>\b\u0007\u0010\u0006\"\u00020\u00052\u00020\u0005B0\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\"\b5\u0012\u001e\b\u000bB\u001a\b6\u0012\b\b7\u0012\u0004\b\b(8\u0012\f\b9\u0012\b\b\fJ\u0004\b\b(:¨\u0006;"}, d2 = {"", "array", "", "offset", "length", "Lkotlinx/io/Source;", "ByteReadPacket", "([BII)Lkotlinx/io/Source;", "Lio/ktor/utils/io/pool/ObjectPool;", "pool", "Lkotlinx/io/Buffer;", "Sink", "(Lio/ktor/utils/io/pool/ObjectPool;)Lkotlinx/io/Buffer;", "()Lkotlinx/io/Buffer;", "out", "readAvailable", "(Lkotlinx/io/Source;Lkotlinx/io/Buffer;)I", "copy", "(Lkotlinx/io/Source;)Lkotlinx/io/Source;", "", "readShortLittleEndian", "(Lkotlinx/io/Source;)S", "", "count", "discard", "(Lkotlinx/io/Source;J)J", "Lkotlin/Function1;", "", "block", "", "takeWhile", "(Lkotlinx/io/Source;Lkotlin/jvm/functions/Function1;)V", "readFully", "(Lkotlinx/io/Source;[BII)V", "T", "function", "preview", "(Lkotlinx/io/Source;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lkotlinx/io/Sink;", "(Lkotlinx/io/Sink;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "release", "(Lkotlinx/io/Source;)V", "ByteReadPacketEmpty", "Lkotlinx/io/Source;", "getByteReadPacketEmpty", "()Lkotlinx/io/Source;", "getRemaining", "(Lkotlinx/io/Source;)J", "getRemaining$annotations", "remaining", "Lkotlin/Deprecated;", "message", "Use Source instead", "replaceWith", "Lkotlin/ReplaceWith;", "expression", "Source", "imports", "kotlinx.io.Source", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class ByteReadPacketKt {
    private static final Source ByteReadPacketEmpty = new Buffer();

    @Deprecated(message = "Use Source instead", replaceWith = @ReplaceWith(expression = "Source", imports = {"kotlinx.io.Source"}))
    public static /* synthetic */ void ByteReadPacket$annotations() {
    }

    public static /* synthetic */ void getRemaining$annotations(Source source) {
    }

    public static final Source getByteReadPacketEmpty() {
        return ByteReadPacketEmpty;
    }

    public static /* synthetic */ Source ByteReadPacket$default(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return ByteReadPacket(bArr, i, i2);
    }

    public static final Source ByteReadPacket(byte[] array, int offset, int length) {
        Intrinsics.checkNotNullParameter(array, "array");
        Source buffer = new Buffer();
        buffer.write(array, offset, offset + length);
        return buffer;
    }

    public static final long getRemaining(Source $this$remaining) {
        Intrinsics.checkNotNullParameter($this$remaining, "<this>");
        return $this$remaining.getBuffer().getSize();
    }

    @Deprecated(message = "Use Buffer instead", replaceWith = @ReplaceWith(expression = "Buffer()", imports = {"kotlinx.io.Buffer"}))
    public static final Buffer Sink(ObjectPool<?> objectPool) {
        Intrinsics.checkNotNullParameter(objectPool, "pool");
        return new Buffer();
    }

    @Deprecated(message = "Use Buffer instead", replaceWith = @ReplaceWith(expression = "Buffer()", imports = {"kotlinx.io.Buffer"}))
    public static final Buffer Sink() {
        return new Buffer();
    }

    public static final int readAvailable(Source $this$readAvailable, Buffer out) {
        Intrinsics.checkNotNullParameter($this$readAvailable, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        long result = $this$readAvailable.getBuffer().getSize();
        out.transferFrom((RawSource) $this$readAvailable);
        return (int) result;
    }

    public static final Source copy(Source $this$copy) {
        Intrinsics.checkNotNullParameter($this$copy, "<this>");
        return $this$copy.getBuffer().copy();
    }

    public static final short readShortLittleEndian(Source $this$readShortLittleEndian) {
        Intrinsics.checkNotNullParameter($this$readShortLittleEndian, "<this>");
        return SourcesKt.readShortLe($this$readShortLittleEndian.getBuffer());
    }

    public static /* synthetic */ long discard$default(Source source, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = Long.MAX_VALUE;
        }
        return discard(source, j);
    }

    public static final long discard(Source $this$discard, long count) {
        Intrinsics.checkNotNullParameter($this$discard, "<this>");
        $this$discard.request(count);
        long countToDiscard = Math.min(count, getRemaining($this$discard));
        $this$discard.getBuffer().skip(countToDiscard);
        return countToDiscard;
    }

    public static final void takeWhile(Source $this$takeWhile, Function1<? super Buffer, Boolean> function1) {
        Intrinsics.checkNotNullParameter($this$takeWhile, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        while (!$this$takeWhile.exhausted() && ((Boolean) function1.invoke($this$takeWhile.getBuffer())).booleanValue()) {
        }
    }

    public static /* synthetic */ void readFully$default(Source source, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length - i;
        }
        readFully(source, bArr, i, i2);
    }

    public static final void readFully(Source $this$readFully, byte[] out, int offset, int length) {
        Intrinsics.checkNotNullParameter($this$readFully, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        SourcesKt.readTo($this$readFully, out, offset, offset + length);
    }

    public static final <T> T preview(Source $this$preview, Function1<? super Source, ? extends T> function1) {
        Intrinsics.checkNotNullParameter($this$preview, "<this>");
        Intrinsics.checkNotNullParameter(function1, "function");
        AutoCloseable peek = $this$preview.getBuffer().peek();
        try {
            T t = (T) function1.invoke(peek);
            AutoCloseableKt.closeFinally(peek, (Throwable) null);
            return t;
        } finally {
        }
    }

    public static final <T> T preview(Sink $this$preview, Function1<? super Source, ? extends T> function1) {
        Intrinsics.checkNotNullParameter($this$preview, "<this>");
        Intrinsics.checkNotNullParameter(function1, "function");
        AutoCloseable peek = $this$preview.getBuffer().peek();
        try {
            T t = (T) function1.invoke(peek);
            AutoCloseableKt.closeFinally(peek, (Throwable) null);
            return t;
        } finally {
        }
    }

    @Deprecated(message = "Use close instead", replaceWith = @ReplaceWith(expression = "this.close()", imports = {}))
    public static final void release(Source $this$release) {
        Intrinsics.checkNotNullParameter($this$release, "<this>");
        $this$release.close();
    }
}