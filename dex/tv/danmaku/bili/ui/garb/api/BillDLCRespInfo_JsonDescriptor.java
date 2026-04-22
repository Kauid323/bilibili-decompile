package tv.danmaku.bili.ui.garb.api;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;
import com.bilibili.bson.common.Types;
import java.lang.reflect.Type;
import java.util.List;

public final class BillDLCRespInfo_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public BillDLCRespInfo_JsonDescriptor() {
        super(BillDLCRespInfo.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("err_code", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("err_message", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("left_chance", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("item_list", (String[]) null, Types.parameterizedType(List.class, new Type[]{DLCItem.class}), (Class) null, 21)};
    }

    public Object constructWith(Object[] objArr) {
        Integer num = (Integer) objArr[0];
        int intValue = num == null ? 0 : num.intValue();
        String str = (String) objArr[1];
        Integer num2 = (Integer) objArr[2];
        return new BillDLCRespInfo(intValue, str, num2 != null ? num2.intValue() : 0, (List) objArr[3]);
    }

    public Object get(Object obj, int i) {
        int errCode;
        BillDLCRespInfo billDLCRespInfo = (BillDLCRespInfo) obj;
        switch (i) {
            case 0:
                errCode = billDLCRespInfo.getErrCode();
                break;
            case 1:
                return billDLCRespInfo.getErrMessage();
            case 2:
                errCode = billDLCRespInfo.getLeftChance();
                break;
            case 3:
                return billDLCRespInfo.getItemList();
            default:
                return null;
        }
        return Integer.valueOf(errCode);
    }
}