package tv.danmaku.bili.ui.garb.nft.model;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;
import com.bilibili.bson.common.Types;
import java.lang.reflect.Type;
import java.util.List;
import tv.danmaku.bili.cb.AuthResultCbHelper;

public final class DLCPreloadModel_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public DLCPreloadModel_JsonDescriptor() {
        super(DLCPreloadModel.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor(AuthResultCbHelper.ARGS_CALLBACK, (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("resources", (String[]) null, Types.parameterizedType(List.class, new Type[]{String.class}), (Class) null, 21)};
    }

    public Object constructWith(Object[] objArr) {
        return new DLCPreloadModel((String) objArr[0], (List) objArr[1]);
    }

    public Object get(Object obj, int i) {
        DLCPreloadModel dLCPreloadModel = (DLCPreloadModel) obj;
        switch (i) {
            case 0:
                return dLCPreloadModel.getCallbackId();
            case 1:
                return dLCPreloadModel.getResources();
            default:
                return null;
        }
    }
}