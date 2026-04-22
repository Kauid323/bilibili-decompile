package kntr.app.digital.preview.splashsetting;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kntr.app.digital.preview.BusinessCoroutineScope;
import kntr.app.digital.preview.action.Action;
import kntr.app.digital.preview.action.ActionModule;
import kntr.app.digital.preview.report.ReportService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.router.Router;
import kntr.common.trio.toast.Toaster;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: SplashSettingActionModule.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J>\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/digital/preview/splashsetting/SplashSettingActionModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "provide", "Lkntr/app/digital/preview/action/ActionModule;", "reportService", "Lkntr/app/digital/preview/report/ReportService;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "splashSettingInfo", "Lkntr/app/digital/preview/splashsetting/SplashSettingInfo;", "splashSettingNoticeDialogService", "Lkntr/app/digital/preview/splashsetting/DLCSplashSettingNoticeDialogService;", "toaster", "Lkntr/common/trio/toast/Toaster;", "router", "Lkntr/base/router/Router;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class SplashSettingActionModule {
    public static final int $stable = 0;
    public static final SplashSettingActionModule INSTANCE = new SplashSettingActionModule();

    private SplashSettingActionModule() {
    }

    @Provides
    @IntoSet
    public final ActionModule<?> provide(final ReportService reportService, @BusinessCoroutineScope final CoroutineScope coroutineScope, final SplashSettingInfo splashSettingInfo, final DLCSplashSettingNoticeDialogService splashSettingNoticeDialogService, final Toaster toaster, final Router router) {
        Intrinsics.checkNotNullParameter(reportService, "reportService");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(splashSettingInfo, "splashSettingInfo");
        Intrinsics.checkNotNullParameter(splashSettingNoticeDialogService, "splashSettingNoticeDialogService");
        Intrinsics.checkNotNullParameter(toaster, "toaster");
        Intrinsics.checkNotNullParameter(router, "router");
        return new ActionModule<SplashSettingAction>() { // from class: kntr.app.digital.preview.splashsetting.SplashSettingActionModule$provide$$inlined$ActionModule$1
            @Override // kntr.app.digital.preview.action.ActionModule
            public KClass<SplashSettingAction> getActionType() {
                return Reflection.getOrCreateKotlinClass(SplashSettingAction.class);
            }

            @Override // kntr.app.digital.preview.action.ActionModule
            public void run(Action<SplashSettingAction> action) {
                Intrinsics.checkNotNullParameter(action, "<this>");
                BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new SplashSettingActionModule$provide$1$1(splashSettingInfo, action, toaster, reportService, coroutineScope, splashSettingNoticeDialogService, router, null), 3, (Object) null);
            }
        };
    }
}