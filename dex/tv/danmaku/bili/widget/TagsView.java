package tv.danmaku.bili.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bilibili.magicasakura.widgets.TintTextView;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import tv.danmaku.bili.widget.FlowLayout;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;

public class TagsView extends FlowLayout {
    private static final int KEY_POS = 1593835520;
    public static final int NO_POSITION = -1;
    private BaseTagAdapter mAdapter;
    private ImageView mCollapseView;
    private boolean mSelectable;
    private View mSelectedTagView;
    private int mTagBackground;
    private View.OnClickListener mTagClick;
    private OnTagSelectedListener mTagSelectedListener;
    private int mTextAppearance;
    private int mTextColor;
    private float weightDefault;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnCollapseClickListener extends View.OnClickListener {
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnTagSelectedListener {
        void onSelect(TagsView tagsView, int i);
    }

    public TagsView(Context context) {
        this(context, null);
    }

    public TagsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TagsView(Context context, AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);
        this.mSelectable = true;
        this.weightDefault = 1.0f;
        this.mTagClick = new View.OnClickListener() { // from class: tv.danmaku.bili.widget.TagsView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int pos = ((Integer) v.getTag(TagsView.KEY_POS)).intValue();
                if (TagsView.this.mSelectedTagView != null) {
                    TagsView.this.mSelectedTagView.setSelected(false);
                }
                if (TagsView.this.mSelectable) {
                    v.setSelected(true);
                    TagsView.this.mSelectedTagView = v;
                } else {
                    TagsView.this.mSelectedTagView = null;
                }
                if (TagsView.this.mTagSelectedListener != null) {
                    TagsView.this.mTagSelectedListener.onSelect(TagsView.this, pos);
                }
            }
        };
        setGravity(119);
        TypedArray a = context.obtainStyledAttributes(attributeSet, com.bilibili.lib.widget.R.styleable.TagsView);
        int collapseIcon = a.getResourceId(com.bilibili.lib.widget.R.styleable.TagsView_tagCollapseIcon, 0);
        this.mTagBackground = a.getResourceId(com.bilibili.lib.widget.R.styleable.TagsView_tagBackground, 0);
        this.weightDefault = a.getFloat(com.bilibili.lib.widget.R.styleable.TagsView_tagItemViewWeight, this.weightDefault);
        this.mTextAppearance = a.getResourceId(com.bilibili.lib.widget.R.styleable.TagsView_tagTextAppearance, com.bilibili.lib.widget.R.style.TextAppearance_App_Subtitle);
        a.recycle();
        setWeightDefault(this.weightDefault);
        if (collapseIcon != 0) {
            this.mCollapseView = new ImageView(context);
            this.mCollapseView.setImageResource(collapseIcon);
            this.mCollapseView.setClickable(true);
            this.mCollapseView.setPadding(getSpacing() / 2, 0, getSpacing() / 2, 0);
            this.mCollapseView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            FlowLayout.LayoutParams params = generateDefaultLayoutParams();
            params.weight = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
            addViewInLayout(this.mCollapseView, 0, params, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.widget.FlowLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l, int t, int r, int b) {
        for (int i = 0; i < this.lines.size(); i++) {
            FlowLayout.LineDefinition line = this.lines.get(i);
            for (int j = 0; j < line.viewCount; j++) {
                View child = line.views[j];
                FlowLayout.LayoutParams lp = (FlowLayout.LayoutParams) child.getLayoutParams();
                child.layout(lp.x + lp.leftMargin, lp.y + lp.topMargin, lp.x + lp.leftMargin + child.getMeasuredWidth(), lp.y + lp.topMargin + child.getMeasuredHeight());
            }
        }
    }

    public void setSelectedPosition(int position) {
        if (this.mSelectedTagView != null) {
            this.mSelectedTagView.setSelected(false);
        }
        for (int i = 0; i < getChildCount(); i++) {
            View v = getChildAt(i);
            Object tag = v.getTag(KEY_POS);
            if (tag != null && ((Integer) tag).intValue() == position) {
                this.mSelectedTagView = v;
                v.setSelected(true);
                return;
            }
        }
    }

    public int getSelectedPosition() {
        if (this.mSelectedTagView == null) {
            return -1;
        }
        return ((Integer) this.mSelectedTagView.getTag(KEY_POS)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.widget.FlowLayout
    public FlowLayout.LineDefinition lineOf(int index, int controlMaxLength) {
        TagLine line;
        if (index == 0 && this.mCollapseView != null) {
            if (this.lines.isEmpty()) {
                line = new TagLine();
                this.lines.add(line);
            } else {
                line = (TagLine) this.lines.get(index);
                line.reset();
            }
            line.maxLength = controlMaxLength;
            return line;
        }
        return super.lineOf(index, controlMaxLength);
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    class TagLine extends FlowLayout.LineDefinition {
        TagLine() {
            super();
        }

        @Override // tv.danmaku.bili.widget.FlowLayout.LineDefinition
        void addView(int i, View child) {
            FlowLayout.LayoutParams lp = (FlowLayout.LayoutParams) child.getLayoutParams();
            addInArray(i, child);
            this.lineLength = this.lineLengthWithSpacing + lp.getLength();
            this.lineLengthWithSpacing = this.lineLength + lp.getSpacingLength() + TagsView.this.getSpacing();
            this.lineThicknessWithSpacing = Math.max(this.lineThicknessWithSpacing, lp.getThickness() + lp.getSpacingThickness());
            this.lineThickness = Math.max(this.lineThickness, lp.getThickness());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // tv.danmaku.bili.widget.FlowLayout.LineDefinition
        public boolean canFit(View child) {
            int childLength;
            if (TagsView.this.mCollapseView == null || TagsView.this.mCollapseView != child) {
                if (TagsView.this.getOrientation() == 0) {
                    childLength = child.getMeasuredWidth();
                } else {
                    childLength = child.getMeasuredHeight();
                }
                return this.lineLengthWithSpacing + childLength <= this.maxLength;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // tv.danmaku.bili.widget.FlowLayout.LineDefinition
        public void calculateChildPosition() {
            if (TagsView.this.mCollapseView == null) {
                super.calculateChildPosition();
                return;
            }
            for (int iconPos = 0; iconPos < this.viewCount - 1; iconPos++) {
                if (this.views[iconPos] == TagsView.this.mCollapseView) {
                    View next = this.views[iconPos + 1];
                    this.views[iconPos + 1] = TagsView.this.mCollapseView;
                    this.views[iconPos] = next;
                }
            }
            int prevChildLength = 0;
            int maxChildThickness = this.lineThickness;
            for (int j = 0; j < this.viewCount; j++) {
                View child = this.views[j];
                FlowLayout.LayoutParams layoutParams = (FlowLayout.LayoutParams) child.getLayoutParams();
                maxChildThickness = Math.max(this.lineThickness, layoutParams.getThickness());
                layoutParams.setInlineStartLength(prevChildLength);
                prevChildLength += layoutParams.getLength() + layoutParams.getSpacingLength() + TagsView.this.getSpacing();
            }
            FlowLayout.LayoutParams collapseLp = (FlowLayout.LayoutParams) TagsView.this.mCollapseView.getLayoutParams();
            collapseLp.setThickness(maxChildThickness);
        }
    }

    public void setOnCollapseClickListener(OnCollapseClickListener l) {
        if (this.mCollapseView != null) {
            this.mCollapseView.setOnClickListener(l);
        }
    }

    void removeLinesInLayout(int start, int count) {
        if (count > this.lines.size()) {
            count = this.lines.size();
        }
        ListIterator<FlowLayout.LineDefinition> listIterator = this.lines.listIterator();
        for (int i = start; i < count && listIterator.hasNext(); i++) {
            FlowLayout.LineDefinition line = listIterator.next();
            line.reset();
            listIterator.remove();
        }
    }

    public void setTagsAdapter(BaseTagAdapter adapter) {
        if (this.mAdapter != adapter) {
            if (this.mAdapter != null) {
                if (this.mCollapseView == null) {
                    removeAllViewsInLayout();
                } else {
                    removeViewsInLayout(1, getChildCount() - 1);
                }
            }
            if (adapter == null) {
                if (this.mCollapseView == null) {
                    removeLinesInLayout(0, this.lines.size());
                } else {
                    removeLinesInLayout(1, this.lines.size());
                }
                this.mAdapter = null;
            } else {
                this.mAdapter = adapter;
                for (int i = 0; i < adapter.getCount(); i++) {
                    TextView tagView = adapter.getTagView(i, this);
                    tagView.setTag(KEY_POS, Integer.valueOf(i));
                    tagView.setOnClickListener(this.mTagClick);
                    tagView.setGravity(17);
                    if (this.mTextAppearance != 0) {
                        tagView.setTextAppearance(getContext(), this.mTextAppearance);
                    }
                    if (this.mTagBackground != 0) {
                        tagView.setBackgroundResource(this.mTagBackground);
                    }
                    if (this.mTextColor != 0) {
                        tagView.setTextColor(this.mTextColor);
                    }
                    ViewGroup.LayoutParams lp = tagView.getLayoutParams();
                    if (!(lp instanceof FlowLayout.LayoutParams)) {
                        lp = generateDefaultLayoutParams();
                    }
                    addViewInLayout(tagView, -1, lp, true);
                }
            }
            requestLayout();
            invalidate();
        }
    }

    public void setTagBackground(int tagBackgroundRes) {
        this.mTagBackground = tagBackgroundRes;
    }

    public void clearDefaultTextAppearance() {
        this.mTextAppearance = 0;
    }

    public void setTextColor(int mTextColor) {
        this.mTextColor = mTextColor;
    }

    public void setOnTagSelectedListener(OnTagSelectedListener l) {
        this.mTagSelectedListener = l;
    }

    public CharSequence getTagByPosition(int position) {
        if (this.mAdapter == null) {
            return null;
        }
        return this.mAdapter.getItem(position);
    }

    public Drawable getCollapseIcon() {
        return this.mCollapseView.getDrawable();
    }

    public ImageView getCollapseView() {
        return this.mCollapseView;
    }

    public void setTagSelectable(boolean selectable) {
        this.mSelectable = selectable;
        if (!this.mSelectable && this.mSelectedTagView != null) {
            this.mSelectedTagView.setSelected(false);
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static abstract class BaseTagAdapter<T> extends BaseAdapter {
        private List<T> mTags;

        public abstract CharSequence getTagName(T t);

        public BaseTagAdapter() {
            this.mTags = new ArrayList();
        }

        public BaseTagAdapter(List<T> tags) {
            if (tags == null || tags.isEmpty()) {
                this.mTags = new ArrayList();
            } else {
                this.mTags = tags;
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mTags.size();
        }

        @Override // android.widget.Adapter
        public CharSequence getItem(int position) {
            if (position >= this.mTags.size() || position < 0) {
                return null;
            }
            T item = this.mTags.get(position);
            return getTagName(item);
        }

        public T getItemData(int position) {
            if (position >= this.mTags.size() || position < 0) {
                return null;
            }
            return this.mTags.get(position);
        }

        public T getTag(int position) {
            if (this.mTags != null && position < this.mTags.size() && position >= 0) {
                return this.mTags.get(position);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int position) {
            return position;
        }

        @Override // android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            return getTagView(position, parent);
        }

        public TextView getTagView(int position, ViewGroup parent) {
            TintTextView text = new TintTextView(parent.getContext());
            text.setText(getItem(position));
            return text;
        }

        public void setTaglist(List<T> taglist) {
            this.mTags = taglist;
            notifyDataSetChanged();
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class TagsAdapter extends BaseTagAdapter {
        public TagsAdapter() {
        }

        public TagsAdapter(List<? extends CharSequence> tags) {
            super(tags);
        }

        @Override // tv.danmaku.bili.widget.TagsView.BaseTagAdapter
        public CharSequence getTagName(Object item) {
            return item.toString();
        }
    }
}