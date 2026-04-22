package io.ktor.utils.io.core;

import com.lynx.tasm.behavior.PropertyIDConstants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Source;

/* compiled from: Packet.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\"\u001e\u0010\u0002\u001a\u00020\u0001*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"\u001e\u0010\u0006\u001a\u00020\u0001*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0005\u001a\u0004\b\u0006\u0010\u0003¨\u0006\b"}, d2 = {"Lkotlinx/io/Source;", "", "isEmpty", "(Lkotlinx/io/Source;)Z", "isEmpty$annotations", "(Lkotlinx/io/Source;)V", "isNotEmpty", "isNotEmpty$annotations", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class PacketKt {
    @Deprecated(message = "Use exhausted() instead", replaceWith = @ReplaceWith(expression = "exhausted()", imports = {}))
    public static /* synthetic */ void isEmpty$annotations(Source source) {
    }

    @Deprecated(message = "This makes no sense for streaming inputs. Some use-cases are covered by exhausted() method", replaceWith = @ReplaceWith(expression = "!exhausted()", imports = {}))
    public static /* synthetic */ void isNotEmpty$annotations(Source source) {
    }

    public static final boolean isEmpty(Source $this$isEmpty) {
        Intrinsics.checkNotNullParameter($this$isEmpty, "<this>");
        return $this$isEmpty.exhausted();
    }

    public static final boolean isNotEmpty(Source $this$isNotEmpty) {
        Intrinsics.checkNotNullParameter($this$isNotEmpty, "<this>");
        return !$this$isNotEmpty.exhausted();
    }
}