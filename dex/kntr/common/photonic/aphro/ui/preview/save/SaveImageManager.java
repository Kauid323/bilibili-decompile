package kntr.common.photonic.aphro.ui.preview.save;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import bili.resource.common.CommonRes;
import bili.resource.common.String0_commonMainKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.Asset;
import kntr.common.photonic.permission.BPermissionState;
import kntr.common.photonic.permission.PermissionSettingNavigator_androidKt;
import kntr.common.photonic.permission.PermissionStatus;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import org.jetbrains.compose.resources.StringResource;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: SaveImageManager.android.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\nj\u0002`\u000bH\u0086@¢\u0006\u0004\b\f\u0010\rJ\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\nj\u0002`\u000bH\u0086@¢\u0006\u0002\u0010\u0013J\u001a\u0010\u0014\u001a\u00020\u00062\n\u0010\u0012\u001a\u00060\nj\u0002`\u000bH\u0082@¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"Lkntr/common/photonic/aphro/ui/preview/save/SaveImageManager;", "", "<init>", "()V", "saveImage", "Lkotlin/Result;", "", "asset", "Lkntr/common/photonic/Asset;", "platformContext", "Landroid/app/Activity;", "Lkntr/common/photonic/permission/PlatformContext;", "saveImage-0E7RQCE", "(Lkntr/common/photonic/Asset;Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkPermission", "", "state", "Lkntr/common/photonic/permission/BPermissionState;", "context", "(Lkntr/common/photonic/permission/BPermissionState;Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showPermissionDeniedAlert", "(Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SaveImageManager {
    public static final int $stable = 0;
    public static final SaveImageManager INSTANCE = new SaveImageManager();

    private SaveImageManager() {
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
    /* renamed from: saveImage-0E7RQCE  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m2317saveImage0E7RQCE(Asset asset, Activity platformContext, Continuation<? super Result<Unit>> continuation) {
        SaveImageManager$saveImage$1 saveImageManager$saveImage$1;
        Object await;
        if (continuation instanceof SaveImageManager$saveImage$1) {
            saveImageManager$saveImage$1 = (SaveImageManager$saveImage$1) continuation;
            if ((saveImageManager$saveImage$1.label & Integer.MIN_VALUE) != 0) {
                saveImageManager$saveImage$1.label -= Integer.MIN_VALUE;
                Object $result = saveImageManager$saveImage$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (saveImageManager$saveImage$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Deferred async$default = BuildersKt.async$default(SaveImageManagerKt.getSaveScope(), (CoroutineContext) null, (CoroutineStart) null, new SaveImageManager$saveImage$2(platformContext, asset, null), 3, (Object) null);
                        saveImageManager$saveImage$1.L$0 = SpillingKt.nullOutSpilledVariable(asset);
                        saveImageManager$saveImage$1.L$1 = SpillingKt.nullOutSpilledVariable(platformContext);
                        saveImageManager$saveImage$1.label = 1;
                        await = async$default.await(saveImageManager$saveImage$1);
                        if (await == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        Activity activity = (Activity) saveImageManager$saveImage$1.L$1;
                        Asset asset2 = (Asset) saveImageManager$saveImage$1.L$0;
                        ResultKt.throwOnFailure($result);
                        await = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return ((Result) await).m2645unboximpl();
            }
        }
        saveImageManager$saveImage$1 = new SaveImageManager$saveImage$1(this, continuation);
        Object $result2 = saveImageManager$saveImage$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (saveImageManager$saveImage$1.label) {
        }
        return ((Result) await).m2645unboximpl();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object checkPermission(BPermissionState state, Activity context, Continuation<? super Boolean> continuation) {
        SaveImageManager$checkPermission$1 saveImageManager$checkPermission$1;
        PermissionStatus authorization;
        Object requestAuthorization;
        if (continuation instanceof SaveImageManager$checkPermission$1) {
            saveImageManager$checkPermission$1 = (SaveImageManager$checkPermission$1) continuation;
            if ((saveImageManager$checkPermission$1.label & Integer.MIN_VALUE) != 0) {
                saveImageManager$checkPermission$1.label -= Integer.MIN_VALUE;
                Object $result = saveImageManager$checkPermission$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (saveImageManager$checkPermission$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        authorization = (PermissionStatus) state.getCurrentStatus().getValue();
                        if (authorization == PermissionStatus.Denied) {
                            saveImageManager$checkPermission$1.L$0 = SpillingKt.nullOutSpilledVariable(state);
                            saveImageManager$checkPermission$1.L$1 = SpillingKt.nullOutSpilledVariable(context);
                            saveImageManager$checkPermission$1.L$2 = SpillingKt.nullOutSpilledVariable(authorization);
                            saveImageManager$checkPermission$1.label = 1;
                            return showPermissionDeniedAlert(context, saveImageManager$checkPermission$1) == coroutine_suspended ? coroutine_suspended : Boxing.boxBoolean(false);
                        }
                        if (authorization == PermissionStatus.Undetermined) {
                            saveImageManager$checkPermission$1.L$0 = SpillingKt.nullOutSpilledVariable(state);
                            saveImageManager$checkPermission$1.L$1 = SpillingKt.nullOutSpilledVariable(context);
                            saveImageManager$checkPermission$1.L$2 = SpillingKt.nullOutSpilledVariable(authorization);
                            saveImageManager$checkPermission$1.label = 2;
                            requestAuthorization = state.requestAuthorization(saveImageManager$checkPermission$1);
                            if (requestAuthorization == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            authorization = (PermissionStatus) requestAuthorization;
                        }
                        return Boxing.boxBoolean(authorization.isGranted());
                    case 1:
                        PermissionStatus permissionStatus = (PermissionStatus) saveImageManager$checkPermission$1.L$2;
                        Activity activity = (Activity) saveImageManager$checkPermission$1.L$1;
                        BPermissionState bPermissionState = (BPermissionState) saveImageManager$checkPermission$1.L$0;
                        ResultKt.throwOnFailure($result);
                    case 2:
                        PermissionStatus permissionStatus2 = (PermissionStatus) saveImageManager$checkPermission$1.L$2;
                        Activity activity2 = (Activity) saveImageManager$checkPermission$1.L$1;
                        BPermissionState bPermissionState2 = (BPermissionState) saveImageManager$checkPermission$1.L$0;
                        ResultKt.throwOnFailure($result);
                        requestAuthorization = $result;
                        authorization = (PermissionStatus) requestAuthorization;
                        return Boxing.boxBoolean(authorization.isGranted());
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        saveImageManager$checkPermission$1 = new SaveImageManager$checkPermission$1(this, continuation);
        Object $result2 = saveImageManager$checkPermission$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (saveImageManager$checkPermission$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00eb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object showPermissionDeniedAlert(final Activity context, Continuation<? super Unit> continuation) {
        SaveImageManager$showPermissionDeniedAlert$1 saveImageManager$showPermissionDeniedAlert$1;
        AlertDialog.Builder builder;
        Object string;
        AlertDialog.Builder title;
        Object string2;
        AlertDialog.Builder message;
        Object string3;
        Object string4;
        AlertDialog.Builder builder2;
        if (continuation instanceof SaveImageManager$showPermissionDeniedAlert$1) {
            saveImageManager$showPermissionDeniedAlert$1 = (SaveImageManager$showPermissionDeniedAlert$1) continuation;
            if ((saveImageManager$showPermissionDeniedAlert$1.label & Integer.MIN_VALUE) != 0) {
                saveImageManager$showPermissionDeniedAlert$1.label -= Integer.MIN_VALUE;
                Object $result = saveImageManager$showPermissionDeniedAlert$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (saveImageManager$showPermissionDeniedAlert$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        builder = new AlertDialog.Builder(context);
                        StringResource common_global_string_426 = String0_commonMainKt.getCommon_global_string_426(CommonRes.INSTANCE.getString());
                        saveImageManager$showPermissionDeniedAlert$1.L$0 = context;
                        saveImageManager$showPermissionDeniedAlert$1.L$1 = builder;
                        saveImageManager$showPermissionDeniedAlert$1.label = 1;
                        string = StringResourcesKt.getString(common_global_string_426, saveImageManager$showPermissionDeniedAlert$1);
                        if (string == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        title = builder.setTitle((CharSequence) string);
                        StringResource common_global_string_427 = String0_commonMainKt.getCommon_global_string_427(CommonRes.INSTANCE.getString());
                        saveImageManager$showPermissionDeniedAlert$1.L$0 = context;
                        saveImageManager$showPermissionDeniedAlert$1.L$1 = title;
                        saveImageManager$showPermissionDeniedAlert$1.label = 2;
                        string2 = StringResourcesKt.getString(common_global_string_427, saveImageManager$showPermissionDeniedAlert$1);
                        if (string2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        message = title.setMessage((CharSequence) string2);
                        StringResource common_global_string_313 = String0_commonMainKt.getCommon_global_string_313(CommonRes.INSTANCE.getString());
                        saveImageManager$showPermissionDeniedAlert$1.L$0 = context;
                        saveImageManager$showPermissionDeniedAlert$1.L$1 = message;
                        saveImageManager$showPermissionDeniedAlert$1.label = 3;
                        string3 = StringResourcesKt.getString(common_global_string_313, saveImageManager$showPermissionDeniedAlert$1);
                        if (string3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        AlertDialog.Builder positiveButton = message.setPositiveButton((CharSequence) string3, new DialogInterface.OnClickListener() { // from class: kntr.common.photonic.aphro.ui.preview.save.SaveImageManager$$ExternalSyntheticLambda0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                SaveImageManager.showPermissionDeniedAlert$lambda$0(context, dialogInterface, i);
                            }
                        });
                        StringResource common_global_string_238 = String0_commonMainKt.getCommon_global_string_238(CommonRes.INSTANCE.getString());
                        saveImageManager$showPermissionDeniedAlert$1.L$0 = SpillingKt.nullOutSpilledVariable(context);
                        saveImageManager$showPermissionDeniedAlert$1.L$1 = positiveButton;
                        saveImageManager$showPermissionDeniedAlert$1.label = 4;
                        string4 = StringResourcesKt.getString(common_global_string_238, saveImageManager$showPermissionDeniedAlert$1);
                        if (string4 != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        builder2 = positiveButton;
                        builder2.setNegativeButton((CharSequence) string4, new DialogInterface.OnClickListener() { // from class: kntr.common.photonic.aphro.ui.preview.save.SaveImageManager$$ExternalSyntheticLambda1
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).show();
                        return Unit.INSTANCE;
                    case 1:
                        builder = (AlertDialog.Builder) saveImageManager$showPermissionDeniedAlert$1.L$1;
                        context = (Activity) saveImageManager$showPermissionDeniedAlert$1.L$0;
                        ResultKt.throwOnFailure($result);
                        string = $result;
                        title = builder.setTitle((CharSequence) string);
                        StringResource common_global_string_4272 = String0_commonMainKt.getCommon_global_string_427(CommonRes.INSTANCE.getString());
                        saveImageManager$showPermissionDeniedAlert$1.L$0 = context;
                        saveImageManager$showPermissionDeniedAlert$1.L$1 = title;
                        saveImageManager$showPermissionDeniedAlert$1.label = 2;
                        string2 = StringResourcesKt.getString(common_global_string_4272, saveImageManager$showPermissionDeniedAlert$1);
                        if (string2 == coroutine_suspended) {
                        }
                        message = title.setMessage((CharSequence) string2);
                        StringResource common_global_string_3132 = String0_commonMainKt.getCommon_global_string_313(CommonRes.INSTANCE.getString());
                        saveImageManager$showPermissionDeniedAlert$1.L$0 = context;
                        saveImageManager$showPermissionDeniedAlert$1.L$1 = message;
                        saveImageManager$showPermissionDeniedAlert$1.label = 3;
                        string3 = StringResourcesKt.getString(common_global_string_3132, saveImageManager$showPermissionDeniedAlert$1);
                        if (string3 == coroutine_suspended) {
                        }
                        AlertDialog.Builder positiveButton2 = message.setPositiveButton((CharSequence) string3, new DialogInterface.OnClickListener() { // from class: kntr.common.photonic.aphro.ui.preview.save.SaveImageManager$$ExternalSyntheticLambda0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                SaveImageManager.showPermissionDeniedAlert$lambda$0(context, dialogInterface, i);
                            }
                        });
                        StringResource common_global_string_2382 = String0_commonMainKt.getCommon_global_string_238(CommonRes.INSTANCE.getString());
                        saveImageManager$showPermissionDeniedAlert$1.L$0 = SpillingKt.nullOutSpilledVariable(context);
                        saveImageManager$showPermissionDeniedAlert$1.L$1 = positiveButton2;
                        saveImageManager$showPermissionDeniedAlert$1.label = 4;
                        string4 = StringResourcesKt.getString(common_global_string_2382, saveImageManager$showPermissionDeniedAlert$1);
                        if (string4 != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        title = (AlertDialog.Builder) saveImageManager$showPermissionDeniedAlert$1.L$1;
                        context = (Activity) saveImageManager$showPermissionDeniedAlert$1.L$0;
                        ResultKt.throwOnFailure($result);
                        string2 = $result;
                        message = title.setMessage((CharSequence) string2);
                        StringResource common_global_string_31322 = String0_commonMainKt.getCommon_global_string_313(CommonRes.INSTANCE.getString());
                        saveImageManager$showPermissionDeniedAlert$1.L$0 = context;
                        saveImageManager$showPermissionDeniedAlert$1.L$1 = message;
                        saveImageManager$showPermissionDeniedAlert$1.label = 3;
                        string3 = StringResourcesKt.getString(common_global_string_31322, saveImageManager$showPermissionDeniedAlert$1);
                        if (string3 == coroutine_suspended) {
                        }
                        AlertDialog.Builder positiveButton22 = message.setPositiveButton((CharSequence) string3, new DialogInterface.OnClickListener() { // from class: kntr.common.photonic.aphro.ui.preview.save.SaveImageManager$$ExternalSyntheticLambda0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                SaveImageManager.showPermissionDeniedAlert$lambda$0(context, dialogInterface, i);
                            }
                        });
                        StringResource common_global_string_23822 = String0_commonMainKt.getCommon_global_string_238(CommonRes.INSTANCE.getString());
                        saveImageManager$showPermissionDeniedAlert$1.L$0 = SpillingKt.nullOutSpilledVariable(context);
                        saveImageManager$showPermissionDeniedAlert$1.L$1 = positiveButton22;
                        saveImageManager$showPermissionDeniedAlert$1.label = 4;
                        string4 = StringResourcesKt.getString(common_global_string_23822, saveImageManager$showPermissionDeniedAlert$1);
                        if (string4 != coroutine_suspended) {
                        }
                        break;
                    case 3:
                        message = (AlertDialog.Builder) saveImageManager$showPermissionDeniedAlert$1.L$1;
                        context = (Activity) saveImageManager$showPermissionDeniedAlert$1.L$0;
                        ResultKt.throwOnFailure($result);
                        string3 = $result;
                        AlertDialog.Builder positiveButton222 = message.setPositiveButton((CharSequence) string3, new DialogInterface.OnClickListener() { // from class: kntr.common.photonic.aphro.ui.preview.save.SaveImageManager$$ExternalSyntheticLambda0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                SaveImageManager.showPermissionDeniedAlert$lambda$0(context, dialogInterface, i);
                            }
                        });
                        StringResource common_global_string_238222 = String0_commonMainKt.getCommon_global_string_238(CommonRes.INSTANCE.getString());
                        saveImageManager$showPermissionDeniedAlert$1.L$0 = SpillingKt.nullOutSpilledVariable(context);
                        saveImageManager$showPermissionDeniedAlert$1.L$1 = positiveButton222;
                        saveImageManager$showPermissionDeniedAlert$1.label = 4;
                        string4 = StringResourcesKt.getString(common_global_string_238222, saveImageManager$showPermissionDeniedAlert$1);
                        if (string4 != coroutine_suspended) {
                        }
                        break;
                    case 4:
                        builder2 = (AlertDialog.Builder) saveImageManager$showPermissionDeniedAlert$1.L$1;
                        Activity activity = (Activity) saveImageManager$showPermissionDeniedAlert$1.L$0;
                        ResultKt.throwOnFailure($result);
                        string4 = $result;
                        builder2.setNegativeButton((CharSequence) string4, new DialogInterface.OnClickListener() { // from class: kntr.common.photonic.aphro.ui.preview.save.SaveImageManager$$ExternalSyntheticLambda1
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).show();
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        saveImageManager$showPermissionDeniedAlert$1 = new SaveImageManager$showPermissionDeniedAlert$1(this, continuation);
        Object $result2 = saveImageManager$showPermissionDeniedAlert$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (saveImageManager$showPermissionDeniedAlert$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPermissionDeniedAlert$lambda$0(Activity $context, DialogInterface dialog, int i) {
        PermissionSettingNavigator_androidKt.navigateToPermissionSettings($context);
        dialog.dismiss();
    }
}