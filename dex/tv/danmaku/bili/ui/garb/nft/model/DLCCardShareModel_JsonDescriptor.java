package tv.danmaku.bili.ui.garb.nft.model;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;
import com.bilibili.bson.common.Types;
import java.lang.reflect.Type;
import java.util.List;

public final class DLCCardShareModel_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public DLCCardShareModel_JsonDescriptor() {
        super(DLCCardShareModel.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("lottery_id", (String[]) null, Long.TYPE, (Class) null, 5), new PojoPropertyDescriptor("share_type", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("card_list", (String[]) null, Types.parameterizedType(List.class, new Type[]{CardShareInfo.class}), (Class) null, 21)};
    }

    public Object constructWith(Object[] objArr) {
        Long l = (Long) objArr[0];
        long longValue = l == null ? 0L : l.longValue();
        Integer num = (Integer) objArr[1];
        return new DLCCardShareModel(longValue, num != null ? num.intValue() : 0, (List) objArr[2]);
    }

    public Object get(Object obj, int i) {
        DLCCardShareModel dLCCardShareModel = (DLCCardShareModel) obj;
        switch (i) {
            case 0:
                return Long.valueOf(dLCCardShareModel.getLotteryId());
            case 1:
                return Integer.valueOf(dLCCardShareModel.getShareType());
            case 2:
                return dLCCardShareModel.getCardList();
            default:
                return null;
        }
    }
}