package tv.danmaku.bili.ui.offline;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.droid.BundleUtil;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseToolbarActivity;
import com.bilibili.lib.ui.garb.Garb;
import com.bilibili.lib.ui.garb.GarbManager;
import com.bilibili.lib.ui.util.MultipleThemeUtils;
import com.bilibili.offline.IOfflineManager;
import com.bilibili.offline.OfflineInfo;
import com.bilibili.offline.OfflineStatus;
import com.bilibili.offline.OfflineType;
import com.bilibili.videodownloader.model.OfflinePermissionCode;
import com.bilibili.videodownloader.model.PermissionCheck;
import com.bilibili.videodownloader.model.PermissionCheckKt;
import com.bilibili.videodownloader.utils.log.LogHelper;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.offline.BottomView;
import tv.danmaku.bili.ui.offline.ItemActionCallback;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.bili.widget.LoadingImageView;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: DownloadedPageActivity.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 @2\u00020\u0001:\u0001@B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u0010\u001f\u001a\u00020\u001cH\u0014J\b\u0010 \u001a\u00020\u001cH\u0014J\b\u0010!\u001a\u00020\u001cH\u0014J\b\u0010\"\u001a\u00020\u001cH\u0002J\b\u0010#\u001a\u00020\u001cH\u0017J\b\u0010$\u001a\u00020\u001cH\u0002J\u0018\u0010%\u001a\u00020\u001c2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'H\u0002J\u0010\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u0011H\u0016J\b\u00100\u001a\u00020\u001cH\u0002J\u0010\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\u0019H\u0002J\b\u00107\u001a\u00020\rH\u0002J\b\u0010;\u001a\u00020\u001cH\u0002J\b\u0010<\u001a\u00020\u001cH\u0002J\b\u0010=\u001a\u00020\u001cH\u0002J\u0010\u0010>\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:¨\u0006A"}, d2 = {"Ltv/danmaku/bili/ui/offline/DownloadedPageActivity;", "Lcom/bilibili/lib/ui/BaseToolbarActivity;", "<init>", "()V", "mGroupId", "", "mRootView", "Landroid/widget/FrameLayout;", "mContainer", "Landroid/view/ViewGroup;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mStorageView", "Ltv/danmaku/bili/ui/offline/StorageView;", "mBottomView", "Ltv/danmaku/bili/ui/offline/BottomView;", "mMenuEdit", "Landroid/view/MenuItem;", "mLoadingView", "Ltv/danmaku/bili/widget/LoadingImageView;", "mVideoOfflineManager", "Ltv/danmaku/bili/ui/offline/VideoOfflineManager;", "mAdapter", "Ltv/danmaku/bili/ui/offline/DownloadedPageAdapter;", "mIsEditMode", "", "mPageScene", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onStop", "onDestroy", "updateUI", "onBackPressed", "loadData", "asyncGetPlayTime", "infoList", "", "Lcom/bilibili/offline/OfflineInfo;", "mDataChangeListener", "Lcom/bilibili/offline/IOfflineManager$OfflineDataChangeListener;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "toggleEditMode", "setBottomBarVisible", "show", "mBottomAction", "Ltv/danmaku/bili/ui/offline/BottomView$BottomActionCallback;", "mItemActionCallback", "Ltv/danmaku/bili/ui/offline/ItemActionCallback$Downloaded;", "attachStorageView", "loadingView", "getLoadingView", "()Ltv/danmaku/bili/widget/LoadingImageView;", "showLoading", "hideLoading", "showEmpty", "setMenuEditVisible", "visible", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DownloadedPageActivity extends BaseToolbarActivity {
    public static final String KEY_PAGE_SCENE = "download_page_scene";
    public static final String KEY_VIDEO_ID = "video_id";
    public static final String KEY_VIDEO_TITLE = "video_title";
    public static final long PAGE_SCENE_GROUP_DRAMA = 1;
    public static final long PAGE_SCENE_PAGE_NORMAL = 0;
    private static final String TAG = "offline-DownloadedPage";
    private DownloadedPageAdapter mAdapter;
    private BottomView mBottomView;
    private ViewGroup mContainer;
    private long mGroupId;
    private boolean mIsEditMode;
    private LoadingImageView mLoadingView;
    private MenuItem mMenuEdit;
    private long mPageScene;
    private RecyclerView mRecyclerView;
    private FrameLayout mRootView;
    private StorageView mStorageView;
    private VideoOfflineManager mVideoOfflineManager;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final IOfflineManager.OfflineDataChangeListener mDataChangeListener = new IOfflineManager.OfflineDataChangeListener() { // from class: tv.danmaku.bili.ui.offline.DownloadedPageActivity$$ExternalSyntheticLambda1
        public final void onOfflineDataChange(List list) {
            DownloadedPageActivity.mDataChangeListener$lambda$0(DownloadedPageActivity.this, list);
        }
    };
    private final BottomView.BottomActionCallback mBottomAction = new DownloadedPageActivity$mBottomAction$1(this);
    private final ItemActionCallback.Downloaded mItemActionCallback = new ItemActionCallback.Downloaded() { // from class: tv.danmaku.bili.ui.offline.DownloadedPageActivity$mItemActionCallback$1
        /* JADX WARN: Code restructure failed: missing block: B:4:0x0008, code lost:
            r0 = r1.this$0.mBottomView;
         */
        @Override // tv.danmaku.bili.ui.offline.ItemActionCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onCheckedItemCountChange(int checkedCount, boolean allChecked) {
            boolean z;
            BottomView bottomView;
            z = DownloadedPageActivity.this.mIsEditMode;
            if (!z || bottomView == null) {
                return;
            }
            bottomView.updateCheckCount(checkedCount, allChecked);
        }

        @Override // tv.danmaku.bili.ui.offline.ItemActionCallback
        public void enterEditMode() {
            boolean z;
            z = DownloadedPageActivity.this.mIsEditMode;
            if (!z) {
                DownloadedPageActivity.this.toggleEditMode();
            }
        }

        @Override // tv.danmaku.bili.ui.offline.ItemActionCallback
        public void onItemCountChange(int count) {
            StorageView storageView;
            if (count > 0) {
                DownloadedPageActivity.this.setMenuEditVisible(true);
                return;
            }
            DownloadedPageActivity.this.setMenuEditVisible(false);
            storageView = DownloadedPageActivity.this.mStorageView;
            if (storageView != null) {
                View $this$isVisible$iv = (View) storageView;
                $this$isVisible$iv.setVisibility(8);
            }
            DownloadedPageActivity.this.showEmpty();
        }

        @Override // tv.danmaku.bili.ui.offline.ItemActionCallback.PlayAction
        public void play(Context context, OfflineInfo info) {
            VideoOfflineManager videoOfflineManager;
            Intrinsics.checkNotNullParameter(context, "context");
            if (info == null) {
                LogHelper.i("offline-DownloadedPage", "info is null");
                return;
            }
            OfflineReporter.reportDownloadedPagePlay();
            OfflinePermissionCode code = PermissionCheckKt.isAccessToPlay((PermissionCheck) info);
            if (!PermissionCheckKt.getForbiddenCodeList().contains(code)) {
                videoOfflineManager = DownloadedPageActivity.this.mVideoOfflineManager;
                if (videoOfflineManager != null) {
                    videoOfflineManager.play(DownloadedPageActivity.this.getLifecycle(), info);
                    return;
                }
                return;
            }
            OfflineUtil.INSTANCE.showDownloadedVipDialog((FragmentActivity) DownloadedPageActivity.this, code, info);
        }
    };

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mGroupId = BundleUtil.getLong(getIntent().getExtras(), KEY_VIDEO_ID, new long[]{0});
        this.mPageScene = BundleUtil.getLong(getIntent().getExtras(), KEY_PAGE_SCENE, new long[]{0});
        if (this.mGroupId == 0) {
            BLog.wtf("DownloadedPageActivity: video id is missing");
            finish();
        }
        String title = getIntent().getStringExtra(KEY_VIDEO_TITLE);
        if (TextUtils.isEmpty(title)) {
            BLog.wtf("DownloadedPageActivity: video title is missing");
            finish();
        }
        setContentView(R.layout.bili_app_activity_offline_downloaded_video);
        ensureToolbar();
        showBackButton();
        setTitle(title);
        this.mRootView = (FrameLayout) findViewById(16908290);
        this.mContainer = (ViewGroup) findViewById(R.id.content_layout);
        this.mStorageView = attachStorageView();
        this.mRecyclerView = findViewById(R.id.recycler);
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager((Context) this));
        }
        this.mVideoOfflineManager = new VideoOfflineManager();
    }

    protected void onStart() {
        super.onStart();
        VideoOfflineManager videoOfflineManager = this.mVideoOfflineManager;
        if (videoOfflineManager != null) {
            videoOfflineManager.onStart((Context) this);
        }
        updateUI();
    }

    protected void onStop() {
        super.onStop();
        VideoOfflineManager videoOfflineManager = this.mVideoOfflineManager;
        if (videoOfflineManager != null) {
            videoOfflineManager.unRegisterDataChangeListener(this.mDataChangeListener);
        }
        VideoOfflineManager videoOfflineManager2 = this.mVideoOfflineManager;
        if (videoOfflineManager2 != null) {
            videoOfflineManager2.onStop((Context) this);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        VideoOfflineManager videoOfflineManager = this.mVideoOfflineManager;
        if (videoOfflineManager != null) {
            videoOfflineManager.release();
        }
        this.mVideoOfflineManager = null;
    }

    private final void updateUI() {
        if (this.mAdapter != null) {
            DownloadedPageAdapter downloadedPageAdapter = this.mAdapter;
            if (downloadedPageAdapter != null) {
                downloadedPageAdapter.clear();
            }
            if (this.mIsEditMode) {
                toggleEditMode();
            }
            setMenuEditVisible(false);
        }
        loadData();
    }

    @Deprecated(message = "Deprecated in Java")
    public void onBackPressed() {
        if (this.mIsEditMode) {
            toggleEditMode();
        } else {
            super.onBackPressed();
        }
    }

    private final void loadData() {
        showLoading();
        VideoOfflineManager videoOfflineManager = this.mVideoOfflineManager;
        if (videoOfflineManager != null) {
            videoOfflineManager.getPagesById(this.mGroupId, this.mPageScene, new IOfflineManager.OfflineDataLoadListener() { // from class: tv.danmaku.bili.ui.offline.DownloadedPageActivity$$ExternalSyntheticLambda0
                public final void onLoadCompleted(List list) {
                    DownloadedPageActivity.loadData$lambda$0(DownloadedPageActivity.this, list);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadData$lambda$0(DownloadedPageActivity this$0, List offlineInfos) {
        if (this$0.isDestroyCalled()) {
            return;
        }
        List list = offlineInfos;
        if (list == null || list.isEmpty()) {
            this$0.showEmpty();
            this$0.setMenuEditVisible(false);
        } else {
            this$0.hideLoading();
            this$0.setMenuEditVisible(true);
            View view2 = this$0.mRecyclerView;
            if (view2 != null) {
                View $this$isVisible$iv = view2;
                $this$isVisible$iv.setVisibility(0);
            }
            DownloadedPageAdapter adapter = new DownloadedPageAdapter(offlineInfos, this$0.mItemActionCallback);
            this$0.mAdapter = adapter;
            RecyclerView recyclerView = this$0.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.setAdapter(adapter);
            }
            DownloadedPageAdapter downloadedPageAdapter = this$0.mAdapter;
            this$0.asyncGetPlayTime(downloadedPageAdapter != null ? downloadedPageAdapter.getInfo() : null);
            StorageView storageView = this$0.mStorageView;
            if (storageView != null) {
                storageView.checkStorage();
            }
        }
        VideoOfflineManager videoOfflineManager = this$0.mVideoOfflineManager;
        if (videoOfflineManager != null) {
            videoOfflineManager.registerDataChangeListener(this$0.mDataChangeListener);
        }
    }

    private final void asyncGetPlayTime(List<OfflineInfo> list) {
        List<OfflineInfo> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new DownloadedPageActivity$asyncGetPlayTime$1(this, list, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mDataChangeListener$lambda$0(DownloadedPageActivity this$0, List infoList) {
        if (this$0.isDestroyCalled() || this$0.mAdapter == null) {
            return;
        }
        List tempList = new LinkedList();
        Iterator it = infoList.iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            OfflineInfo info = (OfflineInfo) it.next();
            if (info.id == this$0.mGroupId) {
                OfflineStatus offlineStatus = info.offlineStatus;
                if (offlineStatus == null || offlineStatus.code != 4) {
                    z = false;
                }
                if (z) {
                    Intrinsics.checkNotNull(info);
                    tempList.add(info);
                    OfflineType offlineType = info.offlineType;
                    if (offlineType != null) {
                        offlineType.type = OfflineType.TYPE_PAGE;
                    }
                    info.title = OfflineUtil.getPageTitle(info);
                    info.sortIndex = OfflineUtil.createSortKey(info);
                    DownloadedPageAdapter downloadedPageAdapter = this$0.mAdapter;
                    if (downloadedPageAdapter != null) {
                        downloadedPageAdapter.addData(info);
                    }
                }
            }
        }
        this$0.asyncGetPlayTime(tempList);
        DownloadedPageAdapter downloadedPageAdapter2 = this$0.mAdapter;
        if ((downloadedPageAdapter2 != null ? downloadedPageAdapter2.getItemCount() : 0) > 0) {
            this$0.hideLoading();
            this$0.setMenuEditVisible(true);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        getMenuInflater().inflate(R.menu.menu_offline_edit, menu);
        this.mMenuEdit = menu.findItem(R.id.menu_edit);
        DownloadedPageAdapter downloadedPageAdapter = this.mAdapter;
        if ((downloadedPageAdapter != null ? downloadedPageAdapter.getItemCount() : 0) == 0) {
            setMenuEditVisible(false);
        }
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        int id = item.getItemId();
        if (id == R.id.menu_edit) {
            toggleEditMode();
        }
        return super.onOptionsItemSelected(item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toggleEditMode() {
        DownloadedPageAdapter adapter = this.mAdapter;
        if (adapter == null) {
            return;
        }
        this.mIsEditMode = !this.mIsEditMode;
        setBottomBarVisible(this.mIsEditMode);
        adapter.setEditMode(this.mIsEditMode);
        MenuItem it = this.mMenuEdit;
        if (it != null) {
            it.setTitle(this.mIsEditMode ? bili.resource.common.R.string.common_global_string_238 : bili.resource.common.R.string.common_global_string_247);
            Garb garb = GarbManager.getCurGarb();
            MultipleThemeUtils.refreshMenuTitleTint((Context) this, getToolbar(), it, garb.isPure() ? 0 : garb.getFontColor());
        }
    }

    private final void setBottomBarVisible(boolean show) {
        if (show) {
            if (this.mBottomView == null) {
                this.mBottomView = new BottomView((Context) this);
            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-1, -2);
            BottomView bottomView = this.mBottomView;
            if (bottomView != null) {
                bottomView.attach(this.mContainer, params, 2, true, this.mBottomAction);
                return;
            }
            return;
        }
        BottomView bottomView2 = this.mBottomView;
        if (bottomView2 != null) {
            bottomView2.detach();
        }
    }

    private final StorageView attachStorageView() {
        StorageView storageView = new StorageView((Context) this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-1, -2);
        ViewGroup it = this.mContainer;
        if (it != null) {
            storageView.attach(it, params, 2);
        }
        return storageView;
    }

    private final LoadingImageView getLoadingView() {
        if (this.mLoadingView == null) {
            this.mLoadingView = new LoadingImageView((Context) this);
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-2, -2);
            params.gravity = 17;
            FrameLayout frameLayout = this.mRootView;
            if (frameLayout != null) {
                frameLayout.addView(this.mLoadingView, params);
            }
        }
        LoadingImageView loadingImageView = this.mLoadingView;
        Intrinsics.checkNotNull(loadingImageView);
        return loadingImageView;
    }

    private final void showLoading() {
        View view2 = this.mRecyclerView;
        if (view2 != null) {
            View $this$isVisible$iv = view2;
            $this$isVisible$iv.setVisibility(8);
        }
        StorageView storageView = this.mStorageView;
        if (storageView != null) {
            View $this$isVisible$iv2 = (View) storageView;
            $this$isVisible$iv2.setVisibility(8);
        }
        getLoadingView().setRefreshing();
    }

    private final void hideLoading() {
        if (this.mLoadingView != null) {
            FrameLayout frameLayout = this.mRootView;
            if (frameLayout != null) {
                frameLayout.removeView(this.mLoadingView);
            }
            this.mLoadingView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEmpty() {
        StorageView storageView = this.mStorageView;
        if (storageView != null) {
            View $this$isVisible$iv = (View) storageView;
            $this$isVisible$iv.setVisibility(8);
        }
        getLoadingView().setRefreshComplete();
        getLoadingView().setImageResource(com.bilibili.app.comm.baseres.R.drawable.img_holder_empty_style2);
        getLoadingView().showEmptyTips(bili.resource.common.R.string.common_global_string_66);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setMenuEditVisible(boolean visible) {
        MenuItem it = this.mMenuEdit;
        if (it != null) {
            it.setVisible(visible);
            if (visible) {
                Garb garb = GarbManager.getCurGarb();
                MultipleThemeUtils.refreshMenuTitleTint((Context) this, getToolbar(), it, garb.isPure() ? 0 : garb.getFontColor());
            }
        }
    }

    /* compiled from: DownloadedPageActivity.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/offline/DownloadedPageActivity$Companion;", "", "<init>", "()V", "TAG", "", "KEY_VIDEO_TITLE", "KEY_VIDEO_ID", "KEY_PAGE_SCENE", "PAGE_SCENE_PAGE_NORMAL", "", "PAGE_SCENE_GROUP_DRAMA", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "videoId", RankRouter.BundleKey.ACTION_PARAM_TITLE, "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent createIntent(Context context, long videoId, String title) {
            Intent intent = new Intent(context, DownloadedPageActivity.class);
            intent.putExtra(DownloadedPageActivity.KEY_VIDEO_ID, videoId);
            intent.putExtra(DownloadedPageActivity.KEY_VIDEO_TITLE, title);
            return intent;
        }
    }
}