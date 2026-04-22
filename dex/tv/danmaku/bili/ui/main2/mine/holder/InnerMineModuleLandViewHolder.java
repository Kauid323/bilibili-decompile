package tv.danmaku.bili.ui.main2.mine.holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bilibili.lib.homepage.mine.MenuGroup;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.view.BiliImageView;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.main2.mine.IMineItemClickListener;
import tv.danmaku.bili.ui.main2.mine.MineExtentionsKt;

public class InnerMineModuleLandViewHolder extends BaseMineItemViewHolder {
    private Context mContext;
    private BiliImageView mIcon;
    private BiliImageView mMngIcon;
    private TextView mTitle;

    public InnerMineModuleLandViewHolder(View itemView, IMineItemClickListener onMineItemClickListener) {
        super(itemView, onMineItemClickListener);
        this.mIcon = itemView.findViewById(R.id.icon);
        this.mTitle = (TextView) itemView.findViewById(R.id.title);
        this.mMngIcon = itemView.findViewById(R.id.mng_icon);
        this.mContext = itemView.getContext();
    }

    public static InnerMineModuleLandViewHolder create(ViewGroup parent, IMineItemClickListener onMineItemClickListener) {
        return new InnerMineModuleLandViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_layout_main_user_center_land_item, parent, false), onMineItemClickListener);
    }

    @Override // tv.danmaku.bili.ui.main2.mine.holder.BaseMineItemViewHolder
    public void bind(MenuGroup.Item item, MenuGroup menuGroup) {
        super.bind(item, menuGroup);
        if (MineExtentionsKt.isShowMngResource(item)) {
            tryShowBadge(null);
            BiliImageLoader.INSTANCE.with(this.mContext).url(item.itemMngResource.icon).into(this.mMngIcon);
            this.mMngIcon.setVisibility(0);
        } else {
            this.mMngIcon.setVisibility(8);
        }
        BiliImageLoader.INSTANCE.with(this.mContext).placeholderImageResId(item.iconResId != 0 ? item.iconResId : com.bilibili.app.comm.baseres.R.drawable.bili_default_image_tv).url(item.icon).into(this.mIcon);
        this.mTitle.setText(item.title);
    }

    @Override // tv.danmaku.bili.ui.main2.mine.holder.BaseMineItemViewHolder
    protected void resetMngResource() {
        this.mMngIcon.setVisibility(8);
    }
}