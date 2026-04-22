package tv.danmaku.bili.ui.favorite;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.bapis.bilibili.polymer.list.FavoriteTabReply;
import com.bapis.bilibili.polymer.list.FavoriteTabReq;
import com.bapis.bilibili.polymer.list.ListMoss;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.base.MainThread;
import com.bilibili.droid.BundleUtil;
import com.bilibili.droid.StringUtil;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accountsui.utils.AuthStatusErrorHelper;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.crashreport.CrashReporter;
import com.bilibili.lib.image2.view.legacy.StaticImageView2;
import com.bilibili.lib.imageviewer.utils.ImageExtentionKt;
import com.bilibili.lib.moss.api.BusinessException;
import com.bilibili.lib.moss.api.MossException;
import com.bilibili.lib.moss.api.MossResponseHandler;
import com.bilibili.lib.router.Router;
import com.bilibili.lib.ui.BaseFragment;
import com.bilibili.lib.ui.RouteConstKt;
import com.bilibili.lib.ui.Target;
import com.bilibili.lib.ui.garb.Garb;
import com.bilibili.lib.ui.garb.GarbManager;
import com.bilibili.lib.ui.mixin.Flag;
import com.bilibili.lib.ui.theme.ThemeWatcher;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.magicasakura.widgets.TintToolbar;
import com.bilibili.playset.report.PlaysetReport;
import com.bilibili.pvtracker.PageViewTracker;
import com.google.android.material.appbar.AppBarLayout;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tv.danmaku.android.util.AppResUtil;
import tv.danmaku.bili.R;
import tv.danmaku.bili.quick.LoginQualityMonitor;
import tv.danmaku.bili.ui.favorite.BaseFavoritesFragment;
import tv.danmaku.bili.ui.favorite.api.FavoriteTab;
import tv.danmaku.bili.ui.favorites.util.FavRouterUtilsKt;
import tv.danmaku.bili.widget.PagerSlidingTabStrip;

public class BaseFavoritesFragment extends BaseFragment implements ThemeWatcher.Observer {
    public static final String FROM_SPMID = "from_spmid";
    public static final int REQUEST_CODE_TO_CREATE_FOLDER = 1;
    public static final String SUB_TAB = "fav_sub_tab";
    public static final String TAB = "tab";
    public static final String TRACK_COMIC_ID = "track_comic_id";
    private static final String cache_sp = "main_favorite_tab_data_cache";
    protected AppBarLayout appBarLayout;
    protected ImageView ivCreateFolder;
    private boolean mIsFragmentStop;
    private boolean mIsTabShown;
    private View.OnClickListener mRetryListener = new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorite.BaseFavoritesFragment$$ExternalSyntheticLambda1
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            BaseFavoritesFragment.this.m1560lambda$new$1$tvdanmakubiliuifavoriteBaseFavoritesFragment(view);
        }
    };
    protected List<FavoriteTab> mTabData;
    private String mTargetFromSpmid;
    private String mTargetSubTabId;
    private String mTargetTabId;
    private String mTargetTrackComicId;
    protected PagerSlidingTabStrip tabStrip;
    private TextView tipButton;
    private StaticImageView2 tipImage;
    private TextView tipMessage;
    private View tipView;
    private Toolbar toolbar;
    protected ViewPager viewPager;
    protected View viewRoot;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = savedInstanceState == null ? getArguments() : savedInstanceState;
        if (bundle != null) {
            this.mTargetTabId = bundle.getString(TAB);
            this.mTargetSubTabId = bundle.getString(SUB_TAB);
            this.mTargetFromSpmid = bundle.getString("from_spmid");
            this.mTargetTrackComicId = bundle.getString(TRACK_COMIC_ID);
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        FavoritePagerAdapter adapter = this.viewPager.getAdapter();
        if (adapter != null && (adapter instanceof FavoritePagerAdapter)) {
            int pageIndex = this.viewPager.getCurrentItem();
            String pageId = adapter.getTabId(pageIndex);
            String subTabId = adapter.getSubTabId(pageIndex);
            String fromSpmid = adapter.getFromSpmid(pageIndex);
            outState.putString(TAB, pageId);
            outState.putString(SUB_TAB, subTabId);
            outState.putString("from_spmid", fromSpmid);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bili_app_fragment_toolbar_tabbar_pager, container, false);
        this.appBarLayout = view.findViewById(R.id.app_bar);
        this.toolbar = view.findViewById(R.id.nav_top_bar);
        this.viewRoot = view.findViewById(R.id.root);
        this.tipView = view.findViewById(R.id.layout_tip);
        this.tipImage = this.tipView.findViewById(R.id.image);
        this.tipMessage = (TextView) this.tipView.findViewById(R.id.tip);
        this.tipButton = (TextView) this.tipView.findViewById(R.id.retry);
        this.ivCreateFolder = (ImageView) view.findViewById(R.id.iv_create_folder);
        this.ivCreateFolder.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorite.BaseFavoritesFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BaseFavoritesFragment.this.m1561lambda$onCreateView$0$tvdanmakubiliuifavoriteBaseFavoritesFragment(view2);
            }
        });
        this.toolbar.setTitle(bili.resource.favorites.R.string.favorites_global_string_93);
        this.tabStrip = view.findViewById(R.id.tabs);
        this.tabStrip.setShouldExpand(false);
        this.tabStrip.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: tv.danmaku.bili.ui.favorite.BaseFavoritesFragment.1
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                if (position >= 0 && position < BaseFavoritesFragment.this.mTabData.size()) {
                    PlaysetReport.reportTabExposure(position, BaseFavoritesFragment.this.mTabData.get(position).name);
                }
            }

            public void onPageScrollStateChanged(int state) {
            }
        });
        this.viewPager = view.findViewById(R.id.pager);
        PageViewTracker.getInstance().observePageChange(this.viewPager);
        showLoadingView();
        getTabData();
        return view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onCreateView$0$tv-danmaku-bili-ui-favorite-BaseFavoritesFragment  reason: not valid java name */
    public /* synthetic */ void m1561lambda$onCreateView$0$tvdanmakubiliuifavoriteBaseFavoritesFragment(View v) {
        PlaysetReport.reportCreateNewFolderEvent();
        Router.global().with(this).forResult(1).open(FavRouterUtilsKt.URL_CREATE_FOLDER);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ThemeWatcher.getInstance().subscribe(this);
        int bgColor = ThemeUtils.getColorById(getActivity(), com.bilibili.app.comm.baseres.R.color.theme_color_primary_tr_background);
        if (enableNavigationIcon()) {
            this.toolbar.setNavigationIcon(com.bilibili.app.comm.baseres.R.drawable.ic_navigation_drawer);
        } else {
            this.toolbar.setNavigationIcon(com.bilibili.app.comm.baseres.R.drawable.ic_br_app_back);
        }
        this.toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorite.BaseFavoritesFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                FragmentActivity activity = BaseFavoritesFragment.this.getActivity();
                if (activity != null) {
                    activity.onBackPressed();
                }
            }
        });
        Garb garb = GarbManager.getCurGarb();
        if (garb.isPure()) {
            changeTopColor(bgColor, ThemeUtils.getColorById(getActivity(), com.bilibili.app.comm.baseres.R.color.theme_color_primary_tr_icon), ThemeUtils.getColorById(getActivity(), com.bilibili.app.comm.baseres.R.color.theme_color_primary_tr_title));
        } else if (garb.isPrimaryOnly()) {
            changeTopColor(bgColor, ThemeUtils.getColorById(getActivity(), com.bilibili.app.comm.baseres.R.color.theme_color_primary_tr_icon), ThemeUtils.getColorById(getActivity(), com.bilibili.app.comm.baseres.R.color.theme_color_primary_tr_title));
        } else {
            changeTopColor(garb.getSecondaryPageColor(), garb.getFontColor(), garb.getFontColor());
        }
    }

    public void onResume() {
        super.onResume();
        this.mIsFragmentStop = false;
        showTab(this.mTabData);
    }

    public void onStop() {
        super.onStop();
        this.mIsFragmentStop = true;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == -1 && data != null) {
            boolean isCreateFolder = BundleUtil.getLong(data.getExtras(), "id", new long[]{-1}) >= 0;
            if (isCreateFolder) {
                onCreatedFolder();
            }
        }
    }

    protected void onCreatedFolder() {
    }

    public void onDestroyView() {
        super.onDestroyView();
        ThemeWatcher.getInstance().unSubscribe(this);
        this.mTabData = null;
        this.mIsTabShown = false;
        this.mIsFragmentStop = true;
    }

    public Toolbar getToolbar() {
        return this.toolbar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: tv.danmaku.bili.ui.favorite.BaseFavoritesFragment$3  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public class AnonymousClass3 implements MossResponseHandler<FavoriteTabReply> {
        public /* synthetic */ void onCompleted() {
            MossResponseHandler.-CC.$default$onCompleted(this);
        }

        public /* synthetic */ void onHeaders(Map map) {
            MossResponseHandler.-CC.$default$onHeaders(this, map);
        }

        public /* synthetic */ long onNextForAck(Object obj) {
            return MossResponseHandler.-CC.$default$onNextForAck(this, obj);
        }

        public /* synthetic */ void onUpstreamAck(Long l) {
            MossResponseHandler.-CC.$default$onUpstreamAck(this, l);
        }

        public /* synthetic */ void onValid() {
            MossResponseHandler.-CC.$default$onValid(this);
        }

        AnonymousClass3() {
        }

        public void onNext(FavoriteTabReply data) {
            if (data == null || data.getItemsList().isEmpty()) {
                onError(new MossException("No favorite tab data", new Exception("No favorite tab data")));
                return;
            }
            BaseFavoritesFragment.this.mTabData = FavoritesExtKt.parse(data.getItemsList());
            String str = JSON.toJSONString(BaseFavoritesFragment.this.mTabData);
            SharedPreferences sp = BiliGlobalPreferenceHelper.getBLKVSharedPreference();
            if (sp != null) {
                sp.edit().putString(BaseFavoritesFragment.cache_sp, str).apply();
            }
            MainThread.runOnMainThread(new Runnable() { // from class: tv.danmaku.bili.ui.favorite.BaseFavoritesFragment$3$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    BaseFavoritesFragment.AnonymousClass3.this.m1563lambda$onNext$0$tvdanmakubiliuifavoriteBaseFavoritesFragment$3();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onNext$0$tv-danmaku-bili-ui-favorite-BaseFavoritesFragment$3  reason: not valid java name */
        public /* synthetic */ void m1563lambda$onNext$0$tvdanmakubiliuifavoriteBaseFavoritesFragment$3() {
            BaseFavoritesFragment.this.showTab(BaseFavoritesFragment.this.mTabData);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onError$1$tv-danmaku-bili-ui-favorite-BaseFavoritesFragment$3  reason: not valid java name */
        public /* synthetic */ void m1562lambda$onError$1$tvdanmakubiliuifavoriteBaseFavoritesFragment$3(MossException t) {
            BaseFavoritesFragment.this.onLoadError(t);
        }

        public void onError(final MossException t) {
            MainThread.runOnMainThread(new Runnable() { // from class: tv.danmaku.bili.ui.favorite.BaseFavoritesFragment$3$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    BaseFavoritesFragment.AnonymousClass3.this.m1562lambda$onError$1$tvdanmakubiliuifavoriteBaseFavoritesFragment$3(t);
                }
            });
        }
    }

    private void getTabData() {
        new ListMoss().favoriteTab(FavoriteTabReq.newBuilder().build(), new AnonymousClass3());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r3v2, types: [tv.danmaku.bili.ui.favorite.BaseFavoritesFragment$4] */
    public void onLoadError(Throwable t) {
        List<FavoriteTab> list;
        FragmentActivity activity = getActivity();
        if ((AuthStatusErrorHelper.isAuthStatusError(t) || isMossAuthStatusError(t)) && activity != null) {
            AuthStatusErrorHelper.logout(activity, "BaseFavoritesFragment");
            activity.onBackPressed();
            return;
        }
        SharedPreferences sp = BiliGlobalPreferenceHelper.getBLKVSharedPreference();
        String str = LoginQualityMonitor.OTHER_RESULT_CODE_MOBILE_API_ERROR;
        if (sp != null) {
            str = sp.getString(cache_sp, LoginQualityMonitor.OTHER_RESULT_CODE_MOBILE_API_ERROR);
        }
        if (str.equals(LoginQualityMonitor.OTHER_RESULT_CODE_MOBILE_API_ERROR)) {
            list = new ArrayList<>();
            list.add(new FavoriteTab("favorite", "视频", "bilibili://main/favorite/playlist"));
        } else {
            Type type = new TypeReference<List<FavoriteTab>>() { // from class: tv.danmaku.bili.ui.favorite.BaseFavoritesFragment.4
            }.getType();
            list = (List) JSON.parseObject(str, type, new Feature[0]);
        }
        this.mTabData = list;
        showTab(this.mTabData);
    }

    private boolean isMossAuthStatusError(Throwable t) {
        if (t instanceof BusinessException) {
            int code = ((BusinessException) t).getCode();
            return code == -2 || code == -101;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showTab(List<FavoriteTab> data) {
        Bundle args;
        String expandFolder;
        if (this.mIsFragmentStop || this.mIsTabShown || data == null) {
            return;
        }
        this.mIsTabShown = true;
        if (!isTargetTabExists(data, this.mTargetTabId)) {
            this.mTargetTabId = null;
            this.mTargetSubTabId = null;
            this.mTargetFromSpmid = null;
        }
        int targetTabIndex = 0;
        List<FavTab> tabs = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            FavoriteTab favoriteTab = data.get(i);
            if (favoriteTab != null) {
                FavTab favTab = new FavTab(favoriteTab.id, favoriteTab.name, favoriteTab.uri, this.mTargetTabId, this.mTargetSubTabId, this.mTargetFromSpmid, this.mTargetTrackComicId);
                if (favoriteTab.isFavoriteVideoTab() && (args = getArguments()) != null && (expandFolder = args.getString("expand")) != null) {
                    Uri.Builder builder = Uri.parse(favTab.pageUrl).buildUpon().appendQueryParameter("expand", expandFolder);
                    favTab.pageUrl = builder.build().toString();
                }
                tabs.add(favTab);
                if (!TextUtils.isEmpty(favTab.tabId) && !TextUtils.isEmpty(this.mTargetTabId) && favTab.tabId.equalsIgnoreCase(this.mTargetTabId)) {
                    targetTabIndex = tabs.size() - 1;
                }
            }
        }
        if (tabs.isEmpty()) {
            showErrorView();
            return;
        }
        setContentLayoutVisibility(0);
        this.viewPager.setAdapter(new FavoritePagerAdapter(getChildFragmentManager(), getContext(), tabs));
        this.tabStrip.setViewPager(this.viewPager);
        this.viewPager.setCurrentItem(targetTabIndex);
    }

    private boolean isTargetTabExists(List<FavoriteTab> data, String mTargetTabId) {
        for (FavoriteTab favoriteTab : data) {
            if (favoriteTab != null && !TextUtils.isEmpty(favoriteTab.id) && favoriteTab.id.equalsIgnoreCase(mTargetTabId)) {
                return true;
            }
        }
        return false;
    }

    private void setContentLayoutVisibility(int visibility) {
        if (this.tabStrip != null) {
            this.tabStrip.setVisibility(visibility);
        }
        if (this.viewPager != null) {
            this.viewPager.setVisibility(visibility);
        }
        if (this.tipView != null) {
            this.tipView.setVisibility(visibility == 0 ? 8 : 0);
        }
    }

    public void showErrorView() {
        setContentLayoutVisibility(8);
        if (this.tipView != null) {
            ImageExtentionKt.displayImageResource(this.tipImage, com.bilibili.app.comm.baseres.R.drawable.img_holder_error_style1);
            this.tipMessage.setText(bili.resource.common.R.string.common_global_string_91);
            this.tipButton.setVisibility(0);
            this.tipButton.setOnClickListener(this.mRetryListener);
        }
    }

    public void showLoadingView() {
        setContentLayoutVisibility(8);
        if (this.tipView != null) {
            ImageExtentionKt.displayImage(this.tipImage, AppResUtil.getImageUrl("img_holder_loading_style1.webp"));
            this.tipMessage.setText(bili.resource.playerbaseres.R.string.playerbaseres_global_string_1356);
            this.tipButton.setVisibility(4);
            this.tipButton.setOnClickListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$1$tv-danmaku-bili-ui-favorite-BaseFavoritesFragment  reason: not valid java name */
    public /* synthetic */ void m1560lambda$new$1$tvdanmakubiliuifavoriteBaseFavoritesFragment(View v) {
        showLoadingView();
        getTabData();
    }

    public void onFragmentShow(Flag lastFlag) {
        super.onFragmentShow(lastFlag);
        PageViewTracker.getInstance().setFragmentVisibility(this, true);
    }

    public void onFragmentHide(Flag lastFlag) {
        super.onFragmentHide(lastFlag);
        PageViewTracker.getInstance().setFragmentVisibility(this, false);
    }

    public void onThemeChanged() {
        if (this.viewRoot != null && getContext() != null) {
            this.viewRoot.setBackgroundColor(ThemeUtils.getColorById(getContext(), com.bilibili.app.comm.baseres.R.color.daynight_color_background));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class FavTab {
        public Fragment fragment;
        private String mTargetFromSpmid;
        private String mTargetId;
        private String mTargetSubId;
        private String mTargetTrackComicId;
        public String pageUrl;
        public String tabId;
        public String tabTitle;

        public FavTab(String id, String title, String url, String targetId, String targetSubId, String targetFromSpmid, String targetTrackComicId) {
            this.tabId = id;
            this.tabTitle = title;
            this.pageUrl = url;
            this.mTargetId = targetId;
            this.mTargetSubId = targetSubId;
            this.mTargetFromSpmid = targetFromSpmid;
            this.mTargetTrackComicId = targetTrackComicId;
        }

        public Fragment getFragment(Context context) {
            if (this.fragment == null) {
                try {
                    Target target = RouteConstKt.findRoute(BLRouter.INSTANCE, new RouteRequest(Uri.parse(this.pageUrl)));
                    if (target != null) {
                        Bundle bundle = target.getArgs();
                        if (StringUtil.isNotBlank(this.mTargetId)) {
                            bundle.putString(BaseFavoritesFragment.TAB, this.mTargetId);
                        }
                        if (StringUtil.isNotBlank(this.mTargetSubId)) {
                            bundle.putString(BaseFavoritesFragment.SUB_TAB, this.mTargetSubId);
                        }
                        if (StringUtil.isNotBlank(this.mTargetFromSpmid)) {
                            bundle.putString("from_spmid", this.mTargetFromSpmid);
                        }
                        if (StringUtil.isNotBlank(this.mTargetTrackComicId)) {
                            bundle.putString(BaseFavoritesFragment.TRACK_COMIC_ID, this.mTargetTrackComicId);
                        }
                        try {
                            this.fragment = Fragment.instantiate(context, target.getClazz().getName(), bundle);
                        } catch (Exception e) {
                            ToastHelper.showToastShort(context, String.format("cannot get page: name(%s), router(%s)", this.tabTitle, this.pageUrl));
                            CrashReporter.INSTANCE.postCaughtException(e);
                        }
                    }
                } catch (Exception e2) {
                }
            }
            if (this.fragment == null) {
                this.fragment = new Fragment();
            }
            return this.fragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class FavoritePagerAdapter extends FragmentPagerAdapter {
        private Context mContext;
        private List<FavTab> mTabs;

        public FavoritePagerAdapter(FragmentManager childFm, Context context, List<FavTab> tabs) {
            super(childFm);
            this.mContext = context;
            this.mTabs = tabs;
        }

        public Fragment getItem(int position) {
            return this.mTabs.get(position).getFragment(this.mContext);
        }

        public int getCount() {
            return this.mTabs.size();
        }

        public CharSequence getPageTitle(int position) {
            return this.mTabs.get(position).tabTitle;
        }

        public String getTabId(int position) {
            return this.mTabs.get(position).tabId;
        }

        public String getSubTabId(int position) {
            return this.mTabs.get(position).mTargetSubId;
        }

        public String getFromSpmid(int position) {
            return this.mTabs.get(position).mTargetFromSpmid;
        }
    }

    protected void changeTopColor(int backgroundColor, int iconColor, int titleColor) {
        if (getActivity() != null && this.appBarLayout != null && (getToolbar() instanceof TintToolbar)) {
            this.appBarLayout.setBackgroundColor(backgroundColor);
            this.ivCreateFolder.setColorFilter(iconColor);
            getToolbar().setTitleColorWithGarb(titleColor);
            getToolbar().setIconTintColorWithGarb(iconColor);
        }
    }

    protected boolean enableNavigationIcon() {
        return true;
    }
}