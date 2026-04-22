package tv.danmaku.biliplayerv2.service.interact.core.model;

import com.bapis.bilibili.community.service.dm.v1.DmViewReply;
import com.bapis.bilibili.community.service.dm.v1.VideoSubtitle;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.kvo.PlayerKVOService;
import tv.danmaku.biliplayerv2.service.setting.DanmakuKeys;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: DanmakuParams.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010]\u001a\u00020^J\u0006\u0010_\u001a\u00020 J\u0006\u0010`\u001a\u00020^J\u001a\u0010a\u001a\u000e\u0012\u0004\u0012\u00020S\u0012\u0004\u0012\u00020\u00010b2\u0006\u0010c\u001a\u00020\u001aR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\u001a\u0010\u0011\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR\u001a\u0010\u0017\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\u001a\u0010(\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R\u001a\u0010+\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\"\"\u0004\b-\u0010$R\u001a\u0010.\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\"\"\u0004\b0\u0010$R\u001a\u00101\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001c\"\u0004\b3\u0010\u001eR\u001a\u00104\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001c\"\u0004\b6\u0010\u001eR\u001a\u00107\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\"\"\u0004\b9\u0010$R\u001a\u0010:\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001c\"\u0004\b<\u0010\u001eR\u001a\u0010=\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u0010\bR\u001a\u0010@\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0006\"\u0004\bB\u0010\bR\u001a\u0010C\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0006\"\u0004\bE\u0010\bR\u001a\u0010F\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0006\"\u0004\bH\u0010\bR\u001a\u0010I\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0006\"\u0004\bJ\u0010\bR\u001c\u0010K\u001a\u0004\u0018\u00010LX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR \u0010Q\u001a\b\u0012\u0004\u0012\u00020S0RX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u0011\u0010X\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bX\u0010\u0006R\u0013\u0010Y\u001a\u0004\u0018\u00010Z8F¢\u0006\u0006\u001a\u0004\b[\u0010\\¨\u0006d"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/core/model/DanmakuParams;", "", "<init>", "()V", "isDanmakuBlockTop", "", "()Z", "setDanmakuBlockTop", "(Z)V", "isDanmakuBlockScroll", "setDanmakuBlockScroll", "isDanmakuBlockBottom", "setDanmakuBlockBottom", "isDanmakuBlockSpecial", "setDanmakuBlockSpecial", "isDanmakuRecommandEnable", "setDanmakuRecommandEnable", "isDanmakuBlockColorful", "setDanmakuBlockColorful", "isDanmakuDuplicateMerging", "setDanmakuDuplicateMerging", "isDanmakuMonospaced", "setDanmakuMonospaced", "isDanmakuTextStyleBold", "setDanmakuTextStyleBold", "danmakuTextStyle", "", "getDanmakuTextStyle", "()I", "setDanmakuTextStyle", "(I)V", "danmakuTextSizeScaleFactor", "", "getDanmakuTextSizeScaleFactor", "()F", "setDanmakuTextSizeScaleFactor", "(F)V", "danmakuStorkeWidthScaling", "getDanmakuStorkeWidthScaling", "setDanmakuStorkeWidthScaling", "danmakuDuration", "getDanmakuDuration", "setDanmakuDuration", "danmakuAlphaFactor", "getDanmakuAlphaFactor", "setDanmakuAlphaFactor", "danmakuScreenDomain", "getDanmakuScreenDomain", "setDanmakuScreenDomain", "danmakuBlockLevel", "getDanmakuBlockLevel", "setDanmakuBlockLevel", "danmakuBlockLevelV2", "getDanmakuBlockLevelV2", "setDanmakuBlockLevelV2", "danmakuDisplayDomain", "getDanmakuDisplayDomain", "setDanmakuDisplayDomain", "danmakuDensity", "getDanmakuDensity", "setDanmakuDensity", "danmakuBlockFixed", "getDanmakuBlockFixed", "setDanmakuBlockFixed", "enableDanmakuFold", "getEnableDanmakuFold", "setEnableDanmakuFold", "danmakuAvoidFigure", "getDanmakuAvoidFigure", "setDanmakuAvoidFigure", "danmakuAvoidScript", "getDanmakuAvoidScript", "setDanmakuAvoidScript", "isDanmakuBlackWordsEnable", "setDanmakuBlackWordsEnable", "dmViewReply", "Lcom/bapis/bilibili/community/service/dm/v1/DmViewReply;", "getDmViewReply", "()Lcom/bapis/bilibili/community/service/dm/v1/DmViewReply;", "setDmViewReply", "(Lcom/bapis/bilibili/community/service/dm/v1/DmViewReply;)V", "blockUserIds", "", "", "getBlockUserIds", "()Ljava/util/Set;", "setBlockUserIds", "(Ljava/util/Set;)V", "isDanmakuClosed", "danmakuSubtitleInfo", "Lcom/bapis/bilibili/community/service/dm/v1/VideoSubtitle;", "getDanmakuSubtitleInfo", "()Lcom/bapis/bilibili/community/service/dm/v1/VideoSubtitle;", "clear", "", "displayDomainReportValue", "reset", "getKVOParamsMap", "", "seniorModeSwitch", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DanmakuParams {
    private boolean danmakuAvoidScript;
    private boolean danmakuBlockFixed;
    private int danmakuDensity;
    private float danmakuScreenDomain;
    private DmViewReply dmViewReply;
    private boolean isDanmakuBlockBottom;
    private boolean isDanmakuBlockColorful;
    private boolean isDanmakuBlockScroll;
    private boolean isDanmakuBlockSpecial;
    private boolean isDanmakuBlockTop;
    private boolean isDanmakuDuplicateMerging;
    private boolean isDanmakuTextStyleBold;
    private boolean isDanmakuRecommandEnable = true;
    private boolean isDanmakuMonospaced = true;
    private int danmakuTextStyle = -1;
    private float danmakuTextSizeScaleFactor = 1.0f;
    private float danmakuStorkeWidthScaling = 0.8f;
    private float danmakuDuration = 8.0f;
    private float danmakuAlphaFactor = 1.0f;
    private int danmakuBlockLevel = -1;
    private int danmakuBlockLevelV2 = -1;
    private float danmakuDisplayDomain = 0.25f;
    private boolean enableDanmakuFold = true;
    private boolean danmakuAvoidFigure = true;
    private boolean isDanmakuBlackWordsEnable = true;
    private Set<String> blockUserIds = new LinkedHashSet();

    public final boolean isDanmakuBlockTop() {
        return this.isDanmakuBlockTop;
    }

    public final void setDanmakuBlockTop(boolean z) {
        this.isDanmakuBlockTop = z;
    }

    public final boolean isDanmakuBlockScroll() {
        return this.isDanmakuBlockScroll;
    }

    public final void setDanmakuBlockScroll(boolean z) {
        this.isDanmakuBlockScroll = z;
    }

    public final boolean isDanmakuBlockBottom() {
        return this.isDanmakuBlockBottom;
    }

    public final void setDanmakuBlockBottom(boolean z) {
        this.isDanmakuBlockBottom = z;
    }

    public final boolean isDanmakuBlockSpecial() {
        return this.isDanmakuBlockSpecial;
    }

    public final void setDanmakuBlockSpecial(boolean z) {
        this.isDanmakuBlockSpecial = z;
    }

    public final boolean isDanmakuRecommandEnable() {
        return this.isDanmakuRecommandEnable;
    }

    public final void setDanmakuRecommandEnable(boolean z) {
        this.isDanmakuRecommandEnable = z;
    }

    public final boolean isDanmakuBlockColorful() {
        return this.isDanmakuBlockColorful;
    }

    public final void setDanmakuBlockColorful(boolean z) {
        this.isDanmakuBlockColorful = z;
    }

    public final boolean isDanmakuDuplicateMerging() {
        return this.isDanmakuDuplicateMerging;
    }

    public final void setDanmakuDuplicateMerging(boolean z) {
        this.isDanmakuDuplicateMerging = z;
    }

    public final boolean isDanmakuMonospaced() {
        return this.isDanmakuMonospaced;
    }

    public final void setDanmakuMonospaced(boolean z) {
        this.isDanmakuMonospaced = z;
    }

    public final boolean isDanmakuTextStyleBold() {
        return this.isDanmakuTextStyleBold;
    }

    public final void setDanmakuTextStyleBold(boolean z) {
        this.isDanmakuTextStyleBold = z;
    }

    public final int getDanmakuTextStyle() {
        return this.danmakuTextStyle;
    }

    public final void setDanmakuTextStyle(int i) {
        this.danmakuTextStyle = i;
    }

    public final float getDanmakuTextSizeScaleFactor() {
        return this.danmakuTextSizeScaleFactor;
    }

    public final void setDanmakuTextSizeScaleFactor(float f) {
        this.danmakuTextSizeScaleFactor = f;
    }

    public final float getDanmakuStorkeWidthScaling() {
        return this.danmakuStorkeWidthScaling;
    }

    public final void setDanmakuStorkeWidthScaling(float f) {
        this.danmakuStorkeWidthScaling = f;
    }

    public final float getDanmakuDuration() {
        return this.danmakuDuration;
    }

    public final void setDanmakuDuration(float f) {
        this.danmakuDuration = f;
    }

    public final float getDanmakuAlphaFactor() {
        return this.danmakuAlphaFactor;
    }

    public final void setDanmakuAlphaFactor(float f) {
        this.danmakuAlphaFactor = f;
    }

    public final float getDanmakuScreenDomain() {
        return this.danmakuScreenDomain;
    }

    public final void setDanmakuScreenDomain(float f) {
        this.danmakuScreenDomain = f;
    }

    public final int getDanmakuBlockLevel() {
        return this.danmakuBlockLevel;
    }

    public final void setDanmakuBlockLevel(int i) {
        this.danmakuBlockLevel = i;
    }

    public final int getDanmakuBlockLevelV2() {
        return this.danmakuBlockLevelV2;
    }

    public final void setDanmakuBlockLevelV2(int i) {
        this.danmakuBlockLevelV2 = i;
    }

    public final float getDanmakuDisplayDomain() {
        return this.danmakuDisplayDomain;
    }

    public final void setDanmakuDisplayDomain(float f) {
        this.danmakuDisplayDomain = f;
    }

    public final int getDanmakuDensity() {
        return this.danmakuDensity;
    }

    public final void setDanmakuDensity(int i) {
        this.danmakuDensity = i;
    }

    public final boolean getDanmakuBlockFixed() {
        return this.danmakuBlockFixed;
    }

    public final void setDanmakuBlockFixed(boolean z) {
        this.danmakuBlockFixed = z;
    }

    public final boolean getEnableDanmakuFold() {
        return this.enableDanmakuFold;
    }

    public final void setEnableDanmakuFold(boolean z) {
        this.enableDanmakuFold = z;
    }

    public final boolean getDanmakuAvoidFigure() {
        return this.danmakuAvoidFigure;
    }

    public final void setDanmakuAvoidFigure(boolean z) {
        this.danmakuAvoidFigure = z;
    }

    public final boolean getDanmakuAvoidScript() {
        return this.danmakuAvoidScript;
    }

    public final void setDanmakuAvoidScript(boolean z) {
        this.danmakuAvoidScript = z;
    }

    public final boolean isDanmakuBlackWordsEnable() {
        return this.isDanmakuBlackWordsEnable;
    }

    public final void setDanmakuBlackWordsEnable(boolean z) {
        this.isDanmakuBlackWordsEnable = z;
    }

    public final DmViewReply getDmViewReply() {
        return this.dmViewReply;
    }

    public final void setDmViewReply(DmViewReply dmViewReply) {
        this.dmViewReply = dmViewReply;
    }

    public final Set<String> getBlockUserIds() {
        return this.blockUserIds;
    }

    public final void setBlockUserIds(Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.blockUserIds = set;
    }

    public final boolean isDanmakuClosed() {
        if (this.dmViewReply != null) {
            DmViewReply dmViewReply = this.dmViewReply;
            Intrinsics.checkNotNull(dmViewReply);
            if (dmViewReply.getClosed()) {
                return true;
            }
        }
        return false;
    }

    public final VideoSubtitle getDanmakuSubtitleInfo() {
        if (this.dmViewReply != null) {
            DmViewReply dmViewReply = this.dmViewReply;
            Intrinsics.checkNotNull(dmViewReply);
            return dmViewReply.getSubtitle();
        }
        return null;
    }

    public final void clear() {
        this.dmViewReply = null;
    }

    public final float displayDomainReportValue() {
        if (this.danmakuDisplayDomain < 1.0f) {
            return this.danmakuDisplayDomain;
        }
        return this.danmakuDensity;
    }

    public final void reset() {
        this.danmakuDisplayDomain = 0.25f;
        this.danmakuAlphaFactor = 0.8f;
        this.danmakuTextSizeScaleFactor = 1.0f;
        this.danmakuDuration = 7.0f;
        this.danmakuDensity = 1;
        this.danmakuBlockFixed = false;
        this.isDanmakuBlockColorful = false;
        this.isDanmakuBlockSpecial = false;
        this.isDanmakuBlockScroll = false;
        this.enableDanmakuFold = true;
        this.isDanmakuDuplicateMerging = false;
        this.danmakuAvoidFigure = true;
        this.danmakuAvoidScript = false;
    }

    public final Map<String, Object> getKVOParamsMap(int seniorModeSwitch) {
        return EnhancedUnmodifiabilityKt.unmodifiable(MapsKt.mapOf(new Pair[]{TuplesKt.to(DanmakuKeys.PREF_DANMAKU_DISPLAY_DOMAIN, Integer.valueOf((int) (this.danmakuDisplayDomain * 100))), TuplesKt.to(DanmakuKeys.PREF_DANMAKU_OPACITY, Float.valueOf(this.danmakuAlphaFactor)), TuplesKt.to(DanmakuKeys.PREF_DANMAKU_SCALING_FACTOR, Float.valueOf(this.danmakuTextSizeScaleFactor)), TuplesKt.to(DanmakuKeys.PREF_DANMAKU_SPEED, Integer.valueOf(PlayerKVOService.INSTANCE.translateLocalSpeedToKVO(this.danmakuDuration))), TuplesKt.to(DanmakuKeys.PREF_DANMAKU_DENSITY, Integer.valueOf(this.danmakuDensity)), TuplesKt.to(DanmakuKeys.PREF_DANMAKU_BLOCKFIXED, Boolean.valueOf(this.danmakuBlockFixed)), TuplesKt.to(DanmakuKeys.PREF_DANMAKU_BLOCKSCROLL, Boolean.valueOf(this.isDanmakuBlockScroll)), TuplesKt.to(DanmakuKeys.PREF_DANMAKU_BLOCKCOLORFUL, Boolean.valueOf(this.isDanmakuBlockColorful)), TuplesKt.to(DanmakuKeys.PREF_DANMAKU_BLOCKSPECIAL, Boolean.valueOf(this.isDanmakuBlockSpecial)), TuplesKt.to(DanmakuKeys.PREF_DANMAKU_FOLD, Boolean.valueOf(this.enableDanmakuFold)), TuplesKt.to(DanmakuKeys.PREF_DANMAKU_BLOCKREPEAT, Boolean.valueOf(this.isDanmakuDuplicateMerging)), TuplesKt.to(DanmakuKeys.PREF_DANMAKU_AVOID_FIGURE, Boolean.valueOf(this.danmakuAvoidFigure)), TuplesKt.to(DanmakuKeys.PREF_DANMAKU_AVOID_SCRIPT, Boolean.valueOf(this.danmakuAvoidScript)), TuplesKt.to(DanmakuKeys.PREF_DANMAKU_SENIOR_MODE_SWITCH, Integer.valueOf(seniorModeSwitch))}));
    }
}