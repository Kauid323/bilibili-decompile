package tv.danmaku.bili.ui.favorite.cheesesupport;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bilibili.lib.image2.BiliImageLoader;

public class LoadMoreScrollListener extends RecyclerView.OnScrollListener {
    private int mFirstItemPosition;
    private int mLastItemPosition;

    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        if (newState == 0) {
            BiliImageLoader.INSTANCE.resume();
        } else {
            BiliImageLoader.INSTANCE.pause();
        }
    }

    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        LinearLayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            this.mLastItemPosition = layoutManager.findLastCompletelyVisibleItemPosition();
            this.mFirstItemPosition = layoutManager.findFirstCompletelyVisibleItemPosition();
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            int[] lastPositions = ((StaggeredGridLayoutManager) layoutManager).findLastCompletelyVisibleItemPositions((int[]) null);
            this.mLastItemPosition = getLastItemPosition(lastPositions);
            int[] firstPositions = ((StaggeredGridLayoutManager) layoutManager).findFirstCompletelyVisibleItemPositions((int[]) null);
            this.mFirstItemPosition = getFirstItemPosition(firstPositions);
        }
        completelyVisibleItemPos(this.mFirstItemPosition, this.mLastItemPosition);
        int visibleItemCount = layoutManager.getChildCount();
        int totalItemCount = layoutManager.getItemCount();
        if (visibleItemCount > 0 && this.mLastItemPosition >= totalItemCount - 1) {
            onLastItemVisible();
        }
    }

    protected void onLastItemVisible() {
    }

    protected void completelyVisibleItemPos(int firstItemPosition, int lastItemPosition) {
    }

    private int getLastItemPosition(int[] lastPositions) {
        int lastItemPos = lastPositions[0];
        for (int pos : lastPositions) {
            lastItemPos = Math.max(pos, lastItemPos);
        }
        return lastItemPos;
    }

    private int getFirstItemPosition(int[] firstPositions) {
        int firstItemPos = firstPositions[0];
        for (int pos : firstPositions) {
            firstItemPos = Math.min(pos, firstItemPos);
        }
        return firstItemPos;
    }
}