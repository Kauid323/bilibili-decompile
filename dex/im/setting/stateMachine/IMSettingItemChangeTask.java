package im.setting.stateMachine;

import BottomSheetItemData$;
import kotlin.Metadata;

/* compiled from: SettingItemChangeStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lim/setting/stateMachine/IMSettingItemChangeTask;", "", "Switch", "Select", "Lim/setting/stateMachine/IMSettingItemChangeTask$Select;", "Lim/setting/stateMachine/IMSettingItemChangeTask$Switch;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IMSettingItemChangeTask {

    /* compiled from: SettingItemChangeStateMachine.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lim/setting/stateMachine/IMSettingItemChangeTask$Switch;", "Lim/setting/stateMachine/IMSettingItemChangeTask;", "on", "", "<init>", "(Z)V", "getOn", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Switch implements IMSettingItemChangeTask {
        public static final int $stable = 0;
        private final boolean on;

        public static /* synthetic */ Switch copy$default(Switch r0, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = r0.on;
            }
            return r0.copy(z);
        }

        public final boolean component1() {
            return this.on;
        }

        public final Switch copy(boolean z) {
            return new Switch(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Switch) && this.on == ((Switch) obj).on;
        }

        public int hashCode() {
            return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.on);
        }

        public String toString() {
            return "Switch(on=" + this.on + ")";
        }

        public Switch(boolean on) {
            this.on = on;
        }

        public final boolean getOn() {
            return this.on;
        }
    }

    /* compiled from: SettingItemChangeStateMachine.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lim/setting/stateMachine/IMSettingItemChangeTask$Select;", "Lim/setting/stateMachine/IMSettingItemChangeTask;", "selectType", "", "<init>", "(I)V", "getSelectType", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Select implements IMSettingItemChangeTask {
        public static final int $stable = 0;
        private final int selectType;

        public static /* synthetic */ Select copy$default(Select select, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i2 = select.selectType;
            }
            return select.copy(i2);
        }

        public final int component1() {
            return this.selectType;
        }

        public final Select copy(int i2) {
            return new Select(i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Select) && this.selectType == ((Select) obj).selectType;
        }

        public int hashCode() {
            return this.selectType;
        }

        public String toString() {
            return "Select(selectType=" + this.selectType + ")";
        }

        public Select(int selectType) {
            this.selectType = selectType;
        }

        public final int getSelectType() {
            return this.selectType;
        }
    }
}