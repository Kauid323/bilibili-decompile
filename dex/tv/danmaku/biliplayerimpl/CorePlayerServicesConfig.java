package tv.danmaku.biliplayerimpl;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerimpl.controlcontainer.ControlContainerService;
import tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2;
import tv.danmaku.biliplayerimpl.functionwidget.FunctionWidgetService;
import tv.danmaku.biliplayerimpl.render.RenderContainerService;
import tv.danmaku.biliplayerimpl.report.DataReporterService;
import tv.danmaku.biliplayerimpl.report.heartbeat.HeartbeatService;
import tv.danmaku.biliplayerimpl.setting.PlayerSettingService;
import tv.danmaku.biliplayerimpl.toast.ToastService;
import tv.danmaku.biliplayerimpl.videodirector.PlayDirectorServiceV3;
import tv.danmaku.biliplayerimpl.videodirector.VideosPlayDirectorService;
import tv.danmaku.biliplayerv2.service.IPlayerService;
import tv.danmaku.biliplayerv2.service.PlayerServiceManager;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PlayerServiceManagerImpl.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020)J\u0012\u0010,\u001a\u00020-2\n\u0010/\u001a\u0006\u0012\u0002\b\u00030\u0005J\u0012\u0010,\u001a\u00020-2\n\u00100\u001a\u0006\u0012\u0002\b\u000301R\u0019\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u0019\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0019\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\bR\u0019\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR\u0019\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\bR\u0019\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00190\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\bR\u0019\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001c0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\bR\u0019\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001f0\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\bR\u0019\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020\"0\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\bR\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\bR\u001f\u0010'\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020)0\u00050(¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u00062"}, d2 = {"Ltv/danmaku/biliplayerimpl/CorePlayerServicesConfig;", "", "<init>", "()V", "Report_Service", "Ljava/lang/Class;", "Ltv/danmaku/biliplayerimpl/report/DataReporterService;", "getReport_Service", "()Ljava/lang/Class;", "Heartbeat_Service", "Ltv/danmaku/biliplayerimpl/report/heartbeat/HeartbeatService;", "getHeartbeat_Service", "Activity_State_Service", "Ltv/danmaku/biliplayerimpl/ActivityStateService;", "getActivity_State_Service", "Player_Setting_Service", "Ltv/danmaku/biliplayerimpl/setting/PlayerSettingService;", "getPlayer_Setting_Service", "Toast_Service", "Ltv/danmaku/biliplayerimpl/toast/ToastService;", "getToast_Service", "Function_Widget_Service", "Ltv/danmaku/biliplayerimpl/functionwidget/FunctionWidgetService;", "getFunction_Widget_Service", "Render_Container_Service", "Ltv/danmaku/biliplayerimpl/render/RenderContainerService;", "getRender_Container_Service", "Player_Core_Service", "Ltv/danmaku/biliplayerimpl/core/PlayerCoreServiceV2;", "getPlayer_Core_Service", "Controller_Service", "Ltv/danmaku/biliplayerimpl/controlcontainer/ControlContainerService;", "getController_Service", "Videos_Play_Director_Service", "Ltv/danmaku/biliplayerimpl/videodirector/VideosPlayDirectorService;", "getVideos_Play_Director_Service", "Play_Director_Service3", "Ltv/danmaku/biliplayerimpl/videodirector/PlayDirectorServiceV3;", "getPlay_Director_Service3", "sCorePlayerServices", "", "Ltv/danmaku/biliplayerv2/service/IPlayerService;", "getSCorePlayerServices", "()Ljava/util/List;", "isCoreService", "", "service", "clazz", "descriptor", "Ltv/danmaku/biliplayerv2/service/PlayerServiceManager$ServiceDescriptor;", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class CorePlayerServicesConfig {
    public static final CorePlayerServicesConfig INSTANCE = new CorePlayerServicesConfig();
    private static final Class<? extends DataReporterService> Report_Service = DataReporterService.class;
    private static final Class<? extends HeartbeatService> Heartbeat_Service = HeartbeatService.class;
    private static final Class<? extends ActivityStateService> Activity_State_Service = ActivityStateService.class;
    private static final Class<? extends PlayerSettingService> Player_Setting_Service = PlayerSettingService.class;
    private static final Class<? extends ToastService> Toast_Service = ToastService.class;
    private static final Class<? extends FunctionWidgetService> Function_Widget_Service = FunctionWidgetService.class;
    private static final Class<? extends RenderContainerService> Render_Container_Service = RenderContainerService.class;
    private static final Class<? extends PlayerCoreServiceV2> Player_Core_Service = PlayerCoreServiceV2.class;
    private static final Class<? extends ControlContainerService> Controller_Service = ControlContainerService.class;
    private static final Class<? extends VideosPlayDirectorService> Videos_Play_Director_Service = VideosPlayDirectorService.class;
    private static final Class<PlayDirectorServiceV3> Play_Director_Service3 = PlayDirectorServiceV3.class;
    private static final List<Class<? extends IPlayerService>> sCorePlayerServices = CollectionsKt.mutableListOf(new Class[]{Player_Setting_Service, Player_Core_Service, Heartbeat_Service, Report_Service, Activity_State_Service, Render_Container_Service, Toast_Service, Function_Widget_Service, Controller_Service, Videos_Play_Director_Service, Play_Director_Service3});

    private CorePlayerServicesConfig() {
    }

    public final Class<? extends DataReporterService> getReport_Service() {
        return Report_Service;
    }

    public final Class<? extends HeartbeatService> getHeartbeat_Service() {
        return Heartbeat_Service;
    }

    public final Class<? extends ActivityStateService> getActivity_State_Service() {
        return Activity_State_Service;
    }

    public final Class<? extends PlayerSettingService> getPlayer_Setting_Service() {
        return Player_Setting_Service;
    }

    public final Class<? extends ToastService> getToast_Service() {
        return Toast_Service;
    }

    public final Class<? extends FunctionWidgetService> getFunction_Widget_Service() {
        return Function_Widget_Service;
    }

    public final Class<? extends RenderContainerService> getRender_Container_Service() {
        return Render_Container_Service;
    }

    public final Class<? extends PlayerCoreServiceV2> getPlayer_Core_Service() {
        return Player_Core_Service;
    }

    public final Class<? extends ControlContainerService> getController_Service() {
        return Controller_Service;
    }

    public final Class<? extends VideosPlayDirectorService> getVideos_Play_Director_Service() {
        return Videos_Play_Director_Service;
    }

    public final Class<PlayDirectorServiceV3> getPlay_Director_Service3() {
        return Play_Director_Service3;
    }

    public final List<Class<? extends IPlayerService>> getSCorePlayerServices() {
        return sCorePlayerServices;
    }

    public final boolean isCoreService(IPlayerService service) {
        Intrinsics.checkNotNullParameter(service, "service");
        return sCorePlayerServices.contains(service.getClass());
    }

    public final boolean isCoreService(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return CollectionsKt.contains(sCorePlayerServices, cls);
    }

    public final boolean isCoreService(PlayerServiceManager.ServiceDescriptor<?> serviceDescriptor) {
        Intrinsics.checkNotNullParameter(serviceDescriptor, "descriptor");
        return CollectionsKt.contains(sCorePlayerServices, serviceDescriptor.getClazz());
    }
}