package kntr.common.photonic.camera;

import android.content.Context;
import android.net.Uri;
import androidx.activity.compose.ManagedActivityResultLauncher;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.common.photonic.Asset;
import kntr.common.photonic.AssetEntry;
import kntr.common.photonic.camera.CameraCaptureResultStatus;
import kntr.common.photonic.finder.AssetFinder;
import kntr.common.photonic.finder.AssetFinderHolder;
import kntr.common.photonic.gallery.entity.AndroidImage;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: RequestCamera.android.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0012\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lkntr/common/photonic/camera/MutableCameraCaptureLauncher;", "Lkntr/common/photonic/camera/CameraCaptureLauncher;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "launcher", "Landroidx/activity/compose/ManagedActivityResultLauncher;", "Landroid/net/Uri;", "", "getLauncher$camera_debug", "()Landroidx/activity/compose/ManagedActivityResultLauncher;", "setLauncher$camera_debug", "(Landroidx/activity/compose/ManagedActivityResultLauncher;)V", "uri", "continuation", "Lkotlin/coroutines/Continuation;", "Lkntr/common/photonic/camera/CameraCaptureResultStatus;", "launch", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleResult", "", "success", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "camera_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class MutableCameraCaptureLauncher implements CameraCaptureLauncher {
    public static final int $stable = 0;
    private final Context context;
    private Continuation<? super CameraCaptureResultStatus> continuation;
    private ManagedActivityResultLauncher<Uri, Boolean> launcher;
    private Uri uri;

    public MutableCameraCaptureLauncher(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final ManagedActivityResultLauncher<Uri, Boolean> getLauncher$camera_debug() {
        return this.launcher;
    }

    public final void setLauncher$camera_debug(ManagedActivityResultLauncher<Uri, Boolean> managedActivityResultLauncher) {
        this.launcher = managedActivityResultLauncher;
    }

    @Override // kntr.common.photonic.camera.CameraCaptureLauncher
    public Object launch(Continuation<? super CameraCaptureResultStatus> continuation) {
        Uri uri;
        uri = RequestCamera_androidKt.createImageUri(this.context);
        this.uri = uri;
        KLog_androidKt.getKLog().i(RequestCameraKt.TAG, "Saving image to URI: " + uri);
        Continuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        Continuation cont = safeContinuation;
        this.continuation = cont;
        if (uri != null && this.launcher != null) {
            ManagedActivityResultLauncher<Uri, Boolean> managedActivityResultLauncher = this.launcher;
            if (managedActivityResultLauncher != null) {
                managedActivityResultLauncher.launch(uri);
            } else {
                Result.Companion companion = Result.Companion;
                cont.resumeWith(Result.m2636constructorimpl(CameraCaptureResultStatus.Canceled.INSTANCE));
            }
        } else {
            Result.Companion companion2 = Result.Companion;
            cont.resumeWith(Result.m2636constructorimpl(CameraCaptureResultStatus.Canceled.INSTANCE));
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00de A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x010e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handleResult(boolean success, Continuation<? super Unit> continuation) {
        MutableCameraCaptureLauncher$handleResult$1 mutableCameraCaptureLauncher$handleResult$1;
        Uri resultUri;
        Result result;
        Object obj;
        Asset asset;
        Uri it;
        CameraCaptureResultStatus result2;
        Continuation<? super CameraCaptureResultStatus> continuation2;
        if (continuation instanceof MutableCameraCaptureLauncher$handleResult$1) {
            mutableCameraCaptureLauncher$handleResult$1 = (MutableCameraCaptureLauncher$handleResult$1) continuation;
            if ((mutableCameraCaptureLauncher$handleResult$1.label & Integer.MIN_VALUE) != 0) {
                mutableCameraCaptureLauncher$handleResult$1.label -= Integer.MIN_VALUE;
                Object $result = mutableCameraCaptureLauncher$handleResult$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (mutableCameraCaptureLauncher$handleResult$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        resultUri = this.uri;
                        if (resultUri != null) {
                            AssetFinderHolder finder = AssetEntry.INSTANCE.getFinder();
                            String qualifiedName = Reflection.getOrCreateKotlinClass(AndroidImage.class).getQualifiedName();
                            if (qualifiedName == null) {
                                qualifiedName = "kntr.common.photonic.gallery.entity.AndroidImage";
                            }
                            AssetFinder<? extends Asset> finderForAssetType = finder.getFinderForAssetType(qualifiedName);
                            if (finderForAssetType != null) {
                                String uri = resultUri.toString();
                                Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
                                mutableCameraCaptureLauncher$handleResult$1.L$0 = resultUri;
                                mutableCameraCaptureLauncher$handleResult$1.L$1 = SpillingKt.nullOutSpilledVariable(resultUri);
                                mutableCameraCaptureLauncher$handleResult$1.Z$0 = success;
                                mutableCameraCaptureLauncher$handleResult$1.I$0 = 0;
                                mutableCameraCaptureLauncher$handleResult$1.label = 1;
                                Object mo2332findAssetByIdentifiergIAlus = finderForAssetType.mo2332findAssetByIdentifiergIAlus(uri, mutableCameraCaptureLauncher$handleResult$1);
                                if (mo2332findAssetByIdentifiergIAlus == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                obj = mo2332findAssetByIdentifiergIAlus;
                                result = Result.m2635boximpl(obj);
                                if (result != null) {
                                    Object m2645unboximpl = result.m2645unboximpl();
                                    if (Result.m2642isFailureimpl(m2645unboximpl)) {
                                        m2645unboximpl = null;
                                    }
                                    asset = (Asset) m2645unboximpl;
                                    KLog_androidKt.getKLog().i(RequestCameraKt.TAG, "Request result " + success + ", find asset from uri: " + resultUri + " , asset not null: " + (asset != null));
                                    if (!success && asset != null) {
                                        result2 = new CameraCaptureResultStatus.ConfirmedAsset(asset);
                                    } else {
                                        it = this.uri;
                                        if (it != null) {
                                            Boxing.boxInt(this.context.getContentResolver().delete(it, null, null));
                                        }
                                        KLog_androidKt.getKLog().w(RequestCameraKt.TAG, "Failed to capture image. Asset is null.");
                                        result2 = CameraCaptureResultStatus.Canceled.INSTANCE;
                                    }
                                    continuation2 = this.continuation;
                                    if (continuation2 != null) {
                                        Result.Companion companion = Result.Companion;
                                        continuation2.resumeWith(Result.m2636constructorimpl(result2));
                                    }
                                    this.continuation = null;
                                    return Unit.INSTANCE;
                                }
                            } else {
                                result = null;
                                if (result != null) {
                                }
                            }
                        }
                        asset = null;
                        KLog_androidKt.getKLog().i(RequestCameraKt.TAG, "Request result " + success + ", find asset from uri: " + resultUri + " , asset not null: " + (asset != null));
                        if (!success) {
                        }
                        it = this.uri;
                        if (it != null) {
                        }
                        KLog_androidKt.getKLog().w(RequestCameraKt.TAG, "Failed to capture image. Asset is null.");
                        result2 = CameraCaptureResultStatus.Canceled.INSTANCE;
                        continuation2 = this.continuation;
                        if (continuation2 != null) {
                        }
                        this.continuation = null;
                        return Unit.INSTANCE;
                    case 1:
                        int i = mutableCameraCaptureLauncher$handleResult$1.I$0;
                        success = mutableCameraCaptureLauncher$handleResult$1.Z$0;
                        Uri uri2 = (Uri) mutableCameraCaptureLauncher$handleResult$1.L$1;
                        resultUri = (Uri) mutableCameraCaptureLauncher$handleResult$1.L$0;
                        ResultKt.throwOnFailure($result);
                        obj = ((Result) $result).m2645unboximpl();
                        result = Result.m2635boximpl(obj);
                        if (result != null) {
                        }
                        asset = null;
                        KLog_androidKt.getKLog().i(RequestCameraKt.TAG, "Request result " + success + ", find asset from uri: " + resultUri + " , asset not null: " + (asset != null));
                        if (!success) {
                        }
                        it = this.uri;
                        if (it != null) {
                        }
                        KLog_androidKt.getKLog().w(RequestCameraKt.TAG, "Failed to capture image. Asset is null.");
                        result2 = CameraCaptureResultStatus.Canceled.INSTANCE;
                        continuation2 = this.continuation;
                        if (continuation2 != null) {
                        }
                        this.continuation = null;
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        mutableCameraCaptureLauncher$handleResult$1 = new MutableCameraCaptureLauncher$handleResult$1(this, continuation);
        Object $result2 = mutableCameraCaptureLauncher$handleResult$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (mutableCameraCaptureLauncher$handleResult$1.label) {
        }
    }
}