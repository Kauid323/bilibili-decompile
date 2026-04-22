package tv.danmaku.bili.ui.garb.api;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;
import com.bilibili.bson.common.Types;
import java.lang.reflect.Type;
import java.util.List;

public final class Animation_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public Animation_JsonDescriptor() {
        super(Animation.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("is_mute", (String[]) null, Boolean.TYPE, (Class) null, 5), new PojoPropertyDescriptor("animation_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("animation_backup_image", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("animation_first_frame", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("animation_video_urls", (String[]) null, Types.parameterizedType(List.class, new Type[]{String.class}), (Class) null, 21), new PojoPropertyDescriptor("subtitles_url", (String[]) null, String.class, (Class) null, 5)};
    }

    public Object constructWith(Object[] objArr) {
        Boolean bool = (Boolean) objArr[0];
        return new Animation(bool != null ? bool.booleanValue() : false, (String) objArr[1], (String) objArr[2], (String) objArr[3], (List) objArr[4], (String) objArr[5]);
    }

    public Object get(Object obj, int i) {
        Animation animation = (Animation) obj;
        switch (i) {
            case 0:
                return Boolean.valueOf(animation.getMute());
            case 1:
                return animation.getAnimationUrl();
            case 2:
                return animation.getAnimationBackupImage();
            case 3:
                return animation.getAnimationFirstFrame();
            case 4:
                return animation.getAnimationVideoUrls();
            case 5:
                return animation.getSubtitlesUrl();
            default:
                return null;
        }
    }
}