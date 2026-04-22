package tv.danmaku.bili.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import tv.danmaku.biliplayerimpl.toast.left.viewholder.ActionMessageWithAnimationVH;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

public class FlowLayout extends ViewGroup {
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    private int gravity;
    protected List<LineDefinition> lines;
    private int maxLines;
    private int orientation;
    private boolean singleLine;
    private int spacing;
    private float weightDefault;

    public FlowLayout(Context context) {
        this(context, null);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);
        this.orientation = 0;
        this.weightDefault = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        this.gravity = 119;
        this.lines = new ArrayList();
        TypedArray a = context.obtainStyledAttributes(attributeSet, com.bilibili.lib.widget.R.styleable.FlowLayout);
        try {
            this.orientation = a.getInteger(com.bilibili.lib.widget.R.styleable.FlowLayout_forientation, this.orientation);
            this.weightDefault = a.getFloat(com.bilibili.lib.widget.R.styleable.FlowLayout_weightDefault, this.weightDefault);
            this.gravity = a.getInteger(com.bilibili.lib.widget.R.styleable.FlowLayout_android_gravity, this.gravity);
            this.spacing = a.getDimensionPixelSize(com.bilibili.lib.widget.R.styleable.FlowLayout_spacing, 0);
            this.singleLine = a.getBoolean(com.bilibili.lib.widget.R.styleable.FlowLayout_singleLine, false);
            if (this.singleLine) {
                this.maxLines = 1;
            } else {
                this.maxLines = a.getInteger(com.bilibili.lib.widget.R.styleable.FlowLayout_maxLines, ActionMessageWithAnimationVH.INVALID_COLOR_INT);
            }
            if (this.singleLine && this.orientation != 0) {
                this.orientation = 0;
            }
        } finally {
            a.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int totalControlWidth;
        int totalControlHeight;
        int modeWidth;
        int modeHeight;
        int sizeWidth = (View.MeasureSpec.getSize(widthMeasureSpec) - getPaddingRight()) - getPaddingLeft();
        int sizeHeight = (View.MeasureSpec.getSize(heightMeasureSpec) - getPaddingTop()) - getPaddingBottom();
        int modeWidth2 = View.MeasureSpec.getMode(widthMeasureSpec);
        int modeHeight2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int controlMaxLength = getOrientation() == 0 ? sizeWidth : sizeHeight;
        int controlMaxThickness = getOrientation() == 0 ? sizeHeight : sizeWidth;
        int modeLength = getOrientation() == 0 ? modeWidth2 : modeHeight2;
        int modeThickness = getOrientation() == 0 ? modeHeight2 : modeWidth2;
        int lineIndex = 0;
        LineDefinition currentLine = lineOf(0, controlMaxLength);
        int count = getChildCount();
        int i = 0;
        while (i < count) {
            View child = getChildAt(i);
            int sizeWidth2 = sizeWidth;
            int sizeHeight2 = sizeHeight;
            if (child.getVisibility() == 8) {
                modeWidth = modeWidth2;
                modeHeight = modeHeight2;
            } else {
                LayoutParams lp = (LayoutParams) child.getLayoutParams();
                modeWidth = modeWidth2;
                modeHeight = modeHeight2;
                child.measure(getChildMeasureSpec(widthMeasureSpec, getPaddingLeft() + getPaddingRight(), lp.width), getChildMeasureSpec(heightMeasureSpec, getPaddingTop() + getPaddingBottom(), lp.height));
                lp.clearCalculatedFields(getOrientation());
                if (getOrientation() == 0) {
                    lp.setLength(child.getMeasuredWidth());
                    lp.setThickness(child.getMeasuredHeight());
                } else {
                    lp.setLength(child.getMeasuredHeight());
                    lp.setThickness(child.getMeasuredWidth());
                }
                boolean newLine = lp.newLine || !(modeLength == 0 || currentLine.canFit(child));
                if (newLine) {
                    if (lineIndex == this.maxLines - 1) {
                        break;
                    }
                    lineIndex++;
                    currentLine = lineOf(lineIndex, controlMaxLength);
                }
                currentLine.addView(child);
            }
            i++;
            sizeWidth = sizeWidth2;
            sizeHeight = sizeHeight2;
            modeWidth2 = modeWidth;
            modeHeight2 = modeHeight;
        }
        while (lineIndex < this.lines.size() - 1) {
            this.lines.remove(this.lines.size() - 1);
        }
        calculateLinesAndChildPosition(this.lines);
        int contentLength = 0;
        int linesCount = this.lines.size();
        for (int i2 = 0; i2 < linesCount; i2++) {
            LineDefinition l = this.lines.get(i2);
            contentLength = Math.max(contentLength, l.getLineLength());
        }
        int i3 = currentLine.getLineStartThickness();
        int contentThickness = i3 + currentLine.getLineThickness();
        int realControlLength = findSize(modeLength, controlMaxLength, contentLength);
        int realControlThickness = findSize(modeThickness, controlMaxThickness, contentThickness);
        applyGravityToLines(this.lines, realControlLength, realControlThickness);
        int i4 = 0;
        while (i4 < linesCount) {
            int linesCount2 = linesCount;
            LineDefinition line = this.lines.get(i4);
            if (currentLine != line) {
                applyGravityToLine(line);
            }
            applyPositionsToViews(line);
            i4++;
            linesCount = linesCount2;
        }
        int totalControlWidth2 = getPaddingLeft() + getPaddingRight();
        int totalControlHeight2 = getPaddingBottom() + getPaddingTop();
        if (getOrientation() == 0) {
            totalControlWidth = totalControlWidth2 + contentLength;
            totalControlHeight = totalControlHeight2 + contentThickness;
        } else {
            totalControlWidth = totalControlWidth2 + contentThickness;
            totalControlHeight = totalControlHeight2 + contentLength;
        }
        int contentLength2 = resolveSize(totalControlWidth, widthMeasureSpec);
        setMeasuredDimension(contentLength2, resolveSize(totalControlHeight, heightMeasureSpec));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LineDefinition lineOf(int index, int controlMaxLength) {
        LineDefinition line;
        if (index < this.lines.size()) {
            line = this.lines.get(index);
            line.reset();
        } else {
            line = new LineDefinition();
            this.lines.add(line);
        }
        line.maxLength = controlMaxLength;
        return line;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int findSize(int modeSize, int controlMaxSize, int contentSize) {
        switch (modeSize) {
            case Integer.MIN_VALUE:
                int realControlLength = Math.min(contentSize, controlMaxSize);
                return realControlLength;
            case 0:
                return contentSize;
            case 1073741824:
                return controlMaxSize;
            default:
                return contentSize;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void calculateLinesAndChildPosition(List<LineDefinition> lines) {
        int prevLinesThickness = 0;
        int linesCount = lines.size();
        for (int i = 0; i < linesCount; i++) {
            LineDefinition line = lines.get(i);
            line.addLineStartThickness(prevLinesThickness);
            prevLinesThickness += line.getLineThickness() + getSpacing();
            line.calculateChildPosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyPositionsToViews(LineDefinition line) {
        for (int i = 0; i < line.viewCount; i++) {
            View child = line.views[i];
            LayoutParams layoutParams = (LayoutParams) child.getLayoutParams();
            if (getOrientation() == 0) {
                layoutParams.setPosition(getPaddingLeft() + line.getLineStartLength() + layoutParams.getInlineStartLength(), getPaddingTop() + line.getLineStartThickness() + layoutParams.getInlineStartThickness());
                child.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.getLength(), 1073741824), View.MeasureSpec.makeMeasureSpec(layoutParams.getThickness(), 1073741824));
            } else {
                layoutParams.setPosition(getPaddingLeft() + line.getLineStartThickness() + layoutParams.getInlineStartThickness(), getPaddingTop() + line.getLineStartLength() + layoutParams.getInlineStartLength());
                child.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.getThickness(), 1073741824), View.MeasureSpec.makeMeasureSpec(layoutParams.getLength(), 1073741824));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyGravityToLines(List<LineDefinition> lines, int realControlLength, int realControlThickness) {
        List<LineDefinition> list = lines;
        int linesCount = lines.size();
        if (linesCount <= 0) {
            return;
        }
        LineDefinition lastLine = list.get(linesCount - 1);
        int excessThickness = realControlThickness - (lastLine.getLineThickness() + lastLine.getLineStartThickness());
        int excessOffset = 0;
        int i = 0;
        while (i < linesCount) {
            LineDefinition child = list.get(i);
            int gravity = getGravity();
            int extraThickness = (excessThickness * 1) / linesCount;
            int childLength = child.getLineLength();
            int childThickness = child.getLineThickness();
            Rect container = new Rect();
            container.top = excessOffset;
            container.left = 0;
            container.right = realControlLength;
            container.bottom = childThickness + extraThickness + excessOffset;
            Rect result = new Rect();
            Gravity.apply(gravity, childLength, childThickness, container, result);
            excessOffset += extraThickness;
            child.addLineStartLength(result.left);
            child.addLineStartThickness(result.top);
            child.setLength(result.width());
            child.setThickness(result.height());
            i++;
            list = lines;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyGravityToLine(LineDefinition line) {
        FlowLayout flowLayout = this;
        LineDefinition lineDefinition = line;
        int viewCount = lineDefinition.viewCount;
        if (viewCount <= 0) {
            return;
        }
        float totalWeight = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        for (int i = 0; i < viewCount; i++) {
            View prev = lineDefinition.views[i];
            LayoutParams plp = (LayoutParams) prev.getLayoutParams();
            totalWeight += flowLayout.getWeight(plp);
        }
        View lastChild = lineDefinition.views[viewCount - 1];
        LayoutParams lastChildLayoutParams = (LayoutParams) lastChild.getLayoutParams();
        int excessLength = line.getLineLength() - (lastChildLayoutParams.getLength() + lastChildLayoutParams.getInlineStartLength());
        int excessOffset = 0;
        int i2 = 0;
        while (i2 < viewCount) {
            View child = lineDefinition.views[i2];
            LayoutParams layoutParams = (LayoutParams) child.getLayoutParams();
            float weight = flowLayout.getWeight(layoutParams);
            int gravity = flowLayout.getGravity(layoutParams);
            int extraLength = (int) ((excessLength * weight) / totalWeight);
            int childLength = layoutParams.getLength() + layoutParams.getSpacingLength();
            int childThickness = layoutParams.getThickness() + layoutParams.getSpacingThickness();
            Rect container = new Rect();
            container.top = 0;
            container.left = excessOffset;
            container.right = childLength + extraLength + excessOffset;
            container.bottom = line.getLineThickness();
            Rect result = new Rect();
            Gravity.apply(gravity, childLength, childThickness, container, result);
            excessOffset += extraLength;
            layoutParams.setInlineStartLength(result.left + layoutParams.getInlineStartLength());
            layoutParams.setInlineStartThickness(result.top);
            layoutParams.setLength(result.width() - layoutParams.getSpacingLength());
            layoutParams.setThickness(result.height() - layoutParams.getSpacingThickness());
            i2++;
            flowLayout = this;
            lineDefinition = line;
        }
    }

    private int getGravity(LayoutParams lp) {
        return lp.gravitySpecified() ? lp.gravity : getGravity();
    }

    private float getWeight(LayoutParams lp) {
        return lp.weightSpecified() ? lp.weight : getWeightDefault();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l, int t, int r, int b) {
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            LayoutParams lp = (LayoutParams) child.getLayoutParams();
            child.layout(lp.x + lp.leftMargin, lp.y + lp.topMargin, lp.x + lp.leftMargin + child.getMeasuredWidth(), lp.y + lp.topMargin + child.getMeasuredHeight());
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof LayoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return generateLayoutParams(-2, -2);
    }

    protected LayoutParams generateLayoutParams(int width, int height) {
        return new LayoutParams(width, height);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return new LayoutParams(p);
    }

    public int getOrientation() {
        return this.orientation;
    }

    public void setOrientation(int orientation) {
        if (this.orientation != orientation) {
            this.orientation = orientation;
            requestLayout();
            invalidate();
        }
    }

    public float getWeightDefault() {
        return this.weightDefault;
    }

    public void setWeightDefault(float weightDefault) {
        this.weightDefault = weightDefault;
        requestLayout();
        invalidate();
    }

    public int getGravity() {
        return this.gravity;
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
        requestLayout();
        invalidate();
    }

    public int getSpacing() {
        return this.spacing;
    }

    public void setSpacing(int spacing) {
        if (this.spacing != spacing) {
            this.spacing = spacing;
            requestLayout();
            invalidate();
        }
    }

    public void setMaxLines(int lines) {
        this.maxLines = lines;
        requestLayout();
        invalidate();
    }

    public int getMaxLines() {
        return this.maxLines;
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        @ViewDebug.ExportedProperty(mapping = {@ViewDebug.IntToString(from = 0, to = "NONE"), @ViewDebug.IntToString(from = PlayerToastConfig.QUEUE_INSERT, to = "TOP"), @ViewDebug.IntToString(from = 80, to = "BOTTOM"), @ViewDebug.IntToString(from = 3, to = "LEFT"), @ViewDebug.IntToString(from = 5, to = "RIGHT"), @ViewDebug.IntToString(from = 16, to = "CENTER_VERTICAL"), @ViewDebug.IntToString(from = 112, to = "FILL_VERTICAL"), @ViewDebug.IntToString(from = 1, to = "CENTER_HORIZONTAL"), @ViewDebug.IntToString(from = 7, to = "FILL_HORIZONTAL"), @ViewDebug.IntToString(from = 17, to = "CENTER"), @ViewDebug.IntToString(from = 119, to = "FILL")})
        public int gravity;
        private int inlineStartLength;
        private int inlineStartThickness;
        private int length;
        public boolean newLine;
        private int spacingLength;
        private int spacingThickness;
        private int thickness;
        public float weight;
        public int x;
        public int y;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.newLine = false;
            this.gravity = 0;
            this.weight = -1.0f;
            readStyleParameters(context, attributeSet);
        }

        public LayoutParams(int width, int height) {
            super(width, height);
            this.newLine = false;
            this.gravity = 0;
            this.weight = -1.0f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.newLine = false;
            this.gravity = 0;
            this.weight = -1.0f;
        }

        public boolean gravitySpecified() {
            return this.gravity != 0;
        }

        public boolean weightSpecified() {
            return this.weight >= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        }

        private void readStyleParameters(Context context, AttributeSet attributeSet) {
            TypedArray a = context.obtainStyledAttributes(attributeSet, com.bilibili.lib.widget.R.styleable.FlowLayout_LayoutParams);
            try {
                this.newLine = a.getBoolean(com.bilibili.lib.widget.R.styleable.FlowLayout_LayoutParams_layout_newLine, false);
                this.gravity = a.getInt(com.bilibili.lib.widget.R.styleable.FlowLayout_LayoutParams_android_layout_gravity, 0);
                this.weight = a.getFloat(com.bilibili.lib.widget.R.styleable.FlowLayout_LayoutParams_layout_weight, -1.0f);
            } finally {
                a.recycle();
            }
        }

        void setPosition(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getInlineStartLength() {
            return this.inlineStartLength;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setInlineStartLength(int inlineStartLength) {
            this.inlineStartLength = inlineStartLength;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getLength() {
            return this.length;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setLength(int length) {
            this.length = length;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getThickness() {
            return this.thickness;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setThickness(int thickness) {
            this.thickness = thickness;
        }

        int getInlineStartThickness() {
            return this.inlineStartThickness;
        }

        void setInlineStartThickness(int inlineStartThickness) {
            this.inlineStartThickness = inlineStartThickness;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getSpacingLength() {
            return this.spacingLength;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getSpacingThickness() {
            return this.spacingThickness;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void clearCalculatedFields(int orientation) {
            if (orientation == 0) {
                this.spacingLength = this.leftMargin + this.rightMargin;
                this.spacingThickness = this.topMargin + this.bottomMargin;
                return;
            }
            this.spacingLength = this.topMargin + this.bottomMargin;
            this.spacingThickness = this.leftMargin + this.rightMargin;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public class LineDefinition {
        int lineLength;
        int lineLengthWithSpacing;
        int lineThickness;
        int lineThicknessWithSpacing;
        int maxLength;
        public int viewCount = 0;
        public View[] views = new View[4];
        int lineStartThickness = 0;
        int lineStartLength = 0;

        public LineDefinition() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void addView(View child) {
            addView(this.viewCount, child);
        }

        void addView(int i, View child) {
            LayoutParams lp = (LayoutParams) child.getLayoutParams();
            addInArray(i, child);
            this.lineLength = this.lineLengthWithSpacing + lp.getLength();
            this.lineLengthWithSpacing = this.lineLength + lp.getSpacingLength() + FlowLayout.this.getSpacing();
            this.lineThicknessWithSpacing = Math.max(this.lineThicknessWithSpacing, lp.getThickness() + lp.getSpacingThickness());
            this.lineThickness = Math.max(this.lineThickness, lp.getThickness());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void addInArray(int index, View child) {
            View[] children = this.views;
            int count = this.viewCount;
            int size = children.length;
            if (index == count) {
                if (size == count) {
                    this.views = new View[size + 4];
                    System.arraycopy(children, 0, this.views, 0, size);
                    children = this.views;
                }
                int i = this.viewCount;
                this.viewCount = i + 1;
                children[i] = child;
            } else if (index < count) {
                if (size == count) {
                    this.views = new View[size + 4];
                    System.arraycopy(children, 0, this.views, 0, index);
                    System.arraycopy(children, index, this.views, index + 1, count - index);
                    children = this.views;
                } else {
                    System.arraycopy(children, index, children, index + 1, count - index);
                }
                children[index] = child;
                this.viewCount++;
            } else {
                throw new IndexOutOfBoundsException("index=" + index + " count=" + count);
            }
        }

        void remove(View item) {
            for (int index = 0; index < this.views.length; index++) {
                if (item == this.views[index]) {
                    this.views[index] = null;
                    this.viewCount--;
                    LayoutParams lp = (LayoutParams) item.getLayoutParams();
                    this.lineLength -= lp.getLength();
                    this.lineLengthWithSpacing = (this.lineLengthWithSpacing - lp.getSpacingLength()) - FlowLayout.this.getSpacing();
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean canFit(View child) {
            int childLength;
            if (FlowLayout.this.getOrientation() == 0) {
                childLength = child.getMeasuredWidth();
            } else {
                childLength = child.getMeasuredHeight();
            }
            return this.lineLengthWithSpacing + childLength <= this.maxLength;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getLineStartThickness() {
            return this.lineStartThickness;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getLineThickness() {
            return this.lineThicknessWithSpacing;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getLineLength() {
            return this.lineLength;
        }

        int getLineStartLength() {
            return this.lineStartLength;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void reset() {
            this.viewCount = 0;
            Arrays.fill(this.views, (Object) null);
            this.lineLengthWithSpacing = 0;
            this.lineLength = 0;
            this.lineThicknessWithSpacing = 0;
            this.lineThickness = 0;
            this.lineStartLength = 0;
            this.lineStartThickness = 0;
        }

        void setThickness(int thickness) {
            int thicknessSpacing = this.lineThicknessWithSpacing - this.lineThickness;
            this.lineThicknessWithSpacing = thickness;
            this.lineThickness = thickness - thicknessSpacing;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setLength(int length) {
            int lengthSpacing = this.lineLengthWithSpacing - this.lineLength;
            this.lineLength = length;
            this.lineLengthWithSpacing = length + lengthSpacing;
        }

        public void setMaxLength(int maxLength) {
            this.maxLength = maxLength;
        }

        void addLineStartThickness(int extraLineStartThickness) {
            this.lineStartThickness += extraLineStartThickness;
        }

        void addLineStartLength(int extraLineStartLength) {
            this.lineStartLength += extraLineStartLength;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void calculateChildPosition() {
            int prevChildLength = 0;
            for (int j = 0; j < this.viewCount; j++) {
                View child = this.views[j];
                LayoutParams layoutParams = (LayoutParams) child.getLayoutParams();
                layoutParams.setInlineStartLength(prevChildLength);
                prevChildLength += layoutParams.getLength() + layoutParams.getSpacingLength() + FlowLayout.this.getSpacing();
            }
        }
    }
}