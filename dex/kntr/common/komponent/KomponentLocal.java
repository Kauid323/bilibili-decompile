package kntr.common.komponent;

import androidx.compose.runtime.CompositionLocal;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KomponentLocal.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B2\b\u0000\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004\u0012\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\b\b¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR%\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\b\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lkntr/common/komponent/KomponentLocal;", "V", "", "associatedCompositionLocal", "Landroidx/compose/runtime/CompositionLocal;", "defaultComputation", "Lkotlin/Function1;", "Lkntr/common/komponent/KomponentLocalAccessScope;", "Lkotlin/ExtensionFunctionType;", "<init>", "(Landroidx/compose/runtime/CompositionLocal;Lkotlin/jvm/functions/Function1;)V", "getAssociatedCompositionLocal$komponent_debug", "()Landroidx/compose/runtime/CompositionLocal;", "getDefaultComputation$komponent_debug", "()Lkotlin/jvm/functions/Function1;", "komponent_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KomponentLocal<V> {
    public static final int $stable = 0;
    private final CompositionLocal<V> associatedCompositionLocal;
    private final Function1<KomponentLocalAccessScope, V> defaultComputation;

    /* JADX WARN: Multi-variable type inference failed */
    public KomponentLocal(CompositionLocal<V> compositionLocal, Function1<? super KomponentLocalAccessScope, ? extends V> function1) {
        Intrinsics.checkNotNullParameter(function1, "defaultComputation");
        this.associatedCompositionLocal = compositionLocal;
        this.defaultComputation = function1;
    }

    public final CompositionLocal<V> getAssociatedCompositionLocal$komponent_debug() {
        return this.associatedCompositionLocal;
    }

    public final Function1<KomponentLocalAccessScope, V> getDefaultComputation$komponent_debug() {
        return this.defaultComputation;
    }
}