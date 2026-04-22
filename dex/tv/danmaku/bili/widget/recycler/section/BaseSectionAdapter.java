package tv.danmaku.bili.widget.recycler.section;

import android.util.Log;
import android.view.View;
import androidx.collection.SparseArrayCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.lib.widget.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import tv.danmaku.bili.widget.recycler.section.BaseSectionAdapter.ViewHolder;

public abstract class BaseSectionAdapter<VH extends ViewHolder> extends RecyclerView.Adapter<VH> {
    private List<Section> sections = new ArrayList();
    private SparseArrayCompat<Section> caches = new SparseArrayCompat<>();

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((BaseSectionAdapter<VH>) ((ViewHolder) viewHolder), i);
    }

    public void onBindViewHolder(VH holder, int position) {
        Section section = getSection(position);
        if (section != null) {
            holder.bind(section.data(position));
        }
    }

    public long getItemId(int position) {
        Section section;
        if (hasStableIds() && (section = getSection(position)) != null) {
            return section.getItemId(position);
        }
        return super.getItemId(position);
    }

    public final int getItemCount() {
        return this.caches.size();
    }

    public int getItemViewType(int position) {
        Section section = getSection(position);
        if (section == null) {
            return 0;
        }
        return section.getItemViewType(position);
    }

    public final Section getSection(int position) {
        return (Section) this.caches.get(position);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getSectionsSize() {
        return this.sections.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Section getSectionInternal(int position) {
        if (position >= this.sections.size() || position < 0) {
            return null;
        }
        return this.sections.get(position);
    }

    protected final int getSectionInternalPosition(Section section) {
        if (section == null) {
            return -1;
        }
        return this.sections.indexOf(section);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void addSectionInternal(int position, Section section) {
        this.sections.add(position, section);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void addSectionInternal(Section section) {
        this.sections.add(section);
    }

    public final void removeSection(int position) {
        this.sections.remove(position);
        onSectionsChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void removeSectionInternal(Section section) {
        this.sections.remove(section);
    }

    public final void setSections(List<? extends Section> list) {
        this.sections.clear();
        this.caches.clear();
        this.sections.addAll(list);
        onSectionsChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void onSectionsChanged() {
        onSectionsChanged(true);
    }

    protected final void onSectionsChanged(boolean invalidate) {
        this.caches.clear();
        int count = 0;
        for (Section sec : this.sections) {
            sec.setStart(count);
            int size = sec.size();
            for (int i = 0; i < size; i++) {
                this.caches.put(count + i, sec);
            }
            count += size;
        }
        if (invalidate) {
            notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        clear();
    }

    public final void clear() {
        this.caches.clear();
        this.sections.clear();
    }

    public final void clear(int start) {
        clear(start, this.sections.size());
    }

    public final void clear(int start, int end) {
        if (start < 0 || start >= this.sections.size() || end < start || end > this.sections.size()) {
            return;
        }
        this.caches.clear();
        for (int i = end - 1; i >= start; i--) {
            this.sections.remove(i);
        }
    }

    protected void finalize() throws Throwable {
        if (this.caches.size() > 0 || this.sections.size() > 0) {
            if (BuildConfig.DEBUG) {
                Log.i("SectionAdapter", this + " finalized not called onDestroy()!");
            }
            onDestroy();
        }
        super/*java.lang.Object*/.finalize();
    }

    public void notifyUserVisible(boolean isVisibleToUser) {
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static abstract class ViewHolder extends RecyclerView.ViewHolder {
        public abstract void bind(Object obj);

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}