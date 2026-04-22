package io.ktor.websocket;

import com.bilibili.doraemonkit.widget.tableview.bean.Column;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: WebSocketExtensionHeader.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {Column.INVAL_VALUE, "value", Column.INVAL_VALUE, "Lio/ktor/websocket/WebSocketExtensionHeader;", "parseWebSocketExtensions", "(Ljava/lang/String;)Ljava/util/List;", "ktor-websockets"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class WebSocketExtensionHeaderKt {
    public static final List<WebSocketExtensionHeader> parseWebSocketExtensions(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        Iterable $this$map$iv = StringsKt.split$default(value, new String[]{","}, false, 0, 6, (Object) null);
        int i = 10;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String it = (String) item$iv$iv;
            List extension = StringsKt.split$default(it, new String[]{";"}, false, 0, 6, (Object) null);
            String name = StringsKt.trim((String) CollectionsKt.first(extension)).toString();
            Iterable $this$map$iv2 = CollectionsKt.drop(extension, 1);
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, i));
            for (Object item$iv$iv2 : $this$map$iv2) {
                String it2 = (String) item$iv$iv2;
                destination$iv$iv2.add(StringsKt.trim(it2).toString());
            }
            List parameters = (List) destination$iv$iv2;
            destination$iv$iv.add(new WebSocketExtensionHeader(name, parameters));
            i = 10;
        }
        return (List) destination$iv$iv;
    }
}