package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class FreedataActivityDebugBinding implements ViewBinding {
    public final Button btnActiveMobile;
    public final Button btnActiveTelecom;
    public final Button btnActiveUnicomCard;
    public final Button btnActiveUnicomPkg;
    public final Button btnActiveUnicomPkgDemiware;
    public final Button btnAutoActiveCmForce;
    public final Button btnAutoActiveCuForce;
    public final Button btnClearStorageData;
    public final Button btnEnter;
    public final Button btnFreeDataCondition;
    public final Button btnIspTest;
    public final Button btnMockUrlProcess;
    public final Button btnPrintStorageData;
    public final Button btnPrintUnicomPkgDemiware;
    public final Button btnSyncTelecom;
    public final Button btnTfRules;
    public final EditText edErrorCode;
    private final ScrollView rootView;
    public final Switch switchCloseActiveWhenNetChange;
    public final Switch switchCloseSyncWhenNetChange;
    public final Switch switchError;
    public final Switch switchFreeData;
    public final TextView tvFdActiveState;
    public final TextView tvFdNetState;
    public final TextView tvFdSimOpt;

    private FreedataActivityDebugBinding(ScrollView rootView, Button btnActiveMobile, Button btnActiveTelecom, Button btnActiveUnicomCard, Button btnActiveUnicomPkg, Button btnActiveUnicomPkgDemiware, Button btnAutoActiveCmForce, Button btnAutoActiveCuForce, Button btnClearStorageData, Button btnEnter, Button btnFreeDataCondition, Button btnIspTest, Button btnMockUrlProcess, Button btnPrintStorageData, Button btnPrintUnicomPkgDemiware, Button btnSyncTelecom, Button btnTfRules, EditText edErrorCode, Switch switchCloseActiveWhenNetChange, Switch switchCloseSyncWhenNetChange, Switch switchError, Switch switchFreeData, TextView tvFdActiveState, TextView tvFdNetState, TextView tvFdSimOpt) {
        this.rootView = rootView;
        this.btnActiveMobile = btnActiveMobile;
        this.btnActiveTelecom = btnActiveTelecom;
        this.btnActiveUnicomCard = btnActiveUnicomCard;
        this.btnActiveUnicomPkg = btnActiveUnicomPkg;
        this.btnActiveUnicomPkgDemiware = btnActiveUnicomPkgDemiware;
        this.btnAutoActiveCmForce = btnAutoActiveCmForce;
        this.btnAutoActiveCuForce = btnAutoActiveCuForce;
        this.btnClearStorageData = btnClearStorageData;
        this.btnEnter = btnEnter;
        this.btnFreeDataCondition = btnFreeDataCondition;
        this.btnIspTest = btnIspTest;
        this.btnMockUrlProcess = btnMockUrlProcess;
        this.btnPrintStorageData = btnPrintStorageData;
        this.btnPrintUnicomPkgDemiware = btnPrintUnicomPkgDemiware;
        this.btnSyncTelecom = btnSyncTelecom;
        this.btnTfRules = btnTfRules;
        this.edErrorCode = edErrorCode;
        this.switchCloseActiveWhenNetChange = switchCloseActiveWhenNetChange;
        this.switchCloseSyncWhenNetChange = switchCloseSyncWhenNetChange;
        this.switchError = switchError;
        this.switchFreeData = switchFreeData;
        this.tvFdActiveState = tvFdActiveState;
        this.tvFdNetState = tvFdNetState;
        this.tvFdSimOpt = tvFdSimOpt;
    }

    public ScrollView getRoot() {
        return this.rootView;
    }

    public static FreedataActivityDebugBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FreedataActivityDebugBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.freedata_activity_debug, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static FreedataActivityDebugBinding bind(View rootView) {
        int id = R.id.btn_active_mobile;
        Button btnActiveMobile = (Button) ViewBindings.findChildViewById(rootView, id);
        if (btnActiveMobile != null) {
            id = R.id.btn_active_telecom;
            Button btnActiveTelecom = (Button) ViewBindings.findChildViewById(rootView, id);
            if (btnActiveTelecom != null) {
                id = R.id.btn_active_unicom_card;
                Button btnActiveUnicomCard = (Button) ViewBindings.findChildViewById(rootView, id);
                if (btnActiveUnicomCard != null) {
                    id = R.id.btn_active_unicom_pkg;
                    Button btnActiveUnicomPkg = (Button) ViewBindings.findChildViewById(rootView, id);
                    if (btnActiveUnicomPkg != null) {
                        id = R.id.btn_active_unicom_pkg_demiware;
                        Button btnActiveUnicomPkgDemiware = (Button) ViewBindings.findChildViewById(rootView, id);
                        if (btnActiveUnicomPkgDemiware != null) {
                            id = R.id.btn_auto_active_cm_force;
                            Button btnAutoActiveCmForce = (Button) ViewBindings.findChildViewById(rootView, id);
                            if (btnAutoActiveCmForce != null) {
                                id = R.id.btn_auto_active_cu_force;
                                Button btnAutoActiveCuForce = (Button) ViewBindings.findChildViewById(rootView, id);
                                if (btnAutoActiveCuForce != null) {
                                    id = R.id.btn_clear_storage_data;
                                    Button btnClearStorageData = (Button) ViewBindings.findChildViewById(rootView, id);
                                    if (btnClearStorageData != null) {
                                        id = R.id.btn_enter;
                                        Button btnEnter = (Button) ViewBindings.findChildViewById(rootView, id);
                                        if (btnEnter != null) {
                                            id = R.id.btn_free_data_condition;
                                            Button btnFreeDataCondition = (Button) ViewBindings.findChildViewById(rootView, id);
                                            if (btnFreeDataCondition != null) {
                                                id = R.id.btn_isp_test;
                                                Button btnIspTest = (Button) ViewBindings.findChildViewById(rootView, id);
                                                if (btnIspTest != null) {
                                                    id = R.id.btn_mock_url_process;
                                                    Button btnMockUrlProcess = (Button) ViewBindings.findChildViewById(rootView, id);
                                                    if (btnMockUrlProcess != null) {
                                                        id = R.id.btn_print_storage_data;
                                                        Button btnPrintStorageData = (Button) ViewBindings.findChildViewById(rootView, id);
                                                        if (btnPrintStorageData != null) {
                                                            id = R.id.btn_print_unicom_pkg_demiware;
                                                            Button btnPrintUnicomPkgDemiware = (Button) ViewBindings.findChildViewById(rootView, id);
                                                            if (btnPrintUnicomPkgDemiware != null) {
                                                                id = R.id.btn_sync_telecom;
                                                                Button btnSyncTelecom = (Button) ViewBindings.findChildViewById(rootView, id);
                                                                if (btnSyncTelecom != null) {
                                                                    id = R.id.btn_tf_rules;
                                                                    Button btnTfRules = (Button) ViewBindings.findChildViewById(rootView, id);
                                                                    if (btnTfRules != null) {
                                                                        id = R.id.ed_error_code;
                                                                        EditText edErrorCode = (EditText) ViewBindings.findChildViewById(rootView, id);
                                                                        if (edErrorCode != null) {
                                                                            id = R.id.switch_close_active_when_net_change;
                                                                            Switch switchCloseActiveWhenNetChange = (Switch) ViewBindings.findChildViewById(rootView, id);
                                                                            if (switchCloseActiveWhenNetChange != null) {
                                                                                id = R.id.switch_close_sync_when_net_change;
                                                                                Switch switchCloseSyncWhenNetChange = (Switch) ViewBindings.findChildViewById(rootView, id);
                                                                                if (switchCloseSyncWhenNetChange != null) {
                                                                                    id = R.id.switch_error;
                                                                                    Switch switchError = (Switch) ViewBindings.findChildViewById(rootView, id);
                                                                                    if (switchError != null) {
                                                                                        id = R.id.switch_free_data;
                                                                                        Switch switchFreeData = (Switch) ViewBindings.findChildViewById(rootView, id);
                                                                                        if (switchFreeData != null) {
                                                                                            id = R.id.tv_fd_active_state;
                                                                                            TextView tvFdActiveState = (TextView) ViewBindings.findChildViewById(rootView, id);
                                                                                            if (tvFdActiveState != null) {
                                                                                                id = R.id.tv_fd_net_state;
                                                                                                TextView tvFdNetState = (TextView) ViewBindings.findChildViewById(rootView, id);
                                                                                                if (tvFdNetState != null) {
                                                                                                    id = R.id.tv_fd_sim_opt;
                                                                                                    TextView tvFdSimOpt = (TextView) ViewBindings.findChildViewById(rootView, id);
                                                                                                    if (tvFdSimOpt != null) {
                                                                                                        return new FreedataActivityDebugBinding((ScrollView) rootView, btnActiveMobile, btnActiveTelecom, btnActiveUnicomCard, btnActiveUnicomPkg, btnActiveUnicomPkgDemiware, btnAutoActiveCmForce, btnAutoActiveCuForce, btnClearStorageData, btnEnter, btnFreeDataCondition, btnIspTest, btnMockUrlProcess, btnPrintStorageData, btnPrintUnicomPkgDemiware, btnSyncTelecom, btnTfRules, edErrorCode, switchCloseActiveWhenNetChange, switchCloseSyncWhenNetChange, switchError, switchFreeData, tvFdActiveState, tvFdNetState, tvFdSimOpt);
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
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}