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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: MergeAtmospherePriceFloor.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002-.B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bBa\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0007\u0010\u0011J\r\u0010\u0018\u001a\u00020\u0019H\u0000¢\u0006\u0002\b\u001aJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J2\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u00192\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\nHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015¨\u0006/"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ImageColorModel;", "Lkntr/app/mall/product/details/page/api/model/ColorModel;", "url", "", "width", "", "height", "<init>", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;)V", "seen0", "", "backDayColor", "backNightColor", "dayColor", "nightColor", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUrl", "()Ljava/lang/String;", "getWidth", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getHeight", "isValid", "", "isValid$product_details_page_debug", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;)Lkntr/app/mall/product/details/page/api/model/ImageColorModel;", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class ImageColorModel extends ColorModel {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final Double height;
    private final String url;
    private final Double width;

    public ImageColorModel() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ImageColorModel copy$default(ImageColorModel imageColorModel, String str, Double d, Double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = imageColorModel.url;
        }
        if ((i & 2) != 0) {
            d = imageColorModel.width;
        }
        if ((i & 4) != 0) {
            d2 = imageColorModel.height;
        }
        return imageColorModel.copy(str, d, d2);
    }

    public final String component1() {
        return this.url;
    }

    public final Double component2() {
        return this.width;
    }

    public final Double component3() {
        return this.height;
    }

    public final ImageColorModel copy(String str, Double d, Double d2) {
        return new ImageColorModel(str, d, d2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ImageColorModel) {
            ImageColorModel imageColorModel = (ImageColorModel) obj;
            return Intrinsics.areEqual(this.url, imageColorModel.url) && Intrinsics.areEqual(this.width, imageColorModel.width) && Intrinsics.areEqual(this.height, imageColorModel.height);
        }
        return false;
    }

    public int hashCode() {
        return ((((this.url == null ? 0 : this.url.hashCode()) * 31) + (this.width == null ? 0 : this.width.hashCode())) * 31) + (this.height != null ? this.height.hashCode() : 0);
    }

    public String toString() {
        String str = this.url;
        Double d = this.width;
        return "ImageColorModel(url=" + str + ", width=" + d + ", height=" + this.height + ")";
    }

    /* compiled from: MergeAtmospherePriceFloor.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ImageColorModel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ImageColorModel;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ImageColorModel> serializer() {
            return ImageColorModel$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ImageColorModel(int seen0, String backDayColor, String backNightColor, String dayColor, String nightColor, String url, Double width, Double height, SerializationConstructorMarker serializationConstructorMarker) {
        super(seen0, backDayColor, backNightColor, dayColor, nightColor, serializationConstructorMarker);
        if ((seen0 & 16) == 0) {
            this.url = null;
        } else {
            this.url = url;
        }
        if ((seen0 & 32) == 0) {
            this.width = null;
        } else {
            this.width = width;
        }
        if ((seen0 & 64) == 0) {
            this.height = null;
        } else {
            this.height = height;
        }
    }

    public ImageColorModel(String url, Double width, Double height) {
        super((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
        this.url = url;
        this.width = width;
        this.height = height;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(ImageColorModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
        ColorModel.write$Self(self, output, serialDesc);
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.url != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.url);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.width != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, DoubleSerializer.INSTANCE, self.width);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.height != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, DoubleSerializer.INSTANCE, self.height);
        }
    }

    public /* synthetic */ ImageColorModel(String str, Double d, Double d2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : d, (i & 4) != 0 ? null : d2);
    }

    public final String getUrl() {
        return this.url;
    }

    public final Double getWidth() {
        return this.width;
    }

    public final Double getHeight() {
        return this.height;
    }

    public final boolean isValid$product_details_page_debug() {
        String str = this.url;
        boolean hasUrl = !(str == null || str.length() == 0);
        boolean hasSize = this.width != null && this.width.doubleValue() > 0.0d && this.height != null && this.height.doubleValue() > 0.0d;
        return hasUrl && hasSize;
    }
}