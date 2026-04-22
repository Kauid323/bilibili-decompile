package tv.danmaku.bili.ui.garb.api;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;
import tv.danmaku.bili.ui.garb.api.WebCard;

public final class WebCard_SmeltTag_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public WebCard_SmeltTag_JsonDescriptor() {
        super(WebCard.SmeltTag.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("image", (String[]) null, String.class, (Class) null, 5)};
    }

    public Object constructWith(Object[] objArr) {
        return new WebCard.SmeltTag((String) objArr[0]);
    }

    public Object get(Object obj, int i) {
        WebCard.SmeltTag smeltTag = (WebCard.SmeltTag) obj;
        switch (i) {
            case 0:
                return smeltTag.getImage();
            default:
                return null;
        }
    }
}