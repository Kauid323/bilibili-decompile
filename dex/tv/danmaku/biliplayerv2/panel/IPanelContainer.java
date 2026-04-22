package tv.danmaku.biliplayerv2.panel;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.ControlContainerConfig;
import tv.danmaku.biliplayerv2.ControlContainerType;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.service.IWithViewPlayerService;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IPanelContainer.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000 72\u00020\u0001:\u00017J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u001a\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J\b\u0010\u0016\u001a\u00020\u0013H&J\b\u0010\u0017\u001a\u00020\u0018H&J\b\u0010\u0019\u001a\u00020\u0018H&J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001cH&J \u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u001cH&J@\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010#2\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010%2\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010%2\b\b\u0002\u0010(\u001a\u00020\u001eH&J\u0010\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020+H&J\u0010\u0010,\u001a\u00020\u00032\u0006\u0010*\u001a\u00020+H&J\u0012\u0010-\u001a\u00020\u001e2\b\u0010.\u001a\u0004\u0018\u00010/H&J\u001c\u00100\u001a\u00020\u00032\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u0003012\u0006\u00102\u001a\u00020\fH&J \u00100\u001a\u00020\u00032\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u0003012\n\u00102\u001a\u0006\u0012\u0002\b\u000301H&J\u0014\u00103\u001a\u00020\u00032\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u000301H&J\u0018\u00104\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00105\u001a\u00020\u001eH&J\u0014\u00106\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00068À\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/panel/IPanelContainer;", "Ltv/danmaku/biliplayerv2/panel/IVideoInsetChangedObserver;", "init", "", "playerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "controlContainerConfig", "", "Ltv/danmaku/biliplayerv2/ControlContainerType;", "Ltv/danmaku/biliplayerv2/ControlContainerConfig;", "ensureBuiltInLayer", "layer", "Ltv/danmaku/biliplayerv2/panel/BuiltInLayer;", "service", "Ltv/danmaku/biliplayerv2/service/IWithViewPlayerService;", "addBuiltInLayer", "removeBuiltInLayer", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "getView", "getWidth", "", "getHeight", "location", "point", "", "locationByAncestor", "", "ancestor", "Landroid/view/ViewGroup;", "updateViewPort", "viewPort", "Landroid/graphics/Rect;", "builtInLayers", "", "customerLayers", "", "immediately", "addOnKeyListener", "listener", "Landroid/view/View$OnKeyListener;", "removeOnKeyListener", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "addLayer", "Ltv/danmaku/biliplayerv2/panel/IPlayerLayer;", "over", "removeLayer", "setBuiltInLayerVisibility", "visibility", "getControlContainerConfig", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IPanelContainer extends IVideoInsetChangedObserver {
    public static final Companion Companion = Companion.$$INSTANCE;

    void addBuiltInLayer(BuiltInLayer builtInLayer, IWithViewPlayerService iWithViewPlayerService);

    void addLayer(IPlayerLayer<?> iPlayerLayer, BuiltInLayer builtInLayer);

    void addLayer(IPlayerLayer<?> iPlayerLayer, IPlayerLayer<?> iPlayerLayer2);

    void addOnKeyListener(View.OnKeyListener onKeyListener);

    boolean dispatchKeyEvent(KeyEvent keyEvent);

    void ensureBuiltInLayer(BuiltInLayer builtInLayer, IWithViewPlayerService iWithViewPlayerService);

    Map<ControlContainerType, ControlContainerConfig> getControlContainerConfig();

    int getHeight();

    View getView();

    int getWidth();

    void init(PlayerContainer playerContainer, Map<ControlContainerType, ControlContainerConfig> map);

    void location(View view2, int[] iArr);

    boolean locationByAncestor(View view2, ViewGroup viewGroup, int[] iArr);

    void onViewCreated(View view2, Bundle bundle);

    void removeBuiltInLayer(BuiltInLayer builtInLayer);

    void removeLayer(IPlayerLayer<?> iPlayerLayer);

    void removeOnKeyListener(View.OnKeyListener onKeyListener);

    void setBuiltInLayerVisibility(BuiltInLayer builtInLayer, boolean z);

    void updateViewPort(Rect rect, List<? extends BuiltInLayer> list, List<String> list2, boolean z);

    /* compiled from: IPanelContainer.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/biliplayerv2/panel/IPanelContainer$Companion;", "", "<init>", "()V", "RESET_VIEW_PORT", "Landroid/graphics/Rect;", "getRESET_VIEW_PORT", "()Landroid/graphics/Rect;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Rect RESET_VIEW_PORT = new Rect();

        private Companion() {
        }

        public final Rect getRESET_VIEW_PORT() {
            return RESET_VIEW_PORT;
        }
    }

    /* compiled from: IPanelContainer.kt */
    /* renamed from: tv.danmaku.biliplayerv2.panel.IPanelContainer$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        static {
            Companion companion = IPanelContainer.Companion;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void updateViewPort$default(IPanelContainer iPanelContainer, Rect rect, List list, List list2, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateViewPort");
            }
            if ((i & 2) != 0) {
                list = null;
            }
            if ((i & 4) != 0) {
                list2 = null;
            }
            if ((i & 8) != 0) {
                z = false;
            }
            iPanelContainer.updateViewPort(rect, list, list2, z);
        }
    }
}