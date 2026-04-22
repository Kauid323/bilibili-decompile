package tv.danmaku.bili.ui.garb;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;
import com.bilibili.bson.common.Types;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import tv.danmaku.bili.push.innerpush.v2.InnerPushReceiverKt;

public final class NftCardModel_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public NftCardModel_JsonDescriptor() {
        super(NftCardModel.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("type", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("jump_id", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("not_on_sale", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("round_id", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("act_id", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("book_x", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("book_y", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor(InnerPushReceiverKt.KEY_EXTRA, (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("card_list", (String[]) null, Types.parameterizedType(ArrayList.class, new Type[]{NftCardDetailModel.class}), (Class) null, 5), new PojoPropertyDescriptor("draw_count", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("animation_draw_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("animation_result_url", (String[]) null, Types.parameterizedType(HashMap.class, new Type[]{String.class, String.class}), (Class) null, 5), new PojoPropertyDescriptor("is_booked", (String[]) null, Boolean.TYPE, (Class) null, 5), new PojoPropertyDescriptor("is_overtime", (String[]) null, Boolean.TYPE, (Class) null, 5), new PojoPropertyDescriptor("mid", (String[]) null, Long.TYPE, (Class) null, 5), new PojoPropertyDescriptor("from", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("from_id", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("f_source", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("source_type", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("space_bg_set_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("horizontal_card_light_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("vertical_card_light_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("horizontal_card_shadow_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("vertical_card_shadow_url", (String[]) null, String.class, (Class) null, 5)};
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
        String str = (String) objArr[7];
        ArrayList arrayList = (ArrayList) objArr[8];
        Integer num8 = (Integer) objArr[9];
        int intValue8 = num8 == null ? 0 : num8.intValue();
        String str2 = (String) objArr[10];
        HashMap hashMap = (HashMap) objArr[11];
        Boolean bool = (Boolean) objArr[12];
        boolean booleanValue = bool == null ? false : bool.booleanValue();
        Boolean bool2 = (Boolean) objArr[13];
        boolean booleanValue2 = bool2 == null ? false : bool2.booleanValue();
        Long l = (Long) objArr[14];
        long longValue = l == null ? 0L : l.longValue();
        String str3 = (String) objArr[15];
        String str4 = (String) objArr[16];
        String str5 = (String) objArr[17];
        Integer num9 = (Integer) objArr[18];
        return new NftCardModel(intValue, intValue2, intValue3, intValue4, intValue5, intValue6, intValue7, str, arrayList, intValue8, str2, hashMap, booleanValue, booleanValue2, longValue, str3, str4, str5, num9 != null ? num9.intValue() : 0, (String) objArr[19], (String) objArr[20], (String) objArr[21], (String) objArr[22], (String) objArr[23]);
    }

    public Object get(Object obj, int i) {
        NftCardModel nftCardModel = (NftCardModel) obj;
        switch (i) {
            case 0:
                return Integer.valueOf(nftCardModel.getType());
            case 1:
                return Integer.valueOf(nftCardModel.getJumpId());
            case 2:
                return Integer.valueOf(nftCardModel.getNotOnSale());
            case 3:
                return Integer.valueOf(nftCardModel.getRoundId());
            case 4:
                return Integer.valueOf(nftCardModel.getActId());
            case 5:
                return Integer.valueOf(nftCardModel.getBookX());
            case 6:
                return Integer.valueOf(nftCardModel.getBookY());
            case 7:
                return nftCardModel.getExtra();
            case 8:
                return nftCardModel.getCardList();
            case 9:
                return Integer.valueOf(nftCardModel.getDrawCount());
            case 10:
                return nftCardModel.getAnimationDrawUrl();
            case 11:
                return nftCardModel.getAnimationResultUrl();
            case 12:
                return Boolean.valueOf(nftCardModel.getBooked());
            case 13:
                return Boolean.valueOf(nftCardModel.getOvertime());
            case 14:
                return Long.valueOf(nftCardModel.getMid());
            case 15:
                return nftCardModel.getFromWhere();
            case 16:
                return nftCardModel.getFromId();
            case 17:
                return nftCardModel.getFSource();
            case 18:
                return Integer.valueOf(nftCardModel.getSourceType());
            case 19:
                return nftCardModel.getSpaceBgSetUrl();
            case 20:
                return nftCardModel.getHCardLightUrl();
            case 21:
                return nftCardModel.getVCardLightUrl();
            case 22:
                return nftCardModel.getHCardShadowUrl();
            case 23:
                return nftCardModel.getVCardShadowUrl();
            default:
                return null;
        }
    }
}