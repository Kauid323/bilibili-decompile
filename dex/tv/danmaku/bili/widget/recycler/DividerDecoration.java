package tv.danmaku.bili.widget.recycler;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bilibili.app.comm.baseres.R;
import com.bilibili.magicasakura.utils.ThemeUtils;

public class DividerDecoration extends RecyclerView.ItemDecoration {
    private int mColorId;
    private int mHeight;
    private int mHorizontalLeftSpacing;
    private int mHorizontalRightSpacing;
    private Paint mPaint;

    public DividerDecoration() {
        this(0);
    }

    public DividerDecoration(int colorId) {
        this(colorId, 1);
    }

    public DividerDecoration(int colorId, int heightPx) {
        this(colorId, heightPx, 0, 0);
    }

    public DividerDecoration(int colorId, int heightPx, int horizontalLeftSpacingPx, int horizontalRightSpacingPx) {
        this.mHeight = 1;
        this.mColorId = colorId == 0 ? R.color.daynight_color_dividing_line : colorId;
        this.mHeight = heightPx;
        this.mHorizontalLeftSpacing = horizontalLeftSpacingPx;
        this.mHorizontalRightSpacing = horizontalRightSpacingPx;
        this.mPaint = new Paint();
        this.mPaint.setStrokeWidth(this.mHeight);
        this.mPaint.setAntiAlias(true);
    }

    @Deprecated
    public DividerDecoration(Context context) {
        this(0);
    }

    @Deprecated
    public DividerDecoration(Context context, int colorId) {
        this(colorId);
    }

    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        this.mPaint.setColor(ThemeUtils.getColorById(parent.getContext(), this.mColorId));
        RecyclerView.LayoutManager manager = parent.getLayoutManager();
        if (manager instanceof LinearLayoutManager) {
            drawLinearDivider(c, parent);
        } else if (manager instanceof StaggeredGridLayoutManager) {
            drawStaggeredGridDivider(c, parent);
        }
    }

    private void drawLinearDivider(Canvas c, RecyclerView parent) {
        LinearLayoutManager llm = parent.getLayoutManager();
        boolean isHorizontal = llm.getOrientation() == 1;
        int left = parent.getPaddingLeft() + (isHorizontal ? this.mHorizontalLeftSpacing : 0);
        int right = (parent.getWidth() - parent.getPaddingRight()) - (isHorizontal ? this.mHorizontalRightSpacing : 0);
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            if (needDrawDivider(parent.getChildViewHolder(child))) {
                RecyclerView.LayoutParams params = child.getLayoutParams();
                float top = (child.getBottom() + params.bottomMargin) - (this.mHeight / 2.0f);
                c.drawLine(left, top, right, top, this.mPaint);
            }
        }
    }

    private void drawStaggeredGridDivider(Canvas c, RecyclerView parent) {
        StaggeredGridLayoutManager manager = parent.getLayoutManager() instanceof StaggeredGridLayoutManager ? (StaggeredGridLayoutManager) parent.getLayoutManager() : null;
        if (manager == null) {
            return;
        }
        int spanCount = manager.getSpanCount();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            if (needDrawDivider(parent.getChildViewHolder(child))) {
                StaggeredGridLayoutManager.LayoutParams params = child.getLayoutParams();
                float hLeft = child.getLeft() + params.leftMargin;
                float hRight = hLeft + child.getWidth();
                float hTop = (child.getBottom() + params.bottomMargin) - (this.mHeight / 2.0f);
                c.drawLine(hLeft, hTop, hRight, hTop, this.mPaint);
                int spanIndex = params.getSpanIndex();
                if (spanIndex >= 0 && !params.isFullSpan() && spanIndex + 1 < spanCount) {
                    float vLeft = (child.getRight() + params.rightMargin) - (this.mHeight / 2.0f);
                    float vTop = child.getTop() + params.topMargin;
                    float vBottom = child.getHeight() + vTop;
                    c.drawLine(vLeft, vTop, vLeft, vBottom, this.mPaint);
                }
            }
        }
    }

    public void setHorizontalSpacing(int horizontalSpacing) {
        this.mHorizontalLeftSpacing = horizontalSpacing;
        this.mHorizontalRightSpacing = horizontalSpacing;
    }

    public void setHorizontalLeftSpacing(int horizontalLeftSpacing) {
        this.mHorizontalLeftSpacing = horizontalLeftSpacing;
    }

    public void setHorizontalRightSpacing(int horizontalRightSpacing) {
        this.mHorizontalRightSpacing = horizontalRightSpacing;
    }

    @Deprecated
    public void setHeight(int mHeight) {
        this.mHeight = mHeight;
    }

    protected boolean needDrawDivider(RecyclerView.ViewHolder holder) {
        return true;
    }
}