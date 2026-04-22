package tv.danmaku.bili.ui.favorites.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.bilibili.adcommon.utils.ext.AdExtensions;
import com.bilibili.app.comm.list.widget.statement.ErrorState;
import com.bilibili.app.comm.list.widget.statement.PlaceHolderState;
import com.bilibili.app.comm.list.widget.statement.StatePageKt;
import com.bilibili.app.comm.list.widget.text.MessageString;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.base.viewbinding.ViewBindingProperty;
import com.bilibili.base.viewbinding.full.CreateMethod;
import com.bilibili.base.viewbinding.full.ReflectionFragmentViewBindings;
import com.bilibili.base.viewbinding.internal.UtilsKt;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.lib.gson.GsonUtils;
import com.bilibili.lib.ui.BaseFragment;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.magicasakura.widgets.TintTextView;
import com.bilibili.pvtracker.PageViewTracker;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.gson.reflect.TypeToken;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.databinding.BiliAppFragmentCollectionTabPageBinding;
import tv.danmaku.bili.ui.favorite.BaseFavoritesFragment;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.ui.favorites.model.SubTab;
import tv.danmaku.bili.ui.favorites.util.FavReportHelperKt;
import tv.danmaku.bili.ui.favorites.util.FavoritesUtilsKt;
import tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel;

/* compiled from: FavoritesTopTabBaseFragment.kt */
@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b*\u00012\b\u0017\u0018\u0000 N2\u00020\u0001:\u0001NB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u0010\u00108\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0016J$\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010?2\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u001a\u0010@\u001a\u0002052\u0006\u0010A\u001a\u00020;2\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u0010B\u001a\u000205H\u0002J$\u0010C\u001a\u0002052\b\b\u0001\u0010D\u001a\u00020\u000b2\b\b\u0001\u0010E\u001a\u00020\u000b2\b\b\u0002\u0010F\u001a\u00020GJ\u0006\u0010H\u001a\u000205J\b\u0010I\u001a\u000205H\u0016J\b\u0010J\u001a\u000205H\u0016J\b\u0010K\u001a\u000205H\u0002J\u0014\u0010L\u001a\u000205*\u00020;2\u0006\u0010M\u001a\u00020*H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020 X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\u000e\u0010(\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0010\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103¨\u0006O"}, d2 = {"Ltv/danmaku/bili/ui/favorites/fragment/FavoritesTopTabBaseFragment;", "Lcom/bilibili/lib/ui/BaseFragment;", "<init>", "()V", "binding", "Ltv/danmaku/bili/databinding/BiliAppFragmentCollectionTabPageBinding;", "getBinding", "()Ltv/danmaku/bili/databinding/BiliAppFragmentCollectionTabPageBinding;", "binding$delegate", "Lcom/bilibili/base/viewbinding/ViewBindingProperty;", "DEFAULT_NO_TAB_ID", "", "getDEFAULT_NO_TAB_ID", "()I", "activityVM", "Ltv/danmaku/bili/ui/favorites/viewmodel/FavoritesActivityViewModel;", "getActivityVM", "()Ltv/danmaku/bili/ui/favorites/viewmodel/FavoritesActivityViewModel;", "activityVM$delegate", "Lkotlin/Lazy;", "subTabs", "", "Ltv/danmaku/bili/ui/favorites/model/SubTab;", "getSubTabs", "()Ljava/util/List;", "setSubTabs", "(Ljava/util/List;)V", "tabId", "getTabId", "setTabId", "(I)V", "tabName", "", "getTabName", "()Ljava/lang/String;", "setTabName", "(Ljava/lang/String;)V", "searchUrl", "getSearchUrl", "setSearchUrl", "defaultTabIndex", "hasRedDot", "", "curSelectedIndex", "firstTimePageSelected", "getFirstTimePageSelected", "()Z", "setFirstTimePageSelected", "(Z)V", "pageChangeCallback", "tv/danmaku/bili/ui/favorites/fragment/FavoritesTopTabBaseFragment$pageChangeCallback$1", "Ltv/danmaku/bili/ui/favorites/fragment/FavoritesTopTabBaseFragment$pageChangeCallback$1;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getDefaultTabIndex", "defaultTabId", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initUI", "showEmptyView", "emptyMessageId", "retryMessageId", "placeState", "Lcom/bilibili/app/comm/list/widget/statement/PlaceHolderState;", "hideEmptyView", "onRetryClick", "onResume", "reportTabShow", "setTabSelected", "selected", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public class FavoritesTopTabBaseFragment extends BaseFragment {
    public static final String TAG = "FavoritesTopTabBaseFragment";
    private final int DEFAULT_NO_TAB_ID;
    private final Lazy activityVM$delegate;
    private final ViewBindingProperty binding$delegate;
    private int curSelectedIndex;
    private int defaultTabIndex;
    private boolean firstTimePageSelected;
    private boolean hasRedDot;
    private final FavoritesTopTabBaseFragment$pageChangeCallback$1 pageChangeCallback;
    private String searchUrl;
    private List<SubTab> subTabs;
    private int tabId;
    private String tabName;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(FavoritesTopTabBaseFragment.class, "binding", "getBinding()Ltv/danmaku/bili/databinding/BiliAppFragmentCollectionTabPageBinding;", 0))};
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX WARN: Type inference failed for: r0v8, types: [tv.danmaku.bili.ui.favorites.fragment.FavoritesTopTabBaseFragment$pageChangeCallback$1] */
    public FavoritesTopTabBaseFragment() {
        Fragment $this$viewBinding_u24default$iv = (Fragment) this;
        CreateMethod createMethod$iv = CreateMethod.INFLATE;
        Function1 onViewDestroyed$iv = UtilsKt.emptyVbCallback();
        this.binding$delegate = ReflectionFragmentViewBindings.viewBindingFragment($this$viewBinding_u24default$iv, BiliAppFragmentCollectionTabPageBinding.class, createMethod$iv, onViewDestroyed$iv);
        this.DEFAULT_NO_TAB_ID = -1;
        final Fragment $this$activityViewModels_u24default$iv = (Fragment) this;
        this.activityVM$delegate = FragmentViewModelLazyKt.createViewModelLazy($this$activityViewModels_u24default$iv, Reflection.getOrCreateKotlinClass(FavoritesActivityViewModel.class), new Function0<ViewModelStore>() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTopTabBaseFragment$special$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelStore m1659invoke() {
                return $this$activityViewModels_u24default$iv.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTopTabBaseFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final CreationExtras m1660invoke() {
                CreationExtras creationExtras;
                Function0 function0 = r2;
                return (function0 == null || (creationExtras = (CreationExtras) function0.invoke()) == null) ? $this$activityViewModels_u24default$iv.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTopTabBaseFragment$special$$inlined$activityViewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelProvider.Factory m1661invoke() {
                return $this$activityViewModels_u24default$iv.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
        this.tabName = "";
        this.searchUrl = "";
        this.firstTimePageSelected = true;
        this.pageChangeCallback = new ViewPager2.OnPageChangeCallback() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTopTabBaseFragment$pageChangeCallback$1
            /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
            /* JADX WARN: Removed duplicated region for block: B:11:0x005c  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onPageSelected(int position) {
                int tabId;
                int i;
                FavoritesTopTabBaseFragment.this.curSelectedIndex = position;
                List<SubTab> subTabs = FavoritesTopTabBaseFragment.this.getSubTabs();
                if (subTabs != null) {
                    i = FavoritesTopTabBaseFragment.this.curSelectedIndex;
                    SubTab subTab = (SubTab) CollectionsKt.getOrNull(subTabs, i);
                    if (subTab != null) {
                        tabId = subTab.getTabId();
                        BLog.d(FavoritesTopTabBaseFragment.TAG, "onPageSelected:" + position + " tabId:" + tabId);
                        if (FavoritesTopTabBaseFragment.this.getFirstTimePageSelected()) {
                            FavoritesTopTabBaseFragment.this.getActivityVM().setCurDefaultTabId(tabId);
                            FavoritesTopTabBaseFragment.this.reportTabShow();
                            return;
                        }
                        FavoritesTopTabBaseFragment.this.setFirstTimePageSelected(false);
                        return;
                    }
                }
                tabId = 0;
                BLog.d(FavoritesTopTabBaseFragment.TAG, "onPageSelected:" + position + " tabId:" + tabId);
                if (FavoritesTopTabBaseFragment.this.getFirstTimePageSelected()) {
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BiliAppFragmentCollectionTabPageBinding getBinding() {
        return (BiliAppFragmentCollectionTabPageBinding) this.binding$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final int getDEFAULT_NO_TAB_ID() {
        return this.DEFAULT_NO_TAB_ID;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final FavoritesActivityViewModel getActivityVM() {
        return (FavoritesActivityViewModel) this.activityVM$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final List<SubTab> getSubTabs() {
        return this.subTabs;
    }

    protected final void setSubTabs(List<SubTab> list) {
        this.subTabs = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getTabId() {
        return this.tabId;
    }

    protected final void setTabId(int i) {
        this.tabId = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String getTabName() {
        return this.tabName;
    }

    protected final void setTabName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tabName = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String getSearchUrl() {
        return this.searchUrl;
    }

    protected final void setSearchUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.searchUrl = str;
    }

    public final boolean getFirstTimePageSelected() {
        return this.firstTimePageSelected;
    }

    public final void setFirstTimePageSelected(boolean z) {
        this.firstTimePageSelected = z;
    }

    /* JADX WARN: Type inference failed for: r5v9, types: [tv.danmaku.bili.ui.favorites.fragment.FavoritesTopTabBaseFragment$onCreate$1$1$1] */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle $this$onCreate_u24lambda_u240 = getArguments();
        if ($this$onCreate_u24lambda_u240 != null) {
            try {
                String subTabsString = $this$onCreate_u24lambda_u240.getString(FavoritesConstsKt.KEY_SUB_TABS);
                if (subTabsString != null) {
                    this.subTabs = (List) GsonUtils.parse(subTabsString, new TypeToken<List<? extends SubTab>>() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTopTabBaseFragment$onCreate$1$1$1
                    }.getType());
                }
                String it = $this$onCreate_u24lambda_u240.getString(FavoritesConstsKt.KEY_FAV_TAB_ID);
                if (it != null) {
                    this.tabId = AdExtensions.toIntOrDefault(it, 0);
                }
                String it2 = $this$onCreate_u24lambda_u240.getString("tab_name");
                if (it2 != null) {
                    this.tabName = it2;
                }
                String it3 = $this$onCreate_u24lambda_u240.getString(FavoritesConstsKt.KEY_SEARCH_URL);
                if (it3 != null) {
                    this.searchUrl = it3;
                }
                String it4 = $this$onCreate_u24lambda_u240.getString(FavoritesConstsKt.KEY_RED_DOT);
                if (it4 != null) {
                    this.hasRedDot = Boolean.parseBoolean(it4);
                }
                String id = $this$onCreate_u24lambda_u240.getString(FavoritesConstsKt.KEY_DEFAULT_TAB_ID);
                if (id != null) {
                    int defaultTabId = AdExtensions.toIntOrDefault(id, this.DEFAULT_NO_TAB_ID);
                    getActivityVM().setDefaultTabId(defaultTabId);
                    this.defaultTabIndex = getDefaultTabIndex(defaultTabId);
                    this.curSelectedIndex = this.defaultTabIndex;
                    return;
                }
                this.defaultTabIndex = getDefaultTabIndex(this.DEFAULT_NO_TAB_ID);
                this.curSelectedIndex = this.defaultTabIndex;
            } catch (Exception e) {
                BLog.e(TAG, "subTabsJsonString parse error:" + $this$onCreate_u24lambda_u240.getString(FavoritesConstsKt.KEY_SUB_TABS));
            }
        }
    }

    public int getDefaultTabIndex(int defaultTabId) {
        int index$iv;
        List $this$indexOfFirst$iv = this.subTabs;
        if ($this$indexOfFirst$iv == null) {
            index$iv = 0;
        } else {
            index$iv = 0;
            Iterator<SubTab> it = $this$indexOfFirst$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    Object item$iv = it.next();
                    SubTab it2 = (SubTab) item$iv;
                    if (it2.getTabId() == defaultTabId) {
                        break;
                    }
                    index$iv++;
                } else {
                    index$iv = -1;
                    break;
                }
            }
        }
        int result = index$iv;
        if (result < 0) {
            return 0;
        }
        return result;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initUI();
    }

    private final void initUI() {
        View customView;
        BiliAppFragmentCollectionTabPageBinding $this$initUI_u24lambda_u240 = getBinding();
        List<SubTab> list = this.subTabs;
        int size = list != null ? list.size() : 1;
        $this$initUI_u24lambda_u240.viewPager.setOffscreenPageLimit(size > 0 ? size : 1);
        $this$initUI_u24lambda_u240.viewPager.setUserInputEnabled(false);
        $this$initUI_u24lambda_u240.viewPager.setAdapter(new FragmentStateAdapter() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTopTabBaseFragment$initUI$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super((Fragment) FavoritesTopTabBaseFragment.this);
            }

            public int getItemCount() {
                List<SubTab> subTabs = FavoritesTopTabBaseFragment.this.getSubTabs();
                if (subTabs != null) {
                    return subTabs.size();
                }
                return 0;
            }

            public Fragment createFragment(int position) {
                SubTab subTab;
                String tabName;
                SubTab subTab2;
                SubTab subTab3;
                Context activity = FavoritesTopTabBaseFragment.this.getActivity();
                if (activity != null) {
                    Context context = activity;
                    List<SubTab> subTabs = FavoritesTopTabBaseFragment.this.getSubTabs();
                    String str = "";
                    String str2 = (subTabs == null || (subTab3 = (SubTab) CollectionsKt.getOrNull(subTabs, position)) == null || (str2 = subTab3.getUri()) == null) ? "" : "";
                    Bundle $this$createFragment_u24lambda_u240 = new Bundle();
                    FavoritesTopTabBaseFragment favoritesTopTabBaseFragment = FavoritesTopTabBaseFragment.this;
                    List<SubTab> subTabs2 = favoritesTopTabBaseFragment.getSubTabs();
                    $this$createFragment_u24lambda_u240.putInt(FavoritesConstsKt.KEY_FAV_TAB_ID, (subTabs2 == null || (subTab2 = (SubTab) CollectionsKt.getOrNull(subTabs2, position)) == null) ? 0 : subTab2.getTabId());
                    $this$createFragment_u24lambda_u240.putString("tab_name", favoritesTopTabBaseFragment.getTabName());
                    List<SubTab> subTabs3 = favoritesTopTabBaseFragment.getSubTabs();
                    if (subTabs3 != null && (subTab = (SubTab) CollectionsKt.getOrNull(subTabs3, position)) != null && (tabName = subTab.getTabName()) != null) {
                        str = tabName;
                    }
                    $this$createFragment_u24lambda_u240.putString("second_tab_name", str);
                    Unit unit = Unit.INSTANCE;
                    Fragment findFragmentByUrl = ListExtentionsKt.findFragmentByUrl(context, str2, $this$createFragment_u24lambda_u240);
                    if (findFragmentByUrl != null) {
                        return findFragmentByUrl;
                    }
                }
                return new Fragment();
            }
        });
        $this$initUI_u24lambda_u240.viewPager.setCurrentItem(this.defaultTabIndex);
        $this$initUI_u24lambda_u240.viewPager.registerOnPageChangeCallback(this.pageChangeCallback);
        new TabLayoutMediator($this$initUI_u24lambda_u240.tabLayout, $this$initUI_u24lambda_u240.viewPager, false, false, new TabLayoutMediator.TabConfigurationStrategy() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTopTabBaseFragment$$ExternalSyntheticLambda3
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                FavoritesTopTabBaseFragment.initUI$lambda$0$0(FavoritesTopTabBaseFragment.this, tab, i);
            }
        }).attach();
        TabLayout.Tab $this$initUI_u24lambda_u240_u241 = $this$initUI_u24lambda_u240.tabLayout.getTabAt(this.defaultTabIndex);
        if ($this$initUI_u24lambda_u240_u241 != null && (customView = $this$initUI_u24lambda_u240_u241.getCustomView()) != null) {
            setTabSelected(customView, true);
        }
        $this$initUI_u24lambda_u240.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTopTabBaseFragment$initUI$1$4
            public void onTabSelected(TabLayout.Tab tab) {
                View customView2;
                if (tab != null && (customView2 = tab.getCustomView()) != null) {
                    FavoritesTopTabBaseFragment.this.setTabSelected(customView2, true);
                }
            }

            public void onTabUnselected(TabLayout.Tab tab) {
                View customView2;
                if (tab != null && (customView2 = tab.getCustomView()) != null) {
                    FavoritesTopTabBaseFragment.this.setTabSelected(customView2, false);
                }
            }

            public void onTabReselected(TabLayout.Tab tab) {
                View customView2;
                if (tab != null && (customView2 = tab.getCustomView()) != null) {
                    FavoritesTopTabBaseFragment.this.setTabSelected(customView2, true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initUI$lambda$0$0(FavoritesTopTabBaseFragment this$0, TabLayout.Tab tab, int pos) {
        TintTextView findViewById;
        SubTab subTab;
        Intrinsics.checkNotNullParameter(tab, BaseFavoritesFragment.TAB);
        View customTab = LayoutInflater.from(this$0.getContext()).inflate(R.layout.bili_app_layout_collection_tab_item, (ViewGroup) null);
        tab.setCustomView(customTab);
        View customView = tab.getCustomView();
        if (customView != null && (findViewById = customView.findViewById(R.id.tab_title)) != null) {
            List<SubTab> list = this$0.subTabs;
            findViewById.setText((list == null || (subTab = (SubTab) CollectionsKt.getOrNull(list, pos)) == null || (r2 = subTab.getTabName()) == null) ? "" : "");
        }
    }

    public static /* synthetic */ void showEmptyView$default(FavoritesTopTabBaseFragment favoritesTopTabBaseFragment, int i, int i2, PlaceHolderState placeHolderState, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showEmptyView");
        }
        if ((i3 & 4) != 0) {
            placeHolderState = (PlaceHolderState) PlaceHolderState.ErrorHolder.INSTANCE;
        }
        favoritesTopTabBaseFragment.showEmptyView(i, i2, placeHolderState);
    }

    public final void showEmptyView(int emptyMessageId, int retryMessageId, final PlaceHolderState placeState) {
        Intrinsics.checkNotNullParameter(placeState, "placeState");
        final ErrorState state = new ErrorState.Empty(0, (MessageString) null, new MessageString.ResourceString(emptyMessageId), new MessageString.ResourceString(retryMessageId), true, 3, (DefaultConstructorMarker) null);
        ListExtentionsKt.visible(getBinding().errorView);
        ListExtentionsKt.gone(getBinding().topContainer);
        getBinding().errorView.setContent(ComposableLambdaKt.composableLambdaInstance(-259414753, true, new Function2() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTopTabBaseFragment$$ExternalSyntheticLambda2
            public final Object invoke(Object obj, Object obj2) {
                Unit showEmptyView$lambda$0;
                showEmptyView$lambda$0 = FavoritesTopTabBaseFragment.showEmptyView$lambda$0(placeState, state, this, (Composer) obj, ((Integer) obj2).intValue());
                return showEmptyView$lambda$0;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showEmptyView$lambda$0(final PlaceHolderState $placeState, final ErrorState $state, final FavoritesTopTabBaseFragment this$0, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C223@8940L147,223@8930L157:FavoritesTopTabBaseFragment.kt#atjan2");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-259414753, $changed, -1, "tv.danmaku.bili.ui.favorites.fragment.FavoritesTopTabBaseFragment.showEmptyView.<anonymous> (FavoritesTopTabBaseFragment.kt:223)");
            }
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(196723927, true, new Function2() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTopTabBaseFragment$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit showEmptyView$lambda$0$0;
                    showEmptyView$lambda$0$0 = FavoritesTopTabBaseFragment.showEmptyView$lambda$0$0($placeState, $state, this$0, (Composer) obj, ((Integer) obj2).intValue());
                    return showEmptyView$lambda$0$0;
                }
            }, $composer, 54), $composer, (int) BR.negativeBtnVisible, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showEmptyView$lambda$0$0(PlaceHolderState $placeState, ErrorState $state, final FavoritesTopTabBaseFragment this$0, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C224@9019L54,224@8958L115:FavoritesTopTabBaseFragment.kt#atjan2");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(196723927, $changed, -1, "tv.danmaku.bili.ui.favorites.fragment.FavoritesTopTabBaseFragment.showEmptyView.<anonymous>.<anonymous> (FavoritesTopTabBaseFragment.kt:224)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 73135405, "CC(remember):FavoritesTopTabBaseFragment.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance(this$0);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTopTabBaseFragment$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit showEmptyView$lambda$0$0$0$0;
                        showEmptyView$lambda$0$0$0$0 = FavoritesTopTabBaseFragment.showEmptyView$lambda$0$0$0$0(FavoritesTopTabBaseFragment.this);
                        return showEmptyView$lambda$0$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            StatePageKt.StatePage($placeState, $state, (Function0) it$iv, $composer, ErrorState.Empty.$stable << 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showEmptyView$lambda$0$0$0$0(FavoritesTopTabBaseFragment this$0) {
        this$0.onRetryClick();
        return Unit.INSTANCE;
    }

    public final void hideEmptyView() {
        ListExtentionsKt.gone(getBinding().errorView);
        ListExtentionsKt.visible(getBinding().topContainer);
    }

    public void onRetryClick() {
    }

    public void onResume() {
        SubTab subTab;
        super.onResume();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new FavoritesTopTabBaseFragment$onResume$1(this, null), 3, (Object) null);
        reportTabShow();
        List<SubTab> list = this.subTabs;
        int tabId = (list == null || (subTab = (SubTab) CollectionsKt.getOrNull(list, this.curSelectedIndex)) == null) ? 0 : subTab.getTabId();
        BLog.d(TAG, "onResume cur index:" + this.curSelectedIndex + " tabId=" + tabId);
        getActivityVM().setCurDefaultTabId(tabId);
        if (this.curSelectedIndex != 0) {
            this.firstTimePageSelected = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportTabShow() {
        SubTab subTab;
        SubTab subTab2;
        BLog.i(TAG, "cur index:" + this.curSelectedIndex);
        Pair[] pairArr = new Pair[5];
        pairArr[0] = TuplesKt.to("tab_name", this.tabName);
        List<SubTab> list = this.subTabs;
        pairArr[1] = TuplesKt.to("second_tab_name", (list == null || (subTab2 = (SubTab) CollectionsKt.getOrNull(list, this.curSelectedIndex)) == null || (r1 = subTab2.getTabName()) == null) ? "" : "");
        List<SubTab> list2 = this.subTabs;
        pairArr[2] = TuplesKt.to(FavoritesConstsKt.IS_ACQUIESCE, (list2 == null || (subTab = (SubTab) CollectionsKt.getOrNull(list2, this.curSelectedIndex)) == null || (r1 = FavoritesUtilsKt.toIsAcquiesce(subTab.getTabId(), getActivityVM().getDefaultTabId())) == null) ? "" : "");
        pairArr[3] = TuplesKt.to("from_spmid", getActivityVM().getFromSpmid());
        String currentPolarisActionId = PageViewTracker.getInstance().currentPolarisActionId();
        pairArr[4] = TuplesKt.to(FavoritesConstsKt.ACTION_ID, currentPolarisActionId != null ? currentPolarisActionId : "");
        FavReportHelperKt.reportFavShow(FavoritesConstsKt.FAV_TAB_SHOW, MapsKt.mapOf(pairArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTabSelected(View $this$setTabSelected, boolean selected) {
        TextView $this$setTabSelected_u24lambda_u240 = (TextView) $this$setTabSelected.findViewById(R.id.tab_title);
        if ($this$setTabSelected_u24lambda_u240 != null) {
            if (selected) {
                $this$setTabSelected_u24lambda_u240.setTextColor(ThemeUtils.getColorById($this$setTabSelected_u24lambda_u240.getContext(), com.bilibili.lib.theme.R.color.Brand_pink));
                $this$setTabSelected_u24lambda_u240.setTypeface(null, 1);
                $this$setTabSelected_u24lambda_u240.setBackgroundResource(R.drawable.bg_collection_tab_shape);
                return;
            }
            $this$setTabSelected_u24lambda_u240.setTextColor(ThemeUtils.getColorById($this$setTabSelected_u24lambda_u240.getContext(), com.bilibili.lib.theme.R.color.Text2));
            $this$setTabSelected_u24lambda_u240.setTypeface(null, 0);
            $this$setTabSelected_u24lambda_u240.setBackgroundResource(17170445);
        }
    }

    /* compiled from: FavoritesTopTabBaseFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/favorites/fragment/FavoritesTopTabBaseFragment$Companion;", "", "<init>", "()V", "TAG", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}