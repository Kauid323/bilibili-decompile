package tv.danmaku.bili.ui.garb.nft.model;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;

public final class DLCSplashCardInfo_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public DLCSplashCardInfo_JsonDescriptor() {
        super(DLCSplashCardInfo.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("result", (String[]) null, String.class, (Class) null, 1)};
    }

    public Object constructWith(Object[] objArr) {
        return new DLCSplashCardInfo((String) objArr[0]);
    }

    public Object get(Object obj, int i) {
        DLCSplashCardInfo dLCSplashCardInfo = (DLCSplashCardInfo) obj;
        switch (i) {
            case 0:
                return dLCSplashCardInfo.getResult();
            default:
                return null;
        }
    }
}