package kntr.app.appwidget.guide.ui;

import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: AppWidgetGuidePopupState.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\b\u0010\u001c\u001a\u00020\u001dH&J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\rH&R\u001c\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0013R\u0012\u0010\u001a\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u000f¨\u0006 À\u0006\u0003"}, d2 = {"Lkntr/app/appwidget/guide/ui/PopupData;", RoomRecommendViewModel.EMPTY_CURSOR, "avatar", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "getAvatar", "()Ljava/util/List;", "title", "getTitle", "()Ljava/lang/String;", "subtitle", "getSubtitle", "forceDark", RoomRecommendViewModel.EMPTY_CURSOR, "getForceDark", "()Z", "offset", RoomRecommendViewModel.EMPTY_CURSOR, "getOffset", "()I", "durationms", RoomRecommendViewModel.EMPTY_CURSOR, "getDurationms", "()J", "style", "getStyle", "outsideTouchable", "getOutsideTouchable", "performAction", RoomRecommendViewModel.EMPTY_CURSOR, "dismiss", "auto", "guide_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface PopupData {
    void dismiss(boolean z);

    List<String> getAvatar();

    long getDurationms();

    boolean getForceDark();

    int getOffset();

    boolean getOutsideTouchable();

    int getStyle();

    String getSubtitle();

    String getTitle();

    void performAction();
}