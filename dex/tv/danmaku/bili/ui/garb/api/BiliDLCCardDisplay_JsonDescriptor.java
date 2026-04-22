package tv.danmaku.bili.ui.garb.api;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;

public final class BiliDLCCardDisplay_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public BiliDLCCardDisplay_JsonDescriptor() {
        super(BiliDLCCardDisplay.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("corner_mark", (String[]) null, BiliDLCCardDisplayMark.class, (Class) null, 5), new PojoPropertyDescriptor("frame", (String[]) null, BiliDLCCardDisplayFrame.class, (Class) null, 5)};
    }

    public Object constructWith(Object[] objArr) {
        return new BiliDLCCardDisplay((BiliDLCCardDisplayMark) objArr[0], (BiliDLCCardDisplayFrame) objArr[1]);
    }

    public Object get(Object obj, int i) {
        BiliDLCCardDisplay biliDLCCardDisplay = (BiliDLCCardDisplay) obj;
        switch (i) {
            case 0:
                return biliDLCCardDisplay.getCornerMark();
            case 1:
                return biliDLCCardDisplay.getFrame();
            default:
                return null;
        }
    }
}