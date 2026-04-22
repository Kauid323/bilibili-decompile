package usercenter;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: UserHandleStateMachine.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\b\u0002\u0003\u0004\u0005\u0006\u0007\b\t\u0082\u0001\b\n\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lusercenter/UserHandleAction;", "", "ShowDoubleCheckDialog", "ShowRecommendDialog", "ShowBindPhoneDialog", "ShowLoadingDialog", "DismissDialog", "Submit", "SubmitSuccess", "ShowNoEditPermissionToast", "Lusercenter/UserHandleAction$DismissDialog;", "Lusercenter/UserHandleAction$ShowBindPhoneDialog;", "Lusercenter/UserHandleAction$ShowDoubleCheckDialog;", "Lusercenter/UserHandleAction$ShowLoadingDialog;", "Lusercenter/UserHandleAction$ShowNoEditPermissionToast;", "Lusercenter/UserHandleAction$ShowRecommendDialog;", "Lusercenter/UserHandleAction$Submit;", "Lusercenter/UserHandleAction$SubmitSuccess;", "usercenter_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface UserHandleAction {

    /* compiled from: UserHandleStateMachine.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lusercenter/UserHandleAction$ShowDoubleCheckDialog;", "Lusercenter/UserHandleAction;", "newHandle", "", "<init>", "(Ljava/lang/String;)V", "getNewHandle", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "usercenter_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ShowDoubleCheckDialog implements UserHandleAction {
        public static final int $stable = 0;
        private final String newHandle;

        public static /* synthetic */ ShowDoubleCheckDialog copy$default(ShowDoubleCheckDialog showDoubleCheckDialog, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = showDoubleCheckDialog.newHandle;
            }
            return showDoubleCheckDialog.copy(str);
        }

        public final String component1() {
            return this.newHandle;
        }

        public final ShowDoubleCheckDialog copy(String str) {
            Intrinsics.checkNotNullParameter(str, "newHandle");
            return new ShowDoubleCheckDialog(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowDoubleCheckDialog) && Intrinsics.areEqual(this.newHandle, ((ShowDoubleCheckDialog) obj).newHandle);
        }

        public int hashCode() {
            return this.newHandle.hashCode();
        }

        public String toString() {
            return "ShowDoubleCheckDialog(newHandle=" + this.newHandle + ")";
        }

        public ShowDoubleCheckDialog(String newHandle) {
            Intrinsics.checkNotNullParameter(newHandle, "newHandle");
            this.newHandle = newHandle;
        }

        public final String getNewHandle() {
            return this.newHandle;
        }
    }

    /* compiled from: UserHandleStateMachine.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lusercenter/UserHandleAction$ShowRecommendDialog;", "Lusercenter/UserHandleAction;", "suggestions", "", "", "<init>", "(Ljava/util/List;)V", "getSuggestions", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "usercenter_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ShowRecommendDialog implements UserHandleAction {
        public static final int $stable = 8;
        private final List<String> suggestions;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ShowRecommendDialog copy$default(ShowRecommendDialog showRecommendDialog, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = showRecommendDialog.suggestions;
            }
            return showRecommendDialog.copy(list);
        }

        public final List<String> component1() {
            return this.suggestions;
        }

        public final ShowRecommendDialog copy(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "suggestions");
            return new ShowRecommendDialog(list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowRecommendDialog) && Intrinsics.areEqual(this.suggestions, ((ShowRecommendDialog) obj).suggestions);
        }

        public int hashCode() {
            return this.suggestions.hashCode();
        }

        public String toString() {
            return "ShowRecommendDialog(suggestions=" + this.suggestions + ")";
        }

        public ShowRecommendDialog(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "suggestions");
            this.suggestions = list;
        }

        public final List<String> getSuggestions() {
            return this.suggestions;
        }
    }

    /* compiled from: UserHandleStateMachine.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lusercenter/UserHandleAction$ShowBindPhoneDialog;", "Lusercenter/UserHandleAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "usercenter_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ShowBindPhoneDialog implements UserHandleAction {
        public static final int $stable = 0;
        public static final ShowBindPhoneDialog INSTANCE = new ShowBindPhoneDialog();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ShowBindPhoneDialog) {
                ShowBindPhoneDialog showBindPhoneDialog = (ShowBindPhoneDialog) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1913693979;
        }

        public String toString() {
            return "ShowBindPhoneDialog";
        }

        private ShowBindPhoneDialog() {
        }
    }

    /* compiled from: UserHandleStateMachine.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lusercenter/UserHandleAction$ShowLoadingDialog;", "Lusercenter/UserHandleAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "usercenter_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ShowLoadingDialog implements UserHandleAction {
        public static final int $stable = 0;
        public static final ShowLoadingDialog INSTANCE = new ShowLoadingDialog();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ShowLoadingDialog) {
                ShowLoadingDialog showLoadingDialog = (ShowLoadingDialog) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1837510224;
        }

        public String toString() {
            return "ShowLoadingDialog";
        }

        private ShowLoadingDialog() {
        }
    }

    /* compiled from: UserHandleStateMachine.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lusercenter/UserHandleAction$DismissDialog;", "Lusercenter/UserHandleAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "usercenter_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class DismissDialog implements UserHandleAction {
        public static final int $stable = 0;
        public static final DismissDialog INSTANCE = new DismissDialog();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DismissDialog) {
                DismissDialog dismissDialog = (DismissDialog) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -32013061;
        }

        public String toString() {
            return "DismissDialog";
        }

        private DismissDialog() {
        }
    }

    /* compiled from: UserHandleStateMachine.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lusercenter/UserHandleAction$Submit;", "Lusercenter/UserHandleAction;", "newHandle", "", "<init>", "(Ljava/lang/String;)V", "getNewHandle", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "usercenter_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Submit implements UserHandleAction {
        public static final int $stable = 0;
        private final String newHandle;

        public static /* synthetic */ Submit copy$default(Submit submit, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = submit.newHandle;
            }
            return submit.copy(str);
        }

        public final String component1() {
            return this.newHandle;
        }

        public final Submit copy(String str) {
            Intrinsics.checkNotNullParameter(str, "newHandle");
            return new Submit(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Submit) && Intrinsics.areEqual(this.newHandle, ((Submit) obj).newHandle);
        }

        public int hashCode() {
            return this.newHandle.hashCode();
        }

        public String toString() {
            return "Submit(newHandle=" + this.newHandle + ")";
        }

        public Submit(String newHandle) {
            Intrinsics.checkNotNullParameter(newHandle, "newHandle");
            this.newHandle = newHandle;
        }

        public final String getNewHandle() {
            return this.newHandle;
        }
    }

    /* compiled from: UserHandleStateMachine.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lusercenter/UserHandleAction$SubmitSuccess;", "Lusercenter/UserHandleAction;", "toast", "", "newHandle", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getToast", "()Ljava/lang/String;", "getNewHandle", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "usercenter_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class SubmitSuccess implements UserHandleAction {
        public static final int $stable = 0;
        private final String newHandle;
        private final String toast;

        public static /* synthetic */ SubmitSuccess copy$default(SubmitSuccess submitSuccess, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = submitSuccess.toast;
            }
            if ((i & 2) != 0) {
                str2 = submitSuccess.newHandle;
            }
            return submitSuccess.copy(str, str2);
        }

        public final String component1() {
            return this.toast;
        }

        public final String component2() {
            return this.newHandle;
        }

        public final SubmitSuccess copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "toast");
            Intrinsics.checkNotNullParameter(str2, "newHandle");
            return new SubmitSuccess(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SubmitSuccess) {
                SubmitSuccess submitSuccess = (SubmitSuccess) obj;
                return Intrinsics.areEqual(this.toast, submitSuccess.toast) && Intrinsics.areEqual(this.newHandle, submitSuccess.newHandle);
            }
            return false;
        }

        public int hashCode() {
            return (this.toast.hashCode() * 31) + this.newHandle.hashCode();
        }

        public String toString() {
            String str = this.toast;
            return "SubmitSuccess(toast=" + str + ", newHandle=" + this.newHandle + ")";
        }

        public SubmitSuccess(String toast, String newHandle) {
            Intrinsics.checkNotNullParameter(toast, "toast");
            Intrinsics.checkNotNullParameter(newHandle, "newHandle");
            this.toast = toast;
            this.newHandle = newHandle;
        }

        public final String getToast() {
            return this.toast;
        }

        public final String getNewHandle() {
            return this.newHandle;
        }
    }

    /* compiled from: UserHandleStateMachine.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lusercenter/UserHandleAction$ShowNoEditPermissionToast;", "Lusercenter/UserHandleAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "usercenter_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ShowNoEditPermissionToast implements UserHandleAction {
        public static final int $stable = 0;
        public static final ShowNoEditPermissionToast INSTANCE = new ShowNoEditPermissionToast();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ShowNoEditPermissionToast) {
                ShowNoEditPermissionToast showNoEditPermissionToast = (ShowNoEditPermissionToast) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -699158855;
        }

        public String toString() {
            return "ShowNoEditPermissionToast";
        }

        private ShowNoEditPermissionToast() {
        }
    }
}