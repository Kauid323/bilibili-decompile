package kntr.app.im.chat.ui.module.pushAdditionalMsg;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Measured;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import bili.resource.common.CommonRes;
import bili.resource.common.String0_commonMainKt;
import com.bapis.bilibili.app.dynamic.v2.KModuleParagraph;
import com.bapis.bilibili.app.dynamic.v2.KParaSpacing;
import com.bapis.bilibili.app.dynamic.v2.KParagraph;
import com.bilibili.common.paragraph.ParagraphState;
import com.bilibili.common.paragraph.action.ParagraphClickListenerContainer;
import com.bilibili.common.paragraph.builder.ParagraphBuilderProvider;
import com.bilibili.common.paragraph.builder.ParagraphContent;
import com.bilibili.common.paragraph.impl.constant.SortedListDrawParams;
import com.bilibili.common.paragraph.impl.constant.TextParagraphConfig;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeDayNight;
import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import im.base.AddBiliImageKt;
import java.util.Iterator;
import kntr.app.im.chat.module.PushAdditionalMsgModule;
import kntr.app.im.chat.ui.builder.ChatMsgFrameScope;
import kntr.app.im.chat.ui.module.pushAdditionalMsg.paragraph.ExpandableParagraphEntryPoint;
import kntr.app.im.chat.ui.module.pushAdditionalMsg.paragraph.ExpandableTextConfig;
import kntr.app.im.chat.ui.module.pushAdditionalMsg.paragraph.ExpandableTextParagraphKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: PushAdditionalMsgModule.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001R\u00020\u0002j\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\b\u001aG\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0013\u0010\u0014\u001a5\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b\u0019¢\u0006\u0002\b\u001aH\u0003¢\u0006\u0002\u0010\u001b¨\u0006\u001c"}, d2 = {"PushAdditionalMsgModule", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/ui/builder/ChatMsgFrameScope;", "frameScope", "module", "Lkntr/app/im/chat/module/PushAdditionalMsgModule;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/im/chat/ui/builder/ChatMsgFrameScope;Lkntr/app/im/chat/module/PushAdditionalMsgModule;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ExpandableText", "text", "Lcom/bapis/bilibili/app/dynamic/v2/KParagraph;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "collapseLine", RoomRecommendViewModel.EMPTY_CURSOR, "toExpand", RoomRecommendViewModel.EMPTY_CURSOR, "toCollapse", "ExpandableText-LfZho9M", "(Lcom/bapis/bilibili/app/dynamic/v2/KParagraph;JLandroidx/compose/ui/Modifier;ILjava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "BoxWithConstraintsAndBaseline", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxWithConstraintsScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PushAdditionalMsgModuleKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxWithConstraintsAndBaseline$lambda$2(Modifier modifier, Function3 function3, int i, int i2, Composer composer, int i3) {
        BoxWithConstraintsAndBaseline(modifier, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpandableText_LfZho9M$lambda$3(KParagraph kParagraph, long j2, Modifier modifier, int i, String str, String str2, int i2, int i3, Composer composer, int i4) {
        m1825ExpandableTextLfZho9M(kParagraph, j2, modifier, i, str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PushAdditionalMsgModule$lambda$0(ChatMsgFrameScope chatMsgFrameScope, PushAdditionalMsgModule pushAdditionalMsgModule, Modifier modifier, int i, int i2, Composer composer, int i3) {
        PushAdditionalMsgModule(chatMsgFrameScope, pushAdditionalMsgModule, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PushAdditionalMsgModule$lambda$2(ChatMsgFrameScope chatMsgFrameScope, PushAdditionalMsgModule pushAdditionalMsgModule, Modifier modifier, int i, int i2, Composer composer, int i3) {
        PushAdditionalMsgModule(chatMsgFrameScope, pushAdditionalMsgModule, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void PushAdditionalMsgModule(final ChatMsgFrameScope frameScope, final PushAdditionalMsgModule module, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Object value$iv;
        Intrinsics.checkNotNullParameter(frameScope, "frameScope");
        Intrinsics.checkNotNullParameter(module, "module");
        Composer $composer3 = $composer.startRestartGroup(131212127);
        ComposerKt.sourceInformation($composer3, "C(PushAdditionalMsgModule)N(frameScope,module,modifier)79@3469L6,74@3277L1530:PushAdditionalMsgModule.kt#po4coe");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(module) ? 32 : 16;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 145) != 144, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(131212127, $dirty2, -1, "kntr.app.im.chat.ui.module.pushAdditionalMsg.PushAdditionalMsgModule (PushAdditionalMsgModule.kt:70)");
            }
            final KParagraph paragraph = module.getValue().getContent();
            if (paragraph == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier5 = modifier4;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.module.pushAdditionalMsg.PushAdditionalMsgModuleKt$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit PushAdditionalMsgModule$lambda$0;
                            PushAdditionalMsgModule$lambda$0 = PushAdditionalMsgModuleKt.PushAdditionalMsgModule$lambda$0(ChatMsgFrameScope.this, module, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return PushAdditionalMsgModule$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
            Modifier modifier$iv = PaddingKt.padding-3ABfNKs(BackgroundKt.background-bw27NRU(PaddingKt.padding-qDBjuR0(modifier4, Dp.constructor-impl(12), Dp.constructor-impl(4), Dp.constructor-impl(12), Dp.constructor-impl(8)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGraph_bg_thin_float-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(6))), Dp.constructor-impl(8));
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
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
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i4 = ((0 >> 6) & 112) | 6;
            BoxScope $this$PushAdditionalMsgModule_u24lambda_u241 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -1504644796, "C85@3675L203,92@3887L914:PushAdditionalMsgModule.kt#po4coe");
            String $this$asRequest_u24default$iv = module.getValue().getRefIcon();
            BiliImageKt.BiliImage(new ImageRequest($this$asRequest_u24default$iv).build(), SizeKt.size-3ABfNKs($this$PushAdditionalMsgModule_u24lambda_u241.align(Modifier.Companion, Alignment.Companion.getTopEnd()), Dp.constructor-impl(16)), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, (Function4) null, $composer3, 0, 508);
            Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(4));
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((54 >> 3) & 14) | ((54 >> 3) & 112));
            int $changed$iv$iv2 = (54 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            $composer2 = $composer3;
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
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i6 = ((54 >> 6) & 112) | 6;
            RowScope $this$PushAdditionalMsgModule_u24lambda_u241_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -1852055163, "C103@4255L21,98@4078L213,110@4474L43,111@4533L258,106@4305L486:PushAdditionalMsgModule.kt#po4coe");
            String avatar = module.getValue().getAvatar();
            Modifier clip = ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), RoundedCornerShapeKt.getCircleShape());
            ComposerKt.sourceInformationMarkerStart($composer3, 1048639914, "CC(remember):PushAdditionalMsgModule.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                value$iv = new Function1() { // from class: kntr.app.im.chat.ui.module.pushAdditionalMsg.PushAdditionalMsgModuleKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        int PushAdditionalMsgModule$lambda$1$0$0$0;
                        PushAdditionalMsgModule$lambda$1$0$0$0 = PushAdditionalMsgModuleKt.PushAdditionalMsgModule$lambda$1$0$0$0((Measured) obj);
                        return Integer.valueOf(PushAdditionalMsgModule$lambda$1$0$0$0);
                    }
                };
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            AddBiliImageKt.AddBiliImage(avatar, $this$PushAdditionalMsgModule_u24lambda_u241_u240.alignBy(clip, (Function1) value$iv), $composer3, 0, 0);
            Modifier weight = $this$PushAdditionalMsgModule_u24lambda_u241_u240.weight(Modifier.Companion, 1.0f, true);
            ComposerKt.sourceInformationMarkerStart($composer3, 1048646944, "CC(remember):PushAdditionalMsgModule.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: kntr.app.im.chat.ui.module.pushAdditionalMsg.PushAdditionalMsgModuleKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        int PushAdditionalMsgModule$lambda$1$0$1$0;
                        PushAdditionalMsgModule$lambda$1$0$1$0 = PushAdditionalMsgModuleKt.PushAdditionalMsgModule$lambda$1$0$1$0((Measured) obj);
                        return Integer.valueOf(PushAdditionalMsgModule$lambda$1$0$1$0);
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            BoxWithConstraintsAndBaseline($this$PushAdditionalMsgModule_u24lambda_u241_u240.alignBy(weight, (Function1) it$iv2), ComposableLambdaKt.rememberComposableLambda(-1299980373, true, new Function3() { // from class: kntr.app.im.chat.ui.module.pushAdditionalMsg.PushAdditionalMsgModuleKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit PushAdditionalMsgModule$lambda$1$0$2;
                    PushAdditionalMsgModule$lambda$1$0$2 = PushAdditionalMsgModuleKt.PushAdditionalMsgModule$lambda$1$0$2(paragraph, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return PushAdditionalMsgModule$lambda$1$0$2;
                }
            }, $composer3, 54), $composer3, 48, 0);
            ComposerKt.sourceInformationMarkerEnd($composer3);
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
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier6 = modifier3;
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.module.pushAdditionalMsg.PushAdditionalMsgModuleKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit PushAdditionalMsgModule$lambda$2;
                    PushAdditionalMsgModule$lambda$2 = PushAdditionalMsgModuleKt.PushAdditionalMsgModule$lambda$2(ChatMsgFrameScope.this, module, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PushAdditionalMsgModule$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int PushAdditionalMsgModule$lambda$1$0$0$0(Measured it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int PushAdditionalMsgModule$lambda$1$0$1$0(Measured placeable) {
        Intrinsics.checkNotNullParameter(placeable, "placeable");
        return placeable.get(ExpandableTextParagraphKt.getFirstLineBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PushAdditionalMsgModule$lambda$1$0$2(KParagraph $paragraph, BoxWithConstraintsScope $this$BoxWithConstraintsAndBaseline, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BoxWithConstraintsAndBaseline, "$this$BoxWithConstraintsAndBaseline");
        ComposerKt.sourceInformation($composer, "C112@4551L226:PushAdditionalMsgModule.kt#po4coe");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$BoxWithConstraintsAndBaseline) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (!$composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1299980373, $dirty2, -1, "kntr.app.im.chat.ui.module.pushAdditionalMsg.PushAdditionalMsgModule.<anonymous>.<anonymous>.<anonymous> (PushAdditionalMsgModule.kt:112)");
            }
            m1825ExpandableTextLfZho9M($paragraph, $this$BoxWithConstraintsAndBaseline.getConstraints-msEJaDk(), SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), 0, null, null, $composer, 384, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* renamed from: ExpandableText-LfZho9M  reason: not valid java name */
    public static final void m1825ExpandableTextLfZho9M(final KParagraph text, final long j2, Modifier modifier, int collapseLine, String toExpand, String toCollapse, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        int i2;
        String toExpand2;
        String str;
        Modifier modifier3;
        int collapseLine2;
        String toExpand3;
        String toCollapse2;
        Modifier modifier4;
        int collapseLine3;
        int $dirty;
        Modifier modifier5;
        int collapseLine4;
        int $dirty2;
        int $dirty3;
        Object element$iv;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer2 = $composer.startRestartGroup(1663342242);
        ComposerKt.sourceInformation($composer2, "C(ExpandableText)N(text,constraints:c#ui.unit.Constraints,modifier,collapseLine,toExpand,toCollapse)133@5167L7,134@5213L7,135@5254L9,137@5295L804,157@6133L105:PushAdditionalMsgModule.kt#po4coe");
        int $dirty4 = $changed;
        if (($changed & 6) == 0) {
            $dirty4 |= $composer2.changedInstance(text) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty4 |= $composer2.changed(j2) ? 32 : 16;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty4 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty4 |= 3072;
            i2 = collapseLine;
        } else if (($changed & 3072) == 0) {
            i2 = collapseLine;
            $dirty4 |= $composer2.changed(i2) ? 2048 : 1024;
        } else {
            i2 = collapseLine;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                toExpand2 = toExpand;
                if ($composer2.changed(toExpand2)) {
                    i4 = 16384;
                    $dirty4 |= i4;
                }
            } else {
                toExpand2 = toExpand;
            }
            i4 = 8192;
            $dirty4 |= i4;
        } else {
            toExpand2 = toExpand;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                str = toCollapse;
                if ($composer2.changed(str)) {
                    i3 = 131072;
                    $dirty4 |= i3;
                }
            } else {
                str = toCollapse;
            }
            i3 = 65536;
            $dirty4 |= i3;
        } else {
            str = toCollapse;
        }
        if ($composer2.shouldExecute((74899 & $dirty4) != 74898, $dirty4 & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "130@4989L57,131@5073L57");
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty4 &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty4 &= -458753;
                }
                toExpand3 = toExpand2;
                toCollapse2 = str;
                modifier5 = modifier2;
                collapseLine4 = i2;
                $dirty = $dirty4;
            } else {
                if (i5 != 0) {
                    modifier4 = (Modifier) Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if (i6 == 0) {
                    collapseLine3 = i2;
                } else {
                    collapseLine3 = 2;
                }
                if ((i & 16) != 0) {
                    $dirty4 &= -57345;
                    toExpand2 = StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_219(CommonRes.INSTANCE.getString()), $composer2, 0);
                }
                if ((i & 32) == 0) {
                    $dirty = $dirty4;
                    toExpand3 = toExpand2;
                    toCollapse2 = str;
                    modifier5 = modifier4;
                    collapseLine4 = collapseLine3;
                } else {
                    $dirty = $dirty4 & (-458753);
                    collapseLine4 = collapseLine3;
                    toCollapse2 = StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_157(CommonRes.INSTANCE.getString()), $composer2, 0);
                    toExpand3 = toExpand2;
                    modifier5 = modifier4;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1663342242, $dirty, -1, "kntr.app.im.chat.ui.module.pushAdditionalMsg.ExpandableText (PushAdditionalMsgModule.kt:132)");
            }
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density = (Density) consume;
            CompositionLocal this_$iv2 = BiliThemeKt.getLocalDayNightTheme();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ThemeDayNight dayNight = (ThemeDayNight) consume2;
            TextStyle defaultStyle = BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT13();
            ComposerKt.sourceInformationMarkerStart($composer2, 744076070, "CC(remember):PushAdditionalMsgModule.kt#9igjgp");
            Object value$iv = $composer2.rememberedValue();
            if (value$iv == Composer.Companion.getEmpty()) {
                Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
                $dirty2 = $dirty;
                value$iv = ((ExpandableParagraphEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(ExpandableParagraphEntryPoint.class))).getExpandableParagraphComponentFactory().bindSortedListDrawParams(new SortedListDrawParams(0.0f, 0.0f, 0.0f, 0.0f, 0L, 31, (DefaultConstructorMarker) null)).bindTextConfig(new TextParagraphConfig(defaultStyle, 0, 0, 6, (DefaultConstructorMarker) null)).bindDayNight(dayNight).bindDensity(density).bindExpandableTextConfig(new ExpandableTextConfig(collapseLine4, toExpand3, toCollapse2, "…", j2, null)).build().paragraphBuilderProvider();
                $composer2.updateRememberedValue(value$iv);
            } else {
                $dirty2 = $dirty;
            }
            ParagraphBuilderProvider provider = (ParagraphBuilderProvider) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 744102187, "CC(remember):PushAdditionalMsgModule.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(text);
            Object value$iv2 = $composer2.rememberedValue();
            if (invalid$iv || value$iv2 == Composer.Companion.getEmpty()) {
                $dirty3 = $dirty2;
                value$iv2 = new ParagraphState(CollectionsKt.listOf(new KModuleParagraph(text, false, (KParaSpacing) null, 6, (DefaultConstructorMarker) null)), provider, (ParagraphClickListenerContainer) null, 4, (DefaultConstructorMarker) null);
                $composer2.updateRememberedValue(value$iv2);
            } else {
                $dirty3 = $dirty2;
            }
            ParagraphState paragraphState = (ParagraphState) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Iterable $this$firstOrNull$iv = paragraphState.getContents();
            Iterator it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    element$iv = it.next();
                    ParagraphContent it2 = (ParagraphContent) element$iv;
                    if (Intrinsics.areEqual(it2.getType(), KParagraph.KParagraphType.TEXT.INSTANCE)) {
                        break;
                    }
                } else {
                    element$iv = null;
                    break;
                }
            }
            ParagraphContent paragraphContent = (ParagraphContent) element$iv;
            if (paragraphContent == null) {
                $composer2.startReplaceGroup(1592538894);
            } else {
                $composer2.startReplaceGroup(744108883);
                ComposerKt.sourceInformation($composer2, "163@6345L17");
                paragraphContent.Content(modifier5, $composer2, ($dirty3 >> 6) & 14);
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
            collapseLine2 = collapseLine4;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            collapseLine2 = i2;
            toExpand3 = toExpand2;
            toCollapse2 = str;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final int i7 = collapseLine2;
            final String str2 = toExpand3;
            final String str3 = toCollapse2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.module.pushAdditionalMsg.PushAdditionalMsgModuleKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit ExpandableText_LfZho9M$lambda$3;
                    ExpandableText_LfZho9M$lambda$3 = PushAdditionalMsgModuleKt.ExpandableText_LfZho9M$lambda$3(text, j2, modifier6, i7, str2, str3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ExpandableText_LfZho9M$lambda$3;
                }
            });
        }
    }

    private static final void BoxWithConstraintsAndBaseline(Modifier modifier, final Function3<? super BoxWithConstraintsScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final Modifier modifier3;
        Composer $composer2 = $composer.startRestartGroup(1899368664);
        ComposerKt.sourceInformation($composer2, "C(BoxWithConstraintsAndBaseline)N(modifier,content)174@6629L730,171@6525L834:PushAdditionalMsgModule.kt#po4coe");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1899368664, $dirty2, -1, "kntr.app.im.chat.ui.module.pushAdditionalMsg.BoxWithConstraintsAndBaseline (PushAdditionalMsgModule.kt:170)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -67806190, "CC(remember):PushAdditionalMsgModule.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (MeasurePolicy) PushAdditionalMsgModuleKt$BoxWithConstraintsAndBaseline$2$1.INSTANCE;
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            MeasurePolicy measurePolicy$iv = (MeasurePolicy) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            int $changed$iv = (($dirty2 << 3) & 112) | 384;
            Modifier modifier$iv = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv = (($changed$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(factory$iv$iv);
            } else {
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv, Integer.valueOf(compositeKeyHash$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv, materialized$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -809011939, "C172@6553L37:PushAdditionalMsgModule.kt#po4coe");
            BoxWithConstraintsKt.BoxWithConstraints((Modifier) null, (Alignment) null, false, function3, $composer2, ($dirty2 << 6) & 7168, 7);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.module.pushAdditionalMsg.PushAdditionalMsgModuleKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit BoxWithConstraintsAndBaseline$lambda$2;
                    BoxWithConstraintsAndBaseline$lambda$2 = PushAdditionalMsgModuleKt.BoxWithConstraintsAndBaseline$lambda$2(modifier3, function3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return BoxWithConstraintsAndBaseline$lambda$2;
                }
            });
        }
    }
}