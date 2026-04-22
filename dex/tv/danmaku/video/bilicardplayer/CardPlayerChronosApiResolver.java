package tv.danmaku.video.bilicardplayer;

import bolts.Continuation;
import bolts.Task;
import com.bilibili.common.chronoscommon.ChronosPackageManager;
import com.bilibili.cron.ChronosPackage;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: CardChronosApiResolver.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007J\u0010\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Ltv/danmaku/video/bilicardplayer/CardPlayerChronosApiResolver;", "", "<init>", "()V", "isResolving", "", "mCallback", "Ltv/danmaku/video/bilicardplayer/ChronosApiResolveCallback;", "setResolveCallback", "", "callback", "resolve", "service", "Lcom/bilibili/common/chronoscommon/ChronosPackageManager$Service;", "Companion", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class CardPlayerChronosApiResolver {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "CardPlayerChronosApiResolver";
    private boolean isResolving;
    private ChronosApiResolveCallback mCallback;

    public final void setResolveCallback(ChronosApiResolveCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.mCallback = callback;
    }

    public static /* synthetic */ void resolve$default(CardPlayerChronosApiResolver cardPlayerChronosApiResolver, ChronosPackageManager.Service service, int i, Object obj) {
        if ((i & 1) != 0) {
            service = ChronosPackageManager.Service.DFM;
        }
        cardPlayerChronosApiResolver.resolve(service);
    }

    public final void resolve(final ChronosPackageManager.Service service) {
        Intrinsics.checkNotNullParameter(service, "service");
        if (this.isResolving) {
            BLog.d(TAG, "chronos api is resolving");
            return;
        }
        this.isResolving = true;
        Task.callInBackground(new Callable() { // from class: tv.danmaku.video.bilicardplayer.CardPlayerChronosApiResolver$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ChronosPackage resolve$lambda$0;
                resolve$lambda$0 = CardPlayerChronosApiResolver.resolve$lambda$0(service);
                return resolve$lambda$0;
            }
        }).continueWith(new Continuation() { // from class: tv.danmaku.video.bilicardplayer.CardPlayerChronosApiResolver$$ExternalSyntheticLambda1
            public final Object then(Task task) {
                Task resolve$lambda$1;
                resolve$lambda$1 = CardPlayerChronosApiResolver.resolve$lambda$1(CardPlayerChronosApiResolver.this, task);
                return resolve$lambda$1;
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChronosPackage resolve$lambda$0(ChronosPackageManager.Service $service) {
        try {
            return ChronosPackageManager.obtain$default(ChronosPackageManager.INSTANCE, $service, (String) null, 2, (Object) null);
        } catch (Throwable t) {
            BLog.e(TAG, "chronos package resolver fail, caused by " + t.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Task resolve$lambda$1(CardPlayerChronosApiResolver this$0, Task it) {
        this$0.isResolving = false;
        if (it.getResult() == null) {
            ChronosApiResolveCallback chronosApiResolveCallback = this$0.mCallback;
            if (chronosApiResolveCallback != null) {
                chronosApiResolveCallback.onResolveFail();
            }
        } else {
            ChronosApiResolveCallback chronosApiResolveCallback2 = this$0.mCallback;
            if (chronosApiResolveCallback2 != null) {
                chronosApiResolveCallback2.onResolveSuccess((ChronosPackage) it.getResult());
            }
        }
        return it;
    }

    /* compiled from: CardChronosApiResolver.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/video/bilicardplayer/CardPlayerChronosApiResolver$Companion;", "", "<init>", "()V", "TAG", "", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}