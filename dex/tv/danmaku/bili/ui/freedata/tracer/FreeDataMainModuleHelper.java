package tv.danmaku.bili.ui.freedata.tracer;

import com.bilibili.lib.config.BLRemoteConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: FreeDataMainModuleHelper.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Ltv/danmaku/bili/ui/freedata/tracer/FreeDataMainModuleHelper;", "", "<init>", "()V", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FreeDataMainModuleHelper {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);

    /* compiled from: FreeDataMainModuleHelper.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0007¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/ui/freedata/tracer/FreeDataMainModuleHelper$Companion;", "", "<init>", "()V", "enableUnicomUpgrade", "", "getConfigInt", "", "key", "", "def", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final boolean enableUnicomUpgrade() {
            return getConfigInt("unicomcard_upgrade", 0) == 1;
        }

        @JvmStatic
        public final int getConfigInt(String key, int def) {
            Intrinsics.checkNotNullParameter(key, "key");
            try {
                return BLRemoteConfig.getInstance().getInt(key, def);
            } catch (NumberFormatException e) {
                return def;
            }
        }
    }

    @JvmStatic
    public static final boolean enableUnicomUpgrade() {
        return Companion.enableUnicomUpgrade();
    }

    @JvmStatic
    public static final int getConfigInt(String key, int def) {
        return Companion.getConfigInt(key, def);
    }
}