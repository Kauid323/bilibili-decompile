package tv.danmaku.biliplayerv2.service.interact.core;

import android.content.Context;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.interact.core.container.IInteractContainer;
import tv.danmaku.biliplayerv2.service.interact.core.sender.DanmakuSendParams;
import tv.danmaku.biliplayerv2.service.interact.core.sender.IDanmakuSender;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IInteractCoreService.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0005H&J\u0012\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0005H&J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005H&J\b\u0010\f\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&J\u001a\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J.\u0010\u0017\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00010\u001bH\u0016J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001fH&J\n\u0010!\u001a\u0004\u0018\u00010\"H&J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\"H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006%À\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/core/IInteractCoreService;", "", "setDanmakuEnable", "", "enable", "", "isDanmakuEnable", "showDanmaku", "fromUser", "hideDanmaku", "setDanmakuVisible", "visible", "isDanmakuVisible", "setDanmakuSender", "sender", "Ltv/danmaku/biliplayerv2/service/interact/core/sender/IDanmakuSender;", "getDanmakuSender", "sendDanmaku", "context", "Landroid/content/Context;", "params", "Ltv/danmaku/biliplayerv2/service/interact/core/sender/DanmakuSendParams;", "sendDanmakuV2", "sendCommandDanmaku", "type", "", "content", "", "", "registerDanmakuVisibleObserver", "observer", "Ltv/danmaku/biliplayerv2/service/interact/core/DanmakuVisibleObserver;", "unregisterDanmakuVisibleObserver", "getInteractContainer", "Ltv/danmaku/biliplayerv2/service/interact/core/container/IInteractContainer;", "setInteractContainer", "container", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IInteractCoreService {
    IDanmakuSender getDanmakuSender();

    IInteractContainer getInteractContainer();

    void hideDanmaku(boolean z);

    boolean isDanmakuEnable();

    boolean isDanmakuVisible();

    void registerDanmakuVisibleObserver(DanmakuVisibleObserver danmakuVisibleObserver);

    boolean sendCommandDanmaku(Context context, int i, Map<String, ? extends Object> map);

    boolean sendDanmaku(Context context, DanmakuSendParams danmakuSendParams);

    boolean sendDanmakuV2(Context context, DanmakuSendParams danmakuSendParams);

    void setDanmakuEnable(boolean z);

    void setDanmakuSender(IDanmakuSender iDanmakuSender);

    void setDanmakuVisible(boolean z, boolean z2);

    void setInteractContainer(IInteractContainer iInteractContainer);

    void showDanmaku(boolean z);

    void unregisterDanmakuVisibleObserver(DanmakuVisibleObserver danmakuVisibleObserver);

    /* compiled from: IInteractCoreService.kt */
    /* renamed from: tv.danmaku.biliplayerv2.service.interact.core.IInteractCoreService$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void showDanmaku$default(IInteractCoreService iInteractCoreService, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showDanmaku");
            }
            if ((i & 1) != 0) {
                z = true;
            }
            iInteractCoreService.showDanmaku(z);
        }

        public static /* synthetic */ void hideDanmaku$default(IInteractCoreService iInteractCoreService, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hideDanmaku");
            }
            if ((i & 1) != 0) {
                z = true;
            }
            iInteractCoreService.hideDanmaku(z);
        }

        public static /* synthetic */ void setDanmakuVisible$default(IInteractCoreService iInteractCoreService, boolean z, boolean z2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setDanmakuVisible");
            }
            if ((i & 2) != 0) {
                z2 = false;
            }
            iInteractCoreService.setDanmakuVisible(z, z2);
        }

        public static boolean $default$sendDanmaku(IInteractCoreService _this, Context context, DanmakuSendParams params) {
            Intrinsics.checkNotNullParameter(params, "params");
            return false;
        }

        public static boolean $default$sendDanmakuV2(IInteractCoreService _this, Context context, DanmakuSendParams params) {
            Intrinsics.checkNotNullParameter(params, "params");
            return false;
        }

        public static boolean $default$sendCommandDanmaku(IInteractCoreService _this, Context context, int type, Map map) {
            Map content = EnhancedUnmodifiabilityKt.unmodifiable(map);
            Intrinsics.checkNotNullParameter(content, "content");
            return false;
        }
    }
}