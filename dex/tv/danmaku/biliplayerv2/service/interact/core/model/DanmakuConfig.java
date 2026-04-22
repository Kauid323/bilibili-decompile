package tv.danmaku.biliplayerv2.service.interact.core.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: DanmakuConfig.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001$B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/core/model/DanmakuConfig;", "", "<init>", "()V", "COMMENT_TYPE_FLY_TO_LEFT", "", "COMMENT_TYPE_BOTTOM", "COMMENT_TYPE_TOP", "COMMENT_TYPE_FLY_TO_RIGHT", "COMMENT_TYPE_ABSOLUTE", "COMMENT_TYPE_SCRIPT", "COLOR_DEFAULT", "TEXT_SIZE_SMALL", "TEXT_SIZE_MEDIUM", "DANMAKU_TEXT_STYLE_DEFAULT", "DANMAKU_TEXTSIZE_SCALE_FACTOR_MIN", "", "DANMAKU_TEXTSIZE_SCALE_FACTOR_DEFAULT", "DANMAKU_TEXTSIZE_SCALE_FACTOR_MAX", "DANMAKU_STROKE_WIDTH_SCALING_DEFAULT", "DANMAKU_DURATION_DEFAULT", "DANMAKU_ALPHA_FACTOR_MIN", "DANMAKU_ALPHA_FACTOR_DEFAULT", "DANMAKU_ALPHA_FACTOR_MAX", "DANMAKU_SCREEN_DOMAIN_FULL", "DANMAKU_SCREEN_DOMAIN_CLOCK_12", "DANMAKU_SCREEN_DOMAIN_CLOCK_9", "DANMAKU_SCREEN_DOMAIN_CLOCK_6", "DANMAKU_SCREEN_DOMAIN_CLOCK_3", "DANMAKU_SCREEN_DOMAIN_UNKNOWN", "DANMAKU_SUBTITLE_LAN_NODISPLAY", "", "DANMAKU_DISPLAY_DOMAIN_DEFAULT", "DANMAKU_DENSITY_DEFAULT", "DANMAKU_SUBTITLE_LAN_MAIN_DEFAULT", "DANMAKU_BLOCK_LEVEL_DEFAULT", "DanmakuOptionName", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DanmakuConfig {
    public static final int COLOR_DEFAULT = 16777215;
    public static final int COMMENT_TYPE_ABSOLUTE = 7;
    public static final int COMMENT_TYPE_BOTTOM = 4;
    public static final int COMMENT_TYPE_FLY_TO_LEFT = 1;
    public static final int COMMENT_TYPE_FLY_TO_RIGHT = 6;
    public static final int COMMENT_TYPE_SCRIPT = 8;
    public static final int COMMENT_TYPE_TOP = 5;
    public static final float DANMAKU_ALPHA_FACTOR_DEFAULT = 1.0f;
    public static final float DANMAKU_ALPHA_FACTOR_MAX = 1.0f;
    public static final float DANMAKU_ALPHA_FACTOR_MIN = 0.2f;
    public static final int DANMAKU_BLOCK_LEVEL_DEFAULT = -1;
    public static final int DANMAKU_DENSITY_DEFAULT = 0;
    public static final float DANMAKU_DISPLAY_DOMAIN_DEFAULT = 0.25f;
    public static final float DANMAKU_DURATION_DEFAULT = 8.0f;
    public static final float DANMAKU_SCREEN_DOMAIN_CLOCK_12 = 1.0f;
    public static final float DANMAKU_SCREEN_DOMAIN_CLOCK_3 = 0.25f;
    public static final float DANMAKU_SCREEN_DOMAIN_CLOCK_6 = 0.5f;
    public static final float DANMAKU_SCREEN_DOMAIN_CLOCK_9 = 0.75f;
    public static final float DANMAKU_SCREEN_DOMAIN_FULL = 2.0f;
    public static final float DANMAKU_SCREEN_DOMAIN_UNKNOWN = 0.0f;
    public static final float DANMAKU_STROKE_WIDTH_SCALING_DEFAULT = 0.8f;
    public static final String DANMAKU_SUBTITLE_LAN_MAIN_DEFAULT = "main_subtitle_default";
    public static final String DANMAKU_SUBTITLE_LAN_NODISPLAY = "nodisplay";
    public static final float DANMAKU_TEXTSIZE_SCALE_FACTOR_DEFAULT = 1.0f;
    public static final float DANMAKU_TEXTSIZE_SCALE_FACTOR_MAX = 2.0f;
    public static final float DANMAKU_TEXTSIZE_SCALE_FACTOR_MIN = 0.5f;
    public static final int DANMAKU_TEXT_STYLE_DEFAULT = -1;
    public static final DanmakuConfig INSTANCE = new DanmakuConfig();
    public static final int TEXT_SIZE_MEDIUM = 25;
    public static final int TEXT_SIZE_SMALL = 18;

    /* compiled from: DanmakuConfig.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0018\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/core/model/DanmakuConfig$DanmakuOptionName;", "", "<init>", "(Ljava/lang/String;I)V", "BLOCK_TOP", "BLOCK_SCROLL", "BLOCK_BOTTOM", "BLOCK_USER", "BLOCK_COLORFUL", "BLOCK_SPECIAL", "DUPLICATE_MERGING", "SCROLL_DURATION_FACTOR", "TRANSPARENCY", "TEXTSIZE_SCALE", "DANMAKU_RECOMMAND", "BLOCK_DANMAKU_ON_SCREEN", "SCREEN_DOMAIN", "DANMAKU_SENIOR_MODE", "DANMUKU_FOLD", "DISPLAY_DOMAIN", "DENSITY", "AVOID_SCRIPT", "AVOID_FIGURE", "BLOCK_FIXED", "BLACK_WORDS", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum DanmakuOptionName {
        BLOCK_TOP,
        BLOCK_SCROLL,
        BLOCK_BOTTOM,
        BLOCK_USER,
        BLOCK_COLORFUL,
        BLOCK_SPECIAL,
        DUPLICATE_MERGING,
        SCROLL_DURATION_FACTOR,
        TRANSPARENCY,
        TEXTSIZE_SCALE,
        DANMAKU_RECOMMAND,
        BLOCK_DANMAKU_ON_SCREEN,
        SCREEN_DOMAIN,
        DANMAKU_SENIOR_MODE,
        DANMUKU_FOLD,
        DISPLAY_DOMAIN,
        DENSITY,
        AVOID_SCRIPT,
        AVOID_FIGURE,
        BLOCK_FIXED,
        BLACK_WORDS;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<DanmakuOptionName> getEntries() {
            return $ENTRIES;
        }
    }

    private DanmakuConfig() {
    }
}