package kntr.common.photonic.permission;

import android.os.Build;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import java.util.Iterator;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PermissionState.android.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u001e\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010\u001fJ\u000e\u0010 \u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u001fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0015\u0010\u0017R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u001bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lkntr/common/photonic/permission/MutableBPermissionState;", "Lkntr/common/photonic/permission/BPermissionState;", "permissionType", "Lkntr/common/photonic/permission/BPermissionType;", "bPermissions", "Lkntr/common/photonic/permission/MultiplePermissionState;", "<init>", "(Lkntr/common/photonic/permission/BPermissionType;Lkntr/common/photonic/permission/MultiplePermissionState;)V", "getPermissionType", "()Lkntr/common/photonic/permission/BPermissionType;", "authorizationContinuation", "Lkotlin/coroutines/Continuation;", "Lkntr/common/photonic/permission/PermissionStatus;", "getAuthorizationContinuation", "()Lkotlin/coroutines/Continuation;", "setAuthorizationContinuation", "(Lkotlin/coroutines/Continuation;)V", "requestMoreAssetsContinuation", "", "getRequestMoreAssetsContinuation", "setRequestMoreAssetsContinuation", "isPartialGranted", "", "()Z", "isPartialGranted$delegate", "Landroidx/compose/runtime/State;", "currentStatus", "Landroidx/compose/runtime/State;", "getCurrentStatus", "()Landroidx/compose/runtime/State;", "requestMoreAssets", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestAuthorization", "permission_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class MutableBPermissionState implements BPermissionState {
    public static final int $stable = 0;
    private Continuation<? super PermissionStatus> authorizationContinuation;
    private final MultiplePermissionState bPermissions;
    private final State<PermissionStatus> currentStatus;
    private final State isPartialGranted$delegate;
    private final BPermissionType permissionType;
    private Continuation<? super Unit> requestMoreAssetsContinuation;

    /* compiled from: PermissionState.android.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BPermissionType.values().length];
            try {
                iArr[BPermissionType.GALLERY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public MutableBPermissionState(BPermissionType permissionType, MultiplePermissionState bPermissions) {
        Intrinsics.checkNotNullParameter(permissionType, "permissionType");
        Intrinsics.checkNotNullParameter(bPermissions, "bPermissions");
        this.permissionType = permissionType;
        this.bPermissions = bPermissions;
        this.isPartialGranted$delegate = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.common.photonic.permission.MutableBPermissionState$$ExternalSyntheticLambda0
            public final Object invoke() {
                boolean isPartialGranted_delegate$lambda$0;
                isPartialGranted_delegate$lambda$0 = MutableBPermissionState.isPartialGranted_delegate$lambda$0(MutableBPermissionState.this);
                return Boolean.valueOf(isPartialGranted_delegate$lambda$0);
            }
        });
        this.currentStatus = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.common.photonic.permission.MutableBPermissionState$$ExternalSyntheticLambda1
            public final Object invoke() {
                PermissionStatus currentStatus$lambda$0;
                currentStatus$lambda$0 = MutableBPermissionState.currentStatus$lambda$0(MutableBPermissionState.this);
                return currentStatus$lambda$0;
            }
        });
    }

    @Override // kntr.common.photonic.permission.BPermissionState
    public BPermissionType getPermissionType() {
        return this.permissionType;
    }

    public final Continuation<PermissionStatus> getAuthorizationContinuation() {
        return this.authorizationContinuation;
    }

    public final void setAuthorizationContinuation(Continuation<? super PermissionStatus> continuation) {
        this.authorizationContinuation = continuation;
    }

    public final Continuation<Unit> getRequestMoreAssetsContinuation() {
        return this.requestMoreAssetsContinuation;
    }

    public final void setRequestMoreAssetsContinuation(Continuation<? super Unit> continuation) {
        this.requestMoreAssetsContinuation = continuation;
    }

    private final boolean isPartialGranted() {
        State $this$getValue$iv = this.isPartialGranted$delegate;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isPartialGranted_delegate$lambda$0(MutableBPermissionState this$0) {
        Object obj;
        AndroidPermissionStatus status;
        boolean z = false;
        if (WhenMappings.$EnumSwitchMapping$0[this$0.getPermissionType().ordinal()] != 1 || Build.VERSION.SDK_INT < 34) {
            return false;
        }
        Iterator<T> it = this$0.bPermissions.getPermissions().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            PermissionState it2 = (PermissionState) obj;
            if (Intrinsics.areEqual(it2.getPermission(), "android.permission.READ_MEDIA_VISUAL_USER_SELECTED")) {
                break;
            }
        }
        PermissionState permissionState = (PermissionState) obj;
        if (permissionState != null && (status = permissionState.getStatus()) != null && PermissionState_androidKt.isGranted(status)) {
            z = true;
        }
        boolean isPartial = z;
        return isPartial;
    }

    @Override // kntr.common.photonic.permission.BPermissionState
    public State<PermissionStatus> getCurrentStatus() {
        return this.currentStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PermissionStatus currentStatus$lambda$0(MutableBPermissionState this$0) {
        if (this$0.bPermissions.getAllPermissionsGranted()) {
            return PermissionStatus.Granted;
        }
        if (this$0.isPartialGranted()) {
            return PermissionStatus.Limited;
        }
        if (!this$0.bPermissions.getRevokedPermissions().isEmpty() && this$0.bPermissions.getShouldShowRationale()) {
            return PermissionStatus.Denied;
        }
        return PermissionStatus.Undetermined;
    }

    @Override // kntr.common.photonic.permission.BPermissionState
    public Object requestMoreAssets(Continuation<? super Unit> continuation) {
        if (getPermissionType() == BPermissionType.GALLERY) {
            Continuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
            Continuation cont = safeContinuation;
            this.requestMoreAssetsContinuation = cont;
            this.bPermissions.launchMultiplePermissionRequest();
            Object orThrow = safeContinuation.getOrThrow();
            if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? orThrow : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    @Override // kntr.common.photonic.permission.BPermissionState
    public Object requestAuthorization(Continuation<? super PermissionStatus> continuation) {
        Continuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        Continuation cont = safeContinuation;
        this.authorizationContinuation = cont;
        this.bPermissions.launchMultiplePermissionRequest();
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}