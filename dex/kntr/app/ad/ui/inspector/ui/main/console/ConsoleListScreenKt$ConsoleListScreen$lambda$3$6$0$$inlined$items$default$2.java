package kntr.app.ad.ui.inspector.ui.main.console;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: LazyDsl.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ConsoleListScreenKt$ConsoleListScreen$lambda$3$6$0$$inlined$items$default$2 implements Function1<Integer, Object> {
    final /* synthetic */ List $items;
    final /* synthetic */ Function1 $key;

    public ConsoleListScreenKt$ConsoleListScreen$lambda$3$6$0$$inlined$items$default$2(Function1 function1, List list) {
        this.$key = function1;
        this.$items = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return invoke(((Number) p1).intValue());
    }

    public final Object invoke(int index) {
        return this.$key.invoke(this.$items.get(index));
    }
}