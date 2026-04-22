package kntr.app.ad.protocol.adextra;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: IAdExtraFetcher.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/app/ad/protocol/adextra/IAdExtraFetcher;", RoomRecommendViewModel.EMPTY_CURSOR, "get", RoomRecommendViewModel.EMPTY_CURSOR, "query", "Lkntr/app/ad/protocol/adextra/IAdExtraQuery;", "protocol_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IAdExtraFetcher {
    String get(IAdExtraQuery iAdExtraQuery);
}