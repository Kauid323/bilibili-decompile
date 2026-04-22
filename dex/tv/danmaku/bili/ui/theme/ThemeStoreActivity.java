package tv.danmaku.bili.ui.theme;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.api.BiliApiException;
import com.bilibili.app.comm.list.common.feed.PegasusStyle;
import com.bilibili.app.comm.list.common.feed.PegasusStyleEnum;
import com.bilibili.app.theme.R;
import com.bilibili.base.Applications;
import com.bilibili.commons.time.FastDateFormat;
import com.bilibili.droid.ActivityUtils;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accountinfo.BiliAccountInfo;
import com.bilibili.lib.accountinfo.model.AccountInfo;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.router.Router;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseAppCompatActivity;
import com.bilibili.lib.ui.garb.Garb;
import com.bilibili.lib.ui.garb.GarbManager;
import com.bilibili.lib.ui.theme.ThemeWatcher;
import com.bilibili.lib.ui.util.MultipleThemeUtils;
import com.bilibili.lib.ui.util.StatusBarCompat;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.magicasakura.widgets.TintButton;
import com.bilibili.magicasakura.widgets.TintImageView;
import com.bilibili.magicasakura.widgets.TintProgressDialog;
import com.bilibili.magicasakura.widgets.TintTextView;
import com.bilibili.magicasakura.widgets.TintToolbar;
import com.bilibili.okretro.BiliApiCallback;
import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.pvtracker.IPvTracker;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import tv.danmaku.bili.ui.garb.GarbManagerDelegate;
import tv.danmaku.bili.ui.garb.core.GarbStorageHelper;
import tv.danmaku.bili.ui.garb.model.GarbApiHelper;
import tv.danmaku.bili.ui.theme.ThemeStoreActivity;
import tv.danmaku.bili.ui.theme.api.BiliSkin;
import tv.danmaku.bili.ui.theme.api.BiliSkinList;
import tv.danmaku.bili.ui.theme.api.OrderResult;
import tv.danmaku.bili.ui.theme.api.ThemeApiLoader;
import tv.danmaku.bili.widget.LoadingImageView;
import tv.danmaku.bili.widget.dialog.BiliCommonDialog;
import tv.danmaku.bili.widget.recycler.section.BaseSection;
import tv.danmaku.bili.widget.recycler.section.BaseSectionAdapter;

public class ThemeStoreActivity extends BaseAppCompatActivity implements IPvTracker, ThemeWatcher.Observer {
    private static final int DEFAULT_THEME = 2;
    private static final String PV_EVENT_ID = "main.theme.0.0.pv";
    private ThemeAdapter mAdapter;
    private List<BiliSkin> mBiliSkins = new ArrayList();
    private TintTextView mDarkMode;
    private Helper mHelper;
    private LoadingImageView mLoadingView;
    private RecyclerView mRecycleView;
    private TintToolbar mToolbar;
    private TintProgressDialog progressDialog;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public /* synthetic */ boolean appendEndExtra() {
        return IPvTracker.-CC.$default$appendEndExtra(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    public /* synthetic */ String getUniqueKey() {
        return IPvTracker.-CC.$default$getUniqueKey(this);
    }

    public /* synthetic */ boolean shouldReport() {
        return IPvTracker.-CC.$default$shouldReport(this);
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, ThemeStoreActivity.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThemeWatcher.getInstance().subscribe(this);
        setContentView(R.layout.bili_app_activity_theme_store);
        this.mToolbar = findViewById(R.id.nav_top_bar);
        this.mToolbar.setContentInsetsAbsolute(0, 0);
        setSupportActionBar(this.mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            this.mToolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.theme.ThemeStoreActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    ThemeStoreActivity.this.onBackPressed();
                }
            });
            getSupportActionBar().setTitle(bili.resource.homepage.R.string.homepage_global_string_286);
        }
        this.mHelper = new Helper(this);
        this.mRecycleView = findViewById(R.id.recycler);
        this.mLoadingView = (LoadingImageView) findViewById(R.id.loading);
        this.progressDialog = new TintProgressDialog(this);
        this.progressDialog.setIndeterminate(true);
        this.progressDialog.setMessage(getString(bili.resource.common.R.string.common_global_string_29));
        this.progressDialog.setCanceledOnTouchOutside(false);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setSmoothScrollbarEnabled(true);
        this.mAdapter = new ThemeAdapter(this.mHelper);
        this.mRecycleView.setLayoutManager(manager);
        this.mRecycleView.setAdapter(this.mAdapter);
        int dividerColor = com.bilibili.lib.theme.R.color.Ga2;
        int dividerHeight = (int) TypedValue.applyDimension(1, 0.5f, getResources().getDisplayMetrics());
        int dividerLeftSpace = (int) TypedValue.applyDimension(1, 12.0f, getResources().getDisplayMetrics());
        CustomDividerDecoration customDividerDecoration = new CustomDividerDecoration(dividerColor, dividerHeight, dividerLeftSpace);
        this.mRecycleView.addItemDecoration(customDividerDecoration);
        this.mDarkMode = findViewById(R.id.dark_mode);
        this.mDarkMode.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.theme.ThemeStoreActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                RouteRequest routeRequest = new RouteRequest.Builder("bilibili://preference/dark-mode").build();
                BLRouter.routeTo(routeRequest, ThemeStoreActivity.this);
            }
        });
        Garb garb = GarbManager.getCurGarb();
        if (!garb.isPure()) {
            tintToolbar(garb);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void tintToolbar(Garb garb) {
        this.mToolbar.setIconTintColorWithGarb(garb.getFontColor());
        if (garb.isPrimaryOnly()) {
            this.mToolbar.setTitleColorWithGarb(ThemeUtils.getColorById(this, com.bilibili.app.comm.baseres.R.color.theme_color_primary_tr_title));
        } else {
            this.mToolbar.setTitleColorWithGarb(garb.getFontColor());
        }
        this.mToolbar.setBackgroundColorWithGarb(garb.getSecondaryPageColor());
        this.mDarkMode.setTextColor(garb.getFontColor());
    }

    private void resetToolbarColor() {
        this.mToolbar.setIconTintColorResource(com.bilibili.app.comm.baseres.R.color.theme_color_primary_tr_icon);
        this.mToolbar.setTitleTintColorResource(com.bilibili.app.comm.baseres.R.color.theme_color_primary_tr_title);
        this.mToolbar.setBackgroundResource(com.bilibili.app.comm.baseres.R.color.theme_color_primary_tr_background);
        this.mDarkMode.setTextColorById(com.bilibili.app.comm.baseres.R.color.theme_color_primary_tr_icon);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Garb garb = GarbManager.getCurGarb();
        if (garb.isPure() || garb.isPrimaryOnly()) {
            StatusBarCompat.tintStatusBar(this, ThemeUtils.getThemeAttrColor(this, androidx.appcompat.R.attr.colorPrimary));
        } else {
            StatusBarCompat.tintStatusBar(this, garb.getSecondaryPageColor(), garb.isDarkMode() ? 1 : 2);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        ThemeWatcher.getInstance().unSubscribe(this);
        this.mHelper.notifyThemeChange();
    }

    public ThemeAdapter getThemeAdapter() {
        return this.mAdapter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void loadTheme() {
        BiliSkinList biliSkinList = null;
        hideLoading();
        if (BiliAccounts.get(this).isLogin()) {
            biliSkinList = ThemeManager.getInstance(this).getAccountThemeList();
        }
        if (biliSkinList == null || biliSkinList.mList == null) {
            showLoading();
            ThemeApiLoader.getList(BiliAccounts.get(this).getAccessKey(), new BiliApiCallback<BiliSkinList>() { // from class: tv.danmaku.bili.ui.theme.ThemeStoreActivity.3
                public boolean isCancel() {
                    return ThemeStoreActivity.this.isFinishing() || ThemeStoreActivity.this.isDestroyCalled();
                }

                public void onError(Throwable error) {
                    ThemeStoreActivity.this.hideLoading();
                    ThemeStoreActivity.this.showErrorTips();
                    ThemeManager.getInstance(ThemeStoreActivity.this).update();
                    BiliSkinList biliSkinList2 = ThemeManager.getInstance(ThemeStoreActivity.this).getDefaultThemeList();
                    if (biliSkinList2 != null && biliSkinList2.mList != null) {
                        ThemeStoreActivity.this.onLoadThemeListSuccess(biliSkinList2, false);
                    } else {
                        ThemeStoreActivity.this.mAdapter.setData(0, 0L, null, false);
                    }
                }

                public void onSuccess(BiliSkinList response) {
                    ThemeStoreActivity.this.hideLoading();
                    if (response == null) {
                        onError(null);
                        return;
                    }
                    ThemeStoreActivity.this.onLoadThemeListSuccess(response, false);
                    ThemeManager themeManager = ThemeManager.getInstance(ThemeStoreActivity.this);
                    if (BiliAccounts.get(ThemeStoreActivity.this).isLogin()) {
                        themeManager.saveAccountThemeList(response);
                    } else {
                        themeManager.saveDefaultThemeList(response);
                    }
                }
            });
            return;
        }
        onLoadThemeListSuccess(biliSkinList, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void onLoadThemeListSuccess(BiliSkinList biliSkinList, boolean forceNotify) {
        int themeId = BiliTheme.readThemeId(this);
        if (!BiliAccounts.get(this).isLogin() && themeId != 2 && themeId != 1 && themeId != 8) {
            themeId = 2;
        }
        if (!GarbManager.getGarbWithNightMode(this).isPure()) {
            themeId = -1;
        }
        List<BiliSkin> list = biliSkinList.mList;
        if (list == null) {
            return;
        }
        this.mBiliSkins.clear();
        Iterator<BiliSkin> it = list.iterator();
        while (it.hasNext()) {
            BiliSkin skin = it.next();
            int skinId = skin == null ? -1 : skin.mId;
            if (BiliTheme.isAvailableThemeId(skinId)) {
                this.mBiliSkins.add(skin);
            }
        }
        this.mAdapter.setData(themeId, biliSkinList.mTs, this.mBiliSkins, forceNotify);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void showErrorTips() {
        ToastHelper.showToastLong(this, getString(bili.resource.homepage.R.string.homepage_global_string_271));
    }

    public void showLoading() {
        if (this.mLoadingView != null) {
            this.mLoadingView.setVisibility(0);
            this.mLoadingView.setRefreshing();
        }
    }

    public void hideLoading() {
        if (this.mLoadingView != null) {
            this.mLoadingView.setRefreshComplete();
            this.mLoadingView.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void unSubscribe(final BiliSkin skin) {
        if (skin == null) {
            return;
        }
        new BiliCommonDialog.Builder(this).setTitle(String.format(Locale.US, getString(bili.resource.homepage.R.string.homepage_global_string_339), skin.mName)).setContentText(getString(bili.resource.homepage.R.string.homepage_global_string_123)).setButtonStyle(1).setNegativeButton(getString(bili.resource.homepage.R.string.homepage_global_string_366), (BiliCommonDialog.OnDialogTextClickListener) null, true).setPositiveButton(getString(bili.resource.homepage.R.string.homepage_global_string_302), new BiliCommonDialog.OnDialogTextClickListener() { // from class: tv.danmaku.bili.ui.theme.ThemeStoreActivity$$ExternalSyntheticLambda0
            @Override // tv.danmaku.bili.widget.dialog.BiliCommonDialog.OnDialogTextClickListener
            public final void onDialogTextClicked(View view2, BiliCommonDialog biliCommonDialog) {
                ThemeStoreActivity.this.m1697lambda$unSubscribe$0$tvdanmakubiliuithemeThemeStoreActivity(skin, view2, biliCommonDialog);
            }
        }, true).build().show(getSupportFragmentManager(), "unsubscribe-confirm-dialog");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$unSubscribe$0$tv-danmaku-bili-ui-theme-ThemeStoreActivity  reason: not valid java name */
    public /* synthetic */ void m1697lambda$unSubscribe$0$tvdanmakubiliuithemeThemeStoreActivity(BiliSkin skin, View view2, BiliCommonDialog dialog) {
        processUnSubscribe(skin.mId);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void processUnSubscribe(final int skinId) {
        if (isFinishing() || isDestroyCalled()) {
            return;
        }
        this.progressDialog.show();
        ThemeApiLoader.cancelOrder(BiliAccounts.get(this).getAccessKey(), skinId, new BiliApiDataCallback<OrderResult>() { // from class: tv.danmaku.bili.ui.theme.ThemeStoreActivity.4
            public boolean isCancel() {
                return ThemeStoreActivity.this.isFinishing() || ThemeStoreActivity.this.isDestroyCalled();
            }

            public void onError(Throwable error) {
                ThemeStoreActivity.this.progressDialog.cancel();
                if (error instanceof BiliApiException) {
                    int code = ((BiliApiException) error).mCode;
                    ToastHelper.showToastShort(ThemeStoreActivity.this.getApplicationContext(), ThemeStoreActivity.this.getErrorMessage(code));
                    return;
                }
                ToastHelper.showToastShort(ThemeStoreActivity.this.getApplicationContext(), ThemeStoreActivity.this.getString(bili.resource.common.R.string.common_global_string_186));
            }

            public void onDataSuccess(OrderResult response) {
                ThemeStoreActivity.this.progressDialog.cancel();
                if (response.status != 1) {
                    ToastHelper.showToastShort(ThemeStoreActivity.this.getApplicationContext(), ThemeStoreActivity.this.getString(bili.resource.homepage.R.string.homepage_global_string_376));
                } else if (ThemeStoreActivity.this.mBiliSkins == null) {
                } else {
                    int i = 0;
                    while (true) {
                        if (i >= ThemeStoreActivity.this.mBiliSkins.size()) {
                            break;
                        }
                        BiliSkin skin = (BiliSkin) ThemeStoreActivity.this.mBiliSkins.get(i);
                        if (skin.mId != skinId) {
                            i++;
                        } else {
                            skin.mStatus = 4;
                            ThemeManager.getInstance(ThemeStoreActivity.this.getApplicationContext()).updateAccountThemeStatus(skin);
                            break;
                        }
                    }
                    if (ThemeStoreActivity.this.mAdapter == null) {
                        return;
                    }
                    ThemeStoreActivity.this.mAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void subscribe(final BiliSkin skin) {
        if (skin == null) {
            return;
        }
        new BiliCommonDialog.Builder(this).setTitle(String.format(Locale.US, getString(bili.resource.homepage.R.string.homepage_global_string_303), skin.mName)).setContentText(String.format(Locale.US, getString(bili.resource.homepage.R.string.homepage_global_string_256), Integer.valueOf(skin.mPrice))).setButtonStyle(1).setNegativeButton(getString(bili.resource.homepage.R.string.homepage_global_string_366), (BiliCommonDialog.OnDialogTextClickListener) null, true).setPositiveButton(getString(bili.resource.homepage.R.string.homepage_global_string_336), new BiliCommonDialog.OnDialogTextClickListener() { // from class: tv.danmaku.bili.ui.theme.ThemeStoreActivity.5
            @Override // tv.danmaku.bili.widget.dialog.BiliCommonDialog.OnDialogTextClickListener
            public void onDialogTextClicked(View view2, BiliCommonDialog dialog) {
                ThemeStoreActivity.this.processSubscribe(skin.mId);
            }
        }, true).build().show(getSupportFragmentManager(), "subscribe-theme-confirm-dialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void processSubscribe(final int skinId) {
        if (isFinishing() || isDestroyCalled()) {
            return;
        }
        this.progressDialog.show();
        ThemeApiLoader.addOrder(BiliAccounts.get(this).getAccessKey(), skinId, new BiliApiDataCallback<OrderResult>() { // from class: tv.danmaku.bili.ui.theme.ThemeStoreActivity.6
            public boolean isCancel() {
                return ThemeStoreActivity.this.isFinishing() || ThemeStoreActivity.this.isDestroyCalled();
            }

            public void onError(Throwable error) {
                ThemeStoreActivity.this.progressDialog.cancel();
                if (error instanceof BiliApiException) {
                    int code = ((BiliApiException) error).mCode;
                    ToastHelper.showToastShort(ThemeStoreActivity.this.getApplicationContext(), ThemeStoreActivity.this.getErrorMessage(code));
                    return;
                }
                ToastHelper.showToastShort(ThemeStoreActivity.this.getApplicationContext(), ThemeStoreActivity.this.getString(bili.resource.common.R.string.common_global_string_186));
            }

            public void onDataSuccess(OrderResult response) {
                ThemeStoreActivity.this.progressDialog.cancel();
                if (response.status != 1) {
                    ToastHelper.showToastShort(ThemeStoreActivity.this.getApplicationContext(), ThemeStoreActivity.this.getString(bili.resource.homepage.R.string.homepage_global_string_201));
                } else {
                    ThemeStoreActivity.this.updateCurrentSubscribe(skinId, response);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCurrentSubscribe(int subSkinId, OrderResult object) {
        AccountInfo info;
        if (this.mBiliSkins == null) {
            return;
        }
        int i = 0;
        while (true) {
            if (i >= this.mBiliSkins.size()) {
                break;
            }
            BiliSkin skin = this.mBiliSkins.get(i);
            if (subSkinId != skin.mId) {
                i++;
            } else {
                skin.mStatus = 1;
                skin.mBuyTime = object.buy_time;
                skin.mDueTime = object.due_time;
                skin.mIsBought = true;
                ThemeManager.getInstance(getApplicationContext()).updateAccountThemeStatus(skin);
                BiliAccountInfo client = BiliAccountInfo.get();
                if (client != null && (info = client.getAccountInfoFromCache()) != null) {
                    BigDecimal myCoins = new BigDecimal(String.valueOf(info.getCoins()));
                    if (myCoins.floatValue() >= skin.mPrice) {
                        BigDecimal result = myCoins.subtract(new BigDecimal(String.valueOf(skin.mPrice)));
                        info.setCoins(Float.valueOf(result.toPlainString()).floatValue());
                    }
                    client.saveAccountInfo(info);
                }
            }
        }
        if (this.mAdapter == null) {
            return;
        }
        this.mAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getErrorMessage(int code) {
        switch (code) {
            case -730:
                return getString(bili.resource.homepage.R.string.homepage_global_string_235);
            case -720:
                return getString(bili.resource.homepage.R.string.homepage_global_string_260);
            case -710:
                return getString(bili.resource.homepage.R.string.homepage_global_string_124);
            case -700:
                return getString(bili.resource.homepage.R.string.homepage_global_string_379);
            case -107:
                return getString(bili.resource.homepage.R.string.homepage_global_string_151);
            case -103:
                return getString(bili.resource.homepage.R.string.homepage_global_string_145);
            case -102:
                return getString(bili.resource.homepage.R.string.homepage_global_string_207);
            case -101:
                return getString(bili.resource.homepage.R.string.homepage_global_string_305);
            default:
                return getString(bili.resource.homepage.R.string.homepage_global_string_200) + code;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onThemeChanged() {
        getDelegate().setLocalNightMode(MultipleThemeUtils.getCurrentNightMode(this));
        int currentThemeId = BiliTheme.getCurrentTheme(this);
        ThemeAdapter themeAdapter = getThemeAdapter();
        if (themeAdapter != null) {
            themeAdapter.setCheckId(currentThemeId);
            themeAdapter.notifyDataSetChanged();
        }
        if (this.mHelper != null) {
            this.mHelper.setNewThemeId(currentThemeId);
        }
        changeUi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void changeUi() {
        resetToolbarColor();
        StatusBarCompat.tintStatusBar(this, ThemeUtils.getThemeAttrColor(this, androidx.appcompat.R.attr.colorPrimary));
        BiliTheme.tintTaskDescription(this);
        ThemeUtils.refreshUI(this);
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class ThemeAdapter extends BaseSectionAdapter<BaseSectionAdapter.ViewHolder> {
        public static final int VH_TYPE_APP_THEME = 3;
        public static final int VH_TYPE_HEADER = 1;
        public static final int VH_TYPE_TM_THEME = 2;
        private AppThemeSection mAppThemeSection;
        private int mCheckId = -1;
        private long mCurrentTs = System.currentTimeMillis();
        private Helper mHelper;
        private TmThemeSection mTmThemeSection;

        public ThemeAdapter(Helper helper) {
            this.mHelper = helper;
        }

        public BaseSectionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            switch (viewType) {
                case 1:
                    return HeaderViewHolder.create(parent);
                case 2:
                    return TmThemeViewHolder.create(parent, this.mHelper);
                case 3:
                    return AppThemeViewHolder.create(parent, new WeakReference(this), this.mHelper);
                default:
                    return null;
            }
        }

        public void setCheckId(int mCheckId) {
            this.mCheckId = mCheckId;
        }

        public void setData(int themeId, long ts, List<BiliSkin> list, boolean forceNotify) {
            this.mCheckId = themeId;
            this.mCurrentTs = ts;
            if (this.mTmThemeSection == null) {
                this.mTmThemeSection = new TmThemeSection(this.mHelper);
                addSectionInternal(this.mTmThemeSection);
            }
            if (this.mAppThemeSection == null && list != null && list.size() > 0) {
                this.mAppThemeSection = new AppThemeSection(list);
                addSectionInternal(this.mAppThemeSection);
            }
            if (forceNotify) {
                notifyDataSetChanged();
            } else {
                onSectionsChanged();
            }
        }

        public void clearData() {
            if (this.mTmThemeSection != null) {
                removeSectionInternal(this.mTmThemeSection);
                this.mTmThemeSection = null;
            }
            if (this.mAppThemeSection != null) {
                removeSectionInternal(this.mAppThemeSection);
                this.mAppThemeSection = null;
            }
            clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class TmThemeSection extends BaseHeaderSection<String, Object> {
        private Helper mHelper;

        public TmThemeSection(Helper mHelper) {
            super(Applications.getCurrent().getResources().getString(bili.resource.homepage.R.string.homepage_global_string_315), new ArrayList(1), 1, 2);
            this.mHelper = mHelper;
        }

        @Override // tv.danmaku.bili.widget.recycler.section.Section
        public Object data(int adapterPosition) {
            int offsetPosition = convertAdapterPosition(adapterPosition);
            if (offsetPosition < 1) {
                return this.mHeader;
            }
            return Boolean.valueOf(this.mHelper.isV1Style());
        }

        @Override // tv.danmaku.bili.widget.recycler.section.Section
        public int size() {
            return 2;
        }

        @Override // tv.danmaku.bili.widget.recycler.section.BaseSection, tv.danmaku.bili.widget.recycler.section.Section
        public long getItemId(int position) {
            return (getItemViewType(position) << 32) + position;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class AppThemeSection extends BaseHeaderSection<String, BiliSkin> {
        public AppThemeSection(List<BiliSkin> list) {
            super(Applications.getCurrent().getResources().getString(bili.resource.homepage.R.string.homepage_global_string_286), list, 1, 3);
        }

        @Override // tv.danmaku.bili.widget.recycler.section.Section
        public Object data(int position) {
            int offsetPosition = convertAdapterPosition(position);
            if (offsetPosition < 1) {
                return this.mHeader;
            }
            BiliSkin biliSkin = (BiliSkin) this.mContents.get(offsetPosition - 1);
            return biliSkin;
        }

        @Override // tv.danmaku.bili.widget.recycler.section.Section
        public int size() {
            int size = this.mContents == null ? 0 : this.mContents.size();
            return size + 1;
        }

        @Override // tv.danmaku.bili.widget.recycler.section.BaseSection, tv.danmaku.bili.widget.recycler.section.Section
        public long getItemId(int position) {
            return (getItemViewType(position) << 32) + position;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class HeaderViewHolder extends BaseSectionAdapter.ViewHolder {
        private TextView mHeaderText;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            this.mHeaderText = (TextView) itemView.findViewById(R.id.title);
        }

        @Override // tv.danmaku.bili.widget.recycler.section.BaseSectionAdapter.ViewHolder
        public void bind(Object data) {
            if (data instanceof String) {
                this.mHeaderText.setText((CharSequence) data);
            }
        }

        public static HeaderViewHolder create(ViewGroup parent) {
            return new HeaderViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_app_layout_list_item_theme_list_header, parent, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class TmThemeViewHolder extends BaseSectionAdapter.ViewHolder implements View.OnClickListener {
        private TintImageView ivPickDouble;
        private TintImageView ivPickSingle;
        private Helper mHelper;
        private RelativeLayout mViewContent1;
        private RelativeLayout mViewContent2;

        public TmThemeViewHolder(View itemView, Helper helper) {
            super(itemView);
            this.mViewContent1 = (RelativeLayout) itemView.findViewById(R.id.content1);
            this.mViewContent2 = (RelativeLayout) itemView.findViewById(R.id.content2);
            this.ivPickSingle = itemView.findViewById(R.id.iv_pink_tick_single);
            this.ivPickDouble = itemView.findViewById(R.id.iv_pink_tick_double);
            this.mViewContent1.setOnClickListener(this);
            this.mViewContent2.setOnClickListener(this);
            this.mHelper = helper;
        }

        @Override // tv.danmaku.bili.widget.recycler.section.BaseSectionAdapter.ViewHolder
        public void bind(Object data) {
            if (data instanceof Boolean) {
                if (((Boolean) data).booleanValue()) {
                    setTickStatus(true);
                } else {
                    setTickStatus(false);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (v == this.mViewContent1) {
                setTickStatus(true);
                this.mHelper.setNewCardStyle(PegasusStyleEnum.USER_SINGLE_COLUMN);
            } else if (v == this.mViewContent2) {
                setTickStatus(false);
                this.mHelper.setNewCardStyle(PegasusStyleEnum.USER_DOUBLE_COLUMN);
            }
        }

        private void setTickStatus(boolean b) {
            this.ivPickSingle.setVisibility(b ? 0 : 4);
            this.ivPickDouble.setVisibility(b ? 4 : 0);
        }

        public static TmThemeViewHolder create(ViewGroup parent, Helper helper) {
            return new TmThemeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_app_layout_list_item_theme_tm_choose, parent, false), helper);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class AppThemeViewHolder extends BaseSectionAdapter.ViewHolder implements View.OnClickListener {
        ImageView indicator;
        private Helper mHelper;
        private WeakReference<ThemeAdapter> mWeakReference;
        TintTextView nameView;
        TintButton orderButton;
        TintImageView tickView;
        TintTextView unsubscribeText;

        public AppThemeViewHolder(View itemView, WeakReference<ThemeAdapter> weakReference, Helper helper) {
            super(itemView);
            this.indicator = (ImageView) itemView.findViewById(R.id.indicator);
            this.tickView = itemView.findViewById(R.id.tick);
            this.nameView = itemView.findViewById(R.id.title);
            this.unsubscribeText = itemView.findViewById(R.id.unsubscribe_text);
            this.orderButton = itemView.findViewById(R.id.order_button);
            this.mWeakReference = weakReference;
            this.mHelper = helper;
        }

        @Override // tv.danmaku.bili.widget.recycler.section.BaseSectionAdapter.ViewHolder
        public void bind(Object data) {
            if (data instanceof BiliSkin) {
                Context context = this.itemView.getContext();
                ThemeAdapter adapter = this.mWeakReference.get();
                if (context == null || adapter == null) {
                    return;
                }
                boolean mIsLogin = BiliAccounts.get(context).isLogin();
                this.orderButton.setOnClickListener(this);
                this.itemView.setOnClickListener(this);
                BiliSkin skin = (BiliSkin) data;
                int themeId = skin.mId;
                int skinColor = BiliTheme.getThemePrimaryColorBySkinId(skin.mId);
                this.nameView.setText(skin.mName);
                if (themeId == 8) {
                    this.indicator.setImageDrawable(ThemeUtils.tintDrawable(this.indicator.getDrawable(), Color.parseColor("#f4f4f4")));
                } else {
                    this.indicator.setImageDrawable(ThemeUtils.tintDrawable(this.indicator.getDrawable(), skinColor));
                }
                setUseStatus(skin, adapter.mCheckId);
                this.orderButton.setBackgroundResource(R.drawable.selector_theme_order_stroke_pink_corner_4);
                this.orderButton.setTextColor(ThemeUtils.getColorById(context, com.bilibili.app.comm.baseres.R.color.theme_color_secondary));
                if (skin.mIsFree) {
                    this.unsubscribeText.setVisibility(8);
                    this.orderButton.setVisibility(8);
                } else if (mIsLogin && skin.mIsBought && (skin.mStatus == 1 || skin.mStatus == 2)) {
                    this.unsubscribeText.setVisibility(0);
                    this.unsubscribeText.setText(context.getString(bili.resource.homepage.R.string.homepage_global_string_232));
                    this.orderButton.setVisibility(0);
                    this.orderButton.setText(context.getString(bili.resource.homepage.R.string.homepage_global_string_302));
                    this.orderButton.setBackgroundResource(R.drawable.shape_roundrect_divider_line_for_white_cornor_4);
                    this.orderButton.setTextColorById(com.bilibili.lib.theme.R.color.Ga5);
                } else if ((mIsLogin && skin.mStatus == 4) || skin.mStatus == 3) {
                    if (!BiliTheme.isThemeExpired(adapter.mCurrentTs, skin.mDueTime)) {
                        this.unsubscribeText.setVisibility(0);
                        this.unsubscribeText.setText(context.getString(bili.resource.homepage.R.string.homepage_global_string_184, FastDateFormat.getInstance("yyyy-MM-dd").format(skin.mDueTime)));
                        this.orderButton.setVisibility(8);
                    } else {
                        this.unsubscribeText.setVisibility(0);
                        this.unsubscribeText.setText(context.getResources().getQuantityString(bili.resource.homepage.R.plurals.homepage_global_string_440, skin.mPrice, Integer.valueOf(skin.mPrice)));
                        this.orderButton.setVisibility(0);
                        this.orderButton.setText(context.getString(bili.resource.homepage.R.string.homepage_global_string_336));
                        this.itemView.setOnClickListener(null);
                    }
                } else {
                    this.unsubscribeText.setVisibility(0);
                    this.unsubscribeText.setText(context.getResources().getQuantityString(bili.resource.homepage.R.plurals.homepage_global_string_440, skin.mPrice, Integer.valueOf(skin.mPrice)));
                    this.orderButton.setVisibility(0);
                    this.orderButton.setText(context.getString(bili.resource.homepage.R.string.homepage_global_string_336));
                }
                this.orderButton.setTag(skin);
                this.itemView.setTag(skin);
            }
        }

        private void setUseStatus(BiliSkin skin, int checkId) {
            if (checkId == skin.mId) {
                this.tickView.setVisibility(0);
            } else {
                this.tickView.setVisibility(4);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            int id = v.getId();
            BiliSkin skin = (BiliSkin) v.getTag();
            Activity activity = ActivityUtils.getWrapperActivity(v.getContext());
            if (skin == null || activity == null) {
                return;
            }
            if (id == R.id.list_item) {
                if (!BiliAccounts.get(v.getContext()).isLogin() && skin.mId == this.mHelper.mNewThemeId) {
                    return;
                }
                if (skin.mIsFree || skin.mIsBought || skin.mStatus == 4 || skin.mStatus == 3) {
                    this.mHelper.setNewtheme(skin.mId);
                    ThemeStoreActivity.reportThemeChangeClick(skin.mId);
                }
            } else if (id == R.id.order_button) {
                if (!BiliAccounts.get(activity).isLogin()) {
                    Router.global().with(v.getContext()).open("activity://main/login/");
                } else if (skin.mIsBought && (skin.mStatus == 1 || skin.mStatus == 2)) {
                    this.mHelper.unSubscribeTheme(skin);
                } else {
                    this.mHelper.subscribeTheme(skin);
                }
            }
        }

        public static AppThemeViewHolder create(ViewGroup parent, WeakReference<ThemeAdapter> weakReference, Helper helper) {
            return new AppThemeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_app_layout_list_item_theme_app_choose, parent, false), weakReference, helper);
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    private static abstract class BaseHeaderSection<Header, Content> extends BaseSection {
        public static final int HEADER_SIZE = 1;
        public int contentType;
        public int headerType;
        public List<Content> mContents;
        public Header mHeader;

        public BaseHeaderSection(Header header, List<Content> contents, int headerType, int contentType) {
            this.mHeader = header;
            this.mContents = contents == null ? Collections.emptyList() : contents;
            this.headerType = headerType;
            this.contentType = contentType;
        }

        @Override // tv.danmaku.bili.widget.recycler.section.Section
        public int getItemViewType(int position) {
            int offsetPosition = convertAdapterPosition(position);
            if (offsetPosition < 1) {
                return this.headerType;
            }
            return this.contentType;
        }

        public void clear() {
            this.mHeader = null;
            if (this.mContents != null) {
                this.mContents.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class Helper {
        boolean hasStyleClicked;
        boolean mIsThemeChanged;
        PegasusStyleEnum mNewCardStyleId;
        int mNewThemeId;
        PegasusStyleEnum mOriginalCardStyleId;
        int mOriginalThemeId;
        ThemeStoreActivity mThemeStoreActivity;

        /* JADX WARN: Multi-variable type inference failed */
        public Helper(ThemeStoreActivity activity) {
            this.mThemeStoreActivity = activity;
            this.mOriginalThemeId = BiliTheme.getCurrentTheme(activity);
            this.mNewThemeId = this.mOriginalThemeId;
            if (!GarbManager.getGarbWithNightMode(this.mThemeStoreActivity).isPure()) {
                this.mNewThemeId = -1;
            }
            this.mOriginalCardStyleId = PegasusStyle.INSTANCE.getCurrentStyle();
            this.mNewCardStyleId = this.mOriginalCardStyleId;
        }

        public void notifyThemeChange() {
            if (this.mIsThemeChanged) {
                Garb currentGarb = GarbManager.getCurGarb();
                if (currentGarb.isPure()) {
                    GarbStorageHelper.INSTANCE.saveLastGarb(currentGarb);
                    GarbManagerDelegate.syncColorGarb(this.mNewThemeId);
                    ThemeWatcher.getInstance().onChanged();
                } else {
                    GarbStorageHelper.INSTANCE.clearLastGarb(this.mThemeStoreActivity, new GarbStorageHelper.IClearLastGarbListener() { // from class: tv.danmaku.bili.ui.theme.ThemeStoreActivity$Helper$$ExternalSyntheticLambda0
                        public final void onClear() {
                            ThemeStoreActivity.Helper.this.m1698lambda$notifyThemeChange$0$tvdanmakubiliuithemeThemeStoreActivity$Helper();
                        }
                    });
                }
                GarbApiHelper.INSTANCE.unloadGarb(this.mThemeStoreActivity, (BiliApiDataCallback) null);
                GarbStorageHelper.INSTANCE.clearOpGarb(this.mThemeStoreActivity, false);
            }
            if (this.hasStyleClicked) {
                PegasusStyle.INSTANCE.setStyle(this.mNewCardStyleId);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$notifyThemeChange$0$tv-danmaku-bili-ui-theme-ThemeStoreActivity$Helper  reason: not valid java name */
        public /* synthetic */ void m1698lambda$notifyThemeChange$0$tvdanmakubiliuithemeThemeStoreActivity$Helper() {
            GarbManagerDelegate.syncColorGarb(this.mNewThemeId);
            ThemeWatcher.getInstance().onChanged();
        }

        public void setNewThemeId(int newThemeId) {
            this.mNewThemeId = newThemeId;
        }

        public void setNewtheme(int newThemeId) {
            Garb garb = GarbManager.getGarbWithNightMode(this.mThemeStoreActivity);
            if (!garb.getChangeable()) {
                ToastHelper.showToastShort(this.mThemeStoreActivity, bili.resource.homepage.R.string.homepage_global_string_355);
            } else if (this.mNewThemeId == newThemeId) {
            } else {
                this.mNewThemeId = newThemeId;
                if (MultipleThemeUtils.isNightFollowSystem(this.mThemeStoreActivity)) {
                    MultipleThemeUtils.setNightFollowSystem(this.mThemeStoreActivity, false);
                    ToastHelper.showToastShort(this.mThemeStoreActivity, bili.resource.homepage.R.string.homepage_global_string_248);
                }
                this.mIsThemeChanged = true;
                BiliTheme.setCurrentTheme(this.mThemeStoreActivity, this.mNewThemeId, false);
                ThemeAdapter themeAdapter = this.mThemeStoreActivity.getThemeAdapter();
                if (themeAdapter != null) {
                    themeAdapter.setCheckId(this.mNewThemeId);
                    themeAdapter.notifyDataSetChanged();
                }
                this.mThemeStoreActivity.changeUi();
            }
        }

        public void setNewCardStyle(PegasusStyleEnum newCardStyle) {
            this.hasStyleClicked = true;
            if (this.mNewCardStyleId == newCardStyle) {
                return;
            }
            this.mNewCardStyleId = newCardStyle;
        }

        public boolean isV1Style() {
            return this.mNewCardStyleId.isSingleColumn();
        }

        public void unSubscribeTheme(BiliSkin skin) {
            this.mThemeStoreActivity.unSubscribe(skin);
        }

        public void subscribeTheme(BiliSkin skin) {
            this.mThemeStoreActivity.subscribe(skin);
        }
    }

    protected void onResume() {
        super.onResume();
        loadTheme();
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    static class CustomDividerDecoration extends RecyclerView.ItemDecoration {
        private int mColorId;
        private int mHeight;
        private int mHorizontalLeftSpacing;
        private Paint mPaint;

        public CustomDividerDecoration(int colorId) {
            this(colorId, 1);
        }

        public CustomDividerDecoration(int colorId, int heightPx) {
            this(colorId, heightPx, 0);
        }

        public CustomDividerDecoration(int colorId, int heightPx, int horizontalLeftSpacingPx) {
            this.mHeight = 1;
            this.mColorId = colorId == 0 ? com.bilibili.lib.theme.R.color.Ga4 : colorId;
            this.mHeight = heightPx;
            this.mHorizontalLeftSpacing = horizontalLeftSpacingPx;
            this.mPaint = new Paint();
            this.mPaint.setStrokeWidth(this.mHeight);
            this.mPaint.setAntiAlias(true);
        }

        public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
            super.onDrawOver(c, parent, state);
            this.mPaint.setColor(ThemeUtils.getColorById(parent.getContext(), this.mColorId));
            drawLinearDivider(c, parent);
        }

        public void getItemOffsets(Rect outRect, View view2, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view2, parent, state);
        }

        protected boolean needDrawDivider(RecyclerView.ViewHolder holder) {
            return true;
        }

        private void drawLinearDivider(Canvas c, RecyclerView parent) {
            int left;
            int right = parent.getWidth() - parent.getPaddingRight();
            int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = parent.getChildAt(i);
                RecyclerView.ViewHolder holder = parent.getChildViewHolder(child);
                if (needDrawDivider(holder)) {
                    if ((holder instanceof AppThemeViewHolder) && i != childCount - 1) {
                        left = parent.getPaddingLeft() + this.mHorizontalLeftSpacing;
                    } else {
                        left = parent.getPaddingLeft();
                    }
                    RecyclerView.LayoutParams params = child.getLayoutParams();
                    float top = (child.getBottom() + params.bottomMargin) - (this.mHeight / 2.0f);
                    c.drawLine(left, top, right, top, this.mPaint);
                }
            }
        }
    }

    public String getPvEventId() {
        return PV_EVENT_ID;
    }

    public Bundle getPvExtra() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportThemeChangeClick(int skinId) {
        Map<String, String> params = new HashMap<>();
        params.put("theme", String.valueOf(skinId));
        Neurons.reportClick(false, "main.theme.theme-select.0.click", params);
    }
}