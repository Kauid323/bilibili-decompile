package tv.danmaku.bili.ui.main.mycenter;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.app.authorspace.SpaceReportHelper;
import com.bilibili.droid.BundleUtil;
import com.bilibili.lib.accountsui.utils.AuthStatusErrorHelper;
import com.bilibili.lib.widget.R;
import com.bilibili.magicasakura.widgets.TintTextView;
import com.bilibili.okretro.BiliApiDataCallback;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.BaseEditFragment;
import tv.danmaku.bili.ui.tag.api.TagDetailApiManager;
import tv.danmaku.bili.ui.tag.api.Tagv2;
import tv.danmaku.bili.ui.tag.api.VideoTagService;
import tv.danmaku.bili.widget.recycler.DividerDecoration;
import tv.danmaku.bili.widget.section.adapter.HeaderFooterAdapter;

public class AttentionTagFragment extends BaseEditFragment {
    private static final String ARGS_FROM = "from";
    private static final String ARGS_MID = "mid";
    private static final String ARGS_TITLE = "title";
    public static final int FROM_SPACE = 1;
    private static final int REQUEST_TO_MANAGER = 2006;
    private static final int REQ_START_TD_ACTIVITY = 2005;
    private AttentionTagAdapter adapter;
    public int currentPage;
    private boolean isLoading;
    private int mFrom;
    private HeaderFooterAdapter mHeaderFooterAdapter;
    private long mMid;
    private String mTitle;
    public int totalPage;
    private List<Tagv2> tagList = new ArrayList();
    private int mLastClickedPosition = -1;
    BiliApiDataCallback<List<Tagv2>> callback = new BiliApiDataCallback<List<Tagv2>>() { // from class: tv.danmaku.bili.ui.main.mycenter.AttentionTagFragment.3
        public boolean isCancel() {
            return AttentionTagFragment.this.getActivity() == null;
        }

        public void onDataSuccess(List<Tagv2> data) {
            AttentionTagFragment.this.hideLoading();
            AttentionTagFragment.this.hideFooter();
            AttentionTagFragment.this.setRefreshCompleted();
            if (AttentionTagFragment.this.getActivity() == null) {
                return;
            }
            AttentionTagFragment.this.isLoading = false;
            if (data != null) {
                if (AttentionTagFragment.this.currentPage == 1) {
                    AttentionTagFragment.this.tagList.clear();
                }
                AttentionTagFragment.this.tagList.addAll(data);
            }
            if (data == null || data.size() == 0) {
                AttentionTagFragment.this.totalPage = 0;
            } else if (data.size() < 20) {
                AttentionTagFragment.this.totalPage = AttentionTagFragment.this.currentPage;
            } else {
                AttentionTagFragment.this.totalPage = AttentionTagFragment.this.currentPage + 1;
            }
            if (AttentionTagFragment.this.tagList.isEmpty()) {
                AttentionTagFragment.this.showEmptyPage();
            } else if (!AttentionTagFragment.this.hasMore()) {
                AttentionTagFragment.this.showFooterNoData();
            }
            AttentionTagFragment.this.adapter.notifyDataSetChanged();
        }

        public void onError(Throwable t) {
            FragmentActivity activity = AttentionTagFragment.this.getActivity();
            if (AuthStatusErrorHelper.isAuthStatusError(t) && activity != null) {
                AuthStatusErrorHelper.logout(activity, "AttentionTagFragment");
                activity.onBackPressed();
            }
            AttentionTagFragment.this.hideLoading();
            AttentionTagFragment.this.hideFooter();
            AttentionTagFragment.this.setRefreshCompleted();
            if (AttentionTagFragment.this.getActivity() == null) {
                return;
            }
            AttentionTagFragment.this.isLoading = false;
            if (AttentionTagFragment.this.currentPage > 1) {
                AttentionTagFragment.this.currentPage--;
                AttentionTagFragment.this.showFooterLoadError();
            } else if (AttentionTagFragment.this.tagList.isEmpty()) {
                AttentionTagFragment.this.showErrorTips();
            }
        }
    };

    public static Bundle createArguments(long mid) {
        return createArguments(mid, null, 0);
    }

    public static Bundle createArguments(long mid, String title, int from) {
        Bundle extra = new Bundle();
        extra.putLong("mid", mid);
        extra.putString("title", title);
        extra.putInt("from", from);
        return extra;
    }

    public static AttentionTagFragment newInstance(long mid) {
        return newInstance(mid, null);
    }

    public static AttentionTagFragment newInstance(long mid, String title) {
        AttentionTagFragment fragment = new AttentionTagFragment();
        fragment.setArguments(createArguments(mid, title, 0));
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extra = getArguments();
        if (extra != null) {
            this.mMid = BundleUtil.getLong(extra, "mid", new long[0]);
            this.mTitle = extra.getString("title");
            this.mFrom = BundleUtil.getInteger(extra, "from", new Integer[0]).intValue();
        }
        this.adapter = new AttentionTagAdapter(this.tagList, this, this.mFrom);
        if (savedInstanceState != null) {
            onAttachLoader(getParentFragment().getFragmentManager());
        }
    }

    @Override // tv.danmaku.bili.ui.BaseEditFragment
    public void onViewCreated(RecyclerView recyclerView, Bundle savedInstanceState) {
        super.onViewCreated(recyclerView, savedInstanceState);
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        this.footerView = inflater.inflate(R.layout.bili_app_layout_loading_view, (ViewGroup) getView(), false);
        hideFooter();
        hideLoading();
        LinearLayoutManager manager = new LinearLayoutManager(recyclerView.getContext());
        manager.setSmoothScrollbarEnabled(true);
        recyclerView.addItemDecoration(new DividerDecoration(recyclerView.getContext()) { // from class: tv.danmaku.bili.ui.main.mycenter.AttentionTagFragment.1
            protected boolean needDrawDivider(RecyclerView.ViewHolder holder) {
                return holder.itemView != AttentionTagFragment.this.footerView;
            }
        });
        recyclerView.setLayoutManager(manager);
        this.mHeaderFooterAdapter = new HeaderFooterAdapter(this.adapter);
        this.mHeaderFooterAdapter.addFooterView(this.footerView);
        recyclerView.setAdapter(this.mHeaderFooterAdapter);
        recyclerView.addOnScrollListener(new OnScrollListener());
        if (!this.isLoading) {
            showLoading();
            loadFirstPage();
        }
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (!TextUtils.isEmpty(this.mTitle)) {
            getActivity().setTitle(this.mTitle);
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_START_TD_ACTIVITY && data != null && !BundleUtil.getBoolean(data.getExtras(), ChannelRoutes.EXTRA_ATTEN_STATUS, new boolean[]{true})) {
            int headersCount = this.mHeaderFooterAdapter.getHeadersCount();
            if (this.mLastClickedPosition >= headersCount && this.mLastClickedPosition < this.adapter.getItemCount() + headersCount) {
                int position = this.mLastClickedPosition - this.mHeaderFooterAdapter.getHeadersCount();
                this.tagList.remove(position);
                this.adapter.notifyItemRemoved(this.mLastClickedPosition);
                if (this.tagList.isEmpty()) {
                    showEmptyPage();
                }
                this.mLastClickedPosition = -1;
            }
        } else if (requestCode == REQUEST_TO_MANAGER && !this.isLoading) {
            showLoading();
            loadFirstPage();
        }
    }

    public void onRefresh() {
        super.onRefresh();
        loadFirstPage();
    }

    private void loadFirstPage() {
        if (this.isLoading) {
            return;
        }
        this.currentPage = 1;
        loadPage(this.callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showEmptyPage() {
        hideFooter();
        this.mLoadingView.setVisibility(0);
        this.mLoadingView.setRefreshComplete();
        this.mLoadingView.showEmptyTips(bili.resource.space.R.string.space_global_string_313);
        this.mLoadingView.setImageResource(com.bilibili.app.comm.baseres.R.drawable.img_holder_empty_style2);
    }

    @Override // tv.danmaku.bili.ui.BaseEditFragment
    public void showFooterLoadError() {
        if (this.footerView != null) {
            this.footerView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main.mycenter.AttentionTagFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (!AttentionTagFragment.this.isLoading) {
                        AttentionTagFragment.this.showFooterLoading();
                        AttentionTagFragment.this.loadNextPage(AttentionTagFragment.this.callback);
                    }
                }
            });
            this.footerView.setVisibility(0);
            this.footerView.findViewById(tv.danmaku.bili.R.id.loading).setVisibility(8);
            ((TextView) this.footerView.findViewById(tv.danmaku.bili.R.id.text1)).setText(bili.resource.common.R.string.common_global_string_136);
        }
    }

    @Override // tv.danmaku.bili.ui.BaseEditFragment
    public boolean onAttachLoader(FragmentManager parentManager) {
        return true;
    }

    @Override // tv.danmaku.bili.ui.BaseEditFragment
    public void onClickReloadNextPage() {
        if (!this.isLoading) {
            showFooterLoading();
            loadNextPage(this.callback);
        }
    }

    public void goToDetailActivity(int position, Tagv2 tag) {
        this.mLastClickedPosition = position;
        ChannelRoutes.goToChannelDetail(getActivity(), tag.tagId, tag.tagName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class AttentionTagAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        WeakReference<AttentionTagFragment> fragmentRef;
        int mFrom;
        List<Tagv2> tagList;

        AttentionTagAdapter(List<Tagv2> tagList, AttentionTagFragment fragment, int from) {
            this.tagList = tagList;
            this.fragmentRef = new WeakReference<>(fragment);
            this.mFrom = from;
        }

        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(tv.danmaku.bili.R.layout.bili_app_list_item_attention_tag, parent, false);
            return new AttentionTagHolder(view, this.fragmentRef, this.mFrom);
        }

        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            setupItem((AttentionTagHolder) holder, position);
        }

        private void setupItem(AttentionTagHolder holder, int position) {
            Tagv2 tag = this.tagList.get(position);
            holder.setTag(tag);
            if (tag != null) {
                holder.title.setText(tag.tagName);
            }
        }

        public int getItemCount() {
            if (this.tagList == null) {
                return 0;
            }
            return this.tagList.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class AttentionTagHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private WeakReference<AttentionTagFragment> fragmentWeakReference;
        private int mFrom;
        private Tagv2 tag;
        private TintTextView title;

        AttentionTagHolder(View itemView, WeakReference<AttentionTagFragment> fragmentWeakReference, int from) {
            super(itemView);
            this.fragmentWeakReference = fragmentWeakReference;
            this.title = itemView.findViewById(tv.danmaku.bili.R.id.title);
            this.mFrom = from;
            itemView.setOnClickListener(this);
        }

        public void setTag(Tagv2 tag) {
            this.tag = tag;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (this.tag != null && this.fragmentWeakReference.get() != null) {
                this.fragmentWeakReference.get().goToDetailActivity(getAdapterPosition(), this.tag);
                if (this.mFrom == 1) {
                    SpaceReportHelper.report(SpaceReportHelper.Event.obtainContentClick("1", "10", "1", String.valueOf(this.tag.tagId)));
                }
            }
        }
    }

    public void loadNextPage(BiliApiDataCallback<List<Tagv2>> callback) {
        this.currentPage++;
        loadPage(callback);
    }

    public void loadPage(BiliApiDataCallback<List<Tagv2>> callback) {
        VideoTagService.TagParamsMap params;
        this.isLoading = true;
        if (this.mMid > 0) {
            params = new VideoTagService.TagParamsMap(this.currentPage, 20, this.mMid);
        } else {
            params = new VideoTagService.TagParamsMap(this.currentPage, 20);
        }
        TagDetailApiManager.getTagList(getActivity(), params, callback);
    }

    public boolean hasMore() {
        return this.currentPage < this.totalPage;
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    class OnScrollListener extends RecyclerView.OnScrollListener {
        OnScrollListener() {
        }

        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            int childCount = recyclerView.getChildCount();
            if (childCount > 0 && AttentionTagFragment.this.hasMore()) {
                RecyclerView.Adapter outerAdapter = recyclerView.getAdapter();
                View lastChild = recyclerView.getChildAt(childCount - 1);
                int lastVisible = recyclerView.getChildAdapterPosition(lastChild);
                if (lastVisible == outerAdapter.getItemCount() - 1 && !AttentionTagFragment.this.isLoading) {
                    AttentionTagFragment.this.showFooterLoading();
                    AttentionTagFragment.this.loadNextPage(AttentionTagFragment.this.callback);
                }
            }
        }
    }
}