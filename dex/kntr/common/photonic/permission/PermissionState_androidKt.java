package kntr.common.photonic.permission;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.permission.AndroidPermissionStatus;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PermissionState.android.kt */
@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0001¢\u0006\u0002\u0010\b\u001a=\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f2 \b\u0002\u0010\r\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u000e\u0012\u0004\u0012\u00020\u00070\u0005H\u0001¢\u0006\u0002\u0010\u000f\u001a!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0001¢\u0006\u0002\u0010\u0011\u001a\u0015\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0001¢\u0006\u0002\u0010\u0016\u001a\u0014\u0010\u0017\u001a\u00020\u0006*\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0014\u0010\u0019\u001a\u00020\u0006*\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\f\u0010\u001b\u001a\u00020\u001a*\u00020\u0018H\u0000\u001a%\u0010\u001c\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0001¢\u0006\u0002\u0010\u001f\u001a!\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00152\n\u0010#\u001a\u00060\u001aj\u0002`$H\u0007¢\u0006\u0002\u0010%\"\u0018\u0010&\u001a\u00020\u0006*\u00020'8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b&\u0010(\"\u0018\u0010\u0019\u001a\u00020\u0006*\u00020'8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b)\u0010(¨\u0006*²\u0006\"\u0010\u0004\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u000e\u0012\u0004\u0012\u00020\u00070\u0005X\u008a\u008e\u0002"}, d2 = {"rememberMutablePermissionState", "Lkntr/common/photonic/permission/MutablePermissionState;", "permission", "", "onPermissionResult", "Lkotlin/Function1;", "", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Lkntr/common/photonic/permission/MutablePermissionState;", "rememberMutableMultiplePermissionState", "Lkntr/common/photonic/permission/MutableMultiplePermissionState;", "permissions", "", "onPermissionsResult", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Lkntr/common/photonic/permission/MutableMultiplePermissionState;", "rememberMutablePermissionsState", "(Ljava/util/List;Landroidx/compose/runtime/Composer;I)Ljava/util/List;", "rememberMutableBPermissionState", "Lkntr/common/photonic/permission/MutableBPermissionState;", "bPermissionType", "Lkntr/common/photonic/permission/BPermissionType;", "(Lkntr/common/photonic/permission/BPermissionType;Landroidx/compose/runtime/Composer;I)Lkntr/common/photonic/permission/MutableBPermissionState;", "checkPermission", "Landroid/content/Context;", "shouldShowRationale", "Landroid/app/Activity;", "findActivity", "PermissionsLifecycleCheckerEffect", "lifecycleEvent", "Landroidx/lifecycle/Lifecycle$Event;", "(Ljava/util/List;Landroidx/lifecycle/Lifecycle$Event;Landroidx/compose/runtime/Composer;II)V", "rememberBPermissionState", "Lkntr/common/photonic/permission/BPermissionState;", "type", "context", "Lkntr/common/photonic/permission/PlatformContext;", "(Lkntr/common/photonic/permission/BPermissionType;Landroid/app/Activity;Landroidx/compose/runtime/Composer;I)Lkntr/common/photonic/permission/BPermissionState;", "isGranted", "Lkntr/common/photonic/permission/AndroidPermissionStatus;", "(Lkntr/common/photonic/permission/AndroidPermissionStatus;)Z", "getShouldShowRationale", "permission_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PermissionState_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PermissionsLifecycleCheckerEffect$lambda$2(List list, Lifecycle.Event event, int i, int i2, Composer composer, int i3) {
        PermissionsLifecycleCheckerEffect(list, event, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private static int __Ghost$Insertion$com_bilibili_infra_base_aop_StoragePermissionHook_checkSelfPermission(Context context, String permission) {
        String finalPerm = permission;
        if (Build.VERSION.SDK_INT >= 33) {
            if ("android.permission.READ_EXTERNAL_STORAGE".equals(permission)) {
                finalPerm = "android.permission.READ_MEDIA_IMAGES";
            } else if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(permission)) {
                return 0;
            }
        }
        return Integer.valueOf(ContextCompat.checkSelfPermission(context, finalPerm)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit rememberMutablePermissionState$lambda$0$0(boolean it) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v14 */
    public static final MutablePermissionState rememberMutablePermissionState(String permission, Function1<? super Boolean, Unit> function1, Composer $composer, int $changed, int i) {
        final Function1 onPermissionResult;
        Intrinsics.checkNotNullParameter(permission, "permission");
        ComposerKt.sourceInformationMarkerStart($composer, -1783112755, "C(rememberMutablePermissionState)N(permission,onPermissionResult)38@1629L2,40@1692L7,42@1734L209,50@1969L58,55@2184L100,53@2071L213,60@2334L125,60@2290L169:PermissionState.android.kt#2xlo5t");
        if ((i & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart($composer, 120596879, "CC(remember):PermissionState.android.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.common.photonic.permission.PermissionState_androidKt$$ExternalSyntheticLambda8
                    public final Object invoke(Object obj) {
                        Unit rememberMutablePermissionState$lambda$0$0;
                        rememberMutablePermissionState$lambda$0$0 = PermissionState_androidKt.rememberMutablePermissionState$lambda$0$0(((Boolean) obj).booleanValue());
                        return rememberMutablePermissionState$lambda$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            onPermissionResult = it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
        } else {
            onPermissionResult = function1;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1783112755, $changed, -1, "kntr.common.photonic.permission.rememberMutablePermissionState (PermissionState.android.kt:39)");
        }
        CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Context context = (Context) consume;
        ComposerKt.sourceInformationMarkerStart($composer, 120600446, "CC(remember):PermissionState.android.kt#9igjgp");
        boolean invalid$iv = ((($changed & 14) ^ 6) > 4 && $composer.changed(permission)) || ($changed & 6) == 4;
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
            Object value$iv2 = new MutablePermissionState(permission, context, findActivity(context));
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
        }
        final MutablePermissionState permissionState = (MutablePermissionState) it$iv2;
        ComposerKt.sourceInformationMarkerEnd($composer);
        PermissionsLifecycleCheckerEffect(CollectionsKt.listOf(permissionState), null, $composer, 0, 2);
        ActivityResultContract requestPermission = new ActivityResultContracts.RequestPermission();
        ComposerKt.sourceInformationMarkerStart($composer, 120614737, "CC(remember):PermissionState.android.kt#9igjgp");
        boolean invalid$iv2 = $composer.changed(permissionState) | (((($changed & 112) ^ 48) > 32 && $composer.changed(onPermissionResult)) || ($changed & 48) == 32);
        Object it$iv3 = $composer.rememberedValue();
        if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
            Object value$iv3 = new Function1() { // from class: kntr.common.photonic.permission.PermissionState_androidKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj) {
                    Unit rememberMutablePermissionState$lambda$2$0;
                    rememberMutablePermissionState$lambda$2$0 = PermissionState_androidKt.rememberMutablePermissionState$lambda$2$0(MutablePermissionState.this, onPermissionResult, ((Boolean) obj).booleanValue());
                    return rememberMutablePermissionState$lambda$2$0;
                }
            };
            $composer.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        final ManagedActivityResultLauncher launcher = ActivityResultRegistryKt.rememberLauncherForActivityResult(requestPermission, (Function1) it$iv3, $composer, 0);
        ComposerKt.sourceInformationMarkerStart($composer, 120619562, "CC(remember):PermissionState.android.kt#9igjgp");
        boolean invalid$iv3 = $composer.changed(permissionState) | $composer.changedInstance(launcher);
        Object it$iv4 = $composer.rememberedValue();
        if (invalid$iv3 || it$iv4 == Composer.Companion.getEmpty()) {
            Object value$iv4 = new Function1() { // from class: kntr.common.photonic.permission.PermissionState_androidKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj) {
                    DisposableEffectResult rememberMutablePermissionState$lambda$3$0;
                    rememberMutablePermissionState$lambda$3$0 = PermissionState_androidKt.rememberMutablePermissionState$lambda$3$0(MutablePermissionState.this, launcher, (DisposableEffectScope) obj);
                    return rememberMutablePermissionState$lambda$3$0;
                }
            };
            $composer.updateRememberedValue(value$iv4);
            it$iv4 = value$iv4;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.DisposableEffect(permissionState, launcher, (Function1) it$iv4, $composer, ManagedActivityResultLauncher.$stable << 3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return permissionState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit rememberMutablePermissionState$lambda$2$0(MutablePermissionState $permissionState, Function1 $onPermissionResult, boolean it) {
        $permissionState.refreshPermissionStatus$permission_debug();
        $onPermissionResult.invoke(Boolean.valueOf(it));
        return Unit.INSTANCE;
    }

    private static boolean __Ghost$Insertion$com_bilibili_infra_base_aop_StoragePermissionHook_shouldShowRequestPermissionRationale(Activity activity, String permission) {
        String finalPerm = permission;
        if (Build.VERSION.SDK_INT >= 33) {
            if ("android.permission.READ_EXTERNAL_STORAGE".equals(permission)) {
                finalPerm = "android.permission.READ_MEDIA_IMAGES";
            } else if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(permission)) {
                return false;
            }
        }
        return Boolean.valueOf(ActivityCompat.shouldShowRequestPermissionRationale(activity, finalPerm)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult rememberMutablePermissionState$lambda$3$0(final MutablePermissionState $permissionState, ManagedActivityResultLauncher $launcher, DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        $permissionState.setLauncher$permission_debug((ActivityResultLauncher) $launcher);
        return new DisposableEffectResult() { // from class: kntr.common.photonic.permission.PermissionState_androidKt$rememberMutablePermissionState$lambda$3$0$$inlined$onDispose$1
            public void dispose() {
                MutablePermissionState.this.setLauncher$permission_debug(null);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit rememberMutableMultiplePermissionState$lambda$0$0(Map it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v7 */
    public static final MutableMultiplePermissionState rememberMutableMultiplePermissionState(List<String> list, Function1<? super Map<String, Boolean>, Unit> function1, Composer $composer, int $changed, int i) {
        Function1 onPermissionsResult;
        Intrinsics.checkNotNullParameter(list, "permissions");
        ComposerKt.sourceInformationMarkerStart($composer, -1066221888, "C(rememberMutableMultiplePermissionState)N(permissions,onPermissionsResult)72@2644L2,74@2713L44,75@2793L41,78@2861L53,81@2958L96,88@3205L173,86@3083L295,93@3436L141,93@3384L193:PermissionState.android.kt#2xlo5t");
        if ((i & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart($composer, 1857953634, "CC(remember):PermissionState.android.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.common.photonic.permission.PermissionState_androidKt$$ExternalSyntheticLambda11
                    public final Object invoke(Object obj) {
                        Unit rememberMutableMultiplePermissionState$lambda$0$0;
                        rememberMutableMultiplePermissionState$lambda$0$0 = PermissionState_androidKt.rememberMutableMultiplePermissionState$lambda$0$0((Map) obj);
                        return rememberMutableMultiplePermissionState$lambda$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            onPermissionsResult = it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
        } else {
            onPermissionsResult = function1;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1066221888, $changed, -1, "kntr.common.photonic.permission.rememberMutableMultiplePermissionState (PermissionState.android.kt:73)");
        }
        List mutablePermissions = rememberMutablePermissionsState(list, $composer, $changed & 14);
        final State onPermissionResultEffect = SnapshotStateKt.rememberUpdatedState(onPermissionsResult, $composer, ($changed >> 3) & 14);
        PermissionsLifecycleCheckerEffect(mutablePermissions, null, $composer, 0, 2);
        ComposerKt.sourceInformationMarkerStart($composer, 1857963776, "CC(remember):PermissionState.android.kt#9igjgp");
        boolean invalid$iv = $composer.changed(list);
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
            Object value$iv2 = new MutableMultiplePermissionState(mutablePermissions);
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
        }
        final MutableMultiplePermissionState multiplePermissionState = (MutableMultiplePermissionState) it$iv2;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ActivityResultContract requestMultiplePermissions = new ActivityResultContracts.RequestMultiplePermissions();
        ComposerKt.sourceInformationMarkerStart($composer, 1857971757, "CC(remember):PermissionState.android.kt#9igjgp");
        boolean invalid$iv2 = $composer.changed(multiplePermissionState) | $composer.changed(onPermissionResultEffect);
        Object it$iv3 = $composer.rememberedValue();
        if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
            Object value$iv3 = new Function1() { // from class: kntr.common.photonic.permission.PermissionState_androidKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj) {
                    Unit rememberMutableMultiplePermissionState$lambda$2$0;
                    rememberMutableMultiplePermissionState$lambda$2$0 = PermissionState_androidKt.rememberMutableMultiplePermissionState$lambda$2$0(MutableMultiplePermissionState.this, onPermissionResultEffect, (Map) obj);
                    return rememberMutableMultiplePermissionState$lambda$2$0;
                }
            };
            $composer.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        final ManagedActivityResultLauncher launcher = ActivityResultRegistryKt.rememberLauncherForActivityResult(requestMultiplePermissions, (Function1) it$iv3, $composer, 0);
        ComposerKt.sourceInformationMarkerStart($composer, 1857979117, "CC(remember):PermissionState.android.kt#9igjgp");
        boolean invalid$iv3 = $composer.changed(multiplePermissionState) | $composer.changedInstance(launcher);
        Object it$iv4 = $composer.rememberedValue();
        if (invalid$iv3 || it$iv4 == Composer.Companion.getEmpty()) {
            Object value$iv4 = new Function1() { // from class: kntr.common.photonic.permission.PermissionState_androidKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    DisposableEffectResult rememberMutableMultiplePermissionState$lambda$3$0;
                    rememberMutableMultiplePermissionState$lambda$3$0 = PermissionState_androidKt.rememberMutableMultiplePermissionState$lambda$3$0(MutableMultiplePermissionState.this, launcher, (DisposableEffectScope) obj);
                    return rememberMutableMultiplePermissionState$lambda$3$0;
                }
            };
            $composer.updateRememberedValue(value$iv4);
            it$iv4 = value$iv4;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.DisposableEffect(multiplePermissionState, launcher, (Function1) it$iv4, $composer, ManagedActivityResultLauncher.$stable << 3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return multiplePermissionState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit rememberMutableMultiplePermissionState$lambda$2$0(MutableMultiplePermissionState $multiplePermissionState, State $onPermissionResultEffect, Map permissionsStatus) {
        Intrinsics.checkNotNullParameter(permissionsStatus, "permissionsStatus");
        $multiplePermissionState.updatePermissionsStatus$permission_debug(permissionsStatus);
        ((Function1) $onPermissionResultEffect.getValue()).invoke(permissionsStatus);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult rememberMutableMultiplePermissionState$lambda$3$0(final MutableMultiplePermissionState $multiplePermissionState, ManagedActivityResultLauncher $launcher, DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        $multiplePermissionState.setLauncher$permission_debug((ActivityResultLauncher) $launcher);
        return new DisposableEffectResult() { // from class: kntr.common.photonic.permission.PermissionState_androidKt$rememberMutableMultiplePermissionState$lambda$3$0$$inlined$onDispose$1
            public void dispose() {
                MutableMultiplePermissionState.this.setLauncher$permission_debug(null);
            }
        };
    }

    public static final List<MutablePermissionState> rememberMutablePermissionsState(List<String> list, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(list, "permissions");
        ComposerKt.sourceInformationMarkerStart($composer, 1965614224, "C(rememberMutablePermissionsState)N(permissions)104@3763L7,107@3850L274:PermissionState.android.kt#2xlo5t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1965614224, $changed, -1, "kntr.common.photonic.permission.rememberMutablePermissionsState (PermissionState.android.kt:103)");
        }
        CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Context context = (Context) consume;
        Activity activity = findActivity(context);
        ComposerKt.sourceInformationMarkerStart($composer, -830333886, "CC(remember):PermissionState.android.kt#9igjgp");
        boolean invalid$iv = $composer.changed(list);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            List<String> $this$map$iv = list;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                String permission = (String) item$iv$iv;
                destination$iv$iv.add(new MutablePermissionState(permission, context, activity));
                invalid$iv = invalid$iv;
            }
            Object value$iv = (List) destination$iv$iv;
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        List mutablePermissions = (List) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        $composer.startReplaceGroup(-830324670);
        ComposerKt.sourceInformation($composer, "");
        for (final MutablePermissionState permissionState : mutablePermissions) {
            $composer.startMovableGroup(-830323002, permissionState.getPermission());
            ComposerKt.sourceInformation($composer, "121@4389L81,119@4260L210,124@4510L165,124@4483L192");
            ActivityResultContract requestPermission = new ActivityResultContracts.RequestPermission();
            ComposerKt.sourceInformationMarkerStart($composer, -830316831, "CC(remember):PermissionState.android.kt#9igjgp");
            boolean invalid$iv2 = $composer.changed(permissionState);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: kntr.common.photonic.permission.PermissionState_androidKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        Unit rememberMutablePermissionsState$lambda$1$0;
                        rememberMutablePermissionsState$lambda$1$0 = PermissionState_androidKt.rememberMutablePermissionsState$lambda$1$0(MutablePermissionState.this, ((Boolean) obj).booleanValue());
                        return rememberMutablePermissionsState$lambda$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            final ManagedActivityResultLauncher launcher = ActivityResultRegistryKt.rememberLauncherForActivityResult(requestPermission, (Function1) it$iv2, $composer, 0);
            ComposerKt.sourceInformationMarkerStart($composer, -830312875, "CC(remember):PermissionState.android.kt#9igjgp");
            boolean invalid$iv3 = $composer.changed(permissionState) | $composer.changedInstance(launcher);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function1() { // from class: kntr.common.photonic.permission.PermissionState_androidKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        DisposableEffectResult rememberMutablePermissionsState$lambda$2$0;
                        rememberMutablePermissionsState$lambda$2$0 = PermissionState_androidKt.rememberMutablePermissionsState$lambda$2$0(MutablePermissionState.this, launcher, (DisposableEffectScope) obj);
                        return rememberMutablePermissionsState$lambda$2$0;
                    }
                };
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.DisposableEffect(launcher, (Function1) it$iv3, $composer, ManagedActivityResultLauncher.$stable);
            $composer.endMovableGroup();
        }
        $composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return mutablePermissions;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit rememberMutablePermissionsState$lambda$1$0(MutablePermissionState $permissionState, boolean it) {
        $permissionState.refreshPermissionStatus$permission_debug();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult rememberMutablePermissionsState$lambda$2$0(final MutablePermissionState $permissionState, ManagedActivityResultLauncher $launcher, DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        $permissionState.setLauncher$permission_debug((ActivityResultLauncher) $launcher);
        return new DisposableEffectResult() { // from class: kntr.common.photonic.permission.PermissionState_androidKt$rememberMutablePermissionsState$lambda$2$0$$inlined$onDispose$1
            public void dispose() {
                MutablePermissionState.this.setLauncher$permission_debug(null);
            }
        };
    }

    public static final MutableBPermissionState rememberMutableBPermissionState(BPermissionType bPermissionType, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(bPermissionType, "bPermissionType");
        ComposerKt.sourceInformationMarkerStart($composer, -1630946142, "C(rememberMutableBPermissionState)N(bPermissionType)138@4956L64,143@5177L75,141@5064L199,149@5307L194,156@5528L322,156@5507L343:PermissionState.android.kt#2xlo5t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1630946142, $changed, -1, "kntr.common.photonic.permission.rememberMutableBPermissionState (PermissionState.android.kt:136)");
        }
        List permissions = AndroidPermissionType.Companion.fromBPermission(bPermissionType).getValue();
        ComposerKt.sourceInformationMarkerStart($composer, 323827362, "CC(remember):PermissionState.android.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = SnapshotStateKt.mutableStateOf$default(new Function1() { // from class: kntr.common.photonic.permission.PermissionState_androidKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit rememberMutableBPermissionState$lambda$0$0;
                    rememberMutableBPermissionState$lambda$0$0 = PermissionState_androidKt.rememberMutableBPermissionState$lambda$0$0((Map) obj);
                    return rememberMutableBPermissionState$lambda$0$0;
                }
            }, (SnapshotMutationPolicy) null, 2, (Object) null);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        final MutableState onPermissionResult$delegate = (MutableState) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, 323834445, "CC(remember):PermissionState.android.kt#9igjgp");
        Object it$iv2 = $composer.rememberedValue();
        if (it$iv2 == Composer.Companion.getEmpty()) {
            Object value$iv2 = new Function1() { // from class: kntr.common.photonic.permission.PermissionState_androidKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj) {
                    Unit rememberMutableBPermissionState$lambda$3$0;
                    rememberMutableBPermissionState$lambda$3$0 = PermissionState_androidKt.rememberMutableBPermissionState$lambda$3$0(onPermissionResult$delegate, (Map) obj);
                    return rememberMutableBPermissionState$lambda$3$0;
                }
            };
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        MutableMultiplePermissionState multiplePermissionState = rememberMutableMultiplePermissionState(permissions, (Function1) it$iv2, $composer, 48, 0);
        ComposerKt.sourceInformationMarkerStart($composer, 323838724, "CC(remember):PermissionState.android.kt#9igjgp");
        boolean invalid$iv = ((($changed & 14) ^ 6) > 4 && $composer.changed(bPermissionType.ordinal())) || ($changed & 6) == 4;
        Object it$iv3 = $composer.rememberedValue();
        if (invalid$iv || it$iv3 == Composer.Companion.getEmpty()) {
            Object value$iv3 = new MutableBPermissionState(bPermissionType, multiplePermissionState);
            $composer.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
        }
        MutableBPermissionState mutableBPermissionState = (MutableBPermissionState) it$iv3;
        ComposerKt.sourceInformationMarkerEnd($composer);
        Unit unit = Unit.INSTANCE;
        ComposerKt.sourceInformationMarkerStart($composer, 323845924, "CC(remember):PermissionState.android.kt#9igjgp");
        boolean invalid$iv2 = $composer.changed(mutableBPermissionState);
        Object it$iv4 = $composer.rememberedValue();
        if (invalid$iv2 || it$iv4 == Composer.Companion.getEmpty()) {
            Object value$iv4 = (Function2) new PermissionState_androidKt$rememberMutableBPermissionState$1$1(mutableBPermissionState, onPermissionResult$delegate, null);
            $composer.updateRememberedValue(value$iv4);
            it$iv4 = value$iv4;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(unit, (Function2) it$iv4, $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return mutableBPermissionState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit rememberMutableBPermissionState$lambda$0$0(Map result) {
        Intrinsics.checkNotNullParameter(result, "result");
        return Unit.INSTANCE;
    }

    private static final Function1<Map<String, Boolean>, Unit> rememberMutableBPermissionState$lambda$1(MutableState<Function1<Map<String, Boolean>, Unit>> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (Function1) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit rememberMutableBPermissionState$lambda$3$0(MutableState $onPermissionResult$delegate, Map result) {
        Intrinsics.checkNotNullParameter(result, "result");
        rememberMutableBPermissionState$lambda$1($onPermissionResult$delegate).invoke(result);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean checkPermission(Context $this$checkPermission, String permission) {
        return __Ghost$Insertion$com_bilibili_infra_base_aop_StoragePermissionHook_checkSelfPermission($this$checkPermission, permission) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean shouldShowRationale(Activity $this$shouldShowRationale, String permission) {
        return __Ghost$Insertion$com_bilibili_infra_base_aop_StoragePermissionHook_shouldShowRequestPermissionRationale($this$shouldShowRationale, permission);
    }

    public static final Activity findActivity(Context $this$findActivity) {
        Intrinsics.checkNotNullParameter($this$findActivity, "<this>");
        Context context = $this$findActivity;
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            Intrinsics.checkNotNullExpressionValue(baseContext, "getBaseContext(...)");
            context = baseContext;
        }
        throw new IllegalStateException("function should be called in the context of an Activity");
    }

    public static final void PermissionsLifecycleCheckerEffect(final List<MutablePermissionState> list, final Lifecycle.Event lifecycleEvent, Composer $composer, final int $changed, final int i) {
        Intrinsics.checkNotNullParameter(list, "permissions");
        Composer $composer2 = $composer.startRestartGroup(980459746);
        ComposerKt.sourceInformation($composer2, "C(PermissionsLifecycleCheckerEffect)N(permissions,lifecycleEvent)316@11203L412,327@11656L7,328@11734L140,328@11678L196:PermissionState.android.kt#2xlo5t");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(lifecycleEvent == null ? -1 : ((Enum) lifecycleEvent).ordinal()) ? 32 : 16;
        }
        if (!$composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                lifecycleEvent = Lifecycle.Event.ON_RESUME;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(980459746, $dirty, -1, "kntr.common.photonic.permission.PermissionsLifecycleCheckerEffect (PermissionState.android.kt:314)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 1623984894, "CC(remember):PermissionState.android.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(list);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new LifecycleEventObserver() { // from class: kntr.common.photonic.permission.PermissionState_androidKt$$ExternalSyntheticLambda5
                    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                        PermissionState_androidKt.PermissionsLifecycleCheckerEffect$lambda$0$0(lifecycleEvent, list, lifecycleOwner, event);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final LifecycleEventObserver permissionsCheckerObserver = (LifecycleEventObserver) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CompositionLocal this_$iv = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Lifecycle lifecycle = ((LifecycleOwner) consume).getLifecycle();
            ComposerKt.sourceInformationMarkerStart($composer2, 1624001614, "CC(remember):PermissionState.android.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changedInstance(lifecycle) | $composer2.changedInstance(permissionsCheckerObserver);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: kntr.common.photonic.permission.PermissionState_androidKt$$ExternalSyntheticLambda6
                    public final Object invoke(Object obj) {
                        DisposableEffectResult PermissionsLifecycleCheckerEffect$lambda$1$0;
                        PermissionsLifecycleCheckerEffect$lambda$1$0 = PermissionState_androidKt.PermissionsLifecycleCheckerEffect$lambda$1$0(lifecycle, permissionsCheckerObserver, (DisposableEffectScope) obj);
                        return PermissionsLifecycleCheckerEffect$lambda$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.DisposableEffect(lifecycle, permissionsCheckerObserver, (Function1) it$iv2, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.permission.PermissionState_androidKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit PermissionsLifecycleCheckerEffect$lambda$2;
                    PermissionsLifecycleCheckerEffect$lambda$2 = PermissionState_androidKt.PermissionsLifecycleCheckerEffect$lambda$2(list, lifecycleEvent, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PermissionsLifecycleCheckerEffect$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PermissionsLifecycleCheckerEffect$lambda$0$0(Lifecycle.Event $lifecycleEvent, List $permissions, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == $lifecycleEvent) {
            Iterator it = $permissions.iterator();
            while (it.hasNext()) {
                MutablePermissionState permission = (MutablePermissionState) it.next();
                if (!Intrinsics.areEqual(permission.getStatus(), AndroidPermissionStatus.Granted.INSTANCE)) {
                    permission.refreshPermissionStatus$permission_debug();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult PermissionsLifecycleCheckerEffect$lambda$1$0(final Lifecycle $lifecycle, final LifecycleEventObserver $permissionsCheckerObserver, DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        $lifecycle.addObserver((LifecycleObserver) $permissionsCheckerObserver);
        return new DisposableEffectResult() { // from class: kntr.common.photonic.permission.PermissionState_androidKt$PermissionsLifecycleCheckerEffect$lambda$1$0$$inlined$onDispose$1
            public void dispose() {
                $lifecycle.removeObserver($permissionsCheckerObserver);
            }
        };
    }

    public static final BPermissionState rememberBPermissionState(BPermissionType type, Activity context, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(context, "context");
        ComposerKt.sourceInformationMarkerStart($composer, -1404819549, "C(rememberBPermissionState)N(type,context)338@12006L55:PermissionState.android.kt#2xlo5t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1404819549, $changed, -1, "kntr.common.photonic.permission.rememberBPermissionState (PermissionState.android.kt:338)");
        }
        MutableBPermissionState rememberMutableBPermissionState = rememberMutableBPermissionState(type, $composer, $changed & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return rememberMutableBPermissionState;
    }

    public static final boolean isGranted(AndroidPermissionStatus $this$isGranted) {
        Intrinsics.checkNotNullParameter($this$isGranted, "<this>");
        return $this$isGranted instanceof AndroidPermissionStatus.Granted;
    }

    public static final boolean getShouldShowRationale(AndroidPermissionStatus $this$shouldShowRationale) {
        Intrinsics.checkNotNullParameter($this$shouldShowRationale, "<this>");
        if ($this$shouldShowRationale instanceof AndroidPermissionStatus.Granted) {
            return false;
        }
        if ($this$shouldShowRationale instanceof AndroidPermissionStatus.Denied) {
            return ((AndroidPermissionStatus.Denied) $this$shouldShowRationale).getShouldShowRationale();
        }
        throw new NoWhenBranchMatchedException();
    }
}