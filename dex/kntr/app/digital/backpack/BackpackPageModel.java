package kntr.app.digital.backpack;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import com.bilibili.compose.theme.BiliTheme;
import javax.inject.Inject;
import kntr.app.digital.backpack.PageState;
import kntr.app.digital.backpack.api.GetBackpackAssetBag;
import kntr.app.digital.backpack.di.PageScope;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.komponent.HostConfiguration;
import kntr.common.komponent.Komponent;
import kntr.common.komponent.KomponentHostScope;
import kntr.common.komponent.KomponentKt;
import kntr.common.komponent.KomponentScope;
import kntr.common.komponent.SetContentResult;
import kntr.common.komponent.UiComposableLike;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: BackpackPageModel.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b²\u0006\n\u0010\f\u001a\u00020\rX\u008a\u008e\u0002²\u0006\u0010\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000fX\u008a\u0084\u0002"}, d2 = {"Lkntr/app/digital/backpack/BackpackPageModel;", RoomRecommendViewModel.EMPTY_CURSOR, "createBackpackKomponent", "Lkntr/app/digital/backpack/CreateBackpackKomponent;", "getBackpackAssetBag", "Lkntr/app/digital/backpack/api/GetBackpackAssetBag;", "<init>", "(Lkntr/app/digital/backpack/CreateBackpackKomponent;Lkntr/app/digital/backpack/api/GetBackpackAssetBag;)V", "komponent", "Lkntr/common/komponent/Komponent;", RoomRecommendViewModel.EMPTY_CURSOR, "backpack_debug", "state", "Lkntr/app/digital/backpack/PageState;", "content", "Lkntr/common/komponent/UiComposableLike;"}, k = 1, mv = {2, 2, 0}, xi = 48)
@PageScope
public final class BackpackPageModel {
    public static final int $stable = 0;
    private final CreateBackpackKomponent createBackpackKomponent;
    private final GetBackpackAssetBag getBackpackAssetBag;

    @Inject
    public BackpackPageModel(CreateBackpackKomponent createBackpackKomponent, GetBackpackAssetBag getBackpackAssetBag) {
        Intrinsics.checkNotNullParameter(createBackpackKomponent, "createBackpackKomponent");
        Intrinsics.checkNotNullParameter(getBackpackAssetBag, "getBackpackAssetBag");
        this.createBackpackKomponent = createBackpackKomponent;
        this.getBackpackAssetBag = getBackpackAssetBag;
    }

    public final Komponent<Unit> komponent() {
        return KomponentKt.Komponent(new Function1() { // from class: kntr.app.digital.backpack.BackpackPageModel$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                SetContentResult komponent$lambda$0;
                komponent$lambda$0 = BackpackPageModel.komponent$lambda$0(BackpackPageModel.this, (KomponentScope) obj);
                return komponent$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SetContentResult komponent$lambda$0(final BackpackPageModel this$0, final KomponentScope $this$Komponent) {
        Intrinsics.checkNotNullParameter($this$Komponent, "$this$Komponent");
        final MutableState state$delegate = SnapshotStateKt.mutableStateOf$default(PageState.Loading.INSTANCE, (SnapshotMutationPolicy) null, 2, (Object) null);
        komponent$lambda$0$requestData($this$Komponent, this$0, state$delegate);
        final Flow $this$map$iv = SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.digital.backpack.BackpackPageModel$$ExternalSyntheticLambda1
            public final Object invoke() {
                PageState komponent$lambda$0$0;
                komponent$lambda$0$0 = BackpackPageModel.komponent$lambda$0$0(state$delegate);
                return komponent$lambda$0$0;
            }
        });
        Flow it = new Flow<Komponent<? extends Unit>>() { // from class: kntr.app.digital.backpack.BackpackPageModel$komponent$lambda$0$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: kntr.app.digital.backpack.BackpackPageModel$komponent$lambda$0$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ MutableState $state$delegate$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ BackpackPageModel this$0;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "kntr.app.digital.backpack.BackpackPageModel$komponent$lambda$0$$inlined$map$1$2", f = "BackpackPageModel.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                /* renamed from: kntr.app.digital.backpack.BackpackPageModel$komponent$lambda$0$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, BackpackPageModel backpackPageModel, MutableState mutableState) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = backpackPageModel;
                    this.$state$delegate$inlined = mutableState;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    CreateBackpackKomponent createBackpackKomponent;
                    PageState komponent$lambda$0$0;
                    Komponent<Unit> invoke;
                    if ($completion instanceof AnonymousClass1) {
                        $continuation = (AnonymousClass1) $completion;
                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                            $continuation.label -= Integer.MIN_VALUE;
                            Object $result = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                    AnonymousClass1 anonymousClass1 = $continuation;
                                    PageState it = (PageState) value;
                                    if (it instanceof PageState.Failure) {
                                        invoke = KomponentKt.Komponent(new Function1<KomponentScope<? super Unit>, SetContentResult>() { // from class: kntr.app.digital.backpack.BackpackPageModel$komponent$1$content$3$1
                                            public final SetContentResult invoke(final KomponentScope<? super Unit> komponentScope) {
                                                Intrinsics.checkNotNullParameter(komponentScope, "$this$Komponent");
                                                final Object state$iv$iv = Unit.INSTANCE;
                                                UiComposableLike content$iv$iv$iv = new UiComposableLike<S>(state$iv$iv, komponentScope) { // from class: kntr.app.digital.backpack.BackpackPageModel$komponent$1$content$3$1$invoke$$inlined$setContent$1
                                                    final /* synthetic */ KomponentScope $this_setContent;
                                                    private final S state;

                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        this.$this_setContent = komponentScope;
                                                        this.state = state$iv$iv;
                                                    }

                                                    public void invoke(Modifier modifier, Composer $composer, int $changed) {
                                                        Intrinsics.checkNotNullParameter(modifier, "modifier");
                                                        $composer.startReplaceGroup(1906618612);
                                                        ComposerKt.sourceInformation($composer, "C(invoke)N(modifier)87@2987L17:Komponent.kt#vxw63z");
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1906618612, $changed, -1, "kntr.common.komponent.setContent.<no name provided>.invoke (Komponent.kt:86)");
                                                        }
                                                        $composer.startReplaceGroup(-795075863);
                                                        ComposerKt.sourceInformation($composer, "CN(modifier)*79@2925L22:BackpackPageModel.kt#nfb1io");
                                                        BackpackPageModel.komponent$lambda$0$ErrorContent(modifier, $composer, $changed & 14 & 14, 0);
                                                        $composer.endReplaceGroup();
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                        $composer.endReplaceGroup();
                                                    }

                                                    public Object getContentType() {
                                                        return Reflection.getOrCreateKotlinClass(getClass());
                                                    }

                                                    public Object getKey() {
                                                        return this.$this_setContent.getKey();
                                                    }

                                                    public S getState() {
                                                        return this.state;
                                                    }

                                                    public HostConfiguration getPreferredHostConfiguration() {
                                                        return this.$this_setContent.getPreferredHostConfiguration();
                                                    }
                                                };
                                                return komponentScope.__setContent(content$iv$iv$iv);
                                            }
                                        });
                                    } else if (Intrinsics.areEqual(it, PageState.Loading.INSTANCE)) {
                                        invoke = KomponentKt.Komponent(new Function1<KomponentScope<? super Unit>, SetContentResult>() { // from class: kntr.app.digital.backpack.BackpackPageModel$komponent$1$content$3$2
                                            public final SetContentResult invoke(final KomponentScope<? super Unit> komponentScope) {
                                                Intrinsics.checkNotNullParameter(komponentScope, "$this$Komponent");
                                                final Object state$iv$iv = Unit.INSTANCE;
                                                UiComposableLike content$iv$iv$iv = new UiComposableLike<S>(state$iv$iv, komponentScope) { // from class: kntr.app.digital.backpack.BackpackPageModel$komponent$1$content$3$2$invoke$$inlined$setContent$1
                                                    final /* synthetic */ KomponentScope $this_setContent;
                                                    private final S state;

                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        this.$this_setContent = komponentScope;
                                                        this.state = state$iv$iv;
                                                    }

                                                    public void invoke(Modifier modifier, Composer $composer, int $changed) {
                                                        Intrinsics.checkNotNullParameter(modifier, "modifier");
                                                        $composer.startReplaceGroup(1906618612);
                                                        ComposerKt.sourceInformation($composer, "C(invoke)N(modifier)87@2987L17:Komponent.kt#vxw63z");
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1906618612, $changed, -1, "kntr.common.komponent.setContent.<no name provided>.invoke (Komponent.kt:86)");
                                                        }
                                                        int i = $changed & 14;
                                                        $composer.startReplaceGroup(1158649768);
                                                        ComposerKt.sourceInformation($composer, "CN(it):BackpackPageModel.kt#nfb1io");
                                                        $composer.endReplaceGroup();
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                        $composer.endReplaceGroup();
                                                    }

                                                    public Object getContentType() {
                                                        return Reflection.getOrCreateKotlinClass(getClass());
                                                    }

                                                    public Object getKey() {
                                                        return this.$this_setContent.getKey();
                                                    }

                                                    public S getState() {
                                                        return this.state;
                                                    }

                                                    public HostConfiguration getPreferredHostConfiguration() {
                                                        return this.$this_setContent.getPreferredHostConfiguration();
                                                    }
                                                };
                                                return komponentScope.__setContent(content$iv$iv$iv);
                                            }
                                        });
                                    } else if (it instanceof PageState.Ready) {
                                        createBackpackKomponent = this.this$0.createBackpackKomponent;
                                        komponent$lambda$0$0 = BackpackPageModel.komponent$lambda$0$0(this.$state$delegate$inlined);
                                        Intrinsics.checkNotNull(komponent$lambda$0$0, "null cannot be cast to non-null type kntr.app.digital.backpack.PageState.Ready");
                                        invoke = createBackpackKomponent.invoke(((PageState.Ready) komponent$lambda$0$0).getAssetBagModel());
                                    } else {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
                                    $continuation.I$0 = 0;
                                    $continuation.label = 1;
                                    if ($this$map_u24lambda_u245.emit(invoke, $continuation) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                case 1:
                                    int i = $continuation.I$0;
                                    FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                    Object obj = $continuation.L$2;
                                    AnonymousClass1 anonymousClass12 = (AnonymousClass1) $continuation.L$1;
                                    Object value2 = $continuation.L$0;
                                    ResultKt.throwOnFailure($result);
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    $continuation = new AnonymousClass1($completion);
                    Object $result2 = $continuation.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch ($continuation.label) {
                    }
                    return Unit.INSTANCE;
                }
            }

            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv.collect(new AnonymousClass2(collector, this$0, state$delegate), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
        final State content$delegate = KomponentKt.embedFlow((KomponentHostScope) $this$Komponent, it);
        final Object state$iv$iv = Unit.INSTANCE;
        UiComposableLike content$iv$iv$iv = new UiComposableLike<S>(state$iv$iv, $this$Komponent, content$delegate) { // from class: kntr.app.digital.backpack.BackpackPageModel$komponent$lambda$0$$inlined$setContent$1
            final /* synthetic */ State $content$delegate$inlined;
            final /* synthetic */ KomponentScope $this_setContent;
            private final S state;

            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$this_setContent = $this$Komponent;
                this.$content$delegate$inlined = content$delegate;
                this.state = state$iv$iv;
            }

            public void invoke(Modifier modifier, Composer $composer, int $changed) {
                UiComposableLike komponent$lambda$0$6;
                Intrinsics.checkNotNullParameter(modifier, "modifier");
                $composer.startReplaceGroup(1906618612);
                ComposerKt.sourceInformation($composer, "C(invoke)N(modifier)87@2987L17:Komponent.kt#vxw63z");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1906618612, $changed, -1, "kntr.common.komponent.setContent.<no name provided>.invoke (Komponent.kt:86)");
                }
                int i = $changed & 14;
                $composer.startReplaceGroup(1643992569);
                ComposerKt.sourceInformation($composer, "CN(it)*96@3535L162:BackpackPageModel.kt#nfb1io");
                komponent$lambda$0$6 = BackpackPageModel.komponent$lambda$0$6(this.$content$delegate$inlined);
                komponent$lambda$0$6.invoke(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier, 0.0f, 1, (Object) null), Color.Companion.getBlack-0d7_KjU(), (Shape) null, 2, (Object) null), $composer, 0);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceGroup();
            }

            public Object getContentType() {
                return Reflection.getOrCreateKotlinClass(getClass());
            }

            public Object getKey() {
                return this.$this_setContent.getKey();
            }

            public S getState() {
                return this.state;
            }

            public HostConfiguration getPreferredHostConfiguration() {
                return this.$this_setContent.getPreferredHostConfiguration();
            }
        };
        return $this$Komponent.__setContent(content$iv$iv$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PageState komponent$lambda$0$0(MutableState<PageState> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (PageState) $this$getValue$iv.getValue();
    }

    private static final void komponent$lambda$0$requestData(KomponentScope<? super Unit> komponentScope, BackpackPageModel this$0, MutableState<PageState> mutableState) {
        KomponentHostScope.-CC.launch$default((KomponentHostScope) komponentScope, (CoroutineContext) null, (CoroutineStart) null, new BackpackPageModel$komponent$1$requestData$1(this$0, mutableState, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void komponent$lambda$0$ErrorContent(Modifier modifier, Composer $composer, int $changed, int i) {
        Function0 factory$iv$iv$iv;
        ComposerKt.sourceInformationMarkerStart($composer, 1359561047, "C(ErrorContent)N(modifier)62@2261L370:BackpackPageModel.kt#nfb1io");
        Modifier modifier2 = (i & 1) != 0 ? (Modifier) Modifier.Companion : modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1359561047, $changed, -1, "kntr.app.digital.backpack.BackpackPageModel.komponent.<anonymous>.ErrorContent (BackpackPageModel.kt:61)");
        }
        Alignment contentAlignment$iv = Alignment.Companion.getCenter();
        int $changed$iv = ($changed & 14) | 48;
        Modifier modifier$iv = modifier2;
        ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
        int $changed$iv$iv = ($changed$iv << 3) & 112;
        ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
        CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
        Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
            factory$iv$iv$iv = factory$iv$iv$iv2;
            $composer.createNode(factory$iv$iv$iv);
        } else {
            factory$iv$iv$iv = factory$iv$iv$iv2;
            $composer.useNode();
        }
        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
        int i2 = ($changed$iv$iv$iv >> 6) & 14;
        ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
        BoxScope boxScope = BoxScopeInstance.INSTANCE;
        int i3 = (($changed$iv >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, 1785408297, "C69@2569L9,66@2420L189:BackpackPageModel.kt#nfb1io");
        TextKt.Text-Nvy7gAk("发生了错误，请重试", (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT14(), $composer, 390, 0, 131066);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UiComposableLike<Unit> komponent$lambda$0$6(State<? extends UiComposableLike<Unit>> state) {
        Object thisObj$iv = state.getValue();
        return (UiComposableLike) thisObj$iv;
    }
}