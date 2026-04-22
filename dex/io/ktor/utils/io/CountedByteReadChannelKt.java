package io.ktor.utils.io;

import com.lynx.tasm.behavior.PropertyIDConstants;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CountedByteReadChannel.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u001e\u0010\t\u001a\u00020\u0004*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/utils/io/CountedByteReadChannel;", "counted", "(Lio/ktor/utils/io/ByteReadChannel;)Lio/ktor/utils/io/CountedByteReadChannel;", "", "getTotalBytesRead", "(Lio/ktor/utils/io/ByteReadChannel;)J", "getTotalBytesRead$annotations", "(Lio/ktor/utils/io/ByteReadChannel;)V", "totalBytesRead", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class CountedByteReadChannelKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "Counter is no longer available on the regular ByteReadChannel. Use CounterByteReadChannel instead.", replaceWith = @ReplaceWith(expression = "this.counted().totalBytesRead", imports = {}))
    public static /* synthetic */ void getTotalBytesRead$annotations(ByteReadChannel byteReadChannel) {
    }

    public static final long getTotalBytesRead(ByteReadChannel $this$totalBytesRead) {
        Intrinsics.checkNotNullParameter($this$totalBytesRead, "<this>");
        throw new IllegalStateException("Counter is no longer available on the regular ByteReadChannel. Use CounterByteReadChannel instead.".toString());
    }

    public static final CountedByteReadChannel counted(ByteReadChannel $this$counted) {
        Intrinsics.checkNotNullParameter($this$counted, "<this>");
        return new CountedByteReadChannel($this$counted);
    }
}