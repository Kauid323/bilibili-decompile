package kntr.base.imageloader;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.redirect.RedirectImpKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Api.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a+\u0010\u0002\u001a\u00020\u0003*\u00020\u00012\u0019\b\u0002\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0086\bø\u0001\u0000\u001a\n\u0010\t\u001a\u00020\u0006*\u00020\u0001\u001a\u0012\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"TAG", "", "asRequest", "Lkntr/base/imageloader/ImmutableImageRequest;", RedirectImpKt.REDIRECT_KV_CONFIG, "Lkotlin/Function1;", "Lkntr/base/imageloader/ImageRequest;", "", "Lkotlin/ExtensionFunctionType;", "toImageRequest", "findExifInfoForPlatform", "tag", "Lkntr/base/imageloader/ExifTag;", "imageloader_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ApiKt {
    public static final String TAG = "BiliImageCompose_";

    public static final ImmutableImageRequest asRequest(String $this$asRequest, Function1<? super ImageRequest, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$asRequest, "<this>");
        Intrinsics.checkNotNullParameter(function1, RedirectImpKt.REDIRECT_KV_CONFIG);
        ImageRequest imageRequest = new ImageRequest($this$asRequest);
        function1.invoke(imageRequest);
        return imageRequest.build();
    }

    public static /* synthetic */ ImmutableImageRequest asRequest$default(String $this$asRequest_u24default, Function1 config, int i, Object obj) {
        if ((i & 1) != 0) {
            Function1 config2 = new Function1<ImageRequest, Unit>() { // from class: kntr.base.imageloader.ApiKt$asRequest$1
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((ImageRequest) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(ImageRequest imageRequest) {
                    Intrinsics.checkNotNullParameter(imageRequest, "<this>");
                }
            };
            config = config2;
        }
        Intrinsics.checkNotNullParameter($this$asRequest_u24default, "<this>");
        Intrinsics.checkNotNullParameter(config, RedirectImpKt.REDIRECT_KV_CONFIG);
        ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default);
        config.invoke(imageRequest);
        return imageRequest.build();
    }

    public static final ImageRequest toImageRequest(String $this$toImageRequest) {
        Intrinsics.checkNotNullParameter($this$toImageRequest, "<this>");
        return new ImageRequest($this$toImageRequest);
    }

    public static final String findExifInfoForPlatform(String $this$findExifInfoForPlatform, ExifTag tag) {
        Intrinsics.checkNotNullParameter($this$findExifInfoForPlatform, "<this>");
        Intrinsics.checkNotNullParameter(tag, "tag");
        return UtilKt.findExifInfo($this$findExifInfoForPlatform, tag);
    }
}