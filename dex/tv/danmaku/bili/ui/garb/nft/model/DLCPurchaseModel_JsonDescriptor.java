package tv.danmaku.bili.ui.garb.nft.model;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;

public final class DLCPurchaseModel_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public DLCPurchaseModel_JsonDescriptor() {
        super(DLCPurchaseModel.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("lottery_id", (String[]) null, Long.TYPE, (Class) null, 5), new PojoPropertyDescriptor("lottery_num", (String[]) null, Integer.TYPE, (Class) null, 5)};
    }

    public Object constructWith(Object[] objArr) {
        Long l = (Long) objArr[0];
        long longValue = l == null ? 0L : l.longValue();
        Integer num = (Integer) objArr[1];
        return new DLCPurchaseModel(longValue, num != null ? num.intValue() : 0);
    }

    public Object get(Object obj, int i) {
        DLCPurchaseModel dLCPurchaseModel = (DLCPurchaseModel) obj;
        switch (i) {
            case 0:
                return Long.valueOf(dLCPurchaseModel.getLotteryId());
            case 1:
                return Integer.valueOf(dLCPurchaseModel.getLotteryNum());
            default:
                return null;
        }
    }
}