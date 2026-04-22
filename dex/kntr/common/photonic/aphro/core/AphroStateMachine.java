package kntr.common.photonic.aphro.core;

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
import javax.inject.Inject;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.aphro.core.AphroAction;
import kntr.common.photonic.aphro.core.AphroState;
import kntr.common.photonic.aphro.core.assets.AphroAssetsAction;
import kntr.common.photonic.aphro.core.assets.AphroAssetsBuilder;
import kntr.common.photonic.aphro.core.assets.AphroAssetsState;
import kntr.common.photonic.aphro.core.ext.PreviewSelectionNotifier;
import kntr.common.photonic.gallery.Gallery;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: AphroStateMachine.kt */
@AphroScope
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\r*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000eH\u0002J\u0018\u0010\u000f\u001a\u00020\r*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000eH\u0002J\u001e\u0010\u0010\u001a\u00020\r*\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0011H\u0002J\u001e\u0010\u0013\u001a\u00020\r*\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0011H\u0002J\u001e\u0010\u0014\u001a\u00020\r*\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0011H\u0002J\u001e\u0010\u0015\u001a\u00020\r*\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0011H\u0002J\u001e\u0010\u0016\u001a\u00020\r*\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0011H\u0002J\u001e\u0010\u0017\u001a\u00020\r*\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0011H\u0002J\u001e\u0010\u0018\u001a\u00020\r*\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0011H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lkntr/common/photonic/aphro/core/AphroStateMachine;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Lkntr/common/photonic/aphro/core/AphroState;", "Lkntr/common/photonic/aphro/core/AphroAction;", "initState", "Lkntr/common/photonic/aphro/core/AphroState$Init;", "gallery", "Lkntr/common/photonic/gallery/Gallery;", "assetsFactory", "Lkntr/common/photonic/aphro/core/assets/AphroAssetsBuilder;", "<init>", "(Lkntr/common/photonic/aphro/core/AphroState$Init;Lkntr/common/photonic/gallery/Gallery;Lkntr/common/photonic/aphro/core/assets/AphroAssetsBuilder;)V", "buildSpec", "", "Lcom/freeletics/flowredux/dsl/FlowReduxStoreBuilder;", "initLoad", "handleSwitch", "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "Lkntr/common/photonic/aphro/core/AphroState$AphroContent;", "handleRefresh", "handleAssets", "handleOriginImage", "handleConfirm", "handleExternalSelection", "handleSelect", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AphroStateMachine extends FlowReduxStateMachine<AphroState, AphroAction> {
    public static final int $stable = 8;
    private final AphroAssetsBuilder assetsFactory;
    private final Gallery gallery;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public AphroStateMachine(AphroState.Init initState, Gallery gallery, AphroAssetsBuilder assetsFactory) {
        super(initState);
        Intrinsics.checkNotNullParameter(initState, "initState");
        Intrinsics.checkNotNullParameter(gallery, "gallery");
        Intrinsics.checkNotNullParameter(assetsFactory, "assetsFactory");
        this.gallery = gallery;
        this.assetsFactory = assetsFactory;
        spec(new Function1() { // from class: kntr.common.photonic.aphro.core.AphroStateMachine$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = AphroStateMachine._init_$lambda$0(AphroStateMachine.this, (FlowReduxStoreBuilder) obj);
                return _init_$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(AphroStateMachine this$0, FlowReduxStoreBuilder $this$spec) {
        Intrinsics.checkNotNullParameter($this$spec, "$this$spec");
        this$0.buildSpec($this$spec);
        return Unit.INSTANCE;
    }

    private final void buildSpec(FlowReduxStoreBuilder<AphroState, AphroAction> flowReduxStoreBuilder) {
        initLoad(flowReduxStoreBuilder);
        Function1 block$iv = new Function1() { // from class: kntr.common.photonic.aphro.core.AphroStateMachine$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit buildSpec$lambda$0;
                buildSpec$lambda$0 = AphroStateMachine.buildSpec$lambda$0(AphroStateMachine.this, (InStateBuilderBlock) obj);
                return buildSpec$lambda$0;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(AphroState.AphroContent.class), block$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildSpec$lambda$0(AphroStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        this$0.handleSwitch($this$inState);
        this$0.handleAssets($this$inState);
        this$0.handleSelect($this$inState);
        this$0.handleOriginImage($this$inState);
        this$0.handleConfirm($this$inState);
        this$0.handleExternalSelection($this$inState);
        this$0.handleRefresh($this$inState);
        return Unit.INSTANCE;
    }

    private final void initLoad(FlowReduxStoreBuilder<AphroState, AphroAction> flowReduxStoreBuilder) {
        Function1 block$iv = new Function1() { // from class: kntr.common.photonic.aphro.core.AphroStateMachine$$ExternalSyntheticLambda10
            public final Object invoke(Object obj) {
                Unit initLoad$lambda$0;
                initLoad$lambda$0 = AphroStateMachine.initLoad$lambda$0((InStateBuilderBlock) obj);
                return initLoad$lambda$0;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(AphroState.Init.class), block$iv);
        Function1 block$iv2 = new Function1() { // from class: kntr.common.photonic.aphro.core.AphroStateMachine$$ExternalSyntheticLambda11
            public final Object invoke(Object obj) {
                Unit initLoad$lambda$1;
                initLoad$lambda$1 = AphroStateMachine.initLoad$lambda$1(AphroStateMachine.this, (InStateBuilderBlock) obj);
                return initLoad$lambda$1;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(AphroState.LoadingAlbum.class), block$iv2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initLoad$lambda$0(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new AphroStateMachine$initLoad$1$1(null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initLoad$lambda$1(AphroStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new AphroStateMachine$initLoad$2$1(this$0, null));
        return Unit.INSTANCE;
    }

    private final void handleSwitch(InStateBuilderBlock<AphroState.AphroContent, AphroState, AphroAction> inStateBuilderBlock) {
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new AphroStateMachine$handleSwitch$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(AphroAction.SwitchAlbum.class), executionPolicy$iv, handler$iv);
    }

    private final void handleRefresh(InStateBuilderBlock<AphroState.AphroContent, AphroState, AphroAction> inStateBuilderBlock) {
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new AphroStateMachine$handleRefresh$1(this, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(AphroAction.RefreshAlbums.class), executionPolicy$iv, handler$iv);
    }

    private final void handleAssets(InStateBuilderBlock<AphroState.AphroContent, AphroState, AphroAction> inStateBuilderBlock) {
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new AphroStateMachine$handleAssets$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(AphroAction.SetSelectedAssets.class), executionPolicy$iv, handler$iv);
        inStateBuilderBlock.untilIdentityChanges(new Function1() { // from class: kntr.common.photonic.aphro.core.AphroStateMachine$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Object handleAssets$lambda$0;
                handleAssets$lambda$0 = AphroStateMachine.handleAssets$lambda$0((AphroState.AphroContent) obj);
                return handleAssets$lambda$0;
            }
        }, new Function1() { // from class: kntr.common.photonic.aphro.core.AphroStateMachine$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Unit handleAssets$lambda$1;
                handleAssets$lambda$1 = AphroStateMachine.handleAssets$lambda$1(AphroStateMachine.this, (IdentityBuilderBlock) obj);
                return handleAssets$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object handleAssets$lambda$0(AphroState.AphroContent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return TuplesKt.to(Integer.valueOf(it.getAlbumRefresh$core_debug()), it.getSelectedAlbum());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleAssets$lambda$1(final AphroStateMachine this$0, IdentityBuilderBlock $this$untilIdentityChanges) {
        Intrinsics.checkNotNullParameter($this$untilIdentityChanges, "$this$untilIdentityChanges");
        $this$untilIdentityChanges.onEnterStartStateMachine(new Function1() { // from class: kntr.common.photonic.aphro.core.AphroStateMachine$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                StateMachine handleAssets$lambda$1$0;
                handleAssets$lambda$1$0 = AphroStateMachine.handleAssets$lambda$1$0(AphroStateMachine.this, (AphroState.AphroContent) obj);
                return handleAssets$lambda$1$0;
            }
        }, new Function1() { // from class: kntr.common.photonic.aphro.core.AphroStateMachine$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                AphroAssetsAction handleAssets$lambda$1$1;
                handleAssets$lambda$1$1 = AphroStateMachine.handleAssets$lambda$1$1((AphroAction) obj);
                return handleAssets$lambda$1$1;
            }
        }, new Function2() { // from class: kntr.common.photonic.aphro.core.AphroStateMachine$$ExternalSyntheticLambda9
            public final Object invoke(Object obj, Object obj2) {
                ChangedState handleAssets$lambda$1$2;
                handleAssets$lambda$1$2 = AphroStateMachine.handleAssets$lambda$1$2((State) obj, (AphroAssetsState) obj2);
                return handleAssets$lambda$1$2;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StateMachine handleAssets$lambda$1$0(AphroStateMachine this$0, AphroState.AphroContent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this$0.assetsFactory.build(new AphroAssetsState.Init(it.getSelectedAlbum(), it.getRequiredAssetCount$core_debug()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AphroAssetsAction handleAssets$lambda$1$1(AphroAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it instanceof AphroAction.LoadMoreAsset ? AphroAssetsAction.LoadMore.INSTANCE : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChangedState handleAssets$lambda$1$2(State state, final AphroAssetsState assetState) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(assetState, "assetState");
        return state.mutate(new Function1() { // from class: kntr.common.photonic.aphro.core.AphroStateMachine$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                AphroState.AphroContent handleAssets$lambda$1$2$0;
                handleAssets$lambda$1$2$0 = AphroStateMachine.handleAssets$lambda$1$2$0(AphroAssetsState.this, (AphroState.AphroContent) obj);
                return handleAssets$lambda$1$2$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AphroState.AphroContent handleAssets$lambda$1$2$0(AphroAssetsState $assetState, AphroState.AphroContent $this$mutate) {
        AphroState.AphroContent copy;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        copy = $this$mutate.copy((r24 & 1) != 0 ? $this$mutate.status : null, (r24 & 2) != 0 ? $this$mutate.selectedAlbum : null, (r24 & 4) != 0 ? $this$mutate.albumList : null, (r24 & 8) != 0 ? $this$mutate.assetsState : $assetState, (r24 & 16) != 0 ? $this$mutate.option : null, (r24 & 32) != 0 ? $this$mutate.useOriginImage : false, (r24 & 64) != 0 ? $this$mutate.confirmed : false, (r24 & 128) != 0 ? $this$mutate.selected : null, (r24 & 256) != 0 ? $this$mutate.albumRefresh : 0, (r24 & 512) != 0 ? $this$mutate.requiredAssetCount : 0, (r24 & 1024) != 0 ? $this$mutate.toast : null);
        return copy;
    }

    private final void handleOriginImage(InStateBuilderBlock<AphroState.AphroContent, AphroState, AphroAction> inStateBuilderBlock) {
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new AphroStateMachine$handleOriginImage$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(AphroAction.CheckUseOriginImage.class), executionPolicy$iv, handler$iv);
    }

    private final void handleConfirm(InStateBuilderBlock<AphroState.AphroContent, AphroState, AphroAction> inStateBuilderBlock) {
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new AphroStateMachine$handleConfirm$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(AphroAction.ConfirmSelection.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv2 = new AphroStateMachine$handleConfirm$2(null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(AphroAction.ConsumeConfirm.class), executionPolicy$iv2, handler$iv2);
    }

    private final void handleExternalSelection(InStateBuilderBlock<AphroState.AphroContent, AphroState, AphroAction> inStateBuilderBlock) {
        BaseBuilderBlock.collectWhileInStateEffect$default((BaseBuilderBlock) inStateBuilderBlock, PreviewSelectionNotifier.INSTANCE.getUseOriginEvent(), (ExecutionPolicy) null, new AphroStateMachine$handleExternalSelection$1(this, null), 2, (Object) null);
        BaseBuilderBlock.collectWhileInStateEffect$default((BaseBuilderBlock) inStateBuilderBlock, PreviewSelectionNotifier.INSTANCE.getAssetSelectEvent(), (ExecutionPolicy) null, new AphroStateMachine$handleExternalSelection$2(this, null), 2, (Object) null);
    }

    private final void handleSelect(InStateBuilderBlock<AphroState.AphroContent, AphroState, AphroAction> inStateBuilderBlock) {
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.common.photonic.aphro.core.AphroStateMachine$$ExternalSyntheticLambda12
            public final Object invoke(Object obj) {
                boolean handleSelect$lambda$0;
                handleSelect$lambda$0 = AphroStateMachine.handleSelect$lambda$0((AphroState.AphroContent) obj);
                return Boolean.valueOf(handleSelect$lambda$0);
            }
        }, new Function1() { // from class: kntr.common.photonic.aphro.core.AphroStateMachine$$ExternalSyntheticLambda13
            public final Object invoke(Object obj) {
                Unit handleSelect$lambda$1;
                handleSelect$lambda$1 = AphroStateMachine.handleSelect$lambda$1((ConditionBuilderBlock) obj);
                return handleSelect$lambda$1;
            }
        });
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.common.photonic.aphro.core.AphroStateMachine$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                boolean handleSelect$lambda$2;
                handleSelect$lambda$2 = AphroStateMachine.handleSelect$lambda$2((AphroState.AphroContent) obj);
                return Boolean.valueOf(handleSelect$lambda$2);
            }
        }, new Function1() { // from class: kntr.common.photonic.aphro.core.AphroStateMachine$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit handleSelect$lambda$3;
                handleSelect$lambda$3 = AphroStateMachine.handleSelect$lambda$3((ConditionBuilderBlock) obj);
                return handleSelect$lambda$3;
            }
        });
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new AphroStateMachine$handleSelect$5(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(AphroAction.UnSelectAsset.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv2 = new AphroStateMachine$handleSelect$6(null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(AphroAction.ClearSelectedAssets.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv3 = new AphroStateMachine$handleSelect$7(null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(AphroAction.SetSelectedAssets.class), executionPolicy$iv3, handler$iv3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean handleSelect$lambda$0(AphroState.AphroContent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getSelected().size() < it.getOption().getRemainingSelectCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleSelect$lambda$1(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new AphroStateMachine$handleSelect$2$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(AphroAction.SelectAsset.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean handleSelect$lambda$2(AphroState.AphroContent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getSelected().size() >= it.getOption().getRemainingSelectCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleSelect$lambda$3(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new AphroStateMachine$handleSelect$4$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(AphroAction.SelectAsset.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }
}