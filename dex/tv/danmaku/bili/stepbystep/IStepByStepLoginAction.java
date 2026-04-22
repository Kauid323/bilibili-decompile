package tv.danmaku.bili.stepbystep;

import BottomSheetItemData$;
import androidx.compose.ui.focus.FocusState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.stat.LoginWay;
import tv.danmaku.bili.fullscreen.stat.Unspecified;

/* compiled from: IStepByStepLoginAction.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0006\u0002\u0003\u0004\u0005\u0006\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/stepbystep/IStepByStepLoginAction;", "", "SwitchToPassword", "ShowEulaAction", "DismissEulaAction", "AgreementCheckedAction", "LoginAction", "OnFocusChanged", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface IStepByStepLoginAction {

    /* compiled from: IStepByStepLoginAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/stepbystep/IStepByStepLoginAction$SwitchToPassword;", "Ltv/danmaku/bili/stepbystep/IStepByStepLoginAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class SwitchToPassword implements IStepByStepLoginAction {
        public static final int $stable = 0;
        public static final SwitchToPassword INSTANCE = new SwitchToPassword();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SwitchToPassword) {
                SwitchToPassword switchToPassword = (SwitchToPassword) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 2020381713;
        }

        public String toString() {
            return "SwitchToPassword";
        }

        private SwitchToPassword() {
        }
    }

    /* compiled from: IStepByStepLoginAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/stepbystep/IStepByStepLoginAction$ShowEulaAction;", "Ltv/danmaku/bili/stepbystep/IStepByStepLoginAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class ShowEulaAction implements IStepByStepLoginAction {
        public static final int $stable = 0;
        public static final ShowEulaAction INSTANCE = new ShowEulaAction();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ShowEulaAction) {
                ShowEulaAction showEulaAction = (ShowEulaAction) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -665572129;
        }

        public String toString() {
            return "ShowEulaAction";
        }

        private ShowEulaAction() {
        }
    }

    /* compiled from: IStepByStepLoginAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/stepbystep/IStepByStepLoginAction$DismissEulaAction;", "Ltv/danmaku/bili/stepbystep/IStepByStepLoginAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class DismissEulaAction implements IStepByStepLoginAction {
        public static final int $stable = 0;
        public static final DismissEulaAction INSTANCE = new DismissEulaAction();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DismissEulaAction) {
                DismissEulaAction dismissEulaAction = (DismissEulaAction) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1878420418;
        }

        public String toString() {
            return "DismissEulaAction";
        }

        private DismissEulaAction() {
        }
    }

    /* compiled from: IStepByStepLoginAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/stepbystep/IStepByStepLoginAction$AgreementCheckedAction;", "Ltv/danmaku/bili/stepbystep/IStepByStepLoginAction;", "checked", "", "fromPopup", "<init>", "(ZZ)V", "getChecked", "()Z", "getFromPopup", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AgreementCheckedAction implements IStepByStepLoginAction {
        public static final int $stable = 0;
        private final boolean checked;
        private final boolean fromPopup;

        public static /* synthetic */ AgreementCheckedAction copy$default(AgreementCheckedAction agreementCheckedAction, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = agreementCheckedAction.checked;
            }
            if ((i & 2) != 0) {
                z2 = agreementCheckedAction.fromPopup;
            }
            return agreementCheckedAction.copy(z, z2);
        }

        public final boolean component1() {
            return this.checked;
        }

        public final boolean component2() {
            return this.fromPopup;
        }

        public final AgreementCheckedAction copy(boolean z, boolean z2) {
            return new AgreementCheckedAction(z, z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AgreementCheckedAction) {
                AgreementCheckedAction agreementCheckedAction = (AgreementCheckedAction) obj;
                return this.checked == agreementCheckedAction.checked && this.fromPopup == agreementCheckedAction.fromPopup;
            }
            return false;
        }

        public int hashCode() {
            return (BottomSheetItemData$.ExternalSyntheticBackport0.m(this.checked) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.fromPopup);
        }

        public String toString() {
            boolean z = this.checked;
            return "AgreementCheckedAction(checked=" + z + ", fromPopup=" + this.fromPopup + ")";
        }

        public AgreementCheckedAction(boolean checked, boolean fromPopup) {
            this.checked = checked;
            this.fromPopup = fromPopup;
        }

        public /* synthetic */ AgreementCheckedAction(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, (i & 2) != 0 ? false : z2);
        }

        public final boolean getChecked() {
            return this.checked;
        }

        public final boolean getFromPopup() {
            return this.fromPopup;
        }
    }

    /* compiled from: IStepByStepLoginAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/stepbystep/IStepByStepLoginAction$LoginAction;", "Ltv/danmaku/bili/stepbystep/IStepByStepLoginAction;", "loginWay", "Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "report", "", "<init>", "(Ltv/danmaku/bili/fullscreen/stat/LoginWay;Z)V", "getLoginWay", "()Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "getReport", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class LoginAction implements IStepByStepLoginAction {
        public static final int $stable = 8;
        private final LoginWay loginWay;
        private final boolean report;

        public LoginAction() {
            this(null, false, 3, null);
        }

        public static /* synthetic */ LoginAction copy$default(LoginAction loginAction, LoginWay loginWay, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                loginWay = loginAction.loginWay;
            }
            if ((i & 2) != 0) {
                z = loginAction.report;
            }
            return loginAction.copy(loginWay, z);
        }

        public final LoginWay component1() {
            return this.loginWay;
        }

        public final boolean component2() {
            return this.report;
        }

        public final LoginAction copy(LoginWay loginWay, boolean z) {
            Intrinsics.checkNotNullParameter(loginWay, "loginWay");
            return new LoginAction(loginWay, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LoginAction) {
                LoginAction loginAction = (LoginAction) obj;
                return Intrinsics.areEqual(this.loginWay, loginAction.loginWay) && this.report == loginAction.report;
            }
            return false;
        }

        public int hashCode() {
            return (this.loginWay.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.report);
        }

        public String toString() {
            LoginWay loginWay = this.loginWay;
            return "LoginAction(loginWay=" + loginWay + ", report=" + this.report + ")";
        }

        public LoginAction(LoginWay loginWay, boolean report) {
            Intrinsics.checkNotNullParameter(loginWay, "loginWay");
            this.loginWay = loginWay;
            this.report = report;
        }

        public /* synthetic */ LoginAction(Unspecified unspecified, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? Unspecified.INSTANCE : unspecified, (i & 2) != 0 ? false : z);
        }

        public final LoginWay getLoginWay() {
            return this.loginWay;
        }

        public final boolean getReport() {
            return this.report;
        }
    }

    /* compiled from: IStepByStepLoginAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/stepbystep/IStepByStepLoginAction$OnFocusChanged;", "Ltv/danmaku/bili/stepbystep/IStepByStepLoginAction;", "focusState", "Landroidx/compose/ui/focus/FocusState;", "<init>", "(Landroidx/compose/ui/focus/FocusState;)V", "getFocusState", "()Landroidx/compose/ui/focus/FocusState;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class OnFocusChanged implements IStepByStepLoginAction {
        public static final int $stable = 8;
        private final FocusState focusState;

        public static /* synthetic */ OnFocusChanged copy$default(OnFocusChanged onFocusChanged, FocusState focusState, int i, Object obj) {
            if ((i & 1) != 0) {
                focusState = onFocusChanged.focusState;
            }
            return onFocusChanged.copy(focusState);
        }

        public final FocusState component1() {
            return this.focusState;
        }

        public final OnFocusChanged copy(FocusState focusState) {
            return new OnFocusChanged(focusState);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnFocusChanged) && Intrinsics.areEqual(this.focusState, ((OnFocusChanged) obj).focusState);
        }

        public int hashCode() {
            if (this.focusState == null) {
                return 0;
            }
            return this.focusState.hashCode();
        }

        public String toString() {
            return "OnFocusChanged(focusState=" + this.focusState + ")";
        }

        public OnFocusChanged(FocusState focusState) {
            this.focusState = focusState;
        }

        public final FocusState getFocusState() {
            return this.focusState;
        }
    }
}