package kntr.app.cheese.space.feed;

import com.bilibili.ogv.operation3.module.operable.OperableModel;
import kntr.app.cheese.space.api.SeasonModel;
import kntr.app.cheese.space.operable.CreateOperableModel;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.router.Router;
import kntr.common.compose.launcher.KomponentRouterKt;
import kntr.common.komponent.KomponentScope;
import kotlin.Metadata;

/* compiled from: CreateCheeseFeedKomponent.kt */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"kntr/app/cheese/space/feed/CreateCheeseFeedKomponent$invoke$1$card$1", RoomRecommendViewModel.EMPTY_CURSOR, "data", "Lkntr/app/cheese/space/api/SeasonModel;", "getData", "()Lkntr/app/cheese/space/api/SeasonModel;", "operableModel", "Lcom/bilibili/ogv/operation3/module/operable/OperableModel;", "getOperableModel", "()Lcom/bilibili/ogv/operation3/module/operable/OperableModel;", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreateCheeseFeedKomponent$invoke$1$card$1 {
    private final SeasonModel data;
    private final OperableModel operableModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CreateCheeseFeedKomponent$invoke$1$card$1(SeasonModel $item, CreateCheeseFeedKomponent $receiver, KomponentScope<? super SeasonModel> komponentScope) {
        CreateOperableModel createOperableModel;
        this.data = $item;
        createOperableModel = $receiver.createOperableModel;
        this.operableModel = CreateOperableModel.invoke$default(createOperableModel, (Router) komponentScope.getCurrent(KomponentRouterKt.getLocalRouter()), $item, null, 4, null);
    }

    public final SeasonModel getData() {
        return this.data;
    }

    public final OperableModel getOperableModel() {
        return this.operableModel;
    }
}