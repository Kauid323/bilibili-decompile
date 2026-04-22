package kntr.app.mall.product.details.page.api.model;

import java.util.List;
import kntr.app.mall.product.details.page.api.model.AdvStateFloor;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;

/* compiled from: AdvStateFloor.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0003()*B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tBC\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J9\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006+"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/AdvStateFloor;", "Lkntr/app/mall/product/details/page/api/model/FloorModel;", "floorKey", "", "floorIcon", "bgImgUrl", "advState", "Lkntr/app/mall/product/details/page/api/model/AdvStateFloor$AdvState;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/AdvStateFloor$AdvState;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/AdvStateFloor$AdvState;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFloorKey", "()Ljava/lang/String;", "getFloorIcon", "getBgImgUrl", "getAdvState", "()Lkntr/app/mall/product/details/page/api/model/AdvStateFloor$AdvState;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "AdvState", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class AdvStateFloor implements FloorModel {
    private final AdvState advState;
    private final String bgImgUrl;
    private final String floorIcon;
    private final String floorKey;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public AdvStateFloor() {
        this((String) null, (String) null, (String) null, (AdvState) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AdvStateFloor copy$default(AdvStateFloor advStateFloor, String str, String str2, String str3, AdvState advState, int i, Object obj) {
        if ((i & 1) != 0) {
            str = advStateFloor.floorKey;
        }
        if ((i & 2) != 0) {
            str2 = advStateFloor.floorIcon;
        }
        if ((i & 4) != 0) {
            str3 = advStateFloor.bgImgUrl;
        }
        if ((i & 8) != 0) {
            advState = advStateFloor.advState;
        }
        return advStateFloor.copy(str, str2, str3, advState);
    }

    public final String component1() {
        return this.floorKey;
    }

    public final String component2() {
        return this.floorIcon;
    }

    public final String component3() {
        return this.bgImgUrl;
    }

    public final AdvState component4() {
        return this.advState;
    }

    public final AdvStateFloor copy(String str, String str2, String str3, AdvState advState) {
        return new AdvStateFloor(str, str2, str3, advState);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdvStateFloor) {
            AdvStateFloor advStateFloor = (AdvStateFloor) obj;
            return Intrinsics.areEqual(this.floorKey, advStateFloor.floorKey) && Intrinsics.areEqual(this.floorIcon, advStateFloor.floorIcon) && Intrinsics.areEqual(this.bgImgUrl, advStateFloor.bgImgUrl) && Intrinsics.areEqual(this.advState, advStateFloor.advState);
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.floorKey == null ? 0 : this.floorKey.hashCode()) * 31) + (this.floorIcon == null ? 0 : this.floorIcon.hashCode())) * 31) + (this.bgImgUrl == null ? 0 : this.bgImgUrl.hashCode())) * 31) + (this.advState != null ? this.advState.hashCode() : 0);
    }

    public String toString() {
        String str = this.floorKey;
        String str2 = this.floorIcon;
        String str3 = this.bgImgUrl;
        return "AdvStateFloor(floorKey=" + str + ", floorIcon=" + str2 + ", bgImgUrl=" + str3 + ", advState=" + this.advState + ")";
    }

    /* compiled from: AdvStateFloor.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/AdvStateFloor$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/AdvStateFloor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdvStateFloor> serializer() {
            return AdvStateFloor$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdvStateFloor(int seen0, String floorKey, String floorIcon, String bgImgUrl, AdvState advState, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.floorKey = null;
        } else {
            this.floorKey = floorKey;
        }
        if ((seen0 & 2) == 0) {
            this.floorIcon = null;
        } else {
            this.floorIcon = floorIcon;
        }
        if ((seen0 & 4) == 0) {
            this.bgImgUrl = null;
        } else {
            this.bgImgUrl = bgImgUrl;
        }
        if ((seen0 & 8) == 0) {
            this.advState = null;
        } else {
            this.advState = advState;
        }
    }

    public AdvStateFloor(String floorKey, String floorIcon, String bgImgUrl, AdvState advState) {
        this.floorKey = floorKey;
        this.floorIcon = floorIcon;
        this.bgImgUrl = bgImgUrl;
        this.advState = advState;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(AdvStateFloor self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.getFloorKey() != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.getFloorKey());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.getFloorIcon() != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.getFloorIcon());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.getBgImgUrl() != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.getBgImgUrl());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.advState != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, AdvStateFloor$AdvState$$serializer.INSTANCE, self.advState);
        }
    }

    public /* synthetic */ AdvStateFloor(String str, String str2, String str3, AdvState advState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : advState);
    }

    @Override // kntr.app.mall.product.details.page.api.model.FloorModel
    public String getFloorKey() {
        return this.floorKey;
    }

    @Override // kntr.app.mall.product.details.page.api.model.FloorModel
    public String getFloorIcon() {
        return this.floorIcon;
    }

    @Override // kntr.app.mall.product.details.page.api.model.FloorModel
    public String getBgImgUrl() {
        return this.bgImgUrl;
    }

    public final AdvState getAdvState() {
        return this.advState;
    }

    /* compiled from: AdvStateFloor.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 F2\u00020\u0001:\u0004CDEFB\u0097\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0005¢\u0006\u0004\b\u0013\u0010\u0014B\u0095\u0001\b\u0010\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0013\u0010\u0018J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010$J\u0010\u00101\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u00102\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u00103\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0011\u00104\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0005HÆ\u0003J\u009e\u0001\u00105\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u00106J\u0013\u00107\u001a\u00020\r2\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\tHÖ\u0001J\t\u0010:\u001a\u00020\u0003HÖ\u0001J%\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00002\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0001¢\u0006\u0002\bBR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010 \u001a\u0004\b&\u0010\u001fR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010 \u001a\u0004\b'\u0010\u001fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010 \u001a\u0004\b(\u0010\u001fR\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001c¨\u0006G"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/AdvStateFloor$AdvState;", "", "activityDeposit", "", "batchRecords", "", "Lkntr/app/mall/product/details/page/api/model/AdvStateFloor$AdvState$BatchRecord;", "deposit", "depositType", "", "maxActivityDeposit", "maxDeposit", "preSale", "", "presaleEndOrderTime", "presaleStartOrderTime", "remain", "state", "Lkntr/app/mall/product/details/page/api/model/AdvStateFloor$AdvState$StateInfo;", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getActivityDeposit", "()Ljava/lang/String;", "getBatchRecords", "()Ljava/util/List;", "getDeposit", "getDepositType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaxActivityDeposit", "getMaxDeposit", "getPreSale", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPresaleEndOrderTime", "getPresaleStartOrderTime", "getRemain", "getState", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)Lkntr/app/mall/product/details/page/api/model/AdvStateFloor$AdvState;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "BatchRecord", "StateInfo", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AdvState {
        private final String activityDeposit;
        private final List<BatchRecord> batchRecords;
        private final String deposit;
        private final Integer depositType;
        private final String maxActivityDeposit;
        private final String maxDeposit;
        private final Boolean preSale;
        private final Integer presaleEndOrderTime;
        private final Integer presaleStartOrderTime;
        private final Integer remain;
        private final List<StateInfo> state;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.AdvStateFloor$AdvState$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_;
                _childSerializers$_anonymous_ = AdvStateFloor.AdvState._childSerializers$_anonymous_();
                return _childSerializers$_anonymous_;
            }
        }), null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.AdvStateFloor$AdvState$$ExternalSyntheticLambda1
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_$0;
                _childSerializers$_anonymous_$0 = AdvStateFloor.AdvState._childSerializers$_anonymous_$0();
                return _childSerializers$_anonymous_$0;
            }
        })};

        public AdvState() {
            this((String) null, (List) null, (String) null, (Integer) null, (String) null, (String) null, (Boolean) null, (Integer) null, (Integer) null, (Integer) null, (List) null, 2047, (DefaultConstructorMarker) null);
        }

        public final String component1() {
            return this.activityDeposit;
        }

        public final Integer component10() {
            return this.remain;
        }

        public final List<StateInfo> component11() {
            return this.state;
        }

        public final List<BatchRecord> component2() {
            return this.batchRecords;
        }

        public final String component3() {
            return this.deposit;
        }

        public final Integer component4() {
            return this.depositType;
        }

        public final String component5() {
            return this.maxActivityDeposit;
        }

        public final String component6() {
            return this.maxDeposit;
        }

        public final Boolean component7() {
            return this.preSale;
        }

        public final Integer component8() {
            return this.presaleEndOrderTime;
        }

        public final Integer component9() {
            return this.presaleStartOrderTime;
        }

        public final AdvState copy(String str, List<BatchRecord> list, String str2, Integer num, String str3, String str4, Boolean bool, Integer num2, Integer num3, Integer num4, List<StateInfo> list2) {
            return new AdvState(str, list, str2, num, str3, str4, bool, num2, num3, num4, list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AdvState) {
                AdvState advState = (AdvState) obj;
                return Intrinsics.areEqual(this.activityDeposit, advState.activityDeposit) && Intrinsics.areEqual(this.batchRecords, advState.batchRecords) && Intrinsics.areEqual(this.deposit, advState.deposit) && Intrinsics.areEqual(this.depositType, advState.depositType) && Intrinsics.areEqual(this.maxActivityDeposit, advState.maxActivityDeposit) && Intrinsics.areEqual(this.maxDeposit, advState.maxDeposit) && Intrinsics.areEqual(this.preSale, advState.preSale) && Intrinsics.areEqual(this.presaleEndOrderTime, advState.presaleEndOrderTime) && Intrinsics.areEqual(this.presaleStartOrderTime, advState.presaleStartOrderTime) && Intrinsics.areEqual(this.remain, advState.remain) && Intrinsics.areEqual(this.state, advState.state);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((((((((this.activityDeposit == null ? 0 : this.activityDeposit.hashCode()) * 31) + (this.batchRecords == null ? 0 : this.batchRecords.hashCode())) * 31) + (this.deposit == null ? 0 : this.deposit.hashCode())) * 31) + (this.depositType == null ? 0 : this.depositType.hashCode())) * 31) + (this.maxActivityDeposit == null ? 0 : this.maxActivityDeposit.hashCode())) * 31) + (this.maxDeposit == null ? 0 : this.maxDeposit.hashCode())) * 31) + (this.preSale == null ? 0 : this.preSale.hashCode())) * 31) + (this.presaleEndOrderTime == null ? 0 : this.presaleEndOrderTime.hashCode())) * 31) + (this.presaleStartOrderTime == null ? 0 : this.presaleStartOrderTime.hashCode())) * 31) + (this.remain == null ? 0 : this.remain.hashCode())) * 31) + (this.state != null ? this.state.hashCode() : 0);
        }

        public String toString() {
            String str = this.activityDeposit;
            List<BatchRecord> list = this.batchRecords;
            String str2 = this.deposit;
            Integer num = this.depositType;
            String str3 = this.maxActivityDeposit;
            String str4 = this.maxDeposit;
            Boolean bool = this.preSale;
            Integer num2 = this.presaleEndOrderTime;
            Integer num3 = this.presaleStartOrderTime;
            Integer num4 = this.remain;
            return "AdvState(activityDeposit=" + str + ", batchRecords=" + list + ", deposit=" + str2 + ", depositType=" + num + ", maxActivityDeposit=" + str3 + ", maxDeposit=" + str4 + ", preSale=" + bool + ", presaleEndOrderTime=" + num2 + ", presaleStartOrderTime=" + num3 + ", remain=" + num4 + ", state=" + this.state + ")";
        }

        /* compiled from: AdvStateFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/AdvStateFloor$AdvState$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/AdvStateFloor$AdvState;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<AdvState> serializer() {
                return AdvStateFloor$AdvState$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ AdvState(int seen0, String activityDeposit, List batchRecords, String deposit, Integer depositType, String maxActivityDeposit, String maxDeposit, Boolean preSale, Integer presaleEndOrderTime, Integer presaleStartOrderTime, Integer remain, List state, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.activityDeposit = null;
            } else {
                this.activityDeposit = activityDeposit;
            }
            if ((seen0 & 2) == 0) {
                this.batchRecords = null;
            } else {
                this.batchRecords = batchRecords;
            }
            if ((seen0 & 4) == 0) {
                this.deposit = null;
            } else {
                this.deposit = deposit;
            }
            if ((seen0 & 8) == 0) {
                this.depositType = null;
            } else {
                this.depositType = depositType;
            }
            if ((seen0 & 16) == 0) {
                this.maxActivityDeposit = null;
            } else {
                this.maxActivityDeposit = maxActivityDeposit;
            }
            if ((seen0 & 32) == 0) {
                this.maxDeposit = null;
            } else {
                this.maxDeposit = maxDeposit;
            }
            if ((seen0 & 64) == 0) {
                this.preSale = null;
            } else {
                this.preSale = preSale;
            }
            if ((seen0 & 128) == 0) {
                this.presaleEndOrderTime = null;
            } else {
                this.presaleEndOrderTime = presaleEndOrderTime;
            }
            if ((seen0 & 256) == 0) {
                this.presaleStartOrderTime = null;
            } else {
                this.presaleStartOrderTime = presaleStartOrderTime;
            }
            if ((seen0 & 512) == 0) {
                this.remain = null;
            } else {
                this.remain = remain;
            }
            if ((seen0 & 1024) == 0) {
                this.state = null;
            } else {
                this.state = state;
            }
        }

        public AdvState(String activityDeposit, List<BatchRecord> list, String deposit, Integer depositType, String maxActivityDeposit, String maxDeposit, Boolean preSale, Integer presaleEndOrderTime, Integer presaleStartOrderTime, Integer remain, List<StateInfo> list2) {
            this.activityDeposit = activityDeposit;
            this.batchRecords = list;
            this.deposit = deposit;
            this.depositType = depositType;
            this.maxActivityDeposit = maxActivityDeposit;
            this.maxDeposit = maxDeposit;
            this.preSale = preSale;
            this.presaleEndOrderTime = presaleEndOrderTime;
            this.presaleStartOrderTime = presaleStartOrderTime;
            this.remain = remain;
            this.state = list2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(AdvStateFloor$AdvState$BatchRecord$$serializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
            return new ArrayListSerializer(AdvStateFloor$AdvState$StateInfo$$serializer.INSTANCE);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(AdvState self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.activityDeposit != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.activityDeposit);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.batchRecords != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.batchRecords);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.deposit != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.deposit);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.depositType != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, IntSerializer.INSTANCE, self.depositType);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.maxActivityDeposit != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.maxActivityDeposit);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.maxDeposit != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.maxDeposit);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.preSale != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, BooleanSerializer.INSTANCE, self.preSale);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.presaleEndOrderTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, IntSerializer.INSTANCE, self.presaleEndOrderTime);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.presaleStartOrderTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 8, IntSerializer.INSTANCE, self.presaleStartOrderTime);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 9) || self.remain != null) {
                output.encodeNullableSerializableElement(serialDesc, 9, IntSerializer.INSTANCE, self.remain);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 10) || self.state != null) {
                output.encodeNullableSerializableElement(serialDesc, 10, lazyArr[10].getValue(), self.state);
            }
        }

        public /* synthetic */ AdvState(String str, List list, String str2, Integer num, String str3, String str4, Boolean bool, Integer num2, Integer num3, Integer num4, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : bool, (i & 128) != 0 ? null : num2, (i & 256) != 0 ? null : num3, (i & 512) != 0 ? null : num4, (i & 1024) == 0 ? list2 : null);
        }

        public final String getActivityDeposit() {
            return this.activityDeposit;
        }

        public final List<BatchRecord> getBatchRecords() {
            return this.batchRecords;
        }

        public final String getDeposit() {
            return this.deposit;
        }

        public final Integer getDepositType() {
            return this.depositType;
        }

        public final String getMaxActivityDeposit() {
            return this.maxActivityDeposit;
        }

        public final String getMaxDeposit() {
            return this.maxDeposit;
        }

        public final Boolean getPreSale() {
            return this.preSale;
        }

        public final Integer getPresaleEndOrderTime() {
            return this.presaleEndOrderTime;
        }

        public final Integer getPresaleStartOrderTime() {
            return this.presaleStartOrderTime;
        }

        public final Integer getRemain() {
            return this.remain;
        }

        /* compiled from: AdvStateFloor.kt */
        @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0002)*B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tBC\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001J%\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001¢\u0006\u0002\b(R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010¨\u0006+"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/AdvStateFloor$AdvState$BatchRecord;", "", "desc", "", "endTimestamp", "", "startTimestamp", "tag", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDesc", "()Ljava/lang/String;", "getEndTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getStartTimestamp", "getTag", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/model/AdvStateFloor$AdvState$BatchRecord;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @Serializable
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class BatchRecord {
            public static final int $stable = 0;
            public static final Companion Companion = new Companion(null);
            private final String desc;
            private final Long endTimestamp;
            private final Long startTimestamp;
            private final String tag;

            public BatchRecord() {
                this((String) null, (Long) null, (Long) null, (String) null, 15, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ BatchRecord copy$default(BatchRecord batchRecord, String str, Long l, Long l2, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = batchRecord.desc;
                }
                if ((i & 2) != 0) {
                    l = batchRecord.endTimestamp;
                }
                if ((i & 4) != 0) {
                    l2 = batchRecord.startTimestamp;
                }
                if ((i & 8) != 0) {
                    str2 = batchRecord.tag;
                }
                return batchRecord.copy(str, l, l2, str2);
            }

            public final String component1() {
                return this.desc;
            }

            public final Long component2() {
                return this.endTimestamp;
            }

            public final Long component3() {
                return this.startTimestamp;
            }

            public final String component4() {
                return this.tag;
            }

            public final BatchRecord copy(String str, Long l, Long l2, String str2) {
                return new BatchRecord(str, l, l2, str2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof BatchRecord) {
                    BatchRecord batchRecord = (BatchRecord) obj;
                    return Intrinsics.areEqual(this.desc, batchRecord.desc) && Intrinsics.areEqual(this.endTimestamp, batchRecord.endTimestamp) && Intrinsics.areEqual(this.startTimestamp, batchRecord.startTimestamp) && Intrinsics.areEqual(this.tag, batchRecord.tag);
                }
                return false;
            }

            public int hashCode() {
                return ((((((this.desc == null ? 0 : this.desc.hashCode()) * 31) + (this.endTimestamp == null ? 0 : this.endTimestamp.hashCode())) * 31) + (this.startTimestamp == null ? 0 : this.startTimestamp.hashCode())) * 31) + (this.tag != null ? this.tag.hashCode() : 0);
            }

            public String toString() {
                String str = this.desc;
                Long l = this.endTimestamp;
                Long l2 = this.startTimestamp;
                return "BatchRecord(desc=" + str + ", endTimestamp=" + l + ", startTimestamp=" + l2 + ", tag=" + this.tag + ")";
            }

            /* compiled from: AdvStateFloor.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/AdvStateFloor$AdvState$BatchRecord$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/AdvStateFloor$AdvState$BatchRecord;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<BatchRecord> serializer() {
                    return AdvStateFloor$AdvState$BatchRecord$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ BatchRecord(int seen0, String desc, Long endTimestamp, Long startTimestamp, String tag, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.desc = null;
                } else {
                    this.desc = desc;
                }
                if ((seen0 & 2) == 0) {
                    this.endTimestamp = null;
                } else {
                    this.endTimestamp = endTimestamp;
                }
                if ((seen0 & 4) == 0) {
                    this.startTimestamp = null;
                } else {
                    this.startTimestamp = startTimestamp;
                }
                if ((seen0 & 8) == 0) {
                    this.tag = null;
                } else {
                    this.tag = tag;
                }
            }

            public BatchRecord(String desc, Long endTimestamp, Long startTimestamp, String tag) {
                this.desc = desc;
                this.endTimestamp = endTimestamp;
                this.startTimestamp = startTimestamp;
                this.tag = tag;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$product_details_page_debug(BatchRecord self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.desc != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.desc);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.endTimestamp != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, LongSerializer.INSTANCE, self.endTimestamp);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.startTimestamp != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, LongSerializer.INSTANCE, self.startTimestamp);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.tag != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.tag);
                }
            }

            public /* synthetic */ BatchRecord(String str, Long l, Long l2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : l2, (i & 8) != 0 ? null : str2);
            }

            public final String getDesc() {
                return this.desc;
            }

            public final Long getEndTimestamp() {
                return this.endTimestamp;
            }

            public final Long getStartTimestamp() {
                return this.startTimestamp;
            }

            public final String getTag() {
                return this.tag;
            }
        }

        public final List<StateInfo> getState() {
            return this.state;
        }

        /* compiled from: AdvStateFloor.kt */
        @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 12\u00020\u0001:\u0003/01BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fBM\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\nHÆ\u0003JJ\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u000eHÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001J%\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0001¢\u0006\u0002\b.R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u00062"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/AdvStateFloor$AdvState$StateInfo;", "", "timeNode", "Lkntr/app/mall/product/details/page/api/model/AdvStateFloor$AdvState$StateInfo$TimeNode;", "process", "", "active", "", "timeNodeDesc", "underlineProcess", "Lkotlinx/serialization/json/JsonElement;", "<init>", "(Lkntr/app/mall/product/details/page/api/model/AdvStateFloor$AdvState$StateInfo$TimeNode;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/app/mall/product/details/page/api/model/AdvStateFloor$AdvState$StateInfo$TimeNode;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTimeNode", "()Lkntr/app/mall/product/details/page/api/model/AdvStateFloor$AdvState$StateInfo$TimeNode;", "getProcess", "()Ljava/lang/String;", "getActive", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTimeNodeDesc", "getUnderlineProcess", "()Lkotlinx/serialization/json/JsonElement;", "component1", "component2", "component3", "component4", "component5", "copy", "(Lkntr/app/mall/product/details/page/api/model/AdvStateFloor$AdvState$StateInfo$TimeNode;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;)Lkntr/app/mall/product/details/page/api/model/AdvStateFloor$AdvState$StateInfo;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "TimeNode", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @Serializable
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class StateInfo {
            private final Boolean active;
            private final String process;
            private final TimeNode timeNode;
            private final String timeNodeDesc;
            private final JsonElement underlineProcess;
            public static final Companion Companion = new Companion(null);
            public static final int $stable = 8;

            public StateInfo() {
                this((TimeNode) null, (String) null, (Boolean) null, (String) null, (JsonElement) null, 31, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ StateInfo copy$default(StateInfo stateInfo, TimeNode timeNode, String str, Boolean bool, String str2, JsonElement jsonElement, int i, Object obj) {
                if ((i & 1) != 0) {
                    timeNode = stateInfo.timeNode;
                }
                if ((i & 2) != 0) {
                    str = stateInfo.process;
                }
                String str3 = str;
                if ((i & 4) != 0) {
                    bool = stateInfo.active;
                }
                Boolean bool2 = bool;
                if ((i & 8) != 0) {
                    str2 = stateInfo.timeNodeDesc;
                }
                String str4 = str2;
                if ((i & 16) != 0) {
                    jsonElement = stateInfo.underlineProcess;
                }
                return stateInfo.copy(timeNode, str3, bool2, str4, jsonElement);
            }

            public final TimeNode component1() {
                return this.timeNode;
            }

            public final String component2() {
                return this.process;
            }

            public final Boolean component3() {
                return this.active;
            }

            public final String component4() {
                return this.timeNodeDesc;
            }

            public final JsonElement component5() {
                return this.underlineProcess;
            }

            public final StateInfo copy(TimeNode timeNode, String str, Boolean bool, String str2, JsonElement jsonElement) {
                return new StateInfo(timeNode, str, bool, str2, jsonElement);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof StateInfo) {
                    StateInfo stateInfo = (StateInfo) obj;
                    return Intrinsics.areEqual(this.timeNode, stateInfo.timeNode) && Intrinsics.areEqual(this.process, stateInfo.process) && Intrinsics.areEqual(this.active, stateInfo.active) && Intrinsics.areEqual(this.timeNodeDesc, stateInfo.timeNodeDesc) && Intrinsics.areEqual(this.underlineProcess, stateInfo.underlineProcess);
                }
                return false;
            }

            public int hashCode() {
                return ((((((((this.timeNode == null ? 0 : this.timeNode.hashCode()) * 31) + (this.process == null ? 0 : this.process.hashCode())) * 31) + (this.active == null ? 0 : this.active.hashCode())) * 31) + (this.timeNodeDesc == null ? 0 : this.timeNodeDesc.hashCode())) * 31) + (this.underlineProcess != null ? this.underlineProcess.hashCode() : 0);
            }

            public String toString() {
                TimeNode timeNode = this.timeNode;
                String str = this.process;
                Boolean bool = this.active;
                String str2 = this.timeNodeDesc;
                return "StateInfo(timeNode=" + timeNode + ", process=" + str + ", active=" + bool + ", timeNodeDesc=" + str2 + ", underlineProcess=" + this.underlineProcess + ")";
            }

            /* compiled from: AdvStateFloor.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/AdvStateFloor$AdvState$StateInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/AdvStateFloor$AdvState$StateInfo;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<StateInfo> serializer() {
                    return AdvStateFloor$AdvState$StateInfo$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ StateInfo(int seen0, TimeNode timeNode, String process, Boolean active, String timeNodeDesc, JsonElement underlineProcess, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.timeNode = null;
                } else {
                    this.timeNode = timeNode;
                }
                if ((seen0 & 2) == 0) {
                    this.process = null;
                } else {
                    this.process = process;
                }
                if ((seen0 & 4) == 0) {
                    this.active = null;
                } else {
                    this.active = active;
                }
                if ((seen0 & 8) == 0) {
                    this.timeNodeDesc = null;
                } else {
                    this.timeNodeDesc = timeNodeDesc;
                }
                if ((seen0 & 16) == 0) {
                    this.underlineProcess = null;
                } else {
                    this.underlineProcess = underlineProcess;
                }
            }

            public StateInfo(TimeNode timeNode, String process, Boolean active, String timeNodeDesc, JsonElement underlineProcess) {
                this.timeNode = timeNode;
                this.process = process;
                this.active = active;
                this.timeNodeDesc = timeNodeDesc;
                this.underlineProcess = underlineProcess;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$product_details_page_debug(StateInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.timeNode != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, AdvStateFloor$AdvState$StateInfo$TimeNode$$serializer.INSTANCE, self.timeNode);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.process != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.process);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.active != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, BooleanSerializer.INSTANCE, self.active);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.timeNodeDesc != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.timeNodeDesc);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.underlineProcess != null) {
                    output.encodeNullableSerializableElement(serialDesc, 4, JsonElementSerializer.INSTANCE, self.underlineProcess);
                }
            }

            public /* synthetic */ StateInfo(TimeNode timeNode, String str, Boolean bool, String str2, JsonElement jsonElement, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : timeNode, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : jsonElement);
            }

            public final TimeNode getTimeNode() {
                return this.timeNode;
            }

            public final String getProcess() {
                return this.process;
            }

            public final Boolean getActive() {
                return this.active;
            }

            public final String getTimeNodeDesc() {
                return this.timeNodeDesc;
            }

            /* compiled from: AdvStateFloor.kt */
            @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007B9\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\u000bJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ2\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\r¨\u0006&"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/AdvStateFloor$AdvState$StateInfo$TimeNode;", "", "year", "", "month", "day", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getYear", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMonth", "getDay", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lkntr/app/mall/product/details/page/api/model/AdvStateFloor$AdvState$StateInfo$TimeNode;", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            @Serializable
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class TimeNode {
                public static final int $stable = 0;
                public static final Companion Companion = new Companion(null);
                private final Integer day;
                private final Integer month;
                private final Integer year;

                public TimeNode() {
                    this((Integer) null, (Integer) null, (Integer) null, 7, (DefaultConstructorMarker) null);
                }

                public static /* synthetic */ TimeNode copy$default(TimeNode timeNode, Integer num, Integer num2, Integer num3, int i, Object obj) {
                    if ((i & 1) != 0) {
                        num = timeNode.year;
                    }
                    if ((i & 2) != 0) {
                        num2 = timeNode.month;
                    }
                    if ((i & 4) != 0) {
                        num3 = timeNode.day;
                    }
                    return timeNode.copy(num, num2, num3);
                }

                public final Integer component1() {
                    return this.year;
                }

                public final Integer component2() {
                    return this.month;
                }

                public final Integer component3() {
                    return this.day;
                }

                public final TimeNode copy(Integer num, Integer num2, Integer num3) {
                    return new TimeNode(num, num2, num3);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj instanceof TimeNode) {
                        TimeNode timeNode = (TimeNode) obj;
                        return Intrinsics.areEqual(this.year, timeNode.year) && Intrinsics.areEqual(this.month, timeNode.month) && Intrinsics.areEqual(this.day, timeNode.day);
                    }
                    return false;
                }

                public int hashCode() {
                    return ((((this.year == null ? 0 : this.year.hashCode()) * 31) + (this.month == null ? 0 : this.month.hashCode())) * 31) + (this.day != null ? this.day.hashCode() : 0);
                }

                public String toString() {
                    Integer num = this.year;
                    Integer num2 = this.month;
                    return "TimeNode(year=" + num + ", month=" + num2 + ", day=" + this.day + ")";
                }

                /* compiled from: AdvStateFloor.kt */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/AdvStateFloor$AdvState$StateInfo$TimeNode$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/AdvStateFloor$AdvState$StateInfo$TimeNode;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<TimeNode> serializer() {
                        return AdvStateFloor$AdvState$StateInfo$TimeNode$$serializer.INSTANCE;
                    }
                }

                public /* synthetic */ TimeNode(int seen0, Integer year, Integer month, Integer day, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.year = null;
                    } else {
                        this.year = year;
                    }
                    if ((seen0 & 2) == 0) {
                        this.month = null;
                    } else {
                        this.month = month;
                    }
                    if ((seen0 & 4) == 0) {
                        this.day = null;
                    } else {
                        this.day = day;
                    }
                }

                public TimeNode(Integer year, Integer month, Integer day) {
                    this.year = year;
                    this.month = month;
                    this.day = day;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$product_details_page_debug(TimeNode self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.year != null) {
                        output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.year);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.month != null) {
                        output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.month);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.day != null) {
                        output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.day);
                    }
                }

                public /* synthetic */ TimeNode(Integer num, Integer num2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3);
                }

                public final Integer getYear() {
                    return this.year;
                }

                public final Integer getMonth() {
                    return this.month;
                }

                public final Integer getDay() {
                    return this.day;
                }
            }

            public final JsonElement getUnderlineProcess() {
                return this.underlineProcess;
            }
        }
    }
}