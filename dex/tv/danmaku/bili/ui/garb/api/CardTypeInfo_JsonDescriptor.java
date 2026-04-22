package tv.danmaku.bili.ui.garb.api;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;
import tv.danmaku.bili.router.ChannelRoutes;

public final class CardTypeInfo_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public CardTypeInfo_JsonDescriptor() {
        super(CardTypeInfo.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("id", (String[]) null, Long.TYPE, (Class) null, 5), new PojoPropertyDescriptor(ChannelRoutes.CHANNEL_NAME, (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("overview_image", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("content", (String[]) null, Content.class, (Class) null, 5), new PojoPropertyDescriptor("material_type", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("theme", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("item_scarcity", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("layout", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("width", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("height", (String[]) null, Integer.TYPE, (Class) null, 5)};
    }

    public Object constructWith(Object[] objArr) {
        Long l = (Long) objArr[0];
        long longValue = l == null ? 0L : l.longValue();
        String str = (String) objArr[1];
        String str2 = (String) objArr[2];
        Content content = (Content) objArr[3];
        Integer num = (Integer) objArr[4];
        int intValue = num == null ? 0 : num.intValue();
        String str3 = (String) objArr[5];
        Integer num2 = (Integer) objArr[6];
        int intValue2 = num2 == null ? 0 : num2.intValue();
        Integer num3 = (Integer) objArr[7];
        int intValue3 = num3 == null ? 0 : num3.intValue();
        Integer num4 = (Integer) objArr[8];
        int intValue4 = num4 == null ? 0 : num4.intValue();
        Integer num5 = (Integer) objArr[9];
        return new CardTypeInfo(longValue, str, str2, content, intValue, str3, intValue2, intValue3, intValue4, num5 == null ? 0 : num5.intValue());
    }

    public Object get(Object obj, int i) {
        CardTypeInfo cardTypeInfo = (CardTypeInfo) obj;
        switch (i) {
            case 0:
                return Long.valueOf(cardTypeInfo.getId());
            case 1:
                return cardTypeInfo.getName();
            case 2:
                return cardTypeInfo.getOverviewImage();
            case 3:
                return cardTypeInfo.getContent();
            case 4:
                return Integer.valueOf(cardTypeInfo.getMaterialType());
            case 5:
                return cardTypeInfo.getTheme();
            case 6:
                return Integer.valueOf(cardTypeInfo.getScarcity());
            case 7:
                return Integer.valueOf(cardTypeInfo.getLayout());
            case 8:
                return Integer.valueOf(cardTypeInfo.getWidth());
            case 9:
                return Integer.valueOf(cardTypeInfo.getHeight());
            default:
                return null;
        }
    }
}