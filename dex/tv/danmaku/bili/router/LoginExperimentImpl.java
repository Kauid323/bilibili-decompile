package tv.danmaku.bili.router;

import com.bilibili.module.account.ILoginExperiment;
import com.bilibili.module.account.LoginInterestExperiment;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.quick.ui.LoginQuickActivityV2;

/* compiled from: LoginExperimentImpl.kt */
@Singleton
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/router/LoginExperimentImpl;", "Lcom/bilibili/module/account/ILoginExperiment;", "<init>", "()V", LoginQuickActivityV2.INTENT_KEY_LOGIN_EXPERIMENT, "", "setLoginExperiment", "", "experiment", "getLoginExperiment", "interestDismissFlag", "Lcom/bilibili/module/account/LoginInterestExperiment;", "getInterestDismissFlag", "setInterestDismissFlag", "flag", "isNewRegUser", "setNewRegUser", "newReg", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@Named("ILoginExperiment")
public final class LoginExperimentImpl implements ILoginExperiment {
    public static final int $stable = 8;
    private LoginInterestExperiment interestDismissFlag = LoginInterestExperiment.Control;
    private boolean isNewRegUser;
    private boolean loginExperiment;

    public void setLoginExperiment(boolean experiment) {
        this.loginExperiment = experiment;
    }

    public boolean getLoginExperiment() {
        return this.loginExperiment;
    }

    public LoginInterestExperiment getInterestDismissFlag() {
        return this.interestDismissFlag;
    }

    public void setInterestDismissFlag(LoginInterestExperiment flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        this.interestDismissFlag = flag;
    }

    public boolean isNewRegUser() {
        return this.isNewRegUser;
    }

    public void setNewRegUser(boolean newReg) {
        this.isNewRegUser = newReg;
    }
}