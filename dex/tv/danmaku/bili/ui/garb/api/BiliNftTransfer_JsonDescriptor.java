package tv.danmaku.bili.ui.garb.api;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;
import com.bilibili.bson.common.Types;
import java.lang.reflect.Type;
import java.util.List;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;

public final class BiliNftTransfer_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public BiliNftTransfer_JsonDescriptor() {
        super(BiliNftTransfer.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("status", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("jump_url", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor(ReportUtilKt.POS_TITLE, (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("content_template", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("highlight_params", (String[]) null, Types.parameterizedType(List.class, new Type[]{String.class}), (Class) null, 21)};
    }

    public Object constructWith(Object[] objArr) {
        Integer num = (Integer) objArr[0];
        return new BiliNftTransfer(num != null ? num.intValue() : 0, (String) objArr[1], (String) objArr[2], (String) objArr[3], (List) objArr[4]);
    }

    public Object get(Object obj, int i) {
        BiliNftTransfer biliNftTransfer = (BiliNftTransfer) obj;
        switch (i) {
            case 0:
                return Integer.valueOf(biliNftTransfer.getStatus());
            case 1:
                return biliNftTransfer.getJumpUrl();
            case 2:
                return biliNftTransfer.getTitle();
            case 3:
                return biliNftTransfer.getContentTemplate();
            case 4:
                return biliNftTransfer.getHighlightParams();
            default:
                return null;
        }
    }
}