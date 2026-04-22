package kntr.app.digital.preview.action;

import dagger.Module;
import dagger.Provides;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kntr.app.digital.preview.BusinessScope;
import kntr.app.digital.preview.report.ReportService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;

/* compiled from: HandleActionModule.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u0004\u001a\u00020\u00052\u0015\u0010\u0006\u001a\u0011\u0012\r\u0012\u000b\u0012\u0002\b\u00030\b¢\u0006\u0002\b\t0\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"Lkntr/app/digital/preview/action/HandleActionModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "provideHandleAction", "Lkntr/app/digital/preview/action/HandleAction;", "runningSet", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/digital/preview/action/ActionModule;", "Lkotlin/jvm/JvmSuppressWildcards;", "reportService", "Lkntr/app/digital/preview/report/ReportService;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class HandleActionModule {
    public static final int $stable = 0;
    public static final HandleActionModule INSTANCE = new HandleActionModule();

    private HandleActionModule() {
    }

    @Provides
    @BusinessScope
    public final HandleAction provideHandleAction(Set<ActionModule<?>> set, final ReportService reportService) {
        Intrinsics.checkNotNullParameter(set, "runningSet");
        Intrinsics.checkNotNullParameter(reportService, "reportService");
        Set<ActionModule<?>> $this$associateBy$iv = set;
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
        final Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associateBy$iv) {
            ActionModule it = (ActionModule) element$iv$iv;
            destination$iv$iv.put(it.getActionType(), element$iv$iv);
        }
        return new HandleAction() { // from class: kntr.app.digital.preview.action.HandleActionModule$$ExternalSyntheticLambda0
            @Override // kntr.app.digital.preview.action.HandleAction
            public final void invoke(Action action) {
                HandleActionModule.provideHandleAction$lambda$1(ReportService.this, destination$iv$iv, action);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> void provideHandleAction$lambda$1$runModule(Map<KClass<? extends Object>, ActionModule<?>> map, Action<T> action) {
        ActionModule running = map.get(Reflection.getOrCreateKotlinClass(action.getData().getClass()));
        if (running != null) {
            running.run(action);
            return;
        }
        KLog_androidKt.getKLog().e("HandleActionModule", "Action not recognized. Action: " + StringsKt.take(action.toString(), 100) + ".");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void provideHandleAction$lambda$1(ReportService $reportService, Map $runningMap, Action action) {
        Intrinsics.checkNotNullParameter(action, "action");
        Report clickReport = action.getReport();
        if (clickReport != null) {
            $reportService.report(clickReport.getEventId(), clickReport.getParams());
        }
        if (Intrinsics.areEqual(action.getData(), Unit.INSTANCE)) {
            KLog_androidKt.getKLog().i("HandleActionModule", "No op action triggered.");
        } else {
            provideHandleAction$lambda$1$runModule($runningMap, action);
        }
    }
}