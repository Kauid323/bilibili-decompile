package io.ktor.utils.io.core;

import com.lynx.tasm.behavior.PropertyIDConstants;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.RawSink;
import kotlinx.io.Sink;
import kotlinx.io.Source;

/* compiled from: Copy.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/io/Source;", "Lkotlinx/io/Sink;", "output", "", "copyTo", "(Lkotlinx/io/Source;Lkotlinx/io/Sink;)J", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class CopyKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use transferTo instead", replaceWith = @ReplaceWith(expression = "output.transferTo(this)", imports = {"kotlinx.io.transferTo"}))
    public static final long copyTo(Source $this$copyTo, Sink output) {
        Intrinsics.checkNotNullParameter($this$copyTo, "<this>");
        Intrinsics.checkNotNullParameter(output, "output");
        return $this$copyTo.transferTo((RawSink) output);
    }
}