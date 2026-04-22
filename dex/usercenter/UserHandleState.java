package usercenter;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import usercenter.DialogState;

/* compiled from: UserHandleStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lusercenter/UserHandleState;", "", "Immutable", "Mutable", "Lusercenter/UserHandleState$Immutable;", "Lusercenter/UserHandleState$Mutable;", "usercenter_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface UserHandleState {

    /* compiled from: UserHandleStateMachine.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lusercenter/UserHandleState$Immutable;", "Lusercenter/UserHandleState;", "handle", "", "tip", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getHandle", "()Ljava/lang/String;", "getTip", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "usercenter_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Immutable implements UserHandleState {
        public static final int $stable = 0;
        private final String handle;
        private final String tip;

        public static /* synthetic */ Immutable copy$default(Immutable immutable, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = immutable.handle;
            }
            if ((i & 2) != 0) {
                str2 = immutable.tip;
            }
            return immutable.copy(str, str2);
        }

        public final String component1() {
            return this.handle;
        }

        public final String component2() {
            return this.tip;
        }

        public final Immutable copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "handle");
            Intrinsics.checkNotNullParameter(str2, "tip");
            return new Immutable(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Immutable) {
                Immutable immutable = (Immutable) obj;
                return Intrinsics.areEqual(this.handle, immutable.handle) && Intrinsics.areEqual(this.tip, immutable.tip);
            }
            return false;
        }

        public int hashCode() {
            return (this.handle.hashCode() * 31) + this.tip.hashCode();
        }

        public String toString() {
            String str = this.handle;
            return "Immutable(handle=" + str + ", tip=" + this.tip + ")";
        }

        public Immutable(String handle, String tip) {
            Intrinsics.checkNotNullParameter(handle, "handle");
            Intrinsics.checkNotNullParameter(tip, "tip");
            this.handle = handle;
            this.tip = tip;
        }

        public final String getHandle() {
            return this.handle;
        }

        public final String getTip() {
            return this.tip;
        }
    }

    /* compiled from: UserHandleStateMachine.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lusercenter/UserHandleState$Mutable;", "Lusercenter/UserHandleState;", "handle", "", "dialogState", "Lusercenter/DialogState;", "<init>", "(Ljava/lang/String;Lusercenter/DialogState;)V", "getHandle", "()Ljava/lang/String;", "getDialogState", "()Lusercenter/DialogState;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "usercenter_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Mutable implements UserHandleState {
        public static final int $stable = 8;
        private final DialogState dialogState;
        private final String handle;

        public static /* synthetic */ Mutable copy$default(Mutable mutable, String str, DialogState dialogState, int i, Object obj) {
            if ((i & 1) != 0) {
                str = mutable.handle;
            }
            if ((i & 2) != 0) {
                dialogState = mutable.dialogState;
            }
            return mutable.copy(str, dialogState);
        }

        public final String component1() {
            return this.handle;
        }

        public final DialogState component2() {
            return this.dialogState;
        }

        public final Mutable copy(String str, DialogState dialogState) {
            Intrinsics.checkNotNullParameter(str, "handle");
            Intrinsics.checkNotNullParameter(dialogState, "dialogState");
            return new Mutable(str, dialogState);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Mutable) {
                Mutable mutable = (Mutable) obj;
                return Intrinsics.areEqual(this.handle, mutable.handle) && Intrinsics.areEqual(this.dialogState, mutable.dialogState);
            }
            return false;
        }

        public int hashCode() {
            return (this.handle.hashCode() * 31) + this.dialogState.hashCode();
        }

        public String toString() {
            String str = this.handle;
            return "Mutable(handle=" + str + ", dialogState=" + this.dialogState + ")";
        }

        public Mutable(String handle, DialogState dialogState) {
            Intrinsics.checkNotNullParameter(handle, "handle");
            Intrinsics.checkNotNullParameter(dialogState, "dialogState");
            this.handle = handle;
            this.dialogState = dialogState;
        }

        public /* synthetic */ Mutable(String str, DialogState.None none, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? DialogState.None.INSTANCE : none);
        }

        public final String getHandle() {
            return this.handle;
        }

        public final DialogState getDialogState() {
            return this.dialogState;
        }
    }
}