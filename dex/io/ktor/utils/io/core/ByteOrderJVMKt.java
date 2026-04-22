package io.ktor.utils.io.core;

import com.lynx.tasm.behavior.PropertyIDConstants;
import kotlin.Metadata;

/* compiled from: ByteOrderJVM.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Ljava/nio/ByteOrder;", "nioOrder", "Lio/ktor/utils/io/core/ByteOrder;", "orderOf", "(Ljava/nio/ByteOrder;)Lio/ktor/utils/io/core/ByteOrder;", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class ByteOrderJVMKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteOrder orderOf(java.nio.ByteOrder nioOrder) {
        if (nioOrder == java.nio.ByteOrder.BIG_ENDIAN) {
            return ByteOrder.BIG_ENDIAN;
        }
        return ByteOrder.LITTLE_ENDIAN;
    }
}