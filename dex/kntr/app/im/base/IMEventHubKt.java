package kntr.app.im.base;

import com.bapis.bilibili.app.im.v1.KIMSettingType;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: IMEventHub.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"settingTypesNeedRefreshSessions", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/bapis/bilibili/app/im/v1/KIMSettingType;", "[Lcom/bapis/bilibili/app/im/v1/KIMSettingType;", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMEventHubKt {
    private static final KIMSettingType[] settingTypesNeedRefreshSessions = {KIMSettingType.SETTING_TYPE_MSG_REMIND.INSTANCE, KIMSettingType.SETTING_TYPE_MSG_INTERCEPTION.INSTANCE, KIMSettingType.SETTING_TYPE_FANS_GROUP_MSG_RECEIVE.INSTANCE, KIMSettingType.SETTING_TYPE_FANS_GROUP_MSG_FOLD.INSTANCE, KIMSettingType.SETTING_TYPE_UNFOLLOWED_MSG_RECEIVE.INSTANCE, KIMSettingType.SETTING_TYPE_UNFOLLOWED_MSG_FOLD.INSTANCE};

    public static final /* synthetic */ KIMSettingType[] access$getSettingTypesNeedRefreshSessions$p() {
        return settingTypesNeedRefreshSessions;
    }
}