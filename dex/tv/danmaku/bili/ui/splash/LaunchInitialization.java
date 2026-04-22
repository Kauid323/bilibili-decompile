package tv.danmaku.bili.ui.splash;

import android.content.Context;
import android.os.SystemClock;
import android.util.Pair;
import androidx.core.os.TraceCompat;
import bolts.Continuation;
import bolts.Task;
import com.bilibili.app.comm.servercomm.ServerClock;
import com.bilibili.base.BiliContext;
import com.bilibili.base.Bootstrap;
import com.bilibili.lib.biliid.api.EnvironmentManager;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.performance.EntryPointKt;
import com.bilibili.lib.router.Router;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.OnlineParamsHelper;
import tv.danmaku.bili.bilow.BilowHelper;
import tv.danmaku.bili.mod.ModManagerHelper;
import tv.danmaku.bili.report.startup.StartupApm;
import tv.danmaku.bili.utils.DelayInitHelper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: LaunchInitialization.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\bJ!\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010\rJ/\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010H\u0007¢\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Ltv/danmaku/bili/ui/splash/LaunchInitialization;", "", "<init>", "()V", "mInitialization", "Lbolts/Task;", "", "mHasInit", "", "firstBoot", "init", "context", "Landroid/content/Context;", "(Landroid/content/Context;Ljava/lang/Boolean;)V", "initAndWait", "listener", "Lkotlin/Function0;", "(Landroid/content/Context;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function0;)V", "initializeModules", "delayInitForNetwork", "startUpWithUI", "startUpWithWorker", "Ljava/lang/Void;", "initModRes", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class LaunchInitialization {
    private static boolean mHasInit;
    private static Task<Unit> mInitialization;
    public static final LaunchInitialization INSTANCE = new LaunchInitialization();
    public static final int $stable = 8;

    public final void init(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        init$default(this, context, null, 2, null);
    }

    public final void initAndWait(Context context, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function0, "listener");
        initAndWait$default(this, context, null, function0, 2, null);
    }

    private LaunchInitialization() {
    }

    public final boolean firstBoot() {
        return EnvironmentManager.getInstance().isFirstStart();
    }

    public static /* synthetic */ void init$default(LaunchInitialization launchInitialization, Context context, Boolean bool, int i, Object obj) {
        if ((i & 2) != 0) {
            bool = null;
        }
        launchInitialization.init(context, bool);
    }

    public final void init(Context context, Boolean firstBoot) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!mHasInit && mInitialization == null) {
            boolean bool = firstBoot != null ? firstBoot.booleanValue() : firstBoot();
            mInitialization = startUpWithWorker(context).continueWith(new Continuation() { // from class: tv.danmaku.bili.ui.splash.LaunchInitialization$$ExternalSyntheticLambda1
                public final Object then(Task task) {
                    Unit init$lambda$0;
                    init$lambda$0 = LaunchInitialization.init$lambda$0(task);
                    return init$lambda$0;
                }
            });
            startUpWithUI(context, bool);
            return;
        }
        BLog.w("LaunchInitialization", "Launch init has already started!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit init$lambda$0(Task it) {
        mHasInit = true;
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void initAndWait$default(LaunchInitialization launchInitialization, Context context, Boolean bool, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            bool = null;
        }
        launchInitialization.initAndWait(context, bool, function0);
    }

    public final void initAndWait(Context context, Boolean firstBoot, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function0, "listener");
        if (mHasInit) {
            function0.invoke();
            return;
        }
        if (mInitialization == null) {
            init(context, firstBoot);
        }
        if (EntryPointKt.getBootOptEnable()) {
            Task<Unit> task = mInitialization;
            if (task != null) {
                task.continueWith(new Continuation() { // from class: tv.danmaku.bili.ui.splash.LaunchInitialization$$ExternalSyntheticLambda2
                    public final Object then(Task task2) {
                        Unit initAndWait$lambda$0;
                        initAndWait$lambda$0 = LaunchInitialization.initAndWait$lambda$0(function0, task2);
                        return initAndWait$lambda$0;
                    }
                }, Task.BACKGROUND_EXECUTOR);
                return;
            }
            return;
        }
        Task<Unit> task2 = mInitialization;
        if (task2 != null) {
            task2.continueWith(new Continuation() { // from class: tv.danmaku.bili.ui.splash.LaunchInitialization$$ExternalSyntheticLambda3
                public final Object then(Task task3) {
                    Unit initAndWait$lambda$1;
                    initAndWait$lambda$1 = LaunchInitialization.initAndWait$lambda$1(function0, task3);
                    return initAndWait$lambda$1;
                }
            }, Task.UI_THREAD_EXECUTOR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initAndWait$lambda$0(Function0 $listener, Task it) {
        $listener.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initAndWait$lambda$1(Function0 $listener, Task it) {
        $listener.invoke();
        return Unit.INSTANCE;
    }

    public final void initializeModules(Context context) {
        Iterator it;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            TraceCompat.beginSection("initializeModules");
            long start = SystemClock.elapsedRealtime();
            if (EntryPointKt.getBootOptEnable()) {
                Iterable $this$forEach$iv = Router.Companion.global().getBootstraps();
                for (Object element$iv : $this$forEach$iv) {
                    BuildersKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new LaunchInitialization$initializeModules$1$1$1((Pair) element$iv, context, null), 3, (Object) null);
                }
            } else {
                Iterable $this$forEach$iv2 = Router.Companion.global().getBootstraps();
                Iterator it2 = $this$forEach$iv2.iterator();
                while (it2.hasNext()) {
                    Object element$iv2 = it2.next();
                    Pair it3 = (Pair) element$iv2;
                    String name$iv = "module " + it3.first;
                    TraceCompat.beginSection(name$iv);
                    Bootstrap bootstrap = (Bootstrap) it3.second;
                    if (bootstrap != null) {
                        it = it2;
                        bootstrap.bootInProcess(context, BiliContext.currentProcessName());
                    } else {
                        it = it2;
                    }
                    Unit unit = Unit.INSTANCE;
                    TraceCompat.endSection();
                    it2 = it;
                }
            }
            StartupApm.setBizBootTime(SystemClock.elapsedRealtime() - start);
            Unit unit2 = Unit.INSTANCE;
        } finally {
            TraceCompat.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void delayInitForNetwork(Context context) {
        OnlineParamsHelper.tryUpdateInBackground();
        BilowHelper.preFetchHttpDNS(context);
        initModRes(context);
    }

    private final void startUpWithUI(final Context context, boolean firstBoot) {
        ServerClock.fetchCurrentTimeMillis();
        if (DelayInitHelper.Companion.needDelayInit()) {
            DelayInitHelper.Companion.registerDelayInitTask(new DelayInitHelper.DelayInitTask() { // from class: tv.danmaku.bili.ui.splash.LaunchInitialization$startUpWithUI$1
                @Override // tv.danmaku.bili.utils.DelayInitHelper.DelayInitTask
                public void onExecute() {
                    LaunchInitialization.INSTANCE.delayInitForNetwork(context);
                }
            });
        } else {
            delayInitForNetwork(context);
        }
        try {
            TraceCompat.beginSection("startUpWithUI");
            if (EntryPointKt.getBootOptEnable()) {
                Iterable $this$forEach$iv = Router.Companion.global().getLaunches();
                for (Object element$iv : $this$forEach$iv) {
                    BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), (CoroutineStart) null, new LaunchInitialization$startUpWithUI$2$1$1((Pair) element$iv, context, null), 2, (Object) null);
                }
            } else {
                Iterable $this$forEach$iv2 = Router.Companion.global().getLaunches();
                for (Object element$iv2 : $this$forEach$iv2) {
                    Pair it = (Pair) element$iv2;
                    String name$iv = "startUp " + it.first;
                    TraceCompat.beginSection(name$iv);
                    Bootstrap.Launch launch = (Bootstrap.Launch) it.second;
                    if (launch != null) {
                        launch.launchWithUI(context, BiliContext.currentProcessName());
                    }
                    Unit unit = Unit.INSTANCE;
                    TraceCompat.endSection();
                }
            }
            Unit unit2 = Unit.INSTANCE;
            TraceCompat.endSection();
            BLRouter.INSTANCE.postCreateModules();
        } catch (Throwable th) {
            TraceCompat.endSection();
            throw th;
        }
    }

    private final Task<Void> startUpWithWorker(final Context context) {
        Iterable $this$map$iv = Router.Companion.global().getLaunches();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            final Pair it = (Pair) item$iv$iv;
            destination$iv$iv.add(Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.ui.splash.LaunchInitialization$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Unit startUpWithWorker$lambda$0$0;
                    startUpWithWorker$lambda$0$0 = LaunchInitialization.startUpWithWorker$lambda$0$0(it, context);
                    return startUpWithWorker$lambda$0$0;
                }
            }));
        }
        Task<Void> whenAll = Task.whenAll((List) destination$iv$iv);
        Intrinsics.checkNotNullExpressionValue(whenAll, "whenAll(...)");
        return whenAll;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startUpWithWorker$lambda$0$0(Pair $it, Context $context) {
        Unit unit;
        String name$iv = "startUpWithWorker " + $it.first;
        try {
            TraceCompat.beginSection(name$iv);
            Bootstrap.Launch launch = (Bootstrap.Launch) $it.second;
            if (launch != null) {
                launch.launchWithWorker($context, BiliContext.currentProcessName());
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            return unit;
        } finally {
            TraceCompat.endSection();
        }
    }

    private final void initModRes(Context context) {
        ModManagerHelper.updateAllAsync(context, false);
    }
}