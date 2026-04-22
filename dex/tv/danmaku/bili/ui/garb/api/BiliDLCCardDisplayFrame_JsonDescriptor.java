package tv.danmaku.bili.ui.garb.api;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;

public final class BiliDLCCardDisplayFrame_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public BiliDLCCardDisplayFrame_JsonDescriptor() {
        super(BiliDLCCardDisplayFrame.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("img_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("small_img_url", (String[]) null, String.class, (Class) null, 5)};
    }

    public Object constructWith(Object[] objArr) {
        return new BiliDLCCardDisplayFrame((String) objArr[0], (String) objArr[1]);
    }

    public Object get(Object obj, int i) {
        BiliDLCCardDisplayFrame biliDLCCardDisplayFrame = (BiliDLCCardDisplayFrame) obj;
        switch (i) {
            case 0:
                return biliDLCCardDisplayFrame.getImg();
            case 1:
                return biliDLCCardDisplayFrame.getImgSmall();
            default:
                return null;
        }
    }
}