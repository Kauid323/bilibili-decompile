package kntr.app.im.chat.ui.widget;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.AnchoredDraggableKt;
import androidx.compose.foundation.gestures.AnchoredDraggableState;
import androidx.compose.foundation.gestures.DraggableAnchorsConfig;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.trio.pagecontroller.BackHandlerKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ChatMediaSelectBottomSheet.kt */
@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a!\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001ad\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\r2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\r2\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\b0\r¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0002\u0010\u0013\u001a+\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u0019\u0010\u001a\u001a \u0010\u001b\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u001d*\b\u0012\u0004\u0012\u0002H\u001d0\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002\u001a-\u0010!\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\"\u001a\u00020\u0016H\u0001¢\u0006\u0004\b#\u0010$¨\u0006%"}, d2 = {"rememberChatMediaSelectBottomSheetState", "Lkntr/app/im/chat/ui/widget/ChatMediaSelectBottomSheetState;", "initialValue", "Lkntr/app/im/chat/ui/widget/ChatMediaSelectSheetState;", "isEnableExpand", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkntr/app/im/chat/ui/widget/ChatMediaSelectSheetState;ZLandroidx/compose/runtime/Composer;II)Lkntr/app/im/chat/ui/widget/ChatMediaSelectBottomSheetState;", "ChatMediaSelectBottomSheet", RoomRecommendViewModel.EMPTY_CURSOR, "modifier", "Landroidx/compose/ui/Modifier;", "state", "onDismissRequest", "Lkotlin/Function0;", "peekHeight", "Landroidx/compose/ui/unit/Dp;", "paddingFromTop", "content", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/Modifier;Lkntr/app/im/chat/ui/widget/ChatMediaSelectBottomSheetState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Scrim", "color", "Landroidx/compose/ui/graphics/Color;", "progress", RoomRecommendViewModel.EMPTY_CURSOR, "Scrim-KTwxG1Y", "(JLandroidx/compose/ui/Modifier;FLandroidx/compose/runtime/Composer;II)V", "preUpPostDownNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "T", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "ChatMediaSelectPullBar", "backgroundColor", "ChatMediaSelectPullBar-RIQooxk", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ChatMediaSelectBottomSheetKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatMediaSelectBottomSheet$lambda$5(Modifier modifier, ChatMediaSelectBottomSheetState chatMediaSelectBottomSheetState, Function0 function0, Function0 function02, Function0 function03, Function2 function2, int i, int i2, Composer composer, int i3) {
        ChatMediaSelectBottomSheet(modifier, chatMediaSelectBottomSheetState, function0, function02, function03, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatMediaSelectPullBar_RIQooxk$lambda$1(Modifier modifier, long j2, long j3, int i, int i2, Composer composer, int i3) {
        m1925ChatMediaSelectPullBarRIQooxk(modifier, j2, j3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Scrim_KTwxG1Y$lambda$2(long j2, Modifier modifier, float f, int i, int i2, Composer composer, int i3) {
        m1926ScrimKTwxG1Y(j2, modifier, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final ChatMediaSelectBottomSheetState rememberChatMediaSelectBottomSheetState(ChatMediaSelectSheetState initialValue, boolean isEnableExpand, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, 2141405749, "C(rememberChatMediaSelectBottomSheetState)N(initialValue,isEnableExpand)88@3310L86:ChatMediaSelectBottomSheet.kt#92mklk");
        if ((i & 1) != 0) {
            initialValue = ChatMediaSelectSheetState.PartiallyExpanded;
        }
        if ((i & 2) != 0) {
            isEnableExpand = true;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2141405749, $changed, -1, "kntr.app.im.chat.ui.widget.rememberChatMediaSelectBottomSheetState (ChatMediaSelectBottomSheet.kt:88)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 601596907, "CC(remember):ChatMediaSelectBottomSheet.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new ChatMediaSelectBottomSheetState(initialValue, isEnableExpand);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ChatMediaSelectBottomSheetState chatMediaSelectBottomSheetState = (ChatMediaSelectBottomSheetState) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return chatMediaSelectBottomSheetState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Dp ChatMediaSelectBottomSheet$lambda$1$0() {
        return Dp.box-impl(ChatMediaSelectBottomSheetDefaults.INSTANCE.m1919getPeekHeightD9Ej5fM());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Dp ChatMediaSelectBottomSheet$lambda$2$0() {
        return Dp.box-impl(ChatMediaSelectBottomSheetDefaults.INSTANCE.m1918getPaddingForTopAppBarD9Ej5fM());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v8 */
    public static final void ChatMediaSelectBottomSheet(Modifier modifier, ChatMediaSelectBottomSheetState state, Function0<Unit> function0, Function0<Dp> function02, Function0<Dp> function03, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        ChatMediaSelectBottomSheetState chatMediaSelectBottomSheetState;
        Function0 onDismissRequest;
        Function0 peekHeight;
        Function0 function04;
        ChatMediaSelectBottomSheetState state2;
        Function0 paddingFromTop;
        Function0 paddingFromTop2;
        Modifier modifier3;
        Function0 peekHeight2;
        Modifier modifier4;
        ChatMediaSelectBottomSheetState state3;
        int $dirty;
        Modifier modifier5;
        final Function0 onDismissRequest2;
        final Function0 paddingFromTop3;
        int $dirty2;
        final Function0 peekHeight3;
        final ChatMediaSelectBottomSheetState state4;
        int i2;
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer $composer2 = $composer.startRestartGroup(977447757);
        ComposerKt.sourceInformation($composer2, "C(ChatMediaSelectBottomSheet)N(modifier,state,onDismissRequest,peekHeight,paddingFromTop,content)103@3842L34,103@3830L46,109@3951L3410,107@3882L3479:ChatMediaSelectBottomSheet.kt#92mklk");
        int $dirty3 = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty3 |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            if ((i & 2) == 0) {
                chatMediaSelectBottomSheetState = state;
                if ($composer2.changed(chatMediaSelectBottomSheetState)) {
                    i2 = 32;
                    $dirty3 |= i2;
                }
            } else {
                chatMediaSelectBottomSheetState = state;
            }
            i2 = 16;
            $dirty3 |= i2;
        } else {
            chatMediaSelectBottomSheetState = state;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty3 |= 384;
            onDismissRequest = function0;
        } else if (($changed & 384) == 0) {
            onDismissRequest = function0;
            $dirty3 |= $composer2.changedInstance(onDismissRequest) ? 256 : 128;
        } else {
            onDismissRequest = function0;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty3 |= 3072;
            peekHeight = function02;
        } else if (($changed & 3072) == 0) {
            peekHeight = function02;
            $dirty3 |= $composer2.changedInstance(peekHeight) ? 2048 : 1024;
        } else {
            peekHeight = function02;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty3 |= 24576;
            function04 = function03;
        } else if (($changed & 24576) == 0) {
            function04 = function03;
            $dirty3 |= $composer2.changedInstance(function04) ? 16384 : 8192;
        } else {
            function04 = function03;
        }
        if ((196608 & $changed) == 0) {
            $dirty3 |= $composer2.changedInstance(function2) ? 131072 : 65536;
        }
        if ($composer2.shouldExecute((74899 & $dirty3) != 74898, $dirty3 & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "95@3522L41,96@3600L2,97@3631L49,98@3713L70");
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty3 &= -113;
                }
                modifier5 = modifier2;
                onDismissRequest2 = onDismissRequest;
                paddingFromTop3 = function04;
                $dirty2 = $dirty3;
                peekHeight3 = peekHeight;
                state4 = chatMediaSelectBottomSheetState;
            } else {
                if (i3 != 0) {
                    modifier4 = (Modifier) Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 2) == 0) {
                    state3 = chatMediaSelectBottomSheetState;
                } else {
                    state3 = rememberChatMediaSelectBottomSheetState(null, false, $composer2, 0, 3);
                    $dirty3 &= -113;
                }
                if (i4 == 0) {
                    $dirty = $dirty3;
                } else {
                    ComposerKt.sourceInformationMarkerStart($composer2, -1270537265, "CC(remember):ChatMediaSelectBottomSheet.kt#9igjgp");
                    Object it$iv = $composer2.rememberedValue();
                    $dirty = $dirty3;
                    if (it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = new Function0() { // from class: kntr.app.im.chat.ui.widget.ChatMediaSelectBottomSheetKt$$ExternalSyntheticLambda6
                            public final Object invoke() {
                                Unit unit;
                                unit = Unit.INSTANCE;
                                return unit;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    Function0 onDismissRequest3 = it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    onDismissRequest = onDismissRequest3;
                }
                if (i5 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer2, -1270536226, "CC(remember):ChatMediaSelectBottomSheet.kt#9igjgp");
                    Object it$iv2 = $composer2.rememberedValue();
                    if (it$iv2 == Composer.Companion.getEmpty()) {
                        Object value$iv2 = new Function0() { // from class: kntr.app.im.chat.ui.widget.ChatMediaSelectBottomSheetKt$$ExternalSyntheticLambda7
                            public final Object invoke() {
                                Dp ChatMediaSelectBottomSheet$lambda$1$0;
                                ChatMediaSelectBottomSheet$lambda$1$0 = ChatMediaSelectBottomSheetKt.ChatMediaSelectBottomSheet$lambda$1$0();
                                return ChatMediaSelectBottomSheet$lambda$1$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv2);
                        it$iv2 = value$iv2;
                    }
                    Function0 peekHeight4 = it$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    peekHeight = peekHeight4;
                }
                if (i6 == 0) {
                    modifier5 = modifier4;
                    onDismissRequest2 = onDismissRequest;
                    paddingFromTop3 = function04;
                    $dirty2 = $dirty;
                    peekHeight3 = peekHeight;
                    state4 = state3;
                } else {
                    ComposerKt.sourceInformationMarkerStart($composer2, -1270533581, "CC(remember):ChatMediaSelectBottomSheet.kt#9igjgp");
                    Object it$iv3 = $composer2.rememberedValue();
                    if (it$iv3 == Composer.Companion.getEmpty()) {
                        Object value$iv3 = new Function0() { // from class: kntr.app.im.chat.ui.widget.ChatMediaSelectBottomSheetKt$$ExternalSyntheticLambda8
                            public final Object invoke() {
                                Dp ChatMediaSelectBottomSheet$lambda$2$0;
                                ChatMediaSelectBottomSheet$lambda$2$0 = ChatMediaSelectBottomSheetKt.ChatMediaSelectBottomSheet$lambda$2$0();
                                return ChatMediaSelectBottomSheet$lambda$2$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv3);
                        it$iv3 = value$iv3;
                    }
                    Function0 paddingFromTop4 = it$iv3;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    paddingFromTop3 = paddingFromTop4;
                    modifier5 = modifier4;
                    onDismissRequest2 = onDismissRequest;
                    peekHeight3 = peekHeight;
                    $dirty2 = $dirty;
                    state4 = state3;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(977447757, $dirty2, -1, "kntr.app.im.chat.ui.widget.ChatMediaSelectBottomSheet (ChatMediaSelectBottomSheet.kt:102)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1270529489, "CC(remember):ChatMediaSelectBottomSheet.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 896) == 256;
            Object it$iv4 = $composer2.rememberedValue();
            if (invalid$iv || it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new Function0() { // from class: kntr.app.im.chat.ui.widget.ChatMediaSelectBottomSheetKt$$ExternalSyntheticLambda9
                    public final Object invoke() {
                        Unit ChatMediaSelectBottomSheet$lambda$3$0;
                        ChatMediaSelectBottomSheet$lambda$3$0 = ChatMediaSelectBottomSheetKt.ChatMediaSelectBottomSheet$lambda$3$0(onDismissRequest2);
                        return ChatMediaSelectBottomSheet$lambda$3$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            BackHandlerKt.BackHandler(false, (Function0) it$iv4, $composer2, 0, 1);
            BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier5, 0.0f, 1, (Object) null), (Alignment) null, false, ComposableLambdaKt.rememberComposableLambda(-2101864649, true, new Function3() { // from class: kntr.app.im.chat.ui.widget.ChatMediaSelectBottomSheetKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit ChatMediaSelectBottomSheet$lambda$4;
                    ChatMediaSelectBottomSheet$lambda$4 = ChatMediaSelectBottomSheetKt.ChatMediaSelectBottomSheet$lambda$4(ChatMediaSelectBottomSheetState.this, peekHeight3, paddingFromTop3, function2, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return ChatMediaSelectBottomSheet$lambda$4;
                }
            }, $composer2, 54), $composer2, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            paddingFromTop2 = paddingFromTop3;
            paddingFromTop = peekHeight3;
            peekHeight2 = onDismissRequest2;
            state2 = state4;
            modifier3 = modifier5;
        } else {
            $composer2.skipToGroupEnd();
            state2 = chatMediaSelectBottomSheetState;
            paddingFromTop = peekHeight;
            paddingFromTop2 = function04;
            modifier3 = modifier2;
            peekHeight2 = onDismissRequest;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final ChatMediaSelectBottomSheetState chatMediaSelectBottomSheetState2 = state2;
            final Function0 function05 = peekHeight2;
            final Function0 function06 = paddingFromTop;
            final Function0 function07 = paddingFromTop2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.widget.ChatMediaSelectBottomSheetKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit ChatMediaSelectBottomSheet$lambda$5;
                    ChatMediaSelectBottomSheet$lambda$5 = ChatMediaSelectBottomSheetKt.ChatMediaSelectBottomSheet$lambda$5(modifier6, chatMediaSelectBottomSheetState2, function05, function06, function07, function2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ChatMediaSelectBottomSheet$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatMediaSelectBottomSheet$lambda$3$0(Function0 $onDismissRequest) {
        $onDismissRequest.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatMediaSelectBottomSheet$lambda$4(final ChatMediaSelectBottomSheetState $state, Function0 $peekHeight, Function0 $paddingFromTop, final Function2 $content, BoxWithConstraintsScope $this$BoxWithConstraints, Composer $composer, int $changed) {
        Function0 factory$iv$iv;
        Intrinsics.checkNotNullParameter($this$BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation($composer, "C110@3988L7,115@4183L579,139@5095L24,175@6536L819,141@5129L2226:ChatMediaSelectBottomSheet.kt#92mklk");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$BoxWithConstraints) ? 4 : 2;
        }
        if ($composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2101864649, $dirty, -1, "kntr.app.im.chat.ui.widget.ChatMediaSelectBottomSheet.<anonymous> (ChatMediaSelectBottomSheet.kt:110)");
            }
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            Density density = (Density) consume;
            final float fullHeight = Constraints.getMaxHeight-impl($this$BoxWithConstraints.getConstraints-msEJaDk());
            final float peekPx = density.toPx-0680j_4(((Dp) $peekHeight.invoke()).unbox-impl());
            final float paddingPx = density.toPx-0680j_4(((Dp) $paddingFromTop.invoke()).unbox-impl());
            boolean isEnableExpand = $state.isEnableExpand();
            ComposerKt.sourceInformationMarkerStart($composer, -1257290566, "CC(remember):ChatMediaSelectBottomSheet.kt#9igjgp");
            boolean invalid$iv = $composer.changed(isEnableExpand) | $composer.changed(fullHeight) | $composer.changed(peekPx);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                AnchoredDraggableState.updateAnchors$default($state.getAnchoredDraggableState$ui_debug(), AnchoredDraggableKt.DraggableAnchors(new Function1() { // from class: kntr.app.im.chat.ui.widget.ChatMediaSelectBottomSheetKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        Unit ChatMediaSelectBottomSheet$lambda$4$2$0;
                        ChatMediaSelectBottomSheet$lambda$4$2$0 = ChatMediaSelectBottomSheetKt.ChatMediaSelectBottomSheet$lambda$4$2$0(fullHeight, peekPx, $state, paddingPx, (DraggableAnchorsConfig) obj);
                        return ChatMediaSelectBottomSheet$lambda$4$2$0;
                    }
                }), (Object) null, 2, (Object) null);
                $composer.updateRememberedValue(Unit.INSTANCE);
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            float progress = $state.isEnableExpand() ? $state.getAnchoredDraggableState$ui_debug().progress(ChatMediaSelectSheetState.PartiallyExpanded, ChatMediaSelectSheetState.Expanded) : 0.0f;
            ComposerKt.sourceInformationMarkerStart($composer, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object value$iv$iv = $composer.rememberedValue();
            if (value$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer);
                $composer.updateRememberedValue(value$iv$iv);
            }
            CoroutineScope scope = (CoroutineScope) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -1257215030, "CC(remember):ChatMediaSelectBottomSheet.kt#9igjgp");
            boolean invalid$iv2 = $composer.changed($state);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv = (MeasurePolicy) new ChatMediaSelectBottomSheetKt$ChatMediaSelectBottomSheet$5$3$1($state);
                $composer.updateRememberedValue(value$iv);
                it$iv2 = value$iv;
            }
            MeasurePolicy measurePolicy$iv = (MeasurePolicy) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            Modifier modifier$iv = Modifier.Companion;
            int compositeKeyHash$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv = ((0 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv = factory$iv$iv2;
                $composer.createNode(factory$iv$iv);
            } else {
                factory$iv$iv = factory$iv$iv2;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv, Integer.valueOf(compositeKeyHash$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv, materialized$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, -252883417, "C144@5202L140,161@5972L6,171@6461L49,149@5381L1129:ChatMediaSelectBottomSheet.kt#92mklk");
            m1926ScrimKTwxG1Y(ChatMediaSelectBottomSheetDefaults.INSTANCE.m1920getScrimColor0d7_KjU(), null, progress, $composer, 0, 2);
            SurfaceKt.Surface-T9BRK9s(AnchoredDraggableKt.anchoredDraggable$default(NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), preUpPostDownNestedScrollConnection($state.getAnchoredDraggableState$ui_debug(), scope), (NestedScrollDispatcher) null, 2, (Object) null), $state.getAnchoredDraggableState$ui_debug(), Orientation.Vertical, false, (MutableInteractionSource) null, (OverscrollEffect) null, (FlingBehavior) null, 60, (Object) null), (progress > 0.0f ? 1 : (progress == 0.0f ? 0 : -1)) == 0 ? RectangleShapeKt.getRectangleShape() : RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(ChatMediaSelectBottomSheetDefaults.INSTANCE.m1921getSheetContentCornerShapeD9Ej5fM(), ChatMediaSelectBottomSheetDefaults.INSTANCE.m1921getSheetContentCornerShapeD9Ej5fM(), 0.0f, 0.0f, 12, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), 0L, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-1852051227, true, new Function2() { // from class: kntr.app.im.chat.ui.widget.ChatMediaSelectBottomSheetKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit ChatMediaSelectBottomSheet$lambda$4$3$0;
                    ChatMediaSelectBottomSheet$lambda$4$3$0 = ChatMediaSelectBottomSheetKt.ChatMediaSelectBottomSheet$lambda$4$3$0($content, (Composer) obj, ((Integer) obj2).intValue());
                    return ChatMediaSelectBottomSheet$lambda$4$3$0;
                }
            }, $composer, 54), $composer, 12582912, 120);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatMediaSelectBottomSheet$lambda$4$2$0(float $fullHeight, float $peekPx, ChatMediaSelectBottomSheetState $state, float $paddingPx, DraggableAnchorsConfig $this$DraggableAnchors) {
        Intrinsics.checkNotNullParameter($this$DraggableAnchors, "$this$DraggableAnchors");
        $this$DraggableAnchors.at(ChatMediaSelectSheetState.PartiallyExpanded, RangesKt.coerceAtLeast($fullHeight - $peekPx, 0.0f));
        if ($state.isEnableExpand()) {
            $this$DraggableAnchors.at(ChatMediaSelectSheetState.Expanded, $paddingPx);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatMediaSelectBottomSheet$lambda$4$3$0(Function2 $content, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C172@6483L9:ChatMediaSelectBottomSheet.kt#92mklk");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1852051227, $changed, -1, "kntr.app.im.chat.ui.widget.ChatMediaSelectBottomSheet.<anonymous>.<anonymous>.<anonymous> (ChatMediaSelectBottomSheet.kt:172)");
            }
            $content.invoke($composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* renamed from: Scrim-KTwxG1Y  reason: not valid java name */
    public static final void m1926ScrimKTwxG1Y(final long j2, Modifier modifier, float progress, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final float progress2;
        float progress3;
        Modifier modifier3;
        Modifier modifier4;
        Modifier pointerModifier;
        Composer $composer2 = $composer.startRestartGroup(-1636536274);
        ComposerKt.sourceInformation($composer2, "C(Scrim)N(color:c#ui.graphics.Color,modifier,progress):ChatMediaSelectBottomSheet.kt#92mklk");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(j2) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            progress2 = progress;
        } else if (($changed & 384) == 0) {
            progress2 = progress;
            $dirty |= $composer2.changed(progress2) ? 256 : 128;
        } else {
            progress2 = progress;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            progress3 = progress2;
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 != 0) {
                progress2 = 1.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1636536274, $dirty2, -1, "kntr.app.im.chat.ui.widget.Scrim (ChatMediaSelectBottomSheet.kt:206)");
            }
            if ((j2 != 16 ? 1 : 0) != 0) {
                $composer2.startReplaceGroup(-1878214555);
                ComposerKt.sourceInformation($composer2, "222@7974L397,220@7898L473");
                if (progress2 == 1.0f) {
                    $composer2.startReplaceGroup(-1878169636);
                    ComposerKt.sourceInformation($composer2, "210@7608L220");
                    Modifier modifier5 = Modifier.Companion;
                    Unit unit = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer2, -753321366, "CC(remember):ChatMediaSelectBottomSheet.kt#9igjgp");
                    Object it$iv = $composer2.rememberedValue();
                    if (it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = (PointerInputEventHandler) new PointerInputEventHandler() { // from class: kntr.app.im.chat.ui.widget.ChatMediaSelectBottomSheetKt$Scrim$pointerModifier$1$1

                            /* compiled from: ChatMediaSelectBottomSheet.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                            @DebugMetadata(c = "kntr.app.im.chat.ui.widget.ChatMediaSelectBottomSheetKt$Scrim$pointerModifier$1$1$1", f = "ChatMediaSelectBottomSheet.kt", i = {0, 1}, l = {213, 214}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture"}, s = {"L$0", "L$0"}, v = 1)
                            /* renamed from: kntr.app.im.chat.ui.widget.ChatMediaSelectBottomSheetKt$Scrim$pointerModifier$1$1$1  reason: invalid class name */
                            /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                            static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                                private /* synthetic */ Object L$0;
                                int label;

                                AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                                    super(2, continuation);
                                }

                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    Continuation<Unit> anonymousClass1 = new AnonymousClass1(continuation);
                                    anonymousClass1.L$0 = obj;
                                    return anonymousClass1;
                                }

                                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                                    return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
                                }

                                /* JADX WARN: Removed duplicated region for block: B:13:0x004f A[RETURN] */
                                /* JADX WARN: Removed duplicated region for block: B:16:0x0054  */
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                */
                                public final Object invokeSuspend(Object $result) {
                                    Object awaitFirstDown$default;
                                    Object waitForUpOrCancellation$default;
                                    PointerInputChange pointerInputChange;
                                    AwaitPointerEventScope $this$awaitEachGesture = (AwaitPointerEventScope) this.L$0;
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch (this.label) {
                                        case 0:
                                            ResultKt.throwOnFailure($result);
                                            this.L$0 = $this$awaitEachGesture;
                                            this.label = 1;
                                            awaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default($this$awaitEachGesture, false, PointerEventPass.Main, (Continuation) this, 1, (Object) null);
                                            if (awaitFirstDown$default == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            ((PointerInputChange) awaitFirstDown$default).consume();
                                            this.L$0 = SpillingKt.nullOutSpilledVariable($this$awaitEachGesture);
                                            this.label = 2;
                                            waitForUpOrCancellation$default = TapGestureDetectorKt.waitForUpOrCancellation$default($this$awaitEachGesture, (PointerEventPass) null, (Continuation) this, 1, (Object) null);
                                            if (waitForUpOrCancellation$default == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            pointerInputChange = (PointerInputChange) waitForUpOrCancellation$default;
                                            if (pointerInputChange != null) {
                                                pointerInputChange.consume();
                                            }
                                            return Unit.INSTANCE;
                                        case 1:
                                            ResultKt.throwOnFailure($result);
                                            awaitFirstDown$default = $result;
                                            ((PointerInputChange) awaitFirstDown$default).consume();
                                            this.L$0 = SpillingKt.nullOutSpilledVariable($this$awaitEachGesture);
                                            this.label = 2;
                                            waitForUpOrCancellation$default = TapGestureDetectorKt.waitForUpOrCancellation$default($this$awaitEachGesture, (PointerEventPass) null, (Continuation) this, 1, (Object) null);
                                            if (waitForUpOrCancellation$default == coroutine_suspended) {
                                            }
                                            pointerInputChange = (PointerInputChange) waitForUpOrCancellation$default;
                                            if (pointerInputChange != null) {
                                            }
                                            return Unit.INSTANCE;
                                        case 2:
                                            ResultKt.throwOnFailure($result);
                                            waitForUpOrCancellation$default = $result;
                                            pointerInputChange = (PointerInputChange) waitForUpOrCancellation$default;
                                            if (pointerInputChange != null) {
                                            }
                                            return Unit.INSTANCE;
                                        default:
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                }
                            }

                            public final Object invoke(PointerInputScope $this$pointerInput, Continuation<? super Unit> continuation) {
                                Object awaitEachGesture = ForEachGestureKt.awaitEachGesture($this$pointerInput, new AnonymousClass1(null), continuation);
                                return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    pointerModifier = SuspendingPointerInputFilterKt.pointerInput(modifier5, unit, (PointerInputEventHandler) it$iv);
                    $composer2.endReplaceGroup();
                } else {
                    $composer2.startReplaceGroup(-1877893364);
                    $composer2.endReplaceGroup();
                    pointerModifier = Modifier.Companion;
                }
                Modifier then = SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, (Object) null).then(pointerModifier);
                ComposerKt.sourceInformationMarkerStart($composer2, -753309477, "CC(remember):ChatMediaSelectBottomSheet.kt#9igjgp");
                boolean invalid$iv = (($dirty2 & 14) == 4) | (($dirty2 & 896) == 256);
                Object it$iv2 = $composer2.rememberedValue();
                if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function1() { // from class: kntr.app.im.chat.ui.widget.ChatMediaSelectBottomSheetKt$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj) {
                            Unit Scrim_KTwxG1Y$lambda$1$0;
                            Scrim_KTwxG1Y$lambda$1$0 = ChatMediaSelectBottomSheetKt.Scrim_KTwxG1Y$lambda$1$0(j2, progress2, (DrawScope) obj);
                            return Scrim_KTwxG1Y$lambda$1$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                CanvasKt.Canvas(then, (Function1) it$iv2, $composer2, 0);
            } else {
                $composer2.startReplaceGroup(-1885680812);
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            progress3 = progress2;
            modifier3 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final float f = progress3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.widget.ChatMediaSelectBottomSheetKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit Scrim_KTwxG1Y$lambda$2;
                    Scrim_KTwxG1Y$lambda$2 = ChatMediaSelectBottomSheetKt.Scrim_KTwxG1Y$lambda$2(j2, modifier6, f, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Scrim_KTwxG1Y$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Scrim_KTwxG1Y$lambda$1$0(long j2, float $progress, DrawScope $this$Canvas) {
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        DrawScope.-CC.drawRect-n-J9OG0$default($this$Canvas, j2, 0L, 0L, RangesKt.coerceIn(ChatMediaSelectBottomSheetDefaults.INSTANCE.getScrimColorAlpha() * $progress, 0.0f, ChatMediaSelectBottomSheetDefaults.INSTANCE.getScrimColorAlpha()), (DrawStyle) null, (ColorFilter) null, 0, 118, (Object) null);
        return Unit.INSTANCE;
    }

    private static final <T> NestedScrollConnection preUpPostDownNestedScrollConnection(AnchoredDraggableState<T> anchoredDraggableState, CoroutineScope scope) {
        return new ChatMediaSelectBottomSheetKt$preUpPostDownNestedScrollConnection$1(anchoredDraggableState, scope);
    }

    /* renamed from: ChatMediaSelectPullBar-RIQooxk  reason: not valid java name */
    public static final void m1925ChatMediaSelectPullBarRIQooxk(Modifier modifier, long j2, long j3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j4;
        long j5;
        Modifier modifier3;
        long j6;
        long j7;
        Modifier modifier4;
        long j8;
        Function0 factory$iv$iv$iv;
        int i2;
        int i3;
        Composer $composer2 = $composer.startRestartGroup(364492085);
        ComposerKt.sourceInformation($composer2, "C(ChatMediaSelectPullBar)N(modifier,color:c#ui.graphics.Color,backgroundColor:c#ui.graphics.Color)279@9639L603:ChatMediaSelectBottomSheet.kt#92mklk");
        int $dirty = $changed;
        int i4 = i & 1;
        if (i4 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            if ((i & 2) == 0) {
                j4 = j2;
                if ($composer2.changed(j4)) {
                    i3 = 32;
                    $dirty |= i3;
                }
            } else {
                j4 = j2;
            }
            i3 = 16;
            $dirty |= i3;
        } else {
            j4 = j2;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                j5 = j3;
                if ($composer2.changed(j5)) {
                    i2 = 256;
                    $dirty |= i2;
                }
            } else {
                j5 = j3;
            }
            i2 = 128;
            $dirty |= i2;
        } else {
            j5 = j3;
        }
        if (!$composer2.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            j6 = j4;
            j7 = j5;
        } else {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "276@9566L6,277@9619L6");
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                modifier4 = modifier2;
                j8 = j4;
            } else {
                if (i4 != 0) {
                    modifier4 = (Modifier) Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 2) == 0) {
                    j8 = j4;
                } else {
                    j8 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBa0_s-0d7_KjU();
                    $dirty &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                    j5 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1-0d7_KjU();
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(364492085, $dirty, -1, "kntr.app.im.chat.ui.widget.ChatMediaSelectPullBar (ChatMediaSelectBottomSheet.kt:278)");
            }
            Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), Dp.constructor-impl(19)), j5, (Shape) null, 2, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier modifier$iv$iv = modifier4;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            j7 = j5;
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
            int i5 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i6 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1514108925, "C289@9893L343:ChatMediaSelectBottomSheet.kt#92mklk");
            BoxKt.Box(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(30)), Dp.constructor-impl(3)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2))), Color.copy-wmQWz5c$default(j8, 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null), $composer2, 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier$iv$iv;
            j6 = j8;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final long j9 = j6;
            final long j10 = j7;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.widget.ChatMediaSelectBottomSheetKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit ChatMediaSelectPullBar_RIQooxk$lambda$1;
                    ChatMediaSelectPullBar_RIQooxk$lambda$1 = ChatMediaSelectBottomSheetKt.ChatMediaSelectPullBar_RIQooxk$lambda$1(modifier5, j9, j10, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ChatMediaSelectPullBar_RIQooxk$lambda$1;
                }
            });
        }
    }
}