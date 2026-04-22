package tv.danmaku.bili.ui.garb;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;

public final class InitConfigurationData_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public InitConfigurationData_JsonDescriptor() {
        super(InitConfigurationData.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("collection_completed_url", (String[]) null, String.class, (Class) null, 4)};
    }

    public Object constructWith(Object[] objArr) {
        return new InitConfigurationData((String) objArr[0]);
    }

    public Object get(Object obj, int i) {
        InitConfigurationData initConfigurationData = (InitConfigurationData) obj;
        switch (i) {
            case 0:
                return initConfigurationData.getCollectionCompletedUrl();
            default:
                return null;
        }
    }
}