package tv.danmaku.bili.ui.garb.nft.model;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;
import com.bilibili.bson.common.Types;
import java.lang.reflect.Type;
import java.util.List;

public final class DLCSubtitles_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public DLCSubtitles_JsonDescriptor() {
        super(DLCSubtitles.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("utterances", (String[]) null, Types.parameterizedType(List.class, new Type[]{Utterances.class}), (Class) null, 21)};
    }

    public Object constructWith(Object[] objArr) {
        return new DLCSubtitles((List) objArr[0]);
    }

    public Object get(Object obj, int i) {
        DLCSubtitles dLCSubtitles = (DLCSubtitles) obj;
        switch (i) {
            case 0:
                return dLCSubtitles.getUtterances();
            default:
                return null;
        }
    }
}