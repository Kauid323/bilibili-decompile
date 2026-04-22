package tv.danmaku.biliplayerv2.panel;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IPlayerLayer.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \u001b*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u001bJ*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\r\u0010\u0010\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\fH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001cÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/panel/IPlayerLayer;", "V", "Landroid/view/View;", "", "onViewPortUpdate", "", "viewPort", "Landroid/graphics/Rect;", "panelWidth", "", "panelHeight", "immediately", "", "onVideoInsetChanged", "inset", "Ltv/danmaku/biliplayerv2/panel/VideoInset;", "getView", "()Landroid/view/View;", "relayout", "type", "", "attachToPlayerContainer", "playerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "detachFromPlayerContainer", "setVisibility", "visibility", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IPlayerLayer<V extends View> {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String PLAYER_CUSTOMER_LAYER_DEFAULT = "player_customer_layer_default";

    void attachToPlayerContainer(PlayerContainer playerContainer);

    void detachFromPlayerContainer(PlayerContainer playerContainer);

    V getView();

    void onVideoInsetChanged(VideoInset videoInset);

    void onViewPortUpdate(Rect rect, int i, int i2, boolean z);

    void relayout();

    void setVisibility(boolean z);

    String type();

    /* compiled from: IPlayerLayer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/biliplayerv2/panel/IPlayerLayer$Companion;", "", "<init>", "()V", "PLAYER_CUSTOMER_LAYER_DEFAULT", "", "markRelayout", "", "view", "Landroid/view/View;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String PLAYER_CUSTOMER_LAYER_DEFAULT = "player_customer_layer_default";

        private Companion() {
        }

        public final void markRelayout(View view2) {
            Intrinsics.checkNotNullParameter(view2, "view");
            if (view2 instanceof ViewGroup) {
                int childCount = ((ViewGroup) view2).getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View child = ((ViewGroup) view2).getChildAt(i);
                    Intrinsics.checkNotNull(child);
                    markRelayout(child);
                }
            }
            view2.forceLayout();
        }
    }

    /* compiled from: IPlayerLayer.kt */
    /* renamed from: tv.danmaku.biliplayerv2.panel.IPlayerLayer$-CC */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        static {
            Companion companion = IPlayerLayer.Companion;
        }

        public static /* synthetic */ void onViewPortUpdate$default(IPlayerLayer iPlayerLayer, Rect rect, int i, int i2, boolean z, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onViewPortUpdate");
            }
            if ((i3 & 8) != 0) {
                z = false;
            }
            iPlayerLayer.onViewPortUpdate(rect, i, i2, z);
        }

        public static void $default$onViewPortUpdate(IPlayerLayer _this, Rect viewPort, int panelWidth, int panelHeight, boolean immediately) {
            Intrinsics.checkNotNullParameter(viewPort, "viewPort");
            View view2 = _this.getView();
            if (Intrinsics.areEqual(viewPort, IPanelContainer.Companion.getRESET_VIEW_PORT())) {
                view2.getLayoutParams().width = -1;
                view2.getLayoutParams().height = -1;
                view2.setTranslationX(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
                view2.setTranslationY(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
                return;
            }
            boolean sizeChanged = (view2.getMeasuredWidth() == viewPort.width() && view2.getMeasuredHeight() == viewPort.height() && (view2.getLayoutParams().width < 0 || view2.getLayoutParams().width == view2.getWidth()) && (view2.getLayoutParams().height < 0 || view2.getLayoutParams().height == view2.getHeight())) ? false : true;
            if (sizeChanged) {
                view2.getLayoutParams().width = viewPort.width();
                view2.getLayoutParams().height = viewPort.height();
                _this.relayout();
            }
            _this.getView().setTranslationY(viewPort.top);
            _this.getView().setTranslationX(viewPort.left);
        }

        public static void $default$relayout(IPlayerLayer _this) {
            View layer = _this.getView();
            if (layer instanceof ViewGroup) {
                int childCount = ((ViewGroup) layer).getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View child = ((ViewGroup) layer).getChildAt(i);
                    Companion companion = IPlayerLayer.Companion;
                    Intrinsics.checkNotNull(child);
                    companion.markRelayout(child);
                }
            }
            layer.requestLayout();
        }

        public static String $default$type(IPlayerLayer _this) {
            return "player_customer_layer_default";
        }

        public static void $default$setVisibility(IPlayerLayer _this, boolean visibility) {
            if (visibility) {
                if (_this.getView().getVisibility() != 0) {
                    _this.getView().setVisibility(0);
                }
            } else if (_this.getView().getVisibility() == 0) {
                _this.getView().setVisibility(4);
            }
        }
    }
}