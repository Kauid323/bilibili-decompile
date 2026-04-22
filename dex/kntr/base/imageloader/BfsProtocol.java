package kntr.base.imageloader;

import BottomSheetItemData$;
import androidx.compose.ui.layout.ContentScale;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.KConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: BfsProtocol.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B§\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\u000e\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<J\u000e\u0010>\u001a\u00020\u00002\u0006\u0010?\u001a\u00020@J\u0010\u0010A\u001a\u00020\u0003HÀ\u0003¢\u0006\u0004\bB\u0010 J\u0010\u0010C\u001a\u00020\u0003HÀ\u0003¢\u0006\u0004\bD\u0010 J\u0010\u0010E\u001a\u00020\u0006HÀ\u0003¢\u0006\u0004\bF\u0010 J\u000e\u0010G\u001a\u00020\bHÀ\u0003¢\u0006\u0002\bHJ\u0010\u0010I\u001a\u00020\nHÀ\u0003¢\u0006\u0004\bJ\u0010'J\u000e\u0010K\u001a\u00020\fHÀ\u0003¢\u0006\u0002\bLJ\u000e\u0010M\u001a\u00020\u000eHÀ\u0003¢\u0006\u0002\bNJ\u000e\u0010O\u001a\u00020\u0010HÀ\u0003¢\u0006\u0002\bPJ\u0010\u0010Q\u001a\u00020\u0012HÀ\u0003¢\u0006\u0004\bR\u00100J\u0010\u0010S\u001a\u00020\u0014HÀ\u0003¢\u0006\u0004\bT\u00100J\u000e\u0010U\u001a\u00020\u0016HÀ\u0003¢\u0006\u0002\bVJ\u000e\u0010W\u001a\u00020\u0010HÀ\u0003¢\u0006\u0002\bXJ\u000e\u0010Y\u001a\u00020\u0010HÀ\u0003¢\u0006\u0002\bZJ\u000e\u0010[\u001a\u00020\u0010HÀ\u0003¢\u0006\u0002\b\\J\u000e\u0010]\u001a\u00020\u0010HÀ\u0003¢\u0006\u0002\b^J\u000e\u0010_\u001a\u00020\u001cHÀ\u0003¢\u0006\u0002\b`J°\u0001\u0010a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u00102\b\b\u0002\u0010\u001a\u001a\u00020\u00102\b\b\u0002\u0010\u001b\u001a\u00020\u001cHÆ\u0001¢\u0006\u0004\bb\u0010cJ\u0013\u0010d\u001a\u00020\u00102\b\u0010e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010f\u001a\u00020gHÖ\u0001J\t\u0010h\u001a\u00020<HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u0004\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\"\u0010 R\u0016\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b#\u0010 R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0016\u0010\t\u001a\u00020\nX\u0080\u0004¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0014\u0010\u000b\u001a\u00020\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0014\u0010\r\u001a\u00020\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0014\u0010\u000f\u001a\u00020\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0016\u0010\u0011\u001a\u00020\u0012X\u0080\u0004¢\u0006\n\n\u0002\u00101\u001a\u0004\b/\u00100R\u0016\u0010\u0013\u001a\u00020\u0014X\u0080\u0004¢\u0006\n\n\u0002\u00101\u001a\u0004\b2\u00100R\u0014\u0010\u0015\u001a\u00020\u0016X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0014\u0010\u0017\u001a\u00020\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010.R\u0014\u0010\u0018\u001a\u00020\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010.R\u0014\u0010\u0019\u001a\u00020\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010.R\u0014\u0010\u001a\u001a\u00020\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010.R\u0014\u0010\u001b\u001a\u00020\u001cX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:¨\u0006i"}, d2 = {"Lkntr/base/imageloader/BfsProtocol;", "", "width", "Lkntr/base/imageloader/Pixel;", "height", "quality", "Lkntr/base/imageloader/Quality;", "format", "Lkntr/base/imageloader/SupportImageType;", "style", "Lkntr/base/imageloader/Style;", "crop", "Lkntr/base/imageloader/ImageCrop;", "regionCrop", "Lkntr/base/imageloader/ImageRegionCrop;", "autoCrop", "", "percent", "Lkntr/base/imageloader/Percent;", "priorityScaleEdge", "Lkntr/base/imageloader/PriorityScaleEdge;", "blur", "Lkntr/base/imageloader/BlurOption;", "rotate", "firstFrame", "gray", "skipDefaultCrop", "noLimitSize", "Lkntr/base/imageloader/Size;", "<init>", "(IIILkntr/base/imageloader/SupportImageType;Ljava/lang/String;Lkntr/base/imageloader/ImageCrop;Lkntr/base/imageloader/ImageRegionCrop;ZLjava/lang/Integer;Ljava/lang/Integer;Lkntr/base/imageloader/BlurOption;ZZZZLkntr/base/imageloader/Size;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getWidth-uhUG8m8$imageloader_debug", "()I", "I", "getHeight-uhUG8m8$imageloader_debug", "getQuality-Z1J5CoE$imageloader_debug", "getFormat$imageloader_debug", "()Lkntr/base/imageloader/SupportImageType;", "getStyle-VN9BJCI$imageloader_debug", "()Ljava/lang/String;", "Ljava/lang/String;", "getCrop$imageloader_debug", "()Lkntr/base/imageloader/ImageCrop;", "getRegionCrop$imageloader_debug", "()Lkntr/base/imageloader/ImageRegionCrop;", "getAutoCrop$imageloader_debug", "()Z", "getPercent-V0ubnAs$imageloader_debug", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPriorityScaleEdge-p7LdFCU$imageloader_debug", "getBlur$imageloader_debug", "()Lkntr/base/imageloader/BlurOption;", "getRotate$imageloader_debug", "getFirstFrame$imageloader_debug", "getGray$imageloader_debug", "getSkipDefaultCrop$imageloader_debug", "getNoLimitSize$imageloader_debug", "()Lkntr/base/imageloader/Size;", "join", "", "imageUrl", "enhanceWithContentScale", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "component1", "component1-uhUG8m8$imageloader_debug", "component2", "component2-uhUG8m8$imageloader_debug", "component3", "component3-Z1J5CoE$imageloader_debug", "component4", "component4$imageloader_debug", "component5", "component5-VN9BJCI$imageloader_debug", "component6", "component6$imageloader_debug", "component7", "component7$imageloader_debug", "component8", "component8$imageloader_debug", "component9", "component9-V0ubnAs$imageloader_debug", "component10", "component10-p7LdFCU$imageloader_debug", "component11", "component11$imageloader_debug", "component12", "component12$imageloader_debug", "component13", "component13$imageloader_debug", "component14", "component14$imageloader_debug", "component15", "component15$imageloader_debug", "component16", "component16$imageloader_debug", "copy", "copy-6rHxNw4", "(IIILkntr/base/imageloader/SupportImageType;Ljava/lang/String;Lkntr/base/imageloader/ImageCrop;Lkntr/base/imageloader/ImageRegionCrop;ZLjava/lang/Integer;Ljava/lang/Integer;Lkntr/base/imageloader/BlurOption;ZZZZLkntr/base/imageloader/Size;)Lkntr/base/imageloader/BfsProtocol;", "equals", "other", "hashCode", "", "toString", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BfsProtocol {
    public static final int $stable = 0;
    private final boolean autoCrop;
    private final BlurOption blur;
    private final ImageCrop crop;
    private final boolean firstFrame;
    private final SupportImageType format;
    private final boolean gray;
    private final int height;
    private final Size noLimitSize;
    private final Integer percent;
    private final Integer priorityScaleEdge;
    private final int quality;
    private final ImageRegionCrop regionCrop;
    private final boolean rotate;
    private final boolean skipDefaultCrop;
    private final String style;
    private final int width;

    public /* synthetic */ BfsProtocol(int i, int i2, int i3, SupportImageType supportImageType, String str, ImageCrop imageCrop, ImageRegionCrop imageRegionCrop, boolean z, Integer num, Integer num2, BlurOption blurOption, boolean z2, boolean z3, boolean z4, boolean z5, Size size, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, supportImageType, str, imageCrop, imageRegionCrop, z, num, num2, blurOption, z2, z3, z4, z5, size);
    }

    /* renamed from: copy-6rHxNw4$default */
    public static /* synthetic */ BfsProtocol m1414copy6rHxNw4$default(BfsProtocol bfsProtocol, int i, int i2, int i3, SupportImageType supportImageType, Style style, ImageCrop imageCrop, ImageRegionCrop imageRegionCrop, boolean z, Percent percent, PriorityScaleEdge priorityScaleEdge, BlurOption blurOption, boolean z2, boolean z3, boolean z4, boolean z5, Size size, int i4, Object obj) {
        int i5 = (i4 & 1) != 0 ? bfsProtocol.width : i;
        int i6 = (i4 & 2) != 0 ? bfsProtocol.height : i2;
        int i7 = (i4 & 4) != 0 ? bfsProtocol.quality : i3;
        SupportImageType supportImageType2 = (i4 & 8) != 0 ? bfsProtocol.format : supportImageType;
        Style m1583boximpl = (i4 & 16) != 0 ? Style.m1583boximpl(bfsProtocol.style) : style;
        return bfsProtocol.m1421copy6rHxNw4(i5, i6, i7, supportImageType2, m1583boximpl.m1589unboximpl(), (i4 & 32) != 0 ? bfsProtocol.crop : imageCrop, (i4 & 64) != 0 ? bfsProtocol.regionCrop : imageRegionCrop, (i4 & 128) != 0 ? bfsProtocol.autoCrop : z, ((i4 & 256) != 0 ? Percent.m1508boximpl(bfsProtocol.percent) : percent).m1514unboximpl(), ((i4 & 512) != 0 ? PriorityScaleEdge.m1533boximpl(bfsProtocol.priorityScaleEdge) : priorityScaleEdge).m1539unboximpl(), (i4 & 1024) != 0 ? bfsProtocol.blur : blurOption, (i4 & 2048) != 0 ? bfsProtocol.rotate : z2, (i4 & 4096) != 0 ? bfsProtocol.firstFrame : z3, (i4 & 8192) != 0 ? bfsProtocol.gray : z4, (i4 & 16384) != 0 ? bfsProtocol.skipDefaultCrop : z5, (i4 & 32768) != 0 ? bfsProtocol.noLimitSize : size);
    }

    /* renamed from: component1-uhUG8m8$imageloader_debug */
    public final int m1415component1uhUG8m8$imageloader_debug() {
        return this.width;
    }

    /* renamed from: component10-p7LdFCU$imageloader_debug */
    public final Integer m1416component10p7LdFCU$imageloader_debug() {
        return this.priorityScaleEdge;
    }

    public final BlurOption component11$imageloader_debug() {
        return this.blur;
    }

    public final boolean component12$imageloader_debug() {
        return this.rotate;
    }

    public final boolean component13$imageloader_debug() {
        return this.firstFrame;
    }

    public final boolean component14$imageloader_debug() {
        return this.gray;
    }

    public final boolean component15$imageloader_debug() {
        return this.skipDefaultCrop;
    }

    public final Size component16$imageloader_debug() {
        return this.noLimitSize;
    }

    /* renamed from: component2-uhUG8m8$imageloader_debug */
    public final int m1417component2uhUG8m8$imageloader_debug() {
        return this.height;
    }

    /* renamed from: component3-Z1J5CoE$imageloader_debug */
    public final int m1418component3Z1J5CoE$imageloader_debug() {
        return this.quality;
    }

    public final SupportImageType component4$imageloader_debug() {
        return this.format;
    }

    /* renamed from: component5-VN9BJCI$imageloader_debug */
    public final String m1419component5VN9BJCI$imageloader_debug() {
        return this.style;
    }

    public final ImageCrop component6$imageloader_debug() {
        return this.crop;
    }

    public final ImageRegionCrop component7$imageloader_debug() {
        return this.regionCrop;
    }

    public final boolean component8$imageloader_debug() {
        return this.autoCrop;
    }

    /* renamed from: component9-V0ubnAs$imageloader_debug */
    public final Integer m1420component9V0ubnAs$imageloader_debug() {
        return this.percent;
    }

    /* renamed from: copy-6rHxNw4 */
    public final BfsProtocol m1421copy6rHxNw4(int i, int i2, int i3, SupportImageType supportImageType, String str, ImageCrop imageCrop, ImageRegionCrop imageRegionCrop, boolean z, Integer num, Integer num2, BlurOption blurOption, boolean z2, boolean z3, boolean z4, boolean z5, Size size) {
        Intrinsics.checkNotNullParameter(supportImageType, "format");
        Intrinsics.checkNotNullParameter(imageCrop, "crop");
        Intrinsics.checkNotNullParameter(imageRegionCrop, "regionCrop");
        Intrinsics.checkNotNullParameter(blurOption, "blur");
        Intrinsics.checkNotNullParameter(size, "noLimitSize");
        return new BfsProtocol(i, i2, i3, supportImageType, str, imageCrop, imageRegionCrop, z, num, num2, blurOption, z2, z3, z4, z5, size, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BfsProtocol) {
            BfsProtocol bfsProtocol = (BfsProtocol) obj;
            return Pixel.m1519equalsimpl0(this.width, bfsProtocol.width) && Pixel.m1519equalsimpl0(this.height, bfsProtocol.height) && Quality.m1544equalsimpl0(this.quality, bfsProtocol.quality) && this.format == bfsProtocol.format && Style.m1586equalsimpl0(this.style, bfsProtocol.style) && Intrinsics.areEqual(this.crop, bfsProtocol.crop) && Intrinsics.areEqual(this.regionCrop, bfsProtocol.regionCrop) && this.autoCrop == bfsProtocol.autoCrop && Percent.m1511equalsimpl0(this.percent, bfsProtocol.percent) && PriorityScaleEdge.m1536equalsimpl0(this.priorityScaleEdge, bfsProtocol.priorityScaleEdge) && Intrinsics.areEqual(this.blur, bfsProtocol.blur) && this.rotate == bfsProtocol.rotate && this.firstFrame == bfsProtocol.firstFrame && this.gray == bfsProtocol.gray && this.skipDefaultCrop == bfsProtocol.skipDefaultCrop && Intrinsics.areEqual(this.noLimitSize, bfsProtocol.noLimitSize);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((Pixel.m1520hashCodeimpl(this.width) * 31) + Pixel.m1520hashCodeimpl(this.height)) * 31) + Quality.m1545hashCodeimpl(this.quality)) * 31) + this.format.hashCode()) * 31) + Style.m1587hashCodeimpl(this.style)) * 31) + this.crop.hashCode()) * 31) + this.regionCrop.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.autoCrop)) * 31) + Percent.m1512hashCodeimpl(this.percent)) * 31) + PriorityScaleEdge.m1537hashCodeimpl(this.priorityScaleEdge)) * 31) + this.blur.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.rotate)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.firstFrame)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.gray)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.skipDefaultCrop)) * 31) + this.noLimitSize.hashCode();
    }

    public String toString() {
        String m1521toStringimpl = Pixel.m1521toStringimpl(this.width);
        String m1521toStringimpl2 = Pixel.m1521toStringimpl(this.height);
        String m1546toStringimpl = Quality.m1546toStringimpl(this.quality);
        SupportImageType supportImageType = this.format;
        String m1588toStringimpl = Style.m1588toStringimpl(this.style);
        ImageCrop imageCrop = this.crop;
        ImageRegionCrop imageRegionCrop = this.regionCrop;
        boolean z = this.autoCrop;
        String m1513toStringimpl = Percent.m1513toStringimpl(this.percent);
        String m1538toStringimpl = PriorityScaleEdge.m1538toStringimpl(this.priorityScaleEdge);
        BlurOption blurOption = this.blur;
        boolean z2 = this.rotate;
        boolean z3 = this.firstFrame;
        boolean z4 = this.gray;
        boolean z5 = this.skipDefaultCrop;
        return "BfsProtocol(width=" + m1521toStringimpl + ", height=" + m1521toStringimpl2 + ", quality=" + m1546toStringimpl + ", format=" + supportImageType + ", style=" + m1588toStringimpl + ", crop=" + imageCrop + ", regionCrop=" + imageRegionCrop + ", autoCrop=" + z + ", percent=" + m1513toStringimpl + ", priorityScaleEdge=" + m1538toStringimpl + ", blur=" + blurOption + ", rotate=" + z2 + ", firstFrame=" + z3 + ", gray=" + z4 + ", skipDefaultCrop=" + z5 + ", noLimitSize=" + this.noLimitSize + ")";
    }

    private BfsProtocol(int width, int height, int quality, SupportImageType format, String style, ImageCrop crop, ImageRegionCrop regionCrop, boolean autoCrop, Integer percent, Integer priorityScaleEdge, BlurOption blur, boolean rotate, boolean firstFrame, boolean gray, boolean skipDefaultCrop, Size noLimitSize) {
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(crop, "crop");
        Intrinsics.checkNotNullParameter(regionCrop, "regionCrop");
        Intrinsics.checkNotNullParameter(blur, "blur");
        Intrinsics.checkNotNullParameter(noLimitSize, "noLimitSize");
        this.width = width;
        this.height = height;
        this.quality = quality;
        this.format = format;
        this.style = style;
        this.crop = crop;
        this.regionCrop = regionCrop;
        this.autoCrop = autoCrop;
        this.percent = percent;
        this.priorityScaleEdge = priorityScaleEdge;
        this.blur = blur;
        this.rotate = rotate;
        this.firstFrame = firstFrame;
        this.gray = gray;
        this.skipDefaultCrop = skipDefaultCrop;
        this.noLimitSize = noLimitSize;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ BfsProtocol(int i, int i2, int i3, SupportImageType supportImageType, Style style, ImageCrop imageCrop, ImageRegionCrop imageRegionCrop, boolean z, Percent percent, PriorityScaleEdge priorityScaleEdge, BlurOption blurOption, boolean z2, boolean z3, boolean z4, boolean z5, Size size, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r2, r3, r4, r5.m1589unboximpl(), (i4 & 32) != 0 ? ImageCrop.Companion.getUNSET() : imageCrop, (i4 & 64) != 0 ? ImageRegionCrop.Companion.getUNSET() : imageRegionCrop, (i4 & 128) != 0 ? false : z, ((i4 & 256) != 0 ? Percent.m1508boximpl(Percent.Companion.m1515getUNSETV0ubnAs()) : percent).m1514unboximpl(), ((i4 & 512) != 0 ? PriorityScaleEdge.m1533boximpl(PriorityScaleEdge.Companion.m1540getUNSETp7LdFCU()) : priorityScaleEdge).m1539unboximpl(), (i4 & 1024) != 0 ? BlurOption.Companion.getUNSET() : blurOption, (i4 & 2048) != 0 ? false : z2, (i4 & 4096) != 0 ? false : z3, (i4 & 8192) != 0 ? false : z4, (i4 & 16384) != 0 ? false : z5, (i4 & 32768) != 0 ? Size.Companion.getUNSET() : size, null);
        int m1523getUNSETuhUG8m8 = (i4 & 1) != 0 ? Pixel.Companion.m1523getUNSETuhUG8m8() : i;
        int m1523getUNSETuhUG8m82 = (i4 & 2) != 0 ? Pixel.Companion.m1523getUNSETuhUG8m8() : i2;
        int m1548getDefaultZ1J5CoE = (i4 & 4) != 0 ? Quality.Companion.m1548getDefaultZ1J5CoE() : i3;
        SupportImageType supportImageType2 = (i4 & 8) != 0 ? SupportImageType.AVIF : supportImageType;
        Style m1583boximpl = (i4 & 16) != 0 ? Style.m1583boximpl(Style.Companion.m1590getUNSETVN9BJCI()) : style;
    }

    /* renamed from: getWidth-uhUG8m8$imageloader_debug */
    public final int m1427getWidthuhUG8m8$imageloader_debug() {
        return this.width;
    }

    /* renamed from: getHeight-uhUG8m8$imageloader_debug */
    public final int m1422getHeightuhUG8m8$imageloader_debug() {
        return this.height;
    }

    /* renamed from: getQuality-Z1J5CoE$imageloader_debug */
    public final int m1425getQualityZ1J5CoE$imageloader_debug() {
        return this.quality;
    }

    public final SupportImageType getFormat$imageloader_debug() {
        return this.format;
    }

    /* renamed from: getStyle-VN9BJCI$imageloader_debug */
    public final String m1426getStyleVN9BJCI$imageloader_debug() {
        return this.style;
    }

    public final ImageCrop getCrop$imageloader_debug() {
        return this.crop;
    }

    public final ImageRegionCrop getRegionCrop$imageloader_debug() {
        return this.regionCrop;
    }

    public final boolean getAutoCrop$imageloader_debug() {
        return this.autoCrop;
    }

    /* renamed from: getPercent-V0ubnAs$imageloader_debug */
    public final Integer m1423getPercentV0ubnAs$imageloader_debug() {
        return this.percent;
    }

    /* renamed from: getPriorityScaleEdge-p7LdFCU$imageloader_debug */
    public final Integer m1424getPriorityScaleEdgep7LdFCU$imageloader_debug() {
        return this.priorityScaleEdge;
    }

    public final BlurOption getBlur$imageloader_debug() {
        return this.blur;
    }

    public final boolean getRotate$imageloader_debug() {
        return this.rotate;
    }

    public final boolean getFirstFrame$imageloader_debug() {
        return this.firstFrame;
    }

    public final boolean getGray$imageloader_debug() {
        return this.gray;
    }

    public final boolean getSkipDefaultCrop$imageloader_debug() {
        return this.skipDefaultCrop;
    }

    public final Size getNoLimitSize$imageloader_debug() {
        return this.noLimitSize;
    }

    public final String join(String imageUrl) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Object bfsSuffix = "@";
        if (Pixel.m1519equalsimpl0(this.noLimitSize.m1577getWidthuhUG8m8(), Pixel.Companion.m1523getUNSETuhUG8m8()) && Pixel.m1519equalsimpl0(this.noLimitSize.m1576getHeightuhUG8m8(), Pixel.Companion.m1523getUNSETuhUG8m8())) {
            Pixel m1516boximpl = Pixel.m1516boximpl(this.width);
            int it = m1516boximpl.m1522unboximpl();
            if (Pixel.m1519equalsimpl0(it, Pixel.Companion.m1523getUNSETuhUG8m8())) {
                m1516boximpl = null;
            }
            if (m1516boximpl != null) {
                int it2 = m1516boximpl.m1522unboximpl();
                bfsSuffix = ((Object) "@") + it2 + "w_";
            }
            Pixel m1516boximpl2 = Pixel.m1516boximpl(this.height);
            int it3 = m1516boximpl2.m1522unboximpl();
            if (Pixel.m1519equalsimpl0(it3, Pixel.Companion.m1523getUNSETuhUG8m8())) {
                m1516boximpl2 = null;
            }
            if (m1516boximpl2 != null) {
                int it4 = m1516boximpl2.m1522unboximpl();
                bfsSuffix = bfsSuffix + it4 + "h_";
            }
        } else {
            Pixel m1516boximpl3 = Pixel.m1516boximpl(this.noLimitSize.m1577getWidthuhUG8m8());
            int it5 = m1516boximpl3.m1522unboximpl();
            if (Pixel.m1519equalsimpl0(it5, Pixel.Companion.m1523getUNSETuhUG8m8())) {
                m1516boximpl3 = null;
            }
            if (m1516boximpl3 != null) {
                int it6 = m1516boximpl3.m1522unboximpl();
                bfsSuffix = ((Object) "@") + it6 + "w_";
            }
            Pixel m1516boximpl4 = Pixel.m1516boximpl(this.noLimitSize.m1576getHeightuhUG8m8());
            int it7 = m1516boximpl4.m1522unboximpl();
            if (Pixel.m1519equalsimpl0(it7, Pixel.Companion.m1523getUNSETuhUG8m8())) {
                m1516boximpl4 = null;
            }
            if (m1516boximpl4 != null) {
                int it8 = m1516boximpl4.m1522unboximpl();
                bfsSuffix = bfsSuffix + it8 + "h_";
            }
        }
        if ((!Intrinsics.areEqual(this.crop, ImageCrop.Companion.getUNSET()) ? this : null) != null) {
            bfsSuffix = bfsSuffix + this.crop.m1462getLeftuhUG8m8() + "-" + this.crop.m1464getTopuhUG8m8() + "-" + (this.crop.m1463getRightuhUG8m8() - this.crop.m1462getLeftuhUG8m8()) + "-" + (this.crop.m1461getBottomuhUG8m8() - this.crop.m1464getTopuhUG8m8()) + "a_";
        }
        if ((!Intrinsics.areEqual(this.regionCrop, ImageRegionCrop.Companion.getUNSET()) ? this : null) != null) {
            bfsSuffix = bfsSuffix + this.regionCrop.getSize().m1577getWidthuhUG8m8() + "-" + this.regionCrop.getSize().m1576getHeightuhUG8m8() + "-" + this.regionCrop.m1482getPos78ljgRQ() + "rc_";
        }
        if ((this.autoCrop ? this : null) != null) {
            bfsSuffix = bfsSuffix + "1c_";
        }
        if ((!Percent.m1511equalsimpl0(this.percent, Percent.Companion.m1515getUNSETV0ubnAs()) ? this : null) != null) {
            bfsSuffix = bfsSuffix + this.percent + "p_";
        }
        if ((!PriorityScaleEdge.m1536equalsimpl0(this.priorityScaleEdge, PriorityScaleEdge.Companion.m1540getUNSETp7LdFCU()) ? this : null) != null) {
            bfsSuffix = bfsSuffix + this.priorityScaleEdge + "e_";
        }
        if ((!Intrinsics.areEqual(this.blur, BlurOption.Companion.getUNSET()) ? this : null) != null) {
            bfsSuffix = bfsSuffix + this.blur.m1443getRadiustNbwJAw() + "-" + this.blur.m1444getSigmaUajuqIQ() + "bl_";
        }
        if ((this.rotate ? this : null) != null) {
            bfsSuffix = bfsSuffix + "1o_";
        }
        if ((this.firstFrame ? this : null) != null) {
            bfsSuffix = bfsSuffix + "1s_";
        }
        if ((Style.m1586equalsimpl0(this.style, Style.Companion.m1590getUNSETVN9BJCI()) && Intrinsics.areEqual(this.noLimitSize, Size.Companion.getUNSET()) && PriorityScaleEdge.m1536equalsimpl0(this.priorityScaleEdge, PriorityScaleEdge.Companion.m1540getUNSETp7LdFCU()) && !this.autoCrop && !this.skipDefaultCrop ? this : null) != null) {
            bfsSuffix = bfsSuffix + "1e_1c_";
        }
        String str = bfsSuffix + this.quality + "q_";
        if ((!Style.m1586equalsimpl0(this.style, Style.Companion.m1590getUNSETVN9BJCI()) ? this : null) != null) {
            str = ((Object) str) + "!" + this.style;
        }
        if (StringsKt.endsWith$default(str, "_", false, 2, (Object) null)) {
            str = StringsKt.removeSuffix(str, "_");
        }
        String gif = SupportImageType.GIF.getSuffix();
        if ((StringsKt.endsWith$default(imageUrl, gif, false, 2, (Object) null) ? this : null) != null) {
            return (this.format == SupportImageType.WEBP || this.format == SupportImageType.WEBP_ANIM) ? ((Object) str) + "." + SupportImageType.WEBP.getSuffix() : ((Object) str) + "." + gif;
        }
        return ((Object) str) + ((this.format == SupportImageType.AVIF && BiliImage_androidKt.disableAvif()) ? "." + SupportImageType.WEBP.getSuffix() : "." + this.format.getSuffix());
    }

    public final BfsProtocol enhanceWithContentScale(ContentScale contentScale) {
        Intrinsics.checkNotNullParameter(contentScale, "contentScale");
        if (KConfig.INSTANCE.ff("enable_content_scale_mapping", false)) {
            return this;
        }
        if (!PriorityScaleEdge.m1536equalsimpl0(this.priorityScaleEdge, PriorityScaleEdge.Companion.m1540getUNSETp7LdFCU()) || this.autoCrop || !Intrinsics.areEqual(this.crop, ImageCrop.Companion.getUNSET()) || !Intrinsics.areEqual(this.noLimitSize, Size.Companion.getUNSET())) {
            return this;
        }
        if (Intrinsics.areEqual(contentScale, ContentScale.Companion.getFit())) {
            return m1414copy6rHxNw4$default(this, 0, 0, 0, null, null, null, null, false, null, PriorityScaleEdge.m1533boximpl(PriorityScaleEdge.m1534constructorimpl(0)), null, false, false, false, false, null, 65023, null);
        }
        if (Intrinsics.areEqual(contentScale, ContentScale.Companion.getCrop())) {
            return m1414copy6rHxNw4$default(this, 0, 0, 0, null, null, null, null, false, null, PriorityScaleEdge.m1533boximpl(PriorityScaleEdge.m1534constructorimpl(1)), null, false, false, false, false, null, 65023, null);
        }
        if (Intrinsics.areEqual(contentScale, ContentScale.Companion.getFillWidth())) {
            if (!Pixel.m1519equalsimpl0(this.width, Pixel.Companion.m1523getUNSETuhUG8m8())) {
                return m1414copy6rHxNw4$default(this, Pixel.Companion.m1523getUNSETuhUG8m8(), Pixel.Companion.m1523getUNSETuhUG8m8(), 0, null, null, null, null, false, null, null, null, false, false, false, false, new Size(this.width, Pixel.Companion.m1523getUNSETuhUG8m8(), null), 32764, null);
            }
        } else if (Intrinsics.areEqual(contentScale, ContentScale.Companion.getFillHeight())) {
            if (!Pixel.m1519equalsimpl0(this.height, Pixel.Companion.m1523getUNSETuhUG8m8())) {
                return m1414copy6rHxNw4$default(this, Pixel.Companion.m1523getUNSETuhUG8m8(), Pixel.Companion.m1523getUNSETuhUG8m8(), 0, null, null, null, null, false, null, null, null, false, false, false, false, new Size(Pixel.Companion.m1523getUNSETuhUG8m8(), this.height, null), 32764, null);
            }
        } else if (Intrinsics.areEqual(contentScale, ContentScale.Companion.getFillBounds())) {
            return m1414copy6rHxNw4$default(this, 0, 0, 0, null, null, null, null, false, null, PriorityScaleEdge.m1533boximpl(PriorityScaleEdge.m1534constructorimpl(2)), null, false, false, false, false, null, 65023, null);
        } else {
            return m1414copy6rHxNw4$default(this, 0, 0, 0, null, null, null, null, false, null, null, null, false, false, false, true, null, 49151, null);
        }
        return this;
    }
}