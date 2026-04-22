package tv.danmaku.video.playerservice;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BLPlayerService.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u0006\u001a\u0002H\u0007\"\b\b\u0000\u0010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00070\fH\u0007¢\u0006\u0002\u0010\rJ-\u0010\u0006\u001a\u0002H\u0007\"\b\b\u0000\u0010\u0007*\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00070\fH\u0007¢\u0006\u0002\u0010\u0010J-\u0010\u0006\u001a\u0002H\u0007\"\b\b\u0000\u0010\u0007*\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00070\fH\u0007¢\u0006\u0002\u0010\u0013J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\fH\u0003J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\fH\u0003J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\fH\u0002J\u0006\u0010\u0016\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Ltv/danmaku/video/playerservice/BLPlayerService;", "", "<init>", "()V", "mRecyclableObjectPool", "Ltv/danmaku/video/playerservice/RecyclableObjectPool;", "with", "T", "Ltv/danmaku/video/playerservice/BLPlayerScene;", "activity", "Landroidx/fragment/app/FragmentActivity;", "type", "Ljava/lang/Class;", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/Class;)Ltv/danmaku/video/playerservice/BLPlayerScene;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;Ljava/lang/Class;)Ltv/danmaku/video/playerservice/BLPlayerScene;", "context", "Landroid/content/Context;", "(Landroid/content/Context;Ljava/lang/Class;)Ltv/danmaku/video/playerservice/BLPlayerScene;", "remove", "", "getRecyclableObjectPool", "Companion", "playerservice_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BLPlayerService {
    public static final String TAG = "BiliPlayerService";
    private final RecyclableObjectPool mRecyclableObjectPool = new RecyclableObjectPool();
    public static final Companion Companion = new Companion(null);
    private static final Lazy<BLPlayerService> instance$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.video.playerservice.BLPlayerService$$ExternalSyntheticLambda0
        public final Object invoke() {
            BLPlayerService instance_delegate$lambda$0;
            instance_delegate$lambda$0 = BLPlayerService.instance_delegate$lambda$0();
            return instance_delegate$lambda$0;
        }
    });

    private BLPlayerService() {
    }

    public final <T extends BLPlayerScene> T with(FragmentActivity activity, Class<T> cls) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(cls, "type");
        return (T) BLPlayerRetriever.Companion.get(activity, this, cls);
    }

    public final <T extends BLPlayerScene> T with(Fragment fragment, Class<T> cls) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(cls, "type");
        return (T) BLPlayerRetriever.Companion.get(fragment, this, cls);
    }

    public final <T extends BLPlayerScene> T with(Context context, Class<T> cls) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cls, "type");
        return (T) BLPlayerRetriever.Companion.get(context, this, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void remove(Context context, Class<? extends BLPlayerScene> cls) {
        BLPlayerRetriever.Companion.remove(context, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void remove(Fragment fragment, Class<? extends BLPlayerScene> cls) {
        BLPlayerRetriever.Companion.remove(fragment, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void remove(FragmentActivity activity, Class<? extends BLPlayerScene> cls) {
        BLPlayerRetriever.Companion.remove(activity, cls);
    }

    public final RecyclableObjectPool getRecyclableObjectPool() {
        return this.mRecyclableObjectPool;
    }

    /* compiled from: BLPlayerService.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\f\u001a\u0002H\r\"\n\b\u0000\u0010\r\u0018\u0001*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b¢\u0006\u0002\u0010\u0011J\"\u0010\f\u001a\u0002H\r\"\n\b\u0000\u0010\r\u0018\u0001*\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0087\b¢\u0006\u0002\u0010\u0014J\"\u0010\f\u001a\u0002H\r\"\n\b\u0000\u0010\r\u0018\u0001*\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0087\b¢\u0006\u0002\u0010\u0017J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u00162\u000e\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u001bH\u0007J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u001bH\u0007J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u001bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u001c"}, d2 = {"Ltv/danmaku/video/playerservice/BLPlayerService$Companion;", "", "<init>", "()V", "TAG", "", "instance", "Ltv/danmaku/video/playerservice/BLPlayerService;", "getInstance", "()Ltv/danmaku/video/playerservice/BLPlayerService;", "instance$delegate", "Lkotlin/Lazy;", "with", "T", "Ltv/danmaku/video/playerservice/BLPlayerScene;", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)Ltv/danmaku/video/playerservice/BLPlayerScene;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)Ltv/danmaku/video/playerservice/BLPlayerScene;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)Ltv/danmaku/video/playerservice/BLPlayerScene;", "remove", "", "type", "Ljava/lang/Class;", "playerservice_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BLPlayerService getInstance() {
            return (BLPlayerService) BLPlayerService.instance$delegate.getValue();
        }

        public final /* synthetic */ <T extends BLPlayerScene> T with(FragmentActivity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            BLPlayerService companion = getInstance();
            Intrinsics.reifiedOperationMarker(4, "T");
            return (T) companion.with(activity, BLPlayerScene.class);
        }

        public final /* synthetic */ <T extends BLPlayerScene> T with(Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            BLPlayerService companion = getInstance();
            Intrinsics.reifiedOperationMarker(4, "T");
            return (T) companion.with(fragment, BLPlayerScene.class);
        }

        public final /* synthetic */ <T extends BLPlayerScene> T with(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            BLPlayerService companion = getInstance();
            Intrinsics.reifiedOperationMarker(4, "T");
            return (T) companion.with(context, BLPlayerScene.class);
        }

        public final void remove(Context context, Class<? extends BLPlayerScene> cls) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(cls, "type");
            getInstance().remove(context, cls);
        }

        public final void remove(FragmentActivity activity, Class<? extends BLPlayerScene> cls) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(cls, "type");
            getInstance().remove(activity, cls);
        }

        public final void remove(Fragment fragment, Class<? extends BLPlayerScene> cls) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(cls, "type");
            getInstance().remove(fragment, cls);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BLPlayerService instance_delegate$lambda$0() {
        return new BLPlayerService();
    }
}