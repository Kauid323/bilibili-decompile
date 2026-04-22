package im.setting;

import BottomSheetItemData$;
import im.setting.model.SettingItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMSettingAction.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lim/setting/IMSettingDialogConfirmAction;", "Lim/setting/IMSettingAction;", "item", "Lim/setting/model/SettingItem$Setting;", "operateOn", "", "<init>", "(Lim/setting/model/SettingItem$Setting;Z)V", "getItem", "()Lim/setting/model/SettingItem$Setting;", "getOperateOn", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSettingDialogConfirmAction implements IMSettingAction {
    public static final int $stable = 0;
    private final SettingItem.Setting item;
    private final boolean operateOn;

    public static /* synthetic */ IMSettingDialogConfirmAction copy$default(IMSettingDialogConfirmAction iMSettingDialogConfirmAction, SettingItem.Setting setting, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            setting = iMSettingDialogConfirmAction.item;
        }
        if ((i2 & 2) != 0) {
            z = iMSettingDialogConfirmAction.operateOn;
        }
        return iMSettingDialogConfirmAction.copy(setting, z);
    }

    public final SettingItem.Setting component1() {
        return this.item;
    }

    public final boolean component2() {
        return this.operateOn;
    }

    public final IMSettingDialogConfirmAction copy(SettingItem.Setting setting, boolean z) {
        Intrinsics.checkNotNullParameter(setting, "item");
        return new IMSettingDialogConfirmAction(setting, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMSettingDialogConfirmAction) {
            IMSettingDialogConfirmAction iMSettingDialogConfirmAction = (IMSettingDialogConfirmAction) obj;
            return Intrinsics.areEqual(this.item, iMSettingDialogConfirmAction.item) && this.operateOn == iMSettingDialogConfirmAction.operateOn;
        }
        return false;
    }

    public int hashCode() {
        return (this.item.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.operateOn);
    }

    public String toString() {
        SettingItem.Setting setting = this.item;
        return "IMSettingDialogConfirmAction(item=" + setting + ", operateOn=" + this.operateOn + ")";
    }

    public IMSettingDialogConfirmAction(SettingItem.Setting item, boolean operateOn) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.item = item;
        this.operateOn = operateOn;
    }

    public final SettingItem.Setting getItem() {
        return this.item;
    }

    public final boolean getOperateOn() {
        return this.operateOn;
    }
}