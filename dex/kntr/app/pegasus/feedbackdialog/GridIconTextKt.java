package kntr.app.pegasus.feedbackdialog;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.ThemeDayNight;
import java.util.Collection;
import java.util.List;
import kntr.app.pegasus.feedbackdialog.model.FeedbackItem;
import kntr.app.pegasus.feedbackdialog.model.FeedbackItemType;
import kntr.app.pegasus.feedbackdialog.widget.ImagePlaceholderKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImmutableImageRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: GridIconText.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bH\u0001¢\u0006\u0002\u0010\n\u001a7\u0010\u000b\u001a\u00020\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000fH\u0001¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"GridIconText", "", "dataList", "", "Lkntr/app/pegasus/feedbackdialog/model/FeedbackItem;", "title", "", "onDismiss", "Lkotlin/Function1;", "Lkntr/app/pegasus/feedbackdialog/model/FeedbackItemType;", "(Ljava/util/List;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "GridIconTextItem", "icon", "text", "onClick", "Lkotlin/Function0;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "feedbackdialog_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class GridIconTextKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GridIconText$lambda$1(List list, String str, Function1 function1, int i, int i2, Composer composer, int i3) {
        GridIconText(list, str, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GridIconTextItem$lambda$2(String str, String str2, Function0 function0, int i, int i2, Composer composer, int i3) {
        GridIconTextItem(str, str2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x04f5, code lost:
        if (r6 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L82;
     */
    /* JADX WARN: Removed duplicated region for block: B:121:0x05db  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x06c2  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x06ce  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x06d4  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0763  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0765  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void GridIconText(final List<FeedbackItem> list, String title, final Function1<? super FeedbackItemType, Unit> function1, Composer $composer, final int $changed, final int i) {
        String str;
        String title2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        List $this$fastForEach$iv;
        int $changed$iv;
        CompositionLocalMap localMap$iv$iv;
        boolean z;
        Composer $composer$iv;
        int $changed$iv$iv$iv;
        Composer $composer$iv$iv;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv2;
        String str2;
        int valid;
        Function0 factory$iv$iv$iv5;
        String str3;
        int index$iv;
        int $dirty;
        boolean invalid$iv;
        Object it$iv;
        Function0 value$iv;
        int count$iv;
        Intrinsics.checkNotNullParameter(list, "dataList");
        Intrinsics.checkNotNullParameter(function1, "onDismiss");
        Composer $composer2 = $composer.startRestartGroup(-718475689);
        ComposerKt.sourceInformation($composer2, "C(GridIconText)N(dataList,title,onDismiss)41@1734L2982:GridIconText.kt#36vyx9");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(list) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
            str = title;
        } else if (($changed & 48) == 0) {
            str = title;
            $dirty2 |= $composer2.changed(str) ? 32 : 16;
        } else {
            str = title;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 256 : 128;
        }
        int $dirty3 = $dirty2;
        if ($composer2.shouldExecute(($dirty3 & 147) != 146, $dirty3 & 1)) {
            String title3 = i2 != 0 ? null : str;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-718475689, $dirty3, -1, "kntr.app.pegasus.feedbackdialog.GridIconText (GridIconText.kt:40)");
            }
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            int $changed$iv$iv = (438 << 3) & 112;
            String str4 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv << 6) & 896) | 6;
            String str5 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((438 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1926896495, "C64@2443L2267:GridIconText.kt#36vyx9");
            String str6 = title3;
            String it = !(str6 == null || StringsKt.isBlank(str6)) ? title3 : null;
            if (it == null) {
                $composer2.startReplaceGroup(1926857464);
                $composer2.endReplaceGroup();
                title2 = title3;
            } else {
                $composer2.startReplaceGroup(1926857465);
                ComposerKt.sourceInformation($composer2, "*49@2030L9,50@2080L6,47@1963L300");
                title2 = title3;
                TextKt.Text-Nvy7gAk(it, PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(4), 1, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGa10-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14b(), $composer2, 48, 24960, 110584);
                Unit unit = Unit.INSTANCE;
                $composer2.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            }
            List windowed = CollectionsKt.windowed(list, 4, 4, true);
            Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
            int $changed$iv2 = '6';
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer2, ((54 >> 3) & 14) | ((54 >> 3) & 112));
            int $changed$iv$iv2 = (54 << 3) & 112;
            Composer $composer$iv$iv2 = $composer2;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv2, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer$iv$iv2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer$iv$iv2, modifier$iv2);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv2 << 6) & 896) | 6;
            Composer $composer$iv$iv$iv2 = $composer$iv$iv2;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv$iv$iv2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv$iv$iv2.startReusableNode();
            if ($composer$iv$iv$iv2.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                $composer$iv$iv$iv2.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                $composer$iv$iv$iv2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer$iv$iv$iv2);
            MeasurePolicy measurePolicy$iv$iv = measurePolicy$iv2;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
            Composer $composer$iv3 = $composer$iv$iv$iv2;
            boolean z2 = false;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            int i6 = ((54 >> 6) & 112) | 6;
            Composer $composer3 = $composer$iv3;
            ComposerKt.sourceInformationMarkerStart($composer3, -1594872939, "C:GridIconText.kt#36vyx9");
            $composer3.startReplaceGroup(225647429);
            ComposerKt.sourceInformation($composer3, "*69@2632L2054");
            List $this$fastForEach$iv2 = windowed;
            int size = $this$fastForEach$iv2.size();
            int $i$f$fastForEach = 0;
            while ($i$f$fastForEach < size) {
                Object item$iv = $this$fastForEach$iv2.get($i$f$fastForEach);
                int i7 = size;
                Iterable rows = (List) item$iv;
                List $this$fastForEach$iv3 = $this$fastForEach$iv2;
                int $changed$iv3 = $changed$iv2;
                MeasurePolicy measurePolicy$iv$iv2 = measurePolicy$iv$iv;
                boolean z3 = z2;
                Modifier modifier$iv3 = IntrinsicKt.height(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), IntrinsicSize.Min);
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
                Composer $composer$iv4 = $composer3;
                int $changed$iv4 = '6';
                int $changed$iv$iv$iv4 = $changed$iv$iv$iv3;
                Modifier materialized$iv$iv3 = materialized$iv$iv2;
                ComposerKt.sourceInformationMarkerStart($composer$iv4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
                MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer$iv4, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                int $changed$iv$iv3 = (54 << 3) & 112;
                Composer $composer$iv$iv3 = $composer$iv4;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv3, -1159599143, str4);
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv3, 0));
                CompositionLocalMap localMap$iv$iv4 = $composer$iv$iv3.getCurrentCompositionLocalMap();
                Composer $composer$iv$iv4 = $composer$iv$iv2;
                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer$iv$iv3, modifier$iv3);
                Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv5 = (($changed$iv$iv3 << 6) & 896) | 6;
                Composer $composer$iv$iv$iv3 = $composer$iv$iv$iv2;
                Composer $composer$iv$iv$iv4 = $composer$iv$iv3;
                Composer $composer$iv$iv$iv5 = $composer$iv3;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv4, -553112988, str5);
                if (!($composer$iv$iv$iv4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv$iv$iv4.startReusableNode();
                if ($composer$iv$iv$iv4.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv8;
                    $composer$iv$iv$iv4.createNode(factory$iv$iv$iv3);
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv8;
                    $composer$iv$iv$iv4.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer$iv$iv$iv4);
                Composer $composer4 = $composer3;
                int index$iv2 = $i$f$fastForEach;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                int i8 = ($changed$iv$iv$iv5 >> 6) & 14;
                Composer $composer$iv5 = $composer$iv$iv$iv4;
                ComposerKt.sourceInformationMarkerStart($composer$iv5, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                int i9 = ((54 >> 6) & 112) | 6;
                RowScope $this$GridIconText_u24lambda_u240_u242_u240_u240 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer$iv5, 267193768, "C74@2867L111:GridIconText.kt#36vyx9");
                ComposerKt.sourceInformationMarkerStart($composer$iv5, 1394091901, "CC(remember):GridIconText.kt#9igjgp");
                boolean invalid$iv2 = $composer$iv5.changed(rows);
                Object it$iv2 = $composer$iv5.rememberedValue();
                if (invalid$iv2) {
                }
                Iterable $this$count$iv = rows;
                if (($this$count$iv instanceof Collection) && ((Collection) $this$count$iv).isEmpty()) {
                    count$iv = 0;
                } else {
                    count$iv = 0;
                    for (Object element$iv : $this$count$iv) {
                        FeedbackItem item = (FeedbackItem) element$iv;
                        if (item.getDisplayValid() && (count$iv = count$iv + 1) < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                    }
                }
                Object value$iv2 = Integer.valueOf(count$iv);
                $composer$iv5.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
                int valid2 = ((Number) it$iv2).intValue();
                ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                $composer$iv5.startReplaceGroup(1394097385);
                ComposerKt.sourceInformation($composer$iv5, "");
                List $this$fastForEach$iv4 = rows;
                int size2 = $this$fastForEach$iv4.size();
                int $i$f$fastForEach2 = 0;
                while ($i$f$fastForEach2 < size2) {
                    Object item$iv2 = $this$fastForEach$iv4.get($i$f$fastForEach2);
                    int i10 = size2;
                    final FeedbackItem dataItem = (FeedbackItem) item$iv2;
                    String iconNight = dataItem.getIconNight();
                    if (iconNight == null) {
                        $this$fastForEach$iv = $this$fastForEach$iv4;
                        $composer$iv5.startReplaceGroup(1011117599);
                        $composer$iv5.endReplaceGroup();
                        $changed$iv = $changed$iv4;
                        iconNight = null;
                    } else {
                        $this$fastForEach$iv = $this$fastForEach$iv4;
                        $composer$iv5.startReplaceGroup(1011117600);
                        ComposerKt.sourceInformation($composer$iv5, "*79@3132L13");
                        BiliTheme biliTheme = BiliTheme.INSTANCE;
                        $changed$iv = $changed$iv4;
                        int $changed$iv5 = BiliTheme.$stable;
                        if (!(biliTheme.getDayNightTheme($composer$iv5, $changed$iv5) == ThemeDayNight.Night)) {
                            iconNight = null;
                        }
                        $composer$iv5.endReplaceGroup();
                    }
                    if (iconNight == null) {
                        iconNight = dataItem.getIcon();
                    }
                    String icon = iconNight;
                    if (icon != null) {
                        localMap$iv$iv = localMap$iv$iv4;
                        if (!StringsKt.isBlank(icon)) {
                            z = true;
                            if (!z) {
                                String title4 = dataItem.getTitle();
                                if (!(title4 != null && (StringsKt.isBlank(title4) ^ true))) {
                                    $composer$iv5.startReplaceGroup(1008026745);
                                    $composer$iv5.endReplaceGroup();
                                    $composer$iv$iv = $composer$iv$iv3;
                                    valid = valid2;
                                    $composer$iv2 = $composer$iv5;
                                    index$iv = $i$f$fastForEach2;
                                    $composer$iv = $composer$iv4;
                                    $dirty = $dirty3;
                                    str3 = str5;
                                    $changed$iv$iv$iv = $changed$iv$iv$iv5;
                                    str2 = str4;
                                    $composer$iv$iv$iv = $composer$iv$iv$iv4;
                                    $i$f$fastForEach2 = index$iv + 1;
                                    $changed$iv$iv$iv5 = $changed$iv$iv$iv;
                                    $composer$iv4 = $composer$iv;
                                    $composer$iv$iv3 = $composer$iv$iv;
                                    $composer$iv$iv$iv4 = $composer$iv$iv$iv;
                                    size2 = i10;
                                    $this$fastForEach$iv4 = $this$fastForEach$iv;
                                    $changed$iv4 = $changed$iv;
                                    localMap$iv$iv4 = localMap$iv$iv;
                                    $composer$iv5 = $composer$iv2;
                                    valid2 = valid;
                                    str4 = str2;
                                    str5 = str3;
                                    $dirty3 = $dirty;
                                }
                            }
                            $composer$iv5.startReplaceGroup(1011344396);
                            ComposerKt.sourceInformation($composer$iv5, "82@3346L821");
                            $composer$iv = $composer$iv4;
                            $changed$iv$iv$iv = $changed$iv$iv$iv5;
                            $composer$iv$iv = $composer$iv$iv3;
                            Modifier modifier$iv4 = SizeKt.heightIn-VpY3zN4$default(SizeKt.fillMaxHeight$default(RowScope.-CC.weight$default($this$GridIconText_u24lambda_u240_u242_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), 0.0f, 1, (Object) null), Dp.constructor-impl(67), 0.0f, 2, (Object) null);
                            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                            $composer$iv$iv$iv = $composer$iv$iv$iv4;
                            ComposerKt.sourceInformationMarkerStart($composer$iv5, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                            int $changed$iv$iv4 = (48 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer$iv5, -1159599143, str4);
                            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv5, 0));
                            CompositionLocalMap localMap$iv$iv5 = $composer$iv5.getCurrentCompositionLocalMap();
                            $composer$iv2 = $composer$iv5;
                            Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer$iv5, modifier$iv4);
                            Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv6 = (($changed$iv$iv4 << 6) & 896) | 6;
                            str2 = str4;
                            valid = valid2;
                            ComposerKt.sourceInformationMarkerStart($composer$iv5, -553112988, str5);
                            if (!($composer$iv5.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer$iv5.startReusableNode();
                            if ($composer$iv5.getInserting()) {
                                factory$iv$iv$iv5 = factory$iv$iv$iv9;
                                $composer$iv5.useNode();
                            } else {
                                factory$iv$iv$iv5 = factory$iv$iv$iv9;
                                $composer$iv5.createNode(factory$iv$iv$iv5);
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer$iv5);
                            str3 = str5;
                            index$iv = $i$f$fastForEach2;
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                            int i11 = ($changed$iv$iv$iv6 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer$iv5, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                            BoxScope boxScope = BoxScopeInstance.INSTANCE;
                            int i12 = ((48 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer$iv5, -205956813, "C93@3917L185,90@3745L392:GridIconText.kt#36vyx9");
                            String title5 = dataItem.getTitle();
                            ComposerKt.sourceInformationMarkerStart($composer$iv5, 270456193, "CC(remember):GridIconText.kt#9igjgp");
                            $dirty = $dirty3;
                            invalid$iv = $composer2.changed(dataItem) | (($dirty3 & 896) != 256);
                            it$iv = $composer$iv5.rememberedValue();
                            if (!invalid$iv && it$iv != Composer.Companion.getEmpty()) {
                                value$iv = it$iv;
                                ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                                GridIconTextItem(icon, title5, value$iv, $composer$iv5, 0, 0);
                                ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                                ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                                $composer$iv5.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                                ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                                ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                                $composer$iv5.endReplaceGroup();
                                $i$f$fastForEach2 = index$iv + 1;
                                $changed$iv$iv$iv5 = $changed$iv$iv$iv;
                                $composer$iv4 = $composer$iv;
                                $composer$iv$iv3 = $composer$iv$iv;
                                $composer$iv$iv$iv4 = $composer$iv$iv$iv;
                                size2 = i10;
                                $this$fastForEach$iv4 = $this$fastForEach$iv;
                                $changed$iv4 = $changed$iv;
                                localMap$iv$iv4 = localMap$iv$iv;
                                $composer$iv5 = $composer$iv2;
                                valid2 = valid;
                                str4 = str2;
                                str5 = str3;
                                $dirty3 = $dirty;
                            }
                            value$iv = new Function0() { // from class: kntr.app.pegasus.feedbackdialog.GridIconTextKt$$ExternalSyntheticLambda2
                                public final Object invoke() {
                                    Unit GridIconText$lambda$0$2$0$0$1$1$0$0;
                                    GridIconText$lambda$0$2$0$0$1$1$0$0 = GridIconTextKt.GridIconText$lambda$0$2$0$0$1$1$0$0(FeedbackItem.this, function1);
                                    return GridIconText$lambda$0$2$0$0$1$1$0$0;
                                }
                            };
                            $composer$iv5.updateRememberedValue(value$iv);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                            GridIconTextItem(icon, title5, value$iv, $composer$iv5, 0, 0);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                            $composer$iv5.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                            $composer$iv5.endReplaceGroup();
                            $i$f$fastForEach2 = index$iv + 1;
                            $changed$iv$iv$iv5 = $changed$iv$iv$iv;
                            $composer$iv4 = $composer$iv;
                            $composer$iv$iv3 = $composer$iv$iv;
                            $composer$iv$iv$iv4 = $composer$iv$iv$iv;
                            size2 = i10;
                            $this$fastForEach$iv4 = $this$fastForEach$iv;
                            $changed$iv4 = $changed$iv;
                            localMap$iv$iv4 = localMap$iv$iv;
                            $composer$iv5 = $composer$iv2;
                            valid2 = valid;
                            str4 = str2;
                            str5 = str3;
                            $dirty3 = $dirty;
                        }
                    } else {
                        localMap$iv$iv = localMap$iv$iv4;
                    }
                    z = false;
                    if (!z) {
                    }
                    $composer$iv5.startReplaceGroup(1011344396);
                    ComposerKt.sourceInformation($composer$iv5, "82@3346L821");
                    $composer$iv = $composer$iv4;
                    $changed$iv$iv$iv = $changed$iv$iv$iv5;
                    $composer$iv$iv = $composer$iv$iv3;
                    Modifier modifier$iv42 = SizeKt.heightIn-VpY3zN4$default(SizeKt.fillMaxHeight$default(RowScope.-CC.weight$default($this$GridIconText_u24lambda_u240_u242_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), 0.0f, 1, (Object) null), Dp.constructor-impl(67), 0.0f, 2, (Object) null);
                    Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                    $composer$iv$iv$iv = $composer$iv$iv$iv4;
                    ComposerKt.sourceInformationMarkerStart($composer$iv5, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv42 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                    int $changed$iv$iv42 = (48 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer$iv5, -1159599143, str4);
                    int compositeKeyHash$iv$iv42 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv5, 0));
                    CompositionLocalMap localMap$iv$iv52 = $composer$iv5.getCurrentCompositionLocalMap();
                    $composer$iv2 = $composer$iv5;
                    Modifier materialized$iv$iv52 = ComposedModifierKt.materializeModifier($composer$iv5, modifier$iv42);
                    Function0 factory$iv$iv$iv92 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv62 = (($changed$iv$iv42 << 6) & 896) | 6;
                    str2 = str4;
                    valid = valid2;
                    ComposerKt.sourceInformationMarkerStart($composer$iv5, -553112988, str5);
                    if (!($composer$iv5.getApplier() instanceof Applier)) {
                    }
                    $composer$iv5.startReusableNode();
                    if ($composer$iv5.getInserting()) {
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv42 = Updater.constructor-impl($composer$iv5);
                    str3 = str5;
                    index$iv = $i$f$fastForEach2;
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, measurePolicy$iv42, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, localMap$iv$iv52, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv42, Integer.valueOf(compositeKeyHash$iv$iv42), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv42, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, materialized$iv$iv52, ComposeUiNode.Companion.getSetModifier());
                    int i112 = ($changed$iv$iv$iv62 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer$iv5, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                    int i122 = ((48 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer$iv5, -205956813, "C93@3917L185,90@3745L392:GridIconText.kt#36vyx9");
                    String title52 = dataItem.getTitle();
                    ComposerKt.sourceInformationMarkerStart($composer$iv5, 270456193, "CC(remember):GridIconText.kt#9igjgp");
                    $dirty = $dirty3;
                    invalid$iv = $composer2.changed(dataItem) | (($dirty3 & 896) != 256);
                    it$iv = $composer$iv5.rememberedValue();
                    if (!invalid$iv) {
                        value$iv = it$iv;
                        ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                        GridIconTextItem(icon, title52, value$iv, $composer$iv5, 0, 0);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                        $composer$iv5.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                        $composer$iv5.endReplaceGroup();
                        $i$f$fastForEach2 = index$iv + 1;
                        $changed$iv$iv$iv5 = $changed$iv$iv$iv;
                        $composer$iv4 = $composer$iv;
                        $composer$iv$iv3 = $composer$iv$iv;
                        $composer$iv$iv$iv4 = $composer$iv$iv$iv;
                        size2 = i10;
                        $this$fastForEach$iv4 = $this$fastForEach$iv;
                        $changed$iv4 = $changed$iv;
                        localMap$iv$iv4 = localMap$iv$iv;
                        $composer$iv5 = $composer$iv2;
                        valid2 = valid;
                        str4 = str2;
                        str5 = str3;
                        $dirty3 = $dirty;
                    }
                    value$iv = new Function0() { // from class: kntr.app.pegasus.feedbackdialog.GridIconTextKt$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            Unit GridIconText$lambda$0$2$0$0$1$1$0$0;
                            GridIconText$lambda$0$2$0$0$1$1$0$0 = GridIconTextKt.GridIconText$lambda$0$2$0$0$1$1$0$0(FeedbackItem.this, function1);
                            return GridIconText$lambda$0$2$0$0$1$1$0$0;
                        }
                    };
                    $composer$iv5.updateRememberedValue(value$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                    GridIconTextItem(icon, title52, value$iv, $composer$iv5, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                    $composer$iv5.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                    $composer$iv5.endReplaceGroup();
                    $i$f$fastForEach2 = index$iv + 1;
                    $changed$iv$iv$iv5 = $changed$iv$iv$iv;
                    $composer$iv4 = $composer$iv;
                    $composer$iv$iv3 = $composer$iv$iv;
                    $composer$iv$iv$iv4 = $composer$iv$iv$iv;
                    size2 = i10;
                    $this$fastForEach$iv4 = $this$fastForEach$iv;
                    $changed$iv4 = $changed$iv;
                    localMap$iv$iv4 = localMap$iv$iv;
                    $composer$iv5 = $composer$iv2;
                    valid2 = valid;
                    str4 = str2;
                    str5 = str3;
                    $dirty3 = $dirty;
                }
                Composer $composer$iv$iv5 = $composer$iv$iv3;
                Composer $composer$iv6 = $composer$iv5;
                Composer $composer$iv7 = $composer$iv4;
                int $dirty4 = $dirty3;
                String str7 = str5;
                String str8 = str4;
                Composer $composer$iv$iv$iv6 = $composer$iv$iv$iv4;
                $composer$iv5.endReplaceGroup();
                $composer$iv5.startReplaceGroup(1394136867);
                ComposerKt.sourceInformation($composer$iv5, "*103@4307L339");
                int i13 = 4 - valid2;
                int i14 = 0;
                while (i14 < i13) {
                    Modifier modifier$iv5 = SizeKt.heightIn-VpY3zN4$default(SizeKt.fillMaxHeight$default(RowScope.-CC.weight$default($this$GridIconText_u24lambda_u240_u242_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), 0.0f, 1, (Object) null), Dp.constructor-impl(67), 0.0f, 2, (Object) null);
                    Alignment contentAlignment$iv3 = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart($composer$iv5, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv5 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
                    int $changed$iv$iv5 = (48 << 3) & 112;
                    String str9 = str8;
                    int i15 = i13;
                    ComposerKt.sourceInformationMarkerStart($composer$iv5, -1159599143, str9);
                    int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv5, 0));
                    CompositionLocalMap localMap$iv$iv6 = $composer$iv5.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer$iv5, modifier$iv5);
                    Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv7 = (($changed$iv$iv5 << 6) & 896) | 6;
                    String str10 = str7;
                    ComposerKt.sourceInformationMarkerStart($composer$iv5, -553112988, str10);
                    if (!($composer$iv5.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer$iv5.startReusableNode();
                    if ($composer$iv5.getInserting()) {
                        factory$iv$iv$iv4 = factory$iv$iv$iv10;
                        $composer$iv5.createNode(factory$iv$iv$iv4);
                    } else {
                        factory$iv$iv$iv4 = factory$iv$iv$iv10;
                        $composer$iv5.useNode();
                    }
                    str7 = str10;
                    Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer$iv5);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv6, ComposeUiNode.Companion.getSetModifier());
                    int i16 = ($changed$iv$iv$iv7 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer$iv5, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                    int i17 = ((48 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer$iv5, 1960771371, "C:GridIconText.kt#36vyx9");
                    ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                    $composer$iv5.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                    i14++;
                    str8 = str9;
                    i13 = i15;
                }
                $composer$iv5.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                ComposerKt.sourceInformationMarkerEnd($composer$iv6);
                $composer$iv$iv$iv6.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv6);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv5);
                ComposerKt.sourceInformationMarkerEnd($composer$iv7);
                $i$f$fastForEach = index$iv2 + 1;
                str4 = str8;
                size = i7;
                $changed$iv2 = $changed$iv3;
                $this$fastForEach$iv2 = $this$fastForEach$iv3;
                measurePolicy$iv$iv = measurePolicy$iv$iv2;
                z2 = z3;
                $changed$iv$iv$iv3 = $changed$iv$iv$iv4;
                materialized$iv$iv2 = materialized$iv$iv3;
                $composer$iv$iv2 = $composer$iv$iv4;
                $composer$iv3 = $composer$iv$iv$iv5;
                $composer$iv$iv$iv2 = $composer$iv$iv$iv3;
                $composer3 = $composer4;
                str5 = str7;
                $dirty3 = $dirty4;
            }
            Composer $composer5 = $composer3;
            Composer $composer$iv$iv$iv7 = $composer$iv$iv$iv2;
            $composer5.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            $composer$iv$iv$iv7.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv7);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            title2 = str;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final String str11 = title2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.pegasus.feedbackdialog.GridIconTextKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit GridIconText$lambda$1;
                    GridIconText$lambda$1 = GridIconTextKt.GridIconText$lambda$1(list, str11, function1, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return GridIconText$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GridIconText$lambda$0$2$0$0$1$1$0$0(FeedbackItem $dataItem, Function1 $onDismiss) {
        $dataItem.getOnClick().invoke($dataItem);
        $onDismiss.invoke($dataItem.getType());
        return Unit.INSTANCE;
    }

    public static final void GridIconTextItem(String icon, String text, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        String str;
        String str2;
        final Function0 onClick;
        Composer $composer2;
        String icon2;
        String text2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Unit unit;
        boolean z;
        boolean z2;
        Composer $composer3 = $composer.startRestartGroup(-353795146);
        ComposerKt.sourceInformation($composer3, "C(GridIconTextItem)N(icon,text,onClick)129@5001L6,131@5101L57,124@4858L1905:GridIconText.kt#36vyx9");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            str = icon;
        } else if (($changed & 6) == 0) {
            str = icon;
            $dirty |= $composer3.changed(str) ? 4 : 2;
        } else {
            str = icon;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            str2 = text;
        } else if (($changed & 48) == 0) {
            str2 = text;
            $dirty |= $composer3.changed(str2) ? 32 : 16;
        } else {
            str2 = text;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            onClick = function0;
        } else if (($changed & 384) == 0) {
            onClick = function0;
            $dirty |= $composer3.changedInstance(onClick) ? 256 : 128;
        } else {
            onClick = function0;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            String icon3 = i2 != 0 ? null : str;
            String text3 = i3 != 0 ? null : str2;
            if (i4 != 0) {
                onClick = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-353795146, $dirty2, -1, "kntr.app.pegasus.feedbackdialog.GridIconTextItem (GridIconText.kt:123)");
            }
            Modifier modifier = BackgroundKt.background-bw27NRU(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1_float-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)));
            ComposerKt.sourceInformationMarkerStart($composer3, -694707345, "CC(remember):GridIconText.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 896) == 256;
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.pegasus.feedbackdialog.GridIconTextKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit GridIconTextItem$lambda$0$0;
                        GridIconTextItem$lambda$0$0 = GridIconTextKt.GridIconTextItem$lambda$0$0(onClick);
                        return GridIconTextItem$lambda$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getTopCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            Function0 onClick2 = onClick;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            $composer2 = $composer3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i6 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -282396938, "C136@5224L1533:GridIconText.kt#36vyx9");
            Modifier modifier$iv2 = PaddingKt.padding-VpY3zN4(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(4), Dp.constructor-impl(8));
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-D5KLDUw(Dp.constructor-impl(4), Alignment.Companion.getTop());
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            int $changed$iv$iv2 = (438 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i8 = ((438 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 490811960, "C144@5546L818:GridIconText.kt#36vyx9");
            Modifier modifier$iv3 = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(32));
            Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv3 = (54 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer3.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i9 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            int i10 = ((54 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1897041238, "C:GridIconText.kt#36vyx9");
            float iconSize = Dp.constructor-impl(24);
            String it = icon3;
            String str3 = it;
            String str4 = !(str3 == null || StringsKt.isBlank(str3)) ? icon3 : null;
            if (str4 == null) {
                $composer3.startReplaceGroup(1897111668);
                $composer3.endReplaceGroup();
                icon2 = icon3;
                unit = null;
            } else {
                icon2 = icon3;
                $composer3.startReplaceGroup(1897111669);
                ComposerKt.sourceInformation($composer3, "*150@5785L525");
                String it2 = str4;
                $composer3.startReplaceGroup(-1601368013);
                ComposerKt.sourceInformation($composer3, "*153@5944L6");
                ImageRequest $this$GridIconTextItem_u24lambda_u241_u240_u240_u241_u240 = new ImageRequest(it2);
                $this$GridIconTextItem_u24lambda_u241_u240_u240_u241_u240.colorFilter(ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), 0, 2, (Object) null));
                ImmutableImageRequest build = $this$GridIconTextItem_u24lambda_u241_u240_u240_u241_u240.build();
                $composer3.endReplaceGroup();
                BiliImageKt.BiliImage(build, SizeKt.size-3ABfNKs(Modifier.Companion, iconSize), null, null, null, null, null, ComposableSingletons$GridIconTextKt.INSTANCE.getLambda$614336680$feedbackdialog_debug(), ComposableSingletons$GridIconTextKt.INSTANCE.m659getLambda$1476310754$feedbackdialog_debug(), $composer3, 113246256, 124);
                Unit unit2 = Unit.INSTANCE;
                $composer3.endReplaceGroup();
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                $composer3.startReplaceGroup(-1601353050);
                ComposerKt.sourceInformation($composer3, "163@6332L18");
                z = true;
                z2 = false;
                ImagePlaceholderKt.m673ImagePlaceholderIv8Zu3U(0L, $composer3, 0, 1);
                $composer3.endReplaceGroup();
            } else {
                z = true;
                z2 = false;
                $composer3.startReplaceGroup(-1601371960);
                $composer3.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            String it3 = text3;
            String str5 = it3;
            String it4 = !((str5 == null || StringsKt.isBlank(str5)) ? z : z2) ? text3 : null;
            if (it4 == null) {
                $composer3.startReplaceGroup(491646106);
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(491646107);
                ComposerKt.sourceInformation($composer3, "*168@6511L9,169@6564L6,166@6436L297");
                TextKt.Text-Nvy7gAk(it4, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 2, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT11(), $composer3, 0, 24960, 109562);
                Unit unit3 = Unit.INSTANCE;
                $composer3.endReplaceGroup();
                Unit unit4 = Unit.INSTANCE;
            }
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
            text2 = text3;
            onClick = onClick2;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            icon2 = str;
            text2 = str2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final String str6 = icon2;
            final String str7 = text2;
            final Function0 function02 = onClick;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.pegasus.feedbackdialog.GridIconTextKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit GridIconTextItem$lambda$2;
                    GridIconTextItem$lambda$2 = GridIconTextKt.GridIconTextItem$lambda$2(str6, str7, function02, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return GridIconTextItem$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GridIconTextItem$lambda$0$0(Function0 $onClick) {
        if ($onClick != null) {
            $onClick.invoke();
        }
        return Unit.INSTANCE;
    }
}