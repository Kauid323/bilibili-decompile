package kntr.base.appinfo;

import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;

/* compiled from: KPackageInfo.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001b\u0010\u0000\u001a\u00020\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"platformPackageInfo", "Lkntr/base/appinfo/IPackageInfo;", "getPlatformPackageInfo", "()Lkntr/base/appinfo/IPackageInfo;", "platformPackageInfo$delegate", "Lkotlin/Lazy;", "appinfo_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KPackageInfo_androidKt {
    private static final Lazy platformPackageInfo$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.appinfo.KPackageInfo_androidKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            IPackageInfo platformPackageInfo_delegate$lambda$0;
            platformPackageInfo_delegate$lambda$0 = KPackageInfo_androidKt.platformPackageInfo_delegate$lambda$0();
            return platformPackageInfo_delegate$lambda$0;
        }
    });

    public static final IPackageInfo getPlatformPackageInfo() {
        return (IPackageInfo) platformPackageInfo$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IPackageInfo platformPackageInfo_delegate$lambda$0() {
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        return ((PackageInfoEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(PackageInfoEntryPoint.class))).getPackageInfo();
    }
}