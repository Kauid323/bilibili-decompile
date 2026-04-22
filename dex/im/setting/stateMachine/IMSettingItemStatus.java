package im.setting.stateMachine;

import BottomSheetItemData$;
import com.bapis.bilibili.app.im.v1.KIMSettingType;
import im.base.IMToast;
import im.setting.IMSettingDialog;
import im.setting.model.SettingItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingItemChangeStateMachine.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0006\u0007\bR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0003\t\n\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lim/setting/stateMachine/IMSettingItemStatus;", "", "type", "Lcom/bapis/bilibili/app/im/v1/KIMSettingType;", "getType", "()Lcom/bapis/bilibili/app/im/v1/KIMSettingType;", "Pending", "Loading", "Done", "Lim/setting/stateMachine/IMSettingItemStatus$Done;", "Lim/setting/stateMachine/IMSettingItemStatus$Loading;", "Lim/setting/stateMachine/IMSettingItemStatus$Pending;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IMSettingItemStatus {
    KIMSettingType getType();

    /* compiled from: SettingItemChangeStateMachine.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lim/setting/stateMachine/IMSettingItemStatus$Pending;", "Lim/setting/stateMachine/IMSettingItemStatus;", "type", "Lcom/bapis/bilibili/app/im/v1/KIMSettingType;", "dialog", "Lim/setting/IMSettingDialog;", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KIMSettingType;Lim/setting/IMSettingDialog;)V", "getType", "()Lcom/bapis/bilibili/app/im/v1/KIMSettingType;", "getDialog", "()Lim/setting/IMSettingDialog;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Pending implements IMSettingItemStatus {
        public static final int $stable = 8;
        private final IMSettingDialog dialog;
        private final KIMSettingType type;

        public static /* synthetic */ Pending copy$default(Pending pending, KIMSettingType kIMSettingType, IMSettingDialog iMSettingDialog, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                kIMSettingType = pending.type;
            }
            if ((i2 & 2) != 0) {
                iMSettingDialog = pending.dialog;
            }
            return pending.copy(kIMSettingType, iMSettingDialog);
        }

        public final KIMSettingType component1() {
            return this.type;
        }

        public final IMSettingDialog component2() {
            return this.dialog;
        }

        public final Pending copy(KIMSettingType kIMSettingType, IMSettingDialog iMSettingDialog) {
            Intrinsics.checkNotNullParameter(kIMSettingType, "type");
            return new Pending(kIMSettingType, iMSettingDialog);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Pending) {
                Pending pending = (Pending) obj;
                return Intrinsics.areEqual(this.type, pending.type) && Intrinsics.areEqual(this.dialog, pending.dialog);
            }
            return false;
        }

        public int hashCode() {
            return (this.type.hashCode() * 31) + (this.dialog == null ? 0 : this.dialog.hashCode());
        }

        public String toString() {
            KIMSettingType kIMSettingType = this.type;
            return "Pending(type=" + kIMSettingType + ", dialog=" + this.dialog + ")";
        }

        public Pending(KIMSettingType type, IMSettingDialog dialog) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
            this.dialog = dialog;
        }

        @Override // im.setting.stateMachine.IMSettingItemStatus
        public KIMSettingType getType() {
            return this.type;
        }

        public final IMSettingDialog getDialog() {
            return this.dialog;
        }
    }

    /* compiled from: SettingItemChangeStateMachine.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lim/setting/stateMachine/IMSettingItemStatus$Loading;", "Lim/setting/stateMachine/IMSettingItemStatus;", "type", "Lcom/bapis/bilibili/app/im/v1/KIMSettingType;", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KIMSettingType;)V", "getType", "()Lcom/bapis/bilibili/app/im/v1/KIMSettingType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Loading implements IMSettingItemStatus {
        public static final int $stable = 8;
        private final KIMSettingType type;

        public static /* synthetic */ Loading copy$default(Loading loading, KIMSettingType kIMSettingType, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                kIMSettingType = loading.type;
            }
            return loading.copy(kIMSettingType);
        }

        public final KIMSettingType component1() {
            return this.type;
        }

        public final Loading copy(KIMSettingType kIMSettingType) {
            Intrinsics.checkNotNullParameter(kIMSettingType, "type");
            return new Loading(kIMSettingType);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Loading) && Intrinsics.areEqual(this.type, ((Loading) obj).type);
        }

        public int hashCode() {
            return this.type.hashCode();
        }

        public String toString() {
            return "Loading(type=" + this.type + ")";
        }

        public Loading(KIMSettingType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
        }

        @Override // im.setting.stateMachine.IMSettingItemStatus
        public KIMSettingType getType() {
            return this.type;
        }
    }

    /* compiled from: SettingItemChangeStateMachine.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lim/setting/stateMachine/IMSettingItemStatus$Done;", "Lim/setting/stateMachine/IMSettingItemStatus;", "type", "Lcom/bapis/bilibili/app/im/v1/KIMSettingType;", "success", "", "resultItem", "Lim/setting/model/SettingItem$Setting;", "toast", "Lim/base/IMToast;", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KIMSettingType;ZLim/setting/model/SettingItem$Setting;Lim/base/IMToast;)V", "getType", "()Lcom/bapis/bilibili/app/im/v1/KIMSettingType;", "getSuccess", "()Z", "getResultItem", "()Lim/setting/model/SettingItem$Setting;", "getToast", "()Lim/base/IMToast;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Done implements IMSettingItemStatus {
        public static final int $stable = 8;
        private final SettingItem.Setting resultItem;
        private final boolean success;
        private final IMToast toast;
        private final KIMSettingType type;

        public static /* synthetic */ Done copy$default(Done done, KIMSettingType kIMSettingType, boolean z, SettingItem.Setting setting, IMToast iMToast, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                kIMSettingType = done.type;
            }
            if ((i2 & 2) != 0) {
                z = done.success;
            }
            if ((i2 & 4) != 0) {
                setting = done.resultItem;
            }
            if ((i2 & 8) != 0) {
                iMToast = done.toast;
            }
            return done.copy(kIMSettingType, z, setting, iMToast);
        }

        public final KIMSettingType component1() {
            return this.type;
        }

        public final boolean component2() {
            return this.success;
        }

        public final SettingItem.Setting component3() {
            return this.resultItem;
        }

        public final IMToast component4() {
            return this.toast;
        }

        public final Done copy(KIMSettingType kIMSettingType, boolean z, SettingItem.Setting setting, IMToast iMToast) {
            Intrinsics.checkNotNullParameter(kIMSettingType, "type");
            Intrinsics.checkNotNullParameter(setting, "resultItem");
            return new Done(kIMSettingType, z, setting, iMToast);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Done) {
                Done done = (Done) obj;
                return Intrinsics.areEqual(this.type, done.type) && this.success == done.success && Intrinsics.areEqual(this.resultItem, done.resultItem) && Intrinsics.areEqual(this.toast, done.toast);
            }
            return false;
        }

        public int hashCode() {
            return (((((this.type.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.success)) * 31) + this.resultItem.hashCode()) * 31) + (this.toast == null ? 0 : this.toast.hashCode());
        }

        public String toString() {
            KIMSettingType kIMSettingType = this.type;
            boolean z = this.success;
            SettingItem.Setting setting = this.resultItem;
            return "Done(type=" + kIMSettingType + ", success=" + z + ", resultItem=" + setting + ", toast=" + this.toast + ")";
        }

        public Done(KIMSettingType type, boolean success, SettingItem.Setting resultItem, IMToast toast) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(resultItem, "resultItem");
            this.type = type;
            this.success = success;
            this.resultItem = resultItem;
            this.toast = toast;
        }

        public /* synthetic */ Done(KIMSettingType kIMSettingType, boolean z, SettingItem.Setting setting, IMToast iMToast, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(kIMSettingType, z, setting, (i2 & 8) != 0 ? null : iMToast);
        }

        @Override // im.setting.stateMachine.IMSettingItemStatus
        public KIMSettingType getType() {
            return this.type;
        }

        public final boolean getSuccess() {
            return this.success;
        }

        public final SettingItem.Setting getResultItem() {
            return this.resultItem;
        }

        public final IMToast getToast() {
            return this.toast;
        }
    }
}