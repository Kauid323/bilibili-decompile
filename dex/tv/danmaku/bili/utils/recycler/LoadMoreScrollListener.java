package tv.danmaku.bili.utils.recycler;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bilibili.lib.image.ImageLoaderPauseOnScrollListener;

public class LoadMoreScrollListener extends ImageLoaderPauseOnScrollListener {
    private int mLastItemPosition;

    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        LinearLayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            this.mLastItemPosition = layoutManager.findLastCompletelyVisibleItemPosition();
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            int[] lastPositions = ((StaggeredGridLayoutManager) layoutManager).findLastCompletelyVisibleItemPositions((int[]) null);
            this.mLastItemPosition = getLastItemPosition(lastPositions);
        }
        int visibleItemCount = layoutManager.getChildCount();
        int totalItemCount = layoutManager.getItemCount();
        if (visibleItemCount > 0 && this.mLastItemPosition >= totalItemCount - 1) {
            onLastItemVisible();
        }
    }

    protected void onLastItemVisible() {
    }

    private int getLastItemPosition(int[] lastPositions) {
        int lastItemPos = lastPositions[0];
        for (int pos : lastPositions) {
            lastItemPos = Math.max(pos, lastItemPos);
        }
        return lastItemPos;
    }
}