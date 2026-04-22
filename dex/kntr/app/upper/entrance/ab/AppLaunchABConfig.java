package kntr.app.upper.entrance.ab;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* compiled from: AppLaunchABConfig.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u0007R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0007R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lkntr/app/upper/entrance/ab/AppLaunchABConfig;", "", "<init>", "()V", "PRE_ANALYSIS", "Lkntr/app/upper/entrance/ab/AppLaunchAB;", "getPRE_ANALYSIS", "()Lkntr/app/upper/entrance/ab/AppLaunchAB;", "CENTER_PLUS_BUBBLE", "getCENTER_PLUS_BUBBLE$annotations", "getCENTER_PLUS_BUBBLE", "CENTER_PLUS_BUBBLE_CHILD", "getCENTER_PLUS_BUBBLE_CHILD", "APP_LAUNCH_AB", "", "getAPP_LAUNCH_AB$entrance_debug", "()Ljava/util/List;", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AppLaunchABConfig {
    public static final AppLaunchABConfig INSTANCE = new AppLaunchABConfig();
    private static final AppLaunchAB PRE_ANALYSIS = new AppLaunchAB("upper_pre_analyse_experiment", CollectionsKt.listOf(new String[]{"a", "b"}), "a", "upper_pre_analyse_experiment", 0, null, 48, null);
    private static final AppLaunchAB CENTER_PLUS_BUBBLE = new AppLaunchAB("creatorgrowth_inspiration", CollectionsKt.listOf(new String[]{"0", "1"}), "0", "creatorgrowth_inspiration", 172800, CollectionsKt.listOf("1"));
    private static final AppLaunchAB CENTER_PLUS_BUBBLE_CHILD = new AppLaunchAB("creatorgrowth_inspiration_son2", CollectionsKt.listOf(new String[]{"0", "1"}), "0", "creatorgrowth_inspiration_son2", 172800, CollectionsKt.listOf("1"));
    private static final List<AppLaunchAB> APP_LAUNCH_AB = CollectionsKt.listOf(CENTER_PLUS_BUBBLE);

    public static /* synthetic */ void getCENTER_PLUS_BUBBLE$annotations() {
    }

    private AppLaunchABConfig() {
    }

    public final AppLaunchAB getPRE_ANALYSIS() {
        return PRE_ANALYSIS;
    }

    public final AppLaunchAB getCENTER_PLUS_BUBBLE() {
        return CENTER_PLUS_BUBBLE;
    }

    public final AppLaunchAB getCENTER_PLUS_BUBBLE_CHILD() {
        return CENTER_PLUS_BUBBLE_CHILD;
    }

    public final List<AppLaunchAB> getAPP_LAUNCH_AB$entrance_debug() {
        return APP_LAUNCH_AB;
    }
}