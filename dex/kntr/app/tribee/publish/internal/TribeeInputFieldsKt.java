package kntr.app.tribee.publish.internal;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.DragInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextFieldStateKt;
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
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.bapis.bilibili.dynamic.interfaces.feed.v1.KTribeePublishConfig;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kntr.app.tribee.publish.ImeHelper_androidKt;
import kntr.app.tribee.publish.TribeePublishAction;
import kntr.app.tribee.publish.TribeePublishContent;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.input.AssetParagraphContentKt;
import kntr.common.paragraph.input.RichTextAction;
import kntr.common.paragraph.input.RichTextContent;
import kntr.common.paragraph.input.RichTextInputFieldsKt;
import kntr.common.paragraph.input.content.AssetContent;
import kntr.common.paragraph.input.content.ParagraphContent;
import kntr.common.paragraph.input.content.TextContent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: TribeeInputFields.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\u001a\u008f\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052&\u0010\u0006\u001a\"\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007j\u0002`\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0001¢\u0006\u0002\u0010\u0015¨\u0006\u0016²\u0006\n\u0010\u0017\u001a\u00020\rX\u008a\u008e\u0002²\u0006\f\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u008a\u008e\u0002"}, d2 = {"TribeeInputFields", "", "content", "Lkntr/app/tribee/publish/TribeePublishContent;", "contentHint", "", "onAction", "Lkotlin/Function2;", "Lkntr/app/tribee/publish/TribeePublishAction;", "Lkotlin/coroutines/Continuation;", "", "Lkntr/app/tribee/publish/TribeeActionHandler;", "needFocus", "", "onContentFocusChange", "Lkotlin/Function0;", "onTitleFocusChange", "onTitleLimitExceed", "onTitleNext", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/tribee/publish/TribeePublishContent;Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ui_debug", "titleFocused", "cursorRect", "Landroidx/compose/ui/geometry/Rect;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeInputFieldsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInputFields$lambda$13(TribeePublishContent tribeePublishContent, String str, Function2 function2, boolean z, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TribeeInputFields(tribeePublishContent, str, function2, z, function0, function02, function03, function04, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:116:0x0304, code lost:
        if (r15 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x04de, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0887, code lost:
        if (r15 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x08c3, code lost:
        if (r15 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x0a73, code lost:
        if (r4 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L191;
     */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0c29  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TribeeInputFields(final TribeePublishContent content, final String contentHint, final Function2<? super TribeePublishAction, ? super Continuation<? super Unit>, ? extends Object> function2, final boolean needFocus, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, final Function0<Unit> function04, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        MutableInteractionSource scrollInteractionSource;
        Iterable $this$forEachIndexed$iv;
        FocusRequester focusRequester;
        Object value$iv;
        int index$iv;
        boolean z;
        Alignment.Horizontal horizontalAlignment$iv;
        Function0 factory$iv$iv$iv2;
        RichTextContent paragraphContent;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv;
        MutableInteractionSource scrollInteractionSource2;
        Composer $composer3;
        Object value$iv2;
        MutableInteractionSource scrollInteractionSource3;
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(contentHint, "contentHint");
        Intrinsics.checkNotNullParameter(function2, "onAction");
        Intrinsics.checkNotNullParameter(function0, "onContentFocusChange");
        Intrinsics.checkNotNullParameter(function02, "onTitleFocusChange");
        Intrinsics.checkNotNullParameter(function03, "onTitleLimitExceed");
        Intrinsics.checkNotNullParameter(function04, "onTitleNext");
        Composer $composer4 = $composer.startRestartGroup(1664022761);
        ComposerKt.sourceInformation($composer4, "C(TribeeInputFields)N(content,contentHint,onAction,needFocus,onContentFocusChange,onTitleFocusChange,onTitleLimitExceed,onTitleNext,modifier)59@2643L29,61@2732L24,62@2779L29,64@2842L68,68@2966L21,70@3030L59,73@3114L34,79@3313L66,81@3395L231,74@3153L5744,205@8928L89,205@8902L115,210@9045L118,210@9022L141,215@9206L25,216@9293L7,217@9335L85,217@9305L115:TribeeInputFields.kt#1zy72f");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changedInstance(content) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changed(contentHint) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer4.changedInstance(function2) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer4.changed(needFocus) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer4.changedInstance(function0) ? 16384 : 8192;
        }
        if (($changed & 196608) == 0) {
            $dirty |= $composer4.changedInstance(function02) ? 131072 : 65536;
        }
        if (($changed & 1572864) == 0) {
            $dirty |= $composer4.changedInstance(function03) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            $dirty |= $composer4.changedInstance(function04) ? 8388608 : 4194304;
        }
        int i2 = i & 256;
        if (i2 != 0) {
            $dirty |= 100663296;
            modifier2 = modifier;
        } else if (($changed & 100663296) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 67108864 : 33554432;
        } else {
            modifier2 = modifier;
        }
        if ($composer4.shouldExecute(($dirty & 38347923) != 38347922, $dirty & 1)) {
            modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1664022761, $dirty, -1, "kntr.app.tribee.publish.internal.TribeeInputFields (TribeeInputFields.kt:58)");
            }
            ComposerKt.sourceInformationMarkerStart($composer4, 1398050438, "CC(remember):TribeeInputFields.kt#9igjgp");
            Object it$iv = $composer4.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv3 = new FocusRequester();
                $composer4.updateRememberedValue(value$iv3);
                it$iv = value$iv3;
            }
            FocusRequester titleFocusRequester = (FocusRequester) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            final RichTextContent paragraphContent2 = content.getContent();
            ComposerKt.sourceInformationMarkerStart($composer4, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer4, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object value$iv$iv = $composer4.rememberedValue();
            if (value$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer4);
                $composer4.updateRememberedValue(value$iv$iv);
            }
            final CoroutineScope scope = (CoroutineScope) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerStart($composer4, 1398054790, "CC(remember):TribeeInputFields.kt#9igjgp");
            Object it$iv2 = $composer4.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new FocusRequester();
                $composer4.updateRememberedValue(value$iv4);
                it$iv2 = value$iv4;
            }
            final FocusRequester parentFocus = (FocusRequester) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerStart($composer4, 1398056845, "CC(remember):TribeeInputFields.kt#9igjgp");
            Object it$iv3 = $composer4.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv5 = (Map) new LinkedHashMap();
                $composer4.updateRememberedValue(value$iv5);
                it$iv3 = value$iv5;
            }
            final Map paragraphFocus = (Map) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            KTribeePublishConfig limitInfo = content.getLimitInfo();
            ScrollState scroll = ScrollKt.rememberScrollState(0, $composer4, 0, 1);
            ComposerKt.sourceInformationMarkerStart($composer4, 1398062852, "CC(remember):TribeeInputFields.kt#9igjgp");
            Object it$iv4 = $composer4.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv6 = InteractionSourceKt.MutableInteractionSource();
                $composer4.updateRememberedValue(value$iv6);
                it$iv4 = value$iv6;
            }
            InteractionSource interactionSource = (MutableInteractionSource) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerStart($composer4, 1398065515, "CC(remember):TribeeInputFields.kt#9igjgp");
            Object value$iv7 = $composer4.rememberedValue();
            MutableInteractionSource scrollInteractionSource4 = interactionSource;
            if (value$iv7 == Composer.Companion.getEmpty()) {
                value$iv7 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer4.updateRememberedValue(value$iv7);
            }
            final MutableState titleFocused$delegate = (MutableState) value$iv7;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier focusRequester2 = FocusRequesterModifierKt.focusRequester(ScrollKt.verticalScroll$default(modifier3, scroll, false, (FlingBehavior) null, false, 14, (Object) null), parentFocus);
            ComposerKt.sourceInformationMarkerStart($composer4, 1398071915, "CC(remember):TribeeInputFields.kt#9igjgp");
            Object it$iv5 = $composer4.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv8 = new Function0() { // from class: kntr.app.tribee.publish.internal.TribeeInputFieldsKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit TribeeInputFields$lambda$7$0;
                        TribeeInputFields$lambda$7$0 = TribeeInputFieldsKt.TribeeInputFields$lambda$7$0(parentFocus);
                        return TribeeInputFields$lambda$7$0;
                    }
                };
                $composer4.updateRememberedValue(value$iv8);
                it$iv5 = value$iv8;
            }
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier modifier4 = ClickableKt.clickable-oSLSa3U$default(focusRequester2, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv5, 15, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer4, 1398074704, "CC(remember):TribeeInputFields.kt#9igjgp");
            boolean invalid$iv = (($dirty & 57344) == 16384) | $composer4.changedInstance(paragraphFocus) | $composer4.changedInstance(paragraphContent2);
            Object it$iv6 = $composer4.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv9 = new Function1() { // from class: kntr.app.tribee.publish.internal.TribeeInputFieldsKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj) {
                    Unit TribeeInputFields$lambda$8$0;
                    TribeeInputFields$lambda$8$0 = TribeeInputFieldsKt.TribeeInputFields$lambda$8$0(paragraphFocus, paragraphContent2, function0, (FocusState) obj);
                    return TribeeInputFields$lambda$8$0;
                }
            };
            $composer4.updateRememberedValue(value$iv9);
            it$iv6 = value$iv9;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(FocusableKt.focusable$default(FocusChangedModifierKt.onFocusChanged(modifier4, (Function1) it$iv6), false, (MutableInteractionSource) null, 3, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(12), 7, (Object) null);
            boolean z2 = false;
            ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv2, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            Alignment.Horizontal horizontalAlignment$iv3 = horizontalAlignment$iv2;
            Composer $composer$iv$iv = $composer4;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv, 0));
            CompositionLocalMap localMap$iv$iv = $composer$iv$iv.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer$iv$iv, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv$iv.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv$iv.startReusableNode();
            if ($composer$iv$iv.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer$iv$iv.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer$iv$iv.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer$iv$iv);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv, 1212305786, "C95@3932L49,103@4204L324,89@3697L842,113@4549L41:TribeeInputFields.kt#1zy72f");
            String title = content.getTitle();
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv, -1207816976, "CC(remember):TribeeInputFields.kt#9igjgp");
            Object value$iv10 = $composer$iv$iv.rememberedValue();
            if (value$iv10 == Composer.Companion.getEmpty()) {
                value$iv10 = new Function1() { // from class: kntr.app.tribee.publish.internal.TribeeInputFieldsKt$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj) {
                        Unit TribeeInputFields$lambda$9$0$0;
                        TribeeInputFields$lambda$9$0$0 = TribeeInputFieldsKt.TribeeInputFields$lambda$9$0$0(titleFocused$delegate, ((Boolean) obj).booleanValue());
                        return TribeeInputFields$lambda$9$0$0;
                    }
                };
                $composer$iv$iv.updateRememberedValue(value$iv10);
            }
            Function1 function1 = (Function1) value$iv10;
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            Modifier focusRequester3 = FocusRequesterModifierKt.focusRequester(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(2), 7, (Object) null), titleFocusRequester);
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv, -1207807997, "CC(remember):TribeeInputFields.kt#9igjgp");
            boolean invalid$iv2 = $composer4.changedInstance(scope) | $composer4.changedInstance(function2) | ((458752 & $dirty) == 131072);
            Object it$iv7 = $composer$iv$iv.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv11 = new Function1() { // from class: kntr.app.tribee.publish.internal.TribeeInputFieldsKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj) {
                    Unit TribeeInputFields$lambda$9$1$0;
                    TribeeInputFields$lambda$9$1$0 = TribeeInputFieldsKt.TribeeInputFields$lambda$9$1$0(scope, function2, function02, (FocusState) obj);
                    return TribeeInputFields$lambda$9$1$0;
                }
            };
            $composer$iv$iv.updateRememberedValue(value$iv11);
            it$iv7 = value$iv11;
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            int $dirty2 = $dirty;
            RichTextContent paragraphContent3 = paragraphContent2;
            String str = "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo";
            String str2 = "CC(remember):TribeeInputFields.kt#9igjgp";
            $composer2 = $composer4;
            TribeeTitleKt.TribeeTitle(title, limitInfo, function2, function03, function04, function1, FocusChangedModifierKt.onFocusChanged(focusRequester3, (Function1) it$iv7), $composer$iv$iv, ($dirty & 896) | 196608 | (($dirty >> 9) & 7168) | (($dirty >> 9) & 57344), 0);
            Composer $composer5 = $composer$iv$iv;
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), $composer5, 6);
            $composer5.startReplaceGroup(-1207790459);
            ComposerKt.sourceInformation($composer5, "*117@4790L37,119@4875L612,132@5500L3241");
            Iterable $this$forEachIndexed$iv2 = paragraphContent3.getContentList();
            boolean z3 = false;
            final int index$iv2 = 0;
            Iterator it = $this$forEachIndexed$iv2.iterator();
            while (it.hasNext()) {
                Object item$iv = it.next();
                int index$iv3 = index$iv2 + 1;
                if (index$iv2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ParagraphContent content2 = (ParagraphContent) item$iv;
                Integer valueOf = Integer.valueOf(index$iv2);
                Object value$iv12 = paragraphFocus.get(valueOf);
                if (value$iv12 == null) {
                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                    focusRequester = new FocusRequester();
                    paragraphFocus.put(valueOf, focusRequester);
                } else {
                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                    focusRequester = value$iv12;
                }
                FocusRequester focusRequester4 = (FocusRequester) focusRequester;
                String str3 = str2;
                ComposerKt.sourceInformationMarkerStart($composer5, 1991291920, str3);
                Composer $this$cache$iv = $composer5;
                boolean z4 = z3;
                Object it$iv8 = $this$cache$iv.rememberedValue();
                Iterator it2 = it;
                if (it$iv8 == Composer.Companion.getEmpty()) {
                    value$iv = BringIntoViewRequesterKt.BringIntoViewRequester();
                    $this$cache$iv.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv8;
                }
                BringIntoViewRequester bringIntoViewRequester = (BringIntoViewRequester) value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerStart($composer5, 1991295215, str3);
                Composer $this$cache$iv2 = $composer5;
                Object value$iv13 = $this$cache$iv2.rememberedValue();
                Object item$iv2 = Composer.Companion.getEmpty();
                if (value$iv13 == item$iv2) {
                    z = z2;
                    horizontalAlignment$iv = horizontalAlignment$iv3;
                    index$iv = index$iv3;
                    value$iv13 = PaddingKt.padding-VpY3zN4$default(FocusChangedModifierKt.onFocusChanged(BringIntoViewRequesterKt.bringIntoViewRequester(FocusRequesterModifierKt.focusRequester(Modifier.Companion, focusRequester4), bringIntoViewRequester), new Function1() { // from class: kntr.app.tribee.publish.internal.TribeeInputFieldsKt$$ExternalSyntheticLambda7
                        public final Object invoke(Object obj) {
                            Unit TribeeInputFields$lambda$9$2$2$0;
                            TribeeInputFields$lambda$9$2$2$0 = TribeeInputFieldsKt.TribeeInputFields$lambda$9$2$2$0(scope, function2, index$iv2, function0, (FocusState) obj);
                            return TribeeInputFields$lambda$9$2$2$0;
                        }
                    }), Dp.constructor-impl(20), 0.0f, 2, (Object) null);
                    $this$cache$iv2.updateRememberedValue(value$iv13);
                } else {
                    index$iv = index$iv3;
                    z = z2;
                    horizontalAlignment$iv = horizontalAlignment$iv3;
                }
                Modifier itemModifier = (Modifier) value$iv13;
                ComposerKt.sourceInformationMarkerEnd($composer5);
                Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                Alignment.Horizontal horizontalAlignment$iv4 = Alignment.Companion.getCenterHorizontally();
                Composer $composer$iv2 = $composer5;
                String str4 = str;
                Composer $composer$iv$iv2 = $composer$iv$iv;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, 1341605231, str4);
                Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv4, $composer$iv2, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                int $changed$iv$iv2 = (390 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv2, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer$iv2.getCurrentCompositionLocalMap();
                Composer $composer6 = $composer5;
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer$iv2, modifier$iv2);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer$iv2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv2.startReusableNode();
                if ($composer$iv2.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer$iv2.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer$iv2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer$iv2);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                int i6 = ((390 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, -1895605721, "C193@8526L201,193@8439L288:TribeeInputFields.kt#1zy72f");
                if (content2 instanceof TextContent) {
                    $composer$iv2.startReplaceGroup(-1895601506);
                    ComposerKt.sourceInformation($composer$iv2, "138@5762L91,142@5924L313,150@6276L84,153@6393L39,158@6640L120,166@7136L109,154@6453L815,170@7327L179,170@7289L217,175@7544L14,176@7646L331,176@7579L398");
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, -338242948, str3);
                    Object it$iv9 = $composer$iv2.rememberedValue();
                    if (it$iv9 == Composer.Companion.getEmpty()) {
                        Object value$iv14 = InteractionSourceKt.MutableInteractionSource();
                        $composer$iv2.updateRememberedValue(value$iv14);
                        it$iv9 = value$iv14;
                    }
                    MutableInteractionSource textInteractionSource = (MutableInteractionSource) it$iv9;
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, -338237542, str3);
                    Object value$iv15 = $composer$iv2.rememberedValue();
                    if (value$iv15 == Composer.Companion.getEmpty()) {
                        value$iv15 = new InputTransformation() { // from class: kntr.app.tribee.publish.internal.TribeeInputFieldsKt$$ExternalSyntheticLambda8
                            public /* synthetic */ void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                InputTransformation.-CC.$default$applySemantics(this, semanticsPropertyReceiver);
                            }

                            public /* synthetic */ KeyboardOptions getKeyboardOptions() {
                                return InputTransformation.-CC.$default$getKeyboardOptions(this);
                            }

                            public final void transformInput(TextFieldBuffer textFieldBuffer) {
                                TribeeInputFieldsKt.TribeeInputFields$lambda$9$2$3$1$0(index$iv2, textFieldBuffer);
                            }
                        };
                        $composer$iv2.updateRememberedValue(value$iv15);
                    }
                    InputTransformation inputTransformation = (InputTransformation) value$iv15;
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, -338226507, str3);
                    Object it$iv10 = $composer$iv2.rememberedValue();
                    if (it$iv10 == Composer.Companion.getEmpty()) {
                        value$iv2 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                        $composer$iv2.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = it$iv10;
                    }
                    final MutableState cursorRect$delegate = (MutableState) value$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    final TextFieldState state = TextFieldStateKt.rememberTextFieldState-Le-punE(((TextContent) content2).getContent(), 0L, $composer$iv2, 0, 2);
                    TextContent textContent = (TextContent) content2;
                    $composer$iv$iv$iv = $composer$iv2;
                    Modifier then = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null).then(itemModifier);
                    String it3 = paragraphContent3.getContentList().size() == 1 ? 1 : null;
                    String str5 = it3 != null ? contentHint : null;
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, -338214823, str3);
                    boolean invalid$iv3 = $composer2.changedInstance(scope) | $composer2.changedInstance(function2);
                    Object it$iv11 = $composer$iv2.rememberedValue();
                    if (invalid$iv3) {
                    }
                    Object value$iv16 = new Function1() { // from class: kntr.app.tribee.publish.internal.TribeeInputFieldsKt$$ExternalSyntheticLambda9
                        public final Object invoke(Object obj) {
                            Unit TribeeInputFields$lambda$9$2$3$6$0;
                            TribeeInputFields$lambda$9$2$3$6$0 = TribeeInputFieldsKt.TribeeInputFields$lambda$9$2$3$6$0(scope, function2, (RichTextAction) obj);
                            return TribeeInputFields$lambda$9$2$3$6$0;
                        }
                    };
                    $composer$iv2.updateRememberedValue(value$iv16);
                    it$iv11 = value$iv16;
                    Function1 function12 = (Function1) it$iv11;
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, -338198962, str3);
                    boolean invalid$iv4 = $composer$iv2.changed(state);
                    Object it$iv12 = $composer$iv2.rememberedValue();
                    if (invalid$iv4) {
                    }
                    Object value$iv17 = new Function2() { // from class: kntr.app.tribee.publish.internal.TribeeInputFieldsKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj, Object obj2) {
                            Unit TribeeInputFields$lambda$9$2$3$7$0;
                            TribeeInputFields$lambda$9$2$3$7$0 = TribeeInputFieldsKt.TribeeInputFields$lambda$9$2$3$7$0(state, cursorRect$delegate, (Density) obj, (Function0) obj2);
                            return TribeeInputFields$lambda$9$2$3$7$0;
                        }
                    };
                    $composer$iv2.updateRememberedValue(value$iv17);
                    it$iv12 = value$iv17;
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    RichTextInputFieldsKt.TextParagraphContent(textContent, index$iv2, function12, then, state, inputTransformation, str5, textInteractionSource, (Function2) it$iv12, $composer$iv2, 12779520, 0);
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, -338192780, str3);
                    Object it$iv13 = $composer$iv2.rememberedValue();
                    if (it$iv13 == Composer.Companion.getEmpty()) {
                        scrollInteractionSource3 = scrollInteractionSource4;
                        Object value$iv18 = (Function2) new TribeeInputFieldsKt$TribeeInputFields$3$3$1$4$1(textInteractionSource, scrollInteractionSource3, null);
                        $composer$iv2.updateRememberedValue(value$iv18);
                        it$iv13 = value$iv18;
                    } else {
                        scrollInteractionSource3 = scrollInteractionSource4;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    EffectsKt.LaunchedEffect(textInteractionSource, (Function2) it$iv13, $composer$iv2, 6);
                    boolean imeVisible = ImeHelper_androidKt.isImeVisible($composer$iv2, 0);
                    Boolean valueOf2 = Boolean.valueOf(imeVisible);
                    Boolean valueOf3 = Boolean.valueOf(paragraphContent3.getCurrentFocus() == index$iv2);
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, -338182420, str3);
                    paragraphContent = paragraphContent3;
                    scrollInteractionSource2 = scrollInteractionSource3;
                    boolean invalid$iv5 = $composer$iv2.changed(imeVisible) | $composer$iv2.changedInstance(paragraphContent) | $composer$iv2.changed(index$iv2) | $composer$iv2.changedInstance(bringIntoViewRequester);
                    $composer$iv = $composer$iv2;
                    Object it$iv14 = $composer$iv2.rememberedValue();
                    if (!invalid$iv5 && it$iv14 != Composer.Companion.getEmpty()) {
                        ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                        EffectsKt.LaunchedEffect(valueOf2, valueOf3, (Function2) it$iv14, $composer$iv2, 0);
                    }
                    Object value$iv19 = (Function2) new TribeeInputFieldsKt$TribeeInputFields$3$3$1$5$1(imeVisible, paragraphContent, index$iv2, bringIntoViewRequester, titleFocused$delegate, cursorRect$delegate, null);
                    $composer$iv2.updateRememberedValue(value$iv19);
                    it$iv14 = value$iv19;
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    EffectsKt.LaunchedEffect(valueOf2, valueOf3, (Function2) it$iv14, $composer$iv2, 0);
                } else {
                    paragraphContent = paragraphContent3;
                    $composer$iv$iv$iv = $composer$iv2;
                    $composer$iv = $composer$iv2;
                    scrollInteractionSource2 = scrollInteractionSource4;
                    $composer$iv2.startReplaceGroup(-1901316511);
                }
                $composer$iv2.endReplaceGroup();
                if (content2 instanceof AssetContent) {
                    $composer$iv2.startReplaceGroup(-1893327036);
                    ComposerKt.sourceInformation($composer$iv2, "187@8212L120,184@8063L341");
                    AssetContent assetContent = (AssetContent) content2;
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, -338164519, str3);
                    boolean invalid$iv6 = $composer2.changedInstance(scope) | $composer2.changedInstance(function2);
                    Object it$iv15 = $composer$iv2.rememberedValue();
                    if (invalid$iv6 || it$iv15 == Composer.Companion.getEmpty()) {
                        Object value$iv20 = new Function1() { // from class: kntr.app.tribee.publish.internal.TribeeInputFieldsKt$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj) {
                                Unit TribeeInputFields$lambda$9$2$3$10$0;
                                TribeeInputFields$lambda$9$2$3$10$0 = TribeeInputFieldsKt.TribeeInputFields$lambda$9$2$3$10$0(scope, function2, (RichTextAction) obj);
                                return TribeeInputFields$lambda$9$2$3$10$0;
                            }
                        };
                        $composer$iv2.updateRememberedValue(value$iv20);
                        it$iv15 = value$iv20;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    AssetParagraphContentKt.AssetParagraphContent(assetContent, index$iv2, (Function1) it$iv15, itemModifier, $composer$iv2, 3072, 0);
                } else {
                    $composer$iv2.startReplaceGroup(-1901316511);
                }
                $composer$iv2.endReplaceGroup();
                Boolean valueOf4 = Boolean.valueOf(paragraphContent.getCurrentFocus() == index$iv2);
                Boolean valueOf5 = Boolean.valueOf(paragraphContent.getFocusConsumed());
                ComposerKt.sourceInformationMarkerStart($composer$iv2, -338154390, str3);
                boolean invalid$iv7 = $composer$iv2.changedInstance(paragraphContent) | $composer$iv2.changed(index$iv2) | $composer$iv2.changed(focusRequester4);
                TribeeInputFieldsKt$TribeeInputFields$3$3$1$7$1 value$iv21 = $composer$iv2.rememberedValue();
                if (invalid$iv7) {
                }
                value$iv21 = new TribeeInputFieldsKt$TribeeInputFields$3$3$1$7$1(paragraphContent, index$iv2, focusRequester4, null);
                $composer$iv2.updateRememberedValue(value$iv21);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                EffectsKt.LaunchedEffect(valueOf4, valueOf5, (Function2) value$iv21, $composer$iv2, 0);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer$iv$iv$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                if (index$iv2 != CollectionsKt.getLastIndex(paragraphContent.getContentList())) {
                    $composer3 = $composer6;
                    $composer3.startReplaceGroup(1604494350);
                    ComposerKt.sourceInformation($composer3, "201@8826L41");
                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), $composer3, 6);
                } else {
                    $composer3 = $composer6;
                    $composer3.startReplaceGroup(1595753559);
                }
                $composer3.endReplaceGroup();
                paragraphContent3 = paragraphContent;
                $composer5 = $composer3;
                str2 = str3;
                $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                z3 = z4;
                it = it2;
                z2 = z;
                horizontalAlignment$iv3 = horizontalAlignment$iv;
                index$iv2 = index$iv;
                $composer$iv$iv = $composer$iv$iv2;
                scrollInteractionSource4 = scrollInteractionSource2;
                str = str4;
            }
            MutableInteractionSource scrollInteractionSource5 = scrollInteractionSource4;
            String str6 = str2;
            Composer $composer7 = $composer5;
            $composer7.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer7);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            $composer$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Boolean valueOf6 = Boolean.valueOf(needFocus);
            ComposerKt.sourceInformationMarkerStart($composer2, 1398251618, str6);
            boolean invalid$iv8 = ($dirty2 & 7168) == 2048;
            Object it$iv16 = $composer2.rememberedValue();
            if (invalid$iv8 || it$iv16 == Composer.Companion.getEmpty()) {
                Object value$iv22 = (Function2) new TribeeInputFieldsKt$TribeeInputFields$4$1(needFocus, titleFocusRequester, null);
                $composer2.updateRememberedValue(value$iv22);
                it$iv16 = value$iv22;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(valueOf6, (Function2) it$iv16, $composer2, ($dirty2 >> 9) & 14);
            ComposerKt.sourceInformationMarkerStart($composer2, 1398255391, str6);
            boolean invalid$iv9 = $composer2.changed(scroll);
            Object it$iv17 = $composer2.rememberedValue();
            if (invalid$iv9 || it$iv17 == Composer.Companion.getEmpty()) {
                scrollInteractionSource = scrollInteractionSource5;
                Object value$iv23 = (Function2) new TribeeInputFieldsKt$TribeeInputFields$5$1(scroll, scrollInteractionSource, null);
                $composer2.updateRememberedValue(value$iv23);
                it$iv17 = value$iv23;
            } else {
                scrollInteractionSource = scrollInteractionSource5;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(scroll, (Function2) it$iv17, $composer2, 0);
            State dragged = DragInteractionKt.collectIsDraggedAsState(scrollInteractionSource, $composer2, 6);
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalSoftwareKeyboardController();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SoftwareKeyboardController keyboardController = (SoftwareKeyboardController) consume;
            Object value = dragged.getValue();
            ComposerKt.sourceInformationMarkerStart($composer2, 1398264638, str6);
            boolean invalid$iv10 = $composer2.changed(dragged) | $composer2.changed(keyboardController);
            Object it$iv18 = $composer2.rememberedValue();
            if (!invalid$iv10 && it$iv18 != Composer.Companion.getEmpty()) {
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(value, (Function2) it$iv18, $composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            Object value$iv24 = (Function2) new TribeeInputFieldsKt$TribeeInputFields$6$1(dragged, keyboardController, null);
            $composer2.updateRememberedValue(value$iv24);
            it$iv18 = value$iv24;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(value, (Function2) it$iv18, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.publish.internal.TribeeInputFieldsKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeInputFields$lambda$13;
                    TribeeInputFields$lambda$13 = TribeeInputFieldsKt.TribeeInputFields$lambda$13(TribeePublishContent.this, contentHint, function2, needFocus, function0, function02, function03, function04, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeInputFields$lambda$13;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean TribeeInputFields$lambda$5(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void TribeeInputFields$lambda$6(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInputFields$lambda$7$0(FocusRequester $parentFocus) {
        FocusRequester.requestFocus-3ESFkO8$default($parentFocus, 0, 1, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInputFields$lambda$8$0(Map $paragraphFocus, RichTextContent $paragraphContent, Function0 $onContentFocusChange, FocusState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.isFocused()) {
            FocusRequester focusRequester = (FocusRequester) $paragraphFocus.get(Integer.valueOf(RangesKt.coerceAtLeast($paragraphContent.getCurrentFocus(), 0)));
            if (focusRequester != null) {
                FocusRequester.requestFocus-3ESFkO8$default(focusRequester, 0, 1, (Object) null);
            }
            $onContentFocusChange.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInputFields$lambda$9$0$0(MutableState $titleFocused$delegate, boolean it) {
        TribeeInputFields$lambda$6($titleFocused$delegate, it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInputFields$lambda$9$1$0(CoroutineScope $scope, Function2 $onAction, Function0 $onTitleFocusChange, FocusState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.isFocused()) {
            BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new TribeeInputFieldsKt$TribeeInputFields$3$2$1$1($onAction, $onTitleFocusChange, null), 3, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInputFields$lambda$9$2$2$0(CoroutineScope $scope, Function2 $onAction, int $index, Function0 $onContentFocusChange, FocusState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.isFocused()) {
            BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new TribeeInputFieldsKt$TribeeInputFields$3$3$itemModifier$1$1$1($onAction, $index, $onContentFocusChange, null), 3, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TribeeInputFields$lambda$9$2$3$1$0(int $index, TextFieldBuffer $this$InputTransformation) {
        Intrinsics.checkNotNullParameter($this$InputTransformation, "$this$InputTransformation");
        if ($index == 0) {
            TextFieldStateHelperKt.filterEmptyOnStart($this$InputTransformation);
        }
        TextFieldStateHelperKt.filterContinuousSpace($this$InputTransformation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect TribeeInputFields$lambda$9$2$3$3(MutableState<Rect> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (Rect) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInputFields$lambda$9$2$3$6$0(CoroutineScope $scope, Function2 $onAction, RichTextAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new TribeeInputFieldsKt$TribeeInputFields$3$3$1$2$1$1($onAction, it, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInputFields$lambda$9$2$3$7$0(TextFieldState $state, MutableState $cursorRect$delegate, Density $this$TextParagraphContent, Function0 it) {
        Intrinsics.checkNotNullParameter($this$TextParagraphContent, "$this$TextParagraphContent");
        Intrinsics.checkNotNullParameter(it, "it");
        TextLayoutResult textLayoutResult = (TextLayoutResult) it.invoke();
        $cursorRect$delegate.setValue(textLayoutResult != null ? textLayoutResult.getCursorRect(TextRange.getMin-impl($state.getSelection-d9O1mEE())) : null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInputFields$lambda$9$2$3$10$0(CoroutineScope $scope, Function2 $onAction, RichTextAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new TribeeInputFieldsKt$TribeeInputFields$3$3$1$6$1$1($onAction, it, null), 3, (Object) null);
        return Unit.INSTANCE;
    }
}