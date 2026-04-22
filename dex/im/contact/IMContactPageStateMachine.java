package im.contact;

import com.bapis.bilibili.app.im.v1.KContactTabType;
import com.bilibili.blens.CollectionsKt;
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
import im.contact.model.IMContactAction;
import im.contact.model.IMContactActionTabChange;
import im.contact.model.IMContactOnContactClick;
import im.contact.model.IMContactPageData;
import im.contact.model.IMContactPageDataLensKt;
import im.contact.model.IMContactRefresh;
import im.contact.model.IMContactTab;
import im.contact.model.StatusError;
import im.contact.model.StatusIdle;
import im.contact.model.StatusLoading;
import im.contact.model.StatusSuccess;
import im.contact.service.ContactLoadService;
import im.contact.service.ContactSearchService;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: IMContactPageStateMachine.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\fH\u0002J\u001e\u0010\r\u001a\u00020\u000b*\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000eH\u0002J\u001e\u0010\u000f\u001a\u00020\u000b*\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000eH\u0002J\u001e\u0010\u0010\u001a\u00020\u000b*\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lim/contact/IMContactPageStateMachine;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Lim/contact/model/IMContactPageData;", "Lim/contact/model/IMContactAction;", "loadService", "Lim/contact/service/ContactLoadService;", "searchService", "Lim/contact/service/ContactSearchService;", "<init>", "(Lim/contact/service/ContactLoadService;Lim/contact/service/ContactSearchService;)V", "build", "", "Lcom/freeletics/flowredux/dsl/FlowReduxStoreBuilder;", "initialLoad", "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "onTabChange", "onClick", "contact_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMContactPageStateMachine extends FlowReduxStateMachine<IMContactPageData, IMContactAction> {
    private final ContactLoadService loadService;
    private final ContactSearchService searchService;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public IMContactPageStateMachine(ContactLoadService loadService, ContactSearchService searchService) {
        super(new IMContactPageData(null, null, null, null, null, 31, null));
        Intrinsics.checkNotNullParameter(loadService, "loadService");
        Intrinsics.checkNotNullParameter(searchService, "searchService");
        this.loadService = loadService;
        this.searchService = searchService;
        spec(new Function1() { // from class: im.contact.IMContactPageStateMachine$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = IMContactPageStateMachine._init_$lambda$0(IMContactPageStateMachine.this, (FlowReduxStoreBuilder) obj);
                return _init_$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(IMContactPageStateMachine this$0, FlowReduxStoreBuilder $this$spec) {
        Intrinsics.checkNotNullParameter($this$spec, "$this$spec");
        this$0.build($this$spec);
        return Unit.INSTANCE;
    }

    private final void build(FlowReduxStoreBuilder<IMContactPageData, IMContactAction> flowReduxStoreBuilder) {
        Function1 block$iv = new Function1() { // from class: im.contact.IMContactPageStateMachine$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit build$lambda$0;
                build$lambda$0 = IMContactPageStateMachine.build$lambda$0(IMContactPageStateMachine.this, (InStateBuilderBlock) obj);
                return build$lambda$0;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(IMContactPageData.class), block$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit build$lambda$0(IMContactPageStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        this$0.initialLoad($this$inState);
        this$0.onTabChange($this$inState);
        this$0.onClick($this$inState);
        return Unit.INSTANCE;
    }

    private final void initialLoad(InStateBuilderBlock<IMContactPageData, IMContactPageData, IMContactAction> inStateBuilderBlock) {
        inStateBuilderBlock.condition(new Function1() { // from class: im.contact.IMContactPageStateMachine$$ExternalSyntheticLambda15
            public final Object invoke(Object obj) {
                boolean initialLoad$lambda$0;
                initialLoad$lambda$0 = IMContactPageStateMachine.initialLoad$lambda$0((IMContactPageData) obj);
                return Boolean.valueOf(initialLoad$lambda$0);
            }
        }, new Function1() { // from class: im.contact.IMContactPageStateMachine$$ExternalSyntheticLambda16
            public final Object invoke(Object obj) {
                Unit initialLoad$lambda$1;
                initialLoad$lambda$1 = IMContactPageStateMachine.initialLoad$lambda$1((ConditionBuilderBlock) obj);
                return initialLoad$lambda$1;
            }
        });
        inStateBuilderBlock.condition(new Function1() { // from class: im.contact.IMContactPageStateMachine$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                boolean initialLoad$lambda$2;
                initialLoad$lambda$2 = IMContactPageStateMachine.initialLoad$lambda$2((IMContactPageData) obj);
                return Boolean.valueOf(initialLoad$lambda$2);
            }
        }, new Function1() { // from class: im.contact.IMContactPageStateMachine$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit initialLoad$lambda$3;
                initialLoad$lambda$3 = IMContactPageStateMachine.initialLoad$lambda$3((ConditionBuilderBlock) obj);
                return initialLoad$lambda$3;
            }
        });
        inStateBuilderBlock.condition(new Function1() { // from class: im.contact.IMContactPageStateMachine$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                boolean initialLoad$lambda$4;
                initialLoad$lambda$4 = IMContactPageStateMachine.initialLoad$lambda$4((IMContactPageData) obj);
                return Boolean.valueOf(initialLoad$lambda$4);
            }
        }, new Function1() { // from class: im.contact.IMContactPageStateMachine$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit initialLoad$lambda$5;
                initialLoad$lambda$5 = IMContactPageStateMachine.initialLoad$lambda$5(IMContactPageStateMachine.this, (ConditionBuilderBlock) obj);
                return initialLoad$lambda$5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initialLoad$lambda$0(IMContactPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getTabList().isEmpty() && Intrinsics.areEqual(it.getStatus(), StatusIdle.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initialLoad$lambda$1(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new IMContactPageStateMachine$initialLoad$2$1(null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initialLoad$lambda$2(IMContactPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getTabList().isEmpty() && (it.getStatus() instanceof StatusError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initialLoad$lambda$3(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new IMContactPageStateMachine$initialLoad$4$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(IMContactRefresh.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initialLoad$lambda$4(IMContactPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getTabList().isEmpty() && Intrinsics.areEqual(it.getStatus(), StatusLoading.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initialLoad$lambda$5(IMContactPageStateMachine this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new IMContactPageStateMachine$initialLoad$6$1(this$0, null));
        return Unit.INSTANCE;
    }

    private final void onTabChange(InStateBuilderBlock<IMContactPageData, IMContactPageData, IMContactAction> inStateBuilderBlock) {
        inStateBuilderBlock.condition(new Function1() { // from class: im.contact.IMContactPageStateMachine$$ExternalSyntheticLambda12
            public final Object invoke(Object obj) {
                boolean onTabChange$lambda$0;
                onTabChange$lambda$0 = IMContactPageStateMachine.onTabChange$lambda$0((IMContactPageData) obj);
                return Boolean.valueOf(onTabChange$lambda$0);
            }
        }, new Function1() { // from class: im.contact.IMContactPageStateMachine$$ExternalSyntheticLambda13
            public final Object invoke(Object obj) {
                Unit onTabChange$lambda$1;
                onTabChange$lambda$1 = IMContactPageStateMachine.onTabChange$lambda$1(IMContactPageStateMachine.this, (ConditionBuilderBlock) obj);
                return onTabChange$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onTabChange$lambda$0(IMContactPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (!Intrinsics.areEqual(it.getStatus(), StatusSuccess.INSTANCE) || it.getTabList().isEmpty() || Intrinsics.areEqual(it.getCurrentTab(), KContactTabType.TAB_UNKNOWN.INSTANCE)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onTabChange$lambda$1(final IMContactPageStateMachine this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.untilIdentityChanges(new Function1() { // from class: im.contact.IMContactPageStateMachine$$ExternalSyntheticLambda10
            public final Object invoke(Object obj) {
                Object onTabChange$lambda$1$0;
                onTabChange$lambda$1$0 = IMContactPageStateMachine.onTabChange$lambda$1$0((IMContactPageData) obj);
                return onTabChange$lambda$1$0;
            }
        }, new Function1() { // from class: im.contact.IMContactPageStateMachine$$ExternalSyntheticLambda11
            public final Object invoke(Object obj) {
                Unit onTabChange$lambda$1$1;
                onTabChange$lambda$1$1 = IMContactPageStateMachine.onTabChange$lambda$1$1(IMContactPageStateMachine.this, (IdentityBuilderBlock) obj);
                return onTabChange$lambda$1$1;
            }
        });
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new IMContactPageStateMachine$onTabChange$2$3(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(IMContactActionTabChange.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object onTabChange$lambda$1$0(IMContactPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getCurrentTab();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onTabChange$lambda$1$1(final IMContactPageStateMachine this$0, IdentityBuilderBlock $this$untilIdentityChanges) {
        Intrinsics.checkNotNullParameter($this$untilIdentityChanges, "$this$untilIdentityChanges");
        $this$untilIdentityChanges.onEnterStartStateMachine(new Function1() { // from class: im.contact.IMContactPageStateMachine$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                StateMachine onTabChange$lambda$1$1$0;
                onTabChange$lambda$1$1$0 = IMContactPageStateMachine.onTabChange$lambda$1$1$0(IMContactPageStateMachine.this, (IMContactPageData) obj);
                return onTabChange$lambda$1$1$0;
            }
        }, new Function2() { // from class: im.contact.IMContactPageStateMachine$$ExternalSyntheticLambda7
            public final Object invoke(Object obj, Object obj2) {
                ChangedState onTabChange$lambda$1$1$1;
                onTabChange$lambda$1$1$1 = IMContactPageStateMachine.onTabChange$lambda$1$1$1((State) obj, (IMContactTab) obj2);
                return onTabChange$lambda$1$1$1;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StateMachine onTabChange$lambda$1$1$0(IMContactPageStateMachine this$0, final IMContactPageData state) {
        IMContactTabStateMachine iMContactTabStateMachine;
        Intrinsics.checkNotNullParameter(state, "state");
        IMContactTab tab = (IMContactTab) CollectionsKt.single(IMContactPageDataLensKt.getTabList(IMContactPageData.Companion), new Function1() { // from class: im.contact.IMContactPageStateMachine$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                int onTabChange$lambda$1$1$0$0;
                onTabChange$lambda$1$1$0$0 = IMContactPageStateMachine.onTabChange$lambda$1$1$0$0(IMContactPageData.this, (List) obj);
                return Integer.valueOf(onTabChange$lambda$1$1$0$0);
            }
        }).get(state);
        if (tab != null) {
            iMContactTabStateMachine = new IMContactTabStateMachine(tab, this$0.loadService, this$0.searchService, null, 8, null);
        } else {
            iMContactTabStateMachine = (FlowReduxStateMachine) new IMContactEmptyTabStateMachine();
        }
        return iMContactTabStateMachine;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int onTabChange$lambda$1$1$0$0(IMContactPageData $state, List $this$single) {
        Intrinsics.checkNotNullParameter($this$single, "$this$single");
        int index$iv = 0;
        for (Object item$iv : $this$single) {
            IMContactTab it = (IMContactTab) item$iv;
            if (Intrinsics.areEqual(it.getCurrentTab(), $state.getCurrentTab())) {
                return index$iv;
            }
            index$iv++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChangedState onTabChange$lambda$1$1$1(final State state, final IMContactTab subState) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(subState, "subState");
        return state.mutate(new Function1() { // from class: im.contact.IMContactPageStateMachine$$ExternalSyntheticLambda14
            public final Object invoke(Object obj) {
                IMContactPageData onTabChange$lambda$1$1$1$0;
                onTabChange$lambda$1$1$1$0 = IMContactPageStateMachine.onTabChange$lambda$1$1$1$0(IMContactTab.this, state, (IMContactPageData) obj);
                return onTabChange$lambda$1$1$1$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMContactPageData onTabChange$lambda$1$1$1$0(IMContactTab $subState, final State $state, IMContactPageData $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        return (IMContactPageData) CollectionsKt.single(IMContactPageDataLensKt.getTabList(IMContactPageData.Companion), new Function1() { // from class: im.contact.IMContactPageStateMachine$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                int onTabChange$lambda$1$1$1$0$0;
                onTabChange$lambda$1$1$1$0$0 = IMContactPageStateMachine.onTabChange$lambda$1$1$1$0$0($state, (List) obj);
                return Integer.valueOf(onTabChange$lambda$1$1$1$0$0);
            }
        }).set($this$mutate, $subState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int onTabChange$lambda$1$1$1$0$0(State $state, List $this$single) {
        Intrinsics.checkNotNullParameter($this$single, "$this$single");
        int index$iv = 0;
        for (Object item$iv : $this$single) {
            IMContactTab it = (IMContactTab) item$iv;
            if (Intrinsics.areEqual(it.getCurrentTab(), ((IMContactPageData) $state.getSnapshot()).getCurrentTab())) {
                return index$iv;
            }
            index$iv++;
        }
        return -1;
    }

    private final void onClick(InStateBuilderBlock<IMContactPageData, IMContactPageData, IMContactAction> inStateBuilderBlock) {
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new IMContactPageStateMachine$onClick$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(IMContactOnContactClick.class), executionPolicy$iv, handler$iv);
    }
}