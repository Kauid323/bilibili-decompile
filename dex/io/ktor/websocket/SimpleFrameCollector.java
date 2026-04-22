package io.ktor.websocket;

import com.bilibili.doraemonkit.widget.tableview.bean.Column;
import com.bilibili.upper.comm.report.UpperReportConstants;
import io.ktor.util.NIOKt;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SimpleFrameCollector.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\n \u0014*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0019\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lio/ktor/websocket/SimpleFrameCollector;", Column.INVAL_VALUE, "<init>", "()V", Column.INVAL_VALUE, "length", "Ljava/nio/ByteBuffer;", "bb", Column.INVAL_VALUE, UpperReportConstants.PUBLISH_STEP_START, "(ILjava/nio/ByteBuffer;)V", "handle", "(Ljava/nio/ByteBuffer;)V", "maskKey", "take", "(Ljava/lang/Integer;)Ljava/nio/ByteBuffer;", "remaining", "I", "buffer", "Ljava/nio/ByteBuffer;", "kotlin.jvm.PlatformType", "maskBuffer", Column.INVAL_VALUE, "getHasRemaining", "()Z", "hasRemaining", "ktor-websockets"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SimpleFrameCollector {
    private ByteBuffer buffer;
    private final ByteBuffer maskBuffer = ByteBuffer.allocate(4);
    private int remaining;

    public final boolean getHasRemaining() {
        return this.remaining > 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
        if (r0.capacity() < r4) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void start(int length, ByteBuffer bb) {
        Intrinsics.checkNotNullParameter(bb, "bb");
        if (!(this.remaining == 0)) {
            throw new IllegalStateException("remaining should be 0");
        }
        this.remaining = length;
        if (this.buffer != null) {
            ByteBuffer byteBuffer = this.buffer;
            Intrinsics.checkNotNull(byteBuffer);
        }
        this.buffer = ByteBuffer.allocate(length);
        ByteBuffer byteBuffer2 = this.buffer;
        Intrinsics.checkNotNull(byteBuffer2);
        byteBuffer2.clear();
        handle(bb);
    }

    public final void handle(ByteBuffer bb) {
        Intrinsics.checkNotNullParameter(bb, "bb");
        int i = this.remaining;
        ByteBuffer byteBuffer = this.buffer;
        Intrinsics.checkNotNull(byteBuffer);
        this.remaining = i - NIOKt.moveTo(bb, byteBuffer, this.remaining);
    }

    public final ByteBuffer take(Integer maskKey) {
        ByteBuffer $this$take_u24lambda_u241 = this.buffer;
        Intrinsics.checkNotNull($this$take_u24lambda_u241);
        $this$take_u24lambda_u241.flip();
        ByteBuffer view = $this$take_u24lambda_u241.slice();
        if (maskKey != null) {
            this.maskBuffer.clear();
            this.maskBuffer.asIntBuffer().put(maskKey.intValue());
            this.maskBuffer.clear();
            Intrinsics.checkNotNull(view);
            ByteBuffer byteBuffer = this.maskBuffer;
            Intrinsics.checkNotNullExpressionValue(byteBuffer, "maskBuffer");
            UtilsKt.xor(view, byteBuffer);
        }
        this.buffer = null;
        ByteBuffer $this$take_u24lambda_u2412 = view.asReadOnlyBuffer();
        Intrinsics.checkNotNullExpressionValue($this$take_u24lambda_u2412, "run(...)");
        return $this$take_u24lambda_u2412;
    }
}