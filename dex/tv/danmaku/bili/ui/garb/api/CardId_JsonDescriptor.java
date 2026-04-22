package tv.danmaku.bili.ui.garb.api;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;

public final class CardId_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public CardId_JsonDescriptor() {
        super(CardId.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("card_id", (String[]) null, Long.TYPE, (Class) null, 5), new PojoPropertyDescriptor("status", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("exchange_status", (String[]) null, Integer.TYPE, (Class) null, 5)};
    }

    public Object constructWith(Object[] objArr) {
        Long l = (Long) objArr[0];
        long longValue = l == null ? 0L : l.longValue();
        Integer num = (Integer) objArr[1];
        int intValue = num == null ? 0 : num.intValue();
        Integer num2 = (Integer) objArr[2];
        return new CardId(longValue, intValue, num2 != null ? num2.intValue() : 0);
    }

    public Object get(Object obj, int i) {
        CardId cardId = (CardId) obj;
        switch (i) {
            case 0:
                return Long.valueOf(cardId.getCardId());
            case 1:
                return Integer.valueOf(cardId.getStatus());
            case 2:
                return Integer.valueOf(cardId.getExchangeStatus());
            default:
                return null;
        }
    }
}