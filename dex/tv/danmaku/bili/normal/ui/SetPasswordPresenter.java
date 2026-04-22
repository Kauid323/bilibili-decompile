package tv.danmaku.bili.normal.ui;

import android.text.TextUtils;
import bili.resource.account.R;
import bolts.CancellationTokenSource;
import bolts.Continuation;
import bolts.Task;
import com.bilibili.lib.accounts.AccountException;
import com.bilibili.lib.accountsui.utils.AuthStatusErrorHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.normal.ui.SetPasswordContract;
import tv.danmaku.bili.normal.ui.SetPasswordPresenter;
import tv.danmaku.bili.safe.BiliSafeHelper;

/* compiled from: SetPasswordPresenter.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/normal/ui/SetPasswordPresenter;", "Ltv/danmaku/bili/normal/ui/SetPasswordContract$Presenter;", "mView", "Ltv/danmaku/bili/normal/ui/SetPasswordContract$View;", "<init>", "(Ltv/danmaku/bili/normal/ui/SetPasswordContract$View;)V", "mSetPwdToken", "Lbolts/CancellationTokenSource;", "mLogoutListener", "Ltv/danmaku/bili/normal/ui/SetPasswordContract$LogoutListener;", "checkPassword", "", "pwd", "setPassword", "", "setLogoutListener", "l", "callLogout", "SetPwdResult", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SetPasswordPresenter implements SetPasswordContract.Presenter {
    public static final int $stable = 8;
    private SetPasswordContract.LogoutListener mLogoutListener;
    private CancellationTokenSource mSetPwdToken;
    private final SetPasswordContract.View mView;

    public SetPasswordPresenter(SetPasswordContract.View mView) {
        Intrinsics.checkNotNullParameter(mView, "mView");
        this.mView = mView;
    }

    @Override // tv.danmaku.bili.normal.ui.SetPasswordContract.Presenter
    public String checkPassword(String pwd) {
        Intrinsics.checkNotNullParameter(pwd, "pwd");
        if (TextUtils.isEmpty(pwd)) {
            String string = this.mView.getContextSelf().getString(R.string.account_global_string_112);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        } else if (pwd.length() > 16) {
            String string2 = this.mView.getContextSelf().getString(R.string.account_global_string_38);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        } else if (pwd.length() < 6) {
            String string3 = this.mView.getContextSelf().getString(R.string.account_global_string_180);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            return string3;
        } else {
            return "";
        }
    }

    @Override // tv.danmaku.bili.normal.ui.SetPasswordContract.Presenter
    public void setPassword(final String pwd) {
        Intrinsics.checkNotNullParameter(pwd, "pwd");
        this.mView.showProgress();
        this.mSetPwdToken = new CancellationTokenSource();
        Callable callable = new Callable() { // from class: tv.danmaku.bili.normal.ui.SetPasswordPresenter$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                SetPasswordPresenter.SetPwdResult password$lambda$0;
                password$lambda$0 = SetPasswordPresenter.setPassword$lambda$0(pwd, this);
                return password$lambda$0;
            }
        };
        CancellationTokenSource cancellationTokenSource = this.mSetPwdToken;
        Task callInBackground = Task.callInBackground(callable, cancellationTokenSource != null ? cancellationTokenSource.getToken() : null);
        Continuation continuation = new Continuation() { // from class: tv.danmaku.bili.normal.ui.SetPasswordPresenter$$ExternalSyntheticLambda1
            public final Object then(Task task) {
                Unit password$lambda$1;
                password$lambda$1 = SetPasswordPresenter.setPassword$lambda$1(SetPasswordPresenter.this, task);
                return password$lambda$1;
            }
        };
        Executor executor = Task.UI_THREAD_EXECUTOR;
        CancellationTokenSource cancellationTokenSource2 = this.mSetPwdToken;
        callInBackground.continueWith(continuation, executor, cancellationTokenSource2 != null ? cancellationTokenSource2.getToken() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SetPwdResult setPassword$lambda$0(String $pwd, SetPasswordPresenter this$0) {
        SetPwdResult result = new SetPwdResult();
        try {
            BiliSafeHelper.setPassWord($pwd, this$0.mView.getContextSelf());
        } catch (AccountException e) {
            result.setMAccountException$accountui_apinkDebug(e);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setPassword$lambda$1(SetPasswordPresenter this$0, Task task) {
        this$0.mView.hideProgress();
        task.isCancelled();
        if (((SetPwdResult) task.getResult()).getMAccountException$accountui_apinkDebug() != null) {
            SetPasswordContract.View view = this$0.mView;
            AccountException mAccountException$accountui_apinkDebug = ((SetPwdResult) task.getResult()).getMAccountException$accountui_apinkDebug();
            SetPasswordContract.View view2 = this$0.mView;
            Intrinsics.checkNotNull(view2);
            view.showTips(AuthStatusErrorHelper.parseTips(mAccountException$accountui_apinkDebug, view2.getContextSelf().getString(R.string.account_global_string_184)));
        } else {
            this$0.mView.showTips(Integer.valueOf(R.string.account_global_string_154));
            this$0.mView.setPwdSucceed();
        }
        return Unit.INSTANCE;
    }

    @Override // tv.danmaku.bili.normal.ui.SetPasswordContract.Presenter
    public void setLogoutListener(SetPasswordContract.LogoutListener l) {
        Intrinsics.checkNotNullParameter(l, "l");
        this.mLogoutListener = l;
    }

    @Override // tv.danmaku.bili.normal.ui.SetPasswordContract.Presenter
    public void callLogout() {
        SetPasswordContract.LogoutListener logoutListener = this.mLogoutListener;
        if (logoutListener != null) {
            logoutListener.callLogout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SetPasswordPresenter.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/normal/ui/SetPasswordPresenter$SetPwdResult;", "", "<init>", "()V", "mAccountException", "Lcom/bilibili/lib/accounts/AccountException;", "getMAccountException$accountui_apinkDebug", "()Lcom/bilibili/lib/accounts/AccountException;", "setMAccountException$accountui_apinkDebug", "(Lcom/bilibili/lib/accounts/AccountException;)V", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class SetPwdResult {
        private AccountException mAccountException;

        public final AccountException getMAccountException$accountui_apinkDebug() {
            return this.mAccountException;
        }

        public final void setMAccountException$accountui_apinkDebug(AccountException accountException) {
            this.mAccountException = accountException;
        }
    }
}