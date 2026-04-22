package tv.danmaku.biliplayerv2.service.interact.helper;

import com.bapis.bilibili.community.service.dm.v1.DanmuPlayerConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: InteractExtension.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"contentString", "", "Lcom/bapis/bilibili/community/service/dm/v1/DanmuPlayerConfig;", "biliplayerv2_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class InteractExtensionKt {
    public static final String contentString(DanmuPlayerConfig $this$contentString) {
        Intrinsics.checkNotNullParameter($this$contentString, "<this>");
        boolean playerDanmakuSwitchSave = $this$contentString.getPlayerDanmakuSwitchSave();
        boolean playerDanmakuSwitch = $this$contentString.getPlayerDanmakuSwitch();
        boolean inlinePlayerDanmakuSwitch = $this$contentString.getInlinePlayerDanmakuSwitch();
        boolean playerDanmakuAiRecommendedSwitch = $this$contentString.getPlayerDanmakuAiRecommendedSwitch();
        int playerDanmakuAiRecommendedLevelV2 = $this$contentString.getPlayerDanmakuAiRecommendedLevelV2();
        boolean playerDanmakuBlockrepeat = $this$contentString.getPlayerDanmakuBlockrepeat();
        boolean playerDanmakuBlocktop = $this$contentString.getPlayerDanmakuBlocktop();
        boolean playerDanmakuBlockscroll = $this$contentString.getPlayerDanmakuBlockscroll();
        boolean playerDanmakuBlockbottom = $this$contentString.getPlayerDanmakuBlockbottom();
        boolean playerDanmakuBlockcolorful = $this$contentString.getPlayerDanmakuBlockcolorful();
        boolean playerDanmakuBlockspecial = $this$contentString.getPlayerDanmakuBlockspecial();
        float playerDanmakuOpacity = $this$contentString.getPlayerDanmakuOpacity();
        float playerDanmakuScalingfactor = $this$contentString.getPlayerDanmakuScalingfactor();
        float playerDanmakuDomain = $this$contentString.getPlayerDanmakuDomain();
        int playerDanmakuSpeed = $this$contentString.getPlayerDanmakuSpeed();
        return "danmaku_switch_save=" + playerDanmakuSwitchSave + ", danmaku_switch=" + playerDanmakuSwitch + ", inline_danmaku_switch=" + inlinePlayerDanmakuSwitch + ", ai_recommend_switch=" + playerDanmakuAiRecommendedSwitch + ", ai_recommend_level=" + playerDanmakuAiRecommendedLevelV2 + ", block_repeat=" + playerDanmakuBlockrepeat + ", block_top=" + playerDanmakuBlocktop + ", block_scroll=" + playerDanmakuBlockscroll + ", block_bottom=" + playerDanmakuBlockbottom + ", block_colorful=" + playerDanmakuBlockcolorful + ", block_special=" + playerDanmakuBlockspecial + ", opacity=" + playerDanmakuOpacity + ", scale_factor=" + playerDanmakuScalingfactor + ", domain=" + playerDanmakuDomain + ", speed=" + playerDanmakuSpeed + ", enable_block_list=" + $this$contentString.getPlayerDanmakuEnableblocklist();
    }
}