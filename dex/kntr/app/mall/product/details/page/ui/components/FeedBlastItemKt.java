package kntr.app.mall.product.details.page.ui.components;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import com.bilibili.compose.theme.BiliTheme;
import java.util.List;
import kntr.app.mall.product.details.page.api.model.CommonGoodsTagBean;
import kntr.app.mall.product.details.page.api.model.FeedTag;
import kntr.app.mall.product.details.page.api.model.MallRecommendItem;
import kntr.app.mall.product.details.page.api.model.PriceInfo;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.mall.product.details.page.ui.scale.UiScaleModel;
import kntr.app.mall.product.details.page.vm.PageActionHandler;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.device.KDevice;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImageState;
import kntr.base.imageloader.ImmutableImageRequest;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FeedBlastItem.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001a\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0001¢\u0006\u0002\u0010\r\u001a\u0015\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0001¢\u0006\u0002\u0010\r\u001a'\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\u0010¨\u0006\u0011²\u0006\n\u0010\u0012\u001a\u00020\u0013X\u008a\u0084\u0002"}, d2 = {"FeedBlastItem", "", "item", "Lkntr/app/mall/product/details/page/api/model/MallRecommendItem;", "pageViewModel", "Lkntr/app/mall/product/details/page/vm/PageViewModel;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/mall/product/details/page/api/model/MallRecommendItem;Lkntr/app/mall/product/details/page/vm/PageViewModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "getTitleMaxWidth", "Landroidx/compose/ui/unit/Dp;", "scale", "", "(FLandroidx/compose/runtime/Composer;I)F", "getImageWidth", "Money", "(Lkntr/app/mall/product/details/page/api/model/MallRecommendItem;FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "product-details-page_debug", "scaleModel", "Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class FeedBlastItemKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FeedBlastItem$lambda$4(MallRecommendItem mallRecommendItem, PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        FeedBlastItem(mallRecommendItem, pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Money$lambda$1(MallRecommendItem mallRecommendItem, float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        Money(mallRecommendItem, f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x04ba, code lost:
        if ((!r2.isEmpty()) == true) goto L67;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FeedBlastItem(final MallRecommendItem item, final PageViewModel pageViewModel, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        List<CommonGoodsTagBean> emptyList;
        Composer $composer3;
        Composer $composer$iv;
        Function0 factory$iv$iv$iv3;
        List<CommonGoodsTagBean> emptyList2;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(pageViewModel, "pageViewModel");
        Composer $composer4 = $composer.startRestartGroup(395689523);
        ComposerKt.sourceInformation($composer4, "C(FeedBlastItem)N(item,pageViewModel,modifier)41@1707L25,42@1786L16,49@2010L6,56@2374L108,51@2107L375,59@2493L184,44@1840L3060:FeedBlastItem.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changedInstance(item) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changedInstance(pageViewModel) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if ($composer4.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
            if (i2 != 0) {
                modifier2 = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(395689523, $dirty, -1, "kntr.app.mall.product.details.page.ui.components.FeedBlastItem (FeedBlastItem.kt:40)");
            }
            CollectorHolder collectorHolder = ExposerKt.rememberCollectorHolder($composer4, 0);
            State scaleModel$delegate = SnapshotStateKt.collectAsState(pageViewModel.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer4, 0, 1);
            float scale = FeedBlastItem$lambda$0(scaleModel$delegate).getScale();
            Modifier modifier4 = BackgroundKt.background-bw27NRU(PaddingKt.padding-VpY3zN4$default(modifier2, 0.0f, ProvideUiScaleKt.dpScaled(5, scale), 1, (Object) null), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getWh0-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(6, scale)));
            String str = "fb_card_" + item.getItemId();
            ComposerKt.sourceInformationMarkerStart($composer4, -1994431585, "CC(remember):FeedBlastItem.kt#9igjgp");
            boolean invalid$iv = $composer4.changedInstance(pageViewModel) | $composer4.changedInstance(item);
            Object it$iv = $composer4.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.FeedBlastItemKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit FeedBlastItem$lambda$1$0;
                        FeedBlastItem$lambda$1$0 = FeedBlastItemKt.FeedBlastItem$lambda$1$0(PageViewModel.this, item);
                        return FeedBlastItem$lambda$1$0;
                    }
                };
                $composer4.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier reportOnExposure = ExposerKt.reportOnExposure(modifier4, str, collectorHolder, null, true, 0.5f, 0, 0L, (Function0) it$iv, $composer4, 221184, 100);
            ComposerKt.sourceInformationMarkerStart($composer4, -1994427701, "CC(remember):FeedBlastItem.kt#9igjgp");
            boolean invalid$iv2 = $composer4.changedInstance(pageViewModel) | $composer4.changedInstance(item);
            Object it$iv2 = $composer4.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.FeedBlastItemKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit FeedBlastItem$lambda$2$0;
                        FeedBlastItem$lambda$2$0 = FeedBlastItemKt.FeedBlastItem$lambda$2$0(PageViewModel.this, item);
                        return FeedBlastItem$lambda$2$0;
                    }
                };
                $composer4.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(reportOnExposure, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            Modifier modifier5 = modifier2;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer4.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -1220887441, "C69@2877L20,78@3266L244,65@2695L826,86@3530L1364:FeedBlastItem.kt#o90vz8");
            String cover = item.getCover();
            if (cover == null) {
                cover = "";
            }
            ImmutableImageRequest build = new ImageRequest(cover).contentScale(ContentScale.Companion.getFit()).build();
            Modifier modifier6 = PaddingKt.padding-qDBjuR0$default(ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, getImageWidth(scale, $composer4, 0)), RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4(ProvideUiScaleKt.dpScaled(6, scale), ProvideUiScaleKt.dpScaled(6, scale), ProvideUiScaleKt.dpScaled(0, scale), ProvideUiScaleKt.dpScaled(0, scale))), 0.0f, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(1, scale), 7, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer4, 2038842833, "CC(remember):FeedBlastItem.kt#9igjgp");
            Object it$iv3 = $composer4.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.FeedBlastItemKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        Unit FeedBlastItem$lambda$3$0$0;
                        FeedBlastItem$lambda$3$0$0 = FeedBlastItemKt.FeedBlastItem$lambda$3$0$0((ImageState) obj);
                        return FeedBlastItem$lambda$3$0$0;
                    }
                };
                $composer4.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer4);
            BiliImageKt.BiliImage(build, modifier6, null, (Function1) it$iv3, null, null, null, null, null, $composer4, 3072, 500);
            Modifier modifier$iv2 = PaddingKt.padding-VpY3zN4(Modifier.Companion, ProvideUiScaleKt.dpScaled(10, scale), ProvideUiScaleKt.dpScaled(8, scale));
            ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer4.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, 468189338, "C95@3937L23,97@4042L23,89@3666L493,116@4866L18:FeedBlastItem.kt#o90vz8");
            FeedTag feedTag = item.getFeedTag();
            if (feedTag == null || (emptyList = feedTag.getFrontTag()) == null) {
                emptyList = CollectionsKt.emptyList();
            }
            List<CommonGoodsTagBean> list = emptyList;
            String title = item.getTitle();
            CommonTagRowKt.m430CommonTagRowvVAugoc(list, title != null ? title : "", getTitleMaxWidth(scale, $composer4, 0), scale, ProvideUiScaleKt.dpScaled(17, scale), SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(4, scale), 7, (Object) null), getTitleMaxWidth(scale, $composer4, 0)), ProvideUiScaleKt.dpScaled(17, scale)), $composer4, 0, 0);
            FeedTag feedTag2 = item.getFeedTag();
            boolean z = (feedTag2 == null || (r2 = feedTag2.getUnderTag()) == null) ? false : true;
            if (z) {
                $composer4.startReplaceGroup(468722692);
                ComposerKt.sourceInformation($composer4, "102@4240L599");
                Modifier modifier$iv3 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(4, scale), 7, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
                MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv3 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
                Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                $composer$iv = $composer4;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv6;
                    $composer4.createNode(factory$iv$iv$iv3);
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv6;
                    $composer4.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer4);
                $composer3 = $composer4;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                int i8 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -914483671, "C108@4559L23,110@4680L23,103@4323L498:FeedBlastItem.kt#o90vz8");
                FeedTag feedTag3 = item.getFeedTag();
                if (feedTag3 == null || (emptyList2 = feedTag3.getUnderTag()) == null) {
                    emptyList2 = CollectionsKt.emptyList();
                }
                CommonTagRowKt.m430CommonTagRowvVAugoc(emptyList2, "", getTitleMaxWidth(scale, $composer4, 0), scale, ProvideUiScaleKt.dpScaled(17, scale), SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, getTitleMaxWidth(scale, $composer4, 0)), ProvideUiScaleKt.dpScaled(17, scale)), $composer4, 48, 0);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
            } else {
                $composer3 = $composer4;
                $composer$iv = $composer4;
                $composer4.startReplaceGroup(464513915);
            }
            $composer4.endReplaceGroup();
            modifier3 = modifier5;
            $composer2 = $composer4;
            Money(item, scale, null, $composer4, $dirty & 14, 4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.FeedBlastItemKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit FeedBlastItem$lambda$4;
                    FeedBlastItem$lambda$4 = FeedBlastItemKt.FeedBlastItem$lambda$4(MallRecommendItem.this, pageViewModel, modifier7, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return FeedBlastItem$lambda$4;
                }
            });
        }
    }

    private static final UiScaleModel FeedBlastItem$lambda$0(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FeedBlastItem$lambda$1$0(PageViewModel $pageViewModel, MallRecommendItem $item) {
        $pageViewModel.reportFbCardShow$product_details_page_debug($item);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FeedBlastItem$lambda$2$0(PageViewModel $pageViewModel, MallRecommendItem $item) {
        $pageViewModel.reportFbCardClick$product_details_page_debug($item);
        PageActionHandler actionHandler$product_details_page_debug = $pageViewModel.getActionHandler$product_details_page_debug();
        String url = $item.getUrl();
        if (url == null) {
            url = "";
        }
        actionHandler$product_details_page_debug.pushTo$product_details_page_debug(url);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FeedBlastItem$lambda$3$0$0(ImageState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it instanceof ImageState.Success) {
            KLog_androidKt.getKLog().e("FeedsComponent", "Success loading image");
        } else {
            KLog_androidKt.getKLog().e("FeedsComponent", "Error loading image");
        }
        return Unit.INSTANCE;
    }

    public static final float getTitleMaxWidth(float scale, Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 2120129385, "C(getTitleMaxWidth)N(scale)125@5069L7:FeedBlastItem.kt#o90vz8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2120129385, $changed, -1, "kntr.app.mall.product.details.page.ui.components.getTitleMaxWidth (FeedBlastItem.kt:122)");
        }
        int screenWidth = KDevice.INSTANCE.getScreenDimensions().getWidth();
        CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density $this$getTitleMaxWidth_u24lambda_u240 = (Density) consume;
        float screenWidthDp = $this$getTitleMaxWidth_u24lambda_u240.toDp-u2uoSUM(screenWidth);
        float maxWidth = (screenWidthDp - 56) / 2;
        float dpScaled = ProvideUiScaleKt.dpScaled(maxWidth, scale);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return dpScaled;
    }

    public static final float getImageWidth(float scale, Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 374063658, "C(getImageWidth)N(scale)136@5372L7:FeedBlastItem.kt#o90vz8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(374063658, $changed, -1, "kntr.app.mall.product.details.page.ui.components.getImageWidth (FeedBlastItem.kt:133)");
        }
        int screenWidth = KDevice.INSTANCE.getScreenDimensions().getWidth();
        CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density $this$getImageWidth_u24lambda_u240 = (Density) consume;
        float screenWidthDp = $this$getImageWidth_u24lambda_u240.toDp-u2uoSUM(screenWidth);
        float width = (screenWidthDp - 16) / 2;
        float dpScaled = ProvideUiScaleKt.dpScaled(width, scale);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return dpScaled;
    }

    public static final void Money(final MallRecommendItem item, final float scale, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        String str;
        Intrinsics.checkNotNullParameter(item, "item");
        Composer $composer3 = $composer.startRestartGroup(-767565767);
        ComposerKt.sourceInformation($composer3, "C(Money)N(item,scale,modifier)149@5629L1580:FeedBlastItem.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(item) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(scale) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier2 = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-767565767, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.Money (FeedBlastItem.kt:148)");
            }
            Arrangement.Horizontal spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getBottom();
            Modifier modifier$iv$iv = SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(modifier2, 0.0f, ProvideUiScaleKt.dpScaled(4, scale), 0.0f, 0.0f, 13, (Object) null), 0.0f, 1, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv = spaceBetween;
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            Modifier modifier3 = modifier2;
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
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i4 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1037269758, "C155@5843L1166,188@7094L6,186@7018L185:FeedBlastItem.kt#o90vz8");
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getBottom();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier$iv = Modifier.Companion;
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            int $changed$iv = ((384 >> 3) & 14) | ((384 >> 3) & 112);
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, $changed$iv);
            int $changed$iv$iv2 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            $composer2 = $composer3;
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            int i6 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -706969699, "C160@6020L6,158@5922L219,166@6252L6,164@6154L265,173@6528L6,171@6432L263,181@6878L6,178@6708L291:FeedBlastItem.kt#o90vz8");
            PriceInfo price = item.getPrice();
            String pricePrefix = price != null ? price.getPricePrefix() : null;
            str = "";
            TextKt.Text-Nvy7gAk(pricePrefix == null ? "" : pricePrefix, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getPi5-0d7_KjU(), (TextAutoSize) null, ProvideUiScaleKt.spScaled(11, scale), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, ProvideUiScaleKt.spScaled(16, scale), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 0, 0, 260074);
            PriceInfo price2 = item.getPrice();
            String priceSymbol = price2 != null ? price2.getPriceSymbol() : null;
            TextKt.Text-Nvy7gAk(priceSymbol == null ? str : priceSymbol, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getPi5-0d7_KjU(), (TextAutoSize) null, ProvideUiScaleKt.spScaled(12, scale), (FontStyle) null, FontWeight.Companion.getW500(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, ProvideUiScaleKt.spScaled(16, scale), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 1572864, 0, 260010);
            PriceInfo price3 = item.getPrice();
            String priceDesc = price3 != null ? price3.getPriceDesc() : null;
            TextKt.Text-Nvy7gAk(priceDesc == null ? str : priceDesc, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getPi5-0d7_KjU(), (TextAutoSize) null, ProvideUiScaleKt.spScaled(16, scale), (FontStyle) null, FontWeight.Companion.getW500(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, ProvideUiScaleKt.spScaled(16, scale), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 1572864, 0, 260010);
            Modifier modifier4 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, ProvideUiScaleKt.dpScaled(2, scale), 0.0f, 0.0f, 0.0f, 14, (Object) null);
            PriceInfo price4 = item.getPrice();
            String priceSuffix = price4 != null ? price4.getPriceSuffix() : null;
            TextKt.Text-Nvy7gAk(priceSuffix == null ? str : priceSuffix, modifier4, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getPi5-0d7_KjU(), (TextAutoSize) null, ProvideUiScaleKt.spScaled(11, scale), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, ProvideUiScaleKt.spScaled(16, scale), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 0, 0, 260072);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            String like = item.getLike();
            TextKt.Text-Nvy7gAk(like != null ? like : "", (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGa5-0d7_KjU(), (TextAutoSize) null, ProvideUiScaleKt.spScaled(11, scale), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, ProvideUiScaleKt.spScaled(16, scale), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 0, 0, 260074);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.FeedBlastItemKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit Money$lambda$1;
                    Money$lambda$1 = FeedBlastItemKt.Money$lambda$1(MallRecommendItem.this, scale, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Money$lambda$1;
                }
            });
        }
    }
}