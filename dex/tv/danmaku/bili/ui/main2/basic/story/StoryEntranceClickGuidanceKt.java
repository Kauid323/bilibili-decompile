package tv.danmaku.bili.ui.main2.basic.story;

import android.app.Application;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: StoryEntranceClickGuidance.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u0006\u0010\b\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"isGuidanceShown", "", "MAX_SHOW_TIMES", "", StoryEntranceClickGuidanceKt.SP_HOME_STORY_ENTRANCE_SHOW_TIMES, "", StoryEntranceClickGuidanceKt.SP_HOME_STORY_INDEPENDENT_GUIDANCE_SHOW, "canShowGuidance", "canShowIndependentGuidance", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class StoryEntranceClickGuidanceKt {
    private static final int MAX_SHOW_TIMES = 3;
    private static final String SP_HOME_STORY_ENTRANCE_SHOW_TIMES = "SP_HOME_STORY_ENTRANCE_SHOW_TIMES";
    private static final String SP_HOME_STORY_INDEPENDENT_GUIDANCE_SHOW = "SP_HOME_STORY_INDEPENDENT_GUIDANCE_SHOW";
    private static boolean isGuidanceShown;

    public static final /* synthetic */ void access$setGuidanceShown$p(boolean z) {
        isGuidanceShown = z;
    }

    public static final boolean canShowGuidance() {
        Application ctx = BiliContext.application();
        if (ctx == null) {
            return false;
        }
        int showTimes = BiliGlobalPreferenceHelper.getBLKVSharedPreference(ctx).getInt(SP_HOME_STORY_ENTRANCE_SHOW_TIMES, 0);
        return !isGuidanceShown && showTimes < 3;
    }

    public static final boolean canShowIndependentGuidance() {
        Application ctx = BiliContext.application();
        if (ctx == null) {
            return false;
        }
        boolean shown = BiliGlobalPreferenceHelper.getBLKVSharedPreference(ctx).getBoolean(SP_HOME_STORY_INDEPENDENT_GUIDANCE_SHOW, false);
        return !shown;
    }
}