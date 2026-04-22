package im.setting.track;

import com.bapis.bilibili.app.im.v1.KSetting;
import com.bapis.bilibili.app.im.v1.KSettingSwitch;
import com.bapis.bilibili.app.im.v1.KSwitchConfirmDialog;
import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import com.tencent.tauth.AuthActivity;
import im.setting.IMSettingAction;
import im.setting.IMSettingDialogConfirmAction;
import im.setting.IMSettingItemExposureAction;
import im.setting.IMSettingSelectAction;
import im.setting.IMSettingState;
import im.setting.IMSettingSwitchAction;
import im.setting.model.SettingItem;
import im.setting.service.SettingReportService;
import java.util.LinkedHashMap;
import java.util.Map;
import kntr.base.neuron.KNeuron;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: Tracker.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0006\u001a$\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nH\u0002\u001a\f\u0010\f\u001a\u00020\u000b*\u00020\rH\u0002\u001a$\u0010\u000e\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u000f2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¨\u0006\u0010"}, d2 = {"bindTracker", "", "Lcom/freeletics/flowredux/dsl/FlowReduxStoreBuilder;", "Lim/setting/IMSettingState;", "Lim/setting/IMSettingAction;", "reportService", "Lim/setting/service/SettingReportService;", "reportClick", AuthActivity.ACTION_KEY, "extraMap", "", "", "moduleName", "Lim/setting/model/SettingItem;", "reportExposure", "Lim/setting/IMSettingItemExposureAction;", "logic_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TrackerKt {
    public static final void bindTracker(FlowReduxStoreBuilder<IMSettingState, IMSettingAction> flowReduxStoreBuilder, final SettingReportService reportService) {
        Intrinsics.checkNotNullParameter(flowReduxStoreBuilder, "<this>");
        Intrinsics.checkNotNullParameter(reportService, "reportService");
        Function1 block$iv = new Function1() { // from class: im.setting.track.TrackerKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit bindTracker$lambda$0;
                bindTracker$lambda$0 = TrackerKt.bindTracker$lambda$0(SettingReportService.this, (InStateBuilderBlock) obj);
                return bindTracker$lambda$0;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(IMSettingState.class), block$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindTracker$lambda$0(SettingReportService $reportService, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new TrackerKt$bindTracker$1$1($reportService, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.onActionEffect(Reflection.getOrCreateKotlinClass(IMSettingAction.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv2 = new TrackerKt$bindTracker$1$2($reportService, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.onActionEffect(Reflection.getOrCreateKotlinClass(IMSettingItemExposureAction.class), executionPolicy$iv2, handler$iv2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportClick(IMSettingAction action, Map<String, String> map) {
        KSettingSwitch value;
        KSettingSwitch value2;
        Map extra = new LinkedHashMap();
        if (action instanceof IMSettingSwitchAction) {
            KSetting.KSwitch content = ((IMSettingSwitchAction) action).getItem().getSetting().getContent();
            KSwitchConfirmDialog kSwitchConfirmDialog = null;
            KSetting.KSwitch kSwitch = content instanceof KSetting.KSwitch ? content : null;
            if (((IMSettingSwitchAction) action).getOn()) {
                if (kSwitch != null && (value2 = kSwitch.getValue()) != null) {
                    kSwitchConfirmDialog = value2.getOnDialog();
                }
            } else if (kSwitch != null && (value = kSwitch.getValue()) != null) {
                kSwitchConfirmDialog = value.getOffDialog();
            }
            KSwitchConfirmDialog dialog = kSwitchConfirmDialog;
            if (dialog == null) {
                extra.put("module", moduleName(((IMSettingSwitchAction) action).getItem()));
                extra.put("click_type", ((IMSettingSwitchAction) action).getOn() ? "1" : "0");
            } else {
                return;
            }
        } else if (action instanceof IMSettingSelectAction) {
            extra.put("module", moduleName(((IMSettingSelectAction) action).getItem()));
            extra.put("item_type", String.valueOf(((IMSettingSelectAction) action).getSelectType()));
        } else if (action instanceof IMSettingDialogConfirmAction) {
            extra.put("module", moduleName(((IMSettingDialogConfirmAction) action).getItem()));
            extra.put("click_type", ((IMSettingDialogConfirmAction) action).getOperateOn() ? "1" : "0");
        } else {
            return;
        }
        KNeuron.INSTANCE.reportClick(false, "im.im-setting.setting.all.click", MapsKt.plus(extra, map));
    }

    private static final String moduleName(SettingItem $this$moduleName) {
        if ($this$moduleName instanceof SettingItem.Setting) {
            return ((SettingItem.Setting) $this$moduleName).getType().toString();
        }
        if ($this$moduleName instanceof SettingItem.UserInfo) {
            return "SETTING_TYPE_USER_INFO";
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportExposure(IMSettingItemExposureAction action, Map<String, String> map) {
        Map extra = new LinkedHashMap();
        extra.put("module", moduleName(action.getItem()));
        KNeuron.INSTANCE.reportExposure(false, "im.im-setting.setting.all.show", MapsKt.plus(extra, map));
    }
}