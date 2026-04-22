package tv.danmaku.bili.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.preference.CheckBoxPreference;
import androidx.preference.PreferenceViewHolder;
import tv.danmaku.bili.widget.preference.PreferenceRegulableHeightHelper;
import tv.danmaku.bili.widget.preference.TypedArrayUtils;

public class RadioButtonPreference extends CheckBoxPreference {
    private String mRadioValue;
    private PreferenceRegulableHeightHelper mRegulableHelper;

    public RadioButtonPreference(Context context) {
        super(context);
        initPreference(context, null, TypedArrayUtils.getAttr(context, androidx.preference.R.attr.checkBoxPreferenceStyle, 16842895), 0);
    }

    public RadioButtonPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPreference(context, attrs, TypedArrayUtils.getAttr(context, androidx.preference.R.attr.checkBoxPreferenceStyle, 16842895), 0);
    }

    public RadioButtonPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initPreference(context, attrs, defStyle, 0);
    }

    private final void initPreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        setWidgetLayoutResource(com.bilibili.lib.widget.R.layout.bili_view_preference_radio_button);
        this.mRegulableHelper = new PreferenceRegulableHeightHelper();
        this.mRegulableHelper.parse(context, attrs, defStyleAttr, defStyleRes);
    }

    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        this.mRegulableHelper.onBindViewHolder(this, holder);
    }

    public void setRadioValue(String radioValue) {
        this.mRadioValue = radioValue;
    }

    public String getRadioValue() {
        return this.mRadioValue;
    }

    public void setLeftOffset(int leftOffset) {
        this.mRegulableHelper.setLeftOffset(leftOffset);
    }

    public int getLeftOffset() {
        return this.mRegulableHelper.getLeftOffset();
    }

    public void setRightOffset(int rightOffset) {
        this.mRegulableHelper.setRightOffset(rightOffset);
    }

    public int getRightOffset() {
        return this.mRegulableHelper.getRightOffset();
    }
}