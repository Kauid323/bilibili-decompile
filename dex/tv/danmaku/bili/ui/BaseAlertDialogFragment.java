package tv.danmaku.bili.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.bilibili.lib.ui.R;
import com.bilibili.ui.busbound.BusDialogFragment;
import java.lang.reflect.Field;

public abstract class BaseAlertDialogFragment extends BusDialogFragment {
    private static final int MAX_SCREEN_WIDTH = 1080;
    protected Button mNegative;
    protected Button mNeutral;
    protected Button mPositive;
    protected TextView mTitle;

    protected abstract void onButtonClick(int i);

    public abstract View onCreateCustomView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            setStyle(1, R.style.AppTheme_AppCompat_Dialog_Alert);
        }
    }

    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(tv.danmaku.bili.R.layout.bili_app_fragment_alert_dialog, container, false);
        ViewGroup custom = (ViewGroup) view.findViewById(tv.danmaku.bili.R.id.customPanel);
        View customView = onCreateCustomView(inflater, custom, savedInstanceState);
        if (customView == null) {
            throw new NullPointerException("The custom view cannot be null!");
        }
        if (custom != customView) {
            if (customView.getParent() == null) {
                custom.addView(customView);
            } else if (customView.getParent() != custom) {
                throw new IllegalStateException("The specified custom view already has a parent.");
            }
        }
        return view;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.mTitle = (TextView) view.findViewById(tv.danmaku.bili.R.id.title);
        View buttons = view.findViewById(tv.danmaku.bili.R.id.buttonPanel);
        this.mNeutral = (Button) buttons.findViewById(16908315);
        this.mNegative = (Button) buttons.findViewById(16908314);
        this.mPositive = (Button) buttons.findViewById(16908313);
        View.OnClickListener onclick = new View.OnClickListener() { // from class: tv.danmaku.bili.ui.BaseAlertDialogFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int button;
                switch (v.getId()) {
                    case 16908313:
                        button = -1;
                        break;
                    case 16908314:
                    default:
                        button = -2;
                        break;
                    case 16908315:
                        button = -3;
                        break;
                }
                BaseAlertDialogFragment.this.onButtonClick(button);
            }
        };
        this.mNeutral.setOnClickListener(onclick);
        this.mNegative.setOnClickListener(onclick);
        this.mPositive.setOnClickListener(onclick);
    }

    public void setTitle(CharSequence text) {
        if (this.mTitle != null) {
            this.mTitle.setText(text);
        } else {
            Log.e("DialogFragment", "The view of dialog is not created");
        }
    }

    public void setPositiveText(CharSequence text) {
        if (this.mPositive != null) {
            this.mPositive.setText(text);
        } else {
            Log.e("DialogFragment", "The view of dialog is not created");
        }
    }

    public void setNegativeText(CharSequence text) {
        if (this.mNegative != null) {
            this.mNegative.setText(text);
        } else {
            Log.e("DialogFragment", "The view of dialog is not created");
        }
    }

    public void setNeutralText(CharSequence text) {
        if (this.mNeutral != null) {
            this.mNeutral.setText(text);
            if (this.mNeutral.getVisibility() == 8) {
                this.mNeutral.setVisibility(0);
                return;
            }
            return;
        }
        Log.e("DialogFragment", "The view of dialog is not created");
    }

    public void onStart() {
        Dialog dialog = getDialog();
        if (dialog != null && getView() != null) {
            Window window = dialog.getWindow();
            WindowManager.LayoutParams p = window.getAttributes();
            DisplayMetrics displayMetrics = dialog.getContext().getResources().getDisplayMetrics();
            int i = displayMetrics.widthPixels;
            int i2 = MAX_SCREEN_WIDTH;
            if (i <= MAX_SCREEN_WIDTH) {
                i2 = (displayMetrics.widthPixels * 7) >> 3;
            }
            p.width = i2;
            p.height = -2;
            getView().measure(View.MeasureSpec.makeMeasureSpec(p.width, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            window.setAttributes(p);
        }
        super.onStart();
    }

    public void show(FragmentManager manager, String tag) {
        try {
            Field mStateSaved = manager.getClass().getDeclaredField("mStateSaved");
            mStateSaved.setAccessible(true);
            if (!mStateSaved.getBoolean(manager)) {
                super.show(manager, tag);
            }
        } catch (Exception e) {
            super.show(manager, tag);
        }
    }
}