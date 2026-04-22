package tv.danmaku.bili.ui.garb.nft.model;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;
import com.bilibili.bson.common.Types;
import java.lang.reflect.Type;
import java.util.List;
import tv.danmaku.bili.BR;

public final class DLCDetailModel_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public DLCDetailModel_JsonDescriptor() {
        super(DLCDetailModel.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("act_id", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("callbackId", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("type", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("screen_type", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("has_draw_ani", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("has_card_ani", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("share_type", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("jump_id", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("horizontal_card_light_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("horizontal_card_shadow_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("vertical_card_light_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("vertical_card_shadow_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("mid", (String[]) null, Long.TYPE, (Class) null, 5), new PojoPropertyDescriptor("total_cnt", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("not_on_sale", (String[]) null, Boolean.TYPE, (Class) null, 5), new PojoPropertyDescriptor("holder_list_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("homepage_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("space_bg_set_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("card_list", (String[]) null, Types.parameterizedType(List.class, new Type[]{DigitalCardDetailModel.class}), (Class) null, 21), new PojoPropertyDescriptor("is_booked", (String[]) null, Boolean.TYPE, (Class) null, 5), new PojoPropertyDescriptor("is_can_donate", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("save_image_right", (String[]) null, Boolean.TYPE, (Class) null, 5), new PojoPropertyDescriptor("is_up_chain", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("from", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("from_id", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("f_source", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("page_type", (String[]) null, Integer.TYPE, (Class) null, 5)};
    }

    public Object constructWith(Object[] objArr) {
        Integer num = (Integer) objArr[0];
        int intValue = num == null ? 0 : num.intValue();
        Integer num2 = (Integer) objArr[1];
        int intValue2 = num2 == null ? 0 : num2.intValue();
        Integer num3 = (Integer) objArr[2];
        int intValue3 = num3 == null ? 0 : num3.intValue();
        Integer num4 = (Integer) objArr[3];
        int intValue4 = num4 == null ? 0 : num4.intValue();
        Integer num5 = (Integer) objArr[4];
        int intValue5 = num5 == null ? 0 : num5.intValue();
        Integer num6 = (Integer) objArr[5];
        int intValue6 = num6 == null ? 0 : num6.intValue();
        Integer num7 = (Integer) objArr[6];
        int intValue7 = num7 == null ? 0 : num7.intValue();
        Integer num8 = (Integer) objArr[7];
        int intValue8 = num8 == null ? 0 : num8.intValue();
        String str = (String) objArr[8];
        String str2 = (String) objArr[9];
        String str3 = (String) objArr[10];
        String str4 = (String) objArr[11];
        Long l = (Long) objArr[12];
        long longValue = l == null ? 0L : l.longValue();
        Integer num9 = (Integer) objArr[13];
        int intValue9 = num9 == null ? 0 : num9.intValue();
        Boolean bool = (Boolean) objArr[14];
        boolean booleanValue = bool == null ? false : bool.booleanValue();
        String str5 = (String) objArr[15];
        String str6 = (String) objArr[16];
        String str7 = (String) objArr[17];
        List list = (List) objArr[18];
        Boolean bool2 = (Boolean) objArr[19];
        boolean booleanValue2 = bool2 == null ? false : bool2.booleanValue();
        Integer num10 = (Integer) objArr[20];
        int intValue10 = num10 == null ? 0 : num10.intValue();
        Boolean bool3 = (Boolean) objArr[21];
        boolean booleanValue3 = bool3 == null ? false : bool3.booleanValue();
        Integer num11 = (Integer) objArr[22];
        int intValue11 = num11 == null ? 0 : num11.intValue();
        String str8 = (String) objArr[23];
        String str9 = (String) objArr[24];
        String str10 = (String) objArr[25];
        Integer num12 = (Integer) objArr[26];
        return new DLCDetailModel(intValue, intValue2, intValue3, intValue4, intValue5, intValue6, intValue7, intValue8, str, str2, str3, str4, longValue, intValue9, booleanValue, str5, str6, str7, list, booleanValue2, intValue10, booleanValue3, intValue11, str8, str9, str10, num12 != null ? num12.intValue() : 0);
    }

    public Object get(Object obj, int i) {
        DLCDetailModel dLCDetailModel = (DLCDetailModel) obj;
        switch (i) {
            case 0:
                return Integer.valueOf(dLCDetailModel.getActivityId());
            case 1:
                return Integer.valueOf(dLCDetailModel.getCallbackId());
            case 2:
                return Integer.valueOf(dLCDetailModel.getType());
            case 3:
                return Integer.valueOf(dLCDetailModel.getScreenType());
            case 4:
                return Integer.valueOf(dLCDetailModel.getHasDrawCardAnimation());
            case 5:
                return Integer.valueOf(dLCDetailModel.getHasCardAnimation());
            case 6:
                return Integer.valueOf(dLCDetailModel.getShareType());
            case 7:
                return Integer.valueOf(dLCDetailModel.getJumpId());
            case 8:
                return dLCDetailModel.getHorizontalCardLightUrl();
            case 9:
                return dLCDetailModel.getHorizontalCardShadowUrl();
            case 10:
                return dLCDetailModel.getVerticalCardLightUrl();
            case 11:
                return dLCDetailModel.getVerticalCardShadowUrl();
            case 12:
                return Long.valueOf(dLCDetailModel.getMid());
            case 13:
                return Integer.valueOf(dLCDetailModel.getTotalCnt());
            case 14:
                return Boolean.valueOf(dLCDetailModel.getNotOnSale());
            case 15:
                return dLCDetailModel.getHolderListUrl();
            case 16:
                return dLCDetailModel.getActHomepageurl();
            case 17:
                return dLCDetailModel.getSpaceBgSetUrl();
            case 18:
                return dLCDetailModel.getCardList();
            case 19:
                return Boolean.valueOf(dLCDetailModel.isBooked());
            case 20:
                return Integer.valueOf(dLCDetailModel.getCanDonate());
            case 21:
                return Boolean.valueOf(dLCDetailModel.getCanSaveImage());
            case 22:
                return Integer.valueOf(dLCDetailModel.getUpChain());
            case 23:
                return dLCDetailModel.getFromWhere();
            case 24:
                return dLCDetailModel.getFromId();
            case BR.avatarList /* 25 */:
                return dLCDetailModel.getFSource();
            case BR.avatarListVisible /* 26 */:
                return Integer.valueOf(dLCDetailModel.getPageType());
            default:
                return null;
        }
    }
}