package io.ktor.websocket;

import java.nio.ByteBuffer;
import kotlin.Metadata;

@Metadata(d1 = {"io/ktor/websocket/UtilsKt__UtilsJvmKt", "io/ktor/websocket/UtilsKt__UtilsKt"}, k = 4, mv = {2, 0, 0}, xi = 48)
public final class UtilsKt {
    public static final int flagAt(boolean $this$flagAt, int at) {
        return UtilsKt__UtilsKt.flagAt($this$flagAt, at);
    }

    public static final int getOUTGOING_CHANNEL_CAPACITY() {
        return UtilsKt__UtilsJvmKt.getOUTGOING_CHANNEL_CAPACITY();
    }

    public static final byte xor(byte $this$xor, byte other) {
        return UtilsKt__UtilsKt.xor($this$xor, other);
    }

    public static final void xor(ByteBuffer $this$xor, ByteBuffer other) {
        UtilsKt__UtilsJvmKt.xor($this$xor, other);
    }
}