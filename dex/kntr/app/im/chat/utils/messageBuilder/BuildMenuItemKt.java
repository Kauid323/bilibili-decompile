package kntr.app.im.chat.utils.messageBuilder;

import com.bapis.bilibili.app.im.v1.KMsgMenuContent;
import com.bapis.bilibili.app.im.v1.KMsgMenuCopy;
import com.bapis.bilibili.app.im.v1.KMsgMenuDelete;
import com.bapis.bilibili.app.im.v1.KMsgMenuItem;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BuildMenuItem.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0006"}, d2 = {"copy", "Lcom/bapis/bilibili/app/im/v1/KMsgMenuItem;", "Lcom/bapis/bilibili/app/im/v1/KMsgMenuItem$Companion;", "text", RoomRecommendViewModel.EMPTY_CURSOR, "delete", "biz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BuildMenuItemKt {
    public static final KMsgMenuItem copy(KMsgMenuItem.Companion $this$copy, String text) {
        Intrinsics.checkNotNullParameter($this$copy, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        return new KMsgMenuItem((String) null, new KMsgMenuContent(new KMsgMenuContent.KCopy(new KMsgMenuCopy(text))), 1, (DefaultConstructorMarker) null);
    }

    public static final KMsgMenuItem delete(KMsgMenuItem.Companion $this$delete) {
        Intrinsics.checkNotNullParameter($this$delete, "<this>");
        return new KMsgMenuItem((String) null, new KMsgMenuContent(new KMsgMenuContent.KDelete(new KMsgMenuDelete())), 1, (DefaultConstructorMarker) null);
    }
}