package kntr.app.mall.product.details.page.api.model;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: ImageModel.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0002+,B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nBC\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000eJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J>\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0007HÖ\u0001J%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0017\u0010\u0010¨\u0006-"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ImageModel;", "", "height", "", "size", "", "url", "", "width", "<init>", "(Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getHeight", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUrl", "()Ljava/lang/String;", "getWidth", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;)Lkntr/app/mall/product/details/page/api/model/ImageModel;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class ImageModel {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final Double height;
    private final Integer size;
    private final String url;
    private final Double width;

    public ImageModel() {
        this((Double) null, (Integer) null, (String) null, (Double) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ImageModel copy$default(ImageModel imageModel, Double d, Integer num, String str, Double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            d = imageModel.height;
        }
        if ((i & 2) != 0) {
            num = imageModel.size;
        }
        if ((i & 4) != 0) {
            str = imageModel.url;
        }
        if ((i & 8) != 0) {
            d2 = imageModel.width;
        }
        return imageModel.copy(d, num, str, d2);
    }

    public final Double component1() {
        return this.height;
    }

    public final Integer component2() {
        return this.size;
    }

    public final String component3() {
        return this.url;
    }

    public final Double component4() {
        return this.width;
    }

    public final ImageModel copy(Double d, Integer num, String str, Double d2) {
        return new ImageModel(d, num, str, d2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ImageModel) {
            ImageModel imageModel = (ImageModel) obj;
            return Intrinsics.areEqual(this.height, imageModel.height) && Intrinsics.areEqual(this.size, imageModel.size) && Intrinsics.areEqual(this.url, imageModel.url) && Intrinsics.areEqual(this.width, imageModel.width);
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.height == null ? 0 : this.height.hashCode()) * 31) + (this.size == null ? 0 : this.size.hashCode())) * 31) + (this.url == null ? 0 : this.url.hashCode())) * 31) + (this.width != null ? this.width.hashCode() : 0);
    }

    public String toString() {
        Double d = this.height;
        Integer num = this.size;
        String str = this.url;
        return "ImageModel(height=" + d + ", size=" + num + ", url=" + str + ", width=" + this.width + ")";
    }

    /* compiled from: ImageModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ImageModel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ImageModel;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ImageModel> serializer() {
            return ImageModel$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ImageModel(int seen0, Double height, Integer size, String url, Double width, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.height = null;
        } else {
            this.height = height;
        }
        if ((seen0 & 2) == 0) {
            this.size = null;
        } else {
            this.size = size;
        }
        if ((seen0 & 4) == 0) {
            this.url = null;
        } else {
            this.url = url;
        }
        if ((seen0 & 8) == 0) {
            this.width = null;
        } else {
            this.width = width;
        }
    }

    public ImageModel(Double height, Integer size, String url, Double width) {
        this.height = height;
        this.size = size;
        this.url = url;
        this.width = width;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(ImageModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.height != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, DoubleSerializer.INSTANCE, self.height);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.size != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.size);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.url != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.url);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.width != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, DoubleSerializer.INSTANCE, self.width);
        }
    }

    public /* synthetic */ ImageModel(Double d, Integer num, String str, Double d2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : d, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : d2);
    }

    public final Double getHeight() {
        return this.height;
    }

    public final Integer getSize() {
        return this.size;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Double getWidth() {
        return this.width;
    }
}