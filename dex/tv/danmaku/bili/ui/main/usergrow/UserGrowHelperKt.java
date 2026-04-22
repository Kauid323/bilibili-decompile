package tv.danmaku.bili.ui.main.usergrow;

import android.text.TextUtils;
import com.bilibili.lib.config.BLRemoteConfig;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: UserGrowHelper.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u001a\b\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\b\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\b\u0010\u0006\u001a\u00020\u0001H\u0000\u001a\b\u0010\u0007\u001a\u00020\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\tX\u0080T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"PATTERN_STR", "", "PATTERN_SHARE_WORD_DEFAULT", "getUserGrowExPattern", "Ljava/util/regex/Pattern;", "getFissionWordRegex", "getShareWordRegex", "getShareWordPattern", "DIALOG_VIEW_TYPE", "", "PAGE_VIEW_TYPE", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class UserGrowHelperKt {
    public static final int DIALOG_VIEW_TYPE = 0;
    public static final int PAGE_VIEW_TYPE = 1;
    private static final String PATTERN_SHARE_WORD_DEFAULT = "b23\\$([0-9a-zA-Z]{6,8})\\$";
    private static final String PATTERN_STR = "(GHA|gha)[0-9a-zA-Z]{7}";

    public static final Pattern getUserGrowExPattern() {
        try {
            Pattern compile = Pattern.compile(BLRemoteConfig.getInstance().getString("fission_code_reg", PATTERN_STR), 2);
            Intrinsics.checkNotNull(compile);
            return compile;
        } catch (Exception e) {
            Pattern compile2 = Pattern.compile(PATTERN_STR, 2);
            Intrinsics.checkNotNullExpressionValue(compile2, "compile(...)");
            return compile2;
        }
    }

    public static final String getFissionWordRegex() {
        String it = BLRemoteConfig.getInstance().getString("fission_code_reg", PATTERN_STR);
        if (it != null) {
            if (TextUtils.isEmpty(it)) {
                it = null;
            }
            return it == null ? PATTERN_STR : it;
        }
        return PATTERN_STR;
    }

    public static final String getShareWordRegex() {
        String it = BLRemoteConfig.getInstance().getString("share_word_reg", PATTERN_SHARE_WORD_DEFAULT);
        if (it != null) {
            if (TextUtils.isEmpty(it)) {
                it = null;
            }
            return it == null ? PATTERN_SHARE_WORD_DEFAULT : it;
        }
        return PATTERN_SHARE_WORD_DEFAULT;
    }

    public static final Pattern getShareWordPattern() {
        try {
            Pattern compile = Pattern.compile(BLRemoteConfig.getInstance().getString("share_word_reg", PATTERN_SHARE_WORD_DEFAULT), 2);
            Intrinsics.checkNotNull(compile);
            return compile;
        } catch (Exception e) {
            Pattern compile2 = Pattern.compile(PATTERN_SHARE_WORD_DEFAULT, 2);
            Intrinsics.checkNotNullExpressionValue(compile2, "compile(...)");
            return compile2;
        }
    }
}