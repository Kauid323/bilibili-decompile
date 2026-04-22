package tv.danmaku.bili.ui.main2.userprotocol;

import android.util.Log;
import com.bilibili.base.BiliContext;
import com.bilibili.commons.RandomUtils;
import com.bilibili.homepage.ExperimentGroup;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.util.CpuUtils;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.BuildConfig;

/* compiled from: UserProtocolExperiment.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\n\u001a\u00020\u000b*\u00020\fJ\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\fJ\b\u0010\u0018\u001a\u00020\u000bH\u0007J\b\u0010\u0019\u001a\u00020\u000bH\u0007J\b\u0010\u001a\u001a\u00020\u000bH\u0007J\b\u0010\u001b\u001a\u00020\u0005H\u0007J\b\u0010\u001c\u001a\u00020\u0005H\u0007J\b\u0010\u001d\u001a\u00020\u0016H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Ltv/danmaku/bili/ui/main2/userprotocol/UserProtocolExperiment;", "", "<init>", "()V", "TAG", "", "PRIVACY_SP_FILE_KEY", "DEFAULT_PRIVACY_SEED_KEY", "DEFAULT_PRIVACY_SEED_VALUE", "", "hit", "", "Lcom/bilibili/homepage/ExperimentGroup;", "mGroup", "mSeed", "bizReportData", "", "getBizReportData", "()Ljava/util/Map;", "setBizReportData", "(Ljava/util/Map;)V", "experiment", "", "getGroup", "hitSpecificBg", "hitVisitMode", "hitVipMode", "getSeed", "getGroupReportPageType", "reset", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class UserProtocolExperiment {
    private static Map<String, String> bizReportData;
    public static final UserProtocolExperiment INSTANCE = new UserProtocolExperiment();
    private static final String TAG = "UserExperimentTag";
    private static final String PRIVACY_SP_FILE_KEY = "privacy_file_sp";
    private static final String DEFAULT_PRIVACY_SEED_KEY = "privacy_seed";
    private static final int DEFAULT_PRIVACY_SEED_VALUE = -1;
    private static ExperimentGroup mGroup = ExperimentGroup.EXPERIMENT_NONE;
    private static int mSeed = -1;
    public static final int $stable = 8;

    private UserProtocolExperiment() {
    }

    public final boolean hit(ExperimentGroup $this$hit) {
        Intrinsics.checkNotNullParameter($this$hit, "<this>");
        return mGroup.getValue() == $this$hit.getValue();
    }

    public final Map<String, String> getBizReportData() {
        return bizReportData;
    }

    public final void setBizReportData(Map<String, String> map) {
        bizReportData = map;
    }

    public final void experiment() {
        int serverSeed;
        ExperimentGroup experimentGroup;
        if (!BuildConfig.DEBUG) {
            Log.e(TAG, "origin seed = " + mSeed);
            if (mSeed > -1) {
                Log.e(TAG, "seed reuse");
                serverSeed = mSeed;
            } else {
                serverSeed = CpuUtils.isX86(BiliContext.application()) ? -1 : RandomUtils.nextInt(100);
                Log.e(TAG, "seed = " + serverSeed);
            }
        } else {
            int random = RandomUtils.nextInt(100);
            Log.e(TAG, "this is debug mod, random is " + random);
            serverSeed = random;
        }
        mSeed = serverSeed;
        int i = mSeed;
        boolean z = true;
        if (i >= 0 && i < 2) {
            experimentGroup = ExperimentGroup.EXPERIMENT_GROUP_AA;
        } else {
            if (2 > i || i >= 100) {
                z = false;
            }
            if (z) {
                experimentGroup = ExperimentGroup.EXPERIMENT_GROUP_BB;
            } else {
                experimentGroup = ExperimentGroup.EXPERIMENT_GROUP_AA;
            }
        }
        mGroup = experimentGroup;
    }

    public final ExperimentGroup getGroup() {
        return mGroup;
    }

    @JvmStatic
    public static final boolean hitSpecificBg() {
        return (mGroup.getValue() == ExperimentGroup.EXPERIMENT_GROUP_AA.getValue() || mGroup.getValue() == ExperimentGroup.EXPERIMENT_NONE.getValue()) ? false : true;
    }

    @JvmStatic
    public static final boolean hitVisitMode() {
        return mGroup.getValue() == ExperimentGroup.EXPERIMENT_GROUP_BB.getValue() || mGroup.getValue() == ExperimentGroup.EXPERIMENT_GROUP_CC.getValue();
    }

    @JvmStatic
    public static final boolean hitVipMode() {
        return mGroup.getValue() == ExperimentGroup.EXPERIMENT_GROUP_CC.getValue();
    }

    @JvmStatic
    public static final String getSeed() {
        return mSeed >= 0 ? String.valueOf(mSeed) : "";
    }

    @JvmStatic
    public static final String getGroupReportPageType() {
        ExperimentGroup[] values;
        if (Intrinsics.areEqual(getSeed(), "")) {
            return "";
        }
        for (ExperimentGroup group : ExperimentGroup.values()) {
            if (group.getValue() == mGroup.getValue()) {
                return group.getDes();
            }
        }
        return "";
    }

    @JvmStatic
    public static final void reset() {
        mGroup = ExperimentGroup.EXPERIMENT_NONE;
        mSeed = -1;
    }
}