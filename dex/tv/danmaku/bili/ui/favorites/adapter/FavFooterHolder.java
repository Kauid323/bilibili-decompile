package tv.danmaku.bili.ui.favorites.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.playset.databinding.BiliAppItemFavFooterBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.adapter.FavFooterHolder;
import tv.danmaku.bili.ui.favorites.card.BaseFavoritesHolder;
import tv.danmaku.bili.ui.favorites.model.FavoritesMediasItem;

/* compiled from: FavoritesListFooterAdapter.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0014R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/adapter/FavFooterHolder;", "Ltv/danmaku/bili/ui/favorites/card/BaseFavoritesHolder;", "Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;", "binding", "Lcom/bilibili/playset/databinding/BiliAppItemFavFooterBinding;", "<init>", "(Lcom/bilibili/playset/databinding/BiliAppItemFavFooterBinding;)V", "getBinding", "()Lcom/bilibili/playset/databinding/BiliAppItemFavFooterBinding;", "bind", "", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FavFooterHolder extends BaseFavoritesHolder<FavoritesMediasItem> {
    private final BiliAppItemFavFooterBinding binding;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: FavoritesListFooterAdapter.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Companion.FavLoadMoreType.values().length];
            try {
                iArr[Companion.FavLoadMoreType.LOAD_MORE_STATUS_GONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Companion.FavLoadMoreType.LOAD_MORE_CLEAN_INVALID.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FavFooterHolder(BiliAppItemFavFooterBinding binding) {
        super(r0);
        Intrinsics.checkNotNullParameter(binding, "binding");
        View root = binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        this.binding = binding;
    }

    public final BiliAppItemFavFooterBinding getBinding() {
        return this.binding;
    }

    protected void bind() {
        switch (WhenMappings.$EnumSwitchMapping$0[((FavoritesMediasItem) getData()).getLoadState().ordinal()]) {
            case 1:
                ListExtentionsKt.gone(this.binding.getRoot());
                return;
            case 2:
                ListExtentionsKt.visible(this.binding.getRoot());
                return;
            default:
                ListExtentionsKt.gone(this.binding.getRoot());
                return;
        }
    }

    /* compiled from: FavoritesListFooterAdapter.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0007¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/adapter/FavFooterHolder$Companion;", "", "<init>", "()V", "create", "Ltv/danmaku/bili/ui/favorites/adapter/FavFooterHolder;", "parent", "Landroid/view/ViewGroup;", "footerClick", "Lkotlin/Function0;", "", "FavLoadMoreType", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {

        /* compiled from: FavoritesListFooterAdapter.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/ui/favorites/adapter/FavFooterHolder$Companion$FavLoadMoreType;", "", "<init>", "(Ljava/lang/String;I)V", "LOAD_MORE_STATUS_LOADING", "LOAD_MORE_STATUS_NO_MORE", "LOAD_MORE_STATUS_GONE", "LOAD_MORE_CLEAN_INVALID", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public enum FavLoadMoreType {
            LOAD_MORE_STATUS_LOADING,
            LOAD_MORE_STATUS_NO_MORE,
            LOAD_MORE_STATUS_GONE,
            LOAD_MORE_CLEAN_INVALID;
            
            private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

            public static EnumEntries<FavLoadMoreType> getEntries() {
                return $ENTRIES;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final FavFooterHolder create(ViewGroup parent, final Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            BiliAppItemFavFooterBinding inflate = BiliAppItemFavFooterBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            FavFooterHolder $this$create_u24lambda_u240 = new FavFooterHolder(inflate);
            $this$create_u24lambda_u240.getBinding().cleanBtn.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorites.adapter.FavFooterHolder$Companion$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FavFooterHolder.Companion.create$lambda$0$0(function0, view);
                }
            });
            return $this$create_u24lambda_u240;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void create$lambda$0$0(Function0 $footerClick, View it) {
            if ($footerClick != null) {
                $footerClick.invoke();
            }
        }
    }

    @JvmStatic
    public static final FavFooterHolder create(ViewGroup parent, Function0<Unit> function0) {
        return Companion.create(parent, function0);
    }
}