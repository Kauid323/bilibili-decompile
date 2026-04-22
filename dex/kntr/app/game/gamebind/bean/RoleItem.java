package kntr.app.game.gamebind.bean;

import com.bilibili.biligame.kntr.common.util.KtJsonKt;
import java.util.List;
import java.util.Map;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;

/* compiled from: RoleItem.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b<\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 f2\u00020\u0001:\u0002fgBÉ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0017\u0010\u0018B×\u0001\b\u0010\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u0017\u0010\u001eJ\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0005HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\u0011\u0010N\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0005HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0005HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010V\u001a\u00020\u0005HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003JË\u0001\u0010X\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010Y\u001a\u00020Z2\b\u0010[\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\\\u001a\u00020\u0005HÖ\u0001J\t\u0010]\u001a\u00020\u0003HÖ\u0001J%\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020\u00002\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020dH\u0001¢\u0006\u0002\beR\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010 \u001a\u0004\b$\u0010%R\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010 \u001a\u0004\b'\u0010\"R\u001c\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010 \u001a\u0004\b)\u0010\"R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010 \u001a\u0004\b+\u0010\"R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010 \u001a\u0004\b-\u0010\"R\u001c\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010 \u001a\u0004\b/\u0010%R$\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010 \u001a\u0004\b1\u00102R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010 \u001a\u0004\b4\u0010\"R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b5\u0010 \u001a\u0004\b6\u0010\"R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010 \u001a\u0004\b8\u0010\"R\u001c\u0010\u0011\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b9\u0010 \u001a\u0004\b:\u0010%R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b;\u0010 \u001a\u0004\b<\u0010\"R\u001c\u0010\u0013\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b=\u0010 \u001a\u0004\b>\u0010%R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b?\u0010 \u001a\u0004\b@\u0010\"R\u001c\u0010\u0015\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bA\u0010 \u001a\u0004\bB\u0010%R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bC\u0010 \u001a\u0004\bD\u0010\"R\u001d\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001b¢\u0006\b\n\u0000\u001a\u0004\bE\u0010F¨\u0006h"}, d2 = {"Lkntr/app/game/gamebind/bean/RoleItem;", RoomRecommendViewModel.EMPTY_CURSOR, ReportBuildInParam.ID, RoomRecommendViewModel.EMPTY_CURSOR, "gameBaseId", RoomRecommendViewModel.EMPTY_CURSOR, "gameIcon", "gameName", "roleName", "sectionName", "visible", "roleInfos", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/game/gamebind/bean/RoleInfo;", "backgroundColor", "backgroundImage", "roleImage", "authStatus", "distributorChannelName", "distributorChannelId", "detailUrl", "bindMethodType", "commentDisplayGameName", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;ILjava/lang/String;)V", "seen0", "reportParams", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()Ljava/lang/String;", "getGameBaseId$annotations", "getGameBaseId", "()I", "getGameIcon$annotations", "getGameIcon", "getGameName$annotations", "getGameName", "getRoleName$annotations", "getRoleName", "getSectionName$annotations", "getSectionName", "getVisible$annotations", "getVisible", "getRoleInfos$annotations", "getRoleInfos", "()Ljava/util/List;", "getBackgroundColor$annotations", "getBackgroundColor", "getBackgroundImage$annotations", "getBackgroundImage", "getRoleImage$annotations", "getRoleImage", "getAuthStatus$annotations", "getAuthStatus", "getDistributorChannelName$annotations", "getDistributorChannelName", "getDistributorChannelId$annotations", "getDistributorChannelId", "getDetailUrl$annotations", "getDetailUrl", "getBindMethodType$annotations", "getBindMethodType", "getCommentDisplayGameName$annotations", "getCommentDisplayGameName", "getReportParams", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$game_bind_debug", "Companion", "$serializer", "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class RoleItem {
    private final int authStatus;
    private final String backgroundColor;
    private final String backgroundImage;
    private final int bindMethodType;
    private final String commentDisplayGameName;
    private final String detailUrl;
    private final int distributorChannelId;
    private final String distributorChannelName;
    private final int gameBaseId;
    private final String gameIcon;
    private final String gameName;
    private final String id;
    private final Map<String, String> reportParams;
    private final String roleImage;
    private final List<RoleInfo> roleInfos;
    private final String roleName;
    private final String sectionName;
    private final int visible;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.game.gamebind.bean.RoleItem$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = RoleItem._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.game.gamebind.bean.RoleItem$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = RoleItem._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    })};

    public RoleItem() {
        this(null, 0, null, null, null, null, 0, null, null, null, null, 0, null, 0, null, 0, null, 131071, null);
    }

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

    @SerialName("comment_display_game_name")
    public static /* synthetic */ void getCommentDisplayGameName$annotations() {
    }

    @SerialName("detail_url")
    public static /* synthetic */ void getDetailUrl$annotations() {
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

    @SerialName("icon")
    public static /* synthetic */ void getGameIcon$annotations() {
    }

    @SerialName("game_name")
    public static /* synthetic */ void getGameName$annotations() {
    }

    @SerialName("role_bind_id")
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName("role_image")
    public static /* synthetic */ void getRoleImage$annotations() {
    }

    @SerialName("role_attributes")
    public static /* synthetic */ void getRoleInfos$annotations() {
    }

    @SerialName("role_name")
    public static /* synthetic */ void getRoleName$annotations() {
    }

    @SerialName("section_name")
    public static /* synthetic */ void getSectionName$annotations() {
    }

    @SerialName("visible_status")
    public static /* synthetic */ void getVisible$annotations() {
    }

    public final String component1() {
        return this.id;
    }

    public final String component10() {
        return this.backgroundImage;
    }

    public final String component11() {
        return this.roleImage;
    }

    public final int component12() {
        return this.authStatus;
    }

    public final String component13() {
        return this.distributorChannelName;
    }

    public final int component14() {
        return this.distributorChannelId;
    }

    public final String component15() {
        return this.detailUrl;
    }

    public final int component16() {
        return this.bindMethodType;
    }

    public final String component17() {
        return this.commentDisplayGameName;
    }

    public final int component2() {
        return this.gameBaseId;
    }

    public final String component3() {
        return this.gameIcon;
    }

    public final String component4() {
        return this.gameName;
    }

    public final String component5() {
        return this.roleName;
    }

    public final String component6() {
        return this.sectionName;
    }

    public final int component7() {
        return this.visible;
    }

    public final List<RoleInfo> component8() {
        return this.roleInfos;
    }

    public final String component9() {
        return this.backgroundColor;
    }

    public final RoleItem copy(String str, int i, String str2, String str3, String str4, String str5, int i2, List<RoleInfo> list, String str6, String str7, String str8, int i3, String str9, int i4, String str10, int i5, String str11) {
        Intrinsics.checkNotNullParameter(str, ReportBuildInParam.ID);
        Intrinsics.checkNotNullParameter(str2, "gameIcon");
        Intrinsics.checkNotNullParameter(str3, "gameName");
        return new RoleItem(str, i, str2, str3, str4, str5, i2, list, str6, str7, str8, i3, str9, i4, str10, i5, str11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RoleItem) {
            RoleItem roleItem = (RoleItem) obj;
            return Intrinsics.areEqual(this.id, roleItem.id) && this.gameBaseId == roleItem.gameBaseId && Intrinsics.areEqual(this.gameIcon, roleItem.gameIcon) && Intrinsics.areEqual(this.gameName, roleItem.gameName) && Intrinsics.areEqual(this.roleName, roleItem.roleName) && Intrinsics.areEqual(this.sectionName, roleItem.sectionName) && this.visible == roleItem.visible && Intrinsics.areEqual(this.roleInfos, roleItem.roleInfos) && Intrinsics.areEqual(this.backgroundColor, roleItem.backgroundColor) && Intrinsics.areEqual(this.backgroundImage, roleItem.backgroundImage) && Intrinsics.areEqual(this.roleImage, roleItem.roleImage) && this.authStatus == roleItem.authStatus && Intrinsics.areEqual(this.distributorChannelName, roleItem.distributorChannelName) && this.distributorChannelId == roleItem.distributorChannelId && Intrinsics.areEqual(this.detailUrl, roleItem.detailUrl) && this.bindMethodType == roleItem.bindMethodType && Intrinsics.areEqual(this.commentDisplayGameName, roleItem.commentDisplayGameName);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((this.id.hashCode() * 31) + this.gameBaseId) * 31) + this.gameIcon.hashCode()) * 31) + this.gameName.hashCode()) * 31) + (this.roleName == null ? 0 : this.roleName.hashCode())) * 31) + (this.sectionName == null ? 0 : this.sectionName.hashCode())) * 31) + this.visible) * 31) + (this.roleInfos == null ? 0 : this.roleInfos.hashCode())) * 31) + (this.backgroundColor == null ? 0 : this.backgroundColor.hashCode())) * 31) + (this.backgroundImage == null ? 0 : this.backgroundImage.hashCode())) * 31) + (this.roleImage == null ? 0 : this.roleImage.hashCode())) * 31) + this.authStatus) * 31) + (this.distributorChannelName == null ? 0 : this.distributorChannelName.hashCode())) * 31) + this.distributorChannelId) * 31) + (this.detailUrl == null ? 0 : this.detailUrl.hashCode())) * 31) + this.bindMethodType) * 31) + (this.commentDisplayGameName != null ? this.commentDisplayGameName.hashCode() : 0);
    }

    public String toString() {
        String str = this.id;
        int i = this.gameBaseId;
        String str2 = this.gameIcon;
        String str3 = this.gameName;
        String str4 = this.roleName;
        String str5 = this.sectionName;
        int i2 = this.visible;
        List<RoleInfo> list = this.roleInfos;
        String str6 = this.backgroundColor;
        String str7 = this.backgroundImage;
        String str8 = this.roleImage;
        int i3 = this.authStatus;
        String str9 = this.distributorChannelName;
        int i4 = this.distributorChannelId;
        String str10 = this.detailUrl;
        int i5 = this.bindMethodType;
        return "RoleItem(id=" + str + ", gameBaseId=" + i + ", gameIcon=" + str2 + ", gameName=" + str3 + ", roleName=" + str4 + ", sectionName=" + str5 + ", visible=" + i2 + ", roleInfos=" + list + ", backgroundColor=" + str6 + ", backgroundImage=" + str7 + ", roleImage=" + str8 + ", authStatus=" + i3 + ", distributorChannelName=" + str9 + ", distributorChannelId=" + i4 + ", detailUrl=" + str10 + ", bindMethodType=" + i5 + ", commentDisplayGameName=" + this.commentDisplayGameName + ")";
    }

    public /* synthetic */ RoleItem(int seen0, String id, int gameBaseId, String gameIcon, String gameName, String roleName, String sectionName, int visible, List roleInfos, String backgroundColor, String backgroundImage, String roleImage, int authStatus, String distributorChannelName, int distributorChannelId, String detailUrl, int bindMethodType, String commentDisplayGameName, Map reportParams, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.id = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.id = id;
        }
        if ((seen0 & 2) == 0) {
            this.gameBaseId = 0;
        } else {
            this.gameBaseId = gameBaseId;
        }
        if ((seen0 & 4) == 0) {
            this.gameIcon = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.gameIcon = gameIcon;
        }
        if ((seen0 & 8) == 0) {
            this.gameName = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.gameName = gameName;
        }
        if ((seen0 & 16) == 0) {
            this.roleName = null;
        } else {
            this.roleName = roleName;
        }
        if ((seen0 & 32) == 0) {
            this.sectionName = null;
        } else {
            this.sectionName = sectionName;
        }
        if ((seen0 & 64) == 0) {
            this.visible = 1;
        } else {
            this.visible = visible;
        }
        if ((seen0 & 128) == 0) {
            this.roleInfos = null;
        } else {
            this.roleInfos = roleInfos;
        }
        if ((seen0 & 256) == 0) {
            this.backgroundColor = null;
        } else {
            this.backgroundColor = backgroundColor;
        }
        if ((seen0 & 512) == 0) {
            this.backgroundImage = null;
        } else {
            this.backgroundImage = backgroundImage;
        }
        if ((seen0 & 1024) == 0) {
            this.roleImage = null;
        } else {
            this.roleImage = roleImage;
        }
        if ((seen0 & 2048) == 0) {
            this.authStatus = 0;
        } else {
            this.authStatus = authStatus;
        }
        if ((seen0 & 4096) == 0) {
            this.distributorChannelName = null;
        } else {
            this.distributorChannelName = distributorChannelName;
        }
        if ((seen0 & 8192) == 0) {
            this.distributorChannelId = 0;
        } else {
            this.distributorChannelId = distributorChannelId;
        }
        if ((seen0 & 16384) == 0) {
            this.detailUrl = null;
        } else {
            this.detailUrl = detailUrl;
        }
        if ((seen0 & 32768) == 0) {
            this.bindMethodType = 0;
        } else {
            this.bindMethodType = bindMethodType;
        }
        if ((seen0 & 65536) == 0) {
            this.commentDisplayGameName = null;
        } else {
            this.commentDisplayGameName = commentDisplayGameName;
        }
        if ((seen0 & 131072) == 0) {
            this.reportParams = MapsKt.mapOf(new Pair[]{TuplesKt.to("game_base_id", String.valueOf(this.gameBaseId)), TuplesKt.to("game_name", this.gameName), TuplesKt.to("role_bind_id", this.id)});
        } else {
            this.reportParams = reportParams;
        }
    }

    public RoleItem(String id, int gameBaseId, String gameIcon, String gameName, String roleName, String sectionName, int visible, List<RoleInfo> list, String backgroundColor, String backgroundImage, String roleImage, int authStatus, String distributorChannelName, int distributorChannelId, String detailUrl, int bindMethodType, String commentDisplayGameName) {
        Intrinsics.checkNotNullParameter(id, ReportBuildInParam.ID);
        Intrinsics.checkNotNullParameter(gameIcon, "gameIcon");
        Intrinsics.checkNotNullParameter(gameName, "gameName");
        this.id = id;
        this.gameBaseId = gameBaseId;
        this.gameIcon = gameIcon;
        this.gameName = gameName;
        this.roleName = roleName;
        this.sectionName = sectionName;
        this.visible = visible;
        this.roleInfos = list;
        this.backgroundColor = backgroundColor;
        this.backgroundImage = backgroundImage;
        this.roleImage = roleImage;
        this.authStatus = authStatus;
        this.distributorChannelName = distributorChannelName;
        this.distributorChannelId = distributorChannelId;
        this.detailUrl = detailUrl;
        this.bindMethodType = bindMethodType;
        this.commentDisplayGameName = commentDisplayGameName;
        this.reportParams = MapsKt.mapOf(new Pair[]{TuplesKt.to("game_base_id", String.valueOf(this.gameBaseId)), TuplesKt.to("game_name", this.gameName), TuplesKt.to("role_bind_id", this.id)});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(RoleInfo$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$game_bind_debug(RoleItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.id, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 0, self.id);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.gameBaseId != 0) {
            output.encodeIntElement(serialDesc, 1, self.gameBaseId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.gameIcon, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 2, self.gameIcon);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.gameName, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 3, self.gameName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.roleName != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.roleName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.sectionName != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.sectionName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.visible != 1) {
            output.encodeIntElement(serialDesc, 6, self.visible);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.roleInfos != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, (SerializationStrategy) lazyArr[7].getValue(), self.roleInfos);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.backgroundColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.backgroundColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.backgroundImage != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.backgroundImage);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.roleImage != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.roleImage);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.authStatus != 0) {
            output.encodeIntElement(serialDesc, 11, self.authStatus);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.distributorChannelName != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.distributorChannelName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.distributorChannelId != 0) {
            output.encodeIntElement(serialDesc, 13, self.distributorChannelId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.detailUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.detailUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.bindMethodType != 0) {
            output.encodeIntElement(serialDesc, 15, self.bindMethodType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.commentDisplayGameName != null) {
            output.encodeNullableSerializableElement(serialDesc, 16, StringSerializer.INSTANCE, self.commentDisplayGameName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || !Intrinsics.areEqual(self.reportParams, MapsKt.mapOf(new Pair[]{TuplesKt.to("game_base_id", String.valueOf(self.gameBaseId)), TuplesKt.to("game_name", self.gameName), TuplesKt.to("role_bind_id", self.id)}))) {
            output.encodeSerializableElement(serialDesc, 17, (SerializationStrategy) lazyArr[17].getValue(), self.reportParams);
        }
    }

    public /* synthetic */ RoleItem(String str, int i, String str2, String str3, String str4, String str5, int i2, List list, String str6, String str7, String str8, int i3, String str9, int i4, String str10, int i5, String str11, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i6 & 2) != 0 ? 0 : i, (i6 & 4) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2, (i6 & 8) == 0 ? str3 : RoomRecommendViewModel.EMPTY_CURSOR, (i6 & 16) != 0 ? null : str4, (i6 & 32) != 0 ? null : str5, (i6 & 64) != 0 ? 1 : i2, (i6 & 128) != 0 ? null : list, (i6 & 256) != 0 ? null : str6, (i6 & 512) != 0 ? null : str7, (i6 & 1024) != 0 ? null : str8, (i6 & 2048) != 0 ? 0 : i3, (i6 & 4096) != 0 ? null : str9, (i6 & 8192) != 0 ? 0 : i4, (i6 & 16384) != 0 ? null : str10, (i6 & 32768) != 0 ? 0 : i5, (i6 & 65536) != 0 ? null : str11);
    }

    public final String getId() {
        return this.id;
    }

    public final int getGameBaseId() {
        return this.gameBaseId;
    }

    public final String getGameIcon() {
        return this.gameIcon;
    }

    public final String getGameName() {
        return this.gameName;
    }

    public final String getRoleName() {
        return this.roleName;
    }

    public final String getSectionName() {
        return this.sectionName;
    }

    public final int getVisible() {
        return this.visible;
    }

    public final List<RoleInfo> getRoleInfos() {
        return this.roleInfos;
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getBackgroundImage() {
        return this.backgroundImage;
    }

    public final String getRoleImage() {
        return this.roleImage;
    }

    public final int getAuthStatus() {
        return this.authStatus;
    }

    public final String getDistributorChannelName() {
        return this.distributorChannelName;
    }

    public final int getDistributorChannelId() {
        return this.distributorChannelId;
    }

    public final String getDetailUrl() {
        return this.detailUrl;
    }

    public final int getBindMethodType() {
        return this.bindMethodType;
    }

    public final String getCommentDisplayGameName() {
        return this.commentDisplayGameName;
    }

    public final Map<String, String> getReportParams() {
        return this.reportParams;
    }

    /* compiled from: RoleItem.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Lkntr/app/game/gamebind/bean/RoleItem$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "decodeFromString", "Lkntr/app/game/gamebind/bean/RoleItem;", "string", RoomRecommendViewModel.EMPTY_CURSOR, "serializer", "Lkotlinx/serialization/KSerializer;", "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<RoleItem> serializer() {
            return RoleItem$$serializer.INSTANCE;
        }

        public final RoleItem decodeFromString(String string) {
            try {
                Json this_$iv = KtJsonKt.getKtJson();
                String string$iv = string == null ? RoomRecommendViewModel.EMPTY_CURSOR : string;
                this_$iv.getSerializersModule();
                return (RoleItem) this_$iv.decodeFromString(BuiltinSerializersKt.getNullable(RoleItem.Companion.serializer()), string$iv);
            } catch (Throwable th) {
                return null;
            }
        }
    }
}