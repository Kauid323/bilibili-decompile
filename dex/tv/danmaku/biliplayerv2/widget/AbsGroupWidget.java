package tv.danmaku.biliplayerv2.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.PlayerContainerCoroutineKt;
import tv.danmaku.biliplayerv2.injection.PlayerServiceInjector;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: AbsGroupWidget.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0004J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0012H\u0017J\b\u0010\u0013\u001a\u00020\u0012H\u0017J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u000fH\u0002J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u000fH\u0002J\b\u0010\u0018\u001a\u00020\u0012H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Ltv/danmaku/biliplayerv2/widget/AbsGroupWidget;", "Ltv/danmaku/biliplayerv2/widget/AbsFunctionWidget;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "playerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "bindToViewJob", "Lkotlinx/coroutines/Job;", "widgetRecords", "Ljava/util/ArrayList;", "Ltv/danmaku/biliplayerv2/widget/AbsGroupWidget$ControlWidgetRecord;", "Lkotlin/collections/ArrayList;", "createContentView", "Landroid/view/View;", "onCreateContentView", "onWidgetShow", "", "onWidgetDismiss", "bindPlayerContainer", "onChildBindPlayerContainer", "view", "onChildWidgetShow", "onChildWidgetDismiss", "ControlWidgetRecord", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class AbsGroupWidget extends AbsFunctionWidget {
    private Job bindToViewJob;
    private PlayerContainer playerContainer;
    private final ArrayList<ControlWidgetRecord> widgetRecords;

    public abstract View onCreateContentView(Context context);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsGroupWidget(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.widgetRecords = new ArrayList<>();
    }

    @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget
    protected final View createContentView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        View view2 = onCreateContentView(context);
        onChildBindPlayerContainer(view2);
        return view2;
    }

    @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget, tv.danmaku.biliplayerv2.widget.IFunctionWidget
    public void onWidgetShow() {
        super.onWidgetShow();
        PlayerContainer playerContainer = this.playerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerContainer");
            playerContainer = null;
        }
        this.bindToViewJob = BuildersKt.launch$default(PlayerContainerCoroutineKt.getCoroutineScope(playerContainer), (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new AbsGroupWidget$onWidgetShow$1(this, null), 1, (Object) null);
    }

    @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget, tv.danmaku.biliplayerv2.widget.IFunctionWidget
    public void onWidgetDismiss() {
        super.onWidgetDismiss();
        Job job = this.bindToViewJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget, tv.danmaku.biliplayerv2.widget.IWidget
    public void bindPlayerContainer(PlayerContainer playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        this.playerContainer = playerContainer;
    }

    private final void onChildBindPlayerContainer(View view2) {
        if (view2 instanceof IWidget) {
            IWidget iWidget = (IWidget) view2;
            PlayerContainer playerContainer = this.playerContainer;
            if (playerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playerContainer");
                playerContainer = null;
            }
            iWidget.bindPlayerContainer(playerContainer);
        }
        if (view2 instanceof ViewGroup) {
            int count = ((ViewGroup) view2).getChildCount();
            for (int i = 0; i < count; i++) {
                View child = ((ViewGroup) view2).getChildAt(i);
                Intrinsics.checkNotNull(child);
                onChildBindPlayerContainer(child);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onChildWidgetShow(View view2) {
        if (view2 instanceof IControlWidget) {
            this.widgetRecords.add(new ControlWidgetRecord((IControlWidget) view2));
        }
        if (view2 instanceof ViewGroup) {
            int count = ((ViewGroup) view2).getChildCount();
            for (int i = 0; i < count; i++) {
                View child = ((ViewGroup) view2).getChildAt(i);
                Intrinsics.checkNotNull(child);
                onChildWidgetShow(child);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onChildWidgetDismiss() {
        Iterator<ControlWidgetRecord> it = this.widgetRecords.iterator();
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
        this.widgetRecords.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbsGroupWidget.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Ltv/danmaku/biliplayerv2/widget/AbsGroupWidget$ControlWidgetRecord;", "", "widget", "Ltv/danmaku/biliplayerv2/widget/IControlWidget;", "<init>", "(Ltv/danmaku/biliplayerv2/widget/IControlWidget;)V", "getWidget", "()Ltv/danmaku/biliplayerv2/widget/IControlWidget;", "serviceInjector", "Ltv/danmaku/biliplayerv2/injection/PlayerServiceInjector;", "getServiceInjector", "()Ltv/danmaku/biliplayerv2/injection/PlayerServiceInjector;", "bindToViewJob", "Lkotlinx/coroutines/Job;", "getBindToViewJob", "()Lkotlinx/coroutines/Job;", "setBindToViewJob", "(Lkotlinx/coroutines/Job;)V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ControlWidgetRecord {
        private Job bindToViewJob;
        private final PlayerServiceInjector serviceInjector;
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
    }
}