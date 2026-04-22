package leakcanary;

import android.app.Application;
import android.os.SystemClock;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.internal.ApplicationsKt;
import leakcanary.internal.HandlersKt;
import leakcanary.internal.LeakCanaryDelegate;

/* compiled from: AppWatcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001$B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 J*\u0010!\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u0017\u001a\u00020\u00042\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R$\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006%"}, d2 = {"Lleakcanary/AppWatcher;", "", "()V", "RETAINED_DELAY_NOT_SET", "", "config", "Lleakcanary/AppWatcher$Config;", "getConfig$annotations", "getConfig", "()Lleakcanary/AppWatcher$Config;", "setConfig", "(Lleakcanary/AppWatcher$Config;)V", "installCause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "isInstalled", "", "()Z", "objectWatcher", "Lleakcanary/ObjectWatcher;", "getObjectWatcher", "()Lleakcanary/ObjectWatcher;", "<set-?>", "retainedDelayMillis", "getRetainedDelayMillis", "()J", "appDefaultWatchers", "", "Lleakcanary/InstallableWatcher;", "application", "Landroid/app/Application;", "reachabilityWatcher", "Lleakcanary/ReachabilityWatcher;", "manualInstall", "", "watchersToInstall", "Config", "leakcanary-object-watcher-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class AppWatcher {
    private static final long RETAINED_DELAY_NOT_SET = -1;
    private static Exception installCause;
    public static final AppWatcher INSTANCE = new AppWatcher();
    private static volatile long retainedDelayMillis = -1;
    private static final ObjectWatcher objectWatcher = new ObjectWatcher(new Clock() { // from class: leakcanary.AppWatcher$objectWatcher$1
        @Override // leakcanary.Clock
        public final long uptimeMillis() {
            return SystemClock.uptimeMillis();
        }
    }, new Executor() { // from class: leakcanary.AppWatcher$objectWatcher$2
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable it) {
            if (!AppWatcher.INSTANCE.isInstalled()) {
                throw new IllegalStateException("AppWatcher not installed".toString());
            }
            HandlersKt.getMainHandler().postDelayed(it, AppWatcher.INSTANCE.getRetainedDelayMillis());
        }
    }, new Function0<Boolean>() { // from class: leakcanary.AppWatcher$objectWatcher$3
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return true;
        }
    });
    private static volatile Config config = new Config(false, false, false, false, 0, false, 63, null);

    @Deprecated(message = "Configuration moved to AppWatcher.manualInstall()")
    @JvmStatic
    public static /* synthetic */ void getConfig$annotations() {
    }

    public final void manualInstall(Application application) {
        manualInstall$default(this, application, 0L, null, 6, null);
    }

    public final void manualInstall(Application application, long j) {
        manualInstall$default(this, application, j, null, 4, null);
    }

    private AppWatcher() {
    }

    public final long getRetainedDelayMillis() {
        return retainedDelayMillis;
    }

    public final ObjectWatcher getObjectWatcher() {
        return objectWatcher;
    }

    public final boolean isInstalled() {
        return installCause != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void manualInstall$default(AppWatcher appWatcher, Application application, long j, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            j = TimeUnit.SECONDS.toMillis(5L);
        }
        if ((i & 4) != 0) {
            list = appDefaultWatchers$default(appWatcher, application, null, 2, null);
        }
        appWatcher.manualInstall(application, j, list);
    }

    public final void manualInstall(Application application, long retainedDelayMillis2, List<? extends InstallableWatcher> watchersToInstall) {
        Intrinsics.checkParameterIsNotNull(application, "application");
        Intrinsics.checkParameterIsNotNull(watchersToInstall, "watchersToInstall");
        HandlersKt.checkMainThread();
        if (isInstalled()) {
            throw new IllegalStateException("AppWatcher already installed, see exception cause for prior install call", installCause);
        }
        if (!(retainedDelayMillis2 >= 0)) {
            throw new IllegalStateException(("retainedDelayMillis " + retainedDelayMillis2 + " must be at least 0 ms").toString());
        }
        retainedDelayMillis = retainedDelayMillis2;
        if (ApplicationsKt.isDebuggableBuild(application)) {
            LogcatSharkLog.Companion.install();
        }
        LeakCanaryDelegate.INSTANCE.getLoadLeakCanary().invoke(application);
        List<? extends InstallableWatcher> $this$forEach$iv = watchersToInstall;
        for (Object element$iv : $this$forEach$iv) {
            InstallableWatcher it = (InstallableWatcher) element$iv;
            it.install();
        }
        installCause = new RuntimeException("manualInstall() first called here");
    }

    public static /* synthetic */ List appDefaultWatchers$default(AppWatcher appWatcher, Application application, ReachabilityWatcher reachabilityWatcher, int i, Object obj) {
        if ((i & 2) != 0) {
            reachabilityWatcher = objectWatcher;
        }
        return appWatcher.appDefaultWatchers(application, reachabilityWatcher);
    }

    public final List<InstallableWatcher> appDefaultWatchers(Application application, ReachabilityWatcher reachabilityWatcher) {
        Intrinsics.checkParameterIsNotNull(application, "application");
        Intrinsics.checkParameterIsNotNull(reachabilityWatcher, "reachabilityWatcher");
        return CollectionsKt.listOf((Object[]) new InstallableWatcher[]{new ActivityWatcher(application, reachabilityWatcher), new FragmentAndViewModelWatcher(application, reachabilityWatcher), new RootViewWatcher(reachabilityWatcher), new ServiceWatcher(reachabilityWatcher)});
    }

    /* compiled from: AppWatcher.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001:\u0001)BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003JE\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\b\u0010%\u001a\u00020&H\u0007J\t\u0010'\u001a\u00020(HÖ\u0001R\u001c\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u000eR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u000eR\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\f\u001a\u0004\b\u0019\u0010\u000e¨\u0006*"}, d2 = {"Lleakcanary/AppWatcher$Config;", "", "watchActivities", "", "watchFragments", "watchFragmentViews", "watchViewModels", "watchDurationMillis", "", "enabled", "(ZZZZJZ)V", "getEnabled$annotations", "()V", "getEnabled", "()Z", "getWatchActivities$annotations", "getWatchActivities", "getWatchDurationMillis$annotations", "getWatchDurationMillis", "()J", "getWatchFragmentViews$annotations", "getWatchFragmentViews", "getWatchFragments$annotations", "getWatchFragments", "getWatchViewModels$annotations", "getWatchViewModels", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "newBuilder", "Lleakcanary/AppWatcher$Config$Builder;", "toString", "", "Builder", "leakcanary-object-watcher-android-core_release"}, k = 1, mv = {1, 4, 1})
    @Deprecated(message = "Call AppWatcher.manualInstall() ")
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Config {
        private final boolean enabled;
        private final boolean watchActivities;
        private final long watchDurationMillis;
        private final boolean watchFragmentViews;
        private final boolean watchFragments;
        private final boolean watchViewModels;

        public Config() {
            this(false, false, false, false, 0L, false, 63, null);
        }

        public static /* synthetic */ Config copy$default(Config config, boolean z, boolean z2, boolean z3, boolean z4, long j, boolean z5, int i, Object obj) {
            if ((i & 1) != 0) {
                z = config.watchActivities;
            }
            if ((i & 2) != 0) {
                z2 = config.watchFragments;
            }
            boolean z6 = z2;
            if ((i & 4) != 0) {
                z3 = config.watchFragmentViews;
            }
            boolean z7 = z3;
            if ((i & 8) != 0) {
                z4 = config.watchViewModels;
            }
            boolean z8 = z4;
            if ((i & 16) != 0) {
                j = config.watchDurationMillis;
            }
            long j2 = j;
            if ((i & 32) != 0) {
                z5 = config.enabled;
            }
            return config.copy(z, z6, z7, z8, j2, z5);
        }

        @Deprecated(message = "Call AppWatcher.appDefaultWatchers() with a custom ReachabilityWatcher")
        public static /* synthetic */ void getEnabled$annotations() {
        }

        @Deprecated(message = "Call AppWatcher.manualInstall() with a custom watcher list")
        public static /* synthetic */ void getWatchActivities$annotations() {
        }

        @Deprecated(message = "Call AppWatcher.manualInstall() with a custom retainedDelayMillis value")
        public static /* synthetic */ void getWatchDurationMillis$annotations() {
        }

        @Deprecated(message = "Call AppWatcher.manualInstall() with a custom watcher list")
        public static /* synthetic */ void getWatchFragmentViews$annotations() {
        }

        @Deprecated(message = "Call AppWatcher.manualInstall() with a custom watcher list")
        public static /* synthetic */ void getWatchFragments$annotations() {
        }

        @Deprecated(message = "Call AppWatcher.manualInstall() with a custom watcher list")
        public static /* synthetic */ void getWatchViewModels$annotations() {
        }

        public final boolean component1() {
            return this.watchActivities;
        }

        public final boolean component2() {
            return this.watchFragments;
        }

        public final boolean component3() {
            return this.watchFragmentViews;
        }

        public final boolean component4() {
            return this.watchViewModels;
        }

        public final long component5() {
            return this.watchDurationMillis;
        }

        public final boolean component6() {
            return this.enabled;
        }

        public final Config copy(boolean z, boolean z2, boolean z3, boolean z4, long j, boolean z5) {
            return new Config(z, z2, z3, z4, j, z5);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof Config) {
                    Config config = (Config) obj;
                    return this.watchActivities == config.watchActivities && this.watchFragments == config.watchFragments && this.watchFragmentViews == config.watchFragmentViews && this.watchViewModels == config.watchViewModels && this.watchDurationMillis == config.watchDurationMillis && this.enabled == config.enabled;
                }
                return false;
            }
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v13 */
        /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
        public int hashCode() {
            boolean z = this.watchActivities;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            int i = r0 * 31;
            ?? r2 = this.watchFragments;
            int i2 = r2;
            if (r2 != 0) {
                i2 = 1;
            }
            int i3 = (i + i2) * 31;
            ?? r22 = this.watchFragmentViews;
            int i4 = r22;
            if (r22 != 0) {
                i4 = 1;
            }
            int i5 = (i3 + i4) * 31;
            ?? r23 = this.watchViewModels;
            int i6 = r23;
            if (r23 != 0) {
                i6 = 1;
            }
            long j = this.watchDurationMillis;
            int i7 = (((i5 + i6) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
            boolean z2 = this.enabled;
            return i7 + (z2 ? 1 : z2 ? 1 : 0);
        }

        public String toString() {
            return "Config(watchActivities=" + this.watchActivities + ", watchFragments=" + this.watchFragments + ", watchFragmentViews=" + this.watchFragmentViews + ", watchViewModels=" + this.watchViewModels + ", watchDurationMillis=" + this.watchDurationMillis + ", enabled=" + this.enabled + ")";
        }

        public Config(boolean watchActivities, boolean watchFragments, boolean watchFragmentViews, boolean watchViewModels, long watchDurationMillis, boolean enabled) {
            this.watchActivities = watchActivities;
            this.watchFragments = watchFragments;
            this.watchFragmentViews = watchFragmentViews;
            this.watchViewModels = watchViewModels;
            this.watchDurationMillis = watchDurationMillis;
            this.enabled = enabled;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ Config(boolean z, boolean z2, boolean z3, boolean z4, long j, boolean z5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(r15, r1, r2, r3, r4, r14);
            boolean z6;
            boolean z7;
            boolean z8;
            long j2;
            boolean z9;
            boolean z10 = (i & 1) != 0 ? true : z;
            if ((i & 2) == 0) {
                z6 = z2;
            } else {
                z6 = true;
            }
            if ((i & 4) == 0) {
                z7 = z3;
            } else {
                z7 = true;
            }
            if ((i & 8) == 0) {
                z8 = z4;
            } else {
                z8 = true;
            }
            if ((i & 16) == 0) {
                j2 = j;
            } else {
                j2 = TimeUnit.SECONDS.toMillis(5L);
            }
            if ((i & 32) == 0) {
                z9 = z5;
            } else {
                z9 = true;
            }
        }

        public final boolean getWatchActivities() {
            return this.watchActivities;
        }

        public final boolean getWatchFragments() {
            return this.watchFragments;
        }

        public final boolean getWatchFragmentViews() {
            return this.watchFragmentViews;
        }

        public final boolean getWatchViewModels() {
            return this.watchViewModels;
        }

        public final long getWatchDurationMillis() {
            return this.watchDurationMillis;
        }

        public final boolean getEnabled() {
            return this.enabled;
        }

        @Deprecated(message = "Configuration moved to AppWatcher.manualInstall()", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public final Builder newBuilder() {
            return new Builder(this);
        }

        /* compiled from: AppWatcher.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\u0003H\u0007J\u0010\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0006H\u0007J\u0010\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0006H\u0007J\u0010\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0006H\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lleakcanary/AppWatcher$Config$Builder;", "", "config", "Lleakcanary/AppWatcher$Config;", "(Lleakcanary/AppWatcher$Config;)V", "watchActivities", "", "watchDurationMillis", "", "watchFragmentViews", "watchFragments", "watchViewModels", "build", "enabled", "leakcanary-object-watcher-android-core_release"}, k = 1, mv = {1, 4, 1})
        @Deprecated(message = "Configuration moved to XML resources")
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        public static final class Builder {
            private boolean watchActivities;
            private long watchDurationMillis;
            private boolean watchFragmentViews;
            private boolean watchFragments;
            private boolean watchViewModels;

            public Builder(Config config) {
                Intrinsics.checkParameterIsNotNull(config, "config");
                this.watchActivities = config.getWatchActivities();
                this.watchFragments = config.getWatchFragments();
                this.watchFragmentViews = config.getWatchFragmentViews();
                this.watchViewModels = config.getWatchViewModels();
                this.watchDurationMillis = config.getWatchDurationMillis();
            }

            @Deprecated(message = "see [Config.enabled]", replaceWith = @ReplaceWith(expression = "", imports = {}))
            public final Builder enabled(boolean enabled) {
                return this;
            }

            @Deprecated(message = "see [Config.watchActivities]", replaceWith = @ReplaceWith(expression = "", imports = {}))
            public final Builder watchActivities(boolean watchActivities) {
                Builder $this$apply = this;
                $this$apply.watchActivities = watchActivities;
                return this;
            }

            @Deprecated(message = "see [Config.watchFragments]", replaceWith = @ReplaceWith(expression = "", imports = {}))
            public final Builder watchFragments(boolean watchFragments) {
                Builder $this$apply = this;
                $this$apply.watchFragments = watchFragments;
                return this;
            }

            @Deprecated(message = "see [Config.watchFragmentViews]", replaceWith = @ReplaceWith(expression = "", imports = {}))
            public final Builder watchFragmentViews(boolean watchFragmentViews) {
                Builder $this$apply = this;
                $this$apply.watchFragmentViews = watchFragmentViews;
                return this;
            }

            @Deprecated(message = "see [Config.watchViewModels]", replaceWith = @ReplaceWith(expression = "", imports = {}))
            public final Builder watchViewModels(boolean watchViewModels) {
                Builder $this$apply = this;
                $this$apply.watchViewModels = watchViewModels;
                return this;
            }

            @Deprecated(message = "see [Config.watchDurationMillis]", replaceWith = @ReplaceWith(expression = "", imports = {}))
            public final Builder watchDurationMillis(long watchDurationMillis) {
                Builder $this$apply = this;
                $this$apply.watchDurationMillis = watchDurationMillis;
                return this;
            }

            @Deprecated(message = "Configuration moved to AppWatcher.manualInstall()")
            public final Config build() {
                return Config.copy$default(AppWatcher.getConfig(), this.watchActivities, this.watchFragments, this.watchFragmentViews, this.watchViewModels, this.watchDurationMillis, false, 32, null);
            }
        }
    }

    public static final Config getConfig() {
        return config;
    }

    public static final void setConfig(Config config2) {
        Intrinsics.checkParameterIsNotNull(config2, "<set-?>");
        config = config2;
    }
}