package kntr.app.game.biz;

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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: SteamPrivacyConfig.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\bX\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u0083\u00012\u00020\u0001:\u0004\u0082\u0001\u0083\u0001B£\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001e\u0010\u001fB\u0089\u0002\b\u0010\u0012\u0006\u0010 \u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b\u001e\u0010#J\u0010\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010%J\u000b\u0010]\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010^\u001a\u00020\u0007HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00106J\u000b\u0010c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010d\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00106J\u000b\u0010e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00106J\u000b\u0010g\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010h\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00106J\u000b\u0010i\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010j\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00106J\u000b\u0010k\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010l\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00106J\u000b\u0010m\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010n\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u0010PJ\u0010\u0010o\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u0010PJ\u000b\u0010p\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0005HÆ\u0003J¬\u0002\u0010t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010uJ\u0013\u0010v\u001a\u00020\u00182\b\u0010w\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010x\u001a\u00020\u0007HÖ\u0001J\t\u0010y\u001a\u00020\u0005HÖ\u0001J'\u0010z\u001a\u00020{2\u0006\u0010|\u001a\u00020\u00002\u0006\u0010}\u001a\u00020~2\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0001¢\u0006\u0003\b\u0081\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010(\u001a\u0004\b,\u0010-R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010(\u001a\u0004\b/\u0010*R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010(\u001a\u0004\b1\u0010*R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010(\u001a\u0004\b3\u0010*R \u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00107\u0012\u0004\b4\u0010(\u001a\u0004\b5\u00106R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b8\u0010(\u001a\u0004\b9\u0010*R \u0010\r\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00107\u0012\u0004\b:\u0010(\u001a\u0004\b;\u00106R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b<\u0010(\u001a\u0004\b=\u0010*R \u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00107\u0012\u0004\b>\u0010(\u001a\u0004\b?\u00106R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b@\u0010(\u001a\u0004\bA\u0010*R \u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00107\u0012\u0004\bB\u0010(\u001a\u0004\bC\u00106R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bD\u0010(\u001a\u0004\bE\u0010*R \u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00107\u0012\u0004\bF\u0010(\u001a\u0004\bG\u00106R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bH\u0010(\u001a\u0004\bI\u0010*R \u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00107\u0012\u0004\bJ\u0010(\u001a\u0004\bK\u00106R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bL\u0010(\u001a\u0004\bM\u0010*R \u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010Q\u0012\u0004\bN\u0010(\u001a\u0004\bO\u0010PR \u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010Q\u0012\u0004\bR\u0010(\u001a\u0004\bS\u0010PR\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bT\u0010(\u001a\u0004\bU\u0010*R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bV\u0010(\u001a\u0004\bW\u0010*R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bX\u0010(\u001a\u0004\bY\u0010*R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bZ\u0010(\u001a\u0004\b[\u0010*¨\u0006\u0084\u0001"}, d2 = {"Lkntr/app/game/biz/SteamPrivacyResponse;", RoomRecommendViewModel.EMPTY_CURSOR, "uid", RoomRecommendViewModel.EMPTY_CURSOR, "steamId", RoomRecommendViewModel.EMPTY_CURSOR, "bindStatus", RoomRecommendViewModel.EMPTY_CURSOR, "bindStatusDesc", "bindTime", "unBindTime", "privacyProfile", "privacyProfileDesc", "privacyInventory", "privacyInventoryDesc", "privacyInventoryGifts", "privacyInventoryGiftsDesc", "privacyOwnedGames", "privacyOwnedGamesDesc", "privacyPlaytime", "privacyPlaytimeDesc", "privacyFriendsList", "privacyFriendsListDesc", "showFriendCode", RoomRecommendViewModel.EMPTY_CURSOR, "friendCodeMetaConfigEnabled", "communityPublicImageUrl", "privacyHelpMessage", "privacyStepInstructions", "privacyWarningMessage", "<init>", "(Ljava/lang/Long;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUid", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSteamId$annotations", "()V", "getSteamId", "()Ljava/lang/String;", "getBindStatus$annotations", "getBindStatus", "()I", "getBindStatusDesc$annotations", "getBindStatusDesc", "getBindTime$annotations", "getBindTime", "getUnBindTime$annotations", "getUnBindTime", "getPrivacyProfile$annotations", "getPrivacyProfile", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPrivacyProfileDesc$annotations", "getPrivacyProfileDesc", "getPrivacyInventory$annotations", "getPrivacyInventory", "getPrivacyInventoryDesc$annotations", "getPrivacyInventoryDesc", "getPrivacyInventoryGifts$annotations", "getPrivacyInventoryGifts", "getPrivacyInventoryGiftsDesc$annotations", "getPrivacyInventoryGiftsDesc", "getPrivacyOwnedGames$annotations", "getPrivacyOwnedGames", "getPrivacyOwnedGamesDesc$annotations", "getPrivacyOwnedGamesDesc", "getPrivacyPlaytime$annotations", "getPrivacyPlaytime", "getPrivacyPlaytimeDesc$annotations", "getPrivacyPlaytimeDesc", "getPrivacyFriendsList$annotations", "getPrivacyFriendsList", "getPrivacyFriendsListDesc$annotations", "getPrivacyFriendsListDesc", "getShowFriendCode$annotations", "getShowFriendCode", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFriendCodeMetaConfigEnabled$annotations", "getFriendCodeMetaConfigEnabled", "getCommunityPublicImageUrl$annotations", "getCommunityPublicImageUrl", "getPrivacyHelpMessage$annotations", "getPrivacyHelpMessage", "getPrivacyStepInstructions$annotations", "getPrivacyStepInstructions", "getPrivacyWarningMessage$annotations", "getPrivacyWarningMessage", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "copy", "(Ljava/lang/Long;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lkntr/app/game/biz/SteamPrivacyResponse;", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$gamebiz_debug", "$serializer", "Companion", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class SteamPrivacyResponse {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final int bindStatus;
    private final String bindStatusDesc;
    private final String bindTime;
    private final String communityPublicImageUrl;
    private final Boolean friendCodeMetaConfigEnabled;
    private final Integer privacyFriendsList;
    private final String privacyFriendsListDesc;
    private final String privacyHelpMessage;
    private final Integer privacyInventory;
    private final String privacyInventoryDesc;
    private final Integer privacyInventoryGifts;
    private final String privacyInventoryGiftsDesc;
    private final Integer privacyOwnedGames;
    private final String privacyOwnedGamesDesc;
    private final Integer privacyPlaytime;
    private final String privacyPlaytimeDesc;
    private final Integer privacyProfile;
    private final String privacyProfileDesc;
    private final String privacyStepInstructions;
    private final String privacyWarningMessage;
    private final Boolean showFriendCode;
    private final String steamId;
    private final Long uid;
    private final String unBindTime;

    @SerialName("bind_status")
    public static /* synthetic */ void getBindStatus$annotations() {
    }

    @SerialName("bind_status_desc")
    public static /* synthetic */ void getBindStatusDesc$annotations() {
    }

    @SerialName("bind_time")
    public static /* synthetic */ void getBindTime$annotations() {
    }

    @SerialName("community_public_image_url")
    public static /* synthetic */ void getCommunityPublicImageUrl$annotations() {
    }

    @SerialName("friend_code_meta_config_enabled")
    public static /* synthetic */ void getFriendCodeMetaConfigEnabled$annotations() {
    }

    @SerialName("privacy_friends_list")
    public static /* synthetic */ void getPrivacyFriendsList$annotations() {
    }

    @SerialName("privacy_friends_list_desc")
    public static /* synthetic */ void getPrivacyFriendsListDesc$annotations() {
    }

    @SerialName("privacy_help_message")
    public static /* synthetic */ void getPrivacyHelpMessage$annotations() {
    }

    @SerialName("privacy_inventory")
    public static /* synthetic */ void getPrivacyInventory$annotations() {
    }

    @SerialName("privacy_inventory_desc")
    public static /* synthetic */ void getPrivacyInventoryDesc$annotations() {
    }

    @SerialName("privacy_inventory_gifts")
    public static /* synthetic */ void getPrivacyInventoryGifts$annotations() {
    }

    @SerialName("privacy_inventory_gifts_desc")
    public static /* synthetic */ void getPrivacyInventoryGiftsDesc$annotations() {
    }

    @SerialName("privacy_owned_games")
    public static /* synthetic */ void getPrivacyOwnedGames$annotations() {
    }

    @SerialName("privacy_owned_games_desc")
    public static /* synthetic */ void getPrivacyOwnedGamesDesc$annotations() {
    }

    @SerialName("privacy_playtime")
    public static /* synthetic */ void getPrivacyPlaytime$annotations() {
    }

    @SerialName("privacy_playtime_desc")
    public static /* synthetic */ void getPrivacyPlaytimeDesc$annotations() {
    }

    @SerialName("privacy_profile")
    public static /* synthetic */ void getPrivacyProfile$annotations() {
    }

    @SerialName("privacy_profile_desc")
    public static /* synthetic */ void getPrivacyProfileDesc$annotations() {
    }

    @SerialName("privacy_step_instructions")
    public static /* synthetic */ void getPrivacyStepInstructions$annotations() {
    }

    @SerialName("privacy_warning_message")
    public static /* synthetic */ void getPrivacyWarningMessage$annotations() {
    }

    @SerialName("show_friend_code")
    public static /* synthetic */ void getShowFriendCode$annotations() {
    }

    @SerialName("steam_id")
    public static /* synthetic */ void getSteamId$annotations() {
    }

    @SerialName("un_bind_time")
    public static /* synthetic */ void getUnBindTime$annotations() {
    }

    public final Long component1() {
        return this.uid;
    }

    public final String component10() {
        return this.privacyInventoryDesc;
    }

    public final Integer component11() {
        return this.privacyInventoryGifts;
    }

    public final String component12() {
        return this.privacyInventoryGiftsDesc;
    }

    public final Integer component13() {
        return this.privacyOwnedGames;
    }

    public final String component14() {
        return this.privacyOwnedGamesDesc;
    }

    public final Integer component15() {
        return this.privacyPlaytime;
    }

    public final String component16() {
        return this.privacyPlaytimeDesc;
    }

    public final Integer component17() {
        return this.privacyFriendsList;
    }

    public final String component18() {
        return this.privacyFriendsListDesc;
    }

    public final Boolean component19() {
        return this.showFriendCode;
    }

    public final String component2() {
        return this.steamId;
    }

    public final Boolean component20() {
        return this.friendCodeMetaConfigEnabled;
    }

    public final String component21() {
        return this.communityPublicImageUrl;
    }

    public final String component22() {
        return this.privacyHelpMessage;
    }

    public final String component23() {
        return this.privacyStepInstructions;
    }

    public final String component24() {
        return this.privacyWarningMessage;
    }

    public final int component3() {
        return this.bindStatus;
    }

    public final String component4() {
        return this.bindStatusDesc;
    }

    public final String component5() {
        return this.bindTime;
    }

    public final String component6() {
        return this.unBindTime;
    }

    public final Integer component7() {
        return this.privacyProfile;
    }

    public final String component8() {
        return this.privacyProfileDesc;
    }

    public final Integer component9() {
        return this.privacyInventory;
    }

    public final SteamPrivacyResponse copy(Long l, String str, int i, String str2, String str3, String str4, Integer num, String str5, Integer num2, String str6, Integer num3, String str7, Integer num4, String str8, Integer num5, String str9, Integer num6, String str10, Boolean bool, Boolean bool2, String str11, String str12, String str13, String str14) {
        return new SteamPrivacyResponse(l, str, i, str2, str3, str4, num, str5, num2, str6, num3, str7, num4, str8, num5, str9, num6, str10, bool, bool2, str11, str12, str13, str14);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SteamPrivacyResponse) {
            SteamPrivacyResponse steamPrivacyResponse = (SteamPrivacyResponse) obj;
            return Intrinsics.areEqual(this.uid, steamPrivacyResponse.uid) && Intrinsics.areEqual(this.steamId, steamPrivacyResponse.steamId) && this.bindStatus == steamPrivacyResponse.bindStatus && Intrinsics.areEqual(this.bindStatusDesc, steamPrivacyResponse.bindStatusDesc) && Intrinsics.areEqual(this.bindTime, steamPrivacyResponse.bindTime) && Intrinsics.areEqual(this.unBindTime, steamPrivacyResponse.unBindTime) && Intrinsics.areEqual(this.privacyProfile, steamPrivacyResponse.privacyProfile) && Intrinsics.areEqual(this.privacyProfileDesc, steamPrivacyResponse.privacyProfileDesc) && Intrinsics.areEqual(this.privacyInventory, steamPrivacyResponse.privacyInventory) && Intrinsics.areEqual(this.privacyInventoryDesc, steamPrivacyResponse.privacyInventoryDesc) && Intrinsics.areEqual(this.privacyInventoryGifts, steamPrivacyResponse.privacyInventoryGifts) && Intrinsics.areEqual(this.privacyInventoryGiftsDesc, steamPrivacyResponse.privacyInventoryGiftsDesc) && Intrinsics.areEqual(this.privacyOwnedGames, steamPrivacyResponse.privacyOwnedGames) && Intrinsics.areEqual(this.privacyOwnedGamesDesc, steamPrivacyResponse.privacyOwnedGamesDesc) && Intrinsics.areEqual(this.privacyPlaytime, steamPrivacyResponse.privacyPlaytime) && Intrinsics.areEqual(this.privacyPlaytimeDesc, steamPrivacyResponse.privacyPlaytimeDesc) && Intrinsics.areEqual(this.privacyFriendsList, steamPrivacyResponse.privacyFriendsList) && Intrinsics.areEqual(this.privacyFriendsListDesc, steamPrivacyResponse.privacyFriendsListDesc) && Intrinsics.areEqual(this.showFriendCode, steamPrivacyResponse.showFriendCode) && Intrinsics.areEqual(this.friendCodeMetaConfigEnabled, steamPrivacyResponse.friendCodeMetaConfigEnabled) && Intrinsics.areEqual(this.communityPublicImageUrl, steamPrivacyResponse.communityPublicImageUrl) && Intrinsics.areEqual(this.privacyHelpMessage, steamPrivacyResponse.privacyHelpMessage) && Intrinsics.areEqual(this.privacyStepInstructions, steamPrivacyResponse.privacyStepInstructions) && Intrinsics.areEqual(this.privacyWarningMessage, steamPrivacyResponse.privacyWarningMessage);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((this.uid == null ? 0 : this.uid.hashCode()) * 31) + (this.steamId == null ? 0 : this.steamId.hashCode())) * 31) + this.bindStatus) * 31) + (this.bindStatusDesc == null ? 0 : this.bindStatusDesc.hashCode())) * 31) + (this.bindTime == null ? 0 : this.bindTime.hashCode())) * 31) + (this.unBindTime == null ? 0 : this.unBindTime.hashCode())) * 31) + (this.privacyProfile == null ? 0 : this.privacyProfile.hashCode())) * 31) + (this.privacyProfileDesc == null ? 0 : this.privacyProfileDesc.hashCode())) * 31) + (this.privacyInventory == null ? 0 : this.privacyInventory.hashCode())) * 31) + (this.privacyInventoryDesc == null ? 0 : this.privacyInventoryDesc.hashCode())) * 31) + (this.privacyInventoryGifts == null ? 0 : this.privacyInventoryGifts.hashCode())) * 31) + (this.privacyInventoryGiftsDesc == null ? 0 : this.privacyInventoryGiftsDesc.hashCode())) * 31) + (this.privacyOwnedGames == null ? 0 : this.privacyOwnedGames.hashCode())) * 31) + (this.privacyOwnedGamesDesc == null ? 0 : this.privacyOwnedGamesDesc.hashCode())) * 31) + (this.privacyPlaytime == null ? 0 : this.privacyPlaytime.hashCode())) * 31) + (this.privacyPlaytimeDesc == null ? 0 : this.privacyPlaytimeDesc.hashCode())) * 31) + (this.privacyFriendsList == null ? 0 : this.privacyFriendsList.hashCode())) * 31) + (this.privacyFriendsListDesc == null ? 0 : this.privacyFriendsListDesc.hashCode())) * 31) + (this.showFriendCode == null ? 0 : this.showFriendCode.hashCode())) * 31) + (this.friendCodeMetaConfigEnabled == null ? 0 : this.friendCodeMetaConfigEnabled.hashCode())) * 31) + (this.communityPublicImageUrl == null ? 0 : this.communityPublicImageUrl.hashCode())) * 31) + (this.privacyHelpMessage == null ? 0 : this.privacyHelpMessage.hashCode())) * 31) + (this.privacyStepInstructions == null ? 0 : this.privacyStepInstructions.hashCode())) * 31) + (this.privacyWarningMessage != null ? this.privacyWarningMessage.hashCode() : 0);
    }

    public String toString() {
        Long l = this.uid;
        String str = this.steamId;
        int i = this.bindStatus;
        String str2 = this.bindStatusDesc;
        String str3 = this.bindTime;
        String str4 = this.unBindTime;
        Integer num = this.privacyProfile;
        String str5 = this.privacyProfileDesc;
        Integer num2 = this.privacyInventory;
        String str6 = this.privacyInventoryDesc;
        Integer num3 = this.privacyInventoryGifts;
        String str7 = this.privacyInventoryGiftsDesc;
        Integer num4 = this.privacyOwnedGames;
        String str8 = this.privacyOwnedGamesDesc;
        Integer num5 = this.privacyPlaytime;
        String str9 = this.privacyPlaytimeDesc;
        Integer num6 = this.privacyFriendsList;
        String str10 = this.privacyFriendsListDesc;
        Boolean bool = this.showFriendCode;
        Boolean bool2 = this.friendCodeMetaConfigEnabled;
        String str11 = this.communityPublicImageUrl;
        String str12 = this.privacyHelpMessage;
        String str13 = this.privacyStepInstructions;
        return "SteamPrivacyResponse(uid=" + l + ", steamId=" + str + ", bindStatus=" + i + ", bindStatusDesc=" + str2 + ", bindTime=" + str3 + ", unBindTime=" + str4 + ", privacyProfile=" + num + ", privacyProfileDesc=" + str5 + ", privacyInventory=" + num2 + ", privacyInventoryDesc=" + str6 + ", privacyInventoryGifts=" + num3 + ", privacyInventoryGiftsDesc=" + str7 + ", privacyOwnedGames=" + num4 + ", privacyOwnedGamesDesc=" + str8 + ", privacyPlaytime=" + num5 + ", privacyPlaytimeDesc=" + str9 + ", privacyFriendsList=" + num6 + ", privacyFriendsListDesc=" + str10 + ", showFriendCode=" + bool + ", friendCodeMetaConfigEnabled=" + bool2 + ", communityPublicImageUrl=" + str11 + ", privacyHelpMessage=" + str12 + ", privacyStepInstructions=" + str13 + ", privacyWarningMessage=" + this.privacyWarningMessage + ")";
    }

    /* compiled from: SteamPrivacyConfig.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/game/biz/SteamPrivacyResponse$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/game/biz/SteamPrivacyResponse;", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<SteamPrivacyResponse> serializer() {
            return SteamPrivacyResponse$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SteamPrivacyResponse(int seen0, Long uid, String steamId, int bindStatus, String bindStatusDesc, String bindTime, String unBindTime, Integer privacyProfile, String privacyProfileDesc, Integer privacyInventory, String privacyInventoryDesc, Integer privacyInventoryGifts, String privacyInventoryGiftsDesc, Integer privacyOwnedGames, String privacyOwnedGamesDesc, Integer privacyPlaytime, String privacyPlaytimeDesc, Integer privacyFriendsList, String privacyFriendsListDesc, Boolean showFriendCode, Boolean friendCodeMetaConfigEnabled, String communityPublicImageUrl, String privacyHelpMessage, String privacyStepInstructions, String privacyWarningMessage, SerializationConstructorMarker serializationConstructorMarker) {
        if (4 != (seen0 & 4)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 4, SteamPrivacyResponse$$serializer.INSTANCE.getDescriptor());
        }
        if ((seen0 & 1) == 0) {
            this.uid = null;
        } else {
            this.uid = uid;
        }
        if ((seen0 & 2) == 0) {
            this.steamId = null;
        } else {
            this.steamId = steamId;
        }
        this.bindStatus = bindStatus;
        if ((seen0 & 8) == 0) {
            this.bindStatusDesc = null;
        } else {
            this.bindStatusDesc = bindStatusDesc;
        }
        if ((seen0 & 16) == 0) {
            this.bindTime = null;
        } else {
            this.bindTime = bindTime;
        }
        if ((seen0 & 32) == 0) {
            this.unBindTime = null;
        } else {
            this.unBindTime = unBindTime;
        }
        if ((seen0 & 64) == 0) {
            this.privacyProfile = null;
        } else {
            this.privacyProfile = privacyProfile;
        }
        if ((seen0 & 128) == 0) {
            this.privacyProfileDesc = null;
        } else {
            this.privacyProfileDesc = privacyProfileDesc;
        }
        if ((seen0 & 256) == 0) {
            this.privacyInventory = null;
        } else {
            this.privacyInventory = privacyInventory;
        }
        if ((seen0 & 512) == 0) {
            this.privacyInventoryDesc = null;
        } else {
            this.privacyInventoryDesc = privacyInventoryDesc;
        }
        if ((seen0 & 1024) == 0) {
            this.privacyInventoryGifts = null;
        } else {
            this.privacyInventoryGifts = privacyInventoryGifts;
        }
        if ((seen0 & 2048) == 0) {
            this.privacyInventoryGiftsDesc = null;
        } else {
            this.privacyInventoryGiftsDesc = privacyInventoryGiftsDesc;
        }
        if ((seen0 & 4096) == 0) {
            this.privacyOwnedGames = null;
        } else {
            this.privacyOwnedGames = privacyOwnedGames;
        }
        if ((seen0 & 8192) == 0) {
            this.privacyOwnedGamesDesc = null;
        } else {
            this.privacyOwnedGamesDesc = privacyOwnedGamesDesc;
        }
        if ((seen0 & 16384) == 0) {
            this.privacyPlaytime = null;
        } else {
            this.privacyPlaytime = privacyPlaytime;
        }
        if ((seen0 & 32768) == 0) {
            this.privacyPlaytimeDesc = null;
        } else {
            this.privacyPlaytimeDesc = privacyPlaytimeDesc;
        }
        if ((seen0 & 65536) == 0) {
            this.privacyFriendsList = null;
        } else {
            this.privacyFriendsList = privacyFriendsList;
        }
        if ((seen0 & 131072) == 0) {
            this.privacyFriendsListDesc = null;
        } else {
            this.privacyFriendsListDesc = privacyFriendsListDesc;
        }
        if ((seen0 & 262144) == 0) {
            this.showFriendCode = null;
        } else {
            this.showFriendCode = showFriendCode;
        }
        if ((seen0 & 524288) == 0) {
            this.friendCodeMetaConfigEnabled = null;
        } else {
            this.friendCodeMetaConfigEnabled = friendCodeMetaConfigEnabled;
        }
        if ((seen0 & 1048576) == 0) {
            this.communityPublicImageUrl = null;
        } else {
            this.communityPublicImageUrl = communityPublicImageUrl;
        }
        if ((seen0 & 2097152) == 0) {
            this.privacyHelpMessage = null;
        } else {
            this.privacyHelpMessage = privacyHelpMessage;
        }
        if ((seen0 & 4194304) == 0) {
            this.privacyStepInstructions = null;
        } else {
            this.privacyStepInstructions = privacyStepInstructions;
        }
        if ((seen0 & 8388608) == 0) {
            this.privacyWarningMessage = null;
        } else {
            this.privacyWarningMessage = privacyWarningMessage;
        }
    }

    public SteamPrivacyResponse(Long uid, String steamId, int bindStatus, String bindStatusDesc, String bindTime, String unBindTime, Integer privacyProfile, String privacyProfileDesc, Integer privacyInventory, String privacyInventoryDesc, Integer privacyInventoryGifts, String privacyInventoryGiftsDesc, Integer privacyOwnedGames, String privacyOwnedGamesDesc, Integer privacyPlaytime, String privacyPlaytimeDesc, Integer privacyFriendsList, String privacyFriendsListDesc, Boolean showFriendCode, Boolean friendCodeMetaConfigEnabled, String communityPublicImageUrl, String privacyHelpMessage, String privacyStepInstructions, String privacyWarningMessage) {
        this.uid = uid;
        this.steamId = steamId;
        this.bindStatus = bindStatus;
        this.bindStatusDesc = bindStatusDesc;
        this.bindTime = bindTime;
        this.unBindTime = unBindTime;
        this.privacyProfile = privacyProfile;
        this.privacyProfileDesc = privacyProfileDesc;
        this.privacyInventory = privacyInventory;
        this.privacyInventoryDesc = privacyInventoryDesc;
        this.privacyInventoryGifts = privacyInventoryGifts;
        this.privacyInventoryGiftsDesc = privacyInventoryGiftsDesc;
        this.privacyOwnedGames = privacyOwnedGames;
        this.privacyOwnedGamesDesc = privacyOwnedGamesDesc;
        this.privacyPlaytime = privacyPlaytime;
        this.privacyPlaytimeDesc = privacyPlaytimeDesc;
        this.privacyFriendsList = privacyFriendsList;
        this.privacyFriendsListDesc = privacyFriendsListDesc;
        this.showFriendCode = showFriendCode;
        this.friendCodeMetaConfigEnabled = friendCodeMetaConfigEnabled;
        this.communityPublicImageUrl = communityPublicImageUrl;
        this.privacyHelpMessage = privacyHelpMessage;
        this.privacyStepInstructions = privacyStepInstructions;
        this.privacyWarningMessage = privacyWarningMessage;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$gamebiz_debug(SteamPrivacyResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.uid != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, LongSerializer.INSTANCE, self.uid);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.steamId != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.steamId);
        }
        output.encodeIntElement(serialDesc, 2, self.bindStatus);
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.bindStatusDesc != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.bindStatusDesc);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.bindTime != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.bindTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.unBindTime != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.unBindTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.privacyProfile != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, IntSerializer.INSTANCE, self.privacyProfile);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.privacyProfileDesc != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.privacyProfileDesc);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.privacyInventory != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, IntSerializer.INSTANCE, self.privacyInventory);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.privacyInventoryDesc != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.privacyInventoryDesc);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.privacyInventoryGifts != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, IntSerializer.INSTANCE, self.privacyInventoryGifts);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.privacyInventoryGiftsDesc != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.privacyInventoryGiftsDesc);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.privacyOwnedGames != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, IntSerializer.INSTANCE, self.privacyOwnedGames);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.privacyOwnedGamesDesc != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.privacyOwnedGamesDesc);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.privacyPlaytime != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, IntSerializer.INSTANCE, self.privacyPlaytime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.privacyPlaytimeDesc != null) {
            output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.privacyPlaytimeDesc);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.privacyFriendsList != null) {
            output.encodeNullableSerializableElement(serialDesc, 16, IntSerializer.INSTANCE, self.privacyFriendsList);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.privacyFriendsListDesc != null) {
            output.encodeNullableSerializableElement(serialDesc, 17, StringSerializer.INSTANCE, self.privacyFriendsListDesc);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 18) || self.showFriendCode != null) {
            output.encodeNullableSerializableElement(serialDesc, 18, BooleanSerializer.INSTANCE, self.showFriendCode);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 19) || self.friendCodeMetaConfigEnabled != null) {
            output.encodeNullableSerializableElement(serialDesc, 19, BooleanSerializer.INSTANCE, self.friendCodeMetaConfigEnabled);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 20) || self.communityPublicImageUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 20, StringSerializer.INSTANCE, self.communityPublicImageUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 21) || self.privacyHelpMessage != null) {
            output.encodeNullableSerializableElement(serialDesc, 21, StringSerializer.INSTANCE, self.privacyHelpMessage);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 22) || self.privacyStepInstructions != null) {
            output.encodeNullableSerializableElement(serialDesc, 22, StringSerializer.INSTANCE, self.privacyStepInstructions);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 23) || self.privacyWarningMessage != null) {
            output.encodeNullableSerializableElement(serialDesc, 23, StringSerializer.INSTANCE, self.privacyWarningMessage);
        }
    }

    public /* synthetic */ SteamPrivacyResponse(Long l, String str, int i, String str2, String str3, String str4, Integer num, String str5, Integer num2, String str6, Integer num3, String str7, Integer num4, String str8, Integer num5, String str9, Integer num6, String str10, Boolean bool, Boolean bool2, String str11, String str12, String str13, String str14, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : l, (i2 & 2) != 0 ? null : str, i, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? null : str3, (i2 & 32) != 0 ? null : str4, (i2 & 64) != 0 ? null : num, (i2 & 128) != 0 ? null : str5, (i2 & 256) != 0 ? null : num2, (i2 & 512) != 0 ? null : str6, (i2 & 1024) != 0 ? null : num3, (i2 & 2048) != 0 ? null : str7, (i2 & 4096) != 0 ? null : num4, (i2 & 8192) != 0 ? null : str8, (i2 & 16384) != 0 ? null : num5, (32768 & i2) != 0 ? null : str9, (65536 & i2) != 0 ? null : num6, (131072 & i2) != 0 ? null : str10, (262144 & i2) != 0 ? null : bool, (524288 & i2) != 0 ? null : bool2, (1048576 & i2) != 0 ? null : str11, (2097152 & i2) != 0 ? null : str12, (4194304 & i2) != 0 ? null : str13, (i2 & 8388608) != 0 ? null : str14);
    }

    public final Long getUid() {
        return this.uid;
    }

    public final String getSteamId() {
        return this.steamId;
    }

    public final int getBindStatus() {
        return this.bindStatus;
    }

    public final String getBindStatusDesc() {
        return this.bindStatusDesc;
    }

    public final String getBindTime() {
        return this.bindTime;
    }

    public final String getUnBindTime() {
        return this.unBindTime;
    }

    public final Integer getPrivacyProfile() {
        return this.privacyProfile;
    }

    public final String getPrivacyProfileDesc() {
        return this.privacyProfileDesc;
    }

    public final Integer getPrivacyInventory() {
        return this.privacyInventory;
    }

    public final String getPrivacyInventoryDesc() {
        return this.privacyInventoryDesc;
    }

    public final Integer getPrivacyInventoryGifts() {
        return this.privacyInventoryGifts;
    }

    public final String getPrivacyInventoryGiftsDesc() {
        return this.privacyInventoryGiftsDesc;
    }

    public final Integer getPrivacyOwnedGames() {
        return this.privacyOwnedGames;
    }

    public final String getPrivacyOwnedGamesDesc() {
        return this.privacyOwnedGamesDesc;
    }

    public final Integer getPrivacyPlaytime() {
        return this.privacyPlaytime;
    }

    public final String getPrivacyPlaytimeDesc() {
        return this.privacyPlaytimeDesc;
    }

    public final Integer getPrivacyFriendsList() {
        return this.privacyFriendsList;
    }

    public final String getPrivacyFriendsListDesc() {
        return this.privacyFriendsListDesc;
    }

    public final Boolean getShowFriendCode() {
        return this.showFriendCode;
    }

    public final Boolean getFriendCodeMetaConfigEnabled() {
        return this.friendCodeMetaConfigEnabled;
    }

    public final String getCommunityPublicImageUrl() {
        return this.communityPublicImageUrl;
    }

    public final String getPrivacyHelpMessage() {
        return this.privacyHelpMessage;
    }

    public final String getPrivacyStepInstructions() {
        return this.privacyStepInstructions;
    }

    public final String getPrivacyWarningMessage() {
        return this.privacyWarningMessage;
    }
}