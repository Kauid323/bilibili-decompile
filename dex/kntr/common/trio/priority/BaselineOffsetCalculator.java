package kntr.common.trio.priority;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.TextLayoutResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ComposePriorityHorizon.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u000b0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lkntr/common/trio/priority/BaselineOffsetCalculator;", "", "size", "", "<init>", "(I)V", "baseline", "", "", "_offset", "Landroidx/compose/runtime/MutableState;", "", "offset", "Landroidx/compose/runtime/State;", "getOffset", "()Landroidx/compose/runtime/State;", "onTextLayout", "", "key", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "trio_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BaselineOffsetCalculator {
    public static final int $stable = 8;
    private final int size;
    private final Map<Object, Float> baseline = new LinkedHashMap();
    private final MutableState<Map<Object, Float>> _offset = SnapshotStateKt.mutableStateOf$default(MapsKt.emptyMap(), (SnapshotMutationPolicy) null, 2, (Object) null);
    private final State<Map<Object, Float>> offset = this._offset;

    public BaselineOffsetCalculator(int size) {
        this.size = size;
    }

    public final State<Map<Object, Float>> getOffset() {
        return this.offset;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onTextLayout(Object key, TextLayoutResult layoutResult) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(layoutResult, "layoutResult");
        float offset = layoutResult.getFirstBaseline() - (((int) (4294967295L & layoutResult.getSize-YbymL2g())) / 2.0f);
        Map<Object, Float> map = this.baseline;
        Pair pair = TuplesKt.to(key, Float.valueOf(offset));
        map.put(pair.getFirst(), pair.getSecond());
        if (this.baseline.size() == this.size) {
            Iterator<T> it = this.baseline.entrySet().iterator();
            if (!it.hasNext()) {
                throw new NoSuchElementException();
            }
            Map.Entry it2 = (Map.Entry) it.next();
            float floatValue = ((Number) it2.getValue()).floatValue();
            while (it.hasNext()) {
                Map.Entry it3 = (Map.Entry) it.next();
                floatValue = Math.max(floatValue, ((Number) it3.getValue()).floatValue());
            }
            float max = floatValue;
            Map $this$map$iv = this.baseline;
            Collection destination$iv$iv = new ArrayList($this$map$iv.size());
            for (Map.Entry item$iv$iv : $this$map$iv.entrySet()) {
                destination$iv$iv.add(TuplesKt.to(item$iv$iv.getKey(), Float.valueOf(max - item$iv$iv.getValue().floatValue())));
            }
            Map offsetMap = MapsKt.toMap((List) destination$iv$iv);
            this._offset.setValue(offsetMap);
        }
    }
}