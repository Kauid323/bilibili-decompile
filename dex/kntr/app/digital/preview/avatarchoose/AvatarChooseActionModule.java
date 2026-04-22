package kntr.app.digital.preview.avatarchoose;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kntr.app.digital.preview.BusinessCoroutineScope;
import kntr.app.digital.preview.action.Action;
import kntr.app.digital.preview.action.ActionModule;
import kntr.app.digital.preview.closing.DismissRequest;
import kntr.app.digital.preview.loading.DigitalLoadingService;
import kntr.app.digital.preview.report.ReportService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.komponent.KomponentScope;
import kntr.common.trio.toast.Toaster;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: AvatarChooseActionModule.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JD\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0007¨\u0006\u0013"}, d2 = {"Lkntr/app/digital/preview/avatarchoose/AvatarChooseActionModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "provide", "Lkntr/app/digital/preview/action/ActionModule;", "reportService", "Lkntr/app/digital/preview/report/ReportService;", "dismissRequest", "Lkntr/app/digital/preview/closing/DismissRequest;", "toaster", "Lkntr/common/trio/toast/Toaster;", "loadingService", "Lkntr/app/digital/preview/loading/DigitalLoadingService;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "komponentScope", "Lkntr/common/komponent/KomponentScope;", RoomRecommendViewModel.EMPTY_CURSOR, "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class AvatarChooseActionModule {
    public static final int $stable = 0;
    public static final AvatarChooseActionModule INSTANCE = new AvatarChooseActionModule();

    private AvatarChooseActionModule() {
    }

    @Provides
    @IntoSet
    public final ActionModule<?> provide(final ReportService reportService, final DismissRequest dismissRequest, final Toaster toaster, final DigitalLoadingService loadingService, @BusinessCoroutineScope final CoroutineScope coroutineScope, final KomponentScope<? super Unit> komponentScope) {
        Intrinsics.checkNotNullParameter(reportService, "reportService");
        Intrinsics.checkNotNullParameter(dismissRequest, "dismissRequest");
        Intrinsics.checkNotNullParameter(toaster, "toaster");
        Intrinsics.checkNotNullParameter(loadingService, "loadingService");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(komponentScope, "komponentScope");
        return new ActionModule<AvatarChooseAction>() { // from class: kntr.app.digital.preview.avatarchoose.AvatarChooseActionModule$provide$$inlined$ActionModule$1
            @Override // kntr.app.digital.preview.action.ActionModule
            public KClass<AvatarChooseAction> getActionType() {
                return Reflection.getOrCreateKotlinClass(AvatarChooseAction.class);
            }

            @Override // kntr.app.digital.preview.action.ActionModule
            public void run(Action<AvatarChooseAction> action) {
                Intrinsics.checkNotNullParameter(action, "<this>");
                BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AvatarChooseActionModule$provide$1$1(komponentScope, action, loadingService, toaster, dismissRequest, null), 3, (Object) null);
                if (!action.getData().getNeedReport()) {
                    return;
                }
                reportService.report("main.space.profile.button.click", MapsKt.mapOf(TuplesKt.to("button_type", "1")));
                ReportService.report$default(reportService, "main.space.change-profile-panel.0.show", null, 2, null);
            }
        };
    }
}