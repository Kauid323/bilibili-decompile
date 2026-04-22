package tv.danmaku.bili.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.bilibili.magicasakura.widgets.TintTextView;
import java.util.ArrayList;
import java.util.List;

public class FlowTagView extends FlowLayout {
    private OnTagClickListener mOnTagClickListener;
    private int mTagBackground;
    private List<String> mTags;
    private int mTextAppearance;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnTagClickListener {
        void onClick(String str);
    }

    public FlowTagView(Context context) {
        super(context);
        this.mTags = new ArrayList();
        initViews(context, null);
    }

    public FlowTagView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTags = new ArrayList();
        initViews(context, attributeSet);
    }

    public FlowTagView(Context context, AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);
        this.mTags = new ArrayList();
        initViews(context, attributeSet);
    }

    private void initViews(Context context, AttributeSet attributeSet) {
        TypedArray a = context.obtainStyledAttributes(attributeSet, R.styleable.FlowTagView);
        this.mTagBackground = a.getResourceId(R.styleable.FlowTagView_flowTagBackground, 0);
        this.mTextAppearance = a.getResourceId(R.styleable.FlowTagView_flowTagTextAppearance, com.bilibili.lib.widget.R.style.TextAppearance_App_Body);
        a.recycle();
        int itemSpace = (int) context.getResources().getDimension(com.bilibili.app.comm.baseres.R.dimen.item_half_spacing);
        setSpacing(itemSpace);
    }

    public void setTags(List<String> tags) {
        if (tags != null) {
            this.mTags.clear();
            this.mTags.addAll(tags);
        }
        removeAllViews();
        addViews();
    }

    private void addViews() {
        for (String tag : this.mTags) {
            if (!TextUtils.isEmpty(tag)) {
                addView(generateItem(tag));
            }
        }
    }

    private View generateItem(String tag) {
        final TintTextView tintTextView = new TintTextView(getContext());
        tintTextView.setText(tag);
        tintTextView.setGravity(17);
        if (this.mTextAppearance != 0) {
            tintTextView.setTextAppearance(getContext(), this.mTextAppearance);
        }
        if (this.mTagBackground != 0) {
            tintTextView.setBackgroundResource(this.mTagBackground);
        }
        if (this.mOnTagClickListener != null) {
            tintTextView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.widget.FlowTagView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    FlowTagView.this.mOnTagClickListener.onClick(String.valueOf(tintTextView.getText()));
                }
            });
        }
        return tintTextView;
    }

    public void setOnTagClickListener(OnTagClickListener onTagClickListener) {
        this.mOnTagClickListener = onTagClickListener;
    }
}