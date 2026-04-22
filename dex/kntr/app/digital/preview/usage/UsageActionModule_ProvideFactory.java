package kntr.app.digital.preview.usage;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.digital.preview.action.ActionModule;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.trio.toast.Toaster;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: UsageActionModule_ProvideFactory.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \r2\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001:\u0001\rB1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\n\u0010\u000bJ\f\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkntr/app/digital/preview/usage/UsageActionModule_ProvideFactory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/preview/action/ActionModule;", "coroutineScopeProvider", "Ljavax/inject/Provider;", "Lkotlinx/coroutines/CoroutineScope;", "usingMenuDialogServiceProvider", "Lkntr/app/digital/preview/usage/DigitalUsageMenuDialogService;", "toasterProvider", "Lkntr/common/trio/toast/Toaster;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UsageActionModule_ProvideFactory implements Factory<ActionModule<?>> {
    private final Provider<CoroutineScope> coroutineScopeProvider;
    private final Provider<Toaster> toasterProvider;
    private final Provider<DigitalUsageMenuDialogService> usingMenuDialogServiceProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public UsageActionModule_ProvideFactory(Provider<CoroutineScope> provider, Provider<DigitalUsageMenuDialogService> provider2, Provider<Toaster> provider3) {
        Intrinsics.checkNotNullParameter(provider, "coroutineScopeProvider");
        Intrinsics.checkNotNullParameter(provider2, "usingMenuDialogServiceProvider");
        Intrinsics.checkNotNullParameter(provider3, "toasterProvider");
        this.coroutineScopeProvider = provider;
        this.usingMenuDialogServiceProvider = provider2;
        this.toasterProvider = provider3;
    }

    public ActionModule<?> get() {
        Companion companion = Companion;
        CoroutineScope coroutineScope = this.coroutineScopeProvider.get();
        Intrinsics.checkNotNullExpressionValue(coroutineScope, "get(...)");
        DigitalUsageMenuDialogService digitalUsageMenuDialogService = this.usingMenuDialogServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(digitalUsageMenuDialogService, "get(...)");
        Toaster toaster = this.toasterProvider.get();
        Intrinsics.checkNotNullExpressionValue(toaster, "get(...)");
        return companion.provide(coroutineScope, digitalUsageMenuDialogService, toaster);
    }

    /* compiled from: UsageActionModule_ProvideFactory.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u0007J$\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\fH\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/digital/preview/usage/UsageActionModule_ProvideFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/preview/usage/UsageActionModule_ProvideFactory;", "coroutineScopeProvider", "Ljavax/inject/Provider;", "Lkotlinx/coroutines/CoroutineScope;", "usingMenuDialogServiceProvider", "Lkntr/app/digital/preview/usage/DigitalUsageMenuDialogService;", "toasterProvider", "Lkntr/common/trio/toast/Toaster;", "provide", "Lkntr/app/digital/preview/action/ActionModule;", "coroutineScope", "usingMenuDialogService", "toaster", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final UsageActionModule_ProvideFactory create(Provider<CoroutineScope> provider, Provider<DigitalUsageMenuDialogService> provider2, Provider<Toaster> provider3) {
            Intrinsics.checkNotNullParameter(provider, "coroutineScopeProvider");
            Intrinsics.checkNotNullParameter(provider2, "usingMenuDialogServiceProvider");
            Intrinsics.checkNotNullParameter(provider3, "toasterProvider");
            return new UsageActionModule_ProvideFactory(provider, provider2, provider3);
        }

        @JvmStatic
        public final ActionModule<?> provide(CoroutineScope coroutineScope, DigitalUsageMenuDialogService usingMenuDialogService, Toaster toaster) {
            Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
            Intrinsics.checkNotNullParameter(usingMenuDialogService, "usingMenuDialogService");
            Intrinsics.checkNotNullParameter(toaster, "toaster");
            return UsageActionModule.INSTANCE.provide(coroutineScope, usingMenuDialogService, toaster);
        }
    }

    @JvmStatic
    public static final UsageActionModule_ProvideFactory create(Provider<CoroutineScope> provider, Provider<DigitalUsageMenuDialogService> provider2, Provider<Toaster> provider3) {
        return Companion.create(provider, provider2, provider3);
    }

    @JvmStatic
    public static final ActionModule<?> provide(CoroutineScope coroutineScope, DigitalUsageMenuDialogService usingMenuDialogService, Toaster toaster) {
        return Companion.provide(coroutineScope, usingMenuDialogService, toaster);
    }
}