package tv.danmaku.bili.widget.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import androidx.preference.CheckBoxPreference;
import androidx.preference.Preference;
import tv.danmaku.bili.widget.R;
import tv.danmaku.biliplayerimpl.toast.left.viewholder.ActionMessageWithAnimationVH;

public class BLCheckBoxPreference extends CheckBoxPreference implements BLPreferenceCap {
    private int mMaxApi;
    private int mMinApi;
    private boolean mShouldHideWhenDisabled;

    public BLCheckBoxPreference(Context context) {
        super(context);
        this.mMinApi = Integer.MIN_VALUE;
        this.mMaxApi = ActionMessageWithAnimationVH.INVALID_COLOR_INT;
        this.mShouldHideWhenDisabled = Boolean.FALSE.booleanValue();
        initPreference(context, null, 0);
    }

    public BLCheckBoxPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mMinApi = Integer.MIN_VALUE;
        this.mMaxApi = ActionMessageWithAnimationVH.INVALID_COLOR_INT;
        this.mShouldHideWhenDisabled = Boolean.FALSE.booleanValue();
        initPreference(context, attrs, 0);
    }

    public BLCheckBoxPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mMinApi = Integer.MIN_VALUE;
        this.mMaxApi = ActionMessageWithAnimationVH.INVALID_COLOR_INT;
        this.mShouldHideWhenDisabled = Boolean.FALSE.booleanValue();
        initPreference(context, attrs, defStyle);
    }

    private final void initPreference(Context context, AttributeSet attrs, int defStyle) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.BLCheckBoxPreference, defStyle, 0);
        if (a == null) {
            return;
        }
        this.mMinApi = a.getInteger(R.styleable.BLCheckBoxPreference_blMinApi, Integer.MIN_VALUE);
        this.mMaxApi = a.getInteger(R.styleable.BLCheckBoxPreference_blMaxApi, ActionMessageWithAnimationVH.INVALID_COLOR_INT);
        this.mShouldHideWhenDisabled = a.getBoolean(R.styleable.BLCheckBoxPreference_blShouldHideWhenDisabled, false);
        a.recycle();
        syncEnabled();
    }

    protected void onSetInitialValue(boolean restoreValue, Object defaultValue) {
        super.onSetInitialValue(restoreValue, defaultValue);
        syncEnabled();
    }

    private void syncEnabled() {
        if (!isTargetApiSupported()) {
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
        syncEnabled();
    }

    @Override // tv.danmaku.bili.widget.preference.BLPreferenceCap
    public boolean shouldHide() {
        if (this.mShouldHideWhenDisabled && !isEnabled()) {
            return true;
        }
        return false;
    }
}