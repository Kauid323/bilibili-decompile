package tv.danmaku.bili.ui.garb.api;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.ui.garb.api.UseMenu;

public final class UseMenu_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public UseMenu_JsonDescriptor() {
        super(UseMenu.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("can_set", (String[]) null, Boolean.TYPE, (Class) null, 5), new PojoPropertyDescriptor(ReportUtilKt.POS_TITLE, (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("target_url", (String[]) null, String.class, (Class) null, 4), new PojoPropertyDescriptor("tips", (String[]) null, String.class, (Class) null, 4), new PojoPropertyDescriptor(FavoritesConstsKt.JUMP_TYPE, (String[]) null, UseMenu.Type.class, (Class) null, 7)};
    }

    public Object constructWith(Object[] objArr) {
        Boolean bool = (Boolean) objArr[0];
        boolean booleanValue = bool == null ? false : bool.booleanValue();
        String str = (String) objArr[1];
        String str2 = (String) objArr[2];
        String str3 = (String) objArr[3];
        Object obj = objArr[4];
        return new UseMenu(booleanValue, str, str2, str3, (UseMenu.Type) obj, obj == null ? 16 : 0, null);
    }

    public Object get(Object obj, int i) {
        UseMenu useMenu = (UseMenu) obj;
        switch (i) {
            case 0:
                return Boolean.valueOf(useMenu.getAvailable());
            case 1:
                return useMenu.getTitle();
            case 2:
                return useMenu.getTargetUrl();
            case 3:
                return useMenu.getTips();
            case 4:
                return useMenu.getJumpType();
            default:
                return null;
        }
    }
}