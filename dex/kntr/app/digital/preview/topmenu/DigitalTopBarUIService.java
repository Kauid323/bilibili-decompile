package kntr.app.digital.preview.topmenu;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.compose.ui.window.PopupProperties;
import com.bilibili.compose.theme.BiliTheme;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kntr.app.digital.preview.BusinessScope;
import kntr.app.digital.preview.action.Action;
import kntr.app.digital.preview.action.HandleAction;
import kntr.app.digital.preview.card.CardBasic;
import kntr.app.digital.preview.card.DigitalCardStateService;
import kntr.app.digital.preview.closing.ClosingAction;
import kntr.app.digital.preview.share.ShareAction;
import kntr.app.digital.preview.smelting.SmeltingTutorialAction;
import kntr.app.digital.preview.viewall.ViewAllAction;
import kntr.app.digital.preview.viewmore.DigitalViewMoreService;
import kntr.app.digital.preview.viewmore.ViewMoreAction;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.app.digital.preview.generated.resources.Drawable0_commonMainKt;
import srcs.app.digital.preview.generated.resources.Res;

/* compiled from: DigitalTopBarUIService.kt */
@BusinessScope
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000eJ)\u0010\u000f\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014H\u0003¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lkntr/app/digital/preview/topmenu/DigitalTopBarUIService;", RoomRecommendViewModel.EMPTY_CURSOR, "handleAction", "Lkntr/app/digital/preview/action/HandleAction;", "viewMoreService", "Lkntr/app/digital/preview/viewmore/DigitalViewMoreService;", "cardStateService", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "<init>", "(Lkntr/app/digital/preview/action/HandleAction;Lkntr/app/digital/preview/viewmore/DigitalViewMoreService;Lkntr/app/digital/preview/card/DigitalCardStateService;)V", "Content", RoomRecommendViewModel.EMPTY_CURSOR, "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ViewMorePopup", "items", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/digital/preview/viewmore/ViewMoreAction$Item;", "onDismissRequest", "Lkotlin/Function0;", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DigitalTopBarUIService {
    public static final int $stable = 8;
    private final DigitalCardStateService cardStateService;
    private final HandleAction handleAction;
    private final DigitalViewMoreService viewMoreService;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$6(DigitalTopBarUIService digitalTopBarUIService, Modifier modifier, int i, int i2, Composer composer, int i3) {
        digitalTopBarUIService.Content(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ViewMorePopup$lambda$1(DigitalTopBarUIService digitalTopBarUIService, List list, Function0 function0, int i, Composer composer, int i2) {
        digitalTopBarUIService.ViewMorePopup(list, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    @Inject
    public DigitalTopBarUIService(HandleAction handleAction, DigitalViewMoreService viewMoreService, DigitalCardStateService cardStateService) {
        Intrinsics.checkNotNullParameter(handleAction, "handleAction");
        Intrinsics.checkNotNullParameter(viewMoreService, "viewMoreService");
        Intrinsics.checkNotNullParameter(cardStateService, "cardStateService");
        this.handleAction = handleAction;
        this.viewMoreService = viewMoreService;
        this.cardStateService = cardStateService;
    }

    /* JADX WARN: Code restructure failed: missing block: B:109:0x0417, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x062f, code lost:
        if (r11 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x02aa, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x036d, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L79;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Content(Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Object element$iv;
        Object element$iv2;
        Object element$iv3;
        Object element$iv4;
        Action action;
        Function0 factory$iv$iv$iv;
        Composer $composer$iv;
        Composer $composer$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(-1761096814);
        ComposerKt.sourceInformation($composer2, "C(Content)N(modifier)69@3417L3903:DigitalTopBarUIService.kt#lar672");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(this) ? 32 : 16;
        }
        if ($composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1761096814, $dirty, -1, "kntr.app.digital.preview.topmenu.DigitalTopBarUIService.Content (DigitalTopBarUIService.kt:59)");
            }
            CardBasic cardBasic = this.cardStateService.getCurrentCardItem().getBasic();
            List actionModule = cardBasic.getTopBarActions();
            if (actionModule == null) {
                actionModule = CollectionsKt.emptyList();
            }
            List $this$firstOrNull$iv = actionModule;
            Iterator<T> it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    element$iv = it.next();
                    Action it2 = (Action) element$iv;
                    if (it2.getData() instanceof ClosingAction) {
                        break;
                    }
                } else {
                    element$iv = null;
                    break;
                }
            }
            final Action closingAction = (Action) element$iv;
            List $this$firstOrNull$iv2 = actionModule;
            Iterator<T> it3 = $this$firstOrNull$iv2.iterator();
            while (true) {
                if (it3.hasNext()) {
                    element$iv2 = it3.next();
                    Action it4 = (Action) element$iv2;
                    if (it4.getData() instanceof ShareAction) {
                        break;
                    }
                } else {
                    element$iv2 = null;
                    break;
                }
            }
            final Action shareAction = (Action) element$iv2;
            List $this$firstOrNull$iv3 = actionModule;
            Iterator<T> it5 = $this$firstOrNull$iv3.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    element$iv3 = null;
                    break;
                }
                element$iv3 = it5.next();
                Action it6 = (Action) element$iv3;
                CardBasic cardBasic2 = cardBasic;
                if (it6.getData() instanceof ViewMoreAction) {
                    break;
                }
                cardBasic = cardBasic2;
            }
            final Action viewMoreAction = (Action) element$iv3;
            List $this$firstOrNull$iv4 = actionModule;
            Iterator<T> it7 = $this$firstOrNull$iv4.iterator();
            while (true) {
                if (!it7.hasNext()) {
                    element$iv4 = null;
                    break;
                }
                element$iv4 = it7.next();
                Action it8 = (Action) element$iv4;
                Iterable $this$firstOrNull$iv5 = $this$firstOrNull$iv4;
                if (it8.getData() instanceof SmeltingTutorialAction) {
                    break;
                }
                $this$firstOrNull$iv4 = $this$firstOrNull$iv5;
            }
            final Action smeltingTutorialAction = (Action) element$iv4;
            List $this$firstOrNull$iv6 = actionModule;
            Iterator<T> it9 = $this$firstOrNull$iv6.iterator();
            while (true) {
                if (!it9.hasNext()) {
                    action = null;
                    break;
                }
                Object element$iv5 = it9.next();
                Action it10 = (Action) element$iv5;
                List actionModule2 = actionModule;
                if (it10.getData() instanceof ViewAllAction) {
                    action = element$iv5;
                    break;
                }
                actionModule = actionModule2;
            }
            final Action viewAllAction = action;
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            int $changed$iv = ($dirty & 14) | 384;
            Modifier modifier$iv = modifier3;
            Modifier modifier4 = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            int $dirty2 = $dirty;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = (($changed$iv >> 6) & 112) | 6;
            RowScope $this$Content_u24lambda_u245 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -626432626, "C87@4163L38:DigitalTopBarUIService.kt#lar672");
            if (closingAction != null) {
                $composer2.startReplaceGroup(-626504640);
                ComposerKt.sourceInformation($composer2, "75@3645L58,81@3963L107,74@3604L524");
                Painter painterResource = ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_dlc_draw_card_result_back(Res.drawable.INSTANCE), $composer2, 0);
                Modifier modifier5 = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(22));
                ComposerKt.sourceInformationMarkerStart($composer2, 1226727897, "CC(remember):DigitalTopBarUIService.kt#9igjgp");
                boolean invalid$iv = $composer2.changedInstance(this) | $composer2.changedInstance(closingAction);
                Object it$iv = $composer2.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv2 = new Function0() { // from class: kntr.app.digital.preview.topmenu.DigitalTopBarUIService$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        Unit Content$lambda$5$0$0;
                        Content$lambda$5$0$0 = DigitalTopBarUIService.Content$lambda$5$0$0(DigitalTopBarUIService.this, closingAction);
                        return Content$lambda$5$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                it$iv = value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ImageKt.Image(painterResource, (String) null, ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer2, Painter.$stable | 48, 120);
            } else {
                $composer2.startReplaceGroup(-630076460);
            }
            $composer2.endReplaceGroup();
            SpacerKt.Spacer(RowScope.-CC.weight$default($this$Content_u24lambda_u245, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer2, 0);
            if (smeltingTutorialAction != null) {
                $composer2.startReplaceGroup(-625838884);
                ComposerKt.sourceInformation($composer2, "90@4317L55,96@4641L108,89@4276L496");
                Painter painterResource2 = ImageResourcesKt.painterResource(Drawable0_commonMainKt.getDigital_smelting_tutorial(Res.drawable.INSTANCE), $composer2, 0);
                Modifier modifier6 = SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(24), 0.0f, 0.0f, 0.0f, 14, (Object) null), Dp.constructor-impl(22));
                ComposerKt.sourceInformationMarkerStart($composer2, 1226749594, "CC(remember):DigitalTopBarUIService.kt#9igjgp");
                boolean invalid$iv2 = $composer2.changedInstance(this) | $composer2.changedInstance(smeltingTutorialAction);
                Object it$iv2 = $composer2.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv3 = new Function0() { // from class: kntr.app.digital.preview.topmenu.DigitalTopBarUIService$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        Unit Content$lambda$5$1$0;
                        Content$lambda$5$1$0 = DigitalTopBarUIService.Content$lambda$5$1$0(DigitalTopBarUIService.this, smeltingTutorialAction);
                        return Content$lambda$5$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
                it$iv2 = value$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ImageKt.Image(painterResource2, (String) null, ClickableKt.clickable-oSLSa3U$default(modifier6, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer2, Painter.$stable | 48, 120);
            } else {
                $composer2.startReplaceGroup(-630076460);
            }
            $composer2.endReplaceGroup();
            if (shareAction != null) {
                $composer2.startReplaceGroup(-625265725);
                ComposerKt.sourceInformation($composer2, "103@4895L59,109@5223L97,102@4854L489");
                Painter painterResource3 = ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_dlc_draw_card_result_share(Res.drawable.INSTANCE), $composer2, 0);
                Modifier modifier7 = SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(24), 0.0f, 0.0f, 0.0f, 14, (Object) null), Dp.constructor-impl(22));
                ComposerKt.sourceInformationMarkerStart($composer2, 1226768207, "CC(remember):DigitalTopBarUIService.kt#9igjgp");
                boolean invalid$iv3 = $composer2.changedInstance(this) | $composer2.changedInstance(shareAction);
                Object it$iv3 = $composer2.rememberedValue();
                if (invalid$iv3) {
                }
                Object value$iv4 = new Function0() { // from class: kntr.app.digital.preview.topmenu.DigitalTopBarUIService$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        Unit Content$lambda$5$2$0;
                        Content$lambda$5$2$0 = DigitalTopBarUIService.Content$lambda$5$2$0(DigitalTopBarUIService.this, shareAction);
                        return Content$lambda$5$2$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv4);
                it$iv3 = value$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ImageKt.Image(painterResource3, (String) null, ClickableKt.clickable-oSLSa3U$default(modifier7, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv3, 15, (Object) null), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer2, Painter.$stable | 48, 120);
            } else {
                $composer2.startReplaceGroup(-630076460);
            }
            $composer2.endReplaceGroup();
            if (viewMoreAction != null) {
                $composer2.startReplaceGroup(-624683545);
                ComposerKt.sourceInformation($composer2, "115@5428L901");
                ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Modifier modifier$iv2 = Modifier.Companion;
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv2 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                $composer$iv$iv$iv = $composer2;
                ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer2.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
                $composer$iv = $composer2;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i6 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -264252162, "C123@5831L48,129@6172L108,122@5786L521:DigitalTopBarUIService.kt#lar672");
                List items = this.viewMoreService.getViewMorePopupItems();
                if (items != null) {
                    $composer2.startReplaceGroup(-264182599);
                    ComposerKt.sourceInformation($composer2, "118@5626L108,118@5578L157");
                    ComposerKt.sourceInformationMarkerStart($composer2, 407122368, "CC(remember):DigitalTopBarUIService.kt#9igjgp");
                    boolean invalid$iv4 = $composer2.changedInstance(this);
                    Object it$iv4 = $composer2.rememberedValue();
                    if (!invalid$iv4 && it$iv4 != Composer.Companion.getEmpty()) {
                        value$iv = it$iv4;
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ViewMorePopup(items, (Function0) value$iv, $composer2, ($dirty2 << 3) & 896);
                    }
                    value$iv = new Function0() { // from class: kntr.app.digital.preview.topmenu.DigitalTopBarUIService$$ExternalSyntheticLambda5
                        public final Object invoke() {
                            Unit Content$lambda$5$3$0$0;
                            Content$lambda$5$3$0$0 = DigitalTopBarUIService.Content$lambda$5$3$0$0(DigitalTopBarUIService.this);
                            return Content$lambda$5$3$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ViewMorePopup(items, (Function0) value$iv, $composer2, ($dirty2 << 3) & 896);
                } else {
                    $composer2.startReplaceGroup(-269693810);
                }
                $composer2.endReplaceGroup();
                Painter painterResource4 = ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_dlc_detail_more(Res.drawable.INSTANCE), $composer2, 0);
                Modifier modifier8 = SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(24), 0.0f, 0.0f, 0.0f, 14, (Object) null), Dp.constructor-impl(22));
                ComposerKt.sourceInformationMarkerStart($composer2, 407139840, "CC(remember):DigitalTopBarUIService.kt#9igjgp");
                boolean invalid$iv5 = $composer2.changedInstance(this) | $composer2.changedInstance(viewMoreAction);
                Object it$iv5 = $composer2.rememberedValue();
                if (invalid$iv5) {
                }
                Object value$iv5 = new Function0() { // from class: kntr.app.digital.preview.topmenu.DigitalTopBarUIService$$ExternalSyntheticLambda6
                    public final Object invoke() {
                        Unit Content$lambda$5$3$1$0;
                        Content$lambda$5$3$1$0 = DigitalTopBarUIService.Content$lambda$5$3$1$0(DigitalTopBarUIService.this, viewMoreAction);
                        return Content$lambda$5$3$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv5);
                it$iv5 = value$iv5;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ImageKt.Image(painterResource4, (String) null, ClickableKt.clickable-oSLSa3U$default(modifier8, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv5, 15, (Object) null), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer2, Painter.$stable | 48, 120);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                $composer$iv = $composer2;
                $composer$iv$iv$iv = $composer2;
                $composer2.startReplaceGroup(-630076460);
            }
            $composer2.endReplaceGroup();
            if (viewAllAction != null) {
                $composer2.startReplaceGroup(-623707231);
                ComposerKt.sourceInformation($composer2, "139@6575L9,142@6723L91,137@6482L355,147@6899L54,152@7166L99,146@6858L430");
                Object data = viewAllAction.getData();
                Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kntr.app.digital.preview.viewall.ViewAllAction");
                ViewAllAction action2 = (ViewAllAction) data;
                String title = action2.getTitle();
                TextStyle t16 = BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT16();
                long Color = ColorKt.Color(4289440425L);
                Modifier modifier9 = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart($composer2, 1226816201, "CC(remember):DigitalTopBarUIService.kt#9igjgp");
                boolean invalid$iv6 = $composer2.changedInstance(this) | $composer2.changedInstance(viewAllAction);
                Object it$iv6 = $composer2.rememberedValue();
                if (invalid$iv6 || it$iv6 == Composer.Companion.getEmpty()) {
                    Object value$iv6 = new Function0() { // from class: kntr.app.digital.preview.topmenu.DigitalTopBarUIService$$ExternalSyntheticLambda7
                        public final Object invoke() {
                            Unit Content$lambda$5$4$0;
                            Content$lambda$5$4$0 = DigitalTopBarUIService.Content$lambda$5$4$0(DigitalTopBarUIService.this, viewAllAction);
                            return Content$lambda$5$4$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv6);
                    it$iv6 = value$iv6;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                TextKt.Text-Nvy7gAk(title, ClickableKt.clickable-oSLSa3U$default(modifier9, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv6, 15, (Object) null), Color, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t16, $composer2, 384, 0, 131064);
                Painter painterResource5 = ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_nft_card_bottom_arrow(Res.drawable.INSTANCE), $composer2, 0);
                Modifier modifier10 = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24));
                ComposerKt.sourceInformationMarkerStart($composer2, 1226830385, "CC(remember):DigitalTopBarUIService.kt#9igjgp");
                boolean invalid$iv7 = $composer2.changedInstance(this) | $composer2.changedInstance(viewAllAction);
                Object it$iv7 = $composer2.rememberedValue();
                if (invalid$iv7 || it$iv7 == Composer.Companion.getEmpty()) {
                    Object value$iv7 = new Function0() { // from class: kntr.app.digital.preview.topmenu.DigitalTopBarUIService$$ExternalSyntheticLambda8
                        public final Object invoke() {
                            Unit Content$lambda$5$5$0;
                            Content$lambda$5$5$0 = DigitalTopBarUIService.Content$lambda$5$5$0(DigitalTopBarUIService.this, viewAllAction);
                            return Content$lambda$5$5$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv7);
                    it$iv7 = value$iv7;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ImageKt.Image(painterResource5, (String) null, ClickableKt.clickable-oSLSa3U$default(modifier10, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv7, 15, (Object) null), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer2, Painter.$stable | 48, 120);
            } else {
                $composer2.startReplaceGroup(-630076460);
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.preview.topmenu.DigitalTopBarUIService$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$6;
                    Content$lambda$6 = DigitalTopBarUIService.Content$lambda$6(DigitalTopBarUIService.this, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$5$0$0(DigitalTopBarUIService this$0, Action $closingAction) {
        this$0.handleAction.invoke($closingAction);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$5$1$0(DigitalTopBarUIService this$0, Action $smeltingTutorialAction) {
        this$0.handleAction.invoke($smeltingTutorialAction);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$5$2$0(DigitalTopBarUIService this$0, Action $shareAction) {
        this$0.handleAction.invoke($shareAction);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$5$3$0$0(DigitalTopBarUIService this$0) {
        this$0.viewMoreService.markViewMorePopupItems(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$5$3$1$0(DigitalTopBarUIService this$0, Action $viewMoreAction) {
        this$0.handleAction.invoke($viewMoreAction);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$5$4$0(DigitalTopBarUIService this$0, Action $viewAllAction) {
        this$0.handleAction.invoke($viewAllAction);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$5$5$0(DigitalTopBarUIService this$0, Action $viewAllAction) {
        this$0.handleAction.invoke($viewAllAction);
        return Unit.INSTANCE;
    }

    private final void ViewMorePopup(final List<ViewMoreAction.Item> list, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1729175244);
        ComposerKt.sourceInformation($composer2, "C(ViewMorePopup)N(items,onDismissRequest)182@8305L1728,178@8091L1942:DigitalTopBarUIService.kt#lar672");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(this) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1729175244, $dirty2, -1, "kntr.app.digital.preview.topmenu.DigitalTopBarUIService.ViewMorePopup (DigitalTopBarUIService.kt:164)");
            }
            AndroidPopup_androidKt.Popup(new PopupPositionProvider() { // from class: kntr.app.digital.preview.topmenu.DigitalTopBarUIService$ViewMorePopup$popupPositionProvider$1
                /* renamed from: calculatePosition-llwVHH4  reason: not valid java name */
                public long m1026calculatePositionllwVHH4(IntRect anchorBounds, long j2, LayoutDirection layoutDirection, long j3) {
                    Intrinsics.checkNotNullParameter(anchorBounds, "anchorBounds");
                    Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
                    int x = anchorBounds.getRight() - ((int) (j3 >> 32));
                    int y = anchorBounds.getBottom();
                    return IntOffset.constructor-impl((x << 32) | (y & 4294967295L));
                }
            }, function0, new PopupProperties(false, false, false, false, 11, (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(247515758, true, new Function2() { // from class: kntr.app.digital.preview.topmenu.DigitalTopBarUIService$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2) {
                    Unit ViewMorePopup$lambda$0;
                    ViewMorePopup$lambda$0 = DigitalTopBarUIService.ViewMorePopup$lambda$0(list, this, (Composer) obj, ((Integer) obj2).intValue());
                    return ViewMorePopup$lambda$0;
                }
            }, $composer2, 54), $composer2, ($dirty2 & 112) | 3456, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.preview.topmenu.DigitalTopBarUIService$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit ViewMorePopup$lambda$1;
                    ViewMorePopup$lambda$1 = DigitalTopBarUIService.ViewMorePopup$lambda$1(DigitalTopBarUIService.this, list, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return ViewMorePopup$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ViewMorePopup$lambda$0(List $items, final DigitalTopBarUIService this$0, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        ComposerKt.sourceInformation($composer, "C189@8572L6,183@8323L1696:DigitalTopBarUIService.kt#lar672");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(247515758, $changed, -1, "kntr.app.digital.preview.topmenu.DigitalTopBarUIService.ViewMorePopup.<anonymous> (DigitalTopBarUIService.kt:183)");
            }
            Modifier modifier$iv = BackgroundKt.background-bw27NRU(SizeKt.wrapContentHeight$default(SizeKt.width-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(5), 0.0f, 0.0f, 13, (Object) null), Dp.constructor-impl(126)), (Alignment.Vertical) null, false, 3, (Object) null), Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBa0-0d7_KjU(), 0.9f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(10)));
            boolean z = false;
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
            boolean z2 = false;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 284346467, "C:DigitalTopBarUIService.kt#lar672");
            $composer.startReplaceGroup(1533193306);
            ComposerKt.sourceInformation($composer, "*197@8944L6,198@9002L9,203@9259L190,194@8787L689");
            List $this$forEachIndexed$iv = $items;
            boolean z3 = false;
            int index$iv = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv2 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Iterable $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                final ViewMoreAction.Item item = (ViewMoreAction.Item) item$iv;
                int index = index$iv;
                String title = item.getTitle();
                int i3 = TextAlign.Companion.getCenter-e0LSkKk();
                boolean z4 = z3;
                boolean z5 = z2;
                long j2 = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getWh0-0d7_KjU();
                TextStyle t13 = BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT13();
                CompositionLocalMap localMap$iv$iv2 = localMap$iv$iv;
                boolean z6 = z;
                Arrangement.Vertical verticalArrangement$iv2 = verticalArrangement$iv;
                Alignment.Horizontal horizontalAlignment$iv2 = horizontalAlignment$iv;
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(14), 1, (Object) null), 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, -1857661338, "CC(remember):DigitalTopBarUIService.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance(this$0) | $composer.changedInstance(item);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.digital.preview.topmenu.DigitalTopBarUIService$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            Unit ViewMorePopup$lambda$0$0$0$0$0;
                            ViewMorePopup$lambda$0$0$0$0$0 = DigitalTopBarUIService.ViewMorePopup$lambda$0$0$0$0$0(DigitalTopBarUIService.this, item);
                            return ViewMorePopup$lambda$0$0$0$0$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                TextKt.Text-Nvy7gAk(title, ClickableKt.clickable-oSLSa3U$default(fillMaxWidth$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), j2, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(i3), 0L, 0, false, 0, 0, (Function1) null, t13, $composer, 0, 0, 130040);
                if (index < CollectionsKt.getLastIndex($items)) {
                    $composer.startReplaceGroup(-1752649767);
                    ComposerKt.sourceInformation($composer, "215@9899L6,209@9560L393");
                    SpacerKt.Spacer(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, 2, (Object) null), 0.0f, 1, (Object) null), Dp.constructor-impl((float) 0.5d)), Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getWh0-0d7_KjU(), 0.15f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null), $composer, 0);
                } else {
                    $composer.startReplaceGroup(-1762118438);
                }
                $composer.endReplaceGroup();
                index$iv = index$iv2;
                $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                z3 = z4;
                z2 = z5;
                localMap$iv$iv = localMap$iv$iv2;
                z = z6;
                verticalArrangement$iv = verticalArrangement$iv2;
                horizontalAlignment$iv = horizontalAlignment$iv2;
            }
            $composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ViewMorePopup$lambda$0$0$0$0$0(DigitalTopBarUIService this$0, ViewMoreAction.Item $item) {
        this$0.handleAction.invoke($item.getAction());
        this$0.viewMoreService.markViewMorePopupItems(null);
        return Unit.INSTANCE;
    }
}