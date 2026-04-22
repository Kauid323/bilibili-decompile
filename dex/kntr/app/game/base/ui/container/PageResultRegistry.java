package kntr.app.game.base.ui.container;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;

/* compiled from: GameComposeContainer.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J/\u0010\u0002\u001a\u00020\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00012\b\u0010\u0005\u001a\u0004\u0018\u0001H\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0007H&¢\u0006\u0002\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lkntr/app/game/base/ui/container/PageResultRegistry;", RoomRecommendViewModel.EMPTY_CURSOR, "setPageResult", RoomRecommendViewModel.EMPTY_CURSOR, "R", "result", "serializer", "Lkotlinx/serialization/KSerializer;", "(Ljava/lang/Object;Lkotlinx/serialization/KSerializer;)V", "base-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface PageResultRegistry {
    <R> void setPageResult(R r, KSerializer<R> kSerializer);
}