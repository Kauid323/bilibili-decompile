package kntr.common.komponent;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalOnFinish.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u001d\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002*\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"localOnFinishHostRequest", "Lkntr/common/komponent/KomponentLocal;", "Lkotlin/Function0;", "", "getLocalOnFinishHostRequest", "()Lkntr/common/komponent/KomponentLocal;", "finishHost", "Lkntr/common/komponent/KomponentLocalAccessScope;", "getFinishHost", "(Lkntr/common/komponent/KomponentLocalAccessScope;)Lkotlin/jvm/functions/Function0;", "komponent_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LocalOnFinishKt {
    private static final KomponentLocal<Function0<Unit>> localOnFinishHostRequest = KomponentLocalKt.komponentLocal$default(null, new Function1() { // from class: kntr.common.komponent.LocalOnFinishKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            Function0 localOnFinishHostRequest$lambda$0;
            localOnFinishHostRequest$lambda$0 = LocalOnFinishKt.localOnFinishHostRequest$lambda$0((KomponentLocalAccessScope) obj);
            return localOnFinishHostRequest$lambda$0;
        }
    }, 1, null);

    public static final KomponentLocal<Function0<Unit>> getLocalOnFinishHostRequest() {
        return localOnFinishHostRequest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0 localOnFinishHostRequest$lambda$0(KomponentLocalAccessScope $this$komponentLocal) {
        Intrinsics.checkNotNullParameter($this$komponentLocal, "$this$komponentLocal");
        throw new IllegalStateException("No onFinishHost implementation provided.".toString());
    }

    public static final Function0<Unit> getFinishHost(KomponentLocalAccessScope $this$finishHost) {
        Intrinsics.checkNotNullParameter($this$finishHost, "<this>");
        return (Function0) $this$finishHost.getCurrent(localOnFinishHostRequest);
    }
}