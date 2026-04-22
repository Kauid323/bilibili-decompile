package tv.danmaku.bili.moss.restriction;

import com.bapis.bilibili.metadata.restriction.ModeType;
import com.bapis.bilibili.metadata.restriction.Restriction;
import com.bilibili.app.comm.restrict.RestrictedMode;
import com.bilibili.app.comm.restrict.RestrictedType;
import com.bilibili.app.comm.restrict.utils.TeenagersModeKt;
import com.bilibili.recommendmode.RecommendMode;
import com.bilibili.teenagersmode.TeenagersMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: RestrictionMode.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/moss/restriction/RestrictionMode;", "", "<init>", "()V", "restriction", "Lcom/bapis/bilibili/metadata/restriction/Restriction;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class RestrictionMode {
    public static final int $stable = 0;
    public static final RestrictionMode INSTANCE = new RestrictionMode();

    private RestrictionMode() {
    }

    public final Restriction restriction() {
        ModeType mode;
        boolean isTeenagersEnable = TeenagersMode.getInstance().isEnable();
        boolean isLessonsModeEnable = RestrictedMode.INSTANCE.isSingleEnable(RestrictedType.LESSONS);
        if (isTeenagersEnable) {
            mode = ModeType.TEENAGERS;
        } else {
            mode = isLessonsModeEnable ? ModeType.LESSONS : ModeType.NORMAL;
        }
        Restriction build = Restriction.newBuilder().setTeenagersMode(isTeenagersEnable).setLessonsMode(isLessonsModeEnable).setDisableRcmd(!RecommendMode.isRecommendModeEnable()).setTeenagersAge(TeenagersModeKt.getTeenagerAge()).setMode(mode).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }
}