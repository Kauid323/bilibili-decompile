package kntr.app.cheese.space.filter;

import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import com.bilibili.ogv.operation3.module.concept.ModulesScope;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: SeasonFilterTrigger.kt */
@ModulesScope
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003R+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lkntr/app/cheese/space/filter/ClassifiedTypeIndex;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "<set-?>", RoomRecommendViewModel.EMPTY_CURSOR, "value", "getValue", "()I", "setValue", "(I)V", "value$delegate", "Landroidx/compose/runtime/MutableIntState;", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ClassifiedTypeIndex {
    public static final int $stable = 0;
    private final MutableIntState value$delegate = SnapshotIntStateKt.mutableIntStateOf(0);

    public final int getValue() {
        IntState $this$getValue$iv = this.value$delegate;
        return $this$getValue$iv.getIntValue();
    }

    public final void setValue(int i) {
        MutableIntState $this$setValue$iv = this.value$delegate;
        $this$setValue$iv.setIntValue(i);
    }
}