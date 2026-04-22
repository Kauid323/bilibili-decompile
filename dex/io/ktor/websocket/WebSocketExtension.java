package io.ktor.websocket;

import com.bilibili.doraemonkit.widget.tableview.bean.Column;
import java.util.List;
import kotlin.Metadata;

/* compiled from: WebSocketExtension.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001J\u001d\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u0010\u0010\u000fR(\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\u00118&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lio/ktor/websocket/WebSocketExtension;", Column.INVAL_VALUE, "ConfigType", Column.INVAL_VALUE, "Lio/ktor/websocket/WebSocketExtensionHeader;", "negotiatedProtocols", Column.INVAL_VALUE, "clientNegotiation", "(Ljava/util/List;)Z", "requestedProtocols", "serverNegotiation", "(Ljava/util/List;)Ljava/util/List;", "Lio/ktor/websocket/Frame;", "frame", "processOutgoingFrame", "(Lio/ktor/websocket/Frame;)Lio/ktor/websocket/Frame;", "processIncomingFrame", "Lio/ktor/websocket/WebSocketExtensionFactory;", "getFactory", "()Lio/ktor/websocket/WebSocketExtensionFactory;", "factory", "getProtocols", "()Ljava/util/List;", "protocols", "ktor-websockets"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface WebSocketExtension<ConfigType> {
    boolean clientNegotiation(List<WebSocketExtensionHeader> list);

    WebSocketExtensionFactory<ConfigType, ? extends WebSocketExtension<ConfigType>> getFactory();

    List<WebSocketExtensionHeader> getProtocols();

    Frame processIncomingFrame(Frame frame);

    Frame processOutgoingFrame(Frame frame);

    List<WebSocketExtensionHeader> serverNegotiation(List<WebSocketExtensionHeader> list);
}