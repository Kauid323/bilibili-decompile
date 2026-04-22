package leakcanary.internal;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.work.Configuration;
import androidx.work.multiprocess.RemoteWorkerService;
import com.bilibili.lib.tribe.core.internal.Hooks;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.AppWatcher;
import leakcanary.internal.RemoteLeakCanaryWorkerService;

/* compiled from: RemoteLeakCanaryWorkerService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lleakcanary/internal/RemoteLeakCanaryWorkerService;", "Landroidx/work/multiprocess/RemoteWorkerService;", "()V", "fakeAppContext", "Lleakcanary/internal/RemoteLeakCanaryWorkerService$FakeAppContextConfigurationProvider;", "getFakeAppContext", "()Lleakcanary/internal/RemoteLeakCanaryWorkerService$FakeAppContextConfigurationProvider;", "fakeAppContext$delegate", "Lkotlin/Lazy;", "getApplicationContext", "Landroid/content/Context;", "onCreate", "", "FakeAppContextConfigurationProvider", "leakcanary-android-process_release"}, k = 1, mv = {1, 4, 1})
public final class RemoteLeakCanaryWorkerService extends RemoteWorkerService {
    private final Lazy fakeAppContext$delegate = LazyKt.lazy(new Function0<FakeAppContextConfigurationProvider>() { // from class: leakcanary.internal.RemoteLeakCanaryWorkerService$fakeAppContext$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final RemoteLeakCanaryWorkerService.FakeAppContextConfigurationProvider invoke() {
            Context applicationContext;
            applicationContext = super/*androidx.work.multiprocess.RemoteWorkerService*/.getApplicationContext();
            Intrinsics.checkExpressionValueIsNotNull(applicationContext, "super.getApplicationContext()");
            return new RemoteLeakCanaryWorkerService.FakeAppContextConfigurationProvider(applicationContext);
        }
    });

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    private final FakeAppContextConfigurationProvider getFakeAppContext() {
        return (FakeAppContextConfigurationProvider) this.fakeAppContext$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    /* compiled from: RemoteLeakCanaryWorkerService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0000H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lleakcanary/internal/RemoteLeakCanaryWorkerService$FakeAppContextConfigurationProvider;", "Landroid/content/ContextWrapper;", "Landroidx/work/Configuration$Provider;", "base", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getApplicationContext", "getWorkManagerConfiguration", "Landroidx/work/Configuration;", "leakcanary-android-process_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class FakeAppContextConfigurationProvider extends ContextWrapper implements Configuration.Provider {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FakeAppContextConfigurationProvider(Context base) {
            super(base);
            Intrinsics.checkParameterIsNotNull(base, "base");
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public FakeAppContextConfigurationProvider getApplicationContext() {
            return this;
        }

        public Configuration getWorkManagerConfiguration() {
            Configuration build = new Configuration.Builder().setDefaultProcessName(getPackageName()).build();
            Intrinsics.checkExpressionValueIsNotNull(build, "Configuration.Builder()\n…ckageName)\n      .build()");
            return build;
        }
    }

    public Context getApplicationContext() {
        return getFakeAppContext();
    }

    public void onCreate() {
        if (!AppWatcher.INSTANCE.isInstalled()) {
            Context applicationContext = super.getApplicationContext();
            if (applicationContext == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.app.Application");
            }
            Application application = (Application) applicationContext;
            AppWatcher.manualInstall$default(AppWatcher.INSTANCE, application, 0L, CollectionsKt.emptyList(), 2, null);
        }
        super.onCreate();
    }
}