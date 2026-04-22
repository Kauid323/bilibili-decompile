package kotlinx.io;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlinx.io.unsafe.UnsafeBufferOperations;

/* compiled from: SourcesJvm.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0012\u0010\u0007\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u001a\u0010\u0007\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\n\u0010\t\u001a\u00020\n*\u00020\b\u001a\u0012\u0010\u000b\u001a\u00020\f*\u00020\b2\u0006\u0010\r\u001a\u00020\u000e\u001a\n\u0010\u000f\u001a\u00020\u0010*\u00020\b¨\u0006\u0011"}, d2 = {"readStringImpl", "", "Lkotlinx/io/Buffer;", "byteCount", "", "charset", "Ljava/nio/charset/Charset;", "readString", "Lkotlinx/io/Source;", "asInputStream", "Ljava/io/InputStream;", "readAtMostTo", "", "sink", "Ljava/nio/ByteBuffer;", "asByteChannel", "Ljava/nio/channels/ReadableByteChannel;", "kotlinx-io-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SourcesJvmKt {
    private static final String readStringImpl(Buffer $this$readStringImpl, long byteCount, Charset charset) {
        int i = 0;
        if (!(byteCount >= 0 && byteCount <= 2147483647L)) {
            throw new IllegalArgumentException(("byteCount (" + byteCount + ") is not within the range [0..2147483647)").toString());
        }
        if ($this$readStringImpl.getSize() < byteCount) {
            throw new EOFException("Buffer contains less bytes then required (byteCount: " + byteCount + ", size: " + $this$readStringImpl.getSize() + ')');
        }
        if (byteCount == 0) {
            return "";
        }
        String str = null;
        UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
        if ($this$readStringImpl.exhausted()) {
            throw new IllegalArgumentException("Buffer is empty".toString());
        }
        Segment head$iv = $this$readStringImpl.getHead();
        Intrinsics.checkNotNull(head$iv);
        byte[] data = head$iv.dataAsByteArray(true);
        int pos = head$iv.getPos();
        int limit = head$iv.getLimit();
        int len = limit - pos;
        if (len >= byteCount) {
            str = new String(data, pos, (int) byteCount, charset);
            i = (int) byteCount;
        }
        int bytesRead$iv = i;
        if (bytesRead$iv != 0) {
            if (bytesRead$iv < 0) {
                throw new IllegalStateException("Returned negative read bytes count");
            }
            if (bytesRead$iv > head$iv.getSize()) {
                throw new IllegalStateException("Returned too many bytes");
            }
            $this$readStringImpl.skip(bytesRead$iv);
        }
        if (str == null) {
            return new String(SourcesKt.readByteArray($this$readStringImpl, (int) byteCount), charset);
        }
        return str;
    }

    public static final String readString(Source $this$readString, Charset charset) {
        Intrinsics.checkNotNullParameter($this$readString, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        for (long req = 1; $this$readString.request(req); req *= 2) {
        }
        return readStringImpl($this$readString.getBuffer(), $this$readString.getBuffer().getSize(), charset);
    }

    public static final String readString(Source $this$readString, long byteCount, Charset charset) {
        Intrinsics.checkNotNullParameter($this$readString, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        $this$readString.require(byteCount);
        return readStringImpl($this$readString.getBuffer(), byteCount, charset);
    }

    public static final InputStream asInputStream(final Source $this$asInputStream) {
        final MutablePropertyReference0Impl isClosed;
        Intrinsics.checkNotNullParameter($this$asInputStream, "<this>");
        if ($this$asInputStream instanceof RealSource) {
            isClosed = new MutablePropertyReference0Impl($this$asInputStream) { // from class: kotlinx.io.SourcesJvmKt$asInputStream$isClosed$1
                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                public Object get() {
                    return Boolean.valueOf(((RealSource) this.receiver).closed);
                }

                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                public void set(Object value) {
                    ((RealSource) this.receiver).closed = ((Boolean) value).booleanValue();
                }
            };
        } else if (!($this$asInputStream instanceof Buffer)) {
            throw new NoWhenBranchMatchedException();
        } else {
            isClosed = new Function0() { // from class: kotlinx.io.SourcesJvmKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    boolean asInputStream$lambda$2;
                    asInputStream$lambda$2 = SourcesJvmKt.asInputStream$lambda$2();
                    return Boolean.valueOf(asInputStream$lambda$2);
                }
            };
        }
        return new InputStream() { // from class: kotlinx.io.SourcesJvmKt$asInputStream$1
            @Override // java.io.InputStream
            public int read() {
                if (isClosed.invoke().booleanValue()) {
                    throw new IOException("Underlying source is closed.");
                }
                if ($this$asInputStream.exhausted()) {
                    return -1;
                }
                byte $this$and$iv = $this$asInputStream.readByte();
                return $this$and$iv & 255;
            }

            @Override // java.io.InputStream
            public int read(byte[] data, int offset, int byteCount) {
                Intrinsics.checkNotNullParameter(data, "data");
                if (isClosed.invoke().booleanValue()) {
                    throw new IOException("Underlying source is closed.");
                }
                _UtilKt.checkOffsetAndCount(data.length, offset, byteCount);
                return $this$asInputStream.readAtMostTo(data, offset, offset + byteCount);
            }

            @Override // java.io.InputStream
            public int available() {
                if (isClosed.invoke().booleanValue()) {
                    throw new IOException("Underlying source is closed.");
                }
                long a$iv = $this$asInputStream.getBuffer().getSize();
                return (int) Math.min(a$iv, Integer.MAX_VALUE);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                $this$asInputStream.close();
            }

            public String toString() {
                return $this$asInputStream + ".asInputStream()";
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean asInputStream$lambda$2() {
        return false;
    }

    public static final int readAtMostTo(Source $this$readAtMostTo, ByteBuffer sink) {
        Intrinsics.checkNotNullParameter($this$readAtMostTo, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        if ($this$readAtMostTo.getBuffer().getSize() == 0) {
            $this$readAtMostTo.request(8192L);
            if ($this$readAtMostTo.getBuffer().getSize() == 0) {
                return -1;
            }
        }
        return BuffersJvmKt.readAtMostTo($this$readAtMostTo.getBuffer(), sink);
    }

    public static final ReadableByteChannel asByteChannel(final Source $this$asByteChannel) {
        final MutablePropertyReference0Impl isClosed;
        Intrinsics.checkNotNullParameter($this$asByteChannel, "<this>");
        if ($this$asByteChannel instanceof RealSource) {
            isClosed = new MutablePropertyReference0Impl($this$asByteChannel) { // from class: kotlinx.io.SourcesJvmKt$asByteChannel$isClosed$1
                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                public Object get() {
                    return Boolean.valueOf(((RealSource) this.receiver).closed);
                }

                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                public void set(Object value) {
                    ((RealSource) this.receiver).closed = ((Boolean) value).booleanValue();
                }
            };
        } else if (!($this$asByteChannel instanceof Buffer)) {
            throw new NoWhenBranchMatchedException();
        } else {
            isClosed = new Function0() { // from class: kotlinx.io.SourcesJvmKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    boolean asByteChannel$lambda$3;
                    asByteChannel$lambda$3 = SourcesJvmKt.asByteChannel$lambda$3();
                    return Boolean.valueOf(asByteChannel$lambda$3);
                }
            };
        }
        return new ReadableByteChannel() { // from class: kotlinx.io.SourcesJvmKt$asByteChannel$1
            @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                Source.this.close();
            }

            @Override // java.nio.channels.Channel
            public boolean isOpen() {
                return !isClosed.invoke().booleanValue();
            }

            @Override // java.nio.channels.ReadableByteChannel
            public int read(ByteBuffer sink) {
                Intrinsics.checkNotNullParameter(sink, "sink");
                return SourcesJvmKt.readAtMostTo(Source.this, sink);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean asByteChannel$lambda$3() {
        return false;
    }
}