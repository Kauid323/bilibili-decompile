package io.ktor.util;

import io.ktor.utils.io.core.ByteReadPacketKt;
import io.ktor.utils.io.core.InputKt;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Source;

/* compiled from: InputJvm.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0003\u001a\u00020\u0002*\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/io/Source;", "Lio/ktor/utils/io/core/Input;", "Ljava/io/InputStream;", "asStream", "(Lkotlinx/io/Source;)Ljava/io/InputStream;", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class InputJvmKt {
    public static final InputStream asStream(final Source $this$asStream) {
        Intrinsics.checkNotNullParameter($this$asStream, "<this>");
        return new InputStream() { // from class: io.ktor.util.InputJvmKt$asStream$1
            @Override // java.io.InputStream
            public int read() {
                if (InputKt.getEndOfInput($this$asStream)) {
                    return -1;
                }
                return $this$asStream.readByte();
            }

            @Override // java.io.InputStream
            public int read(byte[] buffer, int offset, int length) {
                Intrinsics.checkNotNullParameter(buffer, "buffer");
                if (InputKt.getEndOfInput($this$asStream)) {
                    return -1;
                }
                return InputKt.readAvailable($this$asStream, buffer, offset, length);
            }

            @Override // java.io.InputStream
            public long skip(long count) {
                return ByteReadPacketKt.discard($this$asStream, count);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                $this$asStream.close();
            }
        };
    }
}