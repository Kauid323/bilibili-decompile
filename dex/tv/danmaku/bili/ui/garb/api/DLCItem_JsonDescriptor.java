package tv.danmaku.bili.ui.garb.api;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;

public final class DLCItem_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public DLCItem_JsonDescriptor() {
        super(DLCItem.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("item_type", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("item_scarcity", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("card_item", (String[]) null, BiliDLCCardItem.class, (Class) null, 5), new PojoPropertyDescriptor("display", (String[]) null, BiliDLCCardDisplay.class, (Class) null, 1)};
    }

    public Object constructWith(Object[] objArr) {
        Integer num = (Integer) objArr[0];
        int intValue = num == null ? 0 : num.intValue();
        Integer num2 = (Integer) objArr[1];
        return new DLCItem(intValue, num2 != null ? num2.intValue() : 0, (BiliDLCCardItem) objArr[2], (BiliDLCCardDisplay) objArr[3]);
    }

    public Object get(Object obj, int i) {
        int itemType;
        DLCItem dLCItem = (DLCItem) obj;
        switch (i) {
            case 0:
                itemType = dLCItem.getItemType();
                break;
            case 1:
                itemType = dLCItem.getItemScarcity();
                break;
            case 2:
                return dLCItem.getCardItem();
            case 3:
                return dLCItem.getDisplay();
            default:
                return null;
        }
        return Integer.valueOf(itemType);
    }
}