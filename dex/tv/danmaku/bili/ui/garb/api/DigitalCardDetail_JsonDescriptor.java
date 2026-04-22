package tv.danmaku.bili.ui.garb.api;

import com.bili.digital.common.CardNumberGradientColor;
import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;
import com.bilibili.bson.common.Types;
import java.lang.reflect.Type;
import java.util.ArrayList;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.nft.model.DLCPlayModel;
import tv.danmaku.bili.ui.garb.nft.model.DLCTagModel;

public final class DigitalCardDetail_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public DigitalCardDetail_JsonDescriptor() {
        super(DigitalCardDetail.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("card_type_id", (String[]) null, Long.TYPE, (Class) null, 5), new PojoPropertyDescriptor("card_id", (String[]) null, Long.TYPE, (Class) null, 5), new PojoPropertyDescriptor("card_type", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("card_status", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("card_name", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("card_no", (String[]) null, Long.TYPE, (Class) null, 5), new PojoPropertyDescriptor("card_no_show", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("card_scarcity", (String[]) null, Long.TYPE, (Class) null, 5), new PojoPropertyDescriptor("card_cnt", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("total_cnt_show", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("card_img", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("video_list", (String[]) null, Types.parameterizedType(ArrayList.class, new Type[]{String.class}), (Class) null, 21), new PojoPropertyDescriptor("is_mute", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("holding_rate", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("is_req_detail", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("width", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("height", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("horizontal_card_light_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("horizontal_card_shadow_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("vertical_card_light_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("vertical_card_shadow_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("jump_desc", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("jump_link", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("act_id", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("activity_desc", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("activity_link", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("icon_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("is_overtime", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("subtitles_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("trial_play", (String[]) null, Boolean.TYPE, (Class) null, 5), new PojoPropertyDescriptor("play", (String[]) null, DLCPlayModel.class, (Class) null, 5), new PojoPropertyDescriptor(AppConfig.HOST_TAG, (String[]) null, DLCTagModel.class, (Class) null, 5), new PojoPropertyDescriptor("card_NumberGradientColor", (String[]) null, CardNumberGradientColor.class, (Class) null, 5)};
    }

    public Object constructWith(Object[] objArr) {
        Long l = (Long) objArr[0];
        long longValue = l == null ? 0L : l.longValue();
        Long l2 = (Long) objArr[1];
        long longValue2 = l2 == null ? 0L : l2.longValue();
        Integer num = (Integer) objArr[2];
        int intValue = num == null ? 0 : num.intValue();
        Integer num2 = (Integer) objArr[3];
        int intValue2 = num2 == null ? 0 : num2.intValue();
        String str = (String) objArr[4];
        Long l3 = (Long) objArr[5];
        long longValue3 = l3 == null ? 0L : l3.longValue();
        String str2 = (String) objArr[6];
        Long l4 = (Long) objArr[7];
        long longValue4 = l4 == null ? 0L : l4.longValue();
        Integer num3 = (Integer) objArr[8];
        int intValue3 = num3 == null ? 0 : num3.intValue();
        String str3 = (String) objArr[9];
        String str4 = (String) objArr[10];
        ArrayList arrayList = (ArrayList) objArr[11];
        Integer num4 = (Integer) objArr[12];
        int intValue4 = num4 == null ? 0 : num4.intValue();
        String str5 = (String) objArr[13];
        Integer num5 = (Integer) objArr[14];
        int intValue5 = num5 == null ? 0 : num5.intValue();
        Integer num6 = (Integer) objArr[15];
        int intValue6 = num6 == null ? 0 : num6.intValue();
        Integer num7 = (Integer) objArr[16];
        int intValue7 = num7 == null ? 0 : num7.intValue();
        String str6 = (String) objArr[17];
        String str7 = (String) objArr[18];
        String str8 = (String) objArr[19];
        String str9 = (String) objArr[20];
        String str10 = (String) objArr[21];
        String str11 = (String) objArr[22];
        Integer num8 = (Integer) objArr[23];
        int intValue8 = num8 == null ? 0 : num8.intValue();
        String str12 = (String) objArr[24];
        String str13 = (String) objArr[25];
        String str14 = (String) objArr[26];
        Integer num9 = (Integer) objArr[27];
        int intValue9 = num9 == null ? 0 : num9.intValue();
        String str15 = (String) objArr[28];
        Boolean bool = (Boolean) objArr[29];
        return new DigitalCardDetail(longValue, longValue2, intValue, intValue2, str, longValue3, str2, longValue4, intValue3, str3, str4, arrayList, intValue4, str5, intValue5, intValue6, intValue7, str6, str7, str8, str9, str10, str11, intValue8, str12, str13, str14, intValue9, str15, bool != null ? bool.booleanValue() : false, (DLCPlayModel) objArr[30], (DLCTagModel) objArr[31], (CardNumberGradientColor) objArr[32]);
    }

    public Object get(Object obj, int i) {
        DigitalCardDetail digitalCardDetail = (DigitalCardDetail) obj;
        switch (i) {
            case 0:
                return Long.valueOf(digitalCardDetail.getCardTypeId());
            case 1:
                return Long.valueOf(digitalCardDetail.getCardId());
            case 2:
                return Integer.valueOf(digitalCardDetail.getCardType());
            case 3:
                return Integer.valueOf(digitalCardDetail.getStatus());
            case 4:
                return digitalCardDetail.getCardName();
            case 5:
                return Long.valueOf(digitalCardDetail.getCardNo());
            case 6:
                return digitalCardDetail.getCardNoShow();
            case 7:
                return Long.valueOf(digitalCardDetail.getCardScarcity());
            case 8:
                return Integer.valueOf(digitalCardDetail.getTotalCnt());
            case 9:
                return digitalCardDetail.getTotalCntShow();
            case 10:
                return digitalCardDetail.getCardImg();
            case 11:
                return digitalCardDetail.getVideoList();
            case 12:
                return Integer.valueOf(digitalCardDetail.getSilence());
            case 13:
                return digitalCardDetail.getRealChance();
            case 14:
                return Integer.valueOf(digitalCardDetail.getNeedRequest());
            case 15:
                return Integer.valueOf(digitalCardDetail.getWidth());
            case 16:
                return Integer.valueOf(digitalCardDetail.getHeight());
            case 17:
                return digitalCardDetail.getHCardLightUrl();
            case 18:
                return digitalCardDetail.getHCardShadowUrl();
            case 19:
                return digitalCardDetail.getVCardLightUrl();
            case 20:
                return digitalCardDetail.getVCardShadowUrl();
            case 21:
                return digitalCardDetail.getJumpDesc();
            case 22:
                return digitalCardDetail.getJumpLink();
            case 23:
                return Integer.valueOf(digitalCardDetail.getActId());
            case 24:
                return digitalCardDetail.getActivityDesc();
            case BR.avatarList /* 25 */:
                return digitalCardDetail.getActivityLink();
            case BR.avatarListVisible /* 26 */:
                return digitalCardDetail.getIconUrl();
            case BR.avatarPendantUrl /* 27 */:
                return Integer.valueOf(digitalCardDetail.getOvertime());
            case BR.avatarUrl /* 28 */:
                return digitalCardDetail.getSubtitlesUrl();
            case BR.backImageUrl /* 29 */:
                return Boolean.valueOf(digitalCardDetail.isTrialPlay());
            case 30:
                return digitalCardDetail.getPlay();
            case BR.background /* 31 */:
                return digitalCardDetail.getTag();
            case BR.backgroundColor /* 32 */:
                return digitalCardDetail.getCardNumberGradientColor();
            default:
                return null;
        }
    }
}