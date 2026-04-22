package kntr.base.localization.preview;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.activity.OnBackPressedDispatcher;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
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
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextFieldDefaults;
import androidx.compose.material3.TextFieldKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.lib.brouter.uri.Uri;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.localization.DateTimeFormatKt;
import kntr.base.localization.NumberFormatKt;
import kntr.base.router.Router;
import kntr.common.router.RouterKt;
import kntr.common.trio.pagecontroller.LocalOnBackPressedDispatcher;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.datetime.Clock;
import kotlinx.datetime.Instant;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.LocalDateKt;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.base.localization.preview.generated.resources.Res;
import srcs.base.localization.preview.generated.resources.String0_commonMainKt;

/* compiled from: LocalizationPreviewPage.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\u0017\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u0006\u001a\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002\u001a\u0017\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u0006\u001a\u0017\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u0006\u001a'\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u0012\u001a2\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0017H\u0003¢\u0006\u0002\u0010\u0018\u001a\u001f\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u001a\u001a\u0017\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u0006\"\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001c²\u0006\n\u0010\u001d\u001a\u00020\bX\u008a\u008e\u0002²\u0006\n\u0010\u001d\u001a\u00020\bX\u008a\u008e\u0002"}, d2 = {"LocalizationPreview", "", "(Landroidx/compose/runtime/Composer;I)V", "LocalizationInfo", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "NUMBER_FORMAT_DEFAULT", "", "generateTimeTestCases", "", "Lkntr/base/localization/preview/TimeTestCase;", "NumberFormat", "DateTimeFormat", "InfoItem", "key", "", "value", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "PreviewColumn", "title", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TopBar", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "BackIcon", "preview_debug", "text"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LocalizationPreviewPageKt {
    private static final String NUMBER_FORMAT_DEFAULT = "1234567890";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackIcon$lambda$2(Modifier modifier, int i, int i2, Composer composer, int i3) {
        BackIcon(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateTimeFormat$lambda$7(Modifier modifier, int i, int i2, Composer composer, int i3) {
        DateTimeFormat(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InfoItem$lambda$3(Object obj, Object obj2, Modifier modifier, int i, int i2, Composer composer, int i3) {
        InfoItem(obj, obj2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LocalizationInfo$lambda$0(Modifier modifier, int i, int i2, Composer composer, int i3) {
        LocalizationInfo(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LocalizationPreview$lambda$0(int i, Composer composer, int i2) {
        LocalizationPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NumberFormat$lambda$5(Modifier modifier, int i, int i2, Composer composer, int i3) {
        NumberFormat(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewColumn$lambda$1(String str, Modifier modifier, Function2 function2, int i, int i2, Composer composer, int i3) {
        PreviewColumn(str, modifier, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopBar$lambda$1(String str, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TopBar(str, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void LocalizationPreview(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(897651720);
        ComposerKt.sourceInformation($composer2, "C(LocalizationPreview)78@3620L363:LocalizationPreviewPage.kt#3k1zvn");
        if (!$composer2.shouldExecute($changed != 0, $changed & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(897651720, $changed, -1, "kntr.base.localization.preview.LocalizationPreview (LocalizationPreviewPage.kt:77)");
            }
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableSingletons$LocalizationPreviewPageKt.INSTANCE.m1635getLambda$1383794864$preview_debug(), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2) {
                    Unit LocalizationPreview$lambda$0;
                    LocalizationPreview$lambda$0 = LocalizationPreviewPageKt.LocalizationPreview$lambda$0($changed, (Composer) obj, ((Integer) obj2).intValue());
                    return LocalizationPreview$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LocalizationInfo(final Modifier modifier, Composer $composer, final int $changed, final int i) {
        Composer $composer2 = $composer.startRestartGroup(-2099523733);
        ComposerKt.sourceInformation($composer2, "C(LocalizationInfo)N(modifier)93@4102L38,93@4080L720:LocalizationPreviewPage.kt#3k1zvn");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2099523733, $dirty2, -1, "kntr.base.localization.preview.LocalizationInfo (LocalizationPreviewPage.kt:92)");
            }
            PreviewColumn(StringResourcesKt.stringResource(String0_commonMainKt.getInfo_column(Res.string.INSTANCE), $composer2, 0), modifier, ComposableSingletons$LocalizationPreviewPageKt.INSTANCE.getLambda$6839932$preview_debug(), $composer2, (($dirty2 << 3) & 112) | 384, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda35
                public final Object invoke(Object obj, Object obj2) {
                    Unit LocalizationInfo$lambda$0;
                    LocalizationInfo$lambda$0 = LocalizationPreviewPageKt.LocalizationInfo$lambda$0(modifier, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return LocalizationInfo$lambda$0;
                }
            });
        }
    }

    private static final List<TimeTestCase> generateTimeTestCases() {
        final TimeZone timezone = TimeZone.Companion.currentSystemDefault();
        return CollectionsKt.listOf(new TimeTestCase[]{new TimeTestCase("刚刚", new Function0() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda37
            public final Object invoke() {
                long generateTimeTestCases$lambda$0;
                generateTimeTestCases$lambda$0 = LocalizationPreviewPageKt.generateTimeTestCases$lambda$0();
                return Long.valueOf(generateTimeTestCases$lambda$0);
            }
        }, "1分钟以内"), new TimeTestCase("1分钟前", new Function0() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda0
            public final Object invoke() {
                long generateTimeTestCases$lambda$1;
                generateTimeTestCases$lambda$1 = LocalizationPreviewPageKt.generateTimeTestCases$lambda$1();
                return Long.valueOf(generateTimeTestCases$lambda$1);
            }
        }, "[1分钟, 2分钟)"), new TimeTestCase("8分钟前", new Function0() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda1
            public final Object invoke() {
                long generateTimeTestCases$lambda$2;
                generateTimeTestCases$lambda$2 = LocalizationPreviewPageKt.generateTimeTestCases$lambda$2();
                return Long.valueOf(generateTimeTestCases$lambda$2);
            }
        }, "[2分钟, 60分钟)"), new TimeTestCase("1小时前", new Function0() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda2
            public final Object invoke() {
                long generateTimeTestCases$lambda$3;
                generateTimeTestCases$lambda$3 = LocalizationPreviewPageKt.generateTimeTestCases$lambda$3();
                return Long.valueOf(generateTimeTestCases$lambda$3);
            }
        }, "[1小时, 2小时)"), new TimeTestCase("8小时前", new Function0() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda3
            public final Object invoke() {
                long generateTimeTestCases$lambda$4;
                generateTimeTestCases$lambda$4 = LocalizationPreviewPageKt.generateTimeTestCases$lambda$4();
                return Long.valueOf(generateTimeTestCases$lambda$4);
            }
        }, "[2小时, 24小时)"), new TimeTestCase("昨天", new Function0() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda4
            public final Object invoke() {
                long generateTimeTestCases$lambda$5;
                generateTimeTestCases$lambda$5 = LocalizationPreviewPageKt.generateTimeTestCases$lambda$5();
                return Long.valueOf(generateTimeTestCases$lambda$5);
            }
        }, "昨天 xx:xx"), new TimeTestCase("1天前", new Function0() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda5
            public final Object invoke() {
                long generateTimeTestCases$lambda$6;
                generateTimeTestCases$lambda$6 = LocalizationPreviewPageKt.generateTimeTestCases$lambda$6();
                return Long.valueOf(generateTimeTestCases$lambda$6);
            }
        }, "[1天前0点, 2天前0点)"), new TimeTestCase("3天前", new Function0() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda6
            public final Object invoke() {
                long generateTimeTestCases$lambda$7;
                generateTimeTestCases$lambda$7 = LocalizationPreviewPageKt.generateTimeTestCases$lambda$7();
                return Long.valueOf(generateTimeTestCases$lambda$7);
            }
        }, "[2天前0点，自然日3天前0点)"), new TimeTestCase("同年早期", new Function0() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda7
            public final Object invoke() {
                long generateTimeTestCases$lambda$8;
                generateTimeTestCases$lambda$8 = LocalizationPreviewPageKt.generateTimeTestCases$lambda$8(timezone);
                return Long.valueOf(generateTimeTestCases$lambda$8);
            }
        }, "当年内日期格式"), new TimeTestCase("跨年", new Function0() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda8
            public final Object invoke() {
                long generateTimeTestCases$lambda$9;
                generateTimeTestCases$lambda$9 = LocalizationPreviewPageKt.generateTimeTestCases$lambda$9(timezone);
                return Long.valueOf(generateTimeTestCases$lambda$9);
            }
        }, "跨年日期格式"), new TimeTestCase("今天", new Function0() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda38
            public final Object invoke() {
                long generateTimeTestCases$lambda$10;
                generateTimeTestCases$lambda$10 = LocalizationPreviewPageKt.generateTimeTestCases$lambda$10();
                return Long.valueOf(generateTimeTestCases$lambda$10);
            }
        }, "今天未来时间"), new TimeTestCase("明天", new Function0() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda39
            public final Object invoke() {
                long generateTimeTestCases$lambda$11;
                generateTimeTestCases$lambda$11 = LocalizationPreviewPageKt.generateTimeTestCases$lambda$11();
                return Long.valueOf(generateTimeTestCases$lambda$11);
            }
        }, "明天时间"), new TimeTestCase("未来同年", new Function0() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda40
            public final Object invoke() {
                long generateTimeTestCases$lambda$12;
                generateTimeTestCases$lambda$12 = LocalizationPreviewPageKt.generateTimeTestCases$lambda$12(timezone);
                return Long.valueOf(generateTimeTestCases$lambda$12);
            }
        }, "未来同年时间"), new TimeTestCase("未来跨年", new Function0() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda41
            public final Object invoke() {
                long generateTimeTestCases$lambda$13;
                generateTimeTestCases$lambda$13 = LocalizationPreviewPageKt.generateTimeTestCases$lambda$13(timezone);
                return Long.valueOf(generateTimeTestCases$lambda$13);
            }
        }, "未来跨年时间")});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long generateTimeTestCases$lambda$0() {
        Instant now = Clock.System.INSTANCE.now();
        Duration.Companion companion = Duration.Companion;
        return now.minus-LRDsOJo(DurationKt.toDuration(30, DurationUnit.SECONDS)).toEpochMilliseconds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long generateTimeTestCases$lambda$1() {
        Instant now = Clock.System.INSTANCE.now();
        Duration.Companion companion = Duration.Companion;
        return now.minus-LRDsOJo(DurationKt.toDuration(1, DurationUnit.MINUTES)).toEpochMilliseconds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long generateTimeTestCases$lambda$2() {
        Instant now = Clock.System.INSTANCE.now();
        Duration.Companion companion = Duration.Companion;
        return now.minus-LRDsOJo(DurationKt.toDuration(8, DurationUnit.MINUTES)).toEpochMilliseconds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long generateTimeTestCases$lambda$3() {
        Instant now = Clock.System.INSTANCE.now();
        Duration.Companion companion = Duration.Companion;
        return now.minus-LRDsOJo(DurationKt.toDuration(1, DurationUnit.HOURS)).toEpochMilliseconds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long generateTimeTestCases$lambda$4() {
        Instant now = Clock.System.INSTANCE.now();
        Duration.Companion companion = Duration.Companion;
        return now.minus-LRDsOJo(DurationKt.toDuration(8, DurationUnit.HOURS)).toEpochMilliseconds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long generateTimeTestCases$lambda$5() {
        Instant now = Clock.System.INSTANCE.now();
        Duration.Companion companion = Duration.Companion;
        return now.minus-LRDsOJo(DurationKt.toDuration(1, DurationUnit.DAYS)).toEpochMilliseconds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long generateTimeTestCases$lambda$6() {
        Instant now = Clock.System.INSTANCE.now();
        Duration.Companion companion = Duration.Companion;
        Instant instant = now.minus-LRDsOJo(DurationKt.toDuration(1, DurationUnit.DAYS));
        Duration.Companion companion2 = Duration.Companion;
        return instant.minus-LRDsOJo(DurationKt.toDuration(12, DurationUnit.HOURS)).toEpochMilliseconds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long generateTimeTestCases$lambda$7() {
        Instant now = Clock.System.INSTANCE.now();
        Duration.Companion companion = Duration.Companion;
        return now.minus-LRDsOJo(DurationKt.toDuration(3, DurationUnit.DAYS)).toEpochMilliseconds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long generateTimeTestCases$lambda$8(TimeZone $timezone) {
        int currentYear = TimeZoneKt.toLocalDateTime(Clock.System.INSTANCE.now(), $timezone).getYear();
        return TimeZoneKt.toInstant(LocalDateKt.atTime$default(new LocalDate(currentYear, 8, 5), 10, 30, 0, 0, 12, (Object) null), $timezone).toEpochMilliseconds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long generateTimeTestCases$lambda$9(TimeZone $timezone) {
        int currentYear = TimeZoneKt.toLocalDateTime(Clock.System.INSTANCE.now(), $timezone).getYear();
        return TimeZoneKt.toInstant(LocalDateKt.atTime$default(new LocalDate(currentYear - 3, 12, 2), 22, 22, 0, 0, 12, (Object) null), $timezone).toEpochMilliseconds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long generateTimeTestCases$lambda$10() {
        Instant now = Clock.System.INSTANCE.now();
        Duration.Companion companion = Duration.Companion;
        return now.plus-LRDsOJo(DurationKt.toDuration(2, DurationUnit.HOURS)).toEpochMilliseconds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long generateTimeTestCases$lambda$11() {
        Instant now = Clock.System.INSTANCE.now();
        Duration.Companion companion = Duration.Companion;
        return now.plus-LRDsOJo(DurationKt.toDuration(1, DurationUnit.DAYS)).toEpochMilliseconds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long generateTimeTestCases$lambda$12(TimeZone $timezone) {
        int currentYear = TimeZoneKt.toLocalDateTime(Clock.System.INSTANCE.now(), $timezone).getYear();
        return TimeZoneKt.toInstant(LocalDateKt.atTime$default(new LocalDate(currentYear, 12, 25), 15, 4, 0, 0, 12, (Object) null), $timezone).toEpochMilliseconds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long generateTimeTestCases$lambda$13(TimeZone $timezone) {
        int currentYear = TimeZoneKt.toLocalDateTime(Clock.System.INSTANCE.now(), $timezone).getYear();
        return TimeZoneKt.toInstant(LocalDateKt.atTime$default(new LocalDate(currentYear + 1, 11, 2), 15, 4, 0, 0, 12, (Object) null), $timezone).toEpochMilliseconds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00cc, code lost:
        if (r14 == null) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NumberFormat(Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Object obj;
        Composer $composer2 = $composer.startRestartGroup(-2139209774);
        ComposerKt.sourceInformation($composer2, "C(NumberFormat)N(modifier)168@7512L41,168@7495L58,170@7585L127,175@7754L7,176@7788L47,176@7858L1209,176@7766L1301:LocalizationPreviewPage.kt#3k1zvn");
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
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            Modifier modifier3 = i2 != 0 ? SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null) : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2139209774, $dirty2, -1, "kntr.base.localization.preview.NumberFormat (LocalizationPreviewPage.kt:167)");
            }
            Object[] objArr = new Object[0];
            ComposerKt.sourceInformationMarkerStart($composer2, 1508745147, "CC(remember):LocalizationPreviewPage.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda31
                    public final Object invoke() {
                        MutableState NumberFormat$lambda$0$0;
                        NumberFormat$lambda$0$0 = LocalizationPreviewPageKt.NumberFormat$lambda$0$0();
                        return NumberFormat$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final MutableState text$delegate = (MutableState) RememberSaveableKt.rememberSaveable(objArr, (Function0) it$iv, $composer2, 48);
            String NumberFormat$lambda$1 = NumberFormat$lambda$1(text$delegate);
            ComposerKt.sourceInformationMarkerStart($composer2, 1508747569, "CC(remember):LocalizationPreviewPage.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(NumberFormat$lambda$1);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Long longOrNull = StringsKt.toLongOrNull(NumberFormat$lambda$1(text$delegate));
                if (longOrNull != null) {
                    long it = longOrNull.longValue();
                    obj = NumberFormatKt.formatNumber(it, 1, true);
                }
                obj = "";
                Object value$iv2 = obj;
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            final String formatString = (String) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final FocusManager focusManager = (FocusManager) consume;
            PreviewColumn(StringResourcesKt.stringResource(String0_commonMainKt.getNumber_format_column(Res.string.INSTANCE), $composer2, 0), modifier3, ComposableLambdaKt.rememberComposableLambda(-1232666781, true, new Function2() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda33
                public final Object invoke(Object obj2, Object obj3) {
                    Unit NumberFormat$lambda$4;
                    NumberFormat$lambda$4 = LocalizationPreviewPageKt.NumberFormat$lambda$4(focusManager, text$delegate, formatString, (Composer) obj2, ((Integer) obj3).intValue());
                    return NumberFormat$lambda$4;
                }
            }, $composer2, 54), $composer2, (($dirty2 << 3) & 112) | 384, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda34
                public final Object invoke(Object obj2, Object obj3) {
                    Unit NumberFormat$lambda$5;
                    NumberFormat$lambda$5 = LocalizationPreviewPageKt.NumberFormat$lambda$5(modifier2, $changed, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return NumberFormat$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState NumberFormat$lambda$0$0() {
        return SnapshotStateKt.mutableStateOf$default(NUMBER_FORMAT_DEFAULT, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    private static final String NumberFormat$lambda$1(MutableState<String> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (String) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NumberFormat$lambda$4(final FocusManager $focusManager, final MutableState $text$delegate, final String $formatString, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C186@8191L217,198@8701L73,180@8006L128,177@7868L936,203@8875L6,203@8887L56,203@8813L130,207@8982L30,206@8952L109:LocalizationPreviewPage.kt#3k1zvn");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1232666781, $changed, -1, "kntr.base.localization.preview.NumberFormat.<anonymous> (LocalizationPreviewPage.kt:177)");
            }
            Modifier modifier = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(4), 1, (Object) null);
            String NumberFormat$lambda$1 = NumberFormat$lambda$1($text$delegate);
            TextFieldColors textFieldColors = TextFieldDefaults.INSTANCE.colors-0hiis_0(0L, 0L, 0L, 0L, Color.Companion.getTransparent-0d7_KjU(), Color.Companion.getTransparent-0d7_KjU(), Color.Companion.getTransparent-0d7_KjU(), 0L, 0L, 0L, (TextSelectionColors) null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer, 1794048, 0, 0, 0, 3072, 2147483535, 4095);
            KeyboardOptions keyboardOptions = KeyboardOptions.copy-INvB4aQ$default(KeyboardOptions.Companion.getDefault(), 0, (Boolean) null, KeyboardType.Companion.getNumber-PjHm6EE(), ImeAction.Companion.getDone-eUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 818224204, "CC(remember):LocalizationPreviewPage.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($focusManager);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda24
                    public final Object invoke(Object obj) {
                        Unit NumberFormat$lambda$4$0$0;
                        NumberFormat$lambda$4$0$0 = LocalizationPreviewPageKt.NumberFormat$lambda$4$0$0($focusManager, (KeyboardActionScope) obj);
                        return NumberFormat$lambda$4$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            KeyboardActions keyboardActions = new KeyboardActions((Function1) it$iv, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, 62, (DefaultConstructorMarker) null);
            ComposerKt.sourceInformationMarkerStart($composer, 818202019, "CC(remember):LocalizationPreviewPage.kt#9igjgp");
            boolean invalid$iv2 = $composer.changed($text$delegate);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda25
                    public final Object invoke(Object obj) {
                        Unit NumberFormat$lambda$4$1$0;
                        NumberFormat$lambda$4$1$0 = LocalizationPreviewPageKt.NumberFormat$lambda$4$1$0($text$delegate, (String) obj);
                        return NumberFormat$lambda$4$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            TextFieldKt.TextField(NumberFormat$lambda$1, (Function1) it$iv2, modifier, false, false, (TextStyle) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, keyboardOptions, keyboardActions, false, 0, 0, (MutableInteractionSource) null, (Shape) null, textFieldColors, $composer, 384, 0, 0, 4095992);
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getRe6-0d7_KjU())), ComposableLambdaKt.rememberComposableLambda(1085190819, true, new Function2() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda26
                public final Object invoke(Object obj, Object obj2) {
                    Unit NumberFormat$lambda$4$2;
                    NumberFormat$lambda$4$2 = LocalizationPreviewPageKt.NumberFormat$lambda$4$2($formatString, (Composer) obj, ((Integer) obj2).intValue());
                    return NumberFormat$lambda$4$2;
                }
            }, $composer, 54), $composer, ProvidedValue.$stable | 48);
            ComposerKt.sourceInformationMarkerStart($composer, 818233153, "CC(remember):LocalizationPreviewPage.kt#9igjgp");
            Object it$iv3 = $composer.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function0() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda27
                    public final Object invoke() {
                        Unit NumberFormat$lambda$4$3$0;
                        NumberFormat$lambda$4$3$0 = LocalizationPreviewPageKt.NumberFormat$lambda$4$3$0();
                        return NumberFormat$lambda$4$3$0;
                    }
                };
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.Button((Function0) it$iv3, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$LocalizationPreviewPageKt.INSTANCE.m1636getLambda$396605069$preview_debug(), $composer, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NumberFormat$lambda$4$1$0(MutableState $text$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((it.length() == 0) || StringsKt.toLongOrNull(it) != null) {
            $text$delegate.setValue(it);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NumberFormat$lambda$4$0$0(FocusManager $focusManager, KeyboardActionScope $this$KeyboardActions) {
        Intrinsics.checkNotNullParameter($this$KeyboardActions, "$this$KeyboardActions");
        FocusManager.-CC.clearFocus$default($focusManager, false, 1, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NumberFormat$lambda$4$2(String $formatString, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C204@8901L32:LocalizationPreviewPage.kt#3k1zvn");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1085190819, $changed, -1, "kntr.base.localization.preview.NumberFormat.<anonymous>.<anonymous> (LocalizationPreviewPage.kt:204)");
            }
            InfoItem("Format", $formatString, null, $composer, 6, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NumberFormat$lambda$4$3$0() {
        NumberFormatTest.INSTANCE.testAll();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DateTimeFormat(Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        String formatIMDateTime;
        Composer $composer2 = $composer.startRestartGroup(1411318464);
        ComposerKt.sourceInformation($composer2, "C(DateTimeFormat)N(modifier)216@9191L157,216@9174L174,225@9376L90,229@9494L90,233@9606L84,236@9732L7,237@9766L49,237@9838L2396,237@9744L2490:LocalizationPreviewPage.kt#3k1zvn");
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
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            Modifier modifier3 = i2 != 0 ? SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null) : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1411318464, $dirty2, -1, "kntr.base.localization.preview.DateTimeFormat (LocalizationPreviewPage.kt:215)");
            }
            Object[] objArr = new Object[0];
            ComposerKt.sourceInformationMarkerStart($composer2, -932618275, "CC(remember):LocalizationPreviewPage.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda28
                    public final Object invoke() {
                        MutableState DateTimeFormat$lambda$0$0;
                        DateTimeFormat$lambda$0$0 = LocalizationPreviewPageKt.DateTimeFormat$lambda$0$0();
                        return DateTimeFormat$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final MutableState text$delegate = (MutableState) RememberSaveableKt.rememberSaveable(objArr, (Function0) it$iv, $composer2, 48);
            String DateTimeFormat$lambda$1 = DateTimeFormat$lambda$1(text$delegate);
            ComposerKt.sourceInformationMarkerStart($composer2, -932612422, "CC(remember):LocalizationPreviewPage.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(DateTimeFormat$lambda$1);
            Object it$iv2 = $composer2.rememberedValue();
            Object obj = "";
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Long longOrNull = StringsKt.toLongOrNull(DateTimeFormat$lambda$1(text$delegate));
                Object value$iv2 = (longOrNull == null || (r16 = DateTimeFormatKt.formatRelativeDateTime(longOrNull.longValue())) == null) ? "" : "";
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            final String relative = (String) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            String DateTimeFormat$lambda$12 = DateTimeFormat$lambda$1(text$delegate);
            ComposerKt.sourceInformationMarkerStart($composer2, -932608646, "CC(remember):LocalizationPreviewPage.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changed(DateTimeFormat$lambda$12);
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                Long longOrNull2 = StringsKt.toLongOrNull(DateTimeFormat$lambda$1(text$delegate));
                Object value$iv3 = (longOrNull2 == null || (r16 = DateTimeFormatKt.formatAbsoluteDateTime(longOrNull2.longValue())) == null) ? "" : "";
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            final String absolute = (String) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            String DateTimeFormat$lambda$13 = DateTimeFormat$lambda$1(text$delegate);
            ComposerKt.sourceInformationMarkerStart($composer2, -932605068, "CC(remember):LocalizationPreviewPage.kt#9igjgp");
            boolean invalid$iv3 = $composer2.changed(DateTimeFormat$lambda$13);
            Object it$iv4 = $composer2.rememberedValue();
            if (invalid$iv3 || it$iv4 == Composer.Companion.getEmpty()) {
                Long longOrNull3 = StringsKt.toLongOrNull(DateTimeFormat$lambda$1(text$delegate));
                if (longOrNull3 != null && (formatIMDateTime = DateTimeFormatKt.formatIMDateTime(longOrNull3.longValue())) != null) {
                    obj = formatIMDateTime;
                }
                Object value$iv4 = obj;
                $composer2.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            final String im = (String) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final FocusManager focusManager = (FocusManager) consume;
            PreviewColumn(StringResourcesKt.stringResource(String0_commonMainKt.getDatetime_format_column(Res.string.INSTANCE), $composer2, 0), modifier3, ComposableLambdaKt.rememberComposableLambda(720773649, true, new Function2() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda29
                public final Object invoke(Object obj2, Object obj3) {
                    Unit DateTimeFormat$lambda$6;
                    DateTimeFormat$lambda$6 = LocalizationPreviewPageKt.DateTimeFormat$lambda$6(text$delegate, focusManager, relative, absolute, im, (Composer) obj2, ((Integer) obj3).intValue());
                    return DateTimeFormat$lambda$6;
                }
            }, $composer2, 54), $composer2, (($dirty2 << 3) & 112) | 384, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda30
                public final Object invoke(Object obj2, Object obj3) {
                    Unit DateTimeFormat$lambda$7;
                    DateTimeFormat$lambda$7 = LocalizationPreviewPageKt.DateTimeFormat$lambda$7(modifier2, $changed, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return DateTimeFormat$lambda$7;
                }
            });
        }
    }

    private static final String DateTimeFormat$lambda$1(MutableState<String> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (String) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState DateTimeFormat$lambda$0$0() {
        return SnapshotStateKt.mutableStateOf$default(String.valueOf(Clock.System.INSTANCE.now().toEpochMilliseconds()), (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateTimeFormat$lambda$6(final MutableState $text$delegate, final FocusManager $focusManager, final String $relative, final String $absolute, final String $im, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C241@10004L760,238@9848L916,268@11096L217,280@11606L73,262@10911L128,259@10773L936,285@11780L6,285@11792L54,285@11718L128,288@11917L6,288@11929L54,288@11855L128,291@12054L6,291@12066L42,291@11992L116,295@12147L32,294@12117L111:LocalizationPreviewPage.kt#3k1zvn");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(720773649, $changed, -1, "kntr.base.localization.preview.DateTimeFormat.<anonymous> (LocalizationPreviewPage.kt:238)");
            }
            Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
            Modifier modifier = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(4), 1, (Object) null);
            Arrangement.Horizontal horizontal2 = horizontal;
            ComposerKt.sourceInformationMarkerStart($composer, 1173748105, "CC(remember):LocalizationPreviewPage.kt#9igjgp");
            boolean invalid$iv = $composer.changed($text$delegate) | $composer.changedInstance($focusManager);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda15
                    public final Object invoke(Object obj) {
                        Unit DateTimeFormat$lambda$6$0$0;
                        DateTimeFormat$lambda$6$0$0 = LocalizationPreviewPageKt.DateTimeFormat$lambda$6$0$0($text$delegate, $focusManager, (LazyListScope) obj);
                        return DateTimeFormat$lambda$6$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            LazyDslKt.LazyRow(modifier, (LazyListState) null, (PaddingValues) null, false, horizontal2, (Alignment.Vertical) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv, $composer, 24582, 494);
            Modifier modifier2 = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(4), 1, (Object) null);
            String DateTimeFormat$lambda$1 = DateTimeFormat$lambda$1($text$delegate);
            TextFieldColors textFieldColors = TextFieldDefaults.INSTANCE.colors-0hiis_0(0L, 0L, 0L, 0L, Color.Companion.getTransparent-0d7_KjU(), Color.Companion.getTransparent-0d7_KjU(), Color.Companion.getTransparent-0d7_KjU(), 0L, 0L, 0L, (TextSelectionColors) null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer, 1794048, 0, 0, 0, 3072, 2147483535, 4095);
            KeyboardOptions keyboardOptions = KeyboardOptions.copy-INvB4aQ$default(KeyboardOptions.Companion.getDefault(), 0, (Boolean) null, KeyboardType.Companion.getNumber-PjHm6EE(), ImeAction.Companion.getDone-eUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1173798682, "CC(remember):LocalizationPreviewPage.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance($focusManager);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda16
                    public final Object invoke(Object obj) {
                        Unit DateTimeFormat$lambda$6$1$0;
                        DateTimeFormat$lambda$6$1$0 = LocalizationPreviewPageKt.DateTimeFormat$lambda$6$1$0($focusManager, (KeyboardActionScope) obj);
                        return DateTimeFormat$lambda$6$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            KeyboardActions keyboardActions = new KeyboardActions((Function1) it$iv2, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, 62, (DefaultConstructorMarker) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1173776497, "CC(remember):LocalizationPreviewPage.kt#9igjgp");
            boolean invalid$iv3 = $composer.changed($text$delegate);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function1() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda17
                    public final Object invoke(Object obj) {
                        Unit DateTimeFormat$lambda$6$2$0;
                        DateTimeFormat$lambda$6$2$0 = LocalizationPreviewPageKt.DateTimeFormat$lambda$6$2$0($text$delegate, (String) obj);
                        return DateTimeFormat$lambda$6$2$0;
                    }
                };
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            TextFieldKt.TextField(DateTimeFormat$lambda$1, (Function1) it$iv3, modifier2, false, false, (TextStyle) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, keyboardOptions, keyboardActions, false, 0, 0, (MutableInteractionSource) null, (Shape) null, textFieldColors, $composer, 384, 0, 0, 4095992);
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGr6-0d7_KjU())), ComposableLambdaKt.rememberComposableLambda(-906099375, true, new Function2() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda18
                public final Object invoke(Object obj, Object obj2) {
                    Unit DateTimeFormat$lambda$6$3;
                    DateTimeFormat$lambda$6$3 = LocalizationPreviewPageKt.DateTimeFormat$lambda$6$3($relative, (Composer) obj, ((Integer) obj2).intValue());
                    return DateTimeFormat$lambda$6$3;
                }
            }, $composer, 54), $composer, ProvidedValue.$stable | 48);
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBl6-0d7_KjU())), ComposableLambdaKt.rememberComposableLambda(-1265947526, true, new Function2() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda19
                public final Object invoke(Object obj, Object obj2) {
                    Unit DateTimeFormat$lambda$6$4;
                    DateTimeFormat$lambda$6$4 = LocalizationPreviewPageKt.DateTimeFormat$lambda$6$4($absolute, (Composer) obj, ((Integer) obj2).intValue());
                    return DateTimeFormat$lambda$6$4;
                }
            }, $composer, 54), $composer, ProvidedValue.$stable | 48);
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getRe6-0d7_KjU())), ComposableLambdaKt.rememberComposableLambda(-1398271271, true, new Function2() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda20
                public final Object invoke(Object obj, Object obj2) {
                    Unit DateTimeFormat$lambda$6$5;
                    DateTimeFormat$lambda$6$5 = LocalizationPreviewPageKt.DateTimeFormat$lambda$6$5($im, (Composer) obj, ((Integer) obj2).intValue());
                    return DateTimeFormat$lambda$6$5;
                }
            }, $composer, 54), $composer, ProvidedValue.$stable | 48);
            ComposerKt.sourceInformationMarkerStart($composer, 1173815953, "CC(remember):LocalizationPreviewPage.kt#9igjgp");
            Object it$iv4 = $composer.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new Function0() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda22
                    public final Object invoke() {
                        Unit DateTimeFormat$lambda$6$6$0;
                        DateTimeFormat$lambda$6$6$0 = LocalizationPreviewPageKt.DateTimeFormat$lambda$6$6$0();
                        return DateTimeFormat$lambda$6$6$0;
                    }
                };
                $composer.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.Button((Function0) it$iv4, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$LocalizationPreviewPageKt.INSTANCE.getLambda$1017194529$preview_debug(), $composer, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateTimeFormat$lambda$6$0$0(final MutableState $text$delegate, final FocusManager $focusManager, LazyListScope $this$LazyRow) {
        Intrinsics.checkNotNullParameter($this$LazyRow, "$this$LazyRow");
        final List items$iv = generateTimeTestCases();
        final Function1 contentType$iv = new Function1() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$DateTimeFormat$lambda$6$0$0$$inlined$items$default$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return m1722invoke((TimeTestCase) p1);
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final Void m1722invoke(TimeTestCase timeTestCase) {
                return null;
            }
        };
        $this$LazyRow.items(items$iv.size(), (Function1) null, new Function1<Integer, Object>() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$DateTimeFormat$lambda$6$0$0$$inlined$items$default$3
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                return contentType$iv.invoke(items$iv.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$DateTimeFormat$lambda$6$0$0$$inlined$items$default$4
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                ComposerKt.sourceInformation($composer, "CN(it)178@8834L22:LazyDsl.kt#428nma");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$items) ? 4 : 2;
                }
                if (($changed & 48) == 0) {
                    $dirty |= $composer.changed(it) ? 32 : 16;
                }
                if ($composer.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(802480018, $dirty, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                    }
                    int $changed2 = $dirty & 14;
                    final TimeTestCase testCase = (TimeTestCase) items$iv.get(it);
                    $composer.startReplaceGroup(-512364903);
                    ComposerKt.sourceInformation($composer, "CN(testCase)*245@10166L9,246@10219L6,250@10388L6,252@10507L169,243@10079L661:LocalizationPreviewPage.kt#3k1zvn");
                    String label = testCase.getLabel();
                    TextStyle t12 = BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT12();
                    long j = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText2-0d7_KjU();
                    Modifier modifier = BackgroundKt.background-bw27NRU(Modifier.Companion, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg2-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12)));
                    ComposerKt.sourceInformationMarkerStart($composer, -1956177346, "CC(remember):LocalizationPreviewPage.kt#9igjgp");
                    boolean invalid$iv = $composer.changed($text$delegate) | (((($changed2 & 112) ^ 48) > 32 && $composer.changed(testCase)) || ($changed2 & 48) == 32) | $composer.changedInstance($focusManager);
                    Object it$iv = $composer.rememberedValue();
                    if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                        final FocusManager focusManager = $focusManager;
                        final MutableState mutableState = $text$delegate;
                        Object value$iv = (Function0) new Function0<Unit>() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$DateTimeFormat$1$1$1$1$1$1
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m1723invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: collision with other method in class */
                            public final void m1723invoke() {
                                mutableState.setValue(String.valueOf(((Number) TimeTestCase.this.getTimestampGenerator().invoke()).longValue()));
                                FocusManager.-CC.clearFocus$default(focusManager, false, 1, (Object) null);
                            }
                        };
                        $composer.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    TextKt.Text-Nvy7gAk(label, PaddingKt.padding-VpY3zN4(ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(6)), j, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t12, $composer, 0, 0, 131064);
                    $composer.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer.skipToGroupEnd();
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateTimeFormat$lambda$6$2$0(MutableState $text$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((it.length() == 0) || StringsKt.toLongOrNull(it) != null) {
            $text$delegate.setValue(it);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateTimeFormat$lambda$6$1$0(FocusManager $focusManager, KeyboardActionScope $this$KeyboardActions) {
        Intrinsics.checkNotNullParameter($this$KeyboardActions, "$this$KeyboardActions");
        FocusManager.-CC.clearFocus$default($focusManager, false, 1, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateTimeFormat$lambda$6$3(String $relative, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C286@11806L30:LocalizationPreviewPage.kt#3k1zvn");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-906099375, $changed, -1, "kntr.base.localization.preview.DateTimeFormat.<anonymous>.<anonymous> (LocalizationPreviewPage.kt:286)");
            }
            InfoItem("Relative", $relative, null, $composer, 6, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateTimeFormat$lambda$6$4(String $absolute, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C289@11943L30:LocalizationPreviewPage.kt#3k1zvn");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1265947526, $changed, -1, "kntr.base.localization.preview.DateTimeFormat.<anonymous>.<anonymous> (LocalizationPreviewPage.kt:289)");
            }
            InfoItem("Absolute", $absolute, null, $composer, 6, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateTimeFormat$lambda$6$5(String $im, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C292@12080L18:LocalizationPreviewPage.kt#3k1zvn");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1398271271, $changed, -1, "kntr.base.localization.preview.DateTimeFormat.<anonymous>.<anonymous> (LocalizationPreviewPage.kt:292)");
            }
            InfoItem("IM", $im, null, $composer, 6, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateTimeFormat$lambda$6$6$0() {
        DateTimeFormatTest.INSTANCE.testAll();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void InfoItem(final Object key, final Object value, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-327902863);
        ComposerKt.sourceInformation($composer2, "C(InfoItem)N(key,value,modifier)309@12410L25,310@12459L28,312@12493L553:LocalizationPreviewPage.kt#3k1zvn");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(key) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(value) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(4), 1, (Object) null);
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-327902863, $dirty2, -1, "kntr.base.localization.preview.InfoItem (LocalizationPreviewPage.kt:308)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1582033846, "CC(remember):LocalizationPreviewPage.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(key);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = key + ":";
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            String keyContent = (String) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1582032275, "CC(remember):LocalizationPreviewPage.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changed(value);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = String.valueOf(value);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            String valueContent = (String) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(4));
            int $changed$iv = (($dirty2 >> 6) & 14) | 432;
            Modifier modifier$iv = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            Modifier modifier5 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i4 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -501474063, "C319@12726L6,320@12770L9,317@12659L207,326@12944L9,324@12875L165:LocalizationPreviewPage.kt#3k1zvn");
            TextKt.Text-Nvy7gAk(keyContent, (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT16(), $composer2, 0, 24960, 110586);
            TextKt.Text-Nvy7gAk(valueContent, (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14(), $composer2, 0, 24960, 110590);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda14
                public final Object invoke(Object obj, Object obj2) {
                    Unit InfoItem$lambda$3;
                    InfoItem$lambda$3 = LocalizationPreviewPageKt.InfoItem$lambda$3(key, value, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return InfoItem$lambda$3;
                }
            });
        }
    }

    private static final void PreviewColumn(final String title, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier$iv$iv;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer3 = $composer.startRestartGroup(1968362874);
        ComposerKt.sourceInformation($composer3, "C(PreviewColumn)N(title,modifier,content)339@13203L436:LocalizationPreviewPage.kt#3k1zvn");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(title) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier$iv$iv = modifier2;
        } else {
            if (i2 != 0) {
                modifier3 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1968362874, $dirty2, -1, "kntr.base.localization.preview.PreviewColumn (LocalizationPreviewPage.kt:338)");
            }
            int $changed$iv = ($dirty2 >> 3) & 14;
            Modifier modifier$iv = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            modifier$iv$iv = modifier3;
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
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 950023584, "C343@13339L6,344@13383L9,340@13230L177,349@13515L6,346@13416L217:LocalizationPreviewPage.kt#3k1zvn");
            TextKt.Text-Nvy7gAk(title, PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), $composer3, ($dirty2 & 14) | 48, 0, 131064);
            Modifier modifier$iv2 = PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(4));
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv2 = (0 << 3) & 112;
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
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 739443252, "C352@13614L9:LocalizationPreviewPage.kt#3k1zvn");
            function2.invoke($composer3, Integer.valueOf(($dirty2 >> 6) & 14));
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
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier$iv$iv;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda23
                public final Object invoke(Object obj, Object obj2) {
                    Unit PreviewColumn$lambda$1;
                    PreviewColumn$lambda$1 = LocalizationPreviewPageKt.PreviewColumn$lambda$1(title, modifier4, function2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PreviewColumn$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TopBar(final String title, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Composer $composer3 = $composer.startRestartGroup(-193323561);
        ComposerKt.sourceInformation($composer3, "C(TopBar)N(title,modifier)362@13777L7,364@13824L11,366@13884L11,367@13941L10,367@13952L17,368@14058L5,368@13996L1936:LocalizationPreviewPage.kt#3k1zvn");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(title) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (!$composer3.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier3 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-193323561, $dirty, -1, "kntr.base.localization.preview.TopBar (LocalizationPreviewPage.kt:361)");
            }
            CompositionLocal this_$iv = RouterKt.getLocalRouter();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Router router = (Router) consume;
            long titleColor = BiliTheme.INSTANCE.getThemeColors($composer3, BiliTheme.$stable).getTextTitle-0d7_KjU();
            long iconColor = BiliTheme.INSTANCE.getThemeColors($composer3, BiliTheme.$stable).getActionIcon-0d7_KjU();
            float paddingTop = WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getStatusBars(WindowInsets.Companion, $composer3, 6), $composer3, 0).calculateTopPadding-D9Ej5fM();
            Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(modifier3, ColorKt.Color(BiliTheme.INSTANCE.getTheme($composer3, BiliTheme.$stable).getPrimary()), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            Modifier modifier4 = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            $composer2 = $composer3;
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1764024199, "C370@14107L142,377@14259L1667:LocalizationPreviewPage.kt#3k1zvn");
            SpacerKt.Spacer(SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(Modifier.Companion, paddingTop), 0.0f, 1, (Object) null), $composer3, 0);
            Modifier modifier$iv2 = PaddingKt.padding-VpY3zN4$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(44)), Dp.constructor-impl(12), 0.0f, 2, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv2 = (390 << 3) & 112;
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
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i6 = ((390 >> 6) & 112) | 6;
            final RowScope $this$TopBar_u24lambda_u240_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 1929992416, "C381@14438L382,390@14897L230,390@14833L294,398@15203L713,398@15140L776:LocalizationPreviewPage.kt#3k1zvn");
            Modifier modifier$iv3 = RowScope.-CC.weight$default($this$TopBar_u24lambda_u240_u240, SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0f, false, 2, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv3 = (432 << 3) & 112;
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
            int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i8 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1682874426, "C386@14662L144:LocalizationPreviewPage.kt#3k1zvn");
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(iconColor)), ComposableSingletons$LocalizationPreviewPageKt.INSTANCE.getLambda$163286937$preview_debug(), $composer3, ProvidedValue.$stable | 48);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(titleColor)), ComposableLambdaKt.rememberComposableLambda(-137888131, true, new Function2() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2) {
                    Unit TopBar$lambda$0$0$1;
                    TopBar$lambda$0$0$1 = LocalizationPreviewPageKt.TopBar$lambda$0$0$1(title, (Composer) obj, ((Integer) obj2).intValue());
                    return TopBar$lambda$0$0$1;
                }
            }, $composer3, 54), $composer3, ProvidedValue.$stable | 48);
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(iconColor)), ComposableLambdaKt.rememberComposableLambda(-941282970, true, new Function2() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2) {
                    Unit TopBar$lambda$0$0$2;
                    TopBar$lambda$0$0$2 = LocalizationPreviewPageKt.TopBar$lambda$0$0$2($this$TopBar_u24lambda_u240_u240, router, (Composer) obj, ((Integer) obj2).intValue());
                    return TopBar$lambda$0$0$2;
                }
            }, $composer3, 54), $composer3, ProvidedValue.$stable | 48);
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
            endRestartGroup.updateScope(new Function2() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj, Object obj2) {
                    Unit TopBar$lambda$1;
                    TopBar$lambda$1 = LocalizationPreviewPageKt.TopBar$lambda$1(title, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TopBar$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopBar$lambda$0$0$1(String $title, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C393@14993L9,391@14915L198:LocalizationPreviewPage.kt#3k1zvn");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-137888131, $changed, -1, "kntr.base.localization.preview.TopBar.<anonymous>.<anonymous>.<anonymous> (LocalizationPreviewPage.kt:391)");
            }
            TextKt.Text-Nvy7gAk($title, (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT16(), $composer, 0, 24960, 110590);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0175, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit TopBar$lambda$0$0$2(RowScope $this_Row, final Router $router, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        ComposerKt.sourceInformation($composer, "C399@15221L681:LocalizationPreviewPage.kt#3k1zvn");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-941282970, $changed, -1, "kntr.base.localization.preview.TopBar.<anonymous>.<anonymous>.<anonymous> (LocalizationPreviewPage.kt:399)");
            }
            Modifier modifier$iv = RowScope.-CC.weight$default($this_Row, SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0f, false, 2, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getEnd();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
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
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i2 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1133652092, "C405@15516L20,407@15632L120,410@15803L7,404@15463L421:LocalizationPreviewPage.kt#3k1zvn");
            Painter nut_setting_line_500 = BiliIconfont.INSTANCE.getNut_setting_line_500($composer, 6);
            Modifier modifier = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24));
            ComposerKt.sourceInformationMarkerStart($composer, 867858522, "CC(remember):LocalizationPreviewPage.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($router);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function0() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda9
                public final Object invoke() {
                    Unit TopBar$lambda$0$0$2$0$0$0;
                    TopBar$lambda$0$0$2$0$0$0 = LocalizationPreviewPageKt.TopBar$lambda$0$0$2$0$0$0(Router.this);
                    return TopBar$lambda$0$0$2$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier2 = ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
            CompositionLocal this_$iv = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            IconKt.Icon-ww6aTOc(nut_setting_line_500, (String) null, modifier2, ((Color) consume).unbox-impl(), $composer, Painter.$stable | 48, 0);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopBar$lambda$0$0$2$0$0$0(Router $router) {
        $router.launch(Uri.Companion.parse("bilibili://settings/language"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BackIcon(final Modifier modifier, Composer $composer, final int $changed, final int i) {
        Composer $composer2 = $composer.startRestartGroup(-1626996878);
        ComposerKt.sourceInformation($composer2, "C(BackIcon)N(modifier)421@16053L7,423@16090L92,430@16225L24,431@16299L16,432@16351L7,429@16188L212:LocalizationPreviewPage.kt#3k1zvn");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1626996878, $dirty2, -1, "kntr.base.localization.preview.BackIcon (LocalizationPreviewPage.kt:420)");
            }
            final OnBackPressedDispatcher backHandler = LocalOnBackPressedDispatcher.INSTANCE.getCurrent($composer2, LocalOnBackPressedDispatcher.$stable);
            ComposerKt.sourceInformationMarkerStart($composer2, -175899634, "CC(remember):LocalizationPreviewPage.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda21
                    public final Object invoke() {
                        Unit BackIcon$lambda$0$0;
                        BackIcon$lambda$0$0 = LocalizationPreviewPageKt.BackIcon$lambda$0$0(backHandler);
                        return BackIcon$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final Function0 backAction = (Function0) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Painter arrow_back_left_line_500 = BiliIconfont.INSTANCE.getArrow_back_left_line_500($composer2, 6);
            ComposerKt.sourceInformationMarkerStart($composer2, -175893022, "CC(remember):LocalizationPreviewPage.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda32
                    public final Object invoke() {
                        Unit BackIcon$lambda$1$0;
                        BackIcon$lambda$1$0 = LocalizationPreviewPageKt.BackIcon$lambda$1$0(backAction);
                        return BackIcon$lambda$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier2 = ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null);
            CompositionLocal this_$iv = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            IconKt.Icon-ww6aTOc(arrow_back_left_line_500, (String) null, modifier2, ((Color) consume).unbox-impl(), $composer2, Painter.$stable | 48, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.base.localization.preview.LocalizationPreviewPageKt$$ExternalSyntheticLambda36
                public final Object invoke(Object obj, Object obj2) {
                    Unit BackIcon$lambda$2;
                    BackIcon$lambda$2 = LocalizationPreviewPageKt.BackIcon$lambda$2(modifier, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return BackIcon$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackIcon$lambda$0$0(OnBackPressedDispatcher $backHandler) {
        $backHandler.onBackPressed();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackIcon$lambda$1$0(Function0 $backAction) {
        $backAction.invoke();
        return Unit.INSTANCE;
    }
}