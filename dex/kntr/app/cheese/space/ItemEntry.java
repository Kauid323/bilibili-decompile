package kntr.app.cheese.space;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.komponent.KomponentHostScope;
import kntr.common.komponent.UiComposableLike;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SpaceCheesePerLoadUiService.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkntr/app/cheese/space/ItemEntry;", RoomRecommendViewModel.EMPTY_CURSOR, "ui", "Lkntr/common/komponent/UiComposableLike;", "scope", "Lkntr/common/komponent/KomponentHostScope;", "<init>", "(Lkntr/common/komponent/UiComposableLike;Lkntr/common/komponent/KomponentHostScope;)V", "getUi", "()Lkntr/common/komponent/UiComposableLike;", "getScope", "()Lkntr/common/komponent/KomponentHostScope;", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ItemEntry {
    private final KomponentHostScope scope;
    private final UiComposableLike<Object> ui;

    public ItemEntry(UiComposableLike<? extends Object> uiComposableLike, KomponentHostScope scope) {
        Intrinsics.checkNotNullParameter(uiComposableLike, "ui");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.ui = uiComposableLike;
        this.scope = scope;
    }

    public final UiComposableLike<Object> getUi() {
        return this.ui;
    }

    public final KomponentHostScope getScope() {
        return this.scope;
    }
}