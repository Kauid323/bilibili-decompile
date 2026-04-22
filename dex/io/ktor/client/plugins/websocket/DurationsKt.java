package io.ktor.client.plugins.websocket;

import io.ktor.client.plugins.websocket.WebSockets;
import io.ktor.websocket.WebSocketExtensionsConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* compiled from: Durations.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a!\u0010\u0007\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\"\u0018\u0010\u0001\u001a\u0004\u0018\u00010\u0000*\u00020\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\t\".\u0010\u0001\u001a\u0004\u0018\u00010\u0000*\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00008Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lkotlin/time/Duration;", "pingInterval", "", "maxFrameSize", "Lio/ktor/client/plugins/websocket/WebSockets;", "WebSockets-dnQKTGw", "(Lkotlin/time/Duration;J)Lio/ktor/client/plugins/websocket/WebSockets;", "WebSockets", "getPingInterval", "(Lio/ktor/client/plugins/websocket/WebSockets;)Lkotlin/time/Duration;", "Lio/ktor/client/plugins/websocket/WebSockets$Config;", "new", "(Lio/ktor/client/plugins/websocket/WebSockets$Config;)Lkotlin/time/Duration;", "setPingInterval-6Au4x4Y", "(Lio/ktor/client/plugins/websocket/WebSockets$Config;Lkotlin/time/Duration;)V", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DurationsKt {
    /* renamed from: WebSockets-dnQKTGw$default  reason: not valid java name */
    public static /* synthetic */ WebSockets m3510WebSocketsdnQKTGw$default(Duration duration, long j, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = 2147483647L;
        }
        return m3509WebSocketsdnQKTGw(duration, j);
    }

    /* renamed from: WebSockets-dnQKTGw  reason: not valid java name */
    public static final WebSockets m3509WebSocketsdnQKTGw(Duration pingInterval, long maxFrameSize) {
        return new WebSockets(pingInterval != null ? Duration.getInWholeMilliseconds-impl(pingInterval.unbox-impl()) : 0L, maxFrameSize, new WebSocketExtensionsConfig(), null, 8, null);
    }

    public static final Duration getPingInterval(WebSockets $this$pingInterval) {
        Intrinsics.checkNotNullParameter($this$pingInterval, "<this>");
        Long valueOf = Long.valueOf($this$pingInterval.getPingIntervalMillis());
        long it = valueOf.longValue();
        if (!(it > 0)) {
            valueOf = null;
        }
        if (valueOf != null) {
            Duration.Companion companion = Duration.Companion;
            return Duration.box-impl(DurationKt.toDuration(valueOf.longValue(), DurationUnit.MILLISECONDS));
        }
        return null;
    }

    public static final Duration getPingInterval(WebSockets.Config $this$pingInterval) {
        Intrinsics.checkNotNullParameter($this$pingInterval, "<this>");
        Long valueOf = Long.valueOf($this$pingInterval.getPingIntervalMillis());
        long it = valueOf.longValue();
        if (!(it > 0)) {
            valueOf = null;
        }
        if (valueOf != null) {
            Duration.Companion companion = Duration.Companion;
            return Duration.box-impl(DurationKt.toDuration(valueOf.longValue(), DurationUnit.MILLISECONDS));
        }
        return null;
    }

    /* renamed from: setPingInterval-6Au4x4Y  reason: not valid java name */
    public static final void m3511setPingInterval6Au4x4Y(WebSockets.Config $this$pingInterval, Duration duration) {
        Intrinsics.checkNotNullParameter($this$pingInterval, "$this$pingInterval");
        $this$pingInterval.setPingIntervalMillis(duration != null ? Duration.getInWholeMilliseconds-impl(duration.unbox-impl()) : 0L);
    }
}