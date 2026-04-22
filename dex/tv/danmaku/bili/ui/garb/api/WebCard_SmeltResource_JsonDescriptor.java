package tv.danmaku.bili.ui.garb.api;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;
import tv.danmaku.bili.ui.garb.api.WebCard;

public final class WebCard_SmeltResource_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public WebCard_SmeltResource_JsonDescriptor() {
        super(WebCard.SmeltResource.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("dynamic_image", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("static_image", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("card_image", (String[]) null, String.class, (Class) null, 5)};
    }

    public Object constructWith(Object[] objArr) {
        return new WebCard.SmeltResource((String) objArr[0], (String) objArr[1], (String) objArr[2]);
    }

    public Object get(Object obj, int i) {
        WebCard.SmeltResource smeltResource = (WebCard.SmeltResource) obj;
        switch (i) {
            case 0:
                return smeltResource.getDynamicImage();
            case 1:
                return smeltResource.getStaticImage();
            case 2:
                return smeltResource.getCardImage();
            default:
                return null;
        }
    }
}