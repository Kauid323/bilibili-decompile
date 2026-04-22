package tv.danmaku.bili.widget.section.adapter;

import android.util.SparseArray;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class BaseSectionAdapter extends BaseAdapter {
    public static final int TYPE_NONE = -1;
    private int mItemCount;
    private SparseArray<Section> mSectionItems = new SparseArray<>();
    private SparseArray<Section> mSectionTypes = new SparseArray<>();
    private SectionManager mSectionManager = new SectionManager();

    protected abstract void fillSectionList(SectionManager sectionManager);

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        calc();
    }

    public final int getItemCount() {
        return this.mItemCount;
    }

    public final int getItemViewType(int position) {
        Section section = getSection(position);
        if (section != null) {
            if (position == section.start && section.headerViewType > 0) {
                return section.headerViewType;
            }
            if (position == section.end && section.footerViewType > 0) {
                return section.footerViewType;
            }
            return section.contentViewType;
        }
        return super.getItemViewType(position);
    }

    private void calc() {
        this.mSectionItems.clear();
        this.mItemCount = 0;
        this.mSectionManager.clear();
        fillSectionList(this.mSectionManager);
        Iterator it = this.mSectionManager.mSections.iterator();
        while (it.hasNext()) {
            Section section = (Section) it.next();
            section.start = this.mItemCount;
            int size = section.size;
            for (int i = 0; i < size; i++) {
                this.mSectionItems.put(this.mItemCount + i, section);
            }
            int i2 = this.mItemCount;
            this.mItemCount = i2 + size;
            section.end = this.mItemCount - 1;
            this.mSectionTypes.put(section.contentViewType, section);
        }
    }

    public void addSection(int index, Section section) {
        this.mSectionManager.mSections.add(index, section);
    }

    public void addSection(Section section) {
        this.mSectionManager.mSections.add(section);
    }

    public void removeSection(int index) {
        this.mSectionManager.mSections.remove(index);
    }

    public void notifySectionData(boolean isNeedNotify) {
        calc();
        if (isNeedNotify) {
            notifyDataSetChanged();
        }
    }

    public void notifySectionData() {
        notifySectionData(true);
    }

    public Section getSection(int position) {
        return this.mSectionItems.get(position);
    }

    public int getSectionIndex(int position) {
        return this.mSectionManager.mSections.indexOf(this.mSectionItems.get(position));
    }

    public Section getSectionFromType(int contentViewType) {
        return this.mSectionTypes.get(contentViewType);
    }

    public int getIndexInSection(int position) {
        Section section = this.mSectionItems.get(position);
        if (section == null) {
            return position;
        }
        return (position - section.start) - (section.headerViewType > 0 ? 1 : 0);
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class Section {
        public int contentSize;
        public int contentViewType;
        public int end;
        public int footerViewType;
        public int headerViewType;
        public int size;
        public int start;

        public Section(int contentSize, int contentViewType, int headerViewType, int footerViewType) {
            this.contentSize = contentSize;
            this.contentViewType = contentViewType;
            this.headerViewType = headerViewType;
            this.footerViewType = footerViewType;
            this.size = (headerViewType == -1 ? 0 : 1) + contentSize + (footerViewType != -1 ? 1 : 0);
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class SectionManager {
        private ArrayList<Section> mSections = new ArrayList<>();

        public void addSection(int contentSize, int contentViewType, int headerViewType, int footerViewType) {
            Section section = new Section(contentSize, contentViewType, headerViewType, footerViewType);
            this.mSections.add(section);
        }

        @Deprecated
        public void addSection(int contentSize, int contentViewType) {
            addSection(contentSize, contentViewType, -1, -1);
        }

        public void addSectionWithHeader(int contentSize, int contentViewType, int headerViewType) {
            addSection(contentSize, contentViewType, headerViewType, -1);
        }

        public void addSectionWithFooter(int contentSize, int contentViewType, int footerViewType) {
            addSection(contentSize, contentViewType, -1, footerViewType);
        }

        public void addSectionWithNone(int contentSize, int contentViewType) {
            addSection(contentSize, contentViewType, -1, -1);
        }

        public int getSecionSize() {
            return this.mSections.size();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clear() {
            this.mSections.clear();
        }
    }
}