package tv.danmaku.bili.ui.main2.mine.holder;

import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
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
import com.bilibili.magicasakura.widgets.TintConstraintLayout;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment;
import tv.danmaku.bili.ui.main2.reporter.MineReporter;

public class MineNotUpperModuleHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private static final String TAG = "MineNotUpperModuleHolder";
    private final MoleBadgeView mBadgeView;
    private final TintTextView mButtonContent;
    private final ImageView mButtonIcon;
    private final TintConstraintLayout mButtonLayout;
    private final Context mContext;
    private boolean mHasLive;
    private final View mItemView;
    private MenuGroup mMenuGroup;
    private final BiliImageView mNotUpperIcon;
    private final TextView mNotUpperSubtitle;
    private final TextView mNotUpperTitle;
    private final TextView mSubtitleClickTip;
    private final ConstraintLayout mSubtitleContainer;
    private final Rect mTempRect;

    public static MineNotUpperModuleHolder create(ViewGroup parent, HomeUserCenterFragment fragment) {
        return new MineNotUpperModuleHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_layout_main_user_center_module_not_upper, parent, false), fragment);
    }

    public MineNotUpperModuleHolder(View itemView, HomeUserCenterFragment fragment) {
        super(itemView);
        this.mContext = itemView.getContext();
        this.mItemView = itemView;
        this.mNotUpperIcon = itemView.findViewById(R.id.not_upper_title_icon);
        this.mNotUpperIcon.setImageTint(com.bilibili.lib.widget.R.color.auto_night_shade);
        this.mNotUpperTitle = (TextView) itemView.findViewById(R.id.not_upper_title);
        this.mNotUpperSubtitle = (TextView) itemView.findViewById(R.id.not_upper_subtitle);
        this.mSubtitleClickTip = (TextView) itemView.findViewById(R.id.tv_click_tip);
        this.mSubtitleContainer = itemView.findViewById(R.id.subtitle_click_container);
        this.mButtonLayout = itemView.findViewById(R.id.button_layout);
        this.mButtonIcon = (ImageView) itemView.findViewById(R.id.button_icon);
        this.mButtonContent = itemView.findViewById(R.id.button_text);
        this.mBadgeView = itemView.findViewById(R.id.badge);
        this.mBadgeView.setStrokeColor(-1);
        this.mButtonLayout.setOnClickListener(this);
        this.mTempRect = new Rect();
        this.mHasLive = fragment.hasLive();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.button_layout && this.mButtonLayout.getVisibility() == 0 && this.mMenuGroup != null && this.mMenuGroup.button != null) {
            if (this.mMenuGroup.button.isValid(this.mMenuGroup.button.style != 3)) {
                RouteRequest routeRequest = new RouteRequest.Builder(Uri.parse(this.mMenuGroup.button.jumpUrl)).build();
                BLRouter.routeTo(routeRequest, v.getContext());
                String liveType = this.mHasLive ? "10" : MineReporter.LIVE_TYPE_NOT_UPPER_NO_LIVE;
                MineReporter.reportMineModuleButtonClick(this.mMenuGroup.button.text, MineReporter.PUBLISH_TYPE_NOT_UPPER, liveType);
                if (this.mBadgeView != null) {
                    this.mBadgeView.setVisibility(8);
                }
                BiliGlobalPreferenceHelper.getBLKVSharedPreference(this.mContext).edit().putBoolean("ui.main.NavigationFragment.is_show_upload_new" + BiliAccounts.get(v.getContext()).mid(), false).apply();
            }
        }
    }

    public void bind(final MenuGroup menuGroup) {
        this.mMenuGroup = menuGroup;
        BiliImageLoader.INSTANCE.acquire(this.mButtonIcon).useOrigin().asDrawable().url(menuGroup.tipIcon == null ? "" : menuGroup.tipIcon).submit().subscribe(new ImageDataSubscriber<DrawableHolder>() { // from class: tv.danmaku.bili.ui.main2.mine.holder.MineNotUpperModuleHolder.1
            public /* synthetic */ void onProgressUpdate(ImageDataSource imageDataSource) {
                ImageDataSubscriber.-CC.$default$onProgressUpdate(this, imageDataSource);
            }

            public void onResult(ImageDataSource<DrawableHolder> imageDataSource) {
                DrawableHolder holder = (DrawableHolder) imageDataSource.getResult();
                if (holder != null) {
                    MineNotUpperModuleHolder.this.mNotUpperIcon.setImageDrawable(holder.get());
                }
            }

            public void onFailure(ImageDataSource<DrawableHolder> imageDataSource) {
                MineNotUpperModuleHolder.this.mNotUpperIcon.setImageResource(R.drawable.bili_ic_mine_not_up);
            }

            public void onCancellation(ImageDataSource<DrawableHolder> dataSource) {
            }
        });
        MenuGroup.MineButton mineButton = menuGroup.button;
        boolean useDefaultContent = false;
        useDefaultContent = (TextUtils.isEmpty(menuGroup.beUpTitle) || TextUtils.isEmpty(menuGroup.tipTitle) || mineButton == null || TextUtils.isEmpty(mineButton.text)) ? true : true;
        if (useDefaultContent) {
            this.mNotUpperTitle.setText(bili.resource.homepage.R.string.homepage_global_string_24);
            this.mNotUpperSubtitle.setText(bili.resource.homepage.R.string.homepage_global_string_50);
        } else {
            this.mNotUpperTitle.setText(menuGroup.beUpTitle);
            this.mNotUpperSubtitle.setText(menuGroup.tipTitle);
        }
        boolean isShowClickTips = (useDefaultContent || TextUtils.isEmpty(menuGroup.clickBarTips) || TextUtils.isEmpty(menuGroup.clickLink)) ? false : true;
        if (!isShowClickTips) {
            this.mSubtitleClickTip.setVisibility(8);
            this.mSubtitleContainer.setOnClickListener((View.OnClickListener) null);
        } else {
            this.mSubtitleClickTip.setVisibility(0);
            this.mSubtitleClickTip.setText(menuGroup.clickBarTips);
            this.mSubtitleContainer.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main2.mine.holder.MineNotUpperModuleHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MineNotUpperModuleHolder.this.m2099lambda$bind$0$tvdanmakubiliuimain2mineholderMineNotUpperModuleHolder(menuGroup, view);
                }
            });
        }
        if (mineButton != null) {
            this.mBadgeView.setVisibility(8);
            this.mButtonLayout.setVisibility(0);
            this.mButtonContent.setText(useDefaultContent ? this.mContext.getString(bili.resource.homepage.R.string.homepage_global_string_18) : mineButton.text);
            if (TextUtils.isEmpty(mineButton.icon)) {
                this.mButtonIcon.setVisibility(8);
            } else {
                this.mButtonIcon.setVisibility(0);
                BiliImageLoader.INSTANCE.acquire(this.mButtonIcon).with(this.mButtonIcon).asDrawable().url(mineButton.icon).submit().subscribe(new ImageDataSubscriber<DrawableHolder>() { // from class: tv.danmaku.bili.ui.main2.mine.holder.MineNotUpperModuleHolder.2
                    public /* synthetic */ void onProgressUpdate(ImageDataSource imageDataSource) {
                        ImageDataSubscriber.-CC.$default$onProgressUpdate(this, imageDataSource);
                    }

                    public void onResult(ImageDataSource<DrawableHolder> imageDataSource) {
                        DrawableHolder holder = (DrawableHolder) imageDataSource.getResult();
                        if (holder != null) {
                            MineNotUpperModuleHolder.this.mButtonIcon.setImageDrawable(holder.get());
                        }
                    }

                    public void onFailure(ImageDataSource<DrawableHolder> imageDataSource) {
                    }

                    public void onCancellation(ImageDataSource<DrawableHolder> dataSource) {
                    }
                });
            }
            if (mineButton.style == 1) {
                this.mButtonLayout.setBackgroundResource(R.drawable.shape_button_r15_pink_mine);
                this.mButtonContent.setTextColor(-1);
            } else {
                this.mButtonLayout.setBackgroundResource(R.drawable.shape_button_r15_white_mine);
                this.mButtonContent.setTextColor(ContextCompat.getColor(this.mContext, com.bilibili.lib.theme.R.color.Pi5_u));
            }
            if (!BiliGlobalPreferenceHelper.getBLKVSharedPreference(this.mContext).getBoolean("ui.main.NavigationFragment.is_show_upload_new" + BiliAccounts.get(this.mContext).mid(), true)) {
                this.mBadgeView.setVisibility(8);
                return;
            } else {
                this.mBadgeView.setVisibility(0);
                return;
            }
        }
        this.mButtonLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$bind$0$tv-danmaku-bili-ui-main2-mine-holder-MineNotUpperModuleHolder  reason: not valid java name */
    public /* synthetic */ void m2099lambda$bind$0$tvdanmakubiliuimain2mineholderMineNotUpperModuleHolder(MenuGroup menuGroup, View v) {
        if (!TextUtils.isEmpty(menuGroup.clickLink)) {
            goToArchiveActivity(menuGroup.clickLink, v);
        }
    }

    private void goToArchiveActivity(String clickLink, View v) {
        if (TextUtils.isEmpty(clickLink) || v == null) {
            return;
        }
        BLog.e(TAG, "[click] clickLink = " + clickLink);
        RouteRequest routeRequest = new RouteRequest.Builder(Uri.parse(clickLink)).build();
        BLRouter.routeTo(routeRequest, v.getContext());
    }

    public int onUpperTipsViewShow() {
        boolean isVisible = this.mItemView.getLocalVisibleRect(this.mTempRect);
        return isVisible ? 1 : -1;
    }
}