package tv.danmaku.bili.fullscreen.data;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;
import tv.danmaku.bili.fullscreen.CountryCodeSelectActivity;

public final class PhoneCountryCode_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public PhoneCountryCode_JsonDescriptor() {
        super(PhoneCountryCode.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("cname", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor(CountryCodeSelectActivity.KEY_COUNTRY_CODE, (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("id", (String[]) null, Long.TYPE, (Class) null, 7)};
    }

    public Object constructWith(Object[] objArr) {
        String str = (String) objArr[0];
        String str2 = (String) objArr[1];
        Object obj = objArr[2];
        int i = obj == null ? 4 : 0;
        Long l = (Long) obj;
        return new PhoneCountryCode(str, str2, l == null ? 0L : l.longValue(), i, null);
    }

    public Object get(Object obj, int i) {
        PhoneCountryCode phoneCountryCode = (PhoneCountryCode) obj;
        switch (i) {
            case 0:
                return phoneCountryCode.getName();
            case 1:
                return phoneCountryCode.getCountryCode();
            case 2:
                return Long.valueOf(phoneCountryCode.getId());
            default:
                return null;
        }
    }
}