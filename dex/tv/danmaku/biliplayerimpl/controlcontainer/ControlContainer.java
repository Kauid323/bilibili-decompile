package tv.danmaku.biliplayerimpl.controlcontainer;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewGroupKt;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import tv.danmaku.biliplayerimpl.BuildConfig;
import tv.danmaku.biliplayerv2.ControlContainerConfig;
import tv.danmaku.biliplayerv2.ControlContainerType;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.PlayerContainerCoroutineKt;
import tv.danmaku.biliplayerv2.ScreenModeType;
import tv.danmaku.biliplayerv2.injection.PlayerServiceInjector;
import tv.danmaku.biliplayerv2.panel.IVideoInsetChangedObserver;
import tv.danmaku.biliplayerv2.panel.VideoInset;
import tv.danmaku.biliplayerv2.widget.IControlWidget;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.log.PlayerLog;

/* compiled from: ControlContainer.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 P2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002PQB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0006\u0010\nB#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0006\u0010\rJ\u001c\u0010 \u001a\u00020!2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011H\u0016J(\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u00122\b\b\u0001\u0010%\u001a\u00020\f2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'H\u0016J\u0010\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020+H\u0016J \u0010,\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\u001dH\u0016J\b\u0010/\u001a\u00020\u001dH\u0016J\b\u00100\u001a\u00020\u001dH\u0016J\b\u00101\u001a\u00020\u001dH\u0016J\b\u00102\u001a\u00020!H\u0016J\b\u00103\u001a\u00020!H\u0016J\u0010\u00104\u001a\u00020!2\u0006\u00105\u001a\u000206H\u0016J\u0018\u00107\u001a\u00020!2\u0006\u00105\u001a\u0002062\u0006\u00108\u001a\u00020\fH\u0016J\b\u00109\u001a\u000206H\u0016J\b\u0010:\u001a\u00020\u001dH\u0016J\u0018\u0010;\u001a\u00020!2\u0006\u0010$\u001a\u00020\f2\u0006\u0010<\u001a\u00020\u001dH\u0016J\b\u0010=\u001a\u00020!H\u0016J\b\u0010>\u001a\u00020\u0012H\u0016J\b\u0010?\u001a\u00020@H\u0016J\n\u0010A\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010B\u001a\u00020!2\u0006\u0010C\u001a\u00020\u000fH\u0016J\b\u0010D\u001a\u00020\fH\u0016J\u0018\u0010E\u001a\u00020!2\u0006\u0010F\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u0012H\u0016J\u0010\u0010G\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u0012H\u0016J \u0010H\u001a\u00020!2\u0016\u0010I\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001aH\u0002J$\u0010J\u001a\u00020!2\u001a\u0010I\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`\u001aH\u0002J \u0010K\u001a\u00020!2\u0016\u0010I\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001aH\u0002J(\u0010L\u001a\u00020!2\u0006\u0010M\u001a\u00020N2\u0016\u0010O\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001aH\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000RJ\u0010\u0016\u001a>\u0012\u0004\u0012\u00020\u0012\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001a0\u0017j\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001a`\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Ltv/danmaku/biliplayerimpl/controlcontainer/ControlContainer;", "Landroid/widget/FrameLayout;", "Ltv/danmaku/biliplayerimpl/controlcontainer/IControlContainer;", "Ltv/danmaku/biliplayerv2/panel/IVideoInsetChangedObserver;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mPlayerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "mContainerConfigsByType", "", "Ltv/danmaku/biliplayerv2/ControlContainerType;", "Ltv/danmaku/biliplayerv2/ControlContainerConfig;", "mCurrentType", "mCurrentContainerConfig", "mWidgetList", "Ljava/util/HashMap;", "Ljava/util/ArrayList;", "Ltv/danmaku/biliplayerimpl/controlcontainer/ControlContainer$ControlWidgetRecord;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "mCurrentImmersive", "", "mNotifyWidgetsInactiveScheduled", "mPendingNotifyWidgetsInactiveType", "setControlContainerConfig", "", "config", "insertSlotWidgets", "type", "slotContainerId", "slotWidgets", "", "Ltv/danmaku/biliplayerv2/widget/IControlWidget;", "onVideoInsetChanged", "inset", "Ltv/danmaku/biliplayerv2/panel/VideoInset;", "switchTo", "shouldCreateInstance", "targetVisibility", "initCurrentControlContainerStandalone", "isShowing", "isAlwaysShowing", "show", "hide", "setControlAlpha", "alpha", "", "setControlWidgetAlpha", "widgetId", "getControlAlpha", "isImmersive", "setImmersive", "immersive", "release", "getCurrentControlContainerType", "getCurrentControlContainerScreenType", "Ltv/danmaku/biliplayerv2/ScreenModeType;", "getCurrentControlContainerConfig", "bindPlayerContainer", "playerContainer", "getBottomSubtitleBlock", "setControllerEnable", "enable", "getControllerEnable", "notifyWidgetsActive", "records", "notifyWidgetsInactive", "bindPlayerContextToWidget", "initHierarchyPlayerWidget", "layer", "Landroid/view/View;", "list", "Companion", "ControlWidgetRecord", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ControlContainer extends FrameLayout implements IControlContainer, IVideoInsetChangedObserver {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "ControlContainer";
    private Map<ControlContainerType, ControlContainerConfig> mContainerConfigsByType;
    private ControlContainerConfig mCurrentContainerConfig;
    private boolean mCurrentImmersive;
    private ControlContainerType mCurrentType;
    private boolean mNotifyWidgetsInactiveScheduled;
    private ControlContainerType mPendingNotifyWidgetsInactiveType;
    private PlayerContainer mPlayerContainer;
    private final HashMap<ControlContainerType, ArrayList<ControlWidgetRecord>> mWidgetList;

    /* compiled from: ControlContainer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerimpl/controlcontainer/ControlContainer$Companion;", "", "<init>", "()V", "TAG", "", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ControlContainer(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCurrentType = ControlContainerType.INITIAL;
        this.mWidgetList = new HashMap<>();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ControlContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCurrentType = ControlContainerType.INITIAL;
        this.mWidgetList = new HashMap<>();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ControlContainer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCurrentType = ControlContainerType.INITIAL;
        this.mWidgetList = new HashMap<>();
    }

    @Override // tv.danmaku.biliplayerimpl.controlcontainer.IControlContainer
    public void setControlContainerConfig(Map<ControlContainerType, ControlContainerConfig> map) {
        Map config = EnhancedUnmodifiabilityKt.unmodifiable(map);
        Intrinsics.checkNotNullParameter(config, "config");
        if (this.mPendingNotifyWidgetsInactiveType != null) {
            HashMap<ControlContainerType, ArrayList<ControlWidgetRecord>> hashMap = this.mWidgetList;
            ControlContainerType controlContainerType = this.mPendingNotifyWidgetsInactiveType;
            Intrinsics.checkNotNull(controlContainerType);
            ArrayList it = hashMap.get(controlContainerType);
            if (it != null) {
                notifyWidgetsInactive(it);
            }
            this.mPendingNotifyWidgetsInactiveType = null;
            this.mNotifyWidgetsInactiveScheduled = false;
        }
        ArrayList it2 = this.mWidgetList.get(this.mCurrentType);
        if (it2 != null) {
            notifyWidgetsInactive(it2);
        }
        ControlContainerConfig controlContainerConfig = this.mCurrentContainerConfig;
        removeView(controlContainerConfig != null ? controlContainerConfig.getInstance() : null);
        this.mCurrentType = ControlContainerType.INITIAL;
        this.mCurrentContainerConfig = null;
        this.mCurrentImmersive = false;
        this.mWidgetList.clear();
        this.mContainerConfigsByType = config;
    }

    @Override // tv.danmaku.biliplayerimpl.controlcontainer.IControlContainer
    public boolean insertSlotWidgets(ControlContainerType type, int slotContainerId, List<? extends IControlWidget> list) {
        ControlContainerConfig config;
        ArrayList widgets;
        View controlContainerConfig;
        ViewGroup slotContainer;
        Object obj;
        List<IControlWidget> slotWidgets = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(slotWidgets, "slotWidgets");
        Map<ControlContainerType, ControlContainerConfig> map = this.mContainerConfigsByType;
        if (map != null && (config = map.get(type)) != null && (widgets = this.mWidgetList.get(type)) != null && (controlContainerConfig = config.getInstance()) != null && (slotContainer = (ViewGroup) controlContainerConfig.findViewById(slotContainerId)) != null) {
            Sequence slotCurrentWidgets = SequencesKt.map(ViewGroupKt.getChildren(slotContainer), new Function1() { // from class: tv.danmaku.biliplayerimpl.controlcontainer.ControlContainer$$ExternalSyntheticLambda1
                public final Object invoke(Object obj2) {
                    IControlWidget insertSlotWidgets$lambda$0;
                    insertSlotWidgets$lambda$0 = ControlContainer.insertSlotWidgets$lambda$0((View) obj2);
                    return insertSlotWidgets$lambda$0;
                }
            });
            LinkedHashSet slotCurrentRecords = new LinkedHashSet();
            ArrayList $this$forEach$iv = widgets;
            for (Object element$iv : $this$forEach$iv) {
                ControlWidgetRecord record = (ControlWidgetRecord) element$iv;
                if (SequencesKt.contains(slotCurrentWidgets, record.getWidget())) {
                    slotCurrentRecords.add(record);
                }
            }
            widgets.removeAll(slotCurrentRecords);
            slotContainer.removeAllViews();
            if (this.mCurrentType == type) {
                for (Object element$iv2 : slotCurrentWidgets) {
                    IControlWidget it = (IControlWidget) element$iv2;
                    it.onWidgetInactive();
                }
            }
            for (IControlWidget widget : slotWidgets) {
                if (BuildConfig.DEBUG) {
                    Iterator<T> it2 = widgets.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it2.next();
                        ControlWidgetRecord it3 = (ControlWidgetRecord) obj;
                        if (Intrinsics.areEqual(it3.getWidget(), widget)) {
                            break;
                        }
                    }
                    ControlWidgetRecord exit = (ControlWidgetRecord) obj;
                    if (exit != null) {
                        throw new IllegalArgumentException("widget has already been added");
                    }
                }
                Intrinsics.checkNotNull(widget, "null cannot be cast to non-null type android.view.View");
                View view2 = (View) widget;
                ControlWidgetRecord record2 = new ControlWidgetRecord(widget);
                widgets.add(record2);
                slotContainer.addView(view2);
                PlayerContainer playerContainer = this.mPlayerContainer;
                if (playerContainer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainer = null;
                }
                widget.bindPlayerContainer(playerContainer);
                if (widget.getMembersInjector()) {
                    PlayerContainer playerContainer2 = this.mPlayerContainer;
                    if (playerContainer2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                        playerContainer2 = null;
                    }
                    playerContainer2.getPlayerServiceManager().getMembersInjector().injectMembers(widget);
                } else {
                    PlayerServiceInjector serviceInjector = record2.getServiceInjector();
                    PlayerContainer playerContainer3 = this.mPlayerContainer;
                    if (playerContainer3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                        playerContainer3 = null;
                    }
                    serviceInjector.injectPlayerServices(widget, playerContainer3);
                }
                if (this.mCurrentType == type) {
                    PlayerContainer playerContainer4 = this.mPlayerContainer;
                    if (playerContainer4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                        playerContainer4 = null;
                    }
                    record2.setBindToViewJob(BuildersKt.launch$default(PlayerContainerCoroutineKt.getCoroutineScope(playerContainer4), (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new ControlContainer$insertSlotWidgets$3(widget, null), 1, (Object) null));
                }
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IControlWidget insertSlotWidgets$lambda$0(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (IControlWidget) it;
    }

    @Override // tv.danmaku.biliplayerv2.panel.IVideoInsetChangedObserver
    public void onVideoInsetChanged(VideoInset inset) {
        int left;
        int top;
        int right;
        Intrinsics.checkNotNullParameter(inset, "inset");
        Rect containerInset = inset.getContainerInset();
        if (containerInset == null) {
            return;
        }
        if (containerInset.left > 0) {
            left = containerInset.left;
        } else {
            left = 0;
        }
        if (containerInset.top > 0) {
            top = containerInset.top;
        } else {
            top = 0;
        }
        if (containerInset.right > 0) {
            right = containerInset.right;
        } else {
            right = 0;
        }
        int bottom = containerInset.bottom > 0 ? containerInset.bottom : 0;
        setPadding(left, top, right, bottom);
    }

    @Override // tv.danmaku.biliplayerimpl.controlcontainer.IControlContainer
    public boolean switchTo(ControlContainerType type, boolean shouldCreateInstance, boolean targetVisibility) {
        ViewGroup viewGroup;
        Intrinsics.checkNotNullParameter(type, "type");
        ControlContainerType oldType = this.mCurrentType;
        Map<ControlContainerType, ControlContainerConfig> map = this.mContainerConfigsByType;
        ControlContainerConfig oldConfig = map != null ? map.get(this.mCurrentType) : null;
        Map<ControlContainerType, ControlContainerConfig> map2 = this.mContainerConfigsByType;
        ControlContainerConfig newConfig = map2 != null ? map2.get(type) : null;
        boolean z = false;
        if (oldType == type) {
            PlayerLog.i(TAG, "control container has already changed to " + this.mCurrentType);
            return false;
        } else if (this.mContainerConfigsByType == null) {
            PlayerLog.w(TAG, "control container config is null");
            return false;
        } else if (newConfig == null) {
            PlayerLog.w(TAG, "control container type is illegal");
            return false;
        } else {
            this.mCurrentContainerConfig = newConfig;
            this.mCurrentImmersive = false;
            this.mCurrentType = type;
            if (oldConfig != null) {
                removeView(oldConfig.getInstance());
                this.mPendingNotifyWidgetsInactiveType = oldType;
                if (!this.mNotifyWidgetsInactiveScheduled) {
                    PlayerContainer playerContainer = this.mPlayerContainer;
                    if (playerContainer == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                        playerContainer = null;
                    }
                    playerContainer.runCalmTask(new Runnable() { // from class: tv.danmaku.biliplayerimpl.controlcontainer.ControlContainer$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            ControlContainer.switchTo$lambda$0(ControlContainer.this);
                        }
                    });
                }
            }
            if (!newConfig.getEnable()) {
                PlayerLog.d(TAG, "control disable");
                return true;
            }
            int layoutRes = newConfig.getLayoutRes();
            if (layoutRes <= 0 && newConfig.getLayoutView() == null && newConfig.getInstance() == null) {
                PlayerLog.w(TAG, "control container layout res:" + newConfig.getLayoutRes());
            }
            View targetView = newConfig.getInstance();
            if (targetView != null) {
                if (targetVisibility) {
                    show();
                } else {
                    hide();
                }
                addView(targetView);
                ArrayList wl = this.mWidgetList.get(type);
                if (wl != null && (!wl.isEmpty())) {
                    z = true;
                }
                if (!z) {
                    wl = new ArrayList();
                    initHierarchyPlayerWidget(targetView, wl);
                    this.mWidgetList.put(type, wl);
                }
                notifyWidgetsActive(wl);
            } else if (shouldCreateInstance) {
                if (layoutRes > 0) {
                    viewGroup = LayoutInflater.from(getContext()).inflate(layoutRes, (ViewGroup) this, false);
                } else {
                    Function0<ViewGroup> layoutView = newConfig.getLayoutView();
                    viewGroup = layoutView != null ? (ViewGroup) layoutView.invoke() : null;
                }
                View targetView2 = viewGroup;
                if (targetView2 != null) {
                    newConfig.setInstance(targetView2);
                    addView(targetView2);
                    ArrayList widgetList = new ArrayList();
                    this.mWidgetList.put(type, widgetList);
                    initHierarchyPlayerWidget(targetView2, widgetList);
                    bindPlayerContextToWidget(widgetList);
                    if (targetVisibility) {
                        show();
                    } else {
                        hide();
                    }
                    notifyWidgetsActive(widgetList);
                } else {
                    PlayerLog.w(TAG, "this containerType(" + type + ") do not has view");
                }
            } else {
                PlayerLog.d(TAG, "late init control container:" + type);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void switchTo$lambda$0(ControlContainer this$0) {
        ArrayList list;
        this$0.mNotifyWidgetsInactiveScheduled = false;
        ControlContainerType it = this$0.mPendingNotifyWidgetsInactiveType;
        if (it != null && (list = this$0.mWidgetList.get(it)) != null) {
            this$0.notifyWidgetsInactive(list);
        }
    }

    @Override // tv.danmaku.biliplayerimpl.controlcontainer.IControlContainer
    public boolean initCurrentControlContainerStandalone() {
        ViewGroup targetView;
        if (this.mCurrentContainerConfig != null) {
            ControlContainerConfig controlContainerConfig = this.mCurrentContainerConfig;
            Intrinsics.checkNotNull(controlContainerConfig);
            if (controlContainerConfig.getInstance() == null) {
                ControlContainerConfig controlContainerConfig2 = this.mCurrentContainerConfig;
                Intrinsics.checkNotNull(controlContainerConfig2);
                int layoutRes = controlContainerConfig2.getLayoutRes();
                if (layoutRes > 0) {
                    targetView = LayoutInflater.from(getContext()).inflate(layoutRes, (ViewGroup) this, false);
                } else {
                    ControlContainerConfig controlContainerConfig3 = this.mCurrentContainerConfig;
                    Intrinsics.checkNotNull(controlContainerConfig3);
                    Function0<ViewGroup> layoutView = controlContainerConfig3.getLayoutView();
                    targetView = layoutView != null ? (ViewGroup) layoutView.invoke() : null;
                }
                if (targetView != null) {
                    addView(targetView);
                    ControlContainerConfig controlContainerConfig4 = this.mCurrentContainerConfig;
                    Intrinsics.checkNotNull(controlContainerConfig4);
                    controlContainerConfig4.setInstance(targetView);
                    ArrayList widgetList = new ArrayList();
                    this.mWidgetList.put(this.mCurrentType, widgetList);
                    initHierarchyPlayerWidget(targetView, widgetList);
                    bindPlayerContextToWidget(widgetList);
                    notifyWidgetsActive(widgetList);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // tv.danmaku.biliplayerimpl.controlcontainer.IControlContainer
    public boolean isShowing() {
        ControlContainerConfig config = this.mCurrentContainerConfig;
        if (config == null) {
            return false;
        }
        HashSet alwaysShowIds = config.getAlwaysShowIds();
        if (config.getInstance() == null) {
            return false;
        }
        HashSet hashSet = alwaysShowIds;
        if (hashSet == null || hashSet.isEmpty()) {
            View controlContainerConfig = config.getInstance();
            return controlContainerConfig != null && controlContainerConfig.getVisibility() == 0;
        }
        return !config.getAlwaysShowRunning();
    }

    @Override // tv.danmaku.biliplayerimpl.controlcontainer.IControlContainer
    public boolean isAlwaysShowing() {
        ControlContainerConfig config = this.mCurrentContainerConfig;
        if (config == null) {
            return false;
        }
        return config.isAlwaysShowing();
    }

    @Override // tv.danmaku.biliplayerimpl.controlcontainer.IControlContainer
    public void show() {
        View root;
        if (this.mCurrentType == ControlContainerType.INITIAL) {
            PlayerLog.w(TAG, "control container has not been initialized when show called");
            return;
        }
        initCurrentControlContainerStandalone();
        ControlContainerConfig config = this.mCurrentContainerConfig;
        if (config == null || (root = config.getInstance()) == null) {
            return;
        }
        if (root.getVisibility() != 0) {
            root.setVisibility(0);
        }
        HashSet alwaysShowIds = config.getAlwaysShowIds();
        HashSet hashSet = alwaysShowIds;
        boolean z = true;
        if (!(hashSet == null || hashSet.isEmpty())) {
            ControlContainerType containerType = this.mCurrentType;
            Iterable widgets = (ArrayList) this.mWidgetList.get(containerType);
            ArrayList<ControlWidgetRecord> arrayList = (Collection) widgets;
            if (arrayList != null && !arrayList.isEmpty()) {
                z = false;
            }
            if (z) {
                PlayerLog.i(TAG, "setImmersive, control is empty");
                return;
            }
            if (!isImmersive()) {
                config.setAlwaysShowRunning(false);
            }
            Iterable $this$forEach$iv = widgets;
            for (Object element$iv : $this$forEach$iv) {
                ControlWidgetRecord it = (ControlWidgetRecord) element$iv;
                IControlWidget widget = it.getWidget();
                Intrinsics.checkNotNull(widget, "null cannot be cast to non-null type android.view.View");
                View view2 = (View) widget;
                if (!Intrinsics.areEqual(root, view2) && !alwaysShowIds.contains(Integer.valueOf(view2.getId()))) {
                    view2.setVisibility(it.getVisibilityOnHide());
                }
            }
        }
    }

    @Override // tv.danmaku.biliplayerimpl.controlcontainer.IControlContainer
    public void hide() {
        View root;
        if (this.mCurrentType == ControlContainerType.INITIAL) {
            PlayerLog.w(TAG, "control container has not been initialized when hide called");
            return;
        }
        ControlContainerConfig config = this.mCurrentContainerConfig;
        if (config == null || (root = config.getInstance()) == null) {
            return;
        }
        HashSet alwaysShowIds = config.getAlwaysShowIds();
        HashSet hashSet = alwaysShowIds;
        boolean z = true;
        if ((hashSet == null || hashSet.isEmpty()) || !config.getEnable()) {
            if (root.getVisibility() != 8) {
                root.setVisibility(8);
                return;
            }
            return;
        }
        if (root.getVisibility() != 0) {
            root.setVisibility(0);
        }
        ControlContainerType containerType = this.mCurrentType;
        Iterable widgets = (ArrayList) this.mWidgetList.get(containerType);
        ArrayList<ControlWidgetRecord> arrayList = (Collection) widgets;
        if (arrayList == null || arrayList.isEmpty()) {
            PlayerLog.i(TAG, "setImmersive, control is empty");
            return;
        }
        if (!isImmersive()) {
            config.setAlwaysShowRunning(true);
        }
        Iterable $this$forEach$iv = widgets;
        for (Object element$iv : $this$forEach$iv) {
            ControlWidgetRecord it = (ControlWidgetRecord) element$iv;
            IControlWidget widget = it.getWidget();
            Intrinsics.checkNotNull(widget, "null cannot be cast to non-null type android.view.View");
            View view2 = (View) widget;
            if (!Intrinsics.areEqual(root, view2) && !alwaysShowIds.contains(Integer.valueOf(view2.getId()))) {
                it.setVisibilityOnHide(view2.getVisibility());
                if (view2.getVisibility() == 0 ? z : false) {
                    view2.setVisibility(0);
                }
            }
            z = true;
        }
    }

    @Override // tv.danmaku.biliplayerimpl.controlcontainer.IControlContainer
    public void setControlAlpha(float alpha) {
        View controlContainerConfig;
        ControlContainerConfig controlContainerConfig2 = this.mCurrentContainerConfig;
        if (controlContainerConfig2 == null || (controlContainerConfig = controlContainerConfig2.getInstance()) == null) {
            return;
        }
        controlContainerConfig.setAlpha(alpha);
    }

    @Override // tv.danmaku.biliplayerimpl.controlcontainer.IControlContainer
    public void setControlWidgetAlpha(float alpha, int widgetId) {
        ControlContainerType containerType = this.mCurrentType;
        Iterable widgets = (ArrayList) this.mWidgetList.get(containerType);
        if (widgets == null) {
            return;
        }
        Iterable $this$forEach$iv = widgets;
        for (Object element$iv : $this$forEach$iv) {
            ControlWidgetRecord it = (ControlWidgetRecord) element$iv;
            IControlWidget widget = it.getWidget();
            Intrinsics.checkNotNull(widget, "null cannot be cast to non-null type android.view.View");
            View view2 = (View) widget;
            if (widgetId == view2.getId()) {
                view2.setAlpha(alpha);
            }
        }
    }

    @Override // tv.danmaku.biliplayerimpl.controlcontainer.IControlContainer
    public float getControlAlpha() {
        View controlContainerConfig;
        ControlContainerConfig controlContainerConfig2 = this.mCurrentContainerConfig;
        if (controlContainerConfig2 == null || (controlContainerConfig = controlContainerConfig2.getInstance()) == null) {
            return 1.0f;
        }
        return controlContainerConfig.getAlpha();
    }

    @Override // tv.danmaku.biliplayerimpl.controlcontainer.IControlContainer
    public boolean isImmersive() {
        return this.mCurrentImmersive;
    }

    @Override // tv.danmaku.biliplayerimpl.controlcontainer.IControlContainer
    public void setImmersive(int type, boolean immersive) {
        if (this.mCurrentType == ControlContainerType.INITIAL) {
            PlayerLog.w(TAG, "control container has not been initialized when setImmersive called");
            return;
        }
        ControlContainerConfig config = this.mCurrentContainerConfig;
        if (config == null) {
            return;
        }
        HashMap<Integer, HashSet<Integer>> immersiveVisibleIds = config.getImmersiveVisibleIds();
        HashSet<Integer> hashSet = immersiveVisibleIds != null ? immersiveVisibleIds.get(Integer.valueOf(type)) : null;
        HashSet<Integer> hashSet2 = hashSet;
        if (hashSet2 == null || hashSet2.isEmpty()) {
            PlayerLog.i(TAG, "setImmersive, this id is empty: " + type);
            return;
        }
        View root = config.getInstance();
        if (root == null || this.mCurrentImmersive == immersive) {
            return;
        }
        PlayerLog.i(TAG, "setImmersive, " + type + " " + immersive);
        ControlContainerType containerType = this.mCurrentType;
        Iterable widgets = (ArrayList) this.mWidgetList.get(containerType);
        ArrayList<ControlWidgetRecord> arrayList = (Collection) widgets;
        if (arrayList == null || arrayList.isEmpty()) {
            PlayerLog.i(TAG, "setImmersive, control is empty");
        } else if (!immersive) {
            this.mCurrentImmersive = false;
            Iterable $this$forEach$iv = widgets;
            for (Object element$iv : $this$forEach$iv) {
                ControlWidgetRecord it = (ControlWidgetRecord) element$iv;
                IControlWidget widget = it.getWidget();
                Intrinsics.checkNotNull(widget, "null cannot be cast to non-null type android.view.View");
                View view2 = (View) widget;
                if (!Intrinsics.areEqual(root, view2) && !hashSet.contains(Integer.valueOf(view2.getId()))) {
                    view2.setVisibility(it.getVisibilityOnImmersive());
                }
            }
        } else {
            Iterable $this$forEach$iv2 = widgets;
            for (Object element$iv2 : $this$forEach$iv2) {
                ControlWidgetRecord it2 = (ControlWidgetRecord) element$iv2;
                IControlWidget widget2 = it2.getWidget();
                Intrinsics.checkNotNull(widget2, "null cannot be cast to non-null type android.view.View");
                View view3 = (View) widget2;
                if (!Intrinsics.areEqual(root, view3) && !hashSet.contains(Integer.valueOf(view3.getId()))) {
                    it2.setVisibilityOnImmersive(view3.getVisibility());
                    if (view3.getVisibility() == 0) {
                        view3.setVisibility(4);
                    }
                }
            }
            this.mCurrentImmersive = true;
        }
    }

    @Override // tv.danmaku.biliplayerimpl.controlcontainer.IControlContainer
    public void release() {
        if (this.mCurrentType != ControlContainerType.INITIAL) {
            ControlContainerConfig controlContainerConfig = this.mCurrentContainerConfig;
            removeView(controlContainerConfig != null ? controlContainerConfig.getInstance() : null);
            notifyWidgetsInactive(this.mWidgetList.get(this.mCurrentType));
        }
        this.mPendingNotifyWidgetsInactiveType = null;
    }

    @Override // tv.danmaku.biliplayerimpl.controlcontainer.IControlContainer
    public ControlContainerType getCurrentControlContainerType() {
        return this.mCurrentType;
    }

    @Override // tv.danmaku.biliplayerimpl.controlcontainer.IControlContainer
    public ScreenModeType getCurrentControlContainerScreenType() {
        ControlContainerConfig controlContainerConfig;
        ScreenModeType screenModeType;
        Map<ControlContainerType, ControlContainerConfig> map = this.mContainerConfigsByType;
        if (map != null && (controlContainerConfig = map.get(this.mCurrentType)) != null && (screenModeType = controlContainerConfig.getScreenModeType()) != null) {
            return screenModeType;
        }
        return ScreenModeType.THUMB;
    }

    @Override // tv.danmaku.biliplayerimpl.controlcontainer.IControlContainer
    public ControlContainerConfig getCurrentControlContainerConfig() {
        Map<ControlContainerType, ControlContainerConfig> map = this.mContainerConfigsByType;
        if (map != null) {
            return map.get(this.mCurrentType);
        }
        return null;
    }

    @Override // tv.danmaku.biliplayerv2.widget.IWidget
    public void bindPlayerContainer(PlayerContainer playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        this.mPlayerContainer = playerContainer;
    }

    @Override // tv.danmaku.biliplayerimpl.controlcontainer.IControlContainer
    public int getBottomSubtitleBlock() {
        ControlContainerConfig controlContainerConfig;
        Map<ControlContainerType, ControlContainerConfig> map = this.mContainerConfigsByType;
        if (map == null || (controlContainerConfig = map.get(this.mCurrentType)) == null) {
            return 0;
        }
        return controlContainerConfig.getBottomSubtitleBlock();
    }

    @Override // tv.danmaku.biliplayerimpl.controlcontainer.IControlContainer
    public void setControllerEnable(boolean enable, ControlContainerType type) {
        ControlContainerConfig controlContainerConfig;
        Intrinsics.checkNotNullParameter(type, "type");
        Map<ControlContainerType, ControlContainerConfig> map = this.mContainerConfigsByType;
        if (map == null || (controlContainerConfig = map.get(type)) == null) {
            return;
        }
        controlContainerConfig.setEnable(enable);
    }

    @Override // tv.danmaku.biliplayerimpl.controlcontainer.IControlContainer
    public boolean getControllerEnable(ControlContainerType type) {
        ControlContainerConfig controlContainerConfig;
        Intrinsics.checkNotNullParameter(type, "type");
        Map<ControlContainerType, ControlContainerConfig> map = this.mContainerConfigsByType;
        if (map == null || (controlContainerConfig = map.get(type)) == null) {
            return true;
        }
        return controlContainerConfig.getEnable();
    }

    private final void notifyWidgetsActive(ArrayList<ControlWidgetRecord> arrayList) {
        Iterator<ControlWidgetRecord> it = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            ControlWidgetRecord next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            ControlWidgetRecord record = next;
            IControlWidget widget = record.getWidget();
            if (widget.getMembersInjector()) {
                PlayerContainer playerContainer = this.mPlayerContainer;
                if (playerContainer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainer = null;
                }
                playerContainer.getPlayerServiceManager().getMembersInjector().injectMembers(widget);
            } else {
                PlayerServiceInjector serviceInjector = record.getServiceInjector();
                IControlWidget widget2 = record.getWidget();
                PlayerContainer playerContainer2 = this.mPlayerContainer;
                if (playerContainer2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainer2 = null;
                }
                serviceInjector.injectPlayerServices(widget2, playerContainer2);
            }
            PlayerContainer playerContainer3 = this.mPlayerContainer;
            if (playerContainer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer3 = null;
            }
            record.setBindToViewJob(BuildersKt.launch$default(PlayerContainerCoroutineKt.getCoroutineScope(playerContainer3), (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new ControlContainer$notifyWidgetsActive$1(widget, null), 1, (Object) null));
        }
    }

    private final void notifyWidgetsInactive(ArrayList<ControlWidgetRecord> arrayList) {
        if (arrayList == null) {
            return;
        }
        Iterator<ControlWidgetRecord> it = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            ControlWidgetRecord next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            ControlWidgetRecord record = next;
            record.getWidget().onWidgetInactive();
            Job bindToViewJob = record.getBindToViewJob();
            if (bindToViewJob != null) {
                Job.DefaultImpls.cancel$default(bindToViewJob, (CancellationException) null, 1, (Object) null);
            }
            record.getServiceInjector().release();
        }
    }

    private final void bindPlayerContextToWidget(ArrayList<ControlWidgetRecord> arrayList) {
        Iterator<ControlWidgetRecord> it = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            ControlWidgetRecord next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            ControlWidgetRecord record = next;
            IControlWidget widget = record.getWidget();
            PlayerContainer playerContainer = this.mPlayerContainer;
            if (playerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer = null;
            }
            widget.bindPlayerContainer(playerContainer);
        }
    }

    private final void initHierarchyPlayerWidget(View layer, ArrayList<ControlWidgetRecord> arrayList) {
        if (layer instanceof ViewGroup) {
            if (layer instanceof IControlWidget) {
                arrayList.add(new ControlWidgetRecord((IControlWidget) layer));
            }
            int childCount = ((ViewGroup) layer).getChildCount();
            for (int i = 0; i < childCount; i++) {
                View view2 = ((ViewGroup) layer).getChildAt(i);
                if (view2 instanceof ViewGroup) {
                    initHierarchyPlayerWidget(view2, arrayList);
                } else if (view2 instanceof IControlWidget) {
                    arrayList.add(new ControlWidgetRecord((IControlWidget) view2));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ControlContainer.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017¨\u0006\u001b"}, d2 = {"Ltv/danmaku/biliplayerimpl/controlcontainer/ControlContainer$ControlWidgetRecord;", "", "widget", "Ltv/danmaku/biliplayerv2/widget/IControlWidget;", "<init>", "(Ltv/danmaku/biliplayerv2/widget/IControlWidget;)V", "getWidget", "()Ltv/danmaku/biliplayerv2/widget/IControlWidget;", "serviceInjector", "Ltv/danmaku/biliplayerv2/injection/PlayerServiceInjector;", "getServiceInjector", "()Ltv/danmaku/biliplayerv2/injection/PlayerServiceInjector;", "bindToViewJob", "Lkotlinx/coroutines/Job;", "getBindToViewJob", "()Lkotlinx/coroutines/Job;", "setBindToViewJob", "(Lkotlinx/coroutines/Job;)V", "visibilityOnImmersive", "", "getVisibilityOnImmersive", "()I", "setVisibilityOnImmersive", "(I)V", "visibilityOnHide", "getVisibilityOnHide", "setVisibilityOnHide", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ControlWidgetRecord {
        private Job bindToViewJob;
        private final PlayerServiceInjector serviceInjector;
        private int visibilityOnHide;
        private int visibilityOnImmersive;
        private final IControlWidget widget;

        public ControlWidgetRecord(IControlWidget widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            this.widget = widget;
            this.serviceInjector = new PlayerServiceInjector();
        }

        public final IControlWidget getWidget() {
            return this.widget;
        }

        public final PlayerServiceInjector getServiceInjector() {
            return this.serviceInjector;
        }

        public final Job getBindToViewJob() {
            return this.bindToViewJob;
        }

        public final void setBindToViewJob(Job job) {
            this.bindToViewJob = job;
        }

        public final int getVisibilityOnImmersive() {
            return this.visibilityOnImmersive;
        }

        public final void setVisibilityOnImmersive(int i) {
            this.visibilityOnImmersive = i;
        }

        public final int getVisibilityOnHide() {
            return this.visibilityOnHide;
        }

        public final void setVisibilityOnHide(int i) {
            this.visibilityOnHide = i;
        }
    }
}