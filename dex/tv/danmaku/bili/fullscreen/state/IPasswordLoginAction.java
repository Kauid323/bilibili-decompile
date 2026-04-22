package tv.danmaku.bili.fullscreen.state;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: PasswordLoginPageState.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/IPasswordLoginAction;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenAction;", "AccountInputAction", "PasswordInputAction", "Ltv/danmaku/bili/fullscreen/state/IPasswordLoginAction$AccountInputAction;", "Ltv/danmaku/bili/fullscreen/state/IPasswordLoginAction$PasswordInputAction;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface IPasswordLoginAction extends IFullscreenAction {

    /* compiled from: PasswordLoginPageState.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/IPasswordLoginAction$AccountInputAction;", "Ltv/danmaku/bili/fullscreen/state/IPasswordLoginAction;", "account", "", "<init>", "(Ljava/lang/String;)V", "getAccount", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AccountInputAction implements IPasswordLoginAction {
        public static final int $stable = 0;
        private final String account;

        public static /* synthetic */ AccountInputAction copy$default(AccountInputAction accountInputAction, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = accountInputAction.account;
            }
            return accountInputAction.copy(str);
        }

        public final String component1() {
            return this.account;
        }

        public final AccountInputAction copy(String str) {
            Intrinsics.checkNotNullParameter(str, "account");
            return new AccountInputAction(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AccountInputAction) && Intrinsics.areEqual(this.account, ((AccountInputAction) obj).account);
        }

        public int hashCode() {
            return this.account.hashCode();
        }

        public String toString() {
            return "AccountInputAction(account=" + this.account + ")";
        }

        public AccountInputAction(String account) {
            Intrinsics.checkNotNullParameter(account, "account");
            this.account = account;
        }

        public final String getAccount() {
            return this.account;
        }
    }

    /* compiled from: PasswordLoginPageState.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/IPasswordLoginAction$PasswordInputAction;", "Ltv/danmaku/bili/fullscreen/state/IPasswordLoginAction;", "password", "", "<init>", "(Ljava/lang/String;)V", "getPassword", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class PasswordInputAction implements IPasswordLoginAction {
        public static final int $stable = 0;
        private final String password;

        public static /* synthetic */ PasswordInputAction copy$default(PasswordInputAction passwordInputAction, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = passwordInputAction.password;
            }
            return passwordInputAction.copy(str);
        }

        public final String component1() {
            return this.password;
        }

        public final PasswordInputAction copy(String str) {
            Intrinsics.checkNotNullParameter(str, "password");
            return new PasswordInputAction(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PasswordInputAction) && Intrinsics.areEqual(this.password, ((PasswordInputAction) obj).password);
        }

        public int hashCode() {
            return this.password.hashCode();
        }

        public String toString() {
            return "PasswordInputAction(password=" + this.password + ")";
        }

        public PasswordInputAction(String password) {
            Intrinsics.checkNotNullParameter(password, "password");
            this.password = password;
        }

        public final String getPassword() {
            return this.password;
        }
    }
}