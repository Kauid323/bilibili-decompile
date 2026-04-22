package kntr.compose.avatar.model.layers;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* compiled from: Configs.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lkntr/compose/avatar/model/layers/ConfigKey;", "", "key", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "Invalid", "Background", "Avatar", "Pendant", "Icon", "GeneralKey", "GyroAssociatedKey", "GyroKey", "CommentDoubleAssociatedKey", "CommentDoubleClickKey", "LiveAnimaKey", "DarkModeOverride", "DarkModeAssociate", "FollowIconKey", "FollowIconAssociatedKey", "FollowActionCfg", "FollowActionAssociated", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public enum ConfigKey {
    Invalid(""),
    Background("BACKGROUND_LAYER"),
    Avatar("AVATAR_LAYER"),
    Pendant("PENDENT_LAYER"),
    Icon("ICON_LAYER"),
    GeneralKey("GENERAL_CFG"),
    GyroAssociatedKey("GYRO_ASSOCIATED"),
    GyroKey("GYRO_CFG"),
    CommentDoubleAssociatedKey("COMMENT_DOUBLE_CLICK_ASSOCIATED"),
    CommentDoubleClickKey("COMMENT_DOUBLE_CLICK_CFG"),
    LiveAnimaKey("LIVE_ANIME_CFG"),
    DarkModeOverride("DARK_MODE_OVERRIDE_CFG"),
    DarkModeAssociate("DARK_MODE_OVERRIDE_ASSOCIATED"),
    FollowIconKey("FOLLOW_ICON_CFG"),
    FollowIconAssociatedKey("FOLLOW_ICON_ASSOCIATED"),
    FollowActionCfg("FOLLOW_ACTION_CFG"),
    FollowActionAssociated("FOLLOW_ACTION_ASSOCIATED");
    
    private final String key;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<ConfigKey> getEntries() {
        return $ENTRIES;
    }

    ConfigKey(String key) {
        this.key = key;
    }

    public final String getKey() {
        return this.key;
    }
}