package kntr.app.game.bean;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: SteamGameDLCBean.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ?2\u00020\u0001:\u0002>?BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fBe\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u000e\u0010\u0013J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\bHÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\rHÆ\u0003JY\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u00102\u001a\u00020\r2\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\bHÖ\u0001J\t\u00105\u001a\u00020\u0005HÖ\u0001J%\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0001¢\u0006\u0002\b=R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u001aR\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u0007\u0010\u001eR\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010\u001aR\u001c\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0015\u001a\u0004\b\"\u0010\u001aR\u001c\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0015\u001a\u0004\b$\u0010\u001aR\u001c\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0015\u001a\u0004\b&\u0010'R\u0011\u0010(\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b(\u0010'¨\u0006@"}, d2 = {"Lkntr/app/game/bean/DLCDetail;", RoomRecommendViewModel.EMPTY_CURSOR, "dlcAppId", RoomRecommendViewModel.EMPTY_CURSOR, "dlcName", RoomRecommendViewModel.EMPTY_CURSOR, "priceYuan", "isFreeInt", RoomRecommendViewModel.EMPTY_CURSOR, "releaseDate", "dlcIconUrl", "shortDescription", "owned", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(JLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDlcAppId$annotations", "()V", "getDlcAppId", "()J", "getDlcName$annotations", "getDlcName", "()Ljava/lang/String;", "getPriceYuan$annotations", "getPriceYuan", "isFreeInt$annotations", "()I", "getReleaseDate$annotations", "getReleaseDate", "getDlcIconUrl$annotations", "getDlcIconUrl", "getShortDescription$annotations", "getShortDescription", "getOwned$annotations", "getOwned", "()Z", "isFree", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$gamebiz_debug", "$serializer", "Companion", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class DLCDetail {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final long dlcAppId;
    private final String dlcIconUrl;
    private final String dlcName;
    private final int isFreeInt;
    private final boolean owned;
    private final String priceYuan;
    private final String releaseDate;
    private final String shortDescription;

    public DLCDetail() {
        this(0L, (String) null, (String) null, 0, (String) null, (String) null, (String) null, false, 255, (DefaultConstructorMarker) null);
    }

    @SerialName("dlc_app_id")
    public static /* synthetic */ void getDlcAppId$annotations() {
    }

    @SerialName("dlc_icon_url")
    public static /* synthetic */ void getDlcIconUrl$annotations() {
    }

    @SerialName("dlc_name")
    public static /* synthetic */ void getDlcName$annotations() {
    }

    @SerialName("owned")
    public static /* synthetic */ void getOwned$annotations() {
    }

    @SerialName("price_yuan")
    public static /* synthetic */ void getPriceYuan$annotations() {
    }

    @SerialName("release_date")
    public static /* synthetic */ void getReleaseDate$annotations() {
    }

    @SerialName("short_description")
    public static /* synthetic */ void getShortDescription$annotations() {
    }

    @SerialName("is_free")
    public static /* synthetic */ void isFreeInt$annotations() {
    }

    public final long component1() {
        return this.dlcAppId;
    }

    public final String component2() {
        return this.dlcName;
    }

    public final String component3() {
        return this.priceYuan;
    }

    public final int component4() {
        return this.isFreeInt;
    }

    public final String component5() {
        return this.releaseDate;
    }

    public final String component6() {
        return this.dlcIconUrl;
    }

    public final String component7() {
        return this.shortDescription;
    }

    public final boolean component8() {
        return this.owned;
    }

    public final DLCDetail copy(long j2, String str, String str2, int i, String str3, String str4, String str5, boolean z) {
        Intrinsics.checkNotNullParameter(str, "dlcName");
        Intrinsics.checkNotNullParameter(str2, "priceYuan");
        Intrinsics.checkNotNullParameter(str3, "releaseDate");
        Intrinsics.checkNotNullParameter(str4, "dlcIconUrl");
        Intrinsics.checkNotNullParameter(str5, "shortDescription");
        return new DLCDetail(j2, str, str2, i, str3, str4, str5, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DLCDetail) {
            DLCDetail dLCDetail = (DLCDetail) obj;
            return this.dlcAppId == dLCDetail.dlcAppId && Intrinsics.areEqual(this.dlcName, dLCDetail.dlcName) && Intrinsics.areEqual(this.priceYuan, dLCDetail.priceYuan) && this.isFreeInt == dLCDetail.isFreeInt && Intrinsics.areEqual(this.releaseDate, dLCDetail.releaseDate) && Intrinsics.areEqual(this.dlcIconUrl, dLCDetail.dlcIconUrl) && Intrinsics.areEqual(this.shortDescription, dLCDetail.shortDescription) && this.owned == dLCDetail.owned;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.dlcAppId) * 31) + this.dlcName.hashCode()) * 31) + this.priceYuan.hashCode()) * 31) + this.isFreeInt) * 31) + this.releaseDate.hashCode()) * 31) + this.dlcIconUrl.hashCode()) * 31) + this.shortDescription.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.owned);
    }

    public String toString() {
        long j2 = this.dlcAppId;
        String str = this.dlcName;
        String str2 = this.priceYuan;
        int i = this.isFreeInt;
        String str3 = this.releaseDate;
        String str4 = this.dlcIconUrl;
        String str5 = this.shortDescription;
        return "DLCDetail(dlcAppId=" + j2 + ", dlcName=" + str + ", priceYuan=" + str2 + ", isFreeInt=" + i + ", releaseDate=" + str3 + ", dlcIconUrl=" + str4 + ", shortDescription=" + str5 + ", owned=" + this.owned + ")";
    }

    /* compiled from: SteamGameDLCBean.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/game/bean/DLCDetail$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/game/bean/DLCDetail;", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DLCDetail> serializer() {
            return DLCDetail$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ DLCDetail(int seen0, long dlcAppId, String dlcName, String priceYuan, int isFreeInt, String releaseDate, String dlcIconUrl, String shortDescription, boolean owned, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.dlcAppId = 0L;
        } else {
            this.dlcAppId = dlcAppId;
        }
        if ((seen0 & 2) == 0) {
            this.dlcName = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.dlcName = dlcName;
        }
        if ((seen0 & 4) == 0) {
            this.priceYuan = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.priceYuan = priceYuan;
        }
        if ((seen0 & 8) == 0) {
            this.isFreeInt = 0;
        } else {
            this.isFreeInt = isFreeInt;
        }
        if ((seen0 & 16) == 0) {
            this.releaseDate = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.releaseDate = releaseDate;
        }
        if ((seen0 & 32) == 0) {
            this.dlcIconUrl = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.dlcIconUrl = dlcIconUrl;
        }
        if ((seen0 & 64) == 0) {
            this.shortDescription = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.shortDescription = shortDescription;
        }
        if ((seen0 & 128) == 0) {
            this.owned = false;
        } else {
            this.owned = owned;
        }
    }

    public DLCDetail(long dlcAppId, String dlcName, String priceYuan, int isFreeInt, String releaseDate, String dlcIconUrl, String shortDescription, boolean owned) {
        Intrinsics.checkNotNullParameter(dlcName, "dlcName");
        Intrinsics.checkNotNullParameter(priceYuan, "priceYuan");
        Intrinsics.checkNotNullParameter(releaseDate, "releaseDate");
        Intrinsics.checkNotNullParameter(dlcIconUrl, "dlcIconUrl");
        Intrinsics.checkNotNullParameter(shortDescription, "shortDescription");
        this.dlcAppId = dlcAppId;
        this.dlcName = dlcName;
        this.priceYuan = priceYuan;
        this.isFreeInt = isFreeInt;
        this.releaseDate = releaseDate;
        this.dlcIconUrl = dlcIconUrl;
        this.shortDescription = shortDescription;
        this.owned = owned;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$gamebiz_debug(DLCDetail self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.dlcAppId != 0) {
            output.encodeLongElement(serialDesc, 0, self.dlcAppId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.dlcName, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 1, self.dlcName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.priceYuan, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 2, self.priceYuan);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.isFreeInt != 0) {
            output.encodeIntElement(serialDesc, 3, self.isFreeInt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.releaseDate, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 4, self.releaseDate);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.dlcIconUrl, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 5, self.dlcIconUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.shortDescription, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 6, self.shortDescription);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.owned) {
            output.encodeBooleanElement(serialDesc, 7, self.owned);
        }
    }

    public /* synthetic */ DLCDetail(long j2, String str, String str2, int i, String str3, String str4, String str5, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j2, (i2 & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i2 & 4) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str3, (i2 & 32) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str4, (i2 & 64) == 0 ? str5 : RoomRecommendViewModel.EMPTY_CURSOR, (i2 & 128) == 0 ? z : false);
    }

    public final long getDlcAppId() {
        return this.dlcAppId;
    }

    public final String getDlcName() {
        return this.dlcName;
    }

    public final String getPriceYuan() {
        return this.priceYuan;
    }

    public final int isFreeInt() {
        return this.isFreeInt;
    }

    public final String getReleaseDate() {
        return this.releaseDate;
    }

    public final String getDlcIconUrl() {
        return this.dlcIconUrl;
    }

    public final String getShortDescription() {
        return this.shortDescription;
    }

    public final boolean getOwned() {
        return this.owned;
    }

    public final boolean isFree() {
        return this.isFreeInt == 1;
    }
}