package kntr.app.deepsearch.ui.key;

import androidx.compose.foundation.lazy.LazyListScope;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Key.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a1\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"keyScope", RoomRecommendViewModel.EMPTY_CURSOR, "Landroidx/compose/foundation/lazy/LazyListScope;", "startIndex", "block", "Lkotlin/Function1;", "Lkntr/app/deepsearch/ui/key/ListKeyScope;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/ExtensionFunctionType;", "compose_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class KeyKt {
    public static final int keyScope(LazyListScope $this$keyScope, int startIndex, Function1<? super ListKeyScope, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$keyScope, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        ListKeyScope $this$keyScope_u24lambda_u240 = new ListKeyScope($this$keyScope, startIndex);
        function1.invoke($this$keyScope_u24lambda_u240);
        return $this$keyScope_u24lambda_u240.getEndIndex();
    }
}