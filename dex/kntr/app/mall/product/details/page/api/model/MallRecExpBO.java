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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: ResponseModels.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007B9\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ2\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\tHÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000e¨\u0006&"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/MallRecExpBO;", "", "searchHitExp", "", "tianMaHitExp", "tmSearchRetain", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSearchHitExp", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTianMaHitExp", "getTmSearchRetain", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lkntr/app/mall/product/details/page/api/model/MallRecExpBO;", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class MallRecExpBO {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final Boolean searchHitExp;
    private final Boolean tianMaHitExp;
    private final Boolean tmSearchRetain;

    public MallRecExpBO() {
        this((Boolean) null, (Boolean) null, (Boolean) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ MallRecExpBO copy$default(MallRecExpBO mallRecExpBO, Boolean bool, Boolean bool2, Boolean bool3, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = mallRecExpBO.searchHitExp;
        }
        if ((i & 2) != 0) {
            bool2 = mallRecExpBO.tianMaHitExp;
        }
        if ((i & 4) != 0) {
            bool3 = mallRecExpBO.tmSearchRetain;
        }
        return mallRecExpBO.copy(bool, bool2, bool3);
    }

    public final Boolean component1() {
        return this.searchHitExp;
    }

    public final Boolean component2() {
        return this.tianMaHitExp;
    }

    public final Boolean component3() {
        return this.tmSearchRetain;
    }

    public final MallRecExpBO copy(Boolean bool, Boolean bool2, Boolean bool3) {
        return new MallRecExpBO(bool, bool2, bool3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MallRecExpBO) {
            MallRecExpBO mallRecExpBO = (MallRecExpBO) obj;
            return Intrinsics.areEqual(this.searchHitExp, mallRecExpBO.searchHitExp) && Intrinsics.areEqual(this.tianMaHitExp, mallRecExpBO.tianMaHitExp) && Intrinsics.areEqual(this.tmSearchRetain, mallRecExpBO.tmSearchRetain);
        }
        return false;
    }

    public int hashCode() {
        return ((((this.searchHitExp == null ? 0 : this.searchHitExp.hashCode()) * 31) + (this.tianMaHitExp == null ? 0 : this.tianMaHitExp.hashCode())) * 31) + (this.tmSearchRetain != null ? this.tmSearchRetain.hashCode() : 0);
    }

    public String toString() {
        Boolean bool = this.searchHitExp;
        Boolean bool2 = this.tianMaHitExp;
        return "MallRecExpBO(searchHitExp=" + bool + ", tianMaHitExp=" + bool2 + ", tmSearchRetain=" + this.tmSearchRetain + ")";
    }

    /* compiled from: ResponseModels.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/MallRecExpBO$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/MallRecExpBO;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<MallRecExpBO> serializer() {
            return MallRecExpBO$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ MallRecExpBO(int seen0, Boolean searchHitExp, Boolean tianMaHitExp, Boolean tmSearchRetain, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.searchHitExp = null;
        } else {
            this.searchHitExp = searchHitExp;
        }
        if ((seen0 & 2) == 0) {
            this.tianMaHitExp = null;
        } else {
            this.tianMaHitExp = tianMaHitExp;
        }
        if ((seen0 & 4) == 0) {
            this.tmSearchRetain = null;
        } else {
            this.tmSearchRetain = tmSearchRetain;
        }
    }

    public MallRecExpBO(Boolean searchHitExp, Boolean tianMaHitExp, Boolean tmSearchRetain) {
        this.searchHitExp = searchHitExp;
        this.tianMaHitExp = tianMaHitExp;
        this.tmSearchRetain = tmSearchRetain;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(MallRecExpBO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.searchHitExp != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.searchHitExp);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.tianMaHitExp != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.tianMaHitExp);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.tmSearchRetain != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, BooleanSerializer.INSTANCE, self.tmSearchRetain);
        }
    }

    public /* synthetic */ MallRecExpBO(Boolean bool, Boolean bool2, Boolean bool3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : bool2, (i & 4) != 0 ? null : bool3);
    }

    public final Boolean getSearchHitExp() {
        return this.searchHitExp;
    }

    public final Boolean getTianMaHitExp() {
        return this.tianMaHitExp;
    }

    public final Boolean getTmSearchRetain() {
        return this.tmSearchRetain;
    }
}