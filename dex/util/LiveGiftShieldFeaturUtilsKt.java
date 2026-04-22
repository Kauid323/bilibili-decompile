package util;

import com.bilibili.bililive.featureGateway.LiveRoomFeatureGatewayUtil;
import com.bilibili.bililive.videoliveplayer.net.beans.gateway.roominfo.BiliLiveRoomInfo;
import com.bilibili.bililive.videoliveplayer.net.beans.gateway.roominfo.BiliLiveRoomStudioInfo;
import com.bilibili.bililive.videoliveplayer.net.beans.gateway.roominfo.BiliLiveRoomSwitchInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import proxy.IGiftParentBizContext;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: LiveGiftShieldFeaturUtils.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0003*\u00020\u0004\u001a\n\u0010\u0006\u001a\u00020\u0003*\u00020\u0004\u001a\n\u0010\u0007\u001a\u00020\u0003*\u00020\u0004\u001a\n\u0010\b\u001a\u00020\u0003*\u00020\u0004\u001a\n\u0010\t\u001a\u00020\u0003*\u00020\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"SPECIAL_TYPE_MULTI_VOICE", "", "isCloseGuard", "", "Lproxy/IGiftParentBizContext;", "isShieldFansMedalProgress", "isSupportMicUserSendGift", "isSupportSendGiftInOfficial", "isMultiVoice", "isLessonsMode", "giftCommon_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class LiveGiftShieldFeaturUtilsKt {
    public static final int SPECIAL_TYPE_MULTI_VOICE = 71;

    public static final boolean isCloseGuard(IGiftParentBizContext $this$isCloseGuard) {
        BiliLiveRoomSwitchInfo biliLiveRoomSwitchInfo;
        Intrinsics.checkNotNullParameter($this$isCloseGuard, "<this>");
        if (!isLessonsMode($this$isCloseGuard)) {
            BiliLiveRoomInfo roomInfo = $this$isCloseGuard.getRoomInfo();
            if (!((roomInfo == null || (biliLiveRoomSwitchInfo = roomInfo.switchInfo) == null) ? false : biliLiveRoomSwitchInfo.closeGuard)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean isShieldFansMedalProgress(IGiftParentBizContext $this$isShieldFansMedalProgress) {
        BiliLiveRoomStudioInfo biliLiveRoomStudioInfo;
        Intrinsics.checkNotNullParameter($this$isShieldFansMedalProgress, "<this>");
        if (LiveRoomFeatureGatewayUtil.INSTANCE.isFansMedalProgressShow()) {
            BiliLiveRoomInfo roomInfo = $this$isShieldFansMedalProgress.getRoomInfo();
            return roomInfo != null && (biliLiveRoomStudioInfo = roomInfo.studioInfo) != null && biliLiveRoomStudioInfo.status == 1;
        }
        return true;
    }

    public static final boolean isSupportMicUserSendGift(IGiftParentBizContext $this$isSupportMicUserSendGift) {
        Intrinsics.checkNotNullParameter($this$isSupportMicUserSendGift, "<this>");
        return isMultiVoice($this$isSupportMicUserSendGift) && LiveRoomFeatureGatewayUtil.INSTANCE.isMicUserSendGift();
    }

    public static final boolean isSupportSendGiftInOfficial(IGiftParentBizContext $this$isSupportSendGiftInOfficial) {
        Intrinsics.checkNotNullParameter($this$isSupportSendGiftInOfficial, "<this>");
        return $this$isSupportSendGiftInOfficial.isOfficialRoom() && $this$isSupportSendGiftInOfficial.isOfficialShowing();
    }

    public static final boolean isMultiVoice(IGiftParentBizContext $this$isMultiVoice) {
        Intrinsics.checkNotNullParameter($this$isMultiVoice, "<this>");
        return $this$isMultiVoice.getSpecialTypeList().contains(71);
    }

    public static final boolean isLessonsMode(IGiftParentBizContext $this$isLessonsMode) {
        Intrinsics.checkNotNullParameter($this$isLessonsMode, "<this>");
        return $this$isLessonsMode.getSpecialTypeList().contains(4);
    }
}