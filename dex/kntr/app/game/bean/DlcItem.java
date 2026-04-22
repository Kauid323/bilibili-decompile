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

/* compiled from: SteamGameBean.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ;2\u00020\u0001:\u0002:;BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eB[\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0012J\u0006\u0010%\u001a\u00020\u0005J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\nHÆ\u0003J\t\u0010,\u001a\u00020\fHÆ\u0003JO\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010.\u001a\u00020\f2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\nHÖ\u0001J\t\u00101\u001a\u00020\u0005HÖ\u0001J%\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00002\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0001¢\u0006\u0002\b9R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0019R\u001c\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u0019R\u001c\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0019R\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0014\u001a\u0004\b\t\u0010!R\u001c\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0014\u001a\u0004\b#\u0010$¨\u0006<"}, d2 = {"Lkntr/app/game/bean/DlcItem;", RoomRecommendViewModel.EMPTY_CURSOR, "dlcAppId", RoomRecommendViewModel.EMPTY_CURSOR, "dlcName", RoomRecommendViewModel.EMPTY_CURSOR, "iconUrl", "releaseDate", "priceYuan", "isFree", RoomRecommendViewModel.EMPTY_CURSOR, "owned", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDlcAppId$annotations", "()V", "getDlcAppId", "()J", "getDlcName$annotations", "getDlcName", "()Ljava/lang/String;", "getIconUrl$annotations", "getIconUrl", "getReleaseDate$annotations", "getReleaseDate", "getPriceYuan$annotations", "getPriceYuan", "isFree$annotations", "()I", "getOwned$annotations", "getOwned", "()Z", "getPriceDisplay", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$gamebiz_debug", "$serializer", "Companion", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class DlcItem {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final long dlcAppId;
    private final String dlcName;
    private final String iconUrl;
    private final int isFree;
    private final boolean owned;
    private final String priceYuan;
    private final String releaseDate;

    public DlcItem() {
        this(0L, (String) null, (String) null, (String) null, (String) null, 0, false, 127, (DefaultConstructorMarker) null);
    }

    @SerialName("dlc_app_id")
    public static /* synthetic */ void getDlcAppId$annotations() {
    }

    @SerialName("dlc_name")
    public static /* synthetic */ void getDlcName$annotations() {
    }

    @SerialName("icon_url")
    public static /* synthetic */ void getIconUrl$annotations() {
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

    @SerialName("is_free")
    public static /* synthetic */ void isFree$annotations() {
    }

    public final long component1() {
        return this.dlcAppId;
    }

    public final String component2() {
        return this.dlcName;
    }

    public final String component3() {
        return this.iconUrl;
    }

    public final String component4() {
        return this.releaseDate;
    }

    public final String component5() {
        return this.priceYuan;
    }

    public final int component6() {
        return this.isFree;
    }

    public final boolean component7() {
        return this.owned;
    }

    public final DlcItem copy(long j2, String str, String str2, String str3, String str4, int i, boolean z) {
        Intrinsics.checkNotNullParameter(str, "dlcName");
        Intrinsics.checkNotNullParameter(str2, "iconUrl");
        Intrinsics.checkNotNullParameter(str3, "releaseDate");
        Intrinsics.checkNotNullParameter(str4, "priceYuan");
        return new DlcItem(j2, str, str2, str3, str4, i, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DlcItem) {
            DlcItem dlcItem = (DlcItem) obj;
            return this.dlcAppId == dlcItem.dlcAppId && Intrinsics.areEqual(this.dlcName, dlcItem.dlcName) && Intrinsics.areEqual(this.iconUrl, dlcItem.iconUrl) && Intrinsics.areEqual(this.releaseDate, dlcItem.releaseDate) && Intrinsics.areEqual(this.priceYuan, dlcItem.priceYuan) && this.isFree == dlcItem.isFree && this.owned == dlcItem.owned;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.dlcAppId) * 31) + this.dlcName.hashCode()) * 31) + this.iconUrl.hashCode()) * 31) + this.releaseDate.hashCode()) * 31) + this.priceYuan.hashCode()) * 31) + this.isFree) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.owned);
    }

    public String toString() {
        long j2 = this.dlcAppId;
        String str = this.dlcName;
        String str2 = this.iconUrl;
        String str3 = this.releaseDate;
        String str4 = this.priceYuan;
        int i = this.isFree;
        return "DlcItem(dlcAppId=" + j2 + ", dlcName=" + str + ", iconUrl=" + str2 + ", releaseDate=" + str3 + ", priceYuan=" + str4 + ", isFree=" + i + ", owned=" + this.owned + ")";
    }

    /* compiled from: SteamGameBean.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/game/bean/DlcItem$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/game/bean/DlcItem;", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DlcItem> serializer() {
            return DlcItem$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ DlcItem(int seen0, long dlcAppId, String dlcName, String iconUrl, String releaseDate, String priceYuan, int isFree, boolean owned, SerializationConstructorMarker serializationConstructorMarker) {
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
            this.iconUrl = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.iconUrl = iconUrl;
        }
        if ((seen0 & 8) == 0) {
            this.releaseDate = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.releaseDate = releaseDate;
        }
        if ((seen0 & 16) == 0) {
            this.priceYuan = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.priceYuan = priceYuan;
        }
        if ((seen0 & 32) == 0) {
            this.isFree = 0;
        } else {
            this.isFree = isFree;
        }
        if ((seen0 & 64) == 0) {
            this.owned = false;
        } else {
            this.owned = owned;
        }
    }

    public DlcItem(long dlcAppId, String dlcName, String iconUrl, String releaseDate, String priceYuan, int isFree, boolean owned) {
        Intrinsics.checkNotNullParameter(dlcName, "dlcName");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(releaseDate, "releaseDate");
        Intrinsics.checkNotNullParameter(priceYuan, "priceYuan");
        this.dlcAppId = dlcAppId;
        this.dlcName = dlcName;
        this.iconUrl = iconUrl;
        this.releaseDate = releaseDate;
        this.priceYuan = priceYuan;
        this.isFree = isFree;
        this.owned = owned;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$gamebiz_debug(DlcItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.dlcAppId != 0) {
            output.encodeLongElement(serialDesc, 0, self.dlcAppId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.dlcName, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 1, self.dlcName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.iconUrl, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 2, self.iconUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.releaseDate, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 3, self.releaseDate);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.priceYuan, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 4, self.priceYuan);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.isFree != 0) {
            output.encodeIntElement(serialDesc, 5, self.isFree);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.owned) {
            output.encodeBooleanElement(serialDesc, 6, self.owned);
        }
    }

    public /* synthetic */ DlcItem(long j2, String str, String str2, String str3, String str4, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j2, (i2 & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i2 & 4) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2, (i2 & 8) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str3, (i2 & 16) == 0 ? str4 : RoomRecommendViewModel.EMPTY_CURSOR, (i2 & 32) != 0 ? 0 : i, (i2 & 64) == 0 ? z : false);
    }

    public final long getDlcAppId() {
        return this.dlcAppId;
    }

    public final String getDlcName() {
        return this.dlcName;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getReleaseDate() {
        return this.releaseDate;
    }

    public final String getPriceYuan() {
        return this.priceYuan;
    }

    public final int isFree() {
        return this.isFree;
    }

    public final boolean getOwned() {
        return this.owned;
    }

    public final String getPriceDisplay() {
        if (this.isFree == 1) {
            return "免费";
        }
        return "¥" + this.priceYuan;
    }
}