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
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconKt;
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
import androidx.compose.ui.graphics.painter.Painter;
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
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.ThemeDayNight;
import java.util.List;
import kntr.app.pegasus.feedbackdialog.model.FeedbackItem;
import kntr.app.pegasus.feedbackdialog.model.FeedbackItemType;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ListIconText.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a/\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0001¢\u0006\u0002\u0010\b\u001ae\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"ListIconText", "", "dataList", "", "Lkntr/app/pegasus/feedbackdialog/model/FeedbackItem;", "onDismiss", "Lkotlin/Function1;", "Lkntr/app/pegasus/feedbackdialog/model/FeedbackItemType;", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "SingleLineIconText", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "", "iconWidth", "Landroidx/compose/ui/unit/Dp;", "iconHeight", "title", "subtitle", "hasDivider", "", "hasLink", "SingleLineIconText-tw_glAc", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;FFLjava/lang/String;Ljava/lang/String;ZZLandroidx/compose/runtime/Composer;II)V", "feedbackdialog_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ListIconTextKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListIconText$lambda$1(List list, Function1 function1, int i, Composer composer, int i2) {
        ListIconText(list, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SingleLineIconText_tw_glAc$lambda$0(Modifier modifier, String str, float f, float f2, String str2, String str3, boolean z, boolean z2, int i, int i2, Composer composer, int i3) {
        m671SingleLineIconTexttw_glAc(modifier, str, f, f2, str2, str3, z, z2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SingleLineIconText_tw_glAc$lambda$2(Modifier modifier, String str, float f, float f2, String str2, String str3, boolean z, boolean z2, int i, int i2, Composer composer, int i3) {
        m671SingleLineIconTexttw_glAc(modifier, str, f, f2, str2, str3, z, z2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void ListIconText(final List<FeedbackItem> list, final Function1<? super FeedbackItemType, Unit> function1, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        int $dirty;
        boolean z;
        CompositionLocalMap localMap$iv$iv;
        boolean z2;
        boolean z3;
        String str;
        Intrinsics.checkNotNullParameter(list, "dataList");
        Intrinsics.checkNotNullParameter(function1, "onDismiss");
        Composer $composer2 = $composer.startRestartGroup(-1945731998);
        ComposerKt.sourceInformation($composer2, "C(ListIconText)N(dataList,onDismiss)44@1770L6,39@1623L1123:ListIconText.kt#36vyx9");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(list) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        if ($composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1945731998, $dirty2, -1, "kntr.app.pegasus.feedbackdialog.ListIconText (ListIconText.kt:38)");
            }
            Modifier modifier$iv = BackgroundKt.background-bw27NRU(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1_float-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)));
            boolean z4 = false;
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            boolean z5 = false;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -838458004, "C:ListIconText.kt#36vyx9");
            $composer2.startReplaceGroup(-581236082);
            ComposerKt.sourceInformation($composer2, "*63@2578L137,50@1996L734");
            List<FeedbackItem> $this$forEachIndexed$iv = list;
            boolean z6 = false;
            int index$iv = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv2 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Iterable $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                final FeedbackItem item = (FeedbackItem) item$iv;
                int index = index$iv;
                String title = item.getTitle();
                if (title == null || StringsKt.isBlank(title)) {
                    $dirty = $dirty2;
                    z = z6;
                    localMap$iv$iv = localMap$iv$iv2;
                    z2 = z4;
                    z3 = z5;
                } else {
                    String iconNight = item.getIconNight();
                    if (iconNight == null) {
                        z = z6;
                        $composer2.startReplaceGroup(-293859631);
                        $composer2.endReplaceGroup();
                        localMap$iv$iv = localMap$iv$iv2;
                        iconNight = null;
                    } else {
                        z = z6;
                        $composer2.startReplaceGroup(-293859630);
                        ComposerKt.sourceInformation($composer2, "*52@2094L13");
                        localMap$iv$iv = localMap$iv$iv2;
                        if (!(BiliTheme.INSTANCE.getDayNightTheme($composer2, BiliTheme.$stable) == ThemeDayNight.Night)) {
                            iconNight = null;
                        }
                        $composer2.endReplaceGroup();
                    }
                    if (iconNight != null) {
                        str = iconNight;
                    } else {
                        str = item.getIcon();
                    }
                    int $this$dp$iv = item.getIconWidth();
                    float f = Dp.constructor-impl($this$dp$iv);
                    int $this$dp$iv2 = item.getIconHeight();
                    float f2 = Dp.constructor-impl($this$dp$iv2);
                    String title2 = item.getTitle();
                    String subtitle = item.getSubtitle();
                    boolean z7 = index != list.size() - 1;
                    boolean hasLink = item.getType().getHasLink();
                    z2 = z4;
                    z3 = z5;
                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer2, -1117841824, "CC(remember):ListIconText.kt#9igjgp");
                    boolean invalid$iv = $composer2.changed(item) | (($dirty2 & 112) == 32);
                    Object it$iv = $composer2.rememberedValue();
                    if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                        $dirty = $dirty2;
                        Object value$iv = new Function0() { // from class: kntr.app.pegasus.feedbackdialog.ListIconTextKt$$ExternalSyntheticLambda2
                            public final Object invoke() {
                                Unit ListIconText$lambda$0$0$1$0;
                                ListIconText$lambda$0$0$1$0 = ListIconTextKt.ListIconText$lambda$0$0$1$0(FeedbackItem.this, function1);
                                return ListIconText$lambda$0$0$1$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    } else {
                        $dirty = $dirty2;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    m671SingleLineIconTexttw_glAc(ClickableKt.clickable-oSLSa3U$default(fillMaxWidth$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), str, f, f2, title2, subtitle, z7, hasLink, $composer2, 0, 0);
                }
                z4 = z2;
                z5 = z3;
                index$iv = index$iv2;
                $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                z6 = z;
                localMap$iv$iv2 = localMap$iv$iv;
                $dirty2 = $dirty;
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
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.pegasus.feedbackdialog.ListIconTextKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit ListIconText$lambda$1;
                    ListIconText$lambda$1 = ListIconTextKt.ListIconText$lambda$1(list, function1, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return ListIconText$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListIconText$lambda$0$0$1$0(FeedbackItem $item, Function1 $onDismiss) {
        $item.getOnClick().invoke($item);
        $onDismiss.invoke($item.getType());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:157:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0451  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0463  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x04e1  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x04ef  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x04f2  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x04f5  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0501  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0603  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x060f  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0615  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x06e5  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x06f3  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x06f6  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x06fa  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0706  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0796  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x07e9  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x080b  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0866  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0890  */
    /* renamed from: SingleLineIconText-tw_glAc  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m671SingleLineIconTexttw_glAc(Modifier modifier, String icon, float f, float f2, String title, String subtitle, boolean hasDivider, boolean hasLink, Composer $composer, final int $changed, final int i) {
        float f3;
        float f4;
        String title2;
        int $dirty;
        Composer $composer2;
        Modifier modifier2;
        String icon2;
        String subtitle2;
        boolean hasDivider2;
        boolean hasLink2;
        float f5;
        Function0 factory$iv$iv$iv;
        boolean invalid$iv;
        Function0 factory$iv$iv$iv2;
        String it;
        float f6;
        Function0 factory$iv$iv$iv3;
        String it2;
        Composer $composer3;
        Composer $composer4 = $composer.startRestartGroup(-80305145);
        ComposerKt.sourceInformation($composer4, "C(SingleLineIconText)N(modifier,icon,iconWidth:c#ui.unit.Dp,iconHeight:c#ui.unit.Dp,title,subtitle,hasDivider,hasLink)92@3228L2600:ListIconText.kt#36vyx9");
        int $dirty2 = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer4.changed(modifier) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer4.changed(icon) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty2 |= 384;
            f3 = f;
        } else if (($changed & 384) == 0) {
            f3 = f;
            $dirty2 |= $composer4.changed(f3) ? 256 : 128;
        } else {
            f3 = f;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
            f4 = f2;
        } else if (($changed & 3072) == 0) {
            f4 = f2;
            $dirty2 |= $composer4.changed(f4) ? 2048 : 1024;
        } else {
            f4 = f2;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty2 |= 24576;
            title2 = title;
        } else if (($changed & 24576) == 0) {
            title2 = title;
            $dirty2 |= $composer4.changed(title2) ? 16384 : 8192;
        } else {
            title2 = title;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty2 |= 196608;
        } else if (($changed & 196608) == 0) {
            $dirty2 |= $composer4.changed(subtitle) ? 131072 : 65536;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer4.changed(hasDivider) ? 1048576 : 524288;
        }
        int i9 = i & 128;
        if (i9 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer4.changed(hasLink) ? 8388608 : 4194304;
        }
        if ($composer4.shouldExecute(($dirty2 & 4793491) != 4793490, $dirty2 & 1)) {
            modifier2 = i2 != 0 ? (Modifier) Modifier.Companion : modifier;
            icon2 = i3 != 0 ? null : icon;
            if (i4 != 0) {
                f3 = Dp.constructor-impl(20);
            }
            if (i5 != 0) {
                f4 = Dp.constructor-impl(20);
            }
            if (i6 != 0) {
                title2 = null;
            }
            String subtitle3 = i7 != 0 ? null : subtitle;
            hasDivider2 = i8 != 0 ? false : hasDivider;
            hasLink2 = i9 != 0 ? false : hasLink;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-80305145, $dirty2, -1, "kntr.app.pegasus.feedbackdialog.SingleLineIconText (ListIconText.kt:90)");
            }
            String str = title2;
            if (str == null || StringsKt.isBlank(str)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer4.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier3 = modifier2;
                    final String str2 = icon2;
                    final float f7 = f3;
                    final float f8 = f4;
                    final String str3 = title2;
                    final String str4 = subtitle3;
                    final boolean z = hasDivider2;
                    final boolean z2 = hasLink2;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.pegasus.feedbackdialog.ListIconTextKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj, Object obj2) {
                            Unit SingleLineIconText_tw_glAc$lambda$0;
                            SingleLineIconText_tw_glAc$lambda$0 = ListIconTextKt.SingleLineIconText_tw_glAc$lambda$0(modifier3, str2, f7, f8, str3, str4, z, z2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return SingleLineIconText_tw_glAc$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
            $dirty = $dirty2;
            float f9 = f3;
            String subtitle4 = subtitle3;
            String title3 = title2;
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            int $changed$iv = ($dirty & 14) | 48;
            Modifier modifier$iv = modifier2;
            ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = ($changed$iv << 3) & 112;
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
            int i10 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i11 = (($changed$iv >> 6) & 112) | 6;
            BoxScope $this$SingleLineIconText_tw_glAc_u24lambda_u241 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, -1119662209, "C96@3337L55,97@3418L54,98@3481L1970:ListIconText.kt#36vyx9");
            ComposerKt.sourceInformationMarkerStart($composer4, -174667464, "CC(remember):ListIconText.kt#9igjgp");
            boolean invalid$iv2 = ($dirty & 896) == 256;
            Object it$iv = $composer4.rememberedValue();
            if (!invalid$iv2 && it$iv != Composer.Companion.getEmpty()) {
                float padding = ((Dp) it$iv).unbox-impl();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerStart($composer4, -174664873, "CC(remember):ListIconText.kt#9igjgp");
                invalid$iv = ($dirty & 896) != 256;
                Object it$iv2 = $composer4.rememberedValue();
                if (!invalid$iv && it$iv2 != Composer.Companion.getEmpty()) {
                    $composer2 = $composer4;
                    float innerSpace = ((Dp) it$iv2).unbox-impl();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    Modifier modifier$iv2 = PaddingKt.padding-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), padding);
                    Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(innerSpace);
                    ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                    int $changed$iv$iv2 = (384 << 3) & 112;
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
                        $composer4.useNode();
                    } else {
                        factory$iv$iv$iv2 = factory$iv$iv$iv5;
                        $composer4.createNode(factory$iv$iv$iv2);
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer4);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                    int i12 = ($changed$iv$iv$iv2 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    int i13 = ((384 >> 6) & 112) | 6;
                    RowScope $this$SingleLineIconText_tw_glAc_u24lambda_u241_u242 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer4, -506635522, "C116@4175L905:ListIconText.kt#36vyx9");
                    String str5 = icon2;
                    it = str5 != null || StringsKt.isBlank(str5) ? icon2 : null;
                    if (it != null) {
                        $composer4.startReplaceGroup(-506637694);
                        $composer4.endReplaceGroup();
                        f6 = f9;
                    } else {
                        $composer4.startReplaceGroup(-506637693);
                        ComposerKt.sourceInformation($composer4, "*104@3766L382");
                        String $this$asRequest_u24default$iv = it;
                        ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
                        Unit unit = Unit.INSTANCE;
                        f6 = f9;
                        BiliImageKt.BiliImage(imageRequest.build(), SizeKt.size-VpY3zN4(Modifier.Companion, f6, f4), null, null, null, null, null, ComposableSingletons$ListIconTextKt.INSTANCE.m664getLambda$2032547712$feedbackdialog_debug(), ComposableSingletons$ListIconTextKt.INSTANCE.m665getLambda$876498102$feedbackdialog_debug(), $composer4, 113246208, 124);
                        Unit unit2 = Unit.INSTANCE;
                        $composer4.endReplaceGroup();
                        Unit unit3 = Unit.INSTANCE;
                    }
                    Modifier modifier$iv3 = RowScope.-CC.weight$default($this$SingleLineIconText_tw_glAc_u24lambda_u241_u242, Modifier.Companion, 1.0f, false, 2, (Object) null);
                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getCenter();
                    Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                    f5 = f6;
                    float f10 = f4;
                    ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                    int $changed$iv$iv3 = (432 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                    CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
                    Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer4.startReusableNode();
                    if ($composer4.getInserting()) {
                        factory$iv$iv$iv3 = factory$iv$iv$iv6;
                        $composer4.useNode();
                    } else {
                        factory$iv$iv$iv3 = factory$iv$iv$iv6;
                        $composer4.createNode(factory$iv$iv$iv3);
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer4);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                    int i14 = ($changed$iv$iv$iv3 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                    int i15 = ((432 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1470869814, "C123@4454L9,124@4507L6,121@4376L250:ListIconText.kt#36vyx9");
                    TextKt.Text-Nvy7gAk(title3, (Modifier) null, BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT14(), $composer4, ($dirty >> 12) & 14, 24960, 110586);
                    String str6 = subtitle4;
                    it2 = str6 != null || StringsKt.isBlank(str6) ? subtitle4 : null;
                    if (it2 != null) {
                        $composer4.startReplaceGroup(-1470568062);
                        $composer4.endReplaceGroup();
                    } else {
                        $composer4.startReplaceGroup(-1470568061);
                        ComposerKt.sourceInformation($composer4, "*129@4716L40,132@4860L9,133@4917L6,130@4777L271");
                        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), $composer4, 6);
                        TextKt.Text-Nvy7gAk(it2, (Modifier) null, BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT12(), $composer4, 0, 24960, 110586);
                        Unit unit4 = Unit.INSTANCE;
                        $composer4.endReplaceGroup();
                        Unit unit5 = Unit.INSTANCE;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    if (hasLink2) {
                        $composer4.startReplaceGroup(-510365691);
                    } else {
                        $composer4.startReplaceGroup(-505289162);
                        ComposerKt.sourceInformation($composer4, "140@5124L39,142@5229L28,143@5296L6,141@5180L247");
                        SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer4, 6);
                        IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_forward_right_line_900($composer4, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText3-0d7_KjU(), $composer4, Painter.$stable | 432, 0);
                    }
                    $composer4.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    if (hasDivider2) {
                        $composer3 = $composer4;
                        $composer3.startReplaceGroup(-1123037087);
                    } else {
                        $composer3 = $composer4;
                        $composer3.startReplaceGroup(-1117580033);
                        ComposerKt.sourceInformation($composer3, "151@5543L6,150@5490L322");
                        DividerKt.HorizontalDivider-9IZ8Weo($this$SingleLineIconText_tw_glAc_u24lambda_u241.align(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(44), 0.0f, 0.0f, 0.0f, 14, (Object) null), Alignment.Companion.getBottomStart()), Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getLine_regular-0d7_KjU(), $composer3, 48, 0);
                    }
                    $composer3.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    subtitle2 = subtitle4;
                    title2 = title3;
                    f4 = f10;
                }
                $composer2 = $composer4;
                Object value$iv = Dp.box-impl(Dp.constructor-impl(Dp.constructor-impl(8) - Dp.constructor-impl(Dp.constructor-impl(f9 - Dp.constructor-impl(20)) / 2)));
                $composer4.updateRememberedValue(value$iv);
                it$iv2 = value$iv;
                float innerSpace2 = ((Dp) it$iv2).unbox-impl();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                Modifier modifier$iv22 = PaddingKt.padding-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), padding);
                Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.spacedBy-0680j_4(innerSpace2);
                ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv22 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                int $changed$iv$iv22 = (384 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv22 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv22 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv22 = ComposedModifierKt.materializeModifier($composer4, modifier$iv22);
                Function0 factory$iv$iv$iv52 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv22 = (($changed$iv$iv22 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv22 = Updater.constructor-impl($composer4);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, measurePolicy$iv22, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, localMap$iv$iv22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv22, Integer.valueOf(compositeKeyHash$iv$iv22), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv22, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, materialized$iv$iv22, ComposeUiNode.Companion.getSetModifier());
                int i122 = ($changed$iv$iv$iv22 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                int i132 = ((384 >> 6) & 112) | 6;
                RowScope $this$SingleLineIconText_tw_glAc_u24lambda_u241_u2422 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer4, -506635522, "C116@4175L905:ListIconText.kt#36vyx9");
                String str52 = icon2;
                if (str52 != null || StringsKt.isBlank(str52)) {
                }
                if (it != null) {
                }
                Modifier modifier$iv32 = RowScope.-CC.weight$default($this$SingleLineIconText_tw_glAc_u24lambda_u241_u2422, Modifier.Companion, 1.0f, false, 2, (Object) null);
                Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getCenter();
                Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
                f5 = f6;
                float f102 = f4;
                ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv32 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer4, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                int $changed$iv$iv32 = (432 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv32 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv32 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv32 = ComposedModifierKt.materializeModifier($composer4, modifier$iv32);
                Function0 factory$iv$iv$iv62 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv32 = (($changed$iv$iv32 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv32 = Updater.constructor-impl($composer4);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, measurePolicy$iv32, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, localMap$iv$iv32, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv32, Integer.valueOf(compositeKeyHash$iv$iv32), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv32, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, materialized$iv$iv32, ComposeUiNode.Companion.getSetModifier());
                int i142 = ($changed$iv$iv$iv32 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                int i152 = ((432 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -1470869814, "C123@4454L9,124@4507L6,121@4376L250:ListIconText.kt#36vyx9");
                TextKt.Text-Nvy7gAk(title3, (Modifier) null, BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT14(), $composer4, ($dirty >> 12) & 14, 24960, 110586);
                String str62 = subtitle4;
                if (str62 != null || StringsKt.isBlank(str62)) {
                }
                if (it2 != null) {
                }
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                if (hasLink2) {
                }
                $composer4.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                if (hasDivider2) {
                }
                $composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                if (ComposerKt.isTraceInProgress()) {
                }
                subtitle2 = subtitle4;
                title2 = title3;
                f4 = f102;
            }
            Object value$iv2 = Dp.box-impl(Dp.constructor-impl(Dp.constructor-impl(16) - Dp.constructor-impl(Dp.constructor-impl(f9 - Dp.constructor-impl(20)) / 2)));
            $composer4.updateRememberedValue(value$iv2);
            it$iv = value$iv2;
            float padding2 = ((Dp) it$iv).unbox-impl();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerStart($composer4, -174664873, "CC(remember):ListIconText.kt#9igjgp");
            if (($dirty & 896) != 256) {
            }
            Object it$iv22 = $composer4.rememberedValue();
            if (!invalid$iv) {
                $composer2 = $composer4;
                float innerSpace22 = ((Dp) it$iv22).unbox-impl();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                Modifier modifier$iv222 = PaddingKt.padding-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), padding2);
                Alignment.Vertical verticalAlignment$iv22 = Alignment.Companion.getCenterVertically();
                Arrangement.Horizontal horizontalArrangement$iv22 = Arrangement.INSTANCE.spacedBy-0680j_4(innerSpace22);
                ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv222 = RowKt.rowMeasurePolicy(horizontalArrangement$iv22, verticalAlignment$iv22, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                int $changed$iv$iv222 = (384 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv222 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv222 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv222 = ComposedModifierKt.materializeModifier($composer4, modifier$iv222);
                Function0 factory$iv$iv$iv522 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv222 = (($changed$iv$iv222 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv222 = Updater.constructor-impl($composer4);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv222, measurePolicy$iv222, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv222, localMap$iv$iv222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv222, Integer.valueOf(compositeKeyHash$iv$iv222), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv222, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv222, materialized$iv$iv222, ComposeUiNode.Companion.getSetModifier());
                int i1222 = ($changed$iv$iv$iv222 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                int i1322 = ((384 >> 6) & 112) | 6;
                RowScope $this$SingleLineIconText_tw_glAc_u24lambda_u241_u24222 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer4, -506635522, "C116@4175L905:ListIconText.kt#36vyx9");
                String str522 = icon2;
                if (str522 != null || StringsKt.isBlank(str522)) {
                }
                if (it != null) {
                }
                Modifier modifier$iv322 = RowScope.-CC.weight$default($this$SingleLineIconText_tw_glAc_u24lambda_u241_u24222, Modifier.Companion, 1.0f, false, 2, (Object) null);
                Arrangement.Vertical verticalArrangement$iv22 = Arrangement.INSTANCE.getCenter();
                Alignment.Horizontal horizontalAlignment$iv22 = Alignment.Companion.getStart();
                f5 = f6;
                float f1022 = f4;
                ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv322 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv22, horizontalAlignment$iv22, $composer4, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                int $changed$iv$iv322 = (432 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv322 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv322 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv322 = ComposedModifierKt.materializeModifier($composer4, modifier$iv322);
                Function0 factory$iv$iv$iv622 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv322 = (($changed$iv$iv322 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv322 = Updater.constructor-impl($composer4);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv322, measurePolicy$iv322, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv322, localMap$iv$iv322, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv322, Integer.valueOf(compositeKeyHash$iv$iv322), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv322, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv322, materialized$iv$iv322, ComposeUiNode.Companion.getSetModifier());
                int i1422 = ($changed$iv$iv$iv322 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope22 = ColumnScopeInstance.INSTANCE;
                int i1522 = ((432 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -1470869814, "C123@4454L9,124@4507L6,121@4376L250:ListIconText.kt#36vyx9");
                TextKt.Text-Nvy7gAk(title3, (Modifier) null, BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT14(), $composer4, ($dirty >> 12) & 14, 24960, 110586);
                String str622 = subtitle4;
                if (str622 != null || StringsKt.isBlank(str622)) {
                }
                if (it2 != null) {
                }
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                if (hasLink2) {
                }
                $composer4.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                if (hasDivider2) {
                }
                $composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                if (ComposerKt.isTraceInProgress()) {
                }
                subtitle2 = subtitle4;
                title2 = title3;
                f4 = f1022;
            }
            $composer2 = $composer4;
            Object value$iv3 = Dp.box-impl(Dp.constructor-impl(Dp.constructor-impl(8) - Dp.constructor-impl(Dp.constructor-impl(f9 - Dp.constructor-impl(20)) / 2)));
            $composer4.updateRememberedValue(value$iv3);
            it$iv22 = value$iv3;
            float innerSpace222 = ((Dp) it$iv22).unbox-impl();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier modifier$iv2222 = PaddingKt.padding-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), padding2);
            Alignment.Vertical verticalAlignment$iv222 = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv222 = Arrangement.INSTANCE.spacedBy-0680j_4(innerSpace222);
            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2222 = RowKt.rowMeasurePolicy(horizontalArrangement$iv222, verticalAlignment$iv222, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv2222 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2222 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv2222 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2222 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2222);
            Function0 factory$iv$iv$iv5222 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2222 = (($changed$iv$iv2222 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2222 = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2222, measurePolicy$iv2222, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2222, localMap$iv$iv2222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2222, Integer.valueOf(compositeKeyHash$iv$iv2222), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2222, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2222, materialized$iv$iv2222, ComposeUiNode.Companion.getSetModifier());
            int i12222 = ($changed$iv$iv$iv2222 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i13222 = ((384 >> 6) & 112) | 6;
            RowScope $this$SingleLineIconText_tw_glAc_u24lambda_u241_u242222 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, -506635522, "C116@4175L905:ListIconText.kt#36vyx9");
            String str5222 = icon2;
            if (str5222 != null || StringsKt.isBlank(str5222)) {
            }
            if (it != null) {
            }
            Modifier modifier$iv3222 = RowScope.-CC.weight$default($this$SingleLineIconText_tw_glAc_u24lambda_u241_u242222, Modifier.Companion, 1.0f, false, 2, (Object) null);
            Arrangement.Vertical verticalArrangement$iv222 = Arrangement.INSTANCE.getCenter();
            Alignment.Horizontal horizontalAlignment$iv222 = Alignment.Companion.getStart();
            f5 = f6;
            float f10222 = f4;
            ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv3222 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv222, horizontalAlignment$iv222, $composer4, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv3222 = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3222 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv3222 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3222 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3222);
            Function0 factory$iv$iv$iv6222 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3222 = (($changed$iv$iv3222 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3222 = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3222, measurePolicy$iv3222, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3222, localMap$iv$iv3222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3222, Integer.valueOf(compositeKeyHash$iv$iv3222), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3222, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3222, materialized$iv$iv3222, ComposeUiNode.Companion.getSetModifier());
            int i14222 = ($changed$iv$iv$iv3222 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope222 = ColumnScopeInstance.INSTANCE;
            int i15222 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -1470869814, "C123@4454L9,124@4507L6,121@4376L250:ListIconText.kt#36vyx9");
            TextKt.Text-Nvy7gAk(title3, (Modifier) null, BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT14(), $composer4, ($dirty >> 12) & 14, 24960, 110586);
            String str6222 = subtitle4;
            if (str6222 != null || StringsKt.isBlank(str6222)) {
            }
            if (it2 != null) {
            }
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (hasLink2) {
            }
            $composer4.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (hasDivider2) {
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (ComposerKt.isTraceInProgress()) {
            }
            subtitle2 = subtitle4;
            title2 = title3;
            f4 = f10222;
        } else {
            $dirty = $dirty2;
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            icon2 = icon;
            subtitle2 = subtitle;
            hasDivider2 = hasDivider;
            hasLink2 = hasLink;
            f5 = f3;
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier4 = modifier2;
            final String str7 = icon2;
            final float f11 = f5;
            final float f12 = f4;
            final String str8 = title2;
            final String str9 = subtitle2;
            final boolean z3 = hasDivider2;
            final boolean z4 = hasLink2;
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.pegasus.feedbackdialog.ListIconTextKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit SingleLineIconText_tw_glAc$lambda$2;
                    SingleLineIconText_tw_glAc$lambda$2 = ListIconTextKt.SingleLineIconText_tw_glAc$lambda$2(modifier4, str7, f11, f12, str8, str9, z3, z4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SingleLineIconText_tw_glAc$lambda$2;
                }
            });
        }
    }
}