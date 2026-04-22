package kntr.app.deepsearch.base.model.biz;

import com.bapis.bilibili.broadcast.message.deepsearch.KPictureCard;
import java.util.HashMap;
import java.util.Map;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;

/* compiled from: Transactions.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0007J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006J\u001a\u0010\u0011\u001a\u00020\u00062\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nJ\u001e\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000RB\u0010\t\u001a6\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\u0005j\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/PicTransaction;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "picCards", "Ljava/util/HashMap;", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/bapis/bilibili/broadcast/message/deepsearch/KPictureCard;", "Lkotlin/collections/HashMap;", "picAreas", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/deepsearch/base/model/biz/PicRect;", "recordPic", "data", "getPicsAndRemove", "key", "recordArea", "getAreasAndRemove", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PicTransaction {
    public static final PicTransaction INSTANCE = new PicTransaction();
    private static final HashMap<String, KPictureCard> picCards = new HashMap<>();
    private static final HashMap<String, Map<Integer, PicRect>> picAreas = new HashMap<>();

    private PicTransaction() {
    }

    public final String recordPic(KPictureCard data) {
        Intrinsics.checkNotNullParameter(data, "data");
        int hashCode = data.hashCode();
        String key = new StringBuilder().append(hashCode).append(Clock.System.INSTANCE.now().toEpochMilliseconds()).toString();
        picCards.put(key, data);
        return key;
    }

    public final KPictureCard getPicsAndRemove(String key) {
        if (key == null) {
            return null;
        }
        return picCards.remove(key);
    }

    public final String recordArea(Map<Integer, PicRect> map) {
        Intrinsics.checkNotNullParameter(map, "data");
        int hashCode = map.hashCode();
        String key = new StringBuilder().append(hashCode).append(Clock.System.INSTANCE.now().toEpochMilliseconds()).toString();
        picAreas.put(key, map);
        return key;
    }

    public final Map<Integer, PicRect> getAreasAndRemove(String key) {
        if (key == null) {
            return null;
        }
        return picAreas.remove(key);
    }
}