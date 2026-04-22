package im.setting;

import im.setting.model.SettingItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMSettingAction.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lim/setting/IMSettingSelectAction;", "Lim/setting/IMSettingAction;", "item", "Lim/setting/model/SettingItem$Setting;", "selectType", "", "<init>", "(Lim/setting/model/SettingItem$Setting;I)V", "getItem", "()Lim/setting/model/SettingItem$Setting;", "getSelectType", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSettingSelectAction implements IMSettingAction {
    public static final int $stable = 0;
    private final SettingItem.Setting item;
    private final int selectType;

    public static /* synthetic */ IMSettingSelectAction copy$default(IMSettingSelectAction iMSettingSelectAction, SettingItem.Setting setting, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            setting = iMSettingSelectAction.item;
        }
        if ((i3 & 2) != 0) {
            i2 = iMSettingSelectAction.selectType;
        }
        return iMSettingSelectAction.copy(setting, i2);
    }

    public final SettingItem.Setting component1() {
        return this.item;
    }

    public final int component2() {
        return this.selectType;
    }

    public final IMSettingSelectAction copy(SettingItem.Setting setting, int i2) {
        Intrinsics.checkNotNullParameter(setting, "item");
        return new IMSettingSelectAction(setting, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMSettingSelectAction) {
            IMSettingSelectAction iMSettingSelectAction = (IMSettingSelectAction) obj;
            return Intrinsics.areEqual(this.item, iMSettingSelectAction.item) && this.selectType == iMSettingSelectAction.selectType;
        }
        return false;
    }

    public int hashCode() {
        return (this.item.hashCode() * 31) + this.selectType;
    }

    public String toString() {
        SettingItem.Setting setting = this.item;
        return "IMSettingSelectAction(item=" + setting + ", selectType=" + this.selectType + ")";
    }

    public IMSettingSelectAction(SettingItem.Setting item, int selectType) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.item = item;
        this.selectType = selectType;
    }

    public final SettingItem.Setting getItem() {
        return this.item;
    }

    public final int getSelectType() {
        return this.selectType;
    }
}