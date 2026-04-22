package im.keywordBlocking.stateMachine;

import com.bapis.bilibili.app.im.v1.KKeywordBlockingAddReply;
import com.bapis.bilibili.app.im.v1.KKeywordBlockingDeleteReply;
import com.bilibili.blens.BNullableLens;
import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStateMachine;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.IdentityBuilderBlock;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import com.freeletics.flowredux.dsl.State;
import com.freeletics.mad.statemachine.StateMachine;
import com.tencent.tauth.AuthActivity;
import im.base.IMLog;
import im.base.IMToast;
import im.keywordBlocking.KBAction;
import im.keywordBlocking.KBActionAddCancel;
import im.keywordBlocking.KBActionAddConfirm;
import im.keywordBlocking.KBActionAddItem;
import im.keywordBlocking.KBActionClickItem;
import im.keywordBlocking.KBActionDeleteCancel;
import im.keywordBlocking.KBActionDeleteConfirm;
import im.keywordBlocking.KBActionDeleteItem;
import im.keywordBlocking.KBActionInputBoxChanged;
import im.keywordBlocking.KBActionRetryLoad;
import im.keywordBlocking.KBInputBox;
import im.keywordBlocking.KBInputBoxLensKt;
import im.keywordBlocking.KBListItem;
import im.keywordBlocking.KBPageData;
import im.keywordBlocking.KBPageDataLensKt;
import im.keywordBlocking.KBPageStatusError;
import im.keywordBlocking.KBPageStatusIdle;
import im.keywordBlocking.KBPageStatusInitial;
import im.keywordBlocking.KBPageStatusLoading;
import im.keywordBlocking.log.LogTagKt;
import im.keywordBlocking.service.KBPageLoadService;
import im.keywordBlocking.trace.TraceKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Regex;

/* compiled from: KBStateMachine.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\r*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000eH\u0002J\u001e\u0010\u000f\u001a\u00020\r*\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0010H\u0002J\u001e\u0010\u0011\u001a\u00020\r*\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0010H\u0002J\u001e\u0010\u0012\u001a\u00020\r*\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0010H\u0002J\u001e\u0010\u0013\u001a\u00020\r*\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0010H\u0002J$\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J$\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u001bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lim/keywordBlocking/stateMachine/KBStateMachine;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Lim/keywordBlocking/KBPageData;", "Lim/keywordBlocking/KBAction;", "loadService", "Lim/keywordBlocking/service/KBPageLoadService;", "addItemStateMachineBuilder", "Lim/keywordBlocking/stateMachine/KBAddItemStateMachineBuilder;", "deleteItemStateMachineBuilder", "Lim/keywordBlocking/stateMachine/KBDeleteItemStateMachineBuilder;", "<init>", "(Lim/keywordBlocking/service/KBPageLoadService;Lim/keywordBlocking/stateMachine/KBAddItemStateMachineBuilder;Lim/keywordBlocking/stateMachine/KBDeleteItemStateMachineBuilder;)V", "build", "", "Lcom/freeletics/flowredux/dsl/FlowReduxStoreBuilder;", "initialLoad", "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "addKeyword", "bindShowEvent", "deleteKeyword", "addItemStateMapper", "Lcom/freeletics/flowredux/dsl/ChangedState;", "superState", "Lcom/freeletics/flowredux/dsl/State;", "childState", "Lim/keywordBlocking/stateMachine/KBAddItemStatus;", "deleteItemStateMapper", "Lim/keywordBlocking/stateMachine/KBDeleteItemStatus;", "keyword-blocking_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KBStateMachine extends FlowReduxStateMachine<KBPageData, KBAction> {
    private final KBAddItemStateMachineBuilder addItemStateMachineBuilder;
    private final KBDeleteItemStateMachineBuilder deleteItemStateMachineBuilder;
    private final KBPageLoadService loadService;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public KBStateMachine(KBPageLoadService loadService, KBAddItemStateMachineBuilder addItemStateMachineBuilder, KBDeleteItemStateMachineBuilder deleteItemStateMachineBuilder) {
        super(new KBPageData(null, null, 0, null, 0, null, null, null, null, false, 1023, null));
        Intrinsics.checkNotNullParameter(loadService, "loadService");
        Intrinsics.checkNotNullParameter(addItemStateMachineBuilder, "addItemStateMachineBuilder");
        Intrinsics.checkNotNullParameter(deleteItemStateMachineBuilder, "deleteItemStateMachineBuilder");
        this.loadService = loadService;
        this.addItemStateMachineBuilder = addItemStateMachineBuilder;
        this.deleteItemStateMachineBuilder = deleteItemStateMachineBuilder;
        spec(new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$$ExternalSyntheticLambda23
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = KBStateMachine._init_$lambda$0(KBStateMachine.this, (FlowReduxStoreBuilder) obj);
                return _init_$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(KBStateMachine this$0, FlowReduxStoreBuilder $this$spec) {
        Intrinsics.checkNotNullParameter($this$spec, "$this$spec");
        this$0.build($this$spec);
        return Unit.INSTANCE;
    }

    private final void build(FlowReduxStoreBuilder<KBPageData, KBAction> flowReduxStoreBuilder) {
        Function1 block$iv = new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit build$lambda$0;
                build$lambda$0 = KBStateMachine.build$lambda$0(KBStateMachine.this, (InStateBuilderBlock) obj);
                return build$lambda$0;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(KBPageData.class), block$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit build$lambda$0(KBStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        this$0.initialLoad($this$inState);
        this$0.addKeyword($this$inState);
        this$0.deleteKeyword($this$inState);
        this$0.bindShowEvent($this$inState);
        TraceKt.bindTrace($this$inState);
        return Unit.INSTANCE;
    }

    private final void initialLoad(InStateBuilderBlock<KBPageData, KBPageData, KBAction> inStateBuilderBlock) {
        inStateBuilderBlock.condition(new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean initialLoad$lambda$0;
                initialLoad$lambda$0 = KBStateMachine.initialLoad$lambda$0((KBPageData) obj);
                return Boolean.valueOf(initialLoad$lambda$0);
            }
        }, new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$$ExternalSyntheticLambda11
            public final Object invoke(Object obj) {
                Unit initialLoad$lambda$1;
                initialLoad$lambda$1 = KBStateMachine.initialLoad$lambda$1((ConditionBuilderBlock) obj);
                return initialLoad$lambda$1;
            }
        });
        inStateBuilderBlock.condition(new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$$ExternalSyntheticLambda22
            public final Object invoke(Object obj) {
                boolean initialLoad$lambda$2;
                initialLoad$lambda$2 = KBStateMachine.initialLoad$lambda$2((KBPageData) obj);
                return Boolean.valueOf(initialLoad$lambda$2);
            }
        }, new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$$ExternalSyntheticLambda30
            public final Object invoke(Object obj) {
                Unit initialLoad$lambda$3;
                initialLoad$lambda$3 = KBStateMachine.initialLoad$lambda$3(KBStateMachine.this, (ConditionBuilderBlock) obj);
                return initialLoad$lambda$3;
            }
        });
        inStateBuilderBlock.condition(new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$$ExternalSyntheticLambda31
            public final Object invoke(Object obj) {
                boolean initialLoad$lambda$4;
                initialLoad$lambda$4 = KBStateMachine.initialLoad$lambda$4((KBPageData) obj);
                return Boolean.valueOf(initialLoad$lambda$4);
            }
        }, new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$$ExternalSyntheticLambda32
            public final Object invoke(Object obj) {
                Unit initialLoad$lambda$5;
                initialLoad$lambda$5 = KBStateMachine.initialLoad$lambda$5((ConditionBuilderBlock) obj);
                return initialLoad$lambda$5;
            }
        });
        inStateBuilderBlock.condition(new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$$ExternalSyntheticLambda33
            public final Object invoke(Object obj) {
                boolean initialLoad$lambda$6;
                initialLoad$lambda$6 = KBStateMachine.initialLoad$lambda$6((KBPageData) obj);
                return Boolean.valueOf(initialLoad$lambda$6);
            }
        }, new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$$ExternalSyntheticLambda34
            public final Object invoke(Object obj) {
                Unit initialLoad$lambda$7;
                initialLoad$lambda$7 = KBStateMachine.initialLoad$lambda$7(KBStateMachine.this, (ConditionBuilderBlock) obj);
                return initialLoad$lambda$7;
            }
        });
        inStateBuilderBlock.condition(new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$$ExternalSyntheticLambda35
            public final Object invoke(Object obj) {
                boolean initialLoad$lambda$8;
                initialLoad$lambda$8 = KBStateMachine.initialLoad$lambda$8((KBPageData) obj);
                return Boolean.valueOf(initialLoad$lambda$8);
            }
        }, new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$$ExternalSyntheticLambda36
            public final Object invoke(Object obj) {
                Unit initialLoad$lambda$9;
                initialLoad$lambda$9 = KBStateMachine.initialLoad$lambda$9((ConditionBuilderBlock) obj);
                return initialLoad$lambda$9;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initialLoad$lambda$0(KBPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getStatus() instanceof KBPageStatusInitial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initialLoad$lambda$1(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new KBStateMachine$initialLoad$2$1(null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initialLoad$lambda$2(KBPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getStatus() instanceof KBPageStatusLoading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initialLoad$lambda$3(KBStateMachine this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new KBStateMachine$initialLoad$4$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initialLoad$lambda$4(KBPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getStatus() instanceof KBPageStatusError;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initialLoad$lambda$5(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new KBStateMachine$initialLoad$6$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(KBActionRetryLoad.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initialLoad$lambda$6(KBPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (it.getStatus() instanceof KBPageStatusIdle) && it.getItems().isEmpty() && it.getFirstLoad$keyword_blocking_debug();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initialLoad$lambda$7(KBStateMachine this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnterEffect(new KBStateMachine$initialLoad$8$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initialLoad$lambda$8(KBPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getStatus() instanceof KBPageStatusIdle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initialLoad$lambda$9(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new KBStateMachine$initialLoad$10$1(null));
        return Unit.INSTANCE;
    }

    private final void addKeyword(InStateBuilderBlock<KBPageData, KBPageData, KBAction> inStateBuilderBlock) {
        inStateBuilderBlock.condition(new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$$ExternalSyntheticLambda16
            public final Object invoke(Object obj) {
                boolean addKeyword$lambda$0;
                addKeyword$lambda$0 = KBStateMachine.addKeyword$lambda$0((KBPageData) obj);
                return Boolean.valueOf(addKeyword$lambda$0);
            }
        }, new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$$ExternalSyntheticLambda17
            public final Object invoke(Object obj) {
                Unit addKeyword$lambda$1;
                addKeyword$lambda$1 = KBStateMachine.addKeyword$lambda$1((ConditionBuilderBlock) obj);
                return addKeyword$lambda$1;
            }
        });
        inStateBuilderBlock.condition(new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$$ExternalSyntheticLambda18
            public final Object invoke(Object obj) {
                boolean addKeyword$lambda$2;
                addKeyword$lambda$2 = KBStateMachine.addKeyword$lambda$2((KBPageData) obj);
                return Boolean.valueOf(addKeyword$lambda$2);
            }
        }, new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$$ExternalSyntheticLambda19
            public final Object invoke(Object obj) {
                Unit addKeyword$lambda$3;
                addKeyword$lambda$3 = KBStateMachine.addKeyword$lambda$3(KBStateMachine.this, (ConditionBuilderBlock) obj);
                return addKeyword$lambda$3;
            }
        });
        inStateBuilderBlock.condition(new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$$ExternalSyntheticLambda20
            public final Object invoke(Object obj) {
                boolean addKeyword$lambda$4;
                addKeyword$lambda$4 = KBStateMachine.addKeyword$lambda$4((KBPageData) obj);
                return Boolean.valueOf(addKeyword$lambda$4);
            }
        }, new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$$ExternalSyntheticLambda21
            public final Object invoke(Object obj) {
                Unit addKeyword$lambda$5;
                addKeyword$lambda$5 = KBStateMachine.addKeyword$lambda$5((ConditionBuilderBlock) obj);
                return addKeyword$lambda$5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean addKeyword$lambda$0(KBPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getStatus() instanceof KBPageStatusIdle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addKeyword$lambda$1(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new KBStateMachine$addKeyword$2$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(KBActionAddItem.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean addKeyword$lambda$2(KBPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getStatus() instanceof KBPageStatusIdle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addKeyword$lambda$3(final KBStateMachine this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock this_$iv = (BaseBuilderBlock) $this$condition;
        Function2 stateMachineFactory$iv = new Function2() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$$ExternalSyntheticLambda15
            public final Object invoke(Object obj, Object obj2) {
                StateMachine addKeyword$lambda$3$0;
                addKeyword$lambda$3$0 = KBStateMachine.addKeyword$lambda$3$0(KBStateMachine.this, (KBActionAddConfirm) obj, (KBPageData) obj2);
                return addKeyword$lambda$3$0;
            }
        };
        Function2 stateMapper$iv = new KBStateMachine$addKeyword$4$2(this$0);
        Function1 actionMapper$iv$iv = new Function1<A, A>() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$addKeyword$lambda$3$$inlined$onActionStartStateMachine$1
            public final A invoke(A a) {
                Intrinsics.checkNotNullParameter(a, "it");
                return a;
            }
        };
        this_$iv.onActionStartStateMachine(Reflection.getOrCreateKotlinClass(KBActionAddConfirm.class), stateMachineFactory$iv, actionMapper$iv$iv, stateMapper$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StateMachine addKeyword$lambda$3$0(KBStateMachine this$0, KBActionAddConfirm kBActionAddConfirm, KBPageData stateSnapshot) {
        String text;
        Intrinsics.checkNotNullParameter(kBActionAddConfirm, "<unused var>");
        Intrinsics.checkNotNullParameter(stateSnapshot, "stateSnapshot");
        KBInputBox inputBox = stateSnapshot.getInputBox();
        String str = "";
        if (inputBox != null && (text = inputBox.getText()) != null) {
            String replace = new Regex("[\\s\\p{Zs}]").replace(text, "");
            if (replace != null) {
                str = replace;
            }
        }
        String text2 = str;
        IMLog.Companion.i(LogTagKt.KB_LOG_TAG, "启动子状态机添加屏蔽词 " + text2);
        return this$0.addItemStateMachineBuilder.build(text2, stateSnapshot.getItems());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean addKeyword$lambda$4(KBPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.isInputting$keyword_blocking_debug();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addKeyword$lambda$5(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new KBStateMachine$addKeyword$6$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(KBActionInputBoxChanged.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv2 = new KBStateMachine$addKeyword$6$2(null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(KBActionAddCancel.class), executionPolicy$iv2, handler$iv2);
        return Unit.INSTANCE;
    }

    private final void bindShowEvent(InStateBuilderBlock<KBPageData, KBPageData, KBAction> inStateBuilderBlock) {
        inStateBuilderBlock.untilIdentityChanges(new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$$ExternalSyntheticLambda24
            public final Object invoke(Object obj) {
                Object bindShowEvent$lambda$0;
                bindShowEvent$lambda$0 = KBStateMachine.bindShowEvent$lambda$0((KBPageData) obj);
                return bindShowEvent$lambda$0;
            }
        }, new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$$ExternalSyntheticLambda25
            public final Object invoke(Object obj) {
                Unit bindShowEvent$lambda$1;
                bindShowEvent$lambda$1 = KBStateMachine.bindShowEvent$lambda$1(KBStateMachine.this, (IdentityBuilderBlock) obj);
                return bindShowEvent$lambda$1;
            }
        });
        inStateBuilderBlock.untilIdentityChanges(new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$$ExternalSyntheticLambda26
            public final Object invoke(Object obj) {
                Object bindShowEvent$lambda$2;
                bindShowEvent$lambda$2 = KBStateMachine.bindShowEvent$lambda$2((KBPageData) obj);
                return bindShowEvent$lambda$2;
            }
        }, new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$$ExternalSyntheticLambda27
            public final Object invoke(Object obj) {
                Unit bindShowEvent$lambda$3;
                bindShowEvent$lambda$3 = KBStateMachine.bindShowEvent$lambda$3(KBStateMachine.this, (IdentityBuilderBlock) obj);
                return bindShowEvent$lambda$3;
            }
        });
        inStateBuilderBlock.untilIdentityChanges(new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$$ExternalSyntheticLambda28
            public final Object invoke(Object obj) {
                Object bindShowEvent$lambda$4;
                bindShowEvent$lambda$4 = KBStateMachine.bindShowEvent$lambda$4((KBPageData) obj);
                return bindShowEvent$lambda$4;
            }
        }, new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$$ExternalSyntheticLambda29
            public final Object invoke(Object obj) {
                Unit bindShowEvent$lambda$5;
                bindShowEvent$lambda$5 = KBStateMachine.bindShowEvent$lambda$5(KBStateMachine.this, (IdentityBuilderBlock) obj);
                return bindShowEvent$lambda$5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object bindShowEvent$lambda$0(KBPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getAlert();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindShowEvent$lambda$1(KBStateMachine this$0, IdentityBuilderBlock $this$untilIdentityChanges) {
        Intrinsics.checkNotNullParameter($this$untilIdentityChanges, "$this$untilIdentityChanges");
        $this$untilIdentityChanges.onEnterEffect(new KBStateMachine$bindShowEvent$2$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object bindShowEvent$lambda$2(KBPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getDropList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindShowEvent$lambda$3(KBStateMachine this$0, IdentityBuilderBlock $this$untilIdentityChanges) {
        Intrinsics.checkNotNullParameter($this$untilIdentityChanges, "$this$untilIdentityChanges");
        $this$untilIdentityChanges.onEnterEffect(new KBStateMachine$bindShowEvent$4$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object bindShowEvent$lambda$4(KBPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getInputBox();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindShowEvent$lambda$5(KBStateMachine this$0, IdentityBuilderBlock $this$untilIdentityChanges) {
        Intrinsics.checkNotNullParameter($this$untilIdentityChanges, "$this$untilIdentityChanges");
        $this$untilIdentityChanges.onEnterEffect(new KBStateMachine$bindShowEvent$6$1(this$0, null));
        return Unit.INSTANCE;
    }

    private final void deleteKeyword(InStateBuilderBlock<KBPageData, KBPageData, KBAction> inStateBuilderBlock) {
        inStateBuilderBlock.condition(new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                boolean deleteKeyword$lambda$0;
                deleteKeyword$lambda$0 = KBStateMachine.deleteKeyword$lambda$0((KBPageData) obj);
                return Boolean.valueOf(deleteKeyword$lambda$0);
            }
        }, new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Unit deleteKeyword$lambda$1;
                deleteKeyword$lambda$1 = KBStateMachine.deleteKeyword$lambda$1(KBStateMachine.this, (ConditionBuilderBlock) obj);
                return deleteKeyword$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean deleteKeyword$lambda$0(KBPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getStatus() instanceof KBPageStatusIdle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteKeyword$lambda$1(final KBStateMachine this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new KBStateMachine$deleteKeyword$2$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(KBActionClickItem.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv2 = new KBStateMachine$deleteKeyword$2$2(null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(KBActionDeleteItem.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv3 = new KBStateMachine$deleteKeyword$2$3(null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(KBActionDeleteCancel.class), executionPolicy$iv3, handler$iv3);
        BaseBuilderBlock this_$iv = (BaseBuilderBlock) $this$condition;
        Function2 stateMachineFactory$iv = new Function2() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$$ExternalSyntheticLambda7
            public final Object invoke(Object obj, Object obj2) {
                StateMachine deleteKeyword$lambda$1$0;
                deleteKeyword$lambda$1$0 = KBStateMachine.deleteKeyword$lambda$1$0(KBStateMachine.this, (KBActionDeleteConfirm) obj, (KBPageData) obj2);
                return deleteKeyword$lambda$1$0;
            }
        };
        Function2 stateMapper$iv = new KBStateMachine$deleteKeyword$2$5(this$0);
        Function1 actionMapper$iv$iv = new Function1<A, A>() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$deleteKeyword$lambda$1$$inlined$onActionStartStateMachine$1
            public final A invoke(A a) {
                Intrinsics.checkNotNullParameter(a, "it");
                return a;
            }
        };
        this_$iv.onActionStartStateMachine(Reflection.getOrCreateKotlinClass(KBActionDeleteConfirm.class), stateMachineFactory$iv, actionMapper$iv$iv, stateMapper$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StateMachine deleteKeyword$lambda$1$0(KBStateMachine this$0, KBActionDeleteConfirm action, KBPageData kBPageData) {
        Intrinsics.checkNotNullParameter(action, AuthActivity.ACTION_KEY);
        Intrinsics.checkNotNullParameter(kBPageData, "<unused var>");
        IMLog.Companion.i(LogTagKt.KB_LOG_TAG, "启动子状态机删除屏蔽词 " + action.getItem().getKeyword());
        return this$0.deleteItemStateMachineBuilder.build(action.getItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChangedState<KBPageData> addItemStateMapper(State<KBPageData> state, final KBAddItemStatus childState) {
        if (childState instanceof KBAddItemStatusIdle) {
            final BNullableLens lens = KBInputBoxLensKt.textNullable(KBPageDataLensKt.getInputBox(KBPageData.Companion));
            return state.mutate(new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$$ExternalSyntheticLambda9
                public final Object invoke(Object obj) {
                    KBPageData addItemStateMapper$lambda$0;
                    addItemStateMapper$lambda$0 = KBStateMachine.addItemStateMapper$lambda$0(lens, childState, (KBPageData) obj);
                    return addItemStateMapper$lambda$0;
                }
            });
        } else if (childState instanceof KBAddItemStatusLoading) {
            return state.mutate(new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$$ExternalSyntheticLambda10
                public final Object invoke(Object obj) {
                    KBPageData addItemStateMapper$lambda$1;
                    addItemStateMapper$lambda$1 = KBStateMachine.addItemStateMapper$lambda$1(KBAddItemStatus.this, (KBPageData) obj);
                    return addItemStateMapper$lambda$1;
                }
            });
        } else {
            if (childState instanceof KBAddItemStatusFinish) {
                return state.mutate(new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$$ExternalSyntheticLambda12
                    public final Object invoke(Object obj) {
                        KBPageData addItemStateMapper$lambda$2;
                        addItemStateMapper$lambda$2 = KBStateMachine.addItemStateMapper$lambda$2(KBAddItemStatus.this, (KBPageData) obj);
                        return addItemStateMapper$lambda$2;
                    }
                });
            }
            if (!(childState instanceof KBAddItemStatusCancel)) {
                throw new NoWhenBranchMatchedException();
            }
            return state.mutate(new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$$ExternalSyntheticLambda13
                public final Object invoke(Object obj) {
                    KBPageData addItemStateMapper$lambda$3;
                    addItemStateMapper$lambda$3 = KBStateMachine.addItemStateMapper$lambda$3(KBAddItemStatus.this, (KBPageData) obj);
                    return addItemStateMapper$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KBPageData addItemStateMapper$lambda$0(BNullableLens $lens, KBAddItemStatus $childState, KBPageData $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        return (KBPageData) $lens.set($this$mutate, ((KBAddItemStatusIdle) $childState).getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KBPageData addItemStateMapper$lambda$1(KBAddItemStatus $childState, KBPageData $this$mutate) {
        KBPageData copy;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        List mutableList = CollectionsKt.toMutableList($this$mutate.getItems());
        mutableList.add(new KBListItem(((KBAddItemStatusLoading) $childState).getText(), true));
        copy = $this$mutate.copy((r22 & 1) != 0 ? $this$mutate.status : null, (r22 & 2) != 0 ? $this$mutate.items : CollectionsKt.toList(mutableList), (r22 & 4) != 0 ? $this$mutate.limit : 0, (r22 & 8) != 0 ? $this$mutate.limitsHint : null, (r22 & 16) != 0 ? $this$mutate.charLimit : 0, (r22 & 32) != 0 ? $this$mutate.toast : null, (r22 & 64) != 0 ? $this$mutate.inputBox : null, (r22 & 128) != 0 ? $this$mutate.dropList : null, (r22 & 256) != 0 ? $this$mutate.alert : null, (r22 & 512) != 0 ? $this$mutate.firstLoad : false);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KBPageData addItemStateMapper$lambda$2(final KBAddItemStatus $childState, KBPageData $this$mutate) {
        KBPageData copy;
        KBPageData copy2;
        KBListItem kBListItem;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        Object m3198getResultd1pmJ48 = ((KBAddItemStatusFinish) $childState).m3198getResultd1pmJ48();
        Throwable it = Result.exceptionOrNull-impl(m3198getResultd1pmJ48);
        if (it == null) {
            KKeywordBlockingAddReply reply = (KKeywordBlockingAddReply) m3198getResultd1pmJ48;
            Iterable $this$map$iv = $this$mutate.getItems();
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                KBListItem item = (KBListItem) item$iv$iv;
                if (Intrinsics.areEqual(item.getKeyword(), ((KBAddItemStatusFinish) $childState).getText())) {
                    kBListItem = KBListItem.copy$default(item, null, false, 1, null);
                } else {
                    kBListItem = item;
                }
                destination$iv$iv.add(kBListItem);
            }
            List items = (List) destination$iv$iv;
            String it2 = reply.getToast();
            if (!(it2.length() > 0)) {
                it2 = null;
            }
            IMToast toast = it2 != null ? IMToast.Companion.create$default(IMToast.Companion, it2, null, 2, null) : null;
            copy2 = $this$mutate.copy((r22 & 1) != 0 ? $this$mutate.status : null, (r22 & 2) != 0 ? $this$mutate.items : items, (r22 & 4) != 0 ? $this$mutate.limit : 0, (r22 & 8) != 0 ? $this$mutate.limitsHint : null, (r22 & 16) != 0 ? $this$mutate.charLimit : 0, (r22 & 32) != 0 ? $this$mutate.toast : toast, (r22 & 64) != 0 ? $this$mutate.inputBox : null, (r22 & 128) != 0 ? $this$mutate.dropList : null, (r22 & 256) != 0 ? $this$mutate.alert : null, (r22 & 512) != 0 ? $this$mutate.firstLoad : false);
            return copy2;
        }
        List mutableList = CollectionsKt.toMutableList($this$mutate.getItems());
        IMToast imToast = IMToast.Companion.createBlocking$default(IMToast.Companion, it, null, null, 6, null);
        CollectionsKt.removeAll(mutableList, new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                boolean addItemStateMapper$lambda$2$1$0;
                addItemStateMapper$lambda$2$1$0 = KBStateMachine.addItemStateMapper$lambda$2$1$0(KBAddItemStatus.this, (KBListItem) obj);
                return Boolean.valueOf(addItemStateMapper$lambda$2$1$0);
            }
        });
        copy = $this$mutate.copy((r22 & 1) != 0 ? $this$mutate.status : null, (r22 & 2) != 0 ? $this$mutate.items : CollectionsKt.toList(mutableList), (r22 & 4) != 0 ? $this$mutate.limit : 0, (r22 & 8) != 0 ? $this$mutate.limitsHint : null, (r22 & 16) != 0 ? $this$mutate.charLimit : 0, (r22 & 32) != 0 ? $this$mutate.toast : imToast, (r22 & 64) != 0 ? $this$mutate.inputBox : null, (r22 & 128) != 0 ? $this$mutate.dropList : null, (r22 & 256) != 0 ? $this$mutate.alert : null, (r22 & 512) != 0 ? $this$mutate.firstLoad : false);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean addItemStateMapper$lambda$2$1$0(KBAddItemStatus $childState, KBListItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.getKeyword(), ((KBAddItemStatusFinish) $childState).getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KBPageData addItemStateMapper$lambda$3(KBAddItemStatus $childState, KBPageData $this$mutate) {
        KBPageData copy;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        String it = ((KBAddItemStatusCancel) $childState).getThrowable().getMessage();
        copy = $this$mutate.copy((r22 & 1) != 0 ? $this$mutate.status : null, (r22 & 2) != 0 ? $this$mutate.items : null, (r22 & 4) != 0 ? $this$mutate.limit : 0, (r22 & 8) != 0 ? $this$mutate.limitsHint : null, (r22 & 16) != 0 ? $this$mutate.charLimit : 0, (r22 & 32) != 0 ? $this$mutate.toast : it != null ? IMToast.Companion.create$default(IMToast.Companion, it, null, 2, null) : null, (r22 & 64) != 0 ? $this$mutate.inputBox : null, (r22 & 128) != 0 ? $this$mutate.dropList : null, (r22 & 256) != 0 ? $this$mutate.alert : null, (r22 & 512) != 0 ? $this$mutate.firstLoad : false);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChangedState<KBPageData> deleteItemStateMapper(State<KBPageData> state, final KBDeleteItemStatus childState) {
        if (childState instanceof KBDeleteItemStatusIdle) {
            return state.mutate(new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    KBPageData deleteItemStateMapper$lambda$0;
                    deleteItemStateMapper$lambda$0 = KBStateMachine.deleteItemStateMapper$lambda$0((KBPageData) obj);
                    return deleteItemStateMapper$lambda$0;
                }
            });
        }
        if (childState instanceof KBDeleteItemStatusLoading) {
            return state.mutate(new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$$ExternalSyntheticLambda3
                public final Object invoke(Object obj) {
                    KBPageData deleteItemStateMapper$lambda$1;
                    deleteItemStateMapper$lambda$1 = KBStateMachine.deleteItemStateMapper$lambda$1(KBDeleteItemStatus.this, (KBPageData) obj);
                    return deleteItemStateMapper$lambda$1;
                }
            });
        }
        if (!(childState instanceof KBDeleteItemStatusFinish)) {
            throw new NoWhenBranchMatchedException();
        }
        return state.mutate(new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                KBPageData deleteItemStateMapper$lambda$2;
                deleteItemStateMapper$lambda$2 = KBStateMachine.deleteItemStateMapper$lambda$2(KBDeleteItemStatus.this, (KBPageData) obj);
                return deleteItemStateMapper$lambda$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KBPageData deleteItemStateMapper$lambda$0(KBPageData $this$mutate) {
        KBPageData copy;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        copy = $this$mutate.copy((r22 & 1) != 0 ? $this$mutate.status : null, (r22 & 2) != 0 ? $this$mutate.items : null, (r22 & 4) != 0 ? $this$mutate.limit : 0, (r22 & 8) != 0 ? $this$mutate.limitsHint : null, (r22 & 16) != 0 ? $this$mutate.charLimit : 0, (r22 & 32) != 0 ? $this$mutate.toast : null, (r22 & 64) != 0 ? $this$mutate.inputBox : null, (r22 & 128) != 0 ? $this$mutate.dropList : null, (r22 & 256) != 0 ? $this$mutate.alert : null, (r22 & 512) != 0 ? $this$mutate.firstLoad : false);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KBPageData deleteItemStateMapper$lambda$1(KBDeleteItemStatus $childState, KBPageData $this$mutate) {
        KBPageData copy;
        KBListItem kBListItem;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        Iterable $this$map$iv = $this$mutate.getItems();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            KBListItem it = (KBListItem) item$iv$iv;
            if (Intrinsics.areEqual(it.getKeyword(), ((KBDeleteItemStatusLoading) $childState).getItem().getKeyword())) {
                kBListItem = KBListItem.copy$default(it, null, true, 1, null);
            } else {
                kBListItem = it;
            }
            destination$iv$iv.add(kBListItem);
        }
        copy = $this$mutate.copy((r22 & 1) != 0 ? $this$mutate.status : null, (r22 & 2) != 0 ? $this$mutate.items : (List) destination$iv$iv, (r22 & 4) != 0 ? $this$mutate.limit : 0, (r22 & 8) != 0 ? $this$mutate.limitsHint : null, (r22 & 16) != 0 ? $this$mutate.charLimit : 0, (r22 & 32) != 0 ? $this$mutate.toast : null, (r22 & 64) != 0 ? $this$mutate.inputBox : null, (r22 & 128) != 0 ? $this$mutate.dropList : null, (r22 & 256) != 0 ? $this$mutate.alert : null, (r22 & 512) != 0 ? $this$mutate.firstLoad : false);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KBPageData deleteItemStateMapper$lambda$2(final KBDeleteItemStatus $childState, KBPageData $this$mutate) {
        KBPageData copy;
        KBPageData copy2;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        Object m3200getResultd1pmJ48 = ((KBDeleteItemStatusFinish) $childState).m3200getResultd1pmJ48();
        Throwable it = Result.exceptionOrNull-impl(m3200getResultd1pmJ48);
        if (it == null) {
            KKeywordBlockingDeleteReply reply = (KKeywordBlockingDeleteReply) m3200getResultd1pmJ48;
            List mutableList = CollectionsKt.toMutableList($this$mutate.getItems());
            CollectionsKt.removeAll(mutableList, new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$$ExternalSyntheticLambda14
                public final Object invoke(Object obj) {
                    boolean deleteItemStateMapper$lambda$2$0$0;
                    deleteItemStateMapper$lambda$2$0$0 = KBStateMachine.deleteItemStateMapper$lambda$2$0$0(KBDeleteItemStatus.this, (KBListItem) obj);
                    return Boolean.valueOf(deleteItemStateMapper$lambda$2$0$0);
                }
            });
            String it2 = reply.getToast();
            if (!(it2.length() > 0)) {
                it2 = null;
            }
            IMToast toast = it2 != null ? IMToast.Companion.create$default(IMToast.Companion, it2, null, 2, null) : null;
            copy2 = $this$mutate.copy((r22 & 1) != 0 ? $this$mutate.status : null, (r22 & 2) != 0 ? $this$mutate.items : CollectionsKt.toList(mutableList), (r22 & 4) != 0 ? $this$mutate.limit : 0, (r22 & 8) != 0 ? $this$mutate.limitsHint : null, (r22 & 16) != 0 ? $this$mutate.charLimit : 0, (r22 & 32) != 0 ? $this$mutate.toast : toast, (r22 & 64) != 0 ? $this$mutate.inputBox : null, (r22 & 128) != 0 ? $this$mutate.dropList : null, (r22 & 256) != 0 ? $this$mutate.alert : null, (r22 & 512) != 0 ? $this$mutate.firstLoad : false);
            return copy2;
        }
        Iterable $this$map$iv = $this$mutate.getItems();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            KBListItem item = (KBListItem) item$iv$iv;
            destination$iv$iv.add(Intrinsics.areEqual(item.getKeyword(), ((KBDeleteItemStatusFinish) $childState).getItem().getKeyword()) ? KBListItem.copy$default(item, null, false, 1, null) : item);
        }
        copy = $this$mutate.copy((r22 & 1) != 0 ? $this$mutate.status : null, (r22 & 2) != 0 ? $this$mutate.items : (List) destination$iv$iv, (r22 & 4) != 0 ? $this$mutate.limit : 0, (r22 & 8) != 0 ? $this$mutate.limitsHint : null, (r22 & 16) != 0 ? $this$mutate.charLimit : 0, (r22 & 32) != 0 ? $this$mutate.toast : IMToast.Companion.createBlocking$default(IMToast.Companion, it, null, null, 6, null), (r22 & 64) != 0 ? $this$mutate.inputBox : null, (r22 & 128) != 0 ? $this$mutate.dropList : null, (r22 & 256) != 0 ? $this$mutate.alert : null, (r22 & 512) != 0 ? $this$mutate.firstLoad : false);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean deleteItemStateMapper$lambda$2$0$0(KBDeleteItemStatus $childState, KBListItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.getKeyword(), ((KBDeleteItemStatusFinish) $childState).getItem().getKeyword());
    }
}