package kntr.app.im.chat.ui.neuron;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatReporter.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¨\u0006\u0006"}, d2 = {"appendParam", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/ui/neuron/ChatReporter;", "key", RoomRecommendViewModel.EMPTY_CURSOR, "value", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ChatReporterKt {
    public static final void appendParam(ChatReporter $this$appendParam, String key, String value) {
        Intrinsics.checkNotNullParameter($this$appendParam, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        $this$appendParam.appendParam(MapsKt.mapOf(TuplesKt.to(key, value)));
    }
}