package kntr.common.photonic.aphro.ui.component;

import androidx.compose.foundation.lazy.grid.GridItemSpan;
import androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: LazyGridDsl.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class MediaListKt$GridMediaList_aqv2aB4$lambda$2$2$0$$inlined$itemsIndexed$default$2 implements Function2<LazyGridItemSpanScope, Integer, GridItemSpan> {
    final /* synthetic */ List $items;
    final /* synthetic */ Function3 $span;

    public MediaListKt$GridMediaList_aqv2aB4$lambda$2$2$0$$inlined$itemsIndexed$default$2(Function3 function3, List list) {
        this.$span = function3;
        this.$items = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return GridItemSpan.box-impl(m2265invoke_orMbw((LazyGridItemSpanScope) p1, ((Number) p2).intValue()));
    }

    /* renamed from: invoke-_-orMbw  reason: not valid java name */
    public final long m2265invoke_orMbw(LazyGridItemSpanScope $this$items, int it) {
        return ((GridItemSpan) this.$span.invoke($this$items, Integer.valueOf(it), this.$items.get(it))).unbox-impl();
    }
}