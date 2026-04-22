package kntr.app.im.chat.ui.module.localPicture;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.SendStatus;
import kntr.app.im.chat.module.localPicture.LocalPictureModule;
import kntr.app.im.chat.service.sender.image.LocalImageAsset;
import kntr.app.im.chat.ui.ChatActionHandler;
import kntr.app.im.chat.ui.builder.ChatMsgFrameScope;
import kntr.app.im.chat.ui.module.picture.PictureModuleKt;
import kntr.app.im.chat.ui.neuron.CardReporter;
import kntr.app.im.chat.ui.utils.ChatClickableKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.imageloader.AnimateStrategy;
import kntr.base.imageloader.BiliImageOptions;
import kntr.base.imageloader.BiliImagePainterKt;
import kntr.base.imageloader.ImageSource;
import kntr.base.imageloader.ResizeOption;
import kntr.base.imageloader.cache.CachePolicy;
import kntr.common.photonic.AssetEntry;
import kntr.common.photonic.AssetKt;
import kntr.common.photonic.Resolution;
import kntr.common.photonic.ResolutionKt;
import kntr.common.photonic.shower.AssetShower;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: LocalPictureModule.kt */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a;\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0001R\u00020\u0002j\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\f\u001a]\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132,\u0010\u0014\u001a(\b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00152\u0006\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c²\u0006\f\u0010\u001d\u001a\u0004\u0018\u00010\u0016X\u008a\u008e\u0002"}, d2 = {"LocalPictureModule", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/ui/builder/ChatMsgFrameScope;", "frameScope", "module", "Lkntr/app/im/chat/module/localPicture/LocalPictureModule;", "message", "Lkntr/app/im/chat/core/model/EntityMessage;", "actionHandler", "Lkntr/app/im/chat/ui/ChatActionHandler;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/im/chat/ui/builder/ChatMsgFrameScope;Lkntr/app/im/chat/module/localPicture/LocalPictureModule;Lkntr/app/im/chat/core/model/EntityMessage;Lkntr/app/im/chat/ui/ChatActionHandler;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "LocalImage", "asset", "Lkntr/app/im/chat/service/sender/image/LocalImageAsset;", "expectResolution", "Lkntr/common/photonic/Resolution;", "moduleSize", "Landroidx/compose/ui/unit/DpSize;", "onImageClick", "Lkotlin/Function3;", "Lkntr/base/imageloader/ImageSource;", "Landroidx/compose/ui/unit/IntRect;", "Lkotlin/coroutines/Continuation;", RoomRecommendViewModel.EMPTY_CURSOR, "LocalImage-MMVEmd4", "(Lkntr/app/im/chat/service/sender/image/LocalImageAsset;Lkntr/common/photonic/Resolution;JLkotlin/jvm/functions/Function3;Lkntr/app/im/chat/ui/builder/ChatMsgFrameScope;Landroidx/compose/runtime/Composer;I)V", "ui_debug", "imageSource"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class LocalPictureModuleKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LocalImage_MMVEmd4$lambda$9(LocalImageAsset localImageAsset, Resolution resolution, long j2, Function3 function3, ChatMsgFrameScope chatMsgFrameScope, int i, Composer composer, int i2) {
        m1785LocalImageMMVEmd4(localImageAsset, resolution, j2, function3, chatMsgFrameScope, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LocalPictureModule$lambda$3(ChatMsgFrameScope chatMsgFrameScope, LocalPictureModule localPictureModule, EntityMessage entityMessage, ChatActionHandler chatActionHandler, Modifier modifier, int i, int i2, Composer composer, int i3) {
        LocalPictureModule(chatMsgFrameScope, localPictureModule, entityMessage, chatActionHandler, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x02bc, code lost:
        if (r4 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L85;
     */
    /* JADX WARN: Removed duplicated region for block: B:97:0x03a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LocalPictureModule(final ChatMsgFrameScope frameScope, final LocalPictureModule module, final EntityMessage message, final ChatActionHandler actionHandler, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        long j2;
        Function0 factory$iv$iv$iv;
        Composer $composer2;
        Composer $composer$iv;
        int i2;
        Composer $composer3;
        Intrinsics.checkNotNullParameter(frameScope, "frameScope");
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(actionHandler, "actionHandler");
        Composer $composer4 = $composer.startRestartGroup(1124441885);
        ComposerKt.sourceInformation($composer4, "C(LocalPictureModule)N(frameScope,module,message,actionHandler,modifier)89@3605L7,93@3771L1097:LocalPictureModule.kt#k8mqxt");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changed(frameScope) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changed(module) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer4.changed(message) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer4.changed(actionHandler) ? 2048 : 1024;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer4.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $composer4.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i3 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1124441885, $dirty2, -1, "kntr.app.im.chat.ui.module.localPicture.LocalPictureModule (LocalPictureModule.kt:78)");
            }
            Resolution resolution = AssetKt.withOrientation(module.getResolution(), module.getOrientation());
            if (!Intrinsics.areEqual(resolution, Resolution.Companion.getZero())) {
                $composer4.startReplaceGroup(1798556597);
                ComposerKt.sourceInformation($composer4, "82@3363L7");
                CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume = $composer4.consume(this_$iv);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                Density $this$LocalPictureModule_u24lambda_u240 = (Density) consume;
                long j3 = DpKt.DpSize-YgX7TsA($this$LocalPictureModule_u24lambda_u240.toDp-u2uoSUM(resolution.getWidthPx()), $this$LocalPictureModule_u24lambda_u240.toDp-u2uoSUM(resolution.getHeightPx()));
                $composer4.endReplaceGroup();
                j2 = j3;
            } else {
                $composer4.startReplaceGroup(1798702855);
                $composer4.endReplaceGroup();
                j2 = DpKt.DpSize-YgX7TsA(PictureModuleKt.getMaxPictureSize(), PictureModuleKt.getMaxPictureSize());
            }
            long moduleSize = PictureModuleKt.m1816coerceSizeInSInxSuc$default(j2, 0.0f, 0.0f, 3, null);
            CompositionLocal this_$iv2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer4.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Density $this$LocalPictureModule_u24lambda_u241 = (Density) consume2;
            int maxPxSize = MathKt.roundToInt($this$LocalPictureModule_u24lambda_u241.toPx-0680j_4(PictureModuleKt.getMaxPictureSize()));
            Resolution expectResolution = ResolutionKt.coerceAtMostWithScale(resolution, new Resolution(maxPxSize, maxPxSize));
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            int $changed$iv = (($dirty2 >> 12) & 14) | 48;
            Modifier modifier$iv = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer4.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i5 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, 1574126077, "C:LocalPictureModule.kt#k8mqxt");
            LocalImageAsset it = module.getAsset();
            if (it == null) {
                $composer4.startReplaceGroup(1574128741);
                $composer4.endReplaceGroup();
                $composer2 = $composer4;
                $composer$iv = $composer4;
                i2 = 0;
            } else {
                $composer4.startReplaceGroup(1574128742);
                ComposerKt.sourceInformation($composer4, "*102@4052L396,98@3887L617");
                ComposerKt.sourceInformationMarkerStart($composer4, -2086384728, "CC(remember):LocalPictureModule.kt#9igjgp");
                boolean invalid$iv = (($dirty2 & 7168) == 2048) | (($dirty2 & 896) == 256);
                Object it$iv = $composer4.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv = (Function3) new LocalPictureModuleKt$LocalPictureModule$1$1$1$1(actionHandler, message, null);
                $composer4.updateRememberedValue(value$iv);
                it$iv = value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer2 = $composer4;
                $composer$iv = $composer4;
                i2 = 0;
                m1785LocalImageMMVEmd4(it, expectResolution, moduleSize, (Function3) it$iv, frameScope, $composer2, ($dirty2 << 12) & 57344);
                $composer2.endReplaceGroup();
            }
            if (message.getSendStatus() == SendStatus.Sending) {
                float uploadProgress = module.getUploadProgress();
                if (((0.0f > uploadProgress || uploadProgress > 1.0f) ? i2 : 1) != 0) {
                    $composer3 = $composer2;
                    $composer3.startReplaceGroup(1574845865);
                    ComposerKt.sourceInformation($composer3, "116@4618L93,117@4724L128");
                    BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.size-6HolHcs(Modifier.Companion, moduleSize), Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.01f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null), $composer3, i2);
                    UploadProgressKt.m1787UploadProgresspc5RIQQ(module.getUploadProgress(), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(26)), 0L, 0L, 0.0f, $composer3, 48, 28);
                    $composer3.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    $composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }
            $composer3 = $composer2;
            $composer3.startReplaceGroup(1570269707);
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        ScopeUpdateScope endRestartGroup = $composer4.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.module.localPicture.LocalPictureModuleKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit LocalPictureModule$lambda$3;
                    LocalPictureModule$lambda$3 = LocalPictureModuleKt.LocalPictureModule$lambda$3(ChatMsgFrameScope.this, module, message, actionHandler, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return LocalPictureModule$lambda$3;
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:92:0x02a9, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L78;
     */
    /* renamed from: LocalImage-MMVEmd4  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void m1785LocalImageMMVEmd4(final LocalImageAsset asset, final Resolution expectResolution, final long j2, final Function3<? super ImageSource, ? super IntRect, ? super Continuation<? super Unit>, ? extends Object> function3, final ChatMsgFrameScope frameScope, Composer $composer, final int $changed) {
        String str;
        State click;
        final MutableState coordinates;
        int $dirty;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(689882735);
        ComposerKt.sourceInformation($composer2, "C(LocalImage)N(asset,expectResolution,moduleSize:c#ui.unit.DpSize,onImageClick,frameScope)133@5110L76,134@5209L53,135@5279L34,137@5331L24,138@5379L47,139@5453L158,139@5431L180,146@5636L89:LocalPictureModule.kt#k8mqxt");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(asset) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(expectResolution) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changed(j2) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changedInstance(function3) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer2.changed(frameScope) ? 16384 : 8192;
        }
        int $dirty3 = $dirty2;
        if ($composer2.shouldExecute(($dirty3 & 9363) != 9362, $dirty3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(689882735, $dirty3, -1, "kntr.app.im.chat.ui.module.localPicture.LocalImage (LocalPictureModule.kt:132)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 1552351803, "CC(remember):LocalPictureModule.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = AssetEntry.INSTANCE.getShower().getShowerForAssetType(Reflection.getOrCreateKotlinClass(LocalImageAsset.class));
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            AssetShower shower = (AssetShower) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1552354948, "CC(remember):LocalPictureModule.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                MutableState mutableStateOf$default = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(mutableStateOf$default);
                it$iv2 = mutableStateOf$default;
            }
            MutableState coordinates2 = (MutableState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            State click2 = SnapshotStateKt.rememberUpdatedState(function3, $composer2, ($dirty3 >> 9) & 14);
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object value$iv$iv = $composer2.rememberedValue();
            if (value$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv);
            }
            final CoroutineScope scope = (CoroutineScope) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1552360382, "CC(remember):LocalPictureModule.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv3 = value$iv2;
            }
            final MutableState imageSource$delegate = (MutableState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1552362861, "CC(remember):LocalPictureModule.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(scope) | (($dirty3 & 14) == 4) | $composer2.changedInstance(shower) | (($dirty3 & 112) == 32);
            Object value$iv3 = $composer2.rememberedValue();
            if (invalid$iv || value$iv3 == Composer.Companion.getEmpty()) {
                str = "CC(remember):LocalPictureModule.kt#9igjgp";
                click = click2;
                coordinates = coordinates2;
                $dirty = $dirty3;
                value$iv3 = new LocalPictureModuleKt$LocalImage$1$1(scope, asset, shower, expectResolution, imageSource$delegate, null);
                $composer2.updateRememberedValue(value$iv3);
            } else {
                str = "CC(remember):LocalPictureModule.kt#9igjgp";
                coordinates = coordinates2;
                $dirty = $dirty3;
                click = click2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(asset, (Function2) value$iv3, $composer2, $dirty & 14);
            Painter image = BiliImagePainterKt.rememberBiliImagePainter(LocalImage_MMVEmd4$lambda$3(imageSource$delegate), new BiliImageOptions(false, 0, false, false, false, (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, (AnimateStrategy) null, ResizeOption.Companion.getAUTO(), (CachePolicy) null, (CachePolicy) null, 7167, (DefaultConstructorMarker) null), $composer2, 0);
            if (image != null) {
                $composer2.startReplaceGroup(878924513);
                ComposerKt.sourceInformation($composer2, "154@5952L70,156@6037L577,148@5759L866");
                Modifier modifier = SizeKt.size-6HolHcs(Modifier.Companion, j2);
                String str2 = str;
                ComposerKt.sourceInformationMarkerStart($composer2, 1552378741, str2);
                Object it$iv4 = $composer2.rememberedValue();
                if (it$iv4 == Composer.Companion.getEmpty()) {
                    Object value$iv4 = new Function1() { // from class: kntr.app.im.chat.ui.module.localPicture.LocalPictureModuleKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            Unit LocalImage_MMVEmd4$lambda$6$0;
                            LocalImage_MMVEmd4$lambda$6$0 = LocalPictureModuleKt.LocalImage_MMVEmd4$lambda$6$0(coordinates, (LayoutCoordinates) obj);
                            return LocalImage_MMVEmd4$lambda$6$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv4);
                    it$iv4 = value$iv4;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier, (Function1) it$iv4);
                ComposerKt.sourceInformationMarkerStart($composer2, 1552381968, str2);
                boolean invalid$iv2 = $composer2.changedInstance(scope) | $composer2.changed(click) | (($dirty & 57344) == 16384);
                Object it$iv5 = $composer2.rememberedValue();
                if (invalid$iv2) {
                }
                final MutableState mutableState = coordinates;
                final State state = click;
                Object value$iv5 = new Function1() { // from class: kntr.app.im.chat.ui.module.localPicture.LocalPictureModuleKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        boolean LocalImage_MMVEmd4$lambda$7$0;
                        LocalImage_MMVEmd4$lambda$7$0 = LocalPictureModuleKt.LocalImage_MMVEmd4$lambda$7$0(mutableState, scope, frameScope, state, imageSource$delegate, (Offset) obj);
                        return Boolean.valueOf(LocalImage_MMVEmd4$lambda$7$0);
                    }
                };
                $composer2.updateRememberedValue(value$iv5);
                it$iv5 = value$iv5;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ImageKt.Image(image, (String) null, ChatClickableKt.chatClickable$default(onGloballyPositioned, null, (Function1) it$iv5, 1, null), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer2, Painter.$stable | 48, 120);
                $composer2.endReplaceGroup();
            } else {
                ImageSource LocalImage_MMVEmd4$lambda$3 = LocalImage_MMVEmd4$lambda$3(imageSource$delegate);
                if ((LocalImage_MMVEmd4$lambda$3 != null ? LocalImage_MMVEmd4$lambda$3.getError() : null) != null) {
                    $composer2.startReplaceGroup(879821064);
                    ComposerKt.sourceInformation($composer2, "171@6741L6,171@6679L347");
                    Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(SizeKt.size-6HolHcs(Modifier.Companion, j2), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGraph_bg_thick-0d7_KjU(), (Shape) null, 2, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                    MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                    int $changed$iv$iv = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                    CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
                    Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer2.startReusableNode();
                    if ($composer2.getInserting()) {
                        factory$iv$iv$iv = factory$iv$iv$iv2;
                        $composer2.createNode(factory$iv$iv$iv);
                    } else {
                        factory$iv$iv$iv = factory$iv$iv$iv2;
                        $composer2.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                    int i = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    int i2 = ((0 >> 6) & 112) | 6;
                    BoxScope $this$LocalImage_MMVEmd4_u24lambda_u248 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer2, 1920016861, "C173@6824L14,175@6916L6,172@6779L237:LocalPictureModule.kt#k8mqxt");
                    IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getImage_line_500($composer2, 6), (String) null, $this$LocalImage_MMVEmd4_u24lambda_u248.align(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(32)), Alignment.Companion.getCenter()), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText4-0d7_KjU(), $composer2, Painter.$stable | 48, 0);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endReplaceGroup();
                } else {
                    $composer2.startReplaceGroup(880181811);
                    ComposerKt.sourceInformation($composer2, "184@7181L6,180@7048L176");
                    BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.size-6HolHcs(Modifier.Companion, j2), Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText4-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null), $composer2, 0);
                    $composer2.endReplaceGroup();
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.module.localPicture.LocalPictureModuleKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit LocalImage_MMVEmd4$lambda$9;
                    LocalImage_MMVEmd4$lambda$9 = LocalPictureModuleKt.LocalImage_MMVEmd4$lambda$9(LocalImageAsset.this, expectResolution, j2, function3, frameScope, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return LocalImage_MMVEmd4$lambda$9;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageSource LocalImage_MMVEmd4$lambda$3(MutableState<ImageSource> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (ImageSource) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LocalImage_MMVEmd4$lambda$6$0(MutableState $coordinates, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $coordinates.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean LocalImage_MMVEmd4$lambda$7$0(MutableState $coordinates, CoroutineScope $scope, ChatMsgFrameScope $frameScope, State $click, MutableState $imageSource$delegate, Offset it) {
        IntRect frameInWindow;
        LayoutCoordinates it2 = (LayoutCoordinates) $coordinates.getValue();
        if (it2 != null) {
            long position = LayoutCoordinatesKt.positionInWindow(it2);
            long size = it2.getSize-YbymL2g();
            frameInWindow = IntRectKt.IntRect-VbeCjmY(IntOffsetKt.round-k-4lQ0M(position), size);
        } else {
            frameInWindow = null;
        }
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new LocalPictureModuleKt$LocalImage$3$1$1($click, frameInWindow, $imageSource$delegate, null), 3, (Object) null);
        CardReporter.CC.reportMsgClick$default($frameScope.getCardReporter(), null, 1, null);
        return true;
    }
}