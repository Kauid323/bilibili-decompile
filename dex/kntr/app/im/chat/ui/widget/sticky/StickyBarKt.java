package kntr.app.im.chat.ui.widget.sticky;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import com.bapis.bilibili.app.im.v1.KChatStickyModule;
import com.bapis.bilibili.app.im.v1.KShortcutItem;
import com.bapis.bilibili.app.im.v1.KShortcutType;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.im.chat.core.model.ChatInfo;
import kntr.app.im.chat.ui.ChatActionHandler;
import kntr.app.im.chat.ui.neuron.ChatReporter;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImmutableImageRequest;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: StickyBar.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\u001a3\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0001¢\u0006\u0002\u0010\n\u001a1\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\rH\u0003¢\u0006\u0002\u0010\u0010¨\u0006\u0011²\u0006\f\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u008a\u008e\u0002"}, d2 = {"StickyBar", RoomRecommendViewModel.EMPTY_CURSOR, "chatInfo", "Lkntr/app/im/chat/core/model/ChatInfo;", "actionHandler", "Lkntr/app/im/chat/ui/ChatActionHandler;", "modifier", "Landroidx/compose/ui/Modifier;", "reporter", "Lkntr/app/im/chat/ui/neuron/ChatReporter;", "(Lkntr/app/im/chat/core/model/ChatInfo;Lkntr/app/im/chat/ui/ChatActionHandler;Landroidx/compose/ui/Modifier;Lkntr/app/im/chat/ui/neuron/ChatReporter;Landroidx/compose/runtime/Composer;II)V", "StickyBarItem", "icon", RoomRecommendViewModel.EMPTY_CURSOR, "title", "subtitle", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "ui_debug", "dialogType", "Lkntr/app/im/chat/ui/widget/sticky/ConfirmDialogType;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class StickyBarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickyBar$lambda$8(ChatInfo chatInfo, ChatActionHandler chatActionHandler, Modifier modifier, ChatReporter chatReporter, int i, int i2, Composer composer, int i3) {
        StickyBar(chatInfo, chatActionHandler, modifier, chatReporter, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickyBarItem$lambda$1(String str, String str2, Modifier modifier, String str3, int i, int i2, Composer composer, int i3) {
        StickyBarItem(str, str2, modifier, str3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void StickyBar(final ChatInfo chatInfo, final ChatActionHandler actionHandler, Modifier modifier, ChatReporter reporter, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        ChatReporter reporter2;
        final Modifier modifier3;
        boolean z;
        CompositionLocalMap localMap$iv$iv;
        KChatStickyModule.KShortcutsModule kShortcutsModule;
        Modifier materialized$iv$iv;
        boolean z2;
        Composer $composer2;
        RowScope $this$StickyBar_u24lambda_u244;
        Function0 factory$iv$iv$iv;
        Modifier modifier$iv$iv;
        Composer $composer$iv;
        Alignment.Vertical verticalAlignment$iv;
        CompositionLocalMap localMap$iv$iv2;
        CoroutineScope scope;
        KChatStickyModule.KShortcutsModule kShortcutsModule2;
        Intrinsics.checkNotNullParameter(chatInfo, "chatInfo");
        Intrinsics.checkNotNullParameter(actionHandler, "actionHandler");
        Composer $composer3 = $composer.startRestartGroup(30884103);
        ComposerKt.sourceInformation($composer3, "C(StickyBar)N(chatInfo,actionHandler,modifier,reporter)49@2009L24,51@2057L65,55@2173L303,130@5253L295,138@5562L21,130@5209L375:StickyBar.kt#o1wnfl");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(chatInfo) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(actionHandler) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            reporter2 = reporter;
        } else if (($changed & 3072) == 0) {
            reporter2 = reporter;
            $dirty |= $composer3.changed(reporter2) ? 2048 : 1024;
        } else {
            reporter2 = reporter;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (i3 != 0) {
                reporter2 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(30884103, $dirty2, -1, "kntr.app.im.chat.ui.widget.sticky.StickyBar (StickyBar.kt:47)");
            }
            KChatStickyModule stickyModule = chatInfo.getStickyModule();
            final KChatStickyModule.KShortcutsModule module = stickyModule != null ? stickyModule.getModule() : null;
            ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer3, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer3.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3);
                $composer3.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            CoroutineScope scope2 = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer3, -385139640, "CC(remember):StickyBar.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableState dialogType$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -385135690, "CC(remember):StickyBar.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: kntr.app.im.chat.ui.widget.sticky.StickyBarKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        boolean StickyBar$lambda$3$0;
                        StickyBar$lambda$3$0 = StickyBarKt.StickyBar$lambda$3$0(dialogType$delegate, (KShortcutType) obj);
                        return Boolean.valueOf(StickyBar$lambda$3$0);
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            final Function1 showDialog = (Function1) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (module instanceof KChatStickyModule.KShortcutsModule) {
                $composer3.startReplaceGroup(946150704);
                ComposerKt.sourceInformation($composer3, "70@2607L1523");
                Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
                int $changed$iv = (($dirty2 >> 6) & 14) | 384;
                Modifier modifier$iv = modifier3;
                ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv2, $composer3, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
                int $changed$iv$iv = ($changed$iv << 3) & 112;
                Modifier modifier$iv$iv2 = modifier$iv;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv$iv2);
                Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    $composer3.createNode(factory$iv$iv$iv2);
                } else {
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
                Function0 factory$iv$iv$iv3 = factory$iv$iv$iv2;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i4 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                int i5 = (($changed$iv >> 6) & 112) | 6;
                RowScope $this$StickyBar_u24lambda_u2442 = RowScopeInstance.INSTANCE;
                RowScope $this$StickyBar_u24lambda_u2443 = $this$StickyBar_u24lambda_u2442;
                Composer $composer4 = $composer3;
                Composer $composer$iv2 = $composer3;
                Alignment.Vertical verticalAlignment$iv3 = verticalAlignment$iv2;
                ComposerKt.sourceInformationMarkerStart($composer4, 1480770230, "C:StickyBar.kt#o1wnfl");
                $composer4.startReplaceGroup(-506421989);
                ComposerKt.sourceInformation($composer4, "*87@3455L620,82@3198L900");
                Iterable $this$forEachIndexed$iv = module.getValue().getItems();
                int index$iv = 0;
                for (Object item$iv : $this$forEachIndexed$iv) {
                    int index$iv2 = index$iv + 1;
                    if (index$iv < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    final KShortcutItem item = (KShortcutItem) item$iv;
                    int index = index$iv;
                    if (index > 0) {
                        $composer4.startReplaceGroup(1522184658);
                        ComposerKt.sourceInformation($composer4, "78@3063L6,73@2809L346");
                        localMap$iv$iv = localMap$iv$iv3;
                        kShortcutsModule = module;
                        materialized$iv$iv = materialized$iv$iv2;
                        z2 = false;
                        BoxKt.Box(SizeKt.width-3ABfNKs(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(1)), Dp.constructor-impl(24)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float) 0.5d))), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getLine_regular-0d7_KjU(), (Shape) null, 2, (Object) null), Dp.constructor-impl(9)), $composer4, 0);
                    } else {
                        localMap$iv$iv = localMap$iv$iv3;
                        kShortcutsModule = module;
                        materialized$iv$iv = materialized$iv$iv2;
                        z2 = false;
                        $composer4.startReplaceGroup(1519410716);
                    }
                    $composer4.endReplaceGroup();
                    String icon = item.getIcon();
                    String title = item.getTitle();
                    String subtitle = item.getSubtitle();
                    Modifier weight = $this$StickyBar_u24lambda_u2443.weight(Modifier.Companion, 1.0f, true);
                    ComposerKt.sourceInformationMarkerStart($composer4, 1296050450, "CC(remember):StickyBar.kt#9igjgp");
                    boolean invalid$iv = $composer3.changedInstance(scope2) | $composer3.changedInstance(item) | (($dirty2 & 112) == 32 ? true : z2) | (($dirty2 & 7168) == 2048 ? true : z2);
                    Composer $this$cache$iv = $composer4;
                    Object value$iv3 = $this$cache$iv.rememberedValue();
                    if (invalid$iv || value$iv3 == Composer.Companion.getEmpty()) {
                        $composer2 = $composer4;
                        $this$StickyBar_u24lambda_u244 = $this$StickyBar_u24lambda_u2443;
                        factory$iv$iv$iv = factory$iv$iv$iv3;
                        modifier$iv$iv = modifier$iv$iv2;
                        final CoroutineScope coroutineScope = scope2;
                        $composer$iv = $composer$iv2;
                        verticalAlignment$iv = verticalAlignment$iv3;
                        localMap$iv$iv2 = localMap$iv$iv;
                        scope = scope2;
                        kShortcutsModule2 = kShortcutsModule;
                        final ChatReporter chatReporter = reporter2;
                        value$iv3 = new Function0() { // from class: kntr.app.im.chat.ui.widget.sticky.StickyBarKt$$ExternalSyntheticLambda2
                            public final Object invoke() {
                                Unit StickyBar$lambda$4$0$0$0;
                                StickyBar$lambda$4$0$0$0 = StickyBarKt.StickyBar$lambda$4$0$0$0(coroutineScope, showDialog, item, actionHandler, chatReporter);
                                return StickyBar$lambda$4$0$0$0;
                            }
                        };
                        $this$cache$iv.updateRememberedValue(value$iv3);
                    } else {
                        $composer$iv = $composer$iv2;
                        $composer2 = $composer4;
                        $this$StickyBar_u24lambda_u244 = $this$StickyBar_u24lambda_u2443;
                        scope = scope2;
                        factory$iv$iv$iv = factory$iv$iv$iv3;
                        verticalAlignment$iv = verticalAlignment$iv3;
                        localMap$iv$iv2 = localMap$iv$iv;
                        kShortcutsModule2 = kShortcutsModule;
                        modifier$iv$iv = modifier$iv$iv2;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    StickyBarItem(icon, title, ClickableKt.clickable-oSLSa3U$default(weight, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) value$iv3, 15, (Object) null), subtitle, $composer2, 0, 0);
                    module = kShortcutsModule2;
                    localMap$iv$iv3 = localMap$iv$iv2;
                    modifier$iv$iv2 = modifier$iv$iv;
                    index$iv = index$iv2;
                    materialized$iv$iv2 = materialized$iv$iv;
                    $composer4 = $composer2;
                    factory$iv$iv$iv3 = factory$iv$iv$iv;
                    $this$StickyBar_u24lambda_u2443 = $this$StickyBar_u24lambda_u244;
                    $composer$iv2 = $composer$iv;
                    verticalAlignment$iv3 = verticalAlignment$iv;
                    scope2 = scope;
                }
                Composer $composer5 = $composer4;
                $composer5.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endReplaceGroup();
                z = true;
            } else if (module instanceof KChatStickyModule.KTipsModule) {
                $composer3.startReplaceGroup(947712794);
                ComposerKt.sourceInformation($composer3, "104@4278L6,105@4312L856,103@4199L969");
                z = true;
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_notice-0d7_KjU())), ComposableLambdaKt.rememberComposableLambda(-152462488, true, new Function2() { // from class: kntr.app.im.chat.ui.widget.sticky.StickyBarKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj, Object obj2) {
                        Unit StickyBar$lambda$5;
                        StickyBar$lambda$5 = StickyBarKt.StickyBar$lambda$5(modifier3, module, (Composer) obj, ((Integer) obj2).intValue());
                        return StickyBar$lambda$5;
                    }
                }, $composer3, 54), $composer3, ProvidedValue.$stable | 48);
                $composer3.endReplaceGroup();
            } else {
                z = true;
                if (module != null) {
                    $composer3.startReplaceGroup(-385121927);
                    $composer3.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                $composer3.startReplaceGroup(948683993);
                $composer3.endReplaceGroup();
            }
            ConfirmDialogType StickyBar$lambda$1 = StickyBar$lambda$1(dialogType$delegate);
            ComposerKt.sourceInformationMarkerStart($composer3, -385037138, "CC(remember):StickyBar.kt#9igjgp");
            boolean z3 = ($dirty2 & 112) == 32 ? z : false;
            if (($dirty2 & 7168) != 2048) {
                z = false;
            }
            boolean invalid$iv2 = z3 | z;
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv4 = (OnConfirmDialogAction) new StickyBarKt$StickyBar$3$1(actionHandler, dialogType$delegate, reporter2);
                $composer3.updateRememberedValue(value$iv4);
                it$iv3 = value$iv4;
            }
            OnConfirmDialogAction onConfirmDialogAction = (OnConfirmDialogAction) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -385027524, "CC(remember):StickyBar.kt#9igjgp");
            Object it$iv4 = $composer3.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv5 = new Function0() { // from class: kntr.app.im.chat.ui.widget.sticky.StickyBarKt$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        Unit StickyBar$lambda$7$0;
                        StickyBar$lambda$7$0 = StickyBarKt.StickyBar$lambda$7$0(dialogType$delegate);
                        return StickyBar$lambda$7$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv5);
                it$iv4 = value$iv5;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ConfirmdialogKt.ConfirmDialog(StickyBar$lambda$1, onConfirmDialogAction, (Function0) it$iv4, $composer3, 384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final ChatReporter chatReporter2 = reporter2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.widget.sticky.StickyBarKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit StickyBar$lambda$8;
                    StickyBar$lambda$8 = StickyBarKt.StickyBar$lambda$8(ChatInfo.this, actionHandler, modifier4, chatReporter2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return StickyBar$lambda$8;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConfirmDialogType StickyBar$lambda$1(MutableState<ConfirmDialogType> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (ConfirmDialogType) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean StickyBar$lambda$3$0(MutableState $dialogType$delegate, KShortcutType type) {
        ConfirmDialogType confirmDialogType;
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(type, KShortcutType.SHORTCUT_TYPE_BLOCK.INSTANCE)) {
            confirmDialogType = ConfirmDialogType.BlockUser;
        } else {
            confirmDialogType = Intrinsics.areEqual(type, KShortcutType.SHORTCUT_TYPE_PUSH_DISABLE.INSTANCE) ? ConfirmDialogType.DisablePush : null;
        }
        $dialogType$delegate.setValue(confirmDialogType);
        return StickyBar$lambda$1($dialogType$delegate) == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickyBar$lambda$4$0$0$0(CoroutineScope $scope, Function1 $showDialog, KShortcutItem $item, ChatActionHandler $actionHandler, ChatReporter $reporter) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new StickyBarKt$StickyBar$1$1$1$1$1($showDialog, $item, $actionHandler, $reporter, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickyBar$lambda$5(Modifier $modifier, KChatStickyModule.IModule $value, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        ComposerKt.sourceInformation($composer, "C110@4490L6,106@4330L824:StickyBar.kt#o1wnfl");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-152462488, $changed, -1, "kntr.app.im.chat.ui.widget.sticky.StickyBar.<anonymous> (StickyBar.kt:106)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU($modifier, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getPay_yellow_thin-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4))), Dp.constructor-impl(8), 0.0f, 2, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(4));
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i2 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -20729696, "C117@4878L30,116@4825L157,122@5100L9,120@5003L133:StickyBar.kt#o1wnfl");
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getWarning_report_circle_line_500($composer, 6), (String) null, (Modifier) null, 0L, $composer, Painter.$stable | 48, 12);
            TextKt.Text-Nvy7gAk(((KChatStickyModule.KTipsModule) $value).getValue().getText(), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT14(), $composer, 0, 0, 131070);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickyBar$lambda$7$0(MutableState $dialogType$delegate) {
        $dialogType$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    private static final void StickyBarItem(final String icon, final String title, Modifier modifier, String subtitle, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        String str;
        Modifier modifier3;
        String subtitle2;
        Modifier modifier4;
        String subtitle3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-503433922);
        ComposerKt.sourceInformation($composer3, "C(StickyBarItem)N(icon,title,modifier,subtitle)148@5734L1187:StickyBar.kt#o1wnfl");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(icon) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(title) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            str = subtitle;
        } else if (($changed & 3072) == 0) {
            str = subtitle;
            $dirty |= $composer3.changed(str) ? 2048 : 1024;
        } else {
            str = subtitle;
        }
        if (!$composer3.shouldExecute(($dirty & 1171) != 1170, $dirty & 1)) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier2;
            subtitle2 = str;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                subtitle3 = str;
            } else {
                subtitle3 = RoomRecommendViewModel.EMPTY_CURSOR;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-503433922, $dirty, -1, "kntr.app.im.chat.ui.widget.sticky.StickyBarItem (StickyBar.kt:147)");
            }
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-D5KLDUw(Dp.constructor-impl(8), Alignment.Companion.getCenterHorizontally());
            int $changed$iv = (($dirty >> 6) & 14) | 432;
            Modifier modifier$iv = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i5 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1250271888, "C153@5930L221,160@6160L755:StickyBar.kt#o1wnfl");
            $composer3.startReplaceGroup(-1841445815);
            ComposerKt.sourceInformation($composer3, "*156@6063L6");
            ImageRequest $this$StickyBarItem_u24lambda_u240_u240 = new ImageRequest(icon);
            $this$StickyBarItem_u24lambda_u240_u240.colorFilter(ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), 0, 2, (Object) null));
            ImmutableImageRequest build = $this$StickyBarItem_u24lambda_u240_u240.build();
            $composer3.endReplaceGroup();
            BiliImageKt.BiliImage(build, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, (Function4) null, $composer3, 48, 508);
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-D5KLDUw(Dp.constructor-impl(2), Alignment.Companion.getCenterVertically());
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier modifier$iv2 = Modifier.Companion;
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv2 = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i7 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1219795240, "C166@6424L9,169@6553L6,164@6354L226:StickyBar.kt#o1wnfl");
            TextKt.Text-Nvy7gAk(title, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14(), $composer3, ($dirty >> 3) & 14, 24960, 110586);
            if (subtitle3.length() > 0) {
                $composer2 = $composer3;
                $composer2.startReplaceGroup(-1219522751);
                ComposerKt.sourceInformation($composer2, "174@6719L9,177@6860L6,172@6638L253");
                String str2 = subtitle3;
                TextKt.Text-Nvy7gAk(str2, (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12(), $composer2, ($dirty >> 9) & 14, 24960, 110586);
            } else {
                $composer2 = $composer3;
                $composer2.startReplaceGroup(-1226116482);
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            subtitle2 = subtitle3;
        }
        ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final String str3 = subtitle2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.widget.sticky.StickyBarKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit StickyBarItem$lambda$1;
                    StickyBarItem$lambda$1 = StickyBarKt.StickyBarItem$lambda$1(icon, title, modifier5, str3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return StickyBarItem$lambda$1;
                }
            });
        }
    }
}