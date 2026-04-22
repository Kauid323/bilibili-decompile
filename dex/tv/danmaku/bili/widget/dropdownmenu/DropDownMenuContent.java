package tv.danmaku.bili.widget.dropdownmenu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.lib.widget.R;
import tv.danmaku.android.log.BLog;

public class DropDownMenuContent extends RelativeLayout {
    protected int mContentBgColor;
    private RecyclerView.ItemDecoration mItemDecoration;
    private View mMask;
    private RecyclerView mRecyclerView;
    private int mSpanCount;

    public DropDownMenuContent(Context context) {
        this(context, null, 0);
    }

    public DropDownMenuContent(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DropDownMenuContent(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mSpanCount = -1;
        obtainAttrs(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.bili_app_layout_drop_down_menu_content, (ViewGroup) this, true);
        this.mRecyclerView = findViewById(R.id.recycler_view);
        this.mRecyclerView.setBackgroundColor(this.mContentBgColor);
        this.mMask = findViewById(R.id.mask);
    }

    private void obtainAttrs(Context context, AttributeSet attrs) {
        TypedArray ta;
        if (attrs != null && (ta = context.obtainStyledAttributes(attrs, R.styleable.DropDownMenuContent)) != null) {
            this.mContentBgColor = ta.getColor(R.styleable.DropDownMenuContent_contentBgColor, Color.parseColor("#eaeaea"));
            ta.recycle();
        }
    }

    public RecyclerView getRecyclerView() {
        return this.mRecyclerView;
    }

    public View getMask() {
        return this.mMask;
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    public void setSpanCount(int spanCount) {
        this.mSpanCount = spanCount;
    }

    public RecyclerView.ItemDecoration getItemDecoration() {
        return this.mItemDecoration;
    }

    public void clearAllDecoration() {
        int decorationCount = this.mRecyclerView.getItemDecorationCount();
        while (decorationCount > 0) {
            try {
                decorationCount--;
                this.mRecyclerView.removeItemDecorationAt(decorationCount);
            } catch (Exception e) {
                BLog.i("DropDownMenuContent", "remove failed");
                return;
            }
        }
    }

    public void setItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        this.mItemDecoration = itemDecoration;
    }

    public void setContentBgColor(int contentBgColor) {
        this.mContentBgColor = contentBgColor;
        this.mRecyclerView.setBackgroundColor(this.mContentBgColor);
    }
}