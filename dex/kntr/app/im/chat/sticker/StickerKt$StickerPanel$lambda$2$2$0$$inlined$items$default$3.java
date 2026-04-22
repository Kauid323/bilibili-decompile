package kntr.app.im.chat.sticker;

import androidx.compose.foundation.lazy.grid.GridItemSpan;
import androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* compiled from: LazyGridDsl.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class StickerKt$StickerPanel$lambda$2$2$0$$inlined$items$default$3 implements Function2<LazyGridItemSpanScope, Integer, GridItemSpan> {
    final /* synthetic */ List $items;
    final /* synthetic */ Function2 $span;

    public StickerKt$StickerPanel$lambda$2$2$0$$inlined$items$default$3(Function2 function2, List list) {
        this.$span = function2;
        this.$items = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return GridItemSpan.box-impl(m1640invoke_orMbw((LazyGridItemSpanScope) p1, ((Number) p2).intValue()));
    }

    /* renamed from: invoke-_-orMbw  reason: not valid java name */
    public final long m1640invoke_orMbw(LazyGridItemSpanScope $this$items, int it) {
        return ((GridItemSpan) this.$span.invoke($this$items, this.$items.get(it))).unbox-impl();
    }
}