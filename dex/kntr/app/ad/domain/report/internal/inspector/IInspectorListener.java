package kntr.app.ad.domain.report.internal.inspector;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: IInspectorListener.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lkntr/app/ad/domain/report/internal/inspector/IInspectorListener;", RoomRecommendViewModel.EMPTY_CURSOR, "reportSuccess", RoomRecommendViewModel.EMPTY_CURSOR, "reportError", "code", RoomRecommendViewModel.EMPTY_CURSOR, "dsc", RoomRecommendViewModel.EMPTY_CURSOR, "report_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IInspectorListener {
    void reportError(int i, String str);

    void reportSuccess();
}