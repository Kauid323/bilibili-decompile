package home.sidecenter.settings;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SideCenterSettings.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0016"}, d2 = {"Lhome/sidecenter/settings/SideCenterSettingItem;", "Lhome/sidecenter/settings/ISideCenterSettingItem;", "tab", "Lhome/sidecenter/settings/SideCenterSettingType;", "isChecked", "", "<init>", "(Lhome/sidecenter/settings/SideCenterSettingType;Z)V", "getTab", "()Lhome/sidecenter/settings/SideCenterSettingType;", "()Z", "setChecked", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SideCenterSettingItem implements ISideCenterSettingItem {
    public static final int $stable = 0;
    private final boolean isChecked;
    private final SideCenterSettingType tab;

    public static /* synthetic */ SideCenterSettingItem copy$default(SideCenterSettingItem sideCenterSettingItem, SideCenterSettingType sideCenterSettingType, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            sideCenterSettingType = sideCenterSettingItem.tab;
        }
        if ((i2 & 2) != 0) {
            z = sideCenterSettingItem.isChecked;
        }
        return sideCenterSettingItem.copy(sideCenterSettingType, z);
    }

    public final SideCenterSettingType component1() {
        return this.tab;
    }

    public final boolean component2() {
        return this.isChecked;
    }

    public final SideCenterSettingItem copy(SideCenterSettingType sideCenterSettingType, boolean z) {
        Intrinsics.checkNotNullParameter(sideCenterSettingType, "tab");
        return new SideCenterSettingItem(sideCenterSettingType, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SideCenterSettingItem) {
            SideCenterSettingItem sideCenterSettingItem = (SideCenterSettingItem) obj;
            return this.tab == sideCenterSettingItem.tab && this.isChecked == sideCenterSettingItem.isChecked;
        }
        return false;
    }

    public int hashCode() {
        return (this.tab.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isChecked);
    }

    public String toString() {
        SideCenterSettingType sideCenterSettingType = this.tab;
        return "SideCenterSettingItem(tab=" + sideCenterSettingType + ", isChecked=" + this.isChecked + ")";
    }

    public SideCenterSettingItem(SideCenterSettingType tab, boolean isChecked) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        this.tab = tab;
        this.isChecked = isChecked;
    }

    @Override // home.sidecenter.settings.ISideCenterSettingItem
    public SideCenterSettingType getTab() {
        return this.tab;
    }

    @Override // home.sidecenter.settings.ISideCenterSettingItem
    public boolean isChecked() {
        return this.isChecked;
    }

    @Override // home.sidecenter.settings.ISideCenterSettingItem
    public ISideCenterSettingItem setChecked(boolean isChecked) {
        return copy$default(this, null, isChecked, 1, null);
    }
}