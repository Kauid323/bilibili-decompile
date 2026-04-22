package tv.danmaku.biliplayerv2.service.interact.biz;

import com.bapis.bilibili.community.service.dm.v1.DanmuPlayerConfig;
import com.bapis.bilibili.community.service.dm.v1.DanmuPlayerViewConfig;
import com.bapis.bilibili.community.service.dm.v1.DmViewReply;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.setting.DanmakuKeys;
import tv.danmaku.biliplayerv2.service.setting.IPlayerSettingService;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IInteractLayerService.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\r\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/DanmakuSwitchParams;", "", "settingService", "Ltv/danmaku/biliplayerv2/service/setting/IPlayerSettingService;", "<init>", "(Ltv/danmaku/biliplayerv2/service/setting/IPlayerSettingService;)V", "value", "", "inlineDanmakuSwitch", "getInlineDanmakuSwitch", "()Z", "setInlineDanmakuSwitch$biliplayerv2_debug", "(Z)V", "danmakuSwitch", "getDanmakuSwitch", "remoteDanmakuSwitch", "getRemoteDanmakuSwitch", "()Ljava/lang/Boolean;", "setRemoteDanmakuSwitch", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "setDmviewReply", "", "dmViewReply", "Lcom/bapis/bilibili/community/service/dm/v1/DmViewReply;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DanmakuSwitchParams {
    private boolean danmakuSwitch;
    private boolean inlineDanmakuSwitch;
    private Boolean remoteDanmakuSwitch;
    private final IPlayerSettingService settingService;

    public DanmakuSwitchParams(IPlayerSettingService settingService) {
        Intrinsics.checkNotNullParameter(settingService, "settingService");
        this.settingService = settingService;
        this.inlineDanmakuSwitch = true;
    }

    public final boolean getInlineDanmakuSwitch() {
        return this.inlineDanmakuSwitch;
    }

    public final void setInlineDanmakuSwitch$biliplayerv2_debug(boolean z) {
        this.inlineDanmakuSwitch = z;
    }

    public final boolean getDanmakuSwitch() {
        return this.settingService.getBoolean(DanmakuKeys.PREF_DANMAKU_SWITCH_SAVE, true);
    }

    public final Boolean getRemoteDanmakuSwitch() {
        return this.remoteDanmakuSwitch;
    }

    public final void setRemoteDanmakuSwitch(Boolean bool) {
        this.remoteDanmakuSwitch = bool;
    }

    public final void setDmviewReply(DmViewReply dmViewReply) {
        DanmuPlayerViewConfig config;
        DanmuPlayerConfig it;
        if (dmViewReply != null && (config = dmViewReply.getPlayerConfig()) != null && config.hasDanmukuPlayerConfig() && (it = config.getDanmukuPlayerConfig()) != null) {
            this.inlineDanmakuSwitch = it.getInlinePlayerDanmakuSwitch();
            this.remoteDanmakuSwitch = Boolean.valueOf(!it.getPlayerDanmakuSwitchSave() || it.getPlayerDanmakuSwitch());
        }
    }
}