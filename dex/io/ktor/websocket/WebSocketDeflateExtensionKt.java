package io.ktor.websocket;

import com.bilibili.doraemonkit.widget.tableview.bean.Column;
import io.ktor.websocket.Frame;
import kotlin.Metadata;

/* compiled from: WebSocketDeflateExtension.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006\"\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006\"\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0006\"\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0006\"\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u0006\"\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\r\"\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\r¨\u0006\u000f"}, d2 = {"Lio/ktor/websocket/Frame;", Column.INVAL_VALUE, "isCompressed", "(Lio/ktor/websocket/Frame;)Z", Column.INVAL_VALUE, "SERVER_MAX_WINDOW_BITS", "Ljava/lang/String;", "CLIENT_NO_CONTEXT_TAKEOVER", "SERVER_NO_CONTEXT_TAKEOVER", "CLIENT_MAX_WINDOW_BITS", "PERMESSAGE_DEFLATE", Column.INVAL_VALUE, "MAX_WINDOW_BITS", "I", "MIN_WINDOW_BITS", "ktor-websockets"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class WebSocketDeflateExtensionKt {
    private static final String CLIENT_MAX_WINDOW_BITS = "client_max_window_bits";
    private static final String CLIENT_NO_CONTEXT_TAKEOVER = "client_no_context_takeover";
    private static final int MAX_WINDOW_BITS = 15;
    private static final int MIN_WINDOW_BITS = 8;
    private static final String PERMESSAGE_DEFLATE = "permessage-deflate";
    private static final String SERVER_MAX_WINDOW_BITS = "server_max_window_bits";
    private static final String SERVER_NO_CONTEXT_TAKEOVER = "server_no_context_takeover";

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isCompressed(Frame $this$isCompressed) {
        return $this$isCompressed.getRsv1() && (($this$isCompressed instanceof Frame.Text) || ($this$isCompressed instanceof Frame.Binary));
    }
}