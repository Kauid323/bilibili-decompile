package kntr.app.deepsearch.ui.paragraph.text;

import androidx.compose.ui.text.style.TextDecoration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepSearchTextNodeStyleModule.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0080\u0006¨\u0006\u0003"}, d2 = {"minus", "Landroidx/compose/ui/text/style/TextDecoration;", "other", "compose_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchTextNodeStyleModuleKt {
    public static final TextDecoration minus(TextDecoration $this$minus, TextDecoration other) {
        Intrinsics.checkNotNullParameter($this$minus, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Iterable $this$filter$iv = CollectionsKt.listOf(new TextDecoration[]{TextDecoration.Companion.getNone(), TextDecoration.Companion.getUnderline(), TextDecoration.Companion.getLineThrough()});
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            TextDecoration it = (TextDecoration) element$iv$iv;
            if (((!$this$minus.contains(it) || other.contains(it)) ? null : 1) != null) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return TextDecoration.Companion.combine((List) destination$iv$iv);
    }
}