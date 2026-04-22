package tv.danmaku.bili.core.test;

import ComposableSingletons$CustomBottomSheetKt$;
import android.content.Context;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bilibili.app.comm.list.common.cache.PersistedPropertyKt;
import com.bilibili.app.comm.list.common.cache.PersistedValue;
import com.bilibili.app.comm.restrict.utils.TeenagersModeKt;
import com.bilibili.app.comm.restrict.utils.TeenagersModeSource;
import com.bilibili.base.util.ContextUtilKt;
import com.bilibili.list.test.AbsComposeItem;
import kntr.common.trio.switch.SimpleSwitchColors;
import kntr.common.trio.switch.SimpleSwitchKt;
import kntr.common.trio.switch.SimpleSwitchSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.mine.topleft.TeensAgeKt;

/* compiled from: CommonTestPage.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0017¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/core/test/伪装成系统青少年开关;", "Lcom/bilibili/list/test/AbsComposeItem;", "<init>", "()V", "ContentImpl", "", "(Landroidx/compose/runtime/Composer;I)V", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
/* renamed from: tv.danmaku.bili.core.test.伪装成系统青少年开关  reason: contains not printable characters */
public final class C0004 extends AbsComposeItem {
    public static final int $stable = AbsComposeItem.$stable;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentImpl$lambda$2(C0004 c0004, int i, Composer composer, int i2) {
        c0004.ContentImpl(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0274, code lost:
        if (r15 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0465, code lost:
        if (r9 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0739  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x02c0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0469  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x04b4  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x06d1  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x06e4  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0711  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void ContentImpl(Composer $composer, final int $changed) {
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Object value$iv$iv;
        boolean invalid$iv$iv;
        final MutableState result$iv;
        boolean invalid$iv$iv2;
        boolean invalid$iv;
        Function0 factory$iv$iv$iv2;
        boolean invalid$iv2;
        Function0 factory$iv$iv$iv3;
        $ContentImpl$1$3$1$1 value$iv;
        $ContentImpl$1$3$2$1 value$iv2;
        Composer $composer3 = $composer.startRestartGroup(1381346292);
        ComposerKt.sourceInformation($composer3, "C(ContentImpl)174@5860L7,176@5958L43,178@6002L45,180@6057L2289:CommonTestPage.kt#pxmn5u");
        if ($composer3.shouldExecute(($changed & 1) != 0, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1381346292, $changed, -1, "tv.danmaku.bili.core.test.伪装成系统青少年开关.ContentImpl (CommonTestPage.kt:172)");
            }
            CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            FragmentActivity findFragmentActivityOrNull = ContextUtilKt.findFragmentActivityOrNull((Context) consume);
            FragmentManager fragmentManager = findFragmentActivityOrNull != null ? findFragmentActivityOrNull.getSupportFragmentManager() : null;
            ComposerKt.sourceInformationMarkerStart($composer3, 328897727, "CC(remember):CommonTestPage.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function0() { // from class: tv.danmaku.bili.core.test.伪装成系统青少年开关$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        TeenagersModeSource ContentImpl$lambda$0$0;
                        ContentImpl$lambda$0$0 = C0004.ContentImpl$lambda$0$0();
                        return ContentImpl$lambda$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv3);
                it$iv = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            State snapshot = SnapshotStateKt.collectAsState(SnapshotStateKt.snapshotFlow((Function0) it$iv), TeenagersModeKt.getTeenagersModeSource(), (CoroutineContext) null, $composer3, 0, 2);
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & BR.containerVisible));
            int $changed$iv$iv = (6 << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $i$f$Column = $changed$iv$iv << 6;
            int $changed$iv$iv$iv = ($i$f$Column & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((6 >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -164457685, "C181@6150L252,191@6452L141,191@6416L177,197@6607L323:CommonTestPage.kt#pxmn5u");
            Object key$iv = snapshot.getValue();
            ComposerKt.sourceInformationMarkerStart($composer3, 671961792, "CC(rememberPersisted)N(key,provider)142@2940L47,146@3006L60,150@3108L91,150@3072L127:PersistedProperty.kt#q8rhsj");
            ComposerKt.sourceInformationMarkerStart($composer3, 1510193167, "CC(remember):PersistedProperty.kt#9igjgp");
            boolean invalid$iv$iv3 = $composer3.changed(key$iv);
            Object it$iv$iv = $composer3.rememberedValue();
            if (!invalid$iv$iv3 && it$iv$iv != Composer.Companion.getEmpty()) {
                value$iv$iv = it$iv$iv;
                PersistedValue value$iv4 = (PersistedValue) value$iv$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerStart($composer3, 1510195292, "CC(remember):PersistedProperty.kt#9igjgp");
                invalid$iv$iv = $composer3.changed(key$iv);
                Object value$iv$iv2 = $composer3.rememberedValue();
                if (!invalid$iv$iv && value$iv$iv2 != Composer.Companion.getEmpty()) {
                    $composer2 = $composer3;
                    result$iv = (MutableState) value$iv$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Object value = result$iv.getValue();
                    ComposerKt.sourceInformationMarkerStart($composer3, 1510198587, "CC(remember):PersistedProperty.kt#9igjgp");
                    invalid$iv$iv2 = $composer3.changedInstance(value$iv4) | $composer3.changed(result$iv);
                    Object it$iv$iv2 = $composer3.rememberedValue();
                    if (invalid$iv$iv2) {
                    }
                    Object value$iv$iv3 = (Function2) new $ContentImpl$lambda$1$$inlined$rememberPersisted$1(value$iv4, result$iv, null);
                    $composer3.updateRememberedValue(value$iv$iv3);
                    it$iv$iv2 = value$iv$iv3;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    EffectsKt.LaunchedEffect(value, (Function2) it$iv$iv2, $composer3, 0);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Object value2 = result$iv.getValue();
                    ComposerKt.sourceInformationMarkerStart($composer3, -1390769673, "CC(remember):CommonTestPage.kt#9igjgp");
                    invalid$iv = $composer3.changed(result$iv);
                    Object it$iv2 = $composer3.rememberedValue();
                    if (!invalid$iv && it$iv2 != Composer.Companion.getEmpty()) {
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        EffectsKt.LaunchedEffect(value2, (Function2) it$iv2, $composer3, 0);
                        Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                        ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                        Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
                        MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & BR.containerVisible));
                        int $changed$iv$iv2 = (6 << 3) & BR.containerVisible;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                        CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
                        Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            factory$iv$iv$iv2 = factory$iv$iv$iv5;
                            $composer3.useNode();
                        } else {
                            factory$iv$iv$iv2 = factory$iv$iv$iv5;
                            $composer3.createNode(factory$iv$iv$iv2);
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
                        FragmentManager fragmentManager2 = fragmentManager;
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                        int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScope rowScope = RowScopeInstance.INSTANCE;
                        int i4 = ((6 >> 6) & BR.containerVisible) | 6;
                        RowScope $this$ContentImpl_u24lambda_u241_u242 = rowScope;
                        ComposerKt.sourceInformationMarkerStart($composer3, -311577605, "C198@6665L64,201@6746L38,203@6857L57,203@6802L113:CommonTestPage.kt#pxmn5u");
                        TextKt.Text--4IGK_g("伪装一下系统青少年开关", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 6, 0, 131070);
                        SpacerKt.Spacer(RowScope.-CC.weight$default($this$ContentImpl_u24lambda_u241_u242, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer3, 0);
                        boolean booleanValue = ((Boolean) result$iv.getValue()).booleanValue();
                        ComposerKt.sourceInformationMarkerStart($composer3, -1534065593, "CC(remember):CommonTestPage.kt#9igjgp");
                        invalid$iv2 = $composer3.changed(result$iv);
                        Object it$iv3 = $composer3.rememberedValue();
                        if (invalid$iv2) {
                        }
                        Object value$iv5 = new Function1() { // from class: tv.danmaku.bili.core.test.伪装成系统青少年开关$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj) {
                                Unit ContentImpl$lambda$1$2$0$0;
                                ContentImpl$lambda$1$2$0$0 = C0004.ContentImpl$lambda$1$2$0$0(result$iv, ((Boolean) obj).booleanValue());
                                return ContentImpl$lambda$1$2$0$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv5);
                        it$iv3 = value$iv5;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        SimpleSwitchKt.SimpleSwitch(booleanValue, (Function1) it$iv3, (Modifier) null, false, (SimpleSwitchSize) null, (SimpleSwitchColors) null, $composer3, 0, 60);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        if (((Boolean) result$iv.getValue()).booleanValue()) {
                            $composer3.startReplaceGroup(-170592648);
                        } else {
                            $composer3.startReplaceGroup(-163642758);
                            ComposerKt.sourceInformation($composer3, "211@6981L1341");
                            Modifier modifier$iv3 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(16), 0.0f, 0.0f, 13, (Object) null), 0.0f, 1, (Object) null), Dp.constructor-impl(30));
                            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getTop();
                            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & BR.containerVisible));
                            int $changed$iv$iv3 = (6 << 3) & BR.containerVisible;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
                            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                            int $i$f$Row = $changed$iv$iv3 << 6;
                            int $changed$iv$iv$iv3 = ($i$f$Row & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!($composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer3.startReusableNode();
                            if ($composer3.getInserting()) {
                                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                                $composer3.createNode(factory$iv$iv$iv3);
                            } else {
                                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                                $composer3.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                            int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                            RowScope rowScope2 = RowScopeInstance.INSTANCE;
                            int i6 = ((6 >> 6) & BR.containerVisible) | 6;
                            RowScope $this$ContentImpl_u24lambda_u241_u243 = rowScope2;
                            ComposerKt.sourceInformationMarkerStart($composer3, 446306914, "C217@7228L92,221@7342L86,225@7450L38,230@7660L174,235@7857L447,227@7510L794:CommonTestPage.kt#pxmn5u");
                            ComposerKt.sourceInformationMarkerStart($composer3, -124150203, "CC(remember):CommonTestPage.kt#9igjgp");
                            Object it$iv4 = $composer3.rememberedValue();
                            if (it$iv4 == Composer.Companion.getEmpty()) {
                                Object value$iv6 = SnapshotIntStateKt.mutableIntStateOf(TeenagersModeKt.getTeenagerAge());
                                $composer3.updateRememberedValue(value$iv6);
                                it$iv4 = value$iv6;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            MutableState currentAge = (MutableIntState) it$iv4;
                            TextKt.Text--4IGK_g(String.valueOf(((Number) currentAge.getValue()).intValue()), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 0, 0, 131070);
                            SpacerKt.Spacer(RowScope.-CC.weight$default($this$ContentImpl_u24lambda_u241_u243, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer3, 0);
                            int intValue = ((Number) currentAge.getValue()).intValue();
                            ComposerKt.sourceInformationMarkerStart($composer3, -124136297, "CC(remember):CommonTestPage.kt#9igjgp");
                            boolean invalid$iv3 = $composer3.changedInstance(fragmentManager2);
                            Object it$iv5 = $composer3.rememberedValue();
                            if (!invalid$iv3 && it$iv5 != Composer.Companion.getEmpty()) {
                                value$iv = it$iv5;
                                Function1 function1 = value$iv;
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                ComposerKt.sourceInformationMarkerStart($composer3, -124129720, "CC(remember):CommonTestPage.kt#9igjgp");
                                value$iv2 = $composer3.rememberedValue();
                                if (value$iv2 != Composer.Companion.getEmpty()) {
                                    value$iv2 = new $ContentImpl$1$3$2$1(currentAge, null);
                                    $composer3.updateRememberedValue(value$iv2);
                                }
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                TeensAgeKt.TeesAgeButton(intValue, false, function1, (Function2) value$iv2, $composer3, 48, 0);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                $composer3.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                            }
                            value$iv = new $ContentImpl$1$3$1$1(fragmentManager2, currentAge, null);
                            $composer3.updateRememberedValue(value$iv);
                            Function1 function12 = value$iv;
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerStart($composer3, -124129720, "CC(remember):CommonTestPage.kt#9igjgp");
                            value$iv2 = $composer3.rememberedValue();
                            if (value$iv2 != Composer.Companion.getEmpty()) {
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            TeensAgeKt.TeesAgeButton(intValue, false, function12, (Function2) value$iv2, $composer3, 48, 0);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            $composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                        }
                        $composer3.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    Object value$iv7 = (Function2) new $ContentImpl$1$1$1(result$iv, null);
                    $composer3.updateRememberedValue(value$iv7);
                    it$iv2 = value$iv7;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    EffectsKt.LaunchedEffect(value2, (Function2) it$iv2, $composer3, 0);
                    Modifier modifier$iv22 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getStart();
                    Alignment.Vertical verticalAlignment$iv3 = Alignment.Companion.getTop();
                    MeasurePolicy measurePolicy$iv22 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & BR.containerVisible));
                    int $changed$iv$iv22 = (6 << 3) & BR.containerVisible;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv22 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                    CompositionLocalMap localMap$iv$iv22 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv22 = ComposedModifierKt.materializeModifier($composer3, modifier$iv22);
                    Function0 factory$iv$iv$iv52 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv22 = (($changed$iv$iv22 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer3.getApplier() instanceof Applier)) {
                    }
                    $composer3.startReusableNode();
                    if ($composer3.getInserting()) {
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv22 = Updater.constructor-impl($composer3);
                    FragmentManager fragmentManager22 = fragmentManager;
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, measurePolicy$iv22, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, localMap$iv$iv22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv22, Integer.valueOf(compositeKeyHash$iv$iv22), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv22, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, materialized$iv$iv22, ComposeUiNode.Companion.getSetModifier());
                    int i32 = ($changed$iv$iv$iv22 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScope rowScope3 = RowScopeInstance.INSTANCE;
                    int i42 = ((6 >> 6) & BR.containerVisible) | 6;
                    RowScope $this$ContentImpl_u24lambda_u241_u2422 = rowScope3;
                    ComposerKt.sourceInformationMarkerStart($composer3, -311577605, "C198@6665L64,201@6746L38,203@6857L57,203@6802L113:CommonTestPage.kt#pxmn5u");
                    TextKt.Text--4IGK_g("伪装一下系统青少年开关", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 6, 0, 131070);
                    SpacerKt.Spacer(RowScope.-CC.weight$default($this$ContentImpl_u24lambda_u241_u2422, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer3, 0);
                    boolean booleanValue2 = ((Boolean) result$iv.getValue()).booleanValue();
                    ComposerKt.sourceInformationMarkerStart($composer3, -1534065593, "CC(remember):CommonTestPage.kt#9igjgp");
                    invalid$iv2 = $composer3.changed(result$iv);
                    Object it$iv32 = $composer3.rememberedValue();
                    if (invalid$iv2) {
                    }
                    Object value$iv52 = new Function1() { // from class: tv.danmaku.bili.core.test.伪装成系统青少年开关$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            Unit ContentImpl$lambda$1$2$0$0;
                            ContentImpl$lambda$1$2$0$0 = C0004.ContentImpl$lambda$1$2$0$0(result$iv, ((Boolean) obj).booleanValue());
                            return ContentImpl$lambda$1$2$0$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv52);
                    it$iv32 = value$iv52;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    SimpleSwitchKt.SimpleSwitch(booleanValue2, (Function1) it$iv32, (Modifier) null, false, (SimpleSwitchSize) null, (SimpleSwitchColors) null, $composer3, 0, 60);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    if (((Boolean) result$iv.getValue()).booleanValue()) {
                    }
                    $composer3.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                }
                $composer2 = $composer3;
                value$iv$iv2 = SnapshotStateKt.mutableStateOf$default(value$iv4.getV(), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv$iv2);
                result$iv = (MutableState) value$iv$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Object value3 = result$iv.getValue();
                ComposerKt.sourceInformationMarkerStart($composer3, 1510198587, "CC(remember):PersistedProperty.kt#9igjgp");
                invalid$iv$iv2 = $composer3.changedInstance(value$iv4) | $composer3.changed(result$iv);
                Object it$iv$iv22 = $composer3.rememberedValue();
                if (invalid$iv$iv2) {
                }
                Object value$iv$iv32 = (Function2) new $ContentImpl$lambda$1$$inlined$rememberPersisted$1(value$iv4, result$iv, null);
                $composer3.updateRememberedValue(value$iv$iv32);
                it$iv$iv22 = value$iv$iv32;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.LaunchedEffect(value3, (Function2) it$iv$iv22, $composer3, 0);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Object value22 = result$iv.getValue();
                ComposerKt.sourceInformationMarkerStart($composer3, -1390769673, "CC(remember):CommonTestPage.kt#9igjgp");
                invalid$iv = $composer3.changed(result$iv);
                Object it$iv22 = $composer3.rememberedValue();
                if (!invalid$iv) {
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    EffectsKt.LaunchedEffect(value22, (Function2) it$iv22, $composer3, 0);
                    Modifier modifier$iv222 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    Arrangement.Horizontal horizontalArrangement$iv32 = Arrangement.INSTANCE.getStart();
                    Alignment.Vertical verticalAlignment$iv32 = Alignment.Companion.getTop();
                    MeasurePolicy measurePolicy$iv222 = RowKt.rowMeasurePolicy(horizontalArrangement$iv32, verticalAlignment$iv32, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & BR.containerVisible));
                    int $changed$iv$iv222 = (6 << 3) & BR.containerVisible;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv222 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                    CompositionLocalMap localMap$iv$iv222 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv222 = ComposedModifierKt.materializeModifier($composer3, modifier$iv222);
                    Function0 factory$iv$iv$iv522 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv222 = (($changed$iv$iv222 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer3.getApplier() instanceof Applier)) {
                    }
                    $composer3.startReusableNode();
                    if ($composer3.getInserting()) {
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv222 = Updater.constructor-impl($composer3);
                    FragmentManager fragmentManager222 = fragmentManager;
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv222, measurePolicy$iv222, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv222, localMap$iv$iv222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv222, Integer.valueOf(compositeKeyHash$iv$iv222), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv222, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv222, materialized$iv$iv222, ComposeUiNode.Companion.getSetModifier());
                    int i322 = ($changed$iv$iv$iv222 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScope rowScope32 = RowScopeInstance.INSTANCE;
                    int i422 = ((6 >> 6) & BR.containerVisible) | 6;
                    RowScope $this$ContentImpl_u24lambda_u241_u24222 = rowScope32;
                    ComposerKt.sourceInformationMarkerStart($composer3, -311577605, "C198@6665L64,201@6746L38,203@6857L57,203@6802L113:CommonTestPage.kt#pxmn5u");
                    TextKt.Text--4IGK_g("伪装一下系统青少年开关", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 6, 0, 131070);
                    SpacerKt.Spacer(RowScope.-CC.weight$default($this$ContentImpl_u24lambda_u241_u24222, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer3, 0);
                    boolean booleanValue22 = ((Boolean) result$iv.getValue()).booleanValue();
                    ComposerKt.sourceInformationMarkerStart($composer3, -1534065593, "CC(remember):CommonTestPage.kt#9igjgp");
                    invalid$iv2 = $composer3.changed(result$iv);
                    Object it$iv322 = $composer3.rememberedValue();
                    if (invalid$iv2) {
                    }
                    Object value$iv522 = new Function1() { // from class: tv.danmaku.bili.core.test.伪装成系统青少年开关$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            Unit ContentImpl$lambda$1$2$0$0;
                            ContentImpl$lambda$1$2$0$0 = C0004.ContentImpl$lambda$1$2$0$0(result$iv, ((Boolean) obj).booleanValue());
                            return ContentImpl$lambda$1$2$0$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv522);
                    it$iv322 = value$iv522;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    SimpleSwitchKt.SimpleSwitch(booleanValue22, (Function1) it$iv322, (Modifier) null, false, (SimpleSwitchSize) null, (SimpleSwitchColors) null, $composer3, 0, 60);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    if (((Boolean) result$iv.getValue()).booleanValue()) {
                    }
                    $composer3.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                }
                Object value$iv72 = (Function2) new $ContentImpl$1$1$1(result$iv, null);
                $composer3.updateRememberedValue(value$iv72);
                it$iv22 = value$iv72;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.LaunchedEffect(value22, (Function2) it$iv22, $composer3, 0);
                Modifier modifier$iv2222 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv322 = Arrangement.INSTANCE.getStart();
                Alignment.Vertical verticalAlignment$iv322 = Alignment.Companion.getTop();
                MeasurePolicy measurePolicy$iv2222 = RowKt.rowMeasurePolicy(horizontalArrangement$iv322, verticalAlignment$iv322, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & BR.containerVisible));
                int $changed$iv$iv2222 = (6 << 3) & BR.containerVisible;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2222 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv2222 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2222 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2222);
                Function0 factory$iv$iv$iv5222 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2222 = (($changed$iv$iv2222 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2222 = Updater.constructor-impl($composer3);
                FragmentManager fragmentManager2222 = fragmentManager;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2222, measurePolicy$iv2222, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2222, localMap$iv$iv2222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2222, Integer.valueOf(compositeKeyHash$iv$iv2222), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2222, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2222, materialized$iv$iv2222, ComposeUiNode.Companion.getSetModifier());
                int i3222 = ($changed$iv$iv$iv2222 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope322 = RowScopeInstance.INSTANCE;
                int i4222 = ((6 >> 6) & BR.containerVisible) | 6;
                RowScope $this$ContentImpl_u24lambda_u241_u242222 = rowScope322;
                ComposerKt.sourceInformationMarkerStart($composer3, -311577605, "C198@6665L64,201@6746L38,203@6857L57,203@6802L113:CommonTestPage.kt#pxmn5u");
                TextKt.Text--4IGK_g("伪装一下系统青少年开关", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 6, 0, 131070);
                SpacerKt.Spacer(RowScope.-CC.weight$default($this$ContentImpl_u24lambda_u241_u242222, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer3, 0);
                boolean booleanValue222 = ((Boolean) result$iv.getValue()).booleanValue();
                ComposerKt.sourceInformationMarkerStart($composer3, -1534065593, "CC(remember):CommonTestPage.kt#9igjgp");
                invalid$iv2 = $composer3.changed(result$iv);
                Object it$iv3222 = $composer3.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv5222 = new Function1() { // from class: tv.danmaku.bili.core.test.伪装成系统青少年开关$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        Unit ContentImpl$lambda$1$2$0$0;
                        ContentImpl$lambda$1$2$0$0 = C0004.ContentImpl$lambda$1$2$0$0(result$iv, ((Boolean) obj).booleanValue());
                        return ContentImpl$lambda$1$2$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv5222);
                it$iv3222 = value$iv5222;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                SimpleSwitchKt.SimpleSwitch(booleanValue222, (Function1) it$iv3222, (Modifier) null, false, (SimpleSwitchSize) null, (SimpleSwitchColors) null, $composer3, 0, 60);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                if (((Boolean) result$iv.getValue()).booleanValue()) {
                }
                $composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                if (ComposerKt.isTraceInProgress()) {
                }
            }
            value$iv$iv = PersistedPropertyKt.persistedBoolean("os_teenager_mode", "main_debug", false);
            $composer3.updateRememberedValue(value$iv$iv);
            PersistedValue value$iv42 = (PersistedValue) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 1510195292, "CC(remember):PersistedProperty.kt#9igjgp");
            invalid$iv$iv = $composer3.changed(key$iv);
            Object value$iv$iv22 = $composer3.rememberedValue();
            if (!invalid$iv$iv) {
                $composer2 = $composer3;
                result$iv = (MutableState) value$iv$iv22;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Object value32 = result$iv.getValue();
                ComposerKt.sourceInformationMarkerStart($composer3, 1510198587, "CC(remember):PersistedProperty.kt#9igjgp");
                invalid$iv$iv2 = $composer3.changedInstance(value$iv42) | $composer3.changed(result$iv);
                Object it$iv$iv222 = $composer3.rememberedValue();
                if (invalid$iv$iv2) {
                }
                Object value$iv$iv322 = (Function2) new $ContentImpl$lambda$1$$inlined$rememberPersisted$1(value$iv42, result$iv, null);
                $composer3.updateRememberedValue(value$iv$iv322);
                it$iv$iv222 = value$iv$iv322;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.LaunchedEffect(value32, (Function2) it$iv$iv222, $composer3, 0);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Object value222 = result$iv.getValue();
                ComposerKt.sourceInformationMarkerStart($composer3, -1390769673, "CC(remember):CommonTestPage.kt#9igjgp");
                invalid$iv = $composer3.changed(result$iv);
                Object it$iv222 = $composer3.rememberedValue();
                if (!invalid$iv) {
                }
                Object value$iv722 = (Function2) new $ContentImpl$1$1$1(result$iv, null);
                $composer3.updateRememberedValue(value$iv722);
                it$iv222 = value$iv722;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.LaunchedEffect(value222, (Function2) it$iv222, $composer3, 0);
                Modifier modifier$iv22222 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv3222 = Arrangement.INSTANCE.getStart();
                Alignment.Vertical verticalAlignment$iv3222 = Alignment.Companion.getTop();
                MeasurePolicy measurePolicy$iv22222 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3222, verticalAlignment$iv3222, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & BR.containerVisible));
                int $changed$iv$iv22222 = (6 << 3) & BR.containerVisible;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv22222 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv22222 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv22222 = ComposedModifierKt.materializeModifier($composer3, modifier$iv22222);
                Function0 factory$iv$iv$iv52222 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv22222 = (($changed$iv$iv22222 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv22222 = Updater.constructor-impl($composer3);
                FragmentManager fragmentManager22222 = fragmentManager;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22222, measurePolicy$iv22222, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22222, localMap$iv$iv22222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv22222, Integer.valueOf(compositeKeyHash$iv$iv22222), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv22222, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22222, materialized$iv$iv22222, ComposeUiNode.Companion.getSetModifier());
                int i32222 = ($changed$iv$iv$iv22222 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope3222 = RowScopeInstance.INSTANCE;
                int i42222 = ((6 >> 6) & BR.containerVisible) | 6;
                RowScope $this$ContentImpl_u24lambda_u241_u2422222 = rowScope3222;
                ComposerKt.sourceInformationMarkerStart($composer3, -311577605, "C198@6665L64,201@6746L38,203@6857L57,203@6802L113:CommonTestPage.kt#pxmn5u");
                TextKt.Text--4IGK_g("伪装一下系统青少年开关", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 6, 0, 131070);
                SpacerKt.Spacer(RowScope.-CC.weight$default($this$ContentImpl_u24lambda_u241_u2422222, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer3, 0);
                boolean booleanValue2222 = ((Boolean) result$iv.getValue()).booleanValue();
                ComposerKt.sourceInformationMarkerStart($composer3, -1534065593, "CC(remember):CommonTestPage.kt#9igjgp");
                invalid$iv2 = $composer3.changed(result$iv);
                Object it$iv32222 = $composer3.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv52222 = new Function1() { // from class: tv.danmaku.bili.core.test.伪装成系统青少年开关$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        Unit ContentImpl$lambda$1$2$0$0;
                        ContentImpl$lambda$1$2$0$0 = C0004.ContentImpl$lambda$1$2$0$0(result$iv, ((Boolean) obj).booleanValue());
                        return ContentImpl$lambda$1$2$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv52222);
                it$iv32222 = value$iv52222;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                SimpleSwitchKt.SimpleSwitch(booleanValue2222, (Function1) it$iv32222, (Modifier) null, false, (SimpleSwitchSize) null, (SimpleSwitchColors) null, $composer3, 0, 60);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                if (((Boolean) result$iv.getValue()).booleanValue()) {
                }
                $composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                if (ComposerKt.isTraceInProgress()) {
                }
            }
            $composer2 = $composer3;
            value$iv$iv22 = SnapshotStateKt.mutableStateOf$default(value$iv42.getV(), (SnapshotMutationPolicy) null, 2, (Object) null);
            $composer3.updateRememberedValue(value$iv$iv22);
            result$iv = (MutableState) value$iv$iv22;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Object value322 = result$iv.getValue();
            ComposerKt.sourceInformationMarkerStart($composer3, 1510198587, "CC(remember):PersistedProperty.kt#9igjgp");
            invalid$iv$iv2 = $composer3.changedInstance(value$iv42) | $composer3.changed(result$iv);
            Object it$iv$iv2222 = $composer3.rememberedValue();
            if (invalid$iv$iv2) {
            }
            Object value$iv$iv3222 = (Function2) new $ContentImpl$lambda$1$$inlined$rememberPersisted$1(value$iv42, result$iv, null);
            $composer3.updateRememberedValue(value$iv$iv3222);
            it$iv$iv2222 = value$iv$iv3222;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(value322, (Function2) it$iv$iv2222, $composer3, 0);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Object value2222 = result$iv.getValue();
            ComposerKt.sourceInformationMarkerStart($composer3, -1390769673, "CC(remember):CommonTestPage.kt#9igjgp");
            invalid$iv = $composer3.changed(result$iv);
            Object it$iv2222 = $composer3.rememberedValue();
            if (!invalid$iv) {
            }
            Object value$iv7222 = (Function2) new $ContentImpl$1$1$1(result$iv, null);
            $composer3.updateRememberedValue(value$iv7222);
            it$iv2222 = value$iv7222;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(value2222, (Function2) it$iv2222, $composer3, 0);
            Modifier modifier$iv222222 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv32222 = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv32222 = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv222222 = RowKt.rowMeasurePolicy(horizontalArrangement$iv32222, verticalAlignment$iv32222, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & BR.containerVisible));
            int $changed$iv$iv222222 = (6 << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv222222 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv222222 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv222222 = ComposedModifierKt.materializeModifier($composer3, modifier$iv222222);
            Function0 factory$iv$iv$iv522222 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv222222 = (($changed$iv$iv222222 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv222222 = Updater.constructor-impl($composer3);
            FragmentManager fragmentManager222222 = fragmentManager;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv222222, measurePolicy$iv222222, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv222222, localMap$iv$iv222222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv222222, Integer.valueOf(compositeKeyHash$iv$iv222222), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv222222, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv222222, materialized$iv$iv222222, ComposeUiNode.Companion.getSetModifier());
            int i322222 = ($changed$iv$iv$iv222222 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope32222 = RowScopeInstance.INSTANCE;
            int i422222 = ((6 >> 6) & BR.containerVisible) | 6;
            RowScope $this$ContentImpl_u24lambda_u241_u24222222 = rowScope32222;
            ComposerKt.sourceInformationMarkerStart($composer3, -311577605, "C198@6665L64,201@6746L38,203@6857L57,203@6802L113:CommonTestPage.kt#pxmn5u");
            TextKt.Text--4IGK_g("伪装一下系统青少年开关", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 6, 0, 131070);
            SpacerKt.Spacer(RowScope.-CC.weight$default($this$ContentImpl_u24lambda_u241_u24222222, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer3, 0);
            boolean booleanValue22222 = ((Boolean) result$iv.getValue()).booleanValue();
            ComposerKt.sourceInformationMarkerStart($composer3, -1534065593, "CC(remember):CommonTestPage.kt#9igjgp");
            invalid$iv2 = $composer3.changed(result$iv);
            Object it$iv322222 = $composer3.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv522222 = new Function1() { // from class: tv.danmaku.bili.core.test.伪装成系统青少年开关$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit ContentImpl$lambda$1$2$0$0;
                    ContentImpl$lambda$1$2$0$0 = C0004.ContentImpl$lambda$1$2$0$0(result$iv, ((Boolean) obj).booleanValue());
                    return ContentImpl$lambda$1$2$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv522222);
            it$iv322222 = value$iv522222;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            SimpleSwitchKt.SimpleSwitch(booleanValue22222, (Function1) it$iv322222, (Modifier) null, false, (SimpleSwitchSize) null, (SimpleSwitchColors) null, $composer3, 0, 60);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (((Boolean) result$iv.getValue()).booleanValue()) {
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.core.test.伪装成系统青少年开关$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ContentImpl$lambda$2;
                    ContentImpl$lambda$2 = C0004.ContentImpl$lambda$2(C0004.this, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return ContentImpl$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TeenagersModeSource ContentImpl$lambda$0$0() {
        return TeenagersModeKt.getTeenagersModeSource();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentImpl$lambda$1$2$0$0(MutableState $switch, boolean it) {
        $switch.setValue(Boolean.valueOf(it));
        return Unit.INSTANCE;
    }
}