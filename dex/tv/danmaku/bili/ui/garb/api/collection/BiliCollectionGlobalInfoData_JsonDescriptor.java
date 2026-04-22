package tv.danmaku.bili.ui.garb.api.collection;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;

public final class BiliCollectionGlobalInfoData_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public BiliCollectionGlobalInfoData_JsonDescriptor() {
        super(BiliCollectionGlobalInfoData.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("collection_background_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("collection_completed_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("sidebar_info", (String[]) null, BiliCollectionGlobalInfoSideBarData.class, (Class) null, 6), new PojoPropertyDescriptor("max_sort_num", (String[]) null, Integer.TYPE, (Class) null, 5)};
    }

    public Object constructWith(Object[] objArr) {
        String str = (String) objArr[0];
        String str2 = (String) objArr[1];
        Object obj = objArr[2];
        int i = obj == null ? 4 : 0;
        BiliCollectionGlobalInfoSideBarData biliCollectionGlobalInfoSideBarData = (BiliCollectionGlobalInfoSideBarData) obj;
        Integer num = (Integer) objArr[3];
        return new BiliCollectionGlobalInfoData(str, str2, biliCollectionGlobalInfoSideBarData, num == null ? 0 : num.intValue(), i, null);
    }

    public Object get(Object obj, int i) {
        BiliCollectionGlobalInfoData biliCollectionGlobalInfoData = (BiliCollectionGlobalInfoData) obj;
        switch (i) {
            case 0:
                return biliCollectionGlobalInfoData.getCollectionBackgroundUrl();
            case 1:
                return biliCollectionGlobalInfoData.getCollectionCompletedUrl();
            case 2:
                return biliCollectionGlobalInfoData.getSidebarInfo();
            case 3:
                return Integer.valueOf(biliCollectionGlobalInfoData.getMaxSortNum());
            default:
                return null;
        }
    }
}