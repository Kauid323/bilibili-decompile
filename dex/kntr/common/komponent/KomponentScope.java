package kntr.common.komponent;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: Komponent.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J\u0016\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH&J\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H&J\u0016\u0010\u0014\u001a\u00020\u00102\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0012H&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0001\u0001\u0017¨\u0006\u0018À\u0006\u0003"}, d2 = {"Lkntr/common/komponent/KomponentScope;", "S", "Lkntr/common/komponent/KomponentHostScope;", "key", "", "getKey", "()Ljava/lang/Object;", "preferredHostConfiguration", "Lkntr/common/komponent/HostConfiguration;", "getPreferredHostConfiguration", "()Lkntr/common/komponent/HostConfiguration;", "__setContent", "Lkntr/common/komponent/SetContentResult;", "content", "Lkntr/common/komponent/UiComposableLike;", "setPreferredOrientation", "", "orientationProvider", "Lkotlin/Function0;", "Lkntr/common/komponent/Orientation;", "setPopGestureEnabled", "popGestureEnabledProvider", "", "Lkntr/common/komponent/KomponentScopeImpl;", "komponent_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface KomponentScope<S> extends KomponentHostScope {
    SetContentResult __setContent(UiComposableLike<? extends S> uiComposableLike);

    Object getKey();

    HostConfiguration getPreferredHostConfiguration();

    void setPopGestureEnabled(Function0<Boolean> function0);

    void setPreferredOrientation(Function0<? extends Orientation> function0);
}