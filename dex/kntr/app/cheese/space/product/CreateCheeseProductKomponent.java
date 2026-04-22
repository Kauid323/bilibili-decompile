package kntr.app.cheese.space.product;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.bilibili.ogv.operation3.module.operable.OperableModel;
import com.bilibili.ogv.operation3.module.operable.OperableModelKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.cheese.space.aggregate.UpId;
import kntr.app.cheese.space.api.ProductInfo;
import kntr.app.cheese.space.api.ProductModel;
import kntr.app.cheese.space.operable.CreateOperableModel;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.router.Router;
import kntr.common.compose.launcher.KomponentRouterKt;
import kntr.common.komponent.HostConfiguration;
import kntr.common.komponent.Komponent;
import kntr.common.komponent.KomponentKt;
import kntr.common.komponent.KomponentScope;
import kntr.common.komponent.SetContentResult;
import kntr.common.komponent.UiComposableLike;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: CreateCheeseProductKomponent.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkntr/app/cheese/space/product/CreateCheeseProductKomponent;", RoomRecommendViewModel.EMPTY_CURSOR, "createOperableModel", "Lkntr/app/cheese/space/operable/CreateOperableModel;", "upId", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lkntr/app/cheese/space/operable/CreateOperableModel;J)V", "invoke", "Lkntr/common/komponent/Komponent;", "item", "Lkntr/app/cheese/space/api/ProductInfo;", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreateCheeseProductKomponent {
    public static final int $stable = 8;
    private final CreateOperableModel createOperableModel;
    private final long upId;

    @Inject
    public CreateCheeseProductKomponent(CreateOperableModel createOperableModel, @UpId long upId) {
        Intrinsics.checkNotNullParameter(createOperableModel, "createOperableModel");
        this.createOperableModel = createOperableModel;
        this.upId = upId;
    }

    public final Komponent<Object> invoke(final ProductInfo item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return KomponentKt.Komponent(new Function1() { // from class: kntr.app.cheese.space.product.CreateCheeseProductKomponent$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                SetContentResult invoke$lambda$0;
                invoke$lambda$0 = CreateCheeseProductKomponent.invoke$lambda$0(ProductInfo.this, this, (KomponentScope) obj);
                return invoke$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SetContentResult invoke$lambda$0(final ProductInfo $item, CreateCheeseProductKomponent this$0, final KomponentScope $this$Komponent) {
        Intrinsics.checkNotNullParameter($this$Komponent, "$this$Komponent");
        $item.getReport().put(ReportBuildInParam.UP_MID, String.valueOf(this$0.upId));
        final OperableModel operableModel = CreateOperableModel.invoke$default(this$0.createOperableModel, (Router) $this$Komponent.getCurrent(KomponentRouterKt.getLocalRouter()), $item, null, 4, null);
        Iterable $this$mapIndexed$iv = $item.getProduct_model_list();
        boolean z = false;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
        Iterable $this$mapIndexedTo$iv$iv = $this$mapIndexed$iv;
        boolean z2 = false;
        int index$iv$iv = 0;
        for (Object item$iv$iv : $this$mapIndexedTo$iv$iv) {
            int index$iv$iv2 = index$iv$iv + 1;
            if (index$iv$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ProductModel card = (ProductModel) item$iv$iv;
            Iterable $this$mapIndexed$iv2 = $this$mapIndexed$iv;
            boolean z3 = z;
            card.getReport().put("index", String.valueOf(index$iv$iv + 1));
            card.getReport().put(ReportBuildInParam.UP_MID, String.valueOf(this$0.upId));
            destination$iv$iv.add(new CreateCheeseProductKomponent$invoke$1$products$1$1(card, this$0, $this$Komponent));
            $this$mapIndexedTo$iv$iv = $this$mapIndexedTo$iv$iv;
            index$iv$iv = index$iv$iv2;
            z2 = z2;
            z = z3;
            $this$mapIndexed$iv = $this$mapIndexed$iv2;
        }
        final List products = (List) destination$iv$iv;
        if (!products.isEmpty()) {
            UiComposableLike content$iv$iv = new UiComposableLike<ProductInfo>($item, $this$Komponent, operableModel, $item, products) { // from class: kntr.app.cheese.space.product.CreateCheeseProductKomponent$invoke$lambda$0$$inlined$setContent$2
                final /* synthetic */ ProductInfo $item$inlined;
                final /* synthetic */ OperableModel $operableModel$inlined;
                final /* synthetic */ List $products$inlined;
                final /* synthetic */ KomponentScope $this_setContent;
                private final ProductInfo state;

                /* JADX WARN: Multi-variable type inference failed */
                {
                    this.$this_setContent = $this$Komponent;
                    this.$operableModel$inlined = operableModel;
                    this.$item$inlined = $item;
                    this.$products$inlined = products;
                    this.state = $item;
                }

                public void invoke(Modifier modifier, Composer $composer, int $changed) {
                    Function0 factory$iv$iv$iv;
                    Intrinsics.checkNotNullParameter(modifier, "modifier");
                    $composer.startReplaceGroup(1906618612);
                    ComposerKt.sourceInformation($composer, "C(invoke)N(modifier)87@2987L17:Komponent.kt#vxw63z");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1906618612, $changed, -1, "kntr.common.komponent.setContent.<no name provided>.invoke (Komponent.kt:86)");
                    }
                    int i = $changed & 14;
                    $composer.startReplaceGroup(270296622);
                    ComposerKt.sourceInformation($composer, "CN(modifier)*38@1573L2612:CreateCheeseProductKomponent.kt#kcnsom");
                    Modifier modifier$iv = OperableModelKt.applyOperableModel(modifier, this.$operableModel$inlined);
                    ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                    MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    int $changed$iv$iv = (0 << 3) & 112;
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
                    ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                    int i3 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, 2112501694, "C43@1769L444:CreateCheeseProductKomponent.kt#kcnsom");
                    CheeseProductUiKt.SectionHeader(this.$item$inlined.getTitle(), this.$item$inlined.getJump_model().getJump_text(), this.$item$inlined.getProduct_count(), PaddingKt.padding-qDBjuR0(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(12), Dp.constructor-impl(12), Dp.constructor-impl(2)), $composer, 0, 0);
                    if (this.$products$inlined.size() < 3) {
                        $composer.startReplaceGroup(2112933337);
                        ComposerKt.sourceInformation($composer, "54@2364L445");
                        CreateCheeseProductKomponent$invoke$1$products$1$1 singleProduct = (CreateCheeseProductKomponent$invoke$1$products$1$1) CollectionsKt.first(this.$products$inlined);
                        CheeseProductUiKt.ProductSingleItemUi(singleProduct.getData(), OperableModelKt.applyOperableModel(PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(4)), singleProduct.getOperableModel()), $composer, 0, 0);
                        $composer.endReplaceGroup();
                    } else {
                        $composer.startReplaceGroup(2113531885);
                        ComposerKt.sourceInformation($composer, "64@2890L1247,64@2871L1266");
                        final List list = this.$products$inlined;
                        BoxWithConstraintsKt.BoxWithConstraints((Modifier) null, (Alignment) null, false, ComposableLambdaKt.rememberComposableLambda(1187656657, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: kntr.app.cheese.space.product.CreateCheeseProductKomponent$invoke$1$2$1$1
                            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
                                invoke((BoxWithConstraintsScope) p1, (Composer) p2, ((Number) p3).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(BoxWithConstraintsScope $this$BoxWithConstraints, Composer $composer2, int $changed2) {
                                Function0 factory$iv$iv$iv3;
                                Intrinsics.checkNotNullParameter($this$BoxWithConstraints, "$this$BoxWithConstraints");
                                ComposerKt.sourceInformation($composer2, "C66@3000L1107:CreateCheeseProductKomponent.kt#kcnsom");
                                int $dirty = $changed2;
                                if (($changed2 & 6) == 0) {
                                    $dirty |= $composer2.changed($this$BoxWithConstraints) ? 4 : 2;
                                }
                                if (!$composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
                                    $composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1187656657, $dirty, -1, "kntr.app.cheese.space.product.CreateCheeseProductKomponent.invoke.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CreateCheeseProductKomponent.kt:65)");
                                }
                                float itemWidth = Dp.constructor-impl(Dp.constructor-impl($this$BoxWithConstraints.getMaxWidth-D9Ej5fM() - Dp.constructor-impl(45)) / 3);
                                Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float) 10.5d));
                                Modifier modifier$iv2 = IntrinsicKt.height(PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(4)), IntrinsicSize.Max);
                                Arrangement.Horizontal horizontalArrangement$iv = horizontal;
                                List<CreateCheeseProductKomponent$invoke$1$products$1$1> list2 = list;
                                ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
                                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                                int $changed$iv$iv2 = (54 << 3) & 112;
                                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                                CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
                                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
                                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                if (!($composer2.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer2.startReusableNode();
                                if ($composer2.getInserting()) {
                                    factory$iv$iv$iv3 = factory$iv$iv$iv4;
                                    $composer2.createNode(factory$iv$iv$iv3);
                                } else {
                                    factory$iv$iv$iv3 = factory$iv$iv$iv4;
                                    $composer2.useNode();
                                }
                                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                                int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
                                boolean z4 = false;
                                ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                                RowScope rowScope = RowScopeInstance.INSTANCE;
                                int i5 = ((54 >> 6) & 112) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer2, -528114101, "C:CreateCheeseProductKomponent.kt#kcnsom");
                                $composer2.startReplaceGroup(-1263961401);
                                ComposerKt.sourceInformation($composer2, "*75@3564L471");
                                Iterable $this$forEach$iv = CollectionsKt.take(list2, 3);
                                boolean z5 = false;
                                for (Object element$iv : $this$forEach$iv) {
                                    CreateCheeseProductKomponent$invoke$1$products$1$1 product = (CreateCheeseProductKomponent$invoke$1$products$1$1) element$iv;
                                    CheeseProductUiKt.ProductItemUi(product.getData(), OperableModelKt.applyOperableModel(SizeKt.fillMaxHeight$default(SizeKt.width-3ABfNKs(Modifier.Companion, itemWidth), 0.0f, 1, (Object) null), product.getOperableModel()), $composer2, 0, 0);
                                    z4 = z4;
                                    compositeKeyHash$iv$iv2 = compositeKeyHash$iv$iv2;
                                    $this$forEach$iv = $this$forEach$iv;
                                    itemWidth = itemWidth;
                                    z5 = z5;
                                }
                                $composer2.endReplaceGroup();
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                $composer2.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer, 54), $composer, 3072, 7);
                        $composer.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
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

                public ProductInfo getState() {
                    return this.state;
                }

                public HostConfiguration getPreferredHostConfiguration() {
                    return this.$this_setContent.getPreferredHostConfiguration();
                }
            };
            return $this$Komponent.__setContent(content$iv$iv);
        }
        final Object state$iv$iv = Unit.INSTANCE;
        UiComposableLike content$iv$iv$iv = new UiComposableLike<S>(state$iv$iv, $this$Komponent) { // from class: kntr.app.cheese.space.product.CreateCheeseProductKomponent$invoke$lambda$0$$inlined$setContent$1
            final /* synthetic */ KomponentScope $this_setContent;
            private final S state;

            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$this_setContent = $this$Komponent;
                this.state = state$iv$iv;
            }

            public void invoke(Modifier modifier, Composer $composer, int $changed) {
                Intrinsics.checkNotNullParameter(modifier, "modifier");
                $composer.startReplaceGroup(1906618612);
                ComposerKt.sourceInformation($composer, "C(invoke)N(modifier)87@2987L17:Komponent.kt#vxw63z");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1906618612, $changed, -1, "kntr.common.komponent.setContent.<no name provided>.invoke (Komponent.kt:86)");
                }
                $composer.startReplaceGroup(-1095045518);
                ComposerKt.sourceInformation($composer, "CN(it)*35@1475L10:CreateCheeseProductKomponent.kt#kcnsom");
                SpacerKt.Spacer(modifier, $composer, $changed & 14 & 14);
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
}