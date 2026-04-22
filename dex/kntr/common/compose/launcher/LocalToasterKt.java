package kntr.common.compose.launcher;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.komponent.KomponentLocal;
import kntr.common.komponent.KomponentLocalAccessScope;
import kntr.common.komponent.KomponentLocalKt;
import kntr.common.trio.toast.Toaster;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalToaster.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"localToaster", "Lkntr/common/komponent/KomponentLocal;", "Lkntr/common/trio/toast/Toaster;", "getLocalToaster", "()Lkntr/common/komponent/KomponentLocal;", "compose-launcher_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LocalToasterKt {
    private static final KomponentLocal<Toaster> localToaster = KomponentLocalKt.komponentLocal$default(null, new Function1() { // from class: kntr.common.compose.launcher.LocalToasterKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            Toaster localToaster$lambda$0;
            localToaster$lambda$0 = LocalToasterKt.localToaster$lambda$0((KomponentLocalAccessScope) obj);
            return localToaster$lambda$0;
        }
    }, 1, null);

    public static final KomponentLocal<Toaster> getLocalToaster() {
        return localToaster;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Toaster localToaster$lambda$0(KomponentLocalAccessScope $this$komponentLocal) {
        Intrinsics.checkNotNullParameter($this$komponentLocal, "$this$komponentLocal");
        throw new IllegalStateException("Not provided.".toString());
    }
}