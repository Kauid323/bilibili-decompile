package tv.danmaku.bili.widget.preference;

import android.content.Context;
import android.util.AttributeSet;
import androidx.preference.CheckBoxPreference;
import com.bilibili.lib.widget.R;

public class RadioButtonPreference extends CheckBoxPreference {
    private String mRadioValue;

    public RadioButtonPreference(Context context) {
        super(context);
        initPreference();
    }

    public RadioButtonPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPreference();
    }

    public RadioButtonPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initPreference();
    }

    private final void initPreference() {
        setWidgetLayoutResource(R.layout.bili_view_preference_radio_button);
    }

    public void setRadioValue(String radioValue) {
        this.mRadioValue = radioValue;
    }

    public String getRadioValue() {
        return this.mRadioValue;
    }
}