package tv.danmaku.bili.ui.topic;

import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.topic.api.BiliTopic;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: TopicFragments.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\u0016\u0010\u0015\u001a\u00020\u00132\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/ui/topic/TopicListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Ltv/danmaku/bili/ui/topic/BaseViewHolder;", "viewType", "", "<init>", "(I)V", "getViewType", "()I", "list", "", "Ltv/danmaku/bili/ui/topic/api/BiliTopic;", "getItemCount", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "getItemViewType", "position", "onBindViewHolder", "", "holder", "submitList", "newList", "topic_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class TopicListAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private List<BiliTopic> list = new ArrayList();
    private final int viewType;

    public TopicListAdapter(int viewType) {
        this.viewType = viewType;
    }

    public final int getViewType() {
        return this.viewType;
    }

    public int getItemCount() {
        return this.list.size();
    }

    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        switch (viewType) {
            case 1111:
                return new TopicViewHolder(parent);
            case 1874:
                return new ActivityViewHolder(parent);
            default:
                throw new IllegalArgumentException("TopicListAdapter: Error viewType");
        }
    }

    public int getItemViewType(int position) {
        return this.viewType;
    }

    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.list.get(position));
    }

    public final void submitList(final List<BiliTopic> list) {
        if (list == null) {
            int countRemoved = this.list.size();
            this.list = new ArrayList();
            notifyItemRangeRemoved(0, countRemoved);
        } else if (this.list != list) {
            if (this.list.isEmpty()) {
                this.list = list;
                notifyDataSetChanged();
                return;
            }
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() { // from class: tv.danmaku.bili.ui.topic.TopicListAdapter$submitList$result$1
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    List list2;
                    list2 = TopicListAdapter.this.list;
                    return list2.get(oldItemPosition) == list.get(newItemPosition);
                }

                public int getOldListSize() {
                    List list2;
                    list2 = TopicListAdapter.this.list;
                    return list2.size();
                }

                public int getNewListSize() {
                    return list.size();
                }

                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    List list2;
                    list2 = TopicListAdapter.this.list;
                    BiliTopic t1 = (BiliTopic) list2.get(oldItemPosition);
                    BiliTopic t2 = list.get(newItemPosition);
                    return Intrinsics.areEqual(t1.cover, t2.cover) && Intrinsics.areEqual(t1.title, t2.title) && Intrinsics.areEqual(t1.link, t2.link);
                }
            });
            Intrinsics.checkNotNullExpressionValue(result, "calculateDiff(...)");
            this.list = list;
            result.dispatchUpdatesTo(this);
        } else {
            notifyDataSetChanged();
        }
    }
}