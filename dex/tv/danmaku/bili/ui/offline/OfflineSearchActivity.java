package tv.danmaku.bili.ui.offline;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bili.resource.playerbaseres.R;
import com.bilibili.droid.InputMethodManagerHelper;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.image2.view.legacy.StaticImageView2;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseAppCompatActivity;
import com.bilibili.lib.ui.util.StatusBarCompat;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.offline.IOfflineManager;
import com.bilibili.offline.OfflineInfo;
import com.bilibili.videodownloader.model.OfflinePermissionCode;
import com.bilibili.videodownloader.model.PermissionCheck;
import com.bilibili.videodownloader.model.PermissionCheckKt;
import com.bilibili.videodownloader.utils.log.LogHelper;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.android.util.AppResUtil;
import tv.danmaku.bili.ui.offline.BottomView;
import tv.danmaku.bili.ui.offline.ItemActionCallback;
import tv.danmaku.bili.widget.SearchView;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: OfflineSearchActivity.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 :2\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u0010\u001f\u001a\u00020\u001cH\u0014J\b\u0010 \u001a\u00020\u001cH\u0014J\b\u0010!\u001a\u00020\u001cH\u0014J\b\u0010\"\u001a\u00020\u001cH\u0002J\b\u0010#\u001a\u00020\u001cH\u0002J\u0010\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u001aH\u0002J\u0018\u0010&\u001a\u00020\u001c2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010(H\u0003J\b\u0010*\u001a\u00020\u001cH\u0002J\b\u0010+\u001a\u00020\u001cH\u0002J\b\u0010,\u001a\u00020\u001cH\u0002J\b\u0010/\u001a\u00020\u001cH\u0002J\u0010\u00100\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u0018H\u0002J\b\u00104\u001a\u000205H\u0002J\b\u00106\u001a\u00020\u001cH\u0017J\u0012\u00107\u001a\u00020\u001c2\b\u00108\u001a\u0004\u0018\u000109H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Ltv/danmaku/bili/ui/offline/OfflineSearchActivity;", "Lcom/bilibili/lib/ui/BaseAppCompatActivity;", "<init>", "()V", "mSearchView", "Ltv/danmaku/bili/widget/SearchView;", "mResultCount", "Landroid/widget/TextView;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mBottomContainer", "Landroid/widget/FrameLayout;", "mBottomView", "Ltv/danmaku/bili/ui/offline/BottomView;", "mTipView", "Landroid/widget/LinearLayout;", "mTipImage", "Lcom/bilibili/lib/image2/view/legacy/StaticImageView2;", "mTipMessage", "mOfflineManager", "Ltv/danmaku/bili/ui/offline/HybirdOfflineManager;", "mAdapter", "Ltv/danmaku/bili/ui/offline/OfflineSearchAdapter;", "mIsEditMode", "", "mQuery", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onStop", "onPause", "requestFocus", "forceRequestFocus", "doSearch", "query", "asyncGetPlayTime", "infoList", "", "Lcom/bilibili/offline/OfflineInfo;", "showLoading", "hideLoading", "showEmpty", "mItemActionCallback", "Ltv/danmaku/bili/ui/offline/ItemActionCallback$Downloaded;", "toggleEditMode", "setBottomBarVisible", "show", "mBottomAction", "Ltv/danmaku/bili/ui/offline/BottomView$BottomActionCallback;", "createItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "onBackPressed", "tintStatusBar", "activity", "Landroid/app/Activity;", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineSearchActivity extends BaseAppCompatActivity {
    private static final String TAG = "OfflineSearchActivity";
    private OfflineSearchAdapter mAdapter;
    private FrameLayout mBottomContainer;
    private BottomView mBottomView;
    private boolean mIsEditMode;
    private HybirdOfflineManager mOfflineManager;
    private String mQuery;
    private RecyclerView mRecyclerView;
    private TextView mResultCount;
    private SearchView mSearchView;
    private StaticImageView2 mTipImage;
    private TextView mTipMessage;
    private LinearLayout mTipView;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final ItemActionCallback.Downloaded mItemActionCallback = new ItemActionCallback.Downloaded() { // from class: tv.danmaku.bili.ui.offline.OfflineSearchActivity$mItemActionCallback$1
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
            z = OfflineSearchActivity.this.mIsEditMode;
            if (!z || bottomView == null) {
                return;
            }
            bottomView.updateCheckCount(checkedCount, allChecked);
        }

        @Override // tv.danmaku.bili.ui.offline.ItemActionCallback
        public void enterEditMode() {
            boolean z;
            z = OfflineSearchActivity.this.mIsEditMode;
            if (!z) {
                OfflineSearchActivity.this.toggleEditMode();
            }
        }

        @Override // tv.danmaku.bili.ui.offline.ItemActionCallback
        public void onItemCountChange(int newCount) {
            TextView textView;
            String str;
            if (newCount == 0) {
                OfflineSearchActivity.this.showEmpty();
                return;
            }
            textView = OfflineSearchActivity.this.mResultCount;
            if (textView != null) {
                Resources resources = OfflineSearchActivity.this.getResources();
                int i = R.plurals.playerbaseres_global_string_2351;
                str = OfflineSearchActivity.this.mQuery;
                textView.setText(resources.getQuantityString(i, newCount, str, Integer.valueOf(newCount)));
            }
        }

        @Override // tv.danmaku.bili.ui.offline.ItemActionCallback.PlayAction
        public void play(Context context, OfflineInfo info) {
            HybirdOfflineManager hybirdOfflineManager;
            Intrinsics.checkNotNullParameter(context, "context");
            if (info == null) {
                LogHelper.i("OfflineSearchActivity", "info is null");
                return;
            }
            OfflinePermissionCode code = PermissionCheckKt.isAccessToPlay((PermissionCheck) info);
            if (!PermissionCheckKt.getForbiddenCodeList().contains(code)) {
                hybirdOfflineManager = OfflineSearchActivity.this.mOfflineManager;
                if (hybirdOfflineManager != null) {
                    hybirdOfflineManager.play(OfflineSearchActivity.this.getLifecycle(), info);
                    return;
                }
                return;
            }
            OfflineUtil.INSTANCE.showDownloadedVipDialog((FragmentActivity) OfflineSearchActivity.this, code, info);
        }
    };
    private final BottomView.BottomActionCallback mBottomAction = new OfflineSearchActivity$mBottomAction$1(this);

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    protected void onCreate(Bundle savedInstanceState) {
        SearchView.QueryText queryTextView;
        super.onCreate(savedInstanceState);
        tintStatusBar((Activity) this);
        setContentView(tv.danmaku.bili.R.layout.bili_app_activity_offline_search);
        findViewById(tv.danmaku.bili.R.id.cancel).setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.offline.OfflineSearchActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OfflineSearchActivity.this.onBackPressed();
            }
        });
        this.mSearchView = (SearchView) findViewById(tv.danmaku.bili.R.id.search_bar);
        SearchView searchView = this.mSearchView;
        if (searchView != null && (queryTextView = searchView.getQueryTextView()) != null) {
            queryTextView.setHintTextColor(ThemeUtils.getColorById((Context) this, com.bilibili.lib.theme.R.color.Ga4));
        }
        SearchView searchView2 = this.mSearchView;
        if (searchView2 != null) {
            searchView2.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: tv.danmaku.bili.ui.offline.OfflineSearchActivity$onCreate$2
                @Override // tv.danmaku.bili.widget.SearchView.OnQueryTextListener
                public boolean onQueryTextSubmit(String query) {
                    Intrinsics.checkNotNullParameter(query, "query");
                    if (!TextUtils.isEmpty(query)) {
                        OfflineSearchActivity.this.doSearch(query);
                        return false;
                    }
                    return false;
                }

                @Override // tv.danmaku.bili.widget.SearchView.OnQueryTextListener
                public boolean onQueryTextChange(String newText) {
                    Intrinsics.checkNotNullParameter(newText, "newText");
                    return false;
                }

                @Override // tv.danmaku.bili.widget.SearchView.OnQueryTextListener
                public boolean onSuggestionQuery(String query) {
                    Intrinsics.checkNotNullParameter(query, "query");
                    return false;
                }
            });
        }
        requestFocus();
        this.mResultCount = (TextView) findViewById(tv.danmaku.bili.R.id.summary);
        this.mBottomContainer = (FrameLayout) findViewById(tv.danmaku.bili.R.id.bottom_container);
        this.mTipView = (LinearLayout) findViewById(tv.danmaku.bili.R.id.tip_view);
        this.mTipImage = findViewById(tv.danmaku.bili.R.id.tip_image);
        this.mTipMessage = (TextView) findViewById(tv.danmaku.bili.R.id.tip_message);
        this.mRecyclerView = findViewById(tv.danmaku.bili.R.id.recycler);
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager((Context) this));
        }
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 != null) {
            recyclerView2.addItemDecoration(createItemDecoration());
        }
        this.mOfflineManager = new HybirdOfflineManager();
    }

    protected void onStart() {
        super.onStart();
        if (this.mIsEditMode) {
            toggleEditMode();
        }
        HybirdOfflineManager hybirdOfflineManager = this.mOfflineManager;
        if (hybirdOfflineManager != null) {
            hybirdOfflineManager.onStart((Context) this);
        }
    }

    protected void onStop() {
        super.onStop();
        HybirdOfflineManager hybirdOfflineManager = this.mOfflineManager;
        if (hybirdOfflineManager != null) {
            hybirdOfflineManager.onStop((Context) this);
        }
    }

    protected void onPause() {
        super.onPause();
        SearchView searchView = this.mSearchView;
        if (searchView != null) {
            searchView.clearFocus();
        }
    }

    private final void requestFocus() {
        SearchView it = this.mSearchView;
        if (it != null) {
            it.getViewTreeObserver().addOnGlobalLayoutListener(new OfflineSearchActivity$requestFocus$1$1(it, this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void forceRequestFocus() {
        SearchView view2 = this.mSearchView;
        if (view2 != null && !isDestroyCalled()) {
            view2.setFocusable(true);
            view2.requestFocus();
            InputMethodManagerHelper.showSoftInput((Context) this, (View) view2.getQueryTextView(), 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doSearch(final String query) {
        this.mQuery = query;
        InputMethodManagerHelper.hideSoftInput((Context) this, getCurrentFocus(), 2);
        SearchView it = this.mSearchView;
        if (it != null) {
            it.clearFocus();
            it.setFocusable(false);
        }
        setBottomBarVisible(false);
        showLoading();
        HybirdOfflineManager hybirdOfflineManager = this.mOfflineManager;
        if (hybirdOfflineManager != null) {
            hybirdOfflineManager.search(query, new IOfflineManager.OfflineDataLoadListener() { // from class: tv.danmaku.bili.ui.offline.OfflineSearchActivity$$ExternalSyntheticLambda1
                public final void onLoadCompleted(List list) {
                    OfflineSearchActivity.doSearch$lambda$1(OfflineSearchActivity.this, query, list);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doSearch$lambda$1(OfflineSearchActivity this$0, String $query, List infoList) {
        List list = infoList;
        if (list == null || list.isEmpty()) {
            this$0.showEmpty();
            return;
        }
        this$0.hideLoading();
        TextView textView = this$0.mResultCount;
        if (textView != null) {
            textView.setText(this$0.getResources().getQuantityString(R.plurals.playerbaseres_global_string_2351, infoList.size(), $query, Integer.valueOf(infoList.size())));
        }
        OfflineSearchAdapter adapter = new OfflineSearchAdapter(infoList, this$0.mItemActionCallback);
        if (this$0.mAdapter == null) {
            RecyclerView recyclerView = this$0.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.setAdapter(adapter);
            }
        } else {
            RecyclerView recyclerView2 = this$0.mRecyclerView;
            if (recyclerView2 != null) {
                recyclerView2.swapAdapter(adapter, false);
            }
        }
        this$0.mAdapter = adapter;
        OfflineSearchAdapter offlineSearchAdapter = this$0.mAdapter;
        this$0.asyncGetPlayTime(offlineSearchAdapter != null ? offlineSearchAdapter.getInfo() : null);
    }

    private final void asyncGetPlayTime(List<OfflineInfo> list) {
        List<OfflineInfo> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new OfflineSearchActivity$asyncGetPlayTime$1(this, list, null), 3, (Object) null);
    }

    private final void showLoading() {
        TextView textView = this.mResultCount;
        if (textView != null) {
            textView.setVisibility(8);
        }
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        BiliImageView biliImageView = this.mTipImage;
        if (biliImageView != null) {
            BiliImageLoader biliImageLoader = BiliImageLoader.INSTANCE;
            Context context = biliImageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            biliImageLoader.with(context).url(AppResUtil.getImageUrl("img_holder_loading_style1.webp")).into(biliImageView);
        }
        TextView textView2 = this.mTipMessage;
        if (textView2 != null) {
            textView2.setText(bili.resource.following.R.string.following_global_string_540);
        }
        LinearLayout linearLayout = this.mTipView;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
    }

    private final void hideLoading() {
        LinearLayout linearLayout = this.mTipView;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        TextView textView = this.mResultCount;
        if (textView != null) {
            textView.setVisibility(0);
        }
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEmpty() {
        TextView textView = this.mResultCount;
        if (textView != null) {
            textView.setVisibility(8);
        }
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        StaticImageView2 staticImageView2 = this.mTipImage;
        if (staticImageView2 != null) {
            staticImageView2.setImageResource(com.bilibili.app.comm.baseres.R.drawable.img_holder_empty_style2);
        }
        TextView textView2 = this.mTipMessage;
        if (textView2 != null) {
            textView2.setText(R.string.playerbaseres_global_string_1391);
        }
        LinearLayout linearLayout = this.mTipView;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toggleEditMode() {
        if (this.mAdapter == null) {
            return;
        }
        this.mIsEditMode = !this.mIsEditMode;
        setBottomBarVisible(this.mIsEditMode);
        OfflineSearchAdapter offlineSearchAdapter = this.mAdapter;
        if (offlineSearchAdapter != null) {
            offlineSearchAdapter.setEditMode(this.mIsEditMode);
        }
    }

    private final void setBottomBarVisible(boolean show) {
        BottomView bottomView;
        if (show) {
            if (this.mBottomView == null) {
                this.mBottomView = new BottomView((Context) this);
            }
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-1, -2);
            BottomView bottomView2 = this.mBottomView;
            if (bottomView2 != null) {
                bottomView2.attach(this.mBottomContainer, params, 0, false, this.mBottomAction);
            }
            FrameLayout frameLayout = this.mBottomContainer;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
                return;
            }
            return;
        }
        BottomView bottomView3 = this.mBottomView;
        if ((bottomView3 != null ? bottomView3.getParent() : null) != null && (bottomView = this.mBottomView) != null) {
            bottomView.detach();
        }
        FrameLayout frameLayout2 = this.mBottomContainer;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(8);
        }
    }

    private final RecyclerView.ItemDecoration createItemDecoration() {
        return new VariableDividerDecoration() { // from class: tv.danmaku.bili.ui.offline.OfflineSearchActivity$createItemDecoration$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super((Context) OfflineSearchActivity.this);
            }

            @Override // tv.danmaku.bili.ui.offline.VariableDividerDecoration
            protected int getHorizontalLeftSpace(RecyclerView parent, View child) {
                boolean z;
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(child, "child");
                z = OfflineSearchActivity.this.mIsEditMode;
                return (int) TypedValue.applyDimension(1, z ? 54 : 12, parent.getResources().getDisplayMetrics());
            }
        };
    }

    @Deprecated(message = "Deprecated in Java")
    public void onBackPressed() {
        if (this.mIsEditMode) {
            toggleEditMode();
            return;
        }
        InputMethodManagerHelper.hideSoftInput((Context) this, getCurrentFocus(), 2);
        SearchView it = this.mSearchView;
        if (it != null) {
            it.clearFocus();
            it.setFocusable(false);
        }
        super.onBackPressed();
    }

    private final void tintStatusBar(Activity activity) {
        if (activity == null) {
            return;
        }
        StatusBarCompat.tintStatusBar(activity, ThemeUtils.getThemeAttrColor(activity, androidx.appcompat.R.attr.colorPrimary));
        View findViewById = activity.findViewById(16908290);
        if (findViewById != null) {
            findViewById.setPadding(0, StatusBarCompat.getStatusBarHeight(activity), 0, 0);
        }
    }

    /* compiled from: OfflineSearchActivity.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/ui/offline/OfflineSearchActivity$Companion;", "", "<init>", "()V", "TAG", "", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent createIntent(Context context) {
            return new Intent(context, OfflineSearchActivity.class);
        }
    }
}