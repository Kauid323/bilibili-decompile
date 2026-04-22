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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: UserInteractInfo.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0002,-BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nBM\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003JJ\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\fHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006."}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ShareExtra;", "", "imageUrl", "", "mid", "", "text", "title", "url", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getImageUrl", "()Ljava/lang/String;", "getMid", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getText", "getTitle", "getUrl", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/model/ShareExtra;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class ShareExtra {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String imageUrl;
    private final Long mid;
    private final String text;
    private final String title;
    private final String url;

    public ShareExtra() {
        this((String) null, (Long) null, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShareExtra copy$default(ShareExtra shareExtra, String str, Long l, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shareExtra.imageUrl;
        }
        if ((i & 2) != 0) {
            l = shareExtra.mid;
        }
        Long l2 = l;
        if ((i & 4) != 0) {
            str2 = shareExtra.text;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = shareExtra.title;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            str4 = shareExtra.url;
        }
        return shareExtra.copy(str, l2, str5, str6, str4);
    }

    public final String component1() {
        return this.imageUrl;
    }

    public final Long component2() {
        return this.mid;
    }

    public final String component3() {
        return this.text;
    }

    public final String component4() {
        return this.title;
    }

    public final String component5() {
        return this.url;
    }

    public final ShareExtra copy(String str, Long l, String str2, String str3, String str4) {
        return new ShareExtra(str, l, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ShareExtra) {
            ShareExtra shareExtra = (ShareExtra) obj;
            return Intrinsics.areEqual(this.imageUrl, shareExtra.imageUrl) && Intrinsics.areEqual(this.mid, shareExtra.mid) && Intrinsics.areEqual(this.text, shareExtra.text) && Intrinsics.areEqual(this.title, shareExtra.title) && Intrinsics.areEqual(this.url, shareExtra.url);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.imageUrl == null ? 0 : this.imageUrl.hashCode()) * 31) + (this.mid == null ? 0 : this.mid.hashCode())) * 31) + (this.text == null ? 0 : this.text.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.url != null ? this.url.hashCode() : 0);
    }

    public String toString() {
        String str = this.imageUrl;
        Long l = this.mid;
        String str2 = this.text;
        String str3 = this.title;
        return "ShareExtra(imageUrl=" + str + ", mid=" + l + ", text=" + str2 + ", title=" + str3 + ", url=" + this.url + ")";
    }

    /* compiled from: UserInteractInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ShareExtra$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ShareExtra;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ShareExtra> serializer() {
            return ShareExtra$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ShareExtra(int seen0, String imageUrl, Long mid, String text, String title, String url, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.imageUrl = null;
        } else {
            this.imageUrl = imageUrl;
        }
        if ((seen0 & 2) == 0) {
            this.mid = null;
        } else {
            this.mid = mid;
        }
        if ((seen0 & 4) == 0) {
            this.text = null;
        } else {
            this.text = text;
        }
        if ((seen0 & 8) == 0) {
            this.title = null;
        } else {
            this.title = title;
        }
        if ((seen0 & 16) == 0) {
            this.url = null;
        } else {
            this.url = url;
        }
    }

    public ShareExtra(String imageUrl, Long mid, String text, String title, String url) {
        this.imageUrl = imageUrl;
        this.mid = mid;
        this.text = text;
        this.title = title;
        this.url = url;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(ShareExtra self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.imageUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.imageUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.mid != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, LongSerializer.INSTANCE, self.mid);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.text != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.text);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.title != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.title);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.url != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.url);
        }
    }

    public /* synthetic */ ShareExtra(String str, Long l, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4);
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final Long getMid() {
        return this.mid;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }
}