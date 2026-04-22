package kntr.app.deepsearch.base.model.input;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* compiled from: InputState.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lkntr/app/deepsearch/base/model/input/SenderStatus;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;I)V", "SEND_DISALLOW", "SEND_ALLOW", "STOP_ACTION", "SESSION_LOADING", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum SenderStatus {
    SEND_DISALLOW,
    SEND_ALLOW,
    STOP_ACTION,
    SESSION_LOADING;
    
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<SenderStatus> getEntries() {
        return $ENTRIES;
    }
}