package io.ktor.util.cio;

import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.jvm.javaio.BlockingKt;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: OutputStreamAdapters.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/utils/io/ByteWriteChannel;", "Ljava/nio/charset/Charset;", "charset", "Ljava/io/BufferedWriter;", "bufferedWriter", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/nio/charset/Charset;)Ljava/io/BufferedWriter;", "Ljava/io/Writer;", "writer", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/nio/charset/Charset;)Ljava/io/Writer;", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class OutputStreamAdaptersKt {
    public static /* synthetic */ BufferedWriter bufferedWriter$default(ByteWriteChannel byteWriteChannel, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return bufferedWriter(byteWriteChannel, charset);
    }

    public static final BufferedWriter bufferedWriter(ByteWriteChannel $this$bufferedWriter, Charset charset) {
        Intrinsics.checkNotNullParameter($this$bufferedWriter, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(BlockingKt.toOutputStream($this$bufferedWriter), charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192);
    }

    public static /* synthetic */ Writer writer$default(ByteWriteChannel byteWriteChannel, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return writer(byteWriteChannel, charset);
    }

    public static final Writer writer(ByteWriteChannel $this$writer, Charset charset) {
        Intrinsics.checkNotNullParameter($this$writer, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return new OutputStreamWriter(BlockingKt.toOutputStream($this$writer), charset);
    }
}