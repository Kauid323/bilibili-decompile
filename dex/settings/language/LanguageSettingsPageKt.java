package settings.language;

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
import androidx.compose.foundation.text.TextAutoSize;
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
import androidx.compose.ui.graphics.Shape;
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
import bili.resource.settings.SettingsRes;
import bili.resource.settings.String0_commonMainKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.localization.AiTranslateConfig;
import kntr.base.localization.LanguageConfig;
import kntr.base.localization.Locale;
import kntr.base.localization.Localization;
import kntr.base.net.comm.redirect.RedirectImpKt;
import kntr.common.trio.p000switch.SimpleSwitchKt;
import kntr.common.trio.p000switch.SimpleSwitchSize;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.compose.resources.StringResource;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.app.settings.language.generated.resources.Res;

/* compiled from: LanguageSettingsPage.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a7\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tH\u0003¢\u0006\u0002\u0010\n\u001a?\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tH\u0003¢\u0006\u0002\u0010\u000f\u001a\u0015\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0012H\u0003¢\u0006\u0002\u0010\u0013\u001a)\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\rH\u0003¢\u0006\u0002\u0010\u0017\u001a?\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tH\u0003¢\u0006\u0002\u0010\u001c\u001a\u001f\u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020 0\u001f0\u001eH\u0003¢\u0006\u0002\u0010!¨\u0006\""}, d2 = {"LanguageSettingsPage", "", "(Landroidx/compose/runtime/Composer;I)V", "AppLanguageSettings", "locale", "Lkntr/base/localization/Locale;", "modifier", "Landroidx/compose/ui/Modifier;", "onClick", "Lkotlin/Function1;", "(Lkntr/base/localization/Locale;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "AiTranslationSettings", "enabled", "", "onCheckedChange", "(Lkntr/base/localization/Locale;ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "SubTitle", "title", "", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "LanguageItem", "text", "selected", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;II)V", "AiTranslationItem", "checked", RedirectImpKt.REDIRECT_KV_CONFIG, "Lkntr/base/localization/AiTranslateConfig;", "(ZLkntr/base/localization/AiTranslateConfig;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "supportedLocaleList", "", "Lkotlin/Pair;", "Lorg/jetbrains/compose/resources/StringResource;", "(Landroidx/compose/runtime/Composer;I)Ljava/util/List;", "language_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LanguageSettingsPageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AiTranslationItem$lambda$1(boolean z, AiTranslateConfig aiTranslateConfig, Modifier modifier, Function1 function1, int i, int i2, Composer composer, int i3) {
        AiTranslationItem(z, aiTranslateConfig, modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AiTranslationSettings$lambda$2(Locale locale, boolean z, Modifier modifier, Function1 function1, int i, int i2, Composer composer, int i3) {
        AiTranslationSettings(locale, z, modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppLanguageSettings$lambda$1(Locale locale, Modifier modifier, Function1 function1, int i, int i2, Composer composer, int i3) {
        AppLanguageSettings(locale, modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LanguageItem$lambda$1(String str, Modifier modifier, boolean z, int i, int i2, Composer composer, int i3) {
        LanguageItem(str, modifier, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LanguageSettingsPage$lambda$0(int i, Composer composer, int i2) {
        LanguageSettingsPage(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SubTitle$lambda$0(String str, int i, Composer composer, int i2) {
        SubTitle(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void LanguageSettingsPage(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1744055867);
        ComposerKt.sourceInformation($composer2, "C(LanguageSettingsPage)64@2961L1840:LanguageSettingsPage.kt#nusb0j");
        if (!$composer2.shouldExecute($changed != 0, $changed & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1744055867, $changed, -1, "settings.language.LanguageSettingsPage (LanguageSettingsPage.kt:63)");
            }
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableSingletons$LanguageSettingsPageKt.INSTANCE.getLambda$2027889651$language_debug(), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: settings.language.LanguageSettingsPageKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit LanguageSettingsPage$lambda$0;
                    LanguageSettingsPage$lambda$0 = LanguageSettingsPageKt.LanguageSettingsPage$lambda$0($changed, (Composer) obj, ((Integer) obj2).intValue());
                    return LanguageSettingsPage$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AppLanguageSettings(final Locale locale, Modifier modifier, Function1<? super Locale, Unit> function1, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function1 function12;
        Modifier modifier3;
        Function1 onClick;
        Modifier modifier4;
        final Function1 onClick2;
        Function0 factory$iv$iv$iv;
        Function1 onClick3;
        Composer $composer2 = $composer.startRestartGroup(-1889229689);
        ComposerKt.sourceInformation($composer2, "C(AppLanguageSettings)N(locale,modifier,onClick)121@4954L489:LanguageSettingsPage.kt#nusb0j");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(locale) ? 4 : 2;
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
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            function12 = function1;
        } else if (($changed & 384) == 0) {
            function12 = function1;
            $dirty |= $composer2.changedInstance(function12) ? 256 : 128;
        } else {
            function12 = function1;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            onClick = function12;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                onClick2 = function12;
            } else {
                onClick2 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1889229689, $dirty2, -1, "settings.language.AppLanguageSettings (LanguageSettingsPage.kt:120)");
            }
            int $changed$iv = ($dirty2 >> 3) & 14;
            Modifier modifier$iv = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier modifier5 = modifier4;
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
            int $changed$iv2 = ($changed$iv$iv$iv >> 6) & 14;
            boolean z = false;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1591001378, "C122@4990L61,122@4981L71,123@5061L21:LanguageSettingsPage.kt#nusb0j");
            SubTitle(StringResourcesKt.stringResource(String0_commonMainKt.getSettings_global_string_257(SettingsRes.INSTANCE.getString()), $composer2, 0), $composer2, 0);
            $composer2.startReplaceGroup(-1990982113);
            ComposerKt.sourceInformation($composer2, "*125@5155L19,128@5281L75,124@5118L309");
            Iterable $this$forEach$iv = supportedLocaleList($composer2, 0);
            boolean z2 = false;
            for (Object element$iv : $this$forEach$iv) {
                Pair pair = (Pair) element$iv;
                Iterable $this$forEach$iv2 = $this$forEach$iv;
                final Locale it = (Locale) pair.component1();
                boolean z3 = z2;
                StringResource res = (StringResource) pair.component2();
                int $changed$iv3 = $changed$iv2;
                String stringResource = StringResourcesKt.stringResource(res, $composer2, 0);
                Modifier modifier6 = Modifier.Companion;
                boolean z4 = !Intrinsics.areEqual(it, locale);
                ComposerKt.sourceInformationMarkerStart($composer2, -1787741791, "CC(remember):LanguageSettingsPage.kt#9igjgp");
                boolean invalid$iv = (($dirty2 & 896) == 256) | $composer2.changed(it);
                Object it$iv = $composer2.rememberedValue();
                if (!invalid$iv && it$iv != Composer.Companion.getEmpty()) {
                    onClick3 = onClick2;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    LanguageItem(stringResource, SizeKt.fillMaxWidth$default(ClickableKt.clickable-oSLSa3U$default(modifier6, z4, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 14, (Object) null), 0.0f, 1, (Object) null), Intrinsics.areEqual(it, locale), $composer2, 0, 0);
                    z = z;
                    $this$forEach$iv = $this$forEach$iv2;
                    z2 = z3;
                    $changed$iv2 = $changed$iv3;
                    onClick2 = onClick3;
                }
                Object value$iv = new Function0() { // from class: settings.language.LanguageSettingsPageKt$$ExternalSyntheticLambda5
                    public final Object invoke() {
                        Unit AppLanguageSettings$lambda$0$0$0$0;
                        AppLanguageSettings$lambda$0$0$0$0 = LanguageSettingsPageKt.AppLanguageSettings$lambda$0$0$0$0(onClick2, it);
                        return AppLanguageSettings$lambda$0$0$0$0;
                    }
                };
                onClick3 = onClick2;
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                LanguageItem(stringResource, SizeKt.fillMaxWidth$default(ClickableKt.clickable-oSLSa3U$default(modifier6, z4, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 14, (Object) null), 0.0f, 1, (Object) null), Intrinsics.areEqual(it, locale), $composer2, 0, 0);
                z = z;
                $this$forEach$iv = $this$forEach$iv2;
                z2 = z3;
                $changed$iv2 = $changed$iv3;
                onClick2 = onClick3;
            }
            onClick = onClick2;
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
            modifier3 = modifier5;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            final Function1 function13 = onClick;
            endRestartGroup.updateScope(new Function2() { // from class: settings.language.LanguageSettingsPageKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit AppLanguageSettings$lambda$1;
                    AppLanguageSettings$lambda$1 = LanguageSettingsPageKt.AppLanguageSettings$lambda$1(Locale.this, modifier7, function13, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AppLanguageSettings$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppLanguageSettings$lambda$0$0$0$0(Function1 $onClick, Locale $it) {
        if ($onClick != null) {
            $onClick.invoke($it);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0272, code lost:
        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L64;
     */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02e5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AiTranslationSettings(final Locale locale, final boolean enabled, Modifier modifier, Function1<? super Boolean, Unit> function1, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function1 onCheckedChange;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        final Function1 onCheckedChange2;
        Object obj;
        Function0 factory$iv$iv$iv;
        Composer $composer3 = $composer.startRestartGroup(848158971);
        ComposerKt.sourceInformation($composer3, "C(AiTranslationSettings)N(locale,enabled,modifier,onCheckedChange)146@5677L126:LanguageSettingsPage.kt#nusb0j");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(locale) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(enabled) ? 32 : 16;
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
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            onCheckedChange = function1;
        } else if (($changed & 3072) == 0) {
            onCheckedChange = function1;
            $dirty |= $composer3.changedInstance(onCheckedChange) ? 2048 : 1024;
        } else {
            onCheckedChange = function1;
        }
        if (!$composer3.shouldExecute(($dirty & 1171) != 1170, $dirty & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                onCheckedChange2 = onCheckedChange;
            } else {
                onCheckedChange2 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(848158971, $dirty, -1, "settings.language.AiTranslationSettings (LanguageSettingsPage.kt:143)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, -963008263, "CC(remember):LanguageSettingsPage.kt#9igjgp");
            boolean invalid$iv = ($dirty & 14) == 4;
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Iterator<T> it = LanguageConfig.INSTANCE.getRemoteLanguageConfig().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    AiTranslateConfig it2 = (AiTranslateConfig) obj;
                    if (Intrinsics.areEqual(it2.getLanguageTag(), locale.toLanguageTag())) {
                        break;
                    }
                }
                Object value$iv = (AiTranslateConfig) obj;
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            AiTranslateConfig config = (AiTranslateConfig) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (config != null && true == config.getSupportAiTranslate()) {
                String aiTranslateTitle = config.getAiTranslateTitle();
                if (!(aiTranslateTitle == null || StringsKt.isBlank(aiTranslateTitle))) {
                    $composer3.startReplaceGroup(211775259);
                    ComposerKt.sourceInformation($composer3, "152@5941L380");
                    int $changed$iv = ($dirty >> 6) & 14;
                    Modifier modifier$iv = modifier4;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                    MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
                    int $changed$iv$iv = ($changed$iv << 3) & 112;
                    modifier3 = modifier4;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                    CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                    Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if ($composer3.getInserting()) {
                        factory$iv$iv$iv = factory$iv$iv$iv2;
                        $composer3.createNode(factory$iv$iv$iv);
                    } else {
                        factory$iv$iv$iv = factory$iv$iv$iv2;
                        $composer3.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                    int i4 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                    int i5 = (($changed$iv >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -145268412, "C153@5981L61,153@5972L71,158@6229L67,154@6056L255:LanguageSettingsPage.kt#nusb0j");
                    SubTitle(StringResourcesKt.stringResource(String0_commonMainKt.getSettings_global_string_258(SettingsRes.INSTANCE.getString()), $composer3, 0), $composer3, 0);
                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer3, 965153199, "CC(remember):LanguageSettingsPage.kt#9igjgp");
                    boolean invalid$iv2 = ($dirty & 7168) == 2048;
                    Object it$iv2 = $composer3.rememberedValue();
                    if (invalid$iv2) {
                    }
                    Object value$iv2 = new Function1() { // from class: settings.language.LanguageSettingsPageKt$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj2) {
                            Unit AiTranslationSettings$lambda$1$0$0;
                            AiTranslationSettings$lambda$1$0$0 = LanguageSettingsPageKt.AiTranslationSettings$lambda$1$0$0(onCheckedChange2, ((Boolean) obj2).booleanValue());
                            return AiTranslationSettings$lambda$1$0$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    AiTranslationItem(enabled, config, fillMaxWidth$default, (Function1) it$iv2, $composer3, (($dirty >> 3) & 14) | 384 | (AiTranslateConfig.$stable << 3), 0);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endReplaceGroup();
                    $composer2 = $composer3;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    onCheckedChange = onCheckedChange2;
                }
            }
            modifier3 = modifier4;
            $composer2 = $composer3;
            $composer2.startReplaceGroup(205878439);
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
            onCheckedChange = onCheckedChange2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final Function1 function12 = onCheckedChange;
            endRestartGroup.updateScope(new Function2() { // from class: settings.language.LanguageSettingsPageKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj2, Object obj3) {
                    Unit AiTranslationSettings$lambda$2;
                    AiTranslationSettings$lambda$2 = LanguageSettingsPageKt.AiTranslationSettings$lambda$2(Locale.this, enabled, modifier5, function12, $changed, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return AiTranslationSettings$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AiTranslationSettings$lambda$1$0$0(Function1 $onCheckedChange, boolean it) {
        if ($onCheckedChange != null) {
            $onCheckedChange.invoke(Boolean.valueOf(it));
        }
        return Unit.INSTANCE;
    }

    private static final void SubTitle(final String title, Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-1003610754);
        ComposerKt.sourceInformation($composer3, "C(SubTitle)N(title)177@6623L6,178@6663L9,168@6385L298:LanguageSettingsPage.kt#nusb0j");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(title) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1003610754, $dirty2, -1, "settings.language.SubTitle (LanguageSettingsPage.kt:167)");
            }
            $composer2 = $composer3;
            TextKt.Text-Nvy7gAk(title, PaddingKt.padding-qDBjuR0(Modifier.Companion, Dp.constructor-impl(12), Dp.constructor-impl(10), Dp.constructor-impl(12), Dp.constructor-impl(6)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), $composer2, $dirty2 & 14, 0, 131064);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: settings.language.LanguageSettingsPageKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit SubTitle$lambda$0;
                    SubTitle$lambda$0 = LanguageSettingsPageKt.SubTitle$lambda$0(title, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return SubTitle$lambda$0;
                }
            });
        }
    }

    private static final void LanguageItem(final String text, Modifier modifier, boolean selected, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean selected2;
        int $dirty;
        Modifier modifier3;
        Modifier modifier4;
        boolean selected3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer2 = $composer.startRestartGroup(-1854483190);
        ComposerKt.sourceInformation($composer2, "C(LanguageItem)N(text,modifier,selected)188@6862L6,188@6817L1219:LanguageSettingsPage.kt#nusb0j");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(text) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
            selected2 = selected;
        } else if (($changed & 384) == 0) {
            selected2 = selected;
            $dirty2 |= $composer2.changed(selected2) ? 256 : 128;
        } else {
            selected2 = selected;
        }
        if (!$composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $dirty = $dirty2;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                selected3 = selected2;
            } else {
                selected3 = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1854483190, $dirty2, -1, "settings.language.LanguageItem (LanguageSettingsPage.kt:187)");
            }
            Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(modifier4, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            modifier3 = modifier4;
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i5 = ((0 >> 6) & 112) | 6;
            BoxScope $this$LanguageItem_u24lambda_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -249252442, "C189@6885L841,222@7999L6,215@7735L295:LanguageSettingsPage.kt#nusb0j");
            Modifier modifier$iv2 = PaddingKt.padding-qDBjuR0(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(12), Dp.constructor-impl(15), Dp.constructor-impl(12));
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv2 = (0 << 3) & 112;
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
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer2.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i7 = ((0 >> 6) & 112) | 6;
            RowScope $this$LanguageItem_u24lambda_u240_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -392557467, "C201@7259L6,202@7307L9,198@7142L273:LanguageSettingsPage.kt#nusb0j");
            $dirty = $dirty2;
            TextKt.Text-Nvy7gAk(text, RowScope.-CC.weight$default($this$LanguageItem_u24lambda_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT16(), $composer2, $dirty2 & 14, 24960, 110584);
            if (selected3) {
                $composer2.startReplaceGroup(-392252304);
                ComposerKt.sourceInformation($composer2, "208@7509L18,209@7566L6,207@7460L242");
                IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getCheckmark_line_800($composer2, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), $composer2, Painter.$stable | 432, 0);
            } else {
                $composer2.startReplaceGroup(-399661118);
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SpacerKt.Spacer(BackgroundKt.background-bw27NRU$default(PaddingKt.padding-qDBjuR0$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default($this$LanguageItem_u24lambda_u240.align(Modifier.Companion, Alignment.Companion.getBottomStart()), 0.0f, 1, (Object) null), Dp.constructor-impl((float) 0.5d)), Dp.constructor-impl(12), 0.0f, 0.0f, 0.0f, 14, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getLine_regular-0d7_KjU(), (Shape) null, 2, (Object) null), $composer2, 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            selected2 = selected3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final boolean z = selected2;
            endRestartGroup.updateScope(new Function2() { // from class: settings.language.LanguageSettingsPageKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit LanguageItem$lambda$1;
                    LanguageItem$lambda$1 = LanguageSettingsPageKt.LanguageItem$lambda$1(text, modifier5, z, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return LanguageItem$lambda$1;
                }
            });
        }
    }

    private static final void AiTranslationItem(final boolean checked, final AiTranslateConfig config, Modifier modifier, Function1<? super Boolean, Unit> function1, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function1 function12;
        Modifier modifier3;
        Function1 onCheckedChange;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer2 = $composer.startRestartGroup(-2023571823);
        ComposerKt.sourceInformation($composer2, "C(AiTranslationItem)N(checked,config,modifier,onCheckedChange)236@8324L6,235@8270L1158:LanguageSettingsPage.kt#nusb0j");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(checked) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= ($changed & 64) == 0 ? $composer2.changed(config) : $composer2.changedInstance(config) ? 32 : 16;
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
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            function12 = function1;
        } else if (($changed & 3072) == 0) {
            function12 = function1;
            $dirty |= $composer2.changedInstance(function12) ? 2048 : 1024;
        } else {
            function12 = function1;
        }
        if ($composer2.shouldExecute(($dirty & 1171) != 1170, $dirty & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            Function1 onCheckedChange2 = i3 != 0 ? null : function12;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2023571823, $dirty, -1, "settings.language.AiTranslationItem (LanguageSettingsPage.kt:234)");
            }
            Modifier modifier$iv = PaddingKt.padding-3ABfNKs(BackgroundKt.background-bw27NRU$default(modifier4, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null), Dp.constructor-impl(12));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            modifier3 = modifier4;
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i5 = ((384 >> 6) & 112) | 6;
            RowScope $this$AiTranslationItem_u24lambda_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1115926992, "C239@8424L752,260@9185L40,261@9234L188:LanguageSettingsPage.kt#nusb0j");
            Modifier modifier$iv2 = RowScope.-CC.weight$default($this$AiTranslationItem_u24lambda_u240, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv2 = (0 << 3) & 112;
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
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer2.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i7 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 449790939, "C:LanguageSettingsPage.kt#nusb0j");
            String it = config.getAiTranslateTitle();
            if (it == null) {
                $composer2.startReplaceGroup(449804918);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(449804919);
                ComposerKt.sourceInformation($composer2, "*243@8599L6,244@8651L9,241@8524L247,248@8788L40");
                TextKt.Text-Nvy7gAk(it, (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT16(), $composer2, 0, 24960, 110586);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), $composer2, 6);
                Unit unit = Unit.INSTANCE;
                $composer2.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            }
            String it2 = config.getAiTranslateSubtitle();
            if (it2 == null) {
                $composer2.startReplaceGroup(450181103);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(450181104);
                ComposerKt.sourceInformation($composer2, "*253@8980L6,254@9032L9,251@8905L247");
                TextKt.Text-Nvy7gAk(it2, (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 2, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT13(), $composer2, 0, 24960, 110586);
                Unit unit3 = Unit.INSTANCE;
                $composer2.endReplaceGroup();
                Unit unit4 = Unit.INSTANCE;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), $composer2, 6);
            SimpleSwitchKt.SimpleSwitch(checked, onCheckedChange2, null, false, new SimpleSwitchSize(Dp.constructor-impl(24), 0.0f, Dp.constructor-impl(48), Dp.constructor-impl(30), 2, null), null, $composer2, ($dirty & 14) | (($dirty >> 6) & 112) | (SimpleSwitchSize.$stable << 12), 44);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            onCheckedChange = onCheckedChange2;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            onCheckedChange = function12;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final Function1 function13 = onCheckedChange;
            endRestartGroup.updateScope(new Function2() { // from class: settings.language.LanguageSettingsPageKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit AiTranslationItem$lambda$1;
                    AiTranslationItem$lambda$1 = LanguageSettingsPageKt.AiTranslationItem$lambda$1(checked, config, modifier5, function13, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AiTranslationItem$lambda$1;
                }
            });
        }
    }

    private static final List<Pair<Locale, StringResource>> supportedLocaleList(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -190563007, "C(supportedLocaleList)271@9520L974:LanguageSettingsPage.kt#nusb0j");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-190563007, $changed, -1, "settings.language.supportedLocaleList (LanguageSettingsPage.kt:271)");
        }
        List<Locale> supported_list = Localization.INSTANCE.getSUPPORTED_LIST();
        ComposerKt.sourceInformationMarkerStart($composer, 1552547151, "CC(remember):LanguageSettingsPage.kt#9igjgp");
        boolean invalid$iv = $composer.changed(supported_list);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Iterable $this$mapNotNull$iv = Localization.INSTANCE.getSUPPORTED_LIST();
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                Locale locale = (Locale) element$iv$iv$iv;
                boolean invalid$iv2 = invalid$iv;
                StringResource it = Intrinsics.areEqual(locale, Locale.Companion.getSIMPLIFIED_CHINESE()) ? srcs.app.settings.language.generated.resources.String0_commonMainKt.getSimplified_chinese(Res.string.INSTANCE) : Intrinsics.areEqual(locale, Locale.Companion.getTRADITIONAL_CHINESE()) ? srcs.app.settings.language.generated.resources.String0_commonMainKt.getTraditional_chinese(Res.string.INSTANCE) : Intrinsics.areEqual(locale, Locale.Companion.getENGLISH()) ? srcs.app.settings.language.generated.resources.String0_commonMainKt.getEnglish(Res.string.INSTANCE) : Intrinsics.areEqual(locale, Locale.Companion.getJAPANESE()) ? srcs.app.settings.language.generated.resources.String0_commonMainKt.getJapanese(Res.string.INSTANCE) : Intrinsics.areEqual(locale, Locale.Companion.getTHAI()) ? srcs.app.settings.language.generated.resources.String0_commonMainKt.getThai(Res.string.INSTANCE) : Intrinsics.areEqual(locale, Locale.Companion.getARABIC()) ? srcs.app.settings.language.generated.resources.String0_commonMainKt.getArabic(Res.string.INSTANCE) : Intrinsics.areEqual(locale, Locale.Companion.getSPANISH()) ? srcs.app.settings.language.generated.resources.String0_commonMainKt.getSpanish(Res.string.INSTANCE) : Intrinsics.areEqual(locale, Locale.Companion.getPORTUGUESE()) ? srcs.app.settings.language.generated.resources.String0_commonMainKt.getPortuguese(Res.string.INSTANCE) : null;
                Pair pair = it != null ? TuplesKt.to(locale, it) : null;
                if (pair != null) {
                    destination$iv$iv.add(pair);
                }
                invalid$iv = invalid$iv2;
            }
            Object value$iv = (List) destination$iv$iv;
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        List<Pair<Locale, StringResource>> list = (List) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return list;
    }
}