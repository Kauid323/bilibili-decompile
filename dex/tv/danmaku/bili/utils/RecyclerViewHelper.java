package tv.danmaku.bili.utils;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewHelper {
    public static boolean canScrollUp(RecyclerView recyclerView) {
        if (recyclerView == null || recyclerView.getChildCount() == 0) {
            return false;
        }
        View first = recyclerView.getChildAt(0);
        int firstVisible = recyclerView.getChildLayoutPosition(first);
        if (firstVisible != 0) {
            return true;
        }
        RecyclerView.LayoutParams lp = first.getLayoutParams();
        if (first.getTop() >= recyclerView.getPaddingTop() + lp.topMargin) {
            return false;
        }
        return true;
    }
}