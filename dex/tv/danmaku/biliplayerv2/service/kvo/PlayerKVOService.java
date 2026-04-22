package tv.danmaku.biliplayerv2.service.kvo;

import com.bapis.bilibili.community.service.dm.v1.DMMoss;
import com.bapis.bilibili.community.service.dm.v1.DanmuPlayerConfig;
import com.bapis.bilibili.community.service.dm.v1.DanmuPlayerViewConfig;
import com.bapis.bilibili.community.service.dm.v1.DmPlayerConfigReq;
import com.bapis.bilibili.community.service.dm.v1.InlinePlayerDanmakuSwitch;
import com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuAiRecommendedLevel;
import com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuAiRecommendedLevelV2;
import com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuAiRecommendedSwitch;
import com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuBlockbottom;
import com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuBlockcolorful;
import com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuBlockrepeat;
import com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuBlockscroll;
import com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuBlockspecial;
import com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuBlocktop;
import com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuBlocktopBottom;
import com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuDensity;
import com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuDomain;
import com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuDomainV2;
import com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuEnableHerdDm;
import com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuEnableblocklist;
import com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuOpacity;
import com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuPeopleProof;
import com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuScalingfactor;
import com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuSeniorModeSwitch;
import com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuSpeed;
import com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuSubtitleProof;
import com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuSwitch;
import com.bapis.bilibili.community.service.dm.v1.PlayerDanmakuSwitchSave;
import com.bapis.bilibili.community.service.dm.v1.Response;
import com.bilibili.lib.moss.api.CallOptions;
import com.bilibili.lib.moss.api.MossException;
import com.bilibili.lib.moss.api.MossResponseHandler;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.BuildConfig;
import tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService;
import tv.danmaku.biliplayerv2.service.interact.core.model.MockDanmakuParams;
import tv.danmaku.biliplayerv2.service.setting.DanmakuKeys;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.log.PlayerLog;

/* compiled from: PlayerKVOService.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0001J\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0012J\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0012J\u001a\u0010\u0019\u001a\u00020\u00072\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Ltv/danmaku/biliplayerv2/service/kvo/PlayerKVOService;", "", "<init>", "()V", "TAG", "", "syncKVOToRemote", "", "key", "value", "applyKVOToLocal", "playerConfig", "Lcom/bapis/bilibili/community/service/dm/v1/DanmuPlayerViewConfig;", "danmakuService", "Ltv/danmaku/biliplayerv2/service/interact/biz/IInteractLayerService;", "isSwitchRestoredFromShared", "", "translateKVOSpeedToLocal", "", "local", "", "translateLocalSpeedToKVO", "kvo", "ensureDanmakuSpeed", "speed", "syncParamsBatched", "params", "", "DanmakuSwitchReqParams", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerKVOService {
    public static final PlayerKVOService INSTANCE = new PlayerKVOService();
    private static final String TAG = "PlayerKVOService";

    private PlayerKVOService() {
    }

    public final void syncKVOToRemote(final String key, final Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        DmPlayerConfigReq.Builder request = DmPlayerConfigReq.newBuilder();
        PlayerLog.i(TAG, "syncKVOToRemote: key=" + key + ", value=" + value);
        switch (key.hashCode()) {
            case -2083512192:
                if (key.equals(DanmakuKeys.PREF_DANMAKU_OPACITY)) {
                    request.setOpacity(PlayerDanmakuOpacity.newBuilder().setValue(((Float) value).floatValue()).build());
                    break;
                }
                break;
            case -1553197640:
                if (key.equals(DanmakuKeys.PREF_DANMAKU_DENSITY)) {
                    request.setDensity(PlayerDanmakuDensity.newBuilder().setValue(((Integer) value).intValue()).build());
                    break;
                }
                break;
            case -1482322191:
                if (key.equals(DanmakuKeys.PREF_DANMAKU_SENIOR_MODE_SWITCH)) {
                    request.setSeniorModeSwitch(PlayerDanmakuSeniorModeSwitch.newBuilder().setValue(((Integer) value).intValue()).build());
                    break;
                }
                break;
            case -1422066803:
                if (key.equals(DanmakuKeys.PREF_DANMAKU_AVOID_SCRIPT)) {
                    request.setSubtitleProof(PlayerDanmakuSubtitleProof.newBuilder().setValue(((Boolean) value).booleanValue()).build());
                    break;
                }
                break;
            case -1353438791:
                if (key.equals(DanmakuKeys.PREF_DANMAKU_AI_RECOMMEND_LEVEL_V2)) {
                    request.setAiRecommendedLevelV2(PlayerDanmakuAiRecommendedLevelV2.newBuilder().setValue(((Integer) value).intValue()).build());
                    break;
                }
                break;
            case -1290304142:
                if (key.equals(DanmakuKeys.PREF_DANMAKU_BLOCKFIXED)) {
                    request.setBlocktopBottom(PlayerDanmakuBlocktopBottom.newBuilder().setValue(((Boolean) value).booleanValue()).build());
                    break;
                }
                break;
            case -1163424947:
                if (key.equals(DanmakuKeys.PREF_DANMAKU_BLOCKBOTTOM)) {
                    request.setBlockbottom(PlayerDanmakuBlockbottom.newBuilder().setValue(((Boolean) value).booleanValue()).build());
                    break;
                }
                break;
            case -1128211356:
                if (key.equals(DanmakuKeys.PREF_DANMAKU_SWITCH)) {
                    DanmakuSwitchReqParams reqParams = value instanceof DanmakuSwitchReqParams ? (DanmakuSwitchReqParams) value : null;
                    if (reqParams != null) {
                        request.setSwitch(PlayerDanmakuSwitch.newBuilder().setValue(reqParams.getDanmakuSwitch()).setCanIgnore(reqParams.getCanIgnore()).build());
                        break;
                    } else {
                        return;
                    }
                }
                break;
            case -1110137657:
                if (key.equals(DanmakuKeys.PREF_DANMAKU_DOMAIN)) {
                    request.setDomain(PlayerDanmakuDomain.newBuilder().setValue(((Float) value).floatValue()).build());
                    break;
                }
                break;
            case -899891919:
                if (key.equals(DanmakuKeys.PREF_DANMAKU_FOLD)) {
                    request.setEnableHerdDm(PlayerDanmakuEnableHerdDm.newBuilder().setValue(((Boolean) value).booleanValue()).build());
                    break;
                }
                break;
            case -759889206:
                if (key.equals(DanmakuKeys.PREF_INLINE_DANMAKU_SWITCH)) {
                    request.setInlinePlayerDanmakuSwitch(InlinePlayerDanmakuSwitch.newBuilder().setValue(((Boolean) value).booleanValue()).build());
                    break;
                }
                break;
            case 115780394:
                if (key.equals(DanmakuKeys.PREF_DANMAKU_SPEED)) {
                    request.setSpeed(PlayerDanmakuSpeed.newBuilder().setValue(((Integer) value).intValue()).build());
                    break;
                }
                break;
            case 149368796:
                if (key.equals(DanmakuKeys.PREF_DANMAKU_BLOCKCOLORFUL)) {
                    request.setBlockcolorful(PlayerDanmakuBlockcolorful.newBuilder().setValue(((Boolean) value).booleanValue()).build());
                    break;
                }
                break;
            case 510489559:
                if (key.equals(DanmakuKeys.PREF_DANMAKU_BLOCKSPECIAL)) {
                    request.setBlockspecial(PlayerDanmakuBlockspecial.newBuilder().setValue(((Boolean) value).booleanValue()).build());
                    break;
                }
                break;
            case 525598242:
                if (key.equals(DanmakuKeys.PREF_DANMAKU_AI_RECOMMEND_LEVEL)) {
                    request.setAiRecommendedLevel(PlayerDanmakuAiRecommendedLevel.newBuilder().setValue(((Integer) value).intValue()).build());
                    break;
                }
                break;
            case 816580753:
                if (key.equals(DanmakuKeys.PREF_DANMAKU_BLOCKREPEAT)) {
                    request.setBlockrepeat(PlayerDanmakuBlockrepeat.newBuilder().setValue(((Boolean) value).booleanValue()).build());
                    break;
                }
                break;
            case 870892711:
                if (key.equals(DanmakuKeys.PREF_DANMAKU_DISPLAY_DOMAIN)) {
                    request.setDomainV2(PlayerDanmakuDomainV2.newBuilder().setValue(((Integer) value).intValue()).build());
                    break;
                }
                break;
            case 1003256004:
                if (key.equals(DanmakuKeys.PREF_DANMAKU_AVOID_FIGURE)) {
                    request.setPeopleProof(PlayerDanmakuPeopleProof.newBuilder().setValue(((Boolean) value).booleanValue()).build());
                    break;
                }
                break;
            case 1091056499:
                if (key.equals(DanmakuKeys.PREF_DANMAKU_BLOCKTOP)) {
                    request.setBlocktop(PlayerDanmakuBlocktop.newBuilder().setValue(((Boolean) value).booleanValue()).build());
                    break;
                }
                break;
            case 1127870354:
                if (key.equals(DanmakuKeys.PREF_DANMAKU_ENABLEBLOCKLIST)) {
                    request.setEnableblocklist(PlayerDanmakuEnableblocklist.newBuilder().setValue(((Boolean) value).booleanValue()).build());
                    break;
                }
                break;
            case 1204160677:
                if (key.equals(DanmakuKeys.PREF_DANMAKU_SCALING_FACTOR)) {
                    request.setScalingfactor(PlayerDanmakuScalingfactor.newBuilder().setValue(((Float) value).floatValue()).build());
                    break;
                }
                break;
            case 1364087401:
                if (key.equals(DanmakuKeys.PREF_DANMAKU_BLOCKSCROLL)) {
                    request.setBlockscroll(PlayerDanmakuBlockscroll.newBuilder().setValue(((Boolean) value).booleanValue()).build());
                    break;
                }
                break;
            case 1434303608:
                if (key.equals(DanmakuKeys.PREF_DANMAKU_SWITCH_SAVE)) {
                    request.setSwitchSave(PlayerDanmakuSwitchSave.newBuilder().setValue(((Boolean) value).booleanValue()).build());
                    break;
                }
                break;
            case 2006434853:
                if (key.equals(DanmakuKeys.PREF_DANMAKU_AI_RECOMMEND_SWITCH)) {
                    request.setAiRecommendedSwitch(PlayerDanmakuAiRecommendedSwitch.newBuilder().setValue(((Boolean) value).booleanValue()).build());
                    break;
                }
                break;
        }
        try {
            DMMoss dMMoss = new DMMoss((String) null, 0, (CallOptions) null, 7, (DefaultConstructorMarker) null);
            DmPlayerConfigReq build = request.build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            dMMoss.dmPlayerConfig(build, new MossResponseHandler<Response>() { // from class: tv.danmaku.biliplayerv2.service.kvo.PlayerKVOService$syncKVOToRemote$1
                public /* synthetic */ void onHeaders(Map map) {
                    MossResponseHandler.-CC.$default$onHeaders(this, map);
                }

                public /* synthetic */ long onNextForAck(Object obj) {
                    return MossResponseHandler.-CC.$default$onNextForAck(this, obj);
                }

                public /* synthetic */ void onUpstreamAck(Long l) {
                    MossResponseHandler.-CC.$default$onUpstreamAck(this, l);
                }

                public /* synthetic */ void onValid() {
                    MossResponseHandler.-CC.$default$onValid(this);
                }

                public void onNext(Response value2) {
                }

                public void onError(MossException t) {
                    String str = key;
                    PlayerLog.i("PlayerKVOService", "sync kvo error,key:" + str + ",value:" + value);
                }

                public void onCompleted() {
                    String str = key;
                    PlayerLog.i("PlayerKVOService", "sync kvo success,key:" + str + ",value:" + value);
                }
            });
        } catch (Throwable th) {
            PlayerLog.i(TAG, "sync kvo failed,key:" + key + ",value:" + value);
        }
    }

    public final void applyKVOToLocal(DanmuPlayerViewConfig playerConfig, IInteractLayerService danmakuService, boolean isSwitchRestoredFromShared) {
        MockDanmakuParams mockParams;
        Intrinsics.checkNotNullParameter(playerConfig, "playerConfig");
        Intrinsics.checkNotNullParameter(danmakuService, "danmakuService");
        if (playerConfig.hasDanmukuPlayerConfig()) {
            DanmuPlayerConfig danmuPlayerConfig = playerConfig.getDanmukuPlayerConfig();
            PlayerLog.i(TAG, "apply remote kvo config");
            if (isSwitchRestoredFromShared) {
                boolean currentDanmakuSwitch = danmakuService.isDanmakuVisible();
                if (currentDanmakuSwitch) {
                    danmakuService.showDanmaku(false);
                } else {
                    danmakuService.hideDanmaku(false);
                }
                PlayerLog.i(TAG, "currentDanmakuSwitch: " + currentDanmakuSwitch);
            } else {
                boolean danmakuSwitch = !(danmakuService.isInlineMode() || danmuPlayerConfig.getPlayerDanmakuSwitchSave()) || danmuPlayerConfig.getPlayerDanmakuSwitch();
                if (danmakuSwitch) {
                    danmakuService.showDanmaku(false);
                } else {
                    danmakuService.hideDanmaku(false);
                }
                PlayerLog.i(TAG, "danmakuSwitch: " + danmakuSwitch);
            }
            boolean aiRecommendedSwitch = danmuPlayerConfig.getPlayerDanmakuAiRecommendedSwitch();
            IInteractLayerService.CC.switchAiRecommendedSwitch$default(danmakuService, aiRecommendedSwitch, false, 2, null);
            int aiRecLevel = danmuPlayerConfig.getPlayerDanmakuAiRecommendedLevelV2();
            Map<Integer, Integer> playerDanmakuAiRecommendedLevelV2MapMap = danmuPlayerConfig.getPlayerDanmakuAiRecommendedLevelV2MapMap();
            Intrinsics.checkNotNullExpressionValue(playerDanmakuAiRecommendedLevelV2MapMap, "getPlayerDanmakuAiRecommendedLevelV2MapMap(...)");
            danmakuService.setAiBlockLevelMap(playerDanmakuAiRecommendedLevelV2MapMap);
            IInteractLayerService.CC.setAiBlockLevel$default(danmakuService, aiRecLevel, false, 2, null);
            IInteractLayerService.CC.setBlockRepeat$default(danmakuService, danmuPlayerConfig.getPlayerDanmakuBlockrepeat(), false, 2, null);
            IInteractLayerService.CC.setBlockTop$default(danmakuService, danmuPlayerConfig.getPlayerDanmakuBlocktop(), false, 2, null);
            IInteractLayerService.CC.setBlockScroll$default(danmakuService, danmuPlayerConfig.getPlayerDanmakuBlockscroll(), false, 2, null);
            IInteractLayerService.CC.setBlockBottom$default(danmakuService, danmuPlayerConfig.getPlayerDanmakuBlockbottom(), false, 2, null);
            IInteractLayerService.CC.setBlockColorful$default(danmakuService, danmuPlayerConfig.getPlayerDanmakuBlockcolorful(), false, 2, null);
            IInteractLayerService.CC.setBlockSpecial$default(danmakuService, danmuPlayerConfig.getPlayerDanmakuBlockspecial(), false, 2, null);
            IInteractLayerService.CC.setDanmakuOpacity$default(danmakuService, danmuPlayerConfig.getPlayerDanmakuOpacity(), false, 2, null);
            IInteractLayerService.CC.setScaleFactor$default(danmakuService, danmuPlayerConfig.getPlayerDanmakuScalingfactor(), false, 2, null);
            IInteractLayerService.CC.setDanmakuDomain$default(danmakuService, danmuPlayerConfig.getPlayerDanmakuDomain(), false, 2, null);
            BLog.d(TAG, "danmaku domain from dmView, value=" + danmuPlayerConfig.getPlayerDanmakuDomain());
            danmakuService.setBlockList(danmuPlayerConfig.getPlayerDanmakuEnableblocklist());
            int speed = danmuPlayerConfig.getPlayerDanmakuSpeed();
            float localSpeed = translateKVOSpeedToLocal(speed);
            IInteractLayerService.CC.setDanmakuSpeed$default(danmakuService, localSpeed, false, 2, null);
            float displayDomain = danmuPlayerConfig.getPlayerDanmakuDomainV2() / 100.0f;
            IInteractLayerService.CC.setDanmakuDisplayDomain$default(danmakuService, displayDomain, false, 2, null);
            IInteractLayerService.CC.setDanmakuDensity$default(danmakuService, danmuPlayerConfig.getPlayerDanmakuDensity(), false, 2, null);
            IInteractLayerService.CC.setDanmakuFoldSwitchEnable$default(danmakuService, danmuPlayerConfig.getPlayerDanmakuEnableHerdDm(), false, 2, null);
            IInteractLayerService.CC.setBlockFixed$default(danmakuService, danmuPlayerConfig.getPlayerDanmakuBlocktopBottom(), false, 2, null);
            IInteractLayerService.CC.setDanmakuAvoidScript$default(danmakuService, danmuPlayerConfig.getPlayerDanmakuSubtitleProof(), false, 2, null);
            IInteractLayerService.CC.setDanmakuAvoidFigure$default(danmakuService, danmuPlayerConfig.getPlayerDanmakuPeopleProof(), false, 2, null);
            IInteractLayerService.CC.setBlackWordsEnable$default(danmakuService, danmuPlayerConfig.getPlayerDanmakuEnableblocklist(), false, 2, null);
        }
        danmakuService.setDanmakuPlayerPanelSelectionText(playerConfig.hasDanmukuPlayerConfigPanel() ? playerConfig.getDanmukuPlayerConfigPanel().getSelectionText() : null);
        if (!BuildConfig.DEBUG || (mockParams = danmakuService.getMockDanmakuParams()) == null) {
            return;
        }
        String it = mockParams.getDanmakuSwitch();
        if (it != null) {
            if (PlayerKVOServiceKt.access$positiveValue(it)) {
                danmakuService.showDanmaku(false);
            } else {
                danmakuService.hideDanmaku(false);
            }
        }
        String it2 = mockParams.getDanmakuRecommendSwitch();
        if (it2 != null) {
            IInteractLayerService.CC.switchAiRecommendedSwitch$default(danmakuService, PlayerKVOServiceKt.access$positiveValue(it2), false, 2, null);
        }
        String it3 = mockParams.getBlockBottom();
        if (it3 != null) {
            IInteractLayerService.CC.setBlockBottom$default(danmakuService, PlayerKVOServiceKt.access$positiveValue(it3), false, 2, null);
        }
        String it4 = mockParams.getBlockColorful();
        if (it4 != null) {
            IInteractLayerService.CC.setBlockColorful$default(danmakuService, PlayerKVOServiceKt.access$positiveValue(it4), false, 2, null);
        }
        String it5 = mockParams.getBlockRepeat();
        if (it5 != null) {
            IInteractLayerService.CC.setBlockRepeat$default(danmakuService, PlayerKVOServiceKt.access$positiveValue(it5), false, 2, null);
        }
        String it6 = mockParams.getBlockScroll();
        if (it6 != null) {
            IInteractLayerService.CC.setBlockScroll$default(danmakuService, PlayerKVOServiceKt.access$positiveValue(it6), false, 2, null);
        }
        String it7 = mockParams.getBlockSpecial();
        if (it7 != null) {
            IInteractLayerService.CC.setBlockSpecial$default(danmakuService, PlayerKVOServiceKt.access$positiveValue(it7), false, 2, null);
        }
        String it8 = mockParams.getBlockTop();
        if (it8 != null) {
            IInteractLayerService.CC.setBlockTop$default(danmakuService, PlayerKVOServiceKt.access$positiveValue(it8), false, 2, null);
        }
        String it9 = mockParams.getDomain();
        if (it9 != null) {
            IInteractLayerService.CC.setDanmakuDomain$default(danmakuService, Float.parseFloat(it9), false, 2, null);
        }
        String it10 = mockParams.getEnableBlockList();
        if (it10 != null) {
            danmakuService.setBlockList(PlayerKVOServiceKt.access$positiveValue(it10));
        }
        String it11 = mockParams.getOpacity();
        if (it11 != null) {
            IInteractLayerService.CC.setDanmakuOpacity$default(danmakuService, Float.parseFloat(it11), false, 2, null);
        }
        String it12 = mockParams.getScalingFactor();
        if (it12 != null) {
            IInteractLayerService.CC.setScaleFactor$default(danmakuService, Float.parseFloat(it12), false, 2, null);
        }
        String it13 = mockParams.getSeniorModeSwitch();
        if (it13 != null) {
            danmakuService.changeDanmakuSeniorModeSwitch(Integer.parseInt(it13), false);
        }
    }

    public final float translateKVOSpeedToLocal(int local) {
        switch (local) {
            case 10:
                return 10.0f;
            case 20:
                return 8.5f;
            case 30:
            default:
                return 7.0f;
            case module_manga_cover_pic_content_VALUE:
                return 5.5f;
            case 50:
                return 4.0f;
        }
    }

    public final int translateLocalSpeedToKVO(float kvo) {
        if (kvo == 4.0f) {
            return 50;
        }
        if (kvo == 5.5f) {
            return 40;
        }
        if (kvo == 7.0f) {
            return 30;
        }
        if (kvo == 8.5f) {
            return 20;
        }
        return kvo == 10.0f ? 10 : 30;
    }

    public final float ensureDanmakuSpeed(float speed) {
        if (speed == 4.0f) {
            return 0.45f;
        }
        if (speed == 5.5f) {
            return 0.65f;
        }
        if (speed == 7.0f) {
            return 0.9f;
        }
        if (speed == 8.5f) {
            return 1.3f;
        }
        if (speed == 10.0f) {
            return 1.6f;
        }
        return speed;
    }

    public final void syncParamsBatched(Map<String, ? extends Object> map) {
        Map params = EnhancedUnmodifiabilityKt.unmodifiable(map);
        Intrinsics.checkNotNullParameter(params, "params");
        PlayerLog.i(TAG, "kvo syncParamsBatched: " + params);
        DmPlayerConfigReq.Builder request = DmPlayerConfigReq.newBuilder();
        Object obj = params.get(DanmakuKeys.PREF_DANMAKU_DISPLAY_DOMAIN);
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        if (num != null) {
            int it = num.intValue();
            request.setDomainV2(PlayerDanmakuDomainV2.newBuilder().setValue(it).build());
        }
        Object obj2 = params.get(DanmakuKeys.PREF_DANMAKU_OPACITY);
        Float f = obj2 instanceof Float ? (Float) obj2 : null;
        if (f != null) {
            float it2 = f.floatValue();
            request.setOpacity(PlayerDanmakuOpacity.newBuilder().setValue(it2).build());
        }
        Object obj3 = params.get(DanmakuKeys.PREF_DANMAKU_SCALING_FACTOR);
        Float f2 = obj3 instanceof Float ? (Float) obj3 : null;
        if (f2 != null) {
            float it3 = f2.floatValue();
            request.setScalingfactor(PlayerDanmakuScalingfactor.newBuilder().setValue(it3).build());
        }
        Object obj4 = params.get(DanmakuKeys.PREF_DANMAKU_SPEED);
        Integer num2 = obj4 instanceof Integer ? (Integer) obj4 : null;
        if (num2 != null) {
            int it4 = num2.intValue();
            request.setSpeed(PlayerDanmakuSpeed.newBuilder().setValue(it4).build());
        }
        Object obj5 = params.get(DanmakuKeys.PREF_DANMAKU_DENSITY);
        Integer num3 = obj5 instanceof Integer ? (Integer) obj5 : null;
        if (num3 != null) {
            int it5 = num3.intValue();
            request.setDensity(PlayerDanmakuDensity.newBuilder().setValue(it5).build());
        }
        Object obj6 = params.get(DanmakuKeys.PREF_DANMAKU_BLOCKFIXED);
        Boolean bool = obj6 instanceof Boolean ? (Boolean) obj6 : null;
        if (bool != null) {
            boolean it6 = bool.booleanValue();
            request.setBlocktopBottom(PlayerDanmakuBlocktopBottom.newBuilder().setValue(it6).build());
        }
        Object obj7 = params.get(DanmakuKeys.PREF_DANMAKU_BLOCKSCROLL);
        Boolean bool2 = obj7 instanceof Boolean ? (Boolean) obj7 : null;
        if (bool2 != null) {
            boolean it7 = bool2.booleanValue();
            request.setBlockscroll(PlayerDanmakuBlockscroll.newBuilder().setValue(it7).build());
        }
        Object obj8 = params.get(DanmakuKeys.PREF_DANMAKU_BLOCKCOLORFUL);
        Boolean bool3 = obj8 instanceof Boolean ? (Boolean) obj8 : null;
        if (bool3 != null) {
            boolean it8 = bool3.booleanValue();
            request.setBlockcolorful(PlayerDanmakuBlockcolorful.newBuilder().setValue(it8).build());
        }
        Object obj9 = params.get(DanmakuKeys.PREF_DANMAKU_BLOCKSPECIAL);
        Boolean bool4 = obj9 instanceof Boolean ? (Boolean) obj9 : null;
        if (bool4 != null) {
            boolean it9 = bool4.booleanValue();
            request.setBlockspecial(PlayerDanmakuBlockspecial.newBuilder().setValue(it9).build());
        }
        Object obj10 = params.get(DanmakuKeys.PREF_DANMAKU_FOLD);
        Boolean bool5 = obj10 instanceof Boolean ? (Boolean) obj10 : null;
        if (bool5 != null) {
            boolean it10 = bool5.booleanValue();
            request.setEnableHerdDm(PlayerDanmakuEnableHerdDm.newBuilder().setValue(it10).build());
        }
        Object obj11 = params.get(DanmakuKeys.PREF_DANMAKU_BLOCKREPEAT);
        Boolean bool6 = obj11 instanceof Boolean ? (Boolean) obj11 : null;
        if (bool6 != null) {
            boolean it11 = bool6.booleanValue();
            request.setBlockrepeat(PlayerDanmakuBlockrepeat.newBuilder().setValue(it11).build());
        }
        Object obj12 = params.get(DanmakuKeys.PREF_DANMAKU_AVOID_FIGURE);
        Boolean bool7 = obj12 instanceof Boolean ? (Boolean) obj12 : null;
        if (bool7 != null) {
            bool7.booleanValue();
            request.setPeopleProof(PlayerDanmakuPeopleProof.newBuilder().setValue(true).build());
        }
        Object obj13 = params.get(DanmakuKeys.PREF_DANMAKU_AVOID_SCRIPT);
        Boolean bool8 = obj13 instanceof Boolean ? (Boolean) obj13 : null;
        if (bool8 != null) {
            boolean it12 = bool8.booleanValue();
            request.setSubtitleProof(PlayerDanmakuSubtitleProof.newBuilder().setValue(it12).build());
        }
        Object obj14 = params.get(DanmakuKeys.PREF_DANMAKU_SENIOR_MODE_SWITCH);
        Integer num4 = obj14 instanceof Integer ? (Integer) obj14 : null;
        if (num4 != null) {
            int it13 = num4.intValue();
            request.setSeniorModeSwitch(PlayerDanmakuSeniorModeSwitch.newBuilder().setValue(it13).build());
        }
        try {
            DMMoss dMMoss = new DMMoss((String) null, 0, (CallOptions) null, 7, (DefaultConstructorMarker) null);
            DmPlayerConfigReq build = request.build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            dMMoss.dmPlayerConfig(build, new MossResponseHandler<Response>() { // from class: tv.danmaku.biliplayerv2.service.kvo.PlayerKVOService$syncParamsBatched$1
                public /* synthetic */ void onHeaders(Map map2) {
                    MossResponseHandler.-CC.$default$onHeaders(this, map2);
                }

                public /* synthetic */ long onNextForAck(Object obj15) {
                    return MossResponseHandler.-CC.$default$onNextForAck(this, obj15);
                }

                public /* synthetic */ void onUpstreamAck(Long l) {
                    MossResponseHandler.-CC.$default$onUpstreamAck(this, l);
                }

                public /* synthetic */ void onValid() {
                    MossResponseHandler.-CC.$default$onValid(this);
                }

                public void onNext(Response value) {
                }

                public void onError(MossException t) {
                    PlayerLog.i("PlayerKVOService", "kvo resetPreferences error: " + t);
                }

                public void onCompleted() {
                    PlayerLog.i("PlayerKVOService", "kvo resetPreferences success");
                }
            });
        } catch (Throwable e) {
            PlayerLog.i(TAG, "kvo resetPreferences failed: " + e);
        }
    }

    /* compiled from: PlayerKVOService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Ltv/danmaku/biliplayerv2/service/kvo/PlayerKVOService$DanmakuSwitchReqParams;", "", "danmakuSwitch", "", "canIgnore", "<init>", "(ZZ)V", "getDanmakuSwitch", "()Z", "getCanIgnore", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class DanmakuSwitchReqParams {
        private final boolean canIgnore;
        private final boolean danmakuSwitch;

        public DanmakuSwitchReqParams(boolean danmakuSwitch, boolean canIgnore) {
            this.danmakuSwitch = danmakuSwitch;
            this.canIgnore = canIgnore;
        }

        public final boolean getCanIgnore() {
            return this.canIgnore;
        }

        public final boolean getDanmakuSwitch() {
            return this.danmakuSwitch;
        }
    }
}