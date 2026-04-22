package kntr.common.share.common.ui;

import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kntr.common.share.common.GShare;
import kntr.common.share.common.GSharePanel;
import kntr.common.share.common.SharePanelHandler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: SharePanelScope.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"showPanel", "", "Lkntr/common/share/common/ui/SharePanelScope;", "common-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SharePanelScopeKt {
    public static final void showPanel(SharePanelScope $this$showPanel) {
        Intrinsics.checkNotNullParameter($this$showPanel, "<this>");
        SharePanelHandler mHandler = new SharePanelHandler();
        Function1 it = $this$showPanel.getHandler();
        if (it != null) {
            it.invoke(mHandler);
        }
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        GShare gShare = ((GShareEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(GShareEntryPoint.class))).gShare();
        GSharePanel panel = gShare.createPanel($this$showPanel.getCtx(), $this$showPanel.getParams(), $this$showPanel.getStyle(), mHandler);
        panel.show();
    }
}