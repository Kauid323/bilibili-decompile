package im.base;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import bili.resource.common.Res;
import bili.resource.common.String0_commonMainKt;
import com.bilibili.lib.brouter.uri.Uri;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.smtt.sdk.TbsListener;
import com.yalantis.ucrop.view.CropImageView;
import faceverify.q;
import im.base.IMPageStatusAlignmentMethod;
import io.grpc.internal.GrpcUtil;
import io.ktor.client.utils.CIOKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: IMPageStatus.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a8\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\t\u001ai\u0010\u0000\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052$\b\u0002\u0010\u0010\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00112\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\u0016\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0017"}, d2 = {"IMPageStatus", "", "modifier", "Landroidx/compose/ui/Modifier;", "alignmentMethod", "Lim/base/IMPageStatusAlignmentMethod;", q.KEY_RES_9_CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/Modifier;Lim/base/IMPageStatusAlignmentMethod;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "state", "Lim/base/ContentStatus;", "isLoggedIn", "", "emptyText", "", "onLogin", "Lkotlin/Function2;", "Lcom/bilibili/lib/brouter/uri/Uri;", "Lkotlin/coroutines/Continuation;", "", "onRefresh", "(Lim/base/ContentStatus;ZLjava/lang/String;Lim/base/IMPageStatusAlignmentMethod;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "base-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMPageStatusKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMPageStatus$lambda$5(ContentStatus contentStatus, boolean z, String str, IMPageStatusAlignmentMethod iMPageStatusAlignmentMethod, Function2 function2, Function0 function0, int i2, int i3, Composer composer, int i4) {
        IMPageStatus(contentStatus, z, str, iMPageStatusAlignmentMethod, function2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    public static final void IMPageStatus(Modifier modifier, IMPageStatusAlignmentMethod alignmentMethod, Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, int $changed, int i2) {
        Modifier modifier2;
        IMPageStatusAlignmentMethod.CenterWithMinimumPadding alignmentMethod2;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(function2, q.KEY_RES_9_CONTENT);
        ComposerKt.sourceInformationMarkerStart($composer, 306470902, "CC(IMPageStatus)N(modifier,alignmentMethod,content)27@898L14,28@917L246:IMPageStatus.kt#uu6lp7");
        if ((i2 & 1) != 0) {
            modifier2 = (Modifier) Modifier.Companion;
        } else {
            modifier2 = modifier;
        }
        if ((i2 & 2) == 0) {
            alignmentMethod2 = alignmentMethod;
        } else {
            alignmentMethod2 = new IMPageStatusAlignmentMethod.CenterWithMinimumPadding(Dp.constructor-impl(144), null);
        }
        Alignment alignment = alignmentMethod2.getAlignment($composer, ($changed >> 3) & 14);
        Modifier it = SizeKt.fillMaxSize$default(modifier2, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null);
        IMPageStatusAlignmentMethod $this$IMPageStatus_u24lambda_u240_u240 = alignmentMethod2;
        Modifier modifier$iv = $this$IMPageStatus_u24lambda_u240_u240.applyModifier(it);
        ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(alignment, false);
        int $changed$iv$iv = (0 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
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
        int i3 = ($changed$iv$iv$iv >> 6) & 14;
        ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
        BoxScope boxScope = BoxScopeInstance.INSTANCE;
        int i4 = ((0 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -555003426, "C37@1148L9:IMPageStatus.kt#uu6lp7");
        function2.invoke($composer, Integer.valueOf(($changed >> 6) & 14));
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    /* JADX WARN: Code restructure failed: missing block: B:126:0x0321, code lost:
        if (r3 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x03c4, code lost:
        if (r8 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L107;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void IMPageStatus(final ContentStatus state, boolean isLoggedIn, String emptyText, IMPageStatusAlignmentMethod alignmentMethod, Function2<? super Uri, ? super Continuation<? super Unit>, ? extends Object> function2, Function0<Unit> function0, Composer $composer, final int $changed, final int i2) {
        boolean z;
        String str;
        Function2 onLogin;
        final Function0 onRefresh;
        boolean isLoggedIn2;
        String emptyText2;
        Function2 onLogin2;
        Function0 onRefresh2;
        IMPageStatusAlignmentMethod alignmentMethod2;
        boolean isLoggedIn3;
        String emptyText3;
        IMPageStatusAlignmentMethod alignmentMethod3;
        Function2 onLogin3;
        Function0 factory$iv$iv$iv$iv;
        String emptyText4;
        int i3;
        int i4;
        int i5;
        IMPageStatusAlignmentMethod.CenterWithMinimumPadding alignmentMethod4 = alignmentMethod;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer $composer2 = $composer.startRestartGroup(-936730929);
        ComposerKt.sourceInformation($composer2, "C(IMPageStatus)N(state,isLoggedIn,emptyText,alignmentMethod,onLogin,onRefresh)58@1648L580:IMPageStatus.kt#uu6lp7");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(state) ? 4 : 2;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            $dirty |= 48;
            z = isLoggedIn;
        } else if (($changed & 48) == 0) {
            z = isLoggedIn;
            $dirty |= $composer2.changed(z) ? 32 : 16;
        } else {
            z = isLoggedIn;
        }
        if (($changed & 384) == 0) {
            if ((i2 & 4) == 0) {
                str = emptyText;
                if ($composer2.changed(str)) {
                    i5 = 256;
                    $dirty |= i5;
                }
            } else {
                str = emptyText;
            }
            i5 = 128;
            $dirty |= i5;
        } else {
            str = emptyText;
        }
        if (($changed & 3072) == 0) {
            if ((i2 & 8) == 0) {
                if (($changed & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) == 0 ? $composer2.changed(alignmentMethod4) : $composer2.changedInstance(alignmentMethod4)) {
                    i4 = 2048;
                    $dirty |= i4;
                }
            }
            i4 = 1024;
            $dirty |= i4;
        }
        if (($changed & 24576) == 0) {
            if ((i2 & 16) == 0) {
                onLogin = function2;
                if ($composer2.changedInstance(onLogin)) {
                    i3 = 16384;
                    $dirty |= i3;
                }
            } else {
                onLogin = function2;
            }
            i3 = GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE;
            $dirty |= i3;
        } else {
            onLogin = function2;
        }
        int i7 = i2 & 32;
        if (i7 != 0) {
            $dirty |= 196608;
            onRefresh = function0;
        } else if ((196608 & $changed) == 0) {
            onRefresh = function0;
            $dirty |= $composer2.changedInstance(onRefresh) ? WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT : WXMediaMessage.THUMB_LENGTH_LIMIT;
        } else {
            onRefresh = function0;
        }
        if ($composer2.shouldExecute((74899 & $dirty) != 74898, $dirty & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "53@1402L50,55@1604L2,56@1636L2");
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                isLoggedIn3 = i6 != 0 ? true : z;
                if ((i2 & 4) != 0) {
                    emptyText3 = StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_66(Res.string.INSTANCE), $composer2, 0);
                    $dirty &= -897;
                } else {
                    emptyText3 = str;
                }
                if ((i2 & 8) != 0) {
                    alignmentMethod4 = new IMPageStatusAlignmentMethod.CenterWithMinimumPadding(Dp.constructor-impl(144), null);
                    $dirty &= -7169;
                }
                if ((i2 & 16) != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer2, 1744719057, "CC(remember):IMPageStatus.kt#9igjgp");
                    Object it$iv = $composer2.rememberedValue();
                    if (it$iv == Composer.Companion.getEmpty()) {
                        alignmentMethod3 = alignmentMethod4;
                        Object value$iv = (Function2) new IMPageStatusKt$IMPageStatus$3$1(null);
                        $composer2.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    } else {
                        alignmentMethod3 = alignmentMethod4;
                    }
                    onLogin3 = it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $dirty &= -57345;
                } else {
                    alignmentMethod3 = alignmentMethod4;
                    onLogin3 = onLogin;
                }
                if (i7 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer2, 1744720081, "CC(remember):IMPageStatus.kt#9igjgp");
                    Object it$iv2 = $composer2.rememberedValue();
                    if (it$iv2 == Composer.Companion.getEmpty()) {
                        Object value$iv2 = new Function0() { // from class: im.base.IMPageStatusKt$$ExternalSyntheticLambda0
                            public final Object invoke() {
                                Unit unit;
                                unit = Unit.INSTANCE;
                                return unit;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv2);
                        it$iv2 = value$iv2;
                    }
                    Function0 onRefresh3 = it$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    onLogin = onLogin3;
                    onRefresh = onRefresh3;
                    alignmentMethod4 = alignmentMethod3;
                } else {
                    onLogin = onLogin3;
                    alignmentMethod4 = alignmentMethod3;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i2 & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i2 & 8) != 0) {
                    $dirty &= -7169;
                }
                if ((i2 & 16) != 0) {
                    $dirty &= -57345;
                }
                isLoggedIn3 = z;
                emptyText3 = str;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-936730929, $dirty, -1, "im.base.IMPageStatus (IMPageStatus.kt:57)");
            }
            int $changed$iv = ($dirty >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            IMPageStatusAlignmentMethod alignmentMethod$iv = alignmentMethod4;
            ComposerKt.sourceInformationMarkerStart($composer2, 306470902, "CC(IMPageStatus)N(modifier,alignmentMethod,content)27@898L14,28@917L246:IMPageStatus.kt#uu6lp7");
            Modifier modifier$iv = Modifier.Companion;
            Alignment alignment$iv = alignmentMethod$iv.getAlignment($composer2, ($changed$iv >> 3) & 14);
            IMPageStatusAlignmentMethod alignmentMethod5 = alignmentMethod4;
            Modifier modifier$iv$iv = alignmentMethod$iv.applyModifier(SizeKt.fillMaxSize$default(modifier$iv, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null));
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv$iv = BoxKt.maybeCachedBoxMeasurePolicy(alignment$iv, false);
            int $changed$iv$iv$iv = (0 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv$iv);
            Function0 factory$iv$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv$iv = (($changed$iv$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv$iv = factory$iv$iv$iv$iv2;
                $composer2.createNode(factory$iv$iv$iv$iv);
            } else {
                factory$iv$iv$iv$iv = factory$iv$iv$iv$iv2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv$iv = Updater.constructor-impl($composer2);
            String emptyText5 = emptyText3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv$iv, measurePolicy$iv$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv$iv, localMap$iv$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv$iv, materialized$iv$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i8 = ($changed$iv$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i9 = ((0 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -555003426, "C37@1148L9:IMPageStatus.kt#uu6lp7");
            int i10 = ($changed$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -97908316, "C:IMPageStatus.kt#uu6lp7");
            if (isLoggedIn3) {
                isLoggedIn2 = isLoggedIn3;
                $composer2.startReplaceGroup(-97798112);
                ComposerKt.sourceInformation($composer2, "");
                if (Intrinsics.areEqual(state, IdleContent.INSTANCE)) {
                    $composer2.startReplaceGroup(-97764539);
                    $composer2.endReplaceGroup();
                    emptyText4 = emptyText5;
                } else if (Intrinsics.areEqual(state, LoadingContent.INSTANCE)) {
                    $composer2.startReplaceGroup(-97726316);
                    ComposerKt.sourceInformation($composer2, "67@1926L11");
                    IMStatusKt.IMLoading(null, $composer2, 0, 1);
                    $composer2.endReplaceGroup();
                    emptyText4 = emptyText5;
                } else if (state instanceof ErrorContent) {
                    $composer2.startReplaceGroup(-97637284);
                    ComposerKt.sourceInformation($composer2, "71@2022L59,71@2014L67");
                    ComposerKt.sourceInformationMarkerStart($composer2, -141696010, "CC(remember):IMPageStatus.kt#9igjgp");
                    boolean invalid$iv = (458752 & $dirty) == 131072;
                    Object it$iv3 = $composer2.rememberedValue();
                    if (invalid$iv) {
                    }
                    Object value$iv3 = new Function0() { // from class: im.base.IMPageStatusKt$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            Unit IMPageStatus$lambda$4$1$0;
                            IMPageStatus$lambda$4$1$0 = IMPageStatusKt.IMPageStatus$lambda$4$1$0(onRefresh);
                            return IMPageStatus$lambda$4$1$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    IMStatusKt.IMError(null, false, (Function0) it$iv3, $composer2, 0, 3);
                    $composer2.endReplaceGroup();
                    emptyText4 = emptyText5;
                } else if (!Intrinsics.areEqual(state, EmptyContent.INSTANCE)) {
                    $composer2.startReplaceGroup(-141702110);
                    $composer2.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                } else {
                    $composer2.startReplaceGroup(-97498714);
                    ComposerKt.sourceInformation($composer2, "77@2155L25");
                    emptyText4 = emptyText5;
                    IMStatusKt.IMEmpty(null, emptyText4, $composer2, ($dirty >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW, 1);
                    $composer2.endReplaceGroup();
                }
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(-97905031);
                ComposerKt.sourceInformation($composer2, "60@1748L43,60@1737L54");
                ComposerKt.sourceInformationMarkerStart($composer2, -141704794, "CC(remember):IMPageStatus.kt#9igjgp");
                boolean invalid$iv2 = $composer2.changedInstance(onLogin);
                isLoggedIn2 = isLoggedIn3;
                Object it$iv4 = $composer2.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv4 = (Function2) new IMPageStatusKt$IMPageStatus$5$1$1(onLogin, null);
                $composer2.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                IMStatusKt.IMNotLogin(null, (Function2) it$iv4, $composer2, 0, 1);
                $composer2.endReplaceGroup();
                emptyText4 = emptyText5;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            emptyText2 = emptyText4;
            onLogin2 = onLogin;
            onRefresh2 = onRefresh;
            alignmentMethod2 = alignmentMethod5;
        } else {
            $composer2.skipToGroupEnd();
            isLoggedIn2 = z;
            emptyText2 = str;
            onLogin2 = onLogin;
            onRefresh2 = onRefresh;
            alignmentMethod2 = alignmentMethod4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final boolean z2 = isLoggedIn2;
            final String str2 = emptyText2;
            final IMPageStatusAlignmentMethod iMPageStatusAlignmentMethod = alignmentMethod2;
            final Function2 function22 = onLogin2;
            final Function0 function02 = onRefresh2;
            endRestartGroup.updateScope(new Function2() { // from class: im.base.IMPageStatusKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMPageStatus$lambda$5;
                    IMPageStatus$lambda$5 = IMPageStatusKt.IMPageStatus$lambda$5(ContentStatus.this, z2, str2, iMPageStatusAlignmentMethod, function22, function02, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return IMPageStatus$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMPageStatus$lambda$4$1$0(Function0 $onRefresh) {
        $onRefresh.invoke();
        return Unit.INSTANCE;
    }
}