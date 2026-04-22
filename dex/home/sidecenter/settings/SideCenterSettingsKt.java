package home.sidecenter.settings;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SideCenterSettings.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"isTypeChecked", "", "", "Lhome/sidecenter/settings/ISideCenterSettingGroup;", "type", "Lhome/sidecenter/settings/SideCenterSettingType;", "sidecenter_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SideCenterSettingsKt {
    public static final boolean isTypeChecked(List<? extends ISideCenterSettingGroup> list, SideCenterSettingType type) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        List<? extends ISideCenterSettingGroup> $this$any$iv = list;
        if (($this$any$iv instanceof Collection) && $this$any$iv.isEmpty()) {
            return false;
        }
        for (Object element$iv : $this$any$iv) {
            ISideCenterSettingGroup it = (ISideCenterSettingGroup) element$iv;
            if (it.isTypeChecked(type)) {
                return true;
            }
        }
        return false;
    }
}