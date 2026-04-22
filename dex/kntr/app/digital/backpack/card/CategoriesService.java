package kntr.app.digital.backpack.card;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BasicMarqueeKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.MarqueeSpacing;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.foundation.lazy.grid.GridItemSpan;
import androidx.compose.foundation.lazy.grid.LazyGridDslKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.foundation.lazy.grid.LazyGridSpanKt;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.lib.brouter.uri.Builder;
import java.util.List;
import javax.inject.Inject;
import kntr.app.digital.backpack.di.ActivityId;
import kntr.app.digital.backpack.di.BusinessScope;
import kntr.app.digital.backpack.di.From;
import kntr.app.digital.backpack.di.FromSource;
import kntr.app.digital.backpack.di.VMid;
import kntr.app.digital.backpack.lottery.LotterySelectedService;
import kntr.app.digital.backpack.pager.CategoryModel;
import kntr.app.digital.backpack.tab.TabsService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.Pixel;
import kntr.base.router.Router;
import kntr.common.router.UrisKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonObjectBuilder;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.app.digital.backpack.generated.resources.Drawable0_commonMainKt;
import srcs.app.digital.backpack.generated.resources.Res;

/* compiled from: CategoriesService.kt */
@BusinessScope
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001BI\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010\u001aJ%\u0010\u001b\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010\u0018J\u001f\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lkntr/app/digital/backpack/card/CategoriesService;", RoomRecommendViewModel.EMPTY_CURSOR, "router", "Lkntr/base/router/Router;", "actId", RoomRecommendViewModel.EMPTY_CURSOR, "vmid", RoomRecommendViewModel.EMPTY_CURSOR, "from", RoomRecommendViewModel.EMPTY_CURSOR, "fromSource", "tabsService", "Lkntr/app/digital/backpack/tab/TabsService;", "lotterySelectedService", "Lkntr/app/digital/backpack/lottery/LotterySelectedService;", "<init>", "(Lkntr/base/router/Router;IJLjava/lang/String;Ljava/lang/String;Lkntr/app/digital/backpack/tab/TabsService;Lkntr/app/digital/backpack/lottery/LotterySelectedService;)V", "Content", RoomRecommendViewModel.EMPTY_CURSOR, "categories", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/digital/backpack/pager/CategoryModel;", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/util/List;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "EmptyContent", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "CategoriesContent", "CardUI", "card", "Lkntr/app/digital/backpack/card/CardModel;", "(Lkntr/app/digital/backpack/card/CardModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CategoriesService {
    public static final int $stable = 8;
    private final int actId;
    private final String from;
    private final String fromSource;
    private final LotterySelectedService lotterySelectedService;
    private final Router router;
    private final TabsService tabsService;
    private final long vmid;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CardUI$lambda$1(CategoriesService categoriesService, CardModel cardModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        categoriesService.CardUI(cardModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CategoriesContent$lambda$1(CategoriesService categoriesService, List list, Modifier modifier, int i, int i2, Composer composer, int i3) {
        categoriesService.CategoriesContent(list, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$0(CategoriesService categoriesService, List list, Modifier modifier, int i, int i2, Composer composer, int i3) {
        categoriesService.Content(list, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EmptyContent$lambda$1(CategoriesService categoriesService, Modifier modifier, int i, int i2, Composer composer, int i3) {
        categoriesService.EmptyContent(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    @Inject
    public CategoriesService(Router router, @ActivityId int actId, @VMid long vmid, @From String from, @FromSource String fromSource, TabsService tabsService, LotterySelectedService lotterySelectedService) {
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(fromSource, "fromSource");
        Intrinsics.checkNotNullParameter(tabsService, "tabsService");
        Intrinsics.checkNotNullParameter(lotterySelectedService, "lotterySelectedService");
        this.router = router;
        this.actId = actId;
        this.vmid = vmid;
        this.from = from;
        this.fromSource = fromSource;
        this.tabsService = tabsService;
        this.lotterySelectedService = lotterySelectedService;
    }

    public final void Content(final List<CategoryModel> list, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Intrinsics.checkNotNullParameter(list, "categories");
        Composer $composer2 = $composer.startRestartGroup(1401413348);
        ComposerKt.sourceInformation($composer2, "C(Content)N(categories,modifier):CategoriesService.kt#7m94um");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(this) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1401413348, $dirty2, -1, "kntr.app.digital.backpack.card.CategoriesService.Content (CategoriesService.kt:75)");
            }
            if (list.isEmpty()) {
                $composer2.startReplaceGroup(-1871882339);
                ComposerKt.sourceInformation($composer2, "77@3344L33");
                EmptyContent(modifier, $composer2, (($dirty2 >> 3) & 14) | (($dirty2 >> 3) & 112), 0);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(-1871811380);
                ComposerKt.sourceInformation($composer2, "79@3415L50");
                CategoriesContent(list, modifier, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896), 0);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier2 = modifier;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.backpack.card.CategoriesService$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$0;
                    Content$lambda$0 = CategoriesService.Content$lambda$0(CategoriesService.this, list, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$0;
                }
            });
        }
    }

    public final void EmptyContent(Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer3 = $composer.startRestartGroup(1134296353);
        ComposerKt.sourceInformation($composer3, "C(EmptyContent)N(modifier)85@3581L667:CategoriesService.kt#7m94um");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (!$composer3.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1134296353, $dirty, -1, "kntr.app.digital.backpack.card.CategoriesService.EmptyContent (CategoriesService.kt:84)");
            }
            Alignment contentAlignment$iv = Alignment.Companion.getTopCenter();
            int $changed$iv = ($dirty & 14) | 48;
            Modifier modifier$iv = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier modifier4 = modifier3;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i4 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1949232879, "C89@3711L523:CategoriesService.kt#7m94um");
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            Modifier modifier$iv2 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(200), 0.0f, 0.0f, 13, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv2 = (390 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            $composer2 = $composer3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i6 = ((390 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1689962756, "C94@3935L50,93@3894L221,99@4170L6,99@4202L9,99@4137L79:CategoriesService.kt#7m94um");
            ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getImage_page_empty_140(Res.drawable.INSTANCE), $composer3, 0), RoomRecommendViewModel.EMPTY_CURSOR, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(140)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer3, Painter.$stable | 432, 120);
            TextKt.Text-Nvy7gAk("暂无卡牌哦～", (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14(), $composer3, 6, 0, 131066);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.backpack.card.CategoriesService$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit EmptyContent$lambda$1;
                    EmptyContent$lambda$1 = CategoriesService.EmptyContent$lambda$1(CategoriesService.this, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return EmptyContent$lambda$1;
                }
            });
        }
    }

    public final void CategoriesContent(final List<CategoryModel> list, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(list, "categories");
        Composer $composer2 = $composer.startRestartGroup(442226344);
        ComposerKt.sourceInformation($composer2, "C(CategoriesContent)N(categories,modifier)115@4779L1189,109@4423L1545:CategoriesService.kt#7m94um");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(this) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(442226344, $dirty2, -1, "kntr.app.digital.backpack.card.CategoriesService.CategoriesContent (CategoriesService.kt:108)");
            }
            GridCells fixed = new GridCells.Fixed(3);
            PaddingValues paddingValues = PaddingKt.PaddingValues-a9UjIt4(Dp.constructor-impl(16), Dp.constructor-impl(12), Dp.constructor-impl(16), Dp.constructor-impl(52));
            Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(15));
            Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(10));
            ComposerKt.sourceInformationMarkerStart($composer2, -222228819, "CC(remember):CategoriesService.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(list) | $composer2.changedInstance(this);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.app.digital.backpack.card.CategoriesService$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj) {
                        Unit CategoriesContent$lambda$0$0;
                        CategoriesContent$lambda$0$0 = CategoriesService.CategoriesContent$lambda$0$0(list, this, (LazyGridScope) obj);
                        return CategoriesContent$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LazyGridDslKt.LazyVerticalGrid(fixed, modifier4, (LazyGridState) null, paddingValues, false, vertical, horizontal, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv, $composer2, ($dirty2 & 112) | 1769472, 0, 916);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.backpack.card.CategoriesService$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit CategoriesContent$lambda$1;
                    CategoriesContent$lambda$1 = CategoriesService.CategoriesContent$lambda$1(CategoriesService.this, list, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CategoriesContent$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CategoriesContent$lambda$0$0(List $categories, final CategoriesService this$0, LazyGridScope $this$LazyVerticalGrid) {
        Intrinsics.checkNotNullParameter($this$LazyVerticalGrid, "$this$LazyVerticalGrid");
        List $this$forEachIndexed$iv = $categories;
        int index$iv = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv2 = index$iv + 1;
            if (index$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            final CategoryModel category = (CategoryModel) item$iv;
            int index = index$iv;
            Iterable $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
            LazyGridScope.-CC.item$default($this$LazyVerticalGrid, (Object) null, new Function1() { // from class: kntr.app.digital.backpack.card.CategoriesService$$ExternalSyntheticLambda7
                public final Object invoke(Object obj) {
                    GridItemSpan CategoriesContent$lambda$0$0$0$0;
                    CategoriesContent$lambda$0$0$0$0 = CategoriesService.CategoriesContent$lambda$0$0$0$0((LazyGridItemSpanScope) obj);
                    return CategoriesContent$lambda$0$0$0$0;
                }
            }, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1013598192, true, new Function3() { // from class: kntr.app.digital.backpack.card.CategoriesService$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit CategoriesContent$lambda$0$0$0$1;
                    CategoriesContent$lambda$0$0$0$1 = CategoriesService.CategoriesContent$lambda$0$0$0$1(CategoryModel.this, (LazyGridItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return CategoriesContent$lambda$0$0$0$1;
                }
            }), 5, (Object) null);
            final List items$iv = category.getCards();
            final Function1 contentType$iv = new Function1() { // from class: kntr.app.digital.backpack.card.CategoriesService$CategoriesContent$lambda$0$0$0$$inlined$items$default$1
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    return m831invoke((CardModel) p1);
                }

                /* renamed from: invoke  reason: collision with other method in class */
                public final Void m831invoke(CardModel cardModel) {
                    return null;
                }
            };
            $this$LazyVerticalGrid.items(items$iv.size(), (Function1) null, (Function2) null, new Function1<Integer, Object>() { // from class: kntr.app.digital.backpack.card.CategoriesService$CategoriesContent$lambda$0$0$0$$inlined$items$default$4
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    return invoke(((Number) p1).intValue());
                }

                public final Object invoke(int index2) {
                    return contentType$iv.invoke(items$iv.get(index2));
                }
            }, ComposableLambdaKt.composableLambdaInstance(-1117249557, true, new Function4<LazyGridItemScope, Integer, Composer, Integer, Unit>() { // from class: kntr.app.digital.backpack.card.CategoriesService$CategoriesContent$lambda$0$0$0$$inlined$items$default$5
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                    invoke((LazyGridItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyGridItemScope $this$items, int it, Composer $composer, int $changed) {
                    ComposerKt.sourceInformation($composer, "CN(it)539@23988L22:LazyGridDsl.kt#7791vq");
                    int $dirty = $changed;
                    if (($changed & 6) == 0) {
                        $dirty |= $composer.changed($this$items) ? 4 : 2;
                    }
                    if (($changed & 48) == 0) {
                        $dirty |= $composer.changed(it) ? 32 : 16;
                    }
                    if (!$composer.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
                        $composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1117249557, $dirty, -1, "androidx.compose.foundation.lazy.grid.items.<anonymous> (LazyGridDsl.kt:539)");
                    }
                    CardModel card = (CardModel) items$iv.get(it);
                    $composer.startReplaceGroup(1587362802);
                    ComposerKt.sourceInformation($composer, "CN(card)*126@5256L48:CategoriesService.kt#7m94um");
                    this$0.CardUI(card, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer, ((($dirty & 14) >> 3) & 14) | 48, 0);
                    $composer.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            if ($categories.size() > 2 && index == CollectionsKt.getLastIndex($categories) - 1) {
                LazyGridScope.-CC.item$default($this$LazyVerticalGrid, (Object) null, new Function1() { // from class: kntr.app.digital.backpack.card.CategoriesService$$ExternalSyntheticLambda9
                    public final Object invoke(Object obj) {
                        GridItemSpan CategoriesContent$lambda$0$0$0$3;
                        CategoriesContent$lambda$0$0$0$3 = CategoriesService.CategoriesContent$lambda$0$0$0$3((LazyGridItemSpanScope) obj);
                        return CategoriesContent$lambda$0$0$0$3;
                    }
                }, (Object) null, ComposableSingletons$CategoriesServiceKt.INSTANCE.m834getLambda$1340450901$backpack_debug(), 5, (Object) null);
            }
            index$iv = index$iv2;
            $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GridItemSpan CategoriesContent$lambda$0$0$0$0(LazyGridItemSpanScope $this$item) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        return GridItemSpan.box-impl(LazyGridSpanKt.GridItemSpan(3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CategoriesContent$lambda$0$0$0$1(CategoryModel $category, LazyGridItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C121@5068L9,118@4923L234:CategoriesService.kt#7m94um");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1013598192, $changed, -1, "kntr.app.digital.backpack.card.CategoriesService.CategoriesContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CategoriesService.kt:118)");
            }
            TextKt.Text-Nvy7gAk($category.getTitle(), Modifier.Companion, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT14(), $composer, 432, 0, 131064);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GridItemSpan CategoriesContent$lambda$0$0$0$3(LazyGridItemSpanScope $this$item) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        return GridItemSpan.box-impl(LazyGridSpanKt.GridItemSpan(3));
    }

    public final void CardUI(final CardModel card, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Intrinsics.checkNotNullParameter(card, "card");
        Composer $composer2 = $composer.startRestartGroup(-667585124);
        ComposerKt.sourceInformation($composer2, "C(CardUI)N(card,modifier)150@6156L10279,150@6116L10319:CategoriesService.kt#7m94um");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(card) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(this) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-667585124, $dirty2, -1, "kntr.app.digital.backpack.card.CategoriesService.CardUI (CategoriesService.kt:149)");
            }
            BoxWithConstraintsKt.BoxWithConstraints(modifier, (Alignment) null, false, ComposableLambdaKt.rememberComposableLambda(-938554766, true, new Function3() { // from class: kntr.app.digital.backpack.card.CategoriesService$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit CardUI$lambda$0;
                    CardUI$lambda$0 = CategoriesService.CardUI$lambda$0(CardModel.this, this, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return CardUI$lambda$0;
                }
            }, $composer2, 54), $composer2, (($dirty2 >> 3) & 14) | 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier2 = modifier;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.backpack.card.CategoriesService$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit CardUI$lambda$1;
                    CardUI$lambda$1 = CategoriesService.CardUI$lambda$1(CategoriesService.this, card, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CardUI$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x01d2, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit CardUI$lambda$0(final CardModel $card, final CategoriesService this$0, BoxWithConstraintsScope $this$BoxWithConstraints, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        BoxScope $this$CardUI_u24lambda_u240_u240_u241;
        String str;
        String str2;
        Composer $composer2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Function0 factory$iv$iv$iv5;
        Intrinsics.checkNotNullParameter($this$BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation($composer, "C152@6226L9201:CategoriesService.kt#7m94um");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$BoxWithConstraints) ? 4 : 2;
        }
        if ($composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-938554766, $dirty, -1, "kntr.app.digital.backpack.card.CategoriesService.CardUI.<anonymous> (CategoriesService.kt:151)");
            }
            int maxWidth = Constraints.getMaxWidth-impl($this$BoxWithConstraints.getConstraints-msEJaDk());
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default($this$BoxWithConstraints.align(Modifier.Companion, Alignment.Companion.getBottomStart()), 0.0f, Dp.constructor-impl(5), Dp.constructor-impl(5), 0.0f, 9, (Object) null), 0.0f, 1, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv6;
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
            int i2 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 113138104, "C166@6871L2432,160@6574L6694,289@13560L9,284@13290L372:CategoriesService.kt#7m94um");
            Modifier clip = ClipKt.clip(AspectRatioKt.aspectRatio$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.6666667f, false, 2, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)));
            ComposerKt.sourceInformationMarkerStart($composer, -1243273272, "CC(remember):CategoriesService.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance(this$0) | $composer.changed($card);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function0() { // from class: kntr.app.digital.backpack.card.CategoriesService$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit CardUI$lambda$0$0$0$0;
                    CardUI$lambda$0$0$0$0 = CategoriesService.CardUI$lambda$0$0$0$0(CategoriesService.this, $card);
                    return CardUI$lambda$0$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv2 = ClickableKt.clickable-oSLSa3U$default(clip, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                $composer.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i4 = ((0 >> 6) & 112) | 6;
            BoxScope $this$CardUI_u24lambda_u240_u240_u2412 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 732573312, "C201@9353L195,207@9574L946:CategoriesService.kt#7m94um");
            SpacerKt.Spacer(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.15f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null), $composer, 6);
            ImageRequest contentScale = new ImageRequest($card.getImage()).enableAnimate(true).autoPlay(true).contentScale(ContentScale.Companion.getFit());
            int $this$px$iv = Pixel.constructor-impl(maxWidth);
            BiliImageKt.BiliImage(ImageRequest.noLimitSize-Ic4ZqO0$default(contentScale, $this$px$iv, 0, 2, (Object) null).build(), SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, ComposableSingletons$CategoriesServiceKt.INSTANCE.getLambda$720962461$backpack_debug(), $composer, 100663344, 252);
            if (StringsKt.isBlank($card.getBadge())) {
                $this$CardUI_u24lambda_u240_u240_u241 = $this$CardUI_u24lambda_u240_u240_u2412;
                $composer.startReplaceGroup(723173460);
            } else {
                $composer.startReplaceGroup(733682956);
                ComposerKt.sourceInformation($composer, "228@10604L560");
                String $this$asRequest$iv = $card.getBadge();
                ImageRequest $this$CardUI_u24lambda_u240_u240_u241_u240 = new ImageRequest($this$asRequest$iv);
                $this$CardUI_u24lambda_u240_u240_u241_u240.useOrigin(true);
                $this$CardUI_u24lambda_u240_u240_u241_u240.contentScale(ContentScale.Companion.getFillHeight());
                $this$CardUI_u24lambda_u240_u240_u241 = $this$CardUI_u24lambda_u240_u240_u2412;
                BiliImageKt.BiliImage($this$CardUI_u24lambda_u240_u240_u241_u240.build(), SizeKt.height-3ABfNKs($this$CardUI_u24lambda_u240_u240_u241.align(Modifier.Companion, Alignment.Companion.getTopStart()), Dp.constructor-impl(18)), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, (Function4) null, $composer, 0, 508);
            }
            $composer.endReplaceGroup();
            if ($card.getHasBorder()) {
                $composer.startReplaceGroup(734357082);
                ComposerKt.sourceInformation($composer, "243@11314L46,242@11265L250");
                ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIcon_card_border(Res.drawable.INSTANCE), $composer, 0), RoomRecommendViewModel.EMPTY_CURSOR, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer, Painter.$stable | 432, 120);
            } else {
                $composer.startReplaceGroup(723173460);
            }
            $composer.endReplaceGroup();
            if ($card.getDuration() != null) {
                $composer.startReplaceGroup(734715504);
                ComposerKt.sourceInformation($composer, "250@11624L1228");
                Modifier modifier$iv3 = PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU(SizeKt.wrapContentSize$default(PaddingKt.padding-qDBjuR0$default($this$CardUI_u24lambda_u240_u240_u241.align(Modifier.Companion, Alignment.Companion.getBottomStart()), Dp.constructor-impl(4), 0.0f, 0.0f, Dp.constructor-impl(4), 6, (Object) null), (Alignment) null, false, 3, (Object) null), Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(69))), Dp.constructor-impl(3), Dp.constructor-impl((float) 3.5d));
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                int $changed$iv$iv3 = (384 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
                str2 = "C72@3469L9:Box.kt#2w3rfo";
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
                Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                str4 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                str = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    factory$iv$iv$iv5 = factory$iv$iv$iv8;
                    $composer.createNode(factory$iv$iv$iv5);
                } else {
                    factory$iv$iv$iv5 = factory$iv$iv$iv8;
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer);
                str3 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                $composer2 = $composer;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                int i6 = ((384 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 543621269, "C262@12365L200,269@12774L9,266@12598L224:CategoriesService.kt#7m94um");
                String $this$asRequest_u24default$iv = $card.getDuration().getImageUrl();
                ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
                Unit unit = Unit.INSTANCE;
                BiliImageKt.BiliImage(imageRequest.build(), SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(21)), Dp.constructor-impl(11)), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, (Function4) null, $composer, 48, 508);
                TextKt.Text-Nvy7gAk($card.getDuration().getContent(), (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT10(), $composer, 384, 0, 131066);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
            } else {
                str = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                str2 = "C72@3469L9:Box.kt#2w3rfo";
                $composer2 = $composer;
                str3 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                str4 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                $composer.startReplaceGroup(723173460);
            }
            $composer.endReplaceGroup();
            if ($card.getHasGained()) {
                $composer.startReplaceGroup(723173460);
            } else {
                $composer.startReplaceGroup(736006003);
                ComposerKt.sourceInformation($composer, "275@12955L265");
                SpacerKt.Spacer(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null), $composer, 6);
            }
            $composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            Composer $composer3 = $composer2;
            TextKt.Text-Nvy7gAk($card.getTitle(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(8), 0.0f, 0.0f, 13, (Object) null), Color.copy-wmQWz5c$default(ColorKt.Color(4294506744L), $card.getHasGained() ? 1.0f : 0.7f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12b(), $composer3, 48, 24960, 110584);
            if (StringsKt.isBlank($card.getRarity())) {
                $composer3.startReplaceGroup(106341818);
            } else {
                $composer3.startReplaceGroup(119985321);
                ComposerKt.sourceInformation($composer3, "299@14031L9,294@13740L401");
                TextKt.Text-Nvy7gAk($card.getRarity(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(2), 0.0f, 0.0f, 13, (Object) null), Color.copy-wmQWz5c$default(ColorKt.Color(4294964669L), $card.getHasGained() ? 1.0f : 0.7f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12b(), $composer3, 48, 24960, 110584);
            }
            $composer3.endReplaceGroup();
            if ($card.getStockInfo() != null) {
                $composer3.startReplaceGroup(120478221);
                ComposerKt.sourceInformation($composer3, "305@14302L1085");
                boolean hasStock = $card.getStockInfo().getStock() > 0;
                Modifier modifier$iv4 = BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(14), Dp.constructor-impl(6), Dp.constructor-impl(14), 0.0f, 8, (Object) null), 0.0f, 1, (Object) null), Dp.constructor-impl(18)), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(76)));
                Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                str6 = str;
                ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, str6);
                MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv4 = (48 << 3) & 112;
                str7 = str4;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, str7);
                int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer3, modifier$iv4);
                Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                str8 = str3;
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, str8);
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    factory$iv$iv$iv4 = factory$iv$iv$iv9;
                    $composer3.createNode(factory$iv$iv$iv4);
                } else {
                    factory$iv$iv$iv4 = factory$iv$iv$iv9;
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                int i7 = ($changed$iv$iv$iv4 >> 6) & 14;
                str5 = str2;
                ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, str5);
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i8 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -597497579, "C321@15249L9,317@14931L430:CategoriesService.kt#7m94um");
                String str9 = hasStock ? "剩" + $card.getStockInfo().getStock() + "/" + $card.getStockInfo().getTotalStock() : "已售罄";
                long j2 = Color.Companion.getWhite-0d7_KjU();
                if (!hasStock) {
                    j2 = Color.copy-wmQWz5c$default(j2, 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                }
                TextKt.Text-Nvy7gAk(str9, BasicMarqueeKt.basicMarquee-1Mj1MLw$default(Modifier.Companion, 0, 0, 0, 0, (MarqueeSpacing) null, 0.0f, 63, (Object) null), j2, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT10(), $composer3, 48, 24576, 114680);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                str5 = str2;
                str6 = str;
                str7 = str4;
                str8 = str3;
                $composer3.startReplaceGroup(106341818);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if ($card.getCount() > 1) {
                $composer.startReplaceGroup(-238676159);
                ComposerKt.sourceInformation($composer, "329@15487L807");
                Modifier modifier$iv5 = PaddingKt.padding-VpY3zN4(BackgroundKt.background$default(SizeKt.wrapContentSize$default($this$BoxWithConstraints.align(Modifier.Companion, Alignment.Companion.getTopEnd()), (Alignment) null, false, 3, (Object) null), Brush.Companion.linearGradient-mHitzGk$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(Color.Companion.getWhite-0d7_KjU()), Color.box-impl(ColorKt.Color(4294964413L))}), 0L, 0L, 0, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(10)), 0.0f, 4, (Object) null), Dp.constructor-impl(5), Dp.constructor-impl(2));
                Alignment contentAlignment$iv3 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer, 1042775818, str6);
                MeasurePolicy measurePolicy$iv5 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
                int $changed$iv$iv5 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, str7);
                int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv5 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer, modifier$iv5);
                Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, str8);
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv10;
                    $composer.createNode(factory$iv$iv$iv3);
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv10;
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                int i9 = ($changed$iv$iv$iv5 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1833054614, str5);
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                int i10 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -1350475190, "C343@16232L9,340@16074L198:CategoriesService.kt#7m94um");
                TextKt.Text-Nvy7gAk(String.valueOf($card.getCount()), (Modifier) null, ColorKt.Color(4279242767L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT11(), $composer, 384, 0, 131066);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(-237853047);
                ComposerKt.sourceInformation($composer, "347@16340L63");
                SpacerKt.Spacer($this$BoxWithConstraints.align(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), Alignment.Companion.getTopEnd()), $composer, 0);
                $composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CardUI$lambda$0$0$0$0(CategoriesService this$0, CardModel $card) {
        String str;
        Router router = this$0.router;
        Builder appendQueryParameter = UrisKt.toUri("bilibili://digital/preview/kntr").buildUpon().appendQueryParameter("act_id", String.valueOf(this$0.actId)).appendQueryParameter("vmid", String.valueOf(this$0.vmid)).appendQueryParameter("lottery_id", String.valueOf(((Number) this$0.lotterySelectedService.getCurrentLotteryIdFlow().getValue()).longValue())).appendQueryParameter("anchor_id", $card.getAnchorId()).appendQueryParameter("f_source", "shop").appendQueryParameter("from", this$0.from).appendQueryParameter("from_id", this$0.fromSource).appendQueryParameter("owned_status", String.valueOf(this$0.tabsService.getPagerState().getCurrentPage()));
        JsonObjectBuilder builder$iv = new JsonObjectBuilder();
        JsonElementBuildersKt.put(builder$iv, "image", $card.getImage());
        JsonElementBuildersKt.put(builder$iv, "name", $card.getTitle());
        JsonElementBuildersKt.put(builder$iv, "badge", $card.getBadge());
        if ($card.getHasBorder()) {
            str = "https://i1.hdslb.com/bfs/static/jinkela/mall-digital-card/assets/card-frame.05fad8e6.png";
        } else {
            str = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        JsonElementBuildersKt.put(builder$iv, "frameUrl", str);
        JsonElementBuildersKt.put(builder$iv, "hasMask", Boolean.valueOf($card.getCount() < 1));
        Unit unit = Unit.INSTANCE;
        router.launch(appendQueryParameter.appendQueryParameter("simple_card", builder$iv.build().toString()).build());
        return Unit.INSTANCE;
    }
}