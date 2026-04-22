package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Switch;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class ActivityDialogDebugBinding implements ViewBinding {
    public final Button btnClearUrl;
    public final RadioButton btnCommon;
    public final RadioButton btnFill;
    public final Switch btncancelSwitch;
    public final RadioButton common;
    public final RadioButton contentCenter;
    public final EditText contenttext;
    public final EditText contenttextcopy;
    public final EditText etNegative;
    public final EditText etPositive;
    public final EditText link;
    public final RadioButton longEssay;
    public final Switch outcancelSwitch;
    public final Switch picSwitch;
    public final EditText picUrlEt;
    public final RadioGroup radioBtnStyle;
    public final RadioGroup radioContentStyle;
    private final ScrollView rootView;
    public final Button showDialog;
    public final EditText title;
    public final Switch titleColorSwitch;

    private ActivityDialogDebugBinding(ScrollView rootView, Button btnClearUrl, RadioButton btnCommon, RadioButton btnFill, Switch btncancelSwitch, RadioButton common, RadioButton contentCenter, EditText contenttext, EditText contenttextcopy, EditText etNegative, EditText etPositive, EditText link, RadioButton longEssay, Switch outcancelSwitch, Switch picSwitch, EditText picUrlEt, RadioGroup radioBtnStyle, RadioGroup radioContentStyle, Button showDialog, EditText title, Switch titleColorSwitch) {
        this.rootView = rootView;
        this.btnClearUrl = btnClearUrl;
        this.btnCommon = btnCommon;
        this.btnFill = btnFill;
        this.btncancelSwitch = btncancelSwitch;
        this.common = common;
        this.contentCenter = contentCenter;
        this.contenttext = contenttext;
        this.contenttextcopy = contenttextcopy;
        this.etNegative = etNegative;
        this.etPositive = etPositive;
        this.link = link;
        this.longEssay = longEssay;
        this.outcancelSwitch = outcancelSwitch;
        this.picSwitch = picSwitch;
        this.picUrlEt = picUrlEt;
        this.radioBtnStyle = radioBtnStyle;
        this.radioContentStyle = radioContentStyle;
        this.showDialog = showDialog;
        this.title = title;
        this.titleColorSwitch = titleColorSwitch;
    }

    public ScrollView getRoot() {
        return this.rootView;
    }

    public static ActivityDialogDebugBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityDialogDebugBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_dialog_debug, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityDialogDebugBinding bind(View rootView) {
        int id = R.id.btn_clear_url;
        Button btnClearUrl = (Button) ViewBindings.findChildViewById(rootView, id);
        if (btnClearUrl != null) {
            id = R.id.btn_common;
            RadioButton btnCommon = (RadioButton) ViewBindings.findChildViewById(rootView, id);
            if (btnCommon != null) {
                id = R.id.btn_fill;
                RadioButton btnFill = (RadioButton) ViewBindings.findChildViewById(rootView, id);
                if (btnFill != null) {
                    id = R.id.btncancel_switch;
                    Switch btncancelSwitch = (Switch) ViewBindings.findChildViewById(rootView, id);
                    if (btncancelSwitch != null) {
                        id = R.id.common;
                        RadioButton common = (RadioButton) ViewBindings.findChildViewById(rootView, id);
                        if (common != null) {
                            id = R.id.content_center;
                            RadioButton contentCenter = (RadioButton) ViewBindings.findChildViewById(rootView, id);
                            if (contentCenter != null) {
                                id = R.id.contenttext;
                                EditText contenttext = (EditText) ViewBindings.findChildViewById(rootView, id);
                                if (contenttext != null) {
                                    id = R.id.contenttextcopy;
                                    EditText contenttextcopy = (EditText) ViewBindings.findChildViewById(rootView, id);
                                    if (contenttextcopy != null) {
                                        id = R.id.et_negative;
                                        EditText etNegative = (EditText) ViewBindings.findChildViewById(rootView, id);
                                        if (etNegative != null) {
                                            id = R.id.et_positive;
                                            EditText etPositive = (EditText) ViewBindings.findChildViewById(rootView, id);
                                            if (etPositive != null) {
                                                id = R.id.link;
                                                EditText link = (EditText) ViewBindings.findChildViewById(rootView, id);
                                                if (link != null) {
                                                    id = R.id.long_essay;
                                                    RadioButton longEssay = (RadioButton) ViewBindings.findChildViewById(rootView, id);
                                                    if (longEssay != null) {
                                                        id = R.id.outcancel_switch;
                                                        Switch outcancelSwitch = (Switch) ViewBindings.findChildViewById(rootView, id);
                                                        if (outcancelSwitch != null) {
                                                            id = R.id.pic_switch;
                                                            Switch picSwitch = (Switch) ViewBindings.findChildViewById(rootView, id);
                                                            if (picSwitch != null) {
                                                                id = R.id.pic_url_et;
                                                                EditText picUrlEt = (EditText) ViewBindings.findChildViewById(rootView, id);
                                                                if (picUrlEt != null) {
                                                                    id = R.id.radio_btn_style;
                                                                    RadioGroup radioBtnStyle = (RadioGroup) ViewBindings.findChildViewById(rootView, id);
                                                                    if (radioBtnStyle != null) {
                                                                        id = R.id.radio_content_style;
                                                                        RadioGroup radioContentStyle = (RadioGroup) ViewBindings.findChildViewById(rootView, id);
                                                                        if (radioContentStyle != null) {
                                                                            id = R.id.show_dialog;
                                                                            Button showDialog = (Button) ViewBindings.findChildViewById(rootView, id);
                                                                            if (showDialog != null) {
                                                                                id = R.id.title;
                                                                                EditText title = (EditText) ViewBindings.findChildViewById(rootView, id);
                                                                                if (title != null) {
                                                                                    id = R.id.title_color_switch;
                                                                                    Switch titleColorSwitch = (Switch) ViewBindings.findChildViewById(rootView, id);
                                                                                    if (titleColorSwitch != null) {
                                                                                        return new ActivityDialogDebugBinding((ScrollView) rootView, btnClearUrl, btnCommon, btnFill, btncancelSwitch, common, contentCenter, contenttext, contenttextcopy, etNegative, etPositive, link, longEssay, outcancelSwitch, picSwitch, picUrlEt, radioBtnStyle, radioContentStyle, showDialog, title, titleColorSwitch);
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
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}