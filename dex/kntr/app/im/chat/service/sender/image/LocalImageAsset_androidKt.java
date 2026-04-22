package kntr.app.im.chat.service.sender.image;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalImageAsset.android.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"imagePathForDisplay", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/service/sender/image/LocalImageAsset;", "biz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class LocalImageAsset_androidKt {
    public static final String imagePathForDisplay(LocalImageAsset $this$imagePathForDisplay) {
        Intrinsics.checkNotNullParameter($this$imagePathForDisplay, "<this>");
        return "file://" + $this$imagePathForDisplay.getPath$biz_debug();
    }
}