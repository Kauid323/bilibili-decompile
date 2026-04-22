package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.bilibili.magicasakura.widgets.TintCheckedTextView;
import tv.danmaku.bili.R;

public final class SelectDialogSinglechoiceMaterialBinding implements ViewBinding {
    private final TintCheckedTextView rootView;
    public final TintCheckedTextView text1;

    private SelectDialogSinglechoiceMaterialBinding(TintCheckedTextView rootView, TintCheckedTextView text1) {
        this.rootView = rootView;
        this.text1 = text1;
    }

    public TintCheckedTextView getRoot() {
        return this.rootView;
    }

    public static SelectDialogSinglechoiceMaterialBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SelectDialogSinglechoiceMaterialBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.select_dialog_singlechoice_material, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static SelectDialogSinglechoiceMaterialBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        TintCheckedTextView text1 = (TintCheckedTextView) rootView;
        return new SelectDialogSinglechoiceMaterialBinding((TintCheckedTextView) rootView, text1);
    }
}