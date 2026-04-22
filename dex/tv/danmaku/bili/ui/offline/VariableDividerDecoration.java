package tv.danmaku.bili.ui.offline;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.lib.basecomponent.R;
import com.bilibili.magicasakura.utils.ThemeUtils;

/* JADX INFO: Access modifiers changed from: package-private */
public abstract class VariableDividerDecoration extends RecyclerView.ItemDecoration {
    private int height;
    private Paint paint = new Paint();

    public VariableDividerDecoration(Context context) {
        this.height = context.getResources().getDimensionPixelSize(R.dimen.divider_line_height);
        this.paint.setStrokeWidth(this.height);
        this.paint.setAntiAlias(true);
    }

    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        this.paint.setColor(ThemeUtils.getColorById(parent.getContext(), com.bilibili.lib.theme.R.color.Ga2));
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            if (needDrawDivider(parent, child)) {
                RecyclerView.LayoutParams params = child.getLayoutParams();
                float top = (child.getBottom() + params.bottomMargin) - (this.height / 2.0f);
                c.drawLine(getLeft(parent, child), top, getRight(parent, child), top, this.paint);
            }
        }
    }

    private int getLeft(RecyclerView parent, View view2) {
        return parent.getPaddingLeft() + getHorizontalLeftSpace(parent, view2);
    }

    private int getRight(RecyclerView parent, View view2) {
        return (parent.getWidth() - parent.getPaddingRight()) - getHorizontalRightSpace(parent, view2);
    }

    protected int getHorizontalLeftSpace(RecyclerView parent, View view2) {
        return 0;
    }

    protected int getHorizontalRightSpace(RecyclerView parent, View view2) {
        return 0;
    }

    protected boolean needDrawDivider(RecyclerView parent, View view2) {
        return true;
    }
}