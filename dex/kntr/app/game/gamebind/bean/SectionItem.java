package kntr.app.game.gamebind.bean;

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
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: RoleMenuItem.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0002+,B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tBA\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J1\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u000bHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0019¨\u0006-"}, d2 = {"Lkntr/app/game/gamebind/bean/SectionItem;", RoomRecommendViewModel.EMPTY_CURSOR, "roleName", RoomRecommendViewModel.EMPTY_CURSOR, "sectionId", "sectionName", "primary", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRoleName$annotations", "()V", "getRoleName", "()Ljava/lang/String;", "getSectionId$annotations", "getSectionId", "getSectionName$annotations", "getSectionName", "getPrimary$annotations", "getPrimary", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$game_bind_debug", "$serializer", "Companion", "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class SectionItem {
    public static final Companion Companion = new Companion(null);
    private final boolean primary;
    private final String roleName;
    private final String sectionId;
    private final String sectionName;

    public SectionItem() {
        this((String) null, (String) null, (String) null, false, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SectionItem copy$default(SectionItem sectionItem, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sectionItem.roleName;
        }
        if ((i & 2) != 0) {
            str2 = sectionItem.sectionId;
        }
        if ((i & 4) != 0) {
            str3 = sectionItem.sectionName;
        }
        if ((i & 8) != 0) {
            z = sectionItem.primary;
        }
        return sectionItem.copy(str, str2, str3, z);
    }

    @SerialName("primary")
    public static /* synthetic */ void getPrimary$annotations() {
    }

    @SerialName("role_name")
    public static /* synthetic */ void getRoleName$annotations() {
    }

    @SerialName("section_id")
    public static /* synthetic */ void getSectionId$annotations() {
    }

    @SerialName("section_name")
    public static /* synthetic */ void getSectionName$annotations() {
    }

    public final String component1() {
        return this.roleName;
    }

    public final String component2() {
        return this.sectionId;
    }

    public final String component3() {
        return this.sectionName;
    }

    public final boolean component4() {
        return this.primary;
    }

    public final SectionItem copy(String str, String str2, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "roleName");
        Intrinsics.checkNotNullParameter(str2, "sectionId");
        Intrinsics.checkNotNullParameter(str3, "sectionName");
        return new SectionItem(str, str2, str3, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SectionItem) {
            SectionItem sectionItem = (SectionItem) obj;
            return Intrinsics.areEqual(this.roleName, sectionItem.roleName) && Intrinsics.areEqual(this.sectionId, sectionItem.sectionId) && Intrinsics.areEqual(this.sectionName, sectionItem.sectionName) && this.primary == sectionItem.primary;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.roleName.hashCode() * 31) + this.sectionId.hashCode()) * 31) + this.sectionName.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.primary);
    }

    public String toString() {
        String str = this.roleName;
        String str2 = this.sectionId;
        String str3 = this.sectionName;
        return "SectionItem(roleName=" + str + ", sectionId=" + str2 + ", sectionName=" + str3 + ", primary=" + this.primary + ")";
    }

    /* compiled from: RoleMenuItem.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/game/gamebind/bean/SectionItem$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/game/gamebind/bean/SectionItem;", "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<SectionItem> serializer() {
            return SectionItem$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SectionItem(int seen0, String roleName, String sectionId, String sectionName, boolean primary, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.roleName = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.roleName = roleName;
        }
        if ((seen0 & 2) == 0) {
            this.sectionId = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.sectionId = sectionId;
        }
        if ((seen0 & 4) == 0) {
            this.sectionName = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.sectionName = sectionName;
        }
        if ((seen0 & 8) == 0) {
            this.primary = false;
        } else {
            this.primary = primary;
        }
    }

    public SectionItem(String roleName, String sectionId, String sectionName, boolean primary) {
        Intrinsics.checkNotNullParameter(roleName, "roleName");
        Intrinsics.checkNotNullParameter(sectionId, "sectionId");
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        this.roleName = roleName;
        this.sectionId = sectionId;
        this.sectionName = sectionName;
        this.primary = primary;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$game_bind_debug(SectionItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.roleName, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 0, self.roleName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.sectionId, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 1, self.sectionId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.sectionName, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 2, self.sectionName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.primary) {
            output.encodeBooleanElement(serialDesc, 3, self.primary);
        }
    }

    public /* synthetic */ SectionItem(String str, String str2, String str3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2, (i & 4) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str3, (i & 8) != 0 ? false : z);
    }

    public final String getRoleName() {
        return this.roleName;
    }

    public final String getSectionId() {
        return this.sectionId;
    }

    public final String getSectionName() {
        return this.sectionName;
    }

    public final boolean getPrimary() {
        return this.primary;
    }
}