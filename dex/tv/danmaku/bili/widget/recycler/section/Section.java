package tv.danmaku.bili.widget.recycler.section;

public abstract class Section {
    private int start = -1;

    public abstract Object data(int i);

    public abstract long getItemId(int i);

    public abstract int getItemViewType(int i);

    public abstract int size();

    public final void setStart(int adapterPosition) {
        this.start = adapterPosition;
    }

    public final int getStart() {
        return this.start;
    }

    public final int convertAdapterPosition(int adapterPosition) {
        if (this.start == -1) {
            return -1;
        }
        return adapterPosition - this.start;
    }
}