package tv.danmaku.bili.ui.garb.digital.module;

import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: CheckAvatarText.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"CheckAvatarText", "", "modifier", "Landroidx/compose/ui/Modifier;", "onClicked", "Lkotlin/Function0;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CheckAvatarTextKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckAvatarText$lambda$1(Modifier modifier, Function0 function0, int i, int i2, Composer composer, int i3) {
        CheckAvatarText(modifier, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void CheckAvatarText(Modifier modifier, final Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(function0, "onClicked");
        Composer $composer3 = $composer.startRestartGroup(1506604836);
        ComposerKt.sourceInformation($composer3, "C(CheckAvatarText)N(modifier,onClicked)32@1017L43,19@635L521:CheckAvatarText.kt#3k8fsb");
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
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1506604836, $dirty2, -1, "tv.danmaku.bili.ui.garb.digital.module.CheckAvatarText (CheckAvatarText.kt:18)");
            }
            Modifier modifier4 = PaddingKt.padding-VpY3zN4(BorderKt.border-xT4_qwU(SizeKt.wrapContentSize$default(PaddingKt.padding-3ABfNKs(modifier3, Dp.constructor-impl(20)), (Alignment) null, false, 3, (Object) null), Dp.constructor-impl((float) 0.5d), ColorKt.Color(4289440425L), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(100))), Dp.constructor-impl(14), Dp.constructor-impl(5));
            ComposerKt.sourceInformationMarkerStart($composer3, 443283791, "CC(remember):CheckAvatarText.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & BR.containerVisible) == 32;
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: tv.danmaku.bili.ui.garb.digital.module.CheckAvatarTextKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit CheckAvatarText$lambda$0$0;
                        CheckAvatarText$lambda$0$0 = CheckAvatarTextKt.CheckAvatarText$lambda$0$0(function0);
                        return CheckAvatarText$lambda$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier5 = modifier3;
            $composer2 = $composer3;
            TextKt.Text--4IGK_g("查看TA的头像挂件", ClickableKt.clickable-oSLSa3U$default(modifier4, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), ColorKt.Color(4289440425L), TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer2, 3462, 0, 131056);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier5;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.ui.garb.digital.module.CheckAvatarTextKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit CheckAvatarText$lambda$1;
                    CheckAvatarText$lambda$1 = CheckAvatarTextKt.CheckAvatarText$lambda$1(modifier2, function0, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CheckAvatarText$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckAvatarText$lambda$0$0(Function0 $onClicked) {
        $onClicked.invoke();
        return Unit.INSTANCE;
    }
}