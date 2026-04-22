package util;

import com.bilibili.bililive.biz.uicommon.gift.LiveSendGiftReceiveUser;
import com.bilibili.bililive.videoliveplayer.net.beans.gift.BiliLiveReceiveUser;
import com.bilibili.bililive.videoliveplayer.net.beans.gift.BiliLiveReceiveUserRequestParams;
import com.bilibili.bililive.videoliveplayer.net.beans.gift.LiveGiftPanelMicUserInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: LiveGiftUtilsV2.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u001a\u001c\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n\u001a\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0001\u001a&\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00010\rj\b\u0012\u0004\u0012\u00020\u0001`\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\n\u001a&\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00120\rj\b\u0012\u0004\u0012\u00020\u0012`\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\n¨\u0006\u0013"}, d2 = {"createReceiveUser", "Lcom/bilibili/bililive/videoliveplayer/net/beans/gift/BiliLiveReceiveUser;", "userId", "", "position", "", "createSendGiftReceiveUser", "Lcom/bilibili/bililive/biz/uicommon/gift/LiveSendGiftReceiveUser;", "receiveGiftUserUid", "receiveUsers", "", "receiveUser", "micUserTransformSendGiftReceiveUser", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "micUsers", "Lcom/bilibili/bililive/videoliveplayer/net/beans/gift/LiveGiftPanelMicUserInfo;", "micUserTransformReceiveUsersRequestParams", "Lcom/bilibili/bililive/videoliveplayer/net/beans/gift/BiliLiveReceiveUserRequestParams;", "giftCommon_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class LiveGiftUtilsV2Kt {
    public static final BiliLiveReceiveUser createReceiveUser(long userId, int position) {
        BiliLiveReceiveUser $this$createReceiveUser_u24lambda_u240 = new BiliLiveReceiveUser((Long) null, (Integer) null, 3, (DefaultConstructorMarker) null);
        $this$createReceiveUser_u24lambda_u240.setUid(Long.valueOf(userId));
        $this$createReceiveUser_u24lambda_u240.setPosition(Integer.valueOf(position));
        return $this$createReceiveUser_u24lambda_u240;
    }

    public static /* synthetic */ LiveSendGiftReceiveUser createSendGiftReceiveUser$default(long j, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return createSendGiftReceiveUser(j, i);
    }

    public static final LiveSendGiftReceiveUser createSendGiftReceiveUser(long receiveGiftUserUid, int position) {
        return new LiveSendGiftReceiveUser(receiveGiftUserUid, CollectionsKt.mutableListOf(new BiliLiveReceiveUser[]{createReceiveUser(receiveGiftUserUid, position)}));
    }

    public static final LiveSendGiftReceiveUser createSendGiftReceiveUser(long receiveGiftUserUid, List<BiliLiveReceiveUser> list) {
        Intrinsics.checkNotNullParameter(list, "receiveUsers");
        return new LiveSendGiftReceiveUser(receiveGiftUserUid, CollectionsKt.toMutableList(list));
    }

    public static final LiveSendGiftReceiveUser createSendGiftReceiveUser(long receiveGiftUserUid, BiliLiveReceiveUser receiveUser) {
        Intrinsics.checkNotNullParameter(receiveUser, "receiveUser");
        return new LiveSendGiftReceiveUser(receiveGiftUserUid, CollectionsKt.mutableListOf(new BiliLiveReceiveUser[]{receiveUser}));
    }

    public static final ArrayList<BiliLiveReceiveUser> micUserTransformSendGiftReceiveUser(List<LiveGiftPanelMicUserInfo> list) {
        ArrayList receiveUsers = new ArrayList();
        if (list != null) {
            List<LiveGiftPanelMicUserInfo> $this$forEach$iv = list;
            for (Object element$iv : $this$forEach$iv) {
                LiveGiftPanelMicUserInfo it = (LiveGiftPanelMicUserInfo) element$iv;
                BiliLiveReceiveUser $this$micUserTransformSendGiftReceiveUser_u24lambda_u240_u240 = new BiliLiveReceiveUser((Long) null, (Integer) null, 3, (DefaultConstructorMarker) null);
                $this$micUserTransformSendGiftReceiveUser_u24lambda_u240_u240.setUid(Long.valueOf(it.getUid()));
                $this$micUserTransformSendGiftReceiveUser_u24lambda_u240_u240.setPosition(Integer.valueOf(it.getPosition()));
                receiveUsers.add($this$micUserTransformSendGiftReceiveUser_u24lambda_u240_u240);
            }
        }
        return receiveUsers;
    }

    public static final ArrayList<BiliLiveReceiveUserRequestParams> micUserTransformReceiveUsersRequestParams(List<LiveGiftPanelMicUserInfo> list) {
        ArrayList receiveUserRequestParams = new ArrayList();
        if (list != null) {
            List<LiveGiftPanelMicUserInfo> $this$forEach$iv = list;
            for (Object element$iv : $this$forEach$iv) {
                LiveGiftPanelMicUserInfo it = (LiveGiftPanelMicUserInfo) element$iv;
                BiliLiveReceiveUserRequestParams $this$micUserTransformReceiveUsersRequestParams_u24lambda_u240_u240 = new BiliLiveReceiveUserRequestParams();
                $this$micUserTransformReceiveUsersRequestParams_u24lambda_u240_u240.setUid(Long.valueOf(it.getUid()));
                $this$micUserTransformReceiveUsersRequestParams_u24lambda_u240_u240.setRoomId(Long.valueOf(it.getRoomId()));
                $this$micUserTransformReceiveUsersRequestParams_u24lambda_u240_u240.setMystery(it.isMystery());
                receiveUserRequestParams.add($this$micUserTransformReceiveUsersRequestParams_u24lambda_u240_u240);
            }
        }
        return receiveUserRequestParams;
    }
}