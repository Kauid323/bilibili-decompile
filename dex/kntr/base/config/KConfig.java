package kntr.base.config;

import com.bilibili.lib.gripper.api.GripperKt;
import com.bilibili.lib.gripper.api.ProducerContainer;
import com.bilibili.lib.gripper.api.SuspendProducer;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kntr.base.net.comm.redirect.RedirectImpKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: KConfig.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\tH\u0096\u0001¨\u0006\n"}, d2 = {"Lkntr/base/config/KConfig;", "Lkntr/base/config/IPlatformConfig;", "<init>", "()V", RedirectImpKt.REDIRECT_KV_CONFIG, "", "key", "defaultValue", "ff", "", "config_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KConfig implements IPlatformConfig {
    public static final KConfig INSTANCE = new KConfig();
    private final /* synthetic */ IPlatformConfig $$delegate_0;

    @Override // kntr.base.config.IPlatformConfig
    public String config(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.$$delegate_0.config(str, str2);
    }

    @Override // kntr.base.config.IPlatformConfig
    public boolean ff(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.$$delegate_0.ff(str, z);
    }

    private KConfig() {
        SuspendProducer suspendProducer = ProducerContainer.DefaultImpls.get$default(GripperKt.getGripper(Gripper_component_holder_androidKt.getRootGripperComponent()).getContainer(), Reflection.getOrCreateKotlinClass(IPlatformConfig.class), (String) null, 2, (Object) null);
        IPlatformConfig iPlatformConfig = suspendProducer != null ? (IPlatformConfig) suspendProducer.get() : null;
        Intrinsics.checkNotNull(iPlatformConfig);
        this.$$delegate_0 = iPlatformConfig;
    }
}