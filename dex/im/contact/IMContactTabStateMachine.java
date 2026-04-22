package im.contact;

import com.bapis.bilibili.app.im.v1.KContactTabType;
import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStateMachine;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.IdentityBuilderBlock;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import com.freeletics.flowredux.dsl.State;
import im.contact.di.IMContactScope;
import im.contact.model.ContactsReply;
import im.contact.model.ContactsSearchReply;
import im.contact.model.IMContactAction;
import im.contact.model.IMContactActionEnterSearch;
import im.contact.model.IMContactActionExitSearch;
import im.contact.model.IMContactActionLoadMore;
import im.contact.model.IMContactActionSearch;
import im.contact.model.IMContactRefresh;
import im.contact.model.IMContactSearchingTabData;
import im.contact.model.IMContactSearchingTabDataLensKt;
import im.contact.model.IMContactTab;
import im.contact.model.IMContactTabData;
import im.contact.model.IMContactTabDataLensKt;
import im.contact.model.StatusError;
import im.contact.model.StatusIdle;
import im.contact.model.StatusLoading;
import im.contact.model.StatusLoadingMore;
import im.contact.model.StatusSuccess;
import im.contact.service.ContactLoadService;
import im.contact.service.ContactSearchService;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: IMContactTabStateMachine.kt */
@IMContactScope
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B)\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000fH\u0002J\u0018\u0010\u0010\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000fH\u0002J\u0018\u0010\u0011\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000fH\u0002J \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013*\b\u0012\u0004\u0012\u00020\u00140\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00180\u0013*\b\u0012\u0004\u0012\u00020\u00180\u00152\u0006\u0010\u0016\u001a\u00020\u0019H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lim/contact/IMContactTabStateMachine;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Lim/contact/model/IMContactTab;", "Lim/contact/model/IMContactAction;", "initialState", "loadService", "Lim/contact/service/ContactLoadService;", "searchService", "Lim/contact/service/ContactSearchService;", "currentTab", "Lcom/bapis/bilibili/app/im/v1/KContactTabType;", "<init>", "(Lim/contact/model/IMContactTab;Lim/contact/service/ContactLoadService;Lim/contact/service/ContactSearchService;Lcom/bapis/bilibili/app/im/v1/KContactTabType;)V", "buildStateMachine", "", "Lcom/freeletics/flowredux/dsl/FlowReduxStoreBuilder;", "inCommonState", "inSearchState", "updateFromReply", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/contact/model/IMContactTabData;", "Lcom/freeletics/flowredux/dsl/State;", "reply", "Lim/contact/model/ContactsReply;", "Lim/contact/model/IMContactSearchingTabData;", "Lim/contact/model/ContactsSearchReply;", "contact_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMContactTabStateMachine extends FlowReduxStateMachine<IMContactTab, IMContactAction> {
    private final KContactTabType currentTab;
    private final ContactLoadService loadService;
    private final ContactSearchService searchService;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMContactTabStateMachine(IMContactTab initialState, ContactLoadService loadService, ContactSearchService searchService, KContactTabType currentTab) {
        super(initialState);
        Intrinsics.checkNotNullParameter(initialState, "initialState");
        Intrinsics.checkNotNullParameter(loadService, "loadService");
        Intrinsics.checkNotNullParameter(searchService, "searchService");
        Intrinsics.checkNotNullParameter(currentTab, "currentTab");
        this.loadService = loadService;
        this.searchService = searchService;
        this.currentTab = currentTab;
        spec(new Function1() { // from class: im.contact.IMContactTabStateMachine$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = IMContactTabStateMachine._init_$lambda$0(IMContactTabStateMachine.this, (FlowReduxStoreBuilder) obj);
                return _init_$lambda$0;
            }
        });
    }

    public /* synthetic */ IMContactTabStateMachine(IMContactTab iMContactTab, ContactLoadService contactLoadService, ContactSearchService contactSearchService, KContactTabType kContactTabType, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(iMContactTab, contactLoadService, contactSearchService, (i2 & 8) != 0 ? iMContactTab.getCurrentTab() : kContactTabType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(IMContactTabStateMachine this$0, FlowReduxStoreBuilder $this$spec) {
        Intrinsics.checkNotNullParameter($this$spec, "$this$spec");
        this$0.buildStateMachine($this$spec);
        return Unit.INSTANCE;
    }

    private final void buildStateMachine(FlowReduxStoreBuilder<IMContactTab, IMContactAction> flowReduxStoreBuilder) {
        inCommonState(flowReduxStoreBuilder);
        inSearchState(flowReduxStoreBuilder);
    }

    private final void inCommonState(FlowReduxStoreBuilder<IMContactTab, IMContactAction> flowReduxStoreBuilder) {
        Function1 block$iv = new Function1() { // from class: im.contact.IMContactTabStateMachine$$ExternalSyntheticLambda18
            public final Object invoke(Object obj) {
                Unit inCommonState$lambda$0;
                inCommonState$lambda$0 = IMContactTabStateMachine.inCommonState$lambda$0(IMContactTabStateMachine.this, (InStateBuilderBlock) obj);
                return inCommonState$lambda$0;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(IMContactTabData.class), block$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit inCommonState$lambda$0(final IMContactTabStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.condition(new Function1() { // from class: im.contact.IMContactTabStateMachine$$ExternalSyntheticLambda21
            public final Object invoke(Object obj) {
                boolean inCommonState$lambda$0$0;
                inCommonState$lambda$0$0 = IMContactTabStateMachine.inCommonState$lambda$0$0((IMContactTabData) obj);
                return Boolean.valueOf(inCommonState$lambda$0$0);
            }
        }, new Function1() { // from class: im.contact.IMContactTabStateMachine$$ExternalSyntheticLambda22
            public final Object invoke(Object obj) {
                Unit inCommonState$lambda$0$1;
                inCommonState$lambda$0$1 = IMContactTabStateMachine.inCommonState$lambda$0$1((ConditionBuilderBlock) obj);
                return inCommonState$lambda$0$1;
            }
        });
        $this$inState.condition(new Function1() { // from class: im.contact.IMContactTabStateMachine$$ExternalSyntheticLambda23
            public final Object invoke(Object obj) {
                boolean inCommonState$lambda$0$2;
                inCommonState$lambda$0$2 = IMContactTabStateMachine.inCommonState$lambda$0$2((IMContactTabData) obj);
                return Boolean.valueOf(inCommonState$lambda$0$2);
            }
        }, new Function1() { // from class: im.contact.IMContactTabStateMachine$$ExternalSyntheticLambda24
            public final Object invoke(Object obj) {
                Unit inCommonState$lambda$0$3;
                inCommonState$lambda$0$3 = IMContactTabStateMachine.inCommonState$lambda$0$3((ConditionBuilderBlock) obj);
                return inCommonState$lambda$0$3;
            }
        });
        $this$inState.condition(new Function1() { // from class: im.contact.IMContactTabStateMachine$$ExternalSyntheticLambda25
            public final Object invoke(Object obj) {
                boolean inCommonState$lambda$0$4;
                inCommonState$lambda$0$4 = IMContactTabStateMachine.inCommonState$lambda$0$4((IMContactTabData) obj);
                return Boolean.valueOf(inCommonState$lambda$0$4);
            }
        }, new Function1() { // from class: im.contact.IMContactTabStateMachine$$ExternalSyntheticLambda26
            public final Object invoke(Object obj) {
                Unit inCommonState$lambda$0$5;
                inCommonState$lambda$0$5 = IMContactTabStateMachine.inCommonState$lambda$0$5(IMContactTabStateMachine.this, (ConditionBuilderBlock) obj);
                return inCommonState$lambda$0$5;
            }
        });
        $this$inState.condition(new Function1() { // from class: im.contact.IMContactTabStateMachine$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                boolean inCommonState$lambda$0$6;
                inCommonState$lambda$0$6 = IMContactTabStateMachine.inCommonState$lambda$0$6((IMContactTabData) obj);
                return Boolean.valueOf(inCommonState$lambda$0$6);
            }
        }, new Function1() { // from class: im.contact.IMContactTabStateMachine$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit inCommonState$lambda$0$7;
                inCommonState$lambda$0$7 = IMContactTabStateMachine.inCommonState$lambda$0$7((ConditionBuilderBlock) obj);
                return inCommonState$lambda$0$7;
            }
        });
        $this$inState.condition(new Function1() { // from class: im.contact.IMContactTabStateMachine$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                boolean inCommonState$lambda$0$8;
                inCommonState$lambda$0$8 = IMContactTabStateMachine.inCommonState$lambda$0$8((IMContactTabData) obj);
                return Boolean.valueOf(inCommonState$lambda$0$8);
            }
        }, new Function1() { // from class: im.contact.IMContactTabStateMachine$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit inCommonState$lambda$0$9;
                inCommonState$lambda$0$9 = IMContactTabStateMachine.inCommonState$lambda$0$9(IMContactTabStateMachine.this, (ConditionBuilderBlock) obj);
                return inCommonState$lambda$0$9;
            }
        });
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new IMContactTabStateMachine$inCommonState$1$11(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(IMContactActionEnterSearch.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean inCommonState$lambda$0$0(IMContactTabData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.getStatus(), StatusIdle.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit inCommonState$lambda$0$1(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new IMContactTabStateMachine$inCommonState$1$2$1(null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean inCommonState$lambda$0$2(IMContactTabData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (it.getStatus() instanceof StatusError) && it.getContacts$contact_debug().isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit inCommonState$lambda$0$3(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new IMContactTabStateMachine$inCommonState$1$4$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(IMContactRefresh.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean inCommonState$lambda$0$4(IMContactTabData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.getStatus(), StatusLoading.INSTANCE) && it.getContacts$contact_debug().isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit inCommonState$lambda$0$5(IMContactTabStateMachine this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new IMContactTabStateMachine$inCommonState$1$6$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean inCommonState$lambda$0$6(IMContactTabData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (Intrinsics.areEqual(it.getStatus(), StatusLoadingMore.INSTANCE) || it.getContacts$contact_debug().isEmpty() || !it.getHasMore$contact_debug()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit inCommonState$lambda$0$7(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new IMContactTabStateMachine$inCommonState$1$8$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(IMContactActionLoadMore.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean inCommonState$lambda$0$8(IMContactTabData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.getStatus(), StatusLoadingMore.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit inCommonState$lambda$0$9(IMContactTabStateMachine this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new IMContactTabStateMachine$inCommonState$1$10$1(this$0, null));
        return Unit.INSTANCE;
    }

    private final void inSearchState(FlowReduxStoreBuilder<IMContactTab, IMContactAction> flowReduxStoreBuilder) {
        Function1 block$iv = new Function1() { // from class: im.contact.IMContactTabStateMachine$$ExternalSyntheticLambda20
            public final Object invoke(Object obj) {
                Unit inSearchState$lambda$0;
                inSearchState$lambda$0 = IMContactTabStateMachine.inSearchState$lambda$0(IMContactTabStateMachine.this, (InStateBuilderBlock) obj);
                return inSearchState$lambda$0;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(IMContactSearchingTabData.class), block$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit inSearchState$lambda$0(final IMContactTabStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new IMContactTabStateMachine$inSearchState$1$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(IMContactActionSearch.class), executionPolicy$iv, handler$iv);
        $this$inState.condition(new Function1() { // from class: im.contact.IMContactTabStateMachine$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                boolean inSearchState$lambda$0$0;
                inSearchState$lambda$0$0 = IMContactTabStateMachine.inSearchState$lambda$0$0((IMContactSearchingTabData) obj);
                return Boolean.valueOf(inSearchState$lambda$0$0);
            }
        }, new Function1() { // from class: im.contact.IMContactTabStateMachine$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                Unit inSearchState$lambda$0$1;
                inSearchState$lambda$0$1 = IMContactTabStateMachine.inSearchState$lambda$0$1((ConditionBuilderBlock) obj);
                return inSearchState$lambda$0$1;
            }
        });
        $this$inState.condition(new Function1() { // from class: im.contact.IMContactTabStateMachine$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                boolean inSearchState$lambda$0$2;
                inSearchState$lambda$0$2 = IMContactTabStateMachine.inSearchState$lambda$0$2((IMContactSearchingTabData) obj);
                return Boolean.valueOf(inSearchState$lambda$0$2);
            }
        }, new Function1() { // from class: im.contact.IMContactTabStateMachine$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                Unit inSearchState$lambda$0$3;
                inSearchState$lambda$0$3 = IMContactTabStateMachine.inSearchState$lambda$0$3(IMContactTabStateMachine.this, (ConditionBuilderBlock) obj);
                return inSearchState$lambda$0$3;
            }
        });
        $this$inState.condition(new Function1() { // from class: im.contact.IMContactTabStateMachine$$ExternalSyntheticLambda10
            public final Object invoke(Object obj) {
                boolean inSearchState$lambda$0$4;
                inSearchState$lambda$0$4 = IMContactTabStateMachine.inSearchState$lambda$0$4((IMContactSearchingTabData) obj);
                return Boolean.valueOf(inSearchState$lambda$0$4);
            }
        }, new Function1() { // from class: im.contact.IMContactTabStateMachine$$ExternalSyntheticLambda12
            public final Object invoke(Object obj) {
                Unit inSearchState$lambda$0$5;
                inSearchState$lambda$0$5 = IMContactTabStateMachine.inSearchState$lambda$0$5((ConditionBuilderBlock) obj);
                return inSearchState$lambda$0$5;
            }
        });
        $this$inState.condition(new Function1() { // from class: im.contact.IMContactTabStateMachine$$ExternalSyntheticLambda13
            public final Object invoke(Object obj) {
                boolean inSearchState$lambda$0$6;
                inSearchState$lambda$0$6 = IMContactTabStateMachine.inSearchState$lambda$0$6((IMContactSearchingTabData) obj);
                return Boolean.valueOf(inSearchState$lambda$0$6);
            }
        }, new Function1() { // from class: im.contact.IMContactTabStateMachine$$ExternalSyntheticLambda14
            public final Object invoke(Object obj) {
                Unit inSearchState$lambda$0$7;
                inSearchState$lambda$0$7 = IMContactTabStateMachine.inSearchState$lambda$0$7(IMContactTabStateMachine.this, (ConditionBuilderBlock) obj);
                return inSearchState$lambda$0$7;
            }
        });
        BaseBuilderBlock.collectWhileInState$default((BaseBuilderBlock) $this$inState, this$0.searchService.getResultFlow$contact_debug(), (ExecutionPolicy) null, new IMContactTabStateMachine$inSearchState$1$10(this$0, null), 2, (Object) null);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv2 = new IMContactTabStateMachine$inSearchState$1$11(null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(IMContactActionExitSearch.class), executionPolicy$iv2, handler$iv2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean inSearchState$lambda$0$0(IMContactSearchingTabData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (it.getStatus() instanceof StatusError) && it.getSearchResult$contact_debug().isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit inSearchState$lambda$0$1(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new IMContactTabStateMachine$inSearchState$1$3$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(IMContactRefresh.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean inSearchState$lambda$0$2(IMContactSearchingTabData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.getStatus(), StatusLoading.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit inSearchState$lambda$0$3(final IMContactTabStateMachine this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.untilIdentityChanges(new Function1() { // from class: im.contact.IMContactTabStateMachine$$ExternalSyntheticLambda15
            public final Object invoke(Object obj) {
                Object inSearchState$lambda$0$3$0;
                inSearchState$lambda$0$3$0 = IMContactTabStateMachine.inSearchState$lambda$0$3$0((IMContactSearchingTabData) obj);
                return inSearchState$lambda$0$3$0;
            }
        }, new Function1() { // from class: im.contact.IMContactTabStateMachine$$ExternalSyntheticLambda16
            public final Object invoke(Object obj) {
                Unit inSearchState$lambda$0$3$1;
                inSearchState$lambda$0$3$1 = IMContactTabStateMachine.inSearchState$lambda$0$3$1(IMContactTabStateMachine.this, (IdentityBuilderBlock) obj);
                return inSearchState$lambda$0$3$1;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object inSearchState$lambda$0$3$0(IMContactSearchingTabData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getSearchWord();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit inSearchState$lambda$0$3$1(IMContactTabStateMachine this$0, IdentityBuilderBlock $this$untilIdentityChanges) {
        Intrinsics.checkNotNullParameter($this$untilIdentityChanges, "$this$untilIdentityChanges");
        $this$untilIdentityChanges.onEnterEffect(new IMContactTabStateMachine$inSearchState$1$5$2$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean inSearchState$lambda$0$4(IMContactSearchingTabData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !it.getShowList().isEmpty() && it.getHasMore$contact_debug();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit inSearchState$lambda$0$5(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new IMContactTabStateMachine$inSearchState$1$7$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(IMContactActionLoadMore.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean inSearchState$lambda$0$6(IMContactSearchingTabData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.getStatus(), StatusLoadingMore.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit inSearchState$lambda$0$7(IMContactTabStateMachine this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnterEffect(new IMContactTabStateMachine$inSearchState$1$9$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChangedState<IMContactTabData> updateFromReply(State<IMContactTabData> state, final ContactsReply reply) {
        return state.mutate(new Function1() { // from class: im.contact.IMContactTabStateMachine$$ExternalSyntheticLambda19
            public final Object invoke(Object obj) {
                IMContactTabData updateFromReply$lambda$0;
                updateFromReply$lambda$0 = IMContactTabStateMachine.updateFromReply$lambda$0(ContactsReply.this, (IMContactTabData) obj);
                return updateFromReply$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMContactTabData updateFromReply$lambda$0(final ContactsReply $reply, IMContactTabData $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        return (IMContactTabData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: im.contact.IMContactTabStateMachine$$ExternalSyntheticLambda11
            public final Object invoke(Object obj) {
                Unit updateFromReply$lambda$0$0;
                updateFromReply$lambda$0$0 = IMContactTabStateMachine.updateFromReply$lambda$0$0(ContactsReply.this, (CopyScope) obj);
                return updateFromReply$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateFromReply$lambda$0$0(ContactsReply $reply, CopyScope $this$copy) {
        Intrinsics.checkNotNullParameter($this$copy, "$this$copy");
        $this$copy.set(IMContactTabDataLensKt.getStatus(IMContactTabData.Companion), StatusSuccess.INSTANCE);
        $this$copy.set(IMContactTabDataLensKt.getContacts(IMContactTabData.Companion), CollectionsKt.plus((Collection) $this$copy.get(IMContactTabDataLensKt.getContacts(IMContactTabData.Companion)), $reply.getContacts()));
        $this$copy.set(IMContactTabDataLensKt.getPagingParams(IMContactTabData.Companion), $reply.getPaginationParams());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChangedState<IMContactSearchingTabData> updateFromReply(State<IMContactSearchingTabData> state, final ContactsSearchReply reply) {
        return state.mutate(new Function1() { // from class: im.contact.IMContactTabStateMachine$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                IMContactSearchingTabData updateFromReply$lambda$1;
                updateFromReply$lambda$1 = IMContactTabStateMachine.updateFromReply$lambda$1(ContactsSearchReply.this, (IMContactSearchingTabData) obj);
                return updateFromReply$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMContactSearchingTabData updateFromReply$lambda$1(final ContactsSearchReply $reply, IMContactSearchingTabData $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        return (IMContactSearchingTabData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: im.contact.IMContactTabStateMachine$$ExternalSyntheticLambda17
            public final Object invoke(Object obj) {
                Unit updateFromReply$lambda$1$0;
                updateFromReply$lambda$1$0 = IMContactTabStateMachine.updateFromReply$lambda$1$0(ContactsSearchReply.this, (CopyScope) obj);
                return updateFromReply$lambda$1$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateFromReply$lambda$1$0(ContactsSearchReply $reply, CopyScope $this$copy) {
        Intrinsics.checkNotNullParameter($this$copy, "$this$copy");
        $this$copy.set(IMContactSearchingTabDataLensKt.getStatus(IMContactSearchingTabData.Companion), StatusSuccess.INSTANCE);
        $this$copy.set(IMContactSearchingTabDataLensKt.getSearchResult(IMContactSearchingTabData.Companion), CollectionsKt.plus((Collection) $this$copy.get(IMContactSearchingTabDataLensKt.getSearchResult(IMContactSearchingTabData.Companion)), $reply.getContacts()));
        $this$copy.set(IMContactSearchingTabDataLensKt.getPagingParams(IMContactSearchingTabData.Companion), $reply.getPaginationParams());
        return Unit.INSTANCE;
    }
}