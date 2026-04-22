package tv.danmaku.bili.reg;

import kotlin.Metadata;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.helper.ILifecycleObserver;

/* compiled from: LoginRegLifecycleObserver.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/reg/LoginRegLifecycleObserver;", "Ltv/danmaku/bili/helper/ILifecycleObserver;", "<init>", "()V", "TAG", "", "increaseCountDownLatch", "", "decreaseCountDownLatch", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginRegLifecycleObserver implements ILifecycleObserver {
    public static final int $stable = 0;
    public static final LoginRegLifecycleObserver INSTANCE = new LoginRegLifecycleObserver();
    private static final String TAG = "LoginRegLifecycleObserver";

    private LoginRegLifecycleObserver() {
    }

    @Override // tv.danmaku.bili.helper.ILifecycleObserver
    public void increaseCountDownLatch() {
        LoginRegHelper.INSTANCE.setCountDownLatch(LoginRegHelper.INSTANCE.getCountDownLatch() + 1);
        BLog.i(TAG, "onCreate current count  = " + LoginRegHelper.INSTANCE.getCountDownLatch());
    }

    @Override // tv.danmaku.bili.helper.ILifecycleObserver
    public void decreaseCountDownLatch() {
        LoginRegHelper.INSTANCE.setCountDownLatch(LoginRegHelper.INSTANCE.getCountDownLatch() - 1);
        if (LoginRegHelper.INSTANCE.getCountDownLatch() <= 0) {
            LoginRegHelper.INSTANCE.setCountDownLatch(0);
            LoginRegHelper.INSTANCE.setRegCheckStatus(false);
        }
        BLog.i(TAG, "onDestroy current count  = " + LoginRegHelper.INSTANCE.getCountDownLatch());
    }
}