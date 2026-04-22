package kntr.app.im.chat.ui.module.picture;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import com.bapis.bilibili.app.im.v1.KPictureModule;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.module.PictureMsgModule;
import kntr.app.im.chat.ui.ChatActionHandler;
import kntr.app.im.chat.ui.builder.ChatMsgFrameScope;
import kntr.app.im.chat.ui.utils.ChatClickableKt;
import kntr.app.im.chat.ui.utils.PictureLifecycleKeyHandle;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.imageloader.AnimationState;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.Image;
import kntr.base.imageloader.ImageException;
import kntr.base.imageloader.ImageFailScope;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImageSource;
import kntr.base.imageloader.ImageState;
import kntr.base.imageloader.ImmutableImageRequest;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: PictureModule.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u001aC\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0001R\u00020\u0007j\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\u0013\u001a'\u0010\u0014\u001a\u00020\u0015*\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0017\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001av\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00060 2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0013\b\u0002\u0010\"\u001a\r\u0012\u0004\u0012\u00020\u00060#¢\u0006\u0002\b$2$\b\u0002\u0010%\u001a\u001e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00060&¢\u0006\u0002\b$¢\u0006\u0002\b)H\u0003¢\u0006\u0002\u0010*\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003¨\u0006+²\u0006\f\u0010,\u001a\u0004\u0018\u00010-X\u008a\u008e\u0002²\u0006\f\u0010.\u001a\u0004\u0018\u00010/X\u008a\u008e\u0002²\u0006\f\u00100\u001a\u0004\u0018\u000101X\u008a\u008e\u0002"}, d2 = {"maxPictureSize", "Landroidx/compose/ui/unit/Dp;", "getMaxPictureSize", "()F", "F", "PictureModule", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/ui/builder/ChatMsgFrameScope;", "frameScope", "module", "Lkntr/app/im/chat/module/PictureMsgModule;", "message", "Lkntr/app/im/chat/core/model/EntityMessage;", "pictureLifecycleKeyHandle", "Lkntr/app/im/chat/ui/utils/PictureLifecycleKeyHandle;", "actionHandler", "Lkntr/app/im/chat/ui/ChatActionHandler;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/im/chat/ui/builder/ChatMsgFrameScope;Lkntr/app/im/chat/module/PictureMsgModule;Lkntr/app/im/chat/core/model/EntityMessage;Lkntr/app/im/chat/ui/utils/PictureLifecycleKeyHandle;Lkntr/app/im/chat/ui/ChatActionHandler;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "coerceSizeIn", "Landroidx/compose/ui/unit/DpSize;", "maxWidth", "maxHeight", "coerceSizeIn-SInxSuc", "(JFF)J", "BiliImageWithLifecycleCount", "key", RoomRecommendViewModel.EMPTY_CURSOR, "request", RoomRecommendViewModel.EMPTY_CURSOR, "onState", "Lkotlin/Function1;", "Lkntr/base/imageloader/ImageState;", "loadingPlaceholder", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "failPlaceholder", "Lkotlin/Function2;", "Lkntr/base/imageloader/ImageFailScope;", "Lkntr/base/imageloader/ImageException;", "Lkotlin/ExtensionFunctionType;", "(ILjava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "ui_debug", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "imageSource", "Lkntr/base/imageloader/ImageSource;", "animationState", "Lkntr/base/imageloader/AnimationState;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PictureModuleKt {
    private static final float maxPictureSize = Dp.constructor-impl(200);

    public static final Unit BiliImageWithLifecycleCount$lambda$7(int i, String str, Function1 function1, Modifier modifier, Function2 function2, Function4 function4, int i2, int i3, Composer composer, int i4) {
        BiliImageWithLifecycleCount(i, str, function1, modifier, function2, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    public static final Unit PictureModule$lambda$11(ChatMsgFrameScope chatMsgFrameScope, PictureMsgModule pictureMsgModule, EntityMessage entityMessage, PictureLifecycleKeyHandle pictureLifecycleKeyHandle, ChatActionHandler chatActionHandler, Modifier modifier, int i, int i2, Composer composer, int i3) {
        PictureModule(chatMsgFrameScope, pictureMsgModule, entityMessage, pictureLifecycleKeyHandle, chatActionHandler, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final float getMaxPictureSize() {
        return maxPictureSize;
    }

    /* JADX WARN: Code restructure failed: missing block: B:210:0x021c, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L71;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void PictureModule(final ChatMsgFrameScope frameScope, final PictureMsgModule module, final EntityMessage message, final PictureLifecycleKeyHandle pictureLifecycleKeyHandle, final ChatActionHandler actionHandler, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j2;
        Modifier modifier3;
        int i2;
        Intrinsics.checkNotNullParameter(frameScope, "frameScope");
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(pictureLifecycleKeyHandle, "pictureLifecycleKeyHandle");
        Intrinsics.checkNotNullParameter(actionHandler, "actionHandler");
        Composer $composer2 = $composer.startRestartGroup(344700535);
        ComposerKt.sourceInformation($composer2, "C(PictureModule)N(frameScope,module,message,pictureLifecycleKeyHandle,actionHandler,modifier)61@2424L24,62@2478L35,64@2538L53,65@2615L47,76@2956L55,76@2935L76,83@3140L383,100@3631L56,102@3702L864,80@3017L2228:PictureModule.kt#kl58cw");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(frameScope) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(module) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(message) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(pictureLifecycleKeyHandle) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer2.changed(actionHandler) ? 16384 : 8192;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty |= 196608;
            modifier2 = modifier;
        } else if ((196608 & $changed) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 131072 : 65536;
        } else {
            modifier2 = modifier;
        }
        if ($composer2.shouldExecute(($dirty & 74899) != 74898, $dirty & 1)) {
            if (i3 != 0) {
                modifier2 = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(344700535, $dirty, -1, "kntr.app.im.chat.ui.module.picture.PictureModule (PictureModule.kt:59)");
            }
            KPictureModule kModule = module.getValue();
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final State actionHandlerState = SnapshotStateKt.rememberUpdatedState(actionHandler, $composer2, ($dirty >> 12) & 14);
            ComposerKt.sourceInformationMarkerStart($composer2, 544744332, "CC(remember):PictureModule.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                MutableState mutableStateOf$default = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(mutableStateOf$default);
                it$iv = mutableStateOf$default;
            }
            final MutableState coordinates$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 544746790, "CC(remember):PictureModule.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv);
                it$iv2 = value$iv;
            }
            final MutableState imageSource$delegate = (MutableState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (kModule.getHeight() <= 0 || kModule.getWidth() <= 0) {
                $composer2.startReplaceGroup(-292463903);
                $composer2.endReplaceGroup();
                j2 = DpSize.Companion.getUnspecified-MYxV2XQ();
            } else {
                $composer2.startReplaceGroup(-292599931);
                ComposerKt.sourceInformation($composer2, "69@2764L7");
                CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume = $composer2.consume(this_$iv);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Density $this$PictureModule_u24lambda_u246 = (Density) consume;
                long j3 = DpKt.DpSize-YgX7TsA($this$PictureModule_u24lambda_u246.toDp-u2uoSUM(kModule.getWidth()), $this$PictureModule_u24lambda_u246.toDp-u2uoSUM(kModule.getHeight()));
                $composer2.endReplaceGroup();
                j2 = j3;
            }
            long size = m1816coerceSizeInSInxSuc$default(j2, 0.0f, 0.0f, 3, null);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 544757710, "CC(remember):PictureModule.kt#9igjgp");
            boolean invalid$iv = ($dirty & 7168) == 2048;
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv2 = (Function2) new PictureModuleKt$PictureModule$1$1(pictureLifecycleKeyHandle, null);
            $composer2.updateRememberedValue(value$iv2);
            it$iv3 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv3, $composer2, 6);
            int key = pictureLifecycleKeyHandle.getKey();
            String url = kModule.getUrl();
            ComposerKt.sourceInformationMarkerStart($composer2, 544763926, "CC(remember):PictureModule.kt#9igjgp");
            Object value$iv3 = $composer2.rememberedValue();
            if (value$iv3 == Composer.Companion.getEmpty()) {
                value$iv3 = new Function1() { // from class: kntr.app.im.chat.ui.module.picture.PictureModuleKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit PictureModule$lambda$8$0;
                        PictureModule$lambda$8$0 = PictureModuleKt.PictureModule$lambda$8$0(imageSource$delegate, (ImageState) obj);
                        return PictureModule$lambda$8$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
            }
            Function1 function1 = (Function1) value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier4 = SizeKt.size-6HolHcs(modifier2, size);
            ComposerKt.sourceInformationMarkerStart($composer2, 544779311, "CC(remember):PictureModule.kt#9igjgp");
            Object value$iv4 = $composer2.rememberedValue();
            if (value$iv4 == Composer.Companion.getEmpty()) {
                value$iv4 = new Function1() { // from class: kntr.app.im.chat.ui.module.picture.PictureModuleKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        Unit PictureModule$lambda$9$0;
                        PictureModule$lambda$9$0 = PictureModuleKt.PictureModule$lambda$9$0(coordinates$delegate, (LayoutCoordinates) obj);
                        return PictureModule$lambda$9$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv4);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier4, (Function1) value$iv4);
            ComposerKt.sourceInformationMarkerStart($composer2, 544782391, "CC(remember):PictureModule.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changedInstance(scope) | $composer2.changed(actionHandlerState) | (($dirty & 112) == 32) | (($dirty & 896) == 256) | (($dirty & 14) == 4);
            Object value$iv5 = $composer2.rememberedValue();
            if (invalid$iv2 || value$iv5 == Composer.Companion.getEmpty()) {
                modifier3 = modifier2;
                i2 = 1;
                value$iv5 = new Function1() { // from class: kntr.app.im.chat.ui.module.picture.PictureModuleKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        boolean PictureModule$lambda$10$0;
                        PictureModule$lambda$10$0 = PictureModuleKt.PictureModule$lambda$10$0(scope, coordinates$delegate, actionHandlerState, module, message, frameScope, imageSource$delegate, (Offset) obj);
                        return Boolean.valueOf(PictureModule$lambda$10$0);
                    }
                };
                $composer2.updateRememberedValue(value$iv5);
            } else {
                modifier3 = modifier2;
                i2 = 1;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier5 = modifier3;
            BiliImageWithLifecycleCount(key, url, function1, ChatClickableKt.chatClickable$default(onGloballyPositioned, null, (Function1) value$iv5, i2, null), ComposableSingletons$PictureModuleKt.INSTANCE.m1812getLambda$819497398$ui_debug(), ComposableSingletons$PictureModuleKt.INSTANCE.m1810getLambda$397084012$ui_debug(), $composer2, 221568, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier5;
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.module.picture.PictureModuleKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit PictureModule$lambda$11;
                    PictureModule$lambda$11 = PictureModuleKt.PictureModule$lambda$11(ChatMsgFrameScope.this, module, message, pictureLifecycleKeyHandle, actionHandler, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PictureModule$lambda$11;
                }
            });
        }
    }

    private static final LayoutCoordinates PictureModule$lambda$1(MutableState<LayoutCoordinates> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (LayoutCoordinates) $this$getValue$iv.getValue();
    }

    public static final ImageSource PictureModule$lambda$4(MutableState<ImageSource> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (ImageSource) $this$getValue$iv.getValue();
    }

    public static final Unit PictureModule$lambda$8$0(MutableState $imageSource$delegate, ImageState imageState) {
        Intrinsics.checkNotNullParameter(imageState, "imageState");
        if (!(imageState instanceof ImageState.Error)) {
            if (imageState instanceof ImageState.Success) {
                $imageSource$delegate.setValue(new ImageSource((ImageException) null, ((ImageState.Success) imageState).getSource(), 1, (DefaultConstructorMarker) null));
            }
        } else {
            $imageSource$delegate.setValue(new ImageSource(((ImageState.Error) imageState).getError(), (Image) null, 2, (DefaultConstructorMarker) null));
        }
        return Unit.INSTANCE;
    }

    public static final Unit PictureModule$lambda$9$0(MutableState $coordinates$delegate, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $coordinates$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    public static final boolean PictureModule$lambda$10$0(CoroutineScope $scope, MutableState $coordinates$delegate, State $actionHandlerState, PictureMsgModule $module, EntityMessage $message, ChatMsgFrameScope $frameScope, MutableState $imageSource$delegate, Offset it) {
        IntRect intRect;
        LayoutCoordinates it2 = PictureModule$lambda$1($coordinates$delegate);
        if (it2 != null) {
            long position = LayoutCoordinatesKt.positionInWindow(it2);
            long size = it2.getSize-YbymL2g();
            intRect = IntRectKt.IntRect-VbeCjmY(IntOffsetKt.round-k-4lQ0M(position), size);
        } else {
            intRect = null;
        }
        IntRect frameInWindow = intRect;
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new PictureModuleKt$PictureModule$4$1$1($actionHandlerState, $module, $message, frameInWindow, $frameScope, $imageSource$delegate, null), 3, (Object) null);
        return true;
    }

    /* renamed from: coerceSizeIn-SInxSuc$default */
    public static /* synthetic */ long m1816coerceSizeInSInxSuc$default(long j2, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = maxPictureSize;
        }
        if ((i & 2) != 0) {
            f2 = maxPictureSize;
        }
        return m1815coerceSizeInSInxSuc(j2, f, f2);
    }

    /* renamed from: coerceSizeIn-SInxSuc */
    public static final long m1815coerceSizeInSInxSuc(long j2, float f, float f2) {
        float width = DpSize.getWidth-D9Ej5fM(j2);
        float height = DpSize.getHeight-D9Ej5fM(j2);
        if (Dp.compareTo-0680j_4(width, f) > 0 || Dp.compareTo-0680j_4(height, f2) > 0) {
            float widthScale = Dp.compareTo-0680j_4(width, f) > 0 ? f / width : 1.0f;
            float heightScale = Dp.compareTo-0680j_4(height, f2) > 0 ? f2 / height : 1.0f;
            float scale = Math.min(widthScale, heightScale);
            float other$iv = Dp.constructor-impl(width * scale);
            float other$iv2 = Dp.constructor-impl(height * scale);
            long j3 = DpKt.DpSize-YgX7TsA(other$iv, other$iv2);
            KLog_androidKt.getKLog().i("PictureModule", "Original size: " + DpSize.toString-impl(j2) + ", scale: " + scale);
            return j3;
        }
        return j2;
    }

    private static final void BiliImageWithLifecycleCount(final int key, final String request, final Function1<? super ImageState, Unit> function1, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function4<? super ImageFailScope, ? super ImageException, ? super Composer, ? super Integer, Unit> function4, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function2 loadingPlaceholder;
        Function4 failPlaceholder;
        Modifier modifier3;
        boolean valueOf;
        Composer $composer2 = $composer.startRestartGroup(2076116502);
        ComposerKt.sourceInformation($composer2, "C(BiliImageWithLifecycleCount)N(key,request,onState,modifier,loadingPlaceholder,failPlaceholder)176@6232L50,179@6314L160,187@6513L82,187@6480L115:PictureModule.kt#kl58cw");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(key) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(request) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty |= 24576;
            loadingPlaceholder = function2;
        } else if (($changed & 24576) == 0) {
            loadingPlaceholder = function2;
            $dirty |= $composer2.changedInstance(loadingPlaceholder) ? 16384 : 8192;
        } else {
            loadingPlaceholder = function2;
        }
        int i4 = i & 32;
        if (i4 != 0) {
            $dirty |= 196608;
            failPlaceholder = function4;
        } else if ((196608 & $changed) == 0) {
            failPlaceholder = function4;
            $dirty |= $composer2.changedInstance(failPlaceholder) ? 131072 : 65536;
        } else {
            failPlaceholder = function4;
        }
        if (!$composer2.shouldExecute((74899 & $dirty) != 74898, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            Function2 loadingPlaceholder2 = i3 != 0 ? ComposableSingletons$PictureModuleKt.INSTANCE.m1809getLambda$1520417605$ui_debug() : loadingPlaceholder;
            Function4 failPlaceholder2 = i4 != 0 ? ComposableSingletons$PictureModuleKt.INSTANCE.m1811getLambda$530518156$ui_debug() : failPlaceholder;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2076116502, $dirty, -1, "kntr.app.im.chat.ui.module.picture.BiliImageWithLifecycleCount (PictureModule.kt:175)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -2011824504, "CC(remember):PictureModule.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableState animationState$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            AnimationState BiliImageWithLifecycleCount$lambda$1 = BiliImageWithLifecycleCount$lambda$1(animationState$delegate);
            ComposerKt.sourceInformationMarkerStart($composer2, -2011821770, "CC(remember):PictureModule.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(BiliImageWithLifecycleCount$lambda$1) | (($dirty & 14) == 4);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                if (BiliImageWithLifecycleCount$lambda$1(animationState$delegate) == null) {
                    valueOf = false;
                } else {
                    valueOf = Integer.valueOf(key);
                }
                Object value$iv2 = valueOf;
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Object rememberKey = it$iv2;
            Integer valueOf2 = Integer.valueOf(key);
            ComposerKt.sourceInformationMarkerStart($composer2, -2011815480, "CC(remember):PictureModule.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changedInstance(rememberKey);
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = (Function2) new PictureModuleKt$BiliImageWithLifecycleCount$1$1(rememberKey, animationState$delegate, null);
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(rememberKey, valueOf2, (Function2) it$iv3, $composer2, ($dirty << 3) & 112);
            $composer2.startMovableGroup(-2011812317, Integer.valueOf(key));
            ComposerKt.sourceInformation($composer2, "198@6850L116,192@6620L404");
            ImageRequest $this$BiliImageWithLifecycleCount_u24lambda_u245 = new ImageRequest(request);
            $this$BiliImageWithLifecycleCount_u24lambda_u245.autoPlay(true);
            ImmutableImageRequest build = $this$BiliImageWithLifecycleCount_u24lambda_u245.build();
            ComposerKt.sourceInformationMarkerStart($composer2, -2011804662, "CC(remember):PictureModule.kt#9igjgp");
            Object it$iv4 = $composer2.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new Function1() { // from class: kntr.app.im.chat.ui.module.picture.PictureModuleKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        Unit BiliImageWithLifecycleCount$lambda$6$0;
                        BiliImageWithLifecycleCount$lambda$6$0 = PictureModuleKt.BiliImageWithLifecycleCount$lambda$6$0(animationState$delegate, (AnimationState) obj);
                        return BiliImageWithLifecycleCount$lambda$6$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            BiliImageKt.BiliImage(build, modifier3, (String) null, function1, (Function1) null, (Function1) null, (Function1) it$iv4, loadingPlaceholder2, failPlaceholder2, $composer2, (($dirty >> 6) & 112) | 1572864 | (($dirty << 3) & 7168) | (($dirty << 9) & 29360128) | (234881024 & ($dirty << 9)), 52);
            $composer2.endMovableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            loadingPlaceholder = loadingPlaceholder2;
            failPlaceholder = failPlaceholder2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final Function2 function22 = loadingPlaceholder;
            final Function4 function42 = failPlaceholder;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.module.picture.PictureModuleKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit BiliImageWithLifecycleCount$lambda$7;
                    BiliImageWithLifecycleCount$lambda$7 = PictureModuleKt.BiliImageWithLifecycleCount$lambda$7(key, request, function1, modifier4, function22, function42, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return BiliImageWithLifecycleCount$lambda$7;
                }
            });
        }
    }

    public static final AnimationState BiliImageWithLifecycleCount$lambda$1(MutableState<AnimationState> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (AnimationState) $this$getValue$iv.getValue();
    }

    public static final Unit BiliImageWithLifecycleCount$lambda$6$0(MutableState $animationState$delegate, AnimationState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $animationState$delegate.setValue(it);
        return Unit.INSTANCE;
    }
}