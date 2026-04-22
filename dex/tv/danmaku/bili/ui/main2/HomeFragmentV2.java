package tv.danmaku.bili.ui.main2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModelProvider;
import bolts.CancellationTokenSource;
import bolts.Task;
import com.alibaba.fastjson.JSON;
import com.bilibili.app.comm.list.common.api.IDefaultKeywordResult;
import com.bilibili.app.comm.list.common.api.IDefaultKeywordService;
import com.bilibili.app.comm.list.common.campus.HomeCampusSwitchKt;
import com.bilibili.app.comm.list.widget.backflow.HomeCampusGuidanceWrapper;
import com.bilibili.app.comm.list.widget.backflow.HomeCampusGuidanceWrapperKt;
import com.bilibili.app.comm.list.widget.backflow.HomeTabQueueManager;
import com.bilibili.app.comm.list.widget.menu.ListMenuWindowKt;
import com.bilibili.base.BiliContext;
import com.bilibili.bus.Violet;
import com.bilibili.commons.StringUtils;
import com.bilibili.homepage.HomeTabService;
import com.bilibili.homepage.TabIconInfo;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.subscribe.PassportObserver;
import com.bilibili.lib.accounts.subscribe.Topic;
import com.bilibili.lib.arch.lifecycle.Resource;
import com.bilibili.lib.arch.lifecycle.Status;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteInterceptor;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.RouteResponse;
import com.bilibili.lib.btrace.BTrace;
import com.bilibili.lib.homepage.INewIntentCompat;
import com.bilibili.lib.homepage.IWindowFocusChanged;
import com.bilibili.lib.homepage.home.model.ToolbarEvent;
import com.bilibili.lib.homepage.splash.BaseMainViewModel;
import com.bilibili.lib.homepage.splash.OffsetAndForceState;
import com.bilibili.lib.homepage.splash.SplashViewModel;
import com.bilibili.lib.homepage.startdust.IAnchorable;
import com.bilibili.lib.homepage.startdust.menu.BaseBadgeOptionMenuItem;
import com.bilibili.lib.homepage.startdust.menu.DynamicMenuItem;
import com.bilibili.lib.homepage.startdust.menu.HomePageMenusVisibilityKt;
import com.bilibili.lib.homepage.startdust.menu.IDynamicMenuItemServer;
import com.bilibili.lib.homepage.startdust.menu.IOptionMenuItem;
import com.bilibili.lib.homepage.startdust.menu.IOptionMenuProvider;
import com.bilibili.lib.homepage.startdust.secondary.BasePrimaryMultiPageFragment;
import com.bilibili.lib.homepage.startdust.secondary.ISecondaryPageExtraInfoListener;
import com.bilibili.lib.homepage.startdust.secondary.SecondaryPageAdapter;
import com.bilibili.lib.homepage.startdust.secondary.SecondaryPageBubble;
import com.bilibili.lib.homepage.startdust.secondary.SecondaryPageClickAnim;
import com.bilibili.lib.homepage.startdust.secondary.SecondaryPageExtension;
import com.bilibili.lib.homepage.startdust.secondary.SecondaryPageExtraInfo;
import com.bilibili.lib.homepage.startdust.secondary.SecondaryPageIconInfo;
import com.bilibili.lib.homepage.startdust.secondary.SecondaryPageWatcher;
import com.bilibili.lib.homepage.util.AnimateResourceManager;
import com.bilibili.lib.homepage.util.BottomTabSelectedHelper;
import com.bilibili.lib.homepage.util.UriUtils;
import com.bilibili.lib.homepage.widget.HomePageTabContainer;
import com.bilibili.lib.homepage.widget.HomePagerSlidingTabStrip;
import com.bilibili.lib.homepage.widget.TabHost;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.theme.R;
import com.bilibili.lib.ui.garb.Garb;
import com.bilibili.lib.ui.garb.GarbManager;
import com.bilibili.lib.ui.garb.GarbWatcher;
import com.bilibili.lib.ui.mixin.Flag;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.recommendmode.RecommendMode;
import com.bilibili.search.SplashSearchService;
import com.bilibili.teenagersmode.TeenagersMode;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.OnlineParamsHelper;
import tv.danmaku.bili.router.MainRouteUris;
import tv.danmaku.bili.ui.DisplayUtils;
import tv.danmaku.bili.ui.main.event.EventEntranceHelper;
import tv.danmaku.bili.ui.main.event.model.EventEntranceModel;
import tv.danmaku.bili.ui.main.opdialog.OpBizDialogHelper;
import tv.danmaku.bili.ui.main2.HomeFragmentV2;
import tv.danmaku.bili.ui.main2.api.TabDataUpdateEvent;
import tv.danmaku.bili.ui.main2.basic.IMainFragmentHost;
import tv.danmaku.bili.ui.main2.basic.dialog.publish.PublishBubbleDialogKt;
import tv.danmaku.bili.ui.main2.basic.dialog.top.TopTabBubbleDialogWrapperKt;
import tv.danmaku.bili.ui.main2.basic.dialog.top.TopTabClickAnimKt;
import tv.danmaku.bili.ui.main2.event.EventMenuAction;
import tv.danmaku.bili.ui.main2.event.EventMenuItem;
import tv.danmaku.bili.ui.main2.reporter.NavigationReporter;
import tv.danmaku.bili.ui.main2.resource.HomeTabReporterKt;
import tv.danmaku.bili.ui.main2.resource.HomeTabServiceImpl;
import tv.danmaku.bili.ui.main2.resource.HomeTabServiceImplKt;
import tv.danmaku.bili.ui.main2.resource.MainResourceManager;
import tv.danmaku.bili.ui.main2.resource.MenuItem;
import tv.danmaku.bili.ui.main2.resource.MoreCategoryItem;
import tv.danmaku.bili.ui.main2.resource.SecondaryPage;
import tv.danmaku.bili.ui.main2.vm.actions.UpdateTabSelectedAction;
import tv.danmaku.bili.ui.main2.widget.AutoRefreshQueue;

public class HomeFragmentV2 extends BasePrimaryMultiPageFragment implements INewIntentCompat, GarbWatcher.Observer, SecondaryPageWatcher.Observer, IWindowFocusChanged {
    private static final int DEFAULT_PAGE_POSITION = 1;
    private static final int SEARCH_DEFAULT_FROM_MAIN = 1;
    private static final String TAG = "home.main.home";
    private static List<IOptionMenuItem> mMenus;
    private ValueAnimator mAnimator;
    private BaseMainViewModel mBaseMainViewModel;
    private ValueAnimator mBgImageAnimator;
    private View mCategoryView;
    private SecondaryPageExtraInfo mCurPageExtraInfo;
    private BasePrimaryMultiPageFragment.PageInfo mCurPageInfo;
    private Drawable mCurrentDrawable;
    private int mCurrentTabBgEndColor;
    private int mCurrentTabBgStartColor;
    private FrameLayout mFlCategory;
    private FrameLayout mFlSearch;
    private GradientDrawable mGradientDrawable;
    private BiliImageView mIvCategory;
    private BiliImageView mIvSearch;
    private TabHost mTabHost;
    private HomePageTabContainer mTabShaderContainer;
    private CancellationTokenSource mToken;
    private boolean mDefaultWordLoading = false;
    private List<SecondaryPageExtension> mExtensionList = new ArrayList();
    private int[] mTabBgColors = new int[2];
    private Map<String, BitmapDrawable> drawableCache = new HashMap();
    private int mDefSelectedPage = 1;
    IDefaultKeywordService defaultKeywordService = (IDefaultKeywordService) BLRouter.INSTANCE.getServices(IDefaultKeywordService.class).get("IDefaultKeywordService");
    private boolean isResumed = false;
    private boolean isFragmentHide = false;
    private boolean isSplashVisible = true;
    private boolean isAppBarExpanded = true;
    private boolean hasZeroCard = false;
    private final PassportObserver passportObserver = new PassportObserver() { // from class: tv.danmaku.bili.ui.main2.HomeFragmentV2$$ExternalSyntheticLambda13
        public final void onChange(Topic topic) {
            HomeFragmentV2.this.m1914lambda$new$0$tvdanmakubiliuimain2HomeFragmentV2(topic);
        }
    };
    private final DefaultKeywordObserver defaultKeywordObserver = new DefaultKeywordObserver();
    private final HomeFragOperator mHomeFragOperator = new HomeFragOperator() { // from class: tv.danmaku.bili.ui.main2.HomeFragmentV2.1
        @Override // tv.danmaku.bili.ui.main2.HomeFragOperator
        public void forceUpdateHomeTab() {
            HomeFragmentV2.this.forceUpdateHomeTabs();
        }

        @Override // tv.danmaku.bili.ui.main2.HomeFragOperator
        public void updateSearchWord() {
            BLog.i(HomeFragmentV2.TAG, "updateSearchWord");
            HomeFragmentV2.this.updateDefaultSearchWord(true, false);
        }
    };
    private final SplashSearchService searchService = (SplashSearchService) BLRouter.INSTANCE.get(SplashSearchService.class, "SPLASH_SEARCH_SERVICE");
    private SplashViewModel splashViewModel = null;
    private final int SEARCH_AREA_MAX_OFFSET = DisplayUtils.dp2Px(38);
    private final int SEARCH_ICON_IMG_SIZE = DisplayUtils.dp2Px(22);
    private final int SHADER_SIZE = DisplayUtils.dp2Px(26);
    private final int TAB_RIGHT_MARGIN = DisplayUtils.dp2Px(39);
    private boolean hasReport = false;
    private float lastPercent = 0.0f;
    IDefaultKeywordResult mSearchDefaultWord = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$tv-danmaku-bili-ui-main2-HomeFragmentV2  reason: not valid java name */
    public /* synthetic */ void m1914lambda$new$0$tvdanmakubiliuimain2HomeFragmentV2(Topic topic) {
        if ((topic == Topic.SIGN_IN || topic == Topic.SIGN_OUT) && this.defaultKeywordService != null) {
            this.defaultKeywordService.switchLogin();
        }
    }

    protected List<BasePrimaryMultiPageFragment.PageInfo> buildPages() {
        TabIconInfo iconInfo;
        Violet.INSTANCE.ofChannel(TabDataUpdateEvent.class).observe(this, new Observer() { // from class: tv.danmaku.bili.ui.main2.HomeFragmentV2$$ExternalSyntheticLambda14
            public final void onChanged(Object obj) {
                HomeFragmentV2.this.updateTabLayout((TabDataUpdateEvent) obj);
            }
        });
        List<SecondaryPage> srcPages = MainResourceManager.getInstance().getHomeTabPages();
        List<BasePrimaryMultiPageFragment.PageInfo> result = getResult(srcPages);
        if (result.isEmpty()) {
            List<SecondaryPage> defaultSecondPages = MainResourceManager.getInstance().getDefaultHomeTabPages();
            result = getResult(defaultSecondPages);
        }
        HomeTabReporterKt.onHomeTabBuildPages(result);
        HomeTabServiceImpl homeTabService = HomeTabServiceImplKt.getHomeTabServiceImpl();
        Map<String, TabIconInfo> tabIconInfoMap = null;
        if (homeTabService != null) {
            homeTabService.setShowingTabs(result);
            tabIconInfoMap = homeTabService.getTabIconMap();
        }
        for (BasePrimaryMultiPageFragment.PageInfo pageInfo : result) {
            if (pageInfo.url != null && tabIconInfoMap != null && (iconInfo = tabIconInfoMap.get(pageInfo.url)) != null) {
                pageInfo.iconInfo = new SecondaryPageIconInfo(iconInfo.getIconRes());
                pageInfo.clickExtra = iconInfo.getBundle();
            }
        }
        MainResourceManager.getInstance().getConfigData();
        Violet.INSTANCE.sendMsg(new TabDataUpdateEvent(true), false);
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabLayout(TabDataUpdateEvent tabDataUpdateEvent) {
        if (tabDataUpdateEvent.updateTab) {
            forceUpdateHomeTabs();
        }
        if (tabDataUpdateEvent.showTabBar.booleanValue()) {
            this.mTabsLayout.setVisibility(0);
            this.mPager.setHorizontalScrollable(true);
            return;
        }
        this.mTabsLayout.setVisibility(8);
        this.mPager.setHorizontalScrollable(false);
    }

    private List<BasePrimaryMultiPageFragment.PageInfo> getResult(List<SecondaryPage> srcPages) {
        List<BasePrimaryMultiPageFragment.PageInfo> result = new ArrayList<>();
        int size = srcPages.size();
        for (int index = 0; index < size; index++) {
            SecondaryPage srcPage = srcPages.get(index);
            if (srcPage.defaultSelected) {
                this.mDefSelectedPage = index;
            }
            BasePrimaryMultiPageFragment.PageInfo pageInfo = new BasePrimaryMultiPageFragment.PageInfo(srcPage.id, srcPage.title, srcPage.url);
            pageInfo.reporterId = srcPage.reporterId;
            pageInfo.reporterPos = srcPage.reporterPos;
            pageInfo.from = srcPage.from;
            if (srcPage.extension != null) {
                pageInfo.extension = mapping(srcPage.extension);
                this.mExtensionList.add(pageInfo.extension);
            }
            if (srcPage.topTabBubble != null) {
                pageInfo.bubbles = mapping(srcPage.title, srcPage.topTabBubble);
            }
            if (srcPage.topTabClickAnim != null) {
                pageInfo.clickAnimation = mapping(srcPage.topTabClickAnim);
            }
            if (pageInfo.checkParams() && pageCanBeDisplayed(pageInfo)) {
                result.add(pageInfo);
            }
        }
        return result;
    }

    private boolean pageCanBeDisplayed(BasePrimaryMultiPageFragment.PageInfo pageInfo) {
        boolean z = true;
        if (HomeCampusSwitchKt.isHomeCampusTabUrl(pageInfo.url)) {
            boolean result = (RecommendMode.isRecommendModeEnable() && HomeCampusSwitchKt.canShowHomeCampusTab()) ? false : false;
            if (!result) {
                HomeTabReporterKt.onHomeTabFilterOut(pageInfo.name);
            }
            return result;
        }
        return true;
    }

    private SecondaryPageExtension mapping(MainResourceManager.Extension extension) {
        SecondaryPageExtension secondaryPageExtension = new SecondaryPageExtension();
        secondaryPageExtension.activeUrl = extension.activeUrl;
        secondaryPageExtension.activeAnimate = extension.activeAnimate;
        secondaryPageExtension.activeResType = extension.activeResType;
        secondaryPageExtension.inactiveUrl = extension.inactiveUrl;
        secondaryPageExtension.inactiveAnimate = extension.inactiveAnimate;
        secondaryPageExtension.inactiveResType = extension.inactiveResType;
        secondaryPageExtension.topBgUrl = extension.topBg;
        secondaryPageExtension.tabBgUrl = extension.tabBg;
        secondaryPageExtension.isFollowBusiness = extension.isFollowBusiness;
        try {
            secondaryPageExtension.bgStartColor = Color.parseColor(extension.bgStartColor);
        } catch (Exception e) {
            secondaryPageExtension.bgStartColor = 0;
        }
        try {
            secondaryPageExtension.bgCenterColor = Color.parseColor(extension.bgCenterColor);
        } catch (Exception e2) {
            secondaryPageExtension.bgCenterColor = 0;
        }
        try {
            secondaryPageExtension.bgEndColor = Color.parseColor(extension.bgEndColor);
        } catch (Exception e3) {
            secondaryPageExtension.bgEndColor = 0;
        }
        try {
            secondaryPageExtension.fontColor = Color.parseColor(extension.fontColor);
        } catch (Exception e4) {
            secondaryPageExtension.fontColor = 0;
        }
        secondaryPageExtension.barColor = extension.barColor;
        if (extension.extensionClick != null) {
            SecondaryPageExtension.ExtensionClick extensionClick = new SecondaryPageExtension.ExtensionClick();
            extensionClick.id = String.valueOf(extension.extensionClick.id);
            extensionClick.type = extension.extensionClick.type;
            extensionClick.ver = extension.extensionClick.ver;
            secondaryPageExtension.extensionClick = extensionClick;
        }
        return secondaryPageExtension;
    }

    private List<SecondaryPageBubble> mapping(String title, List<MainResourceManager.TopTabBubble> bubbles) {
        List<SecondaryPageBubble> secondaryPageBubbles = new ArrayList<>(bubbles.size());
        for (MainResourceManager.TopTabBubble bubble : bubbles) {
            if (bubble.isValid()) {
                SecondaryPageBubble secondaryPageBubble = new SecondaryPageBubble(title, bubble.id, bubble.icon, bubble.url, bubble.startTime, bubble.endTime);
                secondaryPageBubbles.add(secondaryPageBubble);
            }
        }
        return secondaryPageBubbles;
    }

    private SecondaryPageClickAnim mapping(MainResourceManager.TopTabClickAnim clickAnimation) {
        if (clickAnimation.isValid()) {
            return new SecondaryPageClickAnim(clickAnimation.id, clickAnimation.file, clickAnimation.startTime, clickAnimation.endTime);
        }
        return null;
    }

    public HomePagerSlidingTabStrip getTopTabs() {
        return this.mTabs;
    }

    protected int getDefSelectedPage() {
        return this.mDefSelectedPage;
    }

    public void onCreate(Bundle savedInstanceState) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.mBaseMainViewModel = new ViewModelProvider(activity).get(BaseMainViewModel.class);
        }
        super.onCreate(savedInstanceState);
        SecondaryPageWatcher.INSTANCE.subscribe(this);
        int defaultTabBgColor = ThemeUtils.getColorById(getActivity(), R.color.Wh0);
        int[] iArr = this.mTabBgColors;
        this.mTabBgColors[1] = defaultTabBgColor;
        iArr[0] = defaultTabBgColor;
        this.mGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.mTabBgColors);
        if (activity == null) {
            return;
        }
        this.mBaseMainViewModel.isExpanded().observe(this, new Observer() { // from class: tv.danmaku.bili.ui.main2.HomeFragmentV2$$ExternalSyntheticLambda5
            public final void onChanged(Object obj) {
                HomeFragmentV2.this.m1915lambda$onCreate$1$tvdanmakubiliuimain2HomeFragmentV2((Boolean) obj);
            }
        });
        Boolean hasZeroSignal = (Boolean) this.mBaseMainViewModel.getHasZeroCard().getValue();
        if (hasZeroSignal != null) {
            this.hasZeroCard = hasZeroSignal.booleanValue();
        }
        this.mBaseMainViewModel.getHasZeroCard().observe(this, new Observer() { // from class: tv.danmaku.bili.ui.main2.HomeFragmentV2$$ExternalSyntheticLambda6
            public final void onChanged(Object obj) {
                HomeFragmentV2.this.m1916lambda$onCreate$2$tvdanmakubiliuimain2HomeFragmentV2((Boolean) obj);
            }
        });
        this.mBaseMainViewModel.getAppbarOffsetPercentLiveData().observe(this, new AnonymousClass2());
        this.splashViewModel = new ViewModelProvider(activity).get(SplashViewModel.class);
        initDefaultWordObserver();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$1$tv-danmaku-bili-ui-main2-HomeFragmentV2  reason: not valid java name */
    public /* synthetic */ void m1915lambda$onCreate$1$tvdanmakubiliuimain2HomeFragmentV2(Boolean isExpanded) {
        this.isAppBarExpanded = isExpanded.booleanValue();
        onAppLayoutVisibleStateChange();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$2$tv-danmaku-bili-ui-main2-HomeFragmentV2  reason: not valid java name */
    public /* synthetic */ void m1916lambda$onCreate$2$tvdanmakubiliuimain2HomeFragmentV2(Boolean hasZeroCard) {
        if (this.hasZeroCard == hasZeroCard.booleanValue()) {
            return;
        }
        this.hasZeroCard = hasZeroCard.booleanValue();
        INavigationBarWatcher watcher = this.defaultKeywordObserver.watcher;
        if (watcher == null) {
            return;
        }
        if (hasZeroCard.booleanValue()) {
            watcher.updateZeroCardDefaultWord(this.mSearchDefaultWord);
            watcher.updateSearchText(null);
            reportDefaultWordAvoidShow();
            return;
        }
        watcher.updateZeroCardDefaultWord(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: tv.danmaku.bili.ui.main2.HomeFragmentV2$2  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public class AnonymousClass2 implements Observer<OffsetAndForceState> {
        boolean thisTimeAutoRefresh = false;

        AnonymousClass2() {
        }

        public void onChanged(OffsetAndForceState state) {
            Float percent = state.getOffset();
            boolean forceState = state.getForceState();
            if (percent != null && HomeFragmentV2.this.mFlSearch != null && HomeFragmentV2.this.mFlSearch.getVisibility() == 0 && HomeFragmentV2.this.mFlSearch.getLayoutParams() != null) {
                if (percent.floatValue() == HomeFragmentV2.this.lastPercent) {
                    return;
                }
                HomeFragmentV2.this.lastPercent = percent.floatValue();
                final ViewGroup.MarginLayoutParams searchLp = (ViewGroup.MarginLayoutParams) HomeFragmentV2.this.mFlSearch.getLayoutParams();
                float showPercent = percent.floatValue();
                searchLp.rightMargin = (int) (HomeFragmentV2.this.SEARCH_AREA_MAX_OFFSET * (showPercent - 1.0f));
                final int currSearchExposeSize = (int) (HomeFragmentV2.this.SEARCH_AREA_MAX_OFFSET * percent.floatValue());
                HomeFragmentV2.this.mFlSearch.post(new Runnable() { // from class: tv.danmaku.bili.ui.main2.HomeFragmentV2$2$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        HomeFragmentV2.AnonymousClass2.this.m1929lambda$onChanged$0$tvdanmakubiliuimain2HomeFragmentV2$2(currSearchExposeSize, searchLp);
                    }
                });
                if (HomeFragmentV2.this.mTabShaderContainer != null) {
                    int shadowSize = HomeFragmentV2.this.SHADER_SIZE;
                    if (HomeFragmentV2.this.mFlCategory != null && HomeFragmentV2.this.mFlCategory.getVisibility() != 0) {
                        shadowSize /= 2;
                    }
                    HomeFragmentV2.this.mTabShaderContainer.showShader(currSearchExposeSize + shadowSize);
                }
                if (!HomeFragmentV2.this.hasReport && showPercent == 1.0f) {
                    Neurons.reportExposure(false, NavigationReporter.EVENT_ID_HOME_SEARCH_SHOW);
                    HomeFragmentV2.this.hasReport = true;
                }
            }
            HomeFragmentV2.this.updateTabShadowContainerMargin(percent.floatValue());
            if (percent.floatValue() == 0.0f && this.thisTimeAutoRefresh) {
                AutoRefreshQueue.INSTANCE.setSearchBarVisible(true);
                if (HomeFragmentV2.this.mSearchDefaultWord != null && HomeFragmentV2.this.mSearchDefaultWord.enableRefresh()) {
                    this.thisTimeAutoRefresh = false;
                    if (forceState) {
                        BLog.d(HomeFragmentV2.TAG, "forceState true");
                    } else {
                        AutoRefreshQueue.INSTANCE.requestUntil(0L, HomeFragmentV2.this.getViewLifecycleOwner(), 2, new Function1() { // from class: tv.danmaku.bili.ui.main2.HomeFragmentV2$2$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj) {
                                return HomeFragmentV2.AnonymousClass2.this.m1930lambda$onChanged$1$tvdanmakubiliuimain2HomeFragmentV2$2((Integer) obj);
                            }
                        });
                    }
                }
            }
            if (percent.floatValue() == 1.0f) {
                AutoRefreshQueue.INSTANCE.setSearchBarVisible(false);
                this.thisTimeAutoRefresh = true;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onChanged$0$tv-danmaku-bili-ui-main2-HomeFragmentV2$2  reason: not valid java name */
        public /* synthetic */ void m1929lambda$onChanged$0$tvdanmakubiliuimain2HomeFragmentV2$2(int currSearchExposeSize, ViewGroup.MarginLayoutParams searchLp) {
            HomeFragmentV2.this.mTabs.setRightExtraScrollSpace(currSearchExposeSize, HomeFragmentV2.this.SEARCH_AREA_MAX_OFFSET);
            HomeFragmentV2.this.mFlSearch.setLayoutParams(searchLp);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onChanged$1$tv-danmaku-bili-ui-main2-HomeFragmentV2$2  reason: not valid java name */
        public /* synthetic */ Unit m1930lambda$onChanged$1$tvdanmakubiliuimain2HomeFragmentV2$2(Integer refreshType) {
            HomeFragmentV2.this.getDefaultKeyword(false, refreshType.intValue());
            return null;
        }
    }

    private void initDefaultWordObserver() {
        if (this.searchService == null) {
            return;
        }
        this.searchService.refreshDefaultWord().observe(this, new Observer() { // from class: tv.danmaku.bili.ui.main2.HomeFragmentV2$$ExternalSyntheticLambda16
            public final void onChanged(Object obj) {
                HomeFragmentV2.this.m1913lambda$initDefaultWordObserver$3$tvdanmakubiliuimain2HomeFragmentV2((Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initDefaultWordObserver$3$tv-danmaku-bili-ui-main2-HomeFragmentV2  reason: not valid java name */
    public /* synthetic */ void m1913lambda$initDefaultWordObserver$3$tvdanmakubiliuimain2HomeFragmentV2(Boolean refresh) {
        if (refresh != null && refresh.booleanValue()) {
            updateDefaultSearchWord(false, true);
        }
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.mTabShaderContainer = view.findViewById(com.bilibili.lib.homepage.R.id.tabs_shader_container);
        this.mTabsLayout.setBackground(this.mGradientDrawable);
        if (MainResourceManager.getInstance().getMoreCategoryItem() != null) {
            showCategoryView();
        }
        HomeTabServiceImpl homeTabService = HomeTabServiceImplKt.getHomeTabServiceImpl();
        if (homeTabService != null) {
            homeTabService.setHomeFragmentOperator(this.mHomeFragOperator);
            homeTabService.setLifeCycleScope(LifecycleKt.getCoroutineScope(getViewLifecycleOwner().getLifecycle()));
        }
        this.mTabHost = ListMenuWindowKt.getBottomNavigationBar(view.getRootView());
        this.splashViewModel.getSplashExit().observe(getViewLifecycleOwner(), new Observer<SplashViewModel.SplashExitInfo>() { // from class: tv.danmaku.bili.ui.main2.HomeFragmentV2.3
            public void onChanged(SplashViewModel.SplashExitInfo splashExitInfo) {
                if (splashExitInfo != null) {
                    if (splashExitInfo.getAnimState() == 0 || splashExitInfo.getAnimState() == 2) {
                        HomeFragmentV2.this.isSplashVisible = false;
                        HomeFragmentV2.this.onPageVisibleStateChange();
                    }
                }
            }
        });
    }

    protected void configAdapter(SecondaryPageAdapter mAdapter) {
        HomeTabService homeTabService = (HomeTabService) BLRouter.INSTANCE.get(HomeTabService.class, "HOME_TAB_SERVICE");
        if (homeTabService != null) {
            mAdapter.shouldFixItemPosition = homeTabService.isHotUpdateEnable();
        }
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        GarbWatcher.INSTANCE.subscribe(this);
        BiliAccounts.get(BiliContext.application()).subscribe(this.passportObserver, new Topic[]{Topic.SIGN_IN, Topic.SIGN_OUT});
        if (savedInstanceState == null) {
            Intent intent = activity.getIntent();
            anchorTab(intent);
            tryShowHomeTabGuidance();
            tryShowTabBubble();
            registerTabClickAnim();
        }
    }

    public void onNewIntent(Intent intent) {
        anchorTab(intent);
        FragmentManager fm = getChildFragmentManager();
        List<Fragment> fs = fm.getFragments();
        if (fs.isEmpty()) {
            return;
        }
        for (Fragment fragment : fs) {
            if (fragment instanceof INewIntentCompat) {
                ((INewIntentCompat) fragment).onNewIntent(intent);
            }
        }
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        FragmentManager fm = getChildFragmentManager();
        List<Fragment> fs = fm.getFragments();
        if (fs.isEmpty()) {
            return;
        }
        for (Fragment fragment : fs) {
            if (fragment instanceof IWindowFocusChanged) {
                ((IWindowFocusChanged) fragment).onWindowFocusChanged(hasFocus);
            }
        }
    }

    public void onStart() {
        super.onStart();
        if (!isHidden()) {
            BLog.i(TAG, "onStart");
            tryUpdateTabs();
            tryReportShow();
            HomeLoginExpKt.checkShowOnePass(this);
        }
    }

    public void onResume() {
        super.onResume();
        this.isResumed = true;
        onPageVisibleStateChange();
        if (!isHidden()) {
            isAdded();
        }
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: tv.danmaku.bili.ui.main2.HomeFragmentV2$$ExternalSyntheticLambda7
            @Override // android.os.MessageQueue.IdleHandler
            public final boolean queueIdle() {
                return HomeFragmentV2.this.m1919lambda$onResume$5$tvdanmakubiliuimain2HomeFragmentV2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onResume$5$tv-danmaku-bili-ui-main2-HomeFragmentV2  reason: not valid java name */
    public /* synthetic */ boolean m1919lambda$onResume$5$tvdanmakubiliuimain2HomeFragmentV2() {
        this.mToken = new CancellationTokenSource();
        Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.ui.main2.HomeFragmentV2$$ExternalSyntheticLambda15
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return HomeFragmentV2.this.m1918lambda$onResume$4$tvdanmakubiliuimain2HomeFragmentV2();
            }
        }, this.mToken.getToken());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onResume$4$tv-danmaku-bili-ui-main2-HomeFragmentV2  reason: not valid java name */
    public /* synthetic */ Void m1918lambda$onResume$4$tvdanmakubiliuimain2HomeFragmentV2() throws Exception {
        AnimateResourceManager.startDownload(getContext(), this.mExtensionList);
        return null;
    }

    public void onPause() {
        super.onPause();
        this.isResumed = false;
        onPageVisibleStateChange();
    }

    public void onFragmentHide(Flag flag) {
        super.onFragmentHide(flag);
        this.isFragmentHide = true;
        onPageVisibleStateChange();
        this.splashViewModel.getHomePageVisible().setValue(false);
        resetToolbarStatus();
        HomeTabServiceImpl homeTabService = HomeTabServiceImplKt.getHomeTabServiceImpl();
        if (homeTabService != null) {
            homeTabService.onFragmentHide();
        }
    }

    private void updateAppbar() {
        if (this.mTabsLayout.getVisibility() == 0) {
            this.mPager.setHorizontalScrollable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPageVisibleStateChange() {
        HomePageMenusVisibilityKt.onHomePageMenuVisibleChanged(!this.isFragmentHide && this.isResumed && !this.isSplashVisible && this.isAppBarExpanded);
        onAppLayoutVisibleStateChange();
    }

    private void onAppLayoutVisibleStateChange() {
        if (!this.isFragmentHide && this.isResumed && !this.isSplashVisible && this.isAppBarExpanded) {
            reportMenuExpose();
        }
    }

    private void reportMenuExpose() {
        IDynamicMenuItemServer server;
        if (mMenus != null && !mMenus.isEmpty()) {
            Iterator<IOptionMenuItem> it = mMenus.iterator();
            while (it.hasNext()) {
                DynamicMenuItem dynamicMenuItem = (IOptionMenuItem) it.next();
                if ((dynamicMenuItem instanceof DynamicMenuItem) && (server = dynamicMenuItem.getDynamicServer()) != null) {
                    server.strictExpose();
                }
            }
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.mToken != null) {
            this.mToken.cancel();
            this.mToken = null;
        }
        GarbWatcher.INSTANCE.unSubscribe(this);
        SecondaryPageWatcher.INSTANCE.unSubscribe(this);
        BiliAccounts.get(getContext()).unsubscribe(this.passportObserver, new Topic[]{Topic.SIGN_IN, Topic.SIGN_OUT});
        this.drawableCache.clear();
        HomeTabServiceImpl homeTabService = HomeTabServiceImplKt.getHomeTabServiceImpl();
        if (homeTabService != null) {
            homeTabService.setHomeFragmentOperator(null);
        }
    }

    private void showCategoryView() {
        Context context = getContext();
        if (context == null || this.mCategoryView != null) {
            return;
        }
        this.mCategoryView = LayoutInflater.from(getContext()).inflate(tv.danmaku.bili.R.layout.bili_app_layout_home_top_tabbar_category_layout, this.mTabsLayout, false);
        this.mIvCategory = this.mCategoryView.findViewById(tv.danmaku.bili.R.id.category_image);
        this.mIvSearch = this.mCategoryView.findViewById(tv.danmaku.bili.R.id.search_image);
        this.mFlCategory = (FrameLayout) this.mCategoryView.findViewById(tv.danmaku.bili.R.id.category_click_area);
        this.mFlSearch = (FrameLayout) this.mCategoryView.findViewById(tv.danmaku.bili.R.id.search_click_area);
        this.mFlCategory.setVisibility(8);
        this.mFlSearch.setVisibility(8);
        renderCategoryView(context);
        this.mTabsLayout.addView(this.mCategoryView);
        updateTabShadowContainerMargin(0.0f);
        NavigationReporter.reportHomeTabShow("全部分区");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabShadowContainerMargin(float appbarPercent) {
        if (this.mTabShaderContainer == null || this.mFlCategory == null || this.mFlSearch == null || getTopTabs() == null) {
            return;
        }
        ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) this.mTabShaderContainer.getLayoutParams();
        if (this.mFlSearch.getVisibility() != 0 && this.mFlCategory.getVisibility() != 0) {
            lp.rightMargin = 0;
            this.mTabShaderContainer.showShader(0);
        } else if (this.mFlCategory.getVisibility() == 0) {
            lp.rightMargin = this.TAB_RIGHT_MARGIN;
            if (appbarPercent == 0.0f) {
                this.mTabShaderContainer.showShader(DisplayUtils.dp2Px(26));
            }
        } else if (this.mFlSearch.getVisibility() == 0) {
            int maxSpacing = (int) (this.TAB_RIGHT_MARGIN * 0.5d);
            int rightExtraSpacing = Math.max(0, getTopTabs().getMeasuredWidth() - getTopTabs().getTabContentWidth()) / 2;
            int rightMargin = (int) ((maxSpacing - rightExtraSpacing) * appbarPercent);
            lp.rightMargin = Math.max(0, Math.min(rightMargin, maxSpacing));
        }
        BLog.i(TAG, "updateTabShadowContainerMargin:" + lp.rightMargin + " appbarPercent:" + appbarPercent);
        this.mTabShaderContainer.setLayoutParams(lp);
    }

    private void renderCategoryView(final Context context) {
        List<MoreCategoryItem> items = MainResourceManager.getInstance().getMoreCategoryItem();
        if (items == null || this.mCategoryView == null) {
            return;
        }
        for (final MoreCategoryItem item : items) {
            if (item != null) {
                if (item.isNormal()) {
                    this.mFlCategory.setVisibility(0);
                    renderCategoryView(context, this.mIvCategory, item);
                    this.mFlCategory.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main2.HomeFragmentV2$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            HomeFragmentV2.lambda$renderCategoryView$6(MoreCategoryItem.this, context, view);
                        }
                    });
                } else if (item.isSearchIcon()) {
                    this.mFlSearch.setVisibility(0);
                    renderCategoryView(context, this.mIvSearch, item);
                    this.mFlSearch.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main2.HomeFragmentV2$$ExternalSyntheticLambda2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            HomeFragmentV2.this.m1921lambda$renderCategoryView$8$tvdanmakubiliuimain2HomeFragmentV2(item, context, view);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$renderCategoryView$6(MoreCategoryItem item, Context context, View v) {
        String uri = TextUtils.isEmpty(item.uri) ? "bilibili://main/top_category" : item.uri;
        BLRouter.routeTo(new RouteRequest(Uri.parse(uri)), context);
        NavigationReporter.reportHomeTabClick("全部分区", "click");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$renderCategoryView$8$tv-danmaku-bili-ui-main2-HomeFragmentV2  reason: not valid java name */
    public /* synthetic */ void m1921lambda$renderCategoryView$8$tvdanmakubiliuimain2HomeFragmentV2(MoreCategoryItem item, Context context, View v) {
        String uri = (item == null || TextUtils.isEmpty(item.uri)) ? MainRouteUris.URI_MAIN_TOP_SEARCH : item.uri;
        RouteRequest.Builder builder = new RouteRequest.Builder(uri);
        if (this.mSearchDefaultWord != null) {
            builder.extras(new Function1() { // from class: tv.danmaku.bili.ui.main2.HomeFragmentV2$$ExternalSyntheticLambda12
                public final Object invoke(Object obj) {
                    return HomeFragmentV2.this.m1920lambda$renderCategoryView$7$tvdanmakubiliuimain2HomeFragmentV2((MutableBundleLike) obj);
                }
            });
        }
        BLRouter.routeTo(builder.build(), context);
        Neurons.reportClick(false, NavigationReporter.EVENT_ID_HOME_SEARCH_CLICK);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$renderCategoryView$7$tv-danmaku-bili-ui-main2-HomeFragmentV2  reason: not valid java name */
    public /* synthetic */ Unit m1920lambda$renderCategoryView$7$tvdanmakubiliuimain2HomeFragmentV2(MutableBundleLike bundle) {
        bundle.put("search_discover_from_home", String.valueOf(true));
        bundle.put("search_default_word", JSON.toJSONString(this.mSearchDefaultWord));
        return null;
    }

    private void renderCategoryView(Context context, BiliImageView imageView, MoreCategoryItem item) {
        if (imageView == null || imageView.getVisibility() == 8 || item == null) {
            return;
        }
        imageView.setColorFilter(ContextCompat.getColor(context, R.color.Ga7));
        BiliImageLoader.INSTANCE.with(this).url(item.icon).overrideWidth(this.SEARCH_ICON_IMG_SIZE).overrideHeight(this.SEARCH_ICON_IMG_SIZE).failureImageResId(item.isNormal() ? tv.danmaku.bili.R.drawable.ic_more_category : tv.danmaku.bili.R.drawable.ic_top_search_entrance).into(imageView);
        Garb garb = GarbManager.getGarbWithNightMode(context);
        if (!garb.isPure()) {
            imageView.setColorFilter(garb.getMainFontColor());
        }
    }

    private void hideCategoryView() {
        if (this.mCategoryView == null) {
            return;
        }
        this.mTabsLayout.removeView(this.mCategoryView);
        ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) this.mTabShaderContainer.getLayoutParams();
        lp.rightMargin = 0;
        this.mTabShaderContainer.setLayoutParams(lp);
        this.mTabShaderContainer.hideShader();
        this.mCategoryView = null;
    }

    private void resetToolbarStatus() {
        IMainFragmentHost parentFragment = getParentFragment();
        if (parentFragment instanceof IMainFragmentHost) {
            parentFragment.changeIsCustomTab(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDefaultSearchWord(boolean fromTM, boolean fromBusiness) {
        Boolean prevent;
        BLog.i(TAG, "updateDefaultSearchWord, fromTM = " + fromTM + ", fromBusiness = " + fromBusiness + ", loading = " + this.mDefaultWordLoading);
        if (this.mDefaultWordLoading) {
            return;
        }
        if (this.searchService != null && (prevent = (Boolean) this.searchService.keepOnceRefreshLiveData().getValue()) != null && prevent.booleanValue()) {
            this.searchService.keepOnceRefreshLiveData().setValue(false);
            BLog.i(TAG, "updateDefaultSearchWord, prevent by prev request set");
            if (this.mSearchDefaultWord != null && this.mSearchDefaultWord.enableRefresh()) {
                AutoRefreshQueue.INSTANCE.requestUntil(this.mSearchDefaultWord.getRefreshIntervalMilli() + this.mSearchDefaultWord.getAnimationTimeMilli(), getViewLifecycleOwner(), 1, new Function1() { // from class: tv.danmaku.bili.ui.main2.HomeFragmentV2$$ExternalSyntheticLambda9
                    public final Object invoke(Object obj) {
                        return HomeFragmentV2.this.m1927lambda$updateDefaultSearchWord$9$tvdanmakubiliuimain2HomeFragmentV2((Integer) obj);
                    }
                });
                return;
            }
            return;
        }
        getDefaultKeyword(fromTM, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$updateDefaultSearchWord$9$tv-danmaku-bili-ui-main2-HomeFragmentV2  reason: not valid java name */
    public /* synthetic */ Unit m1927lambda$updateDefaultSearchWord$9$tvdanmakubiliuimain2HomeFragmentV2(Integer refreshType) {
        getDefaultKeyword(false, refreshType.intValue());
        return null;
    }

    public void getDefaultKeyword(boolean fromTM, int refreshType) {
        if (this.hasZeroCard) {
            BLog.i(TAG, "getDefaultKeyword, hasZeroCard , prevent request, refreshType = " + refreshType);
            reportDefaultWordAvoidShow();
            return;
        }
        Fragment parent = getParentFragment();
        if (parent instanceof INavigationBarWatcher) {
            this.mDefaultWordLoading = true;
            INavigationBarWatcher watcher = (INavigationBarWatcher) getParentFragment();
            if (this.defaultKeywordService == null) {
                defaultKeywordUpdateError(watcher);
                return;
            }
            this.defaultKeywordObserver.setWatcher(watcher);
            this.defaultKeywordService.getDefaultKeyword(1, this.mCurPageInfo != null ? this.mCurPageInfo.name : null, fromTM, refreshType, false, (String) null).observe(this, this.defaultKeywordObserver);
        }
    }

    private void reportDefaultWordAvoidShow() {
        final IDefaultKeywordResult result = this.mSearchDefaultWord;
        if (result != null) {
            result.setEnableRefresh(0L);
            Neurons.reportExposure(false, "main.homepage.search-defaultword-avoidance.0.show", new HashMap<String, String>() { // from class: tv.danmaku.bili.ui.main2.HomeFragmentV2.4
                {
                    put("query", result.getShow());
                    put("trackid", result.getTrackId());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void defaultKeywordUpdateError(INavigationBarWatcher watcher) {
        this.mDefaultWordLoading = false;
        if (watcher != null) {
            watcher.updateSearchText(null);
        }
    }

    public void onPageSelected(final int position, final BasePrimaryMultiPageFragment.PageInfo page, SecondaryPageExtraInfo pageExtraInfo) {
        this.mBaseMainViewModel.update(new UpdateTabSelectedAction(position));
        if (this.mCurPageInfo != null) {
            NavigationReporter.reportHomeTabClick(page.name, this.mTabs.isInClick() ? "click" : "slide", (page.clickAnimation == null || !page.clickAnimation.inInvalidTimeGap()) ? "0" : "1");
        }
        this.mCurPageInfo = page;
        this.mCurPageExtraInfo = pageExtraInfo;
        final HomeTabServiceImpl homeTabService = HomeTabServiceImplKt.getHomeTabServiceImpl();
        if (homeTabService != null) {
            ViewKt.doOnNextLayout(this.mTabs, new Function1() { // from class: tv.danmaku.bili.ui.main2.HomeFragmentV2$$ExternalSyntheticLambda11
                public final Object invoke(Object obj) {
                    return HomeFragmentV2.this.m1917lambda$onPageSelected$10$tvdanmakubiliuimain2HomeFragmentV2(page, position, homeTabService, (View) obj);
                }
            });
        }
        tryUpdateTabUi(page, pageExtraInfo, 200L);
        if (page.extension != null && !page.extension.isClicked) {
            page.extension.isClicked = true;
            if (page.extension.extensionClick != null) {
                Task.callInBackground(new Callable<Void>() { // from class: tv.danmaku.bili.ui.main2.HomeFragmentV2.5
                    @Override // java.util.concurrent.Callable
                    public Void call() throws Exception {
                        try {
                            MainResourceManager.TabService tabService = (MainResourceManager.TabService) ServiceGenerator.createService(MainResourceManager.TabService.class);
                            tabService.showClick(page.extension.extensionClick.id, page.extension.extensionClick.ver, page.extension.extensionClick.type).execute();
                            return null;
                        } catch (Exception e) {
                            BLog.d(HomeFragmentV2.TAG, "showClick" + e.getMessage());
                            return null;
                        }
                    }
                });
            }
        }
        BottomTabSelectedHelper.isRecommendPage = getCurrentPage() == getDefSelectedPage();
        OpBizDialogHelper.isFirst = false;
        if (getActivity() != null && page.name != null) {
            BTrace.updateSubPageInfo(page.name, getActivity());
        }
        if (this.mTabHost != null && this.mTabHost.getTabs() != null) {
            for (TabHost.TabInfo tab : this.mTabHost.getTabs()) {
                if (tab.isPublish) {
                    LifecycleOwner viewOwner = (LifecycleOwner) getViewLifecycleOwnerLiveData().getValue();
                    if (viewOwner != null) {
                        PublishBubbleDialogKt.showPublishBubbleInLifecycleScope(viewOwner, this.mTabHost, tab.url);
                        return;
                    }
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onPageSelected$10$tv-danmaku-bili-ui-main2-HomeFragmentV2  reason: not valid java name */
    public /* synthetic */ Unit m1917lambda$onPageSelected$10$tvdanmakubiliuimain2HomeFragmentV2(BasePrimaryMultiPageFragment.PageInfo page, int position, HomeTabServiceImpl homeTabService, View view) {
        if (page != CollectionsKt.getOrNull(getPageInfos(), position)) {
            return Unit.INSTANCE;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable(TopTabClickAnimKt.HOME_TAB_CLICK_ANIM, page.clickAnimation);
        homeTabService.onHomeTabSelect(true, position, page.url, this.mTabs.getTabAt(position), bundle);
        return Unit.INSTANCE;
    }

    public void onPageUnSelected(int position) {
        if (this.mBaseMainViewModel != null) {
            this.mBaseMainViewModel.update(new ToolbarEvent.KeepCollapseStateAndResetToScrollable("page " + position + " unselected"));
        }
    }

    private void tryUpdateTabUi(BasePrimaryMultiPageFragment.PageInfo pageInfo, SecondaryPageExtraInfo pageExtraInfo, long delay) {
        Context context;
        int i;
        BasePrimaryMultiPageFragment.PageInfo pageInfo2;
        Context context2;
        int i2;
        if (isHidden()) {
            return;
        }
        IMainFragmentHost parentFragment = getParentFragment();
        Context context3 = getContext();
        if ((parentFragment instanceof IMainFragmentHost) && context3 != null) {
            boolean canSecondaryPageChangeUi = canSecondaryPageChangeUi(context3, pageExtraInfo);
            if (pageExtraInfo == null) {
                context = context3;
                i = 0;
            } else if ((pageExtraInfo.isColorValid() || pageExtraInfo.isDrawableValid()) && canSecondaryPageChangeUi) {
                if (pageExtraInfo.isDrawableValid()) {
                    if (pageExtraInfo.getTabBgDrawable() != null && pageExtraInfo.getFontColor() != 0) {
                        startTabBgImageAnimator(this.mCurrentDrawable, pageExtraInfo.getTabBgDrawable(), delay, new Runnable() { // from class: tv.danmaku.bili.ui.main2.HomeFragmentV2.7
                            @Override // java.lang.Runnable
                            public void run() {
                                HomeFragmentV2.this.mTabsBgView.setVisibility(0);
                            }
                        });
                        changeUiTask(pageExtraInfo.getFontColor(), 0);
                        context2 = context3;
                        i2 = 0;
                    } else {
                        context2 = context3;
                        i2 = 0;
                    }
                } else if (pageExtraInfo.isColorValid()) {
                    int fontColor = pageExtraInfo.getFontColor();
                    int bgEndColor = pageExtraInfo.getBgEndColor();
                    int bgCenterColor = pageExtraInfo.getBgCenterColor();
                    boolean isTabsImageVisible = this.mTabsBgView.getVisibility() == 0;
                    context2 = context3;
                    i2 = 0;
                    startTabBgColorAnimator(isTabsImageVisible ? bgCenterColor : this.mCurrentTabBgStartColor, isTabsImageVisible ? bgEndColor : this.mCurrentTabBgEndColor, bgCenterColor, bgEndColor, isTabsImageVisible ? this.mTabsBgView : null, delay, new Runnable() { // from class: tv.danmaku.bili.ui.main2.HomeFragmentV2$$ExternalSyntheticLambda4
                        @Override // java.lang.Runnable
                        public final void run() {
                            HomeFragmentV2.this.m1926lambda$tryUpdateTabUi$12$tvdanmakubiliuimain2HomeFragmentV2();
                        }
                    });
                    changeUiTask(fontColor, bgEndColor);
                } else {
                    return;
                }
                ISecondaryPageExtraInfoListener infoListener = null;
                if (this.mCurPageInfo != null && (this.mCurPageInfo.pageFragment instanceof ISecondaryPageExtraInfoListener)) {
                    infoListener = (ISecondaryPageExtraInfoListener) this.mCurPageInfo.pageFragment;
                }
                if (infoListener != null) {
                    infoListener.setChangeState(i2);
                }
                parentFragment.updateMainTopBg(null, pageExtraInfo, delay);
                this.mIsTabColorUpdated = true;
                return;
            } else {
                context = context3;
                i = 0;
            }
            Garb garb = GarbManager.getGarbWithNightMode(context);
            if (!garb.getChangeable()) {
                parentFragment.updateMainTopBgWithGarb(garb, delay);
                updateTabWihGarb(garb, delay);
                return;
            }
            if (pageInfo != null && pageInfo.extension != null) {
                if (pageInfo.extension.isColorValid() || pageInfo.extension.isTobTabBgValid()) {
                    Context context4 = context;
                    String path = AnimateResourceManager.getBitmapRes(context4, pageInfo.extension.tabBgUrl);
                    if (!pageInfo.extension.isTobTabBgValid() || !AnimateResourceManager.isResDownload(context4, pageInfo.extension.tabBgUrl) || TextUtils.isEmpty(path)) {
                        if (pageInfo.extension.isColorValid()) {
                            int fontColor2 = pageInfo.extension.fontColor;
                            int bgEndColor2 = pageInfo.extension.bgEndColor;
                            int bgCenterColor2 = pageInfo.extension.bgCenterColor;
                            if (this.mTabsBgView.getVisibility() == 0) {
                                i = 1;
                            }
                            pageInfo2 = pageInfo;
                            startTabBgColorAnimator(i != 0 ? bgCenterColor2 : this.mCurrentTabBgStartColor, i != 0 ? bgEndColor2 : this.mCurrentTabBgEndColor, bgCenterColor2, bgEndColor2, i != 0 ? this.mTabsBgView : null, delay, new Runnable() { // from class: tv.danmaku.bili.ui.main2.HomeFragmentV2$$ExternalSyntheticLambda3
                                @Override // java.lang.Runnable
                                public final void run() {
                                    HomeFragmentV2.this.m1925lambda$tryUpdateTabUi$11$tvdanmakubiliuimain2HomeFragmentV2();
                                }
                            });
                            changeUiTask(fontColor2, bgEndColor2);
                        } else {
                            resetTabColor(parentFragment, delay);
                            return;
                        }
                    } else {
                        BitmapDrawable bitmapDrawable = getDrawableFromFile(context4, path);
                        if (bitmapDrawable != null) {
                            startTabBgImageAnimator(this.mCurrentDrawable, bitmapDrawable, delay, new Runnable() { // from class: tv.danmaku.bili.ui.main2.HomeFragmentV2.6
                                @Override // java.lang.Runnable
                                public void run() {
                                    HomeFragmentV2.this.mTabsBgView.setVisibility(0);
                                }
                            });
                            changeUiTask(pageInfo.extension.fontColor, i);
                        }
                        pageInfo2 = pageInfo;
                    }
                    parentFragment.updateMainTopBg(pageInfo2.extension, null, delay);
                    this.mIsTabColorUpdated = true;
                    return;
                }
            }
            resetTabColor(parentFragment, delay);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$tryUpdateTabUi$11$tv-danmaku-bili-ui-main2-HomeFragmentV2  reason: not valid java name */
    public /* synthetic */ void m1925lambda$tryUpdateTabUi$11$tvdanmakubiliuimain2HomeFragmentV2() {
        this.mTabsBgView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$tryUpdateTabUi$12$tv-danmaku-bili-ui-main2-HomeFragmentV2  reason: not valid java name */
    public /* synthetic */ void m1926lambda$tryUpdateTabUi$12$tvdanmakubiliuimain2HomeFragmentV2() {
        this.mTabsBgView.setVisibility(8);
    }

    private boolean canSecondaryPageChangeUi(Context context, SecondaryPageExtraInfo pageExtraInfo) {
        if (pageExtraInfo == null) {
            return false;
        }
        ISecondaryPageExtraInfoListener infoListener = null;
        if (this.mCurPageInfo != null && (this.mCurPageInfo.pageFragment instanceof ISecondaryPageExtraInfoListener)) {
            infoListener = (ISecondaryPageExtraInfoListener) this.mCurPageInfo.pageFragment;
        }
        Garb garb = GarbManager.getGarbWithNightMode(context);
        if (!garb.getChangeable()) {
            if (infoListener != null) {
                infoListener.setChangeState(1);
            }
            return false;
        }
        Boolean isFollowBus = MainResourceManager.sTabIsFollowBusMap.get(pageExtraInfo.getUrl());
        if (isFollowBus != null && isFollowBus.booleanValue()) {
            return TextUtils.equals(pageExtraInfo.getUrl(), this.mCurPageInfo.url);
        }
        if (infoListener != null) {
            infoListener.setChangeState(2);
        }
        return false;
    }

    private void resetTabColor(Fragment parent, long delay) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        resetToolbarStatus();
        Garb lastGarb = GarbManager.getGarbWithNightMode(context);
        if (!lastGarb.isPure()) {
            ((IMainFragmentHost) parent).updateMainTopBgWithGarb(lastGarb, delay);
            updateTabWihGarb(lastGarb, delay);
            return;
        }
        ((IMainFragmentHost) parent).resetMainTopBg(delay);
        resetTabColor(delay);
    }

    private void changeUiTask(int fontColor, int bgEndColor) {
        int textColor = ColorUtils.setAlphaComponent(fontColor, (int) BR.followDesc);
        this.mTabs.setIndicatorColor(fontColor);
        int[] tabColor = {fontColor, fontColor, textColor};
        int[][] state = {new int[]{16842913}, new int[]{16842919}, new int[0]};
        ColorStateList tabColorState = new ColorStateList(state, tabColor);
        this.mTabs.setTextColor(tabColorState);
        this.mDivider.setBackgroundColor(bgEndColor);
        this.mTabs.setTintable(false);
        this.mDivider.setTintable(false);
        if (this.mIvCategory != null) {
            this.mIvCategory.setColorFilter(textColor);
        }
    }

    private void startTabBgColorAnimator(int startColor, int endColor, final int customStartColor, final int customEndColor, final ImageView bgView, long duration, final Runnable endAction) {
        int startColor2;
        int endColor2;
        Context context = getContext();
        if (context == null) {
            return;
        }
        int defaultColor = ThemeUtils.getColorById(context, R.color.Wh0);
        if (startColor != 0) {
            startColor2 = startColor;
        } else {
            startColor2 = defaultColor;
        }
        if (endColor != 0) {
            endColor2 = endColor;
        } else {
            endColor2 = defaultColor;
        }
        final ArgbEvaluator argbEvaluator = new ArgbEvaluator();
        this.mAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mAnimator.setDuration(duration);
        final int finalStartColor = startColor2;
        final int finalEndColor = endColor2;
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.main2.HomeFragmentV2$$ExternalSyntheticLambda8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                HomeFragmentV2.this.m1923lambda$startTabBgColorAnimator$13$tvdanmakubiliuimain2HomeFragmentV2(argbEvaluator, finalStartColor, customStartColor, finalEndColor, customEndColor, bgView, valueAnimator);
            }
        });
        this.mAnimator.addListener(new AnimatorListenerAdapter() { // from class: tv.danmaku.bili.ui.main2.HomeFragmentV2.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                HomeFragmentV2.this.mCurrentTabBgStartColor = customStartColor;
                HomeFragmentV2.this.mCurrentTabBgEndColor = customEndColor;
                HomeFragmentV2.this.mCurrentDrawable = null;
                if (endAction != null) {
                    endAction.run();
                }
            }
        });
        this.mAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$startTabBgColorAnimator$13$tv-danmaku-bili-ui-main2-HomeFragmentV2  reason: not valid java name */
    public /* synthetic */ void m1923lambda$startTabBgColorAnimator$13$tvdanmakubiliuimain2HomeFragmentV2(ArgbEvaluator argbEvaluator, int finalStartColor, int customStartColor, int finalEndColor, int customEndColor, ImageView bgView, ValueAnimator animation) {
        float per = ((Float) animation.getAnimatedValue()).floatValue();
        this.mTabBgColors[0] = ((Integer) argbEvaluator.evaluate(per, Integer.valueOf(finalStartColor), Integer.valueOf(customStartColor))).intValue();
        this.mTabBgColors[1] = ((Integer) argbEvaluator.evaluate(per, Integer.valueOf(finalEndColor), Integer.valueOf(customEndColor))).intValue();
        this.mGradientDrawable.setColors(this.mTabBgColors);
        if (bgView != null) {
            bgView.setAlpha(1.0f - per);
        }
    }

    private void startTabBgImageAnimator(final Drawable bgImageViewFrom, Drawable bgImageViewTo, long duration, final Runnable endAction) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        this.mCurrentDrawable = bgImageViewTo;
        this.mTabsBgView.setAlpha(1.0f);
        this.mTabsBgView.setVisibility(0);
        if (bgImageViewFrom != null && bgImageViewFrom != bgImageViewTo) {
            Drawable[] drawables = {bgImageViewFrom, bgImageViewTo};
            TransitionDrawable transitionDrawable = new TransitionDrawable(drawables);
            this.mTabsBgView.setImageDrawable(transitionDrawable);
            transitionDrawable.startTransition((int) duration);
        } else {
            this.mTabsBgView.setImageDrawable(bgImageViewTo);
        }
        this.mBgImageAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mBgImageAnimator.setDuration(duration);
        this.mBgImageAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.main2.HomeFragmentV2$$ExternalSyntheticLambda10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                HomeFragmentV2.this.m1924lambda$startTabBgImageAnimator$14$tvdanmakubiliuimain2HomeFragmentV2(bgImageViewFrom, valueAnimator);
            }
        });
        this.mBgImageAnimator.addListener(new AnimatorListenerAdapter() { // from class: tv.danmaku.bili.ui.main2.HomeFragmentV2.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if (endAction != null) {
                    endAction.run();
                }
            }
        });
        this.mBgImageAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$startTabBgImageAnimator$14$tv-danmaku-bili-ui-main2-HomeFragmentV2  reason: not valid java name */
    public /* synthetic */ void m1924lambda$startTabBgImageAnimator$14$tvdanmakubiliuimain2HomeFragmentV2(Drawable bgImageViewFrom, ValueAnimator animation) {
        float per = ((Float) animation.getAnimatedValue()).floatValue();
        if (bgImageViewFrom == null) {
            this.mTabsBgView.setAlpha(per);
        }
    }

    private void resetTabColor(long duration) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        int toColor = ThemeUtils.getColorById(context, R.color.Wh0);
        startTabBgColorAnimator(this.mCurrentTabBgStartColor, this.mCurrentTabBgEndColor, toColor, toColor, this.mTabsBgView.getVisibility() == 0 ? this.mTabsBgView : null, duration, new Runnable() { // from class: tv.danmaku.bili.ui.main2.HomeFragmentV2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                HomeFragmentV2.this.m1922lambda$resetTabColor$15$tvdanmakubiliuimain2HomeFragmentV2();
            }
        });
        int highlightColor = ThemeUtils.getColorById(context, com.bilibili.app.comm.baseres.R.color.theme_color_secondary);
        this.mTabs.setIndicatorColor(highlightColor);
        this.mTabs.resetTextColor();
        this.mDivider.setBackgroundResource(R.color.Ga2);
        this.mTabs.setTintable(true);
        this.mDivider.setTintable(true);
        if (this.mIvCategory != null) {
            this.mIvCategory.setColorFilter(ContextCompat.getColor(context, R.color.Ga7));
        }
        this.mIsTabColorUpdated = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$resetTabColor$15$tv-danmaku-bili-ui-main2-HomeFragmentV2  reason: not valid java name */
    public /* synthetic */ void m1922lambda$resetTabColor$15$tvdanmakubiliuimain2HomeFragmentV2() {
        this.mTabsBgView.setVisibility(8);
    }

    private void updateTabWihGarb(Garb garb, long duration) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        String tabBgPath = garb.getHeadTabBgPath();
        if (garb.getId() == 0 || garb.getMainFontColor() == 0 || TextUtils.isEmpty(tabBgPath)) {
            resetTabColor(duration);
            return;
        }
        BitmapDrawable bgDrawable = getDrawableFromFile(context, tabBgPath);
        if (bgDrawable != null) {
            startTabBgImageAnimator(this.mCurrentDrawable, bgDrawable, duration, null);
            int fontColor = garb.getMainFontColor();
            int textColor = ColorUtils.setAlphaComponent(fontColor, (int) BR.followDesc);
            this.mTabs.setIndicatorColor(fontColor);
            int[] tabColor = {fontColor, fontColor, textColor};
            int[][] state = {new int[]{16842913}, new int[]{16842919}, new int[0]};
            ColorStateList tabColorState = new ColorStateList(state, tabColor);
            this.mTabs.setTextColor(tabColorState);
            this.mDivider.setBackgroundColor(0);
            this.mTabs.setTintable(false);
            this.mDivider.setTintable(false);
            if (this.mIvCategory != null) {
                this.mIvCategory.setColorFilter(textColor);
            }
        } else {
            this.mTabsBgView.setVisibility(8);
            int defaultBgColor = ThemeUtils.getColorById(context, R.color.Wh0);
            int[] iArr = this.mTabBgColors;
            this.mTabBgColors[1] = defaultBgColor;
            iArr[0] = defaultBgColor;
            this.mGradientDrawable.setColors(this.mTabBgColors);
            this.mTabsLayout.setBackground(this.mGradientDrawable);
            this.mCurrentTabBgStartColor = defaultBgColor;
            this.mCurrentTabBgEndColor = defaultBgColor;
        }
        this.mIsTabColorUpdated = false;
    }

    private BitmapDrawable getDrawableFromFile(Context context, String path) {
        BitmapDrawable drawable = this.drawableCache.get(path);
        if (drawable == null) {
            try {
                File file = new File(URI.create(path));
                Bitmap bitmap = BitmapFactory.decodeFile(file.getPath());
                drawable = new BitmapDrawable(context.getResources(), bitmap);
                this.drawableCache.put(path, drawable);
                return drawable;
            } catch (IllegalArgumentException e) {
                return drawable;
            }
        }
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void forceUpdateHomeTabs() {
        BLog.i(TAG, "forceUpdateHomeTabs");
        List<BasePrimaryMultiPageFragment.PageInfo> oldPages = getPageInfos();
        if (oldPages == null || getCurrentPage() >= oldPages.size()) {
            return;
        }
        BasePrimaryMultiPageFragment.PageInfo oldSelected = (BasePrimaryMultiPageFragment.PageInfo) getPageInfos().get(getCurrentPage());
        List<BasePrimaryMultiPageFragment.PageInfo> newPages = buildPages();
        int curPage = indexOf(oldSelected, newPages);
        clearAndAppend(newPages);
        setCurrentPage(curPage);
    }

    private void tryUpdateTabs() {
        if (MainResourceManager.getInstance().isHomeTabChange()) {
            forceUpdateHomeTabs();
        }
        if (MainResourceManager.getInstance().isCategoryChange()) {
            List<MoreCategoryItem> item = MainResourceManager.getInstance().getMoreCategoryItem();
            if (item == null || item.isEmpty()) {
                hideCategoryView();
            } else {
                showCategoryView();
            }
        }
    }

    private void tryReportShow() {
        if (MainResourceManager.getInstance().getAndResetHomeTabAPIFlag()) {
            List<BasePrimaryMultiPageFragment.PageInfo> pageInfos = getPageInfos();
            int n = pageInfos.size();
            for (int i = 0; i < n; i++) {
                BasePrimaryMultiPageFragment.PageInfo page = pageInfos.get(i);
                NavigationReporter.reportHomeTabShow(page);
            }
        }
    }

    private int indexOf(BasePrimaryMultiPageFragment.PageInfo oldPage, List<BasePrimaryMultiPageFragment.PageInfo> newPages) {
        int n = newPages.size();
        for (int i = 0; i < n; i++) {
            BasePrimaryMultiPageFragment.PageInfo info = newPages.get(i);
            if (info.id.equalsIgnoreCase(oldPage.id)) {
                return i;
            }
        }
        int i2 = this.mDefSelectedPage;
        return i2;
    }

    private void anchorTab(Intent intent) {
        if (intent == null) {
            return;
        }
        String tabName = intent.getStringExtra("tab_name");
        String tabId = intent.getStringExtra(MainTransaction.ARGS_ANCHOR_TAB_ID);
        if (TextUtils.isEmpty(tabName) && TextUtils.isEmpty(tabId)) {
            return;
        }
        List<BasePrimaryMultiPageFragment.PageInfo> pages = getPageInfos();
        int size = pages.size();
        for (int index = 0; index < size; index++) {
            BasePrimaryMultiPageFragment.PageInfo page = pages.get(index);
            if ((TextUtils.equals(Uri.decode(tabId), page.reporterId) && !TextUtils.isEmpty(tabId)) || (TextUtils.equals(Uri.decode(tabName), page.name) && !TextUtils.isEmpty(tabName))) {
                callbackAnchor(page, intent.getExtras());
                setCurrentPage(index);
                return;
            }
        }
    }

    private void tryShowHomeTabGuidance() {
        View tab;
        List<BasePrimaryMultiPageFragment.PageInfo> pages = getPageInfos();
        int size = pages.size();
        for (int index = 0; index < size; index++) {
            BasePrimaryMultiPageFragment.PageInfo page = pages.get(index);
            if (page != null && HomeCampusGuidanceWrapperKt.canShowCampusTabGuidance(page.url) && (tab = this.mTabs.getTabAt(index)) != null) {
                HomeTabQueueManager.INSTANCE.addGuidance(new HomeCampusGuidanceWrapper(this, tab, page));
            }
        }
        HomeTabQueueManager.INSTANCE.startGuidance();
    }

    private void tryShowTabBubble() {
        List<BasePrimaryMultiPageFragment.PageInfo> pages = getPageInfos();
        int size = pages.size();
        for (int index = 0; index < size; index++) {
            BasePrimaryMultiPageFragment.PageInfo page = pages.get(index);
            View anchor = this.mTabs.getTabAt(index);
            if (page != null && anchor != null && page.bubbles != null && TopTabBubbleDialogWrapperKt.showTopTabBubble(anchor, page.bubbles)) {
                return;
            }
        }
    }

    private void registerTabClickAnim() {
        List<BasePrimaryMultiPageFragment.PageInfo> pages = getPageInfos();
        boolean hasRegister = false;
        int size = pages.size();
        for (int index = 0; index < size; index++) {
            BasePrimaryMultiPageFragment.PageInfo page = pages.get(index);
            if (page != null && page.clickAnimation != null && page.clickAnimation.inInvalidTimeGap()) {
                if (!hasRegister) {
                    TopTabClickAnimKt.registerTopTabClickAnim();
                    hasRegister = true;
                }
                TopTabClickAnimKt.preloadResource(getContext(), page.clickAnimation);
            }
        }
    }

    private void callbackAnchor(final BasePrimaryMultiPageFragment.PageInfo page, final Bundle bundle) {
        if (this.mPager != null) {
            if (page.pageFragment == null) {
                page.mLifecycleObserver = new LifecycleObserver() { // from class: tv.danmaku.bili.ui.main2.HomeFragmentV2.10
                    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
                    public void onCreated(LifecycleOwner source) {
                        source.getLifecycle().removeObserver(this);
                        if (source instanceof IAnchorable) {
                            ((IAnchorable) source).onAnchored(bundle);
                        }
                        page.mLifecycleObserver = null;
                    }
                };
            } else if (page.pageFragment instanceof IAnchorable) {
                page.pageFragment.onAnchored(bundle);
            }
        }
    }

    public void onSkinChange(Garb skin) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        renderCategoryView(context);
        if (skin.isPure()) {
            if (!this.mIsTabColorUpdated) {
                Garb lastGarb = GarbManager.getGarbWithNightMode(context);
                if (!lastGarb.isPure()) {
                    changeUiWithGarb(lastGarb);
                    return;
                } else {
                    resetTabColor(0L);
                    return;
                }
            }
            return;
        }
        changeUiWithGarb(skin);
    }

    private void changeUiWithGarb(Garb skin) {
        if (!this.mIsTabColorUpdated || !skin.getChangeable()) {
            if (this.mAnimator != null && this.mAnimator.isStarted()) {
                this.mAnimator.end();
            }
            if (this.mBgImageAnimator != null && this.mBgImageAnimator.isStarted()) {
                this.mBgImageAnimator.end();
            }
            updateTabWihGarb(skin, 0L);
        }
    }

    public void onFragmentShow(Flag lastFlag) {
        super.onFragmentShow(lastFlag);
        if (getTopTabs() != null) {
            getTopTabs().requestLayout();
        }
        this.isFragmentHide = false;
        onPageVisibleStateChange();
        this.splashViewModel.getHomePageVisible().setValue(true);
        checkIfNeedUpdateEntrance();
        BLog.i(TAG, "onFragmentShow, lastFlag = " + lastFlag.name());
        if (lastFlag == Flag.FLAG_HIDDEN) {
            HomeLoginExpKt.checkShowOnePassLoginGuide(this, false);
        }
        this.hasReport = false;
        tryUpdateTabs();
        tryReportShow();
        HomeTabServiceImpl homeTabService = HomeTabServiceImplKt.getHomeTabServiceImpl();
        if (homeTabService != null) {
            homeTabService.onFragmentShow();
        }
        updateDefaultSearchWord(false, false);
        tryUpdateTabUi(this.mCurPageInfo, this.mCurPageExtraInfo, 0L);
        isAdded();
        updateAppbar();
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            this.hasReport = false;
        }
    }

    private void checkIfNeedUpdateEntrance() {
        if (EventEntranceHelper.needUpdate) {
            if (EventEntranceHelper.isChanged) {
                IMainFragmentHost parentFragment = getParentFragment();
                if (parentFragment instanceof IMainFragmentHost) {
                    parentFragment.updateEntranceMenu(0);
                    return;
                }
                return;
            }
            EventEntranceHelper.checkActivityEntrance(new Function0<Unit>() { // from class: tv.danmaku.bili.ui.main2.HomeFragmentV2.11
                public Unit invoke() {
                    if (!HomeFragmentV2.this.activityDie() && EventEntranceHelper.isChanged) {
                        IMainFragmentHost parentFragment2 = HomeFragmentV2.this.getParentFragment();
                        if (parentFragment2 instanceof IMainFragmentHost) {
                            parentFragment2.updateEntranceMenu(0);
                        }
                    }
                    return null;
                }
            });
        }
    }

    public void onSecondaryPageExtraInfoChange(SecondaryPageExtraInfo extraInfo, String url) {
        if (this.mCurPageInfo == null || !TextUtils.equals(this.mCurPageInfo.url, url)) {
            return;
        }
        this.mCurPageExtraInfo = extraInfo;
        tryUpdateTabUi(this.mCurPageInfo, extraInfo, 200L);
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class HomeTab implements RouteInterceptor {
        public RouteResponse intercept(RouteInterceptor.Chain chain) {
            RouteRequest request = chain.getRequest().newBuilder().extras(new Function1() { // from class: tv.danmaku.bili.ui.main2.HomeFragmentV2$HomeTab$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    return HomeFragmentV2.HomeTab.lambda$intercept$0((MutableBundleLike) obj);
                }
            }).build();
            return chain.next(request);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$intercept$0(MutableBundleLike extras) {
            Bundle args = new Bundle();
            args.putBoolean("key_main_tab_toolbar_scroll", true);
            args.putBoolean("key_main_tab_show_title", false);
            args.putBoolean("key_main_tab_show_search", true);
            args.putBoolean("key_main_toolbar_show_avatar", !TeenagersMode.getInstance().isEnable());
            args.putParcelable("key_main_tab_menu_provider", new HomeMenuDataProvider());
            extras.put("key_main_tab_config", args);
            return null;
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class HomeMenuDataProvider implements IOptionMenuProvider, Parcelable {
        public static final Parcelable.Creator<HomeMenuDataProvider> CREATOR = new Parcelable.Creator<HomeMenuDataProvider>() { // from class: tv.danmaku.bili.ui.main2.HomeFragmentV2.HomeMenuDataProvider.1
            @Override // android.os.Parcelable.Creator
            public HomeMenuDataProvider createFromParcel(Parcel in) {
                return new HomeMenuDataProvider(in);
            }

            @Override // android.os.Parcelable.Creator
            public HomeMenuDataProvider[] newArray(int size) {
                return new HomeMenuDataProvider[size];
            }
        };

        public HomeMenuDataProvider() {
        }

        public List<IOptionMenuItem> getMenuData(Context context) {
            List<IOptionMenuItem> menuItems = new ArrayList<>();
            List<MenuItem> menuInfo = MainResourceManager.getInstance().getHomeTopMenus();
            MainResourceManager.getInstance().setShowingHomeTopMenus(menuInfo);
            List<MenuItem> validMenuInfo = new ArrayList<>();
            for (MenuItem info : menuInfo) {
                if (info.checkParams() && isMenuEnable(info)) {
                    BaseBadgeOptionMenuItem.MenuItemInfo dynamicMenuInfo = new BaseBadgeOptionMenuItem.MenuItemInfo();
                    dynamicMenuInfo.name = info.title;
                    dynamicMenuInfo.url = info.url;
                    if (info.icon != null) {
                        dynamicMenuInfo.icon = info.icon.createDrawable();
                    }
                    dynamicMenuInfo.iconUrl = info.iconUrl;
                    dynamicMenuInfo.type = info.type;
                    dynamicMenuInfo.number = info.count;
                    dynamicMenuInfo.animatorIconUrl = info.animatorIconUrl;
                    dynamicMenuInfo.lottieJsonUrl = info.lottieJsonUrl;
                    DynamicMenuItem menuItem = new DynamicMenuItem(context, dynamicMenuInfo);
                    if (menuItem.checkParams()) {
                        menuItems.add(menuItem);
                    }
                    validMenuInfo.add(info);
                } else {
                    HomeTabReporterKt.reportMenuInvalid(info);
                }
            }
            HomeTabReporterKt.reportBuildMenu(validMenuInfo);
            if (EventEntranceHelper.hasEntrance()) {
                EventEntranceModel entranceInfo = EventEntranceHelper.entranceInfo;
                if (entranceInfo != null && entranceInfo.getOnline() != null && entranceInfo.checkParams()) {
                    BaseBadgeOptionMenuItem.MenuItemInfo menuItemInfo = new BaseBadgeOptionMenuItem.MenuItemInfo();
                    menuItemInfo.name = entranceInfo.getOnline().getName();
                    menuItemInfo.jumpUrl = entranceInfo.getOnline().getUri();
                    menuItemInfo.iconUrl = entranceInfo.getOnline().getIcon();
                    menuItemInfo.url = EventMenuAction.ACTION;
                    EventMenuItem menuItem2 = new EventMenuItem(context, menuItemInfo);
                    if (menuItem2.checkParams()) {
                        menuItems.add(0, menuItem2);
                    }
                }
                EventEntranceHelper.isChanged = false;
            }
            HomeFragmentV2.mMenus = menuItems;
            return menuItems;
        }

        public boolean isMenuDataChange() {
            return MainResourceManager.getInstance().isTopMenuChange() || (EventEntranceHelper.isChanged && EventEntranceHelper.animExecuted);
        }

        private boolean isMenuEnable(MenuItem info) {
            if (UriUtils.equals(info.url, "action://game_center/home/menu") && !OnlineParamsHelper.showGameCenterInToolbar()) {
                return false;
            }
            return true;
        }

        private HomeMenuDataProvider(Parcel in) {
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public class DefaultKeywordObserver implements Observer<Resource<IDefaultKeywordResult>> {
        public INavigationBarWatcher watcher;

        DefaultKeywordObserver() {
        }

        public void onChanged(Resource<IDefaultKeywordResult> result) {
            BLog.i(HomeFragmentV2.TAG, "DefaultKeywordObserver.onChanged");
            if (result.getStatus() == Status.SUCCESS && result.getData() != null && this.watcher != null) {
                IDefaultKeywordResult data = (IDefaultKeywordResult) result.getData();
                HomeFragmentV2.this.mDefaultWordLoading = false;
                if (data.isShowFront()) {
                    if (HomeFragmentV2.this.mCurPageInfo != null && !StringUtils.isBlank(HomeFragmentV2.this.mCurPageInfo.name)) {
                        data.setTabName(HomeFragmentV2.this.mCurPageInfo.name);
                    }
                    HomeTabServiceImpl homeTabService = HomeTabServiceImplKt.getHomeTabServiceImpl();
                    if (homeTabService != null && homeTabService.getTMRefreshTimes() > 0) {
                        data.setRefreshTimes(homeTabService.getTMRefreshTimes());
                    }
                    BLog.i(HomeFragmentV2.TAG, "DefaultKeywordObserver.onChanged.text = " + data.getShow());
                    HomeFragmentV2.this.mSearchDefaultWord = data;
                    if (HomeFragmentV2.this.hasZeroCard) {
                        this.watcher.updateZeroCardDefaultWord(HomeFragmentV2.this.mSearchDefaultWord);
                        this.watcher.updateSearchText(null);
                        return;
                    }
                    this.watcher.updateZeroCardDefaultWord(null);
                    this.watcher.updateSearchText(data);
                    NavigationReporter.reportSearchWordShow(data);
                    if (data.enableRefresh()) {
                        AutoRefreshQueue.INSTANCE.requestUntil(data.getRefreshIntervalMilli() + data.getAnimationTimeMilli(), HomeFragmentV2.this.getViewLifecycleOwner(), 1, new Function1() { // from class: tv.danmaku.bili.ui.main2.HomeFragmentV2$DefaultKeywordObserver$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                return HomeFragmentV2.DefaultKeywordObserver.this.m1931lambda$onChanged$0$tvdanmakubiliuimain2HomeFragmentV2$DefaultKeywordObserver((Integer) obj);
                            }
                        });
                        return;
                    }
                    return;
                }
                this.watcher.updateSearchText(null);
                return;
            }
            HomeFragmentV2.this.defaultKeywordUpdateError(this.watcher);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onChanged$0$tv-danmaku-bili-ui-main2-HomeFragmentV2$DefaultKeywordObserver  reason: not valid java name */
        public /* synthetic */ Unit m1931lambda$onChanged$0$tvdanmakubiliuimain2HomeFragmentV2$DefaultKeywordObserver(Integer refreshType) {
            HomeFragmentV2.this.getDefaultKeyword(false, refreshType.intValue());
            return null;
        }

        public void setWatcher(INavigationBarWatcher watcher) {
            this.watcher = watcher;
        }
    }
}