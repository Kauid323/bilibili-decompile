package tv.danmaku.bili.ui.garb.nft.model;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;
import tv.danmaku.bili.BR;

public final class CardShareInfo_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public CardShareInfo_JsonDescriptor() {
        super(CardShareInfo.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("image_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("card_name", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("card_tag", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("card_id", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("card_type_id", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("material_type", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("left_top_tag_img", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("frame_img", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("smelt_tag", (String[]) null, String.class, (Class) null, 7)};
    }

    public Object constructWith(Object[] objArr) {
        String str = (String) objArr[0];
        String str2 = (String) objArr[1];
        String str3 = (String) objArr[2];
        String str4 = (String) objArr[3];
        String str5 = (String) objArr[4];
        String str6 = (String) objArr[5];
        String str7 = (String) objArr[6];
        String str8 = (String) objArr[7];
        Object obj = objArr[8];
        return new CardShareInfo(str, str2, str3, str4, str5, str6, str7, str8, (String) obj, obj == null ? BR.hallEnterHotText : 0, null);
    }

    public Object get(Object obj, int i) {
        CardShareInfo cardShareInfo = (CardShareInfo) obj;
        switch (i) {
            case 0:
                return cardShareInfo.getImageUrl();
            case 1:
                return cardShareInfo.getCardName();
            case 2:
                return cardShareInfo.getCardTag();
            case 3:
                return cardShareInfo.getCardId();
            case 4:
                return cardShareInfo.getCardTypeId();
            case 5:
                return cardShareInfo.getMaterialType();
            case 6:
                return cardShareInfo.getTagImg();
            case 7:
                return cardShareInfo.getFrameImg();
            case 8:
                return cardShareInfo.getSmeltTag();
            default:
                return null;
        }
    }
}