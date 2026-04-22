package tv.danmaku.bili.widget.recycler.section;

public abstract class BaseSection extends Section {
    @Override // tv.danmaku.bili.widget.recycler.section.Section
    public long getItemId(int position) {
        return -1L;
    }
}