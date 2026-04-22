package tv.danmaku.bili.ui.garb.nft.model;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;

public final class CollectProgressButton_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public CollectProgressButton_JsonDescriptor() {
        super(CollectProgressButton.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("text", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("ui_type", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("action", (String[]) null, ActionVo.class, (Class) null, 6), new PojoPropertyDescriptor("report", (String[]) null, ReportVo.class, (Class) null, 6)};
    }

    public Object constructWith(Object[] objArr) {
        String str = (String) objArr[0];
        Integer num = (Integer) objArr[1];
        int intValue = num == null ? 0 : num.intValue();
        Object obj = objArr[2];
        int i = obj == null ? 4 : 0;
        ActionVo actionVo = (ActionVo) obj;
        Object obj2 = objArr[3];
        if (obj2 == null) {
            i |= 8;
        }
        return new CollectProgressButton(str, intValue, actionVo, (ReportVo) obj2, i, null);
    }

    public Object get(Object obj, int i) {
        CollectProgressButton collectProgressButton = (CollectProgressButton) obj;
        switch (i) {
            case 0:
                return collectProgressButton.getText();
            case 1:
                return Integer.valueOf(collectProgressButton.getUiType());
            case 2:
                return collectProgressButton.getAction();
            case 3:
                return collectProgressButton.getReport();
            default:
                return null;
        }
    }
}