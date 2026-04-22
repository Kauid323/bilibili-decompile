package tv.danmaku.bili.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private int mItemCountInLastLine;
    private int mOldItemCount;
    private int mRadixX;
    private int mSpace;
    private int mSpanCount;

    public SpacesItemDecoration(int space) {
        this(space, 1);
    }

    public SpacesItemDecoration(int space, int spanCount) {
        this.mOldItemCount = -1;
        this.mSpace = space;
        this.mSpanCount = spanCount;
        this.mRadixX = space / spanCount;
    }

    public void getItemOffsets(Rect outRect, View view2, final androidx.recyclerview.widget.RecyclerView parent, RecyclerView.State state) {
        int spanSize;
        int index;
        GridLayoutManager.LayoutParams layoutParams = (RecyclerView.LayoutParams) view2.getLayoutParams();
        int sumCount = state.getItemCount();
        int position = layoutParams.getViewLayoutPosition();
        if (layoutParams instanceof GridLayoutManager.LayoutParams) {
            GridLayoutManager.LayoutParams gridParams = layoutParams;
            spanSize = gridParams.getSpanSize();
            index = gridParams.getSpanIndex();
            if ((position == 0 || this.mOldItemCount != sumCount) && this.mSpanCount > 1) {
                int countInLine = 0;
                for (int tempPosition = sumCount - this.mSpanCount; tempPosition < sumCount; tempPosition++) {
                    int spanIndex = parent.getLayoutManager().getSpanSizeLookup().getSpanIndex(tempPosition, this.mSpanCount);
                    countInLine = spanIndex == 0 ? 1 : countInLine + 1;
                }
                this.mItemCountInLastLine = countInLine;
                if (this.mOldItemCount != sumCount) {
                    this.mOldItemCount = sumCount;
                    if (position != 0) {
                        parent.post(new Runnable() { // from class: tv.danmaku.bili.widget.SpacesItemDecoration.1
                            @Override // java.lang.Runnable
                            public void run() {
                                parent.invalidateItemDecorations();
                            }
                        });
                    }
                }
            }
        } else if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            spanSize = ((StaggeredGridLayoutManager.LayoutParams) layoutParams).isFullSpan() ? this.mSpanCount : 1;
            index = ((StaggeredGridLayoutManager.LayoutParams) layoutParams).getSpanIndex();
        } else {
            spanSize = 1;
            index = 0;
        }
        if (spanSize < 1 || index < 0 || spanSize > this.mSpanCount) {
            return;
        }
        outRect.left = this.mSpace - (this.mRadixX * index);
        outRect.right = this.mRadixX + (this.mRadixX * ((index + spanSize) - 1));
        if (this.mSpanCount == 1 && position == sumCount - 1) {
            outRect.bottom = this.mSpace;
        } else if (position >= sumCount - this.mItemCountInLastLine && position < sumCount) {
            outRect.bottom = this.mSpace;
        }
        outRect.top = this.mSpace;
    }
}