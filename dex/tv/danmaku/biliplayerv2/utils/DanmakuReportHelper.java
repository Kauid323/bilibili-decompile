package tv.danmaku.biliplayerv2.utils;

import com.bapis.bilibili.community.service.dm.v1.DmViewReply;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuParams;
import tv.danmaku.biliplayerv2.service.report.EventId;
import tv.danmaku.biliplayerv2.service.report.IReporterService;
import tv.danmaku.biliplayerv2.service.report.NeuronsEvents;
import tv.danmaku.biliplayerv2.service.setting.DanmakuKeys;
import tv.danmaku.biliplayerv2.service.setting.IPlayerSettingService;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: DanmakuReportHelper.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0002J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0005JH\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Ltv/danmaku/biliplayerv2/utils/DanmakuReportHelper;", "", "<init>", "()V", "REPORT_TIMING_VIDEO_START", "", "REPORT_TIMING_VIDEO_COMPLETE", "REPORT_TIMING_VIDEO_CLOSE_DANMAKU_SETTING", "getSpeedForReport", "value", "", "reportAllDanmakuSetting", "", "playerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "danmakuParams", "Ltv/danmaku/biliplayerv2/service/interact/core/model/DanmakuParams;", "reportTiming", "getAllDanmakuSettingReportEvent", "Ltv/danmaku/biliplayerv2/service/report/NeuronsEvents$Event;", "isDanmakuVisible", "", "dmSwitch", "enableMask", "enableBlock", "stroke", "hitNewDanmakuSettings", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DanmakuReportHelper {
    public static final DanmakuReportHelper INSTANCE = new DanmakuReportHelper();
    public static final int REPORT_TIMING_VIDEO_CLOSE_DANMAKU_SETTING = 3;
    public static final int REPORT_TIMING_VIDEO_COMPLETE = 2;
    public static final int REPORT_TIMING_VIDEO_START = 1;

    private DanmakuReportHelper() {
    }

    private final int getSpeedForReport(float value) {
        if (value >= 1.6f) {
            return 1;
        }
        if (value >= 1.3f && value < 1.6f) {
            return 2;
        }
        if (value >= 0.9f && value < 1.3f) {
            return 3;
        }
        if (value >= 0.65f && value < 0.9f) {
            return 4;
        }
        return 5;
    }

    public final void reportAllDanmakuSetting(PlayerContainer playerContainer, DanmakuParams danmakuParams, int reportTiming) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        if (danmakuParams == null) {
            return;
        }
        IReporterService reporter = playerContainer.getReporterService();
        IPlayerSettingService setting = playerContainer.getPlayerSettingService();
        IInteractLayerService danmakuService = playerContainer.getInteractLayerService();
        NeuronsEvents.Event event = getAllDanmakuSettingReportEvent$default(this, danmakuParams, reportTiming, playerContainer.getInteractLayerService().isDanmakuVisible(), danmakuService.getDanmakuSwitchParams().getDanmakuSwitch(), setting.getBoolean(DanmakuKeys.KEY_DANMAKU_MASK_SWITCH, true), setting.getBoolean(DanmakuKeys.PREF_DANMAKU_ENABLEBLOCKLIST, true), setting.getInt(DanmakuKeys.KEY_DANMAKU_TEXT_STYLE, -1), false, 128, null);
        reporter.report(event);
    }

    public static /* synthetic */ NeuronsEvents.Event getAllDanmakuSettingReportEvent$default(DanmakuReportHelper danmakuReportHelper, DanmakuParams danmakuParams, int i, boolean z, boolean z2, boolean z3, boolean z4, int i2, boolean z5, int i3, Object obj) {
        boolean z6;
        if ((i3 & 128) == 0) {
            z6 = z5;
        } else {
            z6 = false;
        }
        return danmakuReportHelper.getAllDanmakuSettingReportEvent(danmakuParams, i, z, z2, z3, z4, i2, z6);
    }

    public final NeuronsEvents.Event getAllDanmakuSettingReportEvent(DanmakuParams danmakuParams, int reportTiming, boolean isDanmakuVisible, boolean dmSwitch, boolean enableMask, boolean enableBlock, int stroke, boolean hitNewDanmakuSettings) {
        int isClosed;
        int mask;
        int blockSubtitle;
        float area;
        int fswitch;
        int bold;
        int mono;
        Intrinsics.checkNotNullParameter(danmakuParams, "danmakuParams");
        JSONObject pjson = new JSONObject();
        if (isDanmakuVisible) {
            isClosed = 1;
        } else {
            isClosed = 2;
        }
        DmViewReply dmViewReply = danmakuParams.getDmViewReply();
        boolean dmMaskExist = dmViewReply != null ? dmViewReply.hasMask() : false;
        if (dmMaskExist) {
            mask = enableMask ? 1 : 2;
        } else {
            mask = 0;
        }
        pjson.put("dm_switch", isClosed);
        pjson.put("ai_filter", danmakuParams.isDanmakuRecommandEnable() ? danmakuParams.getDanmakuBlockLevelV2() : 0);
        pjson.put("dm_mask", mask);
        if (danmakuParams.getDanmakuSubtitleInfo() != null) {
            blockSubtitle = 1;
        } else {
            blockSubtitle = 2;
        }
        StringBuilder typeBlockSb = new StringBuilder();
        if (danmakuParams.isDanmakuDuplicateMerging()) {
            typeBlockSb.append(1);
        }
        if (danmakuParams.isDanmakuBlockTop()) {
            typeBlockSb.append(",").append(2);
        }
        if (danmakuParams.isDanmakuBlockScroll()) {
            typeBlockSb.append(",").append(3);
        }
        if (danmakuParams.isDanmakuBlockBottom()) {
            typeBlockSb.append(",").append(4);
        }
        if (danmakuParams.isDanmakuBlockColorful()) {
            typeBlockSb.append(",").append(5);
        }
        if (danmakuParams.isDanmakuBlockSpecial()) {
            typeBlockSb.append(",").append(6);
        }
        if (danmakuParams.getDanmakuBlockFixed()) {
            typeBlockSb.append(",").append(7);
        }
        if (!danmakuParams.getEnableDanmakuFold()) {
            typeBlockSb.append(",").append(8);
        }
        pjson.put("anti_block_subtitle", blockSubtitle);
        pjson.put("type_block", typeBlockSb.toString());
        pjson.put("alpha", Float.valueOf(danmakuParams.getDanmakuAlphaFactor()));
        pjson.put("size", Float.valueOf(danmakuParams.getDanmakuTextSizeScaleFactor()));
        if (hitNewDanmakuSettings) {
            area = danmakuParams.displayDomainReportValue();
        } else {
            area = danmakuParams.getDanmakuScreenDomain();
        }
        pjson.put("area", Float.valueOf(area));
        pjson.put("speed", getSpeedForReport(danmakuParams.getDanmakuDuration()));
        if (!enableBlock) {
            fswitch = 2;
        } else {
            fswitch = 1;
        }
        pjson.put("filter_switch", fswitch);
        if (danmakuParams.isDanmakuTextStyleBold()) {
            bold = 1;
        } else {
            bold = 2;
        }
        pjson.put("bold", bold);
        if (danmakuParams.isDanmakuMonospaced()) {
            mono = 1;
        } else {
            mono = 2;
        }
        pjson.put("mono", mono);
        pjson.put("danmaku_stroke", stroke + 2);
        pjson.put("dm_switch_default", dmSwitch ? 2 : 1);
        String jSONObject = pjson.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
        return new NeuronsEvents.NormalEvent(EventId.player_neuron_danmaku_set_all, "setting", jSONObject, LoginSceneProcessor.SCENE_KEY, String.valueOf(reportTiming));
    }
}