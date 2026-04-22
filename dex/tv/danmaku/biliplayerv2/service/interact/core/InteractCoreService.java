package tv.danmaku.biliplayerv2.service.interact.core;

import android.content.Context;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.interact.core.IInteractCoreService;
import tv.danmaku.biliplayerv2.service.interact.core.container.DefaultInteractContainer;
import tv.danmaku.biliplayerv2.service.interact.core.container.IInteractContainer;
import tv.danmaku.biliplayerv2.service.interact.core.sender.DanmakuSendParams;
import tv.danmaku.biliplayerv2.service.interact.core.sender.DefaultDanmakuSender;
import tv.danmaku.biliplayerv2.service.interact.core.sender.IDanmakuSender;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.log.PlayerLog;

/* compiled from: InteractCoreService.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\nH\u0016J\b\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\rH\u0016J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\rH\u0016J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\bH\u0016J\n\u0010 \u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/core/InteractCoreService;", "Ltv/danmaku/biliplayerv2/service/interact/core/IInteractCoreService;", "<init>", "()V", "isEnable", "", "isVisible", "mInteractContainer", "Ltv/danmaku/biliplayerv2/service/interact/core/container/IInteractContainer;", "mDanmakuSender", "Ltv/danmaku/biliplayerv2/service/interact/core/sender/IDanmakuSender;", "mDanmakuVisibleObservers", "Ljava/util/LinkedList;", "Ltv/danmaku/biliplayerv2/service/interact/core/DanmakuVisibleObserver;", "showDanmaku", "", "fromUser", "hideDanmaku", "setDanmakuEnable", "enable", "isDanmakuEnable", "setDanmakuVisible", "visible", "isDanmakuVisible", "setDanmakuSender", "sender", "getDanmakuSender", "registerDanmakuVisibleObserver", "observer", "unregisterDanmakuVisibleObserver", "setInteractContainer", "container", "getInteractContainer", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public class InteractCoreService implements IInteractCoreService {
    private boolean isEnable = true;
    private boolean isVisible = true;
    private IInteractContainer mInteractContainer = new DefaultInteractContainer();
    private IDanmakuSender mDanmakuSender = new DefaultDanmakuSender();
    private final LinkedList<DanmakuVisibleObserver> mDanmakuVisibleObservers = new LinkedList<>();

    @Override // tv.danmaku.biliplayerv2.service.interact.core.IInteractCoreService
    public /* synthetic */ boolean sendCommandDanmaku(Context context, int i, Map map) {
        return IInteractCoreService.CC.$default$sendCommandDanmaku(this, context, i, map);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.core.IInteractCoreService
    public /* synthetic */ boolean sendDanmaku(Context context, DanmakuSendParams danmakuSendParams) {
        return IInteractCoreService.CC.$default$sendDanmaku(this, context, danmakuSendParams);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.core.IInteractCoreService
    public /* synthetic */ boolean sendDanmakuV2(Context context, DanmakuSendParams danmakuSendParams) {
        return IInteractCoreService.CC.$default$sendDanmakuV2(this, context, danmakuSendParams);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.core.IInteractCoreService
    public void showDanmaku(boolean fromUser) {
        if (this.isEnable) {
            this.isVisible = true;
            this.mInteractContainer.showDanmaku();
            Collection $this$toTypedArray$iv = this.mDanmakuVisibleObservers;
            Object[] $this$forEach$iv = $this$toTypedArray$iv.toArray(new DanmakuVisibleObserver[0]);
            for (Object element$iv : $this$forEach$iv) {
                DanmakuVisibleObserver it = (DanmakuVisibleObserver) element$iv;
                it.onDanmakuVisibleChanged(true, fromUser);
            }
            PlayerLog.i("InteractCoreService", "showDanmaku fromUser: " + fromUser);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.core.IInteractCoreService
    public void hideDanmaku(boolean fromUser) {
        this.isVisible = false;
        this.mInteractContainer.hideDanmaku();
        Collection $this$toTypedArray$iv = this.mDanmakuVisibleObservers;
        Object[] $this$forEach$iv = $this$toTypedArray$iv.toArray(new DanmakuVisibleObserver[0]);
        for (Object element$iv : $this$forEach$iv) {
            DanmakuVisibleObserver it = (DanmakuVisibleObserver) element$iv;
            it.onDanmakuVisibleChanged(false, fromUser);
        }
        PlayerLog.i("InteractCoreService", "hideDanmaku fromUser: " + fromUser);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.core.IInteractCoreService
    public void setDanmakuEnable(boolean enable) {
        this.isEnable = enable;
        if (!this.isEnable && this.isVisible) {
            hideDanmaku(false);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.core.IInteractCoreService
    public boolean isDanmakuEnable() {
        return this.isEnable;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.core.IInteractCoreService
    public void setDanmakuVisible(boolean visible, boolean fromUser) {
        this.isVisible = visible;
        if (visible) {
            showDanmaku(fromUser);
        } else {
            hideDanmaku(fromUser);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.core.IInteractCoreService
    public boolean isDanmakuVisible() {
        return this.isVisible && this.isEnable;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.core.IInteractCoreService
    public void setDanmakuSender(IDanmakuSender sender) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        this.mDanmakuSender = sender;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.core.IInteractCoreService
    public IDanmakuSender getDanmakuSender() {
        return this.mDanmakuSender;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.core.IInteractCoreService
    public void registerDanmakuVisibleObserver(DanmakuVisibleObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (!this.mDanmakuVisibleObservers.contains(observer)) {
            this.mDanmakuVisibleObservers.add(observer);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.core.IInteractCoreService
    public void unregisterDanmakuVisibleObserver(DanmakuVisibleObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mDanmakuVisibleObservers.remove(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.core.IInteractCoreService
    public void setInteractContainer(IInteractContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.mInteractContainer = container;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.core.IInteractCoreService
    public IInteractContainer getInteractContainer() {
        return this.mInteractContainer;
    }
}