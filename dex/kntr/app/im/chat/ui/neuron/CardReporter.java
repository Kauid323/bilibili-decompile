package kntr.app.im.chat.ui.neuron;

import java.util.Map;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* compiled from: CardReporter.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/ui/neuron/CardReporter;", RoomRecommendViewModel.EMPTY_CURSOR, "reportMsgClick", RoomRecommendViewModel.EMPTY_CURSOR, "cardEventMap", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface CardReporter {
    void reportMsgClick(Map<String, String> map);

    /* compiled from: CardReporter.kt */
    /* renamed from: kntr.app.im.chat.ui.neuron.CardReporter$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public final /* synthetic */ class CC {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void reportMsgClick$default(CardReporter cardReporter, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportMsgClick");
            }
            if ((i & 1) != 0) {
                map = MapsKt.emptyMap();
            }
            cardReporter.reportMsgClick(map);
        }
    }

    /* compiled from: CardReporter.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DefaultImpls {
    }
}