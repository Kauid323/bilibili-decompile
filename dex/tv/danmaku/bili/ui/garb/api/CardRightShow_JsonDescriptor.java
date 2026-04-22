package tv.danmaku.bili.ui.garb.api;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;
import com.bilibili.bson.common.Types;
import java.lang.reflect.Type;
import java.util.List;

public final class CardRightShow_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public CardRightShow_JsonDescriptor() {
        super(CardRightShow.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("is_head_pic", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("is_banner_bg", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("head_tag_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("banner_tag_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("head_pic_toast", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("banner_bg_toast", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("head_expire_format", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("banner_expire_format", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("use_tag_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("use_toast", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("number_menus", (String[]) null, Types.parameterizedType(List.class, new Type[]{UseMenu.class}), (Class) null, 21)};
    }

    public Object constructWith(Object[] objArr) {
        Integer num = (Integer) objArr[0];
        int intValue = num == null ? 0 : num.intValue();
        Integer num2 = (Integer) objArr[1];
        return new CardRightShow(intValue, num2 != null ? num2.intValue() : 0, (String) objArr[2], (String) objArr[3], (String) objArr[4], (String) objArr[5], (String) objArr[6], (String) objArr[7], (String) objArr[8], (String) objArr[9], (List) objArr[10]);
    }

    public Object get(Object obj, int i) {
        int isHeadPic;
        CardRightShow cardRightShow = (CardRightShow) obj;
        switch (i) {
            case 0:
                isHeadPic = cardRightShow.isHeadPic();
                break;
            case 1:
                isHeadPic = cardRightShow.isBannerBg();
                break;
            case 2:
                return cardRightShow.getHeadTagUrl();
            case 3:
                return cardRightShow.getBannerTagUrl();
            case 4:
                return cardRightShow.getHeadPicToast();
            case 5:
                return cardRightShow.getBannerBgToast();
            case 6:
                return cardRightShow.getHeadExpireFormat();
            case 7:
                return cardRightShow.getBannerExpireFormat();
            case 8:
                return cardRightShow.getUseTagUrl();
            case 9:
                return cardRightShow.getUseToast();
            case 10:
                return cardRightShow.getUseMenus();
            default:
                return null;
        }
        return Integer.valueOf(isHeadPic);
    }
}