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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: TokenlinkData.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0002#$B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B-\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\tHÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J%\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0001¢\u0006\u0002\b\"R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0013¨\u0006%"}, d2 = {"Lkntr/app/game/gamebind/bean/TokenlinkData;", RoomRecommendViewModel.EMPTY_CURSOR, "bind", RoomRecommendViewModel.EMPTY_CURSOR, "bindUrl", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(ZLjava/lang/String;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBind$annotations", "()V", "getBind", "()Z", "getBindUrl$annotations", "getBindUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$game_bind_debug", "$serializer", "Companion", "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class TokenlinkData {
    public static final Companion Companion = new Companion(null);
    private final boolean bind;
    private final String bindUrl;

    public static /* synthetic */ TokenlinkData copy$default(TokenlinkData tokenlinkData, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = tokenlinkData.bind;
        }
        if ((i & 2) != 0) {
            str = tokenlinkData.bindUrl;
        }
        return tokenlinkData.copy(z, str);
    }

    @SerialName("bind")
    public static /* synthetic */ void getBind$annotations() {
    }

    @SerialName("bind_url")
    public static /* synthetic */ void getBindUrl$annotations() {
    }

    public final boolean component1() {
        return this.bind;
    }

    public final String component2() {
        return this.bindUrl;
    }

    public final TokenlinkData copy(boolean z, String str) {
        return new TokenlinkData(z, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TokenlinkData) {
            TokenlinkData tokenlinkData = (TokenlinkData) obj;
            return this.bind == tokenlinkData.bind && Intrinsics.areEqual(this.bindUrl, tokenlinkData.bindUrl);
        }
        return false;
    }

    public int hashCode() {
        return (BottomSheetItemData$.ExternalSyntheticBackport0.m(this.bind) * 31) + (this.bindUrl == null ? 0 : this.bindUrl.hashCode());
    }

    public String toString() {
        boolean z = this.bind;
        return "TokenlinkData(bind=" + z + ", bindUrl=" + this.bindUrl + ")";
    }

    /* compiled from: TokenlinkData.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/game/gamebind/bean/TokenlinkData$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/game/gamebind/bean/TokenlinkData;", "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<TokenlinkData> serializer() {
            return TokenlinkData$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ TokenlinkData(int seen0, boolean bind, String bindUrl, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (seen0 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 1, TokenlinkData$$serializer.INSTANCE.getDescriptor());
        }
        this.bind = bind;
        if ((seen0 & 2) == 0) {
            this.bindUrl = null;
        } else {
            this.bindUrl = bindUrl;
        }
    }

    public TokenlinkData(boolean bind, String bindUrl) {
        this.bind = bind;
        this.bindUrl = bindUrl;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$game_bind_debug(TokenlinkData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeBooleanElement(serialDesc, 0, self.bind);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.bindUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.bindUrl);
        }
    }

    public /* synthetic */ TokenlinkData(boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : str);
    }

    public final boolean getBind() {
        return this.bind;
    }

    public final String getBindUrl() {
        return this.bindUrl;
    }
}