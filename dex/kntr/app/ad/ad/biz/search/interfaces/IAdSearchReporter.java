package kntr.app.ad.ad.biz.search.interfaces;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: IAdSearchReporter.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lkntr/app/ad/ad/biz/search/interfaces/IAdSearchReporter;", RoomRecommendViewModel.EMPTY_CURSOR, "reportCardClickForPegasus", RoomRecommendViewModel.EMPTY_CURSOR, "url", RoomRecommendViewModel.EMPTY_CURSOR, "reportChooseButtonClickForPegasus", "index", RoomRecommendViewModel.EMPTY_CURSOR, "text", "search_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IAdSearchReporter {
    void reportCardClickForPegasus(String str);

    void reportChooseButtonClickForPegasus(int i, String str, String str2);
}