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

public class InnerMineModuleMngViewHolder extends BaseMineItemViewHolder {
    private Context mContext;
    private BiliImageView mIcon;
    private TextView mTitle;

    public InnerMineModuleMngViewHolder(View itemView, IMineItemClickListener clickListener) {
        super(itemView, clickListener);
        this.mIcon = itemView.findViewById(R.id.icon);
        this.mTitle = (TextView) itemView.findViewById(R.id.title);
        this.mContext = itemView.getContext();
    }

    public static InnerMineModuleMngViewHolder create(ViewGroup parent, IMineItemClickListener clickListener) {
        return new InnerMineModuleMngViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_layout_main_user_center_mng_item, parent, false), clickListener);
    }

    @Override // tv.danmaku.bili.ui.main2.mine.holder.BaseMineItemViewHolder
    public void bind(MenuGroup.Item item, MenuGroup menuGroup) {
        super.bind(item, menuGroup);
        this.mItem = item;
        BiliImageLoader.INSTANCE.with(this.mContext).placeholderImageResId(item.iconResId != 0 ? item.iconResId : com.bilibili.app.comm.baseres.R.drawable.bili_default_image_tv).url(item.icon).into(this.mIcon);
        this.mTitle.setText(item.title);
    }
}