package kntr.common.photonic.aphro.ui.preview;

import android.content.Context;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;
import androidx.activity.SystemBarStyle;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.bilibili.lib.tribe.core.internal.Hooks;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.aphro.ui.preview.model.ImagePreviewDataNotifier;
import kntr.common.photonic.aphro.ui.preview.model.ImagePreviewDataSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: ComposeImagePreviewActivity.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\b\u001a\u00020\u0005H\u0014J\b\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"Lkntr/common/photonic/aphro/ui/preview/ComposeImagePreviewActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "finish", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposeImagePreviewActivity extends ComponentActivity {
    public static final int $stable = 8;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable$default(this, (SystemBarStyle) null, (SystemBarStyle) null, 3, (Object) null);
        final ImagePreviewDataSource imagePreviewData = ImagePreviewDataNotifier.INSTANCE.getImagePreviewDataSource();
        ComponentActivityKt.setContent$default(this, (CompositionContext) null, ComposableLambdaKt.composableLambdaInstance(1089749908, true, new Function2() { // from class: kntr.common.photonic.aphro.ui.preview.ComposeImagePreviewActivity$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                Unit onCreate$lambda$0;
                onCreate$lambda$0 = ComposeImagePreviewActivity.onCreate$lambda$0(ImagePreviewDataSource.this, this, (Composer) obj, ((Integer) obj2).intValue());
                return onCreate$lambda$0;
            }
        }), 1, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(ImagePreviewDataSource $imagePreviewData, final ComposeImagePreviewActivity this$0, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C:ComposeImagePreviewActivity.kt#n54g3c");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1089749908, $changed, -1, "kntr.common.photonic.aphro.ui.preview.ComposeImagePreviewActivity.onCreate.<anonymous> (ComposeImagePreviewActivity.kt:17)");
            }
            if ($imagePreviewData != null) {
                $composer.startReplaceGroup(-918232750);
                ComposerKt.sourceInformation($composer, "20@702L48,18@626L124");
                ComposerKt.sourceInformationMarkerStart($composer, -722354172, "CC(remember):ComposeImagePreviewActivity.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance(this$0);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.common.photonic.aphro.ui.preview.ComposeImagePreviewActivity$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            Unit onCreate$lambda$0$0$0;
                            onCreate$lambda$0$0$0 = ComposeImagePreviewActivity.onCreate$lambda$0$0$0(ComposeImagePreviewActivity.this);
                            return onCreate$lambda$0$0$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                PreviewPageContentKt.PreviewPageContent($imagePreviewData, (Function0) it$iv, $composer, 0);
            } else {
                $composer.startReplaceGroup(-918841714);
            }
            $composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0$0(ComposeImagePreviewActivity this$0) {
        this$0.finish();
        return Unit.INSTANCE;
    }

    protected void onDestroy() {
        super.onDestroy();
        ImagePreviewDataNotifier.INSTANCE.setImagePreviewDataSource(null);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }
}