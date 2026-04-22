package tv.danmaku.bili.ui.main2.mine.holder;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.lib.badge.Badge;
import com.bilibili.lib.homepage.mine.MenuGroup;
import com.bilibili.lib.homepage.widget.badge.MoleBadgeView;
import com.bilibili.lib.homepage.widget.badge.NumberBadgeView;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.main2.mine.IMineItemClickListener;
import tv.danmaku.bili.ui.main2.mine.MineExtentionsKt;
import tv.danmaku.bili.ui.main2.mine.MinePrefHelper;
import tv.danmaku.bili.ui.main2.mine.MngResourceManager;
import tv.danmaku.bili.ui.main2.reporter.MineReporter;

public abstract class BaseMineItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private static final String TAG = "BaseMineItemViewHolder";
    protected NumberBadgeView mBadgeView;
    private Context mContext;
    protected MenuGroup.Item mItem;
    private final IMineItemClickListener mItemClickListener;
    protected MenuGroup mMenuGroup;
    protected MoleBadgeView moleBadgeView;
    private Rect rectVisible;

    public void tryShowBadge(Badge badge) {
        if (this.mBadgeView != null && this.moleBadgeView == null) {
            if (badge == null || badge == Badge.NONE) {
                this.mBadgeView.setVisibility(8);
                return;
            }
            this.mBadgeView.setVisibility(0);
            this.mBadgeView.update(badge);
        } else if (this.moleBadgeView != null) {
            if (badge == null || badge == Badge.NONE) {
                this.moleBadgeView.setVisibility(8);
                if (this.mBadgeView != null) {
                    this.mBadgeView.setVisibility(8);
                }
            } else if (badge.badgeType == 1) {
                this.moleBadgeView.setVisibility(0);
                if (this.mBadgeView != null) {
                    this.mBadgeView.setVisibility(8);
                }
                this.moleBadgeView.update(badge, 0, 0);
            } else {
                this.moleBadgeView.setVisibility(8);
                if (this.mBadgeView != null) {
                    this.mBadgeView.setVisibility(0);
                    this.mBadgeView.update(badge);
                }
            }
        }
    }

    public BaseMineItemViewHolder(View itemView, IMineItemClickListener clickListener) {
        super(itemView);
        this.rectVisible = new Rect();
        this.mContext = itemView.getContext();
        this.mItemClickListener = clickListener;
        itemView.setOnClickListener(this);
        this.mBadgeView = itemView.findViewById(R.id.badge);
        this.moleBadgeView = itemView.findViewById(R.id.badge_mole);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (MineExtentionsKt.isShowMngResource(this.mItem)) {
            MngResourceManager.recordMngResourceClicked(this.mItem.itemMngResource);
            resetMngResource();
            this.mItem.isReportMngResourceId = true;
        }
        if (this.mItemClickListener != null) {
            this.mItemClickListener.onMineItemClick(this.mItem);
        }
        if (this.mItem != null) {
            MinePrefHelper.INSTANCE.setClickedForNew(v.getContext(), String.valueOf(this.mItem.id));
        }
        Badge badge = MineExtentionsKt.getBadgeNum(this.mItem, v.getContext(), 99);
        int badgeNum = badge == null ? 0 : badge.msgCount;
        MineReporter.reportMineItemClickWithRedDot(this.mItem, getBindingAdapterPosition(), Integer.valueOf(badgeNum), this.mItem.title, null);
        if (this.mItem == null || this.mItem.dismissRedDotOnClicked) {
            tryShowBadge(null);
        }
        if (this.mItem != null) {
            if (this.mItem.dismissRedDotOnClicked) {
                this.mItem.redDot = 0;
                this.mItem.localRedDot = 0;
                this.mItem.redDotSecond = null;
            }
            this.mItem.redDotRorNew = false;
        }
    }

    protected void resetMngResource() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bind(MenuGroup.Item item, MenuGroup menuGroup) {
        this.mItem = item;
        this.mMenuGroup = menuGroup;
        tryShowBadge(MineExtentionsKt.getBadgeNum(item, this.mContext, 99));
    }

    public MenuGroup.Item getItem() {
        return this.mItem;
    }

    public void tryReportExposure() {
        if (this.mItem != null && !this.mItem.hasExposure) {
            this.mItem.hasExposure = true;
            Badge badge = MineExtentionsKt.getBadgeNum(this.mItem, this.itemView.getContext(), 99);
            int badgeNum = badge == null ? 0 : badge.msgCount;
            MineReporter.reportMineItemShowWithRedDot(this.mItem, getLayoutPosition(), Integer.valueOf(badgeNum), this.mItem.title, null, "onScroll");
        }
    }

    public boolean isInRect(Rect globalRect) {
        this.itemView.getGlobalVisibleRect(this.rectVisible);
        return globalRect.contains(this.rectVisible);
    }
}