package kntr.app.digital.preview.card.web;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.foundation.lazy.grid.LazyGridDslKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
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
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
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
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.ktor.KApiResponse;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import kntr.app.digital.preview.BusinessCoroutineScope;
import kntr.app.digital.preview.BusinessScope;
import kntr.app.digital.preview.VMid;
import kntr.app.digital.preview.card.CardBasic;
import kntr.app.digital.preview.card.DigitalCardStateService;
import kntr.app.digital.preview.card.web.FeaturePanelService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.app.digital.preview.generated.resources.Drawable0_commonMainKt;
import srcs.app.digital.preview.generated.resources.Res;

/* compiled from: FeaturePanelService.kt */
@BusinessScope
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B5\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010 J-\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u00122\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001d0$2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010%R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\u000e\u001a*\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u000fj\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006&"}, d2 = {"Lkntr/app/digital/preview/card/web/FeaturePanelService;", RoomRecommendViewModel.EMPTY_CURSOR, "featureDescDialogService", "Lkntr/app/digital/preview/card/web/FeatureDescDialogService;", "vmid", RoomRecommendViewModel.EMPTY_CURSOR, "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "cardStateService", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "getWebCardDescInfo", "Lkntr/app/digital/preview/card/web/GetWebCardDescInfo;", "<init>", "(Lkntr/app/digital/preview/card/web/FeatureDescDialogService;JLkotlinx/coroutines/CoroutineScope;Lkntr/app/digital/preview/card/DigitalCardStateService;Lkntr/app/digital/preview/card/web/GetWebCardDescInfo;)V", "featureMap", "Ljava/util/HashMap;", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/digital/preview/card/web/Feature;", "Lkotlin/collections/HashMap;", "<set-?>", "features", "getFeatures", "()Ljava/util/List;", "setFeatures", "(Ljava/util/List;)V", "features$delegate", "Landroidx/compose/runtime/MutableState;", "Content", RoomRecommendViewModel.EMPTY_CURSOR, "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "FeatureItem", "feature", "onQuestionMarkClick", "Lkotlin/Function0;", "(Lkntr/app/digital/preview/card/web/Feature;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FeaturePanelService {
    public static final int $stable = 8;
    private final DigitalCardStateService cardStateService;
    private final CoroutineScope coroutineScope;
    private final FeatureDescDialogService featureDescDialogService;
    private final HashMap<String, List<Feature>> featureMap;
    private final MutableState features$delegate;
    private final GetWebCardDescInfo getWebCardDescInfo;
    private final long vmid;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$1(FeaturePanelService featurePanelService, Modifier modifier, int i, int i2, Composer composer, int i3) {
        featurePanelService.Content(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FeatureItem$lambda$1(FeaturePanelService featurePanelService, Feature feature, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        featurePanelService.FeatureItem(feature, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    @Inject
    public FeaturePanelService(FeatureDescDialogService featureDescDialogService, @VMid long vmid, @BusinessCoroutineScope CoroutineScope coroutineScope, DigitalCardStateService cardStateService, GetWebCardDescInfo getWebCardDescInfo) {
        Intrinsics.checkNotNullParameter(featureDescDialogService, "featureDescDialogService");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(cardStateService, "cardStateService");
        Intrinsics.checkNotNullParameter(getWebCardDescInfo, "getWebCardDescInfo");
        this.featureDescDialogService = featureDescDialogService;
        this.vmid = vmid;
        this.coroutineScope = coroutineScope;
        this.cardStateService = cardStateService;
        this.getWebCardDescInfo = getWebCardDescInfo;
        this.featureMap = new HashMap<>();
        this.features$delegate = SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), (SnapshotMutationPolicy) null, 2, (Object) null);
        BuildersKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(null), 3, (Object) null);
    }

    private final List<Feature> getFeatures() {
        State $this$getValue$iv = this.features$delegate;
        return (List) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setFeatures(List<Feature> list) {
        MutableState $this$setValue$iv = this.features$delegate;
        $this$setValue$iv.setValue(list);
    }

    /* compiled from: FeaturePanelService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kntr.app.digital.preview.card.web.FeaturePanelService$1", f = "FeaturePanelService.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.app.digital.preview.card.web.FeaturePanelService$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: FeaturePanelService.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "it", RoomRecommendViewModel.EMPTY_CURSOR}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "kntr.app.digital.preview.card.web.FeaturePanelService$1$2", f = "FeaturePanelService.kt", i = {0, 0, 0, 0}, l = {65}, m = "invokeSuspend", n = {"cardBasic", "cardId", "featureList", "it"}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 1)
        /* renamed from: kntr.app.digital.preview.card.web.FeaturePanelService$1$2  reason: invalid class name */
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
            /* synthetic */ int I$0;
            Object L$0;
            Object L$1;
            Object L$2;
            int label;
            final /* synthetic */ FeaturePanelService this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(FeaturePanelService featurePanelService, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = featurePanelService;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
                anonymousClass2.I$0 = ((Number) obj).intValue();
                return anonymousClass2;
            }

            public final Object invoke(int i, Continuation<? super Unit> continuation) {
                return create(Integer.valueOf(i), continuation).invokeSuspend(Unit.INSTANCE);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke(((Number) obj).intValue(), (Continuation) obj2);
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x008c  */
            /* JADX WARN: Removed duplicated region for block: B:18:0x00cf  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object $result) {
                String cardId;
                Object invoke;
                KApiResponse.BusinessFailure businessFailure;
                int it = this.I$0;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        CardBasic cardBasic = this.this$0.cardStateService.cardItemBasicInfo(it);
                        if (!cardBasic.getFeaturePanelShowing()) {
                            this.this$0.setFeatures(CollectionsKt.emptyList());
                        } else {
                            cardId = cardBasic.getUniqueId();
                            List featureList = (List) this.this$0.featureMap.get(cardId);
                            if (featureList == null) {
                                this.L$0 = SpillingKt.nullOutSpilledVariable(cardBasic);
                                this.L$1 = cardId;
                                this.L$2 = SpillingKt.nullOutSpilledVariable(featureList);
                                this.I$0 = it;
                                this.label = 1;
                                invoke = this.this$0.getWebCardDescInfo.invoke(this.this$0.vmid, String.valueOf(cardBasic.getCardIdInfo().getCardId()), (Continuation) this);
                                if (invoke == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                businessFailure = (KApiResponse) invoke;
                                FeaturePanelService featurePanelService = this.this$0;
                                FeaturePanelService featurePanelService2 = this.this$0;
                                if (!(businessFailure instanceof KApiResponse.BusinessFailure)) {
                                    int code = businessFailure.getCode();
                                    new IllegalStateException("code:" + code + ",message:" + businessFailure.getMessage());
                                    featurePanelService2.setFeatures(CollectionsKt.emptyList());
                                    featurePanelService2.featureMap.remove(cardId);
                                } else if (businessFailure instanceof KApiResponse.ServiceUnavailable) {
                                    ((KApiResponse.ServiceUnavailable) businessFailure).getException();
                                    featurePanelService2.setFeatures(CollectionsKt.emptyList());
                                    featurePanelService2.featureMap.remove(cardId);
                                } else if (businessFailure instanceof KApiResponse.Success) {
                                    PropertyInfo result = (PropertyInfo) ((KApiResponse.Success) businessFailure).getData();
                                    featurePanelService.setFeatures(result.getSmeltInfo().getProperties());
                                    featurePanelService.featureMap.put(cardId, result.getSmeltInfo().getProperties());
                                } else {
                                    throw new NoWhenBranchMatchedException();
                                }
                            } else {
                                this.this$0.setFeatures(featureList);
                            }
                        }
                        return Unit.INSTANCE;
                    case 1:
                        List list = (List) this.L$2;
                        cardId = (String) this.L$1;
                        CardBasic cardBasic2 = (CardBasic) this.L$0;
                        ResultKt.throwOnFailure($result);
                        invoke = $result;
                        businessFailure = (KApiResponse) invoke;
                        FeaturePanelService featurePanelService3 = this.this$0;
                        FeaturePanelService featurePanelService22 = this.this$0;
                        if (!(businessFailure instanceof KApiResponse.BusinessFailure)) {
                        }
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    final FeaturePanelService featurePanelService = FeaturePanelService.this;
                    this.label = 1;
                    if (FlowKt.collectLatest(SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.digital.preview.card.web.FeaturePanelService$1$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            int invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = FeaturePanelService.AnonymousClass1.invokeSuspend$lambda$0(FeaturePanelService.this);
                            return Integer.valueOf(invokeSuspend$lambda$0);
                        }
                    }), new AnonymousClass2(FeaturePanelService.this, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int invokeSuspend$lambda$0(FeaturePanelService this$0) {
            return this$0.cardStateService.getIndex();
        }
    }

    public final void Content(Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-1249317942);
        ComposerKt.sourceInformation($composer3, "C(Content)N(modifier)92@4009L1207,86@3715L1501:FeaturePanelService.kt#yfljjo");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(this) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1249317942, $dirty2, -1, "kntr.app.digital.preview.card.web.FeaturePanelService.Content (FeaturePanelService.kt:85)");
            }
            GridCells fixed = new GridCells.Fixed(2);
            Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(12));
            Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(15));
            ComposerKt.sourceInformationMarkerStart($composer3, 1996313057, "CC(remember):FeaturePanelService.kt#9igjgp");
            boolean invalid$iv = $composer3.changedInstance(this);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.app.digital.preview.card.web.FeaturePanelService$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit Content$lambda$0$0;
                        Content$lambda$0$0 = FeaturePanelService.Content$lambda$0$0(FeaturePanelService.this, (LazyGridScope) obj);
                        return Content$lambda$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2 = $composer3;
            LazyGridDslKt.LazyVerticalGrid(fixed, modifier3, (LazyGridState) null, (PaddingValues) null, false, vertical, horizontal, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv, $composer3, (($dirty2 << 3) & 112) | 102432768, 0, 668);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.preview.card.web.FeaturePanelService$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$1;
                    Content$lambda$1 = FeaturePanelService.Content$lambda$1(FeaturePanelService.this, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$0$0(final FeaturePanelService this$0, LazyGridScope $this$LazyVerticalGrid) {
        Intrinsics.checkNotNullParameter($this$LazyVerticalGrid, "$this$LazyVerticalGrid");
        final List items$iv = this$0.getFeatures();
        final Function1 contentType$iv = new Function1() { // from class: kntr.app.digital.preview.card.web.FeaturePanelService$Content$lambda$0$0$$inlined$items$default$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return m955invoke((Feature) p1);
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final Void m955invoke(Feature feature) {
                return null;
            }
        };
        $this$LazyVerticalGrid.items(items$iv.size(), (Function1) null, (Function2) null, new Function1<Integer, Object>() { // from class: kntr.app.digital.preview.card.web.FeaturePanelService$Content$lambda$0$0$$inlined$items$default$4
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                return contentType$iv.invoke(items$iv.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-1117249557, true, new Function4<LazyGridItemScope, Integer, Composer, Integer, Unit>() { // from class: kntr.app.digital.preview.card.web.FeaturePanelService$Content$lambda$0$0$$inlined$items$default$5
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyGridItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r11v3 */
            public final void invoke(LazyGridItemScope $this$items, int it, Composer $composer, int $changed) {
                ComposerKt.sourceInformation($composer, "CN(it)539@23988L22:LazyGridDsl.kt#7791vq");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$items) ? 4 : 2;
                }
                if (($changed & 48) == 0) {
                    $dirty |= $composer.changed(it) ? 32 : 16;
                }
                if (!$composer.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
                    $composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1117249557, $dirty, -1, "androidx.compose.foundation.lazy.grid.items.<anonymous> (LazyGridDsl.kt:539)");
                }
                int $changed2 = $dirty & 14;
                final Feature it2 = (Feature) items$iv.get(it);
                $composer.startReplaceGroup(-1188652388);
                ComposerKt.sourceInformation($composer, "CN(it)*110@4973L188,94@4065L1119:FeaturePanelService.kt#yfljjo");
                Modifier modifier = PaddingKt.padding-qDBjuR0$default(BackgroundKt.background$default(Modifier.Companion, Brush.Companion.horizontalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(Color.Companion.getTransparent-0d7_KjU()), Color.box-impl(Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.15f, 0.0f, 0.0f, 0.0f, 14, (Object) null)), Color.box-impl(Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.15f, 0.0f, 0.0f, 0.0f, 14, (Object) null)), Color.box-impl(Color.Companion.getTransparent-0d7_KjU())}), 0.0f, 0.0f, 0, 14, (Object) null), (Shape) null, 0.0f, 6, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(6), 0.0f, Dp.constructor-impl(6), 4, (Object) null);
                FeaturePanelService featurePanelService = this$0;
                ComposerKt.sourceInformationMarkerStart($composer, 515873828, "CC(remember):FeaturePanelService.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance(this$0) | (((($changed2 & 112) ^ 48) > 32 && $composer.changed(it2)) || ($changed2 & 48) == 32);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    final FeaturePanelService featurePanelService2 = this$0;
                    Object value$iv = (Function0) new Function0<Unit>() { // from class: kntr.app.digital.preview.card.web.FeaturePanelService$Content$1$1$1$1$1

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* compiled from: FeaturePanelService.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "kntr.app.digital.preview.card.web.FeaturePanelService$Content$1$1$1$1$1$1", f = "FeaturePanelService.kt", i = {}, l = {113}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                        /* renamed from: kntr.app.digital.preview.card.web.FeaturePanelService$Content$1$1$1$1$1$1  reason: invalid class name */
                        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ Feature $it;
                            int label;
                            final /* synthetic */ FeaturePanelService this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(FeaturePanelService featurePanelService, Feature feature, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.this$0 = featurePanelService;
                                this.$it = feature;
                            }

                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.this$0, this.$it, continuation);
                            }

                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                            }

                            public final Object invokeSuspend(Object $result) {
                                FeatureDescDialogService featureDescDialogService;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    case 0:
                                        ResultKt.throwOnFailure($result);
                                        featureDescDialogService = this.this$0.featureDescDialogService;
                                        this.label = 1;
                                        if (featureDescDialogService.keepDialogShowing(this.$it, (Continuation) this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        break;
                                    case 1:
                                        ResultKt.throwOnFailure($result);
                                        break;
                                    default:
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                return Unit.INSTANCE;
                            }
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m957invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: collision with other method in class */
                        public final void m957invoke() {
                            CoroutineScope coroutineScope;
                            coroutineScope = FeaturePanelService.this.coroutineScope;
                            BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(FeaturePanelService.this, it2, null), 3, (Object) null);
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                featurePanelService.FeatureItem(it2, it$iv, modifier, $composer, ($changed2 >> 3) & 14, 0);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    public final void FeatureItem(final Feature feature, final Function0<Unit> function0, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        int $dirty;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(feature, "feature");
        Intrinsics.checkNotNullParameter(function0, "onQuestionMarkClick");
        Composer $composer2 = $composer.startRestartGroup(1731535216);
        ComposerKt.sourceInformation($composer2, "C(FeatureItem)N(feature,onQuestionMarkClick,modifier)126@5415L1922:FeaturePanelService.kt#yfljjo");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(feature) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty2 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if ($composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1731535216, $dirty2, -1, "kntr.app.digital.preview.card.web.FeaturePanelService.FeatureItem (FeaturePanelService.kt:125)");
            }
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            int $changed$iv = (($dirty2 >> 6) & 14) | 384;
            Modifier modifier$iv = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
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
            $dirty = $dirty2;
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i4 = (($changed$iv >> 6) & 112) | 6;
            Modifier modifier4 = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer2, -747130171, "C130@5553L78,135@5776L9,132@5649L315,146@6194L51,141@5982L380,151@6380L40:FeaturePanelService.kt#yfljjo");
            String $this$asRequest_u24default$iv = feature.getIcon();
            BiliImageKt.BiliImage(new ImageRequest($this$asRequest_u24default$iv).build(), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, (Function4) null, $composer2, 48, 508);
            TextKt.Text-Nvy7gAk(feature.getTitle(), PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(6), 0.0f, 2, (Object) null), Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14(), $composer2, 432, 24960, 110584);
            IconKt.Icon-ww6aTOc(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getDigital_question_mark(Res.drawable.INSTANCE), $composer2, 0), (String) null, ClickableKt.clickable-oSLSa3U$default(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(14)), false, (String) null, (Role) null, (MutableInteractionSource) null, function0, 15, (Object) null), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.8f, 0.0f, 0.0f, 0.0f, 14, (Object) null), $composer2, Painter.$stable | 3120, 0);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(25)), $composer2, 6);
            if (feature.getSealed()) {
                $composer2.startReplaceGroup(-746255228);
                ComposerKt.sourceInformation($composer2, "157@6611L9,154@6480L330");
                TextKt.Text-Nvy7gAk("封印中", PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(4), 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14(), $composer2, 438, 24960, 110584);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(-745899131);
                ComposerKt.sourceInformation($composer2, "163@6856L82,168@7106L9,165@6960L345");
                String $this$asRequest_u24default$iv2 = feature.getStarIcon();
                BiliImageKt.BiliImage(new ImageRequest($this$asRequest_u24default$iv2).build(), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(14)), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, (Function4) null, $composer2, 48, 508);
                TextKt.Text-Nvy7gAk(feature.getFeatureValue(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(4), 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14(), $composer2, 432, 24960, 110584);
                $composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        } else {
            $dirty = $dirty2;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.preview.card.web.FeaturePanelService$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit FeatureItem$lambda$1;
                    FeatureItem$lambda$1 = FeaturePanelService.FeatureItem$lambda$1(FeaturePanelService.this, feature, function0, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return FeatureItem$lambda$1;
                }
            });
        }
    }
}