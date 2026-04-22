package tv.danmaku.bili.ui.main2.mine.holder;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import tv.danmaku.bili.ui.DisplayUtils;

public class MineModulePortItemDecoration extends RecyclerView.ItemDecoration {
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        RecyclerView.Adapter adapter = parent.getAdapter();
        if (adapter == null) {
            return;
        }
        int childCount = adapter.getItemCount();
        int lines = childCount % 4 == 0 ? childCount / 4 : (childCount / 4) + 1;
        int pos = parent.getChildAdapterPosition(view);
        if (pos >= 4) {
            outRect.top = DisplayUtils.dp2Px(4);
        }
        if (lines == (pos / 4) + 1) {
            outRect.bottom = DisplayUtils.dp2Px(12);
        }
    }
}