package kntr.app.tribee.publish;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStateMachine;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import com.freeletics.flowredux.dsl.State;
import com.freeletics.mad.statemachine.StateMachine;
import javax.inject.Inject;
import kntr.app.tribee.publish.TribeePublishAction;
import kntr.app.tribee.publish.di.TribeePublishScope;
import kntr.app.tribee.publish.draft.TribeeDraftService;
import kntr.app.tribee.publish.service.TribeeContentConverter;
import kntr.app.tribee.publish.service.TribeeInitService;
import kntr.app.tribee.publish.service.TribeePublishService;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.input.RichTextAction;
import kntr.common.paragraph.input.RichTextContent;
import kntr.common.paragraph.input.RichTextStateMachineFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: TribeePublishStateMachine.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B9\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u0012*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\u0012*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0013H\u0002J\u0018\u0010\u0015\u001a\u00020\u0012*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0013H\u0002J\u001e\u0010\u0016\u001a\u00020\u0012*\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0017H\u0002J\u001e\u0010\u0019\u001a\u00020\u0012*\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0017H\u0002J\u0018\u0010\u001a\u001a\u00020\u0012*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0013H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lkntr/app/tribee/publish/TribeePublishStateMachine;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Lkntr/app/tribee/publish/TribeePublishState;", "Lkntr/app/tribee/publish/TribeePublishAction;", "init", "initService", "Lkntr/app/tribee/publish/service/TribeeInitService;", "publishService", "Lkntr/app/tribee/publish/service/TribeePublishService;", "contentFactory", "Lkntr/common/paragraph/input/RichTextStateMachineFactory;", "draftService", "Lkntr/app/tribee/publish/draft/TribeeDraftService;", "converter", "Lkntr/app/tribee/publish/service/TribeeContentConverter;", "<init>", "(Lkntr/app/tribee/publish/TribeePublishState;Lkntr/app/tribee/publish/service/TribeeInitService;Lkntr/app/tribee/publish/service/TribeePublishService;Lkntr/common/paragraph/input/RichTextStateMachineFactory;Lkntr/app/tribee/publish/draft/TribeeDraftService;Lkntr/app/tribee/publish/service/TribeeContentConverter;)V", "handleReport", "", "Lcom/freeletics/flowredux/dsl/FlowReduxStoreBuilder;", "handleClose", "handleToast", "handleInput", "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "Lkntr/app/tribee/publish/TribeePublishContent;", "handleDraft", "handlePublish", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@TribeePublishScope
public final class TribeePublishStateMachine extends FlowReduxStateMachine<TribeePublishState, TribeePublishAction> {
    private final RichTextStateMachineFactory contentFactory;
    private final TribeeContentConverter converter;
    private final TribeeDraftService draftService;
    private final TribeeInitService initService;
    private final TribeePublishService publishService;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public TribeePublishStateMachine(TribeePublishState init, TribeeInitService initService, TribeePublishService publishService, RichTextStateMachineFactory contentFactory, TribeeDraftService draftService, TribeeContentConverter converter) {
        super(init);
        Intrinsics.checkNotNullParameter(init, "init");
        Intrinsics.checkNotNullParameter(initService, "initService");
        Intrinsics.checkNotNullParameter(publishService, "publishService");
        Intrinsics.checkNotNullParameter(contentFactory, "contentFactory");
        Intrinsics.checkNotNullParameter(draftService, "draftService");
        Intrinsics.checkNotNullParameter(converter, "converter");
        this.initService = initService;
        this.publishService = publishService;
        this.contentFactory = contentFactory;
        this.draftService = draftService;
        this.converter = converter;
        spec(new Function1() { // from class: kntr.app.tribee.publish.TribeePublishStateMachine$$ExternalSyntheticLambda2
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
        TribeeInitService $this$lambda_u240_u240 = this$0.initService;
        $this$lambda_u240_u240.initBlock($this$spec);
        Function1 block$iv = new Function1() { // from class: kntr.app.tribee.publish.TribeePublishStateMachine$$ExternalSyntheticLambda16
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
        Function1 block$iv = new Function1() { // from class: kntr.app.tribee.publish.TribeePublishStateMachine$$ExternalSyntheticLambda1
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
        $this$iv.onActionEffect(Reflection.getOrCreateKotlinClass(TribeePublishAction.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    private final void handleClose(FlowReduxStoreBuilder<TribeePublishState, TribeePublishAction> flowReduxStoreBuilder) {
        Function1 block$iv = new Function1() { // from class: kntr.app.tribee.publish.TribeePublishStateMachine$$ExternalSyntheticLambda0
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
        Function1 block$iv = new Function1() { // from class: kntr.app.tribee.publish.TribeePublishStateMachine$$ExternalSyntheticLambda3
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
        inStateBuilderBlock.onEnterStartStateMachine(new Function1() { // from class: kntr.app.tribee.publish.TribeePublishStateMachine$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                StateMachine handleInput$lambda$0;
                handleInput$lambda$0 = TribeePublishStateMachine.handleInput$lambda$0(TribeePublishStateMachine.this, (TribeePublishContent) obj);
                return handleInput$lambda$0;
            }
        }, new Function1() { // from class: kntr.app.tribee.publish.TribeePublishStateMachine$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                RichTextAction handleInput$lambda$1;
                handleInput$lambda$1 = TribeePublishStateMachine.handleInput$lambda$1((TribeePublishAction) obj);
                return handleInput$lambda$1;
            }
        }, new Function2() { // from class: kntr.app.tribee.publish.TribeePublishStateMachine$$ExternalSyntheticLambda6
            public final Object invoke(Object obj, Object obj2) {
                ChangedState handleInput$lambda$2;
                handleInput$lambda$2 = TribeePublishStateMachine.handleInput$lambda$2((State) obj, (RichTextContent) obj2);
                return handleInput$lambda$2;
            }
        });
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new TribeePublishStateMachine$handleInput$4(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(TribeePublishAction.TitleChanged.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv2 = new TribeePublishStateMachine$handleInput$5(null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(TribeePublishAction.SwitchSendToFollowing.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv3 = new TribeePublishStateMachine$handleInput$6(null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(TribeePublishAction.DismissConfirmDialog.class), executionPolicy$iv3, handler$iv3);
        BaseBuilderBlock $this$iv4 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv4 = new TribeePublishStateMachine$handleInput$7(null);
        ExecutionPolicy executionPolicy$iv4 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv4.on(Reflection.getOrCreateKotlinClass(TribeePublishAction.ToggleSelectedCategory.class), executionPolicy$iv4, handler$iv4);
        BaseBuilderBlock $this$iv5 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv5 = new TribeePublishStateMachine$handleInput$8(null);
        ExecutionPolicy executionPolicy$iv5 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv5.on(Reflection.getOrCreateKotlinClass(TribeePublishAction.SwitchSettingItem.class), executionPolicy$iv5, handler$iv5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StateMachine handleInput$lambda$0(TribeePublishStateMachine this$0, TribeePublishContent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this$0.contentFactory.create(it.getContent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChangedState handleInput$lambda$2(State state, final RichTextContent subState) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(subState, "subState");
        return state.mutate(new Function1() { // from class: kntr.app.tribee.publish.TribeePublishStateMachine$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                TribeePublishContent handleInput$lambda$2$0;
                handleInput$lambda$2$0 = TribeePublishStateMachine.handleInput$lambda$2$0(RichTextContent.this, (TribeePublishContent) obj);
                return handleInput$lambda$2$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeePublishContent handleInput$lambda$2$0(RichTextContent $subState, TribeePublishContent $this$mutate) {
        TribeePublishContent copy;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        copy = $this$mutate.copy((r28 & 1) != 0 ? $this$mutate.title : null, (r28 & 2) != 0 ? $this$mutate.content : $subState, (r28 & 4) != 0 ? $this$mutate.tribeeInfo : null, (r28 & 8) != 0 ? $this$mutate.limitInfo : null, (r28 & 16) != 0 ? $this$mutate.categories : null, (r28 & 32) != 0 ? $this$mutate.selectedCategory : null, (r28 & 64) != 0 ? $this$mutate.validLimitInfo : false, (r28 & 128) != 0 ? $this$mutate.settingItems : null, (r28 & 256) != 0 ? $this$mutate.sendToFollowing : false, (r28 & 512) != 0 ? $this$mutate.fromDraft : false, (r28 & 1024) != 0 ? $this$mutate.fromEdit : false, (r28 & 2048) != 0 ? $this$mutate.showPublishConfirmDialog : false, (r28 & 4096) != 0 ? $this$mutate.toast : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RichTextAction handleInput$lambda$1(TribeePublishAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        TribeePublishAction.ContentAction contentAction = it instanceof TribeePublishAction.ContentAction ? (TribeePublishAction.ContentAction) it : null;
        if (contentAction != null) {
            return contentAction.getContentAction();
        }
        return null;
    }

    private final void handleDraft(InStateBuilderBlock<TribeePublishContent, TribeePublishState, TribeePublishAction> inStateBuilderBlock) {
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new TribeePublishStateMachine$handleDraft$1(this, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.onActionEffect(Reflection.getOrCreateKotlinClass(TribeePublishAction.SaveDraft.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv2 = new TribeePublishStateMachine$handleDraft$2(this, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.onActionEffect(Reflection.getOrCreateKotlinClass(TribeePublishAction.ClearDraft.class), executionPolicy$iv2, handler$iv2);
    }

    private final void handlePublish(FlowReduxStoreBuilder<TribeePublishState, TribeePublishAction> flowReduxStoreBuilder) {
        Function1 block$iv = new Function1() { // from class: kntr.app.tribee.publish.TribeePublishStateMachine$$ExternalSyntheticLambda12
            public final Object invoke(Object obj) {
                Unit handlePublish$lambda$0;
                handlePublish$lambda$0 = TribeePublishStateMachine.handlePublish$lambda$0((InStateBuilderBlock) obj);
                return handlePublish$lambda$0;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(TribeePublishContent.class), block$iv);
        Function1 block$iv2 = new Function1() { // from class: kntr.app.tribee.publish.TribeePublishStateMachine$$ExternalSyntheticLambda13
            public final Object invoke(Object obj) {
                Unit handlePublish$lambda$1;
                handlePublish$lambda$1 = TribeePublishStateMachine.handlePublish$lambda$1(TribeePublishStateMachine.this, (InStateBuilderBlock) obj);
                return handlePublish$lambda$1;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(TribeePublishUploading.class), block$iv2);
        Function1 block$iv3 = new Function1() { // from class: kntr.app.tribee.publish.TribeePublishStateMachine$$ExternalSyntheticLambda14
            public final Object invoke(Object obj) {
                Unit handlePublish$lambda$2;
                handlePublish$lambda$2 = TribeePublishStateMachine.handlePublish$lambda$2((InStateBuilderBlock) obj);
                return handlePublish$lambda$2;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(TribeePublishSucceed.class), block$iv3);
        Function1 block$iv4 = new Function1() { // from class: kntr.app.tribee.publish.TribeePublishStateMachine$$ExternalSyntheticLambda15
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
        $this$inState.condition(new Function1() { // from class: kntr.app.tribee.publish.TribeePublishStateMachine$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                boolean handlePublish$lambda$0$0;
                handlePublish$lambda$0$0 = TribeePublishStateMachine.handlePublish$lambda$0$0((TribeePublishContent) obj);
                return Boolean.valueOf(handlePublish$lambda$0$0);
            }
        }, new Function1() { // from class: kntr.app.tribee.publish.TribeePublishStateMachine$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                Unit handlePublish$lambda$0$1;
                handlePublish$lambda$0$1 = TribeePublishStateMachine.handlePublish$lambda$0$1((ConditionBuilderBlock) obj);
                return handlePublish$lambda$0$1;
            }
        });
        $this$inState.condition(new Function1() { // from class: kntr.app.tribee.publish.TribeePublishStateMachine$$ExternalSyntheticLambda10
            public final Object invoke(Object obj) {
                boolean handlePublish$lambda$0$2;
                handlePublish$lambda$0$2 = TribeePublishStateMachine.handlePublish$lambda$0$2((TribeePublishContent) obj);
                return Boolean.valueOf(handlePublish$lambda$0$2);
            }
        }, new Function1() { // from class: kntr.app.tribee.publish.TribeePublishStateMachine$$ExternalSyntheticLambda11
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