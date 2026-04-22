package kntr.app.game.gamebind.bean;

import BottomSheetItemData$;
import com.bilibili.biligame.kntr.common.bean.KBiligame;
import com.bilibili.biligame.kntr.common.bean.KBiligame$;
import com.bilibili.biligame.kntr.common.util.KtJsonKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.Json;

/* compiled from: AuthorizeParams.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ;2\u00020\u0001:\u0002;<Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011Bu\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0010\u0010\u0015J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\t\u0010*\u001a\u00020\u000bHÆ\u0003J\t\u0010+\u001a\u00020\u0007HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010-\u001a\u00020\u000bHÆ\u0003Jo\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000bHÆ\u0001J\u0013\u0010/\u001a\u00020\u000b2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\u0007HÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001J%\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00002\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0001¢\u0006\u0002\b:R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u000f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001f¨\u0006="}, d2 = {"Lkntr/app/game/gamebind/bean/AuthorizeParams;", RoomRecommendViewModel.EMPTY_CURSOR, "gameBaseId", RoomRecommendViewModel.EMPTY_CURSOR, "gameName", "icon", "distributorChannelId", RoomRecommendViewModel.EMPTY_CURSOR, "distributorChannelName", "authStatus", "onlyAuth", RoomRecommendViewModel.EMPTY_CURSOR, "bindMethodType", "gameInfo", "Lcom/bilibili/biligame/kntr/common/bean/KBiligame;", "fromRoleList", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IZILcom/bilibili/biligame/kntr/common/bean/KBiligame;Z)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IZILcom/bilibili/biligame/kntr/common/bean/KBiligame;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getGameBaseId", "()Ljava/lang/String;", "getGameName", "getIcon", "getDistributorChannelId", "()I", "getDistributorChannelName", "getAuthStatus", "getOnlyAuth", "()Z", "getBindMethodType", "getGameInfo", "()Lcom/bilibili/biligame/kntr/common/bean/KBiligame;", "getFromRoleList", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$game_bind_debug", "Companion", "$serializer", "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AuthorizeParams {
    public static final Companion Companion = new Companion(null);
    private final int authStatus;
    private final int bindMethodType;
    private final int distributorChannelId;
    private final String distributorChannelName;
    private final boolean fromRoleList;
    private final String gameBaseId;
    private final KBiligame gameInfo;
    private final String gameName;
    private final String icon;
    private final boolean onlyAuth;

    public final String component1() {
        return this.gameBaseId;
    }

    public final boolean component10() {
        return this.fromRoleList;
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

    public final int component6() {
        return this.authStatus;
    }

    public final boolean component7() {
        return this.onlyAuth;
    }

    public final int component8() {
        return this.bindMethodType;
    }

    public final KBiligame component9() {
        return this.gameInfo;
    }

    public final AuthorizeParams copy(String str, String str2, String str3, int i, String str4, int i2, boolean z, int i3, KBiligame kBiligame, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "gameBaseId");
        Intrinsics.checkNotNullParameter(str2, "gameName");
        Intrinsics.checkNotNullParameter(str3, "icon");
        Intrinsics.checkNotNullParameter(str4, "distributorChannelName");
        return new AuthorizeParams(str, str2, str3, i, str4, i2, z, i3, kBiligame, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AuthorizeParams) {
            AuthorizeParams authorizeParams = (AuthorizeParams) obj;
            return Intrinsics.areEqual(this.gameBaseId, authorizeParams.gameBaseId) && Intrinsics.areEqual(this.gameName, authorizeParams.gameName) && Intrinsics.areEqual(this.icon, authorizeParams.icon) && this.distributorChannelId == authorizeParams.distributorChannelId && Intrinsics.areEqual(this.distributorChannelName, authorizeParams.distributorChannelName) && this.authStatus == authorizeParams.authStatus && this.onlyAuth == authorizeParams.onlyAuth && this.bindMethodType == authorizeParams.bindMethodType && Intrinsics.areEqual(this.gameInfo, authorizeParams.gameInfo) && this.fromRoleList == authorizeParams.fromRoleList;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((this.gameBaseId.hashCode() * 31) + this.gameName.hashCode()) * 31) + this.icon.hashCode()) * 31) + this.distributorChannelId) * 31) + this.distributorChannelName.hashCode()) * 31) + this.authStatus) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.onlyAuth)) * 31) + this.bindMethodType) * 31) + (this.gameInfo == null ? 0 : this.gameInfo.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.fromRoleList);
    }

    public String toString() {
        String str = this.gameBaseId;
        String str2 = this.gameName;
        String str3 = this.icon;
        int i = this.distributorChannelId;
        String str4 = this.distributorChannelName;
        int i2 = this.authStatus;
        boolean z = this.onlyAuth;
        int i3 = this.bindMethodType;
        KBiligame kBiligame = this.gameInfo;
        return "AuthorizeParams(gameBaseId=" + str + ", gameName=" + str2 + ", icon=" + str3 + ", distributorChannelId=" + i + ", distributorChannelName=" + str4 + ", authStatus=" + i2 + ", onlyAuth=" + z + ", bindMethodType=" + i3 + ", gameInfo=" + kBiligame + ", fromRoleList=" + this.fromRoleList + ")";
    }

    public /* synthetic */ AuthorizeParams(int seen0, String gameBaseId, String gameName, String icon, int distributorChannelId, String distributorChannelName, int authStatus, boolean onlyAuth, int bindMethodType, KBiligame gameInfo, boolean fromRoleList, SerializationConstructorMarker serializationConstructorMarker) {
        if (63 != (seen0 & 63)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 63, AuthorizeParams$$serializer.INSTANCE.getDescriptor());
        }
        this.gameBaseId = gameBaseId;
        this.gameName = gameName;
        this.icon = icon;
        this.distributorChannelId = distributorChannelId;
        this.distributorChannelName = distributorChannelName;
        this.authStatus = authStatus;
        if ((seen0 & 64) == 0) {
            this.onlyAuth = false;
        } else {
            this.onlyAuth = onlyAuth;
        }
        if ((seen0 & 128) == 0) {
            this.bindMethodType = 0;
        } else {
            this.bindMethodType = bindMethodType;
        }
        if ((seen0 & 256) == 0) {
            this.gameInfo = null;
        } else {
            this.gameInfo = gameInfo;
        }
        if ((seen0 & 512) == 0) {
            this.fromRoleList = true;
        } else {
            this.fromRoleList = fromRoleList;
        }
    }

    public AuthorizeParams(String gameBaseId, String gameName, String icon, int distributorChannelId, String distributorChannelName, int authStatus, boolean onlyAuth, int bindMethodType, KBiligame gameInfo, boolean fromRoleList) {
        Intrinsics.checkNotNullParameter(gameBaseId, "gameBaseId");
        Intrinsics.checkNotNullParameter(gameName, "gameName");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(distributorChannelName, "distributorChannelName");
        this.gameBaseId = gameBaseId;
        this.gameName = gameName;
        this.icon = icon;
        this.distributorChannelId = distributorChannelId;
        this.distributorChannelName = distributorChannelName;
        this.authStatus = authStatus;
        this.onlyAuth = onlyAuth;
        this.bindMethodType = bindMethodType;
        this.gameInfo = gameInfo;
        this.fromRoleList = fromRoleList;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$game_bind_debug(AuthorizeParams self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.gameBaseId);
        output.encodeStringElement(serialDesc, 1, self.gameName);
        output.encodeStringElement(serialDesc, 2, self.icon);
        output.encodeIntElement(serialDesc, 3, self.distributorChannelId);
        output.encodeStringElement(serialDesc, 4, self.distributorChannelName);
        output.encodeIntElement(serialDesc, 5, self.authStatus);
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.onlyAuth) {
            output.encodeBooleanElement(serialDesc, 6, self.onlyAuth);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.bindMethodType != 0) {
            output.encodeIntElement(serialDesc, 7, self.bindMethodType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.gameInfo != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, KBiligame$.serializer.INSTANCE, self.gameInfo);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || !self.fromRoleList) {
            output.encodeBooleanElement(serialDesc, 9, self.fromRoleList);
        }
    }

    public /* synthetic */ AuthorizeParams(String str, String str2, String str3, int i, String str4, int i2, boolean z, int i3, KBiligame kBiligame, boolean z2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, i, str4, i2, (i4 & 64) != 0 ? false : z, (i4 & 128) != 0 ? 0 : i3, (i4 & 256) != 0 ? null : kBiligame, (i4 & 512) != 0 ? true : z2);
    }

    public final String getGameBaseId() {
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

    public final int getAuthStatus() {
        return this.authStatus;
    }

    public final boolean getOnlyAuth() {
        return this.onlyAuth;
    }

    public final int getBindMethodType() {
        return this.bindMethodType;
    }

    public final KBiligame getGameInfo() {
        return this.gameInfo;
    }

    public final boolean getFromRoleList() {
        return this.fromRoleList;
    }

    /* compiled from: AuthorizeParams.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Lkntr/app/game/gamebind/bean/AuthorizeParams$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "decodeFromString", "Lkntr/app/game/gamebind/bean/AuthorizeParams;", "string", RoomRecommendViewModel.EMPTY_CURSOR, "serializer", "Lkotlinx/serialization/KSerializer;", "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AuthorizeParams> serializer() {
            return AuthorizeParams$$serializer.INSTANCE;
        }

        public final AuthorizeParams decodeFromString(String string) {
            try {
                Json this_$iv = KtJsonKt.getKtJson();
                String string$iv = string == null ? RoomRecommendViewModel.EMPTY_CURSOR : string;
                this_$iv.getSerializersModule();
                return (AuthorizeParams) this_$iv.decodeFromString(BuiltinSerializersKt.getNullable(AuthorizeParams.Companion.serializer()), string$iv);
            } catch (Throwable th) {
                return null;
            }
        }
    }
}