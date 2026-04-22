package tv.danmaku.bili.widget.preference;

import android.content.Context;
import android.util.AttributeSet;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import androidx.preference.R;

public class BLPreference extends Preference {
    private PreferenceRegulableHeightHelper mRegulableHelper;

    public BLPreference(Context context) {
        this(context, null);
    }

    public BLPreference(Context context, AttributeSet attrs) {
        this(context, attrs, TypedArrayUtils.getAttr(context, R.attr.preferenceStyle, 16842894));
    }

    public BLPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public BLPreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
}