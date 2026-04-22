package tv.danmaku.bili.ui.garb.api;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;
import com.bilibili.bson.common.Types;
import java.lang.reflect.Type;
import java.util.List;

public final class BiliCardDetail_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public BiliCardDetail_JsonDescriptor() {
        super(BiliCardDetail.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("card_type_info", (String[]) null, CardTypeInfo.class, (Class) null, 5), new PojoPropertyDescriptor("card_id_list", (String[]) null, Types.parameterizedType(List.class, new Type[]{CardId.class}), (Class) null, 21)};
    }

    public Object constructWith(Object[] objArr) {
        return new BiliCardDetail((CardTypeInfo) objArr[0], (List) objArr[1]);
    }

    public Object get(Object obj, int i) {
        BiliCardDetail biliCardDetail = (BiliCardDetail) obj;
        switch (i) {
            case 0:
                return biliCardDetail.getCardTypeInfo();
            case 1:
                return biliCardDetail.getCardIdList();
            default:
                return null;
        }
    }
}