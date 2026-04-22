package tv.danmaku.bili.ui.main2.reporter;

import com.bilibili.lib.neuron.api.Neurons;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import tv.danmaku.bili.BR;

/* compiled from: WatchLaterReporter.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010\t\u001a\u00020\u0005H\u0007J\b\u0010\n\u001a\u00020\u0005H\u0007J\b\u0010\u000b\u001a\u00020\u0005H\u0007J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000eH\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/main2/reporter/WatchLaterReporter;", "", "<init>", "()V", "reportWatchLaterCardClickEvent", "", "avid", "", "reportWatchLaterCardLongPressEvent", "reportWatchLaterMenuClickEvent", "reportWatchLaterManageEvent", "reportWatchLaterClearEvent", "reportWatchLaterSelectAllEvent", "action", "", "reportWatchLaterDeleteEvent", "num", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class WatchLaterReporter {
    public static final int $stable = 0;
    public static final WatchLaterReporter INSTANCE = new WatchLaterReporter();

    private WatchLaterReporter() {
    }

    @JvmStatic
    public static final void reportWatchLaterCardClickEvent(long avid) {
        Map $this$reportWatchLaterCardClickEvent_u24lambda_u240 = new LinkedHashMap();
        $this$reportWatchLaterCardClickEvent_u24lambda_u240.put("avid", String.valueOf(avid));
        Unit unit = Unit.INSTANCE;
        Neurons.reportClick(false, "main.later-watch.video-card.0.click", $this$reportWatchLaterCardClickEvent_u24lambda_u240);
    }

    @JvmStatic
    public static final void reportWatchLaterCardLongPressEvent(long avid) {
        Map $this$reportWatchLaterCardLongPressEvent_u24lambda_u240 = new LinkedHashMap();
        $this$reportWatchLaterCardLongPressEvent_u24lambda_u240.put("avid", String.valueOf(avid));
        Unit unit = Unit.INSTANCE;
        Neurons.reportClick(false, "main.later-watch.video-card.long-press.click", $this$reportWatchLaterCardLongPressEvent_u24lambda_u240);
    }

    @JvmStatic
    public static final void reportWatchLaterMenuClickEvent() {
        Neurons.reportClick$default(false, "main.later-watch.more-option.0.click", (Map) null, 4, (Object) null);
    }

    @JvmStatic
    public static final void reportWatchLaterManageEvent() {
        Map $this$reportWatchLaterManageEvent_u24lambda_u240 = new LinkedHashMap();
        $this$reportWatchLaterManageEvent_u24lambda_u240.put("option", "1");
        Unit unit = Unit.INSTANCE;
        Neurons.reportClick(false, "main.later-watch.more-option.all.click", $this$reportWatchLaterManageEvent_u24lambda_u240);
    }

    @JvmStatic
    public static final void reportWatchLaterClearEvent() {
        Map $this$reportWatchLaterClearEvent_u24lambda_u240 = new LinkedHashMap();
        $this$reportWatchLaterClearEvent_u24lambda_u240.put("option", "2");
        Unit unit = Unit.INSTANCE;
        Neurons.reportClick(false, "main.later-watch.more-option.all.click", $this$reportWatchLaterClearEvent_u24lambda_u240);
    }

    @JvmStatic
    public static final void reportWatchLaterSelectAllEvent(int action) {
        Map $this$reportWatchLaterSelectAllEvent_u24lambda_u240 = new LinkedHashMap();
        $this$reportWatchLaterSelectAllEvent_u24lambda_u240.put("action", String.valueOf(action));
        Unit unit = Unit.INSTANCE;
        Neurons.reportClick(false, "main.later-watch.editor.selectall.click", $this$reportWatchLaterSelectAllEvent_u24lambda_u240);
    }

    @JvmStatic
    public static final void reportWatchLaterDeleteEvent(int num) {
        Map $this$reportWatchLaterDeleteEvent_u24lambda_u240 = new LinkedHashMap();
        $this$reportWatchLaterDeleteEvent_u24lambda_u240.put("num", String.valueOf(num));
        Unit unit = Unit.INSTANCE;
        Neurons.reportClick(false, "main.later-watch.editor.delete.click", $this$reportWatchLaterDeleteEvent_u24lambda_u240);
    }
}