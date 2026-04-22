package tv.danmaku.bili.ui.garb.nft.model;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;
import tv.danmaku.bili.cb.AuthResultCbHelper;

public final class DLCCardDrawModel_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public DLCCardDrawModel_JsonDescriptor() {
        super(DLCCardDrawModel.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor(AuthResultCbHelper.ARGS_CALLBACK, (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("screen_type", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("has_draw_ani", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("has_card_ani", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("act_id", (String[]) null, Long.TYPE, (Class) null, 5), new PojoPropertyDescriptor("activity_status", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("lottery_id", (String[]) null, Long.TYPE, (Class) null, 5), new PojoPropertyDescriptor("lottery_num", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("biz_info", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("jump_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("animation_draw_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("animation_entry_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("horizontal_card_light_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("vertical_card_light_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("horizontal_card_shadow_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("vertical_card_shadow_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("holder_list_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("is_can_donate", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("is_up_chain", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("share_type", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("from", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("from_id", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("f_source", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("page_type", (String[]) null, Integer.TYPE, (Class) null, 5)};
    }

    public Object constructWith(Object[] objArr) {
        String str = (String) objArr[0];
        Integer num = (Integer) objArr[1];
        int intValue = num == null ? 0 : num.intValue();
        Integer num2 = (Integer) objArr[2];
        int intValue2 = num2 == null ? 0 : num2.intValue();
        Integer num3 = (Integer) objArr[3];
        int intValue3 = num3 == null ? 0 : num3.intValue();
        Long l = (Long) objArr[4];
        long longValue = l == null ? 0L : l.longValue();
        Integer num4 = (Integer) objArr[5];
        int intValue4 = num4 == null ? 0 : num4.intValue();
        Long l2 = (Long) objArr[6];
        long longValue2 = l2 == null ? 0L : l2.longValue();
        Integer num5 = (Integer) objArr[7];
        int intValue5 = num5 == null ? 0 : num5.intValue();
        String str2 = (String) objArr[8];
        String str3 = (String) objArr[9];
        String str4 = (String) objArr[10];
        String str5 = (String) objArr[11];
        String str6 = (String) objArr[12];
        String str7 = (String) objArr[13];
        String str8 = (String) objArr[14];
        String str9 = (String) objArr[15];
        String str10 = (String) objArr[16];
        Integer num6 = (Integer) objArr[17];
        int intValue6 = num6 == null ? 0 : num6.intValue();
        Integer num7 = (Integer) objArr[18];
        int intValue7 = num7 == null ? 0 : num7.intValue();
        Integer num8 = (Integer) objArr[19];
        int intValue8 = num8 == null ? 0 : num8.intValue();
        String str11 = (String) objArr[20];
        String str12 = (String) objArr[21];
        String str13 = (String) objArr[22];
        Integer num9 = (Integer) objArr[23];
        return new DLCCardDrawModel(str, intValue, intValue2, intValue3, longValue, intValue4, longValue2, intValue5, str2, str3, str4, str5, str6, str7, str8, str9, str10, intValue6, intValue7, intValue8, str11, str12, str13, num9 != null ? num9.intValue() : 0);
    }

    public Object get(Object obj, int i) {
        DLCCardDrawModel dLCCardDrawModel = (DLCCardDrawModel) obj;
        switch (i) {
            case 0:
                return dLCCardDrawModel.getCallbackId();
            case 1:
                return Integer.valueOf(dLCCardDrawModel.getScreenType());
            case 2:
                return Integer.valueOf(dLCCardDrawModel.getHasDrawCardAnimation());
            case 3:
                return Integer.valueOf(dLCCardDrawModel.getHasCardAnimation());
            case 4:
                return Long.valueOf(dLCCardDrawModel.getActId());
            case 5:
                return Integer.valueOf(dLCCardDrawModel.getActivityStatus());
            case 6:
                return Long.valueOf(dLCCardDrawModel.getLotteryId());
            case 7:
                return Integer.valueOf(dLCCardDrawModel.getLotteryNum());
            case 8:
                return dLCCardDrawModel.getBizInfo();
            case 9:
                return dLCCardDrawModel.getJumpUrl();
            case 10:
                return dLCCardDrawModel.getAnimDrawUrl();
            case 11:
                return dLCCardDrawModel.getAnimEntryUrl();
            case 12:
                return dLCCardDrawModel.getHorizontalCardLightUrl();
            case 13:
                return dLCCardDrawModel.getVerticalCardLightUrl();
            case 14:
                return dLCCardDrawModel.getHorizontalCardShadowUrl();
            case 15:
                return dLCCardDrawModel.getVerticalCardShadowUrl();
            case 16:
                return dLCCardDrawModel.getHolderListUrl();
            case 17:
                return Integer.valueOf(dLCCardDrawModel.getCanDonate());
            case 18:
                return Integer.valueOf(dLCCardDrawModel.getUpChain());
            case 19:
                return Integer.valueOf(dLCCardDrawModel.getShareType());
            case 20:
                return dLCCardDrawModel.getFromWhere();
            case 21:
                return dLCCardDrawModel.getFromId();
            case 22:
                return dLCCardDrawModel.getFSource();
            case 23:
                return Integer.valueOf(dLCCardDrawModel.getPageType());
            default:
                return null;
        }
    }
}