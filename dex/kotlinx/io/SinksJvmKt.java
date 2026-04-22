package kotlinx.io;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.text.Charsets;

/* compiled from: SinksJvm.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b\u001a\n\u0010\n\u001a\u00020\u000b*\u00020\u0002\u001a\u0012\u0010\f\u001a\u00020\b*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e\u001a\n\u0010\u000f\u001a\u00020\u0010*\u00020\u0002¨\u0006\u0011"}, d2 = {"writeString", "", "Lkotlinx/io/Sink;", "string", "", "charset", "Ljava/nio/charset/Charset;", "startIndex", "", "endIndex", "asOutputStream", "Ljava/io/OutputStream;", "write", "source", "Ljava/nio/ByteBuffer;", "asByteChannel", "Ljava/nio/channels/WritableByteChannel;", "kotlinx-io-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SinksJvmKt {
    public static /* synthetic */ void writeString$default(Sink sink, String str, Charset charset, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = str.length();
        }
        writeString(sink, str, charset, i, i2);
    }

    public static final void writeString(Sink $this$writeString, String string, Charset charset, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$writeString, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        Intrinsics.checkNotNullParameter(charset, "charset");
        int size$iv = string.length();
        _UtilKt.checkBounds(size$iv, startIndex, endIndex);
        if (Intrinsics.areEqual(charset, Charsets.UTF_8)) {
            Utf8Kt.writeString($this$writeString, string, startIndex, endIndex);
            return;
        }
        String substring = string.substring(startIndex, endIndex);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        byte[] data = substring.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(data, "getBytes(...)");
        $this$writeString.write(data, 0, data.length);
    }

    public static final OutputStream asOutputStream(final Sink $this$asOutputStream) {
        final MutablePropertyReference0Impl isClosed;
        Intrinsics.checkNotNullParameter($this$asOutputStream, "<this>");
        if ($this$asOutputStream instanceof RealSink) {
            isClosed = new MutablePropertyReference0Impl($this$asOutputStream) { // from class: kotlinx.io.SinksJvmKt$asOutputStream$isClosed$1
                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                public Object get() {
                    return Boolean.valueOf(((RealSink) this.receiver).closed);
                }

                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                public void set(Object value) {
                    ((RealSink) this.receiver).closed = ((Boolean) value).booleanValue();
                }
            };
        } else if (!($this$asOutputStream instanceof Buffer)) {
            throw new NoWhenBranchMatchedException();
        } else {
            isClosed = new Function0() { // from class: kotlinx.io.SinksJvmKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    boolean asOutputStream$lambda$0;
                    asOutputStream$lambda$0 = SinksJvmKt.asOutputStream$lambda$0();
                    return Boolean.valueOf(asOutputStream$lambda$0);
                }
            };
        }
        return new OutputStream() { // from class: kotlinx.io.SinksJvmKt$asOutputStream$1
            @Override // java.io.OutputStream
            public void write(int i) {
                if (isClosed.invoke().booleanValue()) {
                    throw new IOException("Underlying sink is closed.");
                }
                Sink $this$writeToInternalBuffer$iv = $this$asOutputStream;
                Buffer it = $this$writeToInternalBuffer$iv.getBuffer();
                it.writeByte((byte) i);
                $this$writeToInternalBuffer$iv.hintEmit();
            }

            @Override // java.io.OutputStream
            public void write(byte[] data, int offset, int byteCount) {
                Intrinsics.checkNotNullParameter(data, "data");
                if (isClosed.invoke().booleanValue()) {
                    throw new IOException("Underlying sink is closed.");
                }
                Sink $this$writeToInternalBuffer$iv = $this$asOutputStream;
                Buffer it = $this$writeToInternalBuffer$iv.getBuffer();
                it.write(data, offset, offset + byteCount);
                $this$writeToInternalBuffer$iv.hintEmit();
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
                if (!isClosed.invoke().booleanValue()) {
                    $this$asOutputStream.flush();
                }
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                $this$asOutputStream.close();
            }

            public String toString() {
                return $this$asOutputStream + ".asOutputStream()";
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean asOutputStream$lambda$0() {
        return false;
    }

    public static final int write(Sink $this$write, ByteBuffer source) {
        Intrinsics.checkNotNullParameter($this$write, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        long sizeBefore = $this$write.getBuffer().getSize();
        BuffersJvmKt.transferFrom($this$write.getBuffer(), source);
        long bytesRead = $this$write.getBuffer().getSize() - sizeBefore;
        $this$write.hintEmit();
        return (int) bytesRead;
    }

    public static final WritableByteChannel asByteChannel(final Sink $this$asByteChannel) {
        final MutablePropertyReference0Impl isClosed;
        Intrinsics.checkNotNullParameter($this$asByteChannel, "<this>");
        if ($this$asByteChannel instanceof RealSink) {
            isClosed = new MutablePropertyReference0Impl($this$asByteChannel) { // from class: kotlinx.io.SinksJvmKt$asByteChannel$isClosed$1
                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                public Object get() {
                    return Boolean.valueOf(((RealSink) this.receiver).closed);
                }

                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                public void set(Object value) {
                    ((RealSink) this.receiver).closed = ((Boolean) value).booleanValue();
                }
            };
        } else if (!($this$asByteChannel instanceof Buffer)) {
            throw new NoWhenBranchMatchedException();
        } else {
            isClosed = new Function0() { // from class: kotlinx.io.SinksJvmKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    boolean asByteChannel$lambda$1;
                    asByteChannel$lambda$1 = SinksJvmKt.asByteChannel$lambda$1();
                    return Boolean.valueOf(asByteChannel$lambda$1);
                }
            };
        }
        return new WritableByteChannel() { // from class: kotlinx.io.SinksJvmKt$asByteChannel$1
            @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                Sink.this.close();
            }

            @Override // java.nio.channels.Channel
            public boolean isOpen() {
                return !isClosed.invoke().booleanValue();
            }

            @Override // java.nio.channels.WritableByteChannel
            public int write(ByteBuffer source) {
                Intrinsics.checkNotNullParameter(source, "source");
                if (isClosed.invoke().booleanValue()) {
                    throw new IllegalStateException("Underlying sink is closed.".toString());
                }
                return SinksJvmKt.write(Sink.this, source);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean asByteChannel$lambda$1() {
        return false;
    }
}