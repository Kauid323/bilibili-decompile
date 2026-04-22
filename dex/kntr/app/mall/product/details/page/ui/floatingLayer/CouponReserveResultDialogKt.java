package kntr.app.mall.product.details.page.ui.floatingLayer;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.mall.product.details.page.api.CouponListResponse;
import kntr.app.mall.product.details.page.api.ReserveApiService;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.mall.product.details.page.ui.scale.UiScaleModel;
import kntr.app.mall.product.details.page.utils.DateFormatKt;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.mall.product.details.page.vm.PageViewModelWrapper;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.edit.MediaAttrUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CouponReserveResultDialog.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001a'\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0001¢\u0006\u0002\u0010\u0010\u001a\u0017\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0000¢\u0006\u0002\u0010\u0014\u001a\u0012\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0000¨\u0006\u0018²\u0006\n\u0010\f\u001a\u00020\rX\u008a\u0084\u0002²\u0006\f\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u008a\u0084\u0002"}, d2 = {"CouponReserveResultDialog", "", "show", "", "onDismissRequest", "Lkotlin/Function0;", "pageViewModelWrapper", "Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;", "(ZLkotlin/jvm/functions/Function0;Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;Landroidx/compose/runtime/Composer;I)V", "CouponTagComponent", "text", "", "scaleModel", "Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "parseDiscountPrice", "discountY", "", "(Ljava/lang/Double;)Ljava/lang/String;", "parseCouponTimeString", "coupon", "Lkntr/app/mall/product/details/page/api/CouponListResponse$CouponListItem;", "product-details-page_debug", "reserveCouponResult", "Lkntr/app/mall/product/details/page/api/ReserveApiService$ReserveResultResponse$ReserveResultData;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class CouponReserveResultDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CouponReserveResultDialog$lambda$0(boolean z, Function0 function0, PageViewModelWrapper pageViewModelWrapper, int i, Composer composer, int i2) {
        CouponReserveResultDialog(z, function0, pageViewModelWrapper, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CouponReserveResultDialog$lambda$4(boolean z, Function0 function0, PageViewModelWrapper pageViewModelWrapper, int i, Composer composer, int i2) {
        CouponReserveResultDialog(z, function0, pageViewModelWrapper, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CouponTagComponent$lambda$1(String str, UiScaleModel uiScaleModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        CouponTagComponent(str, uiScaleModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x0103, code lost:
        if (((r19 == null || (r1 = r19.getCouponType()) == null || r1.intValue() != 1) ? false : true) != false) goto L88;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void CouponReserveResultDialog(final boolean show, final Function0<Unit> function0, final PageViewModelWrapper pageViewModelWrapper, Composer $composer, final int $changed) {
        Composer $composer2;
        final String priceText;
        Integer couponType;
        Integer couponType2;
        Intrinsics.checkNotNullParameter(function0, "onDismissRequest");
        Intrinsics.checkNotNullParameter(pageViewModelWrapper, "pageViewModelWrapper");
        Composer $composer3 = $composer.startRestartGroup(1616781615);
        ComposerKt.sourceInformation($composer3, "C(CouponReserveResultDialog)N(show,onDismissRequest,pageViewModelWrapper)53@2417L16,54@2499L16,73@3088L10639,71@3029L10698:CouponReserveResultDialog.kt#j7uxph");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(show) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(pageViewModelWrapper) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        boolean z = false;
        if ($composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1616781615, $dirty2, -1, "kntr.app.mall.product.details.page.ui.floatingLayer.CouponReserveResultDialog (CouponReserveResultDialog.kt:50)");
            }
            PageViewModel pageViewModel = pageViewModelWrapper.getViewModel();
            if (show) {
                final State scaleModel$delegate = SnapshotStateKt.collectAsState(pageViewModel.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer3, 0, 1);
                State reserveCouponResult$delegate = SnapshotStateKt.collectAsState(pageViewModel.getReserveCouponResult(), (CoroutineContext) null, $composer3, 0, 1);
                ReserveApiService.ReserveResultResponse.ReserveResultData CouponReserveResultDialog$lambda$2 = CouponReserveResultDialog$lambda$2(reserveCouponResult$delegate);
                String resultText = CouponReserveResultDialog$lambda$2 != null ? CouponReserveResultDialog$lambda$2.getResultText() : null;
                if (resultText == null) {
                    resultText = "";
                }
                final String resultText2 = resultText;
                ReserveApiService.ReserveResultResponse.ReserveResultData CouponReserveResultDialog$lambda$22 = CouponReserveResultDialog$lambda$2(reserveCouponResult$delegate);
                final CouponListResponse.CouponListItem coupon = CouponReserveResultDialog$lambda$22 != null ? CouponReserveResultDialog$lambda$22.getCouponInfoDTO() : null;
                if (!((coupon == null || (couponType2 = coupon.getCouponType()) == null || couponType2.intValue() != 5) ? false : true)) {
                    if (!((coupon == null || (couponType = coupon.getCouponType()) == null || couponType.intValue() != 6) ? false : true)) {
                    }
                }
                z = true;
                final boolean isDiscountPrice = z;
                if (isDiscountPrice) {
                    priceText = parseDiscountPrice(coupon.getDiscountY());
                } else {
                    priceText = String.valueOf(coupon != null ? coupon.getDiscountY() : null);
                }
                $composer2 = $composer3;
                AndroidDialog_androidKt.Dialog(function0, (DialogProperties) null, ComposableLambdaKt.rememberComposableLambda(-469561722, true, new Function2() { // from class: kntr.app.mall.product.details.page.ui.floatingLayer.CouponReserveResultDialogKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj, Object obj2) {
                        Unit CouponReserveResultDialog$lambda$3;
                        CouponReserveResultDialog$lambda$3 = CouponReserveResultDialogKt.CouponReserveResultDialog$lambda$3(scaleModel$delegate, function0, resultText2, isDiscountPrice, priceText, coupon, r7, r8, (Composer) obj, ((Integer) obj2).intValue());
                        return CouponReserveResultDialog$lambda$3;
                    }
                }, $composer3, 54), $composer3, (($dirty2 >> 3) & 14) | 384, 2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.floatingLayer.CouponReserveResultDialogKt$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj, Object obj2) {
                            Unit CouponReserveResultDialog$lambda$0;
                            CouponReserveResultDialog$lambda$0 = CouponReserveResultDialogKt.CouponReserveResultDialog$lambda$0(show, function0, pageViewModelWrapper, $changed, (Composer) obj, ((Integer) obj2).intValue());
                            return CouponReserveResultDialog$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.floatingLayer.CouponReserveResultDialogKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit CouponReserveResultDialog$lambda$4;
                    CouponReserveResultDialog$lambda$4 = CouponReserveResultDialogKt.CouponReserveResultDialog$lambda$4(show, function0, pageViewModelWrapper, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return CouponReserveResultDialog$lambda$4;
                }
            });
        }
    }

    private static final UiScaleModel CouponReserveResultDialog$lambda$1(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    private static final ReserveApiService.ReserveResultResponse.ReserveResultData CouponReserveResultDialog$lambda$2(State<ReserveApiService.ReserveResultResponse.ReserveResultData> state) {
        Object thisObj$iv = state.getValue();
        return (ReserveApiService.ReserveResultResponse.ReserveResultData) thisObj$iv;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: SSATransform
        java.lang.IndexOutOfBoundsException: bitIndex < 0: -18
        	at java.util.BitSet.get(BitSet.java:623)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.fillBasicBlockInfo(LiveVarAnalysis.java:65)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.runAnalysis(LiveVarAnalysis.java:36)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:55)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
        */
    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit CouponReserveResultDialog$lambda$3(androidx.compose.runtime.State r235, kotlin.jvm.functions.Function0 r236, java.lang.String r237, boolean r238, java.lang.String r239, kntr.app.mall.product.details.page.api.CouponListResponse.CouponListItem r240, java.lang.String r241, java.lang.String r242, androidx.compose.runtime.Composer r243, int r244) {
        /*
            Method dump skipped, instructions count: 6207
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.product.details.page.ui.floatingLayer.CouponReserveResultDialogKt.CouponReserveResultDialog$lambda$3(androidx.compose.runtime.State, kotlin.jvm.functions.Function0, java.lang.String, boolean, java.lang.String, kntr.app.mall.product.details.page.api.CouponListResponse$CouponListItem, java.lang.String, java.lang.String, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CouponReserveResultDialog$lambda$3$0$0$0$0(Function0 $onDismissRequest) {
        $onDismissRequest.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CouponReserveResultDialog$lambda$3$0$1$3$0(Function0 $onDismissRequest) {
        $onDismissRequest.invoke();
        return Unit.INSTANCE;
    }

    public static final void CouponTagComponent(final String text, final UiScaleModel scaleModel, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(scaleModel, "scaleModel");
        Composer $composer3 = $composer.startRestartGroup(-1255562822);
        ComposerKt.sourceInformation($composer3, "C(CouponTagComponent)N(text,scaleModel,modifier)297@13867L651:CouponReserveResultDialog.kt#j7uxph");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(text) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(scaleModel) ? 32 : 16;
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
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1255562822, $dirty2, -1, "kntr.app.mall.product.details.page.ui.floatingLayer.CouponTagComponent (CouponReserveResultDialog.kt:296)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(BorderKt.border-xT4_qwU$default(SizeKt.height-3ABfNKs(PaddingKt.padding-qDBjuR0$default(modifier3, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(6, scaleModel.getScale()), 0.0f, 11, (Object) null), ProvideUiScaleKt.dpScaled(15, scaleModel.getScale())), ProvideUiScaleKt.dpScaled(0.5d, scaleModel.getScale()), ColorKt.Color(4294923911L), (Shape) null, 4, (Object) null), ProvideUiScaleKt.dpScaled(2, scaleModel.getScale()), 0.0f, 2, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv);
            } else {
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
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i4 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1489351278, "C311@14391L9,308@14291L221:CouponReserveResultDialog.kt#j7uxph");
            $composer2 = $composer3;
            TextKt.Text-Nvy7gAk(text, (Modifier) null, ColorKt.Color(4294923911L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT10(), scaleModel.getScale()), $composer3, ($dirty2 & 14) | 384, 24960, 110586);
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
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.floatingLayer.CouponReserveResultDialogKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CouponTagComponent$lambda$1;
                    CouponTagComponent$lambda$1 = CouponReserveResultDialogKt.CouponTagComponent$lambda$1(text, scaleModel, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CouponTagComponent$lambda$1;
                }
            });
        }
    }

    public static final String parseDiscountPrice(Double discountY) {
        if (discountY != null) {
            double roundedValue = ((int) (discountY.doubleValue() * 10)) / 10.0d;
            int intValue = (int) roundedValue;
            if (roundedValue == ((double) intValue)) {
                return String.valueOf(intValue);
            }
            return String.valueOf(roundedValue);
        }
        return "未知";
    }

    public static final String parseCouponTimeString(CouponListResponse.CouponListItem coupon) {
        Integer useEndTime;
        String unit;
        if (coupon == null) {
            return "";
        }
        Integer useEffectDays = coupon.getUseEffectDays();
        if ((useEffectDays != null ? useEffectDays.intValue() : 0) > 0) {
            Integer useEffectUnit = coupon.getUseEffectUnit();
            if (useEffectUnit != null && useEffectUnit.intValue() == 1) {
                unit = "周";
            } else if (useEffectUnit != null && useEffectUnit.intValue() == 2) {
                unit = "个月";
            } else {
                unit = (useEffectUnit != null && useEffectUnit.intValue() == 3) ? "年" : "天";
            }
            return "使用有效期:领取后" + coupon.getUseEffectDays() + unit + "内";
        }
        Integer useStartTime = coupon.getUseStartTime();
        int intValue = useStartTime != null ? useStartTime.intValue() : 0;
        long j = (long) MediaAttrUtils.TYPE_PAY_SEASON;
        long startTime = intValue * j;
        long endTime = j * (coupon.getUseEndTime() != null ? useEndTime.intValue() : 0);
        String startTimeText = DateFormatKt.formatPatternTimestamp$default(startTime, "yyyy.MM.dd", null, 4, null);
        String endTimeText = DateFormatKt.formatPatternTimestamp$default(endTime, "yyyy.MM.dd", null, 4, null);
        String str = startTimeText + "-" + endTimeText;
        return str;
    }
}