package tv.danmaku.bili.ui.offline;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import bili.resource.others.R;
import com.bilibili.base.connectivity.ConnectivityMonitor;
import com.bilibili.fd_service.FreeDataConfig;
import com.bilibili.fd_service.FreeDataManager;
import com.bilibili.fd_service.utils.FdExceptionChecker;
import com.bilibili.lib.accountinfo.BiliAccountInfo;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.image.ImageLoaderPauseOnScrollListener;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseToolbarActivity;
import com.bilibili.lib.ui.garb.Garb;
import com.bilibili.lib.ui.garb.GarbManager;
import com.bilibili.lib.ui.util.MultipleThemeUtils;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.offline.IOfflineManager;
import com.bilibili.offline.OfflineInfo;
import com.bilibili.offline.OfflineType;
import com.bilibili.videodownloader.model.av.Page;
import com.bilibili.videodownloader.ui.VideoDownloadWarningDialog;
import com.bilibili.videodownloader.utils.VideoDownloadSettings;
import com.bilibili.videodownloader.utils.log.LogHelper;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import tv.danmaku.bili.services.videodownload.WrapperErrorCode;
import tv.danmaku.bili.services.videodownload.utils.FreeDataMediaDownloadHelper;
import tv.danmaku.bili.services.videodownload.utils.VideoDownloadNetworkHelper;
import tv.danmaku.bili.ui.freedata.FreeDataEntranceActivity;
import tv.danmaku.bili.ui.offline.BottomView;
import tv.danmaku.bili.ui.offline.DownloadingActivity;
import tv.danmaku.bili.ui.offline.ItemActionCallback;
import tv.danmaku.bili.ui.offline.api.OfflineServiceManager;
import tv.danmaku.bili.widget.LoadingImageView;
import tv.danmaku.bili.widget.dialog.BiliCommonDialog;

public class DownloadingActivity extends BaseToolbarActivity {
    private static final String TAG = "DownloadingActivity";
    private DownloadingAdapter mAdapter;
    private TextView mBatchButton;
    private BottomView mBottomView;
    private ViewGroup mContainer;
    private FreeDataExceptionDialog mFreeDataExceptionDialog;
    private boolean mIsEditMode;
    private LoadingImageView mLoadingView;
    private MenuItem mMenuEdit;
    private HybirdOfflineManager mOfflineManager;
    private String mPlayingKey;
    private RecyclerView mRecyclerView;
    private FrameLayout mRootView;
    private StorageView mStorageView;
    private int mTaskCount;
    private TextView mTaskCountText;
    private IOfflineManager.OfflineDataChangeListener mOfflineDataChange = new IOfflineManager.OfflineDataChangeListener() { // from class: tv.danmaku.bili.ui.offline.DownloadingActivity.1
        public void onOfflineDataChange(List<OfflineInfo> infoList) {
            if (DownloadingActivity.this.isDestroyCalled() || DownloadingActivity.this.mAdapter == null) {
                return;
            }
            for (OfflineInfo offlineInfo : infoList) {
                if (offlineInfo.offlineStatus.code == 4) {
                    DownloadingActivity.this.mAdapter.remove(offlineInfo);
                } else {
                    DownloadingActivity.this.mAdapter.updateStatus(offlineInfo);
                    DownloadingActivity.this.mFreeDataExceptionDialog.showFreeDataErrorDialogIfNeed(offlineInfo);
                }
            }
            if (DownloadingActivity.this.mAdapter.getItemCount() == 0) {
                if (DownloadingActivity.this.mIsEditMode) {
                    DownloadingActivity.this.toggleEditMode();
                }
                DownloadingActivity.this.setMenuEditVisible(false);
                DownloadingActivity.this.showEmpty();
                return;
            }
            DownloadingActivity.this.updateBatchButton(DownloadingActivity.this.mAdapter.isAllStopped());
        }
    };
    private ItemActionCallback.Downloading mItemActionCallback = new ItemActionCallback.Downloading() { // from class: tv.danmaku.bili.ui.offline.DownloadingActivity.2
        @Override // tv.danmaku.bili.ui.offline.ItemActionCallback.PlayAction
        public void play(Context context, OfflineInfo info) {
            if (BiliAccountInfo.get().isEffectiveVip()) {
                DownloadingActivity.this.mOfflineManager.play(DownloadingActivity.this.getLifecycle(), info);
                autoStart(info);
                DownloadingActivity.this.mPlayingKey = DownloadingActivity.this.mOfflineManager.findDownloadingEntryKey(info);
                if (DownloadingActivity.this.mPlayingKey != null) {
                    DownloadingActivity.this.mOfflineManager.setInterruptTransformTempFile(DownloadingActivity.this.mPlayingKey, true);
                    return;
                }
                return;
            }
            DownloadingActivity.showVipDialog(DownloadingActivity.this, DownloadingActivity.this.getString(R.string.others_global_string_39), "loading", 2);
        }

        @Override // tv.danmaku.bili.ui.offline.ItemActionCallback
        public void onCheckedItemCountChange(int checkedCount, boolean allChecked) {
            if (DownloadingActivity.this.mIsEditMode && DownloadingActivity.this.mBottomView != null) {
                DownloadingActivity.this.mBottomView.updateCheckCount(checkedCount, allChecked);
            }
        }

        @Override // tv.danmaku.bili.ui.offline.ItemActionCallback
        public void enterEditMode() {
            if (!DownloadingActivity.this.mIsEditMode) {
                DownloadingActivity.this.toggleEditMode();
            }
        }

        @Override // tv.danmaku.bili.ui.offline.ItemActionCallback
        public void onItemCountChange(int count) {
            if (count > 0) {
                DownloadingActivity.this.setMenuEditVisible(true);
                return;
            }
            DownloadingActivity.this.setMenuEditVisible(false);
            DownloadingActivity.this.mStorageView.setVisibility(8);
            DownloadingActivity.this.mBatchButton.setVisibility(8);
            DownloadingActivity.this.showEmpty();
        }

        @Override // tv.danmaku.bili.ui.offline.ItemActionCallback.PauseResumeAction
        public void pauseResume(final OfflineInfo info) {
            if (info.offlineStatus.code == 5 || info.offlineStatus.code == 3 || info.offlineStatus.code == 1) {
                DownloadingActivity.this.mOfflineManager.stop(info);
                OfflineReporter.reportDownloadingItemPause(info);
            } else if (!VideoDownloadNetworkHelper.showNetWorkWarningDialogIfNeed(DownloadingActivity.this.getApplicationContext(), DownloadingActivity.this.getSupportFragmentManager(), DownloadingActivity.this.isThirdFrom(info), new VideoDownloadWarningDialog.ContinueListener() { // from class: tv.danmaku.bili.ui.offline.DownloadingActivity.2.1
                public void onConfirm(int expectedNetworkType) {
                    start(info, expectedNetworkType);
                }

                public void onNeutral(int networkType) {
                    DownloadingActivity.this.startFreeDataEntranceActivity();
                    FreeDataConfig.getReporter().reportPageClick(3);
                }
            })) {
                start(info, FreeDataMediaDownloadHelper.getNetworkType(DownloadingActivity.this.getApplicationContext()));
            }
        }

        public void autoStart(OfflineInfo info) {
            if (info.offlineStatus != null && info.offlineStatus.code != 5 && info.offlineStatus.code != 3 && info.offlineStatus.code != 1 && VideoDownloadNetworkHelper.isNetWorkAllowAutoDownload(DownloadingActivity.this.getApplicationContext(), DownloadingActivity.this.isThirdFrom(info))) {
                start(info, FreeDataMediaDownloadHelper.getNetworkType(DownloadingActivity.this.getApplicationContext()));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void start(OfflineInfo info, int netType) {
            DownloadingActivity.this.mOfflineManager.start(info, netType);
            OfflineReporter.reportDownloadingItemStart(info);
        }
    };
    private View.OnClickListener mBatchListener = new View.OnClickListener() { // from class: tv.danmaku.bili.ui.offline.DownloadingActivity$$ExternalSyntheticLambda0
        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            DownloadingActivity.this.m1345lambda$new$1$tvdanmakubiliuiofflineDownloadingActivity(view2);
        }
    };
    private BottomView.BottomActionCallback mBottomAction = new AnonymousClass4();

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(tv.danmaku.bili.R.layout.bili_app_activity_offline_downloading);
        ensureToolbar();
        showBackButton();
        setTitle(bili.resource.playerbaseres.R.string.playerbaseres_global_string_1454);
        this.mRootView = (FrameLayout) findViewById(16908290);
        this.mContainer = (ViewGroup) findViewById(tv.danmaku.bili.R.id.content_layout);
        this.mBatchButton = (TextView) findViewById(tv.danmaku.bili.R.id.batch_button);
        this.mTaskCountText = (TextView) findViewById(tv.danmaku.bili.R.id.task_count);
        this.mBatchButton.setOnClickListener(this.mBatchListener);
        this.mStorageView = attachStorageView();
        this.mRecyclerView = findViewById(tv.danmaku.bili.R.id.recycler);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.mRecyclerView.addOnScrollListener(new ImageLoaderPauseOnScrollListener());
        this.mOfflineManager = new HybirdOfflineManager();
        this.mTaskCountText.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.offline.DownloadingActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DownloadingActivity.this.m1346lambda$onCreate$0$tvdanmakubiliuiofflineDownloadingActivity(view2);
            }
        });
        this.mFreeDataExceptionDialog = new FreeDataExceptionDialog(this, this.mOfflineManager);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$0$tv-danmaku-bili-ui-offline-DownloadingActivity  reason: not valid java name */
    public /* synthetic */ void m1346lambda$onCreate$0$tvdanmakubiliuiofflineDownloadingActivity(View v) {
        Neurons.reportClick(false, OfflineReportHelper.CLICK_CHANGE_TASK_COUNT);
        showTaskCountSettingDialog();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onStart() {
        super.onStart();
        this.mOfflineManager.onStart(this);
        updateUI();
        if (this.mPlayingKey != null) {
            this.mOfflineManager.setInterruptTransformTempFile(this.mPlayingKey, false);
            this.mPlayingKey = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onStop() {
        super.onStop();
        this.mOfflineManager.unRegisterDataChangeListener(this.mOfflineDataChange);
        this.mOfflineManager.onStop(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.mOfflineManager.release();
    }

    private void updateUI() {
        if (this.mAdapter != null) {
            if (this.mIsEditMode) {
                toggleEditMode();
            }
            setMenuEditVisible(false);
        }
        setTaskCountText(VideoDownloadSettings.getTaskCount());
        loadData();
    }

    private void loadData() {
        showLoading();
        this.mOfflineManager.getDownloadingItemsForDownloadPage(new IOfflineManager.OfflineDataLoadListener() { // from class: tv.danmaku.bili.ui.offline.DownloadingActivity$$ExternalSyntheticLambda4
            public final void onLoadCompleted(List list) {
                DownloadingActivity.this.onDataLoad(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDataLoad(List<OfflineInfo> offlineInfos) {
        if (isDestroyCalled()) {
            return;
        }
        if (offlineInfos == null || offlineInfos.isEmpty()) {
            showEmpty();
            setMenuEditVisible(false);
        } else {
            hideLoading();
            setMenuEditVisible(true);
            List<OfflineInfo> downloadingInfos = new ArrayList<>();
            for (OfflineInfo info : offlineInfos) {
                if (info.offlineStatus.code == 1 || info.offlineStatus.code == 5 || info.offlineStatus.code == 3) {
                    downloadingInfos.add(info);
                }
            }
            DownloadingAdapter adapter = new DownloadingAdapter(offlineInfos, downloadingInfos, this.mItemActionCallback);
            if (this.mAdapter != null) {
                this.mRecyclerView.swapAdapter(adapter, true);
            } else {
                this.mRecyclerView.setAdapter(adapter);
            }
            this.mAdapter = adapter;
            this.mBatchButton.setVisibility(0);
            updateBatchButton(this.mAdapter.isAllStopped());
            this.mStorageView.checkStorage();
        }
        this.mOfflineManager.registerDataChangeListener(this.mOfflineDataChange);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$1$tv-danmaku-bili-ui-offline-DownloadingActivity  reason: not valid java name */
    public /* synthetic */ void m1345lambda$new$1$tvdanmakubiliuiofflineDownloadingActivity(View v) {
        boolean isAllStop = ((Boolean) this.mBatchButton.getTag()).booleanValue();
        if (isAllStop) {
            startAll(this.mAdapter.getOfflineInfo());
            OfflineReporter.reportDownloadingStartAll();
            return;
        }
        this.mOfflineManager.stopAll();
        OfflineReporter.reportDownloadingPauseAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void updateBatchButton(boolean isAllStopped) {
        Boolean lastState = (Boolean) this.mBatchButton.getTag();
        if (lastState != null && lastState.equals(Boolean.valueOf(isAllStopped))) {
            return;
        }
        Drawable create = VectorDrawableCompat.create(getResources(), isAllStopped ? com.bilibili.app.comm.baseres.R.drawable.ic_vector_nav_bar_cache : tv.danmaku.bili.R.drawable.ic_vector_pause, (Resources.Theme) null);
        if (create != null) {
            int iconSize = (int) TypedValue.applyDimension(1, 20.0f, getResources().getDisplayMetrics());
            int iconColor = ThemeUtils.getColorById(this, com.bilibili.lib.theme.R.color.Ga7);
            create.setBounds(0, 0, iconSize, iconSize);
            DrawableCompat.setTint(create, iconColor);
        }
        String text = getString(isAllStopped ? R.string.others_global_string_127 : R.string.others_global_string_368);
        this.mBatchButton.setCompoundDrawables(create, null, null, null);
        this.mBatchButton.setText(text);
        this.mBatchButton.setTag(Boolean.valueOf(isAllStopped));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void enableOperationButton(boolean enable) {
        Drawable[] drawable = this.mBatchButton.getCompoundDrawables();
        Drawable icon = drawable[0];
        int iconColor = ThemeUtils.getColorById(this, enable ? com.bilibili.lib.theme.R.color.Ga7 : com.bilibili.lib.theme.R.color.Ga4);
        if (icon != null) {
            int iconSize = (int) TypedValue.applyDimension(1, 20.0f, getResources().getDisplayMetrics());
            icon.setBounds(0, 0, iconSize, iconSize);
            DrawableCompat.setTint(icon, iconColor);
            this.mBatchButton.setCompoundDrawables(icon, null, null, null);
        }
        this.mBatchButton.setTextColor(iconColor);
        this.mBatchButton.setEnabled(enable);
        this.mTaskCountText.setTextColor(iconColor);
        this.mTaskCountText.setEnabled(enable);
        setTaskCountText(this.mTaskCount);
    }

    public void startAll(List<OfflineInfo> infoList) {
        if (!VideoDownloadNetworkHelper.showNetWorkWarningDialogIfNeed(getApplicationContext(), getSupportFragmentManager(), isThirdFrom(infoList), new VideoDownloadWarningDialog.ContinueListener() { // from class: tv.danmaku.bili.ui.offline.DownloadingActivity.3
            public void onConfirm(int expectedNetworkType) {
                DownloadingActivity.this.mOfflineManager.startAll(expectedNetworkType);
            }

            public void onNeutral(int networkType) {
                DownloadingActivity.this.startFreeDataEntranceActivity();
                FreeDataConfig.getReporter().reportPageClick(3);
            }
        })) {
            this.mOfflineManager.startAll(FreeDataMediaDownloadHelper.getNetworkType(getApplicationContext()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void startFreeDataEntranceActivity() {
        RouteRequest request = new RouteRequest.Builder("bilibili://main/free-data-entrance").data(Uri.parse(FreeDataEntranceActivity.TARGET_WEB_SITE)).build();
        BLRouter.routeTo(request, this);
    }

    private boolean isThirdFrom(List<OfflineInfo> infoList) {
        if (infoList != null && infoList.size() > 0) {
            for (OfflineInfo info : infoList) {
                if (isThirdFrom(info) && info.offlineStatus.code == 2) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isThirdFrom(OfflineInfo info) {
        Page page;
        if (info.offlineType.type == OfflineType.TYPE_VIDEO && (page = (Page) info.typeInfo) != null) {
            return FreeDataMediaDownloadHelper.isThirdFrom(page.from);
        }
        return false;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(tv.danmaku.bili.R.menu.menu_offline_edit, menu);
        this.mMenuEdit = menu.findItem(tv.danmaku.bili.R.id.menu_edit);
        if (this.mAdapter == null || this.mAdapter.getItemCount() == 0) {
            setMenuEditVisible(false);
        }
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == tv.danmaku.bili.R.id.menu_edit) {
            if (!this.mIsEditMode) {
                OfflineReporter.reportDownloadingEditMenuClick();
            }
            toggleEditMode();
        }
        return super.onOptionsItemSelected(item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void toggleEditMode() {
        if (this.mAdapter == null) {
            return;
        }
        this.mIsEditMode = !this.mIsEditMode;
        this.mMenuEdit.setTitle(this.mIsEditMode ? bili.resource.common.R.string.common_global_string_238 : bili.resource.common.R.string.common_global_string_247);
        enableOperationButton(!this.mIsEditMode);
        setBottomBarVisible(this.mIsEditMode);
        this.mAdapter.setEditMode(this.mIsEditMode);
        Garb garb = GarbManager.getCurGarb();
        MultipleThemeUtils.refreshMenuTitleTint(this, getToolbar(), this.mMenuEdit, garb.isPure() ? 0 : garb.getFontColor());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setBottomBarVisible(boolean show) {
        if (show) {
            if (this.mBottomView == null) {
                this.mBottomView = new BottomView(this);
            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-1, -2);
            this.mBottomView.attach(this.mContainer, params, 4, false, this.mBottomAction);
        } else if (this.mBottomView != null) {
            this.mBottomView.detach();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showTaskCountSettingDialog() {
        final BottomSheetDialog dialog = new BottomSheetDialog(this);
        ViewGroup viewGroup = null;
        View root = View.inflate(this, tv.danmaku.bili.R.layout.bili_app_layout_download_task_count, null);
        LinearLayout linearLayout = (LinearLayout) root.findViewById(tv.danmaku.bili.R.id.list);
        int i = 1;
        while (i <= 3) {
            View itemView = View.inflate(this, tv.danmaku.bili.R.layout.bili_app_layout_item_download_task_count, viewGroup);
            final TextView countTv = (TextView) itemView.findViewById(tv.danmaku.bili.R.id.text);
            ImageView tick = (ImageView) itemView.findViewById(tv.danmaku.bili.R.id.tick);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            String countStr = getString(bili.resource.homepage.R.string.homepage_global_string_253, new Object[]{String.valueOf(i)});
            spannableStringBuilder.append((CharSequence) countStr);
            if (isTaskCountForVip(i)) {
                spannableStringBuilder.append((CharSequence) getString(bili.resource.homepage.R.string.homepage_global_string_364));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(com.bilibili.lib.ui.R.color.pink_kit)), countStr.length(), spannableStringBuilder.length(), 17);
            }
            countTv.setText(spannableStringBuilder);
            if (i == 3) {
                itemView.findViewById(tv.danmaku.bili.R.id.line).setVisibility(8);
            }
            if (this.mTaskCount == i) {
                tick.setVisibility(0);
            } else {
                tick.setVisibility(8);
            }
            countTv.setTag(Integer.valueOf(i));
            itemView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.offline.DownloadingActivity$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DownloadingActivity.this.m1347lambda$showTaskCountSettingDialog$2$tvdanmakubiliuiofflineDownloadingActivity(countTv, dialog, view2);
                }
            });
            linearLayout.addView(itemView);
            i++;
            viewGroup = null;
        }
        dialog.setContentView(root);
        final BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from((View) root.getParent());
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: tv.danmaku.bili.ui.offline.DownloadingActivity$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                bottomSheetBehavior.setState(4);
            }
        });
        TextView cancel = (TextView) root.findViewById(tv.danmaku.bili.R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.offline.DownloadingActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$showTaskCountSettingDialog$2$tv-danmaku-bili-ui-offline-DownloadingActivity  reason: not valid java name */
    public /* synthetic */ void m1347lambda$showTaskCountSettingDialog$2$tvdanmakubiliuiofflineDownloadingActivity(TextView countTv, BottomSheetDialog dialog, View v) {
        int count = ((Integer) countTv.getTag()).intValue();
        changeDownloadingTaskCount(count);
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: tv.danmaku.bili.ui.offline.DownloadingActivity$4  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public class AnonymousClass4 extends BottomView.BottomActionCallback {
        AnonymousClass4() {
        }

        @Override // tv.danmaku.bili.ui.offline.BottomView.BottomActionCallback
        public void checkAll(boolean check) {
            DownloadingActivity.this.mAdapter.checkAll(check);
            OfflineReporter.reportDownloadingSelectAll();
        }

        @Override // tv.danmaku.bili.ui.offline.BottomView.BottomActionCallback
        public void delete() {
            new AlertDialog.Builder(DownloadingActivity.this, com.bilibili.app.preferences.R.style.AppTheme_Dialog_Alert).setMessage(bili.resource.homepage.R.string.homepage_global_string_129).setNegativeButton(bili.resource.common.R.string.common_global_string_238, (DialogInterface.OnClickListener) null).setPositiveButton(bili.resource.common.R.string.common_global_string_113, new DialogInterface.OnClickListener() { // from class: tv.danmaku.bili.ui.offline.DownloadingActivity$4$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    DownloadingActivity.AnonymousClass4.this.m1349lambda$delete$0$tvdanmakubiliuiofflineDownloadingActivity$4(dialogInterface, i);
                }
            }).show();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$delete$0$tv-danmaku-bili-ui-offline-DownloadingActivity$4  reason: not valid java name */
        public /* synthetic */ void m1349lambda$delete$0$tvdanmakubiliuiofflineDownloadingActivity$4(DialogInterface dialog, int which) {
            Collection<OfflineInfo> collections = DownloadingActivity.this.mAdapter.getCheckedInfo();
            LogHelper.i(DownloadingActivity.TAG, "user call delete video from downloading activity > " + OfflineUtil.INSTANCE.getOfflineInfoString(collections));
            LogHelper.i(DownloadingActivity.TAG, "user call delete video counts > " + collections.size());
            DownloadingActivity.this.mOfflineManager.delete(collections);
            DownloadingActivity.this.mAdapter.removeChecked(false);
            DownloadingActivity.this.updateBatchButton(DownloadingActivity.this.mAdapter.isAllStopped());
            DownloadingActivity.this.toggleEditMode();
            OfflineReporter.reportDownloadingDelete();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private StorageView attachStorageView() {
        StorageView storageView = new StorageView(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-1, -2);
        storageView.attach(this.mContainer, params, 3);
        return storageView;
    }

    public void onBackPressed() {
        if (this.mIsEditMode) {
            toggleEditMode();
        } else {
            super.onBackPressed();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private LoadingImageView getLoadingView() {
        if (this.mLoadingView == null) {
            this.mLoadingView = new LoadingImageView(this);
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-2, -2);
            params.gravity = 17;
            this.mRootView.addView(this.mLoadingView, params);
        }
        return this.mLoadingView;
    }

    private void showLoading() {
        this.mBatchButton.setVisibility(8);
        this.mTaskCountText.setVisibility(8);
        this.mRecyclerView.setVisibility(8);
        this.mStorageView.setVisibility(8);
        getLoadingView().setRefreshing();
    }

    private void hideLoading() {
        this.mTaskCountText.setVisibility(0);
        this.mRecyclerView.setVisibility(0);
        if (this.mLoadingView != null) {
            this.mRootView.removeView(this.mLoadingView);
            this.mLoadingView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showEmpty() {
        this.mTaskCountText.setVisibility(8);
        this.mBatchButton.setVisibility(8);
        this.mRecyclerView.setVisibility(8);
        this.mStorageView.setVisibility(8);
        getLoadingView().setRefreshComplete();
        getLoadingView().setImageResource(com.bilibili.app.comm.baseres.R.drawable.img_holder_empty_style2);
        getLoadingView().showEmptyTips(bili.resource.common.R.string.common_global_string_66);
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, DownloadingActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void setMenuEditVisible(boolean visible) {
        if (this.mMenuEdit != null) {
            this.mMenuEdit.setVisible(visible);
            if (visible) {
                Garb garb = GarbManager.getCurGarb();
                MultipleThemeUtils.refreshMenuTitleTint(this, getToolbar(), this.mMenuEdit, garb.isPure() ? 0 : garb.getFontColor());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class FreeDataExceptionDialog {
        private static final String CONFIG_FREE_DATA_URL_KEY = "bandwidth.free_data_exception_url";
        private static final int MAX_POP_DIALOG_TIMES = 2;
        public static final String TAG = "FreeDataExceptionDialog";
        private static int curClickDownloadByTraffic = 0;
        private Activity mActivity;
        private AlertDialog mFdExceptionDialog;
        private List<OfflineInfo> mFdFailTasks;
        private HybirdOfflineManager mOfflineManager;

        public FreeDataExceptionDialog(Activity activity, HybirdOfflineManager offlineManager) {
            this.mActivity = activity;
            this.mOfflineManager = offlineManager;
        }

        public void showFreeDataErrorDialogIfNeed(OfflineInfo offlineInfo) {
            if (FreeDataManager.getInstance().isFreeDataForbade(this.mActivity, FreeDataManager.ForbadeType.VIDEO_DOWNLOAD) || offlineInfo.offlineStatus.code != 2) {
                return;
            }
            if (WrapperErrorCode.UNICON_RESOLVE_UNSUPPORT_THIRD == offlineInfo.errorCode || WrapperErrorCode.UNICON_RESOLVE_TRANSFORM_SEGMENT == offlineInfo.errorCode || WrapperErrorCode.UNICON_RESOLVE_TRANSFORM_IP == offlineInfo.errorCode || WrapperErrorCode.UNICON_RESOLVE_CONDITION_NOT_MATHCED == offlineInfo.errorCode) {
                if (this.mFdFailTasks == null) {
                    this.mFdFailTasks = new ArrayList();
                }
                this.mFdFailTasks.add(offlineInfo);
                if (this.mFdExceptionDialog == null) {
                    this.mFdExceptionDialog = new AlertDialog.Builder(this.mActivity).setTitle(this.mActivity.getString(R.string.others_global_string_107)).setMessage(OfflineUtil.getFdErrorTips(this.mActivity, offlineInfo.fdErrorCode) + this.mActivity.getString(bili.resource.downloads.R.string.downloads_global_string_121)).setCancelable(false).setPositiveButton(this.mActivity.getString(bili.resource.common.R.string.common_global_string_202), new DialogInterface.OnClickListener() { // from class: tv.danmaku.bili.ui.offline.DownloadingActivity$FreeDataExceptionDialog$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            DownloadingActivity.FreeDataExceptionDialog.this.m1350lambda$showFreeDataErrorDialogIfNeed$0$tvdanmakubiliuiofflineDownloadingActivity$FreeDataExceptionDialog(dialogInterface, i);
                        }
                    }).setNegativeButton(this.mActivity.getString(bili.resource.common.R.string.common_global_string_238), (DialogInterface.OnClickListener) null).setNeutralButton(this.mActivity.getString(R.string.others_global_string_252), new DialogInterface.OnClickListener() { // from class: tv.danmaku.bili.ui.offline.DownloadingActivity$FreeDataExceptionDialog$$ExternalSyntheticLambda1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            DownloadingActivity.FreeDataExceptionDialog.this.m1351lambda$showFreeDataErrorDialogIfNeed$1$tvdanmakubiliuiofflineDownloadingActivity$FreeDataExceptionDialog(dialogInterface, i);
                        }
                    }).create();
                }
                if (!this.mFdExceptionDialog.isShowing()) {
                    this.mFdExceptionDialog.setMessage(OfflineUtil.getFdErrorTips(this.mActivity, offlineInfo.fdErrorCode) + this.mActivity.getString(bili.resource.downloads.R.string.downloads_global_string_121));
                    this.mFdExceptionDialog.show();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$showFreeDataErrorDialogIfNeed$0$tv-danmaku-bili-ui-offline-DownloadingActivity$FreeDataExceptionDialog  reason: not valid java name */
        public /* synthetic */ void m1350lambda$showFreeDataErrorDialogIfNeed$0$tvdanmakubiliuiofflineDownloadingActivity$FreeDataExceptionDialog(DialogInterface dialog, int which) {
            curClickDownloadByTraffic++;
            if (curClickDownloadByTraffic >= 2) {
                FdExceptionChecker.getInstance().setFreeDataForbade(this.mActivity, true);
            }
            for (OfflineInfo ofInfo : this.mFdFailTasks) {
                this.mOfflineManager.start(ofInfo, false, ConnectivityMonitor.getInstance().getNetworkWithoutCache());
            }
            this.mFdFailTasks.clear();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$showFreeDataErrorDialogIfNeed$1$tv-danmaku-bili-ui-offline-DownloadingActivity$FreeDataExceptionDialog  reason: not valid java name */
        public /* synthetic */ void m1351lambda$showFreeDataErrorDialogIfNeed$1$tvdanmakubiliuiofflineDownloadingActivity$FreeDataExceptionDialog(DialogInterface dialog, int which) {
            Uri uri;
            String fdUrl = (String) ConfigManager.config().get(CONFIG_FREE_DATA_URL_KEY, "");
            if (TextUtils.isEmpty(fdUrl)) {
                uri = Uri.parse(FreeDataEntranceActivity.TARGET_WEB_SITE);
            } else {
                uri = Uri.parse(fdUrl);
            }
            RouteRequest request = new RouteRequest.Builder("bilibili://main/free-data-entrance").data(uri).build();
            BLRouter.routeTo(request, this.mActivity);
        }
    }

    private boolean isTaskCountForVip(int taskCount) {
        return taskCount >= 2;
    }

    private void changeDownloadingTaskCount(int taskCount) {
        if (isTaskCountForVip(taskCount) && !BiliAccountInfo.get().isEffectiveVip()) {
            showVipDialog(this, getString(R.string.others_global_string_231), "meantime", 1);
            return;
        }
        VideoDownloadSettings.putTaskCount(taskCount);
        setTaskCountText(taskCount);
        this.mOfflineManager.changeVideoDownloadingTaskCount(taskCount);
        OfflineServiceManager.reportChangeTaskCount(taskCount);
    }

    private void setTaskCountText(int taskCount) {
        this.mTaskCount = taskCount;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String string = getString(R.string.others_global_string_31);
        spannableStringBuilder.append((CharSequence) string);
        spannableStringBuilder.append((CharSequence) " ").append((CharSequence) String.valueOf(taskCount));
        int color = getResources().getColor(com.bilibili.lib.theme.R.color.Pi5);
        if (!this.mTaskCountText.isEnabled()) {
            color = ColorUtils.setAlphaComponent(color, 76);
        }
        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), string.length(), spannableStringBuilder.length(), 17);
        this.mTaskCountText.setText(spannableStringBuilder);
    }

    public static void showVipDialog(final FragmentActivity context, String content, final String subAppId, final int reportType) {
        OfflineReportHelper.reportVipDialogShow(reportType);
        new BiliCommonDialog.Builder(context).setTitle(content).setButtonStyle(1).setNegativeButton(context.getString(bili.resource.common.R.string.common_global_string_238), new BiliCommonDialog.OnDialogTextClickListener() { // from class: tv.danmaku.bili.ui.offline.DownloadingActivity$$ExternalSyntheticLambda1
            @Override // tv.danmaku.bili.widget.dialog.BiliCommonDialog.OnDialogTextClickListener
            public final void onDialogTextClicked(View view2, BiliCommonDialog biliCommonDialog) {
                OfflineReportHelper.reportVipDialogClick(reportType, 2);
            }
        }, true).setPositiveButton(context.getString(bili.resource.playerbaseres.R.string.playerbaseres_global_string_630), new BiliCommonDialog.OnDialogTextClickListener() { // from class: tv.danmaku.bili.ui.offline.DownloadingActivity$$ExternalSyntheticLambda2
            @Override // tv.danmaku.bili.widget.dialog.BiliCommonDialog.OnDialogTextClickListener
            public final void onDialogTextClicked(View view2, BiliCommonDialog biliCommonDialog) {
                DownloadingActivity.lambda$showVipDialog$6(subAppId, context, reportType, view2, biliCommonDialog);
            }
        }, true).build().show(context.getSupportFragmentManager(), "vip_dialog");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$showVipDialog$6(String subAppId, FragmentActivity context, int reportType, View view2, BiliCommonDialog dialog) {
        RouteRequest request = new RouteRequest.Builder(Uri.parse("bilibili://user_center/vip/buy/26?appSubId=" + subAppId)).build();
        BLRouter bLRouter = BLRouter.INSTANCE;
        BLRouter.routeTo(request, context);
        OfflineReportHelper.reportVipDialogClick(reportType, 1);
    }
}