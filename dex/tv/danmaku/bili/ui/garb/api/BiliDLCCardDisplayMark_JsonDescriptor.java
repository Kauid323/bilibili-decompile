package tv.danmaku.bili.ui.garb.api;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;

public final class BiliDLCCardDisplayMark_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public BiliDLCCardDisplayMark_JsonDescriptor() {
        super(BiliDLCCardDisplayMark.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("img_url", (String[]) null, String.class, (Class) null, 5)};
    }

    public Object constructWith(Object[] objArr) {
        return new BiliDLCCardDisplayMark((String) objArr[0]);
    }

    public Object get(Object obj, int i) {
        BiliDLCCardDisplayMark biliDLCCardDisplayMark = (BiliDLCCardDisplayMark) obj;
        switch (i) {
            case 0:
                return biliDLCCardDisplayMark.getImg();
            default:
                return null;
        }
    }
}