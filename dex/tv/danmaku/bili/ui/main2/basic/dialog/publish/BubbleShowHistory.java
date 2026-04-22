package tv.danmaku.bili.ui.main2.basic.dialog.publish;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: PublishBubbleDialog.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/ui/main2/basic/dialog/publish/BubbleShowHistory;", "", "<init>", "()V", "id", "", "getId", "()J", "setId", "(J)V", "showCount", "", "getShowCount", "()I", "setShowCount", "(I)V", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BubbleShowHistory {
    public static final int $stable = 8;
    @JSONField(name = "id")
    private long id;
    @JSONField(name = "show_count")
    private int showCount;

    public final long getId() {
        return this.id;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final int getShowCount() {
        return this.showCount;
    }

    public final void setShowCount(int i) {
        this.showCount = i;
    }
}