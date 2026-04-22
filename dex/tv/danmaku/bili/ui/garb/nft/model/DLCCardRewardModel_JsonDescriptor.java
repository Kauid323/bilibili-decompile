package tv.danmaku.bili.ui.garb.nft.model;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;
import com.bilibili.bson.common.Types;
import java.lang.reflect.Type;
import java.util.List;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.api.BiliDLCCardItem;

public final class DLCCardRewardModel_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public DLCCardRewardModel_JsonDescriptor() {
        super(DLCCardRewardModel.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("act_id", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("callbackId", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("share_type", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("screen_type", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("has_draw_ani", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("has_card_ani", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("collect_id", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("collect_name", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("end_time", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("start_time", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("has_redeemed_cnt", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("owner_item_amount", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("redeem_item_id", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("redeem_item_image", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("redeem_item_name", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("redeem_item_type", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("redeem_text", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("require_item_amount", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("is_gained", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("garb_suit_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("garb_apply_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("space_bg_set_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("horizontal_card_light_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("vertical_card_light_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("horizontal_card_shadow_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("vertical_card_shadow_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("card_item", (String[]) null, BiliDLCCardItem.class, (Class) null, 5), new PojoPropertyDescriptor("from", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("from_id", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("reward_tag", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("reward_tip", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("f_source", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("page_type", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("is_highlight", (String[]) null, Boolean.class, (Class) null, 4), new PojoPropertyDescriptor("material_type", (String[]) null, Integer.TYPE, (Class) null, 7), new PojoPropertyDescriptor("video_list", (String[]) null, Types.parameterizedType(List.class, new Type[]{String.class}), (Class) null, 23), new PojoPropertyDescriptor("is_mute", (String[]) null, Boolean.TYPE, (Class) null, 5), new PojoPropertyDescriptor("collect_progress_button", (String[]) null, CollectProgressButton.class, (Class) null, 6)};
    }

    public Object constructWith(Object[] objArr) {
        String str = (String) objArr[0];
        String str2 = (String) objArr[1];
        Integer num = (Integer) objArr[2];
        int intValue = num == null ? 0 : num.intValue();
        Integer num2 = (Integer) objArr[3];
        int intValue2 = num2 == null ? 0 : num2.intValue();
        Integer num3 = (Integer) objArr[4];
        int intValue3 = num3 == null ? 0 : num3.intValue();
        Integer num4 = (Integer) objArr[5];
        int intValue4 = num4 == null ? 0 : num4.intValue();
        Integer num5 = (Integer) objArr[6];
        int intValue5 = num5 == null ? 0 : num5.intValue();
        String str3 = (String) objArr[7];
        String str4 = (String) objArr[8];
        String str5 = (String) objArr[9];
        Integer num6 = (Integer) objArr[10];
        int intValue6 = num6 == null ? 0 : num6.intValue();
        Integer num7 = (Integer) objArr[11];
        int intValue7 = num7 == null ? 0 : num7.intValue();
        String str6 = (String) objArr[12];
        String str7 = (String) objArr[13];
        String str8 = (String) objArr[14];
        Integer num8 = (Integer) objArr[15];
        int intValue8 = num8 == null ? 0 : num8.intValue();
        String str9 = (String) objArr[16];
        Integer num9 = (Integer) objArr[17];
        int intValue9 = num9 == null ? 0 : num9.intValue();
        Integer num10 = (Integer) objArr[18];
        int intValue10 = num10 == null ? 0 : num10.intValue();
        String str10 = (String) objArr[19];
        String str11 = (String) objArr[20];
        String str12 = (String) objArr[21];
        String str13 = (String) objArr[22];
        String str14 = (String) objArr[23];
        String str15 = (String) objArr[24];
        String str16 = (String) objArr[25];
        BiliDLCCardItem biliDLCCardItem = (BiliDLCCardItem) objArr[26];
        String str17 = (String) objArr[27];
        String str18 = (String) objArr[28];
        String str19 = (String) objArr[29];
        String str20 = (String) objArr[30];
        String str21 = (String) objArr[31];
        Integer num11 = (Integer) objArr[32];
        int intValue11 = num11 == null ? 0 : num11.intValue();
        Boolean bool = (Boolean) objArr[33];
        Object obj = objArr[34];
        int i = obj != null ? 0 : 4;
        Integer num12 = (Integer) obj;
        int intValue12 = num12 == null ? 0 : num12.intValue();
        Object obj2 = objArr[35];
        if (obj2 == null) {
            i |= 8;
        }
        List list = (List) obj2;
        Boolean bool2 = (Boolean) objArr[36];
        boolean booleanValue = bool2 != null ? bool2.booleanValue() : false;
        Object obj3 = objArr[37];
        if (obj3 == null) {
            i |= 32;
        }
        return new DLCCardRewardModel(str, str2, intValue, intValue2, intValue3, intValue4, intValue5, str3, str4, str5, intValue6, intValue7, str6, str7, str8, intValue8, str9, intValue9, intValue10, str10, str11, str12, str13, str14, str15, str16, biliDLCCardItem, str17, str18, str19, str20, str21, intValue11, bool, intValue12, list, booleanValue, (CollectProgressButton) obj3, 0, i, null);
    }

    public Object get(Object obj, int i) {
        DLCCardRewardModel dLCCardRewardModel = (DLCCardRewardModel) obj;
        switch (i) {
            case 0:
                return dLCCardRewardModel.getActivityId();
            case 1:
                return dLCCardRewardModel.getCallbackId();
            case 2:
                return Integer.valueOf(dLCCardRewardModel.getShareType());
            case 3:
                return Integer.valueOf(dLCCardRewardModel.getScreenType());
            case 4:
                return Integer.valueOf(dLCCardRewardModel.getHasDrawCardAnimation());
            case 5:
                return Integer.valueOf(dLCCardRewardModel.getHasCardAnimation());
            case 6:
                return Integer.valueOf(dLCCardRewardModel.getCollectId());
            case 7:
                return dLCCardRewardModel.getCollectName();
            case 8:
                return dLCCardRewardModel.getEndTime();
            case 9:
                return dLCCardRewardModel.getStartTime();
            case 10:
                return Integer.valueOf(dLCCardRewardModel.getHasRedeemedCount());
            case 11:
                return Integer.valueOf(dLCCardRewardModel.getOwnerItemAamount());
            case 12:
                return dLCCardRewardModel.getRedeemItemId();
            case 13:
                return dLCCardRewardModel.getRedeemItemImage();
            case 14:
                return dLCCardRewardModel.getRedeemItemName();
            case 15:
                return Integer.valueOf(dLCCardRewardModel.getRedeemItemType());
            case 16:
                return dLCCardRewardModel.getRedeemText();
            case 17:
                return Integer.valueOf(dLCCardRewardModel.getRequireItemAmount());
            case 18:
                return Integer.valueOf(dLCCardRewardModel.getGained());
            case 19:
                return dLCCardRewardModel.getGarbSuitUrl();
            case 20:
                return dLCCardRewardModel.getGarbApplyUrl();
            case 21:
                return dLCCardRewardModel.getSpaceBgSetUrl();
            case 22:
                return dLCCardRewardModel.getHorizontalCardLightUrl();
            case 23:
                return dLCCardRewardModel.getVerticalCardLightUrl();
            case 24:
                return dLCCardRewardModel.getHorizontalCardShadowUrl();
            case BR.avatarList /* 25 */:
                return dLCCardRewardModel.getVerticalCardShadowUrl();
            case BR.avatarListVisible /* 26 */:
                return dLCCardRewardModel.getCardItem();
            case BR.avatarPendantUrl /* 27 */:
                return dLCCardRewardModel.getFromWhere();
            case BR.avatarUrl /* 28 */:
                return dLCCardRewardModel.getFromId();
            case BR.backImageUrl /* 29 */:
                return dLCCardRewardModel.getRewardTag();
            case 30:
                return dLCCardRewardModel.getRewardTip();
            case BR.background /* 31 */:
                return dLCCardRewardModel.getFSource();
            case BR.backgroundColor /* 32 */:
                return Integer.valueOf(dLCCardRewardModel.getPageType());
            case 33:
                return dLCCardRewardModel.isHighlight();
            case BR.backgroundDrawable /* 34 */:
                return Integer.valueOf(dLCCardRewardModel.getMaterialType());
            case BR.backgroundHeaderImageUrl /* 35 */:
                return dLCCardRewardModel.getVideoList();
            case 36:
                return Boolean.valueOf(dLCCardRewardModel.isMute());
            case BR.backgroundTitleText /* 37 */:
                return dLCCardRewardModel.getCollectProgressButton();
            default:
                return null;
        }
    }
}