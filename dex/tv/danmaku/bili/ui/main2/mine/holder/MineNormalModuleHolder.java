package tv.danmaku.bili.ui.main2.mine.holder;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.app.comm.list.widget.scroll.ScrollListenerHelperKt;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.homepage.mine.MenuGroup;
import com.bilibili.lib.homepage.widget.badge.MoleBadgeView;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.bean.DrawableHolder;
import com.bilibili.lib.image2.bean.ImageDataSource;
import com.bilibili.lib.image2.bean.ImageDataSubscriber;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.ui.util.MultipleThemeUtils;
import com.bilibili.magicasakura.widgets.TintConstraintLayout;
import com.bilibili.magicasakura.widgets.TintTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.DisplayUtils;
import tv.danmaku.bili.ui.main2.api.AccountMine;
import tv.danmaku.bili.ui.main2.mine.HomeUserCenterAdapter;
import tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment;
import tv.danmaku.bili.ui.main2.mine.widgets.IDayNightChangeListener;
import tv.danmaku.bili.ui.main2.mine.widgets.MineNightConstraintLayout;
import tv.danmaku.bili.ui.main2.mine.widgets.MineNightTextView;
import tv.danmaku.bili.ui.main2.reporter.MineReporter;

public class MineNormalModuleHolder extends RecyclerView.ViewHolder implements View.OnClickListener, ReportableHolder {
    private final HomeUserCenterAdapter mAdapter;
    private final MoleBadgeView mBadgeView;
    private final TintTextView mButtonContent;
    protected final TextView mButtonForward;
    private final ImageView mButtonIcon;
    protected final TintConstraintLayout mButtonLayout;
    private final Context mContext;
    private final int mDp12;
    private final int mDp2;
    private final int mDp5;
    private final int mDp7;
    private final GradientDrawable mGradientDrawable;
    private boolean mHasLive;
    private final MineNightTextView mHeadSubTitle;
    private final MineNightTextView mHeadTitle;
    private final View mHeaderView;
    private int mInnerItemStyle;
    private boolean mIsUperModule;
    private final MineModulePortItemDecoration mItemDecoration;
    protected MenuGroup mMenuGroup;
    private final BiliImageView mMngBg;
    private final RecyclerView mRecyclerView;
    private final AccountMine.AccountUperInfo mUperInfo;
    private Rect rectVisible;

    public MineNormalModuleHolder(View itemView, HomeUserCenterAdapter adapter, HomeUserCenterFragment fragment) {
        super(itemView);
        this.mIsUperModule = false;
        this.mContext = itemView.getContext();
        this.mAdapter = adapter;
        this.mUperInfo = fragment.getMUperModuleInfo();
        this.mHasLive = fragment.hasLive();
        this.mMngBg = itemView.findViewById(R.id.mng_bg);
        this.mMngBg.setImageTint(com.bilibili.lib.widget.R.color.auto_night_shade);
        this.mHeaderView = itemView.findViewById(R.id.head_layout);
        this.mHeadTitle = (MineNightTextView) itemView.findViewById(R.id.title);
        this.mHeadSubTitle = (MineNightTextView) itemView.findViewById(R.id.subtitle);
        this.mButtonLayout = itemView.findViewById(R.id.button_layout);
        this.mButtonIcon = (ImageView) itemView.findViewById(R.id.button_icon);
        this.mButtonForward = (TextView) itemView.findViewById(R.id.button_forward);
        this.mButtonContent = itemView.findViewById(R.id.button_text);
        this.mRecyclerView = itemView.findViewById(R.id.item_recycle);
        this.mButtonLayout.setOnClickListener(this);
        this.mButtonForward.setOnClickListener(this);
        this.mItemDecoration = new MineModulePortItemDecoration();
        this.mBadgeView = itemView.findViewById(R.id.badge);
        this.mBadgeView.setStrokeColor(-1);
        this.mDp12 = DisplayUtils.dp2Px(12);
        this.mDp2 = DisplayUtils.dp2Px(2);
        this.mDp7 = DisplayUtils.dp2Px(7);
        this.mDp5 = DisplayUtils.dp2Px(5);
        this.mGradientDrawable = new GradientDrawable();
    }

    public static MineNormalModuleHolder create(ViewGroup parent, HomeUserCenterAdapter adapter, HomeUserCenterFragment fragment) {
        return new MineNormalModuleHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_layout_main_user_center_module_normal, parent, false), adapter, fragment);
    }

    public void bind(MenuGroup data) {
        this.mMenuGroup = data;
        this.mInnerItemStyle = data.style;
        this.mIsUperModule = false;
        boolean shouldShowButton = true;
        if (!TextUtils.isEmpty(data.title)) {
            this.mHeaderView.setVisibility(0);
            if (data.viewType == 4) {
                this.mIsUperModule = true;
                shouldShowButton = this.mUperInfo.showVideoUp;
                this.mHeadTitle.setText(!TextUtils.isEmpty(data.upTitle) ? data.upTitle : this.mContext.getString(bili.resource.others.R.string.others_global_string_38));
            } else {
                this.mIsUperModule = false;
                this.mHeadTitle.setText(data.title);
            }
            MenuGroup.MineButton mineButton = data.button;
            if (mineButton != null) {
                if (mineButton.isValid(mineButton.style != 3) && shouldShowButton) {
                    this.mBadgeView.setVisibility(8);
                    this.mButtonLayout.setVisibility(0);
                    if (mineButton.style == 1) {
                        this.mButtonLayout.setVisibility(0);
                        this.mButtonForward.setVisibility(8);
                        bindButtonLayout(mineButton);
                        this.mButtonLayout.setBackgroundResource(R.drawable.shape_button_r15_pink_mine);
                        this.mButtonContent.setTextColor(-1);
                        this.mButtonIcon.setColorFilter(-1);
                    } else if (mineButton.style == 2) {
                        this.mButtonLayout.setVisibility(0);
                        this.mButtonForward.setVisibility(8);
                        bindButtonLayout(mineButton);
                        this.mButtonLayout.setBackgroundResource(R.drawable.shape_button_r15_white_mine);
                        this.mButtonContent.setTextColor(ContextCompat.getColor(this.mContext, com.bilibili.lib.theme.R.color.Pi5_u));
                        this.mButtonIcon.setColorFilter(ContextCompat.getColor(this.mContext, com.bilibili.lib.theme.R.color.Pi5_u));
                    } else if (mineButton.style == 3) {
                        this.mButtonLayout.setVisibility(8);
                        this.mButtonForward.setVisibility(0);
                        this.mButtonForward.setText(mineButton.text);
                    }
                    if (this.mIsUperModule) {
                        if (BiliGlobalPreferenceHelper.getBLKVSharedPreference(this.mContext).getBoolean("ui.main.NavigationFragment.is_show_upload_new" + BiliAccounts.get(this.mContext).mid(), true)) {
                            this.mBadgeView.setVisibility(0);
                        } else {
                            this.mBadgeView.setVisibility(8);
                        }
                    }
                }
            }
            this.mButtonLayout.setVisibility(8);
        } else {
            this.mHeaderView.setVisibility(8);
        }
        initMngModule(data);
        this.mRecyclerView.setVisibility(0);
        if (this.mMenuGroup != null && this.mMenuGroup.itemList != null && this.mMenuGroup.itemList.size() > 0) {
            initInnerRecycleView(this.mMenuGroup.itemList, this.mMenuGroup);
        }
    }

    private void bindButtonLayout(MenuGroup.MineButton mineButton) {
        this.mButtonContent.setText(mineButton.text);
        BiliImageLoader.INSTANCE.acquire(this.mButtonIcon).with(this.mButtonIcon).asDrawable().url(mineButton.icon).submit().subscribe(new ImageDataSubscriber<DrawableHolder>() { // from class: tv.danmaku.bili.ui.main2.mine.holder.MineNormalModuleHolder.1
            public /* synthetic */ void onProgressUpdate(ImageDataSource imageDataSource) {
                ImageDataSubscriber.-CC.$default$onProgressUpdate(this, imageDataSource);
            }

            public void onResult(ImageDataSource<DrawableHolder> imageDataSource) {
                DrawableHolder holder = (DrawableHolder) imageDataSource.getResult();
                if (holder != null) {
                    MineNormalModuleHolder.this.mButtonIcon.setImageDrawable(holder.get());
                }
            }

            public void onFailure(ImageDataSource<DrawableHolder> imageDataSource) {
            }

            public void onCancellation(ImageDataSource<DrawableHolder> dataSource) {
            }
        });
    }

    private void initMngModule(MenuGroup data) {
        int i;
        int i2;
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) this.itemView.getLayoutParams();
        ViewGroup.MarginLayoutParams headViewLayoutParams = (ViewGroup.MarginLayoutParams) this.mHeaderView.getLayoutParams();
        MenuGroup.ModuleMngInfo mngInfo = data.moduleMngInfo;
        if (mngInfo != null && !mngInfo.isNotValid()) {
            boolean isNight = MultipleThemeUtils.isNightTheme(this.mContext);
            this.mInnerItemStyle = InnerMineItemAdapter.INNER_ITEM_STYLE_MNG;
            this.mHeadSubTitle.setVisibility(TextUtils.isEmpty(mngInfo.subtitle) ? 8 : 0);
            this.mHeadSubTitle.setText(mngInfo.subtitle);
            if (TextUtils.isEmpty(mngInfo.subtitleUrl)) {
                this.mHeadSubTitle.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                this.mHeadSubTitle.setOnClickListener(null);
            } else {
                this.mHeadSubTitle.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_mine_mng_tips, 0);
                this.mHeadSubTitle.setCompoundDrawablePadding(this.mDp5);
                this.mHeadSubTitle.setOnClickListener(this);
            }
            final int titleColor = DisplayUtils.parseColor(mngInfo.titleColor, 0);
            if (titleColor == 0) {
                this.mHeadTitle.setTextColor(ContextCompat.getColor(this.mContext, com.bilibili.lib.theme.R.color.Ga10));
            } else {
                MineNightTextView mineNightTextView = this.mHeadTitle;
                if (isNight) {
                    i = ColorUtils.blendARGB(titleColor, -16777216, 0.3f);
                } else {
                    i = titleColor;
                }
                mineNightTextView.setTextColor(i);
            }
            this.mHeadTitle.setChangeListener(new IDayNightChangeListener() { // from class: tv.danmaku.bili.ui.main2.mine.holder.MineNormalModuleHolder$$ExternalSyntheticLambda0
                @Override // tv.danmaku.bili.ui.main2.mine.widgets.IDayNightChangeListener
                public final void onThemeChange(boolean z) {
                    MineNormalModuleHolder.this.m2093lambda$initMngModule$0$tvdanmakubiliuimain2mineholderMineNormalModuleHolder(titleColor, z);
                }
            });
            final int subtitleColor = DisplayUtils.parseColor(mngInfo.subtitleColor, 0);
            if (subtitleColor == 0) {
                this.mHeadSubTitle.setTextColor(ContextCompat.getColor(this.mContext, com.bilibili.lib.theme.R.color.Ga8));
            } else {
                MineNightTextView mineNightTextView2 = this.mHeadSubTitle;
                if (isNight) {
                    i2 = ColorUtils.blendARGB(subtitleColor, -16777216, 0.3f);
                } else {
                    i2 = subtitleColor;
                }
                mineNightTextView2.setTextColor(i2);
            }
            this.mHeadSubTitle.setChangeListener(new IDayNightChangeListener() { // from class: tv.danmaku.bili.ui.main2.mine.holder.MineNormalModuleHolder$$ExternalSyntheticLambda1
                @Override // tv.danmaku.bili.ui.main2.mine.widgets.IDayNightChangeListener
                public final void onThemeChange(boolean z) {
                    MineNormalModuleHolder.this.m2094lambda$initMngModule$1$tvdanmakubiliuimain2mineholderMineNormalModuleHolder(subtitleColor, z);
                }
            });
            if (this.mHeaderView.getVisibility() == 0) {
                headViewLayoutParams.topMargin = this.mDp12;
                this.mMngBg.setVisibility(0);
                BiliImageLoader.INSTANCE.with(this.mContext).url(data.moduleMngInfo.background).into(this.mMngBg);
            } else {
                this.mMngBg.setVisibility(8);
                headViewLayoutParams.topMargin = 0;
            }
            this.mHeaderView.setLayoutParams(headViewLayoutParams);
            int i3 = this.mDp12;
            layoutParams.rightMargin = i3;
            layoutParams.leftMargin = i3;
            this.itemView.setLayoutParams(layoutParams);
            final int mngBackgroundColor = DisplayUtils.parseColor(mngInfo.backgroundColor, 0);
            final GradientDrawable drawable = (GradientDrawable) this.mGradientDrawable.mutate();
            drawable.setCornerRadius(this.mDp7);
            drawable.setColor(isNight ? ColorUtils.blendARGB(mngBackgroundColor, -16777216, 0.3f) : mngBackgroundColor);
            this.itemView.setBackground(drawable);
            if (this.itemView instanceof MineNightConstraintLayout) {
                ((MineNightConstraintLayout) this.itemView).setChangeListener(new IDayNightChangeListener() { // from class: tv.danmaku.bili.ui.main2.mine.holder.MineNormalModuleHolder$$ExternalSyntheticLambda2
                    @Override // tv.danmaku.bili.ui.main2.mine.widgets.IDayNightChangeListener
                    public final void onThemeChange(boolean z) {
                        MineNormalModuleHolder.this.m2095lambda$initMngModule$2$tvdanmakubiliuimain2mineholderMineNormalModuleHolder(drawable, mngBackgroundColor, z);
                    }
                });
            }
            this.itemView.setPadding(0, 0, 0, this.mDp2);
            return;
        }
        this.mInnerItemStyle = data.style;
        this.mHeadSubTitle.setVisibility(8);
        this.mMngBg.setVisibility(8);
        this.mHeadTitle.setTextColor(ContextCompat.getColor(this.mContext, com.bilibili.lib.theme.R.color.Ga10));
        this.mHeadTitle.setChangeListener(new IDayNightChangeListener() { // from class: tv.danmaku.bili.ui.main2.mine.holder.MineNormalModuleHolder$$ExternalSyntheticLambda3
            @Override // tv.danmaku.bili.ui.main2.mine.widgets.IDayNightChangeListener
            public final void onThemeChange(boolean z) {
                MineNormalModuleHolder.this.m2096lambda$initMngModule$3$tvdanmakubiliuimain2mineholderMineNormalModuleHolder(z);
            }
        });
        this.mHeadSubTitle.setChangeListener(null);
        this.mHeadSubTitle.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        this.mHeadSubTitle.setOnClickListener(null);
        if (this.itemView instanceof MineNightConstraintLayout) {
            ((MineNightConstraintLayout) this.itemView).setChangeListener(null);
        }
        headViewLayoutParams.topMargin = 0;
        this.mHeaderView.setLayoutParams(headViewLayoutParams);
        layoutParams.rightMargin = 0;
        layoutParams.leftMargin = 0;
        this.itemView.setLayoutParams(layoutParams);
        this.itemView.setBackground(new ColorDrawable(0));
        this.itemView.setPadding(0, 0, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initMngModule$0$tv-danmaku-bili-ui-main2-mine-holder-MineNormalModuleHolder  reason: not valid java name */
    public /* synthetic */ void m2093lambda$initMngModule$0$tvdanmakubiliuimain2mineholderMineNormalModuleHolder(int titleColor, boolean night) {
        this.mHeadTitle.setTextColor(night ? ColorUtils.blendARGB(titleColor, -16777216, 0.3f) : titleColor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initMngModule$1$tv-danmaku-bili-ui-main2-mine-holder-MineNormalModuleHolder  reason: not valid java name */
    public /* synthetic */ void m2094lambda$initMngModule$1$tvdanmakubiliuimain2mineholderMineNormalModuleHolder(int subtitleColor, boolean night) {
        this.mHeadSubTitle.setTextColor(night ? ColorUtils.blendARGB(subtitleColor, -16777216, 0.3f) : subtitleColor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initMngModule$2$tv-danmaku-bili-ui-main2-mine-holder-MineNormalModuleHolder  reason: not valid java name */
    public /* synthetic */ void m2095lambda$initMngModule$2$tvdanmakubiliuimain2mineholderMineNormalModuleHolder(GradientDrawable drawable, int mngBackgroundColor, boolean night) {
        drawable.setColor(night ? ColorUtils.blendARGB(mngBackgroundColor, -16777216, 0.3f) : mngBackgroundColor);
        this.itemView.setBackground(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initMngModule$3$tv-danmaku-bili-ui-main2-mine-holder-MineNormalModuleHolder  reason: not valid java name */
    public /* synthetic */ void m2096lambda$initMngModule$3$tvdanmakubiliuimain2mineholderMineNormalModuleHolder(boolean night) {
        this.mHeadTitle.setTextColor(ContextCompat.getColor(this.mContext, com.bilibili.lib.theme.R.color.Ga10));
    }

    private void initInnerRecycleView(List<MenuGroup.Item> list, MenuGroup menuGroup) {
        GridLayoutManager gridLayoutManager;
        if (this.mInnerItemStyle == InnerMineItemAdapter.INNER_ITEM_STYLE_PORT || this.mInnerItemStyle == InnerMineItemAdapter.INNER_ITEM_STYLE_MNG) {
            gridLayoutManager = new GridLayoutManager(this.mContext, 4);
            if (this.mRecyclerView.getItemDecorationCount() == 0) {
                this.mRecyclerView.addItemDecoration(this.mItemDecoration);
            }
        } else {
            gridLayoutManager = new GridLayoutManager(this.mContext, 1);
            this.mRecyclerView.removeItemDecoration(this.mItemDecoration);
        }
        InnerMineItemAdapter adapter = new InnerMineItemAdapter(this.mAdapter.getMItemClickListener());
        this.mRecyclerView.setLayoutManager(gridLayoutManager);
        this.mRecyclerView.setAdapter(adapter);
        List<MenuGroup.Item> innerList = new ArrayList<>();
        Iterator<MenuGroup.Item> it = list.iterator();
        while (it.hasNext()) {
            MenuGroup.Item item = it.next();
            boolean addItem = item != null && item.localShow && (!this.mIsUperModule || item.visible == 1);
            if (addItem) {
                item.type = this.mInnerItemStyle;
                innerList.add(item);
            }
        }
        adapter.setItems(innerList, menuGroup);
        adapter.notifyDataSetChanged();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.button_layout) {
            if (this.mButtonLayout.getVisibility() == 0 && this.mMenuGroup != null && this.mMenuGroup.button != null) {
                if (this.mMenuGroup.button.isValid(this.mMenuGroup.button.style != 3)) {
                    RouteRequest routeRequest = new RouteRequest.Builder(Uri.parse(this.mMenuGroup.button.jumpUrl)).build();
                    BLRouter.routeTo(routeRequest, v.getContext());
                    String publishType = this.mIsUperModule ? MineReporter.PUBLISH_TYPE_UPPER : null;
                    String liveType = null;
                    if (this.mIsUperModule) {
                        liveType = this.mHasLive ? "11" : MineReporter.LIVE_TYPE_UPPER_NO_LIVE;
                    }
                    MineReporter.reportMineModuleButtonClick(this.mMenuGroup.button.text, publishType, liveType);
                    if (this.mBadgeView != null) {
                        this.mBadgeView.setVisibility(8);
                    }
                    if (this.mIsUperModule) {
                        BiliGlobalPreferenceHelper.getBLKVSharedPreference(this.mContext).edit().putBoolean("ui.main.NavigationFragment.is_show_upload_new" + BiliAccounts.get(v.getContext()).mid(), false).apply();
                    }
                }
            }
        } else if (id == R.id.subtitle) {
            if (this.mMenuGroup != null && this.mMenuGroup.moduleMngInfo != null) {
                RouteRequest routeRequest2 = new RouteRequest.Builder(Uri.parse(this.mMenuGroup.moduleMngInfo.subtitleUrl)).build();
                BLRouter.routeTo(routeRequest2, v.getContext());
                MineReporter.reportMineMngSubtitleClick(this.mMenuGroup.title);
            }
        } else if (id == R.id.button_forward && this.mButtonForward.getVisibility() == 0 && this.mMenuGroup != null && this.mMenuGroup.button != null) {
            if (this.mMenuGroup.button.isValid(this.mMenuGroup.button.style != 3)) {
                Map<String, String> extra = new HashMap<>(4);
                extra.put("issue_type", this.mMenuGroup.button.localDefault ? "1" : "0");
                extra.put("module_id", "0");
                MineReporter.reportMineItemClickWithRedDot(null, 4, 0, this.mMenuGroup.button.text, extra);
                RouteRequest routeRequest3 = new RouteRequest.Builder(Uri.parse(this.mMenuGroup.button.jumpUrl)).build();
                BLRouter.routeTo(routeRequest3, v.getContext());
            }
        }
    }

    public void onAttachedToRecyclerView() {
        reportButton("onAttach");
    }

    @Override // tv.danmaku.bili.ui.main2.mine.holder.ReportableHolder
    public void onScrollToVisible() {
        reportButton("inner_scroll");
        if (this.mMenuGroup != null && this.mMenuGroup.itemList != null && !this.mMenuGroup.itemList.isEmpty() && this.mRecyclerView != null) {
            if (this.rectVisible == null) {
                this.rectVisible = new Rect();
            }
            this.mRecyclerView.getGlobalVisibleRect(this.rectVisible);
            int childCount = this.mRecyclerView.getChildCount();
            Pair<Integer, Integer> theVisible = ScrollListenerHelperKt.getVisibleItem(this.mRecyclerView);
            for (int i = 0; i < childCount; i++) {
                View child = this.mRecyclerView.getChildAt(i);
                if (child != null) {
                    RecyclerView.ViewHolder holder = this.mRecyclerView.getChildViewHolder(child);
                    if (holder instanceof BaseMineItemViewHolder) {
                        int pos = holder.getLayoutPosition();
                        if (pos < ((Integer) theVisible.getFirst()).intValue() || pos > ((Integer) theVisible.getSecond()).intValue()) {
                            return;
                        }
                        if (((BaseMineItemViewHolder) holder).isInRect(this.rectVisible)) {
                            ((BaseMineItemViewHolder) holder).tryReportExposure();
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportButton(String from) {
        if (this.mMenuGroup != null && this.mMenuGroup.button != null && !this.mMenuGroup.button.hasExposure && this.mMenuGroup.button.isValid(false) && this.mMenuGroup.button.style == 3) {
            this.mMenuGroup.button.hasExposure = true;
            Map<String, String> extra = new HashMap<>(4);
            extra.put("issue_type", this.mMenuGroup.button.localDefault ? "1" : "0");
            extra.put("module_id", "0");
            MineReporter.reportMineItemShowWithRedDot(null, 4, 0, this.mMenuGroup.button.text, extra, from);
        }
    }
}