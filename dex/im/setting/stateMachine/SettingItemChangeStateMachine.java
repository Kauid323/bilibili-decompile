package im.setting.stateMachine;

import com.bapis.bilibili.app.im.v1.KIMSettingType;
import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStateMachine;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import com.freeletics.flowredux.dsl.State;
import com.tencent.open.SocialConstants;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedInject;
import im.base.IMToast;
import im.setting.IMSettingDialog;
import im.setting.model.SettingItem;
import im.setting.model.extension.SettingItemExtKt;
import im.setting.service.SettingChangeService;
import im.setting.stateMachine.IMSettingItemAction;
import im.setting.stateMachine.IMSettingItemChangeTask;
import im.setting.stateMachine.IMSettingItemStatus;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.datetime.Clock;

/* compiled from: SettingItemChangeStateMachine.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B%\b\u0007\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\r*\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0082@¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lim/setting/stateMachine/SettingItemChangeStateMachine;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Lim/setting/stateMachine/IMSettingItemStatus;", "Lim/setting/stateMachine/IMSettingItemAction;", "item", "Lim/setting/model/SettingItem$Setting;", "task", "Lim/setting/stateMachine/IMSettingItemChangeTask;", "changeService", "Lim/setting/service/SettingChangeService;", "<init>", "(Lim/setting/model/SettingItem$Setting;Lim/setting/stateMachine/IMSettingItemChangeTask;Lim/setting/service/SettingChangeService;)V", SocialConstants.TYPE_REQUEST, "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lcom/freeletics/flowredux/dsl/State;", "Lim/setting/stateMachine/IMSettingItemStatus$Loading;", "(Lcom/freeletics/flowredux/dsl/State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SettingItemChangeStateMachine extends FlowReduxStateMachine<IMSettingItemStatus, IMSettingItemAction> {
    public static final int $stable = 8;
    private final SettingChangeService changeService;
    private final SettingItem.Setting item;
    private final IMSettingItemChangeTask task;

    /* JADX WARN: Illegal instructions before constructor call */
    @AssistedInject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SettingItemChangeStateMachine(@Assisted("") SettingItem.Setting item, @Assisted("") IMSettingItemChangeTask task, SettingChangeService changeService) {
        super(new IMSettingItemStatus.Pending(r1, r2));
        IMSettingDialog dialog;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(changeService, "changeService");
        KIMSettingType type = item.getType();
        dialog = SettingItemChangeStateMachineKt.dialog(item, task);
        this.item = item;
        this.task = task;
        this.changeService = changeService;
        KLog_androidKt.getKLog().i("IMSetting", "子状态机 type: " + this.item.getType() + " 初始化");
        spec(new Function1() { // from class: im.setting.stateMachine.SettingItemChangeStateMachine$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = SettingItemChangeStateMachine._init_$lambda$0(SettingItemChangeStateMachine.this, (FlowReduxStoreBuilder) obj);
                return _init_$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(final SettingItemChangeStateMachine this$0, FlowReduxStoreBuilder $this$spec) {
        Intrinsics.checkNotNullParameter($this$spec, "$this$spec");
        Function1 block$iv = new Function1() { // from class: im.setting.stateMachine.SettingItemChangeStateMachine$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                return SettingItemChangeStateMachine.lambda$0$0(SettingItemChangeStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(IMSettingItemStatus.Pending.class), block$iv);
        Function1 block$iv2 = new Function1() { // from class: im.setting.stateMachine.SettingItemChangeStateMachine$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                return SettingItemChangeStateMachine.lambda$0$1(SettingItemChangeStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(IMSettingItemStatus.Loading.class), block$iv2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0(final SettingItemChangeStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.condition(new Function1() { // from class: im.setting.stateMachine.SettingItemChangeStateMachine$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return Boolean.valueOf(SettingItemChangeStateMachine.lambda$0$0$0((IMSettingItemStatus.Pending) obj));
            }
        }, new Function1() { // from class: im.setting.stateMachine.SettingItemChangeStateMachine$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return SettingItemChangeStateMachine.lambda$0$0$1(SettingItemChangeStateMachine.this, (ConditionBuilderBlock) obj);
            }
        });
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new SettingItemChangeStateMachine$1$1$3(this$0, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(IMSettingItemAction.Confirm.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv2 = new SettingItemChangeStateMachine$1$1$4(this$0, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(IMSettingItemAction.Cancel.class), executionPolicy$iv2, handler$iv2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean lambda$0$0$0(IMSettingItemStatus.Pending it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getDialog() == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0$1(SettingItemChangeStateMachine this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnterEffect(new SettingItemChangeStateMachine$1$1$2$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$1(SettingItemChangeStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new SettingItemChangeStateMachine$1$2$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object request(State<IMSettingItemStatus.Loading> state, Continuation<? super ChangedState<? extends IMSettingItemStatus>> continuation) {
        Continuation<? super Result<String>> settingItemChangeStateMachine$request$1;
        SettingItem.Setting changedItem;
        Object mo3403changegIAlus;
        final SettingItem.Setting changedItem2;
        Throwable it;
        Object create;
        SettingItem.Setting changedItem3;
        if (continuation instanceof SettingItemChangeStateMachine$request$1) {
            settingItemChangeStateMachine$request$1 = (SettingItemChangeStateMachine$request$1) continuation;
            if ((settingItemChangeStateMachine$request$1.label & Integer.MIN_VALUE) != 0) {
                settingItemChangeStateMachine$request$1.label -= Integer.MIN_VALUE;
                Object $result = settingItemChangeStateMachine$request$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (settingItemChangeStateMachine$request$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        KLog_androidKt.getKLog().i("IMSetting", "子状态机 type: " + this.item.getType() + ", 接收事件 action: " + this.task);
                        IMSettingItemChangeTask iMSettingItemChangeTask = this.task;
                        if (iMSettingItemChangeTask instanceof IMSettingItemChangeTask.Switch) {
                            changedItem = SettingItemExtKt.transformWithSwitch(this.item, ((IMSettingItemChangeTask.Switch) this.task).getOn());
                        } else if (!(iMSettingItemChangeTask instanceof IMSettingItemChangeTask.Select)) {
                            throw new NoWhenBranchMatchedException();
                        } else {
                            changedItem = SettingItemExtKt.transformWithSelect(this.item, ((IMSettingItemChangeTask.Select) this.task).getSelectType());
                        }
                        SettingChangeService settingChangeService = this.changeService;
                        settingItemChangeStateMachine$request$1.L$0 = state;
                        settingItemChangeStateMachine$request$1.L$1 = changedItem;
                        settingItemChangeStateMachine$request$1.label = 1;
                        mo3403changegIAlus = settingChangeService.mo3403changegIAlus(changedItem, settingItemChangeStateMachine$request$1);
                        if (mo3403changegIAlus == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        changedItem2 = changedItem;
                        it = Result.exceptionOrNull-impl(mo3403changegIAlus);
                        if (it != null) {
                            final String it2 = (String) mo3403changegIAlus;
                            return state.override(new Function1() { // from class: im.setting.stateMachine.SettingItemChangeStateMachine$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj) {
                                    IMSettingItemStatus.Done request$lambda$0$0;
                                    request$lambda$0$0 = SettingItemChangeStateMachine.request$lambda$0$0(SettingItem.Setting.this, it2, (IMSettingItemStatus.Loading) obj);
                                    return request$lambda$0$0;
                                }
                            });
                        }
                        IMToast.Companion companion = IMToast.Companion;
                        settingItemChangeStateMachine$request$1.L$0 = state;
                        settingItemChangeStateMachine$request$1.L$1 = SpillingKt.nullOutSpilledVariable(changedItem2);
                        settingItemChangeStateMachine$request$1.L$2 = SpillingKt.nullOutSpilledVariable(it);
                        settingItemChangeStateMachine$request$1.I$0 = 0;
                        settingItemChangeStateMachine$request$1.label = 2;
                        create = companion.create(it, (r12 & 2) != 0 ? "" : null, (r12 & 4) != 0 ? Clock.System.INSTANCE.now() : null, (r12 & 8) != 0 ? null : null, settingItemChangeStateMachine$request$1);
                        if (create == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        changedItem3 = changedItem2;
                        final IMToast imToast = (IMToast) create;
                        return state.override(new Function1() { // from class: im.setting.stateMachine.SettingItemChangeStateMachine$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj) {
                                IMSettingItemStatus.Done request$lambda$1$0;
                                request$lambda$1$0 = SettingItemChangeStateMachine.request$lambda$1$0(SettingItemChangeStateMachine.this, imToast, (IMSettingItemStatus.Loading) obj);
                                return request$lambda$1$0;
                            }
                        });
                    case 1:
                        SettingItem.Setting changedItem4 = (SettingItem.Setting) settingItemChangeStateMachine$request$1.L$1;
                        state = (State) settingItemChangeStateMachine$request$1.L$0;
                        ResultKt.throwOnFailure($result);
                        mo3403changegIAlus = ((Result) $result).unbox-impl();
                        changedItem2 = changedItem4;
                        it = Result.exceptionOrNull-impl(mo3403changegIAlus);
                        if (it != null) {
                        }
                        break;
                    case 2:
                        int i2 = settingItemChangeStateMachine$request$1.I$0;
                        Throwable th = (Throwable) settingItemChangeStateMachine$request$1.L$2;
                        changedItem3 = (SettingItem.Setting) settingItemChangeStateMachine$request$1.L$1;
                        state = (State) settingItemChangeStateMachine$request$1.L$0;
                        ResultKt.throwOnFailure($result);
                        create = $result;
                        final IMToast imToast2 = (IMToast) create;
                        return state.override(new Function1() { // from class: im.setting.stateMachine.SettingItemChangeStateMachine$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj) {
                                IMSettingItemStatus.Done request$lambda$1$0;
                                request$lambda$1$0 = SettingItemChangeStateMachine.request$lambda$1$0(SettingItemChangeStateMachine.this, imToast2, (IMSettingItemStatus.Loading) obj);
                                return request$lambda$1$0;
                            }
                        });
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        settingItemChangeStateMachine$request$1 = new SettingItemChangeStateMachine$request$1(this, continuation);
        Object $result2 = settingItemChangeStateMachine$request$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (settingItemChangeStateMachine$request$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMSettingItemStatus.Done request$lambda$0$0(SettingItem.Setting $changedItem, String $it, IMSettingItemStatus.Loading $this$override) {
        Intrinsics.checkNotNullParameter($this$override, "$this$override");
        return new IMSettingItemStatus.Done($this$override.getType(), true, SettingItem.Setting.copy$default($changedItem, null, null, false, false, 7, null), IMToast.Companion.create$default(IMToast.Companion, $it, null, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMSettingItemStatus.Done request$lambda$1$0(SettingItemChangeStateMachine this$0, IMToast $imToast, IMSettingItemStatus.Loading $this$override) {
        Intrinsics.checkNotNullParameter($this$override, "$this$override");
        return new IMSettingItemStatus.Done($this$override.getType(), false, SettingItem.Setting.copy$default(this$0.item, null, null, false, false, 7, null), $imToast);
    }
}