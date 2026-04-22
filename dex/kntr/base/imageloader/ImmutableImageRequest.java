package kntr.base.imageloader;

import com.bilibili.lib.brouter.uri.Uri;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ImageRequest.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\r\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\nJ\r\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\rJ\r\u0010\u000e\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0002J\f\u0010\u0013\u001a\u00020\u0011*\u00020\u0007H\u0002J\f\u0010\u0014\u001a\u00020\u0011*\u00020\u0007H\u0002J\u0006\u0010\u0014\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0011J\t\u0010\u0015\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lkntr/base/imageloader/ImmutableImageRequest;", "", "originRequest", "Lkntr/base/imageloader/ImageRequest;", "<init>", "(Lkntr/base/imageloader/ImageRequest;)V", "takeImageUrl", "", "getProtocol", "Lkntr/base/imageloader/BfsProtocol;", "getProtocol$imageloader_debug", "getOptions", "Lkntr/base/imageloader/BiliImageOptions;", "getOptions$imageloader_debug", "toMutableRequest", "toMutableRequest$imageloader_debug", "disableBfs", "", "req", "isNet", "isLocal", "component1", "copy", "equals", "other", "hashCode", "", "toString", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ImmutableImageRequest {
    public static final int $stable = 0;
    private final ImageRequest originRequest;

    private final ImageRequest component1() {
        return this.originRequest;
    }

    public static /* synthetic */ ImmutableImageRequest copy$default(ImmutableImageRequest immutableImageRequest, ImageRequest imageRequest, int i, Object obj) {
        if ((i & 1) != 0) {
            imageRequest = immutableImageRequest.originRequest;
        }
        return immutableImageRequest.copy(imageRequest);
    }

    public final ImmutableImageRequest copy(ImageRequest imageRequest) {
        Intrinsics.checkNotNullParameter(imageRequest, "originRequest");
        return new ImmutableImageRequest(imageRequest);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ImmutableImageRequest) && Intrinsics.areEqual(this.originRequest, ((ImmutableImageRequest) obj).originRequest);
    }

    public int hashCode() {
        return this.originRequest.hashCode();
    }

    public String toString() {
        return "ImmutableImageRequest(originRequest=" + this.originRequest + ")";
    }

    public ImmutableImageRequest(ImageRequest originRequest) {
        Intrinsics.checkNotNullParameter(originRequest, "originRequest");
        this.originRequest = originRequest;
    }

    public final String takeImageUrl() {
        String target;
        String raw = this.originRequest.getRawUrl$imageloader_debug();
        String parseUrl = this.originRequest.getParseUrl$imageloader_debug();
        if (this.originRequest.getOptions$imageloader_debug().getUseRaw() || !isNet(parseUrl) || !ImageRequestKt.access$isBfsUrl(parseUrl)) {
            return raw;
        }
        if (disableBfs(this.originRequest)) {
            target = StringsKt.substringBefore$default(raw, "@", (String) null, 2, (Object) null);
        } else {
            target = parseUrl + this.originRequest.getProtocol$imageloader_debug().join(parseUrl);
        }
        if (this.originRequest.getProtocol$imageloader_debug().getGray$imageloader_debug()) {
            Uri originUri = Uri.Companion.parse(target);
            if (!originUri.getQueryParameterNames().contains("gray_scale")) {
                return Uri.Companion.parse(target).buildUpon().appendQueryParameter("gray_scale", "1").build().toString();
            }
            return target;
        }
        return target;
    }

    public final BfsProtocol getProtocol$imageloader_debug() {
        return BfsProtocol.m1414copy6rHxNw4$default(this.originRequest.getProtocol$imageloader_debug(), 0, 0, 0, null, null, null, null, false, null, null, null, false, false, false, false, null, 65535, null);
    }

    public final BiliImageOptions getOptions$imageloader_debug() {
        return BiliImageOptions.m1431copySsDZD_g$default(this.originRequest.getOptions$imageloader_debug(), false, 0, false, false, false, null, null, 0.0f, null, null, null, null, null, 8191, null);
    }

    public final ImageRequest toMutableRequest$imageloader_debug() {
        return this.originRequest.deepCopy$imageloader_debug();
    }

    private final boolean disableBfs(ImageRequest req) {
        return req.getOptions$imageloader_debug().getUseOrigin() || StringsKt.endsWith$default(req.getRawUrl$imageloader_debug(), "svga", false, 2, (Object) null) || StringsKt.endsWith$default(req.getRawUrl$imageloader_debug(), "lottie", false, 2, (Object) null) || StringsKt.endsWith$default(req.getRawUrl$imageloader_debug(), "json", false, 2, (Object) null) || StringsKt.endsWith$default(req.getRawUrl$imageloader_debug(), "zip", false, 2, (Object) null);
    }

    private final boolean isNet(String $this$isNet) {
        return StringsKt.startsWith$default($this$isNet, "https", false, 2, (Object) null) || StringsKt.startsWith$default($this$isNet, "http", false, 2, (Object) null);
    }

    private final boolean isLocal(String $this$isLocal) {
        return !isNet($this$isLocal);
    }

    public final boolean isLocal() {
        return isLocal(this.originRequest.getRawUrl$imageloader_debug());
    }

    public final boolean isNet() {
        return isNet(this.originRequest.getRawUrl$imageloader_debug());
    }
}