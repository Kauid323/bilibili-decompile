package tv.danmaku.bili.ui.garb.api;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;
import tv.danmaku.bili.ui.garb.api.Notice;

public final class Notice_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public Notice_JsonDescriptor() {
        super(Notice.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("icon_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("tip_text", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("btn_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("btn_text", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("icon_style", (String[]) null, Notice.Style.class, (Class) null, 7), new PojoPropertyDescriptor("tip_type", (String[]) null, Integer.TYPE, (Class) null, 5)};
    }

    public Object constructWith(Object[] objArr) {
        String str = (String) objArr[0];
        String str2 = (String) objArr[1];
        String str3 = (String) objArr[2];
        String str4 = (String) objArr[3];
        Object obj = objArr[4];
        int i = obj == null ? 16 : 0;
        Notice.Style style = (Notice.Style) obj;
        Integer num = (Integer) objArr[5];
        return new Notice(str, str2, str3, str4, style, num == null ? 0 : num.intValue(), i, null);
    }

    public Object get(Object obj, int i) {
        Notice notice = (Notice) obj;
        switch (i) {
            case 0:
                return notice.getIconUrl();
            case 1:
                return notice.getTipText();
            case 2:
                return notice.getBtnUrl();
            case 3:
                return notice.getBtnText();
            case 4:
                return notice.getUiStyle();
            case 5:
                return Integer.valueOf(notice.getNoticeTextType());
            default:
                return null;
        }
    }
}