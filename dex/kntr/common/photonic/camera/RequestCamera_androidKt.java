package kntr.common.photonic.camera;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import java.io.File;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: RequestCamera.android.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"createImageUri", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "rememberCameraCaptureLauncher", "Lkntr/common/photonic/camera/CameraCaptureLauncher;", "(Landroidx/compose/runtime/Composer;I)Lkntr/common/photonic/camera/CameraCaptureLauncher;", "camera_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class RequestCamera_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Uri createImageUri(Context context) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", "IMG_" + System.currentTimeMillis() + ".jpg");
        contentValues.put("mime_type", "image/jpeg");
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("relative_path", Environment.DIRECTORY_PICTURES + "/bili");
        } else {
            File picturesDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            File imageFile = new File(picturesDir, "bili/IMG_" + System.currentTimeMillis() + ".jpg");
            File parentFile = imageFile.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            contentValues.put("_data", imageFile.getAbsolutePath());
        }
        return context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
    }

    public static final CameraCaptureLauncher rememberCameraCaptureLauncher(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -521246699, "C(rememberCameraCaptureLauncher)102@4016L7,105@4072L70,109@4160L24,114@4309L134,112@4213L230,120@4506L151,120@4449L208:RequestCamera.android.kt#1prdp5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-521246699, $changed, -1, "kntr.common.photonic.camera.rememberCameraCaptureLauncher (RequestCamera.android.kt:101)");
        }
        CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Context context = (Context) consume;
        ComposerKt.sourceInformationMarkerStart($composer, 1593100699, "CC(remember):RequestCamera.android.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new MutableCameraCaptureLauncher(context);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        final MutableCameraCaptureLauncher mutableCameraCaptureLauncher = (MutableCameraCaptureLauncher) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
        ComposerKt.sourceInformationMarkerStart($composer, 683736516, "CC(remember):Effects.kt#9igjgp");
        Object it$iv$iv = $composer.rememberedValue();
        if (it$iv$iv == Composer.Companion.getEmpty()) {
            Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer);
            $composer.updateRememberedValue(value$iv$iv);
            it$iv$iv = value$iv$iv;
        }
        final CoroutineScope scope = (CoroutineScope) it$iv$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ActivityResultContract takePicture = new ActivityResultContracts.TakePicture();
        ComposerKt.sourceInformationMarkerStart($composer, 1593108347, "CC(remember):RequestCamera.android.kt#9igjgp");
        boolean invalid$iv = $composer.changedInstance(scope);
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
            Object value$iv2 = new Function1() { // from class: kntr.common.photonic.camera.RequestCamera_androidKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit rememberCameraCaptureLauncher$lambda$1$0;
                    rememberCameraCaptureLauncher$lambda$1$0 = RequestCamera_androidKt.rememberCameraCaptureLauncher$lambda$1$0(scope, mutableCameraCaptureLauncher, ((Boolean) obj).booleanValue());
                    return rememberCameraCaptureLauncher$lambda$1$0;
                }
            };
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        final ManagedActivityResultLauncher launcher = ActivityResultRegistryKt.rememberLauncherForActivityResult(takePicture, (Function1) it$iv2, $composer, 0);
        ComposerKt.sourceInformationMarkerStart($composer, 1593114668, "CC(remember):RequestCamera.android.kt#9igjgp");
        boolean invalid$iv2 = $composer.changedInstance(launcher);
        Object it$iv3 = $composer.rememberedValue();
        if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
            Object value$iv3 = new Function1() { // from class: kntr.common.photonic.camera.RequestCamera_androidKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    DisposableEffectResult rememberCameraCaptureLauncher$lambda$2$0;
                    rememberCameraCaptureLauncher$lambda$2$0 = RequestCamera_androidKt.rememberCameraCaptureLauncher$lambda$2$0(MutableCameraCaptureLauncher.this, launcher, (DisposableEffectScope) obj);
                    return rememberCameraCaptureLauncher$lambda$2$0;
                }
            };
            $composer.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.DisposableEffect(launcher, mutableCameraCaptureLauncher, (Function1) it$iv3, $composer, ManagedActivityResultLauncher.$stable | 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return mutableCameraCaptureLauncher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit rememberCameraCaptureLauncher$lambda$1$0(CoroutineScope $scope, MutableCameraCaptureLauncher $mutableCameraCaptureLauncher, boolean isSuccess) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new RequestCamera_androidKt$rememberCameraCaptureLauncher$launcher$1$1$1($mutableCameraCaptureLauncher, isSuccess, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult rememberCameraCaptureLauncher$lambda$2$0(final MutableCameraCaptureLauncher $mutableCameraCaptureLauncher, ManagedActivityResultLauncher $launcher, DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        $mutableCameraCaptureLauncher.setLauncher$camera_debug($launcher);
        return new DisposableEffectResult() { // from class: kntr.common.photonic.camera.RequestCamera_androidKt$rememberCameraCaptureLauncher$lambda$2$0$$inlined$onDispose$1
            public void dispose() {
                MutableCameraCaptureLauncher.this.setLauncher$camera_debug(null);
            }
        };
    }
}