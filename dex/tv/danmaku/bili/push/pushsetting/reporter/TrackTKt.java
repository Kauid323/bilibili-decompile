package tv.danmaku.bili.push.pushsetting.reporter;

import android.app.Activity;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.neuron.api.Neurons;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: TrackT.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u001a\u0018\u0010\u0006\u001a\u00020\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"reportTrackT", "", "eventType", "", "extension", "", "reportOldDialogInvoke", "showFrom", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class TrackTKt {
    public static /* synthetic */ void reportTrackT$default(String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        reportTrackT(str, map);
    }

    public static final void reportTrackT(String eventType, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        if (!ConfigManager.Companion.isHitFF("push_guidance_custom_reporter_enable")) {
            return;
        }
        Map map2 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("event_type", eventType)});
        if (map != null) {
            map2.putAll(map);
        }
        Neurons.trackT$default(false, "push.guidance.custom.reporter", map2, 0, (Function0) null, 24, (Object) null);
    }

    public static final void reportOldDialogInvoke(String showFrom, Activity activity) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("show_from", showFrom == null ? "" : showFrom);
        pairArr[1] = TuplesKt.to(AudioIntentHelper.FROM_ACTIVITY, activity.getClass().getSimpleName());
        reportTrackT("old_dialog_invoke", MapsKt.mapOf(pairArr));
    }
}