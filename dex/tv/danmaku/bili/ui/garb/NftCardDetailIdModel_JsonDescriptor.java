package tv.danmaku.bili.ui.garb;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;
import tv.danmaku.bili.ui.garb.api.CardRight;
import tv.danmaku.bili.ui.garb.api.CardRightShow;

public final class NftCardDetailIdModel_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public NftCardDetailIdModel_JsonDescriptor() {
        super(NftCardDetailIdModel.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("card_id", (String[]) null, Long.TYPE, (Class) null, 5), new PojoPropertyDescriptor("card_no", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("status", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("exchange_status", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("hash_code", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("card_right_show", (String[]) null, CardRightShow.class, (Class) null, 5), new PojoPropertyDescriptor("card_right", (String[]) null, CardRight.class, (Class) null, 5)};
    }

    public Object constructWith(Object[] objArr) {
        Long l = (Long) objArr[0];
        long longValue = l == null ? 0L : l.longValue();
        String str = (String) objArr[1];
        Integer num = (Integer) objArr[2];
        int intValue = num == null ? 0 : num.intValue();
        Integer num2 = (Integer) objArr[3];
        return new NftCardDetailIdModel(longValue, str, intValue, num2 != null ? num2.intValue() : 0, (String) objArr[4], (CardRightShow) objArr[5], (CardRight) objArr[6]);
    }

    public Object get(Object obj, int i) {
        NftCardDetailIdModel nftCardDetailIdModel = (NftCardDetailIdModel) obj;
        switch (i) {
            case 0:
                return Long.valueOf(nftCardDetailIdModel.getCardId());
            case 1:
                return nftCardDetailIdModel.getCardNo();
            case 2:
                return Integer.valueOf(nftCardDetailIdModel.getStatus());
            case 3:
                return Integer.valueOf(nftCardDetailIdModel.getExchangeStatus());
            case 4:
                return nftCardDetailIdModel.getHashCode();
            case 5:
                return nftCardDetailIdModel.getCardRightShow();
            case 6:
                return nftCardDetailIdModel.getCardRight();
            default:
                return null;
        }
    }
}