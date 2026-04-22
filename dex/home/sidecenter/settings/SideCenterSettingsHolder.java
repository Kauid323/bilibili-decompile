package home.sidecenter.settings;

import bili.resource.homepage.HomepageRes;
import bili.resource.homepage.String0_commonMainKt;
import com.tencent.tauth.AuthActivity;
import home.sidecenter.settings.ISideCenterSettingsAction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: SideCenterSettingsHolder.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010\u001e\u001a\u00020\u001cH\u0002J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020 H\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00108\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"Lhome/sidecenter/settings/SideCenterSettingsHolder;", "", "context", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Lkotlin/coroutines/CoroutineContext;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope$sidecenter_debug$annotations", "()V", "getScope$sidecenter_debug", "()Lkotlinx/coroutines/CoroutineScope;", "_stateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lhome/sidecenter/settings/SideCenterSettingsState;", "stateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getStateFlow$annotations", "getStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "currentState", "getCurrentState", "()Lhome/sidecenter/settings/SideCenterSettingsState;", "handleAction", "", AuthActivity.ACTION_KEY, "Lhome/sidecenter/settings/ISideCenterSettingsAction;", "dispatchAction", "Lhome/sidecenter/settings/SideCenterSettingsActionResult;", "startToastTimer", "loadData", "setItemSwitch", "Lhome/sidecenter/settings/ISideCenterSettingsAction$CheckSettingItem;", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SideCenterSettingsHolder {
    public static final int $stable = 8;
    private final MutableStateFlow<SideCenterSettingsState> _stateFlow;
    private final CoroutineScope scope;
    private final StateFlow<SideCenterSettingsState> stateFlow;

    public static /* synthetic */ void getScope$sidecenter_debug$annotations() {
    }

    public static /* synthetic */ void getStateFlow$annotations() {
    }

    public SideCenterSettingsHolder(CoroutineContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.scope = CoroutineScopeKt.CoroutineScope(context);
        this._stateFlow = StateFlowKt.MutableStateFlow(new SideCenterSettingsState(SideCenterSettingsPageStatus.Idle, null, null, null, 0, 30, null));
        this.stateFlow = FlowKt.asStateFlow(this._stateFlow);
    }

    public final CoroutineScope getScope$sidecenter_debug() {
        return this.scope;
    }

    public final StateFlow<SideCenterSettingsState> getStateFlow() {
        return this.stateFlow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SideCenterSettingsState getCurrentState() {
        return (SideCenterSettingsState) this.stateFlow.getValue();
    }

    public final void handleAction(ISideCenterSettingsAction action) {
        Intrinsics.checkNotNullParameter(action, AuthActivity.ACTION_KEY);
        KLog_androidKt.getKLog().d("SideCenterSettingsHolder", "handleAction: " + action);
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new SideCenterSettingsHolder$handleAction$1(this, action, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SideCenterSettingsActionResult dispatchAction(SideCenterSettingsState currentState, ISideCenterSettingsAction action) {
        if (action instanceof ISideCenterSettingsAction.LoadData) {
            return loadData();
        }
        if (action instanceof ISideCenterSettingsAction.LoadDataSuccess) {
            return new SideCenterSettingsActionResult(((ISideCenterSettingsAction.LoadDataSuccess) action).getState(), null, 2, null);
        }
        if (action instanceof ISideCenterSettingsAction.LoadDataFailed) {
            return new SideCenterSettingsActionResult(SideCenterSettingsState.copy$default(currentState, SideCenterSettingsPageStatus.Error, null, null, null, 0, 30, null), null, 2, null);
        }
        if (action instanceof ISideCenterSettingsAction.CheckSettingItem) {
            return setItemSwitch((ISideCenterSettingsAction.CheckSettingItem) action);
        }
        if (action instanceof ISideCenterSettingsAction.SettingItemSwitchSuccess) {
            boolean showSettingToast = ((ISideCenterSettingsAction.SettingItemSwitchSuccess) action).getItem().getTab() == SideCenterSettingType.Mine;
            SideCenterSettingsPageStatus sideCenterSettingsPageStatus = SideCenterSettingsPageStatus.Success;
            Iterable $this$map$iv = currentState.getSettingGroups();
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                ISideCenterSettingGroup it = (ISideCenterSettingGroup) item$iv$iv;
                destination$iv$iv.add(((ISideCenterSettingsAction.SettingItemSwitchSuccess) action).getItem().getTab().isGroup() ? it.setItemChecked(it, it.getTab() == ((ISideCenterSettingsAction.SettingItemSwitchSuccess) action).getItem().getTab()) : it.setItemChecked(((ISideCenterSettingsAction.SettingItemSwitchSuccess) action).getItem(), !((ISideCenterSettingsAction.SettingItemSwitchSuccess) action).getItem().isChecked()));
            }
            return new SideCenterSettingsActionResult(SideCenterSettingsState.copy$default(currentState, sideCenterSettingsPageStatus, (List) destination$iv$iv, null, null, 0, 28, null), new SideCenterSettingsHolder$dispatchAction$2(showSettingToast, action, null));
        } else if (action instanceof ISideCenterSettingsAction.SettingItemSwitchFailed) {
            return new SideCenterSettingsActionResult(SideCenterSettingsState.copy$default(currentState, SideCenterSettingsPageStatus.Error, null, null, null, 0, 30, null), null, 2, null);
        } else {
            if (action instanceof ISideCenterSettingsAction.CheckedMineTabToastShow) {
                return startToastTimer();
            }
            if (!(action instanceof ISideCenterSettingsAction.CheckedMineTabToastDismiss)) {
                throw new NoWhenBranchMatchedException();
            }
            return new SideCenterSettingsActionResult(SideCenterSettingsState.copy$default(currentState, null, null, null, "", currentState.getToastDismissDelayId$sidecenter_debug() + 1, 7, null), null, 2, null);
        }
    }

    private final SideCenterSettingsActionResult startToastTimer() {
        return new SideCenterSettingsActionResult(SideCenterSettingsState.copy$default(getCurrentState(), null, null, null, HomepageRes.INSTANCE.getString(String0_commonMainKt.getHomepage_global_string_438(HomepageRes.INSTANCE.getString())), 0, 23, null), new SideCenterSettingsHolder$startToastTimer$1(this, null));
    }

    private final SideCenterSettingsActionResult loadData() {
        return new SideCenterSettingsActionResult(SideCenterSettingsState.copy$default(getCurrentState(), SideCenterSettingsPageStatus.Loading, null, null, null, 0, 30, null), new SideCenterSettingsHolder$loadData$1(null));
    }

    private final SideCenterSettingsActionResult setItemSwitch(ISideCenterSettingsAction.CheckSettingItem action) {
        return new SideCenterSettingsActionResult(SideCenterSettingsState.copy$default(getCurrentState(), SideCenterSettingsPageStatus.SettingLoading, null, null, null, 0, 30, null), new SideCenterSettingsHolder$setItemSwitch$1(action, this, null));
    }
}