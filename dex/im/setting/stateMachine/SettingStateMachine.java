package im.setting.stateMachine;

import bili.resource.im.ImRes;
import bili.resource.im.String0_commonMainKt;
import com.bapis.bilibili.app.im.v1.KSetting;
import com.bapis.bilibili.app.im.v1.KSettingRedirect;
import com.bilibili.blens.BSimpleLens;
import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStateMachine;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import com.freeletics.flowredux.dsl.State;
import com.freeletics.mad.statemachine.StateMachine;
import com.tencent.tauth.AuthActivity;
import im.base.IMRouteHolder;
import im.base.IMToast;
import im.setting.IMSettingAction;
import im.setting.IMSettingCloseSelectWindowAction;
import im.setting.IMSettingDialog;
import im.setting.IMSettingDialogCancelAction;
import im.setting.IMSettingDialogConfirmAction;
import im.setting.IMSettingLoadAction;
import im.setting.IMSettingRedirectAction;
import im.setting.IMSettingSelectAction;
import im.setting.IMSettingState;
import im.setting.IMSettingStateLensKt;
import im.setting.IMSettingStateTypeError;
import im.setting.IMSettingStateTypeIdle;
import im.setting.IMSettingStateTypeLoading;
import im.setting.IMSettingStateTypeSuccess;
import im.setting.IMSettingSwitchAction;
import im.setting.IMSettingUserInfoAction;
import im.setting.IMSettingWindowSelect;
import im.setting.di.SettingScope;
import im.setting.evethub.SettingEventHub;
import im.setting.model.IMSettingPageData;
import im.setting.model.SettingItem;
import im.setting.model.extension.KSettingRedirectExtKt;
import im.setting.model.extension.SettingGroupExtKt;
import im.setting.service.SettingNotifyService;
import im.setting.service.SettingReportService;
import im.setting.service.SettingRequestService;
import im.setting.stateMachine.IMSettingItemAction;
import im.setting.stateMachine.IMSettingItemChangeTask;
import im.setting.track.TrackerKt;
import javax.inject.Inject;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;
import kotlinx.datetime.Clock;
import org.jetbrains.compose.resources.StringResource;

/* compiled from: SettingStateMachine.kt */
@SettingScope
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B)\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f*\b\u0012\u0004\u0012\u00020\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0082@¢\u0006\u0002\u0010\u0013J \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f*\b\u0012\u0004\u0012\u00020\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0015H\u0002J\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f*\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0002J,\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f*\b\u0012\u0004\u0012\u00020\u00020\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0082@¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lim/setting/stateMachine/SettingStateMachine;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Lim/setting/IMSettingState;", "Lim/setting/IMSettingAction;", "notifyService", "Lim/setting/service/SettingNotifyService;", "requestService", "Lim/setting/service/SettingRequestService;", "itemChangeStateMachineBuilder", "Lim/setting/stateMachine/SettingItemChangeStateMachineBuilder;", "reportService", "Lim/setting/service/SettingReportService;", "<init>", "(Lim/setting/service/SettingNotifyService;Lim/setting/service/SettingRequestService;Lim/setting/stateMachine/SettingItemChangeStateMachineBuilder;Lim/setting/service/SettingReportService;)V", "onClickRedirectItem", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lcom/freeletics/flowredux/dsl/State;", AuthActivity.ACTION_KEY, "Lim/setting/IMSettingRedirectAction;", "(Lcom/freeletics/flowredux/dsl/State;Lim/setting/IMSettingRedirectAction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onClickUserInfoItem", "Lim/setting/IMSettingUserInfoAction;", "onCloseSelectWindowAction", "receive", "result", "Lkotlin/Result;", "Lim/setting/model/IMSettingPageData;", "(Lcom/freeletics/flowredux/dsl/State;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SettingStateMachine extends FlowReduxStateMachine<IMSettingState, IMSettingAction> {
    public static final int $stable = 8;
    private final SettingItemChangeStateMachineBuilder itemChangeStateMachineBuilder;
    private final SettingNotifyService notifyService;
    private final SettingReportService reportService;
    private final SettingRequestService requestService;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public SettingStateMachine(SettingNotifyService notifyService, SettingRequestService requestService, SettingItemChangeStateMachineBuilder itemChangeStateMachineBuilder, SettingReportService reportService) {
        super(new IMSettingState(IMSettingStateTypeIdle.INSTANCE, new IMSettingPageData(null, null, null, null, 15, null), null, null, null, null, 60, null));
        Intrinsics.checkNotNullParameter(notifyService, "notifyService");
        Intrinsics.checkNotNullParameter(requestService, "requestService");
        Intrinsics.checkNotNullParameter(itemChangeStateMachineBuilder, "itemChangeStateMachineBuilder");
        Intrinsics.checkNotNullParameter(reportService, "reportService");
        this.notifyService = notifyService;
        this.requestService = requestService;
        this.itemChangeStateMachineBuilder = itemChangeStateMachineBuilder;
        this.reportService = reportService;
        spec(new Function1() { // from class: im.setting.stateMachine.SettingStateMachine$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = SettingStateMachine._init_$lambda$0(SettingStateMachine.this, (FlowReduxStoreBuilder) obj);
                return _init_$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(final SettingStateMachine this$0, FlowReduxStoreBuilder $this$spec) {
        Intrinsics.checkNotNullParameter($this$spec, "$this$spec");
        TrackerKt.bindTracker($this$spec, this$0.reportService);
        Function1 block$iv = new Function1() { // from class: im.setting.stateMachine.SettingStateMachine$$ExternalSyntheticLambda12
            public final Object invoke(Object obj) {
                return SettingStateMachine.lambda$0$0(SettingStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(IMSettingState.class), block$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0(final SettingStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnterEffect(new SettingStateMachine$1$1$1(this$0, null));
        $this$inState.condition(new Function1() { // from class: im.setting.stateMachine.SettingStateMachine$$ExternalSyntheticLambda11
            public final Object invoke(Object obj) {
                return Boolean.valueOf(SettingStateMachine.lambda$0$0$0((IMSettingState) obj));
            }
        }, new Function1() { // from class: im.setting.stateMachine.SettingStateMachine$$ExternalSyntheticLambda17
            public final Object invoke(Object obj) {
                return SettingStateMachine.lambda$0$0$1((ConditionBuilderBlock) obj);
            }
        });
        $this$inState.condition(new Function1() { // from class: im.setting.stateMachine.SettingStateMachine$$ExternalSyntheticLambda18
            public final Object invoke(Object obj) {
                return Boolean.valueOf(SettingStateMachine.lambda$0$0$2((IMSettingState) obj));
            }
        }, new Function1() { // from class: im.setting.stateMachine.SettingStateMachine$$ExternalSyntheticLambda19
            public final Object invoke(Object obj) {
                return SettingStateMachine.lambda$0$0$3(SettingStateMachine.this, (ConditionBuilderBlock) obj);
            }
        });
        $this$inState.condition(new Function1() { // from class: im.setting.stateMachine.SettingStateMachine$$ExternalSyntheticLambda20
            public final Object invoke(Object obj) {
                return Boolean.valueOf(SettingStateMachine.lambda$0$0$4((IMSettingState) obj));
            }
        }, new Function1() { // from class: im.setting.stateMachine.SettingStateMachine$$ExternalSyntheticLambda21
            public final Object invoke(Object obj) {
                return SettingStateMachine.lambda$0$0$5(SettingStateMachine.this, (ConditionBuilderBlock) obj);
            }
        });
        $this$inState.condition(new Function1() { // from class: im.setting.stateMachine.SettingStateMachine$$ExternalSyntheticLambda22
            public final Object invoke(Object obj) {
                return Boolean.valueOf(SettingStateMachine.lambda$0$0$6((IMSettingState) obj));
            }
        }, new Function1() { // from class: im.setting.stateMachine.SettingStateMachine$$ExternalSyntheticLambda23
            public final Object invoke(Object obj) {
                return SettingStateMachine.lambda$0$0$7((ConditionBuilderBlock) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean lambda$0$0$0(IMSettingState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (it.getType() instanceof IMSettingStateTypeIdle) || (it.getType() instanceof IMSettingStateTypeError);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0$1(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new SettingStateMachine$1$1$3$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(IMSettingLoadAction.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean lambda$0$0$2(IMSettingState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getType() instanceof IMSettingStateTypeLoading;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0$3(SettingStateMachine this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new SettingStateMachine$1$1$5$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean lambda$0$0$4(IMSettingState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getType() instanceof IMSettingStateTypeSuccess;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0$5(final SettingStateMachine this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new SettingStateMachine$1$1$7$1(this$0, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.onActionEffect(Reflection.getOrCreateKotlinClass(IMSettingSelectAction.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock this_$iv = (BaseBuilderBlock) $this$condition;
        Function2 stateMachineFactory$iv = new Function2() { // from class: im.setting.stateMachine.SettingStateMachine$$ExternalSyntheticLambda3
            public final Object invoke(Object obj, Object obj2) {
                return SettingStateMachine.lambda$0$0$5$0(SettingStateMachine.this, (IMSettingSwitchAction) obj, (IMSettingState) obj2);
            }
        };
        Function1 actionMapper$iv = new Function1() { // from class: im.setting.stateMachine.SettingStateMachine$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                return SettingStateMachine.lambda$0$0$5$1((IMSettingAction) obj);
            }
        };
        Function2 stateMapper$iv = new Function2() { // from class: im.setting.stateMachine.SettingStateMachine$$ExternalSyntheticLambda5
            public final Object invoke(Object obj, Object obj2) {
                return SettingStateMachine.lambda$0$0$5$2(SettingStateMachine.this, (State) obj, (IMSettingItemStatus) obj2);
            }
        };
        this_$iv.onActionStartStateMachine(Reflection.getOrCreateKotlinClass(IMSettingSwitchAction.class), stateMachineFactory$iv, actionMapper$iv, stateMapper$iv);
        BaseBuilderBlock this_$iv2 = (BaseBuilderBlock) $this$condition;
        Function2 stateMachineFactory$iv2 = new Function2() { // from class: im.setting.stateMachine.SettingStateMachine$$ExternalSyntheticLambda6
            public final Object invoke(Object obj, Object obj2) {
                return SettingStateMachine.lambda$0$0$5$3(SettingStateMachine.this, (IMSettingSelectAction) obj, (IMSettingState) obj2);
            }
        };
        Function1 actionMapper$iv2 = new Function1() { // from class: im.setting.stateMachine.SettingStateMachine$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                return SettingStateMachine.lambda$0$0$5$4((IMSettingAction) obj);
            }
        };
        Function2 stateMapper$iv2 = new Function2() { // from class: im.setting.stateMachine.SettingStateMachine$$ExternalSyntheticLambda8
            public final Object invoke(Object obj, Object obj2) {
                return SettingStateMachine.lambda$0$0$5$5(SettingStateMachine.this, (State) obj, (IMSettingItemStatus) obj2);
            }
        };
        this_$iv2.onActionStartStateMachine(Reflection.getOrCreateKotlinClass(IMSettingSelectAction.class), stateMachineFactory$iv2, actionMapper$iv2, stateMapper$iv2);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv2 = new SettingStateMachine$1$1$7$8(this$0, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(IMSettingRedirectAction.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv3 = new SettingStateMachine$1$1$7$9(this$0, null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(IMSettingUserInfoAction.class), executionPolicy$iv3, handler$iv3);
        BaseBuilderBlock $this$iv4 = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv4 = new SettingStateMachine$1$1$7$10(this$0, null);
        ExecutionPolicy executionPolicy$iv4 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv4.on(Reflection.getOrCreateKotlinClass(IMSettingCloseSelectWindowAction.class), executionPolicy$iv4, handler$iv4);
        BaseBuilderBlock.collectWhileInState$default((BaseBuilderBlock) $this$condition, new Function1() { // from class: im.setting.stateMachine.SettingStateMachine$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                return SettingStateMachine.lambda$0$0$5$6((IMSettingState) obj);
            }
        }, (ExecutionPolicy) null, new SettingStateMachine$1$1$7$12(null), 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final StateMachine lambda$0$0$5$0(SettingStateMachine this$0, IMSettingSwitchAction action, IMSettingState stateSnapshot) {
        Intrinsics.checkNotNullParameter(action, AuthActivity.ACTION_KEY);
        Intrinsics.checkNotNullParameter(stateSnapshot, "stateSnapshot");
        KLog_androidKt.getKLog().i("IMSetting", "Setting Switch 子状态机工厂创建. type: " + action.getItem().getType());
        SettingItem.Setting item = SettingGroupExtKt.find(stateSnapshot.getData().getGroups(), action.getItem().getType());
        if (!(item instanceof SettingItem.Setting)) {
            item = null;
        }
        if (item == null) {
            KLog_androidKt.getKLog().e("IMSetting", "Setting Switch 子状态机工厂找不到 type: " + action.getItem().getType() + " 的 item");
            throw new IllegalArgumentException(Unit.INSTANCE.toString());
        }
        return this$0.itemChangeStateMachineBuilder.build(item, new IMSettingItemChangeTask.Switch(action.getOn()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final ChangedState lambda$0$0$5$2(SettingStateMachine this$0, State pageState, IMSettingItemStatus itemStatus) {
        Intrinsics.checkNotNullParameter(pageState, "pageState");
        Intrinsics.checkNotNullParameter(itemStatus, "itemStatus");
        return SettingStateMachineKt.access$childStateMapper(this$0.notifyService, pageState, itemStatus);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final IMSettingItemAction lambda$0$0$5$1(IMSettingAction action) {
        Intrinsics.checkNotNullParameter(action, AuthActivity.ACTION_KEY);
        if (action instanceof IMSettingDialogConfirmAction) {
            KSetting.IContent content = ((IMSettingDialogConfirmAction) action).getItem().getSetting().getContent();
            KSetting.IContent iContent = (KSetting.KSwitch) (content instanceof KSetting.KSwitch ? content : null);
            return IMSettingItemAction.Confirm.INSTANCE;
        } else if (action instanceof IMSettingDialogCancelAction) {
            KSetting.IContent content2 = ((IMSettingDialogCancelAction) action).getItem().getSetting().getContent();
            KSetting.IContent iContent2 = (KSetting.KSwitch) (content2 instanceof KSetting.KSwitch ? content2 : null);
            return IMSettingItemAction.Cancel.INSTANCE;
        } else {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final StateMachine lambda$0$0$5$3(SettingStateMachine this$0, IMSettingSelectAction action, IMSettingState stateSnapshot) {
        Intrinsics.checkNotNullParameter(action, AuthActivity.ACTION_KEY);
        Intrinsics.checkNotNullParameter(stateSnapshot, "stateSnapshot");
        KLog_androidKt.getKLog().i("IMSetting", "Setting Select 子状态机工厂创建. type: " + action.getItem().getType());
        SettingItem.Setting item = SettingGroupExtKt.find(stateSnapshot.getData().getGroups(), action.getItem().getType());
        if (!(item instanceof SettingItem.Setting)) {
            item = null;
        }
        if (item == null) {
            KLog_androidKt.getKLog().e("IMSetting", "Setting Select 子状态机工厂找不到 type: " + action.getItem().getType() + " 的 item");
            throw new IllegalArgumentException(Unit.INSTANCE.toString());
        }
        return this$0.itemChangeStateMachineBuilder.build(item, new IMSettingItemChangeTask.Select(action.getSelectType()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final ChangedState lambda$0$0$5$5(SettingStateMachine this$0, State pageState, IMSettingItemStatus itemStatus) {
        Intrinsics.checkNotNullParameter(pageState, "pageState");
        Intrinsics.checkNotNullParameter(itemStatus, "itemStatus");
        return SettingStateMachineKt.access$childStateMapper(this$0.notifyService, pageState, itemStatus);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final IMSettingItemAction lambda$0$0$5$4(IMSettingAction action) {
        Intrinsics.checkNotNullParameter(action, AuthActivity.ACTION_KEY);
        if (action instanceof IMSettingDialogConfirmAction) {
            KSetting.IContent content = ((IMSettingDialogConfirmAction) action).getItem().getSetting().getContent();
            KSetting.IContent iContent = (KSetting.KSelect) (content instanceof KSetting.KSelect ? content : null);
            return IMSettingItemAction.Confirm.INSTANCE;
        } else if (action instanceof IMSettingDialogCancelAction) {
            KSetting.IContent content2 = ((IMSettingDialogCancelAction) action).getItem().getSetting().getContent();
            KSetting.IContent iContent2 = (KSetting.KSelect) (content2 instanceof KSetting.KSelect ? content2 : null);
            return IMSettingItemAction.Cancel.INSTANCE;
        } else {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Flow lambda$0$0$5$6(IMSettingState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return SettingEventHub.INSTANCE.getRefreshSettingsFlow();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean lambda$0$0$6(IMSettingState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getDialog() != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0$7(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new SettingStateMachine$1$1$9$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(IMSettingDialogConfirmAction.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv2 = new SettingStateMachine$1$1$9$2(null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(IMSettingDialogCancelAction.class), executionPolicy$iv2, handler$iv2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object onClickRedirectItem(State<IMSettingState> state, final IMSettingRedirectAction action, Continuation<? super ChangedState<IMSettingState>> continuation) {
        SettingStateMachine$onClickRedirectItem$1 settingStateMachine$onClickRedirectItem$1;
        Object suspendGetString;
        IMToast.Companion companion;
        if (continuation instanceof SettingStateMachine$onClickRedirectItem$1) {
            settingStateMachine$onClickRedirectItem$1 = (SettingStateMachine$onClickRedirectItem$1) continuation;
            if ((settingStateMachine$onClickRedirectItem$1.label & Integer.MIN_VALUE) != 0) {
                settingStateMachine$onClickRedirectItem$1.label -= Integer.MIN_VALUE;
                Object $result = settingStateMachine$onClickRedirectItem$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (settingStateMachine$onClickRedirectItem$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        final KSetting.KRedirect content = action.getItem().getSetting().getContent();
                        if (content instanceof KSetting.KRedirect) {
                            final KSettingRedirect.IContent content2 = content.getValue().getContent();
                            if (content2 instanceof KSettingRedirect.KPopup) {
                                return state.mutate(new Function1() { // from class: im.setting.stateMachine.SettingStateMachine$$ExternalSyntheticLambda13
                                    public final Object invoke(Object obj) {
                                        IMSettingState onClickRedirectItem$lambda$0;
                                        onClickRedirectItem$lambda$0 = SettingStateMachine.onClickRedirectItem$lambda$0(content2, action, (IMSettingState) obj);
                                        return onClickRedirectItem$lambda$0;
                                    }
                                });
                            }
                            if (content2 instanceof KSettingRedirect.KWindowSelect) {
                                if (action.getItem().isDisabled()) {
                                    IMToast.Companion companion2 = IMToast.Companion;
                                    ImRes imRes = ImRes.INSTANCE;
                                    StringResource im_global_string_418 = String0_commonMainKt.getIm_global_string_418(ImRes.INSTANCE.getString());
                                    settingStateMachine$onClickRedirectItem$1.L$0 = state;
                                    settingStateMachine$onClickRedirectItem$1.L$1 = SpillingKt.nullOutSpilledVariable(action);
                                    settingStateMachine$onClickRedirectItem$1.L$2 = SpillingKt.nullOutSpilledVariable(content);
                                    settingStateMachine$onClickRedirectItem$1.L$3 = SpillingKt.nullOutSpilledVariable(content2);
                                    settingStateMachine$onClickRedirectItem$1.L$4 = companion2;
                                    settingStateMachine$onClickRedirectItem$1.label = 1;
                                    suspendGetString = imRes.suspendGetString(im_global_string_418, settingStateMachine$onClickRedirectItem$1);
                                    if (suspendGetString == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    companion = companion2;
                                    break;
                                } else {
                                    return state.mutate(new Function1() { // from class: im.setting.stateMachine.SettingStateMachine$$ExternalSyntheticLambda15
                                        public final Object invoke(Object obj) {
                                            IMSettingState onClickRedirectItem$lambda$2;
                                            onClickRedirectItem$lambda$2 = SettingStateMachine.onClickRedirectItem$lambda$2(IMSettingRedirectAction.this, (IMSettingState) obj);
                                            return onClickRedirectItem$lambda$2;
                                        }
                                    });
                                }
                            } else {
                                return state.mutate(new Function1() { // from class: im.setting.stateMachine.SettingStateMachine$$ExternalSyntheticLambda16
                                    public final Object invoke(Object obj) {
                                        IMSettingState onClickRedirectItem$lambda$3;
                                        onClickRedirectItem$lambda$3 = SettingStateMachine.onClickRedirectItem$lambda$3(content, (IMSettingState) obj);
                                        return onClickRedirectItem$lambda$3;
                                    }
                                });
                            }
                        } else {
                            return state.noChange();
                        }
                    case 1:
                        companion = (IMToast.Companion) settingStateMachine$onClickRedirectItem$1.L$4;
                        KSettingRedirect.IContent iContent = (KSettingRedirect.IContent) settingStateMachine$onClickRedirectItem$1.L$3;
                        KSetting.IContent iContent2 = (KSetting.IContent) settingStateMachine$onClickRedirectItem$1.L$2;
                        IMSettingRedirectAction iMSettingRedirectAction = (IMSettingRedirectAction) settingStateMachine$onClickRedirectItem$1.L$1;
                        state = (State) settingStateMachine$onClickRedirectItem$1.L$0;
                        ResultKt.throwOnFailure($result);
                        suspendGetString = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                final IMToast toast = IMToast.Companion.create$default(companion, (String) suspendGetString, null, 2, null);
                return state.mutate(new Function1() { // from class: im.setting.stateMachine.SettingStateMachine$$ExternalSyntheticLambda14
                    public final Object invoke(Object obj) {
                        IMSettingState onClickRedirectItem$lambda$1;
                        onClickRedirectItem$lambda$1 = SettingStateMachine.onClickRedirectItem$lambda$1(IMToast.this, (IMSettingState) obj);
                        return onClickRedirectItem$lambda$1;
                    }
                });
            }
        }
        settingStateMachine$onClickRedirectItem$1 = new SettingStateMachine$onClickRedirectItem$1(this, continuation);
        Object $result2 = settingStateMachine$onClickRedirectItem$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (settingStateMachine$onClickRedirectItem$1.label) {
        }
        final IMToast toast2 = IMToast.Companion.create$default(companion, (String) suspendGetString, null, 2, null);
        return state.mutate(new Function1() { // from class: im.setting.stateMachine.SettingStateMachine$$ExternalSyntheticLambda14
            public final Object invoke(Object obj) {
                IMSettingState onClickRedirectItem$lambda$1;
                onClickRedirectItem$lambda$1 = SettingStateMachine.onClickRedirectItem$lambda$1(IMToast.this, (IMSettingState) obj);
                return onClickRedirectItem$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMSettingState onClickRedirectItem$lambda$0(KSettingRedirect.IContent $content, IMSettingRedirectAction $action, IMSettingState $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        BSimpleLens lens = IMSettingStateLensKt.getDialog(IMSettingState.Companion);
        return (IMSettingState) lens.set($this$mutate, new IMSettingDialog(((KSettingRedirect.KPopup) $content).getValue().getTitle(), ((KSettingRedirect.KPopup) $content).getValue().getSubtitle(), $action.getItem().getType(), new IMSettingDialogConfirmAction($action.getItem(), true), new IMSettingDialogCancelAction($action.getItem())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMSettingState onClickRedirectItem$lambda$1(IMToast $toast, IMSettingState $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        return IMSettingState.copy$default($this$mutate, null, null, $toast, null, null, null, 59, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMSettingState onClickRedirectItem$lambda$2(IMSettingRedirectAction $action, IMSettingState $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        BSimpleLens lens = IMSettingStateLensKt.getWindowSelect(IMSettingState.Companion);
        return (IMSettingState) lens.set($this$mutate, new IMSettingWindowSelect($action.getItem()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMSettingState onClickRedirectItem$lambda$3(KSetting.IContent $item, IMSettingState $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        BSimpleLens lens = IMSettingStateLensKt.getRedirect(IMSettingState.Companion);
        return (IMSettingState) lens.set($this$mutate, IMRouteHolder.Companion.create(KSettingRedirectExtKt.getJumpUrl((KSetting.KRedirect) $item)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChangedState<IMSettingState> onClickUserInfoItem(State<IMSettingState> state, final IMSettingUserInfoAction action) {
        return state.mutate(new Function1() { // from class: im.setting.stateMachine.SettingStateMachine$$ExternalSyntheticLambda10
            public final Object invoke(Object obj) {
                IMSettingState onClickUserInfoItem$lambda$0;
                onClickUserInfoItem$lambda$0 = SettingStateMachine.onClickUserInfoItem$lambda$0(IMSettingUserInfoAction.this, (IMSettingState) obj);
                return onClickUserInfoItem$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMSettingState onClickUserInfoItem$lambda$0(IMSettingUserInfoAction $action, IMSettingState $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        return IMSettingState.copy$default($this$mutate, null, null, null, IMRouteHolder.Companion.create($action.getItem().getValue().getUrl()), null, null, 55, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChangedState<IMSettingState> onCloseSelectWindowAction(State<IMSettingState> state) {
        return state.mutate(new Function1() { // from class: im.setting.stateMachine.SettingStateMachine$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                IMSettingState onCloseSelectWindowAction$lambda$0;
                onCloseSelectWindowAction$lambda$0 = SettingStateMachine.onCloseSelectWindowAction$lambda$0((IMSettingState) obj);
                return onCloseSelectWindowAction$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMSettingState onCloseSelectWindowAction$lambda$0(IMSettingState $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        BSimpleLens lens = IMSettingStateLensKt.getWindowSelect(IMSettingState.Companion);
        return (IMSettingState) lens.set($this$mutate, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object receive(State<IMSettingState> state, Object result, Continuation<? super ChangedState<IMSettingState>> continuation) {
        SettingStateMachine$receive$1 settingStateMachine$receive$1;
        Object create;
        final Throwable it;
        State $this$receive = state;
        if (continuation instanceof SettingStateMachine$receive$1) {
            settingStateMachine$receive$1 = (SettingStateMachine$receive$1) continuation;
            if ((settingStateMachine$receive$1.label & Integer.MIN_VALUE) != 0) {
                settingStateMachine$receive$1.label -= Integer.MIN_VALUE;
                Object $result = settingStateMachine$receive$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (settingStateMachine$receive$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        KLog_androidKt.getKLog().i("IMSetting", "列表数据更新: " + Result.toString-impl(result));
                        Throwable it2 = Result.exceptionOrNull-impl(result);
                        if (it2 == null) {
                            final IMSettingPageData it3 = (IMSettingPageData) result;
                            return $this$receive.mutate(new Function1() { // from class: im.setting.stateMachine.SettingStateMachine$$ExternalSyntheticLambda24
                                public final Object invoke(Object obj) {
                                    IMSettingState receive$lambda$0$0;
                                    receive$lambda$0$0 = SettingStateMachine.receive$lambda$0$0(IMSettingPageData.this, (IMSettingState) obj);
                                    return receive$lambda$0$0;
                                }
                            });
                        }
                        IMToast.Companion companion = IMToast.Companion;
                        settingStateMachine$receive$1.L$0 = $this$receive;
                        settingStateMachine$receive$1.L$1 = SpillingKt.nullOutSpilledVariable(result);
                        settingStateMachine$receive$1.L$2 = it2;
                        settingStateMachine$receive$1.I$0 = 0;
                        settingStateMachine$receive$1.label = 1;
                        create = companion.create(it2, (r12 & 2) != 0 ? "" : null, (r12 & 4) != 0 ? Clock.System.INSTANCE.now() : null, (r12 & 8) != 0 ? null : null, settingStateMachine$receive$1);
                        if (create != coroutine_suspended) {
                            it = it2;
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i2 = settingStateMachine$receive$1.I$0;
                        it = (Throwable) settingStateMachine$receive$1.L$2;
                        Object obj = settingStateMachine$receive$1.L$1;
                        $this$receive = (State) settingStateMachine$receive$1.L$0;
                        ResultKt.throwOnFailure($result);
                        create = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                final IMToast imToast = (IMToast) create;
                return $this$receive.mutate(new Function1() { // from class: im.setting.stateMachine.SettingStateMachine$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj2) {
                        IMSettingState receive$lambda$1$0;
                        receive$lambda$1$0 = SettingStateMachine.receive$lambda$1$0(it, imToast, (IMSettingState) obj2);
                        return receive$lambda$1$0;
                    }
                });
            }
        }
        settingStateMachine$receive$1 = new SettingStateMachine$receive$1(this, continuation);
        Object $result2 = settingStateMachine$receive$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (settingStateMachine$receive$1.label) {
        }
        final IMToast imToast2 = (IMToast) create;
        return $this$receive.mutate(new Function1() { // from class: im.setting.stateMachine.SettingStateMachine$$ExternalSyntheticLambda1
            public final Object invoke(Object obj2) {
                IMSettingState receive$lambda$1$0;
                receive$lambda$1$0 = SettingStateMachine.receive$lambda$1$0(it, imToast2, (IMSettingState) obj2);
                return receive$lambda$1$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMSettingState receive$lambda$0$0(IMSettingPageData $it, IMSettingState $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        return IMSettingState.copy$default($this$mutate, IMSettingStateTypeSuccess.INSTANCE, $it, null, null, null, null, 60, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMSettingState receive$lambda$1$0(Throwable $it, IMToast $imToast, IMSettingState $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        return IMSettingState.copy$default($this$mutate, new IMSettingStateTypeError($it), $this$mutate.getData(), $imToast, null, null, null, 56, null);
    }
}