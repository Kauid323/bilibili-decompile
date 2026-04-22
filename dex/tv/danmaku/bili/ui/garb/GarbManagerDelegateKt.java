package tv.danmaku.bili.ui.garb;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import tv.danmaku.bili.BR;

/* compiled from: GarbManagerDelegate.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\n\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"THEME_WHITE", "", "THEME_NIGHT", "THEME_PINK", "THEME_RED", "THEME_YELLOW", "THEME_GREEN", "THEME_BLUE", "THEME_PURPLE", "BROADCAST_DATA_TYPE_GARB", "", "BROADCAST_DATA_TYPE_CARD_STYLE", "BROADCAST_DATA_TYPE_CLEAR_LAST_GARB", "COLOR_MAP", "", "TAG", "BUNDLE_BROADCAST_DATA_TYPE", "BUNDLE_GARB_DATA_KEY", "BUNDLE_THEME_CHANGE_SYNC_GARB_KEY", "BUNDLE_INDEX_CARD_STYLE", "BUNDLE_THEME_CHANGE_SYNC_FROM_MAIN_PROCESS", "BUNDLE_THEME_CHANGE_SHOULD_REPORT", "KEY_SWITCH_CLEAR_OP_CONFIG_ON_FETCH_GARB", "KEY_SWITCH_REGISTER_RETURN", "theme_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class GarbManagerDelegateKt {
    private static final int BROADCAST_DATA_TYPE_CARD_STYLE = 2;
    private static final int BROADCAST_DATA_TYPE_CLEAR_LAST_GARB = 3;
    private static final int BROADCAST_DATA_TYPE_GARB = 1;
    public static final String BUNDLE_BROADCAST_DATA_TYPE = "key_broadcast_data_type";
    public static final String BUNDLE_GARB_DATA_KEY = "key_garb_data";
    public static final String BUNDLE_INDEX_CARD_STYLE = "key_index_card_style";
    public static final String BUNDLE_THEME_CHANGE_SHOULD_REPORT = "key_theme_change_should_report";
    public static final String BUNDLE_THEME_CHANGE_SYNC_FROM_MAIN_PROCESS = "key_theme_change_sync_from_main_process";
    public static final String BUNDLE_THEME_CHANGE_SYNC_GARB_KEY = "key_theme_change_sync_garb";
    private static final String KEY_SWITCH_CLEAR_OP_CONFIG_ON_FETCH_GARB = "key_switch_clear_op_config_on_fetch_garb";
    private static final String KEY_SWITCH_REGISTER_RETURN = "key_switch_clear_op_config_on_fetch_garb";
    public static final String TAG = "main_garb";
    public static final String THEME_WHITE = "white";
    public static final String THEME_NIGHT = "black";
    public static final String THEME_PINK = "pink";
    public static final String THEME_RED = "red";
    public static final String THEME_YELLOW = "yellow";
    public static final String THEME_GREEN = "green";
    public static final String THEME_BLUE = "blue";
    public static final String THEME_PURPLE = "purple";
    private static final Map<String, Integer> COLOR_MAP = MapsKt.mapOf(new Pair[]{TuplesKt.to(THEME_WHITE, 8), TuplesKt.to(THEME_NIGHT, 1), TuplesKt.to(THEME_PINK, 2), TuplesKt.to(THEME_RED, 3), TuplesKt.to(THEME_YELLOW, 4), TuplesKt.to(THEME_GREEN, 5), TuplesKt.to(THEME_BLUE, 6), TuplesKt.to(THEME_PURPLE, 7)});

    public static final /* synthetic */ Map access$getCOLOR_MAP$p() {
        return COLOR_MAP;
    }
}