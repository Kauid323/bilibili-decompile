package tv.danmaku.bili.ui.favorites.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewpager2.widget.ViewPager2;
import bili.resource.favorites.R;
import com.bilibili.adcommon.utils.AdRouters;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.iconfont.KtxKt;
import com.bilibili.magicasakura.widgets.TintImageView;
import com.bilibili.playset.editor.utils.PlaySetEditorRouterUtilsKt;
import com.bilibili.pvtracker.PageViewTracker;
import com.google.android.material.tabs.TabLayout;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.databinding.BiliAppFragmentCollectionTabPageBinding;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.ui.favorites.model.SubTab;
import tv.danmaku.bili.ui.favorites.state.FavoritesPageAction;
import tv.danmaku.bili.ui.favorites.util.FavReportHelperKt;
import tv.danmaku.bili.ui.favorites.util.FavRouterUtilsKt;
import tv.danmaku.bili.ui.favorites.util.FavoritesFolderUtilsKt;
import tv.danmaku.bili.ui.watchlater.utils.WatchLaterRouterKt;

/* compiled from: FavoritesTopTabFragment.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\b\u0010\u0011\u001a\u00020\u000bH\u0002J\b\u0010\u0012\u001a\u00020\u000bH\u0002J\b\u0010\u0013\u001a\u00020\u000bH\u0002J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u000bH\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0019H\u0002R\u001f\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u001e"}, d2 = {"Ltv/danmaku/bili/ui/favorites/fragment/FavoritesTopTabFragment;", "Ltv/danmaku/bili/ui/favorites/fragment/FavoritesTopTabBaseFragment;", "<init>", "()V", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "getLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "initFavTab", "initUI", "collectEvent", "registerCallback", "doSearch", "url", "", "onRetryClick", "getDefaultTabIndex", "", "defaultTabId", "findOrNOID", "tabsForNoDefault", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FavoritesTopTabFragment extends FavoritesTopTabBaseFragment {
    public static final String TAG = "FavoritesTopTabFragment";
    private final ActivityResultLauncher<Intent> launcher;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public FavoritesTopTabFragment() {
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTopTabFragment$$ExternalSyntheticLambda3
            public final void onActivityResult(Object obj) {
                FavoritesTopTabFragment.launcher$lambda$0(FavoritesTopTabFragment.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.launcher = registerForActivityResult;
    }

    public final ActivityResultLauncher<Intent> getLauncher() {
        return this.launcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void launcher$lambda$0(FavoritesTopTabFragment this$0, ActivityResult it) {
        SubTab subTab;
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getResultCode() == -1) {
            List<SubTab> subTabs = this$0.getSubTabs();
            boolean z = false;
            if (subTabs != null && (subTab = (SubTab) CollectionsKt.getOrNull(subTabs, 0)) != null && subTab.getTabId() == 100) {
                z = true;
            }
            if (z) {
                this$0.getActivityVM().sendAction(FavoritesPageAction.ForceRefresh.INSTANCE);
            }
        }
    }

    @Override // tv.danmaku.bili.ui.favorites.fragment.FavoritesTopTabBaseFragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initUI();
        registerCallback();
        collectEvent();
        initFavTab();
    }

    private final void initFavTab() {
        SubTab subTab;
        int it;
        List<SubTab> subTabs = getSubTabs();
        if (subTabs != null && (subTab = (SubTab) CollectionsKt.getOrNull(subTabs, getDefaultTabIndex(getActivityVM().getDefaultTabId()))) != null && (it = subTab.getTabId()) != 100) {
            getActivityVM().sendAction(new FavoritesPageAction.ShowFavTab(it));
        }
    }

    private final void initUI() {
        View $this$initUI_u24lambda_u240_u245;
        View $this$updateLayoutParams$iv;
        Resources resources;
        View $this$initUI_u24lambda_u240_u244;
        Resources resources2;
        SubTab subTab;
        BiliAppFragmentCollectionTabPageBinding $this$initUI_u24lambda_u240 = getBinding();
        List<SubTab> subTabs = getSubTabs();
        if (subTabs == null || subTabs.isEmpty()) {
            FavoritesTopTabBaseFragment.showEmptyView$default(this, R.string.favorites_global_string_171, R.string.favorites_global_string_168, null, 4, null);
        } else {
            hideEmptyView();
        }
        ListExtentionsKt.visible($this$initUI_u24lambda_u240.rightButton);
        $this$initUI_u24lambda_u240.icon1.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTopTabFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FavoritesTopTabFragment.initUI$lambda$0$0(FavoritesTopTabFragment.this, view);
            }
        });
        $this$initUI_u24lambda_u240.icon2.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTopTabFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FavoritesTopTabFragment.initUI$lambda$0$1(FavoritesTopTabFragment.this, view);
            }
        });
        Context it = getContext();
        if (it != null) {
            getBinding().icon3.setImageDrawable(ContextCompat.getDrawable(it, FavoritesFolderUtilsKt.getLayoutIcon()));
        }
        $this$initUI_u24lambda_u240.icon3.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTopTabFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FavoritesTopTabFragment.initUI$lambda$0$3(FavoritesTopTabFragment.this, view);
            }
        });
        List<SubTab> subTabs2 = getSubTabs();
        if ((subTabs2 == null || (subTab = (SubTab) CollectionsKt.getOrNull(subTabs2, 0)) == null || subTab.getTabId() != 100) ? false : true) {
            List<SubTab> subTabs3 = getSubTabs();
            if ((subTabs3 != null ? subTabs3.size() : 0) > 1) {
                TabLayout.Tab tabAt = $this$initUI_u24lambda_u240.tabLayout.getTabAt(0);
                if (tabAt != null && ($this$initUI_u24lambda_u240_u244 = tabAt.getCustomView()) != null) {
                    View findViewById = $this$initUI_u24lambda_u240_u244.findViewById(tv.danmaku.bili.R.id.divider);
                    if (findViewById != null) {
                        ListExtentionsKt.visible(findViewById);
                    }
                    View $this$updateLayoutParams$iv2 = $this$initUI_u24lambda_u240_u244.findViewById(tv.danmaku.bili.R.id.tab_title);
                    if ($this$updateLayoutParams$iv2 != null) {
                        ViewGroup.LayoutParams layoutParams = $this$updateLayoutParams$iv2.getLayoutParams();
                        if (layoutParams == null) {
                            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        }
                        ViewGroup.LayoutParams params$iv = (ViewGroup.MarginLayoutParams) layoutParams;
                        ViewGroup.MarginLayoutParams $this$initUI_u24lambda_u240_u244_u240 = (ViewGroup.MarginLayoutParams) params$iv;
                        Context context = $this$initUI_u24lambda_u240_u244.getContext();
                        $this$initUI_u24lambda_u240_u244_u240.rightMargin = (context == null || (resources2 = context.getResources()) == null) ? ListExtentionsKt.toPx(8) : (int) resources2.getDimension(tv.danmaku.bili.R.dimen.fav_sub_tab_margin);
                        $this$updateLayoutParams$iv2.setLayoutParams(params$iv);
                    }
                }
                TabLayout.Tab tabAt2 = $this$initUI_u24lambda_u240.tabLayout.getTabAt(1);
                if (tabAt2 == null || ($this$initUI_u24lambda_u240_u245 = tabAt2.getCustomView()) == null || ($this$updateLayoutParams$iv = $this$initUI_u24lambda_u240_u245.findViewById(tv.danmaku.bili.R.id.tab_title)) == null) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams2 = $this$updateLayoutParams$iv.getLayoutParams();
                if (layoutParams2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                }
                ViewGroup.LayoutParams params$iv2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                ViewGroup.MarginLayoutParams $this$initUI_u24lambda_u240_u245_u240 = (ViewGroup.MarginLayoutParams) params$iv2;
                Context context2 = $this$initUI_u24lambda_u240_u245.getContext();
                $this$initUI_u24lambda_u240_u245_u240.leftMargin = (context2 == null || (resources = context2.getResources()) == null) ? ListExtentionsKt.toPx(8) : (int) resources.getDimension(tv.danmaku.bili.R.dimen.fav_sub_tab_margin);
                $this$updateLayoutParams$iv.setLayoutParams(params$iv2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initUI$lambda$0$0(FavoritesTopTabFragment this$0, View it) {
        this$0.doSearch(this$0.getSearchUrl());
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to(FavoritesConstsKt.BUTTON_NAME, "0");
        String currentPolarisActionId = PageViewTracker.getInstance().currentPolarisActionId();
        if (currentPolarisActionId == null) {
            currentPolarisActionId = "";
        }
        pairArr[1] = TuplesKt.to(FavoritesConstsKt.ACTION_ID, currentPolarisActionId);
        FavReportHelperKt.reportFavClick(FavoritesConstsKt.FAV_FIRST_BUTTON_CLICK, MapsKt.mapOf(pairArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initUI$lambda$0$1(FavoritesTopTabFragment this$0, View it) {
        if (this$0.getActivityVM().isAddIcon()) {
            Context requireContext = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            PlaySetEditorRouterUtilsKt.routeToCreatePage(requireContext, this$0.launcher, (int) FavRouterUtilsKt.REQ_CODE_CREATE_FOLDER);
            Pair[] pairArr = new Pair[2];
            pairArr[0] = TuplesKt.to(FavoritesConstsKt.BUTTON_NAME, "1");
            String currentPolarisActionId = PageViewTracker.getInstance().currentPolarisActionId();
            pairArr[1] = TuplesKt.to(FavoritesConstsKt.ACTION_ID, currentPolarisActionId != null ? currentPolarisActionId : "");
            FavReportHelperKt.reportFavClick(FavoritesConstsKt.FAV_FIRST_BUTTON_CLICK, MapsKt.mapOf(pairArr));
            return;
        }
        this$0.getActivityVM().sendAction(FavoritesPageAction.StartBatchManage.INSTANCE);
        Pair[] pairArr2 = new Pair[2];
        pairArr2[0] = TuplesKt.to(FavoritesConstsKt.BUTTON_NAME, "2");
        String currentPolarisActionId2 = PageViewTracker.getInstance().currentPolarisActionId();
        pairArr2[1] = TuplesKt.to(FavoritesConstsKt.ACTION_ID, currentPolarisActionId2 != null ? currentPolarisActionId2 : "");
        FavReportHelperKt.reportFavClick(FavoritesConstsKt.FAV_FIRST_BUTTON_CLICK, MapsKt.mapOf(pairArr2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initUI$lambda$0$3(FavoritesTopTabFragment this$0, View it) {
        if (FavoritesFolderUtilsKt.switchLayoutType()) {
            FavReportHelperKt.reportSwitchLayoutTypeClick();
            this$0.getActivityVM().sendAction(FavoritesPageAction.SwitchLayoutType.INSTANCE);
            TintImageView tintImageView = this$0.getBinding().icon3;
            Context context = this$0.getContext();
            tintImageView.setImageDrawable(context != null ? KtxKt.getAppCompatDrawable(context, FavoritesFolderUtilsKt.getLayoutIcon()) : null);
            this$0.getBinding().icon3.setImageTintList(com.bilibili.lib.theme.R.color.Graph_bold);
        }
    }

    private final void collectEvent() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new FavoritesTopTabFragment$collectEvent$1(this, null), 3, (Object) null);
    }

    private final void registerCallback() {
        getBinding().viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTopTabFragment$registerCallback$pageChangeCallback$1
            public void onPageSelected(int position) {
                SubTab subTab;
                List<SubTab> subTabs = FavoritesTopTabFragment.this.getSubTabs();
                if (subTabs != null && (subTab = (SubTab) CollectionsKt.getOrNull(subTabs, position)) != null) {
                    int it = subTab.getTabId();
                    FavoritesTopTabFragment favoritesTopTabFragment = FavoritesTopTabFragment.this;
                    if (it != 100) {
                        favoritesTopTabFragment.getActivityVM().sendAction(new FavoritesPageAction.ShowFavTab(it));
                    }
                }
            }
        });
    }

    private final void doSearch(String url) {
        AdRouters.routeTo$default(AdRouters.INSTANCE, "bilibili://music/search2", (Context) null, 2, (Object) null);
    }

    @Override // tv.danmaku.bili.ui.favorites.fragment.FavoritesTopTabBaseFragment
    public void onRetryClick() {
        WatchLaterRouterKt.routerTo$default(FavoritesConstsKt.ROUTE_RECOMMEND, getContext(), (Map) null, 4, (Object) null);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // tv.danmaku.bili.ui.favorites.fragment.FavoritesTopTabBaseFragment
    public int getDefaultTabIndex(int defaultTabId) {
        int tabsForNoDefault = defaultTabId == getDEFAULT_NO_TAB_ID() ? 101 : defaultTabId;
        int result = findOrNOID(tabsForNoDefault);
        if (result == getDEFAULT_NO_TAB_ID()) {
            result = findOrNOID(102);
        }
        if (result == getDEFAULT_NO_TAB_ID()) {
            result = findOrNOID(103);
        }
        BLog.d(TAG, "getDefaultTabIndex " + result);
        if (result < 0) {
            return 0;
        }
        return result;
    }

    private final int findOrNOID(int tabsForNoDefault) {
        List $this$indexOfFirst$iv = getSubTabs();
        if ($this$indexOfFirst$iv == null) {
            return getDEFAULT_NO_TAB_ID();
        }
        int index$iv = 0;
        for (Object item$iv : $this$indexOfFirst$iv) {
            SubTab it = (SubTab) item$iv;
            if (it.getTabId() == tabsForNoDefault) {
                return index$iv;
            }
            index$iv++;
        }
        return -1;
    }

    /* compiled from: FavoritesTopTabFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/favorites/fragment/FavoritesTopTabFragment$Companion;", "", "<init>", "()V", "TAG", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}