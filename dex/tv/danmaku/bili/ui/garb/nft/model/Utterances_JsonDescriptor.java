package tv.danmaku.bili.ui.garb.nft.model;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;

public final class Utterances_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public Utterances_JsonDescriptor() {
        super(Utterances.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("end_time", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("start_time", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("transcript", (String[]) null, String.class, (Class) null, 5)};
    }

    public Object constructWith(Object[] objArr) {
        Integer num = (Integer) objArr[0];
        int intValue = num == null ? 0 : num.intValue();
        Integer num2 = (Integer) objArr[1];
        return new Utterances(intValue, num2 != null ? num2.intValue() : 0, (String) objArr[2]);
    }

    public Object get(Object obj, int i) {
        int endTime;
        Utterances utterances = (Utterances) obj;
        switch (i) {
            case 0:
                endTime = utterances.getEndTime();
                break;
            case 1:
                endTime = utterances.getStartTime();
                break;
            case 2:
                return utterances.getTranscript();
            default:
                return null;
        }
        return Integer.valueOf(endTime);
    }
}