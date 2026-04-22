package tv.danmaku.bili.ui.splash.event;

import com.bilibili.lib.neuron.api.Neurons;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.splash.SplashAdHelper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: Reporter.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0012\u0010\b\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0000\u001a\u001a\u0010\t\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a\u001a\u0010\f\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001a\u001a\u0010\u000f\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001a\u00020\u000eH\u0000\u001a\u0010\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\"\u0018\u0010\u0004\u001a\u00020\u0005*\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"reportEventSplashShow", "", "splashData", "Ltv/danmaku/bili/ui/splash/event/EventSplashData;", "reportTypeName", "", "getReportTypeName", "(Ltv/danmaku/bili/ui/splash/event/EventSplashData;)Ljava/lang/String;", "reportInteractAction", "reportJumpActionClick", "action", "Ltv/danmaku/bili/ui/splash/event/Action;", "reportSkipClick", "isActionSkip", "", "reportCountDownExit", "isActionCountDownTrigger", "reportEventSplashIllegalWidth", "fragment", "Ltv/danmaku/bili/ui/splash/event/EventSplashFragment;", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ReporterKt {
    public static final void reportEventSplashShow(EventSplashData splashData) {
        Intrinsics.checkNotNullParameter(splashData, "splashData");
        Map $this$reportEventSplashShow_u24lambda_u240 = MapsKt.toMutableMap(MapsKt.mapOf(new Pair[]{TuplesKt.to("eventsplash_id", String.valueOf(splashData.getId())), TuplesKt.to("eventsplash_type", getReportTypeName(splashData))}));
        if (splashData.getEventType() == 0) {
            $this$reportEventSplashShow_u24lambda_u240.put("birthday_splash_type", splashData.isLocalBirthData() ? "1" : "2");
        }
        Unit unit = Unit.INSTANCE;
        Neurons.reportExposure$default(false, "main.eventsplash.load.user.show", $this$reportEventSplashShow_u24lambda_u240, (List) null, 8, (Object) null);
        SplashAdHelper.INSTANCE.adReportEventSplashExposed(splashData);
    }

    private static final String getReportTypeName(EventSplashData $this$reportTypeName) {
        return String.valueOf($this$reportTypeName.getEventType());
    }

    public static final void reportInteractAction(EventSplashData splashData) {
        if (splashData == null) {
            return;
        }
        Neurons.reportClick(false, "main.eventsplash.load.user-interact.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("eventsplash_id", String.valueOf(splashData.getId())), TuplesKt.to("eventsplash_type", getReportTypeName(splashData))}));
    }

    public static final void reportJumpActionClick(EventSplashData splashData, Action action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (splashData == null) {
            return;
        }
        Neurons.reportClick(false, "main.eventsplash.load.user-jump.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("eventsplash_id", String.valueOf(splashData.getId())), TuplesKt.to("eventsplash_type", getReportTypeName(splashData)), TuplesKt.to("eventsplash_jumpurl", action.getJumpUrl())}));
    }

    public static final void reportSkipClick(EventSplashData splashData, boolean isActionSkip) {
        if (splashData == null) {
            return;
        }
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("eventsplash_id", String.valueOf(splashData.getId()));
        pairArr[1] = TuplesKt.to("eventsplash_type", getReportTypeName(splashData));
        pairArr[2] = TuplesKt.to("skip_type", isActionSkip ? "eventsplash_interactskip" : "eventsplash_endskip");
        Neurons.reportClick(false, "main.eventsplash.load.user-skip.click", MapsKt.mapOf(pairArr));
    }

    public static final void reportCountDownExit(EventSplashData splashData, boolean isActionCountDownTrigger) {
        if (splashData == null) {
            return;
        }
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("eventsplash_id", String.valueOf(splashData.getId()));
        pairArr[1] = TuplesKt.to("eventsplash_type", getReportTypeName(splashData));
        pairArr[2] = TuplesKt.to("countdown_close_type", isActionCountDownTrigger ? "eventsplash_interactcountdownend" : "eventsplash_countdownend");
        Neurons.report$default(false, 0, "main.eventsplash.load.user-countdownend.other", MapsKt.mapOf(pairArr), (String) null, 0, 48, (Object) null);
    }

    public static final void reportEventSplashIllegalWidth(EventSplashFragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("is_added", String.valueOf(fragment.isAdded()));
        pairArr[1] = TuplesKt.to("view_alive", String.valueOf(fragment.getView() != null));
        Neurons.trackT$default(false, "splash.track.event.splash.sizetrack", MapsKt.mapOf(pairArr), 0, new Function0() { // from class: tv.danmaku.bili.ui.splash.event.ReporterKt$$ExternalSyntheticLambda0
            public final Object invoke() {
                boolean reportEventSplashIllegalWidth$lambda$0;
                reportEventSplashIllegalWidth$lambda$0 = ReporterKt.reportEventSplashIllegalWidth$lambda$0();
                return Boolean.valueOf(reportEventSplashIllegalWidth$lambda$0);
            }
        }, 8, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean reportEventSplashIllegalWidth$lambda$0() {
        return true;
    }
}