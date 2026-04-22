package io.ktor.websocket;

import com.bilibili.doraemonkit.widget.tableview.bean.Column;
import com.bilibili.dynamicview2.view.render.SapNodeProp;
import com.bilibili.gripper.api.ad.core.report.UIExtraParams;
import io.ktor.websocket.CloseReason;
import io.ktor.websocket.Frame;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WebSocketSession.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\u001a1\u0010\u0004\u001a\u00028\u0000\"\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u0000*\u00020\u00022\u0010\u0010\u0004\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0004\u0010\u0005\u001a3\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u0000*\u00020\u00022\u0010\u0010\u0004\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u001c\u0010\n\u001a\u00020\t*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b\n\u0010\u000b\u001a\u001c\u0010\n\u001a\u00020\t*\u00020\u00022\u0006\u0010\b\u001a\u00020\fH\u0086@¢\u0006\u0004\b\n\u0010\r\u001a\u001e\u0010\u0010\u001a\u00020\t*\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001e\u0010\u0010\u001a\u00020\t*\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0087@¢\u0006\u0004\b\u0010\u0010\u0014\u001a\u001c\u0010\u0015\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0086@¢\u0006\u0004\b\u0015\u0010\u0014¨\u0006\u0016"}, d2 = {"Lio/ktor/websocket/WebSocketExtension;", "T", "Lio/ktor/websocket/WebSocketSession;", "Lio/ktor/websocket/WebSocketExtensionFactory;", "extension", "(Lio/ktor/websocket/WebSocketSession;Lio/ktor/websocket/WebSocketExtensionFactory;)Lio/ktor/websocket/WebSocketExtension;", "extensionOrNull", Column.INVAL_VALUE, SapNodeProp.KEY_CONTENT, Column.INVAL_VALUE, "send", "(Lio/ktor/websocket/WebSocketSession;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", Column.INVAL_VALUE, "(Lio/ktor/websocket/WebSocketSession;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/websocket/CloseReason;", UIExtraParams.REASON, "close", "(Lio/ktor/websocket/WebSocketSession;Lio/ktor/websocket/CloseReason;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", Column.INVAL_VALUE, "cause", "(Lio/ktor/websocket/WebSocketSession;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "closeExceptionally", "ktor-websockets"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class WebSocketSessionKt {
    public static final <T extends WebSocketExtension<?>> T extension(WebSocketSession $this$extension, WebSocketExtensionFactory<?, T> webSocketExtensionFactory) {
        Intrinsics.checkNotNullParameter($this$extension, "<this>");
        Intrinsics.checkNotNullParameter(webSocketExtensionFactory, "extension");
        T t = (T) extensionOrNull($this$extension, webSocketExtensionFactory);
        if (t != null) {
            return t;
        }
        throw new IllegalStateException(("Extension " + webSocketExtensionFactory + " not found.").toString());
    }

    public static final <T extends WebSocketExtension<?>> T extensionOrNull(WebSocketSession $this$extensionOrNull, WebSocketExtensionFactory<?, T> webSocketExtensionFactory) {
        Object element$iv;
        boolean z;
        Intrinsics.checkNotNullParameter($this$extensionOrNull, "<this>");
        Intrinsics.checkNotNullParameter(webSocketExtensionFactory, "extension");
        Iterable $this$firstOrNull$iv = $this$extensionOrNull.getExtensions();
        Iterator<T> it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv = it.next();
                WebSocketExtension it2 = (WebSocketExtension) element$iv;
                if (it2.getFactory().getKey() == webSocketExtensionFactory.getKey()) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        if (element$iv instanceof WebSocketExtension) {
            return (T) element$iv;
        }
        return null;
    }

    public static final Object send(WebSocketSession $this$send, String content, Continuation<? super Unit> continuation) {
        Object send = $this$send.send(new Frame.Text(content), continuation);
        return send == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? send : Unit.INSTANCE;
    }

    public static final Object send(WebSocketSession $this$send, byte[] content, Continuation<? super Unit> continuation) {
        Object send = $this$send.send(new Frame.Binary(true, content), continuation);
        return send == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? send : Unit.INSTANCE;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:1|(2:3|(4:5|6|7|8))|25|6|7|8) */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c A[Catch: all -> 0x0030, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0030, blocks: (B:12:0x002c, B:17:0x0036, B:23:0x0051, B:20:0x003e), top: B:29:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object close(WebSocketSession $this$close, CloseReason reason, Continuation<? super Unit> continuation) {
        WebSocketSessionKt$close$1 webSocketSessionKt$close$1;
        if (continuation instanceof WebSocketSessionKt$close$1) {
            webSocketSessionKt$close$1 = (WebSocketSessionKt$close$1) continuation;
            if ((webSocketSessionKt$close$1.label & Integer.MIN_VALUE) != 0) {
                webSocketSessionKt$close$1.label -= Integer.MIN_VALUE;
                Object $result = webSocketSessionKt$close$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (webSocketSessionKt$close$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        webSocketSessionKt$close$1.L$0 = $this$close;
                        webSocketSessionKt$close$1.label = 1;
                        if ($this$close.send(new Frame.Close(reason), webSocketSessionKt$close$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        webSocketSessionKt$close$1.L$0 = null;
                        webSocketSessionKt$close$1.label = 2;
                        if ($this$close.flush(webSocketSessionKt$close$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        $this$close = (WebSocketSession) webSocketSessionKt$close$1.L$0;
                        ResultKt.throwOnFailure($result);
                        webSocketSessionKt$close$1.L$0 = null;
                        webSocketSessionKt$close$1.label = 2;
                        if ($this$close.flush(webSocketSessionKt$close$1) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        webSocketSessionKt$close$1 = new WebSocketSessionKt$close$1(continuation);
        Object $result2 = webSocketSessionKt$close$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (webSocketSessionKt$close$1.label) {
        }
    }

    public static /* synthetic */ Object close$default(WebSocketSession webSocketSession, CloseReason closeReason, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            closeReason = new CloseReason(CloseReason.Codes.NORMAL, Column.INVAL_VALUE);
        }
        return close(webSocketSession, closeReason, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Close with reason or terminate instead.")
    public static final Object close(WebSocketSession $this$close, Throwable cause, Continuation<? super Unit> continuation) {
        if (cause == null) {
            Object close$default = close$default($this$close, null, continuation, 1, null);
            return close$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? close$default : Unit.INSTANCE;
        }
        Object closeExceptionally = closeExceptionally($this$close, cause, continuation);
        return closeExceptionally == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? closeExceptionally : Unit.INSTANCE;
    }

    public static final Object closeExceptionally(WebSocketSession $this$closeExceptionally, Throwable cause, Continuation<? super Unit> continuation) {
        CloseReason reason = cause instanceof CancellationException ? new CloseReason(CloseReason.Codes.NORMAL, Column.INVAL_VALUE) : new CloseReason(CloseReason.Codes.INTERNAL_ERROR, cause.toString());
        Object close = close($this$closeExceptionally, reason, continuation);
        return close == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? close : Unit.INSTANCE;
    }
}