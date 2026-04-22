package tv.danmaku.bili.ui.garb.nft.model;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;
import com.bilibili.bson.common.Types;
import java.lang.reflect.Type;
import java.util.Map;
import tv.danmaku.bili.ui.garb.nft.model.ReportVo;

public final class ReportVo_Content_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public ReportVo_Content_JsonDescriptor() {
        super(ReportVo.Content.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("event_id", (String[]) null, String.class, (Class) null, 5), new PojoPropertyDescriptor("params", (String[]) null, Types.parameterizedType(Map.class, new Type[]{String.class, String.class}), (Class) null, 5)};
    }

    public Object constructWith(Object[] objArr) {
        return new ReportVo.Content((String) objArr[0], (Map) objArr[1]);
    }

    public Object get(Object obj, int i) {
        ReportVo.Content content = (ReportVo.Content) obj;
        switch (i) {
            case 0:
                return content.getEventId();
            case 1:
                return content.getParams();
            default:
                return null;
        }
    }
}