package tv.danmaku.bili.ui.favorite;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.bottomoptionsheet.BottomOptionSheet;
import com.bilibili.bottomoptionsheet.SheetItem;
import com.bilibili.bottomoptionsheet.listeners.OnSheetItemClickListener;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.ogv.infra.account.BiliAccountsKt;
import com.bilibili.okretro.call.rxjava.CompletableSubscriberBuilder;
import com.bilibili.okretro.call.rxjava.RxUtilsKt;
import com.bilibili.pvtracker.IPvTracker;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.favorite.FavoriteCheeseFragment;
import tv.danmaku.bili.ui.favorite.cheesesupport.BaseCheeseListFragment;
import tv.danmaku.bili.ui.favorite.cheesesupport.CheeseApiManagerKt;
import tv.danmaku.bili.ui.favorite.cheesesupport.CheeseListAdapter;
import tv.danmaku.bili.ui.favorite.cheesesupport.CheeseListReporter;
import tv.danmaku.bili.ui.favorite.cheesesupport.CheeseListVM;
import tv.danmaku.bili.ui.favorite.cheesesupport.CheeseListVMForFav;
import tv.danmaku.bili.ui.favorite.cheesesupport.ICheeseItemProxy;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.widget.section.holder.BaseViewHolder;

/* compiled from: FavoriteCheeseFragment.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000e2\u00020\u00012\u00020\u0002:\u0002\r\u000eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0014J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/ui/favorite/FavoriteCheeseFragment;", "Ltv/danmaku/bili/ui/favorite/cheesesupport/BaseCheeseListFragment;", "Lcom/bilibili/pvtracker/IPvTracker;", "<init>", "()V", "getPvEventId", "", "getPvExtra", "Landroid/os/Bundle;", "createAdapter", "Ltv/danmaku/bili/ui/favorite/cheesesupport/CheeseListAdapter;", "initViewModel", "Ltv/danmaku/bili/ui/favorite/cheesesupport/CheeseListVM;", "FavAdapter", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FavoriteCheeseFragment extends BaseCheeseListFragment implements IPvTracker {
    private static final String BUNDLE_KEY_MID = "mid";
    private static final String MENU_ID_FAV_CANCEL = "fav_cancel";
    private static final String PARAM_KEY_FROM_SPMID = "from_spmid";
    private static final String PARAM_VALUE_FROM_SPMID = "main.my-favorite-pugv.packagecard.0";
    private static final String REPORT_KEY_SID = "seasonid";
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public /* synthetic */ boolean appendEndExtra() {
        return IPvTracker.-CC.$default$appendEndExtra(this);
    }

    public /* synthetic */ String getUniqueKey() {
        return IPvTracker.-CC.$default$getUniqueKey(this);
    }

    public /* synthetic */ boolean shouldReport() {
        return IPvTracker.-CC.$default$shouldReport(this);
    }

    public String getPvEventId() {
        return CheeseListReporter.EVENT_ID_FAV_CHEESE_TAB_PAGE_VIEW;
    }

    public Bundle getPvExtra() {
        return new Bundle();
    }

    @Override // tv.danmaku.bili.ui.favorite.cheesesupport.BaseCheeseListFragment
    protected CheeseListAdapter createAdapter() {
        return new FavAdapter();
    }

    @Override // tv.danmaku.bili.ui.favorite.cheesesupport.BaseCheeseListFragment
    public CheeseListVM initViewModel() {
        return CheeseListVMForFav.Companion.getViewModel((Fragment) this);
    }

    /* compiled from: FavoriteCheeseFragment.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0017J\"\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0002J\"\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010H\u0002¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/ui/favorite/FavoriteCheeseFragment$FavAdapter;", "Ltv/danmaku/bili/ui/favorite/cheesesupport/CheeseListAdapter;", "<init>", "(Ltv/danmaku/bili/ui/favorite/FavoriteCheeseFragment;)V", "bindHolder", "", "holder", "Ltv/danmaku/bili/widget/section/holder/BaseViewHolder;", FavoritesConstsKt.POS, "", "itemView", "Landroid/view/View;", "goToUri", "context", "Landroid/content/Context;", "url", "", "fromSpmId", "appendParam", "Landroid/net/Uri;", "key", "value", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final class FavAdapter extends CheeseListAdapter {
        public FavAdapter() {
        }

        @Override // tv.danmaku.bili.ui.favorite.cheesesupport.CheeseListAdapter
        public void bindHolder(BaseViewHolder holder, int pos, final View itemView) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            super.bindHolder(holder, pos, itemView);
            final ICheeseItemProxy dataItem = getItem(pos);
            View moreView = itemView != null ? itemView.findViewById(R.id.more) : null;
            if (moreView != null) {
                moreView.setVisibility(0);
            }
            if (moreView != null) {
                final FavoriteCheeseFragment favoriteCheeseFragment = FavoriteCheeseFragment.this;
                moreView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorite.FavoriteCheeseFragment$FavAdapter$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FavoriteCheeseFragment.FavAdapter.bindHolder$lambda$0(itemView, dataItem, this, favoriteCheeseFragment, view);
                    }
                });
            }
            if (itemView != null) {
                final FavoriteCheeseFragment favoriteCheeseFragment2 = FavoriteCheeseFragment.this;
                itemView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorite.FavoriteCheeseFragment$FavAdapter$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FavoriteCheeseFragment.FavAdapter.bindHolder$lambda$1(ICheeseItemProxy.this, favoriteCheeseFragment2, this, view);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bindHolder$lambda$0(final View $itemView, final ICheeseItemProxy $dataItem, final FavAdapter this$0, final FavoriteCheeseFragment this$1, View it) {
            Context context = $itemView.getContext();
            if (context == null) {
                return;
            }
            BottomOptionSheet optionSheet = new BottomOptionSheet(context);
            optionSheet.addSheetItem(new SheetItem($itemView.getContext(), FavoriteCheeseFragment.MENU_ID_FAV_CANCEL, bili.resource.favorites.R.string.favorites_global_string_26));
            optionSheet.sheetItemClickListener(new OnSheetItemClickListener() { // from class: tv.danmaku.bili.ui.favorite.FavoriteCheeseFragment$FavAdapter$$ExternalSyntheticLambda4
                public final void onItemClick(SheetItem sheetItem) {
                    FavoriteCheeseFragment.FavAdapter.bindHolder$lambda$0$0(ICheeseItemProxy.this, this$0, this$1, $itemView, sheetItem);
                }
            });
            optionSheet.show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bindHolder$lambda$0$0(final ICheeseItemProxy $dataItem, final FavAdapter this$0, final FavoriteCheeseFragment this$1, final View $itemView, SheetItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            String id = item.getId();
            switch (id.hashCode()) {
                case -1259996130:
                    if (id.equals(FavoriteCheeseFragment.MENU_ID_FAV_CANCEL)) {
                        String accessKey = BiliAccountsKt.getBiliAccounts().getAccessKey();
                        Intrinsics.checkNotNullExpressionValue(accessKey, "getAccessKey(...)");
                        Completable $this$subscribeBy$iv = CheeseApiManagerKt.cancelFavCheese(accessKey, $dataItem != null ? $dataItem.getSeasonId() : 0L);
                        CompletableSubscriberBuilder builder$iv = new CompletableSubscriberBuilder();
                        builder$iv.onComplete(new Action() { // from class: tv.danmaku.bili.ui.favorite.FavoriteCheeseFragment$FavAdapter$$ExternalSyntheticLambda0
                            public final void run() {
                                FavoriteCheeseFragment.FavAdapter.bindHolder$lambda$0$0$0$0(FavoriteCheeseFragment.FavAdapter.this, $dataItem, this$1);
                            }
                        });
                        builder$iv.onError(new Consumer() { // from class: tv.danmaku.bili.ui.favorite.FavoriteCheeseFragment$FavAdapter$$ExternalSyntheticLambda1
                            public final void accept(Object obj) {
                                FavoriteCheeseFragment.FavAdapter.bindHolder$lambda$0$0$0$1($itemView, (Throwable) obj);
                            }
                        });
                        RxUtilsKt.subscribeInternal($this$subscribeBy$iv, builder$iv.getOnComplete(), builder$iv.getOnError());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bindHolder$lambda$0$0$0$0(FavAdapter this$0, ICheeseItemProxy $dataItem, FavoriteCheeseFragment this$1) {
            this$0.removeItem(this$0.indexOf($dataItem));
            if (this$0.getItemCount() == 0) {
                RecyclerView recyclerView = this$1.getRecyclerView();
                if (recyclerView != null) {
                    recyclerView.setVisibility(8);
                }
                this$1.showEmptyTips();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bindHolder$lambda$0$0$0$1(View $itemView, Throwable it) {
            Intrinsics.checkNotNullParameter(it, "it");
            ToastHelper.showToast($itemView.getContext(), bili.resource.playerbaseres.R.string.playerbaseres_global_string_463, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bindHolder$lambda$1(ICheeseItemProxy $dataItem, FavoriteCheeseFragment this$0, FavAdapter this$1, View it) {
            String $this$toUri$iv = ($dataItem == null || ($this$toUri$iv = $dataItem.getLink()) == null) ? "" : "";
            String uri = Uri.parse($this$toUri$iv).buildUpon().appendQueryParameter("from_spmid", FavoriteCheeseFragment.PARAM_VALUE_FROM_SPMID).build().toString();
            Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
            Context context = this$0.getContext();
            if (context != null) {
                goToUri$default(this$1, context, uri, null, 4, null);
            }
            CheeseListReporter.INSTANCE.reportClick(CheeseListReporter.EVENT_ID_FAV_CHEESE_ITEM_CLICK, MapsKt.mapOf(TuplesKt.to(FavoriteCheeseFragment.REPORT_KEY_SID, String.valueOf($dataItem != null ? Long.valueOf($dataItem.getSeasonId()) : null))));
        }

        static /* synthetic */ void goToUri$default(FavAdapter favAdapter, Context context, String str, String str2, int i, Object obj) {
            if ((i & 4) != 0) {
                str2 = "";
            }
            favAdapter.goToUri(context, str, str2);
        }

        private final void goToUri(Context context, String url, String fromSpmId) {
            String str;
            if (url.length() == 0) {
                return;
            }
            String finalUrl = url;
            if (fromSpmId.length() > 0) {
                Uri uri = appendParam(url, "from_spmid", fromSpmId);
                if (uri == null || (str = uri.toString()) == null) {
                    str = url;
                }
                finalUrl = str;
            }
            BLRouter.routeTo(RouteRequestKt.toRouteRequest(finalUrl), context);
        }

        private final Uri appendParam(String url, String key, String value) {
            try {
                Uri.Builder build = Uri.parse(url).buildUpon().appendQueryParameter(key, value);
                return build.build();
            } catch (Exception e) {
                BLog.d("appendParam error = " + e);
                return null;
            }
        }
    }

    /* compiled from: FavoriteCheeseFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/ui/favorite/FavoriteCheeseFragment$Companion;", "", "<init>", "()V", "BUNDLE_KEY_MID", "", "MENU_ID_FAV_CANCEL", "PARAM_KEY_FROM_SPMID", "PARAM_VALUE_FROM_SPMID", "REPORT_KEY_SID", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}