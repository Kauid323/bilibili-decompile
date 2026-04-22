package tv.danmaku.bili.fullscreen.state;

import BottomSheetItemData$;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.service.PhoneInfo;
import tv.danmaku.bili.fullscreen.stat.LoginWay;
import tv.danmaku.bili.fullscreen.stat.Unspecified;
import tv.danmaku.bili.normal.ui.EulaTriggerType;

/* compiled from: IFullscreenLoginPage.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0011\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0082\u0001\u0011\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006$À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenAction;", "SwitchToSms", "SwitchToPassword", "TryOtherLoginWay", "OnPhoneGetAction", "BackToLastPage", "SkipLogin", "DismissCaptchaAction", "NetCodeAuth", "NetCodeAuthResult", "NetCodeVerifyResult", "GoogleLogin", "FacebookLogin", "ShowEulaAction", "DismissEulaAction", "AgreementCheckedAction", "LoginAction", "RouterToSmsB1ExpLogin", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$AgreementCheckedAction;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$BackToLastPage;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$DismissCaptchaAction;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$DismissEulaAction;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$FacebookLogin;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$GoogleLogin;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$LoginAction;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$NetCodeAuth;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$NetCodeAuthResult;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$NetCodeVerifyResult;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$OnPhoneGetAction;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$RouterToSmsB1ExpLogin;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$ShowEulaAction;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$SkipLogin;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$SwitchToPassword;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$SwitchToSms;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$TryOtherLoginWay;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface IFullscreenLoginAction extends IFullscreenAction {

    /* compiled from: IFullscreenLoginPage.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$SwitchToSms;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction;", "report", "", "<init>", "(Z)V", "getReport", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class SwitchToSms implements IFullscreenLoginAction {
        public static final int $stable = 0;
        private final boolean report;

        public SwitchToSms() {
            this(false, 1, null);
        }

        public static /* synthetic */ SwitchToSms copy$default(SwitchToSms switchToSms, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = switchToSms.report;
            }
            return switchToSms.copy(z);
        }

        public final boolean component1() {
            return this.report;
        }

        public final SwitchToSms copy(boolean z) {
            return new SwitchToSms(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SwitchToSms) && this.report == ((SwitchToSms) obj).report;
        }

        public int hashCode() {
            return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.report);
        }

        public String toString() {
            return "SwitchToSms(report=" + this.report + ")";
        }

        public SwitchToSms(boolean report) {
            this.report = report;
        }

        public /* synthetic */ SwitchToSms(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? true : z);
        }

        public final boolean getReport() {
            return this.report;
        }
    }

    /* compiled from: IFullscreenLoginPage.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$SwitchToPassword;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction;", "<init>", "()V", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class SwitchToPassword implements IFullscreenLoginAction {
        public static final int $stable = 0;
        public static final SwitchToPassword INSTANCE = new SwitchToPassword();

        private SwitchToPassword() {
        }
    }

    /* compiled from: IFullscreenLoginPage.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$TryOtherLoginWay;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction;", "<init>", "()V", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class TryOtherLoginWay implements IFullscreenLoginAction {
        public static final int $stable = 0;
        public static final TryOtherLoginWay INSTANCE = new TryOtherLoginWay();

        private TryOtherLoginWay() {
        }
    }

    /* compiled from: IFullscreenLoginPage.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$OnPhoneGetAction;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction;", "phone", "Ltv/danmaku/bili/fullscreen/service/PhoneInfo;", "<init>", "(Ltv/danmaku/bili/fullscreen/service/PhoneInfo;)V", "getPhone", "()Ltv/danmaku/bili/fullscreen/service/PhoneInfo;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class OnPhoneGetAction implements IFullscreenLoginAction {
        public static final int $stable = 8;
        private final PhoneInfo phone;

        public static /* synthetic */ OnPhoneGetAction copy$default(OnPhoneGetAction onPhoneGetAction, PhoneInfo phoneInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                phoneInfo = onPhoneGetAction.phone;
            }
            return onPhoneGetAction.copy(phoneInfo);
        }

        public final PhoneInfo component1() {
            return this.phone;
        }

        public final OnPhoneGetAction copy(PhoneInfo phoneInfo) {
            Intrinsics.checkNotNullParameter(phoneInfo, "phone");
            return new OnPhoneGetAction(phoneInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnPhoneGetAction) && Intrinsics.areEqual(this.phone, ((OnPhoneGetAction) obj).phone);
        }

        public int hashCode() {
            return this.phone.hashCode();
        }

        public String toString() {
            return "OnPhoneGetAction(phone=" + this.phone + ")";
        }

        public OnPhoneGetAction(PhoneInfo phone) {
            Intrinsics.checkNotNullParameter(phone, "phone");
            this.phone = phone;
        }

        public final PhoneInfo getPhone() {
            return this.phone;
        }
    }

    /* compiled from: IFullscreenLoginPage.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$BackToLastPage;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction;", "<init>", "()V", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class BackToLastPage implements IFullscreenLoginAction {
        public static final int $stable = 0;
        public static final BackToLastPage INSTANCE = new BackToLastPage();

        private BackToLastPage() {
        }
    }

    /* compiled from: IFullscreenLoginPage.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$SkipLogin;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction;", "<init>", "()V", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class SkipLogin implements IFullscreenLoginAction {
        public static final int $stable = 0;
        public static final SkipLogin INSTANCE = new SkipLogin();

        private SkipLogin() {
        }
    }

    /* compiled from: IFullscreenLoginPage.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$DismissCaptchaAction;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction;", "<init>", "()V", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class DismissCaptchaAction implements IFullscreenLoginAction {
        public static final int $stable = 0;
        public static final DismissCaptchaAction INSTANCE = new DismissCaptchaAction();

        private DismissCaptchaAction() {
        }
    }

    /* compiled from: IFullscreenLoginPage.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$NetCodeAuth;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction;", "checkEula", "", "<init>", "(Z)V", "getCheckEula", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class NetCodeAuth implements IFullscreenLoginAction {
        public static final int $stable = 0;
        private final boolean checkEula;

        public NetCodeAuth() {
            this(false, 1, null);
        }

        public static /* synthetic */ NetCodeAuth copy$default(NetCodeAuth netCodeAuth, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = netCodeAuth.checkEula;
            }
            return netCodeAuth.copy(z);
        }

        public final boolean component1() {
            return this.checkEula;
        }

        public final NetCodeAuth copy(boolean z) {
            return new NetCodeAuth(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NetCodeAuth) && this.checkEula == ((NetCodeAuth) obj).checkEula;
        }

        public int hashCode() {
            return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.checkEula);
        }

        public String toString() {
            return "NetCodeAuth(checkEula=" + this.checkEula + ")";
        }

        public NetCodeAuth(boolean checkEula) {
            this.checkEula = checkEula;
        }

        public /* synthetic */ NetCodeAuth(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? true : z);
        }

        public final boolean getCheckEula() {
            return this.checkEula;
        }
    }

    /* compiled from: IFullscreenLoginPage.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003¢\u0006\u0004\b\u000b\u0010\bJ\u001e\u0010\f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$NetCodeAuthResult;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction;", "result", "Lkotlin/Result;", "Ltv/danmaku/bili/wauth/WAuthResult;", "<init>", "(Ljava/lang/Object;)V", "getResult-d1pmJ48", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component1-d1pmJ48", "copy", "(Ljava/lang/Object;)Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$NetCodeAuthResult;", "equals", "", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class NetCodeAuthResult implements IFullscreenLoginAction {
        public static final int $stable = 8;
        private final Object result;

        public static /* synthetic */ NetCodeAuthResult copy$default(NetCodeAuthResult netCodeAuthResult, Result result, int i, Object obj) {
            if ((i & 1) != 0) {
                result = Result.box-impl(netCodeAuthResult.result);
            }
            return netCodeAuthResult.copy(result.unbox-impl());
        }

        /* renamed from: component1-d1pmJ48  reason: not valid java name */
        public final Object m1109component1d1pmJ48() {
            return this.result;
        }

        public final NetCodeAuthResult copy(Object obj) {
            return new NetCodeAuthResult(obj);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NetCodeAuthResult) && Result.equals-impl0(this.result, ((NetCodeAuthResult) obj).result);
        }

        public int hashCode() {
            return Result.hashCode-impl(this.result);
        }

        public String toString() {
            return "NetCodeAuthResult(result=" + Result.toString-impl(this.result) + ")";
        }

        public NetCodeAuthResult(Object result) {
            this.result = result;
        }

        /* renamed from: getResult-d1pmJ48  reason: not valid java name */
        public final Object m1110getResultd1pmJ48() {
            return this.result;
        }
    }

    /* compiled from: IFullscreenLoginPage.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003¢\u0006\u0004\b\u000b\u0010\bJ\u001e\u0010\f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$NetCodeVerifyResult;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction;", "result", "Lkotlin/Result;", "Lcom/bilibili/lib/accountsui/ThirdLoginResult;", "<init>", "(Ljava/lang/Object;)V", "getResult-d1pmJ48", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component1-d1pmJ48", "copy", "(Ljava/lang/Object;)Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$NetCodeVerifyResult;", "equals", "", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class NetCodeVerifyResult implements IFullscreenLoginAction {
        public static final int $stable = 8;
        private final Object result;

        public static /* synthetic */ NetCodeVerifyResult copy$default(NetCodeVerifyResult netCodeVerifyResult, Result result, int i, Object obj) {
            if ((i & 1) != 0) {
                result = Result.box-impl(netCodeVerifyResult.result);
            }
            return netCodeVerifyResult.copy(result.unbox-impl());
        }

        /* renamed from: component1-d1pmJ48  reason: not valid java name */
        public final Object m1111component1d1pmJ48() {
            return this.result;
        }

        public final NetCodeVerifyResult copy(Object obj) {
            return new NetCodeVerifyResult(obj);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NetCodeVerifyResult) && Result.equals-impl0(this.result, ((NetCodeVerifyResult) obj).result);
        }

        public int hashCode() {
            return Result.hashCode-impl(this.result);
        }

        public String toString() {
            return "NetCodeVerifyResult(result=" + Result.toString-impl(this.result) + ")";
        }

        public NetCodeVerifyResult(Object result) {
            this.result = result;
        }

        /* renamed from: getResult-d1pmJ48  reason: not valid java name */
        public final Object m1112getResultd1pmJ48() {
            return this.result;
        }
    }

    /* compiled from: IFullscreenLoginPage.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$GoogleLogin;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction;", "<init>", "()V", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class GoogleLogin implements IFullscreenLoginAction {
        public static final int $stable = 0;
        public static final GoogleLogin INSTANCE = new GoogleLogin();

        private GoogleLogin() {
        }
    }

    /* compiled from: IFullscreenLoginPage.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$FacebookLogin;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction;", "<init>", "()V", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class FacebookLogin implements IFullscreenLoginAction {
        public static final int $stable = 0;
        public static final FacebookLogin INSTANCE = new FacebookLogin();

        private FacebookLogin() {
        }
    }

    /* compiled from: IFullscreenLoginPage.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$ShowEulaAction;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction;", "triggerType", "Ltv/danmaku/bili/normal/ui/EulaTriggerType;", "<init>", "(Ltv/danmaku/bili/normal/ui/EulaTriggerType;)V", "getTriggerType", "()Ltv/danmaku/bili/normal/ui/EulaTriggerType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class ShowEulaAction implements IFullscreenLoginAction {
        public static final int $stable = 0;
        private final EulaTriggerType triggerType;

        public ShowEulaAction() {
            this(null, 1, null);
        }

        public static /* synthetic */ ShowEulaAction copy$default(ShowEulaAction showEulaAction, EulaTriggerType eulaTriggerType, int i, Object obj) {
            if ((i & 1) != 0) {
                eulaTriggerType = showEulaAction.triggerType;
            }
            return showEulaAction.copy(eulaTriggerType);
        }

        public final EulaTriggerType component1() {
            return this.triggerType;
        }

        public final ShowEulaAction copy(EulaTriggerType eulaTriggerType) {
            Intrinsics.checkNotNullParameter(eulaTriggerType, "triggerType");
            return new ShowEulaAction(eulaTriggerType);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowEulaAction) && this.triggerType == ((ShowEulaAction) obj).triggerType;
        }

        public int hashCode() {
            return this.triggerType.hashCode();
        }

        public String toString() {
            return "ShowEulaAction(triggerType=" + this.triggerType + ")";
        }

        public ShowEulaAction(EulaTriggerType triggerType) {
            Intrinsics.checkNotNullParameter(triggerType, "triggerType");
            this.triggerType = triggerType;
        }

        public /* synthetic */ ShowEulaAction(EulaTriggerType eulaTriggerType, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? EulaTriggerType.Submit : eulaTriggerType);
        }

        public final EulaTriggerType getTriggerType() {
            return this.triggerType;
        }
    }

    /* compiled from: IFullscreenLoginPage.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$DismissEulaAction;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction;", "agreed", "", "<init>", "(Z)V", "getAgreed", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class DismissEulaAction implements IFullscreenLoginAction {
        public static final int $stable = 0;
        private final boolean agreed;

        public static /* synthetic */ DismissEulaAction copy$default(DismissEulaAction dismissEulaAction, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = dismissEulaAction.agreed;
            }
            return dismissEulaAction.copy(z);
        }

        public final boolean component1() {
            return this.agreed;
        }

        public final DismissEulaAction copy(boolean z) {
            return new DismissEulaAction(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DismissEulaAction) && this.agreed == ((DismissEulaAction) obj).agreed;
        }

        public int hashCode() {
            return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.agreed);
        }

        public String toString() {
            return "DismissEulaAction(agreed=" + this.agreed + ")";
        }

        public DismissEulaAction(boolean agreed) {
            this.agreed = agreed;
        }

        public final boolean getAgreed() {
            return this.agreed;
        }
    }

    /* compiled from: IFullscreenLoginPage.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$AgreementCheckedAction;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction;", "checked", "", "<init>", "(Z)V", "getChecked", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AgreementCheckedAction implements IFullscreenLoginAction {
        public static final int $stable = 0;
        private final boolean checked;

        public static /* synthetic */ AgreementCheckedAction copy$default(AgreementCheckedAction agreementCheckedAction, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = agreementCheckedAction.checked;
            }
            return agreementCheckedAction.copy(z);
        }

        public final boolean component1() {
            return this.checked;
        }

        public final AgreementCheckedAction copy(boolean z) {
            return new AgreementCheckedAction(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AgreementCheckedAction) && this.checked == ((AgreementCheckedAction) obj).checked;
        }

        public int hashCode() {
            return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.checked);
        }

        public String toString() {
            return "AgreementCheckedAction(checked=" + this.checked + ")";
        }

        public AgreementCheckedAction(boolean checked) {
            this.checked = checked;
        }

        public final boolean getChecked() {
            return this.checked;
        }
    }

    /* compiled from: IFullscreenLoginPage.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$LoginAction;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction;", "loginWay", "Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "report", "", "captcha", "", "", "<init>", "(Ltv/danmaku/bili/fullscreen/stat/LoginWay;ZLjava/util/Map;)V", "getLoginWay", "()Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "getReport", "()Z", "getCaptcha", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class LoginAction implements IFullscreenLoginAction {
        public static final int $stable = 8;
        private final Map<String, String> captcha;
        private final LoginWay loginWay;
        private final boolean report;

        public LoginAction() {
            this(null, false, null, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LoginAction copy$default(LoginAction loginAction, LoginWay loginWay, boolean z, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                loginWay = loginAction.loginWay;
            }
            if ((i & 2) != 0) {
                z = loginAction.report;
            }
            if ((i & 4) != 0) {
                map = loginAction.captcha;
            }
            return loginAction.copy(loginWay, z, map);
        }

        public final LoginWay component1() {
            return this.loginWay;
        }

        public final boolean component2() {
            return this.report;
        }

        public final Map<String, String> component3() {
            return this.captcha;
        }

        public final LoginAction copy(LoginWay loginWay, boolean z, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(loginWay, "loginWay");
            Intrinsics.checkNotNullParameter(map, "captcha");
            return new LoginAction(loginWay, z, map);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LoginAction) {
                LoginAction loginAction = (LoginAction) obj;
                return Intrinsics.areEqual(this.loginWay, loginAction.loginWay) && this.report == loginAction.report && Intrinsics.areEqual(this.captcha, loginAction.captcha);
            }
            return false;
        }

        public int hashCode() {
            return (((this.loginWay.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.report)) * 31) + this.captcha.hashCode();
        }

        public String toString() {
            LoginWay loginWay = this.loginWay;
            boolean z = this.report;
            return "LoginAction(loginWay=" + loginWay + ", report=" + z + ", captcha=" + this.captcha + ")";
        }

        public LoginAction(LoginWay loginWay, boolean report, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(loginWay, "loginWay");
            Intrinsics.checkNotNullParameter(map, "captcha");
            this.loginWay = loginWay;
            this.report = report;
            this.captcha = map;
        }

        public /* synthetic */ LoginAction(Unspecified unspecified, boolean z, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? Unspecified.INSTANCE : unspecified, (i & 2) != 0 ? false : z, (i & 4) != 0 ? MapsKt.emptyMap() : map);
        }

        public final LoginWay getLoginWay() {
            return this.loginWay;
        }

        public final boolean getReport() {
            return this.report;
        }

        public final Map<String, String> getCaptcha() {
            return this.captcha;
        }
    }

    /* compiled from: IFullscreenLoginPage.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$RouterToSmsB1ExpLogin;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class RouterToSmsB1ExpLogin implements IFullscreenLoginAction {
        public static final int $stable = 0;
        public static final RouterToSmsB1ExpLogin INSTANCE = new RouterToSmsB1ExpLogin();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RouterToSmsB1ExpLogin) {
                RouterToSmsB1ExpLogin routerToSmsB1ExpLogin = (RouterToSmsB1ExpLogin) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1035868718;
        }

        public String toString() {
            return "RouterToSmsB1ExpLogin";
        }

        private RouterToSmsB1ExpLogin() {
        }
    }
}