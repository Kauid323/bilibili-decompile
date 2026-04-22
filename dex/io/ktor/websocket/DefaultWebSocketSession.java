package io.ktor.websocket;

import com.bilibili.doraemonkit.widget.tableview.bean.Column;
import com.bilibili.upper.comm.report.UpperReportConstants;
import io.ktor.utils.io.InternalAPI;
import io.ktor.websocket.WebSocketSession;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.Deferred;

/* compiled from: DefaultWebSocketSession.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\u00020\u00052\u0012\b\u0002\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002H'¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\r\u001a\u00020\b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\u00020\b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00118&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lio/ktor/websocket/DefaultWebSocketSession;", "Lio/ktor/websocket/WebSocketSession;", Column.INVAL_VALUE, "Lio/ktor/websocket/WebSocketExtension;", "negotiatedExtensions", Column.INVAL_VALUE, UpperReportConstants.PUBLISH_STEP_START, "(Ljava/util/List;)V", Column.INVAL_VALUE, "getPingIntervalMillis", "()J", "setPingIntervalMillis", "(J)V", "pingIntervalMillis", "getTimeoutMillis", "setTimeoutMillis", "timeoutMillis", "Lkotlinx/coroutines/Deferred;", "Lio/ktor/websocket/CloseReason;", "getCloseReason", "()Lkotlinx/coroutines/Deferred;", "closeReason", "ktor-websockets"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface DefaultWebSocketSession extends WebSocketSession {
    Deferred<CloseReason> getCloseReason();

    long getPingIntervalMillis();

    long getTimeoutMillis();

    void setPingIntervalMillis(long j);

    void setTimeoutMillis(long j);

    @InternalAPI
    void start(List<? extends WebSocketExtension<?>> list);

    /* compiled from: DefaultWebSocketSession.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602230606352175db5d-4dcb-42b5-ae97-9aefdbbfec86/202602230606352175db5d-4dcb-42b5-ae97-9aefdbbfec86.dex */
    public static final class DefaultImpls {
        public static Object send(DefaultWebSocketSession $this, Frame frame, Continuation<? super Unit> continuation) {
            Object send = WebSocketSession.DefaultImpls.send($this, frame, continuation);
            return send == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? send : Unit.INSTANCE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void start$default(DefaultWebSocketSession defaultWebSocketSession, List list, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: start");
            }
            if ((i & 1) != 0) {
                list = CollectionsKt.emptyList();
            }
            defaultWebSocketSession.start(list);
        }
    }
}