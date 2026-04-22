package tv.danmaku.bili.widget.recycler;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FullyGridLayoutManager extends GridLayoutManager {
    private int[] mMeasuredDimension;
    private boolean mVerticallyScrollEnabled;

    public FullyGridLayoutManager(Context context, int spanCount) {
        super(context, spanCount);
        this.mVerticallyScrollEnabled = true;
        this.mMeasuredDimension = new int[2];
    }

    public FullyGridLayoutManager(Context context, int spanCount, int orientation, boolean reverseLayout) {
        super(context, spanCount, orientation, reverseLayout);
        this.mVerticallyScrollEnabled = true;
        this.mMeasuredDimension = new int[2];
    }

    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int widthSpec, int heightSpec) {
        int rowMaxHeight;
        int tempWidth;
        int columnMaxWidth;
        int tempHeight;
        int widthMode = View.MeasureSpec.getMode(widthSpec);
        int heightMode = View.MeasureSpec.getMode(heightSpec);
        int widthSize = View.MeasureSpec.getSize(widthSpec);
        int i = View.MeasureSpec.getSize(heightSpec);
        int count = getItemCount();
        int span = getSpanCount();
        int height = 0;
        int rowMaxHeight2 = 0;
        int tempHeight2 = 0;
        int tempWidth2 = 0;
        int columnMaxWidth2 = 0;
        int columnMaxWidth3 = 0;
        int width = 0;
        while (columnMaxWidth3 < count) {
            int heightSize = View.MeasureSpec.makeMeasureSpec(columnMaxWidth3, 0);
            int heightMode2 = View.MeasureSpec.makeMeasureSpec(columnMaxWidth3, 0);
            int heightSize2 = i;
            int heightSize3 = columnMaxWidth3;
            int heightMode3 = heightMode;
            int heightMode4 = columnMaxWidth2;
            measureScrapChild(recycler, columnMaxWidth3, heightSize, heightMode2, this.mMeasuredDimension);
            if (getOrientation() == 0) {
                if (heightSize3 % span == 0) {
                    columnMaxWidth = this.mMeasuredDimension[0];
                    tempHeight = this.mMeasuredDimension[1];
                } else {
                    columnMaxWidth = Math.max(heightMode4, this.mMeasuredDimension[0]);
                    tempHeight = tempHeight2 + this.mMeasuredDimension[1];
                }
                if (heightSize3 % span == span - 1 || heightSize3 == count - 1) {
                    width += columnMaxWidth;
                    columnMaxWidth2 = columnMaxWidth;
                    tempHeight2 = tempHeight;
                    height = Math.max(tempHeight, height);
                } else {
                    columnMaxWidth2 = columnMaxWidth;
                    tempHeight2 = tempHeight;
                }
            } else {
                if (heightSize3 % span == 0) {
                    rowMaxHeight = this.mMeasuredDimension[1];
                    tempWidth = this.mMeasuredDimension[0];
                } else {
                    rowMaxHeight = Math.max(rowMaxHeight2, this.mMeasuredDimension[1]);
                    tempWidth = tempWidth2 + this.mMeasuredDimension[0];
                }
                if (heightSize3 % span == span - 1 || heightSize3 == count - 1) {
                    height += rowMaxHeight;
                    rowMaxHeight2 = rowMaxHeight;
                    tempWidth2 = tempWidth;
                    width = Math.max(tempWidth, width);
                    columnMaxWidth2 = heightMode4;
                } else {
                    rowMaxHeight2 = rowMaxHeight;
                    tempWidth2 = tempWidth;
                    columnMaxWidth2 = heightMode4;
                }
            }
            columnMaxWidth3 = heightSize3 + 1;
            i = heightSize2;
            heightMode = heightMode3;
        }
        int heightMode5 = heightMode;
        int heightSize4 = i;
        switch (widthMode) {
            case 1073741824:
                width = widthSize;
                break;
        }
        switch (heightMode5) {
            case 1073741824:
                height = heightSize4;
                break;
        }
        setMeasuredDimension(width, height);
    }

    private void measureScrapChild(RecyclerView.Recycler recycler, int position, int widthSpec, int heightSpec, int[] measuredDimension) {
        if (position < getItemCount()) {
            try {
                View view2 = recycler.getViewForPosition(position);
                if (view2 != null) {
                    RecyclerView.LayoutParams p = view2.getLayoutParams();
                    int childWidthSpec = ViewGroup.getChildMeasureSpec(widthSpec, getPaddingLeft() + getPaddingRight(), p.width);
                    int childHeightSpec = ViewGroup.getChildMeasureSpec(heightSpec, getPaddingTop() + getPaddingBottom(), p.height);
                    view2.measure(childWidthSpec, childHeightSpec);
                    measuredDimension[0] = view2.getMeasuredWidth() + p.leftMargin + p.rightMargin;
                    measuredDimension[1] = view2.getMeasuredHeight() + p.bottomMargin + p.topMargin;
                    recycler.recycleView(view2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setVerticallyScrollEnabled(boolean enabled) {
        this.mVerticallyScrollEnabled = enabled;
    }

    public boolean canScrollVertically() {
        if (!this.mVerticallyScrollEnabled) {
            return false;
        }
        return super.canScrollVertically();
    }
}