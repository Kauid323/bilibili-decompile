package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class TitleInputItemBinding implements ViewBinding {
    public final TextView optionKey;
    public final EditText optionValue;
    private final LinearLayout rootView;

    private TitleInputItemBinding(LinearLayout rootView, TextView optionKey, EditText optionValue) {
        this.rootView = rootView;
        this.optionKey = optionKey;
        this.optionValue = optionValue;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TitleInputItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static TitleInputItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.title_input_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static TitleInputItemBinding bind(View rootView) {
        int id = R.id.option_key;
        TextView optionKey = (TextView) ViewBindings.findChildViewById(rootView, id);
        if (optionKey != null) {
            id = R.id.option_value;
            EditText optionValue = (EditText) ViewBindings.findChildViewById(rootView, id);
            if (optionValue != null) {
                return new TitleInputItemBinding((LinearLayout) rootView, optionKey, optionValue);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}