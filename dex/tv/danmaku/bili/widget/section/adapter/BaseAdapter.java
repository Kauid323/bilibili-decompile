package tv.danmaku.bili.widget.section.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import tv.danmaku.bili.widget.section.holder.BaseViewHolder;

public abstract class BaseAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    public HandleClickListener mHandleClickListener;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface HandleClickListener {
        void handleClick(BaseViewHolder baseViewHolder);
    }

    public abstract void bindHolder(BaseViewHolder baseViewHolder, int i, View view2);

    public abstract BaseViewHolder createHolder(ViewGroup viewGroup, int i);

    public final BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseViewHolder holder = createHolder(parent, viewType);
        handleClick(holder);
        if (this.mHandleClickListener != null) {
            this.mHandleClickListener.handleClick(holder);
        }
        return holder;
    }

    public final void onBindViewHolder(BaseViewHolder holder, int position) {
        bindHolder(holder, position, holder.itemView);
    }

    public long getItemId(int position) {
        return position;
    }

    public void handleClick(BaseViewHolder holder) {
    }

    public void setHandleClickListener(HandleClickListener handleClickListener) {
        this.mHandleClickListener = handleClickListener;
    }
}