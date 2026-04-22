package tv.danmaku.bili.ui.garb.api.collection;

import com.bili.digital.common.data.BiliCollectionPreferenceData;
import com.bili.digital.common.data.SpaceBannerTop;
import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;

public final class BiliCollectionData_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public BiliCollectionData_JsonDescriptor() {
        super(BiliCollectionData.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("preference", (String[]) null, BiliCollectionPreferenceData.class, (Class) null, 6), new PojoPropertyDescriptor("all", (String[]) null, BiliCollectionAllData.class, (Class) null, 6), new PojoPropertyDescriptor("top", (String[]) null, SpaceBannerTop.class, (Class) null, 6), new PojoPropertyDescriptor("global_info", (String[]) null, BiliCollectionGlobalInfoData.class, (Class) null, 6), new PojoPropertyDescriptor("user_info", (String[]) null, BiliCollectionUserData.class, (Class) null, 6)};
    }

    public Object constructWith(Object[] objArr) {
        Object obj = objArr[0];
        int i = obj == null ? 1 : 0;
        BiliCollectionPreferenceData biliCollectionPreferenceData = (BiliCollectionPreferenceData) obj;
        Object obj2 = objArr[1];
        if (obj2 == null) {
            i |= 2;
        }
        BiliCollectionAllData biliCollectionAllData = (BiliCollectionAllData) obj2;
        Object obj3 = objArr[2];
        if (obj3 == null) {
            i |= 4;
        }
        SpaceBannerTop spaceBannerTop = (SpaceBannerTop) obj3;
        Object obj4 = objArr[3];
        if (obj4 == null) {
            i |= 8;
        }
        BiliCollectionGlobalInfoData biliCollectionGlobalInfoData = (BiliCollectionGlobalInfoData) obj4;
        Object obj5 = objArr[4];
        if (obj5 == null) {
            i |= 16;
        }
        return new BiliCollectionData(biliCollectionPreferenceData, biliCollectionAllData, spaceBannerTop, biliCollectionGlobalInfoData, (BiliCollectionUserData) obj5, i, null);
    }

    public Object get(Object obj, int i) {
        BiliCollectionData biliCollectionData = (BiliCollectionData) obj;
        switch (i) {
            case 0:
                return biliCollectionData.getPreference();
            case 1:
                return biliCollectionData.getAll();
            case 2:
                return biliCollectionData.getTop();
            case 3:
                return biliCollectionData.getGlobalInfo();
            case 4:
                return biliCollectionData.getUserInfo();
            default:
                return null;
        }
    }
}