package kntr.common.compose.launcher;

import android.content.Context;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.komponent.KomponentLocal;
import kntr.common.komponent.KomponentLocalAccessScope;
import kntr.common.komponent.KomponentLocalKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalContext.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0002*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"localContext", "Lkntr/common/komponent/KomponentLocal;", "Landroid/content/Context;", "getLocalContext", "()Lkntr/common/komponent/KomponentLocal;", "context", "Lkntr/common/komponent/KomponentLocalAccessScope;", "getContext", "(Lkntr/common/komponent/KomponentLocalAccessScope;)Landroid/content/Context;", "compose-launcher_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LocalContextKt {
    private static final KomponentLocal<Context> localContext = KomponentLocalKt.komponentLocal$default(null, new Function1() { // from class: kntr.common.compose.launcher.LocalContextKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            Context localContext$lambda$0;
            localContext$lambda$0 = LocalContextKt.localContext$lambda$0((KomponentLocalAccessScope) obj);
            return localContext$lambda$0;
        }
    }, 1, null);

    public static final KomponentLocal<Context> getLocalContext() {
        return localContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Context localContext$lambda$0(KomponentLocalAccessScope $this$komponentLocal) {
        Intrinsics.checkNotNullParameter($this$komponentLocal, "$this$komponentLocal");
        throw new IllegalStateException("No Context value provided.".toString());
    }

    public static final Context getContext(KomponentLocalAccessScope $this$context) {
        Intrinsics.checkNotNullParameter($this$context, "<this>");
        return (Context) $this$context.getCurrent(localContext);
    }
}