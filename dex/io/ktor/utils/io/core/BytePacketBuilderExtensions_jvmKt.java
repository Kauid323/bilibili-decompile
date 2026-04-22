package io.ktor.utils.io.core;

import com.lynx.tasm.behavior.PropertyIDConstants;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.BuffersJvmKt;
import kotlinx.io.Sink;

/* compiled from: BytePacketBuilderExtensions.jvm.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/io/Sink;", "Ljava/nio/ByteBuffer;", "buffer", "", "writeFully", "(Lkotlinx/io/Sink;Ljava/nio/ByteBuffer;)V", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class BytePacketBuilderExtensions_jvmKt {
    public static final void writeFully(Sink $this$writeFully, ByteBuffer buffer) {
        Intrinsics.checkNotNullParameter($this$writeFully, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        BuffersJvmKt.transferFrom($this$writeFully.getBuffer(), buffer);
    }
}