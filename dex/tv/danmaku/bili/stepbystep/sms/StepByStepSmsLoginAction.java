package tv.danmaku.bili.stepbystep.sms;

import BottomSheetItemData$;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.eula.EulaLinkType;
import tv.danmaku.bili.fullscreen.data.PhoneCountryCode;
import tv.danmaku.bili.fullscreen.stat.LoginWay;
import tv.danmaku.bili.fullscreen.stat.Sms;
import tv.danmaku.bili.stepbystep.IStepByStepLoginAction;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: StepByStepSmsLoginAction.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\n\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\u0082\u0001\n\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0016À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction;", "Ltv/danmaku/bili/stepbystep/IStepByStepLoginAction;", "InputPhoneAction", "ClearOutPhone", "ClearOutVerifyCode", "SelectCountryCodeAction", "PageTransitionAction", "OverrideTransitionStateAction", "InputSmsCodeAction", "GetSmsAction", "DismissCaptchaAction", "ReportAction", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ClearOutPhone;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ClearOutVerifyCode;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$DismissCaptchaAction;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$GetSmsAction;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$InputPhoneAction;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$InputSmsCodeAction;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$OverrideTransitionStateAction;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$PageTransitionAction;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$SelectCountryCodeAction;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface StepByStepSmsLoginAction extends IStepByStepLoginAction {

    /* compiled from: StepByStepSmsLoginAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$InputPhoneAction;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction;", "phone", "", "<init>", "(Ljava/lang/String;)V", "getPhone", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class InputPhoneAction implements StepByStepSmsLoginAction {
        public static final int $stable = 0;
        private final String phone;

        public static /* synthetic */ InputPhoneAction copy$default(InputPhoneAction inputPhoneAction, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = inputPhoneAction.phone;
            }
            return inputPhoneAction.copy(str);
        }

        public final String component1() {
            return this.phone;
        }

        public final InputPhoneAction copy(String str) {
            Intrinsics.checkNotNullParameter(str, "phone");
            return new InputPhoneAction(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof InputPhoneAction) && Intrinsics.areEqual(this.phone, ((InputPhoneAction) obj).phone);
        }

        public int hashCode() {
            return this.phone.hashCode();
        }

        public String toString() {
            return "InputPhoneAction(phone=" + this.phone + ")";
        }

        public InputPhoneAction(String phone) {
            Intrinsics.checkNotNullParameter(phone, "phone");
            this.phone = phone;
        }

        public final String getPhone() {
            return this.phone;
        }
    }

    /* compiled from: StepByStepSmsLoginAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ClearOutPhone;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class ClearOutPhone implements StepByStepSmsLoginAction {
        public static final int $stable = 0;
        public static final ClearOutPhone INSTANCE = new ClearOutPhone();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ClearOutPhone) {
                ClearOutPhone clearOutPhone = (ClearOutPhone) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 202388041;
        }

        public String toString() {
            return "ClearOutPhone";
        }

        private ClearOutPhone() {
        }
    }

    /* compiled from: StepByStepSmsLoginAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ClearOutVerifyCode;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class ClearOutVerifyCode implements StepByStepSmsLoginAction {
        public static final int $stable = 0;
        public static final ClearOutVerifyCode INSTANCE = new ClearOutVerifyCode();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ClearOutVerifyCode) {
                ClearOutVerifyCode clearOutVerifyCode = (ClearOutVerifyCode) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 22979083;
        }

        public String toString() {
            return "ClearOutVerifyCode";
        }

        private ClearOutVerifyCode() {
        }
    }

    /* compiled from: StepByStepSmsLoginAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$SelectCountryCodeAction;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction;", LoginReporterV2.Show.SIGNUP_KEY_CODE, "Ltv/danmaku/bili/fullscreen/data/PhoneCountryCode;", "<init>", "(Ltv/danmaku/bili/fullscreen/data/PhoneCountryCode;)V", "getCode", "()Ltv/danmaku/bili/fullscreen/data/PhoneCountryCode;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class SelectCountryCodeAction implements StepByStepSmsLoginAction {
        public static final int $stable = 8;
        private final PhoneCountryCode code;

        public static /* synthetic */ SelectCountryCodeAction copy$default(SelectCountryCodeAction selectCountryCodeAction, PhoneCountryCode phoneCountryCode, int i, Object obj) {
            if ((i & 1) != 0) {
                phoneCountryCode = selectCountryCodeAction.code;
            }
            return selectCountryCodeAction.copy(phoneCountryCode);
        }

        public final PhoneCountryCode component1() {
            return this.code;
        }

        public final SelectCountryCodeAction copy(PhoneCountryCode phoneCountryCode) {
            Intrinsics.checkNotNullParameter(phoneCountryCode, LoginReporterV2.Show.SIGNUP_KEY_CODE);
            return new SelectCountryCodeAction(phoneCountryCode);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SelectCountryCodeAction) && Intrinsics.areEqual(this.code, ((SelectCountryCodeAction) obj).code);
        }

        public int hashCode() {
            return this.code.hashCode();
        }

        public String toString() {
            return "SelectCountryCodeAction(code=" + this.code + ")";
        }

        public SelectCountryCodeAction(PhoneCountryCode code) {
            Intrinsics.checkNotNullParameter(code, LoginReporterV2.Show.SIGNUP_KEY_CODE);
            this.code = code;
        }

        public final PhoneCountryCode getCode() {
            return this.code;
        }
    }

    /* compiled from: StepByStepSmsLoginAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$PageTransitionAction;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class PageTransitionAction implements StepByStepSmsLoginAction {
        public static final int $stable = 0;
        public static final PageTransitionAction INSTANCE = new PageTransitionAction();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PageTransitionAction) {
                PageTransitionAction pageTransitionAction = (PageTransitionAction) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -223289602;
        }

        public String toString() {
            return "PageTransitionAction";
        }

        private PageTransitionAction() {
        }
    }

    /* compiled from: StepByStepSmsLoginAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$OverrideTransitionStateAction;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction;", "transitionPage", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginPageTransitionState;", "<init>", "(Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginPageTransitionState;)V", "getTransitionPage", "()Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginPageTransitionState;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class OverrideTransitionStateAction implements StepByStepSmsLoginAction {
        public static final int $stable = 8;
        private final StepByStepSmsLoginPageTransitionState transitionPage;

        public static /* synthetic */ OverrideTransitionStateAction copy$default(OverrideTransitionStateAction overrideTransitionStateAction, StepByStepSmsLoginPageTransitionState stepByStepSmsLoginPageTransitionState, int i, Object obj) {
            if ((i & 1) != 0) {
                stepByStepSmsLoginPageTransitionState = overrideTransitionStateAction.transitionPage;
            }
            return overrideTransitionStateAction.copy(stepByStepSmsLoginPageTransitionState);
        }

        public final StepByStepSmsLoginPageTransitionState component1() {
            return this.transitionPage;
        }

        public final OverrideTransitionStateAction copy(StepByStepSmsLoginPageTransitionState stepByStepSmsLoginPageTransitionState) {
            Intrinsics.checkNotNullParameter(stepByStepSmsLoginPageTransitionState, "transitionPage");
            return new OverrideTransitionStateAction(stepByStepSmsLoginPageTransitionState);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OverrideTransitionStateAction) && Intrinsics.areEqual(this.transitionPage, ((OverrideTransitionStateAction) obj).transitionPage);
        }

        public int hashCode() {
            return this.transitionPage.hashCode();
        }

        public String toString() {
            return "OverrideTransitionStateAction(transitionPage=" + this.transitionPage + ")";
        }

        public OverrideTransitionStateAction(StepByStepSmsLoginPageTransitionState transitionPage) {
            Intrinsics.checkNotNullParameter(transitionPage, "transitionPage");
            this.transitionPage = transitionPage;
        }

        public final StepByStepSmsLoginPageTransitionState getTransitionPage() {
            return this.transitionPage;
        }
    }

    /* compiled from: StepByStepSmsLoginAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$InputSmsCodeAction;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction;", "smsCode", "", "<init>", "(Ljava/lang/String;)V", "getSmsCode", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class InputSmsCodeAction implements StepByStepSmsLoginAction {
        public static final int $stable = 0;
        private final String smsCode;

        public static /* synthetic */ InputSmsCodeAction copy$default(InputSmsCodeAction inputSmsCodeAction, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = inputSmsCodeAction.smsCode;
            }
            return inputSmsCodeAction.copy(str);
        }

        public final String component1() {
            return this.smsCode;
        }

        public final InputSmsCodeAction copy(String str) {
            Intrinsics.checkNotNullParameter(str, "smsCode");
            return new InputSmsCodeAction(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof InputSmsCodeAction) && Intrinsics.areEqual(this.smsCode, ((InputSmsCodeAction) obj).smsCode);
        }

        public int hashCode() {
            return this.smsCode.hashCode();
        }

        public String toString() {
            return "InputSmsCodeAction(smsCode=" + this.smsCode + ")";
        }

        public InputSmsCodeAction(String smsCode) {
            Intrinsics.checkNotNullParameter(smsCode, "smsCode");
            this.smsCode = smsCode;
        }

        public final String getSmsCode() {
            return this.smsCode;
        }
    }

    /* compiled from: StepByStepSmsLoginAction.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$GetSmsAction;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction;", "newLoginWay", "Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "captcha", "", "", "<init>", "(Ltv/danmaku/bili/fullscreen/stat/LoginWay;Ljava/util/Map;)V", "getNewLoginWay", "()Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "getCaptcha", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class GetSmsAction implements StepByStepSmsLoginAction {
        public static final int $stable = 8;
        private final Map<String, String> captcha;
        private final LoginWay newLoginWay;

        public GetSmsAction() {
            this(null, null, 3, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GetSmsAction copy$default(GetSmsAction getSmsAction, LoginWay loginWay, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                loginWay = getSmsAction.newLoginWay;
            }
            if ((i & 2) != 0) {
                map = getSmsAction.captcha;
            }
            return getSmsAction.copy(loginWay, map);
        }

        public final LoginWay component1() {
            return this.newLoginWay;
        }

        public final Map<String, String> component2() {
            return this.captcha;
        }

        public final GetSmsAction copy(LoginWay loginWay, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(loginWay, "newLoginWay");
            Intrinsics.checkNotNullParameter(map, "captcha");
            return new GetSmsAction(loginWay, map);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof GetSmsAction) {
                GetSmsAction getSmsAction = (GetSmsAction) obj;
                return Intrinsics.areEqual(this.newLoginWay, getSmsAction.newLoginWay) && Intrinsics.areEqual(this.captcha, getSmsAction.captcha);
            }
            return false;
        }

        public int hashCode() {
            return (this.newLoginWay.hashCode() * 31) + this.captcha.hashCode();
        }

        public String toString() {
            LoginWay loginWay = this.newLoginWay;
            return "GetSmsAction(newLoginWay=" + loginWay + ", captcha=" + this.captcha + ")";
        }

        public GetSmsAction(LoginWay newLoginWay, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(newLoginWay, "newLoginWay");
            Intrinsics.checkNotNullParameter(map, "captcha");
            this.newLoginWay = newLoginWay;
            this.captcha = map;
        }

        public /* synthetic */ GetSmsAction(Sms.SmsLogin smsLogin, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? Sms.SmsLogin.INSTANCE : smsLogin, (i & 2) != 0 ? MapsKt.emptyMap() : map);
        }

        public final LoginWay getNewLoginWay() {
            return this.newLoginWay;
        }

        public final Map<String, String> getCaptcha() {
            return this.captcha;
        }
    }

    /* compiled from: StepByStepSmsLoginAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$DismissCaptchaAction;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class DismissCaptchaAction implements StepByStepSmsLoginAction {
        public static final int $stable = 0;
        public static final DismissCaptchaAction INSTANCE = new DismissCaptchaAction();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DismissCaptchaAction) {
                DismissCaptchaAction dismissCaptchaAction = (DismissCaptchaAction) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1951107402;
        }

        public String toString() {
            return "DismissCaptchaAction";
        }

        private DismissCaptchaAction() {
        }
    }

    /* compiled from: StepByStepSmsLoginAction.kt */
    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u000f\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001aJ'\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\b0\u00072\u0006\u0010\t\u001a\u00020\nH&¢\u0006\u0002\u0010\u000bR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u000f\u001b\u001c\u001d\u001e\u001f !\"#$%&'()ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006*À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction;", "eventId", "", "getEventId", "()Ljava/lang/String;", "getParams", "", "Lkotlin/Pair;", "pageState", "Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;", "(Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;)[Lkotlin/Pair;", "OnSubmit", "ClickCountryCode", "OnGetSms", "ClickSwitchToPassword", "ClickArrangementCheckBox", "ClickProvisionTerms", "ShowProvisionPopup", "ClickProvisionPopup", "ClickProvisionPopupTerms", "ShowCaptureDialog", "CloseCaptureDialog", "OnCaptureVerifySuccess", "ClickHelp", "OnLoginSuccess", "OnRegisterSuccess", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction$ClickArrangementCheckBox;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction$ClickCountryCode;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction$ClickHelp;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction$ClickProvisionPopup;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction$ClickProvisionPopupTerms;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction$ClickProvisionTerms;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction$ClickSwitchToPassword;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction$CloseCaptureDialog;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction$OnCaptureVerifySuccess;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction$OnGetSms;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction$OnLoginSuccess;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction$OnRegisterSuccess;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction$OnSubmit;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction$ShowCaptureDialog;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction$ShowProvisionPopup;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface ReportAction extends StepByStepSmsLoginAction {
        String getEventId();

        Pair<String, String>[] getParams(IStepByStepSmsLoginPageState iStepByStepSmsLoginPageState);

        /* compiled from: StepByStepSmsLoginAction.kt */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction$OnSubmit;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction;", "<init>", "()V", "eventId", "", "getEventId", "()Ljava/lang/String;", "getParams", "", "Lkotlin/Pair;", "pageState", "Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;", "(Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;)[Lkotlin/Pair;", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class OnSubmit implements ReportAction {
            public static final int $stable = 0;
            public static final OnSubmit INSTANCE = new OnSubmit();
            private static final String eventId = "app.login.submit.0.click";

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof OnSubmit) {
                    OnSubmit onSubmit = (OnSubmit) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return 234306039;
            }

            public String toString() {
                return "OnSubmit";
            }

            private OnSubmit() {
            }

            @Override // tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction.ReportAction
            public String getEventId() {
                return eventId;
            }

            @Override // tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction.ReportAction
            public Pair<String, String>[] getParams(IStepByStepSmsLoginPageState pageState) {
                Intrinsics.checkNotNullParameter(pageState, "pageState");
                return new Pair[]{TuplesKt.to("is_agree", ListExtentionsKt.toIntString(pageState.getPhoneInputState().getAgreementChecked())), TuplesKt.to(LoginReporterV2.SHOW_PROVISION_KEY, "1")};
            }
        }

        /* compiled from: StepByStepSmsLoginAction.kt */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction$ClickCountryCode;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction;", "<init>", "()V", "eventId", "", "getEventId", "()Ljava/lang/String;", "getParams", "", "Lkotlin/Pair;", "pageState", "Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;", "(Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;)[Lkotlin/Pair;", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class ClickCountryCode implements ReportAction {
            public static final int $stable = 0;
            public static final ClickCountryCode INSTANCE = new ClickCountryCode();
            private static final String eventId = "app.login.country.code.click";

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof ClickCountryCode) {
                    ClickCountryCode clickCountryCode = (ClickCountryCode) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return 1495097115;
            }

            public String toString() {
                return "ClickCountryCode";
            }

            private ClickCountryCode() {
            }

            @Override // tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction.ReportAction
            public String getEventId() {
                return eventId;
            }

            @Override // tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction.ReportAction
            public Pair<String, String>[] getParams(IStepByStepSmsLoginPageState pageState) {
                Intrinsics.checkNotNullParameter(pageState, "pageState");
                return new Pair[0];
            }
        }

        /* compiled from: StepByStepSmsLoginAction.kt */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction$OnGetSms;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction;", "<init>", "()V", "eventId", "", "getEventId", "()Ljava/lang/String;", "getParams", "", "Lkotlin/Pair;", "pageState", "Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;", "(Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;)[Lkotlin/Pair;", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class OnGetSms implements ReportAction {
            public static final int $stable = 0;
            public static final OnGetSms INSTANCE = new OnGetSms();
            private static final String eventId = "app.login.getsms.0.click";

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof OnGetSms) {
                    OnGetSms onGetSms = (OnGetSms) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return -123508734;
            }

            public String toString() {
                return "OnGetSms";
            }

            private OnGetSms() {
            }

            @Override // tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction.ReportAction
            public String getEventId() {
                return eventId;
            }

            @Override // tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction.ReportAction
            public Pair<String, String>[] getParams(IStepByStepSmsLoginPageState pageState) {
                Intrinsics.checkNotNullParameter(pageState, "pageState");
                return new Pair[0];
            }
        }

        /* compiled from: StepByStepSmsLoginAction.kt */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction$ClickSwitchToPassword;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction;", "<init>", "()V", "eventId", "", "getEventId", "()Ljava/lang/String;", "getParams", "", "Lkotlin/Pair;", "pageState", "Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;", "(Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;)[Lkotlin/Pair;", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class ClickSwitchToPassword implements ReportAction {
            public static final int $stable = 0;
            public static final ClickSwitchToPassword INSTANCE = new ClickSwitchToPassword();
            private static final String eventId = "app.login.switch-option.0.click";

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof ClickSwitchToPassword) {
                    ClickSwitchToPassword clickSwitchToPassword = (ClickSwitchToPassword) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return -922579182;
            }

            public String toString() {
                return "ClickSwitchToPassword";
            }

            private ClickSwitchToPassword() {
            }

            @Override // tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction.ReportAction
            public String getEventId() {
                return eventId;
            }

            @Override // tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction.ReportAction
            public Pair<String, String>[] getParams(IStepByStepSmsLoginPageState pageState) {
                Intrinsics.checkNotNullParameter(pageState, "pageState");
                return new Pair[]{TuplesKt.to("type", "pwd")};
            }
        }

        /* compiled from: StepByStepSmsLoginAction.kt */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0011J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction$ClickArrangementCheckBox;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction;", "checked", "", "<init>", "(Z)V", "getChecked", "()Z", "eventId", "", "getEventId", "()Ljava/lang/String;", "getParams", "", "Lkotlin/Pair;", "pageState", "Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;", "(Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;)[Lkotlin/Pair;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class ClickArrangementCheckBox implements ReportAction {
            public static final int $stable = 0;
            private final boolean checked;
            private final String eventId = "app.login.provision.0.click";

            public static /* synthetic */ ClickArrangementCheckBox copy$default(ClickArrangementCheckBox clickArrangementCheckBox, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = clickArrangementCheckBox.checked;
                }
                return clickArrangementCheckBox.copy(z);
            }

            public final boolean component1() {
                return this.checked;
            }

            public final ClickArrangementCheckBox copy(boolean z) {
                return new ClickArrangementCheckBox(z);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof ClickArrangementCheckBox) && this.checked == ((ClickArrangementCheckBox) obj).checked;
            }

            public int hashCode() {
                return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.checked);
            }

            public String toString() {
                return "ClickArrangementCheckBox(checked=" + this.checked + ")";
            }

            public ClickArrangementCheckBox(boolean checked) {
                this.checked = checked;
            }

            public final boolean getChecked() {
                return this.checked;
            }

            @Override // tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction.ReportAction
            public String getEventId() {
                return this.eventId;
            }

            @Override // tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction.ReportAction
            public Pair<String, String>[] getParams(IStepByStepSmsLoginPageState pageState) {
                Intrinsics.checkNotNullParameter(pageState, "pageState");
                return new Pair[]{TuplesKt.to("is_agree", ListExtentionsKt.toIntString(this.checked)), TuplesKt.to(LoginReporterV2.SHOW_PROVISION_KEY, "1")};
            }
        }

        /* compiled from: StepByStepSmsLoginAction.kt */
        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0011J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction$ClickProvisionTerms;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction;", "terms", "Ltv/danmaku/bili/eula/EulaLinkType;", "<init>", "(Ltv/danmaku/bili/eula/EulaLinkType;)V", "getTerms", "()Ltv/danmaku/bili/eula/EulaLinkType;", "eventId", "", "getEventId", "()Ljava/lang/String;", "getParams", "", "Lkotlin/Pair;", "pageState", "Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;", "(Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;)[Lkotlin/Pair;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class ClickProvisionTerms implements ReportAction {
            public static final int $stable = 8;
            private final String eventId;
            private final EulaLinkType terms;

            public static /* synthetic */ ClickProvisionTerms copy$default(ClickProvisionTerms clickProvisionTerms, EulaLinkType eulaLinkType, int i, Object obj) {
                if ((i & 1) != 0) {
                    eulaLinkType = clickProvisionTerms.terms;
                }
                return clickProvisionTerms.copy(eulaLinkType);
            }

            public final EulaLinkType component1() {
                return this.terms;
            }

            public final ClickProvisionTerms copy(EulaLinkType eulaLinkType) {
                Intrinsics.checkNotNullParameter(eulaLinkType, "terms");
                return new ClickProvisionTerms(eulaLinkType);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof ClickProvisionTerms) && Intrinsics.areEqual(this.terms, ((ClickProvisionTerms) obj).terms);
            }

            public int hashCode() {
                return this.terms.hashCode();
            }

            public String toString() {
                return "ClickProvisionTerms(terms=" + this.terms + ")";
            }

            public ClickProvisionTerms(EulaLinkType terms) {
                Intrinsics.checkNotNullParameter(terms, "terms");
                this.terms = terms;
                this.eventId = "app.login.provision.terms.click";
            }

            public final EulaLinkType getTerms() {
                return this.terms;
            }

            @Override // tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction.ReportAction
            public String getEventId() {
                return this.eventId;
            }

            @Override // tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction.ReportAction
            public Pair<String, String>[] getParams(IStepByStepSmsLoginPageState pageState) {
                String str;
                Intrinsics.checkNotNullParameter(pageState, "pageState");
                Pair<String, String>[] pairArr = new Pair[1];
                EulaLinkType eulaLinkType = this.terms;
                if (eulaLinkType instanceof EulaLinkType.Privacy) {
                    str = "privacy";
                } else {
                    str = eulaLinkType instanceof EulaLinkType.Agreement ? "agreement" : "other";
                }
                pairArr[0] = TuplesKt.to("type", str);
                return pairArr;
            }
        }

        /* compiled from: StepByStepSmsLoginAction.kt */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction$ShowProvisionPopup;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction;", "<init>", "()V", "eventId", "", "getEventId", "()Ljava/lang/String;", "getParams", "", "Lkotlin/Pair;", "pageState", "Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;", "(Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;)[Lkotlin/Pair;", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class ShowProvisionPopup implements ReportAction {
            public static final int $stable = 0;
            public static final ShowProvisionPopup INSTANCE = new ShowProvisionPopup();
            private static final String eventId = "app.login.provision-popup.0.show";

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof ShowProvisionPopup) {
                    ShowProvisionPopup showProvisionPopup = (ShowProvisionPopup) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return -1628764076;
            }

            public String toString() {
                return "ShowProvisionPopup";
            }

            private ShowProvisionPopup() {
            }

            @Override // tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction.ReportAction
            public String getEventId() {
                return eventId;
            }

            @Override // tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction.ReportAction
            public Pair<String, String>[] getParams(IStepByStepSmsLoginPageState pageState) {
                Intrinsics.checkNotNullParameter(pageState, "pageState");
                return new Pair[0];
            }
        }

        /* compiled from: StepByStepSmsLoginAction.kt */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u0010J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction$ClickProvisionPopup;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction;", "isAgree", "", "<init>", "(Z)V", "()Z", "eventId", "", "getEventId", "()Ljava/lang/String;", "getParams", "", "Lkotlin/Pair;", "pageState", "Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;", "(Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;)[Lkotlin/Pair;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class ClickProvisionPopup implements ReportAction {
            public static final int $stable = 0;
            private final String eventId = "app.login.provision-popup.0.click";
            private final boolean isAgree;

            public static /* synthetic */ ClickProvisionPopup copy$default(ClickProvisionPopup clickProvisionPopup, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = clickProvisionPopup.isAgree;
                }
                return clickProvisionPopup.copy(z);
            }

            public final boolean component1() {
                return this.isAgree;
            }

            public final ClickProvisionPopup copy(boolean z) {
                return new ClickProvisionPopup(z);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof ClickProvisionPopup) && this.isAgree == ((ClickProvisionPopup) obj).isAgree;
            }

            public int hashCode() {
                return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isAgree);
            }

            public String toString() {
                return "ClickProvisionPopup(isAgree=" + this.isAgree + ")";
            }

            public ClickProvisionPopup(boolean isAgree) {
                this.isAgree = isAgree;
            }

            public final boolean isAgree() {
                return this.isAgree;
            }

            @Override // tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction.ReportAction
            public String getEventId() {
                return this.eventId;
            }

            @Override // tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction.ReportAction
            public Pair<String, String>[] getParams(IStepByStepSmsLoginPageState pageState) {
                Intrinsics.checkNotNullParameter(pageState, "pageState");
                return new Pair[]{TuplesKt.to("is_agree", ListExtentionsKt.toIntString(this.isAgree))};
            }
        }

        /* compiled from: StepByStepSmsLoginAction.kt */
        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0011J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction$ClickProvisionPopupTerms;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction;", "terms", "Ltv/danmaku/bili/eula/EulaLinkType;", "<init>", "(Ltv/danmaku/bili/eula/EulaLinkType;)V", "getTerms", "()Ltv/danmaku/bili/eula/EulaLinkType;", "eventId", "", "getEventId", "()Ljava/lang/String;", "getParams", "", "Lkotlin/Pair;", "pageState", "Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;", "(Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;)[Lkotlin/Pair;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class ClickProvisionPopupTerms implements ReportAction {
            public static final int $stable = 8;
            private final String eventId;
            private final EulaLinkType terms;

            public static /* synthetic */ ClickProvisionPopupTerms copy$default(ClickProvisionPopupTerms clickProvisionPopupTerms, EulaLinkType eulaLinkType, int i, Object obj) {
                if ((i & 1) != 0) {
                    eulaLinkType = clickProvisionPopupTerms.terms;
                }
                return clickProvisionPopupTerms.copy(eulaLinkType);
            }

            public final EulaLinkType component1() {
                return this.terms;
            }

            public final ClickProvisionPopupTerms copy(EulaLinkType eulaLinkType) {
                Intrinsics.checkNotNullParameter(eulaLinkType, "terms");
                return new ClickProvisionPopupTerms(eulaLinkType);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof ClickProvisionPopupTerms) && Intrinsics.areEqual(this.terms, ((ClickProvisionPopupTerms) obj).terms);
            }

            public int hashCode() {
                return this.terms.hashCode();
            }

            public String toString() {
                return "ClickProvisionPopupTerms(terms=" + this.terms + ")";
            }

            public ClickProvisionPopupTerms(EulaLinkType terms) {
                Intrinsics.checkNotNullParameter(terms, "terms");
                this.terms = terms;
                this.eventId = "app.login.provision-popup.terms.click";
            }

            public final EulaLinkType getTerms() {
                return this.terms;
            }

            @Override // tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction.ReportAction
            public String getEventId() {
                return this.eventId;
            }

            @Override // tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction.ReportAction
            public Pair<String, String>[] getParams(IStepByStepSmsLoginPageState pageState) {
                String str;
                Intrinsics.checkNotNullParameter(pageState, "pageState");
                Pair<String, String>[] pairArr = new Pair[1];
                EulaLinkType eulaLinkType = this.terms;
                if (eulaLinkType instanceof EulaLinkType.Privacy) {
                    str = "privacy";
                } else {
                    str = eulaLinkType instanceof EulaLinkType.Agreement ? "agreement" : "other";
                }
                pairArr[0] = TuplesKt.to("type", str);
                return pairArr;
            }
        }

        /* compiled from: StepByStepSmsLoginAction.kt */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction$ShowCaptureDialog;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction;", "<init>", "()V", "eventId", "", "getEventId", "()Ljava/lang/String;", "getParams", "", "Lkotlin/Pair;", "pageState", "Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;", "(Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;)[Lkotlin/Pair;", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class ShowCaptureDialog implements ReportAction {
            public static final int $stable = 0;
            public static final ShowCaptureDialog INSTANCE = new ShowCaptureDialog();
            private static final String eventId = "app.login.verification.0.show";

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof ShowCaptureDialog) {
                    ShowCaptureDialog showCaptureDialog = (ShowCaptureDialog) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return -2007180015;
            }

            public String toString() {
                return "ShowCaptureDialog";
            }

            private ShowCaptureDialog() {
            }

            @Override // tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction.ReportAction
            public String getEventId() {
                return eventId;
            }

            @Override // tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction.ReportAction
            public Pair<String, String>[] getParams(IStepByStepSmsLoginPageState pageState) {
                Intrinsics.checkNotNullParameter(pageState, "pageState");
                return new Pair[0];
            }
        }

        /* compiled from: StepByStepSmsLoginAction.kt */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction$CloseCaptureDialog;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction;", "<init>", "()V", "eventId", "", "getEventId", "()Ljava/lang/String;", "getParams", "", "Lkotlin/Pair;", "pageState", "Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;", "(Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;)[Lkotlin/Pair;", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class CloseCaptureDialog implements ReportAction {
            public static final int $stable = 0;
            public static final CloseCaptureDialog INSTANCE = new CloseCaptureDialog();
            private static final String eventId = "app.login.verification.close.click";

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof CloseCaptureDialog) {
                    CloseCaptureDialog closeCaptureDialog = (CloseCaptureDialog) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return -60677066;
            }

            public String toString() {
                return "CloseCaptureDialog";
            }

            private CloseCaptureDialog() {
            }

            @Override // tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction.ReportAction
            public String getEventId() {
                return eventId;
            }

            @Override // tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction.ReportAction
            public Pair<String, String>[] getParams(IStepByStepSmsLoginPageState pageState) {
                Intrinsics.checkNotNullParameter(pageState, "pageState");
                return new Pair[0];
            }
        }

        /* compiled from: StepByStepSmsLoginAction.kt */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction$OnCaptureVerifySuccess;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction;", "<init>", "()V", "eventId", "", "getEventId", "()Ljava/lang/String;", "getParams", "", "Lkotlin/Pair;", "pageState", "Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;", "(Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;)[Lkotlin/Pair;", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class OnCaptureVerifySuccess implements ReportAction {
            public static final int $stable = 0;
            public static final OnCaptureVerifySuccess INSTANCE = new OnCaptureVerifySuccess();
            private static final String eventId = "app.login.verification.success.click";

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof OnCaptureVerifySuccess) {
                    OnCaptureVerifySuccess onCaptureVerifySuccess = (OnCaptureVerifySuccess) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return -1919469757;
            }

            public String toString() {
                return "OnCaptureVerifySuccess";
            }

            private OnCaptureVerifySuccess() {
            }

            @Override // tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction.ReportAction
            public String getEventId() {
                return eventId;
            }

            @Override // tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction.ReportAction
            public Pair<String, String>[] getParams(IStepByStepSmsLoginPageState pageState) {
                Intrinsics.checkNotNullParameter(pageState, "pageState");
                return new Pair[0];
            }
        }

        /* compiled from: StepByStepSmsLoginAction.kt */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction$ClickHelp;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction;", "<init>", "()V", "eventId", "", "getEventId", "()Ljava/lang/String;", "getParams", "", "Lkotlin/Pair;", "pageState", "Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;", "(Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;)[Lkotlin/Pair;", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class ClickHelp implements ReportAction {
            public static final int $stable = 0;
            public static final ClickHelp INSTANCE = new ClickHelp();
            private static final String eventId = "app.login.gethelp.0.click";

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof ClickHelp) {
                    ClickHelp clickHelp = (ClickHelp) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return 1534608841;
            }

            public String toString() {
                return "ClickHelp";
            }

            private ClickHelp() {
            }

            @Override // tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction.ReportAction
            public String getEventId() {
                return eventId;
            }

            @Override // tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction.ReportAction
            public Pair<String, String>[] getParams(IStepByStepSmsLoginPageState pageState) {
                Intrinsics.checkNotNullParameter(pageState, "pageState");
                return new Pair[0];
            }
        }

        /* compiled from: StepByStepSmsLoginAction.kt */
        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction$OnLoginSuccess;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction;", "method", "", "<init>", "(Ljava/lang/String;)V", "getMethod", "()Ljava/lang/String;", "eventId", "getEventId", "getParams", "", "Lkotlin/Pair;", "pageState", "Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;", "(Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;)[Lkotlin/Pair;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class OnLoginSuccess implements ReportAction {
            public static final int $stable = 0;
            private final String eventId;
            private final String method;

            public static /* synthetic */ OnLoginSuccess copy$default(OnLoginSuccess onLoginSuccess, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = onLoginSuccess.method;
                }
                return onLoginSuccess.copy(str);
            }

            public final String component1() {
                return this.method;
            }

            public final OnLoginSuccess copy(String str) {
                Intrinsics.checkNotNullParameter(str, "method");
                return new OnLoginSuccess(str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof OnLoginSuccess) && Intrinsics.areEqual(this.method, ((OnLoginSuccess) obj).method);
            }

            public int hashCode() {
                return this.method.hashCode();
            }

            public String toString() {
                return "OnLoginSuccess(method=" + this.method + ")";
            }

            public OnLoginSuccess(String method) {
                Intrinsics.checkNotNullParameter(method, "method");
                this.method = method;
                this.eventId = LoginReporterV2.Show.APP_LOGIN_SUCCEED_0_SHOW;
            }

            public final String getMethod() {
                return this.method;
            }

            @Override // tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction.ReportAction
            public String getEventId() {
                return this.eventId;
            }

            @Override // tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction.ReportAction
            public Pair<String, String>[] getParams(IStepByStepSmsLoginPageState pageState) {
                Intrinsics.checkNotNullParameter(pageState, "pageState");
                return new Pair[]{TuplesKt.to("method", this.method)};
            }
        }

        /* compiled from: StepByStepSmsLoginAction.kt */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction$OnRegisterSuccess;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction;", "<init>", "()V", "eventId", "", "getEventId", "()Ljava/lang/String;", "getParams", "", "Lkotlin/Pair;", "pageState", "Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;", "(Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;)[Lkotlin/Pair;", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class OnRegisterSuccess implements ReportAction {
            public static final int $stable = 0;
            public static final OnRegisterSuccess INSTANCE = new OnRegisterSuccess();
            private static final String eventId = LoginReporterV2.Show.APP_REGISTER_PASSED_0_SHOW;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof OnRegisterSuccess) {
                    OnRegisterSuccess onRegisterSuccess = (OnRegisterSuccess) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return 1562914017;
            }

            public String toString() {
                return "OnRegisterSuccess";
            }

            private OnRegisterSuccess() {
            }

            @Override // tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction.ReportAction
            public String getEventId() {
                return eventId;
            }

            @Override // tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction.ReportAction
            public Pair<String, String>[] getParams(IStepByStepSmsLoginPageState pageState) {
                Intrinsics.checkNotNullParameter(pageState, "pageState");
                return new Pair[0];
            }
        }
    }
}