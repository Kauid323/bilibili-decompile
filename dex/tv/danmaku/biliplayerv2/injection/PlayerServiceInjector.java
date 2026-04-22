package tv.danmaku.biliplayerv2.injection;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.PlayerContainerKt;
import tv.danmaku.biliplayerv2.PlayerParamsV2;
import tv.danmaku.biliplayerv2.panel.IPanelContainer;
import tv.danmaku.biliplayerv2.service.AbsFunctionWidgetService;
import tv.danmaku.biliplayerv2.service.IActivityStateService;
import tv.danmaku.biliplayerv2.service.IControlContainerService;
import tv.danmaku.biliplayerv2.service.IPlayDirector;
import tv.danmaku.biliplayerv2.service.IPlayerCoreService;
import tv.danmaku.biliplayerv2.service.IPlayerService;
import tv.danmaku.biliplayerv2.service.IRenderContainerService;
import tv.danmaku.biliplayerv2.service.IToastService;
import tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService;
import tv.danmaku.biliplayerv2.service.PlayerServiceManager;
import tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService;
import tv.danmaku.biliplayerv2.service.report.IReporterService;
import tv.danmaku.biliplayerv2.service.report.heartbeat.IHeartbeatService;
import tv.danmaku.biliplayerv2.service.setting.IPlayerSettingService;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ServiceInjectorByPlayerContainer.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00012\u0006\u0010\t\u001a\u00020\n2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0002J\u0006\u0010\u0011\u001a\u00020\fR*\u0010\u0004\u001a\u001e\u0012\u0018\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Ltv/danmaku/biliplayerv2/injection/PlayerServiceInjector;", "", "<init>", "()V", "boundServices", "", "Lkotlin/Pair;", "Ltv/danmaku/biliplayerv2/service/PlayerServiceManager$ServiceDescriptor;", "Ltv/danmaku/biliplayerv2/service/PlayerServiceManager$Client;", "playerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "injectPlayerServices", "", "thisRef", "findCoreService", "clazz", "Ljava/lang/Class;", "release", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerServiceInjector {
    private List<? extends Pair<? extends PlayerServiceManager.ServiceDescriptor<?>, ? extends PlayerServiceManager.Client<?>>> boundServices;
    private PlayerContainer playerContainer;

    public final void injectPlayerServices(Object thisRef, PlayerContainer playerContainer) {
        Class realType;
        Field[] it;
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        ArrayList result = new ArrayList();
        ArrayList fieldList = new ArrayList();
        Field[] declaredFields = thisRef.getClass().getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "getDeclaredFields(...)");
        CollectionsKt.addAll(fieldList, declaredFields);
        Class fieldClazz = thisRef.getClass();
        while (true) {
            if ((fieldClazz != null ? fieldClazz.getSuperclass() : null) == null) {
                break;
            }
            Class<? super Object> superclass = fieldClazz.getSuperclass();
            if (superclass != null && (it = superclass.getDeclaredFields()) != null) {
                CollectionsKt.addAll(fieldList, it);
            }
            fieldClazz = fieldClazz.getSuperclass();
        }
        Iterator it2 = fieldList.iterator();
        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
        while (it2.hasNext()) {
            Object next = it2.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            Field field = (Field) next;
            if (field.isAnnotationPresent(InjectPlayerService.class)) {
                field.setAccessible(true);
                Class type = field.getType();
                try {
                    Intrinsics.checkNotNull(type);
                    Object coreService = findCoreService(playerContainer, type);
                    if (coreService != null) {
                        field.set(thisRef, coreService);
                    } else if (!IPlayerService.class.isAssignableFrom(type)) {
                        throw new ClassCastException(type + " does not implement of IPlayerService.");
                    } else {
                        if (Modifier.isAbstract(type.getModifiers())) {
                            Iterable allStartedService = playerContainer.getPlayerServiceManager().getAllStartedService();
                            Intrinsics.checkNotNull(allStartedService);
                            Iterable $this$first$iv = allStartedService;
                            for (Object element$iv : $this$first$iv) {
                                if (type.isAssignableFrom((Class) element$iv)) {
                                    realType = (Class) element$iv;
                                }
                            }
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        }
                        realType = type;
                        PlayerServiceManager.ServiceDescriptor descriptor = PlayerServiceManager.ServiceDescriptor.Companion.obtain(realType);
                        PlayerServiceManager.Client client = new PlayerServiceManager.Client();
                        playerContainer.getPlayerServiceManager().bindService(descriptor, client);
                        result.add(TuplesKt.to(descriptor, client));
                        field.set(thisRef, client.getService());
                    }
                } catch (Exception e) {
                    throw new IllegalArgumentException("Service lookup failed for type " + type + " in " + thisRef, e);
                }
            }
        }
        this.boundServices = result;
        this.playerContainer = playerContainer;
    }

    private final Object findCoreService(PlayerContainer playerContainer, Class<?> cls) {
        if (Intrinsics.areEqual(cls, IActivityStateService.class)) {
            return playerContainer.getActivityStateService();
        }
        if (Intrinsics.areEqual(cls, IControlContainerService.class)) {
            return playerContainer.getControlContainerService();
        }
        if (Intrinsics.areEqual(cls, AbsFunctionWidgetService.class)) {
            return playerContainer.getFunctionWidgetService();
        }
        if (Intrinsics.areEqual(cls, IInteractLayerService.class)) {
            return playerContainer.getInteractLayerService();
        }
        if (Intrinsics.areEqual(cls, IPlayerCoreService.class)) {
            return playerContainer.getPlayerCoreService();
        }
        if (Intrinsics.areEqual(cls, IPlayerSettingService.class)) {
            return playerContainer.getPlayerSettingService();
        }
        if (Intrinsics.areEqual(cls, IRenderContainerService.class)) {
            return playerContainer.getRenderContainerService();
        }
        if (Intrinsics.areEqual(cls, IReporterService.class)) {
            return playerContainer.getReporterService();
        }
        if (Intrinsics.areEqual(cls, IToastService.class)) {
            return playerContainer.getToastService();
        }
        if (Intrinsics.areEqual(cls, IVideosPlayDirectorService.class)) {
            return playerContainer.getVideoPlayDirectorService();
        }
        if (Intrinsics.areEqual(cls, IHeartbeatService.class)) {
            return playerContainer.getHeartbeatService();
        }
        if (Intrinsics.areEqual(cls, Context.class)) {
            return playerContainer.getContext();
        }
        if (Intrinsics.areEqual(cls, LifecycleOwner.class)) {
            IPanelContainer panelContainer = playerContainer.getPanelContainer();
            Intrinsics.checkNotNull(panelContainer);
            return ViewTreeLifecycleOwner.get(panelContainer.getView());
        } else if (Intrinsics.areEqual(cls, IPlayDirector.class)) {
            return PlayerContainerKt.getPlayDirector(playerContainer);
        } else {
            if (Intrinsics.areEqual(cls, PlayerParamsV2.class)) {
                return playerContainer.getPlayerParams();
            }
            return null;
        }
    }

    public final void release() {
        PlayerContainer playerContainer;
        List boundServices = this.boundServices;
        if (boundServices == null || (playerContainer = this.playerContainer) == null) {
            return;
        }
        for (Pair<? extends PlayerServiceManager.ServiceDescriptor<?>, ? extends PlayerServiceManager.Client<?>> pair : boundServices) {
            PlayerServiceManager.ServiceDescriptor client = (PlayerServiceManager.ServiceDescriptor) pair.component1();
            PlayerServiceManager.Client descriptor = (PlayerServiceManager.Client) pair.component2();
            playerContainer.getPlayerServiceManager().unbindService(client, descriptor);
        }
        this.boundServices = null;
        this.playerContainer = null;
    }
}