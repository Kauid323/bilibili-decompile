package kntr.compose.avatar.model.layers;

import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Configs.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\" \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"forConfigKey", "Lkntr/compose/avatar/model/layers/ConfigKey;", "", "configMap", "", "getConfigMap", "()Ljava/util/Map;", "model_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ConfigsKt {
    private static final Map<String, ConfigKey> configMap = MapsKt.mapOf(new Pair[]{TuplesKt.to("", ConfigKey.Invalid), TuplesKt.to("GENERAL_CFG", ConfigKey.GeneralKey), TuplesKt.to("GYRO_ASSOCIATED", ConfigKey.GyroAssociatedKey), TuplesKt.to("GYRO_CFG", ConfigKey.GyroKey), TuplesKt.to("COMMENT_DOUBLE_CLICK_ASSOCIATED", ConfigKey.CommentDoubleAssociatedKey), TuplesKt.to("COMMENT_DOUBLE_CLICK_CFG", ConfigKey.CommentDoubleClickKey), TuplesKt.to("LIVE_ANIME_CFG", ConfigKey.LiveAnimaKey), TuplesKt.to("BACKGROUND_LAYER", ConfigKey.Background), TuplesKt.to("AVATAR_LAYER", ConfigKey.Avatar), TuplesKt.to("PENDENT_LAYER", ConfigKey.Pendant), TuplesKt.to("ICON_LAYER", ConfigKey.Icon), TuplesKt.to("DARK_MODE_OVERRIDE_CFG", ConfigKey.DarkModeOverride), TuplesKt.to("FOLLOW_ICON_CFG", ConfigKey.FollowIconKey), TuplesKt.to("FOLLOW_ICON_ASSOCIATED", ConfigKey.FollowIconAssociatedKey), TuplesKt.to("FOLLOW_ACTION_CFG", ConfigKey.FollowActionCfg), TuplesKt.to("FOLLOW_ACTION_ASSOCIATED", ConfigKey.FollowActionAssociated)});

    public static final ConfigKey forConfigKey(String $this$forConfigKey) {
        Intrinsics.checkNotNullParameter($this$forConfigKey, "<this>");
        ConfigKey configKey = configMap.get($this$forConfigKey);
        return configKey == null ? ConfigKey.Invalid : configKey;
    }

    public static final Map<String, ConfigKey> getConfigMap() {
        return configMap;
    }
}