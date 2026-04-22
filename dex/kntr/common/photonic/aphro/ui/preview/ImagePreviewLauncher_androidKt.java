package kntr.common.photonic.aphro.ui.preview;

import android.app.Activity;
import android.app.Application;
import com.bilibili.lib.brouter.uri.Uri;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.router.Router;
import kntr.common.photonic.ContentSizeKt;
import kntr.common.photonic.aphro.ui.preview.model.ImagePreviewDataNotifier;
import kntr.common.photonic.aphro.ui.preview.model.ImagePreviewDataSource;
import kntr.common.photonic.aphro.ui.preview.model.ImagePreviewOptions;
import kntr.common.photonic.aphro.ui.preview.model.OriginImageHint;
import kntr.common.photonic.aphro.ui.preview.model.PreviewableAsset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImagePreviewLauncher.android.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001aL\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\fj\u0002`\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0086@¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"launchImagePreview", "", "router", "Lkntr/base/router/Router;", "dataSource", "", "Lkntr/common/photonic/aphro/ui/preview/model/PreviewableAsset;", "initialAssetIndex", "", "imagePreviewType", "Lkntr/common/photonic/aphro/ui/preview/ImagePreviewType;", "platformContext", "Landroid/app/Activity;", "Lkntr/common/photonic/permission/PlatformContext;", "initialAlbumId", "", "(Lkntr/base/router/Router;Ljava/util/List;ILkntr/common/photonic/aphro/ui/preview/ImagePreviewType;Landroid/app/Activity;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ImagePreviewLauncher_androidKt {
    public static /* synthetic */ Object launchImagePreview$default(Router router, List list, int i, ImagePreviewType imagePreviewType, Activity activity, String str, Continuation continuation, int i2, Object obj) {
        String str2;
        if ((i2 & 32) == 0) {
            str2 = str;
        } else {
            str2 = null;
        }
        return launchImagePreview(router, list, i, imagePreviewType, activity, str2, continuation);
    }

    public static final Object launchImagePreview(Router router, List<? extends PreviewableAsset> list, int initialAssetIndex, ImagePreviewType imagePreviewType, Activity platformContext, String initialAlbumId, Continuation<? super Unit> continuation) {
        ImagePreviewDataNotifier.INSTANCE.setImagePreviewDataSource(new ImagePreviewDataSource(list, initialAssetIndex, imagePreviewType, new ImagePreviewOptions(new OriginImageHint.Threshold(ContentSizeKt.kilobytes(Boxing.boxInt(300)), null)), initialAlbumId));
        Router.Builder newBuilder = router.newBuilder();
        Application application = platformContext.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
        newBuilder.addInterceptor(new AssetPreviewInterceptor(application)).build().launch(Uri.Companion.parse(PreviewStubKt.PREVIEW_ROUTE));
        return Unit.INSTANCE;
    }
}