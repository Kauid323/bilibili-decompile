package kntr.app.digital.preview.viewmore;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import java.util.List;
import kntr.app.digital.preview.BusinessScope;
import kntr.app.digital.preview.viewmore.ViewMoreAction;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: DigitalViewMoreService.kt */
@BusinessScope
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005R;\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lkntr/app/digital/preview/viewmore/DigitalViewMoreService;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "<set-?>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/digital/preview/viewmore/ViewMoreAction$Item;", "viewMorePopupItems", "getViewMorePopupItems", "()Ljava/util/List;", "setViewMorePopupItems", "(Ljava/util/List;)V", "viewMorePopupItems$delegate", "Landroidx/compose/runtime/MutableState;", "markViewMorePopupItems", RoomRecommendViewModel.EMPTY_CURSOR, "items", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DigitalViewMoreService {
    public static final int $stable = 0;
    private final MutableState viewMorePopupItems$delegate = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);

    private final void setViewMorePopupItems(List<ViewMoreAction.Item> list) {
        MutableState $this$setValue$iv = this.viewMorePopupItems$delegate;
        $this$setValue$iv.setValue(list);
    }

    public final List<ViewMoreAction.Item> getViewMorePopupItems() {
        State $this$getValue$iv = this.viewMorePopupItems$delegate;
        return (List) $this$getValue$iv.getValue();
    }

    public final void markViewMorePopupItems(List<ViewMoreAction.Item> list) {
        setViewMorePopupItems(list);
    }
}