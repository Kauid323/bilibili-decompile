package kntr.app.im.chat.core.model;

import kntr.app.im.chat.core.model.ChatUpgradeAnswerDialogStatus;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;

/* compiled from: ChatPageData.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"checkNeedUpdate", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/core/model/ChatUpgradeAnswerDialogStatus;", "instant", "Lkotlinx/datetime/Instant;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ChatPageDataKt {
    public static final boolean checkNeedUpdate(ChatUpgradeAnswerDialogStatus $this$checkNeedUpdate, Instant instant) {
        Intrinsics.checkNotNullParameter($this$checkNeedUpdate, "<this>");
        Intrinsics.checkNotNullParameter(instant, "instant");
        return $this$checkNeedUpdate instanceof ChatUpgradeAnswerDialogStatus.SHOW ? ((ChatUpgradeAnswerDialogStatus.SHOW) $this$checkNeedUpdate).getLastShowTime().compareTo(instant) < 0 : !($this$checkNeedUpdate instanceof ChatUpgradeAnswerDialogStatus.DISMISSED) || ((ChatUpgradeAnswerDialogStatus.DISMISSED) $this$checkNeedUpdate).getLastShowTime().compareTo(instant) < 0;
    }
}