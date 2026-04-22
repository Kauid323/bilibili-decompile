package tv.danmaku.bili.ui.main2.basic;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.palette.graphics.Palette;
import androidx.viewpager.widget.ViewPager;
import bolts.Continuation;
import bolts.Task;
import com.alibaba.fastjson.JSON;
import com.bilibili.app.comm.list.common.api.IDefaultKeywordResult;
import com.bilibili.app.comm.list.common.data.MainTopBehavior;
import com.bilibili.app.comm.restrict.RestrictedMode;
import com.bilibili.app.comm.restrict.RestrictedType;
import com.bilibili.bus.Violet;
import com.bilibili.droid.ActivityUtils;
import com.bilibili.droid.StringUtil;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.homepage.HomeFragmentListener;
import com.bilibili.homepage.HomePageVisibilityEvent;
import com.bilibili.homepage.HomeSideCenterTab;
import com.bilibili.homepage.HomeTabService;
import com.bilibili.homepage.NavigationSelectionEvent;
import com.bilibili.lib.accountinfo.BiliAccountInfo;
import com.bilibili.lib.accountinfo.model.AccountInfo;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.subscribe.PassportObserver;
import com.bilibili.lib.accounts.subscribe.Topic;
import com.bilibili.lib.badge.Badge;
import com.bilibili.lib.badge.BadgeManager;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.blrouter.RouteResponse;
import com.bilibili.lib.btrace.BTrace;
import com.bilibili.lib.homepage.INewIntentCompat;
import com.bilibili.lib.homepage.IWindowFocusChanged;
import com.bilibili.lib.homepage.R;
import com.bilibili.lib.homepage.badge.IBadgeServer;
import com.bilibili.lib.homepage.home.model.ToolbarEvent;
import com.bilibili.lib.homepage.splash.BaseMainViewModel;
import com.bilibili.lib.homepage.splash.OffsetAndForceState;
import com.bilibili.lib.homepage.splash.SplashViewModel;
import com.bilibili.lib.homepage.startdust.HomeSlideTabManager;
import com.bilibili.lib.homepage.startdust.INavigationUserInfoSolution;
import com.bilibili.lib.homepage.startdust.OnPageSelectChangeListener;
import com.bilibili.lib.homepage.startdust.OnTopTabSelectChangeListener;
import com.bilibili.lib.homepage.startdust.PageReSelectedParams;
import com.bilibili.lib.homepage.startdust.menu.IOptionMenuItem;
import com.bilibili.lib.homepage.startdust.menu.IOptionMenuProvider;
import com.bilibili.lib.homepage.startdust.primary.ISlidingPageFragment;
import com.bilibili.lib.homepage.startdust.primary.ITabControlFragment;
import com.bilibili.lib.homepage.startdust.primary.PrimaryPageFragmentInfo;
import com.bilibili.lib.homepage.startdust.secondary.IScrollable;
import com.bilibili.lib.homepage.startdust.secondary.SecondaryPageExtension;
import com.bilibili.lib.homepage.startdust.secondary.SecondaryPageExtraInfo;
import com.bilibili.lib.homepage.util.AnimateResourceManager;
import com.bilibili.lib.homepage.util.BottomTabSelectedHelper;
import com.bilibili.lib.homepage.util.DpUtils;
import com.bilibili.lib.homepage.widget.HomeFloatViewHelper;
import com.bilibili.lib.homepage.widget.HomePagerSlidingTabStrip;
import com.bilibili.lib.homepage.widget.HomeTabPublishView;
import com.bilibili.lib.homepage.widget.MenuActionView;
import com.bilibili.lib.homepage.widget.SecondaryPagerSlidingTabStrip;
import com.bilibili.lib.homepage.widget.TabHost;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.ui.IDrawerHost;
import com.bilibili.lib.ui.RouteConstKt;
import com.bilibili.lib.ui.Target;
import com.bilibili.lib.ui.garb.Garb;
import com.bilibili.lib.ui.garb.GarbManager;
import com.bilibili.lib.ui.garb.GarbWatcher;
import com.bilibili.lib.ui.mixin.Flag;
import com.bilibili.lib.ui.mixin.IFragmentShowHide;
import com.bilibili.lib.ui.util.MultipleThemeUtils;
import com.bilibili.lib.ui.util.StatusBarCompat;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.magicasakura.widgets.TintAppBarLayout;
import com.bilibili.magicasakura.widgets.TintImageView;
import com.bilibili.magicasakura.widgets.TintLinearLayout;
import com.bilibili.moduleservice.upper.UperLogInterface;
import com.bilibili.moduleservice.upper.UpperCenterPlusBubbleService;
import com.bilibili.teenagersmode.TeenagersMode;
import com.bilibili.teenagersmode.utils.TeenagersModeConfigKt;
import com.google.android.material.appbar.AppBarLayout;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.MainActivityV2;
import tv.danmaku.bili.appwidget.hotlist.model.HotListDataPacker;
import tv.danmaku.bili.appwidget.upcard.UpCardAppWidget;
import tv.danmaku.bili.appwidget.upcard.UpCardAppWidgetKt;
import tv.danmaku.bili.core.test.FdDebugActivity;
import tv.danmaku.bili.quick.core.OnePassLoginReportManagerKt;
import tv.danmaku.bili.ui.DisplayUtils;
import tv.danmaku.bili.ui.loginv2.LoginOriginalActivityV2;
import tv.danmaku.bili.ui.main.event.EventEntranceHelper;
import tv.danmaku.bili.ui.main.usergrow.UserGrowManager;
import tv.danmaku.bili.ui.main2.BottomBubbleHelper;
import tv.danmaku.bili.ui.main2.HomeReportHelper;
import tv.danmaku.bili.ui.main2.MainPagerFragmentV2;
import tv.danmaku.bili.ui.main2.MainTransaction;
import tv.danmaku.bili.ui.main2.basic.AppBarStateChangeListener;
import tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment;
import tv.danmaku.bili.ui.main2.basic.PrimaryPageManager;
import tv.danmaku.bili.ui.main2.basic.dialog.publish.PublishBubbleDialogKt;
import tv.danmaku.bili.ui.main2.basic.dialog.publish.PublishBubblePopupWindowKt;
import tv.danmaku.bili.ui.main2.basic.story.HomeStoryEntranceAnimationKt;
import tv.danmaku.bili.ui.main2.basic.story.HomeStoryEntranceServiceImpl;
import tv.danmaku.bili.ui.main2.basic.story.HomeStoryEntranceServiceImplKt;
import tv.danmaku.bili.ui.main2.basic.story.HomeTopLeftClickGuidance;
import tv.danmaku.bili.ui.main2.basic.story.HomeTopLeftClickGuidanceKt;
import tv.danmaku.bili.ui.main2.basic.story.HomeTopLeftStateHolderKt;
import tv.danmaku.bili.ui.main2.basic.story.SideCenterPageListener;
import tv.danmaku.bili.ui.main2.basic.story.StoryExitAnimationListener;
import tv.danmaku.bili.ui.main2.event.EventMenuActionView;
import tv.danmaku.bili.ui.main2.event.EventMenuItem;
import tv.danmaku.bili.ui.main2.reporter.MineReporter;
import tv.danmaku.bili.ui.main2.reporter.NavigationReporter;
import tv.danmaku.bili.ui.main2.resource.DefaultResourceResolver;
import tv.danmaku.bili.ui.main2.resource.HomeNoLoginAvatar;
import tv.danmaku.bili.ui.main2.resource.HomeTabServiceImpl;
import tv.danmaku.bili.ui.main2.resource.HomeTabServiceImplKt;
import tv.danmaku.bili.ui.main2.resource.MainFragmentOperator;
import tv.danmaku.bili.ui.main2.resource.MainFragmentService;
import tv.danmaku.bili.ui.main2.resource.MainResourceManager;
import tv.danmaku.bili.ui.main2.resource.PrimaryPage;
import tv.danmaku.bili.ui.main2.widget.HomeAppBarLayout;
import tv.danmaku.bili.widget.PinnedBottomScrollingBehavior;
import tv.danmaku.bili.widget.SwitchTextView;
import tv.danmaku.bili.widget.VerifyAnimationAvatarFrameLayout;

public abstract class BaseMainFrameFragment extends MainPagerFragmentV2 implements INewIntentCompat, PassportObserver, IMainFragmentHost, SecondaryPagerSlidingTabStrip.TabDotConfig, GarbWatcher.Observer, SecondaryPagerSlidingTabStrip.OnTabLayoutCompleteListener, MainResourceManager.IMenuChangeListener, HomeFloatViewHelper.IHomeFloatListener, IFragmentShowHide, IWindowFocusChanged, MainFragmentOperator {
    private static final String FORCE_UPDATE_HOME_TABS = "force_update_home_tabs";
    private static final String SEARCH_FLAG = "search";
    private static final String SEARCH_HOME_ROUTER = "SearchHomeRouter";
    private static final String TAG = "home.main.base";
    private View content;
    private ValueAnimator mAnimator;
    protected TintAppBarLayout mAppBarLayout;
    private View mAvatarLayout;
    private BiliImageView mAvatarRect;
    private BiliImageView mAvatarRectBg;
    private FrameLayout mAvatarRectContainer;
    private String mAvatarUrl;
    protected BaseMainViewModel mBaseMainViewModel;
    private ValueAnimator mBgImageAnimator;
    private IBottomTabDataProvider mBottomDataProvider;
    private TabHost mBottomNav;
    private Drawable mCurrentBgDrawable;
    private int mCurrentBgEndColor;
    private int mCurrentBgStartColor;
    private long mCurrentGarbId;
    private TintLinearLayout mExpandSearch;
    private HomeFloatViewHelper mHomeFloatViewHelper;
    private HomeNoLoginAvatar mHomeNoLoginAvatar;
    private int mIconColor;
    private TintImageView mIconTeenUmbrella;
    private PinnedBottomScrollingBehavior mMainBehavior;
    private ImageView mMainTopBgImageView;
    private FrameLayout mMainTopLayout;
    private GradientDrawable mMainTopLayoutBgDrawable;
    protected TabHostHelper mNavViewHelper;
    private INavigationUserInfoSolution mNavigationBadgeSolution;
    private ToolbarCenterTextView mNickName;
    private PrimaryPageManager mPageManager;
    private TintImageView mSearchIcon;
    private SwitchTextView mSearchTextView;
    private SplashViewModel mSplashViewModel;
    private HomePagerSlidingTabStrip mTabs;
    private Intent mTempIntent;
    protected Toolbar mToolbar;
    private VerifyAnimationAvatarFrameLayout mVerifyAvatar;
    private IDefaultKeywordResult mSearchDefaultWord = null;
    protected IDefaultKeywordResult mZeroCardSearchDefaultWord = null;
    private List<NavigationInfo> mNavigationInfo = new ArrayList();
    private Map<NavigationInfo, BadgeManager.OnChangedListener> mListenerMap = new HashMap();
    private boolean mIsToolbarColorUpdated = false;
    private int[] mBgColors = new int[2];
    private Map<String, BitmapDrawable> mBgDrawableCache = new HashMap();
    private boolean isFirstStart = true;
    private int statusBarHeight = 0;
    private boolean mIsFirst = false;
    private final TabHostGarbProvider mTabGarbProvider = new TabHostGarbProvider();
    private boolean mShowAvatar = true;
    private final boolean ffSearchBar2Exp1 = ConfigManager.isHitFF("ff_search_bar_ui_exp1");
    private final boolean ffSearchBar2Exp2 = ConfigManager.isHitFF("ff_search_bar_ui_exp2");
    private boolean isFirstResume = true;
    private boolean isSplashShowing = true;
    private boolean isHasShowGameBubble = false;
    private final HomeFragmentListener homeFragmentListener = new HomeFragmentListener() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment.1
        public void onViewCreated(LifecycleCoroutineScope scope) {
        }

        public void onHide() {
        }

        public void onShow() {
            if (!BaseMainFrameFragment.this.isFirstResume) {
                BaseMainFrameFragment.this.syncToolBarAvatar("homeTabShow");
                HomeTopLeftStateHolderKt.setLastIsSideCenterPage(false);
            }
            BaseMainFrameFragment.this.isFirstResume = false;
        }
    };
    private final StoryExitAnimationListener mStoryExitAnimationListener = new StoryExitAnimationListener() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment.3
        @Override // tv.danmaku.bili.ui.main2.basic.story.StoryExitAnimationListener
        public void onStoryExitAnimationStart() {
            if (BaseMainFrameFragment.this.mAppBarLayout != null && BaseMainFrameFragment.this.mVerifyAvatar != null && BaseMainFrameFragment.this.mAvatarRectBg != null && BaseMainFrameFragment.this.mAvatarRect != null) {
                BaseMainFrameFragment.this.mBaseMainViewModel.update(new ToolbarEvent.ExpandToolbar(true, false));
                MainResourceManager.TopLeftInfo info = HomeTopLeftStateHolderKt.getTopLeftInfo();
                if (info != null && info.hitAvatarAndStoryBadgeExp()) {
                    HomeAvatarHelper.setAvatarRectRes(BaseMainFrameFragment.this.mAvatarRectBg, BaseMainFrameFragment.this.mAvatarRect, info);
                    HomeAvatarHelper.startStoryExitAnimation(BaseMainFrameFragment.this.mVerifyAvatar, BaseMainFrameFragment.this.mAvatarRectContainer);
                }
            }
        }
    };
    private SecondaryPagerSlidingTabStrip.PageReselectedListener mTopPageReselectedListener = new SecondaryPagerSlidingTabStrip.PageReselectedListener() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment.4
        public /* synthetic */ void onReselected(int i, View view, Bundle bundle) {
            SecondaryPagerSlidingTabStrip.PageReselectedListener.-CC.$default$onReselected(this, i, view, bundle);
        }

        public void onReselected(int position) {
            OnTopTabSelectChangeListener curIPrimaryPageFragment = BaseMainFrameFragment.this.mPageManager.getCurIPrimaryPageFragment();
            if (curIPrimaryPageFragment instanceof OnTopTabSelectChangeListener) {
                curIPrimaryPageFragment.onTabReselect(position);
            }
        }
    };
    private TabHost.OnSelectChangedListener mSelectChangedListener = new AnonymousClass8();
    boolean needAppendOffset = false;
    protected final AppBarStateChangeListener mOffsetListener = new AppBarStateChangeListener() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment.17
        @Override // tv.danmaku.bili.ui.main2.basic.AppBarStateChangeListener
        public void onStateChanged(AppBarLayout appBarLayout, AppBarStateChangeListener.State state) {
            if (state == AppBarStateChangeListener.State.EXPANDED) {
                BaseMainFrameFragment.this.tryReportDefaultSearchWordShow();
            }
            BLog.i(BaseMainFrameFragment.TAG, "mOffsetListener.onStateChanged, state = " + state.name());
            BaseMainFrameFragment.this.mBaseMainViewModel.isExpanded().setValue(Boolean.valueOf(state == AppBarStateChangeListener.State.EXPANDED));
            if (BaseMainFrameFragment.this.mBottomNav.getCurrentItem() == 0) {
                if (state == AppBarStateChangeListener.State.EXPANDED) {
                    BaseMainFrameFragment.this.needAppendOffset = false;
                } else if (state == AppBarStateChangeListener.State.COLLAPSED) {
                    BaseMainFrameFragment.this.needAppendOffset = true;
                }
            }
        }

        @Override // tv.danmaku.bili.ui.main2.basic.AppBarStateChangeListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
            super.onOffsetChanged(appBarLayout, verticalOffset);
            if (BaseMainFrameFragment.this.mMainTopLayout != null) {
                BaseMainFrameFragment.this.mMainTopLayout.setTranslationY(verticalOffset);
            }
            if (BaseMainFrameFragment.this.mToolbar != null) {
                int range = appBarLayout.getTotalScrollRange();
                float percent = ((range + verticalOffset) * 1.0f) / appBarLayout.getTotalScrollRange();
                if (range == 0) {
                    percent = 1.0f;
                }
                if (appBarLayout instanceof HomeAppBarLayout) {
                    boolean forceState = ((HomeAppBarLayout) appBarLayout).popForceState();
                    BaseMainFrameFragment.this.mBaseMainViewModel.getAppbarOffsetPercentLiveData().setValue(new OffsetAndForceState(Float.valueOf(1.0f - percent), forceState));
                }
                BaseMainFrameFragment.this.mBaseMainViewModel.getAppbarOffset().setValue(Integer.valueOf(range - Math.abs(verticalOffset)));
                BaseMainFrameFragment.this.mBaseMainViewModel.getAppbarVerticalOffset().setValue(Integer.valueOf(verticalOffset));
                BaseMainFrameFragment.this.mToolbar.setAlpha(percent);
            }
        }
    };
    private HomeSlideTabManager.TabController onTabRefreshListener = new HomeSlideTabManager.TabController() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment.18
        public void onTabRefresh(String key) {
            NavigationInfo navigationInfo = BaseMainFrameFragment.this.findCurrentNavigation();
            BaseMainFrameFragment.this.initToolbar(navigationInfo);
        }

        public void onDotChange(String key, int tabPosition) {
            if (key.equals(BaseMainFrameFragment.this.mPageManager.getCurPageUrl()) && BaseMainFrameFragment.this.mTabs.getVisibility() == 0) {
                BaseMainFrameFragment.this.mTabs.changeDot(tabPosition);
            }
        }

        public String getTabTitle(String key) {
            NavigationInfo navigationInfo = BaseMainFrameFragment.this.findNavigation(key);
            if (navigationInfo != null) {
                return navigationInfo.getDisplayTitle();
            }
            return null;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface IBottomTabDataProvider {
        List<NavigationInfo> getNavigationInfo();

        boolean isNavigationDataChange();
    }

    protected abstract IBottomTabDataProvider onCreateBottomDataProvider();

    protected abstract INavigationUserInfoSolution onCreateNavigationBadgeSolution();

    public void onFloatViewDismissListener() {
    }

    public void onFloatViewShowListener(List<? extends TabHost.TabInfo.DialogItem> dialogItems) {
        for (TabHost.TabInfo.DialogItem item : dialogItems) {
            if (item != null) {
                NavigationReporter.reportHomeSubTabShow(item.name, String.valueOf(item.id), item.mngIconId);
            }
        }
    }

    public void onFloatItemClickListener(int index, TabHost.TabInfo.DialogItem dialogItem) {
        NavigationReporter.reportHomeSubTabClick(dialogItem.name, String.valueOf(dialogItem.id), dialogItem.mngIconId);
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class NavigationInfo {
        private int mMenuId;
        private PrimaryPage mPage;
        private PrimaryPageFragmentInfo mPageInfo;
        private int mPosition;

        public NavigationInfo(Activity activity, PrimaryPage page) {
            this.mMenuId = page.url.hashCode();
            this.mPage = page;
            if (page.isPublish) {
                this.mPageInfo = new PrimaryPageFragmentInfo.Builder().isPublish(true).build();
                return;
            }
            Target target = RouteConstKt.findRoute(BLRouter.INSTANCE, RouteRequestKt.toRouteRequest(this.mPage.url));
            if (target == null) {
                BLog.e("route not found for scheme: " + this.mPage.url);
            } else if (!Fragment.class.isAssignableFrom(target.getClazz())) {
                BLog.e("scheme " + this.mPage.url + " is not Fragment");
            } else {
                Bundle args = target.getArgs().getBundle("key_main_tab_config");
                if (args == null) {
                    args = new Bundle();
                } else {
                    target.getArgs().remove("key_main_tab_config");
                }
                PrimaryPageFragmentInfo.Builder builder = new PrimaryPageFragmentInfo.Builder().pageClass(target.getClazz()).pageArgs(target.getArgs()).badgeServer(args.getParcelable("key_main_tab_badge_server")).enableToolbarScroll(args.getBoolean("key_main_tab_toolbar_scroll", true)).showTitle(args.getBoolean("key_main_tab_show_title", true)).showExpandSearch(args.getBoolean("key_main_tab_show_search", false)).showAvatar(args.getBoolean("key_main_toolbar_show_avatar", false)).showAppbarLayout(args.getBoolean("key_main_toolbar_show_appbar_layout", true)).showGarbBg(args.getBoolean("key_main_toolbar_show_garb_bg", true)).isPublish(page.isPublish);
                IOptionMenuProvider menuProvider = args.getParcelable("key_main_tab_menu_provider");
                if (menuProvider != null) {
                    builder.menuItems(menuProvider.getMenuData(activity));
                    builder.menuProvider(menuProvider);
                }
                this.mPageInfo = builder.build();
            }
        }

        public boolean checkParams() {
            return (this.mPage != null && this.mPage.isPublish) || this.mPageInfo != null;
        }

        public String getDisplayTitle() {
            if (this.mPageInfo.isShowTitle()) {
                return this.mPage.title;
            }
            return null;
        }

        public TabHost.TabInfo createTabInfo() {
            TabHost.TabInfo tabInfo = new TabHost.TabInfo();
            tabInfo.id = this.mMenuId;
            tabInfo.title = this.mPage.title;
            tabInfo.tabId = this.mPage.id;
            tabInfo.reportId = this.mPage.reporterId;
            if (this.mPage.icon != null) {
                tabInfo.mIcon = this.mPage.icon.createDrawable();
            }
            tabInfo.normalIconUrl = this.mPage.normalIcon;
            tabInfo.selectedIconUrl = this.mPage.selectedIcon;
            tabInfo.url = this.mPage.url;
            tabInfo.isPublish = this.mPage.isPublish;
            if (tabInfo.isPublish) {
                tabInfo.dialogItems.clear();
                if (this.mPage.dialogItems != null && this.mPage.dialogItems.size() > 0) {
                    for (MainResourceManager.DialogItem item : this.mPage.dialogItems) {
                        if (item.isValid()) {
                            TabHost.TabInfo.DialogItem tabItem = new TabHost.TabInfo.DialogItem();
                            tabItem.id = item.id;
                            tabItem.iconUrl = item.iconUrl;
                            tabItem.name = item.name;
                            tabItem.uri = item.uri;
                            tabItem.pos = item.pos;
                            tabItem.iconRes = item.defaultIconRes;
                            MainResourceManager.DialogMngItem dialogMngItem = item.dialogMngItem;
                            if (dialogMngItem != null) {
                                tabItem.mngIconId = dialogMngItem.id;
                                tabItem.mngIconUrl = dialogMngItem.mngIconUrl;
                                tabItem.mngInValidEndTime = dialogMngItem.inValidEndTime;
                                tabItem.mngInValidStartTime = dialogMngItem.inValidStartTime;
                            }
                            tabInfo.dialogItems.add(tabItem);
                        }
                    }
                    if (tabInfo.dialogItems.size() == 0 || tabInfo.dialogItems.size() > 4) {
                        tabInfo.dialogItems.clear();
                        createDefaultTabHostDialogItems(tabInfo);
                    }
                } else if (StringUtil.isBlank(tabInfo.url)) {
                    tabInfo.url = DefaultResourceResolver.BOTTOM_PUBLISH_URL;
                }
            }
            return tabInfo;
        }

        private void createDefaultTabHostDialogItems(TabHost.TabInfo tabInfo) {
            List<MainResourceManager.DialogItem> defaultItems = DefaultResourceResolver.forDefaultDialogItems();
            if (defaultItems != null) {
                for (MainResourceManager.DialogItem item : defaultItems) {
                    TabHost.TabInfo.DialogItem tabItem = new TabHost.TabInfo.DialogItem();
                    tabItem.id = item.id;
                    tabItem.iconUrl = item.iconUrl;
                    tabItem.name = item.name;
                    tabItem.uri = item.uri;
                    tabItem.pos = item.pos;
                    tabItem.iconRes = item.defaultIconRes;
                    tabInfo.dialogItems.add(tabItem);
                }
            }
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getActivity() != null) {
            this.mSplashViewModel = new ViewModelProvider(getActivity()).get(SplashViewModel.class);
            this.mBaseMainViewModel = new ViewModelProvider(getActivity()).get(BaseMainViewModel.class);
            MainResourceManager.getInstance().setMenuChangeListener(this);
        }
        this.mBottomDataProvider = onCreateBottomDataProvider();
        fill(this.mBottomDataProvider.getNavigationInfo(), this.mNavigationInfo);
        this.mNavigationBadgeSolution = onCreateNavigationBadgeSolution();
        Violet.INSTANCE.ofChannel(TabBottomDataUpdateEvent.class).observe(this, new Observer() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment$$ExternalSyntheticLambda18
            public final void onChanged(Object obj) {
                BaseMainFrameFragment.this.updatePublishView((TabBottomDataUpdateEvent) obj);
            }
        });
        Violet.INSTANCE.ofChannel(MainTopBehavior.class).observe(this, new Observer() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment$$ExternalSyntheticLambda19
            public final void onChanged(Object obj) {
                BaseMainFrameFragment.this.updateMainAppBarExpand((MainTopBehavior) obj);
            }
        });
        Violet.INSTANCE.ofChannel(TabTopLeftDataUpdateEvent.class).observe(this, new Observer() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment$$ExternalSyntheticLambda20
            public final void onChanged(Object obj) {
                BaseMainFrameFragment.this.updateAvatar((TabTopLeftDataUpdateEvent) obj);
            }
        });
        HomeTabService homeTabService = (HomeTabService) BLRouter.INSTANCE.get(HomeTabService.class, "HOME_TAB_SERVICE");
        if (homeTabService != null) {
            homeTabService.registerHomeFragmentListener(this.homeFragmentListener);
        }
        HomeTopLeftStateHolderKt.registerSideCenterPageListener(this, new SideCenterPageListener() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment$$ExternalSyntheticLambda21
            @Override // tv.danmaku.bili.ui.main2.basic.story.SideCenterPageListener
            public final void onExitPage() {
                BaseMainFrameFragment.lambda$onCreate$0();
            }
        });
        if (savedInstanceState == null && homeTabService != null && getActivity() != null && getActivity().getIntent() != null && getActivity().getIntent().getExtras() != null && "1".equals(getActivity().getIntent().getExtras().getString(FORCE_UPDATE_HOME_TABS, ""))) {
            MainFragmentService.INSTANCE.forceUpdateBottomNav(getLifecycle());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onCreate$0() {
        BLog.i(TAG, "registerSideCenterPageListener, exit side center");
        HomeTopLeftStateHolderKt.setLastIsSideCenterPage(true);
    }

    public void onDestroy() {
        super.onDestroy();
        HomeTabService homeTabService = (HomeTabService) BLRouter.INSTANCE.get(HomeTabService.class, "HOME_TAB_SERVICE");
        if (homeTabService != null) {
            homeTabService.unregisterHomeFragmentListener(this.homeFragmentListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAvatar(TabTopLeftDataUpdateEvent event) {
        if (MainResourceManager.getInstance().isTopLeftChange()) {
            BLog.i(TAG, "top left changed syncToolBarAvatar");
            syncToolBarAvatar("topleft data update");
            MainResourceManager.getInstance().markTopLeftNotChange();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePublishView(TabBottomDataUpdateEvent publishUpdateEvent) {
        PrimaryPage publishPage = publishUpdateEvent != null ? publishUpdateEvent.publishPage : null;
        if (publishPage != null) {
            BLog.i(TAG, "updatePublishView");
            NavigationInfo nav = new NavigationInfo(getActivity(), publishPage);
            if (nav.checkParams() && this.mBottomNav != null && this.mBottomNav.getTabs() != null) {
                for (int i = 0; i < this.mBottomNav.getTabs().size(); i++) {
                    if (((TabHost.TabInfo) this.mBottomNav.getTabs().get(i)).isPublish) {
                        HomeTabPublishView findViewById = this.mBottomNav.getItemView(i).findViewById(R.id.home_publish_icon);
                        if (findViewById instanceof HomeTabPublishView) {
                            HomeTabPublishView tabPublishView = findViewById;
                            if (this.mHomeFloatViewHelper != null && tabPublishView.isFold()) {
                                return;
                            }
                            TabHost.TabInfo oldTab = tabPublishView.getMTabIfo();
                            TabHost.TabInfo newTab = nav.createTabInfo();
                            if (oldTab != null) {
                                oldTab.dialogItems = newTab.dialogItems;
                                oldTab.url = newTab.url;
                                if (!TextUtils.equals(oldTab.normalIconUrl, newTab.normalIconUrl)) {
                                    oldTab.normalIconUrl = newTab.normalIconUrl;
                                    tabPublishView.refreshUi();
                                }
                                BLog.i(TAG, "showPublishBubble from update");
                                LifecycleOwner viewOwner = (LifecycleOwner) getViewLifecycleOwnerLiveData().getValue();
                                if (viewOwner != null) {
                                    PublishBubbleDialogKt.showPublishBubbleInLifecycleScope(viewOwner, this.mBottomNav, oldTab.url);
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
    }

    private <T> void fill(Collection<T> from, Collection<T> to) {
        if (from == null || to == null) {
            return;
        }
        to.clear();
        to.addAll(from);
    }

    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(tv.danmaku.bili.R.layout.bili_app_fragment_main, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MainFragmentService.INSTANCE.setOperator(this, this);
        initComponent(view);
        BaseMainFrameComponentKt.observerAppbar(this);
        ViewCompat.setElevation(this.mToolbar, 0.0f);
        buildNavigation(savedInstanceState);
        initStoryEntranceService();
        if (savedInstanceState == null) {
            NavigationInfo nav = findAnchorNavigation();
            if (nav == null) {
                nav = this.mNavigationInfo.get(0);
            }
            String action = nav.mPage.url;
            int index = this.mNavigationInfo.indexOf(nav);
            if (getActivity() != null && nav.mPage.title != null) {
                BTrace.updatePageInfo(nav.mPage.title, getActivity());
            }
            this.mBottomNav.setCurrentItem(index);
            switchToNavigation(action);
        }
        initBadges();
        this.mAppBarLayout.addOnOffsetChangedListener(this.mOffsetListener);
        if (this.mNavigationBadgeSolution != null) {
            this.mNavigationBadgeSolution.onCreate();
        }
        BiliAccounts.get(getActivity()).subscribeAllWithSwitch(this);
        if (this.mSplashViewModel != null) {
            this.mSplashViewModel.getSplashExit().observe(getViewLifecycleOwner(), new AnonymousClass2());
        }
        HomeSlideTabManager.getInstance().setTabController(this.onTabRefreshListener);
        if (this.mTabs != null) {
            this.mTabs.setOnPageReselectedListener(this.mTopPageReselectedListener);
            this.mTabs.setTabDotConfig(this);
        }
        this.mIsFirst = true;
        this.mSplashViewModel.getHomePageVisible().observe(getViewLifecycleOwner(), new Observer() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment$$ExternalSyntheticLambda15
            public final void onChanged(Object obj) {
                BaseMainFrameFragment.this.m2002lambda$onViewCreated$1$tvdanmakubiliuimain2basicBaseMainFrameFragment((Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment$2  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public class AnonymousClass2 implements Observer<SplashViewModel.SplashExitInfo> {
        AnonymousClass2() {
        }

        public void onChanged(SplashViewModel.SplashExitInfo splashExitInfo) {
            if (BaseMainFrameFragment.this.isSplashEnd(splashExitInfo)) {
                BaseMainFrameFragment.this.isSplashShowing = false;
                BaseMainFrameFragment.this.notifySplashExit();
            }
            if (splashExitInfo != null && splashExitInfo.exitWithJump) {
                return;
            }
            BaseMainFrameFragment.this.mBottomNav.post(new Runnable() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    BaseMainFrameFragment.AnonymousClass2.this.m2013lambda$onChanged$1$tvdanmakubiliuimain2basicBaseMainFrameFragment$2();
                }
            });
            if (EventEntranceHelper.isChecked) {
                BaseMainFrameFragment.this.updateEntranceMenu(0);
            } else {
                EventEntranceHelper.registerListener(new Function0() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment$2$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        return BaseMainFrameFragment.AnonymousClass2.this.m2014lambda$onChanged$2$tvdanmakubiliuimain2basicBaseMainFrameFragment$2();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onChanged$1$tv-danmaku-bili-ui-main2-basic-BaseMainFrameFragment$2  reason: not valid java name */
        public /* synthetic */ void m2013lambda$onChanged$1$tvdanmakubiliuimain2basicBaseMainFrameFragment$2() {
            BottomBubbleHelper.checkShowBubble(BaseMainFrameFragment.this.getActivity(), BaseMainFrameFragment.this.mBottomNav, BaseMainFrameFragment.this.mNavViewHelper, new BottomBubbleHelper.GetBubbleCallback() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment$2$$ExternalSyntheticLambda2
                @Override // tv.danmaku.bili.ui.main2.BottomBubbleHelper.GetBubbleCallback
                public final void onGetFinish() {
                    BaseMainFrameFragment.AnonymousClass2.this.m2012lambda$onChanged$0$tvdanmakubiliuimain2basicBaseMainFrameFragment$2();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onChanged$0$tv-danmaku-bili-ui-main2-basic-BaseMainFrameFragment$2  reason: not valid java name */
        public /* synthetic */ void m2012lambda$onChanged$0$tvdanmakubiliuimain2basicBaseMainFrameFragment$2() {
            BaseMainFrameFragment.this.isFirstStart = false;
            if (BaseMainFrameFragment.this.activityDie() || BaseMainFrameFragment.this.isDetached()) {
                return;
            }
            int n = BaseMainFrameFragment.this.mNavigationInfo.size();
            for (int i = 0; i < n; i++) {
                NavigationInfo navInfo = (NavigationInfo) BaseMainFrameFragment.this.mNavigationInfo.get(i);
                if (navInfo.mPage != null) {
                    TabHost.TabInfo tabInfo = null;
                    if (BaseMainFrameFragment.this.mBottomNav != null && BaseMainFrameFragment.this.mBottomNav.getTabs() != null && BaseMainFrameFragment.this.mBottomNav.getTabs().size() > i) {
                        tabInfo = (TabHost.TabInfo) BaseMainFrameFragment.this.mBottomNav.getTabs().get(i);
                    }
                    String str = navInfo.mPage.title;
                    long j = 0;
                    if (tabInfo != null && tabInfo.bubbleId > 0) {
                        j = tabInfo.bubbleId;
                    }
                    NavigationReporter.reportMainTabShow(str, j);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onChanged$2$tv-danmaku-bili-ui-main2-basic-BaseMainFrameFragment$2  reason: not valid java name */
        public /* synthetic */ Unit m2014lambda$onChanged$2$tvdanmakubiliuimain2basicBaseMainFrameFragment$2() {
            BaseMainFrameFragment.this.updateEntranceMenu(0);
            EventEntranceHelper.unregisterListener();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onViewCreated$1$tv-danmaku-bili-ui-main2-basic-BaseMainFrameFragment  reason: not valid java name */
    public /* synthetic */ void m2002lambda$onViewCreated$1$tvdanmakubiliuimain2basicBaseMainFrameFragment(Boolean visible) {
        BLog.i(TAG, "homepage visible state change = " + visible);
        tryReportDefaultSearchWordShow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryReportDefaultSearchWordShow() {
        Boolean homeVisible = (Boolean) this.mSplashViewModel.getHomePageVisible().getValue();
        if (homeVisible == null || !homeVisible.booleanValue()) {
            BLog.i(TAG, "tryReportDefaultSearchWordShow, error, home page not visible");
        } else if (!isSplashEnd((SplashViewModel.SplashExitInfo) this.mSplashViewModel.getSplashExit().getValue())) {
            BLog.i(TAG, "tryReportDefaultSearchWordShow, error, splash not exit");
        } else if (this.mOffsetListener.getCurrentState() != AppBarStateChangeListener.State.EXPANDED) {
            BLog.i(TAG, "tryReportDefaultSearchWordShow, error, search bar not expand");
        } else if (this.mSearchDefaultWord == null || this.mSearchDefaultWord.isExposed()) {
            BLog.i(TAG, "tryReportDefaultSearchWordShow, error, mSearchDefaultWord is null or word exposed");
        } else {
            BLog.i(TAG, "tryReportDefaultSearchWordShow, report , text = " + this.mSearchDefaultWord.getShow());
            this.mSearchDefaultWord.setExposed(true);
            NavigationReporter.reportSearchWordShow2(this.mSearchDefaultWord);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifySplashExit() {
        PublishBubbleDialogKt.setSplashExitTime(System.currentTimeMillis());
        HomeAvatarHelper.notifySplashExit();
        showTopLeftClickGuidance();
        tryReportDefaultSearchWordShow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isSplashEnd(SplashViewModel.SplashExitInfo splashExitInfo) {
        return splashExitInfo != null && (splashExitInfo.getAnimState() == 0 || splashExitInfo.getAnimState() == 2);
    }

    private void initStoryEntranceService() {
        HomeStoryEntranceServiceImpl service = HomeStoryEntranceServiceImplKt.getStoryEntranceServiceImpl();
        updateEntranceRect();
        if (service != null) {
            service.setListener(this.mStoryExitAnimationListener);
        }
    }

    private void updateEntranceRect() {
        final HomeStoryEntranceServiceImpl service = HomeStoryEntranceServiceImplKt.getStoryEntranceServiceImpl();
        MainResourceManager.TopLeftInfo info = HomeTopLeftStateHolderKt.getTopLeftInfo();
        VerifyAnimationAvatarFrameLayout verifyAnimationAvatarFrameLayout = null;
        if (info != null && info.hitAvatarAndStoryBadgeExp()) {
            verifyAnimationAvatarFrameLayout = this.mVerifyAvatar;
        }
        if (verifyAnimationAvatarFrameLayout == null) {
            return;
        }
        final VerifyAnimationAvatarFrameLayout verifyAnimationAvatarFrameLayout2 = verifyAnimationAvatarFrameLayout;
        OneShotPreDrawListener.add(verifyAnimationAvatarFrameLayout, new Runnable() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                BaseMainFrameFragment.lambda$updateEntranceRect$2(HomeStoryEntranceServiceImpl.this, verifyAnimationAvatarFrameLayout2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$updateEntranceRect$2(HomeStoryEntranceServiceImpl service, View finalAnchorView) {
        if (service != null) {
            int[] location = new int[2];
            finalAnchorView.getLocationInWindow(location);
            service.setEntranceRect(new Rect(location[0], location[1], location[0] + finalAnchorView.getWidth(), location[1] + finalAnchorView.getHeight()));
        }
    }

    public void onChange(Topic topic) {
        BottomBubbleHelper.onChange(topic);
        if (topic == Topic.SIGN_IN || topic == Topic.SIGN_OUT || topic == Topic.ACCOUNT_INFO_UPDATE || topic == Topic.ACCOUNT_SWITCH) {
            syncToolBarAvatar("login state changed");
            removeBadges();
            initBadges();
            initAvatarLayoutContentDescription();
        }
        if (topic == Topic.SIGN_IN || topic == Topic.ACCOUNT_SWITCH) {
            MainFragmentService.INSTANCE.forceUpdateBottomNav(getLifecycle());
        }
        if (topic == Topic.SIGN_OUT) {
            this.mBottomNav.resetAllBubbleStatus();
            HomeAvatarHelper.clearAvatar();
        }
    }

    private void refreshTab() {
        HomeTabServiceImpl homeTabService = HomeTabServiceImplKt.getHomeTabServiceImpl();
        if (homeTabService != null) {
            homeTabService.tryUpdateTab(getActivity());
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

    private void anchorTab(Intent intent) {
        Map<String, Object> extras;
        NavigationInfo nav = findAnchorNavigation(intent);
        if (nav == null) {
            return;
        }
        this.mTempIntent = intent;
        int newIndex = this.mNavigationInfo.indexOf(nav);
        int currentIndex = this.mBottomNav.getCurrentItem();
        this.mBottomNav.setCurrentItem(newIndex);
        if (newIndex == currentIndex && (extras = parseIntentExtras()) != null && !extras.isEmpty()) {
            this.mPageManager.invokePageSelectedListener(nav.mPage.url, extras);
        }
    }

    private NavigationInfo findAnchorNavigation() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return null;
        }
        Intent intent = activity.getIntent();
        return findAnchorNavigation(intent);
    }

    private NavigationInfo findAnchorNavigation(Intent intent) {
        if (intent == null) {
            return null;
        }
        String tabName = MainTransaction.getBottomAnchorName(intent.getExtras());
        String tabId = MainTransaction.getBottomAnchorId(intent.getExtras());
        if (TextUtils.isEmpty(tabName) && TextUtils.isEmpty(tabId)) {
            return null;
        }
        for (NavigationInfo nav : this.mNavigationInfo) {
            if ((TextUtils.equals(nav.mPage.reporterId, Uri.decode(tabId)) && !TextUtils.isEmpty(tabId)) || (TextUtils.equals(nav.mPage.title, Uri.decode(tabName)) && !TextUtils.isEmpty(tabName))) {
                return nav;
            }
        }
        return null;
    }

    private void initBadges() {
        for (final NavigationInfo nav : this.mNavigationInfo) {
            IBadgeServer server = nav.mPageInfo.getBadgeServer();
            if (server != null) {
                String key = nav.mPage.url;
                if (!TextUtils.isEmpty(key)) {
                    BadgeManager.OnChangedListener l = new BadgeManager.OnChangedListener() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment$$ExternalSyntheticLambda6
                        public final void onChanged(String str, Badge badge) {
                            BaseMainFrameFragment.this.m1997lambda$initBadges$3$tvdanmakubiliuimain2basicBaseMainFrameFragment(nav, str, badge);
                        }
                    };
                    BadgeManager.getInstance().register(key, l);
                    this.mListenerMap.put(nav, l);
                    server.refresh(getApplicationContext());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initBadges$3$tv-danmaku-bili-ui-main2-basic-BaseMainFrameFragment  reason: not valid java name */
    public /* synthetic */ void m1997lambda$initBadges$3$tvdanmakubiliuimain2basicBaseMainFrameFragment(NavigationInfo nav, String key1, Badge badge) {
        TabHost.TabInfo tabInfo;
        Context context = getContext();
        if (context == null) {
            return;
        }
        int pos = nav.mPosition;
        if (this.mBottomNav != null && this.mBottomNav.getTabs() != null && this.mBottomNav.getTabs().size() > pos && pos >= 0 && (tabInfo = (TabHost.TabInfo) this.mBottomNav.getTabs().get(pos)) != null && tabInfo.bubbleStatus) {
            return;
        }
        Garb garb = GarbManager.getGarbWithNightMode(context);
        showBadge(pos, badge, garb);
    }

    private void initComponent(View view) {
        this.mAppBarLayout = view.findViewById(tv.danmaku.bili.R.id.app_bar);
        this.content = view.findViewById(tv.danmaku.bili.R.id.content);
        this.mToolbar = this.mAppBarLayout.findViewById(tv.danmaku.bili.R.id.nav_top_bar);
        this.mVerifyAvatar = view.findViewById(tv.danmaku.bili.R.id.avatar);
        this.mAvatarLayout = view.findViewById(tv.danmaku.bili.R.id.avatar_layout);
        this.mAvatarRect = view.findViewById(tv.danmaku.bili.R.id.avatar_rect);
        this.mAvatarRectBg = view.findViewById(tv.danmaku.bili.R.id.avatar_rect_bg);
        this.mAvatarRectContainer = (FrameLayout) view.findViewById(tv.danmaku.bili.R.id.avatar_rect_layout);
        this.mNickName = (ToolbarCenterTextView) view.findViewById(tv.danmaku.bili.R.id.nick_name);
        this.mIconTeenUmbrella = view.findViewById(tv.danmaku.bili.R.id.iv_teen_umbrella);
        this.mTabs = view.findViewById(tv.danmaku.bili.R.id.toolbar_tabs);
        this.mTabs.setTabPaddingLeftRight(DpUtils.INSTANCE.dp2Px(4));
        this.mExpandSearch = view.findViewById(tv.danmaku.bili.R.id.expand_search);
        this.mSearchIcon = view.findViewById(tv.danmaku.bili.R.id.search_icon);
        this.mSearchTextView = view.findViewById(tv.danmaku.bili.R.id.search_text);
        if (this.ffSearchBar2Exp1 || this.ffSearchBar2Exp2) {
            this.mSearchTextView.setTextSize(2, 15.0f);
            ViewGroup.LayoutParams layoutParams = this.mExpandSearch.getLayoutParams();
            layoutParams.height = DpUtils.INSTANCE.dp2Px(34);
            this.mExpandSearch.setLayoutParams(layoutParams);
            this.mSearchIcon.setImageResource(com.bilibili.app.comm.baseres.R.drawable.ic_search_action_bold);
        }
        this.mBottomNav = view.findViewById(tv.danmaku.bili.R.id.bottom_navigation);
        this.mBottomNav.setAlpha(0.98f);
        this.mBottomNav.setOnSelectChangedListener(this.mSelectChangedListener);
        this.mNavViewHelper = new TabHostHelper(this.mBottomNav);
        initAvatarLayoutContentDescription();
        this.mAvatarLayout.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BaseMainFrameFragment.this.m1998lambda$initComponent$4$tvdanmakubiliuimain2basicBaseMainFrameFragment(view2);
            }
        });
        this.mExpandSearch.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BaseMainFrameFragment.this.m2001lambda$initComponent$8$tvdanmakubiliuimain2basicBaseMainFrameFragment(view2);
            }
        });
        this.mIconTeenUmbrella.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BaseMainFrameFragment.lambda$initComponent$9(view2);
            }
        });
        initBottomTab(view);
        this.mMainTopLayout = (FrameLayout) view.findViewById(tv.danmaku.bili.R.id.main_top_layout);
        int[] iArr = this.mBgColors;
        int[] iArr2 = this.mBgColors;
        int colorById = ThemeUtils.getColorById(getActivity(), com.bilibili.app.comm.baseres.R.color.theme_color_primary_tr_background);
        iArr2[1] = colorById;
        iArr[0] = colorById;
        this.mMainTopLayoutBgDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.mBgColors);
        this.mMainTopLayout.setBackground(this.mMainTopLayoutBgDrawable);
        this.mMainTopBgImageView = (ImageView) view.findViewById(tv.danmaku.bili.R.id.main_top_bg);
        this.mMainTopBgImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mTabs.setOnTabLayoutCompleteListener(this);
        final ViewTreeObserver searchObserver = this.mExpandSearch.getViewTreeObserver();
        searchObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment.5
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (searchObserver.isAlive()) {
                    searchObserver.removeOnGlobalLayoutListener(this);
                } else {
                    BaseMainFrameFragment.this.mExpandSearch.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                FragmentActivity activity = BaseMainFrameFragment.this.getActivity();
                if (!(activity instanceof MainActivityV2)) {
                    return;
                }
                Rect rect = new Rect();
                boolean visible = BaseMainFrameFragment.this.mExpandSearch.getGlobalVisibleRect(rect);
                if (!visible) {
                    return;
                }
                SplashViewModel vm = new ViewModelProvider(activity).get(SplashViewModel.class);
                vm.getSearchBarRect().setValue(rect);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initComponent$4$tv-danmaku-bili-ui-main2-basic-BaseMainFrameFragment  reason: not valid java name */
    public /* synthetic */ void m1998lambda$initComponent$4$tvdanmakubiliuimain2basicBaseMainFrameFragment(View v) {
        onClickTopNavigation();
        HomeReportHelper.reportTabClick(5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initComponent$8$tv-danmaku-bili-ui-main2-basic-BaseMainFrameFragment  reason: not valid java name */
    public /* synthetic */ void m2001lambda$initComponent$8$tvdanmakubiliuimain2basicBaseMainFrameFragment(View view1) {
        RouteRequest.Builder builder = new RouteRequest.Builder(HotListDataPacker.URL_SEARCH_NEW);
        builder.extras(new Function1() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment$$ExternalSyntheticLambda22
            public final Object invoke(Object obj) {
                return BaseMainFrameFragment.lambda$initComponent$5((MutableBundleLike) obj);
            }
        });
        if (this.mSearchDefaultWord != null) {
            builder.extras(new Function1() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    return BaseMainFrameFragment.this.m1999lambda$initComponent$6$tvdanmakubiliuimain2basicBaseMainFrameFragment((MutableBundleLike) obj);
                }
            });
        } else if (this.mZeroCardSearchDefaultWord != null) {
            builder.extras(new Function1() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    return BaseMainFrameFragment.this.m2000lambda$initComponent$7$tvdanmakubiliuimain2basicBaseMainFrameFragment((MutableBundleLike) obj);
                }
            });
        }
        RouteResponse routeResponse = BLRouter.routeTo(builder.build(), getContext());
        if (!routeResponse.isSuccess()) {
            BLog.e(SEARCH_HOME_ROUTER, routeResponse.toString());
        }
        NavigationReporter.reportSearchWordClick(this.mSearchDefaultWord);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit lambda$initComponent$5(MutableBundleLike bundle) {
        bundle.put("search_discover_from_home", String.valueOf(true));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initComponent$6$tv-danmaku-bili-ui-main2-basic-BaseMainFrameFragment  reason: not valid java name */
    public /* synthetic */ Unit m1999lambda$initComponent$6$tvdanmakubiliuimain2basicBaseMainFrameFragment(MutableBundleLike bundle) {
        bundle.put("search_default_word", JSON.toJSONString(this.mSearchDefaultWord));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initComponent$7$tv-danmaku-bili-ui-main2-basic-BaseMainFrameFragment  reason: not valid java name */
    public /* synthetic */ Unit m2000lambda$initComponent$7$tvdanmakubiliuimain2basicBaseMainFrameFragment(MutableBundleLike bundle) {
        bundle.put("search_default_word", JSON.toJSONString(this.mZeroCardSearchDefaultWord));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$initComponent$9(View v) {
        Neurons.reportClick(false, "main.teenagermodel.teen-status.icon.click");
        RouteRequest.Builder builder = new RouteRequest.Builder("bilibili://main/teenagersmode");
        BLRouter.routeTo(builder.build(), v.getContext());
    }

    private void initAvatarLayoutContentDescription() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        if (!BiliAccounts.get(context).isLogin()) {
            this.mAvatarLayout.setContentDescription(context.getString(bili.resource.homepage.R.string.homepage_global_string_298));
        } else {
            this.mAvatarLayout.setContentDescription(context.getString(bili.resource.homepage.R.string.homepage_global_string_347));
        }
    }

    private void initBottomTab(View view) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        int size = this.mNavigationInfo.size();
        Garb garb = GarbManager.getGarbWithNightMode(context);
        this.mCurrentGarbId = garb.getId();
        this.mTabGarbProvider.build(garb, size);
        if (this.mTabGarbProvider.hasBottomGarb()) {
            this.mBottomNav.renderBgWithGarb(garb, false);
        } else {
            this.mBottomNav.renderBg();
        }
        this.mBottomNav.clearDrawablesCache();
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < size; index++) {
            NavigationInfo info = this.mNavigationInfo.get(index);
            info.mPosition = index;
            TabHost.TabInfo tabInfo = this.mTabGarbProvider.provide(context, info.createTabInfo(), index);
            this.mBottomNav.addTab(tabInfo);
            if (tabInfo.isPublish) {
                showPublishBubble(tabInfo);
            }
            if (info.mPage != null) {
                sb.append(" ").append(info.mPage.title);
            }
            if (index == 0) {
                onBottomNavigationItemSelected(index, info);
            }
        }
        BLog.i(TAG, "initBottomTab" + ((Object) sb));
        this.mBottomNav.initTabContentDescription();
        refreshHomeBottomInfo();
    }

    private void refreshHomeBottomInfo() {
        HomeTabServiceImpl homeTabService = HomeTabServiceImplKt.getHomeTabServiceImpl();
        if (homeTabService != null) {
            homeTabService.setTabHost(this.mBottomNav);
        }
    }

    private void showPublishBubble(final TabHost.TabInfo info) {
        if (!info.isPublish || this.mBottomNav == null) {
            return;
        }
        BLog.i(TAG, "show publish bubble");
        OneShotPreDrawListener.add(this.mBottomNav, new Runnable() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment.6
            @Override // java.lang.Runnable
            public void run() {
                LifecycleOwner viewOwner = (LifecycleOwner) BaseMainFrameFragment.this.getViewLifecycleOwnerLiveData().getValue();
                if (viewOwner != null) {
                    PublishBubbleDialogKt.showPublishBubbleInLifecycleScope(viewOwner, BaseMainFrameFragment.this.mBottomNav, info.url);
                }
            }
        });
    }

    public void onStart() {
        super.onStart();
        updateBottomNavFromCache();
        BLog.d("BottomTabSelectedHelper", "currentUrl=" + BottomTabSelectedHelper.INSTANCE.getCurrentBottomTabUrl());
        NavigationInfo curNav = findCurrentNavigation();
        boolean needReport = MainResourceManager.getInstance().getAndResetPrimaryPageAPIFlag();
        int n = this.mNavigationInfo.size();
        for (int i = 0; i < n; i++) {
            NavigationInfo navInfo = this.mNavigationInfo.get(i);
            tryUpdateTopMenu(curNav, navInfo);
            if (needReport && !this.isFirstStart) {
                TabHost.TabInfo tabInfo = null;
                if (this.mBottomNav != null && this.mBottomNav.getTabs() != null && this.mBottomNav.getTabs().size() > i) {
                    tabInfo = (TabHost.TabInfo) this.mBottomNav.getTabs().get(i);
                }
                String str = navInfo.mPage.title;
                long j = 0;
                if (tabInfo != null && tabInfo.bubbleId > 0) {
                    j = tabInfo.bubbleId;
                }
                NavigationReporter.reportMainTabShow(str, j);
            }
        }
        if (!this.mIsFirst && EventEntranceHelper.hasEntrance() && UserGrowManager.checkHomePage()) {
            EventEntranceHelper.reportEntranceShow();
        }
        this.mIsFirst = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryUpdateTopMenu(NavigationInfo curNav, NavigationInfo navInfo) {
        List<IOptionMenuItem> oldMenu = navInfo.mPageInfo.getMenuItems();
        if (navInfo.mPageInfo.isMenuDataChange()) {
            navInfo.mPageInfo.updateMenuFromProvider(getContext());
            if (curNav == null || curNav.mMenuId == navInfo.mMenuId) {
                switchToMenu(oldMenu, navInfo.mPageInfo.getMenuItems());
            }
        }
    }

    public void tryUpdateCurrentTopMenu(int pos) {
        NavigationInfo curNav = findCurrentNavigation();
        NavigationInfo navInfo = this.mNavigationInfo.get(pos);
        if (navInfo == null || navInfo.mPageInfo == null) {
            return;
        }
        List<IOptionMenuItem> oldMenu = navInfo.mPageInfo.getMenuItems();
        if (navInfo.mPageInfo.isMenuDataChange()) {
            navInfo.mPageInfo.updateMenuFromProvider(getContext());
            if (curNav == null || curNav.mMenuId == navInfo.mMenuId) {
                switchToMenu(oldMenu, navInfo.mPageInfo.getMenuItems());
            }
        }
    }

    public void tryUpdateIncrementTopMenu(int pos) {
        NavigationInfo curNav = findCurrentNavigation();
        NavigationInfo navInfo = this.mNavigationInfo.get(pos);
        if (navInfo == null || navInfo.mPageInfo == null) {
            return;
        }
        List<IOptionMenuItem> oldMenu = navInfo.mPageInfo.getMenuItems();
        navInfo.mPageInfo.updateMenuFromProvider(getContext());
        if (curNav == null || curNav.mMenuId == navInfo.mMenuId) {
            switchToMenu(oldMenu, navInfo.mPageInfo.getMenuItems());
            if (EventEntranceHelper.animValid(getContext())) {
                showEntranceMenuAnim(curNav);
            }
        }
    }

    @Override // tv.danmaku.bili.ui.main2.basic.IMainFragmentHost
    public void updateEntranceMenu(final int pos) {
        if (pos < 0 || pos >= this.mNavigationInfo.size() || !UserGrowManager.checkHomePage()) {
            return;
        }
        final Context context = getContext();
        if (!EventEntranceHelper.hasEntrance() || context == null) {
            return;
        }
        EventEntranceHelper.reportEntranceShow();
        if (!EventEntranceHelper.animExecuted) {
            final ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) this.mExpandSearch.getLayoutParams();
            int start = layoutParams.rightMargin;
            int end = layoutParams.rightMargin + EventMenuActionView.TOTAL_SIZE;
            ValueAnimator animator = ValueAnimator.ofInt(start, end);
            animator.setDuration(500L);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment$$ExternalSyntheticLambda8
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BaseMainFrameFragment.this.m2008lambda$updateEntranceMenu$10$tvdanmakubiliuimain2basicBaseMainFrameFragment(layoutParams, valueAnimator);
                }
            });
            animator.addListener(new Animator.AnimatorListener() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment.7
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    FragmentActivity activity = BaseMainFrameFragment.this.getActivity();
                    if (activity == null || activity.isFinishing()) {
                        return;
                    }
                    NavigationInfo nav = (NavigationInfo) BaseMainFrameFragment.this.mNavigationInfo.get(pos);
                    BaseMainFrameFragment.this.tryUpdateTopMenu(BaseMainFrameFragment.this.findCurrentNavigation(), nav);
                    layoutParams.rightMargin = DisplayUtils.dp2Px(12);
                    BaseMainFrameFragment.this.mExpandSearch.setLayoutParams(layoutParams);
                    if (EventEntranceHelper.animValid(context)) {
                        BaseMainFrameFragment.this.showEntranceMenuAnim(nav);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animation) {
                }
            });
            animator.start();
            EventEntranceHelper.animExecuted = true;
            return;
        }
        NavigationInfo nav = this.mNavigationInfo.get(pos);
        tryUpdateTopMenu(findCurrentNavigation(), nav);
        if (EventEntranceHelper.animValid(context)) {
            showEntranceMenuAnim(nav);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$updateEntranceMenu$10$tv-danmaku-bili-ui-main2-basic-BaseMainFrameFragment  reason: not valid java name */
    public /* synthetic */ void m2008lambda$updateEntranceMenu$10$tvdanmakubiliuimain2basicBaseMainFrameFragment(ViewGroup.MarginLayoutParams layoutParams, ValueAnimator animation) {
        layoutParams.rightMargin = ((Integer) animation.getAnimatedValue()).intValue();
        this.mExpandSearch.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showEntranceMenuAnim(NavigationInfo nav) {
        List<IOptionMenuItem> menus;
        if (nav == null || (menus = nav.mPageInfo.getMenuItems()) == null || menus.isEmpty()) {
            return;
        }
        for (IOptionMenuItem iOptionMenuItem : menus) {
            if (iOptionMenuItem instanceof EventMenuItem) {
                ((EventMenuItem) iOptionMenuItem).showAnim();
            }
        }
    }

    @Override // tv.danmaku.bili.ui.main2.resource.MainFragmentOperator
    public void updateBottomNavFromCache() {
        Context context = getActivity();
        if (!this.mBottomDataProvider.isNavigationDataChange() || context == null) {
            return;
        }
        List<NavigationInfo> newNav = this.mBottomDataProvider.getNavigationInfo();
        List<NavigationInfo> toRemove = new ArrayList<>();
        for (NavigationInfo old : this.mNavigationInfo) {
            if (!isInNewNav(old, newNav)) {
                toRemove.add(old);
            }
        }
        NavigationInfo nav = findCurrentNavigation();
        int checkedPos = indexOf(nav, newNav);
        removeBadges();
        fill(newNav, this.mNavigationInfo);
        Garb garb = GarbManager.getGarbWithNightMode(context);
        this.mTabGarbProvider.build(garb, this.mNavigationInfo.size());
        List<TabHost.TabInfo> tabs = new ArrayList<>();
        for (int index = 0; index < this.mNavigationInfo.size(); index++) {
            NavigationInfo info = this.mNavigationInfo.get(index);
            info.mPosition = index;
            TabHost.TabInfo tabInfo = info.createTabInfo();
            tabs.add(this.mTabGarbProvider.provide(context, tabInfo, index));
        }
        this.mBottomNav.setTabs(tabs);
        refreshHomeBottomInfo();
        if (this.mHomeFloatViewHelper != null) {
            this.mHomeFloatViewHelper.disMiss();
        }
        this.mPageManager.clearAll();
        for (NavigationInfo info2 : toRemove) {
            this.mPageManager.removePageFragment(info2.mPage.url, info2.mPageInfo.getPageClazz());
        }
        for (NavigationInfo info3 : this.mNavigationInfo) {
            this.mPageManager.addPage(info3.mPage.url, info3.mPageInfo.getPageClazz(), info3.mPageInfo.getPageArgs());
        }
        initBadges();
        this.mBottomNav.setCurrentItem(checkedPos);
        switchToNavigation(newNav.get(checkedPos).mPage.url);
    }

    private boolean isInNewNav(NavigationInfo old, List<NavigationInfo> newNav) {
        for (NavigationInfo fresh : newNav) {
            if (old.mMenuId == fresh.mMenuId) {
                return true;
            }
        }
        return false;
    }

    private int indexOf(NavigationInfo old, List<NavigationInfo> newNav) {
        if (old == null) {
            return 0;
        }
        int n = newNav.size();
        for (int i = 0; i < n; i++) {
            NavigationInfo navInfo = newNav.get(i);
            if (navInfo.mMenuId == old.mMenuId) {
                return i;
            }
        }
        return 0;
    }

    /* renamed from: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment$8  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    class AnonymousClass8 implements TabHost.OnSelectChangedListener {
        AnonymousClass8() {
        }

        public void onItemSelected(int position, View itemView) {
            int itemId = itemView.getId();
            BaseMainFrameFragment.this.dismissHomeFloatView();
            NavigationInfo newInfo = BaseMainFrameFragment.this.findNavigation(itemId);
            if (newInfo == null) {
                BaseMainFrameFragment.this.onBottomNavigationItemSelected(position, null);
                return;
            }
            String pageUrl = newInfo.mPage.url;
            NavigationInfo oldInfo = BaseMainFrameFragment.this.findCurrentNavigation();
            BaseMainFrameFragment.this.switchToNavigation(pageUrl);
            List<IOptionMenuItem> oldMenus = oldInfo != null ? oldInfo.mPageInfo.getMenuItems() : null;
            BaseMainFrameFragment.this.switchToMenu(oldMenus, newInfo.mPageInfo.getMenuItems());
            BaseMainFrameFragment.this.initToolbar(newInfo);
            BaseMainFrameFragment.this.onBottomNavigationItemSelected(position, newInfo);
            if (BaseMainFrameFragment.this.mBottomNav.getCurrentItem() == 0 && BaseMainFrameFragment.this.mAppBarLayout.getVisibility() == 0) {
                BaseMainFrameFragment.this.tryToMoveToOriginPosition(BaseMainFrameFragment.this.getApplicationContext());
                BaseMainFrameFragment.this.mBaseMainViewModel.update(new ToolbarEvent.ExpandToolbar(true, false));
            }
            BottomBubbleHelper.dismissWindow(position);
            if (BaseMainFrameFragment.this.getActivity() != null && newInfo.mPage.title != null) {
                BTrace.updatePageInfo(newInfo.mPage.title, BaseMainFrameFragment.this.getActivity());
            }
            BaseMainFrameFragment.this.goBottomPageIfNeed(position);
            BottomBubbleHelper.reportBottomBarClick(position, newInfo.mPage.title);
            BottomTabSelectedHelper.onTabSelectedChange(pageUrl);
            BaseMainFrameFragment.this.updateEntranceMenu(0);
            HomeTabServiceImpl homeTabService = HomeTabServiceImplKt.getHomeTabServiceImpl();
            if (homeTabService != null) {
                homeTabService.onHomeTabSelect(false, position, pageUrl, itemView, null);
            }
            Iterator it = BaseMainFrameFragment.this.mBottomNav.getTabs().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                TabHost.TabInfo tab = (TabHost.TabInfo) it.next();
                if (tab.isPublish) {
                    LifecycleOwner viewOwner = (LifecycleOwner) BaseMainFrameFragment.this.getViewLifecycleOwnerLiveData().getValue();
                    if (viewOwner != null) {
                        PublishBubbleDialogKt.showPublishBubbleInLifecycleScope(viewOwner, BaseMainFrameFragment.this.mBottomNav, tab.url, false);
                    }
                }
            }
            FragmentActivity activity = BaseMainFrameFragment.this.getActivity();
            if (activity != null) {
                Intent intent = new Intent(UpCardAppWidgetKt.APP_WIDGET_MANUAL_CLICK_UPDATE);
                intent.setComponent(new ComponentName((Context) activity, (Class<?>) UpCardAppWidget.class));
                intent.putExtra("from", newInfo.mPage.reporterId);
                activity.sendBroadcast(intent);
            }
        }

        public void onItemReselected(int position, View itemView, Bundle extra) {
            BaseMainFrameFragment.this.dismissHomeFloatView();
            PrimaryPageManager.PrimaryPage page = BaseMainFrameFragment.this.mPageManager.current();
            if (page == null) {
                return;
            }
            OnPageSelectChangeListener pageFragment = page.getPageFragment();
            if (!(pageFragment instanceof OnPageSelectChangeListener)) {
                return;
            }
            BaseMainFrameFragment.this.mBaseMainViewModel.update(new ToolbarEvent.ExpandToolbar(true, false));
            OnPageSelectChangeListener l = pageFragment;
            l.onPageReSelected(new PageReSelectedParams(false, itemView, extra));
            BottomBubbleHelper.dismissWindow(position);
            BaseMainFrameFragment.this.goBottomPageIfNeed(position);
            int itemId = itemView.getId();
            NavigationInfo newInfo = BaseMainFrameFragment.this.findNavigation(itemId);
            if (newInfo != null && newInfo.mPage != null) {
                BottomBubbleHelper.reportBottomBarClick(position, newInfo.mPage.title);
                FragmentActivity activity = BaseMainFrameFragment.this.getActivity();
                if (activity != null) {
                    Intent intent = new Intent(UpCardAppWidgetKt.APP_WIDGET_MANUAL_CLICK_UPDATE);
                    intent.setComponent(new ComponentName((Context) activity, (Class<?>) UpCardAppWidget.class));
                    intent.putExtra("from", newInfo.mPage.reporterId);
                    activity.sendBroadcast(intent);
                }
            }
        }

        public boolean onPublishIconClicked(int position, HomeTabPublishView publishView) {
            final String trackId;
            NavigationInfo newInfo;
            FragmentActivity activity = BaseMainFrameFragment.this.getActivity();
            if (activity == null) {
                return false;
            }
            final TabHost.TabInfo tabInfo = publishView.getMTabIfo();
            UperLogInterface logInterface = (UperLogInterface) BLRouter.INSTANCE.get(UperLogInterface.class, MineReporter.MINE_ICON_TYPE_DEFAULT);
            if (logInterface == null || !BiliAccounts.get(activity).isLogin()) {
                trackId = null;
            } else {
                trackId = logInterface.generateTrackId(activity, (tabInfo == null || TextUtils.isEmpty(tabInfo.url)) ? "" : tabInfo.url);
            }
            String sdkType = logInterface != null ? logInterface.getSdkType() : null;
            if (position < BaseMainFrameFragment.this.mNavigationInfo.size() && (newInfo = (NavigationInfo) BaseMainFrameFragment.this.mNavigationInfo.get(position)) != null && newInfo.mPage != null) {
                BottomBubbleHelper.reportBottomBarClick(position, newInfo.mPage.title, trackId, sdkType);
            }
            if (tabInfo != null && !TextUtils.isEmpty(tabInfo.url)) {
                String url = tabInfo.url;
                final UpperCenterPlusBubbleService.BubbleInfo showingItem = PublishBubblePopupWindowKt.getShowingPopupItem();
                if (showingItem != null && !TextUtils.isEmpty(showingItem.getRouteUrl())) {
                    url = showingItem.getRouteUrl();
                }
                RouteRequest request = new RouteRequest.Builder(url).extras(new Function1() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment$8$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        return BaseMainFrameFragment.AnonymousClass8.lambda$onPublishIconClicked$0(tabInfo, trackId, showingItem, (MutableBundleLike) obj);
                    }
                }).build();
                BLRouter.routeTo(request, activity);
                return false;
            }
            if (BaseMainFrameFragment.this.mHomeFloatViewHelper == null) {
                BaseMainFrameFragment.this.mHomeFloatViewHelper = new HomeFloatViewHelper(activity, BaseMainFrameFragment.this, BaseMainFrameFragment.this.mBottomNav, publishView);
            }
            if (!publishView.isFold() && tabInfo != null && tabInfo.dialogItems != null) {
                BaseMainFrameFragment.this.mHomeFloatViewHelper.setData(tabInfo.dialogItems);
                BaseMainFrameFragment.this.mHomeFloatViewHelper.show();
                return true;
            }
            BaseMainFrameFragment.this.mHomeFloatViewHelper.disMiss();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$onPublishIconClicked$0(TabHost.TabInfo tabInfo, String trackId, UpperCenterPlusBubbleService.BubbleInfo showingItem, MutableBundleLike mutableBundleLike) {
            mutableBundleLike.put("from_spmid", OnePassLoginReportManagerKt.SPM_ID_HOME_BOTTOM_PUBLISH);
            if (tabInfo.isPublish) {
                mutableBundleLike.put("center_plus_type", "0");
                if (!TextUtils.isEmpty(trackId)) {
                    mutableBundleLike.put("track_id", trackId);
                }
                if (showingItem != null) {
                    mutableBundleLike.put("strategy_id", showingItem.getStrategyId());
                    return null;
                }
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goBottomPageIfNeed(int position) {
        if (this.mBottomNav.getTabs().size() > position && position >= 0) {
            TabHost.TabInfo tabInfo = (TabHost.TabInfo) this.mBottomNav.getTabs().get(position);
            if (tabInfo.bubbleStatus && !TextUtils.isEmpty(tabInfo.goPageUrl)) {
                BLRouter.routeTo(new RouteRequest.Builder(Uri.parse(tabInfo.goPageUrl)).build(), getActivity());
            }
            this.mBottomNav.resetBubbleStatus(position);
        }
    }

    private void onClickTopNavigation() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof IDrawerHost) || this.mBottomNav == null || this.mNavigationInfo == null) {
            return;
        }
        if (!BiliAccounts.get(getContext()).isLogin()) {
            RouteRequest request = new RouteRequest.Builder(Uri.parse("bilibili://login")).extras(new Function1<MutableBundleLike, Unit>() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment.9
                public Unit invoke(MutableBundleLike mutableBundleLike) {
                    mutableBundleLike.put(LoginOriginalActivityV2.KEY_PROMPT_SCENE, "main.homepage.avatar-nologin.all.click");
                    return null;
                }
            }).build();
            BLRouter.routeTo(request, activity);
            HomeReportHelper.reportNavViewClick("0");
        } else {
            MainResourceManager.TopLeftInfo topLeftInfo = HomeTopLeftStateHolderKt.getTopLeftInfo();
            HomeSideCenterTab curTab = HomeTopLeftStateHolderKt.getCurrentHomeSideCenterTab();
            if (topLeftInfo != null && StringUtil.isNotBlank(topLeftInfo.url) && curTab != HomeSideCenterTab.MINE) {
                String jumpUrl = topLeftInfo.url;
                if (topLeftInfo.hitRecentTabExp()) {
                    jumpUrl = HomeTopLeftStateHolderKt.getHOME_SIDE_CENTER_ROUTER();
                }
                BLog.i(TAG, "avatar jump to url " + jumpUrl);
                RouteRequest request2 = new RouteRequest.Builder(jumpUrl).extras(new Function1() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment$$ExternalSyntheticLambda13
                    public final Object invoke(Object obj) {
                        return BaseMainFrameFragment.lambda$onClickTopNavigation$11((MutableBundleLike) obj);
                    }
                }).build();
                BLRouter.routeTo(request2, activity);
                HomeReportHelper.reportNavViewClick(String.valueOf(topLeftInfo.gotoFlag));
            } else {
                int mineIndex = -1;
                int size = this.mNavigationInfo.size();
                for (int index = 0; index < size; index++) {
                    PrimaryPage primaryPage = this.mNavigationInfo.get(index).mPage;
                    if (primaryPage != null && TextUtils.equals(DefaultResourceResolver.USER_CENTER, primaryPage.url)) {
                        mineIndex = index;
                    }
                }
                if (mineIndex >= 0) {
                    this.mBottomNav.setCurrentItem(mineIndex);
                }
                HomeReportHelper.reportNavViewClick("1");
            }
        }
        if (!BiliAccounts.get(activity).isLogin()) {
            HomeReportHelper.reportNoLoginedNavViewClick(this.mHomeNoLoginAvatar == null ? "" : this.mHomeNoLoginAvatar.url);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit lambda$onClickTopNavigation$11(MutableBundleLike mutableBundleLike) {
        mutableBundleLike.put("from_spmid", "main.homepage.avatar.0");
        return null;
    }

    protected void onBottomNavigationItemSelected(int position, NavigationInfo info) {
        if (info != null) {
            Violet.INSTANCE.sendMsg(new NavigationSelectionEvent(position, info.mPage.url, info.mPage.id));
        }
    }

    private void buildNavigation(Bundle savedInstanceState) {
        this.mPageManager = new PrimaryPageManager(tv.danmaku.bili.R.id.content, getChildFragmentManager());
        for (NavigationInfo info : this.mNavigationInfo) {
            String id = info.mPage.url;
            this.mPageManager.addPage(id, info.mPageInfo.getPageClazz(), info.mPageInfo.getPageArgs());
        }
        this.mPageManager.onRestoreInstanceState(savedInstanceState);
    }

    private Map<String, Object> parseIntentExtras() {
        Set<String> keys;
        Map<String, Object> query = null;
        if (this.mTempIntent != null) {
            Bundle extras = this.mTempIntent.getExtras();
            if (extras != null && (keys = extras.keySet()) != null && !keys.isEmpty()) {
                query = new HashMap<>();
                for (String key : keys) {
                    Object value = extras.get(key);
                    if (value != null) {
                        query.put(key, value);
                    }
                }
            }
            this.mTempIntent = null;
        }
        return query;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchToNavigation(String pageUrl) {
        Map<String, Object> query = parseIntentExtras();
        this.mPageManager.switchTo(pageUrl, query);
    }

    @Override // tv.danmaku.bili.ui.main2.MainPagerFragmentV2
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        GarbWatcher.INSTANCE.subscribe(this);
        syncToolBarAvatar("onActivityCreated");
        NavigationInfo navigationInfo = findCurrentNavigation();
        if (navigationInfo != null) {
            switchToMenu(null, navigationInfo.mPageInfo.getMenuItems());
            initToolbar(navigationInfo);
        }
        final FragmentActivity activity = getActivity();
        if (activity != null) {
            this.statusBarHeight = StatusBarCompat.getStatusBarHeight(activity);
            int toolbarHeight = activity.getResources().getDimensionPixelSize(com.bilibili.lib.basecomponent.R.dimen.navigation_top_bar_size);
            ViewGroup.MarginLayoutParams toolbarParams = (ViewGroup.MarginLayoutParams) this.mAppBarLayout.getLayoutParams();
            toolbarParams.topMargin = this.statusBarHeight;
            this.mAppBarLayout.setLayoutParams(toolbarParams);
            ViewGroup.LayoutParams topBgLayoutParams = this.mMainTopBgImageView.getLayoutParams();
            topBgLayoutParams.height = this.statusBarHeight + toolbarHeight;
            this.mMainTopBgImageView.setLayoutParams(topBgLayoutParams);
            ViewGroup.LayoutParams topLayoutParams = this.mMainTopLayout.getLayoutParams();
            topLayoutParams.height = this.statusBarHeight + toolbarHeight;
            this.mMainTopLayout.setLayoutParams(topLayoutParams);
            final BiliAccountInfo accountinfo = BiliAccountInfo.get();
            Task.callInBackground(new Callable<AccountInfo>() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment.11
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public AccountInfo call() throws Exception {
                    return accountinfo.requestForMyAccountInfo();
                }
            }).continueWith(new Continuation<AccountInfo, Void>() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment.10
                public /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
                    return m2011then((Task<AccountInfo>) task);
                }

                /* renamed from: then  reason: collision with other method in class */
                public Void m2011then(Task<AccountInfo> task) throws Exception {
                    if (!activity.isFinishing() && task.isCompleted() && task.getResult() != null) {
                        BaseMainFrameFragment.this.syncToolBarAvatar("account info update");
                        return null;
                    }
                    return null;
                }
            }, Task.UI_THREAD_EXECUTOR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchToMenu(List<IOptionMenuItem> oldMenus, List<IOptionMenuItem> newMenus) {
        FragmentActivity activity;
        Menu menu;
        Toolbar toolbar = getBar();
        if (toolbar == null || (activity = getActivity()) == null || (menu = toolbar.getMenu()) == null) {
            return;
        }
        menu.clear();
        if (oldMenus != null) {
            for (IOptionMenuItem menuItem : oldMenus) {
                menuItem.onDestroyMenuItem(menu);
            }
        }
        onCreateMenu(activity, newMenus, menu, activity.getMenuInflater());
        toolbar.setOnMenuItemClickListener(this);
    }

    public final void onCreateMenu(Activity activity, List<IOptionMenuItem> menus, Menu menu, MenuInflater inflater) {
        if (menus == null) {
            return;
        }
        Garb garb = GarbManager.getGarbWithNightMode(activity);
        for (IOptionMenuItem menuItem : menus) {
            menuItem.onCreateMenuItem(menu, inflater);
        }
        int size = menu.size();
        for (int pos = 0; pos < size; pos++) {
            MenuItem menuItem2 = menu.getItem(pos);
            compatActionViewClick(menuItem2);
            MenuActionView actionView = menuItem2.getActionView();
            if (actionView instanceof MenuActionView) {
                MenuActionView actionView2 = actionView;
                if (!actionView2.hasIconTintColor() && actionView2.getIconDrawable() != null) {
                    if (this.mIsToolbarColorUpdated && this.mIconColor != 0) {
                        actionView2.setIconTintColorWithGarb(this.mIconColor);
                        actionView2.setTintable(false);
                    } else if (!garb.isPure()) {
                        actionView2.setIconTintColorWithGarb(garb.getMainFontColor());
                        actionView2.setTintable(false);
                    }
                }
            }
        }
    }

    private void compatActionViewClick(final MenuItem item) {
        if (item == null || item.getActionView() == null) {
            return;
        }
        item.getActionView().setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                BaseMainFrameFragment.this.onMenuItemClick(item);
            }
        });
    }

    public final boolean onMenuItemClick(MenuItem item) {
        List<IOptionMenuItem> menuItems;
        NavigationInfo navigationInfo = findCurrentNavigation();
        if (navigationInfo == null || (menuItems = navigationInfo.mPageInfo.getMenuItems()) == null) {
            return false;
        }
        int menuId = item.getItemId();
        for (IOptionMenuItem menuItem : menuItems) {
            if (menuItem.getMenuItemId() == menuId && menuItem.onMenuItemClick(item)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateExpandSearchWord(IDefaultKeywordResult word) {
        if (TeenagersModeConfigKt.isEnableSearchInTeenagersMode()) {
            String defaultWord = getContext().getString(bili.resource.homepage.R.string.homepage_global_string_73);
            updateExpandSearchText(defaultWord);
            return;
        }
        this.mSearchDefaultWord = word;
        if (word != null && word.isShowFront()) {
            if (word.enableAnimation()) {
                updateExpandSearchTextWithAnimation(word.getShow(), Long.valueOf(word.getAnimationTimeMilli()));
            } else {
                updateExpandSearchText(word.getShow());
            }
            tryReportDefaultSearchWordShow();
            return;
        }
        String zeroCardWord = (String) ConfigManager.Companion.config().get("main.search_zero_signal_default_word", getContext().getString(bili.resource.homepage.R.string.homepage_global_string_57));
        updateExpandSearchText(zeroCardWord);
    }

    protected void updateExpandSearchTextWithAnimation(CharSequence text, Long durationTime) {
        if (this.mSearchTextView != null) {
            this.mSearchTextView.setTextWithAnimation(text, durationTime.longValue());
        }
    }

    protected void updateExpandSearchText(CharSequence text) {
        if (this.mSearchTextView != null) {
            this.mSearchTextView.setText(text);
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        this.mPageManager.onSaveInstanceState(outState);
    }

    public void onDestroyView() {
        super.onDestroyView();
        GarbWatcher.INSTANCE.unSubscribe(this);
        BiliAccounts.get(getActivity()).unsubscribeAllWithSwitch(this);
        notifyMenuDestroy();
        removeBadges();
        if (this.mNavigationBadgeSolution != null) {
            this.mNavigationBadgeSolution.onDestroy();
        }
        HomeSlideTabManager.getInstance().setTabController((HomeSlideTabManager.TabController) null);
        EventEntranceHelper.unregisterListener();
        MainResourceManager.getInstance().setMenuChangeListener(null);
        this.mBgDrawableCache.clear();
        HomeStoryEntranceServiceImpl service = HomeStoryEntranceServiceImplKt.getStoryEntranceServiceImpl();
        if (service != null) {
            service.setListener(null);
            service.setEntranceRect(null);
        }
    }

    private void removeBadges() {
        Collection<NavigationInfo> keySet = this.mListenerMap.keySet();
        for (NavigationInfo nav : keySet) {
            String key = nav.mPage.url;
            if (!TextUtils.isEmpty(key)) {
                BadgeManager.OnChangedListener l = this.mListenerMap.get(nav);
                BadgeManager.getInstance().unregister(key, l);
            }
        }
        this.mListenerMap.clear();
    }

    private void notifyMenuDestroy() {
        List<IOptionMenuItem> items;
        NavigationInfo navigationInfo = findCurrentNavigation();
        if (navigationInfo == null || (items = navigationInfo.mPageInfo.getMenuItems()) == null) {
            return;
        }
        for (IOptionMenuItem item : items) {
            item.onDestroyMenuItem(this.mToolbar.getMenu());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NavigationInfo findNavigation(int menuItemId) {
        for (NavigationInfo info : this.mNavigationInfo) {
            if (info.mMenuId == menuItemId) {
                return info;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NavigationInfo findNavigation(String pageUrl) {
        for (NavigationInfo info : this.mNavigationInfo) {
            if (TextUtils.equals(pageUrl, info.mPage.url)) {
                return info;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NavigationInfo findCurrentNavigation() {
        PrimaryPageManager.PrimaryPage page;
        if (this.mPageManager == null || (page = this.mPageManager.current()) == null) {
            return null;
        }
        String id = this.mPageManager.idOf(page.getPageFragment());
        return findNavigation(id);
    }

    public final void syncToolBarAvatar(String from) {
        BLog.i(TAG, "syncToolBarAvatar, from = " + from);
        if (this.mNavigationBadgeSolution == null || this.mVerifyAvatar == null) {
            return;
        }
        resetAvatarStyle();
        BiliAccounts account = BiliAccounts.get(getContext());
        AccountInfo info = BiliAccountInfo.get().getAccountInfoFromCache();
        if (account.isLogin() && info != null) {
            String avatar = info.getAvatar();
            if (avatar == null || !TextUtils.equals(this.mAvatarUrl, avatar)) {
                if (StringUtil.isBlank(avatar)) {
                    HomeAvatarHelper.clearAvatar();
                } else {
                    HomeAvatarHelper.saveAvatar(avatar);
                }
                String lastAvatar = HomeAvatarHelper.getLastAvatar();
                this.mAvatarUrl = avatar;
                this.mVerifyAvatar.displayAvatar(this.mAvatarUrl, VerifyAnimationAvatarFrameLayout.VType.IMG, lastAvatar, lastAvatar, tv.danmaku.bili.R.drawable.bili_shape_home_login_avatar_placeholder, tv.danmaku.bili.R.drawable.bili_shape_home_login_avatar_placeholder);
                BLog.dfmt(TAG, "syncToolBarAvatar-> avatar(%s)", this.mAvatarUrl);
            }
            MainResourceManager.TopLeftInfo topLeftInfo = HomeTopLeftStateHolderKt.getTopLeftInfo();
            if (HomeTopLeftStateHolderKt.hasEnableShowGuideBubble(info, topLeftInfo)) {
                this.isHasShowGameBubble = true;
                showTopLeftGameBubbleGuidance(info, topLeftInfo);
            }
            if (topLeftInfo != null && HomeTopLeftStateHolderKt.useAvatarWithPendentStyle() && !this.isHasShowGameBubble) {
                if (this.mAvatarRectContainer != null) {
                    this.mAvatarRectContainer.setVisibility(0);
                }
                HomeAvatarHelper.setAvatarStyle(this.mVerifyAvatar, true);
                HomeAvatarHelper.setAvatarRectRes(this.mAvatarRectBg, this.mAvatarRect, topLeftInfo);
                HomeAvatarHelper.tryShowAvatarEntranceAnimation(this.mVerifyAvatar, this.mAvatarRectContainer);
                updateEntranceRect();
            } else {
                HomeStoryEntranceAnimationKt.clearPendingAnimations();
                HomeStoryEntranceAnimationKt.clearRunningAnimations();
                HomeAvatarHelper.setAvatarStyle(this.mVerifyAvatar, false);
                HomeAvatarHelper.shownTagThisTime = false;
                if (this.mAvatarRectContainer != null) {
                    this.mAvatarRectContainer.setVisibility(8);
                }
            }
            this.isHasShowGameBubble = false;
            return;
        }
        HomeAvatarHelper.shownTagThisTime = false;
        if (this.mAvatarRectContainer != null) {
            this.mAvatarRectContainer.setVisibility(8);
        }
        this.mAvatarUrl = null;
        HomeAvatarHelper.clearAvatar();
        HomeNoLoginAvatar avatar2 = MainResourceManager.getInstance().getNoLoginAvatar();
        this.mHomeNoLoginAvatar = avatar2;
        if (avatar2 == null || StringUtil.isBlank(avatar2.url)) {
            this.mVerifyAvatar.displayAvatar(com.bilibili.lib.basecomponent.R.drawable.bili_nologin_avatar);
        } else {
            this.mVerifyAvatar.displayAvatar(avatar2.url, avatar2.type, com.bilibili.lib.basecomponent.R.drawable.bili_nologin_avatar, com.bilibili.lib.basecomponent.R.drawable.bili_nologin_avatar);
        }
        this.mVerifyAvatar.setVerifyImgVisibility(8);
    }

    private void showTopLeftGameBubbleGuidance(AccountInfo info, MainResourceManager.TopLeftInfo topLeftInfo) {
        if (topLeftInfo != null && topLeftInfo.bubbles != null && topLeftInfo.bubbles.size() > 1) {
            final MainResourceManager.TopLeftBubble bubble = topLeftInfo.bubbles.get(1);
            if (bubble.type == 1) {
                final String recordId = "sp_has_shown_game_guide_click_" + bubble.id + "_" + info.getMid();
                HandlerThreads.post(0, new Runnable() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment$$ExternalSyntheticLambda14
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseMainFrameFragment.this.m2005lambda$showTopLeftGameBubbleGuidance$12$tvdanmakubiliuimain2basicBaseMainFrameFragment(bubble, recordId);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$showTopLeftGameBubbleGuidance$12$tv-danmaku-bili-ui-main2-basic-BaseMainFrameFragment  reason: not valid java name */
    public /* synthetic */ void m2005lambda$showTopLeftGameBubbleGuidance$12$tvdanmakubiliuimain2basicBaseMainFrameFragment(MainResourceManager.TopLeftBubble bubble, String recordId) {
        new HomeTopLeftClickGuidance().show(this.mVerifyAvatar, bubble, recordId, this);
    }

    private void showTopLeftClickGuidance() {
        MainResourceManager.TopLeftInfo topLeftInfo = HomeTopLeftStateHolderKt.getTopLeftInfo();
        AccountInfo info = BiliAccountInfo.get().getAccountInfoFromCache();
        if (!this.isSplashShowing && topLeftInfo != null && topLeftInfo.bubbles != null && !topLeftInfo.bubbles.isEmpty() && topLeftInfo.hitRecentTabExp() && HomeTopLeftStateHolderKt.getCurrentHomeSideCenterTab() == HomeSideCenterTab.RECENT && info != null) {
            final MainResourceManager.TopLeftBubble bubble = topLeftInfo.bubbles.get(0);
            final String recordId = "sp_has_shown_top_left_click_" + bubble.id + "_" + info.getMid();
            if (HomeTopLeftClickGuidanceKt.canShowTopLeftClickGuidance(recordId)) {
                HandlerThreads.postDelayed(0, new Runnable() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseMainFrameFragment.this.m2004lambda$showTopLeftClickGuidance$13$tvdanmakubiliuimain2basicBaseMainFrameFragment(bubble, recordId);
                    }
                }, (long) FdDebugActivity.UPDATE_DELAY_TIME);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$showTopLeftClickGuidance$13$tv-danmaku-bili-ui-main2-basic-BaseMainFrameFragment  reason: not valid java name */
    public /* synthetic */ void m2004lambda$showTopLeftClickGuidance$13$tvdanmakubiliuimain2basicBaseMainFrameFragment(MainResourceManager.TopLeftBubble bubble, String recordId) {
        new HomeTopLeftClickGuidance().show(this.mVerifyAvatar, bubble, recordId, this);
    }

    private void resetAvatarStyle() {
        if (this.mAvatarLayout != null) {
            this.mAvatarLayout.setVisibility(this.mShowAvatar ? 0 : 8);
        }
        if (this.mExpandSearch != null && this.mExpandSearch.getLayoutParams() != null) {
            ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) this.mExpandSearch.getLayoutParams();
            lp.setMarginStart(DpUtils.INSTANCE.dp2Px(14));
            this.mExpandSearch.setLayoutParams(lp);
        }
    }

    public void onSkinChange(Garb skin) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        if (this.mHomeFloatViewHelper != null) {
            this.mHomeFloatViewHelper.disMiss();
            this.mHomeFloatViewHelper = null;
        }
        Garb garbWithNightMode = GarbManager.getGarbWithNightMode(context);
        if (garbWithNightMode.getId() != BottomBubbleHelper.getCurbGarbId()) {
            BottomBubbleHelper.dismissWindow(false);
            BottomBubbleHelper.resetLastShow();
            if (this.mBottomNav != null) {
                this.mBottomNav.resetAllBubbleStatus();
            }
            BottomBubbleHelper.setGarbId(garbWithNightMode.getId());
        }
        updateBottomTab(garbWithNightMode, false);
        if (skin.isPure()) {
            if (!this.mIsToolbarColorUpdated) {
                if (garbWithNightMode.isPure()) {
                    resetMainTopBg(0L);
                } else {
                    changeUiWithGarb(garbWithNightMode);
                }
            }
        } else {
            changeUiWithGarb(skin);
        }
        removeBadges();
        initBadges();
    }

    private void updateBottomTab(Garb curGarb, boolean changeConfiguration) {
        if (this.mBottomNav != null) {
            List<TabHost.TabInfo> tabs = this.mBottomNav.getTabs();
            int tabSize = tabs.size();
            this.mTabGarbProvider.rebuild(curGarb, tabSize);
            if (this.mCurrentGarbId != curGarb.getId()) {
                this.mBottomNav.clearDrawablesCache();
                this.mCurrentGarbId = curGarb.getId();
            }
            if (this.mTabGarbProvider.hasBottomGarb()) {
                this.mBottomNav.renderBgWithGarb(curGarb, changeConfiguration);
            } else {
                this.mBottomNav.renderBg();
            }
            for (int index = 0; index < tabSize; index++) {
                TabHost.TabInfo tabInfo = tabs.get(index);
                this.mTabGarbProvider.provide(this.mBottomNav.getContext(), tabInfo, index);
            }
            this.mBottomNav.refreshTab(tabs);
        }
    }

    private void changeUiWithGarb(Garb skin) {
        if (!this.mIsToolbarColorUpdated || !skin.getChangeable()) {
            updateMainTopBgWithGarb(skin, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.ui.main2.MainPagerFragmentV2
    public Toolbar getBar() {
        return this.mToolbar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initToolbar(NavigationInfo nav) {
        Context context = getContext();
        if (nav == null || context == null) {
            return;
        }
        if (this.mMainBehavior == null) {
            CoordinatorLayout.LayoutParams layoutParams = this.content.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                this.mMainBehavior = layoutParams.getBehavior();
            }
        }
        this.mShowAvatar = nav.mPageInfo.isShowAvatar();
        if (!this.mShowAvatar) {
            this.mAvatarLayout.setVisibility(8);
        } else {
            resetAvatarStyle();
        }
        Garb garb = GarbManager.getGarbWithNightMode(context);
        boolean showSearch = true;
        boolean showGarbBg = nav.mPageInfo.isShowGarbBg() && !garb.isPure();
        this.mMainTopBgImageView.setVisibility(showGarbBg ? 0 : 8);
        boolean showAppbarLayout = nav.mPageInfo.isShowAppbar();
        CoordinatorLayout.LayoutParams layoutParams2 = this.content.getLayoutParams();
        if (showAppbarLayout) {
            if ((layoutParams2 instanceof CoordinatorLayout.LayoutParams) && this.mMainBehavior != null) {
                layoutParams2.setBehavior(this.mMainBehavior);
            }
            ViewGroup.MarginLayoutParams toolbarParams = (ViewGroup.MarginLayoutParams) this.mAppBarLayout.getLayoutParams();
            toolbarParams.topMargin = this.statusBarHeight;
            toolbarParams.height = -2;
            this.mAppBarLayout.setLayoutParams(toolbarParams);
        } else {
            if (layoutParams2 instanceof CoordinatorLayout.LayoutParams) {
                CoordinatorLayout.Behavior behavior = layoutParams2.getBehavior();
                if (behavior instanceof PinnedBottomScrollingBehavior) {
                    layoutParams2.setBehavior((CoordinatorLayout.Behavior) null);
                }
            }
            ViewGroup.MarginLayoutParams toolbarParams2 = (ViewGroup.MarginLayoutParams) this.mAppBarLayout.getLayoutParams();
            toolbarParams2.height = 0;
            this.content.setPadding(0, 0, 0, 0);
            this.mAppBarLayout.setLayoutParams(toolbarParams2);
        }
        boolean isTeenagerMode = TeenagersMode.getInstance().isEnable();
        if (!nav.mPageInfo.isShowExpandSearch() || TeenagersMode.getInstance().isEnable("search") || RestrictedMode.isEnable(RestrictedType.LESSONS, "search")) {
            showSearch = false;
        }
        boolean showTitle = nav.mPageInfo.isShowTitle();
        boolean enableToolbarScroll = nav.mPageInfo.isEnableToolbarScroll();
        this.mBaseMainViewModel.update(new ToolbarEvent.EnableScroll(enableToolbarScroll));
        refreshTab(nav.mPage.url);
        if (this.mTabs.getVisibility() == 0) {
            this.mExpandSearch.setVisibility(8);
            this.mNickName.setVisibility(8);
            this.mIconTeenUmbrella.setVisibility(8);
        } else if (isTeenagerMode) {
            if (nav.mPageInfo.isShowExpandSearch() && TeenagersModeConfigKt.isEnableSearchInTeenagersMode()) {
                this.mExpandSearch.setVisibility(0);
                this.mNickName.setVisibility(8);
                this.mIconTeenUmbrella.setVisibility(0);
            } else {
                this.mExpandSearch.setVisibility(8);
                this.mNickName.setVisibility(0);
                this.mNickName.setText(bili.resource.others.R.string.others_global_string_176);
                this.mIconTeenUmbrella.setVisibility(0);
            }
        } else if (showSearch) {
            this.mExpandSearch.setVisibility(0);
            this.mNickName.setVisibility(8);
            this.mIconTeenUmbrella.setVisibility(8);
        } else if (showTitle) {
            this.mExpandSearch.setVisibility(8);
            this.mNickName.setVisibility(0);
            this.mIconTeenUmbrella.setVisibility(8);
            this.mNickName.setText(nav.getDisplayTitle());
        } else {
            this.mExpandSearch.setVisibility(8);
            this.mNickName.setVisibility(8);
            this.mIconTeenUmbrella.setVisibility(8);
        }
        if (!isToolbarColorUpdated()) {
            if (!garb.isPure()) {
                if (!garb.isPrimaryOnly() || showGarbBg) {
                    updateMainTopBgWithGarb(garb, 0L);
                    return;
                }
                return;
            }
            resetMainTopBg(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryToMoveToOriginPosition(Context context) {
        if (this.needAppendOffset) {
            this.needAppendOffset = false;
            IScrollable curIPrimaryPageFragment = this.mPageManager.getCurIPrimaryPageFragment();
            if (curIPrimaryPageFragment instanceof IScrollable) {
                int toolbarHeight = context.getResources().getDimensionPixelSize(com.bilibili.lib.basecomponent.R.dimen.navigation_top_bar_size);
                curIPrimaryPageFragment.scrollUp(toolbarHeight);
            }
        }
    }

    private void tintStatusBarNormal() {
        FragmentActivity activity = getActivity();
        IDrawerHost drawerHost = findDrawerHost();
        if (activity != null && drawerHost != null) {
            drawerHost.tintStatusBarPureForDrawer();
        }
    }

    private void showBadge(int index, Badge badge, Garb garb) {
        if (badge == null || badge == Badge.NONE) {
            hideBadge(index);
        } else if (this.mNavViewHelper != null) {
            this.mNavViewHelper.showBadge(index, badge, garb);
        }
    }

    public void onResume() {
        super.onResume();
        if (findDrawerHost() != null) {
            this.mBottomNav.post(new Runnable() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    BaseMainFrameFragment.this.showBottomBubbleIfNeed();
                }
            });
        }
        if (this.mAppBarLayout.getVisibility() == 0) {
            tryToMoveToOriginPosition(getApplicationContext());
            this.mBaseMainViewModel.update(new ToolbarEvent.ExpandToolbar(true, false));
        }
    }

    public void showBottomBubbleIfNeed() {
        if (this.mBottomNav != null && this.mNavViewHelper != null) {
            BottomBubbleHelper.showWindowFromLoginCacheIfNeed(getActivity(), this.mBottomNav, this.mNavViewHelper);
        }
    }

    private void hideBadge(int index) {
        if (this.mNavViewHelper != null) {
            this.mNavViewHelper.hideBadge(index);
        }
    }

    private IDrawerHost findDrawerHost() {
        IDrawerHost activity = getActivity();
        if (activity instanceof IDrawerHost) {
            return activity;
        }
        return null;
    }

    @Override // tv.danmaku.bili.ui.main2.basic.IMainFragmentHost
    public void updateMainTopBg(SecondaryPageExtension pageExtension, SecondaryPageExtraInfo pageExtraInfo, long duration) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        ImageView imageView = null;
        if (pageExtraInfo != null) {
            if (pageExtraInfo.isDrawableValid()) {
                if (pageExtraInfo.getTopBgDrawable() != null && pageExtraInfo.getFontColor() != 0) {
                    startToolbarBgImageAnimator(this.mCurrentBgDrawable, pageExtraInfo.getTopBgDrawable(), duration, new Runnable() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment.13
                        @Override // java.lang.Runnable
                        public void run() {
                            BaseMainFrameFragment.this.mMainTopBgImageView.setVisibility(0);
                        }
                    });
                    changeUiTask(pageExtraInfo.getFontColor(), pageExtraInfo.isDarkMode());
                }
            } else if (pageExtraInfo.isColorValid()) {
                int fontColor = pageExtraInfo.getFontColor();
                int bgStartColor = pageExtraInfo.getBgStartColor();
                int bgCenterColor = pageExtraInfo.getBgCenterColor();
                boolean isTabsImageVisible = this.mMainTopBgImageView.getVisibility() == 0;
                int i = isTabsImageVisible ? bgStartColor : this.mCurrentBgStartColor;
                int i2 = isTabsImageVisible ? bgCenterColor : this.mCurrentBgEndColor;
                if (isTabsImageVisible) {
                    imageView = this.mMainTopBgImageView;
                }
                startToolbarBgColorAnimator(i, i2, bgStartColor, bgCenterColor, imageView, duration, new Runnable() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment$$ExternalSyntheticLambda16
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseMainFrameFragment.this.m2009lambda$updateMainTopBg$14$tvdanmakubiliuimain2basicBaseMainFrameFragment();
                    }
                });
                changeUiTask(fontColor, pageExtraInfo.isDarkMode());
            }
        } else if (pageExtension != null) {
            if (pageExtension.isTobTabBgValid()) {
                if (AnimateResourceManager.isResDownload(context, pageExtension.topBgUrl)) {
                    String path = AnimateResourceManager.getBitmapRes(context, pageExtension.topBgUrl);
                    if (TextUtils.isEmpty(path)) {
                        return;
                    }
                    BitmapDrawable bitmapDrawable = getDrawableFromFile(context, path);
                    if (bitmapDrawable != null) {
                        startToolbarBgImageAnimator(this.mCurrentBgDrawable, bitmapDrawable, duration, new Runnable() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment.14
                            @Override // java.lang.Runnable
                            public void run() {
                                BaseMainFrameFragment.this.mMainTopBgImageView.setVisibility(0);
                            }
                        });
                        changeUiTask(pageExtension.fontColor, pageExtension.isDarkMode());
                    }
                }
            } else if (pageExtension.isColorValid()) {
                int bgStartColor2 = pageExtension.bgStartColor;
                int bgCenterColor2 = pageExtension.bgCenterColor;
                int highlightColor = pageExtension.fontColor;
                boolean isMainTobBgViewVisible = this.mMainTopBgImageView.getVisibility() == 0;
                int i3 = isMainTobBgViewVisible ? bgStartColor2 : this.mCurrentBgStartColor;
                int i4 = isMainTobBgViewVisible ? bgCenterColor2 : this.mCurrentBgEndColor;
                if (isMainTobBgViewVisible) {
                    imageView = this.mMainTopBgImageView;
                }
                startToolbarBgColorAnimator(i3, i4, bgStartColor2, bgCenterColor2, imageView, duration, new Runnable() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment$$ExternalSyntheticLambda17
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseMainFrameFragment.this.m2010lambda$updateMainTopBg$15$tvdanmakubiliuimain2basicBaseMainFrameFragment();
                    }
                });
                changeUiTask(highlightColor, pageExtension.isDarkMode());
            }
        }
        this.mIsToolbarColorUpdated = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$updateMainTopBg$14$tv-danmaku-bili-ui-main2-basic-BaseMainFrameFragment  reason: not valid java name */
    public /* synthetic */ void m2009lambda$updateMainTopBg$14$tvdanmakubiliuimain2basicBaseMainFrameFragment() {
        this.mMainTopBgImageView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$updateMainTopBg$15$tv-danmaku-bili-ui-main2-basic-BaseMainFrameFragment  reason: not valid java name */
    public /* synthetic */ void m2010lambda$updateMainTopBg$15$tvdanmakubiliuimain2basicBaseMainFrameFragment() {
        this.mMainTopBgImageView.setVisibility(8);
    }

    private void changeUiTask(int highlightColor, boolean isDarkMode) {
        this.mIconColor = ColorUtils.setAlphaComponent(highlightColor, (int) BR.followDesc);
        int searchBarTextColor = ColorUtils.setAlphaComponent(highlightColor, (int) BR.countdownTrackEnabled);
        this.mSearchTextView.setTintable(false);
        this.mSearchTextView.setTextColor(searchBarTextColor);
        GradientDrawable searchBgDrawable = (GradientDrawable) this.mExpandSearch.getBackground();
        if (searchBgDrawable != null) {
            searchBgDrawable.setColor(ColorUtils.setAlphaComponent(highlightColor, 61));
        }
        Drawable searchBarDrawable = this.mSearchIcon.getDrawable();
        if (searchBarDrawable != null) {
            ThemeUtils.tintDrawable(searchBarDrawable, searchBarTextColor);
        }
        tintMenuIcon(this.mIconColor, false);
        Activity activity = ActivityUtils.getWrapperActivity(getActivity());
        if (activity instanceof IDrawerHost) {
            StatusBarCompat.tintStatusBarForDrawer(activity, 0, isDarkMode ? 1 : 2);
        }
    }

    @Override // tv.danmaku.bili.ui.main2.basic.IMainFragmentHost
    public void updateMainTopBgWithGarb(Garb skin, long duration) {
        Context context = getContext();
        String bgPath = skin.getHeadBgPath();
        if (TextUtils.isEmpty(bgPath) || skin.getMainFontColor() == 0 || context == null) {
            resetMainTopBg(duration);
            return;
        }
        BitmapDrawable bgDrawable = getDrawableFromFile(context, bgPath);
        if (bgDrawable != null) {
            startToolbarBgImageAnimator(this.mCurrentBgDrawable, bgDrawable, duration, null);
            int iconColor = ColorUtils.setAlphaComponent(skin.getMainFontColor(), (int) BR.followDesc);
            this.mExpandSearch.setBackgroundResource(com.bilibili.app.comm.listwidget.R.drawable.bg_roundrect_search_view_background_white_r16);
            if (this.ffSearchBar2Exp1 || this.ffSearchBar2Exp2) {
                this.mSearchTextView.setTintable(true);
                this.mSearchTextView.setTextColor(ContextCompat.getColor(context, com.bilibili.lib.theme.R.color.Ga7_u));
                ((GradientDrawable) this.mExpandSearch.getBackground()).setCornerRadius(DpUtils.INSTANCE.dp2Px(17));
                this.mSearchIcon.setImageTintList(com.bilibili.lib.theme.R.color.Ga7_u);
            } else {
                this.mSearchTextView.setTintable(false);
                this.mSearchTextView.setTextColor(ContextCompat.getColor(context, com.bilibili.lib.theme.R.color.Ga7_u));
                this.mSearchIcon.setImageTintList(com.bilibili.lib.theme.R.color.Ga5_u);
            }
            GradientDrawable searchBgDrawable = (GradientDrawable) this.mExpandSearch.getBackground();
            if (searchBgDrawable != null) {
                searchBgDrawable.setColor(ContextCompat.getColor(context, com.bilibili.lib.theme.R.color.Wh0_u));
            }
            int fontColor = skin.getMainFontColor();
            this.mNickName.setTextColor(fontColor);
            this.mIconTeenUmbrella.setColorFilter(fontColor);
            int textColor = ColorUtils.setAlphaComponent(fontColor, (int) BR.followDesc);
            this.mTabs.setIndicatorColor(fontColor);
            int[] tabColor = {fontColor, fontColor, textColor};
            int[][] state = {new int[]{16842913}, new int[]{16842919}, new int[0]};
            ColorStateList tabColorState = new ColorStateList(state, tabColor);
            this.mTabs.setTextColor(tabColorState);
            this.mTabs.setTintable(false);
            tintMenuIcon(iconColor, false);
            Activity activity = ActivityUtils.getWrapperActivity(context);
            if (activity instanceof IDrawerHost) {
                StatusBarCompat.tintStatusBarForDrawer(activity, 0, skin.isMainDarkMode() ? 1 : 2);
            }
        } else {
            this.mMainTopBgImageView.setVisibility(8);
            int defaultBgColor = ThemeUtils.getColorById(getActivity(), com.bilibili.app.comm.baseres.R.color.theme_color_primary_tr_background);
            int[] iArr = this.mBgColors;
            this.mBgColors[1] = defaultBgColor;
            iArr[0] = defaultBgColor;
            this.mMainTopLayoutBgDrawable.setColors(this.mBgColors);
            this.mMainTopLayout.setBackground(this.mMainTopLayoutBgDrawable);
            this.mCurrentBgStartColor = defaultBgColor;
            this.mCurrentBgEndColor = defaultBgColor;
        }
        this.mAvatarRectBg.setColorFilter(getTabBgMainColor(context, bgDrawable));
        this.mIsToolbarColorUpdated = false;
    }

    private int getTabBgMainColor(Context context, BitmapDrawable bitmapDrawable) {
        Bitmap bitmap;
        int defaultBgColor = ThemeUtils.getColorById(context, com.bilibili.app.comm.baseres.R.color.theme_color_primary_tr_background);
        if (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null) {
            BLog.i(TAG, "bitmap is null get default color");
            return defaultBgColor;
        }
        try {
            int bitmapBottomColor = bitmap.getPixel(1, bitmap.getHeight() - 1);
            if (HomeAvatarHelper.usePixelColor()) {
                return bitmapBottomColor;
            }
            return Palette.from(bitmap).generate().getDominantColor(bitmapBottomColor);
        } catch (Exception e) {
            return defaultBgColor;
        }
    }

    private void startToolbarBgColorAnimator(int fromStartBgColor, int fromEndBgColor, final int toStartBgColor, final int toEndBgColor, final ImageView bgView, long duration, final Runnable endAction) {
        int fromStartBgColor2;
        int fromEndBgColor2;
        Context context = getContext();
        if (context == null) {
            return;
        }
        int defaultColor = ThemeUtils.getColorById(getContext(), com.bilibili.app.comm.baseres.R.color.daynight_color_background_card);
        if (fromStartBgColor != 0) {
            fromStartBgColor2 = fromStartBgColor;
        } else {
            fromStartBgColor2 = defaultColor;
        }
        if (fromEndBgColor != 0) {
            fromEndBgColor2 = fromEndBgColor;
        } else {
            fromEndBgColor2 = defaultColor;
        }
        final ArgbEvaluator argbEvaluator = new ArgbEvaluator();
        if (this.mAnimator != null && this.mAnimator.isRunning()) {
            this.mAnimator.end();
        }
        this.mAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mAnimator.setDuration(duration);
        final int finalStartColor = fromStartBgColor2;
        final int finalEndColor = fromEndBgColor2;
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment$$ExternalSyntheticLambda11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                BaseMainFrameFragment.this.m2006lambda$startToolbarBgColorAnimator$16$tvdanmakubiliuimain2basicBaseMainFrameFragment(argbEvaluator, finalStartColor, toStartBgColor, finalEndColor, toEndBgColor, bgView, valueAnimator);
            }
        });
        this.mAnimator.addListener(new AnimatorListenerAdapter() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment.15
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                BaseMainFrameFragment.this.mCurrentBgStartColor = toStartBgColor;
                BaseMainFrameFragment.this.mCurrentBgEndColor = toEndBgColor;
                BaseMainFrameFragment.this.mCurrentBgDrawable = null;
                if (endAction != null) {
                    endAction.run();
                }
            }
        });
        this.mAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$startToolbarBgColorAnimator$16$tv-danmaku-bili-ui-main2-basic-BaseMainFrameFragment  reason: not valid java name */
    public /* synthetic */ void m2006lambda$startToolbarBgColorAnimator$16$tvdanmakubiliuimain2basicBaseMainFrameFragment(ArgbEvaluator argbEvaluator, int finalStartColor, int toStartBgColor, int finalEndColor, int toEndBgColor, ImageView bgView, ValueAnimator animation) {
        float value = ((Float) animation.getAnimatedValue()).floatValue();
        this.mBgColors[0] = ((Integer) argbEvaluator.evaluate(value, Integer.valueOf(finalStartColor), Integer.valueOf(toStartBgColor))).intValue();
        this.mBgColors[1] = ((Integer) argbEvaluator.evaluate(value, Integer.valueOf(finalEndColor), Integer.valueOf(toEndBgColor))).intValue();
        this.mMainTopLayoutBgDrawable.setColors(this.mBgColors);
        if (bgView != null) {
            bgView.setAlpha(1.0f - value);
        }
    }

    private void startToolbarBgImageAnimator(final Drawable bgImageViewFrom, Drawable bgImageViewTo, long duration, final Runnable endAction) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        this.mCurrentBgDrawable = bgImageViewTo;
        this.mMainTopBgImageView.setAlpha(1.0f);
        this.mMainTopBgImageView.setVisibility(0);
        if (bgImageViewFrom != null && bgImageViewFrom != bgImageViewTo) {
            Drawable[] drawables = {bgImageViewFrom, bgImageViewTo};
            TransitionDrawable transitionDrawable = new TransitionDrawable(drawables);
            this.mMainTopBgImageView.setImageDrawable(transitionDrawable);
            transitionDrawable.startTransition((int) duration);
        } else {
            this.mMainTopBgImageView.setImageDrawable(bgImageViewTo);
        }
        if (this.mBgImageAnimator != null && this.mBgImageAnimator.isRunning()) {
            this.mBgImageAnimator.end();
        }
        this.mBgImageAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mBgImageAnimator.setDuration(duration);
        this.mBgImageAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment$$ExternalSyntheticLambda7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                BaseMainFrameFragment.this.m2007lambda$startToolbarBgImageAnimator$17$tvdanmakubiliuimain2basicBaseMainFrameFragment(bgImageViewFrom, valueAnimator);
            }
        });
        this.mBgImageAnimator.addListener(new AnimatorListenerAdapter() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment.16
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
    /* renamed from: lambda$startToolbarBgImageAnimator$17$tv-danmaku-bili-ui-main2-basic-BaseMainFrameFragment  reason: not valid java name */
    public /* synthetic */ void m2007lambda$startToolbarBgImageAnimator$17$tvdanmakubiliuimain2basicBaseMainFrameFragment(Drawable bgImageViewFrom, ValueAnimator animation) {
        float per = ((Float) animation.getAnimatedValue()).floatValue();
        if (bgImageViewFrom == null) {
            this.mMainTopBgImageView.setAlpha(per);
        }
    }

    @Override // tv.danmaku.bili.ui.main2.basic.IMainFragmentHost
    public void resetMainTopBg(long duration) {
        int colorById;
        Context context = getContext();
        if (context == null) {
            return;
        }
        this.mIsToolbarColorUpdated = false;
        int defaultColor = ThemeUtils.getColorById(getContext(), com.bilibili.app.comm.baseres.R.color.daynight_color_background_card);
        int curStartBgColor = this.mCurrentBgStartColor == 0 ? defaultColor : this.mCurrentBgStartColor;
        int curEndBgColor = this.mCurrentBgEndColor == 0 ? defaultColor : this.mCurrentBgEndColor;
        int targetBgColor = ThemeUtils.getColorById(context, com.bilibili.app.comm.baseres.R.color.theme_color_primary_tr_background);
        startToolbarBgColorAnimator(curStartBgColor, curEndBgColor, targetBgColor, targetBgColor, this.mMainTopBgImageView.getVisibility() == 0 ? this.mMainTopBgImageView : null, duration, new Runnable() { // from class: tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                BaseMainFrameFragment.this.m2003lambda$resetMainTopBg$18$tvdanmakubiliuimain2basicBaseMainFrameFragment();
            }
        });
        this.mSearchTextView.setTintable(true);
        this.mSearchTextView.setTextColor(ContextCompat.getColor(context, com.bilibili.lib.theme.R.color.Text2));
        if (this.ffSearchBar2Exp1 || this.ffSearchBar2Exp2) {
            this.mSearchIcon.setImageTintList(com.bilibili.lib.theme.R.color.Graph_bold);
        } else {
            this.mSearchIcon.setImageTintList(com.bilibili.lib.theme.R.color.Graph_medium);
        }
        if (GarbManager.getCurGarb().isPink() || MultipleThemeUtils.isExtraTheme(context)) {
            this.mExpandSearch.setBackgroundResource(com.bilibili.app.comm.listwidget.R.drawable.bg_roundrect_search_view_background_white_r16);
            GradientDrawable searchBgDrawable = (GradientDrawable) this.mExpandSearch.getBackground();
            searchBgDrawable.setColor(ContextCompat.getColor(context, com.bilibili.lib.theme.R.color.Graph_white));
            if (this.ffSearchBar2Exp1 || this.ffSearchBar2Exp2) {
                searchBgDrawable.setCornerRadius(DpUtils.INSTANCE.dp2Px(17));
            }
        } else if (GarbManager.getCurGarb().isPure() && (MultipleThemeUtils.isWhiteTheme(context) || MultipleThemeUtils.isNightTheme(context))) {
            if (this.ffSearchBar2Exp2) {
                this.mExpandSearch.setBackgroundResource(com.bilibili.app.comm.listwidget.R.drawable.bg_roundrect_search_view_bg_pink_stroke_white_r17_w1dp);
            } else {
                this.mExpandSearch.setBackgroundResource(com.bilibili.app.comm.listwidget.R.drawable.bg_roundrect_search_view_background_stroke_white_r16);
                if (this.ffSearchBar2Exp1) {
                    ((GradientDrawable) this.mExpandSearch.getBackground()).setCornerRadius(DpUtils.INSTANCE.dp2Px(17));
                    this.mExpandSearch.setBackgroundResource(com.bilibili.app.comm.listwidget.R.drawable.bg_roundrect_search_view_bg_stroke_white_r17_w1dp);
                }
            }
        }
        this.mNickName.tint();
        TintImageView tintImageView = this.mIconTeenUmbrella;
        if (MultipleThemeUtils.isWhiteTheme(context) || MultipleThemeUtils.isNightTheme(context)) {
            colorById = ThemeUtils.getColorById(context, com.bilibili.lib.theme.R.color.Graph_icon);
        } else {
            colorById = ThemeUtils.getColorById(context, com.bilibili.app.comm.baseres.R.color.theme_color_primary_tr_title);
        }
        tintImageView.setColorFilter(colorById);
        if (MultipleThemeUtils.isNightTheme(getActivity())) {
            this.mTabs.resetTextColor();
            int highlightColor = ThemeUtils.getColorById(context, com.bilibili.app.comm.baseres.R.color.theme_color_secondary);
            this.mTabs.setIndicatorColor(highlightColor);
        } else {
            int tabColorSelected = ThemeUtils.getColorById(context, com.bilibili.app.comm.baseres.R.color.theme_color_tab_pink);
            int tabColorDefault = ThemeUtils.getColorById(context, com.bilibili.app.comm.baseres.R.color.theme_color_primary_tr_text_other);
            int[] tabColor = {tabColorSelected, tabColorSelected, tabColorDefault};
            int[][] state = {new int[]{16842913}, new int[]{16842919}, new int[0]};
            ColorStateList tabColorState = new ColorStateList(state, tabColor);
            this.mTabs.setIndicatorColor(tabColorSelected);
            this.mTabs.setTextColor(tabColorState);
        }
        this.mTabs.setTintable(true);
        tintMenuIcon(ThemeUtils.getColorById(context, com.bilibili.app.comm.baseres.R.color.theme_color_primary_tr_icon), true);
        tintStatusBarNormal();
        this.mAvatarRectBg.setColorFilter(ThemeUtils.getColorById(context, com.bilibili.app.comm.baseres.R.color.theme_color_primary_tr_background));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$resetMainTopBg$18$tv-danmaku-bili-ui-main2-basic-BaseMainFrameFragment  reason: not valid java name */
    public /* synthetic */ void m2003lambda$resetMainTopBg$18$tvdanmakubiliuimain2basicBaseMainFrameFragment() {
        this.mMainTopBgImageView.setVisibility(8);
    }

    private void tintMenuIcon(int tintColor, boolean tintable) {
        if (this.mToolbar == null) {
            return;
        }
        Menu menu = this.mToolbar.getMenu();
        for (int i = 0; i < menu.size(); i++) {
            MenuItem menuItem = menu.getItem(i);
            MenuActionView actionView = menuItem.getActionView();
            if (actionView instanceof MenuActionView) {
                MenuActionView actionView2 = actionView;
                if (!actionView2.hasIconTintColor()) {
                    actionView2.setIconTintColorWithGarb(tintColor);
                    actionView2.setTintable(tintable);
                }
            }
        }
        this.mAvatarRect.setColorFilter(tintColor);
    }

    @Override // tv.danmaku.bili.ui.main2.basic.IMainFragmentHost
    public void changeIsCustomTab(boolean isCustomTab) {
        this.mIsToolbarColorUpdated = isCustomTab;
    }

    public boolean isToolbarColorUpdated() {
        return this.mIsToolbarColorUpdated;
    }

    private void refreshTab(String key) {
        PrimaryPageManager.PrimaryPage current = this.mPageManager.current();
        if (current == null) {
            this.mTabs.setVisibility(8);
        } else if (!key.equals(this.mPageManager.getCurPageUrl())) {
            BLog.w(TAG, "Tab refresh error,invalid key or not current fragment:" + key);
            this.mTabs.setVisibility(8);
        } else {
            ISlidingPageFragment pageFragment = current.getPageFragment();
            if (pageFragment == null) {
                this.mTabs.setVisibility(8);
            } else if (!(pageFragment instanceof ISlidingPageFragment)) {
                this.mTabs.setVisibility(8);
            } else {
                ViewPager viewPager = pageFragment.getViewPagerInstance();
                if (viewPager != null) {
                    this.mTabs.setViewPager(viewPager);
                    this.mTabs.setVisibility(0);
                    return;
                }
                this.mTabs.setViewPager((ViewPager) null);
                this.mTabs.setVisibility(8);
            }
        }
    }

    public boolean showTabDot(int tabPositions) {
        PrimaryPageManager.PrimaryPage current = this.mPageManager.current();
        if (current == null || !(current.getPageFragment() instanceof ITabControlFragment)) {
            return false;
        }
        return current.getPageFragment().showTabDot(tabPositions);
    }

    public void onTabLayoutComplete(ViewGroup tabContainer) {
        PrimaryPageManager.PrimaryPage current;
        if (tabContainer != null && (current = this.mPageManager.current()) != null && (current.getPageFragment() instanceof ITabControlFragment)) {
            current.getPageFragment().onTabLayoutComplete(tabContainer);
        }
    }

    @Override // tv.danmaku.bili.ui.main2.resource.MainResourceManager.IMenuChangeListener
    public void onMenuChanged(List<tv.danmaku.bili.ui.main2.resource.MenuItem> updateList) {
        if (isResumed() && "1".equals(ConfigManager.config().get("home.menu_update_enable", "0"))) {
            tryUpdateIncrementTopMenu(0);
        }
    }

    private BitmapDrawable getDrawableFromFile(Context context, String path) {
        BitmapDrawable drawable = this.mBgDrawableCache.get(path);
        if (drawable == null) {
            try {
                File file = new File(URI.create(path));
                Bitmap bitmap = BitmapFactory.decodeFile(file.getPath());
                drawable = new BitmapDrawable(context.getResources(), bitmap);
                this.mBgDrawableCache.put(path, drawable);
                return drawable;
            } catch (IllegalArgumentException e) {
                return drawable;
            }
        }
        return drawable;
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        dismissHomeFloatView();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Garb garb = GarbManager.getGarbWithNightMode(activity);
            updateBottomTab(garb, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isHomeFloatViewShowing() {
        return this.mHomeFloatViewHelper != null && this.mHomeFloatViewHelper.isShowing();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dismissHomeFloatView() {
        if (this.mHomeFloatViewHelper != null) {
            this.mHomeFloatViewHelper.disMiss();
        }
    }

    public void updateMainAppBarExpand(MainTopBehavior behavior) {
        if (this.mAppBarLayout != null) {
            this.mBaseMainViewModel.update(new ToolbarEvent.ExpandToolbar(behavior.getExpand(), behavior.getAnimate()));
        }
    }

    public void onFragmentShow(Flag lastFlag) {
        super.onFragmentShow(lastFlag);
        Violet.INSTANCE.sendMsg(new HomePageVisibilityEvent(true));
    }

    public void onFragmentHide(Flag lastFlag) {
        super.onFragmentHide(lastFlag);
        Violet.INSTANCE.sendMsg(new HomePageVisibilityEvent(false));
    }
}