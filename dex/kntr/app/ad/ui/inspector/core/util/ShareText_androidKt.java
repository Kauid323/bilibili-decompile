package kntr.app.ad.ui.inspector.core.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.content.FileProvider;
import java.io.File;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareText.android.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"ShareText", RoomRecommendViewModel.EMPTY_CURSOR, "text", RoomRecommendViewModel.EMPTY_CURSOR, "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "ad-inspector_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ShareText_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShareText$lambda$2(String str, int i, Composer composer, int i2) {
        ShareText(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ShareText(final String text, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer2 = $composer.startRestartGroup(-1045768325);
        ComposerKt.sourceInformation($composer2, "C(ShareText)N(text)13@389L7:ShareText.android.kt#5qtqsx");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(text) ? 4 : 2;
        }
        if (!$composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1045768325, $dirty, -1, "kntr.app.ad.ui.inspector.core.util.ShareText (ShareText.android.kt:12)");
            }
            CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Context context = (Context) consume;
            try {
                File cacheDir = new File(context.getCacheDir(), "shared_texts");
                if (!cacheDir.exists()) {
                    cacheDir.mkdirs();
                }
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
                File file = new File(cacheDir, "shared_text_" + timestamp + ".txt");
                FilesKt.writeText$default(file, text, (Charset) null, 2, (Object) null);
                Uri uri = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file);
                Intent $this$ShareText_u24lambda_u240 = new Intent("android.intent.action.SEND");
                $this$ShareText_u24lambda_u240.setType("text/plain");
                $this$ShareText_u24lambda_u240.putExtra("android.intent.extra.STREAM", uri);
                $this$ShareText_u24lambda_u240.addFlags(1);
                context.startActivity(Intent.createChooser($this$ShareText_u24lambda_u240, "Share via"));
            } catch (Exception e) {
                Intent $this$ShareText_u24lambda_u241 = new Intent("android.intent.action.SEND");
                $this$ShareText_u24lambda_u241.setType("text/plain");
                $this$ShareText_u24lambda_u241.putExtra("android.intent.extra.TEXT", text);
                context.startActivity(Intent.createChooser($this$ShareText_u24lambda_u241, "Share via"));
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.inspector.core.util.ShareText_androidKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit ShareText$lambda$2;
                    ShareText$lambda$2 = ShareText_androidKt.ShareText$lambda$2(text, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return ShareText$lambda$2;
                }
            });
        }
    }
}