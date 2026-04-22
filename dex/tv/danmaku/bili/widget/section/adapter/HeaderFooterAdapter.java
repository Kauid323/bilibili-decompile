package tv.danmaku.bili.widget.section.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HeaderFooterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int MAX_HEADER_FOOTER_SIZE = 255;
    private static final int TYPE_FOOTER_OFFSET = 536870912;
    private static final int TYPE_HEADER_OFFSET = 268435456;
    private static final int TYPE_HEADER_OR_FOOTER_SHIFT = 24;
    protected final RecyclerView.Adapter mInner;
    private final ArrayList<FixedViewInfo> mHeaderViewInfos = new ArrayList<>();
    private final ArrayList<FixedViewInfo> mFooterViewInfos = new ArrayList<>();
    private Map<RecyclerView.AdapterDataObserver, RecyclerView.AdapterDataObserver> mObserverMap = new HashMap();

    public HeaderFooterAdapter(RecyclerView.Adapter adapter) {
        this.mInner = adapter;
        if (this.mInner.hasStableIds()) {
            super.setHasStableIds(true);
        }
    }

    public RecyclerView.Adapter getWrapped() {
        return this.mInner;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType >= TYPE_HEADER_OFFSET) {
            return getFixViewInfo(viewType);
        }
        return this.mInner.onCreateViewHolder(parent, viewType);
    }

    private FixedViewInfo getFixViewInfo(int viewType) {
        if (viewType >= TYPE_FOOTER_OFFSET) {
            int footerPosition = ((viewType - TYPE_FOOTER_OFFSET) >> 24) & MAX_HEADER_FOOTER_SIZE;
            return this.mFooterViewInfos.get(footerPosition);
        } else if (viewType >= TYPE_HEADER_OFFSET) {
            int headerPosition = ((viewType - TYPE_HEADER_OFFSET) >> 24) & MAX_HEADER_FOOTER_SIZE;
            return this.mHeaderViewInfos.get(headerPosition);
        } else {
            throw new IndexOutOfBoundsException("wtf! viewtype=" + Integer.toHexString(viewType));
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof FixedViewInfo) {
            return;
        }
        this.mInner.onBindViewHolder(holder, position - getHeadersCount());
    }

    public void setHasStableIds(boolean hasStableIds) {
        super.setHasStableIds(hasStableIds);
        this.mInner.setHasStableIds(hasStableIds);
    }

    public void onViewRecycled(RecyclerView.ViewHolder holder) {
        if (!(holder instanceof FixedViewInfo)) {
            this.mInner.onViewRecycled(holder);
        }
    }

    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        if (!(holder instanceof FixedViewInfo)) {
            this.mInner.onViewAttachedToWindow(holder);
        }
    }

    public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
        if (!(holder instanceof FixedViewInfo)) {
            this.mInner.onViewDetachedFromWindow(holder);
        }
    }

    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver observer) {
        super.registerAdapterDataObserver(observer);
        this.mInner.registerAdapterDataObserver(observerOf(observer));
    }

    private RecyclerView.AdapterDataObserver observerOf(final RecyclerView.AdapterDataObserver observer) {
        RecyclerView.AdapterDataObserver wrapper = this.mObserverMap.get(observer);
        if (wrapper == null) {
            RecyclerView.AdapterDataObserver wrapper2 = new RecyclerView.AdapterDataObserver() { // from class: tv.danmaku.bili.widget.section.adapter.HeaderFooterAdapter.1
                final RecyclerView.AdapterDataObserver delegate;

                {
                    this.delegate = observer;
                }

                public void onChanged() {
                    this.delegate.onChanged();
                }

                public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {
                    this.delegate.onItemRangeChanged(HeaderFooterAdapter.this.getHeadersCount() + positionStart, itemCount, payload);
                }

                public void onItemRangeInserted(int positionStart, int itemCount) {
                    this.delegate.onItemRangeInserted(HeaderFooterAdapter.this.getHeadersCount() + positionStart, itemCount);
                }

                public void onItemRangeRemoved(int positionStart, int itemCount) {
                    this.delegate.onItemRangeRemoved(HeaderFooterAdapter.this.getHeadersCount() + positionStart, itemCount);
                }

                public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
                    int headerOffset = HeaderFooterAdapter.this.getHeadersCount();
                    this.delegate.onItemRangeMoved(fromPosition + headerOffset, toPosition + headerOffset, itemCount);
                }
            };
            this.mObserverMap.put(observer, wrapper2);
            return wrapper2;
        }
        return wrapper;
    }

    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver observer) {
        super.unregisterAdapterDataObserver(observer);
        RecyclerView.AdapterDataObserver wrapper = this.mObserverMap.remove(observer);
        if (wrapper != null) {
            this.mInner.unregisterAdapterDataObserver(wrapper);
        }
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        this.mInner.onAttachedToRecyclerView(recyclerView);
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.mInner.onDetachedFromRecyclerView(recyclerView);
    }

    public int getItemViewType(int position) {
        int numHeaders = getHeadersCount();
        if (position >= numHeaders) {
            int adjPosition = position - numHeaders;
            int adapterCount = this.mInner.getItemCount();
            if (adjPosition < adapterCount) {
                return this.mInner.getItemViewType(adjPosition);
            }
        }
        if (position < numHeaders) {
            return (position << 24) + TYPE_HEADER_OFFSET;
        }
        int footer = (position - numHeaders) - this.mInner.getItemCount();
        return (footer << 24) + TYPE_FOOTER_OFFSET;
    }

    public long getItemId(int position) {
        int id;
        int numHeaders = getHeadersCount();
        if (position >= numHeaders) {
            int adjPosition = position - numHeaders;
            int adapterCount = this.mInner.getItemCount();
            if (adjPosition < adapterCount) {
                return this.mInner.getItemId(adjPosition);
            }
        }
        if (this.mInner.hasStableIds()) {
            if (position < numHeaders) {
                id = (position << 24) + TYPE_HEADER_OFFSET;
            } else {
                int id2 = position - numHeaders;
                id = ((id2 - this.mInner.getItemCount()) << 24) + TYPE_FOOTER_OFFSET;
            }
            return id;
        }
        return -1L;
    }

    public int getItemCount() {
        int count = getFootersCount() + getHeadersCount();
        return this.mInner.getItemCount() + count;
    }

    public int getHeadersCount() {
        return this.mHeaderViewInfos.size();
    }

    public int getFootersCount() {
        return this.mFooterViewInfos.size();
    }

    public void addHeaderView(View v) {
        addHeaderView(v, null);
    }

    public void addHeaderView(View v, Object data) {
        if (this.mHeaderViewInfos.size() > MAX_HEADER_FOOTER_SIZE) {
            throw new IllegalArgumentException("Headers count cannot be larger than 255");
        }
        this.mHeaderViewInfos.add(new FixedViewInfo(v, data));
    }

    public void addFooterView(View v) {
        addFooterView(v, null);
    }

    public void addFooterView(View v, Object data) {
        if (this.mHeaderViewInfos.size() > MAX_HEADER_FOOTER_SIZE) {
            throw new IllegalArgumentException("Footers count cannot be larger than 255");
        }
        this.mFooterViewInfos.add(new FixedViewInfo(v, data));
    }

    public boolean isHeaderOrFooter(int viewType) {
        return viewType >= TYPE_FOOTER_OFFSET || viewType >= TYPE_HEADER_OFFSET;
    }

    public boolean removeFooterView(View v) {
        return this.mFooterViewInfos.size() > 0 && removeFixedViewInfo(v, this.mFooterViewInfos);
    }

    public boolean removeHeaderView(View v) {
        return this.mHeaderViewInfos.size() > 0 && removeFixedViewInfo(v, this.mHeaderViewInfos);
    }

    private boolean removeFixedViewInfo(View v, ArrayList<FixedViewInfo> where) {
        int len = where.size();
        for (int i = 0; i < len; i++) {
            FixedViewInfo info = where.get(i);
            if (info.itemView == v) {
                where.remove(i);
                notifyItemRemoved(info.getAdapterPosition());
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class FixedViewInfo extends RecyclerView.ViewHolder {
        private final Object data;

        public FixedViewInfo(View itemView, Object data) {
            super(itemView);
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }
}