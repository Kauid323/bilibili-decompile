package tv.danmaku.bili.ui.garb.api.collection;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;

public final class BiliCollectionPageData_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public BiliCollectionPageData_JsonDescriptor() {
        super(BiliCollectionPageData.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("ps", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("has_more", (String[]) null, Boolean.TYPE, (Class) null, 5), new PojoPropertyDescriptor("last_id", (String[]) null, Long.TYPE, (Class) null, 5), new PojoPropertyDescriptor("last_type", (String[]) null, Integer.TYPE, (Class) null, 5)};
    }

    public Object constructWith(Object[] objArr) {
        Integer num = (Integer) objArr[0];
        int intValue = num == null ? 0 : num.intValue();
        Boolean bool = (Boolean) objArr[1];
        boolean booleanValue = bool == null ? false : bool.booleanValue();
        Long l = (Long) objArr[2];
        long longValue = l == null ? 0L : l.longValue();
        Integer num2 = (Integer) objArr[3];
        return new BiliCollectionPageData(intValue, booleanValue, longValue, num2 == null ? 0 : num2.intValue());
    }

    public Object get(Object obj, int i) {
        BiliCollectionPageData biliCollectionPageData = (BiliCollectionPageData) obj;
        switch (i) {
            case 0:
                return Integer.valueOf(biliCollectionPageData.getPs());
            case 1:
                return Boolean.valueOf(biliCollectionPageData.getHasMore());
            case 2:
                return Long.valueOf(biliCollectionPageData.getLastId());
            case 3:
                return Integer.valueOf(biliCollectionPageData.getLastType());
            default:
                return null;
        }
    }
}