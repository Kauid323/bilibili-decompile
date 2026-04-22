package io.ktor.utils.io.core.internal;

import com.lynx.tasm.behavior.PropertyIDConstants;
import io.ktor.utils.io.DeprecationKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Buffer;

/* compiled from: ChunkBuffer.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003*>\b\u0007\u0010\u000e\"\u00020\u00002\u00020\u0000B0\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\"\b\b\u0012\u001e\b\u000bB\u001a\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\f\b\f\u0012\b\b\fJ\u0004\b\b(\r¨\u0006\u000f"}, d2 = {"Lkotlinx/io/Buffer;", "", "getWriteRemaining", "(Lkotlinx/io/Buffer;)I", "writeRemaining", "Lkotlin/Deprecated;", "message", DeprecationKt.IO_DEPRECATION_MESSAGE, "replaceWith", "Lkotlin/ReplaceWith;", "expression", "Buffer", "imports", "kotlinx.io", "ChunkBuffer", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class ChunkBufferKt {
    @Deprecated(message = DeprecationKt.IO_DEPRECATION_MESSAGE, replaceWith = @ReplaceWith(expression = "Buffer", imports = {"kotlinx.io"}))
    public static /* synthetic */ void ChunkBuffer$annotations() {
    }

    public static final int getWriteRemaining(Buffer $this$writeRemaining) {
        Intrinsics.checkNotNullParameter($this$writeRemaining, "<this>");
        return Integer.MAX_VALUE;
    }
}