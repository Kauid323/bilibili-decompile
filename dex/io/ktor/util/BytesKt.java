package io.ktor.util;

import io.ktor.utils.io.InternalAPI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Bytes.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\n\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", "", "offset", "", "readShort", "([BI)S", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BytesKt {
    @InternalAPI
    public static final short readShort(byte[] $this$readShort, int offset) {
        Intrinsics.checkNotNullParameter($this$readShort, "<this>");
        int result = (($this$readShort[offset] & 255) << 8) | ($this$readShort[offset + 1] & 255);
        return (short) result;
    }
}