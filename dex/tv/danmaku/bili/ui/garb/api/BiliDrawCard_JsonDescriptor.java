package tv.danmaku.bili.ui.garb.api;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;

public final class BiliDrawCard_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public BiliDrawCard_JsonDescriptor() {
        super(BiliDrawCard.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("err_code", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("err_message", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("card_type_id", (String[]) null, Long.TYPE, (Class) null, 5), new PojoPropertyDescriptor("left_chance", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("card_type_info", (String[]) null, CardTypeInfo.class, (Class) null, 5), new PojoPropertyDescriptor("card_type_cnt_show", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("card_info", (String[]) null, CardInfo.class, (Class) null, 5), new PojoPropertyDescriptor("card_chance", (String[]) null, Float.TYPE, (Class) null, 5), new PojoPropertyDescriptor("is_req_detail", (String[]) null, Integer.TYPE, (Class) null, 5)};
    }

    public Object constructWith(Object[] objArr) {
        Integer num = (Integer) objArr[0];
        int intValue = num == null ? 0 : num.intValue();
        String str = (String) objArr[1];
        Long l = (Long) objArr[2];
        long longValue = l == null ? 0L : l.longValue();
        Integer num2 = (Integer) objArr[3];
        int intValue2 = num2 == null ? 0 : num2.intValue();
        CardTypeInfo cardTypeInfo = (CardTypeInfo) objArr[4];
        String str2 = (String) objArr[5];
        CardInfo cardInfo = (CardInfo) objArr[6];
        Float f = (Float) objArr[7];
        float floatValue = f == null ? 0.0f : f.floatValue();
        Integer num3 = (Integer) objArr[8];
        return new BiliDrawCard(intValue, str, longValue, intValue2, cardTypeInfo, str2, cardInfo, floatValue, num3 == null ? 0 : num3.intValue());
    }

    public Object get(Object obj, int i) {
        BiliDrawCard biliDrawCard = (BiliDrawCard) obj;
        switch (i) {
            case 0:
                return Integer.valueOf(biliDrawCard.getErrCode());
            case 1:
                return biliDrawCard.getErrMessage();
            case 2:
                return Long.valueOf(biliDrawCard.getCardTypeId());
            case 3:
                return Integer.valueOf(biliDrawCard.getLeftChance());
            case 4:
                return biliDrawCard.getCardTypeInfo();
            case 5:
                return biliDrawCard.getTotalCountShow();
            case 6:
                return biliDrawCard.getCardInfo();
            case 7:
                return Float.valueOf(biliDrawCard.getCardChance());
            case 8:
                return Integer.valueOf(biliDrawCard.getNeedRequest());
            default:
                return null;
        }
    }
}