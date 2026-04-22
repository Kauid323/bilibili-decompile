package kntr.app.deepsearch.ui.cards;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.pager.PageSize;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.bapis.bilibili.broadcast.message.deepsearch.KPictureCard;
import com.bapis.bilibili.broadcast.message.deepsearch.KPictureCardItem;
import com.bilibili.compose.theme.BiliTheme;
import java.util.Map;
import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.base.model.biz.PicRect;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.router.Router;
import kntr.common.compose.res.TVPlaceHolderKt;
import kntr.common.router.RouterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: Picture.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\u001aM\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000e\u001aC\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\u0010\u001aC\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\u0010\u001a\u0083\u0001\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\r2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0003¢\u0006\u0002\u0010\u001e\u001a\u0017\u0010\u001f\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010 ¨\u0006!²\u0006\n\u0010\"\u001a\u00020\u0016X\u008a\u008e\u0002²\u0006\n\u0010#\u001a\u00020\rX\u008a\u008e\u0002"}, d2 = {"Picture", RoomRecommendViewModel.EMPTY_CURSOR, "pic", "Lcom/bapis/bilibili/broadcast/message/deepsearch/KPictureCard;", "dispatcher", "Lkotlin/Function1;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", "sessionId", RoomRecommendViewModel.EMPTY_CURSOR, "queryId", "modifier", "Landroidx/compose/ui/Modifier;", "embed", RoomRecommendViewModel.EMPTY_CURSOR, "(Lcom/bapis/bilibili/broadcast/message/deepsearch/KPictureCard;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;II)V", "HighlightFrame", "(Lcom/bapis/bilibili/broadcast/message/deepsearch/KPictureCard;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ReplyPictures", "Pic", "item", "Lcom/bapis/bilibili/broadcast/message/deepsearch/KPictureCardItem;", "index", RoomRecommendViewModel.EMPTY_CURSOR, "size", "showMoreTag", "rect", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/deepsearch/base/model/biz/PicRect;", "ratio", RoomRecommendViewModel.EMPTY_CURSOR, "(Lcom/bapis/bilibili/broadcast/message/deepsearch/KPictureCard;Lcom/bapis/bilibili/broadcast/message/deepsearch/KPictureCardItem;IIZLjava/util/Map;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;FLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "Placeholder", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "compose_debug", "picWidth", "clicked"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PictureKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HighlightFrame$lambda$3(KPictureCard kPictureCard, Function1 function1, String str, String str2, Modifier modifier, int i, int i2, Composer composer, int i3) {
        HighlightFrame(kPictureCard, function1, str, str2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Pic$lambda$6(KPictureCard kPictureCard, KPictureCardItem kPictureCardItem, int i, int i2, boolean z, Map map, String str, String str2, Modifier modifier, float f, Function1 function1, int i3, int i4, int i5, Composer composer, int i6) {
        Pic(kPictureCard, kPictureCardItem, i, i2, z, map, str, str2, modifier, f, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Picture$lambda$0(KPictureCard kPictureCard, Function1 function1, String str, String str2, Modifier modifier, boolean z, int i, int i2, Composer composer, int i3) {
        Picture(kPictureCard, function1, str, str2, modifier, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Placeholder$lambda$0(Modifier modifier, int i, int i2, Composer composer, int i3) {
        Placeholder(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReplyPictures$lambda$2(KPictureCard kPictureCard, Function1 function1, String str, String str2, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ReplyPictures(kPictureCard, function1, str, str2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void Picture(final KPictureCard pic, final Function1<? super DeepSearchAction, Unit> function1, final String sessionId, final String queryId, Modifier modifier, boolean embed, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        Modifier modifier3;
        boolean embed2;
        Modifier modifier4;
        Intrinsics.checkNotNullParameter(pic, "pic");
        Intrinsics.checkNotNullParameter(function1, "dispatcher");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(queryId, "queryId");
        Composer $composer2 = $composer.startRestartGroup(-2123341730);
        ComposerKt.sourceInformation($composer2, "C(Picture)N(pic,dispatcher,sessionId,queryId,modifier,embed):Picture.kt#pp6rt");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(pic) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(sessionId) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(queryId) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 32;
        if (i3 != 0) {
            $dirty |= 196608;
            z = embed;
        } else if ((196608 & $changed) == 0) {
            z = embed;
            $dirty |= $composer2.changed(z) ? 131072 : 65536;
        } else {
            z = embed;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute((74899 & $dirty2) != 74898, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            embed2 = z;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                embed2 = z;
            } else {
                embed2 = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2123341730, $dirty2, -1, "kntr.app.deepsearch.ui.cards.Picture (Picture.kt:72)");
            }
            if (pic.getItems().isEmpty()) {
                $composer2.startReplaceGroup(-198069340);
            } else {
                $composer2.startReplaceGroup(-194910068);
                ComposerKt.sourceInformation($composer2, RoomRecommendViewModel.EMPTY_CURSOR);
                if (Intrinsics.areEqual(pic.getSource(), KPictureCard.KSource.VIDEO.INSTANCE)) {
                    $composer2.startReplaceGroup(-194863537);
                    ComposerKt.sourceInformation($composer2, "75@3242L61");
                    HighlightFrame(pic, function1, sessionId, queryId, modifier4, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896) | ($dirty2 & 7168) | (57344 & $dirty2), 0);
                    $composer2.endReplaceGroup();
                } else {
                    $composer2.startReplaceGroup(-194768987);
                    ComposerKt.sourceInformation($composer2, "77@3333L199");
                    ReplyPictures(pic, function1, sessionId, queryId, PaddingKt.padding-qDBjuR0$default(modifier4, embed2 ? Dp.constructor-impl(31) : Dp.constructor-impl(0), 0.0f, 0.0f, 0.0f, 14, (Object) null), $composer2, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896) | ($dirty2 & 7168), 0);
                    $composer2.endReplaceGroup();
                }
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final boolean z2 = embed2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.ui.cards.PictureKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit Picture$lambda$0;
                    Picture$lambda$0 = PictureKt.Picture$lambda$0(pic, function1, sessionId, queryId, modifier5, z2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Picture$lambda$0;
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x028e, code lost:
        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L68;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void HighlightFrame(final KPictureCard pic, final Function1<? super DeepSearchAction, Unit> function1, final String sessionId, final String queryId, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Composer $composer3 = $composer.startRestartGroup(1082510137);
        ComposerKt.sourceInformation($composer3, "C(HighlightFrame)N(pic,dispatcher,sessionId,queryId,modifier)96@3760L51:Picture.kt#pp6rt");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(pic) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(sessionId) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(queryId) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1082510137, $dirty2, -1, "kntr.app.deepsearch.ui.cards.HighlightFrame (Picture.kt:95)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 910162092, "CC(remember):Picture.kt#9igjgp");
            boolean invalid$iv = $composer3.changed(pic);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateMapOf();
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final Map map = (SnapshotStateMap) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (pic.getItems().size() > 1) {
                $composer3.startReplaceGroup(-1849515454);
                ComposerKt.sourceInformation($composer3, "98@3890L4879,98@3850L4919");
                BoxWithConstraintsKt.BoxWithConstraints(modifier4, (Alignment) null, false, ComposableLambdaKt.rememberComposableLambda(669446696, true, new Function3() { // from class: kntr.app.deepsearch.ui.cards.PictureKt$$ExternalSyntheticLambda11
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit HighlightFrame$lambda$1;
                        HighlightFrame$lambda$1 = PictureKt.HighlightFrame$lambda$1(pic, map, sessionId, queryId, function1, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return HighlightFrame$lambda$1;
                    }
                }, $composer3, 54), $composer3, (($dirty2 >> 12) & 14) | 3072, 6);
                $composer3.endReplaceGroup();
                modifier3 = modifier4;
                $composer2 = $composer3;
            } else if (pic.getItems().size() == 1) {
                $composer3.startReplaceGroup(-1844713337);
                ComposerKt.sourceInformation($composer3, "210@8816L914");
                Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), Dp.constructor-impl(12), 0.0f, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    factory$iv$iv$iv = factory$iv$iv$iv2;
                    $composer3.createNode(factory$iv$iv$iv);
                } else {
                    factory$iv$iv$iv = factory$iv$iv$iv2;
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
                int i4 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -1135348244, "C227@9381L249,215@8944L776:Picture.kt#pp6rt");
                KPictureCardItem kPictureCardItem = (KPictureCardItem) CollectionsKt.firstOrNull(pic.getItems());
                Map map2 = map;
                Modifier modifier5 = SizeKt.widthIn-VpY3zN4(Modifier.Companion, Dp.constructor-impl(0), Dp.constructor-impl(440));
                ComposerKt.sourceInformationMarkerStart($composer3, -36610680, "CC(remember):Picture.kt#9igjgp");
                boolean invalid$iv2 = $composer3.changed(map);
                Object it$iv2 = $composer3.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv2 = new Function1() { // from class: kntr.app.deepsearch.ui.cards.PictureKt$$ExternalSyntheticLambda12
                    public final Object invoke(Object obj) {
                        Unit HighlightFrame$lambda$2$0$0;
                        HighlightFrame$lambda$2$0$0 = PictureKt.HighlightFrame$lambda$2$0$0(map, (LayoutCoordinates) obj);
                        return HighlightFrame$lambda$2$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                modifier3 = modifier4;
                Pic(pic, kPictureCardItem, 0, 1, false, map2, sessionId, queryId, OnGloballyPositionedModifierKt.onGloballyPositioned(modifier5, (Function1) it$iv2), 1.7777778f, function1, $composer3, ($dirty2 & 14) | 805334400 | (($dirty2 << 12) & 3670016) | (29360128 & ($dirty2 << 12)), ($dirty2 >> 3) & 14, 0);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endReplaceGroup();
                $composer2 = $composer3;
            } else {
                modifier3 = modifier4;
                $composer2 = $composer3;
                $composer2.startReplaceGroup(-1853478711);
                $composer2.endReplaceGroup();
            }
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
            final Modifier modifier6 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.ui.cards.PictureKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj, Object obj2) {
                    Unit HighlightFrame$lambda$3;
                    HighlightFrame$lambda$3 = PictureKt.HighlightFrame$lambda$3(pic, function1, sessionId, queryId, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return HighlightFrame$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x02f5, code lost:
        if (r11 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0338  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit HighlightFrame$lambda$1(final KPictureCard $pic, final SnapshotStateMap $picRect, final String $sessionId, final String $queryId, final Function1 $dispatcher, BoxWithConstraintsScope $this$BoxWithConstraints, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 value$iv;
        Object it$iv;
        Object it$iv2;
        Object value$iv2;
        boolean invalid$iv;
        Intrinsics.checkNotNullParameter($this$BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation($composer, "C99@3904L4855:Picture.kt#pp6rt");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(669446696, $changed, -1, "kntr.app.deepsearch.ui.cards.HighlightFrame.<anonymous> (Picture.kt:99)");
            }
            Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(10));
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((54 >> 3) & 14) | ((54 >> 3) & 112));
            int $changed$iv$iv = (54 << 3) & 112;
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
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((54 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1585848666, "C103@4098L18,103@4079L37,105@4150L33,116@4585L701,130@5306L1026,107@4201L2131,155@6377L6,156@6433L6,157@6518L2227,157@6462L2283:Picture.kt#pp6rt");
            ComposerKt.sourceInformationMarkerStart($composer, 1749955396, "CC(remember):Picture.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance($pic);
            Object it$iv3 = $composer.rememberedValue();
            if (!invalid$iv2 && it$iv3 != Composer.Companion.getEmpty()) {
                value$iv = it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer);
                final PagerState pagerState = PagerStateKt.rememberPagerState(0, 0.0f, value$iv, $composer, 0, 3);
                ComposerKt.sourceInformationMarkerStart($composer, 1749957075, "CC(remember):Picture.kt#9igjgp");
                it$iv = $composer.rememberedValue();
                if (it$iv != Composer.Companion.getEmpty()) {
                    Object mutableIntStateOf = SnapshotIntStateKt.mutableIntStateOf(0);
                    $composer.updateRememberedValue(mutableIntStateOf);
                    it$iv2 = mutableIntStateOf;
                } else {
                    it$iv2 = it$iv;
                }
                final MutableIntState picWidth$delegate = (MutableIntState) it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, 0.0f, 0.0f, 14, (Object) null), 0.0f, 1, (Object) null);
                PaddingValues paddingValues = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(0), 0.0f, 2, (Object) null);
                float f = Dp.constructor-impl(4);
                ComposerKt.sourceInformationMarkerStart($composer, 1749971663, "CC(remember):Picture.kt#9igjgp");
                value$iv2 = $composer.rememberedValue();
                if (value$iv2 != Composer.Companion.getEmpty()) {
                    value$iv2 = new PageSize() { // from class: kntr.app.deepsearch.ui.cards.PictureKt$HighlightFrame$1$1$1$1
                        public int calculateMainAxisPageSize(Density $this$calculateMainAxisPageSize, int availableSpace, int pageSpacing) {
                            Intrinsics.checkNotNullParameter($this$calculateMainAxisPageSize, "<this>");
                            int $this$calculateMainAxisPageSize_u24lambda_u240 = MathKt.roundToInt(RangesKt.coerceAtMost((availableSpace - (pageSpacing * 2)) * 0.85f, $this$calculateMainAxisPageSize.toPx-0680j_4(Dp.constructor-impl(440))));
                            picWidth$delegate.setIntValue($this$calculateMainAxisPageSize_u24lambda_u240);
                            return $this$calculateMainAxisPageSize_u24lambda_u240;
                        }
                    };
                    $composer.updateRememberedValue(value$iv2);
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                PagerKt.HorizontalPager--8jOkeI(pagerState, fillMaxWidth$default, paddingValues, (PictureKt$HighlightFrame$1$1$1$1) value$iv2, 0, f, (Alignment.Vertical) null, (TargetedFlingBehavior) null, false, false, (Function1) null, (NestedScrollConnection) null, (SnapPosition) null, (OverscrollEffect) null, ComposableLambdaKt.rememberComposableLambda(1292138321, true, new Function4() { // from class: kntr.app.deepsearch.ui.cards.PictureKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        Unit HighlightFrame$lambda$1$0$5;
                        HighlightFrame$lambda$1$0$5 = PictureKt.HighlightFrame$lambda$1$0$5($pic, $picRect, $sessionId, $queryId, $dispatcher, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                        return HighlightFrame$lambda$1$0$5;
                    }
                }, $composer, 54), $composer, 200112, 24576, 16336);
                final long totalColor = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText4-0d7_KjU();
                final long stateColor = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText2-0d7_KjU();
                Modifier modifier = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(2));
                ComposerKt.sourceInformationMarkerStart($composer, 1750035045, "CC(remember):Picture.kt#9igjgp");
                invalid$iv = $composer.changed(totalColor) | $composer.changed(pagerState) | $composer.changed(stateColor);
                Object it$iv4 = $composer.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv3 = new Function1() { // from class: kntr.app.deepsearch.ui.cards.PictureKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        Unit HighlightFrame$lambda$1$0$6$0;
                        HighlightFrame$lambda$1$0$6$0 = PictureKt.HighlightFrame$lambda$1$0$6$0(totalColor, pagerState, stateColor, picWidth$delegate, (DrawScope) obj);
                        return HighlightFrame$lambda$1$0$6$0;
                    }
                };
                $composer.updateRememberedValue(value$iv3);
                it$iv4 = value$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer);
                CanvasKt.Canvas(modifier, (Function1) it$iv4, $composer, 6);
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
            value$iv = new Function0() { // from class: kntr.app.deepsearch.ui.cards.PictureKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    int HighlightFrame$lambda$1$0$0$0;
                    HighlightFrame$lambda$1$0$0$0 = PictureKt.HighlightFrame$lambda$1$0$0$0($pic);
                    return Integer.valueOf(HighlightFrame$lambda$1$0$0$0);
                }
            };
            $composer.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            final PagerState pagerState2 = PagerStateKt.rememberPagerState(0, 0.0f, value$iv, $composer, 0, 3);
            ComposerKt.sourceInformationMarkerStart($composer, 1749957075, "CC(remember):Picture.kt#9igjgp");
            it$iv = $composer.rememberedValue();
            if (it$iv != Composer.Companion.getEmpty()) {
            }
            final MutableIntState picWidth$delegate2 = (MutableIntState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, 0.0f, 0.0f, 14, (Object) null), 0.0f, 1, (Object) null);
            PaddingValues paddingValues2 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(0), 0.0f, 2, (Object) null);
            float f2 = Dp.constructor-impl(4);
            ComposerKt.sourceInformationMarkerStart($composer, 1749971663, "CC(remember):Picture.kt#9igjgp");
            value$iv2 = $composer.rememberedValue();
            if (value$iv2 != Composer.Companion.getEmpty()) {
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            PagerKt.HorizontalPager--8jOkeI(pagerState2, fillMaxWidth$default2, paddingValues2, (PictureKt$HighlightFrame$1$1$1$1) value$iv2, 0, f2, (Alignment.Vertical) null, (TargetedFlingBehavior) null, false, false, (Function1) null, (NestedScrollConnection) null, (SnapPosition) null, (OverscrollEffect) null, ComposableLambdaKt.rememberComposableLambda(1292138321, true, new Function4() { // from class: kntr.app.deepsearch.ui.cards.PictureKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit HighlightFrame$lambda$1$0$5;
                    HighlightFrame$lambda$1$0$5 = PictureKt.HighlightFrame$lambda$1$0$5($pic, $picRect, $sessionId, $queryId, $dispatcher, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                    return HighlightFrame$lambda$1$0$5;
                }
            }, $composer, 54), $composer, 200112, 24576, 16336);
            final long totalColor2 = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText4-0d7_KjU();
            final long stateColor2 = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText2-0d7_KjU();
            Modifier modifier2 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(2));
            ComposerKt.sourceInformationMarkerStart($composer, 1750035045, "CC(remember):Picture.kt#9igjgp");
            invalid$iv = $composer.changed(totalColor2) | $composer.changed(pagerState2) | $composer.changed(stateColor2);
            Object it$iv42 = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv32 = new Function1() { // from class: kntr.app.deepsearch.ui.cards.PictureKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    Unit HighlightFrame$lambda$1$0$6$0;
                    HighlightFrame$lambda$1$0$6$0 = PictureKt.HighlightFrame$lambda$1$0$6$0(totalColor2, pagerState2, stateColor2, picWidth$delegate2, (DrawScope) obj);
                    return HighlightFrame$lambda$1$0$6$0;
                }
            };
            $composer.updateRememberedValue(value$iv32);
            it$iv42 = value$iv32;
            ComposerKt.sourceInformationMarkerEnd($composer);
            CanvasKt.Canvas(modifier2, (Function1) it$iv42, $composer, 6);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int HighlightFrame$lambda$1$0$0$0(KPictureCard $pic) {
        return $pic.getItems().size();
    }

    private static final int HighlightFrame$lambda$1$0$2(MutableIntState $picWidth$delegate) {
        IntState $this$getValue$iv = (IntState) $picWidth$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HighlightFrame$lambda$1$0$5(KPictureCard $pic, final SnapshotStateMap $picRect, String $sessionId, String $queryId, Function1 $dispatcher, PagerScope $this$HorizontalPager, final int index, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$HorizontalPager, "$this$HorizontalPager");
        ComposerKt.sourceInformation($composer, "CN(index)144@5907L293,132@5395L919:Picture.kt#pp6rt");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1292138321, $changed, -1, "kntr.app.deepsearch.ui.cards.HighlightFrame.<anonymous>.<anonymous>.<anonymous> (Picture.kt:131)");
        }
        KPictureCardItem item = (KPictureCardItem) CollectionsKt.getOrNull($pic.getItems(), index);
        int size = $pic.getItems().size();
        Map map = (Map) $picRect;
        boolean z = true;
        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
        ComposerKt.sourceInformationMarkerStart($composer, 499397462, "CC(remember):Picture.kt#9igjgp");
        boolean changed = $composer.changed($picRect);
        if (((($changed & 112) ^ 48) <= 32 || !$composer.changed(index)) && ($changed & 48) != 32) {
            z = false;
        }
        boolean invalid$iv = changed | z;
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function1() { // from class: kntr.app.deepsearch.ui.cards.PictureKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj) {
                    Unit HighlightFrame$lambda$1$0$5$0$0;
                    HighlightFrame$lambda$1$0$5$0$0 = PictureKt.HighlightFrame$lambda$1$0$5$0$0($picRect, index, (LayoutCoordinates) obj);
                    return HighlightFrame$lambda$1$0$5$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        Pic($pic, item, index, size, false, map, $sessionId, $queryId, OnGloballyPositionedModifierKt.onGloballyPositioned(fillMaxWidth$default, (Function1) it$iv), 1.7777778f, $dispatcher, $composer, (($changed << 3) & 896) | 805330944, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HighlightFrame$lambda$1$0$5$0$0(SnapshotStateMap $picRect, int $index, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Rect rec = LayoutCoordinatesKt.boundsInWindow$default(it, false, 1, (Object) null);
        ((Map) $picRect).put(Integer.valueOf($index), new PicRect(rec.getLeft(), rec.getTop(), rec.getRight(), rec.getBottom()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HighlightFrame$lambda$1$0$6$0(long $totalColor, PagerState $pagerState, long $stateColor, MutableIntState $picWidth$delegate, DrawScope $this$Canvas) {
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        int bits$iv$iv$iv = (int) ($this$Canvas.getCenter-F1C5BW0() >> 32);
        float start0 = Float.intBitsToFloat(bits$iv$iv$iv) - $this$Canvas.toPx-0680j_4(Dp.constructor-impl(15));
        float totalIndicatorWidth = $this$Canvas.toPx-0680j_4(Dp.constructor-impl(30));
        int bits$iv$iv$iv2 = (int) ($this$Canvas.getCenter-F1C5BW0() & 4294967295L);
        float y$iv = Float.intBitsToFloat(bits$iv$iv$iv2) - $this$Canvas.toPx-0680j_4(Dp.constructor-impl(1));
        long v1$iv$iv = Float.floatToRawIntBits(start0);
        long v2$iv$iv = Float.floatToRawIntBits(y$iv);
        long j2 = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
        float height$iv = $this$Canvas.toPx-0680j_4(Dp.constructor-impl(2));
        long v1$iv$iv2 = Float.floatToRawIntBits(totalIndicatorWidth);
        long v2$iv$iv2 = Float.floatToRawIntBits(height$iv);
        long j3 = Size.constructor-impl((v1$iv$iv2 << 32) | (v2$iv$iv2 & 4294967295L));
        float x$iv = $this$Canvas.toPx-0680j_4(Dp.constructor-impl(1));
        float y$iv2 = $this$Canvas.toPx-0680j_4(Dp.constructor-impl(1));
        long v1$iv$iv3 = Float.floatToRawIntBits(x$iv);
        long v2$iv$iv3 = Float.floatToRawIntBits(y$iv2);
        DrawScope.-CC.drawRoundRect-u-Aw5IA$default($this$Canvas, $totalColor, j2, j3, CornerRadius.constructor-impl((v1$iv$iv3 << 32) | (v2$iv$iv3 & 4294967295L)), (DrawStyle) null, 0.0f, (ColorFilter) null, 0, 240, (Object) null);
        int picCnt = $pagerState.getPageCount();
        float picSpacing = $this$Canvas.toPx-0680j_4(Dp.constructor-impl(8));
        float maxValue = RangesKt.coerceAtLeast((HighlightFrame$lambda$1$0$2($picWidth$delegate) * picCnt) + ((picCnt - 1) * picSpacing), 1.0f);
        float indicatorWidth = (((int) ($pagerState.getLayoutInfo().getViewportSize-YbymL2g() >> 32)) / maxValue) * totalIndicatorWidth;
        float start = start0 + ((($pagerState.getCurrentPage() + $pagerState.getCurrentPageOffsetFraction()) / picCnt) * totalIndicatorWidth);
        int bits$iv$iv$iv3 = (int) ($this$Canvas.getCenter-F1C5BW0() & 4294967295L);
        float y$iv3 = Float.intBitsToFloat(bits$iv$iv$iv3) - $this$Canvas.toPx-0680j_4(Dp.constructor-impl(1));
        long v1$iv$iv4 = Float.floatToRawIntBits(start);
        long v2$iv$iv4 = Float.floatToRawIntBits(y$iv3);
        long j4 = Offset.constructor-impl((v1$iv$iv4 << 32) | (v2$iv$iv4 & 4294967295L));
        float height$iv2 = $this$Canvas.toPx-0680j_4(Dp.constructor-impl(2));
        long v1$iv$iv5 = Float.floatToRawIntBits(indicatorWidth);
        long v2$iv$iv5 = Float.floatToRawIntBits(height$iv2);
        long j5 = Size.constructor-impl((v1$iv$iv5 << 32) | (v2$iv$iv5 & 4294967295L));
        float x$iv2 = $this$Canvas.toPx-0680j_4(Dp.constructor-impl(1));
        float y$iv4 = $this$Canvas.toPx-0680j_4(Dp.constructor-impl(1));
        long v1$iv$iv6 = Float.floatToRawIntBits(x$iv2);
        long v2$iv$iv6 = Float.floatToRawIntBits(y$iv4);
        DrawScope.-CC.drawRoundRect-u-Aw5IA$default($this$Canvas, $stateColor, j4, j5, CornerRadius.constructor-impl((v1$iv$iv6 << 32) | (v2$iv$iv6 & 4294967295L)), (DrawStyle) null, 0.0f, (ColorFilter) null, 0, 240, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HighlightFrame$lambda$2$0$0(SnapshotStateMap $picRect, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Rect rec = LayoutCoordinatesKt.boundsInWindow$default(it, false, 1, (Object) null);
        ((Map) $picRect).put(0, new PicRect(rec.getLeft(), rec.getTop(), rec.getRight(), rec.getBottom()));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x024d, code lost:
        if (r3 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void ReplyPictures(final KPictureCard pic, final Function1<? super DeepSearchAction, Unit> function1, final String sessionId, final String queryId, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Composer $composer$iv;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv2;
        Composer $composer3;
        Composer $composer4 = $composer.startRestartGroup(-266913981);
        ComposerKt.sourceInformation($composer4, "C(ReplyPictures)N(pic,dispatcher,sessionId,queryId,modifier)248@9947L51,249@10003L1996:Picture.kt#pp6rt");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changedInstance(pic) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changedInstance(function1) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer4.changed(sessionId) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer4.changed(queryId) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer4.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-266913981, $dirty2, -1, "kntr.app.deepsearch.ui.cards.ReplyPictures (Picture.kt:247)");
            }
            String str = "CC(remember):Picture.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart($composer4, 1193708054, "CC(remember):Picture.kt#9igjgp");
            boolean invalid$iv = $composer4.changed(pic);
            Object it$iv = $composer4.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateMapOf();
                $composer4.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final Map map = (SnapshotStateMap) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier modifier$iv = SizeKt.widthIn-VpY3zN4$default(modifier4, 0.0f, Dp.constructor-impl(600), 1, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(4));
            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            int $changed$iv$iv = (48 << 3) & 112;
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
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = ((48 >> 6) & 112) | 6;
            RowScope $this$ReplyPictures_u24lambda_u241 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, 1743179590, "C:Picture.kt#pp6rt");
            boolean z = true;
            if (pic.getItems().size() == 1) {
                $composer4.startReplaceGroup(1743174877);
                ComposerKt.sourceInformation($composer4, "268@10653L249,255@10186L819,276@11018L38");
                KPictureCardItem kPictureCardItem = (KPictureCardItem) CollectionsKt.getOrNull(pic.getItems(), 0);
                int size = pic.getItems().size();
                Modifier weight$default = RowScope.-CC.weight$default($this$ReplyPictures_u24lambda_u241, Modifier.Companion, 1.0f, false, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer4, 1580266848, "CC(remember):Picture.kt#9igjgp");
                boolean invalid$iv2 = $composer4.changed(map);
                Object it$iv2 = $composer4.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv2 = new Function1() { // from class: kntr.app.deepsearch.ui.cards.PictureKt$$ExternalSyntheticLambda8
                    public final Object invoke(Object obj) {
                        Unit ReplyPictures$lambda$1$0$0;
                        ReplyPictures$lambda$1$0$0 = PictureKt.ReplyPictures$lambda$1$0$0(map, (LayoutCoordinates) obj);
                        return ReplyPictures$lambda$1$0$0;
                    }
                };
                $composer4.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer$iv2 = $composer4;
                modifier3 = modifier4;
                $composer$iv = $composer4;
                $composer2 = $composer4;
                $composer$iv$iv$iv = $composer4;
                Pic(pic, kPictureCardItem, 0, size, false, map, sessionId, queryId, OnGloballyPositionedModifierKt.onGloballyPositioned(weight$default, (Function1) it$iv2), Intrinsics.areEqual(pic.getSource(), KPictureCard.KSource.VIDEO.INSTANCE) ? 1.7777778f : 1.0f, function1, $composer4, ($dirty2 & 14) | 24960 | (($dirty2 << 12) & 3670016) | (($dirty2 << 12) & 29360128), ($dirty2 >> 3) & 14, 0);
                SpacerKt.Spacer(RowScope.-CC.weight$default($this$ReplyPictures_u24lambda_u241, Modifier.Companion, 2.0f, false, 2, (Object) null), $composer4, 0);
                $composer4.endReplaceGroup();
                $composer3 = $composer4;
            } else {
                modifier3 = modifier4;
                $composer$iv = $composer4;
                Map picRect = map;
                $composer2 = $composer4;
                $composer$iv$iv$iv = $composer4;
                boolean z2 = false;
                Composer $composer5 = $composer4;
                $composer$iv2 = $composer4;
                $composer5.startReplaceGroup(1744068514);
                ComposerKt.sourceInformation($composer5, "*290@11595L273,279@11123L846");
                int i5 = 0;
                while (i5 < 3) {
                    final int index = i5;
                    KPictureCardItem kPictureCardItem2 = (KPictureCardItem) CollectionsKt.getOrNull(pic.getItems(), index);
                    int size2 = pic.getItems().size();
                    boolean z3 = (index != 2 || pic.getItems().size() <= 3) ? z2 : z;
                    Modifier weight$default2 = RowScope.-CC.weight$default($this$ReplyPictures_u24lambda_u241, Modifier.Companion, 1.0f, false, 2, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer5, 220160428, str);
                    final Map map2 = picRect;
                    boolean invalid$iv3 = $composer5.changed(map2) | $composer5.changed(index);
                    Composer $this$cache$iv = $composer5;
                    Object it$iv3 = $this$cache$iv.rememberedValue();
                    if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                        Object value$iv3 = new Function1() { // from class: kntr.app.deepsearch.ui.cards.PictureKt$$ExternalSyntheticLambda9
                            public final Object invoke(Object obj) {
                                Unit ReplyPictures$lambda$1$1$0$0;
                                ReplyPictures$lambda$1$1$0$0 = PictureKt.ReplyPictures$lambda$1$1$0$0(map2, index, (LayoutCoordinates) obj);
                                return ReplyPictures$lambda$1$1$0$0;
                            }
                        };
                        $this$cache$iv.updateRememberedValue(value$iv3);
                        it$iv3 = value$iv3;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    Pic(pic, kPictureCardItem2, index, size2, z3, map2, sessionId, queryId, OnGloballyPositionedModifierKt.onGloballyPositioned(weight$default2, (Function1) it$iv3), 0.0f, function1, $composer5, ($dirty2 & 14) | (($dirty2 << 12) & 3670016) | (($dirty2 << 12) & 29360128), ($dirty2 >> 3) & 14, 512);
                    i5++;
                    str = str;
                    $composer5 = $composer5;
                    z2 = false;
                    z = true;
                    picRect = map2;
                }
                $composer3 = $composer5;
                $composer3.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.ui.cards.PictureKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2) {
                    Unit ReplyPictures$lambda$2;
                    ReplyPictures$lambda$2 = PictureKt.ReplyPictures$lambda$2(pic, function1, sessionId, queryId, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ReplyPictures$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReplyPictures$lambda$1$0$0(SnapshotStateMap $picRect, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Rect rec = LayoutCoordinatesKt.boundsInWindow$default(it, false, 1, (Object) null);
        ((Map) $picRect).put(0, new PicRect(rec.getLeft(), rec.getTop(), rec.getRight(), rec.getBottom()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReplyPictures$lambda$1$1$0$0(SnapshotStateMap $picRect, int $index, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Rect rec = LayoutCoordinatesKt.boundsInWindow$default(it, false, 1, (Object) null);
        ((Map) $picRect).put(Integer.valueOf($index), new PicRect(rec.getLeft(), rec.getTop(), rec.getRight(), rec.getBottom()));
        return Unit.INSTANCE;
    }

    private static final void Pic(final KPictureCard pic, final KPictureCardItem item, final int index, final int size, final boolean showMoreTag, final Map<Integer, PicRect> map, final String sessionId, final String queryId, Modifier modifier, float ratio, final Function1<? super DeepSearchAction, Unit> function1, Composer $composer, final int $changed, final int $changed1, final int i) {
        Composer $composer2;
        Modifier modifier2;
        float ratio2;
        Composer $composer3;
        String str;
        Function0 factory$iv$iv$iv;
        float ratio3;
        Composer $composer4;
        Function0 factory$iv$iv$iv2;
        Object value$iv;
        Composer $composer5 = $composer.startRestartGroup(-35378846);
        ComposerKt.sourceInformation($composer5, "C(Pic)N(pic,item,index,size,showMoreTag,rect,sessionId,queryId,modifier,ratio,dispatcher)318@12348L7,320@12373L24,321@12417L34,324@12474L49,328@12566L7,334@12687L1934,330@12579L3562:Picture.kt#pp6rt");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        if (($changed & 6) == 0) {
            $dirty |= $composer5.changedInstance(pic) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer5.changedInstance(item) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer5.changed(index) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer5.changed(size) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer5.changed(showMoreTag) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer5.changedInstance(map) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty |= $composer5.changed(sessionId) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            $dirty |= $composer5.changed(queryId) ? 8388608 : 4194304;
        }
        int i2 = i & 256;
        if (i2 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer5.changed(modifier) ? 67108864 : 33554432;
        }
        int i3 = i & 512;
        if (i3 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty |= $composer5.changed(ratio) ? 536870912 : 268435456;
        }
        if (($changed1 & 6) == 0) {
            $dirty1 |= $composer5.changedInstance(function1) ? 4 : 2;
        }
        if ($composer5.shouldExecute((($dirty & 306783379) == 306783378 && ($dirty1 & 3) == 2) ? false : true, $dirty & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier;
            float ratio4 = i3 != 0 ? 1.0f : ratio;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-35378846, $dirty, $dirty1, "kntr.app.deepsearch.ui.cards.Pic (Picture.kt:317)");
            }
            CompositionLocal this_$iv = RouterKt.getLocalRouter();
            ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer5.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            final Router route = (Router) consume;
            ComposerKt.sourceInformationMarkerStart($composer5, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            float ratio5 = ratio4;
            ComposerKt.sourceInformationMarkerStart($composer5, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object value$iv$iv = $composer5.rememberedValue();
            if (value$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer5);
                $composer5.updateRememberedValue(value$iv$iv);
            }
            final CoroutineScope scope = (CoroutineScope) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerStart($composer5, 360680004, "CC(remember):Picture.kt#9igjgp");
            Object value$iv2 = $composer5.rememberedValue();
            if (value$iv2 == Composer.Companion.getEmpty()) {
                value$iv2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer5.updateRememberedValue(value$iv2);
            }
            final MutableState clicked$delegate = (MutableState) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerStart($composer5, 360681843, "CC(remember):Picture.kt#9igjgp");
            Object it$iv = $composer5.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv3 = new FocusRequester();
                $composer5.updateRememberedValue(value$iv3);
                it$iv = value$iv3;
            }
            final FocusRequester fq = (FocusRequester) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer5);
            CompositionLocal this_$iv2 = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer5.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            final FocusManager focusManager = (FocusManager) consume2;
            Modifier focusRequester = FocusRequesterModifierKt.focusRequester(modifier3, fq);
            ComposerKt.sourceInformationMarkerStart($composer5, 360690544, "CC(remember):Picture.kt#9igjgp");
            boolean invalid$iv = $composer5.changedInstance(scope) | $composer5.changedInstance(item) | (($dirty1 & 14) == 4) | $composer5.changedInstance(pic) | ((29360128 & $dirty) == 8388608) | $composer5.changedInstance(map) | (($dirty & 896) == 256) | ((3670016 & $dirty) == 1048576) | $composer5.changedInstance(route) | $composer5.changedInstance(focusManager);
            Object value$iv4 = $composer5.rememberedValue();
            if (invalid$iv || value$iv4 == Composer.Companion.getEmpty()) {
                modifier2 = modifier3;
                $composer3 = $composer5;
                str = "CC(remember):Picture.kt#9igjgp";
                value$iv4 = new Function0() { // from class: kntr.app.deepsearch.ui.cards.PictureKt$$ExternalSyntheticLambda5
                    public final Object invoke() {
                        Unit Pic$lambda$4$0;
                        Pic$lambda$4$0 = PictureKt.Pic$lambda$4$0(scope, item, clicked$delegate, function1, pic, queryId, map, index, sessionId, route, focusManager, fq);
                        return Pic$lambda$4$0;
                    }
                };
                $composer5.updateRememberedValue(value$iv4);
            } else {
                modifier2 = modifier3;
                $composer3 = $composer5;
                str = "CC(remember):Picture.kt#9igjgp";
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(focusRequester, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) value$iv4, 15, (Object) null);
            Composer $composer$iv = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv, 0));
            CompositionLocalMap localMap$iv$iv = $composer$iv.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer$iv, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv.startReusableNode();
            if ($composer$iv.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer$iv.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer$iv.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer$iv);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i5 = ((0 >> 6) & 112) | 6;
            BoxScope $this$Pic_u24lambda_u245 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -857740209, "C:Picture.kt#pp6rt");
            if (item != null) {
                $composer$iv.startReplaceGroup(-857749882);
                ComposerKt.sourceInformation($composer$iv, "373@14696L59,373@14671L84,376@14768L487");
                String src = item.getSrc();
                ComposerKt.sourceInformationMarkerStart($composer$iv, -997499977, str);
                $composer4 = $composer3;
                boolean invalid$iv2 = $composer4.changedInstance(item);
                Object it$iv2 = $composer$iv.rememberedValue();
                if (!invalid$iv2 && it$iv2 != Composer.Companion.getEmpty()) {
                    value$iv = it$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    EffectsKt.LaunchedEffect(src, (Function2) value$iv, $composer$iv, 0);
                    String $this$asRequest$iv = item.getSrc();
                    ratio3 = ratio5;
                    BiliImageKt.BiliImage(new ImageRequest($this$asRequest$iv).build(), ClipKt.clip(AspectRatioKt.aspectRatio$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ratio3, false, 2, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(6))), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableSingletons$PictureKt.INSTANCE.getLambda$985054492$compose_debug(), ComposableSingletons$PictureKt.INSTANCE.getLambda$848059538$compose_debug(), $composer$iv, 113246208, 124);
                }
                value$iv = (Function2) new PictureKt$Pic$2$1$1(item, null);
                $composer$iv.updateRememberedValue(value$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                EffectsKt.LaunchedEffect(src, (Function2) value$iv, $composer$iv, 0);
                String $this$asRequest$iv2 = item.getSrc();
                ratio3 = ratio5;
                BiliImageKt.BiliImage(new ImageRequest($this$asRequest$iv2).build(), ClipKt.clip(AspectRatioKt.aspectRatio$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ratio3, false, 2, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(6))), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableSingletons$PictureKt.INSTANCE.getLambda$985054492$compose_debug(), ComposableSingletons$PictureKt.INSTANCE.getLambda$848059538$compose_debug(), $composer$iv, 113246208, 124);
            } else {
                ratio3 = ratio5;
                $composer4 = $composer3;
                $composer$iv.startReplaceGroup(-872309466);
            }
            $composer$iv.endReplaceGroup();
            if (showMoreTag) {
                $composer$iv.startReplaceGroup(-857113638);
                ComposerKt.sourceInformation($composer$iv, "399@15632L6,391@15305L820");
                Modifier modifier$iv2 = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(PaddingKt.padding-qDBjuR0$default($this$Pic_u24lambda_u245.align(Modifier.Companion, Alignment.Companion.getBottomEnd()), 0.0f, 0.0f, Dp.constructor-impl(6), Dp.constructor-impl(6), 3, (Object) null), Dp.constructor-impl(20)), Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer$iv, BiliTheme.$stable).getBa0-0d7_KjU(), 0.8f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4))), Dp.constructor-impl(6), 0.0f, 2, (Object) null);
                Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                ratio2 = ratio3;
                ComposerKt.sourceInformationMarkerStart($composer$iv, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv2 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer$iv, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer$iv.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer$iv, modifier$iv2);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer$iv.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv.startReusableNode();
                if ($composer$iv.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer$iv.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer$iv.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer$iv);
                $composer2 = $composer4;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i7 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv, 1786610255, "C408@16022L6,409@16079L9,406@15935L176:Picture.kt#pp6rt");
                TextKt.Text-Nvy7gAk("+" + (size - 3), (Modifier) null, BiliTheme.INSTANCE.getColors($composer$iv, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer$iv, BiliTheme.$stable).getT13(), $composer$iv, 0, 0, 131066);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
            } else {
                ratio2 = ratio3;
                $composer2 = $composer4;
                $composer$iv.startReplaceGroup(-872309466);
            }
            $composer$iv.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer5;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            ratio2 = ratio;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final float f = ratio2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.ui.cards.PictureKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit Pic$lambda$6;
                    Pic$lambda$6 = PictureKt.Pic$lambda$6(pic, item, index, size, showMoreTag, map, sessionId, queryId, modifier4, f, function1, $changed, $changed1, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Pic$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Pic$lambda$1(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Pic$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Pic$lambda$4$0(CoroutineScope $scope, KPictureCardItem $item, MutableState $clicked$delegate, Function1 $dispatcher, KPictureCard $pic, String $queryId, Map $rect, int $index, String $sessionId, Router $route, FocusManager $focusManager, FocusRequester $fq) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new PictureKt$Pic$1$1$1($item, $clicked$delegate, $dispatcher, $pic, $queryId, $rect, $index, $sessionId, $route, $focusManager, $fq, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Placeholder(Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2 = $composer.startRestartGroup(1384167681);
        ComposerKt.sourceInformation($composer2, "C(Placeholder)N(modifier)421@16333L6,418@16218L158:Picture.kt#pp6rt");
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
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1384167681, $dirty2, -1, "kntr.app.deepsearch.ui.cards.Placeholder (Picture.kt:417)");
            }
            TVPlaceHolderKt.TVPlaceholder-iJQMabo(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGraph_bg_thick-0d7_KjU(), (Shape) null, 2, (Object) null), 0L, $composer2, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.ui.cards.PictureKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit Placeholder$lambda$0;
                    Placeholder$lambda$0 = PictureKt.Placeholder$lambda$0(modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Placeholder$lambda$0;
                }
            });
        }
    }
}