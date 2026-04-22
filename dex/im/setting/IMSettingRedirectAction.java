package im.setting;

import im.setting.model.SettingItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMSettingAction.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lim/setting/IMSettingRedirectAction;", "Lim/setting/IMSettingAction;", "item", "Lim/setting/model/SettingItem$Setting;", "<init>", "(Lim/setting/model/SettingItem$Setting;)V", "getItem", "()Lim/setting/model/SettingItem$Setting;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSettingRedirectAction implements IMSettingAction {
    public static final int $stable = 0;
    private final SettingItem.Setting item;

    public static /* synthetic */ IMSettingRedirectAction copy$default(IMSettingRedirectAction iMSettingRedirectAction, SettingItem.Setting setting, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            setting = iMSettingRedirectAction.item;
        }
        return iMSettingRedirectAction.copy(setting);
    }

    public final SettingItem.Setting component1() {
        return this.item;
    }

    public final IMSettingRedirectAction copy(SettingItem.Setting setting) {
        Intrinsics.checkNotNullParameter(setting, "item");
        return new IMSettingRedirectAction(setting);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof IMSettingRedirectAction) && Intrinsics.areEqual(this.item, ((IMSettingRedirectAction) obj).item);
    }

    public int hashCode() {
        return this.item.hashCode();
    }

    public String toString() {
        return "IMSettingRedirectAction(item=" + this.item + ")";
    }

    public IMSettingRedirectAction(SettingItem.Setting item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.item = item;
    }

    public final SettingItem.Setting getItem() {
        return this.item;
    }
}