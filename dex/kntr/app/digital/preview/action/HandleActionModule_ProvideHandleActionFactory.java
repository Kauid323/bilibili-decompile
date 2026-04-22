package kntr.app.digital.preview.action;

import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;
import kntr.app.digital.preview.report.ReportService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HandleActionModule_ProvideHandleActionFactory.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB-\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00050\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\u0002H\u0016R\u001e\u0010\u0003\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkntr/app/digital/preview/action/HandleActionModule_ProvideHandleActionFactory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/preview/action/HandleAction;", "runningSetProvider", "Ljavax/inject/Provider;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/digital/preview/action/ActionModule;", "reportServiceProvider", "Lkntr/app/digital/preview/report/ReportService;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HandleActionModule_ProvideHandleActionFactory implements Factory<HandleAction> {
    private final Provider<ReportService> reportServiceProvider;
    private final Provider<Set<ActionModule<?>>> runningSetProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public HandleActionModule_ProvideHandleActionFactory(Provider<Set<ActionModule<?>>> provider, Provider<ReportService> provider2) {
        Intrinsics.checkNotNullParameter(provider, "runningSetProvider");
        Intrinsics.checkNotNullParameter(provider2, "reportServiceProvider");
        this.runningSetProvider = provider;
        this.reportServiceProvider = provider2;
    }

    public HandleAction get() {
        Companion companion = Companion;
        Set<ActionModule<?>> set = this.runningSetProvider.get();
        Intrinsics.checkNotNullExpressionValue(set, "get(...)");
        ReportService reportService = this.reportServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(reportService, "get(...)");
        return companion.provideHandleAction(set, reportService);
    }

    /* compiled from: HandleActionModule_ProvideHandleActionFactory.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\b0\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007H\u0007J\"\u0010\f\u001a\u00020\r2\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007¨\u0006\u0010"}, d2 = {"Lkntr/app/digital/preview/action/HandleActionModule_ProvideHandleActionFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/preview/action/HandleActionModule_ProvideHandleActionFactory;", "runningSetProvider", "Ljavax/inject/Provider;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/digital/preview/action/ActionModule;", "reportServiceProvider", "Lkntr/app/digital/preview/report/ReportService;", "provideHandleAction", "Lkntr/app/digital/preview/action/HandleAction;", "runningSet", "reportService", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final HandleActionModule_ProvideHandleActionFactory create(Provider<Set<ActionModule<?>>> provider, Provider<ReportService> provider2) {
            Intrinsics.checkNotNullParameter(provider, "runningSetProvider");
            Intrinsics.checkNotNullParameter(provider2, "reportServiceProvider");
            return new HandleActionModule_ProvideHandleActionFactory(provider, provider2);
        }

        @JvmStatic
        public final HandleAction provideHandleAction(Set<? extends ActionModule<?>> set, ReportService reportService) {
            Intrinsics.checkNotNullParameter(set, "runningSet");
            Intrinsics.checkNotNullParameter(reportService, "reportService");
            return HandleActionModule.INSTANCE.provideHandleAction(set, reportService);
        }
    }

    @JvmStatic
    public static final HandleActionModule_ProvideHandleActionFactory create(Provider<Set<ActionModule<?>>> provider, Provider<ReportService> provider2) {
        return Companion.create(provider, provider2);
    }

    @JvmStatic
    public static final HandleAction provideHandleAction(Set<? extends ActionModule<?>> set, ReportService reportService) {
        return Companion.provideHandleAction(set, reportService);
    }
}