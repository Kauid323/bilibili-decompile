package tv.danmaku.bili.change;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material.IconKt;
import androidx.compose.material.TextKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ArrowBackKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import bili.resource.account.R;
import com.bilibili.compose.theme.BiliTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: AccountSwitchCompose.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ComposableSingletons$AccountSwitchComposeKt {
    public static final ComposableSingletons$AccountSwitchComposeKt INSTANCE = new ComposableSingletons$AccountSwitchComposeKt();
    private static Function2<Composer, Integer, Unit> lambda$1170069406 = ComposableLambdaKt.composableLambdaInstance(1170069406, false, new Function2() { // from class: tv.danmaku.bili.change.ComposableSingletons$AccountSwitchComposeKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_1170069406$lambda$0;
            lambda_1170069406$lambda$0 = ComposableSingletons$AccountSwitchComposeKt.lambda_1170069406$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_1170069406$lambda$0;
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1584467516 = ComposableLambdaKt.composableLambdaInstance(1584467516, false, new Function2() { // from class: tv.danmaku.bili.change.ComposableSingletons$AccountSwitchComposeKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_1584467516$lambda$0;
            lambda_1584467516$lambda$0 = ComposableSingletons$AccountSwitchComposeKt.lambda_1584467516$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_1584467516$lambda$0;
        }
    });

    /* renamed from: lambda$-76628010  reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f3lambda$76628010 = ComposableLambdaKt.composableLambdaInstance(-76628010, false, new Function3() { // from class: tv.danmaku.bili.change.ComposableSingletons$AccountSwitchComposeKt$$ExternalSyntheticLambda2
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__76628010$lambda$0;
            lambda__76628010$lambda$0 = ComposableSingletons$AccountSwitchComposeKt.lambda__76628010$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__76628010$lambda$0;
        }
    });

    /* renamed from: getLambda$-76628010$accountui_apinkDebug  reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m761getLambda$76628010$accountui_apinkDebug() {
        return f3lambda$76628010;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1170069406$accountui_apinkDebug() {
        return lambda$1170069406;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1584467516$accountui_apinkDebug() {
        return lambda$1584467516;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1170069406$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C66@2716L76,67@2836L9,65@2679L192:AccountSwitchCompose.kt#khrci7");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1170069406, $changed, -1, "tv.danmaku.bili.change.ComposableSingletons$AccountSwitchComposeKt.lambda$1170069406.<anonymous> (AccountSwitchCompose.kt:65)");
            }
            TextKt.Text--4IGK_g(StringResources_androidKt.stringResource(R.string.account_global_string_15, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT17(), $composer, 0, 0, 65534);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1584467516$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C80@3377L6,77@3207L208:AccountSwitchCompose.kt#khrci7");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1584467516, $changed, -1, "tv.danmaku.bili.change.ComposableSingletons$AccountSwitchComposeKt.lambda$1584467516.<anonymous> (AccountSwitchCompose.kt:77)");
            }
            IconKt.Icon-ww6aTOc(ArrowBackKt.getArrowBack(Icons.Filled.INSTANCE), "", (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText2-0d7_KjU(), $composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__76628010$lambda$0(LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C142@6025L160:AccountSwitchCompose.kt#khrci7");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-76628010, $changed, -1, "tv.danmaku.bili.change.ComposableSingletons$AccountSwitchComposeKt.lambda$-76628010.<anonymous> (AccountSwitchCompose.kt:142)");
            }
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(12)), $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}