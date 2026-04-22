package io.ktor.utils.io.core;

import com.lynx.tasm.behavior.PropertyIDConstants;
import io.ktor.utils.io.DeprecationKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Buffer;

/* compiled from: BufferAppend.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a#\u0010\u0004\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/io/Buffer;", "other", "", "maxSize", "writeBufferAppend", "(Lkotlinx/io/Buffer;Lkotlinx/io/Buffer;I)I", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class BufferAppendKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = DeprecationKt.IO_DEPRECATION_MESSAGE, replaceWith = @ReplaceWith(expression = "write(other, min(other.size, maxSize.toLong())", imports = {}))
    public static final int writeBufferAppend(Buffer $this$writeBufferAppend, Buffer other, int maxSize) {
        Intrinsics.checkNotNullParameter($this$writeBufferAppend, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        long byteCount = Math.min(other.getSize(), maxSize);
        $this$writeBufferAppend.write(other, byteCount);
        return (int) byteCount;
    }
}