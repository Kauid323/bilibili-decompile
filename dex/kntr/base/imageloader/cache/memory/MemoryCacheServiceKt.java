package kntr.base.imageloader.cache.memory;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageOptions;
import kntr.base.imageloader.ImmutableImageRequest;
import kntr.base.imageloader.Pixel;
import kntr.base.imageloader.ResizeOption;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MemoryCacheService.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"TAG", "", "getCacheKeyString", "Lkntr/base/imageloader/ImmutableImageRequest;", "finalSize", "Lkntr/base/imageloader/ResizeOption;", "Lkntr/base/imageloader/BiliImageOptions;", "request", "imageloader_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class MemoryCacheServiceKt {
    private static final String TAG = "MemoryCacheService";

    public static final String getCacheKeyString(ImmutableImageRequest $this$getCacheKeyString) {
        BiliImageOptions options$imageloader_debug;
        ResizeOption it;
        Intrinsics.checkNotNullParameter($this$getCacheKeyString, "<this>");
        String url = $this$getCacheKeyString.takeImageUrl();
        ImmutableImageRequest immutableImageRequest = $this$getCacheKeyString.isLocal() ? $this$getCacheKeyString : null;
        if (immutableImageRequest != null && (options$imageloader_debug = immutableImageRequest.getOptions$imageloader_debug()) != null && (it = finalSize(options$imageloader_debug, $this$getCacheKeyString)) != null) {
            String str = url + "_" + Pixel.m1521toStringimpl(it.m1563getWidthuhUG8m8()) + "x" + Pixel.m1521toStringimpl(it.m1562getHeightuhUG8m8());
            if (str != null) {
                return str;
            }
        }
        return url;
    }

    private static final ResizeOption finalSize(BiliImageOptions $this$finalSize, ImmutableImageRequest request) {
        if ($this$finalSize.getResizeOption() == null || Intrinsics.areEqual($this$finalSize.getResizeOption(), ResizeOption.Companion.getAUTO())) {
            return new ResizeOption(request.getProtocol$imageloader_debug().m1427getWidthuhUG8m8$imageloader_debug(), request.getProtocol$imageloader_debug().m1422getHeightuhUG8m8$imageloader_debug(), null);
        }
        return $this$finalSize.getResizeOption();
    }
}