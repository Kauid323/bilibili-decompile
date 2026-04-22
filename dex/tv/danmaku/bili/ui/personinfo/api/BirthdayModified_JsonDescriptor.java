package tv.danmaku.bili.ui.personinfo.api;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;

public final class BirthdayModified_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public BirthdayModified_JsonDescriptor() {
        super(BirthdayModified.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("changed", (String[]) null, Boolean.TYPE, (Class) null, 7)};
    }

    public Object constructWith(Object[] objArr) {
        Object obj = objArr[0];
        int i = obj == null ? 1 : 0;
        Boolean bool = (Boolean) obj;
        return new BirthdayModified(bool != null ? bool.booleanValue() : false, i, null);
    }

    public Object get(Object obj, int i) {
        BirthdayModified birthdayModified = (BirthdayModified) obj;
        switch (i) {
            case 0:
                return Boolean.valueOf(birthdayModified.getChanged());
            default:
                return null;
        }
    }
}