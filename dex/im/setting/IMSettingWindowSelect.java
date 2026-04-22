package im.setting;

import im.setting.model.SettingItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMSettingState.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lim/setting/IMSettingWindowSelect;", "", "item", "Lim/setting/model/SettingItem$Setting;", "<init>", "(Lim/setting/model/SettingItem$Setting;)V", "getItem", "()Lim/setting/model/SettingItem$Setting;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSettingWindowSelect {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final SettingItem.Setting item;

    public static /* synthetic */ IMSettingWindowSelect copy$default(IMSettingWindowSelect iMSettingWindowSelect, SettingItem.Setting setting, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            setting = iMSettingWindowSelect.item;
        }
        return iMSettingWindowSelect.copy(setting);
    }

    public final SettingItem.Setting component1() {
        return this.item;
    }

    public final IMSettingWindowSelect copy(SettingItem.Setting setting) {
        Intrinsics.checkNotNullParameter(setting, "item");
        return new IMSettingWindowSelect(setting);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof IMSettingWindowSelect) && Intrinsics.areEqual(this.item, ((IMSettingWindowSelect) obj).item);
    }

    public int hashCode() {
        return this.item.hashCode();
    }

    public String toString() {
        return "IMSettingWindowSelect(item=" + this.item + ")";
    }

    public IMSettingWindowSelect(SettingItem.Setting item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.item = item;
    }

    public final SettingItem.Setting getItem() {
        return this.item;
    }

    /* compiled from: IMSettingState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lim/setting/IMSettingWindowSelect$Companion;", "", "<init>", "()V", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}