package tv.danmaku.bili.ui.main2.mine.holder;

import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.lib.homepage.mine.MenuGroup;
import java.util.ArrayList;
import java.util.List;
import tv.danmaku.bili.ui.main2.mine.IMineItemClickListener;

public class InnerMineItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int SPAN_COUNT = 4;
    private IMineItemClickListener mItemClickListener;
    private List<MenuGroup.Item> mItems = new ArrayList();
    private MenuGroup menuGroup;
    public static int INNER_ITEM_STYLE_PORT = 1;
    public static int INNER_ITEM_STYLE_LAND = 2;
    public static int INNER_ITEM_STYLE_MNG = 3;

    public InnerMineItemAdapter(IMineItemClickListener itemClickListener) {
        this.mItemClickListener = itemClickListener;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        MenuGroup.Item item = this.mItems.get(i);
        int type = item.type;
        if (INNER_ITEM_STYLE_PORT == type) {
            return TextUtils.isEmpty(item.titleTail) ? InnerMineModulePortViewHolder.create(viewGroup, this.mItemClickListener) : InnerMineModulePortTailViewHolder.create(viewGroup, this.mItemClickListener);
        } else if (INNER_ITEM_STYLE_MNG == type) {
            return InnerMineModuleMngViewHolder.create(viewGroup, this.mItemClickListener);
        } else {
            return InnerMineModuleLandViewHolder.create(viewGroup, this.mItemClickListener);
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        MenuGroup.Item item = this.mItems.get(i);
        if (viewHolder instanceof InnerMineModulePortViewHolder) {
            ((InnerMineModulePortViewHolder) viewHolder).bind(item, this.menuGroup);
        } else if (viewHolder instanceof InnerMineModulePortTailViewHolder) {
            ((InnerMineModulePortTailViewHolder) viewHolder).bind(item, this.menuGroup);
        } else if (viewHolder instanceof InnerMineModuleLandViewHolder) {
            ((InnerMineModuleLandViewHolder) viewHolder).bind(item, this.menuGroup);
        } else if (viewHolder instanceof InnerMineModuleMngViewHolder) {
            ((InnerMineModuleMngViewHolder) viewHolder).bind(item, this.menuGroup);
        }
    }

    public int getItemCount() {
        return this.mItems.size();
    }

    public void setItems(List<MenuGroup.Item> items, MenuGroup menuGroup) {
        this.menuGroup = menuGroup;
        this.mItems.clear();
        this.mItems.addAll(items);
    }
}