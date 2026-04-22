package home.sidecenter.settings;

import com.bapis.bilibili.app.home.v1.KHomeMoss;
import com.bapis.bilibili.app.home.v1.KTabSelection;
import com.bapis.bilibili.app.home.v1.KTabUpdateSource;
import com.bapis.bilibili.app.home.v1.KTopLeftGoto;
import com.bapis.bilibili.app.home.v1.KTopLeftTabUpdateReq;
import com.bapis.bilibili.app.home.v1.KTopLeftTabUpdateRes;
import home.sidecenter.settings.ISideCenterSettingsAction;
import kntr.base.log.KLog_androidKt;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SideCenterSettingsHolder.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lhome/sidecenter/settings/ISideCenterSettingsAction;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "home.sidecenter.settings.SideCenterSettingsHolder$setItemSwitch$1", f = "SideCenterSettingsHolder.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {279, 280, 288}, m = "invokeSuspend", n = {"$this$SideCenterSettingsActionResult", "req", "$this$SideCenterSettingsActionResult", "req", "rsp", "$this$SideCenterSettingsActionResult", "req", "e"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 1)
public final class SideCenterSettingsHolder$setItemSwitch$1 extends SuspendLambda implements Function2<FlowCollector<? super ISideCenterSettingsAction>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ISideCenterSettingsAction.CheckSettingItem $action;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ SideCenterSettingsHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SideCenterSettingsHolder$setItemSwitch$1(ISideCenterSettingsAction.CheckSettingItem checkSettingItem, SideCenterSettingsHolder sideCenterSettingsHolder, Continuation<? super SideCenterSettingsHolder$setItemSwitch$1> continuation) {
        super(2, continuation);
        this.$action = checkSettingItem;
        this.this$0 = sideCenterSettingsHolder;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> sideCenterSettingsHolder$setItemSwitch$1 = new SideCenterSettingsHolder$setItemSwitch$1(this.$action, this.this$0, continuation);
        sideCenterSettingsHolder$setItemSwitch$1.L$0 = obj;
        return sideCenterSettingsHolder$setItemSwitch$1;
    }

    public final Object invoke(FlowCollector<? super ISideCenterSettingsAction> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x01d3: INVOKE  (r7 I:java.lang.Object) = (r5 I:java.lang.Object A[D('req' com.bapis.bilibili.app.home.v1.KTopLeftTabUpdateReq)]) type: STATIC call: kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(java.lang.Object):java.lang.Object, block:B:56:0x01b3 */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01b1 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object nullOutSpilledVariable;
        Object obj;
        KTopLeftTabUpdateReq kTopLeftTabUpdateReq;
        SideCenterSettingsState currentState;
        KTabSelection kTabSelection;
        SideCenterSettingsState currentState2;
        SideCenterSettingsState currentState3;
        KTabSelection kTabSelection2;
        SideCenterSettingsState currentState4;
        KTopLeftTabUpdateReq req;
        Object obj2;
        KTopLeftTabUpdateRes rsp;
        FlowCollector $this$SideCenterSettingsActionResult = (FlowCollector) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (Exception e2) {
            KLog_androidKt.getKLog().i("SideCenterSettingsHolder", "Failed check settings item");
            this.L$0 = SpillingKt.nullOutSpilledVariable($this$SideCenterSettingsActionResult);
            this.L$1 = SpillingKt.nullOutSpilledVariable(nullOutSpilledVariable);
            this.L$2 = SpillingKt.nullOutSpilledVariable(e2);
            this.label = 3;
            if ($this$SideCenterSettingsActionResult.emit(new ISideCenterSettingsAction.SettingItemSwitchFailed(this.$action.getItem(), e2), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = nullOutSpilledVariable;
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                ISideCenterSettingsAction.CheckSettingItem checkSettingItem = this.$action;
                SideCenterSettingsHolder sideCenterSettingsHolder = this.this$0;
                if (checkSettingItem.getItem().getTab() == SideCenterSettingType.Mine) {
                    kTopLeftTabUpdateReq = new KTopLeftTabUpdateReq(KTopLeftGoto.GOTO_MINE.INSTANCE, KTabSelection.TS_UNKNOWN.INSTANCE, (KTabUpdateSource) null, 4, (DefaultConstructorMarker) null);
                } else if (checkSettingItem.getItem().getTab() == SideCenterSettingType.Recent) {
                    kTopLeftTabUpdateReq = new KTopLeftTabUpdateReq(KTopLeftGoto.GOTO_RECENT.INSTANCE, KTabSelection.TS_ONLY_RECENT.INSTANCE, (KTabUpdateSource) null, 4, (DefaultConstructorMarker) null);
                } else if (checkSettingItem.getItem().getTab() == SideCenterSettingType.Story) {
                    KTopLeftGoto kTopLeftGoto = KTopLeftGoto.GOTO_RECENT.INSTANCE;
                    if (checkSettingItem.getItem().isChecked()) {
                        currentState4 = sideCenterSettingsHolder.getCurrentState();
                        kTabSelection2 = currentState4.isTabChecked(SideCenterSettingType.Listen) ? (KTabSelection) KTabSelection.TS_ONLY_LISTEN.INSTANCE : (KTabSelection) KTabSelection.TS_ONLY_RECENT.INSTANCE;
                    } else {
                        currentState3 = sideCenterSettingsHolder.getCurrentState();
                        kTabSelection2 = currentState3.isTabChecked(SideCenterSettingType.Listen) ? (KTabSelection) KTabSelection.TS_ALL.INSTANCE : KTabSelection.TS_ONLY_STORY.INSTANCE;
                    }
                    kTopLeftTabUpdateReq = new KTopLeftTabUpdateReq(kTopLeftGoto, kTabSelection2, (KTabUpdateSource) null, 4, (DefaultConstructorMarker) null);
                } else if (checkSettingItem.getItem().getTab() == SideCenterSettingType.Listen) {
                    KTopLeftGoto kTopLeftGoto2 = KTopLeftGoto.GOTO_RECENT.INSTANCE;
                    if (checkSettingItem.getItem().isChecked()) {
                        currentState2 = sideCenterSettingsHolder.getCurrentState();
                        kTabSelection = currentState2.isTabChecked(SideCenterSettingType.Story) ? (KTabSelection) KTabSelection.TS_ONLY_STORY.INSTANCE : (KTabSelection) KTabSelection.TS_ONLY_RECENT.INSTANCE;
                    } else {
                        currentState = sideCenterSettingsHolder.getCurrentState();
                        kTabSelection = currentState.isTabChecked(SideCenterSettingType.Story) ? (KTabSelection) KTabSelection.TS_ALL.INSTANCE : KTabSelection.TS_ONLY_LISTEN.INSTANCE;
                    }
                    kTopLeftTabUpdateReq = new KTopLeftTabUpdateReq(kTopLeftGoto2, kTabSelection, (KTabUpdateSource) null, 4, (DefaultConstructorMarker) null);
                } else {
                    kTopLeftTabUpdateReq = new KTopLeftTabUpdateReq(KTopLeftGoto.GOTO_UNKNOWN.INSTANCE, KTabSelection.TS_UNKNOWN.INSTANCE, (KTabUpdateSource) null, 4, (DefaultConstructorMarker) null);
                }
                req = kTopLeftTabUpdateReq;
                KLog_androidKt.getKLog().i("SideCenterSettingsHolder", "Start check settings item");
                this.L$0 = $this$SideCenterSettingsActionResult;
                this.L$1 = SpillingKt.nullOutSpilledVariable(req);
                this.label = 1;
                obj2 = new KHomeMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null).topLeftTabUpdate(req, (Continuation) this);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                rsp = (KTopLeftTabUpdateRes) obj2;
                this.L$0 = $this$SideCenterSettingsActionResult;
                this.L$1 = SpillingKt.nullOutSpilledVariable(req);
                this.L$2 = SpillingKt.nullOutSpilledVariable(rsp);
                this.label = 2;
                if ($this$SideCenterSettingsActionResult.emit(new ISideCenterSettingsAction.SettingItemSwitchSuccess(this.$action.getItem(), rsp.toString()), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                req = (KTopLeftTabUpdateReq) this.L$1;
                ResultKt.throwOnFailure($result);
                obj2 = $result;
                rsp = (KTopLeftTabUpdateRes) obj2;
                this.L$0 = $this$SideCenterSettingsActionResult;
                this.L$1 = SpillingKt.nullOutSpilledVariable(req);
                this.L$2 = SpillingKt.nullOutSpilledVariable(rsp);
                this.label = 2;
                if ($this$SideCenterSettingsActionResult.emit(new ISideCenterSettingsAction.SettingItemSwitchSuccess(this.$action.getItem(), rsp.toString()), (Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 2:
                KTopLeftTabUpdateRes kTopLeftTabUpdateRes = (KTopLeftTabUpdateRes) this.L$2;
                KTopLeftTabUpdateReq kTopLeftTabUpdateReq2 = (KTopLeftTabUpdateReq) this.L$1;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            case 3:
                Exception exc = (Exception) this.L$2;
                obj = (KTopLeftTabUpdateReq) this.L$1;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}