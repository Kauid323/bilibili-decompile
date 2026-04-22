package kntr.app.cheese.space;

import kntr.app.cheese.space.api.PageData;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.komponent.Komponent;
import kotlin.Metadata;
import kotlin.Unit;

/* compiled from: SpaceCheesePageModel.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦\u0002¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lkntr/app/cheese/space/CreatePerLoadKomponent;", RoomRecommendViewModel.EMPTY_CURSOR, "invoke", "Lkntr/common/komponent/Komponent;", RoomRecommendViewModel.EMPTY_CURSOR, "pageData", "Lkntr/app/cheese/space/api/PageData;", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface CreatePerLoadKomponent {
    Komponent<Unit> invoke(PageData pageData);
}