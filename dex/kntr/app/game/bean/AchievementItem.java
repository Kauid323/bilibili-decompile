package kntr.app.game.bean;

import BottomSheetItemData$;
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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: SteamGameBean.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ?2\u00020\u0001:\u0002>?B[\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eBg\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\r\u0010\u0013J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0007HÆ\u0003J\t\u0010,\u001a\u00020\u0007HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jb\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00101J\u0013\u00102\u001a\u00020\u00072\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\u0010HÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001J%\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0001¢\u0006\u0002\b=R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0015\u001a\u0004\b\b\u0010\u001eR\u001c\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0015\u001a\u0004\b!\u0010\u0017R \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010%\u0012\u0004\b\"\u0010\u0015\u001a\u0004\b#\u0010$R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0015\u001a\u0004\b'\u0010\u0017¨\u0006@"}, d2 = {"Lkntr/app/game/bean/AchievementItem;", RoomRecommendViewModel.EMPTY_CURSOR, "apiname", RoomRecommendViewModel.EMPTY_CURSOR, "name", "iconUrl", "achieved", RoomRecommendViewModel.EMPTY_CURSOR, "isRare", "achievePercentFormatted", "unlockTime", RoomRecommendViewModel.EMPTY_CURSOR, "unlockTimeFormatted", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getApiname$annotations", "()V", "getApiname", "()Ljava/lang/String;", "getName$annotations", "getName", "getIconUrl$annotations", "getIconUrl", "getAchieved$annotations", "getAchieved", "()Z", "isRare$annotations", "getAchievePercentFormatted$annotations", "getAchievePercentFormatted", "getUnlockTime$annotations", "getUnlockTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getUnlockTimeFormatted$annotations", "getUnlockTimeFormatted", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lkntr/app/game/bean/AchievementItem;", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$gamebiz_debug", "$serializer", "Companion", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AchievementItem {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String achievePercentFormatted;
    private final boolean achieved;
    private final String apiname;
    private final String iconUrl;
    private final boolean isRare;
    private final String name;
    private final Long unlockTime;
    private final String unlockTimeFormatted;

    public AchievementItem() {
        this((String) null, (String) null, (String) null, false, false, (String) null, (Long) null, (String) null, 255, (DefaultConstructorMarker) null);
    }

    @SerialName("achieve_percent_formatted")
    public static /* synthetic */ void getAchievePercentFormatted$annotations() {
    }

    @SerialName("achieved")
    public static /* synthetic */ void getAchieved$annotations() {
    }

    @SerialName("apiname")
    public static /* synthetic */ void getApiname$annotations() {
    }

    @SerialName("icon_url")
    public static /* synthetic */ void getIconUrl$annotations() {
    }

    @SerialName("name")
    public static /* synthetic */ void getName$annotations() {
    }

    @SerialName("unlock_time")
    public static /* synthetic */ void getUnlockTime$annotations() {
    }

    @SerialName("unlock_time_formatted")
    public static /* synthetic */ void getUnlockTimeFormatted$annotations() {
    }

    @SerialName("is_rare")
    public static /* synthetic */ void isRare$annotations() {
    }

    public final String component1() {
        return this.apiname;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.iconUrl;
    }

    public final boolean component4() {
        return this.achieved;
    }

    public final boolean component5() {
        return this.isRare;
    }

    public final String component6() {
        return this.achievePercentFormatted;
    }

    public final Long component7() {
        return this.unlockTime;
    }

    public final String component8() {
        return this.unlockTimeFormatted;
    }

    public final AchievementItem copy(String str, String str2, String str3, boolean z, boolean z2, String str4, Long l, String str5) {
        Intrinsics.checkNotNullParameter(str, "apiname");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "iconUrl");
        Intrinsics.checkNotNullParameter(str4, "achievePercentFormatted");
        return new AchievementItem(str, str2, str3, z, z2, str4, l, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AchievementItem) {
            AchievementItem achievementItem = (AchievementItem) obj;
            return Intrinsics.areEqual(this.apiname, achievementItem.apiname) && Intrinsics.areEqual(this.name, achievementItem.name) && Intrinsics.areEqual(this.iconUrl, achievementItem.iconUrl) && this.achieved == achievementItem.achieved && this.isRare == achievementItem.isRare && Intrinsics.areEqual(this.achievePercentFormatted, achievementItem.achievePercentFormatted) && Intrinsics.areEqual(this.unlockTime, achievementItem.unlockTime) && Intrinsics.areEqual(this.unlockTimeFormatted, achievementItem.unlockTimeFormatted);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((this.apiname.hashCode() * 31) + this.name.hashCode()) * 31) + this.iconUrl.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.achieved)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isRare)) * 31) + this.achievePercentFormatted.hashCode()) * 31) + (this.unlockTime == null ? 0 : this.unlockTime.hashCode())) * 31) + (this.unlockTimeFormatted != null ? this.unlockTimeFormatted.hashCode() : 0);
    }

    public String toString() {
        String str = this.apiname;
        String str2 = this.name;
        String str3 = this.iconUrl;
        boolean z = this.achieved;
        boolean z2 = this.isRare;
        String str4 = this.achievePercentFormatted;
        Long l = this.unlockTime;
        return "AchievementItem(apiname=" + str + ", name=" + str2 + ", iconUrl=" + str3 + ", achieved=" + z + ", isRare=" + z2 + ", achievePercentFormatted=" + str4 + ", unlockTime=" + l + ", unlockTimeFormatted=" + this.unlockTimeFormatted + ")";
    }

    /* compiled from: SteamGameBean.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/game/bean/AchievementItem$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/game/bean/AchievementItem;", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AchievementItem> serializer() {
            return AchievementItem$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AchievementItem(int seen0, String apiname, String name, String iconUrl, boolean achieved, boolean isRare, String achievePercentFormatted, Long unlockTime, String unlockTimeFormatted, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.apiname = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.apiname = apiname;
        }
        if ((seen0 & 2) == 0) {
            this.name = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.name = name;
        }
        if ((seen0 & 4) == 0) {
            this.iconUrl = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.iconUrl = iconUrl;
        }
        if ((seen0 & 8) == 0) {
            this.achieved = false;
        } else {
            this.achieved = achieved;
        }
        if ((seen0 & 16) == 0) {
            this.isRare = false;
        } else {
            this.isRare = isRare;
        }
        if ((seen0 & 32) == 0) {
            this.achievePercentFormatted = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.achievePercentFormatted = achievePercentFormatted;
        }
        if ((seen0 & 64) == 0) {
            this.unlockTime = null;
        } else {
            this.unlockTime = unlockTime;
        }
        if ((seen0 & 128) == 0) {
            this.unlockTimeFormatted = null;
        } else {
            this.unlockTimeFormatted = unlockTimeFormatted;
        }
    }

    public AchievementItem(String apiname, String name, String iconUrl, boolean achieved, boolean isRare, String achievePercentFormatted, Long unlockTime, String unlockTimeFormatted) {
        Intrinsics.checkNotNullParameter(apiname, "apiname");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(achievePercentFormatted, "achievePercentFormatted");
        this.apiname = apiname;
        this.name = name;
        this.iconUrl = iconUrl;
        this.achieved = achieved;
        this.isRare = isRare;
        this.achievePercentFormatted = achievePercentFormatted;
        this.unlockTime = unlockTime;
        this.unlockTimeFormatted = unlockTimeFormatted;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$gamebiz_debug(AchievementItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.apiname, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 0, self.apiname);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.name, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 1, self.name);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.iconUrl, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 2, self.iconUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.achieved) {
            output.encodeBooleanElement(serialDesc, 3, self.achieved);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.isRare) {
            output.encodeBooleanElement(serialDesc, 4, self.isRare);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.achievePercentFormatted, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 5, self.achievePercentFormatted);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.unlockTime != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, LongSerializer.INSTANCE, self.unlockTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.unlockTimeFormatted != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.unlockTimeFormatted);
        }
    }

    public /* synthetic */ AchievementItem(String str, String str2, String str3, boolean z, boolean z2, String str4, Long l, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2, (i & 4) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str3, (i & 8) != 0 ? false : z, (i & 16) == 0 ? z2 : false, (i & 32) == 0 ? str4 : RoomRecommendViewModel.EMPTY_CURSOR, (i & 64) != 0 ? null : l, (i & 128) == 0 ? str5 : null);
    }

    public final String getApiname() {
        return this.apiname;
    }

    public final String getName() {
        return this.name;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final boolean getAchieved() {
        return this.achieved;
    }

    public final boolean isRare() {
        return this.isRare;
    }

    public final String getAchievePercentFormatted() {
        return this.achievePercentFormatted;
    }

    public final Long getUnlockTime() {
        return this.unlockTime;
    }

    public final String getUnlockTimeFormatted() {
        return this.unlockTimeFormatted;
    }
}