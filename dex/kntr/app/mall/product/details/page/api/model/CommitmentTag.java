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
import kotlinx.serialization.internal.ByteSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: ResponseModels.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002&'B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bB9\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J2\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\nHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0001¢\u0006\u0002\b%R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006("}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CommitmentTag;", "", "name", "", "style", "", "type", "<init>", "(Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName", "()Ljava/lang/String;", "getStyle", "()Ljava/lang/Byte;", "Ljava/lang/Byte;", "getType", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/model/CommitmentTag;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class CommitmentTag {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String name;
    private final Byte style;
    private final String type;

    public CommitmentTag() {
        this((String) null, (Byte) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CommitmentTag copy$default(CommitmentTag commitmentTag, String str, Byte b, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = commitmentTag.name;
        }
        if ((i & 2) != 0) {
            b = commitmentTag.style;
        }
        if ((i & 4) != 0) {
            str2 = commitmentTag.type;
        }
        return commitmentTag.copy(str, b, str2);
    }

    public final String component1() {
        return this.name;
    }

    public final Byte component2() {
        return this.style;
    }

    public final String component3() {
        return this.type;
    }

    public final CommitmentTag copy(String str, Byte b, String str2) {
        return new CommitmentTag(str, b, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CommitmentTag) {
            CommitmentTag commitmentTag = (CommitmentTag) obj;
            return Intrinsics.areEqual(this.name, commitmentTag.name) && Intrinsics.areEqual(this.style, commitmentTag.style) && Intrinsics.areEqual(this.type, commitmentTag.type);
        }
        return false;
    }

    public int hashCode() {
        return ((((this.name == null ? 0 : this.name.hashCode()) * 31) + (this.style == null ? 0 : this.style.hashCode())) * 31) + (this.type != null ? this.type.hashCode() : 0);
    }

    public String toString() {
        String str = this.name;
        Byte b = this.style;
        return "CommitmentTag(name=" + str + ", style=" + b + ", type=" + this.type + ")";
    }

    /* compiled from: ResponseModels.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CommitmentTag$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/CommitmentTag;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<CommitmentTag> serializer() {
            return CommitmentTag$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ CommitmentTag(int seen0, String name, Byte style, String type, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.name = null;
        } else {
            this.name = name;
        }
        if ((seen0 & 2) == 0) {
            this.style = null;
        } else {
            this.style = style;
        }
        if ((seen0 & 4) == 0) {
            this.type = null;
        } else {
            this.type = type;
        }
    }

    public CommitmentTag(String name, Byte style, String type) {
        this.name = name;
        this.style = style;
        this.type = type;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(CommitmentTag self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.name != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.name);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.style != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, ByteSerializer.INSTANCE, self.style);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.type != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.type);
        }
    }

    public /* synthetic */ CommitmentTag(String str, Byte b, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : b, (i & 4) != 0 ? null : str2);
    }

    public final String getName() {
        return this.name;
    }

    public final Byte getStyle() {
        return this.style;
    }

    public final String getType() {
        return this.type;
    }
}