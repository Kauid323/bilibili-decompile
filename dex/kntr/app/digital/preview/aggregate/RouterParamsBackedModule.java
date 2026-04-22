package kntr.app.digital.preview.aggregate;

import dagger.Module;
import dagger.Provides;
import java.util.Map;
import kntr.app.digital.preview.ActivityId;
import kntr.app.digital.preview.FromParams;
import kntr.app.digital.preview.PageScope;
import kntr.app.digital.preview.RouterParams;
import kntr.app.digital.preview.SimpleCard;
import kntr.app.digital.preview.VMid;
import kntr.app.digital.preview.api.GetCardList;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RouterParamsBackedModule.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/digital/preview/aggregate/RouterParamsBackedModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "provideSimpleCard", "Lkntr/app/digital/preview/SimpleCard;", "routerParams", "Lkntr/app/digital/preview/RouterParams;", "provideVMid", RoomRecommendViewModel.EMPTY_CURSOR, "provideFromParams", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "provideActivityId", RoomRecommendViewModel.EMPTY_CURSOR, "provideRequestParams", "Lkntr/app/digital/preview/api/GetCardList$RequestParams;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class RouterParamsBackedModule {
    public static final int $stable = 0;
    public static final RouterParamsBackedModule INSTANCE = new RouterParamsBackedModule();

    private RouterParamsBackedModule() {
    }

    @Provides
    @PageScope
    public final SimpleCard provideSimpleCard(RouterParams routerParams) {
        Intrinsics.checkNotNullParameter(routerParams, "routerParams");
        return routerParams.getSimpleCard();
    }

    @Provides
    @VMid
    @PageScope
    public final long provideVMid(RouterParams routerParams) {
        Intrinsics.checkNotNullParameter(routerParams, "routerParams");
        return routerParams.getVmid();
    }

    @Provides
    @FromParams
    @PageScope
    public final Map<String, String> provideFromParams(RouterParams routerParams) {
        Intrinsics.checkNotNullParameter(routerParams, "routerParams");
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("f_source", routerParams.getFSource()), TuplesKt.to("from", routerParams.getFrom()), TuplesKt.to("from_id", routerParams.getFromId())});
    }

    @Provides
    @ActivityId
    @PageScope
    public final int provideActivityId(RouterParams routerParams) {
        Intrinsics.checkNotNullParameter(routerParams, "routerParams");
        return routerParams.getActId();
    }

    @Provides
    @PageScope
    public final GetCardList.RequestParams provideRequestParams(RouterParams routerParams) {
        Intrinsics.checkNotNullParameter(routerParams, "routerParams");
        return new GetCardList.RequestParams(routerParams.getActId(), routerParams.getVmid(), routerParams.getLotteryId(), routerParams.getAnchorId(), routerParams.getAnchorId(), routerParams.getExtra(), routerParams.getDirection());
    }
}