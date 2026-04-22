package kntr.app.deepsearch.ui.input;

import kntr.app.deepsearch.base.model.input.SenderStatus;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* compiled from: Input.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lkntr/app/deepsearch/ui/input/SenderStatusNullable;", RoomRecommendViewModel.EMPTY_CURSOR, "origin", "Lkntr/app/deepsearch/base/model/input/SenderStatus;", "<init>", "(Ljava/lang/String;ILkntr/app/deepsearch/base/model/input/SenderStatus;)V", "getOrigin", "()Lkntr/app/deepsearch/base/model/input/SenderStatus;", "SEND_DISALLOW", "SEND_ALLOW", "STOP_ACTION", "SESSION_LOADING", "GONE", "compose_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum SenderStatusNullable {
    SEND_DISALLOW(SenderStatus.SEND_DISALLOW),
    SEND_ALLOW(SenderStatus.SEND_ALLOW),
    STOP_ACTION(SenderStatus.STOP_ACTION),
    SESSION_LOADING(SenderStatus.SESSION_LOADING),
    GONE(null);
    
    private final SenderStatus origin;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<SenderStatusNullable> getEntries() {
        return $ENTRIES;
    }

    SenderStatusNullable(SenderStatus origin) {
        this.origin = origin;
    }

    public final SenderStatus getOrigin() {
        return this.origin;
    }
}