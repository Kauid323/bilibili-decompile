package tv.danmaku.bili.fullscreen.data;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;
import com.bilibili.bson.common.Types;
import java.lang.reflect.Type;
import java.util.List;
import tv.danmaku.bili.ui.main2.reporter.MineReporter;

public final class AvailableCountryCode_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public AvailableCountryCode_JsonDescriptor() {
        super(AvailableCountryCode.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor(MineReporter.MINE_ICON_TYPE_DEFAULT, (String[]) null, PhoneCountryCode.class, (Class) null, 7), new PojoPropertyDescriptor("list", (String[]) null, Types.parameterizedType(List.class, new Type[]{PhoneCountryCode.class}), (Class) null, 23)};
    }

    public Object constructWith(Object[] objArr) {
        Object obj = objArr[0];
        int i = obj == null ? 1 : 0;
        PhoneCountryCode phoneCountryCode = (PhoneCountryCode) obj;
        Object obj2 = objArr[1];
        if (obj2 == null) {
            i |= 2;
        }
        return new AvailableCountryCode(phoneCountryCode, (List) obj2, i, null);
    }

    public Object get(Object obj, int i) {
        AvailableCountryCode availableCountryCode = (AvailableCountryCode) obj;
        switch (i) {
            case 0:
                return availableCountryCode.getDefaultCountry();
            case 1:
                return availableCountryCode.getList();
            default:
                return null;
        }
    }
}