package kntr.app.ad.domain.click.internal;

import kntr.app.ad.ad.biz.search.AdSearchSubCardType;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* compiled from: ClickTrack.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lkntr/app/ad/domain/click/internal/ClickTrackResult;", RoomRecommendViewModel.EMPTY_CURSOR, "code", RoomRecommendViewModel.EMPTY_CURSOR, "desc", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getDesc", "Click", "Success", "NoReact", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum ClickTrackResult {
    Click("00", "click"),
    Success(AdSearchSubCardType.CARD_TYPE_NONE, "success"),
    NoReact("1", "click no react");
    
    private final String code;
    private final String desc;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<ClickTrackResult> getEntries() {
        return $ENTRIES;
    }

    ClickTrackResult(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getDesc() {
        return this.desc;
    }
}