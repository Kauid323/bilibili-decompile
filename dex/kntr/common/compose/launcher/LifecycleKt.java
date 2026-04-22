package kntr.common.compose.launcher;

import androidx.lifecycle.LifecycleOwner;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.komponent.KomponentLocal;
import kntr.common.komponent.KomponentLocalAccessScope;
import kntr.common.komponent.KomponentLocalKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Lifecycle.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"localLifecycleOwner", "Lkntr/common/komponent/KomponentLocal;", "Landroidx/lifecycle/LifecycleOwner;", "getLocalLifecycleOwner", "()Lkntr/common/komponent/KomponentLocal;", "compose-launcher_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LifecycleKt {
    private static final KomponentLocal<LifecycleOwner> localLifecycleOwner = KomponentLocalKt.komponentLocal$default(null, new Function1() { // from class: kntr.common.compose.launcher.LifecycleKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            LifecycleOwner localLifecycleOwner$lambda$0;
            localLifecycleOwner$lambda$0 = LifecycleKt.localLifecycleOwner$lambda$0((KomponentLocalAccessScope) obj);
            return localLifecycleOwner$lambda$0;
        }
    }, 1, null);

    public static final KomponentLocal<LifecycleOwner> getLocalLifecycleOwner() {
        return localLifecycleOwner;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LifecycleOwner localLifecycleOwner$lambda$0(KomponentLocalAccessScope $this$komponentLocal) {
        Intrinsics.checkNotNullParameter($this$komponentLocal, "$this$komponentLocal");
        throw new IllegalStateException("No LifecycleOwner value provided.".toString());
    }
}