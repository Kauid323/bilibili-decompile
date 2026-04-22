package kntr.app.digital.preview.usage;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kntr.app.ad.ad.biz.search.AdSearchSubCardType;
import kntr.app.digital.preview.BusinessCoroutineScope;
import kntr.app.digital.preview.action.Action;
import kntr.app.digital.preview.action.ActionModule;
import kntr.app.digital.preview.closing.DismissRequest;
import kntr.app.digital.preview.report.ReportService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.router.Router;
import kntr.common.router.UrisKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: ChangeAvatarActionModule.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¨\u0006\u0010"}, d2 = {"Lkntr/app/digital/preview/usage/ChangeHeaderActionModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "provide", "Lkntr/app/digital/preview/action/ActionModule;", "restrictionDialogService", "Lkntr/app/digital/preview/usage/DigitalUsageRestrictionDialogService;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "reportService", "Lkntr/app/digital/preview/report/ReportService;", "router", "Lkntr/base/router/Router;", "dismissRequest", "Lkntr/app/digital/preview/closing/DismissRequest;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class ChangeHeaderActionModule {
    public static final int $stable = 0;
    public static final ChangeHeaderActionModule INSTANCE = new ChangeHeaderActionModule();

    private ChangeHeaderActionModule() {
    }

    @Provides
    @IntoSet
    public final ActionModule<?> provide(final DigitalUsageRestrictionDialogService restrictionDialogService, @BusinessCoroutineScope final CoroutineScope coroutineScope, final ReportService reportService, final Router router, DismissRequest dismissRequest) {
        Intrinsics.checkNotNullParameter(restrictionDialogService, "restrictionDialogService");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(reportService, "reportService");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(dismissRequest, "dismissRequest");
        return new ActionModule<ChangeHeaderAction>() { // from class: kntr.app.digital.preview.usage.ChangeHeaderActionModule$provide$$inlined$ActionModule$1
            @Override // kntr.app.digital.preview.action.ActionModule
            public KClass<ChangeHeaderAction> getActionType() {
                return Reflection.getOrCreateKotlinClass(ChangeHeaderAction.class);
            }

            @Override // kntr.app.digital.preview.action.ActionModule
            public void run(Action<ChangeHeaderAction> action) {
                Intrinsics.checkNotNullParameter(action, "<this>");
                if (action.getData().getHasLimitDialog()) {
                    BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ChangeHeaderActionModule$provide$1$1(restrictionDialogService, action, null), 3, (Object) null);
                }
                ChangeHeaderActionModule.provide$lambda$0$setHeader(reportService, router, action);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void provide$lambda$0$setHeader(ReportService $reportService, Router $router, Action<ChangeHeaderAction> action) {
        $reportService.report("sqzz.activity.main-page.use-result.show", MapsKt.mapOf(TuplesKt.to("setting_type", AdSearchSubCardType.CARD_TYPE_2)));
        $router.launch(UrisKt.toUri(action.getData().getSpaceBgSetUrl()));
    }
}