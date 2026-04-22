package tv.danmaku.bili.ui.garb.nft.model;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;

public final class DLCPlayModel_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public DLCPlayModel_JsonDescriptor() {
        super(DLCPlayModel.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor("duration", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("trial_duration", (String[]) null, Integer.TYPE, (Class) null, 5), new PojoPropertyDescriptor("show_subtitles", (String[]) null, Boolean.TYPE, (Class) null, 5), new PojoPropertyDescriptor("show_progress_bar", (String[]) null, Boolean.TYPE, (Class) null, 5)};
    }

    public Object constructWith(Object[] objArr) {
        Integer num = (Integer) objArr[0];
        int intValue = num == null ? 0 : num.intValue();
        Integer num2 = (Integer) objArr[1];
        int intValue2 = num2 == null ? 0 : num2.intValue();
        Boolean bool = (Boolean) objArr[2];
        boolean booleanValue = bool == null ? false : bool.booleanValue();
        Boolean bool2 = (Boolean) objArr[3];
        return new DLCPlayModel(intValue, intValue2, booleanValue, bool2 != null ? bool2.booleanValue() : false);
    }

    public Object get(Object obj, int i) {
        DLCPlayModel dLCPlayModel = (DLCPlayModel) obj;
        switch (i) {
            case 0:
                return Integer.valueOf(dLCPlayModel.getDuration());
            case 1:
                return Integer.valueOf(dLCPlayModel.getTrialDuration());
            case 2:
                return Boolean.valueOf(dLCPlayModel.getShowSubtitles());
            case 3:
                return Boolean.valueOf(dLCPlayModel.getShowProgressBar());
            default:
                return null;
        }
    }
}