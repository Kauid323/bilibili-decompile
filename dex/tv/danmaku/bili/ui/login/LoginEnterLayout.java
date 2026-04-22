package tv.danmaku.bili.ui.login;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import bili.resource.homepage.R;

public class LoginEnterLayout extends LinearLayout implements View.OnClickListener {
    private static final int HEIGHT_DIVIDER_LINE = 12;
    public static final int ID_VIEW_QUICK = 1002;
    public static final int ID_VIEW_SMS = 1001;
    private static final int MARGIN_DIVIDER_LINE = 16;
    public static final int MODE_QUICK = 1;
    public static final int MODE_SMS = 0;
    public static final int MODE_SMS_QUICK = 2;
    private static final int TEXT_SIZE = 12;
    private static final int WIDTH_DIVIDER_LINE = 1;
    private OnItemClickListener mOnItemClickListener;

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    interface OnItemClickListener {
        void onClick(int i);
    }

    public LoginEnterLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOrientation(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case 1001:
                if (this.mOnItemClickListener != null) {
                    this.mOnItemClickListener.onClick(1001);
                    return;
                }
                return;
            case 1002:
                if (this.mOnItemClickListener != null) {
                    this.mOnItemClickListener.onClick(1002);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void update(boolean quickLoginEnable, boolean smsLoginEnable) {
        if (quickLoginEnable && smsLoginEnable) {
            setMode(2);
        } else if (quickLoginEnable) {
            setMode(1);
        } else if (smsLoginEnable) {
            setMode(0);
        } else {
            setVisibility(8);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    private void setMode(int mode) {
        switch (mode) {
            case 0:
                addView(createText(R.string.homepage_global_string_304, 12.0f, 1001, com.bilibili.app.comm.baseres.R.drawable.ic_arrow_right_gray, this));
                return;
            case 1:
                addView(createText(R.string.homepage_global_string_292, 12.0f, 1002, com.bilibili.app.comm.baseres.R.drawable.ic_arrow_right_gray, this));
                return;
            case 2:
                View view = new View(getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dp2px(getContext(), 1.0f), dp2px(getContext(), 12.0f));
                layoutParams.leftMargin = dp2px(getContext(), 16.0f);
                layoutParams.rightMargin = dp2px(getContext(), 16.0f);
                layoutParams.gravity = 16;
                view.setBackgroundColor(getContext().getResources().getColor(com.bilibili.app.comm.baseres.R.color.gray_dark));
                view.setLayoutParams(layoutParams);
                addView(createText(R.string.homepage_global_string_292, 12.0f, 1002, 0, this));
                addView(view);
                addView(createText(R.string.homepage_global_string_304, 12.0f, 1001, 0, this));
                return;
            default:
                return;
        }
    }

    private TextView createText(int StrId, float tSize, int viewId, int rightDrawableResId, View.OnClickListener l) {
        TextView tv2 = new TextView(getContext());
        tv2.setText(StrId);
        tv2.setId(viewId);
        tv2.setTextSize(tSize);
        tv2.setOnClickListener(l);
        tv2.setTextColor(getContext().getResources().getColor(17170443));
        if (rightDrawableResId != 0) {
            tv2.setCompoundDrawablePadding(dp2px(getContext(), 4.0f));
            Drawable drawable = getContext().getResources().getDrawable(rightDrawableResId);
            drawable.setColorFilter(ContextCompat.getColor(getContext(), 17170443), PorterDuff.Mode.SRC_IN);
            tv2.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        }
        return tv2;
    }

    private int dp2px(Context context, float dp) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) ((dp * scale) + 0.5f);
    }
}