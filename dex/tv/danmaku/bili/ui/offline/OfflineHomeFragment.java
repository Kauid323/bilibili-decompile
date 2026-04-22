package tv.danmaku.bili.ui.offline;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.app.comm.servercomm.ServerClock;
import com.bilibili.app.preferences.BiliPreferencesActivity;
import com.bilibili.bangumi.BangumiRelateService;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.ui.BaseFragment;
import com.bilibili.lib.ui.garb.Garb;
import com.bilibili.lib.ui.garb.GarbManager;
import com.bilibili.lib.ui.garb.GarbWatcher;
import com.bilibili.lib.ui.mixin.Flag;
import com.bilibili.lib.ui.theme.ThemeWatcher;
import com.bilibili.lib.ui.util.MultipleThemeUtils;
import com.bilibili.magicasakura.widgets.TintToolbar;
import com.bilibili.offline.IOfflineManager;
import com.bilibili.offline.OfflineInfo;
import com.bilibili.offline.OfflineStatus;
import com.bilibili.pvtracker.IPvTracker;
import com.bilibili.pvtracker.PageViewTracker;
import com.bilibili.videodownloader.model.OfflinePermissionCode;
import com.bilibili.videodownloader.model.PermissionCheck;
import com.bilibili.videodownloader.model.PermissionCheckKt;
import com.bilibili.videodownloader.model.season.Episode;
import com.bilibili.videodownloader.utils.log.LogHelper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.R;
import tv.danmaku.bili.preferences.DownloadStoragePrefHelper;
import tv.danmaku.bili.ui.offline.BottomView;
import tv.danmaku.bili.ui.offline.ItemActionCallback;
import tv.danmaku.bili.ui.offline.OfflineHomeSection;
import tv.danmaku.bili.ui.offline.RecyclerViewSegmentHelper;
import tv.danmaku.biliplayerimpl.toast.left.viewholder.ActionMessageWithAnimationVH;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: OfflineHomeFragment.kt */
@Metadata(d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 n2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001nB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\u0002012\u0006\u00103\u001a\u00020'H\u0016J\u0012\u00104\u001a\u0002012\b\u00105\u001a\u0004\u0018\u000106H\u0016J$\u00107\u001a\u00020\u000e2\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0010\u0010<\u001a\u0002012\u0006\u0010=\u001a\u00020\u000eH\u0002J\b\u0010>\u001a\u00020+H\u0002J\u001a\u0010?\u001a\u0002012\u0006\u0010@\u001a\u00020\u000e2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0010\u0010A\u001a\u0002012\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010D\u001a\u0002012\u0006\u0010B\u001a\u00020CH\u0016J\u0006\u0010G\u001a\u000201J\u0016\u0010J\u001a\u00020+2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020M0LH\u0002J\b\u0010R\u001a\u000201H\u0016J\b\u0010S\u001a\u000201H\u0016J\b\u0010T\u001a\u000201H\u0016J\b\u0010U\u001a\u000201H\u0016J\b\u0010V\u001a\u000201H\u0002J\b\u0010W\u001a\u000201H\u0002J\u0016\u0010Z\u001a\u0002012\f\u0010[\u001a\b\u0012\u0004\u0012\u00020M0\\H\u0002J\b\u0010`\u001a\u000201H\u0002J\b\u0010a\u001a\u000201H\u0002J\b\u0010b\u001a\u000201H\u0002J\b\u0010c\u001a\u00020dH\u0016J\b\u0010e\u001a\u000206H\u0016J\u0010\u0010f\u001a\u0002012\u0006\u0010&\u001a\u00020'H\u0002J\u0016\u0010g\u001a\u0002012\f\u0010h\u001a\b\u0012\u0004\u0012\u00020M0\\H\u0002J\u0010\u0010i\u001a\u00020+2\u0006\u0010j\u001a\u00020kH\u0002J\u0012\u0010l\u001a\u0002012\b\b\u0001\u0010m\u001a\u00020kH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010 \u001a\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020'8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0012\u0010*\u001a\u00020+8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020IX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020OX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020QX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020YX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010]\u001a\u0004\u0018\u00010\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b^\u0010_¨\u0006o"}, d2 = {"Ltv/danmaku/bili/ui/offline/OfflineHomeFragment;", "Lcom/bilibili/lib/ui/BaseFragment;", "Lcom/bilibili/pvtracker/IPvTracker;", "Lcom/bilibili/lib/ui/theme/ThemeWatcher$Observer;", "Lcom/bilibili/lib/ui/garb/GarbWatcher$Observer;", "<init>", "()V", "mRootView", "Landroid/widget/LinearLayout;", "mToolbar", "Landroidx/appcompat/widget/Toolbar;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mBottomEntrance", "Landroid/view/View;", "mStorageView", "Ltv/danmaku/bili/ui/offline/StorageView;", "mBottomView", "Ltv/danmaku/bili/ui/offline/BottomView;", "mLoadingView", "Ltv/danmaku/bili/ui/offline/OfflineHomeLoadingView;", "mMenu", "Landroid/view/Menu;", "mMenuSearch", "Landroid/view/MenuItem;", "mMenuSetting", "mMenuEdit", "mOfflineManager", "Ltv/danmaku/bili/ui/offline/HybirdOfflineManager;", "getMOfflineManager", "()Ltv/danmaku/bili/ui/offline/HybirdOfflineManager;", "mOfflineManager$delegate", "Lkotlin/Lazy;", "mAdapter", "Ltv/danmaku/bili/ui/offline/OfflineHomeAdapter;", "getMAdapter", "()Ltv/danmaku/bili/ui/offline/OfflineHomeAdapter;", "mAdapter$delegate", "garb", "Lcom/bilibili/lib/ui/garb/Garb;", "getGarb", "()Lcom/bilibili/lib/ui/garb/Garb;", "mIsEditMode", "", "mIsDownloadingItemLoaded", "mIsDownloadedVideoLoaded", "mRecyclerViewSegmentHelper", "Ltv/danmaku/bili/ui/offline/RecyclerViewSegmentHelper;", "onThemeChanged", "", "onSkinChange", "skin", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initEntrance", "rootView", "showReserveEntrance", "onViewCreated", "view", "onFragmentShow", "lastFlag", "Lcom/bilibili/lib/ui/mixin/Flag;", "onFragmentHide", "mItemCallback", "Ltv/danmaku/bili/ui/offline/ItemActionCallback$Downloaded;", "toggleEditMode", "mBottomAction", "Ltv/danmaku/bili/ui/offline/BottomView$BottomActionCallback;", "containsMultiPage", "checked", "", "Lcom/bilibili/offline/OfflineInfo;", "mOfflineNavListener", "Landroid/view/View$OnClickListener;", "mMenuClickListener", "Landroidx/appcompat/widget/Toolbar$OnMenuItemClickListener;", "onStart", "onResume", "onStop", "onDestroy", "loadData", "notifyDataLoaded", "mDataChangeListener", "Lcom/bilibili/offline/IOfflineManager$OfflineDataChangeListener;", "asyncGetPlayTime", "infoList", "", "loadingView", "getLoadingView", "()Ltv/danmaku/bili/ui/offline/OfflineHomeLoadingView;", "showLoading", "hideLoading", "showEmpty", "getPvEventId", "", "getPvExtra", "changeToolBarColor", "queryEpPlayableV2", "offlineInfoList", "checkPlayable", "playable", "", "refreshMenuIconTint", "menuColor", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineHomeFragment extends BaseFragment implements IPvTracker, ThemeWatcher.Observer, GarbWatcher.Observer {
    private static final String OFFLINE_EVENT_ID = "main.my-cache.0.0.pv";
    private static final String TAG = "offline-home";
    private View mBottomEntrance;
    private BottomView mBottomView;
    private boolean mIsDownloadedVideoLoaded;
    private boolean mIsDownloadingItemLoaded;
    public boolean mIsEditMode;
    private OfflineHomeLoadingView mLoadingView;
    private Menu mMenu;
    private MenuItem mMenuEdit;
    private MenuItem mMenuSearch;
    private MenuItem mMenuSetting;
    private RecyclerView mRecyclerView;
    private RecyclerViewSegmentHelper mRecyclerViewSegmentHelper;
    private LinearLayout mRootView;
    private StorageView mStorageView;
    private Toolbar mToolbar;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final Lazy mOfflineManager$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.offline.OfflineHomeFragment$$ExternalSyntheticLambda4
        public final Object invoke() {
            HybirdOfflineManager mOfflineManager_delegate$lambda$0;
            mOfflineManager_delegate$lambda$0 = OfflineHomeFragment.mOfflineManager_delegate$lambda$0();
            return mOfflineManager_delegate$lambda$0;
        }
    });
    private final Lazy mAdapter$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.offline.OfflineHomeFragment$$ExternalSyntheticLambda5
        public final Object invoke() {
            OfflineHomeAdapter mAdapter_delegate$lambda$0;
            mAdapter_delegate$lambda$0 = OfflineHomeFragment.mAdapter_delegate$lambda$0(OfflineHomeFragment.this);
            return mAdapter_delegate$lambda$0;
        }
    });
    private final ItemActionCallback.Downloaded mItemCallback = new ItemActionCallback.Downloaded() { // from class: tv.danmaku.bili.ui.offline.OfflineHomeFragment$mItemCallback$1
        /* JADX WARN: Code restructure failed: missing block: B:4:0x0006, code lost:
            r0 = r1.this$0.mBottomView;
         */
        @Override // tv.danmaku.bili.ui.offline.ItemActionCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onCheckedItemCountChange(int checkedCount, boolean allChecked) {
            BottomView bottomView;
            if (!OfflineHomeFragment.this.mIsEditMode || bottomView == null) {
                return;
            }
            bottomView.updateCheckCount(checkedCount, allChecked);
        }

        @Override // tv.danmaku.bili.ui.offline.ItemActionCallback
        public void enterEditMode() {
            if (!OfflineHomeFragment.this.mIsEditMode) {
                OfflineHomeFragment.this.toggleEditMode();
            }
        }

        @Override // tv.danmaku.bili.ui.offline.ItemActionCallback
        public void onItemCountChange(int newCount) {
            MenuItem menuItem;
            OfflineHomeAdapter mAdapter;
            OfflineHomeAdapter mAdapter2;
            menuItem = OfflineHomeFragment.this.mMenuEdit;
            if (menuItem != null) {
                mAdapter2 = OfflineHomeFragment.this.getMAdapter();
                menuItem.setVisible(mAdapter2.getDownloadedCount() > 0);
            }
            mAdapter = OfflineHomeFragment.this.getMAdapter();
            if (mAdapter.getSectionSize() == 0) {
                OfflineHomeFragment.this.showEmpty();
            }
        }

        @Override // tv.danmaku.bili.ui.offline.ItemActionCallback.PlayAction
        public void play(Context context, OfflineInfo info) {
            HybirdOfflineManager mOfflineManager;
            Intrinsics.checkNotNullParameter(context, "context");
            if (info == null) {
                LogHelper.i("offline-home", "info is null");
                return;
            }
            OfflinePermissionCode code = PermissionCheckKt.isAccessToPlay((PermissionCheck) info);
            if (!PermissionCheckKt.getForbiddenCodeList().contains(code)) {
                mOfflineManager = OfflineHomeFragment.this.getMOfflineManager();
                Lifecycle lifecycle = OfflineHomeFragment.this.getLifecycle();
                Intrinsics.checkNotNullExpressionValue(lifecycle, "<get-lifecycle>(...)");
                mOfflineManager.play(lifecycle, info);
                return;
            }
            FragmentActivity it = OfflineHomeFragment.this.getActivity();
            if (it != null) {
                OfflineUtil.INSTANCE.showDownloadedVipDialog(it, code, info);
            }
        }
    };
    private final BottomView.BottomActionCallback mBottomAction = new OfflineHomeFragment$mBottomAction$1(this);
    private final View.OnClickListener mOfflineNavListener = new View.OnClickListener() { // from class: tv.danmaku.bili.ui.offline.OfflineHomeFragment$$ExternalSyntheticLambda6
        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            OfflineHomeFragment.mOfflineNavListener$lambda$0(OfflineHomeFragment.this, view2);
        }
    };
    private final Toolbar.OnMenuItemClickListener mMenuClickListener = new Toolbar.OnMenuItemClickListener() { // from class: tv.danmaku.bili.ui.offline.OfflineHomeFragment$$ExternalSyntheticLambda7
        public final boolean onMenuItemClick(MenuItem menuItem) {
            boolean mMenuClickListener$lambda$0;
            mMenuClickListener$lambda$0 = OfflineHomeFragment.mMenuClickListener$lambda$0(OfflineHomeFragment.this, menuItem);
            return mMenuClickListener$lambda$0;
        }
    };
    private final IOfflineManager.OfflineDataChangeListener mDataChangeListener = new IOfflineManager.OfflineDataChangeListener() { // from class: tv.danmaku.bili.ui.offline.OfflineHomeFragment$$ExternalSyntheticLambda8
        public final void onOfflineDataChange(List list) {
            OfflineHomeFragment.mDataChangeListener$lambda$0(OfflineHomeFragment.this, list);
        }
    };

    public /* synthetic */ boolean appendEndExtra() {
        return IPvTracker.-CC.$default$appendEndExtra(this);
    }

    public /* synthetic */ String getUniqueKey() {
        return IPvTracker.-CC.$default$getUniqueKey(this);
    }

    public /* synthetic */ boolean shouldReport() {
        return IPvTracker.-CC.$default$shouldReport(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HybirdOfflineManager getMOfflineManager() {
        return (HybirdOfflineManager) this.mOfflineManager$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HybirdOfflineManager mOfflineManager_delegate$lambda$0() {
        return new HybirdOfflineManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OfflineHomeAdapter getMAdapter() {
        return (OfflineHomeAdapter) this.mAdapter$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflineHomeAdapter mAdapter_delegate$lambda$0(OfflineHomeFragment this$0) {
        return new OfflineHomeAdapter(this$0.mItemCallback);
    }

    private final Garb getGarb() {
        return GarbManager.getCurGarb();
    }

    public void onThemeChanged() {
        refreshMenuIconTint(0);
    }

    public void onSkinChange(Garb skin) {
        Intrinsics.checkNotNullParameter(skin, "skin");
        if (skin.isPure()) {
            return;
        }
        refreshMenuIconTint(skin.isPure() ? 0 : skin.getFontColor());
        changeToolBarColor(skin);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThemeWatcher.getInstance().subscribe(this);
        GarbWatcher.INSTANCE.subscribe(this);
        if (ServerClock.now() == -1) {
            ServerClock.fetchCurrentTimeMillis();
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View view2 = inflater.inflate(R.layout.bili_app_fragment_toolbar_offline, container, false);
        this.mRootView = view2 instanceof LinearLayout ? (LinearLayout) view2 : null;
        Toolbar $this$onCreateView_u24lambda_u240 = view2.findViewById(R.id.nav_top_bar);
        if ($this$onCreateView_u24lambda_u240 != null) {
            $this$onCreateView_u24lambda_u240.setTitle(bili.resource.playerbaseres.R.string.playerbaseres_global_string_60);
            $this$onCreateView_u24lambda_u240.setNavigationIcon(androidx.appcompat.R.drawable.abc_ic_ab_back_material);
            $this$onCreateView_u24lambda_u240.setNavigationOnClickListener(this.mOfflineNavListener);
            $this$onCreateView_u24lambda_u240.setOnMenuItemClickListener(this.mMenuClickListener);
            $this$onCreateView_u24lambda_u240.inflateMenu(R.menu.offline_home);
            this.mMenu = $this$onCreateView_u24lambda_u240.getMenu();
        } else {
            $this$onCreateView_u24lambda_u240 = null;
        }
        this.mToolbar = $this$onCreateView_u24lambda_u240;
        Menu menu = this.mMenu;
        this.mMenuSearch = menu != null ? menu.findItem(R.id.offline_video_search) : null;
        Menu menu2 = this.mMenu;
        this.mMenuSetting = menu2 != null ? menu2.findItem(R.id.offline_video_setting) : null;
        Menu menu3 = this.mMenu;
        this.mMenuEdit = menu3 != null ? menu3.findItem(R.id.offline_video_edit) : null;
        MenuItem menuItem = this.mMenuEdit;
        if (menuItem != null) {
            menuItem.setVisible(false);
        }
        refreshMenuIconTint(getGarb().isPure() ? 0 : getGarb().getFontColor());
        Intrinsics.checkNotNull(view2);
        initEntrance(view2);
        this.mStorageView = (StorageView) view2.findViewById(R.id.storage_view);
        this.mRecyclerView = view2.findViewById(R.id.recycler);
        RecyclerView $this$onCreateView_u24lambda_u241 = this.mRecyclerView;
        if ($this$onCreateView_u24lambda_u241 != null) {
            $this$onCreateView_u24lambda_u241.setLayoutManager(new LinearLayoutManager($this$onCreateView_u24lambda_u241.getContext()));
            $this$onCreateView_u24lambda_u241.setAdapter(getMAdapter());
        }
        this.mRecyclerViewSegmentHelper = new RecyclerViewSegmentHelper(this.mRecyclerView, ActionMessageWithAnimationVH.INVALID_COLOR_INT, new RecyclerViewSegmentHelper.onNewPageVisibleListener() { // from class: tv.danmaku.bili.ui.offline.OfflineHomeFragment$$ExternalSyntheticLambda3
            @Override // tv.danmaku.bili.ui.offline.RecyclerViewSegmentHelper.onNewPageVisibleListener
            public final void onNewPageVisible(int i, int i2) {
                OfflineHomeFragment.onCreateView$lambda$2(OfflineHomeFragment.this, i, i2);
            }
        });
        return view2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$2(OfflineHomeFragment this$0, int start, int end) {
        int subListEnd;
        OfflineHomeSection.Downloaded downloadedSection = this$0.getMAdapter().getDownloadedSection();
        if (downloadedSection == null) {
            return;
        }
        List requestList = new LinkedList();
        for (int i = start; i < end; i++) {
            Object data = downloadedSection.data(i);
            if ((data instanceof OfflineInfo) && (((OfflineInfo) data).typeInfo instanceof Episode)) {
                if (((OfflineInfo) data).getPageCount() <= 1) {
                    requestList.add(data);
                    if (requestList.size() >= 30) {
                        this$0.queryEpPlayableV2(requestList);
                        requestList.clear();
                    }
                } else {
                    if (requestList.size() + ((OfflineInfo) data).getPageCount() >= 30) {
                        this$0.queryEpPlayableV2(requestList);
                        requestList.clear();
                    }
                    int pageSize = (((OfflineInfo) data).getPageCount() / 30) + 1;
                    for (int pageIndex = 0; pageIndex < pageSize; pageIndex++) {
                        int subListStart = pageIndex * 30;
                        if (pageIndex == pageSize - 1) {
                            subListEnd = (pageIndex * 30) + (((OfflineInfo) data).getPageCount() % 30);
                        } else {
                            subListEnd = (pageIndex * 30) + 30;
                        }
                        this$0.queryEpPlayableV2(CollectionsKt.filterNotNull(((OfflineInfo) data).pages.subList(subListStart, subListEnd)));
                    }
                }
            }
        }
        if (!requestList.isEmpty()) {
            this$0.queryEpPlayableV2(requestList);
            requestList.clear();
        }
    }

    private final void initEntrance(View rootView) {
        this.mBottomEntrance = rootView.findViewById(R.id.bottom_entrance);
        View reserveEntrance = rootView.findViewById(R.id.reserve_entrance);
        if (showReserveEntrance()) {
            reserveEntrance.setVisibility(0);
            Neurons.reportExposure$default(false, OfflineReportHelper.SHOW_ORDER_BUTTON, (Map) null, (List) null, 12, (Object) null);
        } else {
            reserveEntrance.setVisibility(8);
        }
        reserveEntrance.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.offline.OfflineHomeFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OfflineHomeFragment.initEntrance$lambda$0(OfflineHomeFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initEntrance$lambda$0(OfflineHomeFragment this$0, View it) {
        Neurons.reportClick$default(false, OfflineReportHelper.CLICK_ORDER_BUTTON, (Map) null, 4, (Object) null);
        Uri parse = Uri.parse("activity://bangumi/reserve-list");
        Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
        BLRouter.routeTo(new RouteRequest.Builder(parse).build(), (Fragment) this$0);
    }

    private final boolean showReserveEntrance() {
        BangumiRelateService bangumiRelateService = (BangumiRelateService) BLRouter.INSTANCE.get(BangumiRelateService.class, "default");
        return bangumiRelateService != null && bangumiRelateService.hasReserveData();
    }

    public void onViewCreated(View view2, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view2, "view");
        super.onViewCreated(view2, savedInstanceState);
        if (!getGarb().isPure()) {
            changeToolBarColor(getGarb());
        }
    }

    public void onFragmentShow(Flag lastFlag) {
        Intrinsics.checkNotNullParameter(lastFlag, "lastFlag");
        super.onFragmentShow(lastFlag);
        PageViewTracker.getInstance().setFragmentVisibility((Fragment) this, true);
    }

    public void onFragmentHide(Flag lastFlag) {
        Intrinsics.checkNotNullParameter(lastFlag, "lastFlag");
        super.onFragmentHide(lastFlag);
        PageViewTracker.getInstance().setFragmentVisibility((Fragment) this, false);
    }

    public final void toggleEditMode() {
        this.mIsEditMode = !this.mIsEditMode;
        if (this.mIsEditMode) {
            MenuItem menuItem = this.mMenuSearch;
            if (menuItem != null) {
                menuItem.setVisible(false);
            }
            MenuItem menuItem2 = this.mMenuSetting;
            if (menuItem2 != null) {
                menuItem2.setVisible(false);
            }
            MenuItem menuItem3 = this.mMenuEdit;
            if (menuItem3 != null) {
                menuItem3.setTitle(bili.resource.common.R.string.common_global_string_238);
            }
            MenuItem menuItem4 = this.mMenuEdit;
            if (menuItem4 != null) {
                menuItem4.setIcon((Drawable) null);
            }
            View view2 = this.mBottomEntrance;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            StorageView storageView = this.mStorageView;
            if (storageView != null) {
                storageView.setVisibility(8);
            }
            if (this.mBottomView == null) {
                this.mBottomView = new BottomView(getContext());
            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-1, -2);
            BottomView bottomView = this.mBottomView;
            if (bottomView != null) {
                bottomView.attach(this.mRootView, params, -1, true, this.mBottomAction);
            }
        } else {
            MenuItem menuItem5 = this.mMenuSearch;
            if (menuItem5 != null) {
                menuItem5.setVisible(true);
            }
            MenuItem menuItem6 = this.mMenuSetting;
            if (menuItem6 != null) {
                menuItem6.setVisible(true);
            }
            MenuItem menuItem7 = this.mMenuEdit;
            if (menuItem7 != null) {
                menuItem7.setTitle(bili.resource.common.R.string.common_global_string_247);
            }
            MenuItem menuItem8 = this.mMenuEdit;
            if (menuItem8 != null) {
                menuItem8.setIcon(R.drawable.ic_download_edit);
            }
            View view3 = this.mBottomEntrance;
            if (view3 != null) {
                view3.setVisibility(0);
            }
            StorageView storageView2 = this.mStorageView;
            if (storageView2 != null) {
                storageView2.setVisibility(0);
            }
            BottomView bottomView2 = this.mBottomView;
            if (bottomView2 != null) {
                bottomView2.detach();
            }
        }
        refreshMenuIconTint(getGarb().isPure() ? 0 : getGarb().getFontColor());
        getMAdapter().setEditMode(this.mIsEditMode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean containsMultiPage(Collection<OfflineInfo> collection) {
        Object obj;
        OfflineInfo it;
        Iterator<T> it2 = collection.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            OfflineInfo it3 = (OfflineInfo) obj;
            if (it3.getPageCount() > 1) {
                it = 1;
                continue;
            } else {
                it = null;
                continue;
            }
            if (it != null) {
                break;
            }
        }
        return obj != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mOfflineNavListener$lambda$0(OfflineHomeFragment this$0, View view2) {
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        if (this$0.mIsEditMode) {
            this$0.toggleEditMode();
        } else {
            activity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mMenuClickListener$lambda$0(OfflineHomeFragment this$0, MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        int itemId = item.getItemId();
        if (itemId == R.id.offline_video_search) {
            OfflineReporter.reportHomeSearchMenuClick();
            this$0.startActivity(OfflineSearchActivity.Companion.createIntent(this$0.getContext()));
            return true;
        } else if (itemId == R.id.offline_video_setting) {
            Context context = this$0.getContext();
            if (context != null) {
                OfflineReporter.reportHomeSettingMenuClick();
                this$0.startActivity(BiliPreferencesActivity.createIntent(context, DownloadStoragePrefHelper.DownloadPrefFragment.class.getName(), this$0.getString(bili.resource.settings.R.string.settings_global_string_1)));
                return true;
            }
            return true;
        } else if (itemId == R.id.offline_video_edit) {
            if (!this$0.mIsEditMode) {
                OfflineReporter.reportHomeEditMenuClick();
            }
            this$0.toggleEditMode();
            return true;
        } else {
            return false;
        }
    }

    public void onStart() {
        super.onStart();
        getMOfflineManager().onStart(getContext());
        if (this.mIsEditMode) {
            toggleEditMode();
        }
        loadData();
    }

    public void onResume() {
        super.onResume();
        StorageView storageView = this.mStorageView;
        if (storageView != null) {
            storageView.updateStorageIfStorageTypeChanged();
        }
    }

    public void onStop() {
        super.onStop();
        this.mIsDownloadingItemLoaded = false;
        this.mIsDownloadedVideoLoaded = false;
        getMOfflineManager().unRegisterDataChangeListener(this.mDataChangeListener);
        getMOfflineManager().onStop(getContext());
    }

    public void onDestroy() {
        super.onDestroy();
        getMOfflineManager().release();
        ThemeWatcher.getInstance().unSubscribe(this);
        GarbWatcher.INSTANCE.unSubscribe(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadData() {
        showLoading();
        getMAdapter().clearData();
        getMOfflineManager().getDownloadingItems(new IOfflineManager.OfflineDataLoadListener() { // from class: tv.danmaku.bili.ui.offline.OfflineHomeFragment$$ExternalSyntheticLambda0
            public final void onLoadCompleted(List list) {
                OfflineHomeFragment.loadData$lambda$0(OfflineHomeFragment.this, list);
            }
        });
        getMOfflineManager().getDownloadedVideo(new IOfflineManager.OfflineDataLoadListener() { // from class: tv.danmaku.bili.ui.offline.OfflineHomeFragment$$ExternalSyntheticLambda1
            public final void onLoadCompleted(List list) {
                OfflineHomeFragment.loadData$lambda$1(OfflineHomeFragment.this, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadData$lambda$0(OfflineHomeFragment this$0, List infoList) {
        this$0.getMAdapter().addOfflineSection(new OfflineHomeSection.Downloading(infoList));
        this$0.mIsDownloadingItemLoaded = true;
        this$0.notifyDataLoaded();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadData$lambda$1(OfflineHomeFragment this$0, List infoList) {
        MenuItem menuItem;
        List list = infoList == null ? CollectionsKt.emptyList() : infoList;
        this$0.getMAdapter().addOfflineSection(new OfflineHomeSection.Downloaded(list));
        this$0.mIsDownloadedVideoLoaded = true;
        if (!list.isEmpty() && (menuItem = this$0.mMenuEdit) != null) {
            menuItem.setVisible(true);
        }
        this$0.asyncGetPlayTime(list);
        this$0.notifyDataLoaded();
        RecyclerViewSegmentHelper recyclerViewSegmentHelper = this$0.mRecyclerViewSegmentHelper;
        if (recyclerViewSegmentHelper != null) {
            recyclerViewSegmentHelper.start(this$0.getMAdapter().getItemCount());
        }
    }

    private final void notifyDataLoaded() {
        if (this.mIsDownloadingItemLoaded && this.mIsDownloadedVideoLoaded) {
            if (getMAdapter().getItemCount() == 0) {
                showEmpty();
            } else {
                hideLoading();
                StorageView storageView = this.mStorageView;
                if (storageView != null) {
                    storageView.checkStorage();
                }
            }
            getMOfflineManager().registerDataChangeListener(this.mDataChangeListener);
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new OfflineHomeFragment$notifyDataLoaded$1(this, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mDataChangeListener$lambda$0(OfflineHomeFragment this$0, List infoList) {
        Intrinsics.checkNotNullParameter(infoList, "infoList");
        if (this$0.activityDie()) {
            return;
        }
        List tempList = new LinkedList();
        List $this$forEach$iv = infoList;
        for (Object element$iv : $this$forEach$iv) {
            OfflineInfo offlineInfo = (OfflineInfo) element$iv;
            OfflineStatus offlineStatus = offlineInfo.offlineStatus;
            Integer valueOf = offlineStatus != null ? Integer.valueOf(offlineStatus.code) : null;
            if (valueOf == null || valueOf.intValue() != 7) {
                if (valueOf == null || valueOf.intValue() != 9) {
                    if (valueOf == null || valueOf.intValue() != 8) {
                        if (valueOf != null && valueOf.intValue() == 4) {
                            tempList.add(offlineInfo);
                            this$0.getMAdapter().onItemDownloaded(offlineInfo);
                        } else {
                            RecyclerView it = this$0.mRecyclerView;
                            if (it != null) {
                                this$0.getMAdapter().onItemDownloading(it, offlineInfo);
                            }
                        }
                    }
                }
            }
        }
        this$0.asyncGetPlayTime(tempList);
    }

    private final void asyncGetPlayTime(List<OfflineInfo> list) {
        if (list.isEmpty()) {
            return;
        }
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new OfflineHomeFragment$asyncGetPlayTime$1(this, list, null), 3, (Object) null);
    }

    private final OfflineHomeLoadingView getLoadingView() {
        LinearLayout rootView = this.mRootView;
        if (rootView == null) {
            return null;
        }
        if (this.mLoadingView == null) {
            this.mLoadingView = new OfflineHomeLoadingView(rootView.getContext());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-1, 0);
            params.weight = 1.0f;
            rootView.addView((View) this.mLoadingView, rootView.indexOfChild((View) this.mRecyclerView) + 1, params);
        }
        return this.mLoadingView;
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
        OfflineHomeLoadingView loadingView = getLoadingView();
        if (loadingView != null) {
            loadingView.setRefreshing();
        }
    }

    private final void hideLoading() {
        View view2 = this.mRecyclerView;
        if (view2 != null) {
            View $this$isVisible$iv = view2;
            $this$isVisible$iv.setVisibility(0);
        }
        if (this.mLoadingView != null) {
            LinearLayout linearLayout = this.mRootView;
            if (linearLayout != null) {
                linearLayout.removeView((View) this.mLoadingView);
            }
            this.mLoadingView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEmpty() {
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
        OfflineHomeLoadingView $this$showEmpty_u24lambda_u240 = getLoadingView();
        if ($this$showEmpty_u24lambda_u240 != null) {
            $this$showEmpty_u24lambda_u240.setRefreshComplete();
            $this$showEmpty_u24lambda_u240.setImageResource(com.bilibili.app.comm.baseres.R.drawable.img_holder_empty_style2);
            $this$showEmpty_u24lambda_u240.showEmptyTips(bili.resource.common.R.string.common_global_string_66);
        }
    }

    public String getPvEventId() {
        return OFFLINE_EVENT_ID;
    }

    public Bundle getPvExtra() {
        return new Bundle();
    }

    private final void changeToolBarColor(Garb garb) {
        TintToolbar tintToolbar = this.mToolbar;
        TintToolbar $this$changeToolBarColor_u24lambda_u240 = tintToolbar instanceof TintToolbar ? tintToolbar : null;
        if ($this$changeToolBarColor_u24lambda_u240 != null) {
            $this$changeToolBarColor_u24lambda_u240.setBackgroundColorWithGarb(garb.getSecondaryPageColor());
            $this$changeToolBarColor_u24lambda_u240.setTitleColorWithGarb(garb.getFontColor());
            $this$changeToolBarColor_u24lambda_u240.setIconTintColorWithGarb(garb.getFontColor());
        }
    }

    private final void queryEpPlayableV2(List<OfflineInfo> list) {
        if (list.isEmpty()) {
            return;
        }
        JsonArray offlineList = new JsonArray();
        List<OfflineInfo> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            OfflineInfo offlineInfo = (OfflineInfo) element$iv;
            Object episode = offlineInfo.typeInfo;
            if ((episode instanceof Episode) && offlineInfo.getVideoQuality() != 0) {
                JsonElement jsonObject = new JsonObject();
                jsonObject.addProperty("ep_id", Long.valueOf(((Episode) episode).id));
                jsonObject.addProperty(IjkMediaPlayer.OnNativeInvokeListener.ARG_QN, Integer.valueOf(offlineInfo.getVideoQuality()));
                offlineList.add(jsonObject);
            }
        }
        if (offlineList.size() <= 0) {
            return;
        }
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new OfflineHomeFragment$queryEpPlayableV2$2(offlineList, this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean checkPlayable(int playable) {
        return playable == 0;
    }

    private final void refreshMenuIconTint(int menuColor) {
        Toolbar it = this.mToolbar;
        if (it != null) {
            MultipleThemeUtils.refreshMenuIconTint(FoundationAlias.getFapp(), it, menuColor);
        }
    }

    /* compiled from: OfflineHomeFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/ui/offline/OfflineHomeFragment$Companion;", "", "<init>", "()V", "TAG", "", "OFFLINE_EVENT_ID", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}