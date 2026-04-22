package io.ktor.utils.io.core;

import com.lynx.tasm.behavior.PropertyIDConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Buffer;
import kotlinx.io.Source;
import kotlinx.io.SourcesKt;

/* compiled from: Buffers.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0013\u0010\u0007\u001a\u00020\u0006*\u00020\u0000H\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlinx/io/Buffer;", "", "count", "", "readBytes", "(Lkotlinx/io/Buffer;I)[B", "", "isEmpty", "(Lkotlinx/io/Buffer;)Z", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class BuffersKt {
    public static /* synthetic */ byte[] readBytes$default(Buffer buffer, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = (int) buffer.getSize();
        }
        return readBytes(buffer, i);
    }

    public static final byte[] readBytes(Buffer $this$readBytes, int count) {
        Intrinsics.checkNotNullParameter($this$readBytes, "<this>");
        return SourcesKt.readByteArray((Source) $this$readBytes, count);
    }

    public static final boolean isEmpty(Buffer $this$isEmpty) {
        Intrinsics.checkNotNullParameter($this$isEmpty, "<this>");
        return $this$isEmpty.getSize() == 0;
    }
}