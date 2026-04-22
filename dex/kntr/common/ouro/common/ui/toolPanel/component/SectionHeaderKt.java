package kntr.common.ouro.common.ui.toolPanel.component;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.StringResource;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: SectionHeader.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"sectionHeader", "", "Landroidx/compose/foundation/lazy/LazyListScope;", "title", "Lorg/jetbrains/compose/resources/StringResource;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SectionHeaderKt {
    public static final void sectionHeader(LazyListScope $this$sectionHeader, final StringResource title) {
        Intrinsics.checkNotNullParameter($this$sectionHeader, "<this>");
        Intrinsics.checkNotNullParameter(title, "title");
        LazyListScope.-CC.item$default($this$sectionHeader, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-254308377, true, new Function3() { // from class: kntr.common.ouro.common.ui.toolPanel.component.SectionHeaderKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit sectionHeader$lambda$0;
                sectionHeader$lambda$0 = SectionHeaderKt.sectionHeader$lambda$0(title, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return sectionHeader$lambda$0;
            }
        }), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sectionHeader$lambda$0(StringResource $title, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C14@533L21,15@586L9,16@631L6,13@508L202:SectionHeader.kt#seozip");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-254308377, $changed, -1, "kntr.common.ouro.common.ui.toolPanel.component.sectionHeader.<anonymous> (SectionHeader.kt:13)");
            }
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource($title, $composer, 0), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.constructor-impl(4), 7, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT11(), $composer, 48, 0, 131064);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}