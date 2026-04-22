package kntr.app.digital.preview.aggregate;

import kntr.app.digital.preview.aggregate.CardPreviewComponent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.router.target.RouterTarget;
import kntr.base.router.target.RouterTargetContext;
import kntr.common.komponent.KomponentScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CardPreviewComponent.android.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00030\u0004H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"cardPreviewComponentFactory", "Lkntr/app/digital/preview/aggregate/CardPreviewComponent$Factory;", "initCardPreviewForPlatform", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/common/komponent/KomponentScope;", "previewRouterTarget", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "preview_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CardPreviewComponent_androidKt {
    public static final CardPreviewComponent.Factory cardPreviewComponentFactory() {
        return DaggerCardPreviewComponent.Companion.factory();
    }

    public static final void initCardPreviewForPlatform(KomponentScope<? super Unit> komponentScope) {
        Intrinsics.checkNotNullParameter(komponentScope, "<this>");
    }

    public static final RouterTarget previewRouterTarget(RouterTargetContext $this$previewRouterTarget) {
        Intrinsics.checkNotNullParameter($this$previewRouterTarget, "<this>");
        return $this$previewRouterTarget.find($this$previewRouterTarget.getUri().buildUpon().appendPath("kntr").build());
    }
}