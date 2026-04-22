package kntr.common.paragraph.assetuploader;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.BytesSizeSerializer;
import kntr.common.photonic.ContentSize;
import kntr.common.photonic.Resolution;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.Transient;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: AssetUploader.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 =2\u00020\u0001:\u0002<=B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fBG\b\u0010\u0012\u0006\u0010\r\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\u0010\u0010)\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b*\u0010\u001cJ\t\u0010+\u001a\u00020\nHÆ\u0003JB\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b-\u0010.J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\nHÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001J%\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u00002\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0001¢\u0006\u0002\b;R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0017R\u001e\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001d\u0012\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u00020\"8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0012\u001a\u0004\b$\u0010%¨\u0006>"}, d2 = {"Lkntr/common/paragraph/assetuploader/ImageUploadResult;", "", "imageUrl", "", "imageWidth", "", "imageHeight", "imageSize", "Lkntr/common/photonic/ContentSize;", "aiGenPic", "", "<init>", "(Ljava/lang/String;JJDILkotlin/jvm/internal/DefaultConstructorMarker;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;JJLkntr/common/photonic/ContentSize;ILkotlinx/serialization/internal/SerializationConstructorMarker;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getImageUrl$annotations", "()V", "getImageUrl", "()Ljava/lang/String;", "getImageWidth$annotations", "getImageWidth", "()J", "getImageHeight$annotations", "getImageHeight", "getImageSize-QJZHGII$annotations", "getImageSize-QJZHGII", "()D", "D", "getAiGenPic$annotations", "getAiGenPic", "()I", "resolution", "Lkntr/common/photonic/Resolution;", "getResolution$annotations", "getResolution", "()Lkntr/common/photonic/Resolution;", "component1", "component2", "component3", "component4", "component4-QJZHGII", "component5", "copy", "copy-02Cdc8s", "(Ljava/lang/String;JJDI)Lkntr/common/paragraph/assetuploader/ImageUploadResult;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$assetuploader_debug", "$serializer", "Companion", "assetuploader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class ImageUploadResult {
    public static final Companion Companion = new Companion(null);
    private final int aiGenPic;
    private final long imageHeight;
    private final double imageSize;
    private final String imageUrl;
    private final long imageWidth;
    private final Resolution resolution;

    public /* synthetic */ ImageUploadResult(int i, String str, long j, long j2, ContentSize contentSize, int i2, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, j, j2, contentSize, i2, serializationConstructorMarker);
    }

    public /* synthetic */ ImageUploadResult(String str, long j, long j2, double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, j2, d, i);
    }

    @SerialName("ai_gen_pic")
    public static /* synthetic */ void getAiGenPic$annotations() {
    }

    @SerialName("image_height")
    public static /* synthetic */ void getImageHeight$annotations() {
    }

    @SerialName("img_size")
    @Serializable(with = BytesSizeSerializer.class)
    /* renamed from: getImageSize-QJZHGII$annotations  reason: not valid java name */
    public static /* synthetic */ void m2145getImageSizeQJZHGII$annotations() {
    }

    @SerialName("image_url")
    public static /* synthetic */ void getImageUrl$annotations() {
    }

    @SerialName("image_width")
    public static /* synthetic */ void getImageWidth$annotations() {
    }

    @Transient
    public static /* synthetic */ void getResolution$annotations() {
    }

    public final String component1() {
        return this.imageUrl;
    }

    public final long component2() {
        return this.imageWidth;
    }

    public final long component3() {
        return this.imageHeight;
    }

    /* renamed from: component4-QJZHGII  reason: not valid java name */
    public final double m2146component4QJZHGII() {
        return this.imageSize;
    }

    public final int component5() {
        return this.aiGenPic;
    }

    /* renamed from: copy-02Cdc8s  reason: not valid java name */
    public final ImageUploadResult m2147copy02Cdc8s(String str, long j, long j2, double d, int i) {
        Intrinsics.checkNotNullParameter(str, "imageUrl");
        return new ImageUploadResult(str, j, j2, d, i, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ImageUploadResult) {
            ImageUploadResult imageUploadResult = (ImageUploadResult) obj;
            return Intrinsics.areEqual(this.imageUrl, imageUploadResult.imageUrl) && this.imageWidth == imageUploadResult.imageWidth && this.imageHeight == imageUploadResult.imageHeight && ContentSize.m2186equalsimpl0(this.imageSize, imageUploadResult.imageSize) && this.aiGenPic == imageUploadResult.aiGenPic;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.imageUrl.hashCode() * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.imageWidth)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.imageHeight)) * 31) + ContentSize.m2190hashCodeimpl(this.imageSize)) * 31) + this.aiGenPic;
    }

    public String toString() {
        String str = this.imageUrl;
        long j = this.imageWidth;
        long j2 = this.imageHeight;
        String m2193toStringimpl = ContentSize.m2193toStringimpl(this.imageSize);
        return "ImageUploadResult(imageUrl=" + str + ", imageWidth=" + j + ", imageHeight=" + j2 + ", imageSize=" + m2193toStringimpl + ", aiGenPic=" + this.aiGenPic + ")";
    }

    /* compiled from: AssetUploader.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/paragraph/assetuploader/ImageUploadResult$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/paragraph/assetuploader/ImageUploadResult;", "assetuploader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ImageUploadResult> serializer() {
            return ImageUploadResult$$serializer.INSTANCE;
        }
    }

    private /* synthetic */ ImageUploadResult(int seen0, String imageUrl, long imageWidth, long imageHeight, ContentSize imageSize, int aiGenPic, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (seen0 & 15)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 15, ImageUploadResult$$serializer.INSTANCE.getDescriptor());
        }
        this.imageUrl = imageUrl;
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.imageSize = imageSize.m2195unboximpl();
        if ((seen0 & 16) == 0) {
            this.aiGenPic = 0;
        } else {
            this.aiGenPic = aiGenPic;
        }
        this.resolution = new Resolution((int) this.imageWidth, (int) this.imageHeight);
    }

    private ImageUploadResult(String imageUrl, long imageWidth, long imageHeight, double imageSize, int aiGenPic) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        this.imageUrl = imageUrl;
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.imageSize = imageSize;
        this.aiGenPic = aiGenPic;
        this.resolution = new Resolution((int) this.imageWidth, (int) this.imageHeight);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$assetuploader_debug(ImageUploadResult self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.imageUrl);
        output.encodeLongElement(serialDesc, 1, self.imageWidth);
        output.encodeLongElement(serialDesc, 2, self.imageHeight);
        output.encodeSerializableElement(serialDesc, 3, BytesSizeSerializer.INSTANCE, ContentSize.m2181boximpl(self.imageSize));
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.aiGenPic != 0) {
            output.encodeIntElement(serialDesc, 4, self.aiGenPic);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ImageUploadResult(String str, long j, long j2, double d, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, j2, d, r9, null);
        int i3;
        if ((i2 & 16) == 0) {
            i3 = i;
        } else {
            i3 = 0;
        }
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final long getImageWidth() {
        return this.imageWidth;
    }

    public final long getImageHeight() {
        return this.imageHeight;
    }

    /* renamed from: getImageSize-QJZHGII  reason: not valid java name */
    public final double m2148getImageSizeQJZHGII() {
        return this.imageSize;
    }

    public final int getAiGenPic() {
        return this.aiGenPic;
    }

    public final Resolution getResolution() {
        return this.resolution;
    }
}