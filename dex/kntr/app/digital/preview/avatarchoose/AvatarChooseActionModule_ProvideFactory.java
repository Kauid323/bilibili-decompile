package kntr.app.digital.preview.avatarchoose;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.digital.preview.action.ActionModule;
import kntr.app.digital.preview.closing.DismissRequest;
import kntr.app.digital.preview.loading.DigitalLoadingService;
import kntr.app.digital.preview.report.ReportService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.komponent.KomponentScope;
import kntr.common.trio.toast.Toaster;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AvatarChooseActionModule_ProvideFactory.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00142\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001:\u0001\u0014Ba\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004\u0012\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\f\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkntr/app/digital/preview/avatarchoose/AvatarChooseActionModule_ProvideFactory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/preview/action/ActionModule;", "reportServiceProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/report/ReportService;", "dismissRequestProvider", "Lkntr/app/digital/preview/closing/DismissRequest;", "toasterProvider", "Lkntr/common/trio/toast/Toaster;", "loadingServiceProvider", "Lkntr/app/digital/preview/loading/DigitalLoadingService;", "coroutineScopeProvider", "Lkotlinx/coroutines/CoroutineScope;", "komponentScopeProvider", "Lkntr/common/komponent/KomponentScope;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AvatarChooseActionModule_ProvideFactory implements Factory<ActionModule<?>> {
    private final Provider<CoroutineScope> coroutineScopeProvider;
    private final Provider<DismissRequest> dismissRequestProvider;
    private final Provider<KomponentScope<Unit>> komponentScopeProvider;
    private final Provider<DigitalLoadingService> loadingServiceProvider;
    private final Provider<ReportService> reportServiceProvider;
    private final Provider<Toaster> toasterProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public AvatarChooseActionModule_ProvideFactory(Provider<ReportService> provider, Provider<DismissRequest> provider2, Provider<Toaster> provider3, Provider<DigitalLoadingService> provider4, Provider<CoroutineScope> provider5, Provider<KomponentScope<Unit>> provider6) {
        Intrinsics.checkNotNullParameter(provider, "reportServiceProvider");
        Intrinsics.checkNotNullParameter(provider2, "dismissRequestProvider");
        Intrinsics.checkNotNullParameter(provider3, "toasterProvider");
        Intrinsics.checkNotNullParameter(provider4, "loadingServiceProvider");
        Intrinsics.checkNotNullParameter(provider5, "coroutineScopeProvider");
        Intrinsics.checkNotNullParameter(provider6, "komponentScopeProvider");
        this.reportServiceProvider = provider;
        this.dismissRequestProvider = provider2;
        this.toasterProvider = provider3;
        this.loadingServiceProvider = provider4;
        this.coroutineScopeProvider = provider5;
        this.komponentScopeProvider = provider6;
    }

    public ActionModule<?> get() {
        Companion companion = Companion;
        ReportService reportService = this.reportServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(reportService, "get(...)");
        DismissRequest dismissRequest = this.dismissRequestProvider.get();
        Intrinsics.checkNotNullExpressionValue(dismissRequest, "get(...)");
        Toaster toaster = this.toasterProvider.get();
        Intrinsics.checkNotNullExpressionValue(toaster, "get(...)");
        DigitalLoadingService digitalLoadingService = this.loadingServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(digitalLoadingService, "get(...)");
        CoroutineScope coroutineScope = this.coroutineScopeProvider.get();
        Intrinsics.checkNotNullExpressionValue(coroutineScope, "get(...)");
        KomponentScope<Unit> komponentScope = this.komponentScopeProvider.get();
        Intrinsics.checkNotNullExpressionValue(komponentScope, "get(...)");
        return companion.provide(reportService, dismissRequest, toaster, digitalLoadingService, coroutineScope, komponentScope);
    }

    /* compiled from: AvatarChooseActionModule_ProvideFactory.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jb\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0007H\u0007JB\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00102\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0007¨\u0006\u001c"}, d2 = {"Lkntr/app/digital/preview/avatarchoose/AvatarChooseActionModule_ProvideFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/preview/avatarchoose/AvatarChooseActionModule_ProvideFactory;", "reportServiceProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/report/ReportService;", "dismissRequestProvider", "Lkntr/app/digital/preview/closing/DismissRequest;", "toasterProvider", "Lkntr/common/trio/toast/Toaster;", "loadingServiceProvider", "Lkntr/app/digital/preview/loading/DigitalLoadingService;", "coroutineScopeProvider", "Lkotlinx/coroutines/CoroutineScope;", "komponentScopeProvider", "Lkntr/common/komponent/KomponentScope;", RoomRecommendViewModel.EMPTY_CURSOR, "provide", "Lkntr/app/digital/preview/action/ActionModule;", "reportService", "dismissRequest", "toaster", "loadingService", "coroutineScope", "komponentScope", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AvatarChooseActionModule_ProvideFactory create(Provider<ReportService> provider, Provider<DismissRequest> provider2, Provider<Toaster> provider3, Provider<DigitalLoadingService> provider4, Provider<CoroutineScope> provider5, Provider<KomponentScope<Unit>> provider6) {
            Intrinsics.checkNotNullParameter(provider, "reportServiceProvider");
            Intrinsics.checkNotNullParameter(provider2, "dismissRequestProvider");
            Intrinsics.checkNotNullParameter(provider3, "toasterProvider");
            Intrinsics.checkNotNullParameter(provider4, "loadingServiceProvider");
            Intrinsics.checkNotNullParameter(provider5, "coroutineScopeProvider");
            Intrinsics.checkNotNullParameter(provider6, "komponentScopeProvider");
            return new AvatarChooseActionModule_ProvideFactory(provider, provider2, provider3, provider4, provider5, provider6);
        }

        @JvmStatic
        public final ActionModule<?> provide(ReportService reportService, DismissRequest dismissRequest, Toaster toaster, DigitalLoadingService loadingService, CoroutineScope coroutineScope, KomponentScope<? super Unit> komponentScope) {
            Intrinsics.checkNotNullParameter(reportService, "reportService");
            Intrinsics.checkNotNullParameter(dismissRequest, "dismissRequest");
            Intrinsics.checkNotNullParameter(toaster, "toaster");
            Intrinsics.checkNotNullParameter(loadingService, "loadingService");
            Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
            Intrinsics.checkNotNullParameter(komponentScope, "komponentScope");
            return AvatarChooseActionModule.INSTANCE.provide(reportService, dismissRequest, toaster, loadingService, coroutineScope, komponentScope);
        }
    }

    @JvmStatic
    public static final AvatarChooseActionModule_ProvideFactory create(Provider<ReportService> provider, Provider<DismissRequest> provider2, Provider<Toaster> provider3, Provider<DigitalLoadingService> provider4, Provider<CoroutineScope> provider5, Provider<KomponentScope<Unit>> provider6) {
        return Companion.create(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @JvmStatic
    public static final ActionModule<?> provide(ReportService reportService, DismissRequest dismissRequest, Toaster toaster, DigitalLoadingService loadingService, CoroutineScope coroutineScope, KomponentScope<? super Unit> komponentScope) {
        return Companion.provide(reportService, dismissRequest, toaster, loadingService, coroutineScope, komponentScope);
    }
}