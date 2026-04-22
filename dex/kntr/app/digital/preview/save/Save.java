package kntr.app.digital.preview.save;

import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.komponent.KomponentScope;
import kotlin.Metadata;
import kotlin.Unit;

/* compiled from: Save.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J,\u0010\b\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nH&¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lkntr/app/digital/preview/save/Save;", RoomRecommendViewModel.EMPTY_CURSOR, "saveImage", RoomRecommendViewModel.EMPTY_CURSOR, "komponentScope", "Lkntr/common/komponent/KomponentScope;", "imageUrl", RoomRecommendViewModel.EMPTY_CURSOR, "saveVideo", "videoUrls", RoomRecommendViewModel.EMPTY_CURSOR, "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface Save {
    void saveImage(KomponentScope<? super Unit> komponentScope, String str);

    void saveVideo(KomponentScope<? super Unit> komponentScope, String str, List<String> list);
}