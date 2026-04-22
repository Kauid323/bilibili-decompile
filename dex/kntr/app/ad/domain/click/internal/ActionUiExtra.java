package kntr.app.ad.domain.click.internal;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* compiled from: ClickReport.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lkntr/app/ad/domain/click/internal/ActionUiExtra;", RoomRecommendViewModel.EMPTY_CURSOR, "value", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SHOW_TIME", "WECHAT_URL", "URL", "FAIL_REASON", "IS_FIRST_JUMP", "IS_DOUBLE_LINK_OPENED", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum ActionUiExtra {
    SHOW_TIME("show_time"),
    WECHAT_URL("wechat_url"),
    URL("url"),
    FAIL_REASON("fail_reason"),
    IS_FIRST_JUMP("is_first_jump"),
    IS_DOUBLE_LINK_OPENED("is_double_link_opened");
    
    private final String value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<ActionUiExtra> getEntries() {
        return $ENTRIES;
    }

    ActionUiExtra(String value) {
        this.value = value;
    }

    public final String getValue() {
        return this.value;
    }
}