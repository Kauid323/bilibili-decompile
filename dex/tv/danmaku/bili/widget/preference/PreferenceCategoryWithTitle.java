package tv.danmaku.bili.widget.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceViewHolder;
import com.bilibili.lib.widget.R;
import tv.danmaku.android.util.AppBuildConfig;

public class PreferenceCategoryWithTitle extends PreferenceCategory {
    private Context mContext;
    private CharSequence mTitle;
    private int titleLayoutRes;

    public PreferenceCategoryWithTitle(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    public PreferenceCategoryWithTitle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public PreferenceCategoryWithTitle(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public PreferenceCategoryWithTitle(Context context) {
        super(context);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray attrArray = context.obtainStyledAttributes(attrs, R.styleable.CategoryWithTitle, 0, 0);
        this.mContext = context;
        if (attrArray == null) {
            return;
        }
        this.mTitle = attrArray.getString(R.styleable.CategoryWithTitle_categoryTitle);
        this.titleLayoutRes = AppBuildConfig.isHDApp(context) ? attrArray.getResourceId(R.styleable.CategoryWithTitle_textViewLayout, R.layout.layout_setting_title_hd) : attrArray.getResourceId(R.styleable.CategoryWithTitle_textViewLayout, R.layout.layout_setting_title);
        attrArray.recycle();
    }

    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        if (!TextUtils.isEmpty(this.mTitle) && (holder.itemView instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) holder.itemView;
            viewGroup.removeAllViews();
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            layoutParams.height = -2;
            TextView titleTv = (TextView) View.inflate(this.mContext, this.titleLayoutRes, null);
            viewGroup.addView(titleTv);
            titleTv.setText(this.mTitle);
        }
    }

    public void setTitle(CharSequence title) {
        if ((title == null && this.mTitle != null) || (title != null && !title.equals(this.mTitle))) {
            this.mTitle = title;
            notifyChanged();
        }
    }
}