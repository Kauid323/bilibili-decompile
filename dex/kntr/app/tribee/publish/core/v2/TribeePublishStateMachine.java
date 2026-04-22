package kntr.app.tribee.publish.core.v2;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStateMachine;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import com.google.common.base.Optional;
import javax.inject.Inject;
import kntr.app.tribee.publish.core.v2.TribeePublishAction;
import kntr.app.tribee.publish.core.v2.di.TribeePublishOuroStore;
import kntr.app.tribee.publish.core.v2.di.TribeePublishScope;
import kntr.app.tribee.publish.core.v2.model.TribeePublishContent;
import kntr.app.tribee.publish.core.v2.model.TribeePublishFailed;
import kntr.app.tribee.publish.core.v2.model.TribeePublishState;
import kntr.app.tribee.publish.core.v2.model.TribeePublishSucceed;
import kntr.app.tribee.publish.core.v2.model.TribeePublishUploading;
import kntr.app.tribee.publish.core.v2.service.TribeePublishDataConverter;
import kntr.app.tribee.publish.core.v2.service.TribeePublishDraftService;
import kntr.app.tribee.publish.core.v2.service.TribeePublishInitService;
import kntr.app.tribee.publish.core.v2.service.TribeePublishService;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroStore;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;

/* compiled from: TribeePublishStateMachine.kt */
@TribeePublishScope
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001BA\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u0013*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u0013*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0014H\u0002J\u0018\u0010\u0016\u001a\u00020\u0013*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0014H\u0002J\u001e\u0010\u0017\u001a\u00020\u0013*\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0018H\u0002J\u001e\u0010\u001a\u001a\u00020\u0013*\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0018H\u0002J\u0018\u0010\u001b\u001a\u00020\u0013*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0014H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lkntr/app/tribee/publish/core/v2/TribeePublishStateMachine;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishState;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction;", "init", "ouroStore", "Lkntr/common/ouro/core/OuroStore;", "initService", "Lkntr/app/tribee/publish/core/v2/service/TribeePublishInitService;", "publishService", "Lkntr/app/tribee/publish/core/v2/service/TribeePublishService;", "draftService", "Lcom/google/common/base/Optional;", "Lkntr/app/tribee/publish/core/v2/service/TribeePublishDraftService;", "converter", "Lkntr/app/tribee/publish/core/v2/service/TribeePublishDataConverter;", "<init>", "(Lkntr/app/tribee/publish/core/v2/model/TribeePublishState;Lkntr/common/ouro/core/OuroStore;Lkntr/app/tribee/publish/core/v2/service/TribeePublishInitService;Lkntr/app/tribee/publish/core/v2/service/TribeePublishService;Lcom/google/common/base/Optional;Lkntr/app/tribee/publish/core/v2/service/TribeePublishDataConverter;)V", "handleReport", "", "Lcom/freeletics/flowredux/dsl/FlowReduxStoreBuilder;", "handleClose", "handleToast", "handleInput", "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishContent;", "handleDraft", "handlePublish", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeePublishStateMachine extends FlowReduxStateMachine<TribeePublishState, TribeePublishAction> {
    private final TribeePublishDataConverter converter;
    private final Optional<TribeePublishDraftService> draftService;
    private final TribeePublishInitService initService;
    private final OuroStore ouroStore;
    private final TribeePublishService publishService;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public TribeePublishStateMachine(TribeePublishState init, @TribeePublishOuroStore OuroStore ouroStore, TribeePublishInitService initService, TribeePublishService publishService, Optional<TribeePublishDraftService> optional, TribeePublishDataConverter converter) {
        super(init);
        Intrinsics.checkNotNullParameter(init, "init");
        Intrinsics.checkNotNullParameter(ouroStore, "ouroStore");
        Intrinsics.checkNotNullParameter(initService, "initService");
        Intrinsics.checkNotNullParameter(publishService, "publishService");
        Intrinsics.checkNotNullParameter(optional, "draftService");
        Intrinsics.checkNotNullParameter(converter, "converter");
        this.ouroStore = ouroStore;
        this.initService = initService;
        this.publishService = publishService;
        this.draftService = optional;
        this.converter = converter;
        spec(new Function1() { // from class: kntr.app.tribee.publish.core.v2.TribeePublishStateMachine$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = TribeePublishStateMachine._init_$lambda$0(TribeePublishStateMachine.this, (FlowReduxStoreBuilder) obj);
                return _init_$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(final TribeePublishStateMachine this$0, FlowReduxStoreBuilder $this$spec) {
        Intrinsics.checkNotNullParameter($this$spec, "$this$spec");
        TribeePublishInitService $this$lambda_u240_u240 = this$0.initService;
        $this$lambda_u240_u240.initBlock($this$spec);
        Function1 block$iv = new Function1() { // from class: kntr.app.tribee.publish.core.v2.TribeePublishStateMachine$$ExternalSyntheticLambda10
            public final Object invoke(Object obj) {
                return TribeePublishStateMachine.lambda$0$1(TribeePublishStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(TribeePublishContent.class), block$iv);
        this$0.handlePublish($this$spec);
        this$0.handleClose($this$spec);
        this$0.handleToast($this$spec);
        this$0.handleReport($this$spec);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$1(TribeePublishStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        this$0.handleInput($this$inState);
        this$0.handleDraft($this$inState);
        return Unit.INSTANCE;
    }

    private final void handleReport(FlowReduxStoreBuilder<TribeePublishState, TribeePublishAction> flowReduxStoreBuilder) {
        Function1 block$iv = new Function1() { // from class: kntr.app.tribee.publish.core.v2.TribeePublishStateMachine$$ExternalSyntheticLambda11
            public final Object invoke(Object obj) {
                Unit handleReport$lambda$0;
                handleReport$lambda$0 = TribeePublishStateMachine.handleReport$lambda$0((InStateBuilderBlock) obj);
                return handleReport$lambda$0;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(TribeePublishState.class), block$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleReport$lambda$0(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new TribeePublishStateMachine$handleReport$1$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.onActionEffect(Reflection.getOrCreateKotlinClass(TribeePublishAction.TrackerAction.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    private final void handleClose(FlowReduxStoreBuilder<TribeePublishState, TribeePublishAction> flowReduxStoreBuilder) {
        Function1 block$iv = new Function1() { // from class: kntr.app.tribee.publish.core.v2.TribeePublishStateMachine$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                Unit handleClose$lambda$0;
                handleClose$lambda$0 = TribeePublishStateMachine.handleClose$lambda$0((InStateBuilderBlock) obj);
                return handleClose$lambda$0;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(TribeePublishState.class), block$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleClose$lambda$0(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new TribeePublishStateMachine$handleClose$1$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(TribeePublishAction.Close.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    private final void handleToast(FlowReduxStoreBuilder<TribeePublishState, TribeePublishAction> flowReduxStoreBuilder) {
        Function1 block$iv = new Function1() { // from class: kntr.app.tribee.publish.core.v2.TribeePublishStateMachine$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit handleToast$lambda$0;
                handleToast$lambda$0 = TribeePublishStateMachine.handleToast$lambda$0((InStateBuilderBlock) obj);
                return handleToast$lambda$0;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(TribeePublishState.class), block$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleToast$lambda$0(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new TribeePublishStateMachine$handleToast$1$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(TribeePublishAction.ConsumeToast.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    private final void handleInput(InStateBuilderBlock<TribeePublishContent, TribeePublishState, TribeePublishAction> inStateBuilderBlock) {
        BaseBuilderBlock.collectWhileInState$default((BaseBuilderBlock) inStateBuilderBlock, new Function1() { // from class: kntr.app.tribee.publish.core.v2.TribeePublishStateMachine$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Flow handleInput$lambda$0;
                handleInput$lambda$0 = TribeePublishStateMachine.handleInput$lambda$0(TribeePublishStateMachine.this, (TribeePublishContent) obj);
                return handleInput$lambda$0;
            }
        }, (ExecutionPolicy) null, new TribeePublishStateMachine$handleInput$2(null), 2, (Object) null);
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new TribeePublishStateMachine$handleInput$3(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(TribeePublishAction.TitleChanged.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv2 = new TribeePublishStateMachine$handleInput$4(null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(TribeePublishAction.SwitchSendToFollowing.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv3 = new TribeePublishStateMachine$handleInput$5(null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(TribeePublishAction.ToggleSelectedCategory.class), executionPolicy$iv3, handler$iv3);
        BaseBuilderBlock $this$iv4 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv4 = new TribeePublishStateMachine$handleInput$6(null);
        ExecutionPolicy executionPolicy$iv4 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv4.on(Reflection.getOrCreateKotlinClass(TribeePublishAction.DismissConfirmDialog.class), executionPolicy$iv4, handler$iv4);
        BaseBuilderBlock $this$iv5 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv5 = new TribeePublishStateMachine$handleInput$7(null);
        ExecutionPolicy executionPolicy$iv5 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv5.on(Reflection.getOrCreateKotlinClass(TribeePublishAction.SwitchSettingItem.class), executionPolicy$iv5, handler$iv5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow handleInput$lambda$0(TribeePublishStateMachine this$0, TribeePublishContent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this$0.ouroStore.getStateFlow();
    }

    private final void handleDraft(InStateBuilderBlock<TribeePublishContent, TribeePublishState, TribeePublishAction> inStateBuilderBlock) {
        TribeePublishDraftService draftService = (TribeePublishDraftService) this.draftService.orNull();
        if (draftService != null) {
            BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
            Function3 handler$iv = new TribeePublishStateMachine$handleDraft$1(draftService, this, null);
            ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
            $this$iv.onActionEffect(Reflection.getOrCreateKotlinClass(TribeePublishAction.SaveDraft.class), executionPolicy$iv, handler$iv);
            BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) inStateBuilderBlock;
            Function3 handler$iv2 = new TribeePublishStateMachine$handleDraft$2(draftService, null);
            ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
            $this$iv2.onActionEffect(Reflection.getOrCreateKotlinClass(TribeePublishAction.ClearDraft.class), executionPolicy$iv2, handler$iv2);
        }
    }

    private final void handlePublish(FlowReduxStoreBuilder<TribeePublishState, TribeePublishAction> flowReduxStoreBuilder) {
        Function1 block$iv = new Function1() { // from class: kntr.app.tribee.publish.core.v2.TribeePublishStateMachine$$ExternalSyntheticLambda12
            public final Object invoke(Object obj) {
                Unit handlePublish$lambda$0;
                handlePublish$lambda$0 = TribeePublishStateMachine.handlePublish$lambda$0((InStateBuilderBlock) obj);
                return handlePublish$lambda$0;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(TribeePublishContent.class), block$iv);
        Function1 block$iv2 = new Function1() { // from class: kntr.app.tribee.publish.core.v2.TribeePublishStateMachine$$ExternalSyntheticLambda13
            public final Object invoke(Object obj) {
                Unit handlePublish$lambda$1;
                handlePublish$lambda$1 = TribeePublishStateMachine.handlePublish$lambda$1(TribeePublishStateMachine.this, (InStateBuilderBlock) obj);
                return handlePublish$lambda$1;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(TribeePublishUploading.class), block$iv2);
        Function1 block$iv3 = new Function1() { // from class: kntr.app.tribee.publish.core.v2.TribeePublishStateMachine$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit handlePublish$lambda$2;
                handlePublish$lambda$2 = TribeePublishStateMachine.handlePublish$lambda$2((InStateBuilderBlock) obj);
                return handlePublish$lambda$2;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(TribeePublishSucceed.class), block$iv3);
        Function1 block$iv4 = new Function1() { // from class: kntr.app.tribee.publish.core.v2.TribeePublishStateMachine$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit handlePublish$lambda$3;
                handlePublish$lambda$3 = TribeePublishStateMachine.handlePublish$lambda$3((InStateBuilderBlock) obj);
                return handlePublish$lambda$3;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(TribeePublishFailed.class), block$iv4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handlePublish$lambda$0(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.condition(new Function1() { // from class: kntr.app.tribee.publish.core.v2.TribeePublishStateMachine$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                boolean handlePublish$lambda$0$0;
                handlePublish$lambda$0$0 = TribeePublishStateMachine.handlePublish$lambda$0$0((TribeePublishContent) obj);
                return Boolean.valueOf(handlePublish$lambda$0$0);
            }
        }, new Function1() { // from class: kntr.app.tribee.publish.core.v2.TribeePublishStateMachine$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Unit handlePublish$lambda$0$1;
                handlePublish$lambda$0$1 = TribeePublishStateMachine.handlePublish$lambda$0$1((ConditionBuilderBlock) obj);
                return handlePublish$lambda$0$1;
            }
        });
        $this$inState.condition(new Function1() { // from class: kntr.app.tribee.publish.core.v2.TribeePublishStateMachine$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                boolean handlePublish$lambda$0$2;
                handlePublish$lambda$0$2 = TribeePublishStateMachine.handlePublish$lambda$0$2((TribeePublishContent) obj);
                return Boolean.valueOf(handlePublish$lambda$0$2);
            }
        }, new Function1() { // from class: kntr.app.tribee.publish.core.v2.TribeePublishStateMachine$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                Unit handlePublish$lambda$0$3;
                handlePublish$lambda$0$3 = TribeePublishStateMachine.handlePublish$lambda$0$3((ConditionBuilderBlock) obj);
                return handlePublish$lambda$0$3;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean handlePublish$lambda$0$0(TribeePublishContent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getReadyForPublish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handlePublish$lambda$0$1(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new TribeePublishStateMachine$handlePublish$1$2$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(TribeePublishAction.Publish.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean handlePublish$lambda$0$2(TribeePublishContent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !it.getReadyForPublish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handlePublish$lambda$0$3(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new TribeePublishStateMachine$handlePublish$1$4$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(TribeePublishAction.Publish.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handlePublish$lambda$1(TribeePublishStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new TribeePublishStateMachine$handlePublish$2$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handlePublish$lambda$2(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new TribeePublishStateMachine$handlePublish$3$1(null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handlePublish$lambda$3(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new TribeePublishStateMachine$handlePublish$4$1(null));
        return Unit.INSTANCE;
    }
}