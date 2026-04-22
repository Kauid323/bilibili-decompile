package kntr.base.imageloader;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.ColorPainter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.IntSize;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import java.util.concurrent.CancellationException;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.ImageState;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: BiliImage.kt */
@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\u001aÄ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0013\b\u0002\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u00132$\b\u0002\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0013¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001aÌ\u0001\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u00072\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t2\u0014\b\u0002\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00010\t2\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00010\u00122\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0013\b\u0002\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u00132$\b\u0002\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0013¢\u0006\u0002\b\u0018H\u0003¢\u0006\u0002\u0010\"\u001a\r\u0010#\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010$¨\u0006%²\u0006\n\u0010&\u001a\u00020 X\u008a\u008e\u0002²\u0006\n\u0010'\u001a\u00020(X\u008a\u008e\u0002²\u0006\n\u0010)\u001a\u00020*X\u008a\u0084\u0002²\u0006\n\u0010\u001b\u001a\u00020\nX\u008a\u008e\u0002"}, d2 = {"BiliImage", "", "request", "Lkntr/base/imageloader/ImmutableImageRequest;", "modifier", "Landroidx/compose/ui/Modifier;", "contentDescription", "", "onState", "Lkotlin/Function1;", "Lkntr/base/imageloader/ImageState;", "urlTransformation", "Lkntr/base/imageloader/ImageRequest;", "bitmapTransformation", "Lkntr/base/imageloader/Image;", "onAnimation", "Lkntr/base/imageloader/AnimationState;", "loadingPlaceholder", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "failPlaceholder", "Lkotlin/Function2;", "Lkntr/base/imageloader/ImageFailScope;", "Lkntr/base/imageloader/ImageException;", "Lkotlin/ExtensionFunctionType;", "(Lkntr/base/imageloader/ImmutableImageRequest;Landroidx/compose/ui/Modifier;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "InnerImage", "imageState", "options", "Lkntr/base/imageloader/BiliImageOptions;", "traceId", "onSizeChange", "Landroidx/compose/ui/unit/IntSize;", "onRetry", "(Lkntr/base/imageloader/ImageState;Lkntr/base/imageloader/BiliImageOptions;Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "DefaultPlaceHolder", "(Landroidx/compose/runtime/Composer;I)V", "imageloader_debug", "measuredSize", "retryHash", "", "measureDone", ""}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BiliImageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BiliImage$lambda$19(ImmutableImageRequest immutableImageRequest, Modifier modifier, String str, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function2 function2, Function4 function4, int i, int i2, Composer composer, int i3) {
        BiliImage(immutableImageRequest, modifier, str, function1, function12, function13, function14, function2, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DefaultPlaceHolder$lambda$0(int i, Composer composer, int i2) {
        DefaultPlaceHolder(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerImage$lambda$10(ImageState imageState, BiliImageOptions biliImageOptions, Modifier modifier, String str, String str2, Function1 function1, Function1 function12, Function0 function0, Function1 function13, Function2 function2, Function4 function4, int i, int i2, int i3, Composer composer, int i4) {
        InnerImage(imageState, biliImageOptions, modifier, str, str2, function1, function12, function0, function13, function2, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:136:0x01ae, code lost:
        if (r11 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x02a0, code lost:
        if (r15 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x02dd, code lost:
        if (r4 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x04f2, code lost:
        if (r13 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x0620, code lost:
        if (r8 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L131;
     */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x049f  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x04ea  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x04f6  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x052d  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x058c  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0599  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x059e  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x05ae  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x05ed  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0618  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0624  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x064e  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x06a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BiliImage(final ImmutableImageRequest request, Modifier modifier, String contentDescription, Function1<? super ImageState, Unit> function1, Function1<? super ImageRequest, ImmutableImageRequest> function12, Function1<? super Image, ? extends Image> function13, Function1<? super AnimationState, Unit> function14, Function2<? super Composer, ? super Integer, Unit> function2, Function4<? super ImageFailScope, ? super ImageException, ? super Composer, ? super Integer, Unit> function4, Composer $composer, final int $changed, final int i) {
        String contentDescription2;
        Function1 onState;
        Function1 urlTransformation;
        int $dirty;
        Modifier modifier2;
        Object bitmapTransformation;
        Function1 onAnimation;
        Function2 loadingPlaceholder;
        Function4<? super ImageFailScope, ? super ImageException, ? super Composer, ? super Integer, Unit> function42;
        String contentDescription3;
        int $dirty2;
        Lifecycle lifecycle;
        Object value$iv;
        int m1517constructorimpl;
        int m1517constructorimpl2;
        Object obj;
        final ImmutableImageRequest finalReq;
        boolean invalid$iv;
        Object it$iv;
        Function1 urlTransformation2;
        Object value$iv2;
        boolean invalid$iv2;
        boolean invalid$iv3;
        Function1 onState2;
        boolean invalid$iv4;
        Object it$iv2;
        BiliImageOptions biliImageOptions;
        Object it$iv3;
        boolean invalid$iv5;
        boolean invalid$iv6;
        Object it$iv4;
        Intrinsics.checkNotNullParameter(request, "request");
        Composer $composer2 = $composer.startRestartGroup(-1556797832);
        ComposerKt.sourceInformation($composer2, "C(BiliImage)N(request,modifier,contentDescription,onState,urlTransformation,bitmapTransformation,onAnimation,loadingPlaceholder,failPlaceholder)45@1861L71,49@1950L24,51@2000L62,55@2085L54,59@2164L124,65@2330L7,68@2376L1058,95@3458L467,109@3969L1014,109@3931L1052,143@5016L43,143@4989L70,149@5128L45,156@5388L33,157@5446L31,150@5215L35,147@5065L546:BiliImage.kt#2bx67y");
        int $dirty3 = $changed;
        if (($changed & 6) == 0) {
            $dirty3 |= $composer2.changed(request) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty3 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty3 |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty3 |= 384;
            contentDescription2 = contentDescription;
        } else if (($changed & 384) == 0) {
            contentDescription2 = contentDescription;
            $dirty3 |= $composer2.changed(contentDescription2) ? 256 : 128;
        } else {
            contentDescription2 = contentDescription;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty3 |= 3072;
            onState = function1;
        } else if (($changed & 3072) == 0) {
            onState = function1;
            $dirty3 |= $composer2.changedInstance(onState) ? 2048 : 1024;
        } else {
            onState = function1;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty3 |= 24576;
            urlTransformation = function12;
        } else if (($changed & 24576) == 0) {
            urlTransformation = function12;
            $dirty3 |= $composer2.changedInstance(urlTransformation) ? 16384 : 8192;
        } else {
            urlTransformation = function12;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty3 |= 196608;
        } else if (($changed & 196608) == 0) {
            $dirty3 |= $composer2.changedInstance(function13) ? 131072 : 65536;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty3 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty3 |= $composer2.changedInstance(function14) ? 1048576 : 524288;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty3 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty3 |= $composer2.changedInstance(function2) ? 8388608 : 4194304;
        }
        int i9 = i & 256;
        if (i9 != 0) {
            $dirty3 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty3 |= $composer2.changedInstance(function4) ? 67108864 : 33554432;
        }
        if ($composer2.shouldExecute(($dirty3 & 38347923) != 38347922, $dirty3 & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier;
            if (i3 != 0) {
                contentDescription2 = "biliImage";
            }
            Function1 onState3 = i4 != 0 ? null : onState;
            Function1 urlTransformation3 = i5 != 0 ? null : urlTransformation;
            Object bitmapTransformation2 = i6 != 0 ? null : function13;
            Function1 onAnimation2 = i7 != 0 ? null : function14;
            Function2 loadingPlaceholder2 = i8 != 0 ? ComposableSingletons$BiliImageKt.INSTANCE.getLambda$838573043$imageloader_debug() : function2;
            Function4<ImageFailScope, ImageException, Composer, Integer, Unit> lambda$1478878682$imageloader_debug = i9 != 0 ? ComposableSingletons$BiliImageKt.INSTANCE.getLambda$1478878682$imageloader_debug() : function4;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1556797832, $dirty3, -1, "kntr.base.imageloader.BiliImage (BiliImage.kt:43)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1434079425, "CC(remember):BiliImage.kt#9igjgp");
            boolean invalid$iv7 = ($dirty3 & 14) == 4;
            Object it$iv5 = $composer2.rememberedValue();
            if (invalid$iv7) {
            }
            Object value$iv3 = "[" + request.takeImageUrl() + "]";
            $composer2.updateRememberedValue(value$iv3);
            it$iv5 = value$iv3;
            final String traceId = (String) it$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            Function4<? super ImageFailScope, ? super ImageException, ? super Composer, ? super Integer, Unit> function43 = lambda$1478878682$imageloader_debug;
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1434074986, "CC(remember):BiliImage.kt#9igjgp");
            boolean invalid$iv8 = ($dirty3 & 14) == 4;
            Object it$iv6 = $composer2.rememberedValue();
            if (invalid$iv8 || it$iv6 == Composer.Companion.getEmpty()) {
                Object value$iv4 = SnapshotStateKt.mutableStateOf$default(IntSize.box-impl(IntSize.Companion.getZero-YbymL2g()), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv4);
                it$iv6 = value$iv4;
            }
            final MutableState measuredSize$delegate = (MutableState) it$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1434072274, "CC(remember):BiliImage.kt#9igjgp");
            boolean invalid$iv9 = ($dirty3 & 14) == 4;
            Object it$iv7 = $composer2.rememberedValue();
            if (invalid$iv9) {
            }
            Object value$iv5 = SnapshotIntStateKt.mutableIntStateOf(0);
            $composer2.updateRememberedValue(value$iv5);
            it$iv7 = value$iv5;
            final MutableIntState retryHash$delegate = (MutableIntState) it$iv7;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1434069676, "CC(remember):BiliImage.kt#9igjgp");
            boolean invalid$iv10 = ($dirty3 & 14) == 4;
            loadingPlaceholder = loadingPlaceholder2;
            Object value$iv6 = $composer2.rememberedValue();
            if (invalid$iv10) {
            }
            value$iv6 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.base.imageloader.BiliImageKt$$ExternalSyntheticLambda8
                public final Object invoke() {
                    boolean BiliImage$lambda$7$0;
                    BiliImage$lambda$7$0 = BiliImageKt.BiliImage$lambda$7$0(measuredSize$delegate);
                    return Boolean.valueOf(BiliImage$lambda$7$0);
                }
            });
            $composer2.updateRememberedValue(value$iv6);
            State measureDone$delegate = (State) value$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CompositionLocal this_$iv = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            onAnimation = onAnimation2;
            contentDescription3 = contentDescription2;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Lifecycle lifecycle2 = ((LifecycleOwner) consume).getLifecycle();
            Modifier modifier4 = modifier3;
            Function1 onState4 = onState3;
            long BiliImage$lambda$2 = BiliImage$lambda$2(measuredSize$delegate);
            ComposerKt.sourceInformationMarkerStart($composer2, -1434061958, "CC(remember):BiliImage.kt#9igjgp");
            boolean invalid$iv11 = $composer2.changed(BiliImage$lambda$2) | (($dirty3 & 14) == 4);
            Object it$iv8 = $composer2.rememberedValue();
            if (!invalid$iv11 && it$iv8 != Composer.Companion.getEmpty()) {
                $dirty2 = $dirty3;
                bitmapTransformation = bitmapTransformation2;
                lifecycle = lifecycle2;
                finalReq = (ImmutableImageRequest) it$iv8;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerStart($composer2, -1434027925, "CC(remember):BiliImage.kt#9igjgp");
                invalid$iv = $composer2.changed(finalReq);
                it$iv = $composer2.rememberedValue();
                if (!invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    if (finalReq != null) {
                        urlTransformation2 = urlTransformation3;
                        value$iv2 = SnapshotStateKt.mutableStateOf$default(ImageState.Empty.INSTANCE, (SnapshotMutationPolicy) null, 2, (Object) null);
                    } else if (BiliImage_androidKt.inMemoryCache(finalReq)) {
                        urlTransformation2 = urlTransformation3;
                        KLog_androidKt.getKLog().d(ApiKt.TAG, traceId + " - in memory cache hit");
                        value$iv2 = SnapshotStateKt.mutableStateOf$default(ImageState.Empty.INSTANCE, (SnapshotMutationPolicy) null, 2, (Object) null);
                    } else {
                        urlTransformation2 = urlTransformation3;
                        KLog_androidKt.getKLog().d(ApiKt.TAG, traceId + " - in memory cache miss");
                        value$iv2 = SnapshotStateKt.mutableStateOf$default(ImageState.Loading.INSTANCE, (SnapshotMutationPolicy) null, 2, (Object) null);
                    }
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv = value$iv2;
                } else {
                    urlTransformation2 = urlTransformation3;
                }
                final MutableState imageState$delegate = (MutableState) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Integer valueOf = Integer.valueOf(BiliImage$lambda$5(retryHash$delegate));
                ComposerKt.sourceInformationMarkerStart($composer2, -1434011026, "CC(remember):BiliImage.kt#9igjgp");
                final Lifecycle lifecycle3 = lifecycle;
                invalid$iv2 = $composer2.changed(finalReq) | $composer2.changed(traceId) | $composer2.changedInstance(scope) | $composer2.changedInstance(lifecycle3) | $composer2.changed(imageState$delegate);
                Object it$iv9 = $composer2.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv7 = new Function1() { // from class: kntr.base.imageloader.BiliImageKt$$ExternalSyntheticLambda9
                    public final Object invoke(Object obj2) {
                        DisposableEffectResult BiliImage$lambda$13$0;
                        BiliImage$lambda$13$0 = BiliImageKt.BiliImage$lambda$13$0(ImmutableImageRequest.this, traceId, scope, lifecycle3, imageState$delegate, (DisposableEffectScope) obj2);
                        return BiliImage$lambda$13$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv7);
                it$iv9 = value$iv7;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.DisposableEffect(finalReq, valueOf, (Function1) it$iv9, $composer2, 0);
                ImageState BiliImage$lambda$11 = BiliImage$lambda$11(imageState$delegate);
                ComposerKt.sourceInformationMarkerStart($composer2, -1433978493, "CC(remember):BiliImage.kt#9igjgp");
                $dirty = $dirty2;
                invalid$iv3 = (($dirty & 7168) == 2048) | $composer2.changed(imageState$delegate);
                Object it$iv10 = $composer2.rememberedValue();
                if (!invalid$iv3 && it$iv10 != Composer.Companion.getEmpty()) {
                    onState2 = onState4;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    EffectsKt.LaunchedEffect(BiliImage$lambda$11, (Function2) it$iv10, $composer2, 0);
                    ImageState BiliImage$lambda$112 = BiliImage$lambda$11(imageState$delegate);
                    ComposerKt.sourceInformationMarkerStart($composer2, -1433974907, "CC(remember):BiliImage.kt#9igjgp");
                    invalid$iv4 = $composer2.changed(finalReq);
                    it$iv2 = $composer2.rememberedValue();
                    if (!invalid$iv4 || it$iv2 == Composer.Companion.getEmpty()) {
                        Object value$iv8 = finalReq == null ? finalReq.getOptions$imageloader_debug() : null;
                        $composer2.updateRememberedValue(value$iv8);
                        it$iv2 = value$iv8;
                    }
                    biliImageOptions = (BiliImageOptions) it$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    if (biliImageOptions == null) {
                        biliImageOptions = new BiliImageOptions(false, 0, false, false, false, null, null, 0.0f, null, null, null, null, null, 8191, null);
                    }
                    ComposerKt.sourceInformationMarkerStart($composer2, -1433966599, "CC(remember):BiliImage.kt#9igjgp");
                    it$iv3 = $composer2.rememberedValue();
                    if (it$iv3 == Composer.Companion.getEmpty()) {
                        Object value$iv9 = bitmapTransformation;
                        $composer2.updateRememberedValue(value$iv9);
                        it$iv3 = value$iv9;
                    }
                    Function1 function15 = (Function1) it$iv3;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerStart($composer2, -1433964745, "CC(remember):BiliImage.kt#9igjgp");
                    invalid$iv5 = $composer2.changed(measuredSize$delegate);
                    Object it$iv11 = $composer2.rememberedValue();
                    if (invalid$iv5) {
                    }
                    Object value$iv10 = new Function1() { // from class: kntr.base.imageloader.BiliImageKt$$ExternalSyntheticLambda10
                        public final Object invoke(Object obj2) {
                            Unit BiliImage$lambda$17$0;
                            BiliImage$lambda$17$0 = BiliImageKt.BiliImage$lambda$17$0(measuredSize$delegate, (IntSize) obj2);
                            return BiliImage$lambda$17$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv10);
                    it$iv11 = value$iv10;
                    Function1 function16 = (Function1) it$iv11;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerStart($composer2, -1433972133, "CC(remember):BiliImage.kt#9igjgp");
                    invalid$iv6 = $composer2.changed(retryHash$delegate);
                    it$iv4 = $composer2.rememberedValue();
                    if (!invalid$iv6 || it$iv4 == Composer.Companion.getEmpty()) {
                        Object value$iv11 = new Function0() { // from class: kntr.base.imageloader.BiliImageKt$$ExternalSyntheticLambda0
                            public final Object invoke() {
                                Unit BiliImage$lambda$18$0;
                                BiliImage$lambda$18$0 = BiliImageKt.BiliImage$lambda$18$0(retryHash$delegate);
                                return BiliImage$lambda$18$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv11);
                        it$iv4 = value$iv11;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    InnerImage(BiliImage$lambda$112, biliImageOptions, modifier4, contentDescription3, traceId, function15, function16, (Function0) it$iv4, onAnimation, loadingPlaceholder, function43, $composer2, (($dirty << 3) & 896) | 196608 | (($dirty << 3) & 7168) | (($dirty << 6) & 234881024) | (1879048192 & ($dirty << 6)), ($dirty >> 24) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function42 = function43;
                    onState = onState2;
                    modifier2 = modifier4;
                    urlTransformation = urlTransformation2;
                }
                onState2 = onState4;
                Object value$iv12 = (Function2) new BiliImageKt$BiliImage$2$1(onState2, imageState$delegate, null);
                $composer2.updateRememberedValue(value$iv12);
                it$iv10 = value$iv12;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(BiliImage$lambda$11, (Function2) it$iv10, $composer2, 0);
                ImageState BiliImage$lambda$1122 = BiliImage$lambda$11(imageState$delegate);
                ComposerKt.sourceInformationMarkerStart($composer2, -1433974907, "CC(remember):BiliImage.kt#9igjgp");
                invalid$iv4 = $composer2.changed(finalReq);
                it$iv2 = $composer2.rememberedValue();
                if (!invalid$iv4) {
                }
                Object value$iv82 = finalReq == null ? finalReq.getOptions$imageloader_debug() : null;
                $composer2.updateRememberedValue(value$iv82);
                it$iv2 = value$iv82;
                biliImageOptions = (BiliImageOptions) it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (biliImageOptions == null) {
                }
                ComposerKt.sourceInformationMarkerStart($composer2, -1433966599, "CC(remember):BiliImage.kt#9igjgp");
                it$iv3 = $composer2.rememberedValue();
                if (it$iv3 == Composer.Companion.getEmpty()) {
                }
                Function1 function152 = (Function1) it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerStart($composer2, -1433964745, "CC(remember):BiliImage.kt#9igjgp");
                invalid$iv5 = $composer2.changed(measuredSize$delegate);
                Object it$iv112 = $composer2.rememberedValue();
                if (invalid$iv5) {
                }
                Object value$iv102 = new Function1() { // from class: kntr.base.imageloader.BiliImageKt$$ExternalSyntheticLambda10
                    public final Object invoke(Object obj2) {
                        Unit BiliImage$lambda$17$0;
                        BiliImage$lambda$17$0 = BiliImageKt.BiliImage$lambda$17$0(measuredSize$delegate, (IntSize) obj2);
                        return BiliImage$lambda$17$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv102);
                it$iv112 = value$iv102;
                Function1 function162 = (Function1) it$iv112;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerStart($composer2, -1433972133, "CC(remember):BiliImage.kt#9igjgp");
                invalid$iv6 = $composer2.changed(retryHash$delegate);
                it$iv4 = $composer2.rememberedValue();
                if (!invalid$iv6) {
                }
                Object value$iv112 = new Function0() { // from class: kntr.base.imageloader.BiliImageKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit BiliImage$lambda$18$0;
                        BiliImage$lambda$18$0 = BiliImageKt.BiliImage$lambda$18$0(retryHash$delegate);
                        return BiliImage$lambda$18$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv112);
                it$iv4 = value$iv112;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                InnerImage(BiliImage$lambda$1122, biliImageOptions, modifier4, contentDescription3, traceId, function152, function162, (Function0) it$iv4, onAnimation, loadingPlaceholder, function43, $composer2, (($dirty << 3) & 896) | 196608 | (($dirty << 3) & 7168) | (($dirty << 6) & 234881024) | (1879048192 & ($dirty << 6)), ($dirty >> 24) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                function42 = function43;
                onState = onState2;
                modifier2 = modifier4;
                urlTransformation = urlTransformation2;
            }
            if (BiliImage$lambda$8(measureDone$delegate)) {
                ImageRequest $this$BiliImage_u24lambda_u249_u240 = request.toMutableRequest$imageloader_debug();
                if (Pixel.m1519equalsimpl0(request.getProtocol$imageloader_debug().m1427getWidthuhUG8m8$imageloader_debug(), Pixel.Companion.m1523getUNSETuhUG8m8())) {
                    $dirty2 = $dirty3;
                    m1517constructorimpl = Pixel.m1517constructorimpl((int) (BiliImage$lambda$2(measuredSize$delegate) >> 32));
                } else {
                    m1517constructorimpl = request.getProtocol$imageloader_debug().m1427getWidthuhUG8m8$imageloader_debug();
                    $dirty2 = $dirty3;
                }
                if (Pixel.m1519equalsimpl0(request.getProtocol$imageloader_debug().m1422getHeightuhUG8m8$imageloader_debug(), Pixel.Companion.m1523getUNSETuhUG8m8())) {
                    bitmapTransformation = bitmapTransformation2;
                    lifecycle = lifecycle2;
                    int $i$f$unpackInt2 = (int) (BiliImage$lambda$2(measuredSize$delegate) & 4294967295L);
                    m1517constructorimpl2 = Pixel.m1517constructorimpl($i$f$unpackInt2);
                } else {
                    m1517constructorimpl2 = request.getProtocol$imageloader_debug().m1422getHeightuhUG8m8$imageloader_debug();
                    bitmapTransformation = bitmapTransformation2;
                    lifecycle = lifecycle2;
                }
                $this$BiliImage_u24lambda_u249_u240.m1486gearsIc4ZqO0$imageloader_debug(m1517constructorimpl, m1517constructorimpl2);
                $this$BiliImage_u24lambda_u249_u240.deepCopy$imageloader_debug();
                value$iv = (urlTransformation3 == null || (obj = (ImmutableImageRequest) urlTransformation3.invoke($this$BiliImage_u24lambda_u249_u240)) == null) ? $this$BiliImage_u24lambda_u249_u240.build() : obj;
            } else {
                $dirty2 = $dirty3;
                bitmapTransformation = bitmapTransformation2;
                lifecycle = lifecycle2;
                value$iv = null;
            }
            $composer2.updateRememberedValue(value$iv);
            it$iv8 = value$iv;
            finalReq = (ImmutableImageRequest) it$iv8;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1434027925, "CC(remember):BiliImage.kt#9igjgp");
            invalid$iv = $composer2.changed(finalReq);
            it$iv = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            if (finalReq != null) {
            }
            $composer2.updateRememberedValue(value$iv2);
            it$iv = value$iv2;
            final MutableState imageState$delegate2 = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Integer valueOf2 = Integer.valueOf(BiliImage$lambda$5(retryHash$delegate));
            ComposerKt.sourceInformationMarkerStart($composer2, -1434011026, "CC(remember):BiliImage.kt#9igjgp");
            final Lifecycle lifecycle32 = lifecycle;
            invalid$iv2 = $composer2.changed(finalReq) | $composer2.changed(traceId) | $composer2.changedInstance(scope) | $composer2.changedInstance(lifecycle32) | $composer2.changed(imageState$delegate2);
            Object it$iv92 = $composer2.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv72 = new Function1() { // from class: kntr.base.imageloader.BiliImageKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj2) {
                    DisposableEffectResult BiliImage$lambda$13$0;
                    BiliImage$lambda$13$0 = BiliImageKt.BiliImage$lambda$13$0(ImmutableImageRequest.this, traceId, scope, lifecycle32, imageState$delegate2, (DisposableEffectScope) obj2);
                    return BiliImage$lambda$13$0;
                }
            };
            $composer2.updateRememberedValue(value$iv72);
            it$iv92 = value$iv72;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.DisposableEffect(finalReq, valueOf2, (Function1) it$iv92, $composer2, 0);
            ImageState BiliImage$lambda$113 = BiliImage$lambda$11(imageState$delegate2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1433978493, "CC(remember):BiliImage.kt#9igjgp");
            $dirty = $dirty2;
            invalid$iv3 = (($dirty & 7168) == 2048) | $composer2.changed(imageState$delegate2);
            Object it$iv102 = $composer2.rememberedValue();
            if (!invalid$iv3) {
                onState2 = onState4;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(BiliImage$lambda$113, (Function2) it$iv102, $composer2, 0);
                ImageState BiliImage$lambda$11222 = BiliImage$lambda$11(imageState$delegate2);
                ComposerKt.sourceInformationMarkerStart($composer2, -1433974907, "CC(remember):BiliImage.kt#9igjgp");
                invalid$iv4 = $composer2.changed(finalReq);
                it$iv2 = $composer2.rememberedValue();
                if (!invalid$iv4) {
                }
                Object value$iv822 = finalReq == null ? finalReq.getOptions$imageloader_debug() : null;
                $composer2.updateRememberedValue(value$iv822);
                it$iv2 = value$iv822;
                biliImageOptions = (BiliImageOptions) it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (biliImageOptions == null) {
                }
                ComposerKt.sourceInformationMarkerStart($composer2, -1433966599, "CC(remember):BiliImage.kt#9igjgp");
                it$iv3 = $composer2.rememberedValue();
                if (it$iv3 == Composer.Companion.getEmpty()) {
                }
                Function1 function1522 = (Function1) it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerStart($composer2, -1433964745, "CC(remember):BiliImage.kt#9igjgp");
                invalid$iv5 = $composer2.changed(measuredSize$delegate);
                Object it$iv1122 = $composer2.rememberedValue();
                if (invalid$iv5) {
                }
                Object value$iv1022 = new Function1() { // from class: kntr.base.imageloader.BiliImageKt$$ExternalSyntheticLambda10
                    public final Object invoke(Object obj2) {
                        Unit BiliImage$lambda$17$0;
                        BiliImage$lambda$17$0 = BiliImageKt.BiliImage$lambda$17$0(measuredSize$delegate, (IntSize) obj2);
                        return BiliImage$lambda$17$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv1022);
                it$iv1122 = value$iv1022;
                Function1 function1622 = (Function1) it$iv1122;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerStart($composer2, -1433972133, "CC(remember):BiliImage.kt#9igjgp");
                invalid$iv6 = $composer2.changed(retryHash$delegate);
                it$iv4 = $composer2.rememberedValue();
                if (!invalid$iv6) {
                }
                Object value$iv1122 = new Function0() { // from class: kntr.base.imageloader.BiliImageKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit BiliImage$lambda$18$0;
                        BiliImage$lambda$18$0 = BiliImageKt.BiliImage$lambda$18$0(retryHash$delegate);
                        return BiliImage$lambda$18$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv1122);
                it$iv4 = value$iv1122;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                InnerImage(BiliImage$lambda$11222, biliImageOptions, modifier4, contentDescription3, traceId, function1522, function1622, (Function0) it$iv4, onAnimation, loadingPlaceholder, function43, $composer2, (($dirty << 3) & 896) | 196608 | (($dirty << 3) & 7168) | (($dirty << 6) & 234881024) | (1879048192 & ($dirty << 6)), ($dirty >> 24) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                function42 = function43;
                onState = onState2;
                modifier2 = modifier4;
                urlTransformation = urlTransformation2;
            }
            onState2 = onState4;
            Object value$iv122 = (Function2) new BiliImageKt$BiliImage$2$1(onState2, imageState$delegate2, null);
            $composer2.updateRememberedValue(value$iv122);
            it$iv102 = value$iv122;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(BiliImage$lambda$113, (Function2) it$iv102, $composer2, 0);
            ImageState BiliImage$lambda$112222 = BiliImage$lambda$11(imageState$delegate2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1433974907, "CC(remember):BiliImage.kt#9igjgp");
            invalid$iv4 = $composer2.changed(finalReq);
            it$iv2 = $composer2.rememberedValue();
            if (!invalid$iv4) {
            }
            Object value$iv8222 = finalReq == null ? finalReq.getOptions$imageloader_debug() : null;
            $composer2.updateRememberedValue(value$iv8222);
            it$iv2 = value$iv8222;
            biliImageOptions = (BiliImageOptions) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (biliImageOptions == null) {
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1433966599, "CC(remember):BiliImage.kt#9igjgp");
            it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
            }
            Function1 function15222 = (Function1) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1433964745, "CC(remember):BiliImage.kt#9igjgp");
            invalid$iv5 = $composer2.changed(measuredSize$delegate);
            Object it$iv11222 = $composer2.rememberedValue();
            if (invalid$iv5) {
            }
            Object value$iv10222 = new Function1() { // from class: kntr.base.imageloader.BiliImageKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj2) {
                    Unit BiliImage$lambda$17$0;
                    BiliImage$lambda$17$0 = BiliImageKt.BiliImage$lambda$17$0(measuredSize$delegate, (IntSize) obj2);
                    return BiliImage$lambda$17$0;
                }
            };
            $composer2.updateRememberedValue(value$iv10222);
            it$iv11222 = value$iv10222;
            Function1 function16222 = (Function1) it$iv11222;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1433972133, "CC(remember):BiliImage.kt#9igjgp");
            invalid$iv6 = $composer2.changed(retryHash$delegate);
            it$iv4 = $composer2.rememberedValue();
            if (!invalid$iv6) {
            }
            Object value$iv11222 = new Function0() { // from class: kntr.base.imageloader.BiliImageKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit BiliImage$lambda$18$0;
                    BiliImage$lambda$18$0 = BiliImageKt.BiliImage$lambda$18$0(retryHash$delegate);
                    return BiliImage$lambda$18$0;
                }
            };
            $composer2.updateRememberedValue(value$iv11222);
            it$iv4 = value$iv11222;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            InnerImage(BiliImage$lambda$112222, biliImageOptions, modifier4, contentDescription3, traceId, function15222, function16222, (Function0) it$iv4, onAnimation, loadingPlaceholder, function43, $composer2, (($dirty << 3) & 896) | 196608 | (($dirty << 3) & 7168) | (($dirty << 6) & 234881024) | (1879048192 & ($dirty << 6)), ($dirty >> 24) & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            function42 = function43;
            onState = onState2;
            modifier2 = modifier4;
            urlTransformation = urlTransformation2;
        } else {
            $dirty = $dirty3;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            bitmapTransformation = function13;
            onAnimation = function14;
            loadingPlaceholder = function2;
            function42 = function4;
            contentDescription3 = contentDescription2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier2;
            final String str = contentDescription3;
            final Function1 function17 = onState;
            final Function1 function18 = urlTransformation;
            final Function1 function19 = bitmapTransformation;
            final Function1 function110 = onAnimation;
            final Function2 function22 = loadingPlaceholder;
            final Function4<? super ImageFailScope, ? super ImageException, ? super Composer, ? super Integer, Unit> function44 = function42;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.base.imageloader.BiliImageKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj2, Object obj3) {
                    Unit BiliImage$lambda$19;
                    BiliImage$lambda$19 = BiliImageKt.BiliImage$lambda$19(ImmutableImageRequest.this, modifier5, str, function17, function18, function19, function110, function22, function44, $changed, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return BiliImage$lambda$19;
                }
            });
        }
    }

    private static final long BiliImage$lambda$2(MutableState<IntSize> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((IntSize) $this$getValue$iv.getValue()).unbox-impl();
    }

    private static final void BiliImage$lambda$3(MutableState<IntSize> mutableState, long j) {
        Object value$iv = IntSize.box-impl(j);
        mutableState.setValue(value$iv);
    }

    private static final int BiliImage$lambda$5(MutableIntState $retryHash$delegate) {
        IntState $this$getValue$iv = (IntState) $retryHash$delegate;
        return $this$getValue$iv.getIntValue();
    }

    private static final boolean BiliImage$lambda$8(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BiliImage$lambda$7$0(MutableState $measuredSize$delegate) {
        return (((int) (BiliImage$lambda$2($measuredSize$delegate) >> 32)) == 0 || ((int) (4294967295L & BiliImage$lambda$2($measuredSize$delegate))) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageState BiliImage$lambda$11(MutableState<ImageState> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (ImageState) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult BiliImage$lambda$13$0(ImmutableImageRequest $finalReq, String $traceId, CoroutineScope $scope, Lifecycle $lifecycle, MutableState $imageState$delegate, DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        if ($finalReq != null) {
            KLog_androidKt.getKLog().d(ApiKt.TAG, $traceId + " - final request");
            final Job job = BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new BiliImageKt$BiliImage$1$1$1$job$1($finalReq, $lifecycle, $traceId, $imageState$delegate, null), 3, (Object) null);
            new DisposableEffectResult() { // from class: kntr.base.imageloader.BiliImageKt$BiliImage$lambda$13$0$0$$inlined$onDispose$1
                public void dispose() {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
            };
        }
        return new DisposableEffectResult() { // from class: kntr.base.imageloader.BiliImageKt$BiliImage$lambda$13$0$$inlined$onDispose$1
            public void dispose() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BiliImage$lambda$18$0(MutableIntState $retryHash$delegate) {
        $retryHash$delegate.setIntValue(BiliImage$lambda$5($retryHash$delegate) + 1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BiliImage$lambda$17$0(MutableState $measuredSize$delegate, IntSize size) {
        BiliImage$lambda$3($measuredSize$delegate, size.unbox-impl());
        return Unit.INSTANCE;
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException
        */
    /* JADX INFO: Access modifiers changed from: private */
    public static final kntr.base.imageloader.Image InnerImage$lambda$0$0(kntr.base.imageloader.Image r1) {
        /*
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kntr.base.imageloader.BiliImageKt.InnerImage$lambda$0$0(kntr.base.imageloader.Image):kntr.base.imageloader.Image");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerImage$lambda$1$0(IntSize it) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:190:0x02df, code lost:
        if (r6 != null) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x035a, code lost:
        if (r15 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x0401, code lost:
        if (r15 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L112;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void InnerImage(final ImageState imageState, final BiliImageOptions options, Modifier modifier, String contentDescription, String traceId, Function1<? super Image, ? extends Image> function1, Function1<? super IntSize, Unit> function12, Function0<Unit> function0, Function1<? super AnimationState, Unit> function13, Function2<? super Composer, ? super Integer, Unit> function2, Function4<? super ImageFailScope, ? super ImageException, ? super Composer, ? super Integer, Unit> function4, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        String contentDescription2;
        String traceId2;
        Function1 bitmapTransformation;
        Function1 onSizeChange;
        Function0 onRetry;
        Function1 onAnimation;
        Function2 loadingPlaceholder;
        Function4 failPlaceholder;
        Function1 bitmapTransformation2;
        Function1 onSizeChange2;
        final Function0 onRetry2;
        Image image;
        Function1 onAnimation2;
        Function0 factory$iv$iv;
        Function4 failPlaceholder2;
        Object value$iv;
        Object value$iv2;
        Composer $composer2 = $composer.startRestartGroup(1669762575);
        ComposerKt.sourceInformation($composer2, "C(InnerImage)N(imageState,options,modifier,contentDescription,traceId,bitmapTransformation,onSizeChange,onRetry,onAnimation,loadingPlaceholder,failPlaceholder)171@5865L6,172@5911L2,173@5941L2,179@6206L165,188@6405L170,195@6606L64,202@6751L127,240@8079L558,199@6676L1961:BiliImage.kt#2bx67y");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(imageState) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(options) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(modifier) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(contentDescription) ? 2048 : 1024;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty |= $composer2.changed(traceId) ? 16384 : 8192;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty |= 196608;
        } else if (($changed & 196608) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 131072 : 65536;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changedInstance(function12) ? 1048576 : 524288;
        }
        int i7 = i & 128;
        if (i7 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 8388608 : 4194304;
        }
        int i8 = i & 256;
        if (i8 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer2.changedInstance(function13) ? 67108864 : 33554432;
        }
        int i9 = i & 512;
        if (i9 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 536870912 : 268435456;
        }
        int i10 = i & 1024;
        if (i10 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty1 |= $composer2.changedInstance(function4) ? 4 : 2;
        }
        if ($composer2.shouldExecute((($dirty & 306783379) == 306783378 && ($dirty1 & 3) == 2) ? false : true, $dirty & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier;
            final String contentDescription3 = i3 != 0 ? "biliImage" : contentDescription;
            String traceId3 = i4 != 0 ? "" : traceId;
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -1675926763, "CC(remember):BiliImage.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    value$iv2 = new Function1() { // from class: kntr.base.imageloader.BiliImageKt$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj) {
                            return BiliImageKt.InnerImage$lambda$0$0((Image) obj);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = it$iv;
                }
                bitmapTransformation2 = (Function1) value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                bitmapTransformation2 = function1;
            }
            if (i6 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -1675925295, "CC(remember):BiliImage.kt#9igjgp");
                Object it$iv2 = $composer2.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    value$iv = new Function1() { // from class: kntr.base.imageloader.BiliImageKt$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj) {
                            Unit InnerImage$lambda$1$0;
                            InnerImage$lambda$1$0 = BiliImageKt.InnerImage$lambda$1$0((IntSize) obj);
                            return InnerImage$lambda$1$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv2;
                }
                onSizeChange2 = (Function1) value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onSizeChange2 = function12;
            }
            if (i7 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -1675924335, "CC(remember):BiliImage.kt#9igjgp");
                Object it$iv3 = $composer2.rememberedValue();
                if (it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function0() { // from class: kntr.base.imageloader.BiliImageKt$$ExternalSyntheticLambda5
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                }
                onRetry2 = (Function0) it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onRetry2 = function0;
            }
            Function1 onAnimation3 = i8 != 0 ? null : function13;
            Function2 loadingPlaceholder2 = i9 != 0 ? ComposableSingletons$BiliImageKt.INSTANCE.getLambda$331894858$imageloader_debug() : function2;
            Function4 failPlaceholder3 = i10 != 0 ? ComposableSingletons$BiliImageKt.INSTANCE.m1447getLambda$826557967$imageloader_debug() : function4;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1669762575, $dirty, $dirty1, "kntr.base.imageloader.InnerImage (BiliImage.kt:177)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1675915692, "CC(remember):BiliImage.kt#9igjgp");
            Object it$iv4 = $composer2.rememberedValue();
            Function4 failPlaceholder4 = failPlaceholder3;
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new FailPlaceholderScope() { // from class: kntr.base.imageloader.BiliImageKt$InnerImage$failScope$1$1
                    @Override // kntr.base.imageloader.ImageFailScope
                    public void retry() {
                        onRetry2.invoke();
                    }
                };
                $composer2.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            BiliImageKt$InnerImage$failScope$1$1 failScope = (BiliImageKt$InnerImage$failScope$1$1) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1675909319, "CC(remember):BiliImage.kt#9igjgp");
            boolean invalid$iv = ($dirty & 14) == 4;
            Function0 onRetry3 = onRetry2;
            Object value$iv5 = $composer2.rememberedValue();
            if (invalid$iv || value$iv5 == Composer.Companion.getEmpty()) {
                ImageState.Success it = imageState instanceof ImageState.Success ? (ImageState.Success) imageState : null;
                if (it != null) {
                    if (bitmapTransformation2 != null) {
                        image = (Image) bitmapTransformation2.invoke(it.getSource());
                    }
                    image = it.getSource();
                } else {
                    image = null;
                }
                value$iv5 = image;
                $composer2.updateRememberedValue(value$iv5);
            }
            Image image2 = (Image) value$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1675902993, "CC(remember):BiliImage.kt#9igjgp");
            Object value$iv6 = $composer2.rememberedValue();
            bitmapTransformation = bitmapTransformation2;
            if (value$iv6 == Composer.Companion.getEmpty()) {
                value$iv6 = new ColorPainter(Color.Companion.getTransparent-0d7_KjU(), (DefaultConstructorMarker) null);
                $composer2.updateRememberedValue(value$iv6);
            }
            Painter painter = (ColorPainter) value$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1675898290, "CC(remember):BiliImage.kt#9igjgp");
            boolean invalid$iv2 = ($dirty & 7168) == 2048;
            Object it$iv5 = $composer2.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv7 = new Function1() { // from class: kntr.base.imageloader.BiliImageKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj) {
                    Unit InnerImage$lambda$6$0;
                    InnerImage$lambda$6$0 = BiliImageKt.InnerImage$lambda$6$0(contentDescription3, (SemanticsPropertyReceiver) obj);
                    return InnerImage$lambda$6$0;
                }
            };
            $composer2.updateRememberedValue(value$iv7);
            it$iv5 = value$iv7;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Painter painter2 = null;
            Modifier clipToBounds = ClipKt.clipToBounds(SemanticsModifierKt.semantics$default(modifier3, false, (Function1) it$iv5, 1, (Object) null));
            if (image2 == null) {
                $composer2.startReplaceGroup(-413009758);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(-413009757);
                ComposerKt.sourceInformation($composer2, "*209@7013L180");
                Painter rememberBiliImagePainter = BiliImagePainterKt.rememberBiliImagePainter(image2, options, onAnimation3, $composer2, (($dirty >> 18) & 896) | ($dirty & 112), 0);
                $composer2.endReplaceGroup();
                painter2 = rememberBiliImagePainter;
            }
            Modifier modifier$iv = PainterModifierKt.paint$default(clipToBounds, painter2 == null ? painter : painter2, false, options.getAlign(), options.getContentScale(), options.m1435getAlpha_AzBSks(), options.getColorFilter(), 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, -1675855363, "CC(remember):BiliImage.kt#9igjgp");
            boolean invalid$iv3 = (3670016 & $dirty) == 1048576;
            Object it$iv6 = $composer2.rememberedValue();
            if (invalid$iv3) {
                onAnimation2 = onAnimation3;
            } else {
                onAnimation2 = onAnimation3;
            }
            Object value$iv8 = (MeasurePolicy) new BiliImageKt$InnerImage$6$1(onSizeChange2);
            $composer2.updateRememberedValue(value$iv8);
            it$iv6 = value$iv8;
            MeasurePolicy measurePolicy$iv = (MeasurePolicy) it$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            modifier2 = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv = ((0 << 6) & 896) | 6;
            contentDescription2 = contentDescription3;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv = factory$iv$iv2;
                $composer2.createNode(factory$iv$iv);
            } else {
                factory$iv$iv = factory$iv$iv2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv, Integer.valueOf(compositeKeyHash$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv, materialized$iv, ComposeUiNode.Companion.getSetModifier());
            int i11 = ($changed$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -323576076, "C:BiliImage.kt#2bx67y");
            if (imageState instanceof ImageState.Loading) {
                $composer2.startReplaceGroup(-323529453);
                ComposerKt.sourceInformation($composer2, "224@7636L20");
                KLog_androidKt.getKLog().d(ApiKt.TAG, traceId3 + " - show loading");
                loadingPlaceholder2.invoke($composer2, Integer.valueOf(($dirty >> 27) & 14));
                $composer2.endReplaceGroup();
                failPlaceholder2 = failPlaceholder4;
            } else if (imageState instanceof ImageState.Error) {
                $composer2.startReplaceGroup(-323366424);
                ComposerKt.sourceInformation($composer2, "232@7922L33");
                KLog_androidKt.getKLog().d(ApiKt.TAG, traceId3 + " - biliImage fetch fail. error = " + ((ImageState.Error) imageState).getError().getMessage());
                failPlaceholder2 = failPlaceholder4;
                failPlaceholder2.invoke(failScope, ((ImageState.Error) imageState).getError(), $composer2, Integer.valueOf((($dirty1 << 6) & 896) | 6));
                $composer2.endReplaceGroup();
            } else {
                failPlaceholder2 = failPlaceholder4;
                $composer2.startReplaceGroup(-323091206);
                $composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            onAnimation = onAnimation2;
            loadingPlaceholder = loadingPlaceholder2;
            failPlaceholder = failPlaceholder2;
            traceId2 = traceId3;
            onRetry = onRetry3;
            onSizeChange = onSizeChange2;
        } else {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            contentDescription2 = contentDescription;
            traceId2 = traceId;
            bitmapTransformation = function1;
            onSizeChange = function12;
            onRetry = function0;
            onAnimation = function13;
            loadingPlaceholder = function2;
            failPlaceholder = function4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final String str = contentDescription2;
            final String str2 = traceId2;
            final Function1 function14 = bitmapTransformation;
            final Function1 function15 = onSizeChange;
            final Function0 function02 = onRetry;
            final Function1 function16 = onAnimation;
            final Function2 function22 = loadingPlaceholder;
            final Function4 function42 = failPlaceholder;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.base.imageloader.BiliImageKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit InnerImage$lambda$10;
                    InnerImage$lambda$10 = BiliImageKt.InnerImage$lambda$10(ImageState.this, options, modifier4, str, str2, function14, function15, function02, function16, function22, function42, $changed, $changed1, i, (Composer) obj, ((Integer) obj2).intValue());
                    return InnerImage$lambda$10;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerImage$lambda$6$0(String $contentDescription, SemanticsPropertyReceiver $this$semantics) {
        Intrinsics.checkNotNullParameter($this$semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription($this$semantics, $contentDescription);
        SemanticsPropertiesKt.setRole-kuIjeqM($this$semantics, Role.Companion.getImage-o7Vup1c());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DefaultPlaceHolder(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1803261077);
        ComposerKt.sourceInformation($composer2, "C(DefaultPlaceHolder)266@8692L38:BiliImage.kt#2bx67y");
        if (!$composer2.shouldExecute($changed != 0, $changed & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1803261077, $changed, -1, "kntr.base.imageloader.DefaultPlaceHolder (BiliImage.kt:265)");
            }
            BoxKt.Box(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer2, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.base.imageloader.BiliImageKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DefaultPlaceHolder$lambda$0;
                    DefaultPlaceHolder$lambda$0 = BiliImageKt.DefaultPlaceHolder$lambda$0($changed, (Composer) obj, ((Integer) obj2).intValue());
                    return DefaultPlaceHolder$lambda$0;
                }
            });
        }
    }
}