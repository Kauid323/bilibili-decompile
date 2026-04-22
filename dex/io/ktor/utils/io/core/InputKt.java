package io.ktor.utils.io.core;

import com.lynx.tasm.behavior.PropertyIDConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Source;

/* compiled from: Input.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a1\u0010\u0007\u001a\u00020\u0004*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\"\u0019\u0010\f\u001a\u00020\t*\u00060\u0000j\u0002`\u00018F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b*\n\u0010\r\"\u00020\u00002\u00020\u0000¨\u0006\u000e"}, d2 = {"Lkotlinx/io/Source;", "Lio/ktor/utils/io/core/Input;", "", "buffer", "", "offset", "length", "readAvailable", "(Lkotlinx/io/Source;[BII)I", "", "getEndOfInput", "(Lkotlinx/io/Source;)Z", "endOfInput", "Input", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class InputKt {
    public static final boolean getEndOfInput(Source $this$endOfInput) {
        Intrinsics.checkNotNullParameter($this$endOfInput, "<this>");
        return $this$endOfInput.exhausted();
    }

    public static /* synthetic */ int readAvailable$default(Source source, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length - i;
        }
        return readAvailable(source, bArr, i, i2);
    }

    public static final int readAvailable(Source $this$readAvailable, byte[] buffer, int offset, int length) {
        Intrinsics.checkNotNullParameter($this$readAvailable, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int result = $this$readAvailable.readAtMostTo(buffer, offset, offset + length);
        if (result == -1) {
            return 0;
        }
        return result;
    }
}