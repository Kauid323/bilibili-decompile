package tv.danmaku.bili.fullscreen.state;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.eula.EulaLinkType;
import tv.danmaku.bili.normal.ui.EulaTriggerType;

/* compiled from: IFullscreenLoginPage.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\b\u0002\u0003\u0004\u0005\u0006\u0007\b\t\u0082\u0001\b\n\u000b\f\r\u000e\u000f\u0010\u0011ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginReportAction;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenAction;", "LoginHelpClick", "LoginForgetClick", "FindPwdByPhone", "FindPwdByEMail", "ShowCaptchaDialog", "CaptchaVerified", "CaptchaClosed", "EulaLinkClicked", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginReportAction$CaptchaClosed;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginReportAction$CaptchaVerified;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginReportAction$EulaLinkClicked;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginReportAction$FindPwdByEMail;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginReportAction$FindPwdByPhone;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginReportAction$LoginForgetClick;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginReportAction$LoginHelpClick;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginReportAction$ShowCaptchaDialog;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface IFullscreenLoginReportAction extends IFullscreenAction {

    /* compiled from: IFullscreenLoginPage.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginReportAction$LoginHelpClick;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginReportAction;", "<init>", "()V", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class LoginHelpClick implements IFullscreenLoginReportAction {
        public static final int $stable = 0;
        public static final LoginHelpClick INSTANCE = new LoginHelpClick();

        private LoginHelpClick() {
        }
    }

    /* compiled from: IFullscreenLoginPage.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginReportAction$LoginForgetClick;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginReportAction;", "<init>", "()V", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class LoginForgetClick implements IFullscreenLoginReportAction {
        public static final int $stable = 0;
        public static final LoginForgetClick INSTANCE = new LoginForgetClick();

        private LoginForgetClick() {
        }
    }

    /* compiled from: IFullscreenLoginPage.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginReportAction$FindPwdByPhone;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginReportAction;", "<init>", "()V", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class FindPwdByPhone implements IFullscreenLoginReportAction {
        public static final int $stable = 0;
        public static final FindPwdByPhone INSTANCE = new FindPwdByPhone();

        private FindPwdByPhone() {
        }
    }

    /* compiled from: IFullscreenLoginPage.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginReportAction$FindPwdByEMail;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginReportAction;", "<init>", "()V", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class FindPwdByEMail implements IFullscreenLoginReportAction {
        public static final int $stable = 0;
        public static final FindPwdByEMail INSTANCE = new FindPwdByEMail();

        private FindPwdByEMail() {
        }
    }

    /* compiled from: IFullscreenLoginPage.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginReportAction$ShowCaptchaDialog;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginReportAction;", "<init>", "()V", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class ShowCaptchaDialog implements IFullscreenLoginReportAction {
        public static final int $stable = 0;
        public static final ShowCaptchaDialog INSTANCE = new ShowCaptchaDialog();

        private ShowCaptchaDialog() {
        }
    }

    /* compiled from: IFullscreenLoginPage.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginReportAction$CaptchaVerified;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginReportAction;", "<init>", "()V", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class CaptchaVerified implements IFullscreenLoginReportAction {
        public static final int $stable = 0;
        public static final CaptchaVerified INSTANCE = new CaptchaVerified();

        private CaptchaVerified() {
        }
    }

    /* compiled from: IFullscreenLoginPage.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginReportAction$CaptchaClosed;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginReportAction;", "<init>", "()V", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class CaptchaClosed implements IFullscreenLoginReportAction {
        public static final int $stable = 0;
        public static final CaptchaClosed INSTANCE = new CaptchaClosed();

        private CaptchaClosed() {
        }
    }

    /* compiled from: IFullscreenLoginPage.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginReportAction$EulaLinkClicked;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginReportAction;", "type", "Ltv/danmaku/bili/eula/EulaLinkType;", "inDialog", "", "triggerType", "Ltv/danmaku/bili/normal/ui/EulaTriggerType;", "<init>", "(Ltv/danmaku/bili/eula/EulaLinkType;ZLtv/danmaku/bili/normal/ui/EulaTriggerType;)V", "getType", "()Ltv/danmaku/bili/eula/EulaLinkType;", "getInDialog", "()Z", "getTriggerType", "()Ltv/danmaku/bili/normal/ui/EulaTriggerType;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class EulaLinkClicked implements IFullscreenLoginReportAction {
        public static final int $stable = 8;
        private final boolean inDialog;
        private final EulaTriggerType triggerType;
        private final EulaLinkType type;

        public static /* synthetic */ EulaLinkClicked copy$default(EulaLinkClicked eulaLinkClicked, EulaLinkType eulaLinkType, boolean z, EulaTriggerType eulaTriggerType, int i, Object obj) {
            if ((i & 1) != 0) {
                eulaLinkType = eulaLinkClicked.type;
            }
            if ((i & 2) != 0) {
                z = eulaLinkClicked.inDialog;
            }
            if ((i & 4) != 0) {
                eulaTriggerType = eulaLinkClicked.triggerType;
            }
            return eulaLinkClicked.copy(eulaLinkType, z, eulaTriggerType);
        }

        public final EulaLinkType component1() {
            return this.type;
        }

        public final boolean component2() {
            return this.inDialog;
        }

        public final EulaTriggerType component3() {
            return this.triggerType;
        }

        public final EulaLinkClicked copy(EulaLinkType eulaLinkType, boolean z, EulaTriggerType eulaTriggerType) {
            Intrinsics.checkNotNullParameter(eulaLinkType, "type");
            return new EulaLinkClicked(eulaLinkType, z, eulaTriggerType);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof EulaLinkClicked) {
                EulaLinkClicked eulaLinkClicked = (EulaLinkClicked) obj;
                return Intrinsics.areEqual(this.type, eulaLinkClicked.type) && this.inDialog == eulaLinkClicked.inDialog && this.triggerType == eulaLinkClicked.triggerType;
            }
            return false;
        }

        public int hashCode() {
            return (((this.type.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.inDialog)) * 31) + (this.triggerType == null ? 0 : this.triggerType.hashCode());
        }

        public String toString() {
            EulaLinkType eulaLinkType = this.type;
            boolean z = this.inDialog;
            return "EulaLinkClicked(type=" + eulaLinkType + ", inDialog=" + z + ", triggerType=" + this.triggerType + ")";
        }

        public EulaLinkClicked(EulaLinkType type, boolean inDialog, EulaTriggerType triggerType) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
            this.inDialog = inDialog;
            this.triggerType = triggerType;
        }

        public /* synthetic */ EulaLinkClicked(EulaLinkType eulaLinkType, boolean z, EulaTriggerType eulaTriggerType, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(eulaLinkType, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : eulaTriggerType);
        }

        public final boolean getInDialog() {
            return this.inDialog;
        }

        public final EulaTriggerType getTriggerType() {
            return this.triggerType;
        }

        public final EulaLinkType getType() {
            return this.type;
        }
    }
}