package kntr.common.photonic.aphro.ui;

import com.bilibili.lib.brouter.uri.Builder;
import com.bilibili.lib.brouter.uri.Uri;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.router.Router;
import kntr.common.photonic.gallery.entity.AndroidImage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;

/* compiled from: AssetPreview.android.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"previewAsset", "", "router", "Lkntr/base/router/Router;", "previewConfig", "Lkntr/common/photonic/aphro/ui/AssetPreviewConfig;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AssetPreview_androidKt {
    public static final void previewAsset(Router router, AssetPreviewConfig previewConfig) {
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(previewConfig, "previewConfig");
        if (previewConfig.getCurrentAsset() instanceof AndroidImage) {
            String key = String.valueOf(Clock.System.INSTANCE.now().toEpochMilliseconds());
            AssetPreviewHolder.INSTANCE.put(key, previewConfig);
            Builder $this$previewAsset_u24lambda_u240 = Uri.Companion.parse("bilibili://aphro/preview/images").buildUpon();
            $this$previewAsset_u24lambda_u240.appendQueryParameter("preview_interceptor", "kntr");
            $this$previewAsset_u24lambda_u240.appendQueryParameter("preview_config_key", key);
            router.launch($this$previewAsset_u24lambda_u240.build());
        }
    }
}