package tv.danmaku.bili.ui.garb.api.collection;

import com.bili.digital.common.data.SpaceBannerItem;
import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;
import com.bilibili.bson.common.Types;
import java.lang.reflect.Type;
import java.util.List;
import tv.danmaku.bili.ui.login.LoginReporterV2;

public final class BiliCollectionAllData_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public BiliCollectionAllData_JsonDescriptor() {
        super(BiliCollectionAllData.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("result", (String[]) null, Types.parameterizedType(List.class, new Type[]{SpaceBannerItem.class}), (Class) null, 22), new PojoPropertyDescriptor(LoginReporterV2.PAGE_FROM_KEY, (String[]) null, BiliCollectionPageData.class, (Class) null, 6), new PojoPropertyDescriptor("total", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("all", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("collection_public", (String[]) null, Boolean.TYPE, (Class) null, 5)};
    }

    public Object constructWith(Object[] objArr) {
        Object obj = objArr[0];
        int i = obj == null ? 1 : 0;
        List list = (List) obj;
        Object obj2 = objArr[1];
        if (obj2 == null) {
            i |= 2;
        }
        int i2 = i;
        BiliCollectionPageData biliCollectionPageData = (BiliCollectionPageData) obj2;
        Integer num = (Integer) objArr[2];
        int intValue = num == null ? 0 : num.intValue();
        Integer num2 = (Integer) objArr[3];
        int intValue2 = num2 == null ? 0 : num2.intValue();
        Boolean bool = (Boolean) objArr[4];
        return new BiliCollectionAllData(list, biliCollectionPageData, intValue, intValue2, bool == null ? false : bool.booleanValue(), i2, null);
    }

    public Object get(Object obj, int i) {
        BiliCollectionAllData biliCollectionAllData = (BiliCollectionAllData) obj;
        switch (i) {
            case 0:
                return biliCollectionAllData.getResult();
            case 1:
                return biliCollectionAllData.getPage();
            case 2:
                return Integer.valueOf(biliCollectionAllData.getTotal());
            case 3:
                return Integer.valueOf(biliCollectionAllData.getAll());
            case 4:
                return Boolean.valueOf(biliCollectionAllData.getCollectionPublic());
            default:
                return null;
        }
    }
}