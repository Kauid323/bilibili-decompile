package kntr.app.game.gamebind.bean;

import com.bilibili.biligame.kntr.common.bean.KBiligame;
import com.bilibili.biligame.kntr.common.bean.KBiligame$;
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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: UnbindRoleItem.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 J2\u00020\u0001:\u0002IJBy\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0010\u0010\u0011B\u0081\u0001\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0010\u0010\u0015J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0081\u0001\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010?\u001a\u00020\u0003HÖ\u0001J\t\u0010@\u001a\u00020\u0005HÖ\u0001J%\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u00002\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GH\u0001¢\u0006\u0002\bHR\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u001cR\u001c\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0017\u001a\u0004\b \u0010\u0019R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0017\u001a\u0004\b\"\u0010\u001cR\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0017\u001a\u0004\b$\u0010\u001cR\u001e\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0017\u001a\u0004\b&\u0010\u001cR\u001c\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0017\u001a\u0004\b(\u0010\u0019R\u001c\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u0017\u001a\u0004\b*\u0010\u0019R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u0017\u001a\u0004\b,\u0010-R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u0017\u001a\u0004\b/\u0010\u001c¨\u0006K"}, d2 = {"Lkntr/app/game/gamebind/bean/UnbindRoleItem;", RoomRecommendViewModel.EMPTY_CURSOR, "gameBaseId", RoomRecommendViewModel.EMPTY_CURSOR, "gameName", RoomRecommendViewModel.EMPTY_CURSOR, "icon", "distributorChannelId", "distributorChannelName", "backgroundColor", "backgroundImage", "bindMethodType", "authStatus", "gameInfo", "Lcom/bilibili/biligame/kntr/common/bean/KBiligame;", "roleImage", "<init>", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILcom/bilibili/biligame/kntr/common/bean/KBiligame;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILcom/bilibili/biligame/kntr/common/bean/KBiligame;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getGameBaseId$annotations", "()V", "getGameBaseId", "()I", "getGameName$annotations", "getGameName", "()Ljava/lang/String;", "getIcon$annotations", "getIcon", "getDistributorChannelId$annotations", "getDistributorChannelId", "getDistributorChannelName$annotations", "getDistributorChannelName", "getBackgroundColor$annotations", "getBackgroundColor", "getBackgroundImage$annotations", "getBackgroundImage", "getBindMethodType$annotations", "getBindMethodType", "getAuthStatus$annotations", "getAuthStatus", "getGameInfo$annotations", "getGameInfo", "()Lcom/bilibili/biligame/kntr/common/bean/KBiligame;", "getRoleImage$annotations", "getRoleImage", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$game_bind_debug", "$serializer", "Companion", "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class UnbindRoleItem {
    public static final Companion Companion = new Companion(null);
    private final int authStatus;
    private final String backgroundColor;
    private final String backgroundImage;
    private final int bindMethodType;
    private final int distributorChannelId;
    private final String distributorChannelName;
    private final int gameBaseId;
    private final KBiligame gameInfo;
    private final String gameName;
    private final String icon;
    private final String roleImage;

    @SerialName("auth_status")
    public static /* synthetic */ void getAuthStatus$annotations() {
    }

    @SerialName("background_color")
    public static /* synthetic */ void getBackgroundColor$annotations() {
    }

    @SerialName("background_image")
    public static /* synthetic */ void getBackgroundImage$annotations() {
    }

    @SerialName("bind_method_type")
    public static /* synthetic */ void getBindMethodType$annotations() {
    }

    @SerialName("distributor_channel_id")
    public static /* synthetic */ void getDistributorChannelId$annotations() {
    }

    @SerialName("distributor_channel_name")
    public static /* synthetic */ void getDistributorChannelName$annotations() {
    }

    @SerialName("game_base_id")
    public static /* synthetic */ void getGameBaseId$annotations() {
    }

    @SerialName("game_download")
    public static /* synthetic */ void getGameInfo$annotations() {
    }

    @SerialName("game_name")
    public static /* synthetic */ void getGameName$annotations() {
    }

    @SerialName("icon")
    public static /* synthetic */ void getIcon$annotations() {
    }

    @SerialName("role_image")
    public static /* synthetic */ void getRoleImage$annotations() {
    }

    public final int component1() {
        return this.gameBaseId;
    }

    public final KBiligame component10() {
        return this.gameInfo;
    }

    public final String component11() {
        return this.roleImage;
    }

    public final String component2() {
        return this.gameName;
    }

    public final String component3() {
        return this.icon;
    }

    public final int component4() {
        return this.distributorChannelId;
    }

    public final String component5() {
        return this.distributorChannelName;
    }

    public final String component6() {
        return this.backgroundColor;
    }

    public final String component7() {
        return this.backgroundImage;
    }

    public final int component8() {
        return this.bindMethodType;
    }

    public final int component9() {
        return this.authStatus;
    }

    public final UnbindRoleItem copy(int i, String str, String str2, int i2, String str3, String str4, String str5, int i3, int i4, KBiligame kBiligame, String str6) {
        Intrinsics.checkNotNullParameter(str, "gameName");
        Intrinsics.checkNotNullParameter(str2, "icon");
        return new UnbindRoleItem(i, str, str2, i2, str3, str4, str5, i3, i4, kBiligame, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UnbindRoleItem) {
            UnbindRoleItem unbindRoleItem = (UnbindRoleItem) obj;
            return this.gameBaseId == unbindRoleItem.gameBaseId && Intrinsics.areEqual(this.gameName, unbindRoleItem.gameName) && Intrinsics.areEqual(this.icon, unbindRoleItem.icon) && this.distributorChannelId == unbindRoleItem.distributorChannelId && Intrinsics.areEqual(this.distributorChannelName, unbindRoleItem.distributorChannelName) && Intrinsics.areEqual(this.backgroundColor, unbindRoleItem.backgroundColor) && Intrinsics.areEqual(this.backgroundImage, unbindRoleItem.backgroundImage) && this.bindMethodType == unbindRoleItem.bindMethodType && this.authStatus == unbindRoleItem.authStatus && Intrinsics.areEqual(this.gameInfo, unbindRoleItem.gameInfo) && Intrinsics.areEqual(this.roleImage, unbindRoleItem.roleImage);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((this.gameBaseId * 31) + this.gameName.hashCode()) * 31) + this.icon.hashCode()) * 31) + this.distributorChannelId) * 31) + (this.distributorChannelName == null ? 0 : this.distributorChannelName.hashCode())) * 31) + (this.backgroundColor == null ? 0 : this.backgroundColor.hashCode())) * 31) + (this.backgroundImage == null ? 0 : this.backgroundImage.hashCode())) * 31) + this.bindMethodType) * 31) + this.authStatus) * 31) + (this.gameInfo == null ? 0 : this.gameInfo.hashCode())) * 31) + (this.roleImage != null ? this.roleImage.hashCode() : 0);
    }

    public String toString() {
        int i = this.gameBaseId;
        String str = this.gameName;
        String str2 = this.icon;
        int i2 = this.distributorChannelId;
        String str3 = this.distributorChannelName;
        String str4 = this.backgroundColor;
        String str5 = this.backgroundImage;
        int i3 = this.bindMethodType;
        int i4 = this.authStatus;
        KBiligame kBiligame = this.gameInfo;
        return "UnbindRoleItem(gameBaseId=" + i + ", gameName=" + str + ", icon=" + str2 + ", distributorChannelId=" + i2 + ", distributorChannelName=" + str3 + ", backgroundColor=" + str4 + ", backgroundImage=" + str5 + ", bindMethodType=" + i3 + ", authStatus=" + i4 + ", gameInfo=" + kBiligame + ", roleImage=" + this.roleImage + ")";
    }

    /* compiled from: UnbindRoleItem.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/game/gamebind/bean/UnbindRoleItem$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/game/gamebind/bean/UnbindRoleItem;", "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<UnbindRoleItem> serializer() {
            return UnbindRoleItem$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ UnbindRoleItem(int seen0, int gameBaseId, String gameName, String icon, int distributorChannelId, String distributorChannelName, String backgroundColor, String backgroundImage, int bindMethodType, int authStatus, KBiligame gameInfo, String roleImage, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (seen0 & 7)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 7, UnbindRoleItem$$serializer.INSTANCE.getDescriptor());
        }
        this.gameBaseId = gameBaseId;
        this.gameName = gameName;
        this.icon = icon;
        if ((seen0 & 8) == 0) {
            this.distributorChannelId = 0;
        } else {
            this.distributorChannelId = distributorChannelId;
        }
        if ((seen0 & 16) == 0) {
            this.distributorChannelName = null;
        } else {
            this.distributorChannelName = distributorChannelName;
        }
        if ((seen0 & 32) == 0) {
            this.backgroundColor = null;
        } else {
            this.backgroundColor = backgroundColor;
        }
        if ((seen0 & 64) == 0) {
            this.backgroundImage = null;
        } else {
            this.backgroundImage = backgroundImage;
        }
        if ((seen0 & 128) == 0) {
            this.bindMethodType = 0;
        } else {
            this.bindMethodType = bindMethodType;
        }
        if ((seen0 & 256) == 0) {
            this.authStatus = 0;
        } else {
            this.authStatus = authStatus;
        }
        if ((seen0 & 512) == 0) {
            this.gameInfo = null;
        } else {
            this.gameInfo = gameInfo;
        }
        if ((seen0 & 1024) == 0) {
            this.roleImage = null;
        } else {
            this.roleImage = roleImage;
        }
    }

    public UnbindRoleItem(int gameBaseId, String gameName, String icon, int distributorChannelId, String distributorChannelName, String backgroundColor, String backgroundImage, int bindMethodType, int authStatus, KBiligame gameInfo, String roleImage) {
        Intrinsics.checkNotNullParameter(gameName, "gameName");
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.gameBaseId = gameBaseId;
        this.gameName = gameName;
        this.icon = icon;
        this.distributorChannelId = distributorChannelId;
        this.distributorChannelName = distributorChannelName;
        this.backgroundColor = backgroundColor;
        this.backgroundImage = backgroundImage;
        this.bindMethodType = bindMethodType;
        this.authStatus = authStatus;
        this.gameInfo = gameInfo;
        this.roleImage = roleImage;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$game_bind_debug(UnbindRoleItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeIntElement(serialDesc, 0, self.gameBaseId);
        output.encodeStringElement(serialDesc, 1, self.gameName);
        output.encodeStringElement(serialDesc, 2, self.icon);
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.distributorChannelId != 0) {
            output.encodeIntElement(serialDesc, 3, self.distributorChannelId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.distributorChannelName != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.distributorChannelName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.backgroundColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.backgroundColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.backgroundImage != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.backgroundImage);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.bindMethodType != 0) {
            output.encodeIntElement(serialDesc, 7, self.bindMethodType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.authStatus != 0) {
            output.encodeIntElement(serialDesc, 8, self.authStatus);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.gameInfo != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, KBiligame$.serializer.INSTANCE, self.gameInfo);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.roleImage != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.roleImage);
        }
    }

    public /* synthetic */ UnbindRoleItem(int i, String str, String str2, int i2, String str3, String str4, String str5, int i3, int i4, KBiligame kBiligame, String str6, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, str2, (i5 & 8) != 0 ? 0 : i2, (i5 & 16) != 0 ? null : str3, (i5 & 32) != 0 ? null : str4, (i5 & 64) != 0 ? null : str5, (i5 & 128) != 0 ? 0 : i3, (i5 & 256) != 0 ? 0 : i4, (i5 & 512) != 0 ? null : kBiligame, (i5 & 1024) != 0 ? null : str6);
    }

    public final int getGameBaseId() {
        return this.gameBaseId;
    }

    public final String getGameName() {
        return this.gameName;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final int getDistributorChannelId() {
        return this.distributorChannelId;
    }

    public final String getDistributorChannelName() {
        return this.distributorChannelName;
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getBackgroundImage() {
        return this.backgroundImage;
    }

    public final int getBindMethodType() {
        return this.bindMethodType;
    }

    public final int getAuthStatus() {
        return this.authStatus;
    }

    public final KBiligame getGameInfo() {
        return this.gameInfo;
    }

    public final String getRoleImage() {
        return this.roleImage;
    }
}