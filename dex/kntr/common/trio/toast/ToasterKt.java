package kntr.common.trio.toast;

import androidx.compose.runtime.CompositionLocalAccessorScope;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Toaster.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"LocalToaster", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Lkntr/common/trio/toast/Toaster;", "getLocalToaster", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "trio_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ToasterKt {
    private static final ProvidableCompositionLocal<Toaster> LocalToaster = CompositionLocalKt.compositionLocalWithComputedDefaultOf(new Function1() { // from class: kntr.common.trio.toast.ToasterKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            Toaster LocalToaster$lambda$0;
            LocalToaster$lambda$0 = ToasterKt.LocalToaster$lambda$0((CompositionLocalAccessorScope) obj);
            return LocalToaster$lambda$0;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Toaster LocalToaster$lambda$0(CompositionLocalAccessorScope $this$compositionLocalWithComputedDefaultOf) {
        Intrinsics.checkNotNullParameter($this$compositionLocalWithComputedDefaultOf, "$this$compositionLocalWithComputedDefaultOf");
        return Toaster_androidKt.provideToaster($this$compositionLocalWithComputedDefaultOf);
    }

    public static final ProvidableCompositionLocal<Toaster> getLocalToaster() {
        return LocalToaster;
    }
}