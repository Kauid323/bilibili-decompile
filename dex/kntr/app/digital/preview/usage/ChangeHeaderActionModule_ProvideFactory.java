package kntr.app.digital.preview.usage;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.digital.preview.action.ActionModule;
import kntr.app.digital.preview.closing.DismissRequest;
import kntr.app.digital.preview.report.ReportService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.router.Router;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ChangeHeaderActionModule_ProvideFactory.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00112\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001:\u0001\u0011BM\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\f\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkntr/app/digital/preview/usage/ChangeHeaderActionModule_ProvideFactory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/preview/action/ActionModule;", "restrictionDialogServiceProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/usage/DigitalUsageRestrictionDialogService;", "coroutineScopeProvider", "Lkotlinx/coroutines/CoroutineScope;", "reportServiceProvider", "Lkntr/app/digital/preview/report/ReportService;", "routerProvider", "Lkntr/base/router/Router;", "dismissRequestProvider", "Lkntr/app/digital/preview/closing/DismissRequest;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChangeHeaderActionModule_ProvideFactory implements Factory<ActionModule<?>> {
    private final Provider<CoroutineScope> coroutineScopeProvider;
    private final Provider<DismissRequest> dismissRequestProvider;
    private final Provider<ReportService> reportServiceProvider;
    private final Provider<DigitalUsageRestrictionDialogService> restrictionDialogServiceProvider;
    private final Provider<Router> routerProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public ChangeHeaderActionModule_ProvideFactory(Provider<DigitalUsageRestrictionDialogService> provider, Provider<CoroutineScope> provider2, Provider<ReportService> provider3, Provider<Router> provider4, Provider<DismissRequest> provider5) {
        Intrinsics.checkNotNullParameter(provider, "restrictionDialogServiceProvider");
        Intrinsics.checkNotNullParameter(provider2, "coroutineScopeProvider");
        Intrinsics.checkNotNullParameter(provider3, "reportServiceProvider");
        Intrinsics.checkNotNullParameter(provider4, "routerProvider");
        Intrinsics.checkNotNullParameter(provider5, "dismissRequestProvider");
        this.restrictionDialogServiceProvider = provider;
        this.coroutineScopeProvider = provider2;
        this.reportServiceProvider = provider3;
        this.routerProvider = provider4;
        this.dismissRequestProvider = provider5;
    }

    public ActionModule<?> get() {
        Companion companion = Companion;
        DigitalUsageRestrictionDialogService digitalUsageRestrictionDialogService = this.restrictionDialogServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(digitalUsageRestrictionDialogService, "get(...)");
        CoroutineScope coroutineScope = this.coroutineScopeProvider.get();
        Intrinsics.checkNotNullExpressionValue(coroutineScope, "get(...)");
        ReportService reportService = this.reportServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(reportService, "get(...)");
        Router router = this.routerProvider.get();
        Intrinsics.checkNotNullExpressionValue(router, "get(...)");
        DismissRequest dismissRequest = this.dismissRequestProvider.get();
        Intrinsics.checkNotNullExpressionValue(dismissRequest, "get(...)");
        return companion.provide(digitalUsageRestrictionDialogService, coroutineScope, reportService, router, dismissRequest);
    }

    /* compiled from: ChangeHeaderActionModule_ProvideFactory.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JN\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007H\u0007J4\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00122\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0010H\u0007¨\u0006\u0018"}, d2 = {"Lkntr/app/digital/preview/usage/ChangeHeaderActionModule_ProvideFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/preview/usage/ChangeHeaderActionModule_ProvideFactory;", "restrictionDialogServiceProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/usage/DigitalUsageRestrictionDialogService;", "coroutineScopeProvider", "Lkotlinx/coroutines/CoroutineScope;", "reportServiceProvider", "Lkntr/app/digital/preview/report/ReportService;", "routerProvider", "Lkntr/base/router/Router;", "dismissRequestProvider", "Lkntr/app/digital/preview/closing/DismissRequest;", "provide", "Lkntr/app/digital/preview/action/ActionModule;", "restrictionDialogService", "coroutineScope", "reportService", "router", "dismissRequest", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ChangeHeaderActionModule_ProvideFactory create(Provider<DigitalUsageRestrictionDialogService> provider, Provider<CoroutineScope> provider2, Provider<ReportService> provider3, Provider<Router> provider4, Provider<DismissRequest> provider5) {
            Intrinsics.checkNotNullParameter(provider, "restrictionDialogServiceProvider");
            Intrinsics.checkNotNullParameter(provider2, "coroutineScopeProvider");
            Intrinsics.checkNotNullParameter(provider3, "reportServiceProvider");
            Intrinsics.checkNotNullParameter(provider4, "routerProvider");
            Intrinsics.checkNotNullParameter(provider5, "dismissRequestProvider");
            return new ChangeHeaderActionModule_ProvideFactory(provider, provider2, provider3, provider4, provider5);
        }

        @JvmStatic
        public final ActionModule<?> provide(DigitalUsageRestrictionDialogService restrictionDialogService, CoroutineScope coroutineScope, ReportService reportService, Router router, DismissRequest dismissRequest) {
            Intrinsics.checkNotNullParameter(restrictionDialogService, "restrictionDialogService");
            Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
            Intrinsics.checkNotNullParameter(reportService, "reportService");
            Intrinsics.checkNotNullParameter(router, "router");
            Intrinsics.checkNotNullParameter(dismissRequest, "dismissRequest");
            return ChangeHeaderActionModule.INSTANCE.provide(restrictionDialogService, coroutineScope, reportService, router, dismissRequest);
        }
    }

    @JvmStatic
    public static final ChangeHeaderActionModule_ProvideFactory create(Provider<DigitalUsageRestrictionDialogService> provider, Provider<CoroutineScope> provider2, Provider<ReportService> provider3, Provider<Router> provider4, Provider<DismissRequest> provider5) {
        return Companion.create(provider, provider2, provider3, provider4, provider5);
    }

    @JvmStatic
    public static final ActionModule<?> provide(DigitalUsageRestrictionDialogService restrictionDialogService, CoroutineScope coroutineScope, ReportService reportService, Router router, DismissRequest dismissRequest) {
        return Companion.provide(restrictionDialogService, coroutineScope, reportService, router, dismissRequest);
    }
}