package kntr.app.im.chat.ui.widget;

import androidx.compose.foundation.gestures.AnchoredDraggableState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatMediaSelectBottomSheet.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR+\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0004\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lkntr/app/im/chat/ui/widget/ChatMediaSelectBottomSheetState;", RoomRecommendViewModel.EMPTY_CURSOR, "initialValue", "Lkntr/app/im/chat/ui/widget/ChatMediaSelectSheetState;", "isEnableExpand", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lkntr/app/im/chat/ui/widget/ChatMediaSelectSheetState;Z)V", "anchoredDraggableState", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "getAnchoredDraggableState$ui_debug", "()Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "setAnchoredDraggableState$ui_debug", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;)V", "<set-?>", "()Z", "setEnableExpand", "(Z)V", "isEnableExpand$delegate", "Landroidx/compose/runtime/MutableState;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatMediaSelectBottomSheetState {
    public static final int $stable = 0;
    private AnchoredDraggableState<ChatMediaSelectSheetState> anchoredDraggableState;
    private final MutableState isEnableExpand$delegate;

    public ChatMediaSelectBottomSheetState(ChatMediaSelectSheetState initialValue, boolean isEnableExpand) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        this.anchoredDraggableState = new AnchoredDraggableState<>(initialValue);
        this.isEnableExpand$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(isEnableExpand), (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public /* synthetic */ ChatMediaSelectBottomSheetState(ChatMediaSelectSheetState chatMediaSelectSheetState, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(chatMediaSelectSheetState, (i & 2) != 0 ? true : z);
    }

    public final AnchoredDraggableState<ChatMediaSelectSheetState> getAnchoredDraggableState$ui_debug() {
        return this.anchoredDraggableState;
    }

    public final void setAnchoredDraggableState$ui_debug(AnchoredDraggableState<ChatMediaSelectSheetState> anchoredDraggableState) {
        Intrinsics.checkNotNullParameter(anchoredDraggableState, "<set-?>");
        this.anchoredDraggableState = anchoredDraggableState;
    }

    public final boolean isEnableExpand() {
        State $this$getValue$iv = this.isEnableExpand$delegate;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    public final void setEnableExpand(boolean z) {
        MutableState $this$setValue$iv = this.isEnableExpand$delegate;
        Object value$iv = Boolean.valueOf(z);
        $this$setValue$iv.setValue(value$iv);
    }
}