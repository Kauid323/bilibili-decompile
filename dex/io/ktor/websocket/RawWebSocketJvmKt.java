package io.ktor.websocket;

import com.bilibili.doraemonkit.widget.tableview.bean.Column;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RawWebSocketJvm.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "input", "Lio/ktor/utils/io/ByteWriteChannel;", "output", Column.INVAL_VALUE, "maxFrameSize", Column.INVAL_VALUE, "masking", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lio/ktor/websocket/WebSocketSession;", "RawWebSocket", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;JZLkotlin/coroutines/CoroutineContext;)Lio/ktor/websocket/WebSocketSession;", "ktor-websockets"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RawWebSocketJvmKt {
    public static /* synthetic */ WebSocketSession RawWebSocket$default(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j, boolean z, CoroutineContext coroutineContext, int i, Object obj) {
        long j2;
        boolean z2;
        if ((i & 4) == 0) {
            j2 = j;
        } else {
            j2 = 2147483647L;
        }
        if ((i & 8) == 0) {
            z2 = z;
        } else {
            z2 = false;
        }
        return RawWebSocket(byteReadChannel, byteWriteChannel, j2, z2, coroutineContext);
    }

    public static final WebSocketSession RawWebSocket(ByteReadChannel input, ByteWriteChannel output, long maxFrameSize, boolean masking, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        return new RawWebSocketJvm(input, output, maxFrameSize, masking, coroutineContext, null, 32, null);
    }
}