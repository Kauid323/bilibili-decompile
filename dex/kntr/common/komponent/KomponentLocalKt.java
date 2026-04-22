package kntr.common.komponent;

import androidx.compose.runtime.CompositionLocal;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KomponentLocal.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a=\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u00020\u0006¢\u0006\u0002\b\b¨\u0006\t"}, d2 = {"komponentLocal", "Lkntr/common/komponent/KomponentLocal;", "V", "associatedCompositionLocal", "Landroidx/compose/runtime/CompositionLocal;", "defaultComputation", "Lkotlin/Function1;", "Lkntr/common/komponent/KomponentLocalAccessScope;", "Lkotlin/ExtensionFunctionType;", "komponent_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KomponentLocalKt {
    public static /* synthetic */ KomponentLocal komponentLocal$default(CompositionLocal compositionLocal, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            compositionLocal = null;
        }
        return komponentLocal(compositionLocal, function1);
    }

    public static final <V> KomponentLocal<V> komponentLocal(CompositionLocal<V> compositionLocal, Function1<? super KomponentLocalAccessScope, ? extends V> function1) {
        Intrinsics.checkNotNullParameter(function1, "defaultComputation");
        return new KomponentLocal<>(compositionLocal, function1);
    }
}