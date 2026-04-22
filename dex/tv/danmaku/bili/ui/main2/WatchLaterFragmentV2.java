package tv.danmaku.bili.ui.main2;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.app.comm.baseres.R;
import com.bilibili.app.comm.list.common.report.ListCommonReport;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.app.history.utils.TimeUtils;
import com.bilibili.base.util.ContextUtilKt;
import com.bilibili.droid.BundleUtil;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accountinfo.BiliAccountInfo;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.image2.bean.ScaleType;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.imageviewer.utils.ImageExtentionKt;
import com.bilibili.lib.ui.BaseAppCompatActivity;
import com.bilibili.lib.ui.garb.Garb;
import com.bilibili.lib.ui.garb.GarbManager;
import com.bilibili.lib.ui.mixin.Flag;
import com.bilibili.lib.ui.util.MultipleThemeUtils;
import com.bilibili.lib.ui.util.StatusBarCompat;
import com.bilibili.magicasakura.widgets.GarbTintToolBar;
import com.bilibili.magicasakura.widgets.TintCheckBox;
import com.bilibili.magicasakura.widgets.TintRelativeLayout;
import com.bilibili.magicasakura.widgets.TintTextView;
import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.pvtracker.IPvTracker;
import com.bilibili.pvtracker.PageViewTracker;
import com.squareup.otto.Subscribe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kntr.base.localization.NumberFormat_androidKt;
import tv.danmaku.bili.MainActivityV2;
import tv.danmaku.bili.ui.main.MainPagerRefreshRecyclerFragment;
import tv.danmaku.bili.ui.main2.WatchLaterFragmentV2;
import tv.danmaku.bili.ui.main2.reporter.WatchLaterReporter;
import tv.danmaku.bili.videopage.common.helper.VideoRouter;
import tv.danmaku.bili.videopage.common.watchlater.api.WatchLaterApiManager;
import tv.danmaku.bili.videopage.common.watchlater.api.WatchLaterItem;
import tv.danmaku.bili.videopage.common.watchlater.api.WatchLaterList;
import tv.danmaku.bili.widget.VectorTextView;

public class WatchLaterFragmentV2 extends MainPagerRefreshRecyclerFragment implements IPvTracker {
    public static final String TAG = "WatchLaterFragmentV2";
    private static final int TYPE_MENU_CLEAR = 1;
    private static final int TYPE_MENU_DELETE = 2;
    private static final int TYPE_MENU_EDIT = 0;
    private static final String WATCH_LATER_EVENT_ID = "main.later-watch.0.0.pv";
    private static final String WATCH_LATER_SPMID = "main.later-watch.0.0";
    private static boolean isEditMode = false;
    private static int sCount;
    WatchLaterAdapter adapter;
    private TintCheckBox checkBox;
    private View mBottomBar;
    private boolean mIsLoading;
    private TextView tvDelete;
    TextView tvSelectAll;
    List<WatchLaterItem> watchLaterItems = new ArrayList();
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private View.OnClickListener mSelectClick = new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main2.WatchLaterFragmentV2.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            WatchLaterReporter.reportWatchLaterSelectAllEvent(1);
            if (WatchLaterFragmentV2.this.adapter != null) {
                WatchLaterFragmentV2.this.adapter.selectAll();
            }
        }
    };
    private View.OnClickListener mDeselectClick = new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main2.WatchLaterFragmentV2.2
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            WatchLaterReporter.reportWatchLaterSelectAllEvent(2);
            if (WatchLaterFragmentV2.this.adapter != null) {
                WatchLaterFragmentV2.this.adapter.deselectAll();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface ItemOperationCallBack {
        void hasSelected(boolean z);

        void onClickCardMore(WatchLaterItem watchLaterItem);

        void onItemLongClick(WatchLaterItem watchLaterItem);

        void onItemSelected(boolean z);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: tv.danmaku.bili.ui.main2.WatchLaterFragmentV2$3  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public class AnonymousClass3 implements ItemOperationCallBack {
        AnonymousClass3() {
        }

        @Override // tv.danmaku.bili.ui.main2.WatchLaterFragmentV2.ItemOperationCallBack
        public void onItemSelected(boolean selectAll) {
            WatchLaterFragmentV2.this.onItemSelected(selectAll);
        }

        @Override // tv.danmaku.bili.ui.main2.WatchLaterFragmentV2.ItemOperationCallBack
        public void hasSelected(boolean has) {
            if (has) {
                WatchLaterFragmentV2.this.tvDelete.setTextColor(WatchLaterFragmentV2.this.getResources().getColor(R.color.theme_color_secondary));
            } else {
                WatchLaterFragmentV2.this.tvDelete.setTextColor(WatchLaterFragmentV2.this.getResources().getColor(com.bilibili.lib.theme.R.color.Ga4));
            }
        }

        @Override // tv.danmaku.bili.ui.main2.WatchLaterFragmentV2.ItemOperationCallBack
        public void onItemLongClick(WatchLaterItem item) {
            if (!WatchLaterFragmentV2.isEditMode) {
                WatchLaterFragmentV2.this.adapter.mSelectedAvId.add(Long.valueOf(item.avid));
                WatchLaterFragmentV2.this.switchEditMode(true);
            }
        }

        @Override // tv.danmaku.bili.ui.main2.WatchLaterFragmentV2.ItemOperationCallBack
        public void onClickCardMore(final WatchLaterItem item) {
            final CommonMenuBottomSheet bottomSheet = new CommonMenuBottomSheet();
            Bundle arguments = new Bundle();
            ArrayList<MenuItemBean> beans = new ArrayList<>();
            beans.add(new MenuItemBean(2, com.bilibili.lib.widget.R.drawable.playset_ic_menu_delete, WatchLaterFragmentV2.this.getResources().getString(bili.resource.common.R.string.common_global_string_113)));
            arguments.putParcelableArrayList(CommonMenuBottomSheetKt.KEY_ITEMS, beans);
            bottomSheet.setArguments(arguments);
            bottomSheet.setOnMenuClickListener(new OnMenuClickListener() { // from class: tv.danmaku.bili.ui.main2.WatchLaterFragmentV2$3$$ExternalSyntheticLambda0
                @Override // tv.danmaku.bili.ui.main2.OnMenuClickListener
                public final void onMenuClick(MenuItemBean menuItemBean) {
                    WatchLaterFragmentV2.AnonymousClass3.this.m1959lambda$onClickCardMore$0$tvdanmakubiliuimain2WatchLaterFragmentV2$3(bottomSheet, item, menuItemBean);
                }
            });
            bottomSheet.show(WatchLaterFragmentV2.this.getChildFragmentManager(), null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onClickCardMore$0$tv-danmaku-bili-ui-main2-WatchLaterFragmentV2$3  reason: not valid java name */
        public /* synthetic */ void m1959lambda$onClickCardMore$0$tvdanmakubiliuimain2WatchLaterFragmentV2$3(CommonMenuBottomSheet bottomSheet, WatchLaterItem item, MenuItemBean menuItem) {
            bottomSheet.dismiss();
            WatchLaterFragmentV2.this.onItemDeleted(item);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.adapter = new WatchLaterAdapter(this, this.watchLaterItems, new AnonymousClass3());
    }

    @Override // tv.danmaku.bili.ui.main.MainPagerRefreshRecyclerFragment
    public void onViewCreated(RecyclerView recyclerView, Bundle savedInstanceState) {
        View view;
        super.onViewCreated(recyclerView, savedInstanceState);
        hideLoading();
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setSmoothScrollbarEnabled(true);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(this.adapter);
        if (!this.mIsLoading) {
            showLoading();
            loadFirstPager();
        }
        if (!activityDie() && (view = getView()) != null) {
            this.mBottomBar = view.findViewById(tv.danmaku.bili.R.id.bottom_delete_layout);
            if (this.mBottomBar != null) {
                this.checkBox = this.mBottomBar.findViewById(tv.danmaku.bili.R.id.checkbox);
                this.checkBox.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main2.WatchLaterFragmentV2$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        WatchLaterFragmentV2.this.m1957lambda$onViewCreated$0$tvdanmakubiliuimain2WatchLaterFragmentV2(view2);
                    }
                });
                this.tvSelectAll = (TextView) this.mBottomBar.findViewById(tv.danmaku.bili.R.id.tv_select_all);
                this.tvSelectAll.setOnClickListener(this.mSelectClick);
                this.tvDelete = (TextView) this.mBottomBar.findViewById(tv.danmaku.bili.R.id.tv_delete);
                this.tvDelete.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main2.WatchLaterFragmentV2$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        WatchLaterFragmentV2.this.m1958lambda$onViewCreated$1$tvdanmakubiliuimain2WatchLaterFragmentV2(view2);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onViewCreated$0$tv-danmaku-bili-ui-main2-WatchLaterFragmentV2  reason: not valid java name */
    public /* synthetic */ void m1957lambda$onViewCreated$0$tvdanmakubiliuimain2WatchLaterFragmentV2(View v) {
        this.tvSelectAll.performClick();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onViewCreated$1$tv-danmaku-bili-ui-main2-WatchLaterFragmentV2  reason: not valid java name */
    public /* synthetic */ void m1958lambda$onViewCreated$1$tvdanmakubiliuimain2WatchLaterFragmentV2(View v) {
        WatchLaterReporter.reportWatchLaterDeleteEvent(this.adapter == null ? 0 : this.adapter.mSelectedAvId.size());
        if (this.adapter != null && this.adapter.mSelectedAvId.size() > 0) {
            deleteItems(this.adapter.mSelectedAvId);
            removeItemsFromAdapter(this.adapter);
            onDataSetChanged();
            switchEditMode(false);
        }
    }

    @Override // tv.danmaku.bili.ui.main.MainPagerFragment
    public void onActivityCreated(Bundle savedInstanceState) {
        Drawable drawable;
        super.onActivityCreated(savedInstanceState);
        Bundle b = getArguments();
        if (getActivity() instanceof MainActivityV2) {
            StatusBarCompat.setHeightAndPadding(getActivity(), getBar());
        }
        if (b != null && BundleUtil.getBoolean(b, "activity_base_toolbar", new boolean[]{false}) && (getActivity() instanceof WatchLaterActivity) && (drawable = getActivity().getBackDrawable()) != null) {
            getBar().setNavigationIcon(drawable.mutate());
        }
        Garb garb = GarbManager.getCurGarb();
        if (!garb.isPure()) {
            changeToolBarColor(garb.getSecondaryPageColor(), garb.getFontColor(), garb.getFontColor());
        }
    }

    public void onFragmentShow(Flag lastFlag) {
        super.onFragmentShow(lastFlag);
        PageViewTracker.getInstance().setFragmentVisibility(this, true);
    }

    public void onFragmentHide(Flag lastFlag) {
        super.onFragmentHide(lastFlag);
        PageViewTracker.getInstance().setFragmentVisibility(this, false);
    }

    @Override // tv.danmaku.bili.ui.main.MainPagerFragment
    public void onCreateMenu(Menu menu, MenuInflater inflater) {
        isEditMode = false;
        inflater.inflate(tv.danmaku.bili.R.menu.watch_later_top_menu, menu);
        MenuItem menuFinish = menu.findItem(tv.danmaku.bili.R.id.edit_finish);
        setMenuDisplay(menuFinish, false);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Garb garb = GarbManager.getCurGarb();
            MultipleThemeUtils.refreshMenuIconTint(activity, getBar(), garb.getFontColor());
            MultipleThemeUtils.refreshMenuTitleTint(activity, getBar(), menuFinish, (garb.isWhite() || garb.isNight()) ? getResources().getColor(com.bilibili.lib.theme.R.color.Pi5) : garb.getFontColor());
        }
    }

    private void onClickClearMenu() {
        final FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        new AlertDialog.Builder(activity).setMessage(bili.resource.others.R.string.others_global_string_211).setPositiveButton(bili.resource.common.R.string.common_global_string_113, new DialogInterface.OnClickListener() { // from class: tv.danmaku.bili.ui.main2.WatchLaterFragmentV2$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                WatchLaterFragmentV2.this.m1955lambda$onClickClearMenu$2$tvdanmakubiliuimain2WatchLaterFragmentV2(activity, dialogInterface, i);
            }
        }).setNegativeButton(bili.resource.common.R.string.common_global_string_238, (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onClickClearMenu$2$tv-danmaku-bili-ui-main2-WatchLaterFragmentV2  reason: not valid java name */
    public /* synthetic */ void m1955lambda$onClickClearMenu$2$tvdanmakubiliuimain2WatchLaterFragmentV2(Activity activity, DialogInterface dialog, int which) {
        if (sCount == 0) {
            ToastHelper.showToast(getApplicationContext(), activity.getString(bili.resource.favorites.R.string.favorites_global_string_243), 0);
        } else {
            clearWatchedItems();
        }
    }

    @Override // tv.danmaku.bili.ui.main.MainPagerFragment
    public boolean onMenuItemClick(MenuItem item) {
        int i = item.getItemId();
        if (i == tv.danmaku.bili.R.id.menu_icon) {
            WatchLaterReporter.reportWatchLaterMenuClickEvent();
            final CommonMenuBottomSheet bottomSheet = new CommonMenuBottomSheet();
            ArrayList<MenuItemBean> beans = new ArrayList<>(2);
            beans.add(new MenuItemBean(0, com.bilibili.playset.R.drawable.playset_ic_manage_songlist, getResources().getString(bili.resource.favorites.R.string.favorites_global_string_245)));
            beans.add(new MenuItemBean(1, com.bilibili.playset.R.drawable.playset_ic_clear, getResources().getString(bili.resource.favorites.R.string.favorites_global_string_244)));
            Bundle arguments = new Bundle();
            arguments.putParcelableArrayList(CommonMenuBottomSheetKt.KEY_ITEMS, beans);
            bottomSheet.setArguments(arguments);
            bottomSheet.setOnMenuClickListener(new OnMenuClickListener() { // from class: tv.danmaku.bili.ui.main2.WatchLaterFragmentV2$$ExternalSyntheticLambda0
                @Override // tv.danmaku.bili.ui.main2.OnMenuClickListener
                public final void onMenuClick(MenuItemBean menuItemBean) {
                    WatchLaterFragmentV2.this.m1956lambda$onMenuItemClick$3$tvdanmakubiliuimain2WatchLaterFragmentV2(bottomSheet, menuItemBean);
                }
            });
            bottomSheet.show(getChildFragmentManager(), null);
            return true;
        } else if (i == tv.danmaku.bili.R.id.edit_finish) {
            switchEditMode(false);
            return true;
        } else {
            return super.onMenuItemClick(item);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onMenuItemClick$3$tv-danmaku-bili-ui-main2-WatchLaterFragmentV2  reason: not valid java name */
    public /* synthetic */ void m1956lambda$onMenuItemClick$3$tvdanmakubiliuimain2WatchLaterFragmentV2(CommonMenuBottomSheet bottomSheet, MenuItemBean menuItemBean) {
        bottomSheet.dismiss();
        if (menuItemBean.getId() == 0) {
            WatchLaterReporter.reportWatchLaterManageEvent();
            switchEditMode(true);
        } else if (menuItemBean.getId() == 1) {
            WatchLaterReporter.reportWatchLaterClearEvent();
            onClickClearMenu();
        }
    }

    @Override // tv.danmaku.bili.ui.main.MainPagerRefreshRecyclerFragment
    public void onRefresh() {
        super.onRefresh();
        loadFirstPager();
    }

    public boolean onBackPress() {
        if (isInEditMode()) {
            switchEditMode(false);
            return true;
        }
        return false;
    }

    @Override // tv.danmaku.bili.ui.main.MainPagerFragment
    protected int getTitleId() {
        return bili.resource.playerbaseres.R.string.playerbaseres_global_string_163;
    }

    private void setMenuDisplay(MenuItem menu, boolean display) {
        if (menu != null) {
            menu.setVisible(display);
            menu.setEnabled(display);
        }
    }

    private void setTitle(int num) {
        if (getActivity() != null && this.adapter != null && getBar() != null) {
            String title = getActivity().getString(bili.resource.playerbaseres.R.string.playerbaseres_global_string_163) + " (" + num + ")";
            getBar().setTitle(title);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadFirstPager() {
        if (this.mIsLoading) {
            return;
        }
        loadPage();
    }

    private void onDataSetChanged() {
        setTitle(sCount);
        if (this.adapter != null) {
            showEmptyPage(this.adapter.watchList);
        }
    }

    private static void removeItemsFromAdapter(WatchLaterAdapter adapter) {
        Iterator<WatchLaterItem> itemIterator = adapter.watchList.iterator();
        while (itemIterator.hasNext()) {
            WatchLaterItem item = itemIterator.next();
            if (adapter.mSelectedAvId.contains(Long.valueOf(item.avid))) {
                itemIterator.remove();
            }
        }
        sCount -= adapter.mSelectedAvId.size();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class WatchLaterHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        int ICON_TYPE_VT;
        int ICON_TYPE_VV;
        TintTextView author;
        TintCheckBox checkVideo;
        TintTextView commentCount;
        BiliImageView cover;
        TintRelativeLayout invalidView;
        private WatchLaterItem mWatchLaterItem;
        ItemOperationCallBack operationCallBack;
        TextView pageNum;
        VectorTextView playCount;
        ProgressBar progressBar;
        TextView time;
        TintTextView title;

        void setWatchLaterItem(WatchLaterItem item) {
            this.mWatchLaterItem = item;
        }

        WatchLaterHolder(View itemView, final ItemOperationCallBack operationCallBack) {
            super(itemView);
            this.ICON_TYPE_VT = 33;
            this.ICON_TYPE_VV = 1;
            this.operationCallBack = operationCallBack;
            this.title = itemView.findViewById(tv.danmaku.bili.R.id.title);
            this.author = itemView.findViewById(tv.danmaku.bili.R.id.author);
            this.time = (TextView) itemView.findViewById(tv.danmaku.bili.R.id.time);
            this.playCount = itemView.findViewById(tv.danmaku.bili.R.id.tv_play_counts);
            this.commentCount = itemView.findViewById(tv.danmaku.bili.R.id.tv_comment_counts);
            this.cover = itemView.findViewById(tv.danmaku.bili.R.id.cover);
            this.checkVideo = itemView.findViewById(tv.danmaku.bili.R.id.check_video);
            this.progressBar = (ProgressBar) itemView.findViewById(tv.danmaku.bili.R.id.progress);
            this.invalidView = itemView.findViewById(tv.danmaku.bili.R.id.rl_invalid);
            this.pageNum = (TextView) itemView.findViewById(tv.danmaku.bili.R.id.page_num);
            itemView.findViewById(tv.danmaku.bili.R.id.more).setOnClickListener(this);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: tv.danmaku.bili.ui.main2.WatchLaterFragmentV2$WatchLaterHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return WatchLaterFragmentV2.WatchLaterHolder.this.m1962lambda$new$0$tvdanmakubiliuimain2WatchLaterFragmentV2$WatchLaterHolder(operationCallBack, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$new$0$tv-danmaku-bili-ui-main2-WatchLaterFragmentV2$WatchLaterHolder  reason: not valid java name */
        public /* synthetic */ boolean m1962lambda$new$0$tvdanmakubiliuimain2WatchLaterFragmentV2$WatchLaterHolder(ItemOperationCallBack operationCallBack, View v) {
            WatchLaterReporter.reportWatchLaterCardLongPressEvent(this.mWatchLaterItem.avid);
            operationCallBack.onItemLongClick(this.mWatchLaterItem);
            return true;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (WatchLaterFragmentV2.isEditMode) {
                this.checkVideo.setChecked(!this.checkVideo.isChecked());
            } else if (this.mWatchLaterItem == null) {
            } else {
                if (v.getId() == tv.danmaku.bili.R.id.more) {
                    this.operationCallBack.onClickCardMore(this.mWatchLaterItem);
                } else if (!this.mWatchLaterItem.isInvalidVideo()) {
                    WatchLaterReporter.reportWatchLaterCardClickEvent(this.mWatchLaterItem.avid);
                    ListCommonReport.reportMythWatchLaterVideoClick(String.valueOf(this.mWatchLaterItem.avid));
                    if (BiliAccountInfo.get().getAccountInfoFromCache() != null && this.mWatchLaterItem.uri != null) {
                        Uri.Builder builder = Uri.parse(this.mWatchLaterItem.uri).buildUpon();
                        int progress = this.mWatchLaterItem.progress;
                        if (progress != -1) {
                            progress *= 1000;
                        }
                        builder.appendQueryParameter("from_spmid", WatchLaterFragmentV2.WATCH_LATER_SPMID).appendQueryParameter("watch_later_progress", String.valueOf(progress)).appendQueryParameter("cid", String.valueOf(this.mWatchLaterItem.cid)).appendQueryParameter("avid", String.valueOf(this.mWatchLaterItem.avid));
                        VideoRouter.goToUri(v.getContext(), builder.build());
                    }
                } else if (this.mWatchLaterItem.owner != null && this.mWatchLaterItem.owner.mid > 0) {
                    Uri.Builder builder2 = Uri.parse("bilibili://space/" + this.mWatchLaterItem.owner.mid).buildUpon();
                    builder2.appendQueryParameter("from_spmid", WatchLaterFragmentV2.WATCH_LATER_SPMID);
                    VideoRouter.goToUri(v.getContext(), builder2.build());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class WatchLaterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private List<Long> mSelectedAvId = new ArrayList();
        private ItemOperationCallBack operationCallBack;
        List<WatchLaterItem> watchList;

        WatchLaterAdapter(WatchLaterFragmentV2 context, List<WatchLaterItem> watchLaterItems, ItemOperationCallBack operationCallBack) {
            this.watchList = new ArrayList();
            this.watchList = watchLaterItems;
            this.operationCallBack = operationCallBack;
        }

        void deleteItem(WatchLaterItem item) {
            int index;
            if (item != null && (index = this.watchList.indexOf(item)) >= 0) {
                this.watchList.remove(index);
                notifyItemRemoved(index);
            }
        }

        boolean isListEmpty() {
            return this.watchList.isEmpty();
        }

        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(tv.danmaku.bili.R.layout.bili_app_list_item_watch_later, parent, false);
            final WatchLaterHolder holder = new WatchLaterHolder(view, this.operationCallBack);
            holder.checkVideo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: tv.danmaku.bili.ui.main2.WatchLaterFragmentV2.WatchLaterAdapter.1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (WatchLaterAdapter.this.mSelectedAvId != null) {
                        Object tag = buttonView.getTag();
                        if (tag instanceof WatchLaterItem) {
                            if (WatchLaterAdapter.this.mSelectedAvId.contains(Long.valueOf(((WatchLaterItem) tag).avid)) && !isChecked) {
                                WatchLaterAdapter.this.mSelectedAvId.remove(Long.valueOf(((WatchLaterItem) tag).avid));
                            } else if (!WatchLaterAdapter.this.mSelectedAvId.contains(Long.valueOf(((WatchLaterItem) tag).avid)) && isChecked) {
                                WatchLaterAdapter.this.mSelectedAvId.add(Long.valueOf(((WatchLaterItem) tag).avid));
                            }
                        }
                        Context context = holder.itemView.getContext();
                        if (ContextUtilKt.findFragmentActivityOrNull(context) instanceof BaseAppCompatActivity) {
                            int selectedSize = WatchLaterAdapter.this.mSelectedAvId.size();
                            if (WatchLaterAdapter.this.operationCallBack != null) {
                                WatchLaterAdapter.this.operationCallBack.hasSelected(selectedSize > 0);
                            }
                            if (selectedSize == WatchLaterAdapter.this.watchList.size()) {
                                if (WatchLaterAdapter.this.operationCallBack != null) {
                                    WatchLaterAdapter.this.operationCallBack.onItemSelected(false);
                                }
                            } else if (!isChecked) {
                                if ((selectedSize == 0 || selectedSize == WatchLaterAdapter.this.watchList.size() - 1) && WatchLaterAdapter.this.operationCallBack != null) {
                                    WatchLaterAdapter.this.operationCallBack.onItemSelected(true);
                                }
                            }
                        }
                    }
                }
            });
            return holder;
        }

        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            setupItem((WatchLaterHolder) holder, position);
        }

        private void setupItem(WatchLaterHolder holder, int position) {
            WatchLaterItem item = this.watchList.get(position);
            Context context = holder.itemView.getContext();
            holder.itemView.setTag(item);
            holder.setWatchLaterItem(item);
            if (item != null) {
                setVideoInfo(holder, item, context);
                TintCheckBox tintCheckBox = holder.checkVideo;
                if (tintCheckBox != null) {
                    if (WatchLaterFragmentV2.isEditMode && tintCheckBox.isEnabled()) {
                        tintCheckBox.setVisibility(0);
                        tintCheckBox.setTag(item);
                        tintCheckBox.setChecked(this.mSelectedAvId.contains(Long.valueOf(item.avid)));
                        return;
                    }
                    tintCheckBox.setVisibility(8);
                }
            }
        }

        private void setProgressBar(WatchLaterItem item, WatchLaterHolder holder) {
            if (item.progress == 0 || item.isWatchFinished() || item.count > 1) {
                holder.progressBar.setVisibility(8);
                return;
            }
            holder.progressBar.setVisibility(0);
            int p = 0;
            if (item.page != null && item.page.duration != 0) {
                p = (item.progress * 100) / item.page.duration;
            }
            holder.progressBar.setProgress(p);
        }

        private void setPlayTime(WatchLaterItem item, WatchLaterHolder holder) {
            holder.time.setText(getPlayTime(item));
        }

        private String getPlayTime(WatchLaterItem item) {
            String ps;
            String ds = TimeUtils.formatTimeWithHour(item.duration * 1000);
            long progress = item.progress * 1000;
            if (progress == 0) {
                return ds;
            }
            if (progress < 0) {
                ps = ds;
            } else {
                ps = TimeUtils.formatTimeWithHour(progress);
            }
            return ps + " / " + ds;
        }

        private void setPlayCountAndBarrage(WatchLaterItem item, WatchLaterHolder holder) {
            if (item.stat != null) {
                holder.commentCount.setVisibility(0);
                holder.commentCount.setText(NumberFormat_androidKt.formatNumber(item.stat.danMaKu));
            } else {
                holder.commentCount.setVisibility(4);
            }
            ListExtentionsKt.setTextWithIcon(holder.playCount, item.viewText1, item.enableVt == 1 ? holder.ICON_TYPE_VT : holder.ICON_TYPE_VV);
        }

        private void setUpInfo(WatchLaterItem item, WatchLaterHolder holder) {
            if (item.owner != null && !TextUtils.isEmpty(item.owner.name)) {
                holder.author.setVisibility(0);
                holder.author.setText(item.owner.name);
                return;
            }
            holder.author.setVisibility(4);
        }

        private String getTitle(WatchLaterItem item, Context context) {
            if (item.isInvalidVideo()) {
                String title = item.state == -100 ? context.getString(bili.resource.common.R.string.common_global_string_339) : context.getString(bili.resource.common.R.string.common_global_string_340);
                return title;
            }
            String title2 = item.title == null ? "" : item.title;
            return title2;
        }

        private void setVideoInfo(WatchLaterHolder holder, WatchLaterItem item, Context context) {
            setUpInfo(item, holder);
            holder.title.setText(getTitle(item, context));
            if (item.isInvalidVideo()) {
                holder.time.setVisibility(8);
                holder.pageNum.setVisibility(0);
                holder.pageNum.setText(bili.resource.common.R.string.common_global_string_26);
                holder.pageNum.setCompoundDrawablesWithIntrinsicBounds(com.bilibili.app.comm.listwidget.R.drawable.playset_ic_media_invalid, 0, 0, 0);
                holder.pageNum.setBackgroundDrawable(ContextCompat.getDrawable(context, com.bilibili.app.comm.listwidget.R.drawable.shape_roundrect_black40));
                holder.title.setTextColorById(com.bilibili.lib.theme.R.color.Ga4);
                holder.progressBar.setVisibility(8);
                holder.playCount.setVisibility(8);
                holder.commentCount.setVisibility(8);
                holder.invalidView.setVisibility(0);
                ImageExtentionKt.builder(holder.cover, (String) null).into(holder.cover);
                return;
            }
            holder.invalidView.setVisibility(8);
            holder.pageNum.setCompoundDrawablesWithIntrinsicBounds(com.bilibili.playset.R.drawable.drawable_watch_later_p, 0, 0, 0);
            holder.pageNum.setBackgroundDrawable(ContextCompat.getDrawable(context, com.bilibili.app.comm.listwidget.R.drawable.shape_roundrect_black60));
            holder.title.setTextColorById(com.bilibili.lib.theme.R.color.Ga10);
            if (!TextUtils.isEmpty(item.cover)) {
                ImageExtentionKt.builder(holder.cover, item.cover).actualImageScaleType(ScaleType.CENTER_CROP).actualImageColorFilter(ResourcesCompat.getColor(holder.itemView.getResources(), 17170445, (Resources.Theme) null)).into(holder.cover);
            } else {
                ImageExtentionKt.builder(holder.cover, (String) null).into(holder.cover);
            }
            setProgressBar(item, holder);
            setPlayTime(item, holder);
            setPlayCountAndBarrage(item, holder);
            setPageMask(holder, item, context);
        }

        private void setPageMask(WatchLaterHolder holder, WatchLaterItem item, Context context) {
            if (item.count > 1) {
                holder.pageNum.setCompoundDrawablesWithIntrinsicBounds(com.bilibili.playset.R.drawable.drawable_watch_later_p, 0, 0, 0);
                holder.time.setVisibility(8);
                holder.pageNum.setVisibility(0);
                String page = item.count > 999 ? "999+" : Integer.toString(item.count);
                if (item.isWatchFinished()) {
                    String watchFinished = "%s·" + context.getResources().getString(bili.resource.playerbaseres.R.string.playerbaseres_global_string_626);
                    holder.pageNum.setText(String.format(watchFinished, page));
                    return;
                }
                holder.pageNum.setText(page);
                return;
            }
            holder.pageNum.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            if (item.isWatchFinished()) {
                holder.time.setVisibility(8);
                holder.pageNum.setVisibility(0);
                holder.pageNum.setText(context.getResources().getString(bili.resource.playerbaseres.R.string.playerbaseres_global_string_626));
                return;
            }
            holder.time.setVisibility(0);
            holder.pageNum.setVisibility(8);
        }

        public int getItemCount() {
            if (this.watchList == null) {
                return 0;
            }
            return this.watchList.size();
        }

        void onSetEditMode(boolean editMode) {
            if (!editMode) {
                this.mSelectedAvId.clear();
            }
            notifyDataSetChanged();
        }

        void selectAll() {
            this.mSelectedAvId.clear();
            for (WatchLaterItem item : this.watchList) {
                this.mSelectedAvId.add(Long.valueOf(item.avid));
            }
            notifyDataSetChanged();
        }

        void deselectAll() {
            this.mSelectedAvId.clear();
            notifyDataSetChanged();
        }
    }

    void loadPage() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        this.mIsLoading = true;
        WatchLaterApiManager.getWatchLaterList(activity, BiliAccounts.get(getContext()).getAccessKey(), new BiliApiDataCallback<WatchLaterList>() { // from class: tv.danmaku.bili.ui.main2.WatchLaterFragmentV2.4
            public boolean isCancel() {
                return WatchLaterFragmentV2.this.getActivity() == null || WatchLaterFragmentV2.this.adapter == null;
            }

            public void onDataSuccess(WatchLaterList result) {
                WatchLaterFragmentV2.this.onDataResponse(result);
            }

            public void onError(Throwable t) {
                WatchLaterFragmentV2.this.onErrorResponse();
            }
        });
    }

    private void deleteItems(List<Long> avidList) {
        ListCommonReport.reportMythWatchLaterDeleteVideoClick();
        String accessKey = BiliAccounts.get(getContext()).getAccessKey();
        WatchLaterApiManager.deleteItem(accessKey, avidList);
    }

    private void clearWatchedItems() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        ListCommonReport.reportMythWatchLaterClearVideoClick();
        this.mIsLoading = true;
        showLoading();
        String accessKey = BiliAccounts.get(getContext()).getAccessKey();
        WatchLaterApiManager.clearWatchedItems(activity, accessKey, new BiliApiDataCallback<Void>() { // from class: tv.danmaku.bili.ui.main2.WatchLaterFragmentV2.5
            public void onDataSuccess(Void result) {
                if (WatchLaterFragmentV2.this.getActivity() == null) {
                    return;
                }
                WatchLaterFragmentV2.this.mIsLoading = false;
                WatchLaterFragmentV2.this.loadFirstPager();
            }

            public void onError(Throwable t) {
                WatchLaterFragmentV2.this.hideLoading();
                if (WatchLaterFragmentV2.this.getActivity() == null) {
                    return;
                }
                WatchLaterFragmentV2.this.mIsLoading = false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onErrorResponse() {
        hideLoading();
        setRefreshCompleted();
        this.mIsLoading = false;
        if (this.watchLaterItems.isEmpty()) {
            showErrorTips();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDataResponse(WatchLaterList response) {
        hideLoading();
        setRefreshCompleted();
        this.mIsLoading = false;
        if (response != null) {
            sCount = response.count;
            setTitle(sCount);
        }
        this.watchLaterItems.clear();
        if (response != null && response.watchLaterItems != null) {
            this.watchLaterItems.addAll(response.watchLaterItems);
        }
        this.adapter.notifyDataSetChanged();
        showEmptyPage(this.watchLaterItems);
    }

    private boolean showEmptyPage(List<WatchLaterItem> list) {
        if (list.isEmpty() && sCount == 0) {
            showEmptyPage();
            return true;
        }
        return false;
    }

    private void showEmptyPage() {
        this.mLoadingView.setVisibility(0);
        this.mLoadingView.setRefreshComplete();
        this.mLoadingView.showEmptyTips(bili.resource.following.R.string.following_global_string_314);
        this.mLoadingView.setImageResource(R.drawable.img_holder_empty_style2);
    }

    public void onItemDeleted(WatchLaterItem item) {
        if (item != null) {
            this.adapter.deleteItem(item);
            ArrayList<Long> list = new ArrayList<>();
            list.add(Long.valueOf(item.avid));
            deleteItems(list);
            sCount--;
            setTitle(sCount);
            switchEditMode(false);
            if (this.adapter.isListEmpty()) {
                showEmptyPage();
            }
        }
    }

    public static boolean isInEditMode() {
        return isEditMode;
    }

    @Subscribe
    public void onBackPressed(OnBackPressedEvent event) {
        if ("wl_edit_mode_back_pressed".equals(event.tag)) {
            switchEditMode(false);
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class OnBackPressedEvent {
        String tag;

        public OnBackPressedEvent(String tag) {
            this.tag = tag;
        }
    }

    public void onItemSelected(boolean selectAll) {
        if (getActivity() == null || this.tvSelectAll == null) {
            return;
        }
        if (selectAll) {
            this.checkBox.setChecked(false);
            this.tvSelectAll.setOnClickListener(this.mSelectClick);
            return;
        }
        this.checkBox.setChecked(true);
        this.tvSelectAll.setOnClickListener(this.mDeselectClick);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchEditMode(boolean inEditMode) {
        if (getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        isEditMode = inEditMode;
        if (this.adapter != null) {
            this.adapter.onSetEditMode(isEditMode);
        }
        if (this.mBottomBar != null && getRecyclerView() != null) {
            this.mBottomBar.setVisibility(inEditMode ? 0 : 8);
        }
        if (getBar() != null && getBar().getMenu() != null) {
            MenuItem menuIcon = getBar().getMenu().findItem(tv.danmaku.bili.R.id.menu_icon);
            MenuItem editFinish = getBar().getMenu().findItem(tv.danmaku.bili.R.id.edit_finish);
            if (isEditMode) {
                setMenuDisplay(editFinish, true);
                setMenuDisplay(menuIcon, false);
                return;
            }
            setMenuDisplay(editFinish, false);
            setMenuDisplay(menuIcon, true);
            if (this.adapter != null && this.adapter.watchList.isEmpty() && sCount > 0) {
                this.mHandler.postDelayed(new Runnable() { // from class: tv.danmaku.bili.ui.main2.WatchLaterFragmentV2.6
                    @Override // java.lang.Runnable
                    public void run() {
                        WatchLaterFragmentV2.this.loadFirstPager();
                    }
                }, 500L);
            }
        }
    }

    public String getPvEventId() {
        return WATCH_LATER_EVENT_ID;
    }

    public Bundle getPvExtra() {
        return null;
    }

    private void changeToolBarColor(int backgroundColor, int titleColor, int iconColor) {
        if (getActivity() != null && (getBar() instanceof GarbTintToolBar)) {
            getBar().setBackgroundColorWithGarb(backgroundColor);
            getBar().setTitleColorWithGarb(titleColor);
            getBar().setIconTintColorWithGarb(iconColor);
        }
    }
}