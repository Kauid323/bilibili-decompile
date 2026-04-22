package tv.danmaku.bili.ui.rank;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bapis.bilibili.app.show.rank.v1.Item;
import com.bilibili.droid.BundleUtil;
import com.bilibili.lib.arch.lifecycle.Resource;
import com.bilibili.lib.arch.lifecycle.Status;
import com.bilibili.lib.config.BLRemoteConfig;
import com.bilibili.lib.image.ImageLoaderPauseOnScrollListener;
import com.bilibili.lib.ui.swiperefresh.BaseSwipeRecyclerViewFragment;
import com.bilibili.pvtracker.IPvTracker;
import com.bilibili.pvtracker.PageViewTracker;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.ui.rank.model.RankListViewModelFactory;
import tv.danmaku.bili.ui.rank.model.RankModel;
import tv.danmaku.bili.ui.rank.reporter.RankingReport;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.bili.ui.rank.utils.ICurrentFragmentState;
import tv.danmaku.bili.ui.rank.utils.RankSpmidConstantsKt;
import tv.danmaku.bili.ui.rank.view.TipTitleHolder;
import tv.danmaku.bili.ui.rank.view.ViewHolderBase;
import tv.danmaku.bili.ui.rank.view.ViewHolderUgc;
import tv.danmaku.bili.ui.watchlater.utils.WatchLaterReporterKt;
import tv.danmaku.bili.widget.recycler.DividerDecoration;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: RankVideoListFragment.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u00015B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\"\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u0007H\u0016J\b\u0010%\u001a\u00020\u0007H\u0016J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0018H\u0014J\u0010\u0010(\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0018H\u0016J\b\u0010)\u001a\u00020\u0007H\u0016J\u0006\u0010*\u001a\u00020\u0007J\u0016\u00100\u001a\u00020\u00072\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020/0.H\u0002J\b\u00101\u001a\u00020\u0007H\u0002J\b\u00102\u001a\u00020\u0007H\u0002J\b\u00103\u001a\u00020\u0013H\u0016J\b\u00104\u001a\u00020\u001bH\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010+\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0.0-0,X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Ltv/danmaku/bili/ui/rank/RankVideoListFragment;", "Lcom/bilibili/lib/ui/swiperefresh/BaseSwipeRecyclerViewFragment;", "Lcom/bilibili/pvtracker/IPvTracker;", "Ltv/danmaku/bili/ui/rank/utils/ICurrentFragmentState;", "<init>", "()V", "selectedPosition", "", "position", "", "adapter", "Ltv/danmaku/bili/ui/rank/RankVideoListFragment$VideosAdapter;", "tid", "getTid", "()I", "setTid", "(I)V", "type", RankRouter.BundleKey.ACTION_PARAM_TITLE, "", "mPosition", "viewModel", "Ltv/danmaku/bili/ui/rank/RankVideoListViewModel;", "mLastIsVisible", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onDestroy", "onRefresh", "setUserVisibleCompat", "isVisibleToUser", "setUserVisibleHint", "onResume", "tryLoad", "observer", "Landroidx/lifecycle/Observer;", "Lcom/bilibili/lib/arch/lifecycle/Resource;", "", "Ltv/danmaku/bili/ui/rank/model/RankModel;", "showData", "setHeaderTitle", "showError", "getPvEventId", "getPvExtra", "VideosAdapter", "rank_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class RankVideoListFragment extends BaseSwipeRecyclerViewFragment implements IPvTracker, ICurrentFragmentState {
    public static final int $stable = 8;
    private VideosAdapter adapter;
    private boolean mLastIsVisible;
    private int mPosition;
    private final Observer<Resource<List<RankModel>>> observer = new Observer() { // from class: tv.danmaku.bili.ui.rank.RankVideoListFragment$$ExternalSyntheticLambda0
        public final void onChanged(Object obj) {
            RankVideoListFragment.observer$lambda$0(RankVideoListFragment.this, (Resource) obj);
        }
    };
    private int tid;
    private String title;
    private int type;
    private RankVideoListViewModel viewModel;

    /* compiled from: RankVideoListFragment.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Status.values().length];
            try {
                iArr[Status.LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Status.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Status.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ boolean appendEndExtra() {
        return IPvTracker.-CC.$default$appendEndExtra(this);
    }

    public /* synthetic */ String getUniqueKey() {
        return IPvTracker.-CC.$default$getUniqueKey(this);
    }

    public /* synthetic */ boolean shouldReport() {
        return IPvTracker.-CC.$default$shouldReport(this);
    }

    @Override // tv.danmaku.bili.ui.rank.utils.ICurrentFragmentState
    public void selectedPosition(int position) {
        this.mPosition = position;
        String spmidToPv = RankSpmidConstantsKt.spmidToPv(RankSpmidConstantsKt.SPMID_RANK_FRAGMENT_SQUARE);
        Bundle $this$selectedPosition_u24lambda_u240 = new Bundle();
        $this$selectedPosition_u24lambda_u240.putString(WatchLaterReporterKt.KEY_TAB_NAME, this.title);
        $this$selectedPosition_u24lambda_u240.putString("tab_order", String.valueOf(this.mPosition + 1));
        Unit unit = Unit.INSTANCE;
        PageViewTracker.getInstance().setExtra((Fragment) this, spmidToPv, $this$selectedPosition_u24lambda_u240);
    }

    public final int getTid() {
        return this.tid;
    }

    public final void setTid(int i) {
        this.tid = i;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        Integer integer = BundleUtil.getInteger(bundle, "type", new Integer[0]);
        Intrinsics.checkNotNullExpressionValue(integer, "getInteger(...)");
        this.type = integer.intValue();
        Integer integer2 = BundleUtil.getInteger(bundle, "tid", new Integer[0]);
        Intrinsics.checkNotNullExpressionValue(integer2, "getInteger(...)");
        this.tid = integer2.intValue();
        this.title = BundleUtil.getString(bundle, RankRouter.BundleKey.ACTION_PARAM_TITLE, new String[0]);
        this.adapter = new VideosAdapter(this);
        ViewModelStoreOwner activity = getActivity();
        if (this.viewModel == null && activity != null) {
            ViewModelProvider viewModelProvider = new ViewModelProvider(activity, new RankListViewModelFactory(this.type, this.tid));
            int i = this.tid;
            ViewModel viewModel = viewModelProvider.get("RankVideoList: " + i + ", " + this.type, RankVideoListViewModel.class);
            RankVideoListViewModel $this$onCreate_u24lambda_u240 = (RankVideoListViewModel) viewModel;
            $this$onCreate_u24lambda_u240.getRankList().observe((LifecycleOwner) this, this.observer);
            this.viewModel = (RankVideoListViewModel) viewModel;
        }
    }

    public void onViewCreated(RecyclerView recyclerView, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(this.adapter);
        recyclerView.addOnScrollListener(new ImageLoaderPauseOnScrollListener());
        recyclerView.addItemDecoration(new DividerDecoration(com.bilibili.lib.theme.R.color.Ga2));
        recyclerView.setBackgroundColor(getResources().getColor(com.bilibili.lib.theme.R.color.Wh0));
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != 101 || resultCode != -1 || data == null) {
            return;
        }
        tryLoad();
    }

    public void onDestroy() {
        super.onDestroy();
        VideosAdapter videosAdapter = this.adapter;
        if (videosAdapter != null) {
            videosAdapter.destroy();
        }
    }

    public void onRefresh() {
        super.onRefresh();
        tryLoad();
    }

    protected void setUserVisibleCompat(boolean isVisibleToUser) {
        super.setUserVisibleCompat(isVisibleToUser);
        if (isVisibleToUser) {
            RankingReport.reportRankingPageShow(this.title);
        }
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (this.mLastIsVisible != isVisibleToUser) {
            this.mLastIsVisible = isVisibleToUser;
            PageViewTracker.getInstance().setFragmentVisibility((Fragment) this, isVisibleToUser);
        }
    }

    public void onResume() {
        super.onResume();
        String spmidToPv = RankSpmidConstantsKt.spmidToPv(RankSpmidConstantsKt.SPMID_RANK_FRAGMENT_SQUARE);
        Bundle $this$onResume_u24lambda_u240 = new Bundle();
        $this$onResume_u24lambda_u240.putString(WatchLaterReporterKt.KEY_TAB_NAME, this.title);
        $this$onResume_u24lambda_u240.putString("tab_order", String.valueOf(this.mPosition + 1));
        Unit unit = Unit.INSTANCE;
        PageViewTracker.getInstance().setExtra((Fragment) this, spmidToPv, $this$onResume_u24lambda_u240);
    }

    public final void tryLoad() {
        RankVideoListViewModel rankVideoListViewModel = this.viewModel;
        if (rankVideoListViewModel != null) {
            rankVideoListViewModel.load();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observer$lambda$0(RankVideoListFragment this$0, Resource it) {
        List data;
        Intrinsics.checkNotNullParameter(it, "it");
        Status status = it.getStatus();
        switch (status == null ? -1 : WhenMappings.$EnumSwitchMapping$0[status.ordinal()]) {
            case -1:
                this$0.showError();
                return;
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                this$0.setRefreshStart();
                return;
            case 2:
                if (this$0.getRecyclerView() != null && (data = (List) it.getData()) != null) {
                    this$0.showData(data);
                    return;
                }
                return;
            case 3:
                this$0.showError();
                return;
        }
    }

    private final void showData(List<RankModel> list) {
        hideLoading();
        setRefreshCompleted();
        hideErrorTips();
        VideosAdapter videosAdapter = this.adapter;
        if (videosAdapter != null) {
            videosAdapter.setVideoList(list);
        }
        setHeaderTitle();
    }

    private final void setHeaderTitle() {
        VideosAdapter videosAdapter;
        String headerTitle = BLRemoteConfig.getInstance().getString("rank_tips_content");
        String str = headerTitle;
        if (!(str == null || StringsKt.isBlank(str)) && (videosAdapter = this.adapter) != null) {
            Item build = Item.newBuilder().setTitle(headerTitle).build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            RankModel $this$setHeaderTitle_u24lambda_u240 = new RankModel(build);
            $this$setHeaderTitle_u24lambda_u240.setRankModelType(1);
            videosAdapter.setHeaderModel($this$setHeaderTitle_u24lambda_u240);
        }
    }

    private final void showError() {
        VideosAdapter videosAdapter = this.adapter;
        if (videosAdapter != null) {
            videosAdapter.setVideoList(CollectionsKt.emptyList());
        }
        showEmptyTips(com.bilibili.lib.ui.R.drawable.ic_load_empty, bili.resource.common.R.string.common_global_string_400);
        setRefreshCompleted();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RankVideoListFragment.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u0014\u0010\u0016\u001a\u00020\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u0018J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\tH\u0007J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u001c\u001a\u00020\u0011H\u0016J\u0006\u0010\u001d\u001a\u00020\u0013J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0011H\u0002J\b\u0010!\u001a\u00020\u0013H\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Ltv/danmaku/bili/ui/rank/RankVideoListFragment$VideosAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Ltv/danmaku/bili/ui/rank/view/ViewHolderBase;", "fragment", "Ltv/danmaku/bili/ui/rank/RankVideoListFragment;", "<init>", "(Ltv/danmaku/bili/ui/rank/RankVideoListFragment;)V", "mList", "", "Ltv/danmaku/bili/ui/rank/model/RankModel;", "mHeaderModel", "mFragment", "Ljava/lang/ref/WeakReference;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "setVideoList", "list", "", "setHeaderModel", "model", "getItemViewType", "getItemCount", "destroy", "hasHeaderView", "", "getRankModel", "clearModels", "rank_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class VideosAdapter extends RecyclerView.Adapter<ViewHolderBase> {
        private final WeakReference<RankVideoListFragment> mFragment;
        private RankModel mHeaderModel;
        private final List<RankModel> mList;

        public VideosAdapter(RankVideoListFragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            this.mList = new ArrayList(100);
            this.mFragment = new WeakReference<>(fragment);
        }

        public ViewHolderBase onCreateViewHolder(ViewGroup parent, int viewType) {
            String str;
            String str2;
            Intrinsics.checkNotNullParameter(parent, "parent");
            String str3 = "";
            if (viewType == 1) {
                RankVideoListFragment rankVideoListFragment = this.mFragment.get();
                if (rankVideoListFragment != null && (str2 = rankVideoListFragment.title) != null) {
                    str3 = str2;
                }
                return new TipTitleHolder(parent, str3);
            }
            RankVideoListFragment rankVideoListFragment2 = this.mFragment.get();
            if (rankVideoListFragment2 != null && (str = rankVideoListFragment2.title) != null) {
                str3 = str;
            }
            return new ViewHolderUgc(parent, str3);
        }

        public void onBindViewHolder(ViewHolderBase holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.setHasHeader(hasHeaderView());
            holder.bind(getRankModel(position), this.mFragment);
        }

        public final void setVideoList(List<RankModel> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            clearModels();
            this.mList.addAll(list);
            notifyDataSetChanged();
        }

        public final void setHeaderModel(RankModel model) {
            Intrinsics.checkNotNullParameter(model, "model");
            this.mHeaderModel = model;
            notifyItemInserted(0);
        }

        public int getItemViewType(int position) {
            return getRankModel(position).getRankModelType();
        }

        public int getItemCount() {
            int i;
            int min = Math.min(100, this.mList.size());
            if (hasHeaderView()) {
                i = 1;
            } else {
                i = 0;
            }
            return min + i;
        }

        public final void destroy() {
            clearModels();
        }

        private final boolean hasHeaderView() {
            return this.mHeaderModel != null;
        }

        private final RankModel getRankModel(int position) {
            if (hasHeaderView()) {
                if (position == 0) {
                    RankModel rankModel = this.mHeaderModel;
                    Intrinsics.checkNotNull(rankModel);
                    return rankModel;
                }
                return this.mList.get(position - 1);
            }
            return this.mList.get(position);
        }

        private final void clearModels() {
            this.mList.clear();
            this.mHeaderModel = null;
        }
    }

    public String getPvEventId() {
        return RankSpmidConstantsKt.spmidToPv(RankSpmidConstantsKt.SPMID_RANK_FRAGMENT_SQUARE);
    }

    public Bundle getPvExtra() {
        Bundle bundle = new Bundle();
        bundle.putString(WatchLaterReporterKt.KEY_TAB_NAME, this.title);
        bundle.putString("tab_order", String.valueOf(this.mPosition + 1));
        return bundle;
    }
}