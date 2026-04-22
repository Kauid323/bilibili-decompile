package kntr.app.digital.preview.splashsetting;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.digital.preview.action.ActionModule;
import kntr.app.digital.preview.report.ReportService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.router.Router;
import kntr.common.trio.toast.Toaster;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SplashSettingActionModule_ProvideFactory.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00132\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001:\u0001\u0013B[\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\f\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkntr/app/digital/preview/splashsetting/SplashSettingActionModule_ProvideFactory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/preview/action/ActionModule;", "reportServiceProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/report/ReportService;", "coroutineScopeProvider", "Lkotlinx/coroutines/CoroutineScope;", "splashSettingInfoProvider", "Lkntr/app/digital/preview/splashsetting/SplashSettingInfo;", "splashSettingNoticeDialogServiceProvider", "Lkntr/app/digital/preview/splashsetting/DLCSplashSettingNoticeDialogService;", "toasterProvider", "Lkntr/common/trio/toast/Toaster;", "routerProvider", "Lkntr/base/router/Router;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SplashSettingActionModule_ProvideFactory implements Factory<ActionModule<?>> {
    private final Provider<CoroutineScope> coroutineScopeProvider;
    private final Provider<ReportService> reportServiceProvider;
    private final Provider<Router> routerProvider;
    private final Provider<SplashSettingInfo> splashSettingInfoProvider;
    private final Provider<DLCSplashSettingNoticeDialogService> splashSettingNoticeDialogServiceProvider;
    private final Provider<Toaster> toasterProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public SplashSettingActionModule_ProvideFactory(Provider<ReportService> provider, Provider<CoroutineScope> provider2, Provider<SplashSettingInfo> provider3, Provider<DLCSplashSettingNoticeDialogService> provider4, Provider<Toaster> provider5, Provider<Router> provider6) {
        Intrinsics.checkNotNullParameter(provider, "reportServiceProvider");
        Intrinsics.checkNotNullParameter(provider2, "coroutineScopeProvider");
        Intrinsics.checkNotNullParameter(provider3, "splashSettingInfoProvider");
        Intrinsics.checkNotNullParameter(provider4, "splashSettingNoticeDialogServiceProvider");
        Intrinsics.checkNotNullParameter(provider5, "toasterProvider");
        Intrinsics.checkNotNullParameter(provider6, "routerProvider");
        this.reportServiceProvider = provider;
        this.coroutineScopeProvider = provider2;
        this.splashSettingInfoProvider = provider3;
        this.splashSettingNoticeDialogServiceProvider = provider4;
        this.toasterProvider = provider5;
        this.routerProvider = provider6;
    }

    public ActionModule<?> get() {
        Companion companion = Companion;
        ReportService reportService = this.reportServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(reportService, "get(...)");
        CoroutineScope coroutineScope = this.coroutineScopeProvider.get();
        Intrinsics.checkNotNullExpressionValue(coroutineScope, "get(...)");
        SplashSettingInfo splashSettingInfo = this.splashSettingInfoProvider.get();
        Intrinsics.checkNotNullExpressionValue(splashSettingInfo, "get(...)");
        DLCSplashSettingNoticeDialogService dLCSplashSettingNoticeDialogService = this.splashSettingNoticeDialogServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(dLCSplashSettingNoticeDialogService, "get(...)");
        Toaster toaster = this.toasterProvider.get();
        Intrinsics.checkNotNullExpressionValue(toaster, "get(...)");
        Router router = this.routerProvider.get();
        Intrinsics.checkNotNullExpressionValue(router, "get(...)");
        return companion.provide(reportService, coroutineScope, splashSettingInfo, dLCSplashSettingNoticeDialogService, toaster, router);
    }

    /* compiled from: SplashSettingActionModule_ProvideFactory.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\\\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007H\u0007J<\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00142\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0012H\u0007¨\u0006\u001b"}, d2 = {"Lkntr/app/digital/preview/splashsetting/SplashSettingActionModule_ProvideFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/preview/splashsetting/SplashSettingActionModule_ProvideFactory;", "reportServiceProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/report/ReportService;", "coroutineScopeProvider", "Lkotlinx/coroutines/CoroutineScope;", "splashSettingInfoProvider", "Lkntr/app/digital/preview/splashsetting/SplashSettingInfo;", "splashSettingNoticeDialogServiceProvider", "Lkntr/app/digital/preview/splashsetting/DLCSplashSettingNoticeDialogService;", "toasterProvider", "Lkntr/common/trio/toast/Toaster;", "routerProvider", "Lkntr/base/router/Router;", "provide", "Lkntr/app/digital/preview/action/ActionModule;", "reportService", "coroutineScope", "splashSettingInfo", "splashSettingNoticeDialogService", "toaster", "router", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SplashSettingActionModule_ProvideFactory create(Provider<ReportService> provider, Provider<CoroutineScope> provider2, Provider<SplashSettingInfo> provider3, Provider<DLCSplashSettingNoticeDialogService> provider4, Provider<Toaster> provider5, Provider<Router> provider6) {
            Intrinsics.checkNotNullParameter(provider, "reportServiceProvider");
            Intrinsics.checkNotNullParameter(provider2, "coroutineScopeProvider");
            Intrinsics.checkNotNullParameter(provider3, "splashSettingInfoProvider");
            Intrinsics.checkNotNullParameter(provider4, "splashSettingNoticeDialogServiceProvider");
            Intrinsics.checkNotNullParameter(provider5, "toasterProvider");
            Intrinsics.checkNotNullParameter(provider6, "routerProvider");
            return new SplashSettingActionModule_ProvideFactory(provider, provider2, provider3, provider4, provider5, provider6);
        }

        @JvmStatic
        public final ActionModule<?> provide(ReportService reportService, CoroutineScope coroutineScope, SplashSettingInfo splashSettingInfo, DLCSplashSettingNoticeDialogService splashSettingNoticeDialogService, Toaster toaster, Router router) {
            Intrinsics.checkNotNullParameter(reportService, "reportService");
            Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
            Intrinsics.checkNotNullParameter(splashSettingInfo, "splashSettingInfo");
            Intrinsics.checkNotNullParameter(splashSettingNoticeDialogService, "splashSettingNoticeDialogService");
            Intrinsics.checkNotNullParameter(toaster, "toaster");
            Intrinsics.checkNotNullParameter(router, "router");
            return SplashSettingActionModule.INSTANCE.provide(reportService, coroutineScope, splashSettingInfo, splashSettingNoticeDialogService, toaster, router);
        }
    }

    @JvmStatic
    public static final SplashSettingActionModule_ProvideFactory create(Provider<ReportService> provider, Provider<CoroutineScope> provider2, Provider<SplashSettingInfo> provider3, Provider<DLCSplashSettingNoticeDialogService> provider4, Provider<Toaster> provider5, Provider<Router> provider6) {
        return Companion.create(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @JvmStatic
    public static final ActionModule<?> provide(ReportService reportService, CoroutineScope coroutineScope, SplashSettingInfo splashSettingInfo, DLCSplashSettingNoticeDialogService splashSettingNoticeDialogService, Toaster toaster, Router router) {
        return Companion.provide(reportService, coroutineScope, splashSettingInfo, splashSettingNoticeDialogService, toaster, router);
    }
}