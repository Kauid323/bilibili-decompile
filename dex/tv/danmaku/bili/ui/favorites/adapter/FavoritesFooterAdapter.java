package tv.danmaku.bili.ui.favorites.adapter;

import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.adapter.FavFooterHolder;
import tv.danmaku.bili.ui.favorites.card.BaseFavoritesHolder;
import tv.danmaku.bili.ui.favorites.model.FavoritesMediasItem;

/* compiled from: FavoritesListFooterAdapter.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0012H\u0016J\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0006\u0010\u0019\u001a\u00020\u0006R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/ui/favorites/adapter/FavoritesFooterAdapter;", "Ltv/danmaku/bili/ui/favorites/adapter/FavoritesListAdapter;", "cardClickListener", "Ltv/danmaku/bili/ui/favorites/adapter/FavCardClickListener;", "footerClick", "Lkotlin/Function0;", "", "<init>", "(Ltv/danmaku/bili/ui/favorites/adapter/FavCardClickListener;Lkotlin/jvm/functions/Function0;)V", "footerItem", "Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;", "showFooterGone", "submitNewList", "showFooterCleanInvalid", "mediaList", "", "submitList", "list", "", "onCreateViewHolder", "Ltv/danmaku/bili/ui/favorites/card/BaseFavoritesHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "loadMore", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FavoritesFooterAdapter extends FavoritesListAdapter {
    public static final String TAG = "FavoritesListFooterAdapter";
    private final Function0<Unit> footerClick;
    private FavoritesMediasItem footerItem;
    private List<FavoritesMediasItem> mediaList;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FavoritesFooterAdapter(FavCardClickListener cardClickListener, Function0<Unit> function0) {
        super(cardClickListener);
        Intrinsics.checkNotNullParameter(cardClickListener, "cardClickListener");
        this.footerClick = function0;
        this.footerItem = new FavoritesMediasItem(null, null, 0, 0L, null, null, null, null, 0, 0, null, null, 0, null, null, 0, null, 0, 0, false, false, 4, false, false, false, null, 65011711, null);
    }

    public void showFooterGone() {
        super.submitList(this.mediaList);
    }

    private final void submitNewList() {
        List<FavoritesMediasItem> list = this.mediaList;
        List newList = list != null ? CollectionsKt.toMutableList(list) : null;
        if (newList != null) {
            newList.add(this.footerItem);
        }
        super.submitList(newList);
    }

    public void showFooterCleanInvalid() {
        this.footerItem.setLoadState(FavFooterHolder.Companion.FavLoadMoreType.LOAD_MORE_CLEAN_INVALID);
        submitNewList();
    }

    public void submitList(List<FavoritesMediasItem> list) {
        ArrayList arrayList;
        if (list == null || (arrayList = CollectionsKt.toMutableList(list)) == null) {
            arrayList = new ArrayList();
        }
        this.mediaList = arrayList;
        super.submitList(list);
    }

    @Override // tv.danmaku.bili.ui.favorites.adapter.FavoritesListAdapter
    public BaseFavoritesHolder<FavoritesMediasItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 4) {
            FavFooterHolder create = FavFooterHolder.Companion.create(parent, this.footerClick);
            Intrinsics.checkNotNull(create, "null cannot be cast to non-null type tv.danmaku.bili.ui.favorites.card.BaseFavoritesHolder<tv.danmaku.bili.ui.favorites.model.FavoritesMediasItem>");
            return create;
        }
        return super.onCreateViewHolder(parent, viewType);
    }

    public final void loadMore() {
        Function0<Unit> function0 = this.footerClick;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* compiled from: FavoritesListFooterAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/favorites/adapter/FavoritesFooterAdapter$Companion;", "", "<init>", "()V", "TAG", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}