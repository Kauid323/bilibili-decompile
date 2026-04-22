package kntr.app.ad.domain.adextra.handler;

import kntr.app.ad.protocol.adextra.IAdExtraQuery;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: IAdExtraQueryHandler.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b`\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/app/ad/domain/adextra/handler/IAdExtraQueryHandler;", "Q", "Lkntr/app/ad/protocol/adextra/IAdExtraQuery;", RoomRecommendViewModel.EMPTY_CURSOR, "handle", RoomRecommendViewModel.EMPTY_CURSOR, "query", "(Lkntr/app/ad/protocol/adextra/IAdExtraQuery;)Ljava/lang/String;", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IAdExtraQueryHandler<Q extends IAdExtraQuery> {
    String handle(Q q);
}