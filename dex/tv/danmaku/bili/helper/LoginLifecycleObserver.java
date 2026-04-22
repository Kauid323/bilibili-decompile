package tv.danmaku.bili.helper;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import java.util.HashSet;
import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.reg.LoginRegLifecycleObserver;
import tv.danmaku.bili.report.LoginReportLifecycleObserver;

/* compiled from: LoginLifecycleObserver.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0007J\b\u0010\n\u001a\u00020\tH\u0007R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/helper/LoginLifecycleObserver;", "Landroidx/lifecycle/LifecycleObserver;", "<init>", "()V", "observerList", "Ljava/util/HashSet;", "Ltv/danmaku/bili/helper/ILifecycleObserver;", "Lkotlin/collections/HashSet;", "increaseCountDownLatch", "", "decreaseCountDownLatch", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginLifecycleObserver implements LifecycleObserver {
    public static final int $stable;
    public static final LoginLifecycleObserver INSTANCE = new LoginLifecycleObserver();
    private static final HashSet<ILifecycleObserver> observerList = new HashSet<>();

    private LoginLifecycleObserver() {
    }

    static {
        HashSet $this$_init__u24lambda_u240 = observerList;
        $this$_init__u24lambda_u240.add(LoginRegLifecycleObserver.INSTANCE);
        $this$_init__u24lambda_u240.add(LoginReportLifecycleObserver.INSTANCE);
        $stable = 8;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void increaseCountDownLatch() {
        Iterable $this$forEach$iv = observerList;
        for (Object element$iv : $this$forEach$iv) {
            ILifecycleObserver it = (ILifecycleObserver) element$iv;
            it.increaseCountDownLatch();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void decreaseCountDownLatch() {
        Iterable $this$forEach$iv = observerList;
        for (Object element$iv : $this$forEach$iv) {
            ILifecycleObserver it = (ILifecycleObserver) element$iv;
            it.decreaseCountDownLatch();
        }
    }
}