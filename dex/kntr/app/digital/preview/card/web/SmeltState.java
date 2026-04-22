package kntr.app.digital.preview.card.web;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: SmeltCardContent.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R/\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u0004\u0018\u00010\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0015\u001a\u00020\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lkntr/app/digital/preview/card/web/SmeltState;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "<set-?>", "Lkntr/app/digital/preview/card/web/SmeltStatus;", "smeltStatus", "getSmeltStatus", "()Lkntr/app/digital/preview/card/web/SmeltStatus;", "setSmeltStatus", "(Lkntr/app/digital/preview/card/web/SmeltStatus;)V", "smeltStatus$delegate", "Landroidx/compose/runtime/MutableState;", "url", RoomRecommendViewModel.EMPTY_CURSOR, "getUrl", "()Ljava/lang/String;", "cardId", RoomRecommendViewModel.EMPTY_CURSOR, "getCardId", "()Ljava/lang/Long;", "enableAudio", RoomRecommendViewModel.EMPTY_CURSOR, "getEnableAudio", "()Z", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class SmeltState {
    public static final int $stable = 0;
    private final MutableState smeltStatus$delegate = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);

    public abstract Long getCardId();

    public abstract boolean getEnableAudio();

    public abstract String getUrl();

    public final SmeltStatus getSmeltStatus() {
        State $this$getValue$iv = this.smeltStatus$delegate;
        return (SmeltStatus) $this$getValue$iv.getValue();
    }

    public final void setSmeltStatus(SmeltStatus smeltStatus) {
        MutableState $this$setValue$iv = this.smeltStatus$delegate;
        $this$setValue$iv.setValue(smeltStatus);
    }
}