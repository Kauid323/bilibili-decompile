package kntr.app.digital.preview;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.Map;
import javax.inject.Inject;
import kntr.app.digital.preview.PageState;
import kntr.app.digital.preview.api.CardPreviewModel;
import kntr.app.digital.preview.api.GetCardList;
import kntr.app.digital.preview.card.CardInfoUIKt;
import kntr.app.digital.preview.card.DigitalItemContainerKt;
import kntr.app.digital.preview.card.image.ImageModuleKt;
import kntr.app.digital.preview.shop.ShopPreviewComponent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.komponent.HostConfiguration;
import kntr.common.komponent.Komponent;
import kntr.common.komponent.KomponentHostScope;
import kntr.common.komponent.KomponentKt;
import kntr.common.komponent.KomponentLocalAccessScope;
import kntr.common.komponent.KomponentScope;
import kntr.common.komponent.LocalOnFinishKt;
import kntr.common.komponent.SetContentResult;
import kntr.common.komponent.UiComposableLike;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.app.digital.preview.generated.resources.Drawable0_commonMainKt;
import srcs.app.digital.preview.generated.resources.Res;

/* compiled from: CardPreviewPageModel.kt */
@PageScope
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0001\u0018\u00002\u00020\u0001B3\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011²\u0006\n\u0010\u0012\u001a\u00020\u0013X\u008a\u008e\u0002²\u0006\n\u0010\u0014\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\f\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u008a\u008e\u0002²\u0006\u0010\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u0019X\u008a\u0084\u0002"}, d2 = {"Lkntr/app/digital/preview/CardPreviewPageModel;", RoomRecommendViewModel.EMPTY_CURSOR, "shopPreviewComponentFactory", "Lkntr/app/digital/preview/shop/ShopPreviewComponent$Factory;", "params", "Lkntr/app/digital/preview/api/GetCardList$RequestParams;", "getCardList", "Lkntr/app/digital/preview/api/GetCardList;", "simpleCard", "Lkntr/app/digital/preview/SimpleCard;", "dialogService", "Lkntr/app/digital/preview/DialogService;", "<init>", "(Lkntr/app/digital/preview/shop/ShopPreviewComponent$Factory;Lkntr/app/digital/preview/api/GetCardList$RequestParams;Lkntr/app/digital/preview/api/GetCardList;Lkntr/app/digital/preview/SimpleCard;Lkntr/app/digital/preview/DialogService;)V", "komponent", "Lkntr/common/komponent/Komponent;", RoomRecommendViewModel.EMPTY_CURSOR, "preview_debug", "state", "Lkntr/app/digital/preview/PageState;", "animationFinished", RoomRecommendViewModel.EMPTY_CURSOR, "pendingPageData", "Lkntr/app/digital/preview/api/CardPreviewModel;", "content", "Lkntr/common/komponent/UiComposableLike;"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CardPreviewPageModel {
    public static final int $stable = 0;
    private final DialogService dialogService;
    private final GetCardList getCardList;
    private final GetCardList.RequestParams params;
    private final ShopPreviewComponent.Factory shopPreviewComponentFactory;
    private final SimpleCard simpleCard;

    @Inject
    public CardPreviewPageModel(ShopPreviewComponent.Factory shopPreviewComponentFactory, GetCardList.RequestParams params, GetCardList getCardList, SimpleCard simpleCard, DialogService dialogService) {
        Intrinsics.checkNotNullParameter(shopPreviewComponentFactory, "shopPreviewComponentFactory");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(getCardList, "getCardList");
        Intrinsics.checkNotNullParameter(dialogService, "dialogService");
        this.shopPreviewComponentFactory = shopPreviewComponentFactory;
        this.params = params;
        this.getCardList = getCardList;
        this.simpleCard = simpleCard;
        this.dialogService = dialogService;
    }

    public final Komponent<Unit> komponent() {
        return KomponentKt.Komponent(new Function1() { // from class: kntr.app.digital.preview.CardPreviewPageModel$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                SetContentResult komponent$lambda$0;
                komponent$lambda$0 = CardPreviewPageModel.komponent$lambda$0(CardPreviewPageModel.this, (KomponentScope) obj);
                return komponent$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SetContentResult komponent$lambda$0(final CardPreviewPageModel this$0, final KomponentScope $this$Komponent) {
        Intrinsics.checkNotNullParameter($this$Komponent, "$this$Komponent");
        final MutableState state$delegate = SnapshotStateKt.mutableStateOf$default(PageState.Initial.INSTANCE, (SnapshotMutationPolicy) null, 2, (Object) null);
        final MutableState animationFinished$delegate = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        final MutableState pendingPageData$delegate = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        komponent$lambda$0$requestCardList($this$Komponent, this$0, animationFinished$delegate, state$delegate, pendingPageData$delegate);
        final Flow $this$map$iv = SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.digital.preview.CardPreviewPageModel$$ExternalSyntheticLambda0
            public final Object invoke() {
                PageState komponent$lambda$0$0;
                komponent$lambda$0$0 = CardPreviewPageModel.komponent$lambda$0$0(state$delegate);
                return komponent$lambda$0$0;
            }
        });
        Flow it = new Flow<Komponent<? extends Unit>>() { // from class: kntr.app.digital.preview.CardPreviewPageModel$komponent$lambda$0$$inlined$map$1
            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv.collect(new AnonymousClass2(collector, this$0, $this$Komponent, animationFinished$delegate, pendingPageData$delegate, state$delegate), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: kntr.app.digital.preview.CardPreviewPageModel$komponent$lambda$0$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ MutableState $animationFinished$delegate$inlined;
                final /* synthetic */ MutableState $pendingPageData$delegate$inlined;
                final /* synthetic */ MutableState $state$delegate$inlined;
                final /* synthetic */ KomponentScope $this_Komponent$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ CardPreviewPageModel this$0;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "kntr.app.digital.preview.CardPreviewPageModel$komponent$lambda$0$$inlined$map$1$2", f = "CardPreviewPageModel.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                /* renamed from: kntr.app.digital.preview.CardPreviewPageModel$komponent$lambda$0$$inlined$map$1$2$1  reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, CardPreviewPageModel cardPreviewPageModel, KomponentScope komponentScope, MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = cardPreviewPageModel;
                    this.$this_Komponent$inlined = komponentScope;
                    this.$animationFinished$delegate$inlined = mutableState;
                    this.$pendingPageData$delegate$inlined = mutableState2;
                    this.$state$delegate$inlined = mutableState3;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0045  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    ShopPreviewComponent.Factory factory;
                    PageState komponent$lambda$0$0;
                    Komponent<Unit> komponent;
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
                                    if (Intrinsics.areEqual(it, PageState.Initial.INSTANCE)) {
                                        final CardPreviewPageModel cardPreviewPageModel = this.this$0;
                                        final MutableState mutableState = this.$animationFinished$delegate$inlined;
                                        final KomponentScope komponentScope = this.$this_Komponent$inlined;
                                        final MutableState mutableState2 = this.$pendingPageData$delegate$inlined;
                                        final MutableState mutableState3 = this.$state$delegate$inlined;
                                        komponent = KomponentKt.Komponent(
                                        /*  JADX ERROR: Method code generation error
                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0078: INVOKE  (r1v11 'komponent' kntr.common.komponent.Komponent<kotlin.Unit>) = 
                                              (wrap: kotlin.jvm.functions.Function1<kntr.common.komponent.KomponentScope<? super kotlin.Unit>, kntr.common.komponent.SetContentResult> : 0x0073: CONSTRUCTOR  (r12v5 kotlin.jvm.functions.Function1<kntr.common.komponent.KomponentScope<? super kotlin.Unit>, kntr.common.komponent.SetContentResult> A[REMOVE]) = 
                                              (r14v0 'cardPreviewPageModel' kntr.app.digital.preview.CardPreviewPageModel A[DONT_INLINE])
                                              (r15v0 'mutableState' androidx.compose.runtime.MutableState A[DONT_INLINE])
                                              (r13v0 'komponentScope' kntr.common.komponent.KomponentScope A[DONT_INLINE])
                                              (r1v10 'mutableState2' androidx.compose.runtime.MutableState A[DONT_INLINE])
                                              (r3v10 'mutableState3' androidx.compose.runtime.MutableState A[DONT_INLINE])
                                             call: kntr.app.digital.preview.CardPreviewPageModel$komponent$1$content$3$1.<init>(kntr.app.digital.preview.CardPreviewPageModel, androidx.compose.runtime.MutableState, kntr.common.komponent.KomponentScope, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState):void type: CONSTRUCTOR)
                                             type: STATIC call: kntr.common.komponent.KomponentKt.Komponent(kotlin.jvm.functions.Function1):kntr.common.komponent.Komponent in method: kntr.app.digital.preview.CardPreviewPageModel$komponent$lambda$0$$inlined$map$1.2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                                            	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:267)
                                            	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:79)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
                                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                            	at java.util.ArrayList.forEach(ArrayList.java:1257)
                                            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:390)
                                            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: kntr.app.digital.preview.CardPreviewPageModel$komponent$1$content$3$1, state: NOT_LOADED
                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:302)
                                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:769)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:718)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:417)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1097)
                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:872)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:421)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
                                            	... 39 more
                                            */
                                        /*
                                            this = this;
                                            r0 = r20
                                            r1 = r22
                                            boolean r2 = r1 instanceof kntr.app.digital.preview.CardPreviewPageModel$komponent$lambda$0$$inlined$map$1.AnonymousClass2.AnonymousClass1
                                            if (r2 == 0) goto L18
                                            r2 = r1
                                            kntr.app.digital.preview.CardPreviewPageModel$komponent$lambda$0$$inlined$map$1$2$1 r2 = (kntr.app.digital.preview.CardPreviewPageModel$komponent$lambda$0$$inlined$map$1.AnonymousClass2.AnonymousClass1) r2
                                            int r3 = r2.label
                                            r4 = -2147483648(0xffffffff80000000, float:-0.0)
                                            r3 = r3 & r4
                                            if (r3 == 0) goto L18
                                            int r3 = r2.label
                                            int r3 = r3 - r4
                                            r2.label = r3
                                            goto L1d
                                        L18:
                                            kntr.app.digital.preview.CardPreviewPageModel$komponent$lambda$0$$inlined$map$1$2$1 r2 = new kntr.app.digital.preview.CardPreviewPageModel$komponent$lambda$0$$inlined$map$1$2$1
                                            r2.<init>(r1)
                                        L1d:
                                            java.lang.Object r3 = r2.result
                                            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                            int r5 = r2.label
                                            switch(r5) {
                                                case 0: goto L45;
                                                case 1: goto L30;
                                                default: goto L28;
                                            }
                                        L28:
                                            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                                            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                                            r1.<init>(r2)
                                            throw r1
                                        L30:
                                            int r4 = r2.I$0
                                            java.lang.Object r5 = r2.L$3
                                            kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
                                            java.lang.Object r6 = r2.L$2
                                            java.lang.Object r7 = r2.L$1
                                            kntr.app.digital.preview.CardPreviewPageModel$komponent$lambda$0$$inlined$map$1$2$1 r7 = (kntr.app.digital.preview.CardPreviewPageModel$komponent$lambda$0$$inlined$map$1.AnonymousClass2.AnonymousClass1) r7
                                            java.lang.Object r8 = r2.L$0
                                            kotlin.ResultKt.throwOnFailure(r3)
                                            r19 = r3
                                            goto Ld4
                                        L45:
                                            kotlin.ResultKt.throwOnFailure(r3)
                                            kotlinx.coroutines.flow.FlowCollector r5 = r0.$this_unsafeFlow
                                            r7 = r2
                                            r6 = r21
                                            r8 = 0
                                            r9 = r2
                                            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
                                            r10 = r6
                                            kntr.app.digital.preview.PageState r10 = (kntr.app.digital.preview.PageState) r10
                                            r11 = 0
                                            kntr.app.digital.preview.PageState$Initial r12 = kntr.app.digital.preview.PageState.Initial.INSTANCE
                                            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual(r10, r12)
                                            if (r12 == 0) goto L7d
                                            kntr.app.digital.preview.CardPreviewPageModel$komponent$1$content$3$1 r12 = new kntr.app.digital.preview.CardPreviewPageModel$komponent$1$content$3$1
                                            kntr.app.digital.preview.CardPreviewPageModel r14 = r0.this$0
                                            androidx.compose.runtime.MutableState r15 = r0.$animationFinished$delegate$inlined
                                            kntr.common.komponent.KomponentScope r13 = r0.$this_Komponent$inlined
                                            androidx.compose.runtime.MutableState r1 = r0.$pendingPageData$delegate$inlined
                                            r19 = r3
                                            androidx.compose.runtime.MutableState r3 = r0.$state$delegate$inlined
                                            r16 = r13
                                            r13 = r12
                                            r17 = r1
                                            r18 = r3
                                            r13.<init>(r14, r15, r16, r17, r18)
                                            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
                                            kntr.common.komponent.Komponent r1 = kntr.common.komponent.KomponentKt.Komponent(r12)
                                            goto Lac
                                        L7d:
                                            r19 = r3
                                            boolean r1 = r10 instanceof kntr.app.digital.preview.PageState.Ready
                                            if (r1 == 0) goto Ld7
                                            kntr.app.digital.preview.CardPreviewPageModel r1 = r0.this$0
                                            kntr.app.digital.preview.shop.ShopPreviewComponent$Factory r1 = kntr.app.digital.preview.CardPreviewPageModel.access$getShopPreviewComponentFactory$p(r1)
                                            androidx.compose.runtime.MutableState r3 = r0.$state$delegate$inlined
                                            kntr.app.digital.preview.PageState r3 = kntr.app.digital.preview.CardPreviewPageModel.access$komponent$lambda$0$0(r3)
                                            java.lang.String r12 = "null cannot be cast to non-null type kntr.app.digital.preview.PageState.Ready"
                                            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r12)
                                            kntr.app.digital.preview.PageState$Ready r3 = (kntr.app.digital.preview.PageState.Ready) r3
                                            kntr.app.digital.preview.api.CardPreviewModel r3 = r3.getPageData()
                                            kntr.common.komponent.KomponentScope r12 = r0.$this_Komponent$inlined
                                            kotlinx.coroutines.CoroutineScope r12 = r12.getCoroutineScope()
                                            kntr.app.digital.preview.shop.ShopPreviewComponent r1 = r1.create(r3, r12)
                                            kntr.app.digital.preview.shop.ShopPreviewUIService r1 = r1.getPageService()
                                            kntr.common.komponent.Komponent r1 = r1.komponent()
                                        Lac:
                                            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r21)
                                            r2.L$0 = r3
                                            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
                                            r2.L$1 = r3
                                            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
                                            r2.L$2 = r3
                                            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
                                            r2.L$3 = r3
                                            r2.I$0 = r8
                                            r3 = 1
                                            r2.label = r3
                                            java.lang.Object r1 = r5.emit(r1, r2)
                                            if (r1 != r4) goto Ld1
                                            return r4
                                        Ld1:
                                            r4 = r8
                                            r8 = r21
                                        Ld4:
                                            kotlin.Unit r1 = kotlin.Unit.INSTANCE
                                            return r1
                                        Ld7:
                                            kotlin.NoWhenBranchMatchedException r1 = new kotlin.NoWhenBranchMatchedException
                                            r1.<init>()
                                            throw r1
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: kntr.app.digital.preview.CardPreviewPageModel$komponent$lambda$0$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                                    }
                                }
                            };
                            final State content$delegate = KomponentKt.embedFlow((KomponentHostScope) $this$Komponent, it);
                            final Object state$iv$iv = Unit.INSTANCE;
                            UiComposableLike content$iv$iv$iv = new UiComposableLike<S>(state$iv$iv, $this$Komponent, this$0, content$delegate) { // from class: kntr.app.digital.preview.CardPreviewPageModel$komponent$lambda$0$$inlined$setContent$1
                                final /* synthetic */ State $content$delegate$inlined;
                                final /* synthetic */ KomponentScope $this_setContent;
                                private final S state;
                                final /* synthetic */ CardPreviewPageModel this$0;

                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    this.$this_setContent = $this$Komponent;
                                    this.this$0 = this$0;
                                    this.$content$delegate$inlined = content$delegate;
                                    this.state = state$iv$iv;
                                }

                                public void invoke(Modifier modifier, Composer $composer, int $changed) {
                                    DialogService dialogService;
                                    UiComposableLike komponent$lambda$0$10;
                                    Intrinsics.checkNotNullParameter(modifier, "modifier");
                                    $composer.startReplaceGroup(1906618612);
                                    ComposerKt.sourceInformation($composer, "C(invoke)N(modifier)87@2987L17:Komponent.kt#vxw63z");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1906618612, $changed, -1, "kntr.common.komponent.setContent.<no name provided>.invoke (Komponent.kt:86)");
                                    }
                                    int i = $changed & 14;
                                    $composer.startReplaceGroup(-72682194);
                                    ComposerKt.sourceInformation($composer, "CN(it)*209@10335L9,210@10365L43:CardPreviewPageModel.kt#cowxjs");
                                    dialogService = this.this$0.dialogService;
                                    dialogService.Content($composer, 0);
                                    komponent$lambda$0$10 = CardPreviewPageModel.komponent$lambda$0$10(this.$content$delegate$inlined);
                                    komponent$lambda$0$10.invoke(BackgroundKt.background-bw27NRU$default(modifier, Color.Companion.getBlack-0d7_KjU(), (Shape) null, 2, (Object) null), $composer, 0);
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

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final boolean komponent$lambda$0$2(MutableState<Boolean> mutableState) {
                            State $this$getValue$iv = (State) mutableState;
                            return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final void komponent$lambda$0$3(MutableState<Boolean> mutableState, boolean z) {
                            Object value$iv = Boolean.valueOf(z);
                            mutableState.setValue(value$iv);
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final CardPreviewModel komponent$lambda$0$4(MutableState<CardPreviewModel> mutableState) {
                            State $this$getValue$iv = (State) mutableState;
                            return (CardPreviewModel) $this$getValue$iv.getValue();
                        }

                        private static final void komponent$lambda$0$requestCardList(KomponentScope<? super Unit> komponentScope, CardPreviewPageModel this$0, MutableState<Boolean> mutableState, MutableState<PageState> mutableState2, MutableState<CardPreviewModel> mutableState3) {
                            BuildersKt.launch$default(komponentScope.getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new CardPreviewPageModel$komponent$1$requestCardList$1(this$0, mutableState, mutableState2, mutableState3, null), 3, (Object) null);
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final void komponent$lambda$0$InitialContent(final CardPreviewPageModel this$0, MutableState<Boolean> mutableState, KomponentScope<? super Unit> komponentScope, MutableState<CardPreviewModel> mutableState2, MutableState<PageState> mutableState3, Modifier modifier, Composer $composer, int $changed, int i) {
                            Function0 factory$iv$iv$iv;
                            Function0 factory$iv$iv$iv2;
                            Function0 factory$iv$iv$iv3;
                            Object it$iv;
                            Composer $composer$iv$iv$iv;
                            Animatable scale;
                            BoxScope $this$komponent_u24lambda_u240_u24InitialContent_u246_u240_u241;
                            Composer $composer2;
                            Composer $composer$iv;
                            Unit unit;
                            Composer $composer$iv2;
                            Composer $composer$iv3;
                            Composer $composer$iv4;
                            Composer $composer3;
                            Composer $composer$iv5;
                            Composer $composer$iv6;
                            boolean z;
                            int i2;
                            ComposerKt.sourceInformationMarkerStart($composer, -410937709, "C(InitialContent)N(modifier):CardPreviewPageModel.kt#cowxjs");
                            Modifier modifier2 = (i & 1) != 0 ? (Modifier) Modifier.Companion : modifier;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-410937709, $changed, -1, "kntr.app.digital.preview.CardPreviewPageModel.komponent.<anonymous>.InitialContent (CardPreviewPageModel.kt:88)");
                            }
                            if (this$0.simpleCard == null) {
                                $composer.startReplaceGroup(-1588396234);
                                ComposerKt.sourceInformation($composer, "91@3925L24");
                                komponent$lambda$0$3(mutableState, true);
                                BoxKt.Box(modifier2, $composer, $changed & 14);
                                $composer.endReplaceGroup();
                            } else {
                                $composer.startReplaceGroup(-1588107500);
                                ComposerKt.sourceInformation($composer, "93@4003L5323");
                                int $changed$iv = $changed & 14;
                                Modifier modifier$iv = modifier2;
                                ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                                int $changed$iv$iv = ($changed$iv << 3) & 112;
                                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                                CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
                                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
                                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                if (!($composer.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer.startReusableNode();
                                if ($composer.getInserting()) {
                                    factory$iv$iv$iv = factory$iv$iv$iv4;
                                    $composer.createNode(factory$iv$iv$iv);
                                } else {
                                    factory$iv$iv$iv = factory$iv$iv$iv4;
                                    $composer.useNode();
                                }
                                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                                int i3 = ($changed$iv$iv$iv >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                                int i4 = (($changed$iv >> 6) & 112) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer, -1736255211, "C95@4096L46,94@4047L386,103@4463L4837:CardPreviewPageModel.kt#cowxjs");
                                ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_top_highlight(Res.drawable.INSTANCE), $composer, 0), (String) null, SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(222)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer, Painter.$stable | 432, 120);
                                Modifier modifier$iv2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
                                ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                                MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                                int $changed$iv$iv2 = (390 << 3) & 112;
                                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                                CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
                                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
                                Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
                                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                if (!($composer.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer.startReusableNode();
                                if ($composer.getInserting()) {
                                    factory$iv$iv$iv2 = factory$iv$iv$iv5;
                                    $composer.createNode(factory$iv$iv$iv2);
                                } else {
                                    factory$iv$iv$iv2 = factory$iv$iv$iv5;
                                    $composer.useNode();
                                }
                                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                                int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                                int i6 = ((390 >> 6) & 112) | 6;
                                ColumnScope $this$komponent_u24lambda_u240_u24InitialContent_u246_u240 = ColumnScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart($composer, -950138699, "C109@4763L41,111@4890L58,110@4837L568,122@5546L711,120@5438L3832:CardPreviewPageModel.kt#cowxjs");
                                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(44)), $composer, 6);
                                ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_dlc_draw_card_result_back(Res.drawable.INSTANCE), $composer, 0), (String) null, ClickableKt.clickable-oSLSa3U$default(PaddingKt.padding-3ABfNKs(SizeKt.size-3ABfNKs($this$komponent_u24lambda_u240_u24InitialContent_u246_u240.align(Modifier.Companion, Alignment.Companion.getStart()), Dp.constructor-impl(44)), Dp.constructor-impl(11)), false, (String) null, (Role) null, (MutableInteractionSource) null, LocalOnFinishKt.getFinishHost((KomponentLocalAccessScope) komponentScope), 15, (Object) null), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer, Painter.$stable | 48, 120);
                                Modifier modifier3 = Modifier.Companion;
                                ComposerKt.sourceInformationMarkerStart($composer, 1631939610, "CC(remember):CardPreviewPageModel.kt#9igjgp");
                                Object it$iv2 = $composer.rememberedValue();
                                if (it$iv2 == Composer.Companion.getEmpty()) {
                                    Object value$iv = new Function3() { // from class: kntr.app.digital.preview.CardPreviewPageModel$$ExternalSyntheticLambda2
                                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                                            MeasureResult komponent$lambda$0$InitialContent$6$0$0$0;
                                            komponent$lambda$0$InitialContent$6$0$0$0 = CardPreviewPageModel.komponent$lambda$0$InitialContent$6$0$0$0((MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                                            return komponent$lambda$0$InitialContent$6$0$0$0;
                                        }
                                    };
                                    $composer.updateRememberedValue(value$iv);
                                    it$iv2 = value$iv;
                                }
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                Modifier modifier$iv3 = LayoutModifierKt.layout(modifier3, (Function3) it$iv2);
                                ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                                Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                                MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                                int $changed$iv$iv3 = (0 << 3) & 112;
                                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                                CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
                                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
                                Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                if (!($composer.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer.startReusableNode();
                                if ($composer.getInserting()) {
                                    factory$iv$iv$iv3 = factory$iv$iv$iv6;
                                    $composer.createNode(factory$iv$iv$iv3);
                                } else {
                                    factory$iv$iv$iv3 = factory$iv$iv$iv6;
                                    $composer.useNode();
                                }
                                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer);
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                                int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                                int i8 = ((0 >> 6) & 112) | 6;
                                BoxScope $this$komponent_u24lambda_u240_u24InitialContent_u246_u240_u2412 = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart($composer, -703969987, "C134@6388L44,133@6331L518,142@6886L363,149@7298L29,151@7386L544,151@7365L565,167@8391L290,175@8959L277,161@7967L1269:CardPreviewPageModel.kt#cowxjs");
                                ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_bottom_base(Res.drawable.INSTANCE), $composer, 0), (String) null, SizeKt.width-3ABfNKs(SizeKt.height-3ABfNKs($this$komponent_u24lambda_u240_u24InitialContent_u246_u240_u2412.align(Modifier.Companion, Alignment.Companion.getBottomCenter()), Dp.constructor-impl(139)), Dp.constructor-impl(291)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer, Painter.$stable | 48, 120);
                                CardInfoUIKt.CardNameUI(this$0.simpleCard.getName(), PaddingKt.padding-qDBjuR0$default($this$komponent_u24lambda_u240_u24InitialContent_u246_u240_u2412.align(Modifier.Companion, Alignment.Companion.getBottomCenter()), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(40), 7, (Object) null), $composer, 0, 0);
                                ComposerKt.sourceInformationMarkerStart($composer, -715417302, "CC(remember):CardPreviewPageModel.kt#9igjgp");
                                Object it$iv3 = $composer.rememberedValue();
                                if (it$iv3 == Composer.Companion.getEmpty()) {
                                    Object Animatable$default = AnimatableKt.Animatable$default(0.5f, 0.0f, 2, (Object) null);
                                    $composer.updateRememberedValue(Animatable$default);
                                    it$iv = Animatable$default;
                                } else {
                                    it$iv = it$iv3;
                                }
                                Animatable scale2 = (Animatable) it$iv;
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                Unit unit2 = Unit.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart($composer, -715413971, "CC(remember):CardPreviewPageModel.kt#9igjgp");
                                boolean invalid$iv = $composer.changedInstance(scale2) | $composer.changed(mutableState) | $composer.changed(mutableState2) | $composer.changed(mutableState3);
                                Object value$iv2 = $composer.rememberedValue();
                                if (invalid$iv || value$iv2 == Composer.Companion.getEmpty()) {
                                    $composer$iv$iv$iv = $composer;
                                    scale = scale2;
                                    $this$komponent_u24lambda_u240_u24InitialContent_u246_u240_u241 = $this$komponent_u24lambda_u240_u24InitialContent_u246_u240_u2412;
                                    $composer2 = $composer;
                                    $composer$iv = $composer;
                                    unit = unit2;
                                    $composer$iv2 = $composer;
                                    $composer$iv3 = $composer;
                                    $composer$iv4 = $composer;
                                    $composer3 = $composer;
                                    $composer$iv5 = $composer;
                                    $composer$iv6 = $composer;
                                    z = false;
                                    i2 = 2;
                                    value$iv2 = new CardPreviewPageModel$komponent$1$InitialContent$1$1$2$1$1(scale2, mutableState, mutableState2, mutableState3, null);
                                    $composer.updateRememberedValue(value$iv2);
                                } else {
                                    unit = unit2;
                                    scale = scale2;
                                    $composer3 = $composer;
                                    $composer$iv2 = $composer;
                                    $composer$iv3 = $composer;
                                    $composer$iv5 = $composer;
                                    $composer$iv6 = $composer;
                                    $this$komponent_u24lambda_u240_u24InitialContent_u246_u240_u241 = $this$komponent_u24lambda_u240_u24InitialContent_u246_u240_u2412;
                                    $composer$iv$iv$iv = $composer;
                                    $composer$iv4 = $composer;
                                    i2 = 2;
                                    z = false;
                                    $composer2 = $composer;
                                    $composer$iv = $composer;
                                }
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                Composer $composer4 = $composer2;
                                EffectsKt.LaunchedEffect(unit, (Function2) value$iv2, $composer4, 6);
                                Modifier aspectRatio$default = AspectRatioKt.aspectRatio$default(SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(58), Dp.constructor-impl(49), Dp.constructor-impl(58), 0.0f, 8, (Object) null), 0.0f, 1, (Object) null), 0.6666667f, z, i2, (Object) null);
                                ComposerKt.sourceInformationMarkerStart($composer4, -715382065, "CC(remember):CardPreviewPageModel.kt#9igjgp");
                                final Animatable scale3 = scale;
                                boolean invalid$iv2 = $composer4.changedInstance(scale3);
                                Object it$iv4 = $composer4.rememberedValue();
                                if (invalid$iv2 || it$iv4 == Composer.Companion.getEmpty()) {
                                    Object value$iv3 = new Function1() { // from class: kntr.app.digital.preview.CardPreviewPageModel$$ExternalSyntheticLambda3
                                        public final Object invoke(Object obj) {
                                            Unit komponent$lambda$0$InitialContent$6$0$1$2$0;
                                            komponent$lambda$0$InitialContent$6$0$1$2$0 = CardPreviewPageModel.komponent$lambda$0$InitialContent$6$0$1$2$0(scale3, (GraphicsLayerScope) obj);
                                            return komponent$lambda$0$InitialContent$6$0$1$2$0;
                                        }
                                    };
                                    $composer4.updateRememberedValue(value$iv3);
                                    it$iv4 = value$iv3;
                                }
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                DigitalItemContainerKt.DigitalCardContainer(this$0.simpleCard.getFrameUrl(), this$0.simpleCard.getBadge(), $this$komponent_u24lambda_u240_u24InitialContent_u246_u240_u241.align(GraphicsLayerModifierKt.graphicsLayer(aspectRatio$default, (Function1) it$iv4), Alignment.Companion.getTopCenter()), this$0.simpleCard.getHasMask(), ComposableLambdaKt.rememberComposableLambda(931280140, true, new Function3() { // from class: kntr.app.digital.preview.CardPreviewPageModel$$ExternalSyntheticLambda4
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        Unit komponent$lambda$0$InitialContent$6$0$1$3;
                                        komponent$lambda$0$InitialContent$6$0$1$3 = CardPreviewPageModel.komponent$lambda$0$InitialContent$6$0$1$3(CardPreviewPageModel.this, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                        return komponent$lambda$0$InitialContent$6$0$1$3;
                                    }
                                }, $composer4, 54), $composer4, 24576, 0);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                                $composer$iv$iv$iv.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                                ComposerKt.sourceInformationMarkerEnd($composer$iv6);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                                $composer$iv3.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                                $composer.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                $composer.endReplaceGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer);
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final MeasureResult komponent$lambda$0$InitialContent$6$0$0$0(MeasureScope $this$layout, Measurable measurable, Constraints constraints) {
                            Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
                            Intrinsics.checkNotNullParameter(measurable, "measurable");
                            int width = Constraints.getMaxWidth-impl(constraints.unbox-impl());
                            int height = MathKt.roundToInt(((width - ($this$layout.toPx-0680j_4(Dp.constructor-impl(58)) * 2)) * 1.5f) + $this$layout.toPx-0680j_4(Dp.constructor-impl(117)) + $this$layout.toPx-0680j_4(Dp.constructor-impl(49)));
                            final Placeable placeable = measurable.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(constraints.unbox-impl(), 0, 0, height, height, 3, (Object) null));
                            return MeasureScope.-CC.layout$default($this$layout, width, height, (Map) null, new Function1() { // from class: kntr.app.digital.preview.CardPreviewPageModel$$ExternalSyntheticLambda1
                                public final Object invoke(Object obj) {
                                    Unit komponent$lambda$0$InitialContent$6$0$0$0$0;
                                    komponent$lambda$0$InitialContent$6$0$0$0$0 = CardPreviewPageModel.komponent$lambda$0$InitialContent$6$0$0$0$0(placeable, (Placeable.PlacementScope) obj);
                                    return komponent$lambda$0$InitialContent$6$0$0$0$0;
                                }
                            }, 4, (Object) null);
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final Unit komponent$lambda$0$InitialContent$6$0$0$0$0(Placeable $placeable, Placeable.PlacementScope $this$layout) {
                            Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
                            Placeable.PlacementScope.place$default($this$layout, $placeable, 0, 0, 0.0f, 4, (Object) null);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final Unit komponent$lambda$0$InitialContent$6$0$1$2$0(Animatable $scale, GraphicsLayerScope $this$graphicsLayer) {
                            Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
                            $this$graphicsLayer.setScaleX(((Number) $scale.getValue()).floatValue());
                            $this$graphicsLayer.setScaleY(((Number) $scale.getValue()).floatValue());
                            $this$graphicsLayer.setTransformOrigin-__ExYCQ(TransformOrigin.Companion.getCenter-SzJe1aQ());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final Unit komponent$lambda$0$InitialContent$6$0$1$3(CardPreviewPageModel this$0, BoxScope $this$DigitalCardContainer, Composer $composer, int $changed) {
                            Intrinsics.checkNotNullParameter($this$DigitalCardContainer, "$this$DigitalCardContainer");
                            ComposerKt.sourceInformation($composer, "C176@9001L197:CardPreviewPageModel.kt#cowxjs");
                            if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
                                $composer.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(931280140, $changed, -1, "kntr.app.digital.preview.CardPreviewPageModel.komponent.<anonymous>.InitialContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CardPreviewPageModel.kt:176)");
                                }
                                ImageModuleKt.ImageUI(this$0.simpleCard.getImage(), SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), null, $composer, 48, 4);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final UiComposableLike<Unit> komponent$lambda$0$10(State<? extends UiComposableLike<Unit>> state) {
                            Object thisObj$iv = state.getValue();
                            return (UiComposableLike) thisObj$iv;
                        }
                    }