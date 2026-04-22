package kntr.common.paragraph.input;

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
import dagger.assisted.Assisted;
import dagger.assisted.AssistedInject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.assetuploader.base.AssetUploadState;
import kntr.common.paragraph.assetuploader.base.OriginAssetUploadState;
import kntr.common.paragraph.assetuploader.stateMachine.AssetUploaderStateMachineFactory;
import kntr.common.paragraph.input.RichTextAction;
import kntr.common.paragraph.input.content.AssetContent;
import kntr.common.paragraph.input.content.ParagraphContent;
import kntr.common.paragraph.input.content.TextContent;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: RichTextStateMachine.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001b\b\u0007\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\t\u001a\u00020\n*\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000bH\u0002J\u001e\u0010\f\u001a\u00020\n*\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000bH\u0002J\u001e\u0010\r\u001a\u00020\n*\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000bH\u0002J\u001e\u0010\u000e\u001a\u00020\n*\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkntr/common/paragraph/input/RichTextStateMachine;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Lkntr/common/paragraph/input/RichTextContent;", "Lkntr/common/paragraph/input/RichTextAction;", "init", "startAssetStateMachineFactory", "Lkntr/common/paragraph/assetuploader/stateMachine/AssetUploaderStateMachineFactory;", "<init>", "(Lkntr/common/paragraph/input/RichTextContent;Lkntr/common/paragraph/assetuploader/stateMachine/AssetUploaderStateMachineFactory;)V", "ensureLastText", "", "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "textInput", "removeAsset", "insertAsset", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class RichTextStateMachine extends FlowReduxStateMachine<RichTextContent, RichTextAction> {
    private final AssetUploaderStateMachineFactory startAssetStateMachineFactory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @AssistedInject
    public RichTextStateMachine(@Assisted("") RichTextContent init, AssetUploaderStateMachineFactory startAssetStateMachineFactory) {
        super(init);
        Intrinsics.checkNotNullParameter(init, "init");
        Intrinsics.checkNotNullParameter(startAssetStateMachineFactory, "startAssetStateMachineFactory");
        this.startAssetStateMachineFactory = startAssetStateMachineFactory;
        spec(new Function1() { // from class: kntr.common.paragraph.input.RichTextStateMachine$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = RichTextStateMachine._init_$lambda$0(RichTextStateMachine.this, (FlowReduxStoreBuilder) obj);
                return _init_$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(final RichTextStateMachine this$0, FlowReduxStoreBuilder $this$spec) {
        Intrinsics.checkNotNullParameter($this$spec, "$this$spec");
        Function1 block$iv = new Function1() { // from class: kntr.common.paragraph.input.RichTextStateMachine$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return RichTextStateMachine.lambda$0$0(RichTextStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(RichTextContent.class), block$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0(RichTextStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        this$0.textInput($this$inState);
        this$0.insertAsset($this$inState);
        this$0.removeAsset($this$inState);
        this$0.ensureLastText($this$inState);
        return Unit.INSTANCE;
    }

    private final void ensureLastText(InStateBuilderBlock<RichTextContent, RichTextContent, RichTextAction> inStateBuilderBlock) {
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.common.paragraph.input.RichTextStateMachine$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                boolean ensureLastText$lambda$0;
                ensureLastText$lambda$0 = RichTextStateMachine.ensureLastText$lambda$0((RichTextContent) obj);
                return Boolean.valueOf(ensureLastText$lambda$0);
            }
        }, new Function1() { // from class: kntr.common.paragraph.input.RichTextStateMachine$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit ensureLastText$lambda$1;
                ensureLastText$lambda$1 = RichTextStateMachine.ensureLastText$lambda$1((ConditionBuilderBlock) obj);
                return ensureLastText$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ensureLastText$lambda$0(RichTextContent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !(CollectionsKt.lastOrNull(it.getContentList()) instanceof TextContent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ensureLastText$lambda$1(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new RichTextStateMachine$ensureLastText$2$1(null));
        return Unit.INSTANCE;
    }

    private final void textInput(InStateBuilderBlock<RichTextContent, RichTextContent, RichTextAction> inStateBuilderBlock) {
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new RichTextStateMachine$textInput$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(RichTextAction.TextChanged.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv2 = new RichTextStateMachine$textInput$2(null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(RichTextAction.FocusOn.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv3 = new RichTextStateMachine$textInput$3(this, null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.onActionEffect(Reflection.getOrCreateKotlinClass(RichTextAction.FocusOnFirstText.class), executionPolicy$iv3, handler$iv3);
        BaseBuilderBlock $this$iv4 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv4 = new RichTextStateMachine$textInput$4(this, null);
        ExecutionPolicy executionPolicy$iv4 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv4.onActionEffect(Reflection.getOrCreateKotlinClass(RichTextAction.RetryFocusOn.class), executionPolicy$iv4, handler$iv4);
        BaseBuilderBlock $this$iv5 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv5 = new RichTextStateMachine$textInput$5(null);
        ExecutionPolicy executionPolicy$iv5 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv5.on(Reflection.getOrCreateKotlinClass(RichTextAction.FocusOnTitle.class), executionPolicy$iv5, handler$iv5);
        BaseBuilderBlock $this$iv6 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv6 = new RichTextStateMachine$textInput$6(null);
        ExecutionPolicy executionPolicy$iv6 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv6.on(Reflection.getOrCreateKotlinClass(RichTextAction.FocusConsumed.class), executionPolicy$iv6, handler$iv6);
    }

    private final void removeAsset(InStateBuilderBlock<RichTextContent, RichTextContent, RichTextAction> inStateBuilderBlock) {
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new RichTextStateMachine$removeAsset$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(RichTextAction.RemoveAsset.class), executionPolicy$iv, handler$iv);
    }

    private final void insertAsset(InStateBuilderBlock<RichTextContent, RichTextContent, RichTextAction> inStateBuilderBlock) {
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new RichTextStateMachine$insertAsset$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(RichTextAction.AddAsset.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv2 = new RichTextStateMachine$insertAsset$2(this, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.onActionEffect(Reflection.getOrCreateKotlinClass(RichTextAction.RetryAsset.class), executionPolicy$iv2, handler$iv2);
        inStateBuilderBlock.untilIdentityChanges(new Function1() { // from class: kntr.common.paragraph.input.RichTextStateMachine$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Object insertAsset$lambda$0;
                insertAsset$lambda$0 = RichTextStateMachine.insertAsset$lambda$0((RichTextContent) obj);
                return insertAsset$lambda$0;
            }
        }, new Function1() { // from class: kntr.common.paragraph.input.RichTextStateMachine$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit insertAsset$lambda$1;
                insertAsset$lambda$1 = RichTextStateMachine.insertAsset$lambda$1(RichTextStateMachine.this, (IdentityBuilderBlock) obj);
                return insertAsset$lambda$1;
            }
        });
        BaseBuilderBlock this_$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function2 stateMachineFactory$iv = new Function2() { // from class: kntr.common.paragraph.input.RichTextStateMachine$$ExternalSyntheticLambda6
            public final Object invoke(Object obj, Object obj2) {
                StateMachine insertAsset$lambda$2;
                insertAsset$lambda$2 = RichTextStateMachine.insertAsset$lambda$2(RichTextStateMachine.this, (StartAsset) obj, (RichTextContent) obj2);
                return insertAsset$lambda$2;
            }
        };
        Function1 actionMapper$iv = new Function1() { // from class: kntr.common.paragraph.input.RichTextStateMachine$insertAsset$6
            public final Void invoke(RichTextAction it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return null;
            }
        };
        Function2 stateMapper$iv = new Function2() { // from class: kntr.common.paragraph.input.RichTextStateMachine$$ExternalSyntheticLambda7
            public final Object invoke(Object obj, Object obj2) {
                ChangedState insertAsset$lambda$3;
                insertAsset$lambda$3 = RichTextStateMachine.insertAsset$lambda$3((State) obj, (AssetUploadState) obj2);
                return insertAsset$lambda$3;
            }
        };
        this_$iv.onActionStartStateMachine(Reflection.getOrCreateKotlinClass(StartAsset.class), stateMachineFactory$iv, actionMapper$iv, stateMapper$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object insertAsset$lambda$0(RichTextContent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getAssetMap$core_debug();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit insertAsset$lambda$1(RichTextStateMachine this$0, IdentityBuilderBlock $this$untilIdentityChanges) {
        Intrinsics.checkNotNullParameter($this$untilIdentityChanges, "$this$untilIdentityChanges");
        $this$untilIdentityChanges.onEnterEffect(new RichTextStateMachine$insertAsset$4$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StateMachine insertAsset$lambda$2(RichTextStateMachine this$0, StartAsset action, RichTextContent richTextContent) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(richTextContent, "<unused var>");
        return this$0.startAssetStateMachineFactory.create(new OriginAssetUploadState(action.getAsset(), action.getUseOrigin()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChangedState insertAsset$lambda$3(State state, final AssetUploadState assetContent) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(assetContent, "assetContent");
        return state.mutate(new Function1() { // from class: kntr.common.paragraph.input.RichTextStateMachine$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                RichTextContent insertAsset$lambda$3$0;
                insertAsset$lambda$3$0 = RichTextStateMachine.insertAsset$lambda$3$0(AssetUploadState.this, (RichTextContent) obj);
                return insertAsset$lambda$3$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RichTextContent insertAsset$lambda$3$0(AssetUploadState $assetContent, RichTextContent $this$mutate) {
        AssetContent assetContent;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        Iterable $this$map$iv = $this$mutate.getContentList();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            ParagraphContent it = (ParagraphContent) item$iv$iv;
            if ((it instanceof AssetContent) && Intrinsics.areEqual(((AssetContent) it).getAsset(), $assetContent.getAsset())) {
                assetContent = new AssetContent($assetContent);
            } else {
                assetContent = it;
            }
            destination$iv$iv.add(assetContent);
        }
        ArrayList arrayList = (List) destination$iv$iv;
        Map $this$insertAsset_u24lambda_u243_u240_u241 = MapsKt.toMutableMap($this$mutate.getAssetMap$core_debug());
        Asset asset = $assetContent.getAsset();
        if (asset != null) {
            $this$insertAsset_u24lambda_u243_u240_u241.put(asset, new AssetContent($assetContent));
        }
        Unit unit = Unit.INSTANCE;
        return RichTextContent.copy$default($this$mutate, arrayList, 0, false, MapsKt.toMap($this$insertAsset_u24lambda_u243_u240_u241), 6, null);
    }
}