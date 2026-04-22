package tv.danmaku.bili.widget.section.holder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import tv.danmaku.bili.widget.section.adapter.BaseAdapter;

public class BaseViewHolder extends RecyclerView.ViewHolder {
    private BaseAdapter mAdapter;

    public BaseViewHolder(View itemView, BaseAdapter adapter) {
        super(itemView);
        this.mAdapter = adapter;
    }

    public BaseAdapter getAdapter() {
        return this.mAdapter;
    }
}