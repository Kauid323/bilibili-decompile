package im.setting.stateMachine;

import kotlin.Metadata;

/* compiled from: SettingItemChangeStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lim/setting/stateMachine/IMSettingItemAction;", "", "Confirm", "Cancel", "Lim/setting/stateMachine/IMSettingItemAction$Cancel;", "Lim/setting/stateMachine/IMSettingItemAction$Confirm;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IMSettingItemAction {

    /* compiled from: SettingItemChangeStateMachine.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lim/setting/stateMachine/IMSettingItemAction$Confirm;", "Lim/setting/stateMachine/IMSettingItemAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Confirm implements IMSettingItemAction {
        public static final int $stable = 0;
        public static final Confirm INSTANCE = new Confirm();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Confirm) {
                Confirm confirm = (Confirm) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 522233975;
        }

        public String toString() {
            return "Confirm";
        }

        private Confirm() {
        }
    }

    /* compiled from: SettingItemChangeStateMachine.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lim/setting/stateMachine/IMSettingItemAction$Cancel;", "Lim/setting/stateMachine/IMSettingItemAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Cancel implements IMSettingItemAction {
        public static final int $stable = 0;
        public static final Cancel INSTANCE = new Cancel();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Cancel) {
                Cancel cancel = (Cancel) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 281008611;
        }

        public String toString() {
            return "Cancel";
        }

        private Cancel() {
        }
    }
}