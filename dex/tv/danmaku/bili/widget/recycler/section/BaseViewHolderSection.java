package tv.danmaku.bili.widget.recycler.section;

import android.view.ViewGroup;
import tv.danmaku.bili.widget.recycler.section.BaseSectionAdapter;

public abstract class BaseViewHolderSection extends BaseSection {
    public abstract BaseSectionAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i);
}