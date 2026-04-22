package tv.danmaku.bili.ui.favorite;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.bilibili.api.BiliApiException;
import com.bilibili.app.comm.baseres.R;
import com.bilibili.app.comm.list.common.widget.ListCommonMenuWindow;
import com.bilibili.base.connectivity.ConnectivityMonitor;
import com.bilibili.commons.time.FastDateFormat;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.view.legacy.ScalableImageView2;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.ui.menu.IFloatMenuItem;
import com.bilibili.lib.ui.menu.NormalMenuItem;
import com.bilibili.magicasakura.widgets.TintTextView;
import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.ServiceGenerator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import tv.danmaku.android.util.AppResUtil;
import tv.danmaku.bili.ui.BaseEditFragment;
import tv.danmaku.bili.ui.favorite.api.FavTopicData;
import tv.danmaku.bili.ui.favorite.api.FavoriteApiManager;
import tv.danmaku.bili.ui.topic.api.TopicApiService;
import tv.danmaku.bili.widget.SpacesItemDecoration;
import tv.danmaku.bili.widget.section.adapter.HeaderFooterAdapter;

public class FavoriteH5TopicFragment extends BaseEditFragment {
    private static final int CODE_UNFAVORITE_TOPIC = 23;
    public static final String KEY_UNFAV_TOPIC_ID = "unfav_topic_id";
    private H5TopicAdapter mAdapter;
    private String mErrorImageUrl;
    private boolean mHasMore;
    private boolean mIsFirstPageLoaded;
    private boolean mIsFragmentStop;
    private boolean mIsLoading;
    private int mPageNum = 0;

    @Override // tv.danmaku.bili.ui.BaseEditFragment
    public void onViewCreated(RecyclerView recyclerView, Bundle savedInstanceState) {
        super.onViewCreated(recyclerView, savedInstanceState);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setSmoothScrollbarEnabled(true);
        recyclerView.setLayoutManager(manager);
        int dp15 = (int) TypedValue.applyDimension(1, 15.0f, getResources().getDisplayMetrics());
        recyclerView.addItemDecoration(new SpacesItemDecoration(dp15) { // from class: tv.danmaku.bili.ui.favorite.FavoriteH5TopicFragment.1
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                if (view == FavoriteH5TopicFragment.this.footerView) {
                    return;
                }
                super.getItemOffsets(outRect, view, parent, state);
            }
        });
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: tv.danmaku.bili.ui.favorite.FavoriteH5TopicFragment.2
            public void onScrolled(RecyclerView recyclerView2, int dx, int dy) {
                int childCount = recyclerView2.getChildCount();
                if (childCount > 0 && FavoriteH5TopicFragment.this.mHasMore && FavoriteH5TopicFragment.this.mIsFirstPageLoaded) {
                    View lastChild = recyclerView2.getChildAt(childCount - 1);
                    RecyclerView.Adapter outerAdapter = recyclerView2.getAdapter();
                    int lastVisible = recyclerView2.getChildAdapterPosition(lastChild);
                    if (lastVisible == outerAdapter.getItemCount() - 1 && !FavoriteH5TopicFragment.this.mIsLoading) {
                        FavoriteH5TopicFragment.this.loadNextPage();
                    }
                }
            }
        });
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: tv.danmaku.bili.ui.favorite.FavoriteH5TopicFragment.3
            public void onScrolled(RecyclerView recyclerView2, int dx, int dy) {
                FavoriteH5TopicFragment.this.hideFooterIfNeed();
            }
        });
        if (this.mAdapter == null) {
            this.mAdapter = new H5TopicAdapter(this);
        }
        HeaderFooterAdapter wrapperAdapter = new HeaderFooterAdapter(this.mAdapter);
        wrapperAdapter.addFooterView(this.footerView);
        recyclerView.setAdapter(wrapperAdapter);
    }

    public void onResume() {
        super.onResume();
        this.mIsFragmentStop = false;
    }

    protected void setUserVisibleCompat(boolean isVisibleToUser) {
        SwipeRefreshLayout swipeRefresh;
        super.setUserVisibleCompat(isVisibleToUser);
        if (isVisibleToUser && this.mAdapter.getItemCount() == 0 && (swipeRefresh = getSwipeRefreshLayout()) != null) {
            swipeRefresh.post(new Runnable() { // from class: tv.danmaku.bili.ui.favorite.FavoriteH5TopicFragment.4
                @Override // java.lang.Runnable
                public void run() {
                    FavoriteH5TopicFragment.this.showLoading();
                    FavoriteH5TopicFragment.this.loadFirstPage();
                }
            });
        }
    }

    public void onStop() {
        super.onStop();
        this.mIsFragmentStop = true;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        int position;
        if (resultCode == -1 && requestCode == 23 && data != null) {
            String topicId = data.getStringExtra(KEY_UNFAV_TOPIC_ID);
            long id = -1;
            try {
                id = TextUtils.isEmpty(topicId) ? -1L : Long.parseLong(topicId);
            } catch (NumberFormatException e) {
            }
            if (id != -1 && (position = this.mAdapter.getItemPositonById(id)) != -1) {
                this.mAdapter.removeItem(position);
                if (this.mAdapter.getItemCount() == 0) {
                    showEmptyTips(getErrorImageUrl());
                }
            }
        }
    }

    @Override // tv.danmaku.bili.ui.BaseEditFragment
    public boolean onAttachLoader(FragmentManager parentManager) {
        return false;
    }

    @Override // tv.danmaku.bili.ui.BaseEditFragment
    public void onClickReloadNextPage() {
        loadNextPage();
    }

    public void showErrorTips() {
        if (this.mLoadingView != null) {
            this.mLoadingView.setVisibility(0);
            this.mLoadingView.setImageResource(R.drawable.img_holder_error_style1);
            if (!ConnectivityMonitor.getInstance().isNetworkActive()) {
                this.mLoadingView.showEmptyTips(bili.resource.playerbaseres.R.string.playerbaseres_global_string_505);
            } else {
                this.mLoadingView.showEmptyTips(bili.resource.common.R.string.common_global_string_164);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideFooterIfNeed() {
        LinearLayoutManager layoutManager;
        int childCount;
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView != null && (childCount = (layoutManager = recyclerView.getLayoutManager()).getItemCount()) > 0 && this.footerView == layoutManager.getChildAt(childCount - 1) && layoutManager.findFirstCompletelyVisibleItemPosition() == 0) {
            hideFooter();
        } else {
            showFooterNoData();
        }
    }

    public void onRefresh() {
        super.onRefresh();
        loadFirstPage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadFirstPage() {
        this.mPageNum = 0;
        this.mHasMore = true;
        this.mIsFirstPageLoaded = false;
        hideFooter();
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadNextPage() {
        showFooterLoading();
        loadData();
    }

    private void loadData() {
        if (this.mIsLoading && !this.mHasMore) {
            return;
        }
        this.mIsLoading = true;
        this.mPageNum++;
        FavoriteApiManager.getFavTopic(BiliAccounts.get(getContext()).getAccessKey(), this.mPageNum, new BiliApiDataCallback<FavTopicData>() { // from class: tv.danmaku.bili.ui.favorite.FavoriteH5TopicFragment.5
            public void onDataSuccess(FavTopicData data) {
                if (FavoriteH5TopicFragment.this.mPageNum == 1) {
                    FavoriteH5TopicFragment.this.hideLoading();
                    if (data == null || data.items == null || data.items.isEmpty()) {
                        FavoriteH5TopicFragment.this.mAdapter.clear();
                        FavoriteH5TopicFragment.this.showEmptyTips(FavoriteH5TopicFragment.this.getErrorImageUrl());
                    } else {
                        FavoriteH5TopicFragment.this.mAdapter.setTopicList(data.items);
                        if (data.items.size() < 20) {
                            FavoriteH5TopicFragment.this.mHasMore = false;
                            FavoriteH5TopicFragment.this.hideFooterIfNeed();
                        }
                        FavoriteH5TopicFragment.this.mIsFirstPageLoaded = true;
                    }
                } else if (data == null) {
                    FavoriteH5TopicFragment.this.showFooterLoadError();
                } else if (data.items == null || data.items.isEmpty()) {
                    FavoriteH5TopicFragment.this.mHasMore = false;
                    FavoriteH5TopicFragment.this.showFooterNoData();
                } else {
                    FavoriteH5TopicFragment.this.mAdapter.addTopicList(data.items);
                    FavoriteH5TopicFragment.this.hideFooter();
                }
                FavoriteH5TopicFragment.this.mIsLoading = false;
            }

            public void onError(Throwable t) {
                FavoriteH5TopicFragment.this.hideLoading();
                if (FavoriteH5TopicFragment.this.mPageNum == 1) {
                    FavoriteH5TopicFragment.this.mAdapter.clear();
                    FavoriteH5TopicFragment.this.showErrorTips();
                } else {
                    FavoriteH5TopicFragment.this.mPageNum--;
                    FavoriteH5TopicFragment.this.showFooterLoadError();
                }
                FavoriteH5TopicFragment.this.mIsLoading = false;
            }

            public boolean isCancel() {
                return FavoriteH5TopicFragment.this.mIsFragmentStop;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unFavTopic(long topicId) {
        if (this.mIsLoading) {
            return;
        }
        this.mIsLoading = true;
        if (this.mAdapter.getItemCount() == 0) {
            hideFooter();
            showEmptyTips(getErrorImageUrl());
        }
        String accessKey = BiliAccounts.get(getContext()).getAccessKey();
        ((TopicApiService) ServiceGenerator.createService(TopicApiService.class)).unFavorTopic(accessKey, String.valueOf(topicId)).enqueue(new BiliApiDataCallback<Void>() { // from class: tv.danmaku.bili.ui.favorite.FavoriteH5TopicFragment.6
            public void onDataSuccess(Void data) {
                ToastHelper.showToastShort(FavoriteH5TopicFragment.this.getContext(), bili.resource.others.R.string.others_global_string_392);
                FavoriteH5TopicFragment.this.mIsLoading = false;
            }

            public void onError(Throwable t) {
                String msg = FavoriteH5TopicFragment.this.getString(bili.resource.playerbaseres.R.string.playerbaseres_global_string_463);
                int code = 0;
                if (t instanceof BiliApiException) {
                    msg = t.getMessage();
                    code = ((BiliApiException) t).mCode;
                }
                if (code == 15003) {
                    onDataSuccess((Void) null);
                    return;
                }
                ToastHelper.showToastShort(FavoriteH5TopicFragment.this.getContext(), msg);
                FavoriteH5TopicFragment.this.mIsLoading = false;
            }

            public boolean isCancel() {
                return FavoriteH5TopicFragment.this.isDetached() || FavoriteH5TopicFragment.this.getActivity() == null;
            }
        });
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            Neurons.reportExposure(false, "main.topic.contents.activity.show");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class H5TopicAdapter extends RecyclerView.Adapter<H5TopicViewHolder> {
        private WeakReference<FavoriteH5TopicFragment> mFragment;
        private List<FavTopicData.FavTopic> mTopicList = new ArrayList();

        public H5TopicAdapter(FavoriteH5TopicFragment fragment) {
            this.mFragment = new WeakReference<>(fragment);
        }

        public void setTopicList(List<FavTopicData.FavTopic> topicList) {
            if (topicList == null || topicList.isEmpty()) {
                return;
            }
            this.mTopicList.clear();
            this.mTopicList.addAll(topicList);
            notifyDataSetChanged();
        }

        public void addTopicList(List<FavTopicData.FavTopic> topicList) {
            if (topicList == null || topicList.isEmpty()) {
                return;
            }
            this.mTopicList.addAll(topicList);
            notifyDataSetChanged();
        }

        public void clear() {
            this.mTopicList.clear();
            notifyDataSetChanged();
        }

        public H5TopicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return H5TopicViewHolder.create(parent);
        }

        public void onBindViewHolder(H5TopicViewHolder holder, int position) {
            final FavTopicData.FavTopic topic = this.mTopicList.get(position);
            BiliImageLoader.INSTANCE.with(holder.mCover.getContext()).url(topic.cover).failureImageResId(tv.danmaku.bili.R.drawable.banner_default_topic).into(holder.mCover);
            holder.mData = topic;
            holder.mTitle.setText(topic.title);
            holder.mFavTime.setText(favTipString(holder.itemView.getContext(), topic.fav_at));
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorite.FavoriteH5TopicFragment.H5TopicAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    Map<String, String> reportParams = new HashMap<>();
                    reportParams.put("type", "1");
                    reportParams.put("content", String.valueOf(topic.topicId));
                    Neurons.reportClick(false, "main.topic.contents.0.click", reportParams);
                    if (!TextUtils.isEmpty(topic.link) && H5TopicAdapter.this.mFragment != null && H5TopicAdapter.this.mFragment.get() != null) {
                        RouteRequest request = new RouteRequest.Builder(Uri.parse(topic.link)).requestCode(23).build();
                        BLRouter bLRouter = BLRouter.INSTANCE;
                        BLRouter.routeTo(request, (Fragment) H5TopicAdapter.this.mFragment.get());
                    }
                }
            });
            holder.mMenu.setTag(holder);
            holder.mMenu.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorite.FavoriteH5TopicFragment.H5TopicAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    final H5TopicViewHolder holder2 = (H5TopicViewHolder) v.getTag();
                    List<IFloatMenuItem> menus = new ArrayList<>();
                    menus.add(new NormalMenuItem(0, v.getResources().getString(bili.resource.favorites.R.string.favorites_global_string_26), new NormalMenuItem.OnMenuClickListener() { // from class: tv.danmaku.bili.ui.favorite.FavoriteH5TopicFragment.H5TopicAdapter.2.1
                        public void onMenuClick(View view) {
                            H5TopicAdapter.this.deleteItem(holder2);
                        }
                    }));
                    ListCommonMenuWindow.show(v.getContext(), v, menus);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void deleteItem(H5TopicViewHolder holder) {
            if (holder == null || holder.mData == null) {
                return;
            }
            removeItem(holder.getAdapterPosition());
            FavoriteH5TopicFragment h5TopicFragment = this.mFragment.get();
            if (h5TopicFragment != null) {
                h5TopicFragment.unFavTopic(holder.mData.topicId);
            }
        }

        public int getItemCount() {
            return this.mTopicList.size();
        }

        public int getItemPositonById(long id) {
            int n = this.mTopicList.size();
            for (int i = 0; i < n; i++) {
                FavTopicData.FavTopic topic = this.mTopicList.get(i);
                if (topic.topicId == id) {
                    int position = i;
                    return position;
                }
            }
            return -1;
        }

        public FavTopicData.FavTopic getItem(int position) {
            return this.mTopicList.get(position);
        }

        public void removeItem(int position) {
            this.mTopicList.remove(position);
            notifyItemRemoved(position);
        }

        private static String favTipString(Context context, long favtime) {
            long now = System.currentTimeMillis();
            long sec = (now / 1000) - favtime;
            if (sec < 60) {
                return context.getResources().getString(bili.resource.favorites.R.string.favorites_global_string_174);
            }
            if (sec < 3600) {
                long min = sec / 60;
                return String.format(Locale.US, context.getResources().getQuantityString(bili.resource.favorites.R.plurals.favorites_global_string_251, (int) min), Long.valueOf(min));
            } else if (sec < 86400) {
                long hour = (sec / 60) / 60;
                return String.format(Locale.US, context.getResources().getQuantityString(bili.resource.favorites.R.plurals.favorites_global_string_253, (int) hour), Long.valueOf(hour));
            } else if (sec < 2592000) {
                long day = ((sec / 60) / 60) / 24;
                return String.format(Locale.US, context.getResources().getQuantityString(bili.resource.favorites.R.plurals.favorites_global_string_259, (int) day), Long.valueOf(day));
            } else {
                Calendar favCal = Calendar.getInstance();
                favCal.setTimeInMillis(favtime * 1000);
                Calendar nowCal = Calendar.getInstance();
                nowCal.setTimeInMillis(now);
                return favCal.get(1) == nowCal.get(1) ? String.format(Locale.US, context.getString(bili.resource.favorites.R.string.favorites_global_string_172), FastDateFormat.getInstance("MM-dd").format(1000 * favtime)) : String.format(Locale.US, context.getString(bili.resource.favorites.R.string.favorites_global_string_172), FastDateFormat.getInstance("yy-MM-dd").format(1000 * favtime));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class H5TopicViewHolder extends RecyclerView.ViewHolder {
        public ScalableImageView2 mCover;
        public FavTopicData.FavTopic mData;
        public TextView mFavTime;
        public ImageView mMenu;
        public TintTextView mTitle;

        public H5TopicViewHolder(View itemView) {
            super(itemView);
            this.mCover = itemView.findViewById(tv.danmaku.bili.R.id.cover);
            this.mTitle = itemView.findViewById(tv.danmaku.bili.R.id.title);
            this.mFavTime = (TextView) itemView.findViewById(tv.danmaku.bili.R.id.fav_time);
            this.mMenu = (ImageView) itemView.findViewById(tv.danmaku.bili.R.id.menu_more);
        }

        public static H5TopicViewHolder create(ViewGroup parent) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(tv.danmaku.bili.R.layout.bili_app_list_item_favorite_h5topic, parent, false);
            float elevation = TypedValue.applyDimension(1, 2.0f, parent.getResources().getDisplayMetrics());
            ViewCompat.setElevation(itemView, elevation);
            return new H5TopicViewHolder(itemView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getErrorImageUrl() {
        if (TextUtils.isEmpty(this.mErrorImageUrl)) {
            this.mErrorImageUrl = AppResUtil.getImageUrl("img_holder_empty_style3.webp");
        }
        return this.mErrorImageUrl;
    }
}