package kntr.app.game.bean;

import kntr.app.game.base.ui.widget.gameaction.state.GameActionStateKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: SteamGameBean.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/game/bean/SteamGameDetailData.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/game/bean/SteamGameDetailData;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class SteamGameDetailData$$serializer implements GeneratedSerializer<SteamGameDetailData> {
    public static final int $stable;
    public static final SteamGameDetailData$$serializer INSTANCE = new SteamGameDetailData$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.game.bean.SteamGameDetailData", INSTANCE, 6);
        pluginGeneratedSerialDescriptor.addElement("game_info", true);
        pluginGeneratedSerialDescriptor.addElement("player_info", true);
        pluginGeneratedSerialDescriptor.addElement("play_data", true);
        pluginGeneratedSerialDescriptor.addElement("achievement_progress", true);
        pluginGeneratedSerialDescriptor.addElement("recent_achievements", true);
        pluginGeneratedSerialDescriptor.addElement("dlc_module", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private SteamGameDetailData$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(GameInfo$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(SteamPlayerInfo$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(PlayData$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AchievementProgress$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(RecentAchievements$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(DlcModule$$serializer.INSTANCE)};
    }

    public final SteamGameDetailData deserialize(Decoder decoder) {
        RecentAchievements recentAchievements;
        DlcModule dlcModule;
        PlayData playData;
        AchievementProgress achievementProgress;
        GameInfo gameInfo;
        SteamPlayerInfo steamPlayerInfo;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i2 = 5;
        GameInfo gameInfo2 = null;
        if (beginStructure.decodeSequentially()) {
            gameInfo = (GameInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, GameInfo$$serializer.INSTANCE, (Object) null);
            dlcModule = (DlcModule) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, DlcModule$$serializer.INSTANCE, (Object) null);
            achievementProgress = (AchievementProgress) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, AchievementProgress$$serializer.INSTANCE, (Object) null);
            recentAchievements = (RecentAchievements) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, RecentAchievements$$serializer.INSTANCE, (Object) null);
            playData = (PlayData) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, PlayData$$serializer.INSTANCE, (Object) null);
            steamPlayerInfo = (SteamPlayerInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, SteamPlayerInfo$$serializer.INSTANCE, (Object) null);
            i = 63;
        } else {
            boolean z = true;
            int i3 = 0;
            SteamPlayerInfo steamPlayerInfo2 = null;
            PlayData playData2 = null;
            AchievementProgress achievementProgress2 = null;
            RecentAchievements recentAchievements2 = null;
            DlcModule dlcModule2 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        z = false;
                        i2 = 5;
                    case 0:
                        gameInfo2 = (GameInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, GameInfo$$serializer.INSTANCE, gameInfo2);
                        i3 |= 1;
                        i2 = 5;
                    case 1:
                        steamPlayerInfo2 = (SteamPlayerInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, SteamPlayerInfo$$serializer.INSTANCE, steamPlayerInfo2);
                        i3 |= 2;
                    case 2:
                        playData2 = (PlayData) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, PlayData$$serializer.INSTANCE, playData2);
                        i3 |= 4;
                    case 3:
                        achievementProgress2 = (AchievementProgress) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, AchievementProgress$$serializer.INSTANCE, achievementProgress2);
                        i3 |= 8;
                    case 4:
                        recentAchievements2 = (RecentAchievements) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, RecentAchievements$$serializer.INSTANCE, recentAchievements2);
                        i3 |= 16;
                    case 5:
                        dlcModule2 = (DlcModule) beginStructure.decodeNullableSerializableElement(serialDescriptor, i2, DlcModule$$serializer.INSTANCE, dlcModule2);
                        i3 |= 32;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            recentAchievements = recentAchievements2;
            dlcModule = dlcModule2;
            playData = playData2;
            achievementProgress = achievementProgress2;
            gameInfo = gameInfo2;
            steamPlayerInfo = steamPlayerInfo2;
            i = i3;
        }
        beginStructure.endStructure(serialDescriptor);
        return new SteamGameDetailData(i, gameInfo, steamPlayerInfo, playData, achievementProgress, recentAchievements, dlcModule, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, SteamGameDetailData value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        SteamGameDetailData.write$Self$gamebiz_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}