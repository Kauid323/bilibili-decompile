package kntr.app.upcomingEpisode.calendar.ui;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
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
import com.bapis.bilibili.community.interfacess.watch.v1.KCalendarPointType;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.base.handler.CalendarType;
import kntr.app.upcomingEpisode.calendar.utils.BiliCalendarExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDate;

/* compiled from: BiliCalendarDayContent.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a[\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"BiliCalendarDayContent", "", "date", "Lkotlinx/datetime/LocalDate;", "isSelected", "", "modifier", "Landroidx/compose/ui/Modifier;", "pointType", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KCalendarPointType;", "noBackground", "onClick", "Lkotlin/Function1;", "calendarMode", "Lkntr/app/upcomingEpisode/base/handler/CalendarType;", "(Lkotlinx/datetime/LocalDate;ZLandroidx/compose/ui/Modifier;Lcom/bapis/bilibili/community/interfacess/watch/v1/KCalendarPointType;ZLkotlin/jvm/functions/Function1;Lkntr/app/upcomingEpisode/base/handler/CalendarType;Landroidx/compose/runtime/Composer;II)V", "main_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BiliCalendarDayContentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BiliCalendarDayContent$lambda$3(LocalDate localDate, boolean z, Modifier modifier, KCalendarPointType kCalendarPointType, boolean z2, Function1 function1, CalendarType calendarType, int i, int i2, Composer composer, int i3) {
        BiliCalendarDayContent(localDate, z, modifier, kCalendarPointType, z2, function1, calendarType, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BiliCalendarDayContent$lambda$0$0(LocalDate it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v7 */
    public static final void BiliCalendarDayContent(final LocalDate date, final boolean isSelected, Modifier modifier, KCalendarPointType pointType, boolean noBackground, Function1<? super LocalDate, Unit> function1, CalendarType calendarMode, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        KCalendarPointType kCalendarPointType;
        boolean noBackground2;
        final Function1 onClick;
        Composer $composer2;
        CalendarType calendarMode2;
        Modifier modifier3;
        KCalendarPointType pointType2;
        boolean noBackground3;
        Function1 onClick2;
        Modifier modifier4;
        KCalendarPointType pointType3;
        CalendarType calendarMode3;
        long j;
        Modifier modifier5;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        TextStyle textStyle;
        long j2;
        long j3;
        long j4;
        long j5;
        int i2;
        Intrinsics.checkNotNullParameter(date, "date");
        Composer $composer3 = $composer.startRestartGroup(1652202305);
        ComposerKt.sourceInformation($composer3, "C(BiliCalendarDayContent)N(date,isSelected,modifier,pointType,noBackground,onClick,calendarMode)67@2705L17,40@1640L3754:BiliCalendarDayContent.kt#4t4v7p");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(date) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(isSelected) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                kCalendarPointType = pointType;
                if ($composer3.changedInstance(kCalendarPointType)) {
                    i2 = 2048;
                    $dirty |= i2;
                }
            } else {
                kCalendarPointType = pointType;
            }
            i2 = 1024;
            $dirty |= i2;
        } else {
            kCalendarPointType = pointType;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= 24576;
            noBackground2 = noBackground;
        } else if (($changed & 24576) == 0) {
            noBackground2 = noBackground;
            $dirty |= $composer3.changed(noBackground2) ? 16384 : 8192;
        } else {
            noBackground2 = noBackground;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty |= 196608;
            onClick = function1;
        } else if ((196608 & $changed) == 0) {
            onClick = function1;
            $dirty |= $composer3.changedInstance(onClick) ? 131072 : 65536;
        } else {
            onClick = function1;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer3.changed(calendarMode == null ? -1 : calendarMode.ordinal()) ? 1048576 : 524288;
        }
        if ($composer3.shouldExecute((599187 & $dirty) != 599186, $dirty & 1)) {
            $composer3.startDefaults();
            ComposerKt.sourceInformation($composer3, "36@1564L2");
            if (($changed & 1) != 0 && !$composer3.getDefaultsInvalid()) {
                $composer3.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                modifier4 = modifier2;
                pointType3 = kCalendarPointType;
                calendarMode3 = calendarMode;
            } else {
                if (i3 != 0) {
                    modifier4 = (Modifier) Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 8) == 0) {
                    pointType3 = kCalendarPointType;
                } else {
                    pointType3 = (KCalendarPointType) KCalendarPointType.CALENDAR_POINT_TYPE_DEFAULT.INSTANCE;
                    $dirty &= -7169;
                }
                if (i4 != 0) {
                    noBackground2 = true;
                }
                if (i5 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer3, -1371476029, "CC(remember):BiliCalendarDayContent.kt#9igjgp");
                    Object it$iv = $composer3.rememberedValue();
                    if (it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = new Function1() { // from class: kntr.app.upcomingEpisode.calendar.ui.BiliCalendarDayContentKt$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                Unit BiliCalendarDayContent$lambda$0$0;
                                BiliCalendarDayContent$lambda$0$0 = BiliCalendarDayContentKt.BiliCalendarDayContent$lambda$0$0((LocalDate) obj);
                                return BiliCalendarDayContent$lambda$0$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    Function1 onClick3 = it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    onClick = onClick3;
                }
                if (i6 == 0) {
                    calendarMode3 = calendarMode;
                } else {
                    calendarMode3 = CalendarType.WEEK;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1652202305, $dirty, -1, "kntr.app.upcomingEpisode.calendar.ui.BiliCalendarDayContent (BiliCalendarDayContent.kt:38)");
            }
            Modifier modifier6 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), Dp.constructor-impl(44));
            if (isSelected && BiliCalendarExtensionsKt.isNow(date)) {
                $composer3.startReplaceGroup(434229070);
                ComposerKt.sourceInformation($composer3, "48@1917L6");
                j = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(434322473);
                ComposerKt.sourceInformation($composer3, "");
                if (noBackground2) {
                    $composer3.startReplaceGroup(434365005);
                    ComposerKt.sourceInformation($composer3, "51@2058L6");
                    j = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg2-0d7_KjU();
                    $composer3.endReplaceGroup();
                } else {
                    $composer3.startReplaceGroup(434454285);
                    ComposerKt.sourceInformation($composer3, "53@2148L6");
                    j = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1-0d7_KjU();
                    $composer3.endReplaceGroup();
                }
                $composer3.endReplaceGroup();
            }
            Modifier modifier7 = BackgroundKt.background-bw27NRU(modifier6, j, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)));
            if (isSelected && !BiliCalendarExtensionsKt.isNow(date)) {
                $composer3.startReplaceGroup(434700983);
                ComposerKt.sourceInformation($composer3, "61@2485L6");
                modifier3 = modifier4;
                modifier5 = BorderKt.border-xT4_qwU(Modifier.Companion, Dp.constructor-impl(1), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)));
                $composer3.endReplaceGroup();
            } else {
                modifier3 = modifier4;
                $composer3.startReplaceGroup(434964297);
                $composer3.endReplaceGroup();
                modifier5 = Modifier.Companion;
            }
            Modifier then = modifier7.then(modifier5);
            ComposerKt.sourceInformationMarkerStart($composer3, -1371439502, "CC(remember):BiliCalendarDayContent.kt#9igjgp");
            boolean invalid$iv = ((458752 & $dirty) == 131072) | $composer3.changedInstance(date);
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.app.upcomingEpisode.calendar.ui.BiliCalendarDayContentKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit BiliCalendarDayContent$lambda$1$0;
                        BiliCalendarDayContent$lambda$1$0 = BiliCalendarDayContentKt.BiliCalendarDayContent$lambda$1$0(onClick, date);
                        return BiliCalendarDayContent$lambda$1$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(then, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            onClick2 = onClick;
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
            $composer2 = $composer3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i8 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1119728029, "C70@2785L2603:BiliCalendarDayContent.kt#4t4v7p");
            Modifier modifier$iv2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i9 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i10 = ((390 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1098033396, "C74@2928L40,76@3001L1107,105@4121L48:BiliCalendarDayContent.kt#4t4v7p");
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer3, 6);
            String valueOf = String.valueOf(date.getDayOfMonth());
            if (BiliCalendarExtensionsKt.isNow(date)) {
                $composer3.startReplaceGroup(-1097916651);
                ComposerKt.sourceInformation($composer3, "80@3156L9");
                TextStyle t11b = BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT11b();
                $composer3.endReplaceGroup();
                textStyle = t11b;
            } else {
                $composer3.startReplaceGroup(-1097839306);
                ComposerKt.sourceInformation($composer3, "82@3234L9");
                TextStyle t11 = BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT11();
                $composer3.endReplaceGroup();
                textStyle = t11;
            }
            if (BiliCalendarExtensionsKt.isNow(date)) {
                $composer3.startReplaceGroup(-1097697357);
                ComposerKt.sourceInformation($composer3, "");
                if (isSelected) {
                    $composer3.startReplaceGroup(-1097618710);
                    ComposerKt.sourceInformation($composer3, "88@3460L6");
                    j5 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_white-0d7_KjU();
                    $composer3.endReplaceGroup();
                } else {
                    $composer3.startReplaceGroup(-1097528903);
                    ComposerKt.sourceInformation($composer3, "91@3598L6");
                    j5 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                    $composer3.endReplaceGroup();
                }
                $composer3.endReplaceGroup();
                j3 = j5;
            } else {
                $composer3.startReplaceGroup(-1097361131);
                ComposerKt.sourceInformation($composer3, "");
                if (calendarMode3 == CalendarType.MONTH) {
                    $composer3.startReplaceGroup(-1097300991);
                    ComposerKt.sourceInformation($composer3, "");
                    if (noBackground2) {
                        $composer3.startReplaceGroup(-1097258521);
                        ComposerKt.sourceInformation($composer3, "96@3827L6");
                        j2 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU();
                        $composer3.endReplaceGroup();
                    } else {
                        $composer3.startReplaceGroup(-1097167257);
                        ComposerKt.sourceInformation($composer3, "98@3919L6");
                        j2 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU();
                        $composer3.endReplaceGroup();
                    }
                    $composer3.endReplaceGroup();
                } else {
                    $composer3.startReplaceGroup(-1097050449);
                    ComposerKt.sourceInformation($composer3, "101@4033L6");
                    j2 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU();
                    $composer3.endReplaceGroup();
                }
                $composer3.endReplaceGroup();
                j3 = j2;
            }
            TextKt.Text-Nvy7gAk(valueOf, (Modifier) null, j3, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, textStyle, $composer3, 0, 0, 131066);
            calendarMode2 = calendarMode3;
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(14)), $composer3, 6);
            if (BiliCalendarExtensionsKt.isDefault(pointType3)) {
                pointType2 = pointType3;
                $composer3.startReplaceGroup(-1101014915);
            } else {
                $composer3.startReplaceGroup(-1096777370);
                ComposerKt.sourceInformation($composer3, "108@4253L1111");
                Modifier modifier8 = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(3));
                if (isSelected && BiliCalendarExtensionsKt.isNow(date)) {
                    $composer3.startReplaceGroup(-1096456303);
                    ComposerKt.sourceInformation($composer3, "116@4643L6");
                    j4 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGraph_white-0d7_KjU();
                    $composer3.endReplaceGroup();
                } else {
                    $composer3.startReplaceGroup(-1096235645);
                    ComposerKt.sourceInformation($composer3, "");
                    if (Intrinsics.areEqual(pointType3, KCalendarPointType.CALENDAR_POINT_TYPE_RED.INSTANCE)) {
                        $composer3.startReplaceGroup(-866642769);
                        ComposerKt.sourceInformation($composer3, "120@4924L6");
                        j4 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                        $composer3.endReplaceGroup();
                    } else if (Intrinsics.areEqual(pointType3, KCalendarPointType.CALENDAR_POINT_TYPE_GRAY.INSTANCE)) {
                        $composer3.startReplaceGroup(-866638961);
                        ComposerKt.sourceInformation($composer3, "121@5043L6");
                        j4 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGraph_weak-0d7_KjU();
                        $composer3.endReplaceGroup();
                    } else {
                        $composer3.startReplaceGroup(-866636400);
                        ComposerKt.sourceInformation($composer3, "122@5123L6");
                        j4 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGraph_white-0d7_KjU();
                        $composer3.endReplaceGroup();
                    }
                    $composer3.endReplaceGroup();
                }
                pointType2 = pointType3;
                BoxKt.Box(BackgroundKt.background-bw27NRU(modifier8, j4, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(1))), $composer3, 0);
            }
            $composer3.endReplaceGroup();
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
            noBackground3 = noBackground2;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            calendarMode2 = calendarMode;
            modifier3 = modifier2;
            pointType2 = kCalendarPointType;
            noBackground3 = noBackground2;
            onClick2 = onClick;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier9 = modifier3;
            final KCalendarPointType kCalendarPointType2 = pointType2;
            final boolean z = noBackground3;
            final Function1 function12 = onClick2;
            final CalendarType calendarType = calendarMode2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.upcomingEpisode.calendar.ui.BiliCalendarDayContentKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit BiliCalendarDayContent$lambda$3;
                    BiliCalendarDayContent$lambda$3 = BiliCalendarDayContentKt.BiliCalendarDayContent$lambda$3(date, isSelected, modifier9, kCalendarPointType2, z, function12, calendarType, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return BiliCalendarDayContent$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BiliCalendarDayContent$lambda$1$0(Function1 $onClick, LocalDate $date) {
        $onClick.invoke($date);
        return Unit.INSTANCE;
    }
}