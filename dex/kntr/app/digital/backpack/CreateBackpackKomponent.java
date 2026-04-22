package kntr.app.digital.backpack;

import kntr.app.digital.backpack.api.BackpackAssetBagModel;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.komponent.Komponent;
import kotlin.Metadata;
import kotlin.Unit;

/* compiled from: BackpackPageModel.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bà\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦\u0002¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lkntr/app/digital/backpack/CreateBackpackKomponent;", RoomRecommendViewModel.EMPTY_CURSOR, "invoke", "Lkntr/common/komponent/Komponent;", RoomRecommendViewModel.EMPTY_CURSOR, "assetBagModel", "Lkntr/app/digital/backpack/api/BackpackAssetBagModel;", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface CreateBackpackKomponent {
    Komponent<Unit> invoke(BackpackAssetBagModel backpackAssetBagModel);
}