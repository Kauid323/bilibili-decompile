package tv.danmaku.bili.ui.garb.nft.model;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;
import tv.danmaku.bili.ui.garb.nft.model.ActionVo;

public final class ActionVo_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public ActionVo_JsonDescriptor() {
        super(ActionVo.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("type", (String[]) null, ActionVo.Type.class, (Class) null, 7), new PojoPropertyDescriptor("value", (String[]) null, String.class, (Class) null, 5)};
    }

    public Object constructWith(Object[] objArr) {
        Object obj = objArr[0];
        return new ActionVo((ActionVo.Type) obj, (String) objArr[1], obj == null ? 1 : 0, null);
    }

    public Object get(Object obj, int i) {
        ActionVo actionVo = (ActionVo) obj;
        switch (i) {
            case 0:
                return actionVo.getType();
            case 1:
                return actionVo.getValue();
            default:
                return null;
        }
    }
}