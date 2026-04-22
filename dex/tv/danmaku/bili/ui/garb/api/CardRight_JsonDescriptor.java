package tv.danmaku.bili.ui.garb.api;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;

public final class CardRight_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public CardRight_JsonDescriptor() {
        super(CardRight.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("head_pic_expire", (String[]) null, Long.TYPE, (Class) null, 5), new PojoPropertyDescriptor("banner_bg_expire", (String[]) null, Long.TYPE, (Class) null, 5)};
    }

    public Object constructWith(Object[] objArr) {
        Long l = (Long) objArr[0];
        long longValue = l == null ? 0L : l.longValue();
        Long l2 = (Long) objArr[1];
        return new CardRight(longValue, l2 != null ? l2.longValue() : 0L);
    }

    public Object get(Object obj, int i) {
        long headPicExpire;
        CardRight cardRight = (CardRight) obj;
        switch (i) {
            case 0:
                headPicExpire = cardRight.getHeadPicExpire();
                break;
            case 1:
                headPicExpire = cardRight.getBannerBgExpire();
                break;
            default:
                return null;
        }
        return Long.valueOf(headPicExpire);
    }
}