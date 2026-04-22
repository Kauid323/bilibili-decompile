package tv.danmaku.bili.widget.recycler;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

public class HLinearLayoutManager extends LinearLayoutManager {
    public HLinearLayoutManager(Context context) {
        super(context, 0, false);
    }

    public HLinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this(context);
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()) { // from class: tv.danmaku.bili.widget.recycler.HLinearLayoutManager.1
            protected int getHorizontalSnapPreference() {
                return -1;
            }

            public PointF computeScrollVectorForPosition(int targetPosition) {
                return HLinearLayoutManager.this.computeScrollVectorForPosition(targetPosition);
            }
        };
        linearSmoothScroller.setTargetPosition(position);
        startSmoothScroll(linearSmoothScroller);
    }
}