package tv.danmaku.bili.helper;

import android.app.Application;
import com.bilibili.login.LoginPageState;
import com.bilibili.login.LoginPageStateHolder;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: LoginSuccessProcessor.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u001a\u001a\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\"\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\"\u0010\n\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\b\u0010\u000b\u001a\u00020\fH\u0007\"\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"processLoginSuccess", "", "application", "Landroid/app/Application;", "loginUIType", "Ltv/danmaku/bili/helper/LoginUIType;", "processLoginPageFinish", "onLoginPageEnter", LoginReporterV2.PAGE_FROM_KEY, "", "onLoginPageExit", "provideLoginPageState", "Lcom/bilibili/login/LoginPageStateHolder;", "pageState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/bilibili/login/LoginPageState;", "loginPage", "Ljava/util/LinkedList;", "Ljava/lang/ref/WeakReference;", "accountui_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginSuccessProcessorKt {
    private static final MutableStateFlow<LoginPageState> pageState = StateFlowKt.MutableStateFlow(new LoginPageState(false));
    private static final LinkedList<WeakReference<Object>> loginPage = new LinkedList<>();

    public static /* synthetic */ void processLoginSuccess$default(Application application, LoginUIType loginUIType, int i, Object obj) {
        if ((i & 2) != 0) {
            loginUIType = LoginUIType.UNKNOWN;
        }
        processLoginSuccess(application, loginUIType);
    }

    public static final void processLoginSuccess(Application application, LoginUIType loginUIType) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(loginUIType, "loginUIType");
        BLog.i("processLoginSuccess", loginUIType.name());
    }

    static /* synthetic */ void processLoginPageFinish$default(Application application, LoginUIType loginUIType, int i, Object obj) {
        if ((i & 2) != 0) {
            loginUIType = LoginUIType.UNKNOWN;
        }
        processLoginPageFinish(application, loginUIType);
    }

    private static final void processLoginPageFinish(Application application, LoginUIType loginUIType) {
        BLog.i("processLoginFinish", loginUIType.name());
    }

    public static /* synthetic */ void onLoginPageEnter$default(Object obj, Application application, LoginUIType loginUIType, int i, Object obj2) {
        if ((i & 4) != 0) {
            loginUIType = LoginUIType.UNKNOWN;
        }
        onLoginPageEnter(obj, application, loginUIType);
    }

    public static final void onLoginPageEnter(final Object page, Application application, LoginUIType loginUIType) {
        WeakReference it;
        Intrinsics.checkNotNullParameter(page, LoginReporterV2.PAGE_FROM_KEY);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(loginUIType, "loginUIType");
        BLog.i("onLoginPageEnter", loginUIType.name());
        CollectionsKt.removeAll(loginPage, new Function1() { // from class: tv.danmaku.bili.helper.LoginSuccessProcessorKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean onLoginPageEnter$lambda$0;
                onLoginPageEnter$lambda$0 = LoginSuccessProcessorKt.onLoginPageEnter$lambda$0(page, (WeakReference) obj);
                return Boolean.valueOf(onLoginPageEnter$lambda$0);
            }
        });
        loginPage.add(new WeakReference<>(page));
        MutableStateFlow<LoginPageState> mutableStateFlow = pageState;
        Iterable $this$any$iv = loginPage;
        boolean z = false;
        if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
            Iterator<T> it2 = $this$any$iv.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object element$iv = it2.next();
                WeakReference it3 = (WeakReference) element$iv;
                if (it3.get() != null) {
                    it = 1;
                    continue;
                } else {
                    it = null;
                    continue;
                }
                if (it != null) {
                    z = true;
                    break;
                }
            }
        }
        mutableStateFlow.setValue(new LoginPageState(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onLoginPageEnter$lambda$0(Object $page, WeakReference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.get(), $page) || it.get() == null;
    }

    public static /* synthetic */ void onLoginPageExit$default(Object obj, Application application, LoginUIType loginUIType, int i, Object obj2) {
        if ((i & 4) != 0) {
            loginUIType = LoginUIType.UNKNOWN;
        }
        onLoginPageExit(obj, application, loginUIType);
    }

    public static final void onLoginPageExit(final Object page, Application application, LoginUIType loginUIType) {
        WeakReference it;
        Intrinsics.checkNotNullParameter(page, LoginReporterV2.PAGE_FROM_KEY);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(loginUIType, "loginUIType");
        BLog.i("onLoginPageExit", loginUIType.name());
        CollectionsKt.removeAll(loginPage, new Function1() { // from class: tv.danmaku.bili.helper.LoginSuccessProcessorKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                boolean onLoginPageExit$lambda$0;
                onLoginPageExit$lambda$0 = LoginSuccessProcessorKt.onLoginPageExit$lambda$0(page, (WeakReference) obj);
                return Boolean.valueOf(onLoginPageExit$lambda$0);
            }
        });
        if (loginPage.isEmpty()) {
            processLoginPageFinish(application, loginUIType);
        }
        MutableStateFlow<LoginPageState> mutableStateFlow = pageState;
        Iterable $this$any$iv = loginPage;
        boolean z = false;
        if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
            Iterator<T> it2 = $this$any$iv.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object element$iv = it2.next();
                WeakReference it3 = (WeakReference) element$iv;
                if (it3.get() != null) {
                    it = 1;
                    continue;
                } else {
                    it = null;
                    continue;
                }
                if (it != null) {
                    z = true;
                    break;
                }
            }
        }
        mutableStateFlow.setValue(new LoginPageState(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onLoginPageExit$lambda$0(Object $page, WeakReference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.get(), $page) || it.get() == null;
    }

    public static final LoginPageStateHolder provideLoginPageState() {
        return new LoginPageStateHolderImpl();
    }
}