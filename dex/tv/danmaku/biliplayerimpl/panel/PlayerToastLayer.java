package tv.danmaku.biliplayerimpl.panel;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.panel.BuiltInLayer;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PlayerToastLayer.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerimpl/panel/PlayerToastLayer;", "Ltv/danmaku/biliplayerimpl/panel/AbsBuiltInPlayerLayer;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerToastLayer extends AbsBuiltInPlayerLayer {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayerToastLayer(View view2) {
        super(view2, BuiltInLayer.LayerToast.getIndex());
        Intrinsics.checkNotNullParameter(view2, "view");
    }
}