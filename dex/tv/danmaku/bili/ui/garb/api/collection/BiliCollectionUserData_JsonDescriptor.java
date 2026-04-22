package tv.danmaku.bili.ui.garb.api.collection;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;
import tv.danmaku.bili.router.ChannelRoutes;

public final class BiliCollectionUserData_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public BiliCollectionUserData_JsonDescriptor() {
        super(BiliCollectionUserData.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("avatar", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("mid", (String[]) null, Long.TYPE, (Class) null, 5), new PojoPropertyDescriptor(ChannelRoutes.CHANNEL_NAME, (String[]) null, String.class, (Class) null, 5)};
    }

    public Object constructWith(Object[] objArr) {
        String str = (String) objArr[0];
        Long l = (Long) objArr[1];
        return new BiliCollectionUserData(str, l == null ? 0L : l.longValue(), (String) objArr[2]);
    }

    public Object get(Object obj, int i) {
        BiliCollectionUserData biliCollectionUserData = (BiliCollectionUserData) obj;
        switch (i) {
            case 0:
                return biliCollectionUserData.getAvatar();
            case 1:
                return Long.valueOf(biliCollectionUserData.getMid());
            case 2:
                return biliCollectionUserData.getName();
            default:
                return null;
        }
    }
}