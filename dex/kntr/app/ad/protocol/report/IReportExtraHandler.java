package kntr.app.ad.protocol.report;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: IReportExtraHandler.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H'J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\bH&J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H'¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lkntr/app/ad/protocol/report/IReportExtraHandler;", RoomRecommendViewModel.EMPTY_CURSOR, "put", RoomRecommendViewModel.EMPTY_CURSOR, "key", RoomRecommendViewModel.EMPTY_CURSOR, "value", "block", "Lkotlin/Function0;", "protocol_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IReportExtraHandler {
    void put(String str, Object obj);

    void put(String str, String str2);

    void put(String str, Function0<String> function0);
}