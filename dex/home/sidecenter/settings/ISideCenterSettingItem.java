package home.sidecenter.settings;

import kotlin.Metadata;

/* compiled from: SideCenterSettings.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tH&R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\b\u0010\u000b\u0082\u0001\u0003\r\u000e\u000f¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lhome/sidecenter/settings/ISideCenterSettingItem;", "", "tab", "Lhome/sidecenter/settings/SideCenterSettingType;", "getTab$annotations", "()V", "getTab", "()Lhome/sidecenter/settings/SideCenterSettingType;", "isChecked", "", "isChecked$annotations", "()Z", "setChecked", "Lhome/sidecenter/settings/ISideCenterSettingGroup;", "Lhome/sidecenter/settings/SideCenterSettingGroup;", "Lhome/sidecenter/settings/SideCenterSettingItem;", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ISideCenterSettingItem {

    /* compiled from: SideCenterSettings.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void getTab$annotations() {
        }

        public static /* synthetic */ void isChecked$annotations() {
        }
    }

    SideCenterSettingType getTab();

    boolean isChecked();

    ISideCenterSettingItem setChecked(boolean z);
}