package tv.danmaku.bili.ui.garb.nft.model;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;

public final class DLCTagModel_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public DLCTagModel_JsonDescriptor() {
        super(DLCTagModel.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("image_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("content", (String[]) null, String.class, (Class) null, 5)};
    }

    public Object constructWith(Object[] objArr) {
        return new DLCTagModel((String) objArr[0], (String) objArr[1]);
    }

    public Object get(Object obj, int i) {
        DLCTagModel dLCTagModel = (DLCTagModel) obj;
        switch (i) {
            case 0:
                return dLCTagModel.getImageUrl();
            case 1:
                return dLCTagModel.getContent();
            default:
                return null;
        }
    }
}