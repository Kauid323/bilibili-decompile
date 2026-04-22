package tv.danmaku.biliplayerv2;

import android.content.Context;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.panel.IPanelContainer;
import tv.danmaku.biliplayerv2.service.network.PlayerNetworkMonitor;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PlayerContainer.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\u001bH&J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH&R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\u00020\u0016X¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006!"}, d2 = {"Ltv/danmaku/biliplayerv2/PlayerContainer;", "Ltv/danmaku/biliplayerv2/IPlayerContainer;", "<init>", "()V", "scopeRef", "Ljava/util/concurrent/atomic/AtomicReference;", "Ltv/danmaku/biliplayerv2/PlayerContainerCoroutineScope;", "getScopeRef$biliplayerv2_debug", "()Ljava/util/concurrent/atomic/AtomicReference;", "panelContainer", "Ltv/danmaku/biliplayerv2/panel/IPanelContainer;", "getPanelContainer", "()Ltv/danmaku/biliplayerv2/panel/IPanelContainer;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "playerParams", "Ltv/danmaku/biliplayerv2/PlayerParamsV2;", "getPlayerParams", "()Ltv/danmaku/biliplayerv2/PlayerParamsV2;", "isSharing", "", "()Z", "setSharing", "(Z)V", "getPlayerNetworkMonitor", "Ltv/danmaku/biliplayerv2/service/network/PlayerNetworkMonitor;", "runCalmTask", "", "task", "Ljava/lang/Runnable;", "removeCalmTask", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class PlayerContainer implements IPlayerContainer {
    private final AtomicReference<PlayerContainerCoroutineScope> scopeRef = new AtomicReference<>();

    public abstract Context getContext();

    public abstract IPanelContainer getPanelContainer();

    public abstract PlayerNetworkMonitor getPlayerNetworkMonitor();

    public abstract PlayerParamsV2 getPlayerParams();

    public abstract boolean isSharing();

    public abstract void removeCalmTask(Runnable runnable);

    public abstract void runCalmTask(Runnable runnable);

    public abstract void setSharing(boolean z);

    public final AtomicReference<PlayerContainerCoroutineScope> getScopeRef$biliplayerv2_debug() {
        return this.scopeRef;
    }
}