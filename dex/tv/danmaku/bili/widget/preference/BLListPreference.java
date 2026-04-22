package tv.danmaku.bili.widget.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import tv.danmaku.bili.widget.R;
import tv.danmaku.biliplayerimpl.toast.left.viewholder.ActionMessageWithAnimationVH;

public class BLListPreference extends ListPreference implements BLPreferenceCap {
    private CharSequence[] mBLEntryShouldDisableDependentOnValues;
    private CharSequence[] mBLEntrySummaries;
    private boolean mDisableDependent;
    private int mMaxApi;
    private int mMinApi;
    private boolean mShouldHideWhenDisabled;

    public BLListPreference(Context context) {
        super(context);
        this.mMinApi = Integer.MIN_VALUE;
        this.mMaxApi = ActionMessageWithAnimationVH.INVALID_COLOR_INT;
        this.mShouldHideWhenDisabled = Boolean.FALSE.booleanValue();
        this.mDisableDependent = false;
        initPreference(context, null);
    }

    public BLListPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mMinApi = Integer.MIN_VALUE;
        this.mMaxApi = ActionMessageWithAnimationVH.INVALID_COLOR_INT;
        this.mShouldHideWhenDisabled = Boolean.FALSE.booleanValue();
        this.mDisableDependent = false;
        initPreference(context, attrs);
    }

    private final void initPreference(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.BLListPreference, 0, 0);
        if (a == null) {
            return;
        }
        this.mBLEntrySummaries = a.getTextArray(R.styleable.BLListPreference_blEntrySummaries);
        this.mBLEntryShouldDisableDependentOnValues = a.getTextArray(R.styleable.BLListPreference_blEntryShouldDisableDependentsOnValues);
        this.mMinApi = a.getInteger(R.styleable.BLListPreference_blMinApi, Integer.MIN_VALUE);
        this.mMaxApi = a.getInteger(R.styleable.BLListPreference_blMaxApi, ActionMessageWithAnimationVH.INVALID_COLOR_INT);
        this.mShouldHideWhenDisabled = a.getBoolean(R.styleable.BLCheckBoxPreference_blShouldHideWhenDisabled, false);
        a.recycle();
        syncEnabled();
    }

    protected void onClick() {
        super.onClick();
        setPreferenceChangeListener();
    }

    private void setPreferenceChangeListener() {
        if (getOnPreferenceChangeListener() == null) {
            setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: tv.danmaku.bili.widget.preference.BLListPreference.1
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    BLListPreference.this.preferenceChange(preference, newValue);
                    return true;
                }
            });
        } else if (!(getOnPreferenceChangeListener() instanceof PreferenceChangeListenerWrapper)) {
            setOnPreferenceChangeListener(new PreferenceChangeListenerWrapper(getOnPreferenceChangeListener()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preferenceChange(Preference preference, Object newValue) {
        if ((preference instanceof ListPreference) && (newValue instanceof String)) {
            int index = ((ListPreference) preference).findIndexOfValue(String.valueOf(newValue));
            updateViewShow(index);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public class PreferenceChangeListenerWrapper implements Preference.OnPreferenceChangeListener {
        private Preference.OnPreferenceChangeListener mInnerOnPreferenceChangeListener;

        public PreferenceChangeListenerWrapper(Preference.OnPreferenceChangeListener onPreferenceChangeListener) {
            this.mInnerOnPreferenceChangeListener = onPreferenceChangeListener;
        }

        public boolean onPreferenceChange(Preference preference, Object newValue) {
            if (this.mInnerOnPreferenceChangeListener != null) {
                this.mInnerOnPreferenceChangeListener.onPreferenceChange(preference, newValue);
            }
            BLListPreference.this.preferenceChange(preference, newValue);
            return true;
        }
    }

    protected void onSetInitialValue(boolean restoreValue, Object defaultValue) {
        super.onSetInitialValue(restoreValue, defaultValue);
        syncSummary();
        syncDependents();
        syncEnabled();
    }

    protected void updateViewShow(int newIndex) {
        if (newIndex < 0) {
            return;
        }
        if (this.mBLEntrySummaries != null && newIndex < this.mBLEntrySummaries.length) {
            setSummary(this.mBLEntrySummaries[newIndex]);
        } else {
            setSummary(getEntries()[newIndex]);
        }
        syncDependents();
        syncEnabled();
    }

    public int getEntryIndex() {
        CharSequence[] entryValues = getEntryValues();
        CharSequence value = getValue();
        if (entryValues == null || value == null) {
            return -1;
        }
        for (int i = 0; i < entryValues.length; i++) {
            if (TextUtils.equals(value, entryValues[i])) {
                return i;
            }
        }
        return -1;
    }

    public void syncEnabled() {
        if (this.mDisableDependent) {
            setEnabled(false);
        } else if (!isTargetApiSupported()) {
            setEnabled(false);
        } else {
            setEnabled(true);
        }
    }

    public boolean isTargetApiSupported() {
        if (Build.VERSION.SDK_INT >= this.mMinApi && Build.VERSION.SDK_INT <= this.mMaxApi) {
            return true;
        }
        return false;
    }

    public void onDependencyChanged(Preference dependency, boolean disableDependent) {
        super.onDependencyChanged(dependency, disableDependent);
        this.mDisableDependent = disableDependent;
        syncEnabled();
    }

    public void setBLEntrySummaries(Context context, int resId) {
        setBLEntrySummaries(context.getResources().getTextArray(resId));
    }

    public void setBLEntrySummaries(CharSequence[] entrySummaries) {
        this.mBLEntrySummaries = entrySummaries;
        notifyChanged();
    }

    public CharSequence[] getBLEntrySummaries() {
        return this.mBLEntrySummaries;
    }

    private void syncSummary() {
        int index = getEntryIndex();
        if (index < 0) {
            return;
        }
        if (this.mBLEntrySummaries != null && index < this.mBLEntrySummaries.length) {
            setSummary(this.mBLEntrySummaries[index]);
        } else {
            setSummary(getEntries()[index]);
        }
    }

    public boolean shouldDisableDependents() {
        int index = getEntryIndex();
        if (index < 0) {
            return false;
        }
        return getShouldDisableDependentOnValue(index);
    }

    public void syncDependents() {
        notifyDependencyChange(shouldDisableDependents());
    }

    public void setShouldDisableDependentOnValues(Context context, int resId) {
        setShouldDisableDependentOnValues(context.getResources().getTextArray(resId));
    }

    public void setShouldDisableDependentOnValues(CharSequence[] values) {
        this.mBLEntryShouldDisableDependentOnValues = values;
        notifyChanged();
    }

    public CharSequence[] getShouldDisableDependentOnValues() {
        return this.mBLEntryShouldDisableDependentOnValues;
    }

    private boolean getShouldDisableDependentOnValue(int index) {
        CharSequence strValue;
        if (this.mBLEntryShouldDisableDependentOnValues == null || index >= this.mBLEntryShouldDisableDependentOnValues.length || (strValue = this.mBLEntryShouldDisableDependentOnValues[index]) == null) {
            return false;
        }
        try {
            int intValue = Integer.parseInt(strValue.toString());
            return intValue != 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override // tv.danmaku.bili.widget.preference.BLPreferenceCap
    public boolean shouldHide() {
        if (this.mShouldHideWhenDisabled && !isEnabled()) {
            return true;
        }
        return false;
    }
}