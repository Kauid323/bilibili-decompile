package kntr.app.digital.preview.report;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import java.util.Map;
import kntr.app.digital.preview.RouterParams;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PageReportParamsProvider.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lkntr/app/digital/preview/report/PageReportParamsProvider;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "provide", "Lkntr/app/digital/preview/report/FillCommonReportParams;", "routerParams", "Lkntr/app/digital/preview/RouterParams;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class PageReportParamsProvider {
    public static final int $stable = 0;
    public static final PageReportParamsProvider INSTANCE = new PageReportParamsProvider();

    private PageReportParamsProvider() {
    }

    @Provides
    @IntoSet
    public final FillCommonReportParams provide(final RouterParams routerParams) {
        Intrinsics.checkNotNullParameter(routerParams, "routerParams");
        return new FillCommonReportParams() { // from class: kntr.app.digital.preview.report.PageReportParamsProvider$$ExternalSyntheticLambda0
            @Override // kntr.app.digital.preview.report.FillCommonReportParams
            public final void invoke(Map map) {
                PageReportParamsProvider.provide$lambda$0(RouterParams.this, map);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void provide$lambda$0(RouterParams $routerParams, Map $this$FillCommonReportParams) {
        Intrinsics.checkNotNullParameter($this$FillCommonReportParams, "$this$FillCommonReportParams");
        $this$FillCommonReportParams.put("activity_id", String.valueOf($routerParams.getActId()));
        $this$FillCommonReportParams.put("lottery_id", String.valueOf($routerParams.getLotteryId()));
        $this$FillCommonReportParams.put("f_source", $routerParams.getFSource());
        $this$FillCommonReportParams.put("from", $routerParams.getFrom());
        $this$FillCommonReportParams.put("from_id", $routerParams.getFromId());
        $this$FillCommonReportParams.put("vmid", String.valueOf($routerParams.getVmid()));
    }
}