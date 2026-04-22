package tv.danmaku.bili.widget.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import java.util.Map;
import tv.danmaku.bili.widget.R;

public class BLRadioGroupEntrancePreference extends BLPreference {
    private String mDefaultRadioValue;
    private CharSequence[] mRadioEntries;
    private CharSequence[] mRadioEntrySummaries;
    private CharSequence[] mRadioEntryValues;

    public BLRadioGroupEntrancePreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPreference(context, attrs);
    }

    public BLRadioGroupEntrancePreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initPreference(context, attrs);
    }

    private void initPreference(Context context, AttributeSet attrs) {
        TypedArray attrArray = context.obtainStyledAttributes(attrs, R.styleable.RadioGroupPreference, 0, 0);
        if (attrArray == null) {
            return;
        }
        this.mDefaultRadioValue = attrArray.getString(R.styleable.RadioGroupPreference_radioDefaultValue);
        this.mRadioEntries = attrArray.getTextArray(R.styleable.RadioGroupPreference_radioEntries);
        this.mRadioEntryValues = attrArray.getTextArray(R.styleable.RadioGroupPreference_radioEntryValues);
        this.mRadioEntrySummaries = attrArray.getTextArray(R.styleable.RadioGroupPreference_radioEntrySummaries);
        attrArray.recycle();
    }

    public void setRadioEntryMap(Map<CharSequence, CharSequence> entryMap) {
        this.mRadioEntries = (CharSequence[]) entryMap.keySet().toArray(new CharSequence[0]);
        this.mRadioEntryValues = (CharSequence[]) entryMap.values().toArray(new CharSequence[0]);
    }

    public CharSequence getSummary() {
        String value = getPersistedString(this.mDefaultRadioValue);
        return findSummary(value);
    }

    private CharSequence findSummary(String value) {
        if (value == null || this.mRadioEntryValues == null || (this.mRadioEntrySummaries == null && this.mRadioEntries == null)) {
            return null;
        }
        int pos = -1;
        int index = 0;
        while (true) {
            if (index >= this.mRadioEntryValues.length) {
                break;
            } else if (!TextUtils.equals(value, this.mRadioEntryValues[index])) {
                index++;
            } else {
                pos = index;
                break;
            }
        }
        if (pos < 0) {
            return null;
        }
        String result = null;
        if (this.mRadioEntrySummaries != null && pos < this.mRadioEntrySummaries.length && this.mRadioEntrySummaries[pos] != null) {
            result = this.mRadioEntrySummaries[pos].toString();
        }
        if (result == null && this.mRadioEntries != null && pos < this.mRadioEntries.length && this.mRadioEntries[pos] != null) {
            return this.mRadioEntries[pos].toString();
        }
        return result;
    }
}