package tv.danmaku.bili.ui.personinfo.modifyNameV2;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import tv.danmaku.bili.ui.personinfo.modifyNameV2.ModifyNameV2Intent;
import tv.danmaku.bili.ui.personinfo.modifyNameV2.PageState;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ModifyNameViewModelV2.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\b\u0010\u001b\u001a\u00020\u0017H\u0002J\b\u0010\u001c\u001a\u00020\u0017H\u0002J,\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\u001f2\b\u0010\"\u001a\u0004\u0018\u00010\u001fH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Ltv/danmaku/bili/ui/personinfo/modifyNameV2/ModifyNameViewModelV2;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_stateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ltv/danmaku/bili/ui/personinfo/modifyNameV2/ViewState;", "pageStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getPageStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "_eventFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Ltv/danmaku/bili/ui/personinfo/modifyNameV2/ModifyNameV2Event;", "pageEventFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getPageEventFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "setPageEventFlow", "(Lkotlinx/coroutines/flow/SharedFlow;)V", "unameMsg", "Ltv/danmaku/bili/ui/personinfo/modifyNameV2/UnameMessageBean;", "sendIntent", "", "intent", "Ltv/danmaku/bili/ui/personinfo/modifyNameV2/ModifyNameV2Intent;", "handleGetCopyWriteIntent", "getNickNameCopyWrite", "handleSubmitIntent", "handleUseSubmitIntent", "uname", "", "source", "from", LoginSceneProcessor.SCENE_KEY, "Companion", "personinfo_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ModifyNameViewModelV2 extends ViewModel {
    private static final String TAG = "ModifyNameViewModel";
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final MutableStateFlow<ViewState> _stateFlow = StateFlowKt.MutableStateFlow(new ViewState(null, null, 3, null));
    private final StateFlow<ViewState> pageStateFlow = FlowKt.asStateFlow(this._stateFlow);
    private final MutableSharedFlow<ModifyNameV2Event> _eventFlow = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
    private SharedFlow<? extends ModifyNameV2Event> pageEventFlow = FlowKt.asSharedFlow(this._eventFlow);
    private final UnameMessageBean unameMsg = new UnameMessageBean(false, false, null, null, null, null, 63, null);

    /* compiled from: ModifyNameViewModelV2.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/personinfo/modifyNameV2/ModifyNameViewModelV2$Companion;", "", "<init>", "()V", "TAG", "", "personinfo_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final StateFlow<ViewState> getPageStateFlow() {
        return this.pageStateFlow;
    }

    public final SharedFlow<ModifyNameV2Event> getPageEventFlow() {
        return this.pageEventFlow;
    }

    public final void setPageEventFlow(SharedFlow<? extends ModifyNameV2Event> sharedFlow) {
        Intrinsics.checkNotNullParameter(sharedFlow, "<set-?>");
        this.pageEventFlow = sharedFlow;
    }

    public final void sendIntent(ModifyNameV2Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof ModifyNameV2Intent.SaveSubmitIntent) {
            handleSubmitIntent();
        } else if (intent instanceof ModifyNameV2Intent.GetNickNameCopyWriteIntent) {
            handleGetCopyWriteIntent();
        } else if (!(intent instanceof ModifyNameV2Intent.UseAndSubmitIntent)) {
            throw new NoWhenBranchMatchedException();
        } else {
            handleUseSubmitIntent(((ModifyNameV2Intent.UseAndSubmitIntent) intent).getName(), ((ModifyNameV2Intent.UseAndSubmitIntent) intent).getSource(), ((ModifyNameV2Intent.UseAndSubmitIntent) intent).getFrom(), ((ModifyNameV2Intent.UseAndSubmitIntent) intent).getScene());
        }
    }

    private final void handleGetCopyWriteIntent() {
        ViewState currentState = (ViewState) this._stateFlow.getValue();
        this._stateFlow.setValue(ViewState.copy$default(currentState, PageState.ShowLoading.INSTANCE, null, 2, null));
        getNickNameCopyWrite();
    }

    private final void getNickNameCopyWrite() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ModifyNameViewModelV2$getNickNameCopyWrite$1(this, null), 3, (Object) null);
    }

    private final void handleSubmitIntent() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ModifyNameViewModelV2$handleSubmitIntent$1(this, null), 3, (Object) null);
    }

    private final void handleUseSubmitIntent(String uname, String source, String from, String scene) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ModifyNameViewModelV2$handleUseSubmitIntent$1(this, uname, source, from, scene, null), 3, (Object) null);
    }
}