package tv.danmaku.bili.ui.favorite;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.crashreport.CrashReporter;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.ui.BaseFragment;
import com.bilibili.lib.ui.RouteConstKt;
import com.bilibili.lib.ui.Target;
import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.pvtracker.IPvTracker;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.DisplayUtils;
import tv.danmaku.bili.ui.favorite.api.FavSecondTabData;
import tv.danmaku.bili.ui.favorite.api.FavoriteApiManager;
import tv.danmaku.bili.widget.DisableScrollViewpager;
import tv.danmaku.bili.widget.section.adapter.PageAdapter;

public class FavoriteSpecialTopicFragment extends BaseFragment implements IPvTracker {
    private PageAdapter adapter;
    private FragmentManager fragmentManager;
    private TabMarginSlidingTabStrip tabs;
    private DisableScrollViewpager viewPager;

    public /* synthetic */ boolean appendEndExtra() {
        return IPvTracker.-CC.$default$appendEndExtra(this);
    }

    public /* synthetic */ String getUniqueKey() {
        return IPvTracker.-CC.$default$getUniqueKey(this);
    }

    public /* synthetic */ boolean shouldReport() {
        return IPvTracker.-CC.$default$shouldReport(this);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bili_app_fragment_favorite_special_topic, (ViewGroup) null);
        this.fragmentManager = getChildFragmentManager();
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        this.tabs = (TabMarginSlidingTabStrip) view.findViewById(R.id.tabs);
        this.viewPager = view.findViewById(R.id.pager);
        this.viewPager.setPagingEnabled(false);
        this.adapter = new PageAdapter(getActivity(), getChildFragmentManager());
        this.viewPager.setAdapter(this.adapter);
        this.tabs.setViewPager(this.viewPager);
        this.tabs.setShouldExpand(false);
        String accessKey = BiliAccounts.get(getContext()).getAccessKey();
        FavoriteApiManager.getSecondTab(accessKey, "special_topic", new BiliApiDataCallback<FavSecondTabData>() { // from class: tv.danmaku.bili.ui.favorite.FavoriteSpecialTopicFragment.1
            public void onDataSuccess(FavSecondTabData data) {
                FavoriteSpecialTopicFragment.this.addPage(data);
            }

            public void onError(Throwable t) {
            }
        });
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        int position;
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && this.viewPager != null && this.adapter.getCount() > (position = this.viewPager.getCurrentItem())) {
            PageAdapter.PageInfo tabPage = this.adapter.getPage(position);
            if (tabPage instanceof TabPage) {
                if ("ogv_film".equals(((TabPage) tabPage).tabName)) {
                    Neurons.reportExposure(false, "main.topic.contents.movie.show");
                } else if ("topic_act".equals(((TabPage) tabPage).tabName)) {
                    Neurons.reportExposure(false, "main.topic.contents.activity.show");
                }
            }
        }
    }

    public String getPvEventId() {
        return "main.topic.0.0.pv";
    }

    public Bundle getPvExtra() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPage(FavSecondTabData data) {
        if (data != null && data.items != null) {
            for (FavSecondTabData.Item item : data.items) {
                if (item != null) {
                    this.adapter.add(new TabPage(item.name, item.uri, item.tab));
                }
            }
            this.tabs.notifyDataSetChanged();
            if (this.adapter.getCount() < 2) {
                this.tabs.setVisibility(8);
            }
            this.tabs.setTabItemMargin(DisplayUtils.dp2Px(12));
            this.adapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public class TabPage implements PageAdapter.PageInfo {
        private String name;
        private String tabName;
        private String uri;

        public TabPage(String name, String uri, String tabName) {
            this.name = name;
            this.uri = uri;
            this.tabName = tabName;
        }

        public CharSequence getTitle(Context context) {
            return this.name;
        }

        public int getId() {
            return hashCode();
        }

        public String getTabName() {
            return this.tabName;
        }

        public PageAdapter.Page getPage() {
            return new PageAdapter.Page() { // from class: tv.danmaku.bili.ui.favorite.FavoriteSpecialTopicFragment.TabPage.1
                private Fragment mFragment;

                public boolean canScrollUp() {
                    return false;
                }

                public Fragment getFragment() {
                    if (this.mFragment == null) {
                        this.mFragment = findFragment(TabPage.this);
                    }
                    if (this.mFragment == null) {
                        Target target = RouteConstKt.findRoute(BLRouter.INSTANCE, new RouteRequest(Uri.parse(TabPage.this.uri)));
                        if (target != null) {
                            try {
                                this.mFragment = Fragment.instantiate(FavoriteSpecialTopicFragment.this.getContext(), target.getClazz().getName());
                            } catch (Exception e) {
                                TabPage.this.toastPageError(TabPage.this.name, TabPage.this.uri);
                                CrashReporter.INSTANCE.postCaughtException(e);
                            }
                        } else {
                            TabPage.this.toastPageError(TabPage.this.name, TabPage.this.uri);
                        }
                    }
                    if (this.mFragment == null) {
                        this.mFragment = new Fragment();
                    }
                    return this.mFragment;
                }

                private Fragment findFragment(PageAdapter.PageInfo info) {
                    return FavoriteSpecialTopicFragment.this.fragmentManager.findFragmentByTag(PageAdapter.getTagName(R.id.pager, info));
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void toastPageError(String name, String uri) {
            ToastHelper.showToastShort(FavoriteSpecialTopicFragment.this.getContext(), String.format("cannot get page: name(%s), router(%s)", name, uri));
        }
    }
}