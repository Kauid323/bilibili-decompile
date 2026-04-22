package tv.danmaku.bili.widget.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.bilibili.lib.ui.R;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;

public class PreferenceRegulableHeightHelper {
    private boolean mEnableRegulable = false;
    private float mFillHeight;
    private int mLeftOffset;
    private int mRightOffset;
    private float mWrapHeight;

    public void parse(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RegulablePreference, defStyleAttr, defStyleRes);
        this.mEnableRegulable = a.getBoolean(R.styleable.RegulablePreference_regulable, false);
        float defaultWrapHeight = context.getResources().getDimension(R.dimen.preference_regulable_wrap_height_default);
        this.mWrapHeight = a.getDimension(R.styleable.RegulablePreference_wrapHeight, defaultWrapHeight);
        float defaultFillHeight = context.getResources().getDimension(R.dimen.preference_regulable_fill_height_default);
        this.mFillHeight = a.getDimension(R.styleable.RegulablePreference_fillHeight, defaultFillHeight);
        this.mLeftOffset = (int) a.getDimension(R.styleable.RegulablePreference_leftOffset, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        this.mRightOffset = (int) a.getDimension(R.styleable.RegulablePreference_rightOffset, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        a.recycle();
    }

    public void onBindViewHolder(Preference preference, PreferenceViewHolder holder) {
        if (!this.mEnableRegulable) {
            return;
        }
        boolean hasTitle = !TextUtils.isEmpty(preference.getTitle());
        boolean hasSummary = !TextUtils.isEmpty(preference.getSummary());
        if (hasTitle && hasSummary) {
            holder.itemView.setMinimumHeight((int) this.mFillHeight);
        } else {
            holder.itemView.setMinimumHeight((int) this.mWrapHeight);
        }
        if (this.mLeftOffset > 0 || this.mRightOffset > 0) {
            int paddingLeft = this.mLeftOffset > 0 ? this.mLeftOffset : holder.itemView.getPaddingLeft();
            int paddingRight = this.mRightOffset > 0 ? this.mRightOffset : holder.itemView.getPaddingRight();
            int paddingTop = holder.itemView.getPaddingTop();
            int paddingBottom = holder.itemView.getPaddingBottom();
            holder.itemView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void setLeftOffset(int leftOffset) {
        this.mLeftOffset = leftOffset;
    }

    public int getLeftOffset() {
        return this.mLeftOffset;
    }

    public void setRightOffset(int rightOffset) {
        this.mRightOffset = rightOffset;
    }

    public int getRightOffset() {
        return this.mRightOffset;
    }
}