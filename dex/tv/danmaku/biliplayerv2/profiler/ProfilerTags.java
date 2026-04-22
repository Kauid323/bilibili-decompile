package tv.danmaku.biliplayerv2.profiler;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ProfilerTags.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Ltv/danmaku/biliplayerv2/profiler/ProfilerTags;", "", "<init>", "()V", "RESOLVE_PLAY_URL_FIRE", "", "SET_MEDIA_ITEM", "START_RESOLVE_PLAY_URL", "END_RESOLVE_PLAY_URL", "KEY_EXTRAS_QN", "KEY_EXTRAS_RESOLVE_TYPE", "KEY_EXTRAS_START_POSITION", "START_PLAY_PRELOAD", "START_PLAY_PRELOAD_NORMAL", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ProfilerTags {
    public static final String END_RESOLVE_PLAY_URL = "end_resolve_play_url";
    public static final ProfilerTags INSTANCE = new ProfilerTags();
    public static final String KEY_EXTRAS_QN = "key_extras_qn";
    public static final String KEY_EXTRAS_RESOLVE_TYPE = "key_extras_resolve_type";
    public static final String KEY_EXTRAS_START_POSITION = "key_extras_start_position";
    public static final String RESOLVE_PLAY_URL_FIRE = "resolve_play_url_fire";
    public static final String SET_MEDIA_ITEM = "set_media_item";
    public static final String START_PLAY_PRELOAD = "play_handler_start_play_from_preload";
    public static final String START_PLAY_PRELOAD_NORMAL = "play_handler_start_play_normal_resolver";
    public static final String START_RESOLVE_PLAY_URL = "start_resolve_play_url";

    private ProfilerTags() {
    }
}