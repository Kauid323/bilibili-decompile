package tv.danmaku.biliplayerimpl.panel;

import android.graphics.Rect;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.panel.BuiltInLayer;
import tv.danmaku.biliplayerv2.service.IRenderContainerService;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PlayerRenderLayer.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ltv/danmaku/biliplayerimpl/panel/PlayerRenderLayer;", "Ltv/danmaku/biliplayerimpl/panel/AbsBuiltInPlayerLayer;", "view", "Landroid/view/View;", "mService", "Ltv/danmaku/biliplayerv2/service/IRenderContainerService;", "<init>", "(Landroid/view/View;Ltv/danmaku/biliplayerv2/service/IRenderContainerService;)V", "onViewPortUpdate", "", "viewPort", "Landroid/graphics/Rect;", "panelWidth", "", "panelHeight", "immediately", "", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerRenderLayer extends AbsBuiltInPlayerLayer {
    private final IRenderContainerService mService;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayerRenderLayer(View view2, IRenderContainerService mService) {
        super(view2, BuiltInLayer.LayerRender.getIndex());
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(mService, "mService");
        this.mService = mService;
    }

    @Override // tv.danmaku.biliplayerimpl.panel.AbsBuiltInPlayerLayer, tv.danmaku.biliplayerv2.panel.IPlayerLayer
    public void onViewPortUpdate(Rect viewPort, int panelWidth, int panelHeight, boolean immediately) {
        Intrinsics.checkNotNullParameter(viewPort, "viewPort");
        this.mService.updateViewPort(viewPort, immediately);
    }
}