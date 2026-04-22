package kntr.app.digital.preview.smelting;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.framework.simpleplayer.SimplePlayer;
import com.bilibili.ktor.KApiResponse;
import com.bilibili.ogv.bpf.neuron.NeuronReportKt;
import com.bilibili.ogv.bpf.server.ApiExceptionKt;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.util.reflect.TypeInfo;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kntr.app.digital.preview.aggregate.CardPreviewComponent;
import kntr.app.digital.preview.smelting.State;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.komponent.HostConfiguration;
import kntr.common.komponent.Komponent;
import kntr.common.komponent.KomponentHostScope;
import kntr.common.komponent.KomponentKt;
import kntr.common.komponent.KomponentScope;
import kntr.common.komponent.LocalOnFinishKt;
import kntr.common.komponent.Orientation;
import kntr.common.komponent.SetContentResult;
import kntr.common.komponent.UiComposableLike;
import kntr.common.trio.systemui.SystemUI_androidKt;
import kntr.common.trio.systemui.SystemUiController;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.YieldKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;

/* compiled from: SmeltingTutorialEntrance.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u001a\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0001*$\b\u0002\u0010\u0000\"\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¨\u0006\b²\u0006\n\u0010\t\u001a\u00020\nX\u008a\u008e\u0002²\u0006\n\u0010\u000b\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010\f\u001a\u00020\u0002X\u008a\u008e\u0002²\u0006\n\u0010\r\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010\u000f\u001a\u00020\u0002X\u008a\u0084\u0002²\u0006\u0010\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011X\u008a\u0084\u0002"}, d2 = {"ToToast", "Lkotlin/Pair;", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "smeltingTutorialEntrance", "Lkntr/common/komponent/Komponent;", RoomRecommendViewModel.EMPTY_CURSOR, "report_params", "preview_debug", "state", "Lkntr/app/digital/preview/smelting/State;", "playerVisible", "url", "curIndex", RoomRecommendViewModel.EMPTY_CURSOR, "buttonText", "content", "Lkntr/common/komponent/UiComposableLike;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SmeltingTutorialEntranceKt {
    public static final Komponent<Unit> smeltingTutorialEntrance(final String report_params) {
        Intrinsics.checkNotNullParameter(report_params, "report_params");
        return KomponentKt.Komponent(new Function1() { // from class: kntr.app.digital.preview.smelting.SmeltingTutorialEntranceKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                SetContentResult smeltingTutorialEntrance$lambda$0;
                smeltingTutorialEntrance$lambda$0 = SmeltingTutorialEntranceKt.smeltingTutorialEntrance$lambda$0(report_params, (KomponentScope) obj);
                return smeltingTutorialEntrance$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r9v2, types: [kntr.app.digital.preview.smelting.SmeltingTutorialEntranceKt$smeltingTutorialEntrance$1$player$1] */
    public static final SetContentResult smeltingTutorialEntrance$lambda$0(String $report_params, final KomponentScope $this$Komponent) {
        Intrinsics.checkNotNullParameter($this$Komponent, "$this$Komponent");
        $this$Komponent.setPreferredOrientation(new Function0() { // from class: kntr.app.digital.preview.smelting.SmeltingTutorialEntranceKt$$ExternalSyntheticLambda0
            public final Object invoke() {
                Orientation orientation;
                orientation = Orientation.UserPortrait;
                return orientation;
            }
        });
        final MutableState state$delegate = SnapshotStateKt.mutableStateOf$default(State.Loading.INSTANCE, (SnapshotMutationPolicy) null, 2, (Object) null);
        BuildersKt.launch$default($this$Komponent.getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new SmeltingTutorialEntranceKt$smeltingTutorialEntrance$1$2(state$delegate, $this$Komponent, null), 3, (Object) null);
        final MutableState playerVisible$delegate = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        Json this_$iv = Json.Default;
        this_$iv.getSerializersModule();
        final Map reportMap = (Map) this_$iv.decodeFromString(new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE), $report_params);
        final MutableState url$delegate = SnapshotStateKt.mutableStateOf$default(RoomRecommendViewModel.EMPTY_CURSOR, (SnapshotMutationPolicy) null, 2, (Object) null);
        final CoroutineScope coroutineScope = $this$Komponent.getCoroutineScope();
        final ?? r9 = new SimplePlayer(coroutineScope) { // from class: kntr.app.digital.preview.smelting.SmeltingTutorialEntranceKt$smeltingTutorialEntrance$1$player$1
            public String getUrl() {
                String smeltingTutorialEntrance$lambda$0$6;
                smeltingTutorialEntrance$lambda$0$6 = SmeltingTutorialEntranceKt.smeltingTutorialEntrance$lambda$0$6(url$delegate);
                return smeltingTutorialEntrance$lambda$0$6;
            }

            public boolean getIntendToPlay() {
                return true;
            }

            public float getVolume() {
                return 1.0f;
            }

            public boolean getLoop() {
                return true;
            }

            /* renamed from: firstFrameRendered-LRDsOJo  reason: not valid java name */
            public void m1008firstFrameRenderedLRDsOJo(long j2) {
                SmeltingTutorialEntranceKt.smeltingTutorialEntrance$lambda$0$5(playerVisible$delegate, true);
            }
        };
        final Flow $this$map$iv = SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.digital.preview.smelting.SmeltingTutorialEntranceKt$$ExternalSyntheticLambda1
            public final Object invoke() {
                State smeltingTutorialEntrance$lambda$0$1;
                smeltingTutorialEntrance$lambda$0$1 = SmeltingTutorialEntranceKt.smeltingTutorialEntrance$lambda$0$1(state$delegate);
                return smeltingTutorialEntrance$lambda$0$1;
            }
        });
        Flow it = new Flow<Komponent<? extends Unit>>() { // from class: kntr.app.digital.preview.smelting.SmeltingTutorialEntranceKt$smeltingTutorialEntrance$lambda$0$$inlined$map$1
            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv.collect(new AnonymousClass2(collector, url$delegate, reportMap, r9, playerVisible$delegate), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: kntr.app.digital.preview.smelting.SmeltingTutorialEntranceKt$smeltingTutorialEntrance$lambda$0$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ SmeltingTutorialEntranceKt$smeltingTutorialEntrance$1$player$1 $player$inlined;
                final /* synthetic */ MutableState $playerVisible$delegate$inlined;
                final /* synthetic */ Map $reportMap$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ MutableState $url$delegate$inlined;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "kntr.app.digital.preview.smelting.SmeltingTutorialEntranceKt$smeltingTutorialEntrance$lambda$0$$inlined$map$1$2", f = "SmeltingTutorialEntrance.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                /* renamed from: kntr.app.digital.preview.smelting.SmeltingTutorialEntranceKt$smeltingTutorialEntrance$lambda$0$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, MutableState mutableState, Map map, SmeltingTutorialEntranceKt$smeltingTutorialEntrance$1$player$1 smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$player$1, MutableState mutableState2) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$url$delegate$inlined = mutableState;
                    this.$reportMap$inlined = map;
                    this.$player$inlined = smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$player$1;
                    this.$playerVisible$delegate$inlined = mutableState2;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0043  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    String str;
                    Komponent smeltingTutorialEntrance$lambda$0$createSuccessKomponent;
                    if ($completion instanceof AnonymousClass1) {
                        $continuation = (AnonymousClass1) $completion;
                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                            $continuation.label -= Integer.MIN_VALUE;
                            Object $result = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                    AnonymousClass1 anonymousClass1 = $continuation;
                                    State localState = (State) value;
                                    if (localState instanceof State.Loading) {
                                        smeltingTutorialEntrance$lambda$0$createSuccessKomponent = KomponentKt.Komponent(SmeltingTutorialEntranceKt$smeltingTutorialEntrance$1$content$3$1.INSTANCE);
                                    } else if (!(localState instanceof State.Success)) {
                                        throw new NoWhenBranchMatchedException();
                                    } else {
                                        MutableState mutableState = this.$url$delegate$inlined;
                                        SmeltingTutorialItemInfo smeltingTutorialItemInfo = (SmeltingTutorialItemInfo) CollectionsKt.firstOrNull(((State.Success) localState).getTutorialInfoList());
                                        if (smeltingTutorialItemInfo == null || (str = smeltingTutorialItemInfo.getImage()) == null) {
                                            str = RoomRecommendViewModel.EMPTY_CURSOR;
                                        }
                                        mutableState.setValue(str);
                                        smeltingTutorialEntrance$lambda$0$createSuccessKomponent = SmeltingTutorialEntranceKt.smeltingTutorialEntrance$lambda$0$createSuccessKomponent(this.$reportMap$inlined, this.$player$inlined, this.$playerVisible$delegate$inlined, this.$url$delegate$inlined, ((State.Success) localState).getTutorialInfoList());
                                    }
                                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
                                    $continuation.I$0 = 0;
                                    $continuation.label = 1;
                                    if ($this$map_u24lambda_u245.emit(smeltingTutorialEntrance$lambda$0$createSuccessKomponent, $continuation) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                    break;
                                case 1:
                                    int i = $continuation.I$0;
                                    FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                    Object obj = $continuation.L$2;
                                    AnonymousClass1 anonymousClass12 = (AnonymousClass1) $continuation.L$1;
                                    Object obj2 = $continuation.L$0;
                                    ResultKt.throwOnFailure($result);
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    $continuation = new AnonymousClass1($completion);
                    Object $result2 = $continuation.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch ($continuation.label) {
                    }
                    return Unit.INSTANCE;
                }
            }
        };
        final androidx.compose.runtime.State content$delegate = KomponentKt.embedFlow((KomponentHostScope) $this$Komponent, it);
        final Object state$iv$iv = Unit.INSTANCE;
        UiComposableLike content$iv$iv$iv = new UiComposableLike<S>(state$iv$iv, $this$Komponent, content$delegate) { // from class: kntr.app.digital.preview.smelting.SmeltingTutorialEntranceKt$smeltingTutorialEntrance$lambda$0$$inlined$setContent$1
            final /* synthetic */ androidx.compose.runtime.State $content$delegate$inlined;
            final /* synthetic */ KomponentScope $this_setContent;
            private final S state;

            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$this_setContent = $this$Komponent;
                this.$content$delegate$inlined = content$delegate;
                this.state = state$iv$iv;
            }

            public void invoke(final Modifier modifier, Composer $composer, int $changed) {
                Intrinsics.checkNotNullParameter(modifier, "modifier");
                $composer.startReplaceGroup(1906618612);
                ComposerKt.sourceInformation($composer, "C(invoke)N(modifier)87@2987L17:Komponent.kt#vxw63z");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1906618612, $changed, -1, "kntr.common.komponent.setContent.<no name provided>.invoke (Komponent.kt:86)");
                }
                int i = $changed & 14;
                $composer.startReplaceGroup(-774650174);
                ComposerKt.sourceInformation($composer, "CN(modifier)*179@7689L248,179@7679L258:SmeltingTutorialEntrance.kt#smaoud");
                final androidx.compose.runtime.State state = this.$content$delegate$inlined;
                BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(-267345369, true, new Function2<Composer, Integer, Unit>() { // from class: kntr.app.digital.preview.smelting.SmeltingTutorialEntranceKt$smeltingTutorialEntrance$1$3$1
                    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                        invoke((Composer) p1, ((Number) p2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer2, int $changed2) {
                        UiComposableLike smeltingTutorialEntrance$lambda$0$12;
                        ComposerKt.sourceInformation($composer2, "C180@7726L28,181@7792L72,181@7771L93,184@7881L42:SmeltingTutorialEntrance.kt#smaoud");
                        if (!$composer2.shouldExecute(($changed2 & 3) != 2, $changed2 & 1)) {
                            $composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-267345369, $changed2, -1, "kntr.app.digital.preview.smelting.smeltingTutorialEntrance.<anonymous>.<anonymous>.<anonymous> (SmeltingTutorialEntrance.kt:180)");
                        }
                        SystemUiController uiController = SystemUI_androidKt.rememberSystemUiController($composer2, 0);
                        Unit unit = Unit.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer2, 779141519, "CC(remember):SmeltingTutorialEntrance.kt#9igjgp");
                        boolean invalid$iv = $composer2.changed(uiController);
                        Object it$iv = $composer2.rememberedValue();
                        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                            Object value$iv = (Function2) new SmeltingTutorialEntranceKt$smeltingTutorialEntrance$1$3$1$1$1(uiController, null);
                            $composer2.updateRememberedValue(value$iv);
                            it$iv = value$iv;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        EffectsKt.LaunchedEffect(unit, (Function2) it$iv, $composer2, 6);
                        smeltingTutorialEntrance$lambda$0$12 = SmeltingTutorialEntranceKt.smeltingTutorialEntrance$lambda$0$12(state);
                        smeltingTutorialEntrance$lambda$0$12.invoke(SizeKt.fillMaxSize$default(modifier, 0.0f, 1, (Object) null), $composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer, 54), $composer, 384, 3);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceGroup();
            }

            public Object getContentType() {
                return Reflection.getOrCreateKotlinClass(getClass());
            }

            public Object getKey() {
                return this.$this_setContent.getKey();
            }

            public S getState() {
                return this.state;
            }

            public HostConfiguration getPreferredHostConfiguration() {
                return this.$this_setContent.getPreferredHostConfiguration();
            }
        };
        return $this$Komponent.__setContent(content$iv$iv$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final State smeltingTutorialEntrance$lambda$0$1(MutableState<State> mutableState) {
        androidx.compose.runtime.State $this$getValue$iv = (androidx.compose.runtime.State) mutableState;
        return (State) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0167 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x016b A[Catch: Exception -> 0x0177, CancellationException -> 0x0179, TryCatch #6 {CancellationException -> 0x0179, Exception -> 0x0177, blocks: (B:45:0x016b, B:46:0x016f, B:47:0x0176, B:33:0x0111, B:40:0x013d, B:29:0x00c2), top: B:68:0x00c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x016f A[Catch: Exception -> 0x0177, CancellationException -> 0x0179, TryCatch #6 {CancellationException -> 0x0179, Exception -> 0x0177, blocks: (B:45:0x016b, B:46:0x016f, B:47:0x0176, B:33:0x0111, B:40:0x013d, B:29:0x00c2), top: B:68:0x00c2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object smeltingTutorialEntrance$lambda$0$getSmeltingTutorialInfo(Continuation<? super KApiResponse<SmeltingTutorialInfo>> continuation) {
        SmeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$1 smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$1;
        SmeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$1 smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12;
        int $i$f$get;
        HttpClient $this$get_u24default$iv;
        HttpRequestBuilder builder$iv$iv$iv;
        int $i$f$get2;
        KType kType;
        Object bodyNullable;
        if (continuation instanceof SmeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$1) {
            smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$1 = (SmeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$1) continuation;
            if ((smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$1.label & Integer.MIN_VALUE) != 0) {
                smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$1.label -= Integer.MIN_VALUE;
                smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12 = smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$1;
                Object $result = smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $i$f$get = 0;
                        try {
                            $this$get_u24default$iv = CardPreviewComponent.Impl.INSTANCE.provideHttpClient();
                            builder$iv$iv$iv = new HttpRequestBuilder();
                            HttpRequestKt.url(builder$iv$iv$iv, "https://api.bilibili.com/x/vas/smelt/card/tutorial");
                            builder$iv$iv$iv.setMethod(HttpMethod.Companion.getGet());
                        } catch (CancellationException e$iv) {
                            throw e$iv;
                        } catch (Exception e) {
                            e$iv = e;
                        }
                        try {
                            HttpStatement httpStatement = new HttpStatement(builder$iv$iv$iv, $this$get_u24default$iv);
                            smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.L$0 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                            smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.L$1 = SpillingKt.nullOutSpilledVariable("https://api.bilibili.com/x/vas/smelt/card/tutorial");
                            smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.L$2 = SpillingKt.nullOutSpilledVariable(smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12);
                            smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.L$3 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                            smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.L$4 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                            smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.L$5 = SpillingKt.nullOutSpilledVariable(builder$iv$iv$iv);
                            smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.L$6 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                            smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.I$0 = 0;
                            smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.I$1 = 0;
                            smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.I$2 = 0;
                            smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.I$3 = 0;
                            smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.I$4 = 0;
                            smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.I$5 = 0;
                            smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.label = 1;
                            $result = httpStatement.execute(smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12);
                            coroutine_suspended = coroutine_suspended;
                            if ($result == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $i$f$get2 = 0;
                            HttpResponse $this$body$iv = (HttpResponse) $result;
                            HttpClientCall call = $this$body$iv.getCall();
                            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                            try {
                                kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(SmeltingTutorialInfo.class)));
                            } catch (Throwable th) {
                                kType = null;
                            }
                            TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                            smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.L$0 = SpillingKt.nullOutSpilledVariable($this$body$iv);
                            smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.L$1 = SpillingKt.nullOutSpilledVariable(smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12);
                            smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.L$2 = null;
                            smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.L$3 = null;
                            smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.L$4 = null;
                            smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.L$5 = null;
                            smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.L$6 = null;
                            smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.I$0 = $i$f$get;
                            smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.I$1 = $i$f$get2;
                            smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.I$2 = 0;
                            smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.label = 2;
                            bodyNullable = call.bodyNullable(typeInfo, smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12);
                            if (bodyNullable != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            if (bodyNullable == null) {
                                return (KApiResponse) bodyNullable;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kntr.app.digital.preview.smelting.SmeltingTutorialInfo>");
                        } catch (CancellationException e$iv2) {
                            throw e$iv2;
                        } catch (Exception e2) {
                            e$iv = e2;
                            ApiExceptionKt.logApiException(e$iv);
                            return new KApiResponse.ServiceUnavailable(e$iv);
                        }
                    case 1:
                        int i = smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.I$5;
                        int i2 = smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.I$4;
                        int i3 = smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.I$3;
                        int i4 = smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.I$2;
                        $i$f$get2 = smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.I$1;
                        int $i$f$handleApiException = smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.I$0;
                        HttpClient httpClient = (HttpClient) smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.L$6;
                        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.L$5;
                        HttpClient httpClient2 = (HttpClient) smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.L$4;
                        HttpClient httpClient3 = (HttpClient) smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.L$3;
                        SmeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$1 smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$13 = (SmeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$1) smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.L$2;
                        String str = (String) smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.L$1;
                        HttpClient httpClient4 = (HttpClient) smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            $i$f$get = $i$f$handleApiException;
                            HttpResponse $this$body$iv2 = (HttpResponse) $result;
                            HttpClientCall call2 = $this$body$iv2.getCall();
                            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                            kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(SmeltingTutorialInfo.class)));
                            TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass2, kType);
                            smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.L$0 = SpillingKt.nullOutSpilledVariable($this$body$iv2);
                            smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.L$1 = SpillingKt.nullOutSpilledVariable(smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12);
                            smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.L$2 = null;
                            smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.L$3 = null;
                            smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.L$4 = null;
                            smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.L$5 = null;
                            smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.L$6 = null;
                            smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.I$0 = $i$f$get;
                            smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.I$1 = $i$f$get2;
                            smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.I$2 = 0;
                            smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.label = 2;
                            bodyNullable = call2.bodyNullable(typeInfo2, smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12);
                            if (bodyNullable != coroutine_suspended) {
                            }
                        } catch (CancellationException e$iv3) {
                            throw e$iv3;
                        } catch (Exception e3) {
                            e$iv = e3;
                            ApiExceptionKt.logApiException(e$iv);
                            return new KApiResponse.ServiceUnavailable(e$iv);
                        }
                        break;
                    case 2:
                        int i5 = smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.I$2;
                        int i6 = smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.I$1;
                        int i7 = smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.I$0;
                        SmeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$1 smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$14 = (SmeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$1) smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.L$1;
                        HttpResponse httpResponse = (HttpResponse) smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            bodyNullable = $result;
                            if (bodyNullable == null) {
                            }
                        } catch (CancellationException e$iv4) {
                            throw e$iv4;
                        } catch (Exception e4) {
                            e$iv = e4;
                            ApiExceptionKt.logApiException(e$iv);
                            return new KApiResponse.ServiceUnavailable(e$iv);
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$1 = new SmeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$1(continuation);
        smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12 = smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$1;
        Object $result2 = smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$getSmeltingTutorialInfo$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean smeltingTutorialEntrance$lambda$0$4(MutableState<Boolean> mutableState) {
        androidx.compose.runtime.State $this$getValue$iv = (androidx.compose.runtime.State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void smeltingTutorialEntrance$lambda$0$5(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String smeltingTutorialEntrance$lambda$0$6(MutableState<String> mutableState) {
        androidx.compose.runtime.State $this$getValue$iv = (androidx.compose.runtime.State) mutableState;
        return (String) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Komponent<Unit> smeltingTutorialEntrance$lambda$0$createSuccessKomponent(final Map<String, String> map, final SmeltingTutorialEntranceKt$smeltingTutorialEntrance$1$player$1 player, final MutableState<Boolean> mutableState, final MutableState<String> mutableState2, final List<SmeltingTutorialItemInfo> list) {
        return KomponentKt.Komponent(new Function1() { // from class: kntr.app.digital.preview.smelting.SmeltingTutorialEntranceKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                SetContentResult smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8;
                smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8 = SmeltingTutorialEntranceKt.smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8(list, map, player, mutableState, mutableState2, (KomponentScope) obj);
                return smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SetContentResult smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8(final List $tutorialInfoList, final Map $reportMap, final SmeltingTutorialEntranceKt$smeltingTutorialEntrance$1$player$1 $player, final MutableState $playerVisible$delegate, final MutableState $url$delegate, final KomponentScope $this$Komponent) {
        Intrinsics.checkNotNullParameter($this$Komponent, "$this$Komponent");
        final Object state$iv$iv = Unit.INSTANCE;
        UiComposableLike content$iv$iv$iv = new UiComposableLike<S>(state$iv$iv, $this$Komponent, $this$Komponent, $tutorialInfoList, $reportMap, $player, $playerVisible$delegate, $url$delegate) { // from class: kntr.app.digital.preview.smelting.SmeltingTutorialEntranceKt$smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8$$inlined$setContent$1
            final /* synthetic */ SmeltingTutorialEntranceKt$smeltingTutorialEntrance$1$player$1 $player$inlined;
            final /* synthetic */ MutableState $playerVisible$delegate$inlined;
            final /* synthetic */ Map $reportMap$inlined;
            final /* synthetic */ KomponentScope $this_Komponent$inlined;
            final /* synthetic */ KomponentScope $this_setContent;
            final /* synthetic */ List $tutorialInfoList$inlined;
            final /* synthetic */ MutableState $url$delegate$inlined;
            private final S state;

            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$this_setContent = $this$Komponent;
                this.$this_Komponent$inlined = $this$Komponent;
                this.$tutorialInfoList$inlined = $tutorialInfoList;
                this.$reportMap$inlined = $reportMap;
                this.$player$inlined = $player;
                this.$playerVisible$delegate$inlined = $playerVisible$delegate;
                this.$url$delegate$inlined = $url$delegate;
                this.state = state$iv$iv;
            }

            /* JADX WARN: Code restructure failed: missing block: B:23:0x0231, code lost:
                if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L21;
             */
            /* JADX WARN: Removed duplicated region for block: B:38:0x0324  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void invoke(Modifier modifier, Composer $composer, int $changed) {
                Function0 factory$iv$iv$iv;
                int smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8$0$0$1;
                String str;
                int smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8$0$0$12;
                boolean smeltingTutorialEntrance$lambda$0$4;
                String smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8$0$0$3;
                int smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8$0$0$13;
                Intrinsics.checkNotNullParameter(modifier, "modifier");
                $composer.startReplaceGroup(1906618612);
                ComposerKt.sourceInformation($composer, "C(invoke)N(modifier)87@2987L17:Komponent.kt#vxw63z");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1906618612, $changed, -1, "kntr.common.komponent.setContent.<no name provided>.invoke (Komponent.kt:86)");
                }
                int i = $changed & 14;
                $composer.startReplaceGroup(-1191785213);
                ComposerKt.sourceInformation($composer, "CN(modifier)*94@3836L2773:SmeltingTutorialEntrance.kt#smaoud");
                Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(modifier, ColorKt.Color(4278190080L), (Shape) null, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv = (0 << 3) & 112;
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
                int i2 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                int i3 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 125535895, "C99@4036L342,107@4403L41,108@4485L33,109@4561L366,118@4983L444,118@4953L474,135@5823L614,130@5526L1061:SmeltingTutorialEntrance.kt#smaoud");
                SmeltingTutorialUIKt.SmeltingTutorialTopBar(LocalOnFinishKt.getFinishHost(this.$this_Komponent$inlined), SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(WindowInsetsPadding_androidKt.statusBarsPadding(Modifier.Companion), 0.0f, 1, (Object) null), Dp.constructor-impl(44)), $composer, 0, 0);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), $composer, 6);
                ComposerKt.sourceInformationMarkerStart($composer, -965769930, "CC(remember):SmeltingTutorialEntrance.kt#9igjgp");
                Object it$iv = $composer.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = SnapshotIntStateKt.mutableIntStateOf(0);
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                final MutableIntState curIndex$delegate = (MutableIntState) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer);
                smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8$0$0$1 = SmeltingTutorialEntranceKt.smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8$0$0$1(curIndex$delegate);
                if (smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8$0$0$1 < this.$tutorialInfoList$inlined.size() - 1) {
                    smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8$0$0$13 = SmeltingTutorialEntranceKt.smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8$0$0$1(curIndex$delegate);
                    str = "继续查看（" + (smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8$0$0$13 + 1) + "/" + this.$tutorialInfoList$inlined.size() + ")";
                } else {
                    str = "我知道了";
                }
                androidx.compose.runtime.State buttonText$delegate = SnapshotStateKt.rememberUpdatedState(str, $composer, 0);
                Unit unit = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer, -965753583, "CC(remember):SmeltingTutorialEntrance.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance(this.$reportMap$inlined);
                Object it$iv2 = $composer.rememberedValue();
                if (invalid$iv) {
                }
                final Map map = this.$reportMap$inlined;
                Object value$iv2 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: kntr.app.digital.preview.smelting.SmeltingTutorialEntranceKt$smeltingTutorialEntrance$1$createSuccessKomponent$1$1$1$1$1
                    public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
                        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
                        final Map<String, String> map2 = map;
                        final MutableIntState mutableIntState = curIndex$delegate;
                        return new DisposableEffectResult() { // from class: kntr.app.digital.preview.smelting.SmeltingTutorialEntranceKt$smeltingTutorialEntrance$1$createSuccessKomponent$1$1$1$1$1$invoke$$inlined$onDispose$1
                            public void dispose() {
                                int smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8$0$0$14;
                                Map $this$invoke_u24lambda_u240_u240 = MapsKt.createMapBuilder();
                                $this$invoke_u24lambda_u240_u240.putAll(map2);
                                smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8$0$0$14 = SmeltingTutorialEntranceKt.smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8$0$0$1(mutableIntState);
                                $this$invoke_u24lambda_u240_u240.put("endpage", String.valueOf(smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8$0$0$14));
                                Map map3 = MapsKt.build($this$invoke_u24lambda_u240_u240);
                                NeuronReportKt.getNeuronReport().invoke("sqzz.dressing.rebuild.guide.show", map3);
                            }
                        };
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer);
                EffectsKt.DisposableEffect(unit, (Function1) it$iv2, $composer, 6);
                List list = this.$tutorialInfoList$inlined;
                smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8$0$0$12 = SmeltingTutorialEntranceKt.smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8$0$0$1(curIndex$delegate);
                SmeltingTutorialItemInfo curTutorialInfo = (SmeltingTutorialItemInfo) list.get(smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8$0$0$12);
                SmeltingTutorialEntranceKt$smeltingTutorialEntrance$1$player$1 smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$player$1 = this.$player$inlined;
                smeltingTutorialEntrance$lambda$0$4 = SmeltingTutorialEntranceKt.smeltingTutorialEntrance$lambda$0$4(this.$playerVisible$delegate$inlined);
                smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8$0$0$3 = SmeltingTutorialEntranceKt.smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8$0$0$3(buttonText$delegate);
                ComposerKt.sourceInformationMarkerStart($composer, -965726533, "CC(remember):SmeltingTutorialEntrance.kt#9igjgp");
                boolean invalid$iv2 = $composer.changedInstance(this.$tutorialInfoList$inlined) | $composer.changedInstance(this.$this_Komponent$inlined) | $composer.changed(this.$playerVisible$delegate$inlined) | $composer.changed(this.$url$delegate$inlined);
                Object it$iv3 = $composer.rememberedValue();
                if (!invalid$iv2 && it$iv3 != Composer.Companion.getEmpty()) {
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    SmeltingTutorialUIKt.SmeltingTutorialItemUI(curTutorialInfo, smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$player$1, smeltingTutorialEntrance$lambda$0$4, smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8$0$0$3, (Function0) it$iv3, LocalOnFinishKt.getFinishHost(this.$this_Komponent$inlined), SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer, 1572864, 0);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer.endReplaceGroup();
                }
                final List list2 = this.$tutorialInfoList$inlined;
                final KomponentScope komponentScope = this.$this_Komponent$inlined;
                final MutableState mutableState = this.$playerVisible$delegate$inlined;
                final MutableState mutableState2 = this.$url$delegate$inlined;
                Object value$iv3 = (Function0) new Function0<Unit>() { // from class: kntr.app.digital.preview.smelting.SmeltingTutorialEntranceKt$smeltingTutorialEntrance$1$createSuccessKomponent$1$1$1$2$1
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1007invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: collision with other method in class */
                    public final void m1007invoke() {
                        int smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8$0$0$14;
                        int smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8$0$0$15;
                        smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8$0$0$14 = SmeltingTutorialEntranceKt.smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8$0$0$1(curIndex$delegate);
                        if (smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8$0$0$14 < list2.size() - 1) {
                            smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8$0$0$15 = SmeltingTutorialEntranceKt.smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8$0$0$1(curIndex$delegate);
                            curIndex$delegate.setIntValue(smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8$0$0$15 + 1);
                            BuildersKt.launch$default(komponentScope.getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(list2, mutableState, mutableState2, curIndex$delegate, null), 3, (Object) null);
                            return;
                        }
                        LocalOnFinishKt.getFinishHost(komponentScope).invoke();
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* compiled from: SmeltingTutorialEntrance.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "kntr.app.digital.preview.smelting.SmeltingTutorialEntranceKt$smeltingTutorialEntrance$1$createSuccessKomponent$1$1$1$2$1$1", f = "SmeltingTutorialEntrance.kt", i = {}, l = {142}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                    /* renamed from: kntr.app.digital.preview.smelting.SmeltingTutorialEntranceKt$smeltingTutorialEntrance$1$createSuccessKomponent$1$1$1$2$1$1  reason: invalid class name */
                    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ MutableIntState $curIndex$delegate;
                        final /* synthetic */ MutableState<Boolean> $playerVisible$delegate;
                        final /* synthetic */ List<SmeltingTutorialItemInfo> $tutorialInfoList;
                        final /* synthetic */ MutableState<String> $url$delegate;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(List<SmeltingTutorialItemInfo> list, MutableState<Boolean> mutableState, MutableState<String> mutableState2, MutableIntState mutableIntState, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$tutorialInfoList = list;
                            this.$playerVisible$delegate = mutableState;
                            this.$url$delegate = mutableState2;
                            this.$curIndex$delegate = mutableIntState;
                        }

                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$tutorialInfoList, this.$playerVisible$delegate, this.$url$delegate, this.$curIndex$delegate, continuation);
                        }

                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                        }

                        public final Object invokeSuspend(Object $result) {
                            int smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8$0$0$1;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    SmeltingTutorialEntranceKt.smeltingTutorialEntrance$lambda$0$5(this.$playerVisible$delegate, false);
                                    this.$url$delegate.setValue(RoomRecommendViewModel.EMPTY_CURSOR);
                                    this.label = 1;
                                    if (YieldKt.yield((Continuation) this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    break;
                                case 1:
                                    ResultKt.throwOnFailure($result);
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            MutableState<String> mutableState = this.$url$delegate;
                            List<SmeltingTutorialItemInfo> list = this.$tutorialInfoList;
                            smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8$0$0$1 = SmeltingTutorialEntranceKt.smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8$0$0$1(this.$curIndex$delegate);
                            mutableState.setValue(list.get(smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8$0$0$1).getImage());
                            return Unit.INSTANCE;
                        }
                    }
                };
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer);
                SmeltingTutorialUIKt.SmeltingTutorialItemUI(curTutorialInfo, smeltingTutorialEntranceKt$smeltingTutorialEntrance$1$player$1, smeltingTutorialEntrance$lambda$0$4, smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8$0$0$3, (Function0) it$iv3, LocalOnFinishKt.getFinishHost(this.$this_Komponent$inlined), SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer, 1572864, 0);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                }
                $composer.endReplaceGroup();
            }

            public Object getContentType() {
                return Reflection.getOrCreateKotlinClass(getClass());
            }

            public Object getKey() {
                return this.$this_setContent.getKey();
            }

            public S getState() {
                return this.state;
            }

            public HostConfiguration getPreferredHostConfiguration() {
                return this.$this_setContent.getPreferredHostConfiguration();
            }
        };
        return $this$Komponent.__setContent(content$iv$iv$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8$0$0$1(MutableIntState $curIndex$delegate) {
        IntState $this$getValue$iv = (IntState) $curIndex$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String smeltingTutorialEntrance$lambda$0$createSuccessKomponent$8$0$0$3(androidx.compose.runtime.State<String> state) {
        Object thisObj$iv = state.getValue();
        return (String) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UiComposableLike<Unit> smeltingTutorialEntrance$lambda$0$12(androidx.compose.runtime.State<? extends UiComposableLike<Unit>> state) {
        Object thisObj$iv = state.getValue();
        return (UiComposableLike) thisObj$iv;
    }
}