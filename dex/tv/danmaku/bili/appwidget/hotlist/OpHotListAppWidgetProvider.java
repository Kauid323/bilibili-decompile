package tv.danmaku.bili.appwidget.hotlist;

import android.app.Application;
import android.content.Context;
import android.os.SystemClock;
import com.bilibili.base.BiliContext;
import com.bilibili.base.util.DelayTaskController;
import com.bilibili.lib.gripper.api.ExecutionPlan;
import com.bilibili.lib.gripper.api.Gripper;
import com.bilibili.lib.gripper.api.GripperKt;
import com.bilibili.lib.gripper.api.PlanSource;
import com.bilibili.lib.gripper.api.ProducerNode;
import com.oplus.cardwidget.domain.action.CardWidgetAction;
import com.oplus.cardwidget.serviceLayer.AppCardWidgetProvider;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.hotlist.model.HotListDataPacker;
import tv.danmaku.bili.appwidget.hotlist.model.HotListWidgetModel;
import tv.danmaku.bili.appwidget.hotlist.utils.SpUtilKt;

/* compiled from: OpHotListAppWidgetProvider.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u000e\b\u0007\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fH\u0016J\u0018\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fH\u0016J\u001e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0016J\u0018\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fH\u0016J\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001c\u0010!\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010#\u001a\u00020\u0015H\u0016J\u0010\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u0006H\u0016J\b\u0010&\u001a\u00020\u0015H\u0002J\b\u0010'\u001a\u00020\u0015H\u0016J\b\u0010(\u001a\u00020\u0015H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006*"}, d2 = {"Ltv/danmaku/bili/appwidget/hotlist/OpHotListAppWidgetProvider;", "Lcom/oplus/cardwidget/serviceLayer/AppCardWidgetProvider;", "Ltv/danmaku/bili/appwidget/hotlist/DataChangeListener;", "<init>", "()V", "isGripperComplete", "", "updateFromRefresh", "needUpdate", "isCardObserverSaved", "grantedPermissions", "", "", "gripper", "Lcom/bilibili/lib/gripper/api/Gripper;", "getGripper", "()Lcom/bilibili/lib/gripper/api/Gripper;", "gripper$delegate", "Lkotlin/Lazy;", "onCreate", "subscribed", "", "context", "Landroid/content/Context;", "widgetCode", "unSubscribed", "onCardsObserve", "widgetCodes", "", "getCardLayoutName", "onResume", "updateCard", "isRestrictedMode", "switchLayout", "layout", "onCardRefresh", "onTryUpdate", "resetPage", "postEmptyData", "onChangeMode", "registerGripperListener", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class OpHotListAppWidgetProvider extends AppCardWidgetProvider implements DataChangeListener {
    public static final long DEFAULT_REFRESH_INTERVAL = 7200000;
    public static final String HOT_LIST_LAYOUT_BLOCK_JSON = "hot_list_block.json";
    public static final String HOT_LIST_LAYOUT_JSON = "hot_list.json";
    public static final String HOT_LIST_LAYOUT_LOADING_JSON = "hot_list_loading.json";
    public static final String HOT_LIST_LAYOUT_RESTRICTED_MODE_JSON = "hot_list_restricted_mode.json";
    private final List<String> grantedPermissions = CollectionsKt.mutableListOf(new String[]{"com.android.launcher", "com.oppo.launcher", "com.coloros.assistantscreen"});
    private final Lazy gripper$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.appwidget.hotlist.OpHotListAppWidgetProvider$$ExternalSyntheticLambda0
        public final Object invoke() {
            Gripper gripper_delegate$lambda$0;
            gripper_delegate$lambda$0 = OpHotListAppWidgetProvider.gripper_delegate$lambda$0();
            return gripper_delegate$lambda$0;
        }
    });
    private boolean isCardObserverSaved;
    private boolean isGripperComplete;
    private boolean needUpdate;
    private boolean updateFromRefresh;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    private final Gripper getGripper() {
        return (Gripper) this.gripper$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Gripper gripper_delegate$lambda$0() {
        Application application = BiliContext.application();
        Intrinsics.checkNotNull(application);
        return GripperKt.getGripper(application);
    }

    public boolean onCreate() {
        boolean state = super.onCreate();
        StateNoticeKt.getUSER_DATA_INSTANCE().addNotice(this);
        registerGripperListener();
        return state;
    }

    public void subscribed(Context context, String widgetCode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(widgetCode, "widgetCode");
        super.subscribed(context, widgetCode);
        if (!this.isCardObserverSaved) {
            SpUtilKt.setOpHotListCount(context, SpUtilKt.getOpHotListCount(context) + 1);
        }
    }

    public void unSubscribed(Context context, String widgetCode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(widgetCode, "widgetCode");
        super.unSubscribed(context, widgetCode);
        if (!this.isCardObserverSaved) {
            SpUtilKt.setOpHotListCount(context, SpUtilKt.getOpHotListCount(context) - 1);
        }
    }

    public void onCardsObserve(Context context, List<String> list) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "widgetCodes");
        super.onCardsObserve(context, list);
        SpUtilKt.setOpHotListCount(context, list.size());
        this.isCardObserverSaved = true;
    }

    public String getCardLayoutName(String widgetCode) {
        Intrinsics.checkNotNullParameter(widgetCode, "widgetCode");
        if (DelayTaskController.shouldBlock()) {
            return HOT_LIST_LAYOUT_BLOCK_JSON;
        }
        Context it = getContext();
        boolean z = false;
        if (it != null && isRestrictedMode(it)) {
            z = true;
        }
        return z ? HOT_LIST_LAYOUT_RESTRICTED_MODE_JSON : HOT_LIST_LAYOUT_JSON;
    }

    public void onResume(Context context, String widgetCode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(widgetCode, "widgetCode");
        if (DelayTaskController.shouldBlock()) {
            switchLayout(context, HOT_LIST_LAYOUT_BLOCK_JSON);
            postEmptyData();
        } else if (isRestrictedMode(context)) {
            switchLayout(context, HOT_LIST_LAYOUT_RESTRICTED_MODE_JSON);
            postEmptyData();
        } else {
            SpUtilKt.resetOppoHotListPageNo(context);
            this.needUpdate = true;
            if (!this.isGripperComplete) {
                switchLayout(context, HOT_LIST_LAYOUT_BLOCK_JSON);
                postEmptyData();
                return;
            }
            updateCard(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCard(Context context) {
        if (!SpUtilKt.isOpHotListExists(context)) {
            return;
        }
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO())), (CoroutineContext) null, (CoroutineStart) null, new OpHotListAppWidgetProvider$updateCard$1(this, context, null), 3, (Object) null);
    }

    private final boolean isRestrictedMode(Context context) {
        return SpUtilKt.isRestrictedTeenagerMode(context) | SpUtilKt.isRestrictedLessonMode(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void switchLayout$default(OpHotListAppWidgetProvider opHotListAppWidgetProvider, Context context, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        opHotListAppWidgetProvider.switchLayout(context, str);
    }

    private final void switchLayout(Context context, String layout) {
        String layoutName;
        Iterable $this$forEach$iv = getShowedCardList();
        for (Object element$iv : $this$forEach$iv) {
            String widgetCode = (String) element$iv;
            if (DelayTaskController.shouldBlock()) {
                layoutName = HOT_LIST_LAYOUT_BLOCK_JSON;
            } else {
                layoutName = isRestrictedMode(context) ? HOT_LIST_LAYOUT_RESTRICTED_MODE_JSON : HOT_LIST_LAYOUT_JSON;
            }
            CardWidgetAction.INSTANCE.switchLayoutCommand(widgetCode, layout == null ? layoutName : layout);
        }
    }

    @Override // tv.danmaku.bili.appwidget.hotlist.DataChangeListener
    public void onCardRefresh() {
        Context context = getContext();
        if (context != null) {
            this.updateFromRefresh = true;
            if (!this.isGripperComplete) {
                this.needUpdate = true;
                switchLayout(context, HOT_LIST_LAYOUT_LOADING_JSON);
                postEmptyData();
                return;
            }
            updateCard(context);
        }
    }

    @Override // tv.danmaku.bili.appwidget.hotlist.DataChangeListener
    public void onTryUpdate(boolean resetPage) {
        Context context = getContext();
        if (context != null) {
            switchLayout$default(this, context, null, 2, null);
            this.isGripperComplete = true;
            if (isRestrictedMode(context)) {
                return;
            }
            long curTime = SystemClock.elapsedRealtime();
            long lastRefreshTime = SpUtilKt.getOpHotListRefreshTime(context);
            if (lastRefreshTime == 0 || curTime - lastRefreshTime >= DEFAULT_REFRESH_INTERVAL) {
                if (resetPage) {
                    SpUtilKt.resetOppoHotListPageNo(context);
                }
                updateCard(context);
                SpUtilKt.setOpHotListRefreshTime(context, curTime);
            }
        }
    }

    private final void postEmptyData() {
        Iterable $this$forEach$iv = getShowedCardList();
        for (Object element$iv : $this$forEach$iv) {
            String widgetCode = (String) element$iv;
            CardWidgetAction.INSTANCE.postUpdateCommand(getContext(), new HotListDataPacker(new HotListWidgetModel(null, 1, null)), widgetCode);
        }
    }

    @Override // tv.danmaku.bili.appwidget.hotlist.DataChangeListener
    public void onChangeMode() {
        Context context = getContext();
        if (context != null) {
            switchLayout$default(this, context, null, 2, null);
            if (!SpUtilKt.isOpHotListExists(context)) {
                return;
            }
            if (isRestrictedMode(context)) {
                postEmptyData();
                return;
            }
            SpUtilKt.resetOppoHotListPageNo(context);
            updateCard(context);
            SpUtilKt.setOpHotListRefreshTime(context, SystemClock.elapsedRealtime());
        }
    }

    private final void registerGripperListener() {
        getGripper().addPlanListenerFactory(new ExecutionPlan.Listener.Factory() { // from class: tv.danmaku.bili.appwidget.hotlist.OpHotListAppWidgetProvider$registerGripperListener$1
            public ExecutionPlan.Listener createListener(ExecutionPlan plan) {
                Intrinsics.checkNotNullParameter(plan, "plan");
                PlanSource.Trigger source = plan.getSource();
                if ((source instanceof PlanSource.Trigger) && !Intrinsics.areEqual(source.getKey(), "OnPrivacyAllowed")) {
                    return null;
                }
                final OpHotListAppWidgetProvider opHotListAppWidgetProvider = OpHotListAppWidgetProvider.this;
                return new ExecutionPlan.Listener() { // from class: tv.danmaku.bili.appwidget.hotlist.OpHotListAppWidgetProvider$registerGripperListener$1$createListener$1
                    public void afterNodeExecute(ProducerNode node, long duration) {
                        Intrinsics.checkNotNullParameter(node, "node");
                    }

                    public void beforeNodeExecute(ProducerNode node) {
                        Intrinsics.checkNotNullParameter(node, "node");
                    }

                    public void onCompleted() {
                        boolean z;
                        boolean z2;
                        Context it;
                        z = OpHotListAppWidgetProvider.this.needUpdate;
                        if (z) {
                            z2 = OpHotListAppWidgetProvider.this.isGripperComplete;
                            if (!z2 && (it = OpHotListAppWidgetProvider.this.getContext()) != null) {
                                OpHotListAppWidgetProvider.this.updateCard(it);
                            }
                        }
                        OpHotListAppWidgetProvider.this.isGripperComplete = true;
                    }

                    public void onStart() {
                    }

                    public void onSubmitted() {
                    }
                };
            }
        });
    }

    /* compiled from: OpHotListAppWidgetProvider.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/appwidget/hotlist/OpHotListAppWidgetProvider$Companion;", "", "<init>", "()V", "DEFAULT_REFRESH_INTERVAL", "", "HOT_LIST_LAYOUT_JSON", "", "HOT_LIST_LAYOUT_BLOCK_JSON", "HOT_LIST_LAYOUT_LOADING_JSON", "HOT_LIST_LAYOUT_RESTRICTED_MODE_JSON", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}