package kntr.common.komponent;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Komponent.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B&\u0012\u001d\u0010\u0003\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b\b\u0010\tR(\u0010\u0003\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkntr/common/komponent/KomponentImpl;", "S", "Lkntr/common/komponent/Komponent;", "setup", "Lkotlin/Function1;", "Lkntr/common/komponent/KomponentScope;", "Lkntr/common/komponent/SetContentResult;", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getSetup", "()Lkotlin/jvm/functions/Function1;", "komponent_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KomponentImpl<S> implements Komponent<S> {
    public static final int $stable = 0;
    private final Function1<KomponentScope<? super S>, SetContentResult> setup;

    /* JADX WARN: Multi-variable type inference failed */
    public KomponentImpl(Function1<? super KomponentScope<? super S>, ? extends SetContentResult> function1) {
        Intrinsics.checkNotNullParameter(function1, "setup");
        this.setup = function1;
    }

    public final Function1<KomponentScope<? super S>, SetContentResult> getSetup() {
        return this.setup;
    }
}