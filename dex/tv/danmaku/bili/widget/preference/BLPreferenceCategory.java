package tv.danmaku.bili.widget.preference;

import android.content.Context;
import android.util.AttributeSet;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceViewHolder;
import androidx.preference.R;

public class BLPreferenceCategory extends PreferenceCategory {
    private PreferenceRegulableHeightHelper mRegulableHelper;

    public BLPreferenceCategory(Context context) {
        this(context, null);
    }

    public BLPreferenceCategory(Context context, AttributeSet attrs) {
        this(context, attrs, TypedArrayUtils.getAttr(context, R.attr.preferenceCategoryStyle, 16842892));
    }

    public BLPreferenceCategory(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public BLPreferenceCategory(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this.mRegulableHelper = new PreferenceRegulableHeightHelper();
        this.mRegulableHelper.parse(context, attrs, defStyleAttr, defStyleRes);
    }

    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        this.mRegulableHelper.onBindViewHolder(this, holder);
    }

    protected boolean onPrepareAddPreference(Preference preference) {
        if (preference instanceof BLPreferenceCap) {
            BLPreferenceCap cap = (BLPreferenceCap) preference;
            if (cap.shouldHide()) {
                return false;
            }
        }
        return super.onPrepareAddPreference(preference);
    }
}