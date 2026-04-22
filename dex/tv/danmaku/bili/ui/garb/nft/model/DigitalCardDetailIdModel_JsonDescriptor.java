package tv.danmaku.bili.ui.garb.nft.model;

import com.bili.digital.common.CardNumberGradientColor;
import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;
import tv.danmaku.bili.ui.garb.api.CardLockStatus;
import tv.danmaku.bili.ui.garb.api.CardRight;
import tv.danmaku.bili.ui.garb.api.CardRightShow;

public final class DigitalCardDetailIdModel_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public DigitalCardDetailIdModel_JsonDescriptor() {
        super(DigitalCardDetailIdModel.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("card_id", (String[]) null, Long.TYPE, (Class) null, 5), new PojoPropertyDescriptor("card_ext_text", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("card_no", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("status", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("exchange_status", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("hash_code", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("card_right_show", (String[]) null, CardRightShow.class, (Class) null, 5), new PojoPropertyDescriptor("card_right", (String[]) null, CardRight.class, (Class) null, 5), new PojoPropertyDescriptor("color_format", (String[]) null, CardNumberGradientColor.class, (Class) null, 4), new PojoPropertyDescriptor("smelt_lock_status", (String[]) null, CardLockStatus.class, (Class) null, 4)};
    }

    public Object constructWith(Object[] objArr) {
        Long l = (Long) objArr[0];
        long longValue = l == null ? 0L : l.longValue();
        String str = (String) objArr[1];
        String str2 = (String) objArr[2];
        Integer num = (Integer) objArr[3];
        int intValue = num == null ? 0 : num.intValue();
        Integer num2 = (Integer) objArr[4];
        return new DigitalCardDetailIdModel(longValue, str, str2, intValue, num2 != null ? num2.intValue() : 0, (String) objArr[5], (CardRightShow) objArr[6], (CardRight) objArr[7], (CardNumberGradientColor) objArr[8], (CardLockStatus) objArr[9]);
    }

    public Object get(Object obj, int i) {
        DigitalCardDetailIdModel digitalCardDetailIdModel = (DigitalCardDetailIdModel) obj;
        switch (i) {
            case 0:
                return Long.valueOf(digitalCardDetailIdModel.getCardId());
            case 1:
                return digitalCardDetailIdModel.getCardExtText();
            case 2:
                return digitalCardDetailIdModel.getCardNo();
            case 3:
                return Integer.valueOf(digitalCardDetailIdModel.getStatus());
            case 4:
                return Integer.valueOf(digitalCardDetailIdModel.getExchangeStatus());
            case 5:
                return digitalCardDetailIdModel.getHashCode();
            case 6:
                return digitalCardDetailIdModel.getCardRightShow();
            case 7:
                return digitalCardDetailIdModel.getCardRight();
            case 8:
                return digitalCardDetailIdModel.getCardNumberGradientColor();
            case 9:
                return digitalCardDetailIdModel.getCardLockStatus();
            default:
                return null;
        }
    }
}