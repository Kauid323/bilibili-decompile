package io.ktor.utils.io;

import com.lynx.tasm.behavior.PropertyIDConstants;
import com.lynx.tasm.behavior.PropsConstants;
import io.ktor.utils.io.core.StringsKt;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.io.Buffer;
import kotlinx.io.Source;

/* compiled from: ByteChannelCtor.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a#\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\f\b\u0002\u0010\f\u001a\u00060\nj\u0002`\u000b¢\u0006\u0004\b\u0006\u0010\r\u001a\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0006\u0010\u0010¨\u0006\u0011"}, d2 = {"", "content", "", "offset", "length", "Lio/ktor/utils/io/ByteReadChannel;", "ByteReadChannel", "([BII)Lio/ktor/utils/io/ByteReadChannel;", "", PropsConstants.TEXT, "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "charset", "(Ljava/lang/String;Ljava/nio/charset/Charset;)Lio/ktor/utils/io/ByteReadChannel;", "Lkotlinx/io/Source;", "source", "(Lkotlinx/io/Source;)Lio/ktor/utils/io/ByteReadChannel;", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class ByteChannelCtorKt {
    public static /* synthetic */ ByteReadChannel ByteReadChannel$default(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return ByteReadChannel(bArr, i, i2);
    }

    public static final ByteReadChannel ByteReadChannel(byte[] content, int offset, int length) {
        Intrinsics.checkNotNullParameter(content, "content");
        Source buffer = new Buffer();
        buffer.write(content, offset, offset + length);
        return ByteReadChannel(buffer);
    }

    public static /* synthetic */ ByteReadChannel ByteReadChannel$default(String str, Charset charset, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        return ByteReadChannel(str, charset);
    }

    public static final ByteReadChannel ByteReadChannel(String text, Charset charset) {
        Intrinsics.checkNotNullParameter(text, PropsConstants.TEXT);
        Intrinsics.checkNotNullParameter(charset, "charset");
        return ByteReadChannel$default(StringsKt.toByteArray(text, charset), 0, 0, 6, null);
    }

    public static final ByteReadChannel ByteReadChannel(Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return new SourceByteReadChannel(source);
    }
}