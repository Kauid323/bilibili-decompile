package tv.danmaku.bili.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceManager;
import androidx.preference.PreferenceViewHolder;
import tv.danmaku.android.util.DebugLog;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;

public class RadioGroupPreference extends PreferenceCategory implements Preference.OnPreferenceClickListener {
    private String mDefaultRadioValue;
    private boolean mHideTopBar;
    private int mLeftOffset;
    private OnPreferenceRadioItemClickListener mOnPreferenceRadioItemClickListener;
    private CharSequence[] mRadioEntries;
    private CharSequence[] mRadioEntrySummaries;
    private CharSequence[] mRadioEntryValues;
    private int mRightOffset;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnPreferenceRadioItemClickListener {
        boolean onPreferenceRadioItemClick(RadioGroupPreference radioGroupPreference, RadioButtonPreference radioButtonPreference);
    }

    public RadioGroupPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mHideTopBar = false;
        initPreference(context, attrs);
    }

    public RadioGroupPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mHideTopBar = false;
        initPreference(context, attrs);
    }

    private final void initPreference(Context context, AttributeSet attrs) {
        TypedArray attrArray = context.obtainStyledAttributes(attrs, R.styleable.RadioGroupPreference, 0, 0);
        if (attrArray == null) {
            return;
        }
        this.mDefaultRadioValue = attrArray.getString(R.styleable.RadioGroupPreference_radioDefaultValue);
        this.mRadioEntries = attrArray.getTextArray(R.styleable.RadioGroupPreference_radioEntries);
        this.mRadioEntryValues = attrArray.getTextArray(R.styleable.RadioGroupPreference_radioEntryValues);
        this.mRadioEntrySummaries = attrArray.getTextArray(R.styleable.RadioGroupPreference_radioEntrySummaries);
        this.mLeftOffset = (int) attrArray.getDimension(R.styleable.RadioGroupPreference_leftOffset, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        this.mRightOffset = (int) attrArray.getDimension(R.styleable.RadioGroupPreference_rightOffset, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        this.mHideTopBar = attrArray.getBoolean(R.styleable.RadioGroupPreference_hideTopBar, false);
        attrArray.recycle();
    }

    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        if (this.mHideTopBar && (holder.itemView instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) holder.itemView;
            viewGroup.removeAllViews();
            holder.itemView.getLayoutParams().height = 0;
            holder.setDividerAllowedAbove(true);
        }
    }

    protected void onAttachedToHierarchy(PreferenceManager preferenceManager) {
        super.onAttachedToHierarchy(preferenceManager);
        if (this.mRadioEntries == null) {
            return;
        }
        int count = this.mRadioEntries.length;
        for (int i = 0; i < count; i++) {
            CharSequence entry = this.mRadioEntries[i];
            if (!TextUtils.isEmpty(entry)) {
                RadioButtonPreference radioPreference = new RadioButtonPreference(getContext());
                radioPreference.setTitle(entry);
                radioPreference.setPersistent(false);
                if (this.mLeftOffset > 0) {
                    radioPreference.setLeftOffset(this.mLeftOffset);
                }
                if (this.mRightOffset > 0) {
                    radioPreference.setRightOffset(this.mRightOffset);
                }
                if (this.mRadioEntryValues != null && i < this.mRadioEntryValues.length) {
                    CharSequence entryValue = this.mRadioEntryValues[i];
                    if (!TextUtils.isEmpty(entryValue)) {
                        radioPreference.setRadioValue(entryValue.toString());
                    }
                    if (this.mRadioEntrySummaries != null && i < this.mRadioEntrySummaries.length) {
                        CharSequence entrySummary = this.mRadioEntrySummaries[i];
                        if (!TextUtils.isEmpty(entrySummary)) {
                            radioPreference.setSummary(entrySummary);
                        }
                    }
                    addPreference(radioPreference);
                }
            }
        }
        if (!setRadioValue(getPersistedString(this.mDefaultRadioValue))) {
            setRadioValue(this.mDefaultRadioValue);
        }
    }

    protected boolean onPrepareAddPreference(Preference preference) {
        if ((preference instanceof RadioButtonPreference) && super.onPrepareAddPreference(preference)) {
            preference.setOnPreferenceClickListener(this);
            return true;
        }
        return false;
    }

    public boolean onPreferenceClick(Preference preference) {
        if (preference instanceof RadioButtonPreference) {
            RadioButtonPreference radioButtonPref = (RadioButtonPreference) preference;
            String radioValue = radioButtonPref.getRadioValue();
            if (this.mOnPreferenceRadioItemClickListener == null || !this.mOnPreferenceRadioItemClickListener.onPreferenceRadioItemClick(this, radioButtonPref)) {
                if (canBeChanged(radioValue)) {
                    uncheckAll(radioButtonPref);
                    radioButtonPref.setChecked(true);
                    persistString(radioValue);
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    private void uncheckAll(RadioButtonPreference except) {
        int count = getPreferenceCount();
        for (int i = 0; i < count; i++) {
            RadioButtonPreference preference = getPreference(i);
            if ((preference instanceof RadioButtonPreference) && preference != except) {
                RadioButtonPreference radioButtonPref = preference;
                radioButtonPref.setChecked(false);
            }
        }
    }

    public RadioButtonPreference findPreferenceByRadioValue(int radioValue) {
        return findPreferenceByRadioValue(String.valueOf(radioValue));
    }

    public RadioButtonPreference findPreferenceByRadioValue(String radioValue) {
        int count = getPreferenceCount();
        for (int i = 0; i < count; i++) {
            RadioButtonPreference preference = getPreference(i);
            if (preference instanceof RadioButtonPreference) {
                RadioButtonPreference radioButtonPref = preference;
                String realValue = radioButtonPref.getRadioValue();
                if (realValue.equalsIgnoreCase(radioValue)) {
                    return radioButtonPref;
                }
            }
        }
        return null;
    }

    private boolean checkByRadioValue(String radioValue) {
        RadioButtonPreference findPreference = findPreferenceByRadioValue(radioValue);
        if (findPreference == null) {
            return false;
        }
        uncheckAll(findPreference);
        findPreference.setChecked(true);
        return true;
    }

    public String getRadioValue() {
        return getPersistedString(this.mDefaultRadioValue);
    }

    public int getRadioValueAsInteger(int defaultValue) {
        String radioValue = getRadioValue();
        try {
            return Integer.parseInt(radioValue);
        } catch (NumberFormatException e) {
            DebugLog.printStackTrace(e);
            return defaultValue;
        }
    }

    public boolean setRadioValue(String radioValue) {
        if (canBeChanged(radioValue) && checkByRadioValue(radioValue)) {
            persistString(radioValue);
            return true;
        }
        return false;
    }

    private boolean canBeChanged(String newValue) {
        Preference.OnPreferenceChangeListener listener = getOnPreferenceChangeListener();
        if (listener == null) {
            return true;
        }
        return listener.onPreferenceChange(this, newValue);
    }

    public void setEnabledByRadioValue(String radioValue, boolean enable) {
        RadioButtonPreference findPreference = findPreferenceByRadioValue(radioValue);
        if (findPreference == null) {
            return;
        }
        findPreference.setEnabled(enable);
    }

    public void setEnabledByRadioValue(int radioValue, boolean enable) {
        setEnabledByRadioValue(String.valueOf(radioValue), enable);
    }

    public void removeByRadioValue(int radioValue) {
        RadioButtonPreference findPreference = findPreferenceByRadioValue(radioValue);
        if (findPreference == null) {
            return;
        }
        removePreference(findPreference);
    }

    public void setRadioSummary(int radioValue, String summary) {
        RadioButtonPreference findPreference = findPreferenceByRadioValue(radioValue);
        if (findPreference == null) {
            return;
        }
        findPreference.setSummary(summary);
    }

    public void setOnPreferenceRadioItemClickListener(OnPreferenceRadioItemClickListener listener) {
        this.mOnPreferenceRadioItemClickListener = listener;
    }

    protected Object onGetDefaultValue(TypedArray a, int index) {
        return a.getString(index);
    }

    protected void onSetInitialValue(boolean restoreValue, Object defaultValue) {
        setRadioValue(restoreValue ? getPersistedString(this.mDefaultRadioValue) : (String) defaultValue);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [android.os.Parcelable, tv.danmaku.bili.widget.RadioGroupPreference$SavedState] */
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        if (isPersistent()) {
            return superState;
        }
        ?? savedState = new SavedState(superState);
        ((SavedState) savedState).mRadioValue = getRadioValue();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable state) {
        if (state == null || !state.getClass().equals(SavedState.class)) {
            super.onRestoreInstanceState(state);
            return;
        }
        SavedState myState = (SavedState) state;
        super.onRestoreInstanceState(myState.getSuperState());
        setRadioValue(myState.mRadioValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: tv.danmaku.bili.widget.RadioGroupPreference.SavedState.1
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        private String mRadioValue;

        public SavedState(Parcel source) {
            super(source);
            this.mRadioValue = source.readString();
        }

        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeString(this.mRadioValue);
        }

        public SavedState(Parcelable superState) {
            super(superState);
        }
    }
}