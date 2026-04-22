package tv.danmaku.bili.ui.garb.api;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.ui.garb.nft.model.DLCPlayModel;
import tv.danmaku.bili.ui.garb.nft.model.DLCTagModel;

public final class BiliDLCCardItem_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public BiliDLCCardItem_JsonDescriptor() {
        super(BiliDLCCardItem.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("card_type_info", (String[]) null, CardTypeInfo.class, (Class) null, 5), new PojoPropertyDescriptor("card_chance", (String[]) null, Float.TYPE, (Class) null, 5), new PojoPropertyDescriptor("card_info", (String[]) null, CardInfo.class, (Class) null, 5), new PojoPropertyDescriptor("card_type_cnt", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("card_type_cnt_show", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("play", (String[]) null, DLCPlayModel.class, (Class) null, 5), new PojoPropertyDescriptor(AppConfig.HOST_TAG, (String[]) null, DLCTagModel.class, (Class) null, 5)};
    }

    public Object constructWith(Object[] objArr) {
        CardTypeInfo cardTypeInfo = (CardTypeInfo) objArr[0];
        Float f = (Float) objArr[1];
        float floatValue = f == null ? 0.0f : f.floatValue();
        CardInfo cardInfo = (CardInfo) objArr[2];
        Integer num = (Integer) objArr[3];
        return new BiliDLCCardItem(cardTypeInfo, floatValue, cardInfo, num != null ? num.intValue() : 0, (String) objArr[4], (DLCPlayModel) objArr[5], (DLCTagModel) objArr[6]);
    }

    public Object get(Object obj, int i) {
        BiliDLCCardItem biliDLCCardItem = (BiliDLCCardItem) obj;
        switch (i) {
            case 0:
                return biliDLCCardItem.getCardTypeInfo();
            case 1:
                return Float.valueOf(biliDLCCardItem.getCardChance());
            case 2:
                return biliDLCCardItem.getCardInfo();
            case 3:
                return Integer.valueOf(biliDLCCardItem.getCardTypeCnt());
            case 4:
                return biliDLCCardItem.getCardTypeCntShow();
            case 5:
                return biliDLCCardItem.getPlay();
            case 6:
                return biliDLCCardItem.getTag();
            default:
                return null;
        }
    }
}