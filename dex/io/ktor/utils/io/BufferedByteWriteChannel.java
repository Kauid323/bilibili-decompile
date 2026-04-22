package io.ktor.utils.io;

import com.lynx.tasm.behavior.PropertyIDConstants;
import kotlin.Metadata;

/* compiled from: BufferedByteWriteChannel.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"Lio/ktor/utils/io/BufferedByteWriteChannel;", "Lio/ktor/utils/io/ByteWriteChannel;", "", "flushWriteBuffer", "()V", "close", "ktor-io"}, k = 1, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public interface BufferedByteWriteChannel extends ByteWriteChannel {
    void close();

    @InternalAPI
    void flushWriteBuffer();
}