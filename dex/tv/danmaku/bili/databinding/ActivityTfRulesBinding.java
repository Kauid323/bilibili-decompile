package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class ActivityTfRulesBinding implements ViewBinding {
    public final Button btnRuleAssets;
    public final Button btnRuleClear;
    public final Button btnRulePrint;
    public final Button btnRuleRequest;
    private final LinearLayout rootView;

    private ActivityTfRulesBinding(LinearLayout rootView, Button btnRuleAssets, Button btnRuleClear, Button btnRulePrint, Button btnRuleRequest) {
        this.rootView = rootView;
        this.btnRuleAssets = btnRuleAssets;
        this.btnRuleClear = btnRuleClear;
        this.btnRulePrint = btnRulePrint;
        this.btnRuleRequest = btnRuleRequest;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityTfRulesBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityTfRulesBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_tf_rules, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityTfRulesBinding bind(View rootView) {
        int id = R.id.btn_rule_assets;
        Button btnRuleAssets = (Button) ViewBindings.findChildViewById(rootView, id);
        if (btnRuleAssets != null) {
            id = R.id.btn_rule_clear;
            Button btnRuleClear = (Button) ViewBindings.findChildViewById(rootView, id);
            if (btnRuleClear != null) {
                id = R.id.btn_rule_print;
                Button btnRulePrint = (Button) ViewBindings.findChildViewById(rootView, id);
                if (btnRulePrint != null) {
                    id = R.id.btn_rule_request;
                    Button btnRuleRequest = (Button) ViewBindings.findChildViewById(rootView, id);
                    if (btnRuleRequest != null) {
                        return new ActivityTfRulesBinding((LinearLayout) rootView, btnRuleAssets, btnRuleClear, btnRulePrint, btnRuleRequest);
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}