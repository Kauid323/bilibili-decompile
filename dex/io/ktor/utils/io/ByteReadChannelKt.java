package io.ktor.utils.io;

import com.lynx.tasm.behavior.PropertyIDConstants;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteReadChannel.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "", "cancel", "(Lio/ktor/utils/io/ByteReadChannel;)V", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class ByteReadChannelKt {
    public static final void cancel(ByteReadChannel $this$cancel) {
        Intrinsics.checkNotNullParameter($this$cancel, "<this>");
        $this$cancel.cancel(new IOException("Channel was cancelled"));
    }
}