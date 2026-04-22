package kntr.app.tribee.steam.page.share;

import androidx.compose.foundation.ImageKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.layout.ContentScale;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.qrcode.QrCodeProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeSteamShareQrCode.android.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"TribeeSteamShareQrCode", "", "qrCodeProvider", "Lkntr/common/paragraph/qrcode/QrCodeProvider;", "qrCodeString", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/common/paragraph/qrcode/QrCodeProvider;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "consume_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeSteamShareQrCode_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamShareQrCode$lambda$1(QrCodeProvider qrCodeProvider, String str, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TribeeSteamShareQrCode(qrCodeProvider, str, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void TribeeSteamShareQrCode(final QrCodeProvider qrCodeProvider, final String qrCodeString, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(qrCodeProvider, "qrCodeProvider");
        Intrinsics.checkNotNullParameter(qrCodeString, "qrCodeString");
        Composer $composer3 = $composer.startRestartGroup(-882480297);
        ComposerKt.sourceInformation($composer3, "C(TribeeSteamShareQrCode)N(qrCodeProvider,qrCodeString,modifier):TribeeSteamShareQrCode.android.kt#m5suzp");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(qrCodeProvider) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(qrCodeString) ? 32 : 16;
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
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-882480297, $dirty2, -1, "kntr.app.tribee.steam.page.share.TribeeSteamShareQrCode (TribeeSteamShareQrCode.android.kt:12)");
            }
            ImageBitmap it = QrCodeProvider.CC.getQrCodeImage$default(qrCodeProvider, qrCodeString, 0, 0, 0, 14, null);
            if (it == null) {
                $composer3.startReplaceGroup(-475524288);
                $composer3.endReplaceGroup();
                $composer2 = $composer3;
            } else {
                $composer3.startReplaceGroup(-475524287);
                ComposerKt.sourceInformation($composer3, "*14@429L118");
                $composer2 = $composer3;
                ImageKt.Image-5h-nEew(it, "QR Code", modifier3, (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, 0, $composer2, ($dirty2 & 896) | 48, 248);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.steam.page.share.TribeeSteamShareQrCode_androidKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeSteamShareQrCode$lambda$1;
                    TribeeSteamShareQrCode$lambda$1 = TribeeSteamShareQrCode_androidKt.TribeeSteamShareQrCode$lambda$1(QrCodeProvider.this, qrCodeString, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeSteamShareQrCode$lambda$1;
                }
            });
        }
    }
}