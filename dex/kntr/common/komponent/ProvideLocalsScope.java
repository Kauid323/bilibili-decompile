package kntr.common.komponent;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: Komponent.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J&\u0010\u0007\u001a\u00020\b\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\t\u001a\u0002H\u0003H¦\u0004¢\u0006\u0002\u0010\nR\"\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lkntr/common/komponent/ProvideLocalsScope;", "Lkntr/common/komponent/KomponentLocalAccessScope;", "current", "V", "Lkntr/common/komponent/KomponentLocal;", "getCurrent", "(Lkntr/common/komponent/KomponentLocal;)Ljava/lang/Object;", "provides", "", "value", "(Lkntr/common/komponent/KomponentLocal;Ljava/lang/Object;)V", "komponent_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface ProvideLocalsScope extends KomponentLocalAccessScope {
    @Override // kntr.common.komponent.KomponentLocalAccessScope
    <V> V getCurrent(KomponentLocal<V> komponentLocal);

    <V> void provides(KomponentLocal<V> komponentLocal, V v);
}