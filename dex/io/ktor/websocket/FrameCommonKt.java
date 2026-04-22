package io.ktor.websocket;

import com.bilibili.doraemonkit.widget.tableview.bean.Column;
import io.ktor.utils.io.charsets.EncodingKt;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import io.ktor.utils.io.core.StringsKt;
import io.ktor.websocket.Frame;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.io.Buffer;
import kotlinx.io.Sink;
import kotlinx.io.Source;

/* compiled from: FrameCommon.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0013\u0010\n\u001a\u0004\u0018\u00010\t*\u00020\b¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/websocket/Frame$Text;", Column.INVAL_VALUE, "readText", "(Lio/ktor/websocket/Frame$Text;)Ljava/lang/String;", "Lio/ktor/websocket/Frame;", Column.INVAL_VALUE, "readBytes", "(Lio/ktor/websocket/Frame;)[B", "Lio/ktor/websocket/Frame$Close;", "Lio/ktor/websocket/CloseReason;", "readReason", "(Lio/ktor/websocket/Frame$Close;)Lio/ktor/websocket/CloseReason;", "ktor-websockets"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class FrameCommonKt {
    public static final String readText(Frame.Text $this$readText) {
        Intrinsics.checkNotNullParameter($this$readText, "<this>");
        if ($this$readText.getFin()) {
            CharsetDecoder newDecoder = Charsets.UTF_8.newDecoder();
            Intrinsics.checkNotNullExpressionValue(newDecoder, "newDecoder(...)");
            Source buffer = new Buffer();
            Sink $this$readText_u24lambda_u241 = (Sink) buffer;
            BytePacketBuilderKt.writeFully$default($this$readText_u24lambda_u241, $this$readText.getData(), 0, 0, 6, (Object) null);
            return EncodingKt.decode$default(newDecoder, buffer, 0, 2, (Object) null);
        }
        throw new IllegalArgumentException("Text could be only extracted from non-fragmented frame".toString());
    }

    public static final byte[] readBytes(Frame $this$readBytes) {
        Intrinsics.checkNotNullParameter($this$readBytes, "<this>");
        byte[] data = $this$readBytes.getData();
        byte[] copyOf = Arrays.copyOf(data, data.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        return copyOf;
    }

    public static final CloseReason readReason(Frame.Close $this$readReason) {
        Intrinsics.checkNotNullParameter($this$readReason, "<this>");
        if ($this$readReason.getData().length < 2) {
            return null;
        }
        Source buffer = new Buffer();
        Sink $this$readReason_u24lambda_u242 = (Sink) buffer;
        BytePacketBuilderKt.writeFully$default($this$readReason_u24lambda_u242, $this$readReason.getData(), 0, 0, 6, (Object) null);
        Source packet = buffer;
        short code = packet.readShort();
        String message = StringsKt.readText$default(packet, (Charset) null, 0, 3, (Object) null);
        return new CloseReason(code, message);
    }
}