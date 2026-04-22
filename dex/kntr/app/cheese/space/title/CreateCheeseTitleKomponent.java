package kntr.app.cheese.space.title;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.ogv.operation3.module.operable.OperableModel;
import com.bilibili.ogv.operation3.module.operable.OperableModelKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.cheese.space.aggregate.UpId;
import kntr.app.cheese.space.api.ClassifiedInfo;
import kntr.app.cheese.space.api.SeasonInfo;
import kntr.app.cheese.space.api.SortModel;
import kntr.app.cheese.space.filter.ClassifiedTypeIndex;
import kntr.app.cheese.space.filter.SortTypeIndex;
import kntr.app.cheese.space.operable.CreateReportableModel;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.komponent.HostConfiguration;
import kntr.common.komponent.Komponent;
import kntr.common.komponent.KomponentKt;
import kntr.common.komponent.KomponentScope;
import kntr.common.komponent.SetContentResult;
import kntr.common.komponent.UiComposableLike;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: CreateCheeseTitleKomponent.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u000eH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkntr/app/cheese/space/title/CreateCheeseTitleKomponent;", RoomRecommendViewModel.EMPTY_CURSOR, "classifiedTypeIndex", "Lkntr/app/cheese/space/filter/ClassifiedTypeIndex;", "sortTypeIndex", "Lkntr/app/cheese/space/filter/SortTypeIndex;", "createReportableModel", "Lkntr/app/cheese/space/operable/CreateReportableModel;", "upId", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lkntr/app/cheese/space/filter/ClassifiedTypeIndex;Lkntr/app/cheese/space/filter/SortTypeIndex;Lkntr/app/cheese/space/operable/CreateReportableModel;J)V", "invoke", "Lkntr/common/komponent/Komponent;", "Lkntr/app/cheese/space/api/SeasonInfo;", "seasonInfo", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreateCheeseTitleKomponent {
    public static final int $stable = 8;
    private final ClassifiedTypeIndex classifiedTypeIndex;
    private final CreateReportableModel createReportableModel;
    private final SortTypeIndex sortTypeIndex;
    private final long upId;

    @Inject
    public CreateCheeseTitleKomponent(ClassifiedTypeIndex classifiedTypeIndex, SortTypeIndex sortTypeIndex, CreateReportableModel createReportableModel, @UpId long upId) {
        Intrinsics.checkNotNullParameter(classifiedTypeIndex, "classifiedTypeIndex");
        Intrinsics.checkNotNullParameter(sortTypeIndex, "sortTypeIndex");
        Intrinsics.checkNotNullParameter(createReportableModel, "createReportableModel");
        this.classifiedTypeIndex = classifiedTypeIndex;
        this.sortTypeIndex = sortTypeIndex;
        this.createReportableModel = createReportableModel;
        this.upId = upId;
    }

    public final Komponent<SeasonInfo> invoke(final SeasonInfo seasonInfo) {
        Intrinsics.checkNotNullParameter(seasonInfo, "seasonInfo");
        return KomponentKt.Komponent(new Function1() { // from class: kntr.app.cheese.space.title.CreateCheeseTitleKomponent$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                SetContentResult invoke$lambda$0;
                invoke$lambda$0 = CreateCheeseTitleKomponent.invoke$lambda$0(SeasonInfo.this, this, (KomponentScope) obj);
                return invoke$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SetContentResult invoke$lambda$0(final SeasonInfo $seasonInfo, final CreateCheeseTitleKomponent this$0, final KomponentScope $this$Komponent) {
        Intrinsics.checkNotNullParameter($this$Komponent, "$this$Komponent");
        Iterable $this$mapIndexed$iv = $seasonInfo.getClassified_info_list();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
        int index$iv$iv = 0;
        for (Object item$iv$iv : $this$mapIndexed$iv) {
            int index$iv$iv2 = index$iv$iv + 1;
            if (index$iv$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ClassifiedInfo item = (ClassifiedInfo) item$iv$iv;
            destination$iv$iv.add(new CreateCheeseTitleKomponent$invoke$1$classifiedTypes$1$1(index$iv$iv, item, this$0));
            index$iv$iv = index$iv$iv2;
        }
        final List classifiedTypes = (List) destination$iv$iv;
        final int sortTypesCount = $seasonInfo.getSort_model_list().size();
        final OperableModel sortClickModel = CreateReportableModel.invoke$default(this$0.createReportableModel, "main.space-pugv.feeds.rank-bnt.click", MapsKt.mapOf(TuplesKt.to(ReportBuildInParam.UP_MID, String.valueOf(this$0.upId))), null, new Function0() { // from class: kntr.app.cheese.space.title.CreateCheeseTitleKomponent$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit invoke$lambda$0$1;
                invoke$lambda$0$1 = CreateCheeseTitleKomponent.invoke$lambda$0$1(sortTypesCount, this$0);
                return invoke$lambda$0$1;
            }
        }, 4, null);
        final LazyListState classifiedTypeListState = new LazyListState(0, 0, 3, (DefaultConstructorMarker) null);
        UiComposableLike content$iv$iv = new UiComposableLike<SeasonInfo>($seasonInfo, $this$Komponent, $seasonInfo, this$0, sortClickModel, classifiedTypes, classifiedTypeListState) { // from class: kntr.app.cheese.space.title.CreateCheeseTitleKomponent$invoke$lambda$0$$inlined$setContent$1
            final /* synthetic */ LazyListState $classifiedTypeListState$inlined;
            final /* synthetic */ List $classifiedTypes$inlined;
            final /* synthetic */ SeasonInfo $seasonInfo$inlined;
            final /* synthetic */ OperableModel $sortClickModel$inlined;
            final /* synthetic */ KomponentScope $this_setContent;
            private final SeasonInfo state;
            final /* synthetic */ CreateCheeseTitleKomponent this$0;

            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$this_setContent = $this$Komponent;
                this.$seasonInfo$inlined = $seasonInfo;
                this.this$0 = this$0;
                this.$sortClickModel$inlined = sortClickModel;
                this.$classifiedTypes$inlined = classifiedTypes;
                this.$classifiedTypeListState$inlined = classifiedTypeListState;
                this.state = $seasonInfo;
            }

            public void invoke(final Modifier modifier, Composer $composer, int $changed) {
                Function0 factory$iv$iv$iv;
                SortTypeIndex sortTypeIndex;
                Composer $composer$iv;
                Composer $composer2;
                Intrinsics.checkNotNullParameter(modifier, "modifier");
                $composer.startReplaceGroup(1906618612);
                ComposerKt.sourceInformation($composer, "C(invoke)N(modifier)87@2987L17:Komponent.kt#vxw63z");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1906618612, $changed, -1, "kntr.common.komponent.setContent.<no name provided>.invoke (Komponent.kt:86)");
                }
                int $changed2 = $changed & 14;
                $composer.startReplaceGroup(1426583190);
                ComposerKt.sourceInformation($composer, "CN(modifier)*62@2863L6,61@2775L2869:CreateCheeseTitleKomponent.kt#xnzfar");
                Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
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
                int i = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                int i2 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 487094443, "C64@2924L548:CreateCheeseTitleKomponent.kt#xnzfar");
                String title = this.$seasonInfo$inlined.getTitle();
                int season_count = this.$seasonInfo$inlined.getSeason_count();
                List<SortModel> sort_model_list = this.$seasonInfo$inlined.getSort_model_list();
                sortTypeIndex = this.this$0.sortTypeIndex;
                CheeseTitleUiKt.SectionHeader(title, season_count, (SortModel) CollectionsKt.getOrNull(sort_model_list, sortTypeIndex.getValue()), this.$sortClickModel$inlined, PaddingKt.padding-qDBjuR0(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(12), Dp.constructor-impl(12), Dp.constructor-impl(4)), $composer, 0, 0);
                if (this.$classifiedTypes$inlined.isEmpty()) {
                    $composer$iv = $composer;
                    $composer2 = $composer;
                    $composer2.startReplaceGroup(484109204);
                    $composer2.endReplaceGroup();
                } else {
                    $composer.startReplaceGroup(487677769);
                    ComposerKt.sourceInformation($composer, "75@3601L1995,75@3561L2035");
                    final CreateCheeseTitleKomponent createCheeseTitleKomponent = this.this$0;
                    final LazyListState lazyListState = this.$classifiedTypeListState$inlined;
                    final List list = this.$classifiedTypes$inlined;
                    $composer$iv = $composer;
                    BoxWithConstraintsKt.BoxWithConstraints(modifier, (Alignment) null, false, ComposableLambdaKt.rememberComposableLambda(-559712321, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: kntr.app.cheese.space.title.CreateCheeseTitleKomponent$invoke$1$1$1$1
                        public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
                            invoke((BoxWithConstraintsScope) p1, (Composer) p2, ((Number) p3).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(BoxWithConstraintsScope $this$BoxWithConstraints, Composer $composer3, int $changed3) {
                            ClassifiedTypeIndex classifiedTypeIndex;
                            Intrinsics.checkNotNullParameter($this$BoxWithConstraints, "$this$BoxWithConstraints");
                            ComposerKt.sourceInformation($composer3, "C76@3662L7,79@3925L290,79@3883L332,96@4902L664,85@4248L1318:CreateCheeseTitleKomponent.kt#xnzfar");
                            int $dirty = $changed3;
                            if (($changed3 & 6) == 0) {
                                $dirty |= $composer3.changed($this$BoxWithConstraints) ? 4 : 2;
                            }
                            int $dirty2 = $dirty;
                            if ($composer3.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-559712321, $dirty2, -1, "kntr.app.cheese.space.title.CreateCheeseTitleKomponent.invoke.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CreateCheeseTitleKomponent.kt:76)");
                                }
                                CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object consume = $composer3.consume(this_$iv);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                Density density = (Density) consume;
                                int scrollOffset = -((int) density.toPx-0680j_4(Dp.constructor-impl(Dp.constructor-impl($this$BoxWithConstraints.getMaxWidth-D9Ej5fM() / 2) - Dp.constructor-impl(36))));
                                classifiedTypeIndex = CreateCheeseTitleKomponent.this.classifiedTypeIndex;
                                Integer valueOf = Integer.valueOf(classifiedTypeIndex.getValue());
                                ComposerKt.sourceInformationMarkerStart($composer3, -1012617823, "CC(remember):CreateCheeseTitleKomponent.kt#9igjgp");
                                boolean invalid$iv = $composer3.changed(lazyListState) | $composer3.changedInstance(CreateCheeseTitleKomponent.this) | $composer3.changed(scrollOffset);
                                LazyListState lazyListState2 = lazyListState;
                                CreateCheeseTitleKomponent createCheeseTitleKomponent2 = CreateCheeseTitleKomponent.this;
                                Object it$iv = $composer3.rememberedValue();
                                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                                    Object value$iv = (Function2) new CreateCheeseTitleKomponent$invoke$1$1$1$1$1$1(lazyListState2, createCheeseTitleKomponent2, scrollOffset, null);
                                    $composer3.updateRememberedValue(value$iv);
                                    it$iv = value$iv;
                                }
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv, $composer3, 0);
                                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                                PaddingValues paddingValues = PaddingKt.PaddingValues-a9UjIt4(Dp.constructor-impl(12), Dp.constructor-impl(6), Dp.constructor-impl(12), Dp.constructor-impl(8));
                                Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
                                LazyListState lazyListState3 = lazyListState;
                                Arrangement.Horizontal horizontal2 = horizontal;
                                ComposerKt.sourceInformationMarkerStart($composer3, -1012586185, "CC(remember):CreateCheeseTitleKomponent.kt#9igjgp");
                                boolean invalid$iv2 = $composer3.changedInstance(list) | $composer3.changed(modifier);
                                final List<CreateCheeseTitleKomponent$invoke$1$classifiedTypes$1$1> list2 = list;
                                final Modifier modifier2 = modifier;
                                Object it$iv2 = $composer3.rememberedValue();
                                if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                                    Object value$iv2 = (Function1) new Function1<LazyListScope, Unit>() { // from class: kntr.app.cheese.space.title.CreateCheeseTitleKomponent$invoke$1$1$1$1$2$1
                                        public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                                            invoke((LazyListScope) p1);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyListScope $this$LazyRow) {
                                            Intrinsics.checkNotNullParameter($this$LazyRow, "$this$LazyRow");
                                            final List items$iv = list2;
                                            final Modifier modifier3 = modifier2;
                                            $this$LazyRow.items(items$iv.size(), (Function1) null, new Function1<Integer, Object>() { // from class: kntr.app.cheese.space.title.CreateCheeseTitleKomponent$invoke$1$1$1$1$2$1$invoke$$inlined$itemsIndexed$default$2
                                                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                                                    return invoke(((Number) p1).intValue());
                                                }

                                                public final Object invoke(int index) {
                                                    items$iv.get(index);
                                                    return null;
                                                }
                                            }, ComposableLambdaKt.composableLambdaInstance(2039820996, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: kntr.app.cheese.space.title.CreateCheeseTitleKomponent$invoke$1$1$1$1$2$1$invoke$$inlined$itemsIndexed$default$3
                                                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                                                    invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(LazyItemScope $this$items, int it, Composer $composer4, int $changed4) {
                                                    ComposerKt.sourceInformation($composer4, "CN(it)214@10668L26:LazyDsl.kt#428nma");
                                                    int $dirty3 = $changed4;
                                                    if (($changed4 & 6) == 0) {
                                                        $dirty3 |= $composer4.changed($this$items) ? 4 : 2;
                                                    }
                                                    if (($changed4 & 48) == 0) {
                                                        $dirty3 |= $composer4.changed(it) ? 32 : 16;
                                                    }
                                                    if (!$composer4.shouldExecute(($dirty3 & 147) != 146, $dirty3 & 1)) {
                                                        $composer4.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(2039820996, $dirty3, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                                                    }
                                                    int i3 = ($dirty3 & 14) | ($dirty3 & 112);
                                                    CreateCheeseTitleKomponent$invoke$1$classifiedTypes$1$1 item2 = (CreateCheeseTitleKomponent$invoke$1$classifiedTypes$1$1) items$iv.get(it);
                                                    $composer4.startReplaceGroup(1751874889);
                                                    ComposerKt.sourceInformation($composer4, "CN(item)*98@5023L471:CreateCheeseTitleKomponent.kt#xnzfar");
                                                    CheeseTitleUiKt.ClassifiedTypeItem(item2.getData().getName(), item2.getSelected(), OperableModelKt.applyOperableModel(SizeKt.sizeIn-qDBjuR0$default(modifier3, 0.0f, 0.0f, Dp.constructor-impl(200), 0.0f, 11, (Object) null), item2.getClassifiedClickModel()), $composer4, 0, 0);
                                                    $composer4.endReplaceGroup();
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }));
                                        }
                                    };
                                    $composer3.updateRememberedValue(value$iv2);
                                    it$iv2 = value$iv2;
                                }
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                LazyDslKt.LazyRow(fillMaxWidth$default, lazyListState3, paddingValues, false, horizontal2, (Alignment.Vertical) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv2, $composer3, 24582, 488);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer3.skipToGroupEnd();
                        }
                    }, $composer, 54), $composer, ($changed2 & 14) | 3072, 6);
                    $composer.endReplaceGroup();
                    $composer2 = $composer;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
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

            public SeasonInfo getState() {
                return this.state;
            }

            public HostConfiguration getPreferredHostConfiguration() {
                return this.$this_setContent.getPreferredHostConfiguration();
            }
        };
        return $this$Komponent.__setContent(content$iv$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$0$1(int $sortTypesCount, CreateCheeseTitleKomponent this$0) {
        if ($sortTypesCount > 0) {
            int nextIndex = this$0.sortTypeIndex.getValue() + 1;
            this$0.sortTypeIndex.setValue(nextIndex % $sortTypesCount);
        }
        return Unit.INSTANCE;
    }
}