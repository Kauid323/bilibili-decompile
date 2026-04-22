package kntr.base.imageloader;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import com.bilibili.lib.brouter.uri.Uri;
import com.bilibili.lib.brouter.uri.Url;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.cache.CachePolicy;
import kntr.base.log.ILogger;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: ImageRequest.kt */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0019¢\u0006\u0004\b\u001e\u0010\u001bJ\u0015\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!¢\u0006\u0004\b\"\u0010\u001bJ\u000e\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%J\u0015\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(¢\u0006\u0004\b)\u0010*J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-J\u000e\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u000200J\u0010\u00101\u001a\u00020\u00002\b\b\u0002\u00102\u001a\u000203J\u0015\u00104\u001a\u00020\u00002\u0006\u00105\u001a\u000206¢\u0006\u0004\b7\u00108J\u0015\u00109\u001a\u00020\u00002\u0006\u0010:\u001a\u00020;¢\u0006\u0004\b<\u00108J\u000e\u0010=\u001a\u00020\u00002\u0006\u0010>\u001a\u00020?J\u0010\u0010@\u001a\u00020\u00002\b\b\u0002\u0010A\u001a\u000203J\u0010\u0010B\u001a\u00020\u00002\b\b\u0002\u0010C\u001a\u000203J\u0010\u0010D\u001a\u00020\u00002\b\b\u0002\u0010D\u001a\u000203J!\u0010E\u001a\u00020\u00002\b\b\u0002\u0010F\u001a\u00020\u00192\b\b\u0002\u0010G\u001a\u00020\u0019¢\u0006\u0004\bH\u0010IJ\u0010\u0010J\u001a\u00020\u00002\b\b\u0002\u0010J\u001a\u000203J\u0015\u0010K\u001a\u00020\u00002\u0006\u0010K\u001a\u00020L¢\u0006\u0004\bM\u0010\u001bJ\u0010\u0010N\u001a\u00020\u00002\b\b\u0002\u0010N\u001a\u000203J\u000e\u0010O\u001a\u00020\u00002\u0006\u0010O\u001a\u00020PJ\u0010\u0010Q\u001a\u00020\u00002\b\b\u0002\u0010Q\u001a\u000203J\u0010\u0010R\u001a\u00020\u00002\b\b\u0002\u0010R\u001a\u000203J\u000e\u0010S\u001a\u00020\u00002\u0006\u0010S\u001a\u00020TJ\u0015\u0010U\u001a\u00020\u00002\u0006\u0010U\u001a\u00020V¢\u0006\u0004\bW\u0010XJ\u000e\u0010Y\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020ZJ\u000e\u0010[\u001a\u00020\u00002\u0006\u0010[\u001a\u00020\\J\u000e\u0010]\u001a\u00020\u00002\u0006\u0010]\u001a\u00020^J\u000e\u0010_\u001a\u00020\u00002\u0006\u0010`\u001a\u00020aJ\u000e\u0010b\u001a\u00020\u00002\u0006\u0010`\u001a\u00020aJ\u0006\u0010c\u001a\u00020dJ\u001f\u0010e\u001a\u00020\u00002\u0006\u0010f\u001a\u00020\u00192\u0006\u0010g\u001a\u00020\u0019H\u0000¢\u0006\u0004\bh\u0010IJ\f\u0010i\u001a\u00020j*\u00020jH\u0002J\r\u0010k\u001a\u00020\u0000H\u0000¢\u0006\u0002\blJ\u0013\u0010m\u001a\u0002032\b\u0010n\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010o\u001a\u00020pH\u0016J\u000e\u0010q\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\brJ\u0013\u0010s\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010t\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0007\"\u0004\b\n\u0010\u0005R\u001a\u0010\u000b\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006u"}, d2 = {"Lkntr/base/imageloader/ImageRequest;", "", "rawUrl", "", "<init>", "(Ljava/lang/String;)V", "getRawUrl$imageloader_debug", "()Ljava/lang/String;", "parseUrl", "getParseUrl$imageloader_debug", "setParseUrl$imageloader_debug", "protocol", "Lkntr/base/imageloader/BfsProtocol;", "getProtocol$imageloader_debug", "()Lkntr/base/imageloader/BfsProtocol;", "setProtocol$imageloader_debug", "(Lkntr/base/imageloader/BfsProtocol;)V", "options", "Lkntr/base/imageloader/BiliImageOptions;", "getOptions$imageloader_debug", "()Lkntr/base/imageloader/BiliImageOptions;", "setOptions$imageloader_debug", "(Lkntr/base/imageloader/BiliImageOptions;)V", "requestWidth", "width", "Lkntr/base/imageloader/Pixel;", "requestWidth-3VbuI34", "(I)Lkntr/base/imageloader/ImageRequest;", "requestHeight", "height", "requestHeight-3VbuI34", "requestQuality", "quality", "Lkntr/base/imageloader/Quality;", "requestQuality-Ac6X4_Q", "requestFormat", "format", "Lkntr/base/imageloader/SupportImageType;", "requestStyle", "style", "Lkntr/base/imageloader/Style;", "requestStyle-R_Oh58k", "(Ljava/lang/String;)Lkntr/base/imageloader/ImageRequest;", "requestCrop", "crop", "Lkntr/base/imageloader/ImageCrop;", "requestRegionCrop", "regionCrop", "Lkntr/base/imageloader/ImageRegionCrop;", "requestAutoCrop", "autoCrop", "", "requestPercent", "percent", "Lkntr/base/imageloader/Percent;", "requestPercent-D0msbVc", "(Ljava/lang/Integer;)Lkntr/base/imageloader/ImageRequest;", "requestPriorityScaleEdge", "priorityScaleEdge", "Lkntr/base/imageloader/PriorityScaleEdge;", "requestPriorityScaleEdge-nYmw4LM", "requestBlur", "blur", "Lkntr/base/imageloader/BlurOption;", "requestRotate", "rotate", "requestFirstFrame", "firstFrame", "gray", "noLimitSize", "requireWidth", "requireHeight", "noLimitSize-Ic4ZqO0", "(II)Lkntr/base/imageloader/ImageRequest;", "enableAnimate", "animateLoopCount", "Lkntr/base/imageloader/LoopCount;", "animateLoopCount-SW3asMM", "autoPlay", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "useRaw", "useOrigin", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "Lkntr/base/imageloader/Alpha;", "alpha-EQRtbio", "(F)Lkntr/base/imageloader/ImageRequest;", "align", "Landroidx/compose/ui/Alignment;", "animateStrategy", "Lkntr/base/imageloader/AnimateStrategy;", "resizeOption", "Lkntr/base/imageloader/ResizeOption;", "memoryCachePolicy", "policy", "Lkntr/base/imageloader/cache/CachePolicy;", "diskCachePolicy", "build", "Lkntr/base/imageloader/ImmutableImageRequest;", "gears", "measureW", "measureH", "gears-Ic4ZqO0$imageloader_debug", "purifyUrl", "Lcom/bilibili/lib/brouter/uri/Uri;", "deepCopy", "deepCopy$imageloader_debug", "equals", "other", "hashCode", "", "component1", "component1$imageloader_debug", "copy", "toString", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ImageRequest {
    public static final int $stable = 8;
    private BiliImageOptions options;
    private String parseUrl;
    private BfsProtocol protocol;
    private final String rawUrl;

    public ImageRequest() {
        this(null, 1, null);
    }

    public static /* synthetic */ ImageRequest copy$default(ImageRequest imageRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = imageRequest.rawUrl;
        }
        return imageRequest.copy(str);
    }

    public final String component1$imageloader_debug() {
        return this.rawUrl;
    }

    public final ImageRequest copy(String str) {
        Intrinsics.checkNotNullParameter(str, "rawUrl");
        return new ImageRequest(str);
    }

    public String toString() {
        return "ImageRequest(rawUrl=" + this.rawUrl + ")";
    }

    public ImageRequest(String rawUrl) {
        Intrinsics.checkNotNullParameter(rawUrl, "rawUrl");
        this.rawUrl = rawUrl;
        this.parseUrl = "";
        this.protocol = new BfsProtocol(0, 0, 0, null, null, null, null, false, null, null, null, false, false, false, false, null, 65535, null);
        this.options = new BiliImageOptions(false, 0, false, false, false, null, null, 0.0f, null, null, null, null, null, 8191, null);
        try {
            this.parseUrl = purifyUrl(Uri.Companion.parse(this.rawUrl)).toString();
        } catch (Throwable t) {
            ILogger kLog = KLog_androidKt.getKLog();
            String message = t.getMessage();
            kLog.e(ApiKt.TAG, "url parse error, message = " + message + ", cause = " + t.getCause());
        }
    }

    public /* synthetic */ ImageRequest(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }

    public final String getRawUrl$imageloader_debug() {
        return this.rawUrl;
    }

    public final String getParseUrl$imageloader_debug() {
        return this.parseUrl;
    }

    public final void setParseUrl$imageloader_debug(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.parseUrl = str;
    }

    public final BfsProtocol getProtocol$imageloader_debug() {
        return this.protocol;
    }

    public final void setProtocol$imageloader_debug(BfsProtocol bfsProtocol) {
        Intrinsics.checkNotNullParameter(bfsProtocol, "<set-?>");
        this.protocol = bfsProtocol;
    }

    public final BiliImageOptions getOptions$imageloader_debug() {
        return this.options;
    }

    public final void setOptions$imageloader_debug(BiliImageOptions biliImageOptions) {
        Intrinsics.checkNotNullParameter(biliImageOptions, "<set-?>");
        this.options = biliImageOptions;
    }

    /* renamed from: requestWidth-3VbuI34 */
    public final ImageRequest m1493requestWidth3VbuI34(int i) {
        ImageRequest $this$requestWidth_3VbuI34_u24lambda_u240 = this;
        $this$requestWidth_3VbuI34_u24lambda_u240.protocol = BfsProtocol.m1414copy6rHxNw4$default($this$requestWidth_3VbuI34_u24lambda_u240.protocol, i, 0, 0, null, null, null, null, false, null, null, null, false, false, false, false, null, 65534, null);
        return this;
    }

    /* renamed from: requestHeight-3VbuI34 */
    public final ImageRequest m1488requestHeight3VbuI34(int i) {
        ImageRequest $this$requestHeight_3VbuI34_u24lambda_u240 = this;
        $this$requestHeight_3VbuI34_u24lambda_u240.protocol = BfsProtocol.m1414copy6rHxNw4$default($this$requestHeight_3VbuI34_u24lambda_u240.protocol, 0, i, 0, null, null, null, null, false, null, null, null, false, false, false, false, null, 65533, null);
        return this;
    }

    /* renamed from: requestQuality-Ac6X4_Q */
    public final ImageRequest m1491requestQualityAc6X4_Q(int i) {
        ImageRequest $this$requestQuality_Ac6X4_Q_u24lambda_u240 = this;
        $this$requestQuality_Ac6X4_Q_u24lambda_u240.protocol = BfsProtocol.m1414copy6rHxNw4$default($this$requestQuality_Ac6X4_Q_u24lambda_u240.protocol, 0, 0, i, null, null, null, null, false, null, null, null, false, false, false, false, null, 65531, null);
        return this;
    }

    public final ImageRequest requestFormat(SupportImageType format) {
        Intrinsics.checkNotNullParameter(format, "format");
        ImageRequest $this$requestFormat_u24lambda_u240 = this;
        $this$requestFormat_u24lambda_u240.protocol = BfsProtocol.m1414copy6rHxNw4$default($this$requestFormat_u24lambda_u240.protocol, 0, 0, 0, format, null, null, null, false, null, null, null, false, false, false, false, null, 65527, null);
        return this;
    }

    /* renamed from: requestStyle-R_Oh58k */
    public final ImageRequest m1492requestStyleR_Oh58k(String str) {
        ImageRequest $this$requestStyle_R_Oh58k_u24lambda_u240 = this;
        $this$requestStyle_R_Oh58k_u24lambda_u240.protocol = BfsProtocol.m1414copy6rHxNw4$default($this$requestStyle_R_Oh58k_u24lambda_u240.protocol, 0, 0, 0, null, Style.m1583boximpl(str), null, null, false, null, null, null, false, false, false, false, null, 65519, null);
        return this;
    }

    public final ImageRequest requestCrop(ImageCrop crop) {
        Intrinsics.checkNotNullParameter(crop, "crop");
        ImageRequest $this$requestCrop_u24lambda_u240 = this;
        $this$requestCrop_u24lambda_u240.protocol = BfsProtocol.m1414copy6rHxNw4$default($this$requestCrop_u24lambda_u240.protocol, 0, 0, 0, null, null, crop, null, false, null, null, null, false, false, false, false, null, 65503, null);
        return this;
    }

    public final ImageRequest requestRegionCrop(ImageRegionCrop regionCrop) {
        Intrinsics.checkNotNullParameter(regionCrop, "regionCrop");
        ImageRequest $this$requestRegionCrop_u24lambda_u240 = this;
        $this$requestRegionCrop_u24lambda_u240.protocol = BfsProtocol.m1414copy6rHxNw4$default($this$requestRegionCrop_u24lambda_u240.protocol, 0, 0, 0, null, null, null, regionCrop, false, null, null, null, false, false, false, false, null, 65471, null);
        return this;
    }

    public static /* synthetic */ ImageRequest requestAutoCrop$default(ImageRequest imageRequest, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return imageRequest.requestAutoCrop(z);
    }

    public final ImageRequest requestAutoCrop(boolean autoCrop) {
        ImageRequest $this$requestAutoCrop_u24lambda_u240 = this;
        $this$requestAutoCrop_u24lambda_u240.protocol = BfsProtocol.m1414copy6rHxNw4$default($this$requestAutoCrop_u24lambda_u240.protocol, 0, 0, 0, null, null, null, null, autoCrop, null, null, null, false, false, false, false, null, 65407, null);
        return this;
    }

    /* renamed from: requestPercent-D0msbVc */
    public final ImageRequest m1489requestPercentD0msbVc(Integer num) {
        ImageRequest $this$requestPercent_D0msbVc_u24lambda_u240 = this;
        $this$requestPercent_D0msbVc_u24lambda_u240.protocol = BfsProtocol.m1414copy6rHxNw4$default($this$requestPercent_D0msbVc_u24lambda_u240.protocol, 0, 0, 0, null, null, null, null, false, Percent.m1508boximpl(num), null, null, false, false, false, false, null, 65279, null);
        return this;
    }

    /* renamed from: requestPriorityScaleEdge-nYmw4LM */
    public final ImageRequest m1490requestPriorityScaleEdgenYmw4LM(Integer num) {
        ImageRequest $this$requestPriorityScaleEdge_nYmw4LM_u24lambda_u240 = this;
        $this$requestPriorityScaleEdge_nYmw4LM_u24lambda_u240.protocol = BfsProtocol.m1414copy6rHxNw4$default($this$requestPriorityScaleEdge_nYmw4LM_u24lambda_u240.protocol, 0, 0, 0, null, null, null, null, false, null, PriorityScaleEdge.m1533boximpl(num), null, false, false, false, false, null, 65023, null);
        return this;
    }

    public final ImageRequest requestBlur(BlurOption blur) {
        Intrinsics.checkNotNullParameter(blur, "blur");
        ImageRequest $this$requestBlur_u24lambda_u240 = this;
        $this$requestBlur_u24lambda_u240.protocol = BfsProtocol.m1414copy6rHxNw4$default($this$requestBlur_u24lambda_u240.protocol, 0, 0, 0, null, null, null, null, false, null, null, blur, false, false, false, false, null, 64511, null);
        return this;
    }

    public static /* synthetic */ ImageRequest requestRotate$default(ImageRequest imageRequest, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return imageRequest.requestRotate(z);
    }

    public final ImageRequest requestRotate(boolean rotate) {
        ImageRequest $this$requestRotate_u24lambda_u240 = this;
        $this$requestRotate_u24lambda_u240.protocol = BfsProtocol.m1414copy6rHxNw4$default($this$requestRotate_u24lambda_u240.protocol, 0, 0, 0, null, null, null, null, false, null, null, null, rotate, false, false, false, null, 63487, null);
        return this;
    }

    public static /* synthetic */ ImageRequest requestFirstFrame$default(ImageRequest imageRequest, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return imageRequest.requestFirstFrame(z);
    }

    public final ImageRequest requestFirstFrame(boolean firstFrame) {
        ImageRequest $this$requestFirstFrame_u24lambda_u240 = this;
        $this$requestFirstFrame_u24lambda_u240.protocol = BfsProtocol.m1414copy6rHxNw4$default($this$requestFirstFrame_u24lambda_u240.protocol, 0, 0, 0, null, null, null, null, false, null, null, null, false, firstFrame, false, false, null, 61439, null);
        return this;
    }

    public static /* synthetic */ ImageRequest gray$default(ImageRequest imageRequest, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return imageRequest.gray(z);
    }

    public final ImageRequest gray(boolean gray) {
        ImageRequest $this$gray_u24lambda_u240 = this;
        $this$gray_u24lambda_u240.protocol = BfsProtocol.m1414copy6rHxNw4$default($this$gray_u24lambda_u240.protocol, 0, 0, 0, null, null, null, null, false, null, null, null, false, false, gray, false, null, 57343, null);
        return this;
    }

    /* renamed from: noLimitSize-Ic4ZqO0$default */
    public static /* synthetic */ ImageRequest m1483noLimitSizeIc4ZqO0$default(ImageRequest imageRequest, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = Pixel.Companion.m1523getUNSETuhUG8m8();
        }
        if ((i3 & 2) != 0) {
            i2 = Pixel.Companion.m1523getUNSETuhUG8m8();
        }
        return imageRequest.m1487noLimitSizeIc4ZqO0(i, i2);
    }

    /* renamed from: noLimitSize-Ic4ZqO0 */
    public final ImageRequest m1487noLimitSizeIc4ZqO0(int i, int i2) {
        ImageRequest $this$noLimitSize_Ic4ZqO0_u24lambda_u240 = this;
        if (Pixel.m1519equalsimpl0(i, Pixel.Companion.m1523getUNSETuhUG8m8()) || Pixel.m1519equalsimpl0(i2, Pixel.Companion.m1523getUNSETuhUG8m8())) {
            $this$noLimitSize_Ic4ZqO0_u24lambda_u240.protocol = BfsProtocol.m1414copy6rHxNw4$default($this$noLimitSize_Ic4ZqO0_u24lambda_u240.protocol, 0, 0, 0, null, null, null, null, false, null, null, null, false, false, false, false, new Size(i, i2, null), 32767, null);
            return this;
        }
        throw new IllegalArgumentException("noLimitSize only support one side");
    }

    public static /* synthetic */ ImageRequest enableAnimate$default(ImageRequest imageRequest, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return imageRequest.enableAnimate(z);
    }

    public final ImageRequest enableAnimate(boolean enableAnimate) {
        BiliImageOptions m1434copySsDZD_g;
        ImageRequest $this$enableAnimate_u24lambda_u240 = this;
        m1434copySsDZD_g = r2.m1434copySsDZD_g((r28 & 1) != 0 ? r2.enableAnimate : enableAnimate, (r28 & 2) != 0 ? r2.animateLoopCount : 0, (r28 & 4) != 0 ? r2.autoPlay : false, (r28 & 8) != 0 ? r2.useRaw : false, (r28 & 16) != 0 ? r2.useOrigin : false, (r28 & 32) != 0 ? r2.align : null, (r28 & 64) != 0 ? r2.contentScale : null, (r28 & 128) != 0 ? r2.alpha : 0.0f, (r28 & 256) != 0 ? r2.colorFilter : null, (r28 & 512) != 0 ? r2.animateStrategy : null, (r28 & 1024) != 0 ? r2.resizeOption : null, (r28 & 2048) != 0 ? r2.memoryCachePolicy : null, (r28 & 4096) != 0 ? $this$enableAnimate_u24lambda_u240.options.diskCachePolicy : null);
        $this$enableAnimate_u24lambda_u240.options = m1434copySsDZD_g;
        return this;
    }

    /* renamed from: animateLoopCount-SW3asMM */
    public final ImageRequest m1485animateLoopCountSW3asMM(int i) {
        BiliImageOptions m1434copySsDZD_g;
        ImageRequest $this$animateLoopCount_SW3asMM_u24lambda_u240 = this;
        m1434copySsDZD_g = r2.m1434copySsDZD_g((r28 & 1) != 0 ? r2.enableAnimate : false, (r28 & 2) != 0 ? r2.animateLoopCount : i, (r28 & 4) != 0 ? r2.autoPlay : false, (r28 & 8) != 0 ? r2.useRaw : false, (r28 & 16) != 0 ? r2.useOrigin : false, (r28 & 32) != 0 ? r2.align : null, (r28 & 64) != 0 ? r2.contentScale : null, (r28 & 128) != 0 ? r2.alpha : 0.0f, (r28 & 256) != 0 ? r2.colorFilter : null, (r28 & 512) != 0 ? r2.animateStrategy : null, (r28 & 1024) != 0 ? r2.resizeOption : null, (r28 & 2048) != 0 ? r2.memoryCachePolicy : null, (r28 & 4096) != 0 ? $this$animateLoopCount_SW3asMM_u24lambda_u240.options.diskCachePolicy : null);
        $this$animateLoopCount_SW3asMM_u24lambda_u240.options = m1434copySsDZD_g;
        return this;
    }

    public static /* synthetic */ ImageRequest autoPlay$default(ImageRequest imageRequest, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return imageRequest.autoPlay(z);
    }

    public final ImageRequest autoPlay(boolean autoPlay) {
        BiliImageOptions m1434copySsDZD_g;
        ImageRequest $this$autoPlay_u24lambda_u240 = this;
        m1434copySsDZD_g = r2.m1434copySsDZD_g((r28 & 1) != 0 ? r2.enableAnimate : false, (r28 & 2) != 0 ? r2.animateLoopCount : 0, (r28 & 4) != 0 ? r2.autoPlay : autoPlay, (r28 & 8) != 0 ? r2.useRaw : false, (r28 & 16) != 0 ? r2.useOrigin : false, (r28 & 32) != 0 ? r2.align : null, (r28 & 64) != 0 ? r2.contentScale : null, (r28 & 128) != 0 ? r2.alpha : 0.0f, (r28 & 256) != 0 ? r2.colorFilter : null, (r28 & 512) != 0 ? r2.animateStrategy : null, (r28 & 1024) != 0 ? r2.resizeOption : null, (r28 & 2048) != 0 ? r2.memoryCachePolicy : null, (r28 & 4096) != 0 ? $this$autoPlay_u24lambda_u240.options.diskCachePolicy : null);
        $this$autoPlay_u24lambda_u240.options = m1434copySsDZD_g;
        return this;
    }

    public final ImageRequest colorFilter(ColorFilter colorFilter) {
        BiliImageOptions m1434copySsDZD_g;
        Intrinsics.checkNotNullParameter(colorFilter, "colorFilter");
        ImageRequest $this$colorFilter_u24lambda_u240 = this;
        m1434copySsDZD_g = r1.m1434copySsDZD_g((r28 & 1) != 0 ? r1.enableAnimate : false, (r28 & 2) != 0 ? r1.animateLoopCount : 0, (r28 & 4) != 0 ? r1.autoPlay : false, (r28 & 8) != 0 ? r1.useRaw : false, (r28 & 16) != 0 ? r1.useOrigin : false, (r28 & 32) != 0 ? r1.align : null, (r28 & 64) != 0 ? r1.contentScale : null, (r28 & 128) != 0 ? r1.alpha : 0.0f, (r28 & 256) != 0 ? r1.colorFilter : colorFilter, (r28 & 512) != 0 ? r1.animateStrategy : null, (r28 & 1024) != 0 ? r1.resizeOption : null, (r28 & 2048) != 0 ? r1.memoryCachePolicy : null, (r28 & 4096) != 0 ? $this$colorFilter_u24lambda_u240.options.diskCachePolicy : null);
        $this$colorFilter_u24lambda_u240.options = m1434copySsDZD_g;
        return this;
    }

    public static /* synthetic */ ImageRequest useRaw$default(ImageRequest imageRequest, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return imageRequest.useRaw(z);
    }

    public final ImageRequest useRaw(boolean useRaw) {
        BiliImageOptions m1434copySsDZD_g;
        ImageRequest $this$useRaw_u24lambda_u240 = this;
        m1434copySsDZD_g = r2.m1434copySsDZD_g((r28 & 1) != 0 ? r2.enableAnimate : false, (r28 & 2) != 0 ? r2.animateLoopCount : 0, (r28 & 4) != 0 ? r2.autoPlay : false, (r28 & 8) != 0 ? r2.useRaw : useRaw, (r28 & 16) != 0 ? r2.useOrigin : false, (r28 & 32) != 0 ? r2.align : null, (r28 & 64) != 0 ? r2.contentScale : null, (r28 & 128) != 0 ? r2.alpha : 0.0f, (r28 & 256) != 0 ? r2.colorFilter : null, (r28 & 512) != 0 ? r2.animateStrategy : null, (r28 & 1024) != 0 ? r2.resizeOption : null, (r28 & 2048) != 0 ? r2.memoryCachePolicy : null, (r28 & 4096) != 0 ? $this$useRaw_u24lambda_u240.options.diskCachePolicy : null);
        $this$useRaw_u24lambda_u240.options = m1434copySsDZD_g;
        return this;
    }

    public static /* synthetic */ ImageRequest useOrigin$default(ImageRequest imageRequest, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return imageRequest.useOrigin(z);
    }

    public final ImageRequest useOrigin(boolean useOrigin) {
        BiliImageOptions m1434copySsDZD_g;
        ImageRequest $this$useOrigin_u24lambda_u240 = this;
        m1434copySsDZD_g = r2.m1434copySsDZD_g((r28 & 1) != 0 ? r2.enableAnimate : false, (r28 & 2) != 0 ? r2.animateLoopCount : 0, (r28 & 4) != 0 ? r2.autoPlay : false, (r28 & 8) != 0 ? r2.useRaw : false, (r28 & 16) != 0 ? r2.useOrigin : useOrigin, (r28 & 32) != 0 ? r2.align : null, (r28 & 64) != 0 ? r2.contentScale : null, (r28 & 128) != 0 ? r2.alpha : 0.0f, (r28 & 256) != 0 ? r2.colorFilter : null, (r28 & 512) != 0 ? r2.animateStrategy : null, (r28 & 1024) != 0 ? r2.resizeOption : null, (r28 & 2048) != 0 ? r2.memoryCachePolicy : null, (r28 & 4096) != 0 ? $this$useOrigin_u24lambda_u240.options.diskCachePolicy : null);
        $this$useOrigin_u24lambda_u240.options = m1434copySsDZD_g;
        return this;
    }

    public final ImageRequest contentScale(ContentScale contentScale) {
        boolean isBfsUrl;
        BiliImageOptions m1434copySsDZD_g;
        Intrinsics.checkNotNullParameter(contentScale, "contentScale");
        ImageRequest $this$contentScale_u24lambda_u240 = this;
        isBfsUrl = ImageRequestKt.isBfsUrl($this$contentScale_u24lambda_u240.parseUrl);
        if (isBfsUrl) {
            $this$contentScale_u24lambda_u240.protocol = $this$contentScale_u24lambda_u240.protocol.enhanceWithContentScale(contentScale);
        }
        m1434copySsDZD_g = r0.m1434copySsDZD_g((r28 & 1) != 0 ? r0.enableAnimate : false, (r28 & 2) != 0 ? r0.animateLoopCount : 0, (r28 & 4) != 0 ? r0.autoPlay : false, (r28 & 8) != 0 ? r0.useRaw : false, (r28 & 16) != 0 ? r0.useOrigin : false, (r28 & 32) != 0 ? r0.align : null, (r28 & 64) != 0 ? r0.contentScale : contentScale, (r28 & 128) != 0 ? r0.alpha : 0.0f, (r28 & 256) != 0 ? r0.colorFilter : null, (r28 & 512) != 0 ? r0.animateStrategy : null, (r28 & 1024) != 0 ? r0.resizeOption : null, (r28 & 2048) != 0 ? r0.memoryCachePolicy : null, (r28 & 4096) != 0 ? $this$contentScale_u24lambda_u240.options.diskCachePolicy : null);
        $this$contentScale_u24lambda_u240.options = m1434copySsDZD_g;
        return this;
    }

    /* renamed from: alpha-EQRtbio */
    public final ImageRequest m1484alphaEQRtbio(float f) {
        BiliImageOptions m1434copySsDZD_g;
        ImageRequest $this$alpha_EQRtbio_u24lambda_u240 = this;
        m1434copySsDZD_g = r2.m1434copySsDZD_g((r28 & 1) != 0 ? r2.enableAnimate : false, (r28 & 2) != 0 ? r2.animateLoopCount : 0, (r28 & 4) != 0 ? r2.autoPlay : false, (r28 & 8) != 0 ? r2.useRaw : false, (r28 & 16) != 0 ? r2.useOrigin : false, (r28 & 32) != 0 ? r2.align : null, (r28 & 64) != 0 ? r2.contentScale : null, (r28 & 128) != 0 ? r2.alpha : f, (r28 & 256) != 0 ? r2.colorFilter : null, (r28 & 512) != 0 ? r2.animateStrategy : null, (r28 & 1024) != 0 ? r2.resizeOption : null, (r28 & 2048) != 0 ? r2.memoryCachePolicy : null, (r28 & 4096) != 0 ? $this$alpha_EQRtbio_u24lambda_u240.options.diskCachePolicy : null);
        $this$alpha_EQRtbio_u24lambda_u240.options = m1434copySsDZD_g;
        return this;
    }

    public final ImageRequest align(Alignment align) {
        BiliImageOptions m1434copySsDZD_g;
        Intrinsics.checkNotNullParameter(align, "align");
        ImageRequest $this$align_u24lambda_u240 = this;
        m1434copySsDZD_g = r1.m1434copySsDZD_g((r28 & 1) != 0 ? r1.enableAnimate : false, (r28 & 2) != 0 ? r1.animateLoopCount : 0, (r28 & 4) != 0 ? r1.autoPlay : false, (r28 & 8) != 0 ? r1.useRaw : false, (r28 & 16) != 0 ? r1.useOrigin : false, (r28 & 32) != 0 ? r1.align : align, (r28 & 64) != 0 ? r1.contentScale : null, (r28 & 128) != 0 ? r1.alpha : 0.0f, (r28 & 256) != 0 ? r1.colorFilter : null, (r28 & 512) != 0 ? r1.animateStrategy : null, (r28 & 1024) != 0 ? r1.resizeOption : null, (r28 & 2048) != 0 ? r1.memoryCachePolicy : null, (r28 & 4096) != 0 ? $this$align_u24lambda_u240.options.diskCachePolicy : null);
        $this$align_u24lambda_u240.options = m1434copySsDZD_g;
        return this;
    }

    public final ImageRequest animateStrategy(AnimateStrategy animateStrategy) {
        BiliImageOptions m1434copySsDZD_g;
        Intrinsics.checkNotNullParameter(animateStrategy, "animateStrategy");
        ImageRequest $this$animateStrategy_u24lambda_u240 = this;
        m1434copySsDZD_g = r1.m1434copySsDZD_g((r28 & 1) != 0 ? r1.enableAnimate : false, (r28 & 2) != 0 ? r1.animateLoopCount : 0, (r28 & 4) != 0 ? r1.autoPlay : false, (r28 & 8) != 0 ? r1.useRaw : false, (r28 & 16) != 0 ? r1.useOrigin : false, (r28 & 32) != 0 ? r1.align : null, (r28 & 64) != 0 ? r1.contentScale : null, (r28 & 128) != 0 ? r1.alpha : 0.0f, (r28 & 256) != 0 ? r1.colorFilter : null, (r28 & 512) != 0 ? r1.animateStrategy : animateStrategy, (r28 & 1024) != 0 ? r1.resizeOption : null, (r28 & 2048) != 0 ? r1.memoryCachePolicy : null, (r28 & 4096) != 0 ? $this$animateStrategy_u24lambda_u240.options.diskCachePolicy : null);
        $this$animateStrategy_u24lambda_u240.options = m1434copySsDZD_g;
        return this;
    }

    public final ImageRequest resizeOption(ResizeOption resizeOption) {
        BiliImageOptions m1434copySsDZD_g;
        Intrinsics.checkNotNullParameter(resizeOption, "resizeOption");
        ImageRequest $this$resizeOption_u24lambda_u240 = this;
        m1434copySsDZD_g = r1.m1434copySsDZD_g((r28 & 1) != 0 ? r1.enableAnimate : false, (r28 & 2) != 0 ? r1.animateLoopCount : 0, (r28 & 4) != 0 ? r1.autoPlay : false, (r28 & 8) != 0 ? r1.useRaw : false, (r28 & 16) != 0 ? r1.useOrigin : false, (r28 & 32) != 0 ? r1.align : null, (r28 & 64) != 0 ? r1.contentScale : null, (r28 & 128) != 0 ? r1.alpha : 0.0f, (r28 & 256) != 0 ? r1.colorFilter : null, (r28 & 512) != 0 ? r1.animateStrategy : null, (r28 & 1024) != 0 ? r1.resizeOption : resizeOption, (r28 & 2048) != 0 ? r1.memoryCachePolicy : null, (r28 & 4096) != 0 ? $this$resizeOption_u24lambda_u240.options.diskCachePolicy : null);
        $this$resizeOption_u24lambda_u240.options = m1434copySsDZD_g;
        return this;
    }

    public final ImageRequest memoryCachePolicy(CachePolicy policy) {
        BiliImageOptions m1434copySsDZD_g;
        Intrinsics.checkNotNullParameter(policy, "policy");
        ImageRequest $this$memoryCachePolicy_u24lambda_u240 = this;
        m1434copySsDZD_g = r1.m1434copySsDZD_g((r28 & 1) != 0 ? r1.enableAnimate : false, (r28 & 2) != 0 ? r1.animateLoopCount : 0, (r28 & 4) != 0 ? r1.autoPlay : false, (r28 & 8) != 0 ? r1.useRaw : false, (r28 & 16) != 0 ? r1.useOrigin : false, (r28 & 32) != 0 ? r1.align : null, (r28 & 64) != 0 ? r1.contentScale : null, (r28 & 128) != 0 ? r1.alpha : 0.0f, (r28 & 256) != 0 ? r1.colorFilter : null, (r28 & 512) != 0 ? r1.animateStrategy : null, (r28 & 1024) != 0 ? r1.resizeOption : null, (r28 & 2048) != 0 ? r1.memoryCachePolicy : policy, (r28 & 4096) != 0 ? $this$memoryCachePolicy_u24lambda_u240.options.diskCachePolicy : null);
        $this$memoryCachePolicy_u24lambda_u240.options = m1434copySsDZD_g;
        return this;
    }

    public final ImageRequest diskCachePolicy(CachePolicy policy) {
        BiliImageOptions m1434copySsDZD_g;
        Intrinsics.checkNotNullParameter(policy, "policy");
        ImageRequest $this$diskCachePolicy_u24lambda_u240 = this;
        m1434copySsDZD_g = r1.m1434copySsDZD_g((r28 & 1) != 0 ? r1.enableAnimate : false, (r28 & 2) != 0 ? r1.animateLoopCount : 0, (r28 & 4) != 0 ? r1.autoPlay : false, (r28 & 8) != 0 ? r1.useRaw : false, (r28 & 16) != 0 ? r1.useOrigin : false, (r28 & 32) != 0 ? r1.align : null, (r28 & 64) != 0 ? r1.contentScale : null, (r28 & 128) != 0 ? r1.alpha : 0.0f, (r28 & 256) != 0 ? r1.colorFilter : null, (r28 & 512) != 0 ? r1.animateStrategy : null, (r28 & 1024) != 0 ? r1.resizeOption : null, (r28 & 2048) != 0 ? r1.memoryCachePolicy : null, (r28 & 4096) != 0 ? $this$diskCachePolicy_u24lambda_u240.options.diskCachePolicy : policy);
        $this$diskCachePolicy_u24lambda_u240.options = m1434copySsDZD_g;
        return this;
    }

    public final ImmutableImageRequest build() {
        return new ImmutableImageRequest(deepCopy$imageloader_debug());
    }

    /* renamed from: gears-Ic4ZqO0$imageloader_debug */
    public final ImageRequest m1486gearsIc4ZqO0$imageloader_debug(int i, int i2) {
        ImageRequest $this$gears_Ic4ZqO0_u24lambda_u240 = this;
        Size gearsSize = SizeControllerKt.m1578getStageSizeIc4ZqO0(i, i2);
        if (!Pixel.m1519equalsimpl0(i, Pixel.Companion.m1523getUNSETuhUG8m8())) {
            $this$gears_Ic4ZqO0_u24lambda_u240.protocol = BfsProtocol.m1414copy6rHxNw4$default($this$gears_Ic4ZqO0_u24lambda_u240.protocol, gearsSize.m1577getWidthuhUG8m8(), 0, 0, null, null, null, null, false, null, null, null, false, false, false, false, null, 65534, null);
        }
        if (!Pixel.m1519equalsimpl0(i2, Pixel.Companion.m1523getUNSETuhUG8m8())) {
            $this$gears_Ic4ZqO0_u24lambda_u240.protocol = BfsProtocol.m1414copy6rHxNw4$default($this$gears_Ic4ZqO0_u24lambda_u240.protocol, 0, gearsSize.m1576getHeightuhUG8m8(), 0, null, null, null, null, false, null, null, null, false, false, false, false, null, 65533, null);
        }
        return this;
    }

    private final Uri purifyUrl(Uri $this$purifyUrl) {
        String host = $this$purifyUrl.getHost();
        boolean z = true;
        if (!(host == null || host.length() == 0)) {
            String host2 = $this$purifyUrl.getHost();
            Intrinsics.checkNotNull(host2);
            if (StringsKt.endsWith$default(host2, ".hdslb.com", false, 2, (Object) null)) {
                String target = $this$purifyUrl.toString();
                int extensionPos = StringsKt.lastIndexOf$default(target, '.', 0, false, 6, (Object) null);
                int lastSeparator = StringsKt.lastIndexOf$default(target, '/', 0, false, 6, (Object) null);
                if (lastSeparator > extensionPos) {
                    throw new IllegalArgumentException("url has no extension");
                }
                String path = $this$purifyUrl.getPath();
                if (path != null && path.length() != 0) {
                    z = false;
                }
                if (z) {
                    throw new IllegalArgumentException("path must not be empty");
                }
                String path2 = $this$purifyUrl.getPath();
                Intrinsics.checkNotNull(path2);
                if (StringsKt.contains$default(path2, "@", false, 2, (Object) null)) {
                    String host3 = $this$purifyUrl.getHost();
                    Intrinsics.checkNotNull(host3);
                    if (!StringsKt.endsWith$default(host3, ".hdslb.com", false, 2, (Object) null)) {
                        throw new IllegalArgumentException("it's not bfs url");
                    }
                }
                int suffixIndex = StringsKt.lastIndexOf$default(target, '_', 0, false, 6, (Object) null);
                int x = StringsKt.lastIndexOf$default(target, 'x', 0, false, 6, (Object) null);
                if (suffixIndex != -1 && x > suffixIndex) {
                    String pureUrl = target.substring(0, suffixIndex);
                    Intrinsics.checkNotNullExpressionValue(pureUrl, "substring(...)");
                    String ext = target.substring(StringsKt.lastIndexOf$default(target, '.', 0, false, 6, (Object) null));
                    Intrinsics.checkNotNullExpressionValue(ext, "substring(...)");
                    if (StringsKt.endsWith$default(pureUrl, ext, false, 2, (Object) null)) {
                        target = pureUrl;
                    }
                }
                Url targetUrl = Url.Companion.parse(target);
                Object encodedPath = targetUrl.getEncodedPath();
                String replace = encodedPath != null ? new Regex("%40").replace((CharSequence) encodedPath, "@") : null;
                if (replace != null) {
                    String it = replace;
                    int atIndex = StringsKt.indexOf$default(it, '@', 0, false, 6, (Object) null);
                    int extIndex = StringsKt.indexOf$default(it, '.', 0, false, 6, (Object) null);
                    if (atIndex > extIndex && atIndex < it.length()) {
                        String substring = it.substring(0, atIndex);
                        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                        replace = substring;
                    }
                }
                return targetUrl.buildUpon().encodedPath(replace).build();
            }
        }
        return $this$purifyUrl;
    }

    public final ImageRequest deepCopy$imageloader_debug() {
        BiliImageOptions m1434copySsDZD_g;
        ImageRequest $this$deepCopy_u24lambda_u240 = new ImageRequest(this.rawUrl);
        $this$deepCopy_u24lambda_u240.parseUrl = this.parseUrl;
        $this$deepCopy_u24lambda_u240.protocol = BfsProtocol.m1414copy6rHxNw4$default(this.protocol, 0, 0, 0, null, null, null, null, false, null, null, null, false, false, false, false, null, 65535, null);
        m1434copySsDZD_g = r5.m1434copySsDZD_g((r28 & 1) != 0 ? r5.enableAnimate : false, (r28 & 2) != 0 ? r5.animateLoopCount : 0, (r28 & 4) != 0 ? r5.autoPlay : false, (r28 & 8) != 0 ? r5.useRaw : false, (r28 & 16) != 0 ? r5.useOrigin : false, (r28 & 32) != 0 ? r5.align : null, (r28 & 64) != 0 ? r5.contentScale : null, (r28 & 128) != 0 ? r5.alpha : 0.0f, (r28 & 256) != 0 ? r5.colorFilter : null, (r28 & 512) != 0 ? r5.animateStrategy : null, (r28 & 1024) != 0 ? r5.resizeOption : null, (r28 & 2048) != 0 ? r5.memoryCachePolicy : null, (r28 & 4096) != 0 ? this.options.diskCachePolicy : null);
        $this$deepCopy_u24lambda_u240.options = m1434copySsDZD_g;
        return $this$deepCopy_u24lambda_u240;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ImageRequest) && Intrinsics.areEqual(this.parseUrl, ((ImageRequest) other).parseUrl) && Intrinsics.areEqual(this.protocol, ((ImageRequest) other).protocol) && Intrinsics.areEqual(this.options, ((ImageRequest) other).options);
    }

    public int hashCode() {
        int result = this.parseUrl.hashCode();
        return (((result * 31) + this.protocol.hashCode()) * 31) + this.options.hashCode();
    }
}