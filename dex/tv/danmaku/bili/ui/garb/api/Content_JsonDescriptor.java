package tv.danmaku.bili.ui.garb.api;

import com.bilibili.app.authorspace.api.BiliNftImage;
import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;

public final class Content_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public Content_JsonDescriptor() {
        super(Content.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("image", (String[]) null, BiliNftImage.class, (Class) null, 5), new PojoPropertyDescriptor("animation", (String[]) null, Animation.class, (Class) null, 5)};
    }

    public Object constructWith(Object[] objArr) {
        return new Content((BiliNftImage) objArr[0], (Animation) objArr[1]);
    }

    public Object get(Object obj, int i) {
        Content content = (Content) obj;
        switch (i) {
            case 0:
                return content.getImage();
            case 1:
                return content.getAnimation();
            default:
                return null;
        }
    }
}