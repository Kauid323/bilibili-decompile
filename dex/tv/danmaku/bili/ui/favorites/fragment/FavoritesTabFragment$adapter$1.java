package tv.danmaku.bili.ui.favorites.fragment;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.app.comm.list.common.widget.bottomsheet.ListBottomSheetDialogV2;
import com.bilibili.app.comm.list.common.widget.bottomsheet.ListImageTitleItem;
import com.bilibili.app.comm.supermenu.core.MenuItemImpl;
import com.bilibili.lib.theme.R;
import com.bilibili.playset.PlaySetShareHelper;
import com.bilibili.playset.api.FavoritesTranslateKt;
import com.bilibili.playset.api.MultitypeMedia;
import com.bilibili.pvtracker.PageViewTracker;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.adapter.FavCardClickListener;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.ui.favorites.model.FavoritesMediasItem;
import tv.danmaku.bili.ui.favorites.model.FavoritesResponseKt;
import tv.danmaku.bili.ui.favorites.state.FavoritesAction;
import tv.danmaku.bili.ui.favorites.util.FavReportHelperKt;
import tv.danmaku.bili.ui.favorites.util.FavoritesUtilsKt;

/* compiled from: FavoritesTabFragment.kt */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"tv/danmaku/bili/ui/favorites/fragment/FavoritesTabFragment$adapter$1", "Ltv/danmaku/bili/ui/favorites/adapter/FavCardClickListener;", "onItemClick", "", "item", "Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;", FavoritesConstsKt.POS, "", "onCheckClick", "onMoreClick", "onClearInvalidItem", "startDrag", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FavoritesTabFragment$adapter$1 implements FavCardClickListener {
    final /* synthetic */ FavoritesTabFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FavoritesTabFragment$adapter$1(FavoritesTabFragment $receiver) {
        this.this$0 = $receiver;
    }

    @Override // tv.danmaku.bili.ui.favorites.adapter.FavCardClickListener
    public void onItemClick(FavoritesMediasItem item, int pos) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.this$0.getViewModel().sendAction(new FavoritesAction.ClickItem(item, pos));
        Pair[] pairArr = new Pair[10];
        pairArr[0] = TuplesKt.to("oid", String.valueOf(item.getOid()));
        pairArr[1] = TuplesKt.to(FavoritesConstsKt.FAV_TYPE, String.valueOf(item.getOtype()));
        pairArr[2] = TuplesKt.to("tab_name", this.this$0.getFirstTabName());
        pairArr[3] = TuplesKt.to("second_tab_name", this.this$0.getSecondTabName());
        pairArr[4] = TuplesKt.to(FavoritesConstsKt.IS_ACQUIESCE, FavoritesUtilsKt.toIsAcquiesce(this.this$0.getTabId(), this.this$0.getActivityVM().getDefaultTabId()));
        pairArr[5] = TuplesKt.to(FavoritesConstsKt.POS, String.valueOf(pos + 1));
        pairArr[6] = TuplesKt.to("from_spmid", this.this$0.getActivityVM().getFromSpmid());
        pairArr[7] = TuplesKt.to(FavoritesConstsKt.USER_STATE, item.getUserStateStr());
        pairArr[8] = TuplesKt.to(FavoritesConstsKt.IS_VALID, item.isInvalid() ? "1" : "0");
        String currentPolarisActionId = PageViewTracker.getInstance().currentPolarisActionId();
        if (currentPolarisActionId == null) {
            currentPolarisActionId = "";
        }
        pairArr[9] = TuplesKt.to(FavoritesConstsKt.ACTION_ID, currentPolarisActionId);
        FavReportHelperKt.reportFavCardClick(MapsKt.mapOf(pairArr));
    }

    @Override // tv.danmaku.bili.ui.favorites.adapter.FavCardClickListener
    public void onCheckClick(int pos) {
        this.this$0.getViewModel().sendAction(new FavoritesAction.CheckItem(pos));
    }

    @Override // tv.danmaku.bili.ui.favorites.adapter.FavCardClickListener
    public void onMoreClick(FavoritesMediasItem item) {
        final FavoritesMediasItem favoritesMediasItem = item;
        Intrinsics.checkNotNullParameter(favoritesMediasItem, "item");
        if (item.getOtype() == 302 || item.getOtype() == 12) {
            Context mContext = this.this$0.getContext();
            if (mContext == null) {
                return;
            }
            Iterable $this$map$iv = FavoritesConstsKt.getFavTabArticleBottomSheetItems();
            final FavoritesTabFragment favoritesTabFragment = this.this$0;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                final Pair it = (Pair) item$iv$iv;
                destination$iv$iv.add(new ListImageTitleItem(mContext.getString(((Number) it.getFirst()).intValue()), (String) null, (Integer) it.getSecond(), 0, R.color.Text1, false, 0, new Function0() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTabFragment$adapter$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit onMoreClick$lambda$0$0;
                        onMoreClick$lambda$0$0 = FavoritesTabFragment$adapter$1.onMoreClick$lambda$0$0(FavoritesTabFragment.this, favoritesMediasItem, it);
                        return onMoreClick$lambda$0$0;
                    }
                }, (int) BR.config, (DefaultConstructorMarker) null));
                favoritesMediasItem = item;
            }
            ArrayList items = new ArrayList((List) destination$iv$iv);
            ListBottomSheetDialogV2 newInstance = ListBottomSheetDialogV2.Companion.newInstance();
            FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            ListBottomSheetDialogV2.show$default(newInstance, childFragmentManager, (String) null, items, (Function0) null, "FavoriteTab Article", 10, (Object) null);
            return;
        }
        Activity activity = this.this$0.getActivity();
        if (activity == null) {
            return;
        }
        PlaySetShareHelper playSetShareHelper = new PlaySetShareHelper("main.my-favorite.option-more.0.click", FavoritesResponseKt.getShareType(item), FavoritesResponseKt.getShareFrom(item), "main.my-favorite.option-more.0.click");
        MultitypeMedia multiTypeMedia = FavoritesResponseKt.toMultiTypeMedia(item);
        List<MenuItemImpl> customMenuItems = FavoritesResponseKt.getCustomMenuItems(favoritesMediasItem, activity);
        final FavoritesTabFragment favoritesTabFragment2 = this.this$0;
        playSetShareHelper.shareNew(activity, multiTypeMedia, customMenuItems, new Function1() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTabFragment$adapter$1$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                boolean onMoreClick$lambda$1;
                onMoreClick$lambda$1 = FavoritesTabFragment$adapter$1.onMoreClick$lambda$1(FavoritesTabFragment.this, favoritesMediasItem, (String) obj);
                return Boolean.valueOf(onMoreClick$lambda$1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onMoreClick$lambda$0$0(FavoritesTabFragment this$0, FavoritesMediasItem $item, Pair $it) {
        this$0.getViewModel().sendAction(new FavoritesAction.DeleteItem($item));
        String string = this$0.getString(((Number) $it.getFirst()).intValue());
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        FavReportHelperKt.reportSecButtonClick(string);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onMoreClick$lambda$1(FavoritesTabFragment this$0, FavoritesMediasItem $item, String menuId) {
        Intrinsics.checkNotNullParameter(menuId, "menuId");
        if (Intrinsics.areEqual(menuId, "delete_favorite")) {
            this$0.getViewModel().sendAction(new FavoritesAction.DeleteItem($item));
            return true;
        } else if (Intrinsics.areEqual(menuId, "menu_translate")) {
            Pair[] pairArr = new Pair[6];
            pairArr[0] = TuplesKt.to("action_type", FavoritesTranslateKt.isTranslated($item) ? "original" : "translate");
            pairArr[1] = TuplesKt.to("card_page", "list");
            pairArr[2] = TuplesKt.to("oid", String.valueOf($item.getOid()));
            pairArr[3] = TuplesKt.to(FavoritesConstsKt.FAV_TYPE, String.valueOf($item.getOtype()));
            pairArr[4] = TuplesKt.to("tab_name", this$0.getFirstTabName());
            pairArr[5] = TuplesKt.to("second_tab_name", this$0.getSecondTabName());
            FavReportHelperKt.reportSwitchTranslateClick(MapsKt.mapOf(pairArr));
            this$0.getViewModel().sendAction(new FavoritesAction.SwitchTranslate($item));
            return true;
        } else {
            return false;
        }
    }

    @Override // tv.danmaku.bili.ui.favorites.adapter.FavCardClickListener
    public void onClearInvalidItem(FavoritesMediasItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.this$0.getViewModel().sendAction(new FavoritesAction.ClearInvalidVideo(item));
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to(FavoritesConstsKt.BUTTON_NAME, "3");
        String currentPolarisActionId = PageViewTracker.getInstance().currentPolarisActionId();
        if (currentPolarisActionId == null) {
            currentPolarisActionId = "";
        }
        pairArr[1] = TuplesKt.to(FavoritesConstsKt.ACTION_ID, currentPolarisActionId);
        FavReportHelperKt.reportFavClick(FavoritesConstsKt.FAV_FIRST_BUTTON_CLICK, MapsKt.mapOf(pairArr));
    }

    @Override // tv.danmaku.bili.ui.favorites.adapter.FavCardClickListener
    public void startDrag(RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
    }
}