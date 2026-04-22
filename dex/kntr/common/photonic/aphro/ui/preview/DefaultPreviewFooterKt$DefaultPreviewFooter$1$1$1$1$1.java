package kntr.common.photonic.aphro.ui.preview;

import android.app.Activity;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.common.photonic.aphro.ui.preview.model.PreviewableAsset;
import kntr.common.photonic.aphro.ui.preview.save.SaveImageManager;
import kntr.common.photonic.permission.BPermissionState;
import kntr.common.trio.toast.Toaster;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultPreviewFooter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.aphro.ui.preview.DefaultPreviewFooterKt$DefaultPreviewFooter$1$1$1$1$1", f = "DefaultPreviewFooter.kt", i = {1}, l = {68, 73}, m = "invokeSuspend", n = {"authorized"}, s = {"Z$0"}, v = 1)
public final class DefaultPreviewFooterKt$DefaultPreviewFooter$1$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $context;
    final /* synthetic */ PreviewableAsset $currentAsset;
    final /* synthetic */ String $failToast;
    final /* synthetic */ BPermissionState $galleryPermission;
    final /* synthetic */ Activity $platformContext;
    final /* synthetic */ String $successToast;
    final /* synthetic */ Toaster $toaster;
    boolean Z$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultPreviewFooterKt$DefaultPreviewFooter$1$1$1$1$1(BPermissionState bPermissionState, Activity activity, PreviewableAsset previewableAsset, Activity activity2, Toaster toaster, String str, String str2, Continuation<? super DefaultPreviewFooterKt$DefaultPreviewFooter$1$1$1$1$1> continuation) {
        super(2, continuation);
        this.$galleryPermission = bPermissionState;
        this.$context = activity;
        this.$currentAsset = previewableAsset;
        this.$platformContext = activity2;
        this.$toaster = toaster;
        this.$successToast = str;
        this.$failToast = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultPreviewFooterKt$DefaultPreviewFooter$1$1$1$1$1(this.$galleryPermission, this.$context, this.$currentAsset, this.$platformContext, this.$toaster, this.$successToast, this.$failToast, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object checkPermission;
        Exception e;
        boolean authorized;
        Object obj;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                checkPermission = SaveImageManager.INSTANCE.checkPermission(this.$galleryPermission, this.$context, (Continuation) this);
                if (checkPermission == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                checkPermission = $result;
                break;
            case 2:
                authorized = this.Z$0;
                try {
                    ResultKt.throwOnFailure($result);
                    obj = ((Result) $result).m2645unboximpl();
                    ResultKt.throwOnFailure(obj);
                    KLog_androidKt.getKLog().i("Preview", "save image success");
                    Toaster.CC.showToast$default(this.$toaster, this.$successToast, null, 2, null);
                } catch (Exception e2) {
                    e = e2;
                    JobKt.ensureActive(getContext());
                    KLog_androidKt.getKLog().e("Preview", "save image failed", e);
                    Toaster.CC.showToast$default(this.$toaster, this.$failToast, null, 2, null);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        boolean authorized2 = ((Boolean) checkPermission).booleanValue();
        KLog_androidKt.getKLog().i("Preview", "save image authorized: " + (authorized2));
        if (authorized2) {
            try {
                this.Z$0 = authorized2;
                this.label = 2;
                Object m2317saveImage0E7RQCE = SaveImageManager.INSTANCE.m2317saveImage0E7RQCE(this.$currentAsset, this.$platformContext, (Continuation) this);
                if (m2317saveImage0E7RQCE == coroutine_suspended) {
                    return coroutine_suspended;
                }
                authorized = authorized2;
                obj = m2317saveImage0E7RQCE;
                ResultKt.throwOnFailure(obj);
                KLog_androidKt.getKLog().i("Preview", "save image success");
                Toaster.CC.showToast$default(this.$toaster, this.$successToast, null, 2, null);
            } catch (Exception e3) {
                e = e3;
                authorized = authorized2;
                JobKt.ensureActive(getContext());
                KLog_androidKt.getKLog().e("Preview", "save image failed", e);
                Toaster.CC.showToast$default(this.$toaster, this.$failToast, null, 2, null);
                return Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }
}