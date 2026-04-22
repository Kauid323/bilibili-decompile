package tv.danmaku.bili.widget.recycler.section;

import android.view.ViewGroup;
import tv.danmaku.bili.widget.recycler.section.BaseSectionAdapter;

public abstract class BaseViewHolderSectionAdapter extends BaseSectionAdapter<BaseSectionAdapter.ViewHolder> {
    public final BaseSectionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int size = getSectionsSize();
        for (int index = 0; index < size; index++) {
            Section item = getSectionInternal(index);
            if (item != null) {
                if (!(item instanceof BaseViewHolderSection)) {
                    throw new IllegalArgumentException(String.format("The section (%s) must be an instance of %s", item.getClass().getSimpleName(), BaseViewHolderSection.class.getSimpleName()));
                }
                BaseSectionAdapter.ViewHolder holder = ((BaseViewHolderSection) item).onCreateViewHolder(parent, viewType);
                if (holder != null) {
                    return holder;
                }
            }
        }
        return null;
    }
}