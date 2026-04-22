package tv.danmaku.bili.ui.garb.api;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;
import tv.danmaku.bili.ui.garb.api.WebCard;

public final class WebCard_SmeltUrl_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public WebCard_SmeltUrl_JsonDescriptor() {
        super(WebCard.SmeltUrl.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("reshape_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("render_url", (String[]) null, String.class, (Class) null, 5)};
    }

    public Object constructWith(Object[] objArr) {
        return new WebCard.SmeltUrl((String) objArr[0], (String) objArr[1]);
    }

    public Object get(Object obj, int i) {
        WebCard.SmeltUrl smeltUrl = (WebCard.SmeltUrl) obj;
        switch (i) {
            case 0:
                return smeltUrl.getReshapeUrl();
            case 1:
                return smeltUrl.getRenderUrl();
            default:
                return null;
        }
    }
}