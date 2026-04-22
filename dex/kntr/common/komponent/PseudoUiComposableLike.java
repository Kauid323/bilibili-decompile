package kntr.common.komponent;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnitKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UiComposableLike.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0097\u0002¢\u0006\u0002\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lkntr/common/komponent/PseudoUiComposableLike;", "Lkntr/common/komponent/UiComposableLike;", "", "<init>", "()V", "invoke", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "contentType", "", "getContentType", "()Ljava/lang/Object;", "key", "getKey", "state", "getState", "()Ljava/lang/Void;", "preferredHostConfiguration", "Lkntr/common/komponent/HostConfiguration;", "getPreferredHostConfiguration", "()Lkntr/common/komponent/HostConfiguration;", "komponent_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PseudoUiComposableLike implements UiComposableLike {
    public static final int $stable = 0;
    public static final PseudoUiComposableLike INSTANCE = new PseudoUiComposableLike();
    private static final Object contentType = INSTANCE;
    private static final Object key = INSTANCE;
    private static final HostConfiguration preferredHostConfiguration = new HostConfiguration() { // from class: kntr.common.komponent.PseudoUiComposableLike$preferredHostConfiguration$1
        @Override // kntr.common.komponent.HostConfiguration
        public Orientation getOrientation() {
            return Orientation.Unspecified;
        }

        @Override // kntr.common.komponent.HostConfiguration
        public boolean isPopGestureEnabled() {
            return true;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1(PseudoUiComposableLike pseudoUiComposableLike, Modifier modifier, int i, Composer composer, int i2) {
        pseudoUiComposableLike.invoke(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private PseudoUiComposableLike() {
    }

    @Override // kntr.common.komponent.UiComposableLike
    public void invoke(final Modifier modifier, Composer $composer, final int $changed) {
        Composer $composer2;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer $composer3 = $composer.startRestartGroup(876262296);
        ComposerKt.sourceInformation($composer3, "C(invoke)N(modifier)36@1134L44,36@1113L65,39@1187L173:UiComposableLike.kt#vxw63z");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(modifier) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(876262296, $dirty2, -1, "kntr.common.komponent.PseudoUiComposableLike.invoke (UiComposableLike.kt:31)");
            }
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 274487012, "CC(remember):UiComposableLike.kt#9igjgp");
            boolean invalid$iv = $composer3.changed("This is a pseudo UI which should not appear in real world. It happens when one of the `Flow`s you embedded is not \"stateful\", which means that it does not emit immediately on collection.");
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new PseudoUiComposableLike$invoke$1$1("This is a pseudo UI which should not appear in real world. It happens when one of the `Flow`s you embedded is not \"stateful\", which means that it does not emit immediately on collection.", null);
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv, $composer3, 6);
            $composer2 = $composer3;
            BasicTextKt.BasicText-RWo7tUw("This is a pseudo UI which should not appear in real world. It happens when one of the `Flow`s you embedded is not \"stateful\", which means that it does not emit immediately on collection.", BackgroundKt.background-bw27NRU$default(modifier, Color.Companion.getBlack-0d7_KjU(), (Shape) null, 2, (Object) null), new TextStyle(Color.Companion.getRed-0d7_KjU(), TextUnitKt.getSp(16), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777212, (DefaultConstructorMarker) null), (Function1) null, 0, false, 0, 0, (ColorProducer) null, (TextAutoSize) null, $composer2, 384, 1016);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.komponent.PseudoUiComposableLike$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit invoke$lambda$1;
                    invoke$lambda$1 = PseudoUiComposableLike.invoke$lambda$1(PseudoUiComposableLike.this, modifier, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return invoke$lambda$1;
                }
            });
        }
    }

    @Override // kntr.common.komponent.UiComposableLike
    public Object getContentType() {
        return contentType;
    }

    @Override // kntr.common.komponent.UiComposableLike
    public Object getKey() {
        return key;
    }

    @Override // kntr.common.komponent.UiComposableLike
    public Void getState() {
        throw new UnsupportedOperationException();
    }

    @Override // kntr.common.komponent.UiComposableLike
    public HostConfiguration getPreferredHostConfiguration() {
        return preferredHostConfiguration;
    }
}