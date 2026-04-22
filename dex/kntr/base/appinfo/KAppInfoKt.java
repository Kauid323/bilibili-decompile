package kntr.base.appinfo;

import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;

/* compiled from: KAppInfo.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001b\u0010\u0000\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"platformAppInfo", "Lkntr/base/appinfo/IAppInfo;", "getPlatformAppInfo", "()Lkntr/base/appinfo/IAppInfo;", "platformAppInfo$delegate", "Lkotlin/Lazy;", "appinfo_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KAppInfoKt {
    private static final Lazy platformAppInfo$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.appinfo.KAppInfoKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            IAppInfo platformAppInfo_delegate$lambda$0;
            platformAppInfo_delegate$lambda$0 = KAppInfoKt.platformAppInfo_delegate$lambda$0();
            return platformAppInfo_delegate$lambda$0;
        }
    });

    public static final /* synthetic */ IAppInfo access$getPlatformAppInfo() {
        return getPlatformAppInfo();
    }

    public static final IAppInfo getPlatformAppInfo() {
        return (IAppInfo) platformAppInfo$delegate.getValue();
    }

    public static final IAppInfo platformAppInfo_delegate$lambda$0() {
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        return ((AppInfoEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(AppInfoEntryPoint.class))).getAppInfo();
    }
}