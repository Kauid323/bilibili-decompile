package tv.danmaku.bili.widget.dropdownmenu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bilibili.lib.widget.R;
import java.util.ArrayList;
import tv.danmaku.bili.widget.section.holder.BaseViewHolder;

public class DefaultSubMenuAdapter extends BaseSubMenuAdapter<DropDownMenuItem> {
    public ArrayList<DropDownMenuItem> mSubMenuList;

    @Override // tv.danmaku.bili.widget.dropdownmenu.BaseSubMenuAdapter
    public void setSubMenuData(ArrayList<DropDownMenuItem> dataList) {
        this.mSubMenuList = dataList;
    }

    @Override // tv.danmaku.bili.widget.section.adapter.BaseAdapter
    public void bindHolder(BaseViewHolder holder, int position, View itemView) {
        if (holder instanceof SubMenuHolder) {
            try {
                DropDownMenuItem menuItem = this.mSubMenuList.get(holder.getAdapterPosition());
                ((SubMenuHolder) holder).setupView(menuItem);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // tv.danmaku.bili.widget.section.adapter.BaseAdapter
    public BaseViewHolder createHolder(ViewGroup parent, int viewType) {
        return SubMenuHolder.create(parent, this);
    }

    public int getItemCount() {
        if (this.mSubMenuList == null) {
            return 0;
        }
        return this.mSubMenuList.size();
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    static class SubMenuHolder extends BaseViewHolder {
        private TextView item;

        public SubMenuHolder(View itemView, DefaultSubMenuAdapter adapter) {
            super(itemView, adapter);
            this.item = (TextView) itemView.findViewById(R.id.item);
        }

        public static SubMenuHolder create(ViewGroup parent, DefaultSubMenuAdapter adapter) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_app_layout_drop_down_submenu_item, parent, false);
            return new SubMenuHolder(inflate, adapter);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setupView(DropDownMenuItem menuItem) {
            this.item.setText(menuItem.name);
            this.item.setSelected(menuItem.isSelect);
        }
    }
}