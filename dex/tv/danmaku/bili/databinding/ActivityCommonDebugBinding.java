package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class ActivityCommonDebugBinding implements ViewBinding {
    public final EditText abId;
    public final Button btn1;
    public final Button btn2;
    public final Button btnCreate;
    public final Button btnDelete;
    public final Button btnTriggerCritical;
    public final Button btnTriggerMinor;
    public final Button btnTriggerStart;
    public final EditText format;
    public final EditText path;
    public final EditText rmBl;
    public final SwitchCompat rmFake;
    public final EditText rmName;
    public final EditText rmPath;
    public final EditText rmSize;
    public final EditText rmStrategy;
    public final EditText rmWl;
    private final ScrollView rootView;
    public final EditText size;

    private ActivityCommonDebugBinding(ScrollView rootView, EditText abId, Button btn1, Button btn2, Button btnCreate, Button btnDelete, Button btnTriggerCritical, Button btnTriggerMinor, Button btnTriggerStart, EditText format, EditText path, EditText rmBl, SwitchCompat rmFake, EditText rmName, EditText rmPath, EditText rmSize, EditText rmStrategy, EditText rmWl, EditText size) {
        this.rootView = rootView;
        this.abId = abId;
        this.btn1 = btn1;
        this.btn2 = btn2;
        this.btnCreate = btnCreate;
        this.btnDelete = btnDelete;
        this.btnTriggerCritical = btnTriggerCritical;
        this.btnTriggerMinor = btnTriggerMinor;
        this.btnTriggerStart = btnTriggerStart;
        this.format = format;
        this.path = path;
        this.rmBl = rmBl;
        this.rmFake = rmFake;
        this.rmName = rmName;
        this.rmPath = rmPath;
        this.rmSize = rmSize;
        this.rmStrategy = rmStrategy;
        this.rmWl = rmWl;
        this.size = size;
    }

    public ScrollView getRoot() {
        return this.rootView;
    }

    public static ActivityCommonDebugBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityCommonDebugBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_common_debug, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityCommonDebugBinding bind(View rootView) {
        SwitchCompat rmFake;
        int id = R.id.ab_id;
        EditText abId = (EditText) ViewBindings.findChildViewById(rootView, id);
        if (abId != null) {
            id = R.id.btn_1;
            Button btn1 = (Button) ViewBindings.findChildViewById(rootView, id);
            if (btn1 != null) {
                id = R.id.btn_2;
                Button btn2 = (Button) ViewBindings.findChildViewById(rootView, id);
                if (btn2 != null) {
                    id = R.id.btn_create;
                    Button btnCreate = (Button) ViewBindings.findChildViewById(rootView, id);
                    if (btnCreate != null) {
                        id = R.id.btn_delete;
                        Button btnDelete = (Button) ViewBindings.findChildViewById(rootView, id);
                        if (btnDelete != null) {
                            id = R.id.btn_trigger_critical;
                            Button btnTriggerCritical = (Button) ViewBindings.findChildViewById(rootView, id);
                            if (btnTriggerCritical != null) {
                                id = R.id.btn_trigger_minor;
                                Button btnTriggerMinor = (Button) ViewBindings.findChildViewById(rootView, id);
                                if (btnTriggerMinor != null) {
                                    id = R.id.btn_trigger_start;
                                    Button btnTriggerStart = (Button) ViewBindings.findChildViewById(rootView, id);
                                    if (btnTriggerStart != null) {
                                        id = R.id.format;
                                        EditText format = (EditText) ViewBindings.findChildViewById(rootView, id);
                                        if (format != null) {
                                            id = R.id.path;
                                            EditText path = (EditText) ViewBindings.findChildViewById(rootView, id);
                                            if (path != null) {
                                                id = R.id.rm_bl;
                                                EditText rmBl = (EditText) ViewBindings.findChildViewById(rootView, id);
                                                if (rmBl != null && (rmFake = ViewBindings.findChildViewById(rootView, (id = R.id.rm_fake))) != null) {
                                                    id = R.id.rm_name;
                                                    EditText rmName = (EditText) ViewBindings.findChildViewById(rootView, id);
                                                    if (rmName != null) {
                                                        id = R.id.rm_path;
                                                        EditText rmPath = (EditText) ViewBindings.findChildViewById(rootView, id);
                                                        if (rmPath != null) {
                                                            id = R.id.rm_size;
                                                            EditText rmSize = (EditText) ViewBindings.findChildViewById(rootView, id);
                                                            if (rmSize != null) {
                                                                id = R.id.rm_strategy;
                                                                EditText rmStrategy = (EditText) ViewBindings.findChildViewById(rootView, id);
                                                                if (rmStrategy != null) {
                                                                    id = R.id.rm_wl;
                                                                    EditText rmWl = (EditText) ViewBindings.findChildViewById(rootView, id);
                                                                    if (rmWl != null) {
                                                                        id = R.id.size;
                                                                        EditText size = (EditText) ViewBindings.findChildViewById(rootView, id);
                                                                        if (size != null) {
                                                                            return new ActivityCommonDebugBinding((ScrollView) rootView, abId, btn1, btn2, btnCreate, btnDelete, btnTriggerCritical, btnTriggerMinor, btnTriggerStart, format, path, rmBl, rmFake, rmName, rmPath, rmSize, rmStrategy, rmWl, size);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}