package tv.danmaku.biliplayerv2.service.setting;

import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: Constants.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000f\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0004\"\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0004\"\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0004\"\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0004\"\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0004\"\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0004¨\u0006\u0011"}, d2 = {"sMainPlayerSettingKeys", "", "", "getSMainPlayerSettingKeys", "()Ljava/util/List;", "sBLKVKeys", "getSBLKVKeys", "sKeyInScopeVideoItem", "getSKeyInScopeVideoItem", "sKeyInScopeVideo", "getSKeyInScopeVideo", "sKeyInScopePlayer", "getSKeyInScopePlayer", "sKeyInScopeApp", "getSKeyInScopeApp", "sKeyInScopePersistent", "getSKeyInScopePersistent", "biliplayerv2_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ConstantsKt {
    private static final List<String> sMainPlayerSettingKeys = CollectionsKt.listOf(new String[]{Player.KEY_PLAY_COMPLETED_ACTION, DanmakuKeys.KEY_DANMAKU_TEXT_STYLE, DanmakuKeys.KEY_DANMAKU_TEXT_STYLE_BOLD, DanmakuKeys.PREF_DANMAKU_SWITCH_SAVE, Player.KEY_ENABLE_SNAPSHOT_AND_GIF, Player.KEY_ENABLE_SIDE_RECOMMEND_VIDEO, Player.KEY_ENABLE_DOUBLE_FINGER_RESIZE, Player.KEY_SKIP_TITLES_ENDINGS});
    private static final List<String> sBLKVKeys = CollectionsKt.listOf(new String[]{Player.KEY_PLAY_QUALITY_USER_SETTING, Player.KEY_STORY_PLAY_QUALITY_USER_SETTING, Player.KEY_PLAY_QUALITY_AUTO_SWITCH, Player.KEY_STORY_PLAY_QUALITY_AUTO_SWITCH, Player.KEY_QUALITY_USER_SETTING_UNIFORM, Player.KEY_BACKGROUND_SELECTED, Player.KEY_SPEED_4K_DIALOG_SHOW, Player.KEY_AUTO_ENTER_WHOLE_SCENE, Player.KEY_AUTO_OPEN_DOLBY, Player.KEY_HEARTBEAT_CLICK_REPORT_DID, DanmakuKeys.PREF_DANMAKU_SWITCH, DanmakuKeys.PREF_INLINE_DANMAKU_SWITCH, DanmakuKeys.PREF_DANMAKU_AI_RECOMMEND_SWITCH, DanmakuKeys.PREF_DANMAKU_AI_RECOMMEND_LEVEL, DanmakuKeys.PREF_DANMAKU_AI_RECOMMEND_LEVEL_V2, DanmakuKeys.PREF_DANMAKU_AI_RECOMMEND_LEVEL_MAP, DanmakuKeys.PREF_DANMAKU_BLOCKREPEAT, DanmakuKeys.PREF_DANMAKU_BLOCKTOP, DanmakuKeys.PREF_DANMAKU_BLOCKSCROLL, DanmakuKeys.PREF_DANMAKU_BLOCKBOTTOM, DanmakuKeys.PREF_DANMAKU_BLOCKCOLORFUL, DanmakuKeys.PREF_DANMAKU_BLOCKSPECIAL, DanmakuKeys.PREF_DANMAKU_OPACITY, DanmakuKeys.PREF_DANMAKU_SCALING_FACTOR, DanmakuKeys.PREF_DANMAKU_DOMAIN, DanmakuKeys.PREF_DANMAKU_SPEED, DanmakuKeys.PREF_DANMAKU_ENABLEBLOCKLIST, DanmakuKeys.PREF_DANMAKU_TIP_SHOWED, DanmakuKeys.PREF_UNLOGIN_LIKE_TIP_SHOWED, Player.PREF_FULL_STORY_SHOW, DanmakuKeys.KEY_DANMAKU_REPORT_SHIELD_CHECKED, DanmakuKeys.KEY_DANMAKU_STROKE_WIDTH_SCALING, DanmakuKeys.KEY_DANMAKU_SUBTITLE_LARGE, DanmakuKeys.KEY_DANMAKU_SUBTITLE_DRAG, DanmakuKeys.KEY_DANMAKU_SUBTITLE_TIP_FIRST_TIME, DanmakuKeys.KEY_DANMAKU_MASK_SWITCH, Player.KEY_FORCE_LOGIN_TOAST, Player.KEY_LAST_SHOW_NETWORK_DIALOG_TIME, Player.KEY_LAST_SHOW_OPEN_FREE_TOAST_TIME, Player.KEY_SHOW_OPEN_FREE_TOAST_TIMES, Player.KEY_VIP_QUALITY_TRY_WATCHED_COUNT, Player.KEY_VIP_QUALITY_LAST_TRY_WATCH_TIME, Player.KEY_VIP_QUALITY_DISABLE_TRY_WATCH_BY_USER, Player.KEY_PLAY_ONLINE_SWITCH_HAS_CHANGED, Player.KEY_PLAY_ONLINE_SWITCH_VALUE});
    private static final List<String> sKeyInScopeVideoItem = CollectionsKt.listOf(new String[]{Player.KEY_FLIP_VIDEO_SELECTED, Player.KEY_PLAYER_ASPECT, DanmakuKeys.PREF_DANMAKU_SENT, DanmakuKeys.PREF_DANMAKU_RECOMMEND_BUBBLE_SHOW, DanmakuKeys.PREF_DANMAKU_SUPPORT_BOX_CHECKED_BY_USER, DanmakuKeys.PREF_DANMAKU_SUPPORT_BOX_CHECKED});
    private static final List<String> sKeyInScopeVideo = CollectionsKt.listOf(new String[]{Player.KEY_BGM_DYNAMIC_SHOWN_FULL, Player.KEY_BGM_DYNAMIC_SHOWN_HALF});
    private static final List<String> sKeyInScopePlayer = CollectionsKt.listOf(new String[]{Player.KEY_PLAYER_SPEED, Player.KEY_LOCKED_PLAYER_SPEED, Player.KEY_PLAY_QUALITY_USER_EXPECTED, Player.KEY_ENABLE_DANMAKU_LIST_ENTRACE, "key_background_play_alert_shown_count", DanmakuKeys.KEY_DANMAKU_SUBTITLE_LAN_MAIN, DanmakuKeys.KEY_DANMAKU_SUBTITLE_LAN_VICE, DanmakuKeys.KEY_DANMAKU_USER_CHANGED_BILINGUAL, DanmakuKeys.KEY_DANMAKU_SUBTITLE_SWITCH_ON, DanmakuKeys.KEY_DANMAKU_SUBTITLE_MULTI});
    private static final List<String> sKeyInScopeApp = CollectionsKt.emptyList();
    private static final List<String> sKeyInScopePersistent = CollectionsKt.listOf(new String[]{Player.KEY_ENABLE_SNAPSHOT_AND_GIF, Player.KEY_ENABLE_SIDE_RECOMMEND_VIDEO, Player.KEY_ENABLE_DOUBLE_FINGER_RESIZE, Player.KEY_SKIP_TITLES_ENDINGS, DanmakuKeys.PREF_DANMAKU_SWITCH_SAVE, DanmakuKeys.PREF_DANMAKU_SWITCH, DanmakuKeys.PREF_INLINE_DANMAKU_SWITCH, DanmakuKeys.PREF_DANMAKU_AI_RECOMMEND_SWITCH, DanmakuKeys.PREF_DANMAKU_AI_RECOMMEND_LEVEL, DanmakuKeys.PREF_DANMAKU_AI_RECOMMEND_LEVEL_V2, DanmakuKeys.PREF_DANMAKU_AI_RECOMMEND_LEVEL_MAP, DanmakuKeys.PREF_DANMAKU_BLOCKREPEAT, DanmakuKeys.PREF_DANMAKU_BLOCKTOP, DanmakuKeys.PREF_DANMAKU_BLOCKSCROLL, DanmakuKeys.PREF_DANMAKU_BLOCKBOTTOM, DanmakuKeys.PREF_DANMAKU_BLOCKCOLORFUL, DanmakuKeys.PREF_DANMAKU_BLOCKSPECIAL, DanmakuKeys.PREF_DANMAKU_OPACITY, DanmakuKeys.PREF_DANMAKU_SCALING_FACTOR, DanmakuKeys.PREF_DANMAKU_DOMAIN, DanmakuKeys.PREF_DANMAKU_SPEED, DanmakuKeys.PREF_DANMAKU_ENABLEBLOCKLIST, DanmakuKeys.PREF_DANMAKU_TIP_SHOWED, DanmakuKeys.PREF_UNLOGIN_LIKE_TIP_SHOWED, Player.PREF_FULL_STORY_SHOW, DanmakuKeys.KEY_DANMAKU_TEXT_STYLE, DanmakuKeys.KEY_DANMAKU_TEXT_STYLE_BOLD, DanmakuKeys.KEY_DANMAKU_REPORT_SHIELD_CHECKED, DanmakuKeys.KEY_DANMAKU_STROKE_WIDTH_SCALING, DanmakuKeys.KEY_DANMAKU_SUBTITLE_LARGE, DanmakuKeys.KEY_DANMAKU_SUBTITLE_DRAG, DanmakuKeys.KEY_DANMAKU_SUBTITLE_TIP_FIRST_TIME, Player.KEY_PLAY_COMPLETED_ACTION, Player.KEY_PLAY_QUALITY_USER_SETTING, Player.KEY_STORY_PLAY_QUALITY_USER_SETTING, Player.KEY_PLAY_QUALITY_AUTO_SWITCH, Player.KEY_STORY_PLAY_QUALITY_AUTO_SWITCH, Player.KEY_QUALITY_USER_SETTING_UNIFORM, Player.KEY_BACKGROUND_SELECTED, Player.PREF_KEY_PAYCOIN_IS_SYNC_LIKE, DanmakuKeys.KEY_DANMAKU_MASK_SWITCH, Player.KEY_FORCE_LOGIN_TOAST, Player.KEY_SPEED_4K_DIALOG_SHOW, Player.KEY_AUTO_ENTER_WHOLE_SCENE, Player.KEY_AUTO_OPEN_DOLBY, Player.KEY_LAST_SHOW_NETWORK_DIALOG_TIME, Player.KEY_LAST_SHOW_OPEN_FREE_TOAST_TIME, Player.KEY_SHOW_OPEN_FREE_TOAST_TIMES, Player.KEY_PLAY_RECORD_GIF_SWITCH, Player.KEY_PLAY_ONLINE_SWITCH_HAS_CHANGED, Player.KEY_PLAY_ONLINE_SWITCH_VALUE, DanmakuKeys.PREF_DANMAKU_FOLD, DanmakuKeys.PREF_DANMAKU_AVOID_SCRIPT, DanmakuKeys.PREF_DANMAKU_AVOID_FIGURE, DanmakuKeys.PREF_DANMAKU_BLOCKFIXED});

    public static final List<String> getSMainPlayerSettingKeys() {
        return EnhancedUnmodifiabilityKt.unmodifiable(sMainPlayerSettingKeys);
    }

    public static final List<String> getSBLKVKeys() {
        return EnhancedUnmodifiabilityKt.unmodifiable(sBLKVKeys);
    }

    public static final List<String> getSKeyInScopeVideoItem() {
        return EnhancedUnmodifiabilityKt.unmodifiable(sKeyInScopeVideoItem);
    }

    public static final List<String> getSKeyInScopeVideo() {
        return EnhancedUnmodifiabilityKt.unmodifiable(sKeyInScopeVideo);
    }

    public static final List<String> getSKeyInScopePlayer() {
        return EnhancedUnmodifiabilityKt.unmodifiable(sKeyInScopePlayer);
    }

    public static final List<String> getSKeyInScopeApp() {
        return EnhancedUnmodifiabilityKt.unmodifiable(sKeyInScopeApp);
    }

    public static final List<String> getSKeyInScopePersistent() {
        return EnhancedUnmodifiabilityKt.unmodifiable(sKeyInScopePersistent);
    }
}