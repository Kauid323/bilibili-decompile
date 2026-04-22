package tv.danmaku.bili.ui.garb.api;

import com.bili.digital.common.CardNumberGradientColor;
import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;

public final class CardInfo_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public CardInfo_JsonDescriptor() {
        super(CardInfo.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("card_id", (String[]) null, Long.TYPE, (Class) null, 5), new PojoPropertyDescriptor("card_no", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("hash_code", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("card_right_show", (String[]) null, CardRightShow.class, (Class) null, 5), new PojoPropertyDescriptor("color_format", (String[]) null, CardNumberGradientColor.class, (Class) null, 4), new PojoPropertyDescriptor("meta_info", (String[]) null, com.bilibili.digital.card.page.card.cardmodule.web.WebCard.class, (Class) null, 5), new PojoPropertyDescriptor("card_right", (String[]) null, CardRight.class, (Class) null, 5), new PojoPropertyDescriptor("smelt_lock_status", (String[]) null, CardLockStatus.class, (Class) null, 4), new PojoPropertyDescriptor("card_ext_text", (String[]) null, String.class, (Class) null, 5)};
    }

    public Object constructWith(Object[] objArr) {
        Long l = (Long) objArr[0];
        return new CardInfo(l == null ? 0L : l.longValue(), (String) objArr[1], (String) objArr[2], (CardRightShow) objArr[3], (CardNumberGradientColor) objArr[4], (com.bilibili.digital.card.page.card.cardmodule.web.WebCard) objArr[5], (CardRight) objArr[6], (CardLockStatus) objArr[7], (String) objArr[8]);
    }

    public Object get(Object obj, int i) {
        CardInfo cardInfo = (CardInfo) obj;
        switch (i) {
            case 0:
                return Long.valueOf(cardInfo.getId());
            case 1:
                return cardInfo.getCardNo();
            case 2:
                return cardInfo.getHashCode();
            case 3:
                return cardInfo.getCardRightShow();
            case 4:
                return cardInfo.getCardNumberGradientColor();
            case 5:
                return cardInfo.getWebCard();
            case 6:
                return cardInfo.getCardRight();
            case 7:
                return cardInfo.getCardLockStatus();
            case 8:
                return cardInfo.getCardExtText();
            default:
                return null;
        }
    }
}